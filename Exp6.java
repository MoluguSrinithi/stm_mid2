import java.util.*;
import java.sql.*;

class Exp6{
    static String url = "jdbc:sqlite:students.db";

    static void setup() throws Exception{
        Connection con = DriverManager.getConnection(url);
        Statement st = con.createStatement();
        st.execute("CREATE TABLE IF NOT EXISTS students" + "(id INTEGER, name TEXT, marks INTEGER)");
        st.execute("DELETE FROM students");
        st.execute("INSERT INTO students VALUES (1,'ravi',89)");
        st.execute("INSERT INTO students VALUES (2,'neha',89)");
        st.execute("INSERT INTO students VALUES (3,'amit',58)");
        con.close();
    }

    static void test(int id, String exp) throws Exception{
        Connection con = DriverManager.getConnection(url);
        PreparedStatement ps = con.prepareStatement("SELECT marks from students where id=?");
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int marks = rs.getInt("marks");

        String status = marks>=50?"PASS": "FAIL";
        if (status.equals(exp)) {
            System.out.println("Student: " + id +" Marks= " + marks + ": PASS");
        } else {
            System.out.println("Student: " + id +" Marks= " + marks + ": FAIL");
        }
        con.close();
    }

    public static void main(String[] args) throws Exception{
        setup();
        test(1,"PASS");
        test(2,"PASS");
        test(3,"PASS");
    }
}