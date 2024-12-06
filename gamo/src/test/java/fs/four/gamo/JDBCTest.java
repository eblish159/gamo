package fs.four.gamo;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import org.junit.Test;

public class JDBCTest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testConnection() {	
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##gamo";
		String password = "gamo";
		
		try (Connection con = DriverManager.getConnection(url, user, password)) {
			System.out.println("connection: " + con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}