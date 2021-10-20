package io.github.yellldo.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName : ViewController<br>
 * Description : ViewController<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
@Controller
public class ViewController {


    @GetMapping("/index")
    public String index(){
        return "/index";
    }

    @GetMapping("/generator")
    public String generator(){
        return "generator";
    }

}
