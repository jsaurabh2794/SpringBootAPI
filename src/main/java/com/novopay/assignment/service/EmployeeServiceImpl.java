package com.novopay.assignment.service;

import com.novopay.assignment.entity.Direction;
import com.novopay.assignment.entity.Employee;
import com.novopay.assignment.repository.EmployeeRepo;
import com.novopay.assignment.util.ProjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final int DEFAULT_PAGE_NO = 0;
    private static final int DEFAULT_PAGE_SIZE = 25;

    @Autowired
    @Qualifier("employeeRepo")
    private EmployeeRepo employeeRepo;

    @Override
    @Cacheable(value = "getEmployees")
    public Page<Employee> getEmployees(int pageNo, int pageSize, Direction direction) {
        Sort.Direction dir = ProjectUtil.getDirection(direction);
        Sort sort = Sort.by(dir, "Id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> list = employeeRepo.findAll(pageable);
        return list;
    }

    @Override
    @Cacheable(value = "getEmployeeInRangeBetween")
    public Page<Employee> getEmployeeInRangeBetween(Integer start, Integer end, Integer pageNo, Integer pageSize, Direction direction) {
        pageNo = pageNo == null ? DEFAULT_PAGE_NO : pageNo;
        pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
        Sort.Direction dir = ProjectUtil.getDirection(direction);
        Sort sort = Sort.by(dir, "Id");
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Employee> list = employeeRepo.findByIdBetween(start, end, pageable);
        return list;
    }
}
