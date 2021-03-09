package week14.homework;

import java.util.List;

public interface DepartmentDAO {

    List<Department> findAll();
    void insertNewDepartment(Department department);
    void delete(int index);
    void updateCity(int index, String newCity);

}
