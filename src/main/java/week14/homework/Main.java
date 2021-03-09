package week14.homework;

import java.sql.Date;

public class Main {

    public static void main(String[] args) {

        Department department = Department.builder()
                .id(50)
                .name("IT")
                .city("LOS ANGELES")
                .build();

        Employee employee = Employee.builder()
                .employeeNo(8001)
                .name("Marcel")
                .job("Clerk")
                .employeeManager(7698)
                .hireDate(Date.valueOf("2010-02-12"))
                .employeeSalary(2500)
                .employeeComm(0)
                .employeeDepartmentNo(20)
                .build();


        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        DepartmentDAO departmentDAO = new DepartmentDAOImpl();

        // employeeDAO.findAll().forEach(System.out::println);  // listeata toti angajatii
        // employeeDAO.insertNewEmployee(employee);             // adauga un angajat nou (creat in builderul de mai sus)
        // employeeDAO.delete(8001);                            // sterge un angajat specificat (by id)
        // employeeDAO.updateSalary(8001, 3700);                // schimba salariul unui angajat specificat (by id)
        // employeeDAO.findEmployeeByName("Marcel");            // listeaza toti angajatii care contin secventa string specificata

        departmentDAO.findAll().forEach(System.out::println); //listeaza toate departamentele
        //departmentDAO.insertNewDepartment(department);      // creaza un departament nou
        //departmentDAO.delete(50);                           // sterge un departement specificat (by id)
        //departmentDAO.updateCity(50, "HOUSTON");            // schimba orasul unui departament specificat (by id)




    }
}
