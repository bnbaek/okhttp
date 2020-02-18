package net.open.httpclient;

import java.io.IOException;
import java.time.Duration;
import net.jodah.failsafe.RetryPolicy;
import org.springframework.stereotype.Component;

/**
 * Created by BNBAEK
 * Package : net.open.httpclient
 * User: dean
 * Date: 2020/02/18
 * Time: 11:18 오전
 */
@Component
public class BarogoRetryPolicy {
  public static RetryPolicy<Object> standardPolicy(){
    return new RetryPolicy<>()
        .handle(IOException.class)
        .withDelay(Duration.ofSeconds(1))
        .withMaxRetries(2);
  }

}
