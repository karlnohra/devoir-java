import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class testjdbc {
    public static void main( String[] args ) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");

        Statement st = cx.createStatement();
        ResultSet rs = st.executeQuery( "SELECT * FROM personnes" );
        while (rs.next()) {
            String nom = rs.getString("name");
            int age = rs.getInt("age");
            System.out.println( nom + " a " + age + " ans" );
        }
        rs.close();
        st.close();
        cx.close();
    }


}
