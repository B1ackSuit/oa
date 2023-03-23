package cn.ean.oaemp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @FileName Swagger2TestController
 * @Author ean
 * @Date 2023/3/14 15:37
 **/
@RestController
public class Swagger2TestController {

    @GetMapping("/swagger2Test")
    public String swagger2Test() {
        return "Success!";
    }

}
