package group;
import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static Connection connection;
    public static ResultSet getAllStudents(){
        //Create a resultset which we will return
        ResultSet resultSet = null;
        try {
            //create and run the query to get all students
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from students");

            //Collect the results in the resultset
            resultSet = statement.getResultSet();

            //interate through the result set, printing out each column
            while (resultSet.next()) {
                for (int i = 1; i < 6; i++)
                    System.out.print(resultSet.getString(i) + " ");
                System.out.println();
            }
        }
        catch (Exception e){}

        //return the resultset
        return resultSet;
    }
    public static void addStudent(String in_first_name, String in_last_name, String in_email, String in_enrollment_date){
        try {
            //create and execute the query to add a new student to the database
            Statement statement = connection.createStatement();
            statement.executeQuery("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES('" +
                    in_first_name + "', '" + in_last_name + "', '" + in_email + "', '" + in_enrollment_date + "');");
        }
        catch (Exception e){}
    }

    public static void updateStudentEmail(int student_id, String new_email){
        try {
            //create and execute a query to update a specified student's email
            Statement statement = connection.createStatement();
            statement.executeQuery("UPDATE students SET email = '" + new_email + "'WHERE student_id = '" + student_id + "'");
        }
        catch (Exception e){}
    }

    public static void deleteStudent(int student_id){
        try {
            //create and execute a query to delete a specified student
            Statement statement = connection.createStatement();
            statement.executeQuery("DELETE FROM students WHERE student_id = '" + student_id + "'");
        }
        catch (Exception e){System.out.println(e);}
    }

    public static void main(String[] args) {
        //Variables for connecting to the database
        String url = "jdbc:postgresql://localhost:5432/Assignment3";
        String name = "postgres";
        String pass = "INSERT PASSWORD HERE";


        try{
            //connect to the database
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url,name,pass);

            //Run the created functions

            //addStudent("Alex","Davidson","A.dave@email.com","2023-08-25");
            //updateStudentEmail(1,"new@email.com");
            deleteStudent(4);
            getAllStudents();
        }
        catch (Exception e){}
    }
}