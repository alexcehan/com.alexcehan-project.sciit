package week14.practice;

import java.util.Date;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JDBC {

    public static void main(String[] args) throws SQLException, ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

        String url = "jdbc:mysql://localhost:3306/test_schema";

        String uname = "root";
        String password = "root";
        String dateString = "02-02-02";
        String firstname = "";
        String lastname = "";
        String srcFile = "src/main/java/week12/practice/DatabaseFile.csv";
        String line;




//        String query = "INSERT INTO users_table values (" + first_name + ", " + last_name + ", " + sqlDate +" )";

//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        try {
            Connection connection = DriverManager.getConnection(url, uname, password);
            Statement statement = connection.createStatement();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String [] split = line.split(",");
                    if (split[0].equals("FirstName")) {
                        continue;
                    }

                    firstname = split[0];
                    lastname = split[1];
                    dateString = split[2];
                    Date parsed = dateFormat.parse(dateString);
                    java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());



                    statement.executeUpdate("INSERT INTO users_table(first_name, last_name, date_birth) values('"+ firstname + "', '" + lastname + "', '" + sqlDate +"')");

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

//            statement.executeUpdate("INSERT INTO users_table(first_name, last_name, date_birth) values('Irina', 'Cehan', '1990-12-02')");



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
