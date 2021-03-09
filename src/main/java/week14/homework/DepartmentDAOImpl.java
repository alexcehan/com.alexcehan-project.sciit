package week14.homework;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public List<Department> findAll() {
        List<Department> departments = new LinkedList<>();
        String sqlQuery = ("SELECT * FROM department");

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            connection.setAutoCommit(false);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                departments.add(Department.builder()
                                            .id(resultSet.getInt("id"))
                                            .name(resultSet.getString("name"))
                                            .city(resultSet.getString("city"))
                                            .build());
            }

            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return departments;
    }

    @Override
    public void insertNewDepartment(Department department) {
        try (Connection connection = getConnection()) {
            String sqlInsert = "INSERT INTO department (id, name, city) VALUES" +
            "(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setInt(1, department.getId());
            preparedStatement.setString(2, department.getName());
            preparedStatement.setString(3, department.getCity());

            System.out.println(preparedStatement.executeUpdate() + " rows affected!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int index) {
        try (Connection connection = getConnection()) {
            String sqlDelete = ("DELETE FROM department WHERE id = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setInt(1, index);

            System.out.println(preparedStatement.executeUpdate() + " rows affected!");

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateCity(int index, String newCity) {
        try (Connection connection = getConnection()) {
            String sqlUpdate = ("UPDATE department SET city = ? WHERE ID = ?");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, newCity);
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
