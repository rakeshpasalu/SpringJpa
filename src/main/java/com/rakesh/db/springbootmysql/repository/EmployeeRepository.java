package com.rakesh.db.springbootmysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rakesh.db.springbootmysql.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
