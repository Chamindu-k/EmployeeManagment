package com.chamindu.demo.repository;

import com.chamindu.demo.model.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Author by chamindu_kaushalya
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
}

