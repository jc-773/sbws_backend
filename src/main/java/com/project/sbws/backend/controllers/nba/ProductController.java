package com.project.sbws.backend.controllers.nba;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
    @RequestMapping(value = "/product", method=RequestMethod.GET)
     public String getPlayerStatsBySeason(@RequestParam int id) {
        List<String> productList = new ArrayList<>();
        productList.add("Borrowed Time");
        productList.add("Startup Nation");
        productList.add("The 1619 Project");
        productList.add("Juiced");
        productList.add("Leaders Eat Last");
        productList.add("Hide");
        productList.add("Burn");
        productList.add("Blood Brother");
        productList.add("The Pact");
        productList.add("Broken Places");
        productList.add("Borrowed Time");
        productList.add("Startup Nation");
        productList.add("The 1619 Project");
        productList.add("Juiced");
        productList.add("Leaders Eat Last");
        productList.add("Hide");
        productList.add("Burn");
        productList.add("Blood Brother");
        productList.add("The Pact");
        productList.add("Broken Places");
        productList.add("Borrowed Time");
        productList.add("Startup Nation");
        productList.add("The 1619 Project");
        productList.add("Juiced");
        productList.add("Leaders Eat Last");
        productList.add("Hide");
        productList.add("Burn");
        productList.add("Blood Brother");
        productList.add("The Pact");
        productList.add("Broken Places");
        productList.add("Borrowed Time");
        productList.add("Startup Nation");
        productList.add("The 1619 Project");
        productList.add("Juiced");
        productList.add("Leaders Eat Last");
        productList.add("Hide");
        productList.add("Burn");
        productList.add("Blood Brother");
        productList.add("The Pact");
        productList.add("Broken Places");
        productList.add("Borrowed Time");
        productList.add("Startup Nation");
        productList.add("The 1619 Project");
        productList.add("Juiced");
        productList.add("Leaders Eat Last");
        productList.add("Hide");
        productList.add("Burn");
        productList.add("Blood Brother");
        productList.add("The Pact");
        productList.add("Broken Places");
        
        return productList.get(id);
     }
}
