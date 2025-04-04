package in.basha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.basha.dto.DepartmentsDTO;
import in.basha.entity.Departments;
import in.basha.repo.DepartmentRepository;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    
    

    public List<Departments> getAllDepartments() {
        return departmentRepository.findAll();
    }

    


    public Departments saveDepartment(Departments department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    public DepartmentsDTO getDepartmentById(Long id) {
        Optional<Departments> byId = departmentRepository.findById(id);
        if (byId.isPresent()) {
            Departments department = byId.get();
            return new DepartmentsDTO(department.getId(), department.getName());
        }
        return null;
    }




	public DepartmentsDTO getDepartmentByEmployeeId(Long id) {
		Optional<Departments> byId = departmentRepository.findById(id);
        if (byId.isPresent()) {
            Departments department = byId.get();
            return new DepartmentsDTO(department.getId(), department.getName());
        }
     
		return null;
	}

	

}
