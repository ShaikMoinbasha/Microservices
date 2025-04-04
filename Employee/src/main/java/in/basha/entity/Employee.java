package in.basha.entity;



import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  

    private String name;
    private String email;
    private Integer age;
    private String empPosition;
    private Long deptId; 

    

    public Employee() {
		
	}


	public Employee(Long id, String name, String email, Integer age, String empPosition, Long deptId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.empPosition = empPosition;
        this.deptId = deptId;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getEmpPosition() { return empPosition; }
    public void setEmpPosition(String empPosition) { this.empPosition = empPosition; }

    public Long getDeptId() { return deptId; }
    public void setDeptId(Long deptId) { this.deptId = deptId; }
}
