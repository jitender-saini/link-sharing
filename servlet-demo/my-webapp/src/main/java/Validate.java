import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Validate {
    public static boolean checkUser(String username, String password){
        boolean st = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","delete");
            PreparedStatement ps = con.prepareStatement("select * from user where username = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
        }catch (Exception e){
            e.printStackTrace();
        }
        return st;
    }
}
