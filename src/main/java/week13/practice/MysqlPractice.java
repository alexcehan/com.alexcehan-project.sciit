package week13.practice;

import org.apache.commons.lang3.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MysqlPractice {
    public static void main(String[] args) throws ParseException {
        String url = "jdbc:mysql://localhost:3306/practice_schema";
        String uname = "root";
        String password = "root";
        String firstName = "";
        String lastName = "";
        String email = "";
        String gender = "";
        String dob = "1930-12-31";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "1930-12-31";
        Date parsed = dateFormat.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());

        String srcFile = "src/main/java/week13/practice/people_db.csv";

        String statementToExecute = ("INSERT INTO people_table(first_name, last_name, email, gender, dob) values('" + firstName + "', '" + lastName + "', '" + email + "', '"+ gender + "', '" + sqlDate + "')");

        try  {
            Connection connection = DriverManager.getConnection(url, uname, password);
            Statement statement = connection.createStatement();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(srcFile))) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    String[] splitLine = line.split(",");
                    if (splitLine[0].equals("first_name")) {
                        continue;
                    }

                    firstName = splitLine[0];
                    lastName = splitLine[1];
                    email = splitLine[2];
                    gender = splitLine[3];
                    sqlDate = new java.sql.Date(dateFormat.parse(splitLine[4]).getTime());

                    try {
                        statement.executeUpdate("INSERT INTO people_table(first_name, last_name, email, gender, dob) values('" + StringEscapeUtils.escapeCsv(firstName) + "', '" + lastName + "', '" + email + "', '" + gender + "', '" + sqlDate + "')");
                    } catch (SQLSyntaxErrorException e) {


                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
