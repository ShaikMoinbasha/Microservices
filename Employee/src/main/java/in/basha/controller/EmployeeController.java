package in.basha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.basha.dto.DepartmentsDTO;
import in.basha.entity.Employee;
import in.basha.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/postEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("getEmployee/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/getMsgs")
    public String getName() {
    	return employeeService.getHelloMsg();
    }
    
    @GetMapping("/getDepartment/{id}")
    public DepartmentsDTO getDeptIdByEmpId(@PathVariable Long id) {
    	return employeeService.getDepartmentIdByEmpId(id);
    }
    
    @GetMapping("/getAllEmployees")
    public List<Employee> getAllDepartments() {
        return employeeService.getAllEmployees();
    }
    
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    	employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
