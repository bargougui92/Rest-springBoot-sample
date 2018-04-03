package com.Restful.webservices.example01.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

    //we want to do dynamic filtering which means hiding some fields dynamically
	@GetMapping("/filtering")
    public MappingJacksonValue retreiveBean(){
	   SomeBean someBean = new SomeBean("value1", "value2", "value3");
	   //it will show only properties f1 and f3
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("f1", "f3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }
}
