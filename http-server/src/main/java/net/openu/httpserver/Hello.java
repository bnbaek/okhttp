package net.openu.httpserver;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.Getter;

/**
 * Created by iopenu@gmail.com on 2020/02/17
 * Github : https://github.com/bnbaek
 */
@Getter
public class Hello {

  private String name;
  private Long instant;
  private LocalDateTime localDateTime;
  private ZonedDateTime zonedDateTime;

  public Hello(String name) {
    this.instant = Instant.now().toEpochMilli();
    this.localDateTime = LocalDateTime.now();
    this.zonedDateTime = ZonedDateTime.of(this.localDateTime, ZoneId.of("Asia/Seoul"));
    this.name = name;
  }
}
