package com.novopay.assignment.service;

import com.novopay.assignment.entity.Direction;
import com.novopay.assignment.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {
    Page<Employee> getEmployees(int pageNo, int pageSize, Direction direction);

    Page<Employee> getEmployeeInRangeBetween(Integer start, Integer end, Integer pageNo, Integer pageSize, Direction direction);
}
