package com.rest.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by Sindhu on 8/13/15.
 */

@Controller
public class EmployeeController {


    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public @ResponseBody Employee getEmployee(@RequestParam(value = "id") int id){
        Employee e = null;
        e = service.get(id);
        return e;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public @ResponseBody Employee createEmployee(@RequestBody @Valid Employee employee){
        Employee e = null;
        e = service.save(employee);
        return e;
    }

}
