package net.openu.httpserver;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by iopenu@gmail.com on 2020/02/17
 * Github : https://github.com/bnbaek
 */
@RestController
@RequestMapping("/api/hellos")
public class HelloContorller {

  @GetMapping
  public List<Hello> hellos() {
    return Arrays.asList(new Hello("h1")
        , new Hello("h2")
        , new Hello("h3")
        , new Hello("h4")
        , new Hello("h5")
    );
  }


}
