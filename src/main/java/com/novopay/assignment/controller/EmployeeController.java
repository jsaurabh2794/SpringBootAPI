package com.novopay.assignment.controller;

import com.novopay.assignment.entity.Direction;
import com.novopay.assignment.entity.Employee;
import com.novopay.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class EmployeeController {


    @Autowired
    @Qualifier("employeeService")
    private EmployeeService employeeService;

    @CrossOrigin
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public Page<Employee> getEmployees(@RequestParam(value = "pageNo") Integer pageNo,
                                       @RequestParam(value = "PageSize") Integer pageSize,
                                       @RequestParam(value = "direction") Direction direction) {
        Page<Employee> employees = null;
        try {
            employees = employeeService.getEmployees(pageNo, pageSize, direction);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    @CrossOrigin
    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public Page<Employee> getEmployeesByIdInRangeange(@RequestParam(value = "pageNo",required = false) Integer pageNo,
                                       @RequestParam(value = "PageSize") Integer pageSize,
                                       @RequestParam(value = "start") Integer start,
                                       @RequestParam(value = "end") Integer end,
                                       @RequestParam(value = "direction") Direction direction) {
        Page<Employee> employees = null;
        try {
            employees = employeeService.getEmployeeInRangeBetween(start,end,pageNo,pageSize,direction);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }

}
