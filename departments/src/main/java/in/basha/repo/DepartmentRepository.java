package in.basha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import in.basha.entity.Departments;

@Repository
public interface DepartmentRepository extends JpaRepository<Departments, Long> {
    
    @Query(value = "SELECT d.id, d.name " +
                   "FROM departments d " +
                   "JOIN employee e ON d.id = e.dept_id " +
                   "WHERE e.id = :id", nativeQuery = true)
    Object[] getDepartmentByEmployeeId(@Param("id") Long id);
}
