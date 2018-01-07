package br.com.ime.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rabriol on 2/27/17.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String homepage() {
        return "index.html";
    }
}
