package week14.homework;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void insertNewEmployee(Employee employee);
    Employee findEmployeeByName(String name);
    void delete (int index);
    void updateSalary(int index, int newSalary);

}
