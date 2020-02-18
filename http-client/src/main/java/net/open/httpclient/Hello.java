package net.open.httpclient;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.Data;
import lombok.Getter;

/**
 * Created by iopenu@gmail.com on 2020/02/17
 * Github : https://github.com/bnbaek
 */
@Data
public class Hello {

  private String name;
  private Long instant;
  private LocalDateTime localDateTime;
  private ZonedDateTime zonedDateTime;


}
