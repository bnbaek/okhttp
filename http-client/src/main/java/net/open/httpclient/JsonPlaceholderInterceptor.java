package net.open.httpclient;

import java.io.IOException;
import java.net.SocketTimeoutException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

/**
 * Created by BNBAEK
 * Package : net.open.httpclient
 * User: dean
 * Date: 2020/02/18
 * Time: 9:23 오전
 */
@Component
@Slf4j
public class JsonPlaceholderInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = null;

    try{
      response = chain.proceed(

          chain.request().newBuilder()
              .addHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
              .addHeader("Cache-Control", "no-cache")
              .addHeader("Cache-Control", "no-store")
              .build()
      );
    }catch (SocketTimeoutException e){
      log.error("TIMEOUT");
      throw new IOException();
    }

    String url = request.url().url().toString();
    log.info("URL > {}",url);

    return response;
  }
}