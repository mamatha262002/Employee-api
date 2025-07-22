package org.example.employee_api.Repository;


import org.example.employee_api.model.employee1;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<employee1, Long>
{

}
