package com.ben.pofs.pofs.test;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
@Data
public class test {

    int a =1;
    String b = "ahahhh";
   @GetMapping("/test0")
    public String testM(){

        return "yees";
    }

    @GetMapping("/test")
    public String testMethod(@RequestParam String name,
                             @RequestParam String type,
                             @RequestParam String color) {
        return "Search for :  " + name + " and Type : " + type + " Color : " + color;
    }
//http://localhost:8080/test?name=pc&type=hp&color=red

    @GetMapping("/test-path/{name}/{type}/{color}/{id}")
    public String testPath(@PathVariable("name") String name,
                           @PathVariable("type") String type,
                           @PathVariable("color") String color,
                           @PathVariable("id") Integer id) {
        return "Name : " + name + " Type : " + type + " Color : " + color + " Id : " + id;
    }
//http://localhost:8080/test-path/pc/hp/red/2
}
// see cours 20 21 29
// https://www.youtube.com/watch?v=9SGDpanrcGg&list=PLZlA0Gpn_vH_QhGJh6bk35T6lB_e_q38m&index=10
