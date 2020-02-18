package net.open.httpclient;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.Callable;
import lombok.RequiredArgsConstructor;
import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by BNBAEK
 * Package : net.open.httpclient
 * User: dean
 * Date: 2020/02/18
 * Time: 9:26 오전
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hellos")
public class HelloController {

  private final HelloService helloService;

  @GetMapping
  public List<Hello> getHellos() throws IOException {
    return Failsafe.with(BarogoRetryPolicy.standardPolicy()).get(() -> helloService.getHello());

  }

}
