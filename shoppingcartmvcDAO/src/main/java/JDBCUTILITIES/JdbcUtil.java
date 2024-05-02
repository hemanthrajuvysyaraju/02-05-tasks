package JDBCUTILITIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {

	public static Connection getConnection() {
		FileInputStream fs = null;
		Properties p = new Properties();
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			fs = new FileInputStream("C:\\Users\\heman\\eclipse-workspace\\irctcmvc\\src\\main\\java\\JDBCUTILITIES\\connection.properties");
			p.load(fs);
			con = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (IOException | SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void closeConnections(Connection con, Statement st, ResultSet rs) throws SQLException {
		if (con != null) {
			con.close();
		}
		if (st != null) {
			st.close();
		}
		if (rs != null) {
			rs.close();
		}
	}

}
