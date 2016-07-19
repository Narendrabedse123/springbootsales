package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@SpringBootApplication
public class SpringBootBarsApplication {

    @Autowired
    private BarDao barDao;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.initDirectFieldAccess();
    }

    @RequestMapping(path = "/bars", method = RequestMethod.GET)
    @ResponseBody
    Iterable<Bar> listBars() {
        return barDao.findAll();
    }

    @RequestMapping(path = "/bars", method = RequestMethod.POST)
    String addBar(@ModelAttribute Bar bar) {
        barDao.save(bar);
        return "redirect:/";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBarsApplication.class, args);
    }

}
