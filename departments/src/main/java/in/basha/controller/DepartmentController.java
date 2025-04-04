package in.basha.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import in.basha.dto.DepartmentsDTO;
import in.basha.entity.Departments;
import in.basha.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private Environment environment;
	
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/getDepartmentById/{id}")
    public DepartmentsDTO getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }
    @GetMapping("/getMsg")
    public String getName() {
    	String port = environment.getProperty("server.port");
    	return "Hello getting name Department"+" "+port;
    }
    
    @GetMapping("/getDepartmentByEmployeeId/{id}")
    public DepartmentsDTO getDepartmentByEmployeeId(@PathVariable Long id) {
        return departmentService.getDepartmentByEmployeeId(id);
    }
    
    
    

    @GetMapping("/getAllDepartments")
    public List<Departments> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping("/postDepartment")
    public ResponseEntity<Departments> saveDepartment(@RequestBody Departments department) {
        return ResponseEntity.ok(departmentService.saveDepartment(department));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
