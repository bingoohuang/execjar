package com.example.caching;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BookRepo {
  @Cacheable("books")
  public Book getByIsbn(String isbn) {
    simulateSlowService(isbn);
    return new Book(isbn, "Some book");
  }

  @SneakyThrows
  private void simulateSlowService(String isbn) {
    log.info("simulateSlowService:{}", isbn);
    Thread.sleep(3000L);
  }
}
