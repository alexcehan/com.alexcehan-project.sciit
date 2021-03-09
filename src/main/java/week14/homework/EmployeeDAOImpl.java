package week14.homework;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public static void main(String[] args) {

    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new LinkedList<>();
        String sqlQuery = ("SELECT * FROM employee");
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
            connection.setAutoCommit(false);

            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                Employee employee = Employee.builder()
                                        .employeeNo(resultSet.getInt("id"))
                                        .name(resultSet.getString("name"))
                                        .job(resultSet.getString("job"))
                                        .employeeManager(resultSet.getInt("mgr"))
                                        .hireDate(resultSet.getDate("hiredate"))
                                        .employeeSalary(resultSet.getInt("salary"))
                                        .employeeComm(resultSet.getInt("comm"))
                                        .employeeDepartmentNo(resultSet.getInt("department_id"))
                                        .build();
                employeeList.add(employee);
            }

            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void insertNewEmployee(Employee employee) {
        try (Connection connection = getConnection()) {
            String sqlInsert = "INSERT INTO employee (ID, NAME, JOB, MGR, HIREDATE, SALARY, COMM, DEPARTMENT_ID) VALUES" +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, employee.getEmployeeNo());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setInt(4, employee.getEmployeeManager());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setInt(6, employee.getEmployeeSalary());
            preparedStatement.setInt(7, employee.getEmployeeComm());
            preparedStatement.setInt(8, employee.getEmployeeDepartmentNo());

            System.out.println(preparedStatement.executeUpdate() + " rows affected!");

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public Employee findEmployeeByName(String name) {

        try (Connection connection = getConnection()) {
            String sqlQuery = "SELECT ID, NAME, JOB,SALARY, DEPARTMENT_ID FROM employee WHERE NAME LIKE ?";
            name = ("%" + name + "%");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Employee.builder()
                                            .employeeNo(resultSet.getInt("id"))
                                            .name(resultSet.getString("name"))
                                            .job(resultSet.getString("job"))
                                            .employeeSalary(resultSet.getInt("salary"))
                                            .employeeDepartmentNo(resultSet.getInt("department_id"))
                                            .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int index) {
        try (Connection connection = getConnection()) {
            String sqlDelete = ("DELETE FROM employee WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, index);

            System.out.println(preparedStatement.executeUpdate() + " rows affected!");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateSalary(int index, int newSalary) {
        try (Connection connection = getConnection()) {
            String sqlUpdate = ("UPDATE employee SET salary = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setInt(1, newSalary);
            preparedStatement.setInt(2, index);

            System.out.println(preparedStatement.executeUpdate() + " rows affected!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private Connection getConnection() {
        try {
            return (DriverManager.getConnection("jdbc:mysql://localhost:3306/hr",
                    "root",
                    "root"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
