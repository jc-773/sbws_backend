package com.project.sbws.backend.controllers.nba;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class RatingController {
    

    @RequestMapping(value = "/rating", method=RequestMethod.GET)
    public Integer requestMethodName() {
       return (int)(Math.random() * 10);
    }
    
}
