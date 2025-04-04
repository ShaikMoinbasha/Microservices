package in.basha.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import in.basha.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
}

