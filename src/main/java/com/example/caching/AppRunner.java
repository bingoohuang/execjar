package com.example.caching;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class AppRunner implements CommandLineRunner {
  private final BookRepo repo;

  @Override
  public void run(String... args) {
    log.info(".... Fetching books");
    log.info("isbn-1234 -->" + repo.getByIsbn("isbn-1234"));
    log.info("isbn-4567 -->" + repo.getByIsbn("isbn-4567"));
    log.info("isbn-1234 -->" + repo.getByIsbn("isbn-1234"));
    log.info("isbn-4567 -->" + repo.getByIsbn("isbn-4567"));
    log.info("isbn-1234 -->" + repo.getByIsbn("isbn-1234"));
    log.info("isbn-1234 -->" + repo.getByIsbn("isbn-1234"));
  }
}
