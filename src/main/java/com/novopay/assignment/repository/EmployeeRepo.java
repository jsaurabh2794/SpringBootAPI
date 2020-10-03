package com.novopay.assignment.repository;

import com.novopay.assignment.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository("employeeRepo")
public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {

    Page<Employee> findByIdBetween(int start, int end, Pageable pageable);

}
