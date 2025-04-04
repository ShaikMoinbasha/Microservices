package in.basha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.basha.client.DepartmentClient;
import in.basha.dto.DepartmentsDTO;
import in.basha.entity.Employee;
import in.basha.repo.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private DepartmentClient client;

    

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    
    public DepartmentsDTO getDepartment(Long id) {
    	return client.getDepartmentByEmployeeId(id);
    }

    
    

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		
	}

	public String getHelloMsg() {
	
		return client.getName();
	}

	public DepartmentsDTO getDepartmentIdByEmpId(Long id) {
		Optional<Employee> byId = employeeRepository.findById(id);
		if(byId.isPresent()) {
			Long deptId = byId.get().getDeptId();
			return client.getDepartmentByEmployeeId(deptId);
		}
		return null;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> all = employeeRepository.findAll();
		return all;
	}
}
