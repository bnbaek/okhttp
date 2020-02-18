package net.open.httpclient;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by BNBAEK
 * Package : net.open.httpclient
 * User: dean
 * Date: 2020/02/18
 * Time: 9:24 오전
 */
public interface JsonPlaceholderService {
  //@GET("/posts/{postId}")
  //  Call<Hello> getHellos(@Path("postId") long postId);
  @GET("/api/hellos")
  Call<List<Hello>> getHellos();

}
