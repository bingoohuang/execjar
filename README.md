# executable-jar-with-maven-example

[![Build Status](https://travis-ci.org/bingoohuang/execjar.svg?branch=develop)](https://travis-ci.org/bingoohuang/execjar)

Generates executable jar files with dependencies.

## Just build it

```bash
➜  execjar git:(master) ✗ mvn clean package

```

## And see what you got

```bash
➜  execjar git:(master) ✗ ls -lh target
total 5864
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 classes
-rw-r--r--  1 bingoobjca  staff   2.9M  7 29 19:53 execjar-0.0.1-exec.jar
-rw-r--r--  1 bingoobjca  staff   3.0K  7 29 19:53 execjar-0.0.1.jar
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 generated-sources
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 maven-archiver
drwxr-xr-x  3 bingoobjca  staff    96B  7 29 19:53 maven-status
```

## And run it

```bash
➜  execjar git:(master) ✗ java -jar target/execjar-0.0.1-exec.jar
class com.google.common.io.BaseEncoding
➜  execjar git:(master) ✗
```

## Thanks

1. [Generates executable jar files with dependencies](https://github.com/jinahya/executable-jar-with-maven-example)
1. [How to Create an Executable JAR with Maven](https://www.baeldung.com/executable-jar-with-maven)

## OpenJDK https


```bash
[root@host-192-168-111-4 jdk]# tar zxf openjdk-8u41-b04-linux-x64-14_jan_2020.tar.gz
[root@host-192-168-111-4 jdk]# export JAVA_HOME=/root/bingoohuang/jdk/java-se-8u41-ri/
[root@host-192-168-111-4 jdk]# export PATH=$JAVA_HOME/bin:$PATH
[root@host-192-168-111-4 jdk]# java -version
openjdk version "1.8.0_41"
OpenJDK Runtime Environment (build 1.8.0_41-b04)
OpenJDK 64-Bit Server VM (build 25.40-b25, mixed mode)
[root@host-192-168-111-4 jdk]# which java
/root/bingoohuang/jdk/java-se-8u41-ri/bin/java
[root@host-192-168-111-4 bingoohuang]# java -jar execjar-0.0.1-exec.jar
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Exception in thread "main" javax.net.ssl.SSLException: java.lang.RuntimeException: Unexpected error: java.security.InvalidAlgorithmParameterException: the trustAnchors parameter must be non-empty
	at sun.security.ssl.Alerts.getSSLException(Alerts.java:214)
	at sun.security.ssl.SSLSocketImpl.fatal(SSLSocketImpl.java:1958)
	at sun.security.ssl.SSLSocketImpl.fatal(SSLSocketImpl.java:1915)
	at sun.security.ssl.SSLSocketImpl.handleException(SSLSocketImpl.java:1898)
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1419)
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1396)
	at okhttp3.internal.connection.RealConnection.connectTls(RealConnection.java:336)
	at okhttp3.internal.connection.RealConnection.establishProtocol(RealConnection.java:300)
	at okhttp3.internal.connection.RealConnection.connect(RealConnection.java:185)
	at okhttp3.internal.connection.ExchangeFinder.findConnection(ExchangeFinder.java:224)
	at okhttp3.internal.connection.ExchangeFinder.findHealthyConnection(ExchangeFinder.java:108)
	at okhttp3.internal.connection.ExchangeFinder.find(ExchangeFinder.java:88)
	at okhttp3.internal.connection.Transmitter.newExchange(Transmitter.java:169)
	at okhttp3.internal.connection.ConnectInterceptor.intercept(ConnectInterceptor.java:41)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:142)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:117)
	at okhttp3.internal.cache.CacheInterceptor.intercept(CacheInterceptor.java:94)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:142)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:117)
	at okhttp3.internal.http.BridgeInterceptor.intercept(BridgeInterceptor.java:93)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:142)
	at okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(RetryAndFollowUpInterceptor.java:88)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:142)
	at okhttp3.internal.http.RealInterceptorChain.proceed(RealInterceptorChain.java:117)
	at okhttp3.RealCall.getResponseWithInterceptorChain(RealCall.java:221)
	at okhttp3.RealCall.execute(RealCall.java:81)
	at com.github.bingoohuang.execjar.OkRest.get(OkRest.java:29)
	at com.github.bingoohuang.execjar.Main.main(Main.java:18)
Caused by: java.lang.RuntimeException: Unexpected error: java.security.InvalidAlgorithmParameterException: the trustAnchors parameter must be non-empty
	at sun.security.validator.PKIXValidator.<init>(PKIXValidator.java:90)
	at sun.security.validator.Validator.getInstance(Validator.java:179)
	at sun.security.ssl.X509TrustManagerImpl.getValidator(X509TrustManagerImpl.java:312)
	at sun.security.ssl.X509TrustManagerImpl.checkTrustedInit(X509TrustManagerImpl.java:171)
	at sun.security.ssl.X509TrustManagerImpl.checkTrusted(X509TrustManagerImpl.java:184)
	at sun.security.ssl.X509TrustManagerImpl.checkServerTrusted(X509TrustManagerImpl.java:124)
	at sun.security.ssl.ClientHandshaker.serverCertificate(ClientHandshaker.java:1508)
	at sun.security.ssl.ClientHandshaker.processMessage(ClientHandshaker.java:215)
	at sun.security.ssl.Handshaker.processLoop(Handshaker.java:1024)
	at sun.security.ssl.Handshaker.process_record(Handshaker.java:954)
	at sun.security.ssl.SSLSocketImpl.readRecord(SSLSocketImpl.java:1065)
	at sun.security.ssl.SSLSocketImpl.performInitialHandshake(SSLSocketImpl.java:1384)
	at sun.security.ssl.SSLSocketImpl.startHandshake(SSLSocketImpl.java:1412)
	... 23 more
Caused by: java.security.InvalidAlgorithmParameterException: the trustAnchors parameter must be non-empty
	at java.security.cert.PKIXParameters.setTrustAnchors(PKIXParameters.java:200)
	at java.security.cert.PKIXParameters.<init>(PKIXParameters.java:120)
	at java.security.cert.PKIXBuilderParameters.<init>(PKIXBuilderParameters.java:104)
	at sun.security.validator.PKIXValidator.<init>(PKIXValidator.java:88)
	... 35 more
```

```bash
[root@host-192-168-111-4 jdk]# tar zxf OpenJDK8U-jdk_x64_linux_hotspot_8u252b09.tar.gz
[root@host-192-168-111-4 jdk]# export JAVA_HOME=/root/bingoohuang/jdk/jdk8u252-b09
[root@host-192-168-111-4 jdk]# export PATH=$JAVA_HOME/bin:$PATH
[root@host-192-168-111-4 jdk]# java -version
openjdk version "1.8.0_252"
OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_252-b09)
OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.252-b09, mixed mode)
[root@host-192-168-111-4 jdk]# java -jar ../execjar-0.0.1-exec.jar
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
<!DOCTYPE html>
<!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');
                </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>

{"status":404, "message":"服务请求不存在", "more info":"URI没找到，请检查API设置"}
{"status":404, "message":"服务请求不存在", "more info":"URI没找到，请检查API设置"}
```

```bash
[root@host-192-168-111-4 jdk]# tar zxf amazon-corretto-8.252.09.1-linux-x64.tar.gz
[root@host-192-168-111-4 jdk]# export JAVA_HOME=/root/bingoohuang/jdk/amazon-corretto-8.252.09.1-linux-x64
[root@host-192-168-111-4 jdk]# export PATH=$JAVA_HOME/bin:$PATH
[root@host-192-168-111-4 jdk]# java -version
openjdk version "1.8.0_252"
OpenJDK Runtime Environment Corretto-8.252.09.1 (build 1.8.0_252-b09)
OpenJDK 64-Bit Server VM Corretto-8.252.09.1 (build 25.252-b09, mixed mode)
[root@host-192-168-111-4 jdk]# java -jar ../execjar-0.0.1-exec.jar
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
<!DOCTYPE html>
<!--STATUS OK--><html> <head><meta http-equiv=content-type content=text/html;charset=utf-8><meta http-equiv=X-UA-Compatible content=IE=Edge><meta content=always name=referrer><link rel=stylesheet type=text/css href=https://ss1.bdstatic.com/5eN1bjq8AAUYm2zgoY3K/r/www/cache/bdorz/baidu.min.css><title>百度一下，你就知道</title></head> <body link=#0000cc> <div id=wrapper> <div id=head> <div class=head_wrapper> <div class=s_form> <div class=s_form_wrapper> <div id=lg> <img hidefocus=true src=//www.baidu.com/img/bd_logo1.png width=270 height=129> </div> <form id=form name=f action=//www.baidu.com/s class=fm> <input type=hidden name=bdorz_come value=1> <input type=hidden name=ie value=utf-8> <input type=hidden name=f value=8> <input type=hidden name=rsv_bp value=1> <input type=hidden name=rsv_idx value=1> <input type=hidden name=tn value=baidu><span class="bg s_ipt_wr"><input id=kw name=wd class=s_ipt value maxlength=255 autocomplete=off autofocus=autofocus></span><span class="bg s_btn_wr"><input type=submit id=su value=百度一下 class="bg s_btn" autofocus></span> </form> </div> </div> <div id=u1> <a href=http://news.baidu.com name=tj_trnews class=mnav>新闻</a> <a href=https://www.hao123.com name=tj_trhao123 class=mnav>hao123</a> <a href=http://map.baidu.com name=tj_trmap class=mnav>地图</a> <a href=http://v.baidu.com name=tj_trvideo class=mnav>视频</a> <a href=http://tieba.baidu.com name=tj_trtieba class=mnav>贴吧</a> <noscript> <a href=http://www.baidu.com/bdorz/login.gif?login&amp;tpl=mn&amp;u=http%3A%2F%2Fwww.baidu.com%2f%3fbdorz_come%3d1 name=tj_login class=lb>登录</a> </noscript> <script>document.write('<a href="http://www.baidu.com/bdorz/login.gif?login&tpl=mn&u='+ encodeURIComponent(window.location.href+ (window.location.search === "" ? "?" : "&")+ "bdorz_come=1")+ '" name="tj_login" class="lb">登录</a>');
                </script> <a href=//www.baidu.com/more/ name=tj_briicon class=bri style="display: block;">更多产品</a> </div> </div> </div> <div id=ftCon> <div id=ftConw> <p id=lh> <a href=http://home.baidu.com>关于百度</a> <a href=http://ir.baidu.com>About Baidu</a> </p> <p id=cp>&copy;2017&nbsp;Baidu&nbsp;<a href=http://www.baidu.com/duty/>使用百度前必读</a>&nbsp; <a href=http://jianyi.baidu.com/ class=cp-feedback>意见反馈</a>&nbsp;京ICP证030173号&nbsp; <img src=//www.baidu.com/img/gs.gif> </p> </div> </div> </div> </body> </html>

{"status":404, "message":"服务请求不存在", "more info":"URI没找到，请检查API设置"}
{"status":404, "message":"服务请求不存在", "more info":"URI没找到，请检查API设置"}
```
