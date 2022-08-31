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

//     Handles /hello?name=LaunchCode requests
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
    @GetMapping("form2")
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

    @RequestMapping(value="form2", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }
//        return "<h2>" + greeting + " " + n + "</h2>";

        return greeting + " " + n;
    }

}
