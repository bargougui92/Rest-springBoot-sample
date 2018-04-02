package com.Restful.webservices.example01.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
    public SomeBean retreiveBean(){
        return new SomeBean("value1", "value2", "value3");
    }
}
