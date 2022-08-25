package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody //Used when we aren't using templates to provide basic text response
@RequestMapping("hello")
public class HelloController {

    // Handles requests at path /hello
//    @GetMapping("hello") //specifies this method handles GET requests
//    @ResponseBody //Used when we aren't using templates to provide basic text response
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye because of @RequestMapping at @controller level
    @GetMapping("goodbye") //specifies this method handles GET requests
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles /hello?name=LaunchCode requests
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("suckit")
    public String suckItQueryParam(@RequestParam String name) {
        return "Suck it, " + name + " ..|.,";
    }

    // handles /hello/LaunchCode requests
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) { return "Hello, " + name + "!";}

    // /hello/form because of @RequestMapping at @Controller level
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
