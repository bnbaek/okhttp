package net.open.httpclient;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
@RequiredArgsConstructor
public class JsonPlaceholderConfig {

  private final Interceptor jsonPlaceholderInterceptor;

  @Bean("jsonPlaceholderOkHttpClient")
  public OkHttpClient jsonPlaceholderOkHttpClient() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(Level.BASIC);
    return new OkHttpClient.Builder()
        .readTimeout(10, TimeUnit.SECONDS)
        .connectTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(logging)
        .addInterceptor(jsonPlaceholderInterceptor)
        .build();
  }

  @Bean("jsonPlaceholderObjectMapper")
  public ObjectMapper jsonPlaceholderObjectMapper() {

    return Jackson2ObjectMapperBuilder.json()

        .featuresToDisable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .modules(new JavaTimeModule())
        .build();
  }

  @Bean("jsonPlaceholderRetrofit")
  public Retrofit jsonPlaceholderRetrofit(

      @Qualifier("jsonPlaceholderObjectMapper") ObjectMapper jsonPlaceholderObjectMapper,
      @Qualifier("jsonPlaceholderOkHttpClient") OkHttpClient jsonPlaceholderOkHttpClient
  ) {

    return new Retrofit.Builder()

        .baseUrl("http://localhost:28080")
        .addConverterFactory(JacksonConverterFactory.create(jsonPlaceholderObjectMapper))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(jsonPlaceholderOkHttpClient)
        .build();
  }

  @Bean("jsonPlaceholderService")
  public JsonPlaceholderService jsonPlaceholderService(

      @Qualifier("jsonPlaceholderRetrofit") Retrofit jsonPlaceHolderRetrofit
  ) {
    return jsonPlaceHolderRetrofit.create(JsonPlaceholderService.class);
  }
}
