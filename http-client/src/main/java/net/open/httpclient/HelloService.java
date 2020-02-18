package net.open.httpclient;

import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by BNBAEK
 * Package : net.open.httpclient
 * User: dean
 * Date: 2020/02/18
 * Time: 11:08 오전
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HelloService {
  private final JsonPlaceholderService jsonPlaceholderService;

  public List<Hello> getHello() throws IOException {
    Call<List<Hello>> call = jsonPlaceholderService.getHellos();

    Response<List<Hello>> execute = call.execute();
    int statusCode = execute.code();
    log.info("statusCode : {}",statusCode);
    if(statusCode>=200 && statusCode<400){
      return execute.body();
    }else{
      throw new IOException();
    }


  }

}
