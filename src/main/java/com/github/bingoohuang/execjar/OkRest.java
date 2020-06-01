package com.github.bingoohuang.execjar;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import okhttp3.*;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Slf4j
public class OkRest {

  /**
   * GET请求。
   *
   * @param url 请求地址。
   * @return 响应结果。
   */
  @SneakyThrows
  public static String get(String url) {
    Request request = new Request.Builder().url(url).build();

    try (Response response = OkHttp.client.newCall(request).execute()) {
      return getSuccessBody(request, url, response);
    }
  }

  /**
   * 删除请求。
   *
   * @param url 请求地址。
   * @return 响应结果。
   */
  @SneakyThrows
  public static String delete(String url) {
    Request request = new Request.Builder().url(url).delete().build();

    try (Response response = OkHttp.client.newCall(request).execute()) {
      return getSuccessBody(request, url, response);
    }
  }

  /**
   * 下载文件请求。
   *
   * @param url 请求地址。
   * @param saver 文件存储实现。
   */
  @SneakyThrows
  public static void download(String url, InputStreamSaver saver) {
    Request request = new Request.Builder().url(url).build();

    try (Response response = OkHttp.client.newCall(request).execute()) {
      int code = response.code();
      log.info("download {} {}, code:{}", request.method(), url, code);
      if (code >= 200 && code < 300) {
        try (val bs = response.body().byteStream()) {
          saver.save(bs);
        }
        return;
      }

      String body = response.body().string();
      throw new RuntimeException(
          "download from url:" + url + "failed code:" + code + ", body:" + body);
    }
  }

  /**
   * 上传文件。
   *
   * @param url 请求地址。
   * @param fileName 上传文件名。
   * @param file 文件内容输入流。
   * @return 响应结果。
   */
  @SneakyThrows
  public static String upload(String url, String fileName, InputStream file) {
    RequestBody formBody =
        new MultipartBody.Builder()
            .setType(MultipartBody.FORM)
            .addFormDataPart(
                "file",
                fileName,
                createRequestBody(MediaType.parse("application/octet-stream"), file))
            .build();
    Request request = new Request.Builder().url(url).post(formBody).build();

    try (Response response = OkHttp.client.newCall(request).execute()) {
      return getSuccessBody(request, url, response);
    }
  }

  @SneakyThrows
  private static String getSuccessBody(Request request, String url, Response response) {
    int code = response.code();
    String body = response.body().string();
    log.info("{} {}, code:{}, body:{}", request.method(), url, code, body);
    if (code >= 200 && code < 300) {
      return body;
    }

    throw new RuntimeException("url " + url + " failed code:" + code + ", body:" + body);
  }

  /**
   * 根据输入流创建OkHttp的请求体对象。
   *
   * @param mediaType 媒体类型
   * @param inputStream 输入流
   * @return OkHttp的请求体对象
   */
  static RequestBody createRequestBody(final MediaType mediaType, final InputStream inputStream) {
    return new RequestBody() {
      @Override
      public MediaType contentType() {
        return mediaType;
      }

      @Override
      @SneakyThrows
      public long contentLength() {
        return inputStream.available();
      }

      @Override
      public void writeTo(BufferedSink sink) throws IOException {
        try (Source source = Okio.source(inputStream)) {
          sink.writeAll(source);
        }
      }
    };
  }

  /** 输入流保存接口。 */
  public interface InputStreamSaver {
    /**
     * 保存输入流。
     *
     * @param source 输入流。
     */
    void save(InputStream source);
  }

  /** 保存输入流到输出流。 */
  @AllArgsConstructor
  public static class OutputStreamSaver implements InputStreamSaver {
    private final OutputStream os;

    @Override
    @SneakyThrows
    public void save(InputStream source) {
      // https://gist.github.com/suweya/cc73abedcf8f9378f8a7179178106944
      byte[] buffer = new byte[2 * 1024];
      int len;
      while ((len = source.read(buffer)) != -1) {
        os.write(buffer, 0, len);
      }
    }
  }
}
