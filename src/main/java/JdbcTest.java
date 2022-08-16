import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcTest {

	public static void main(String[] args) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
				System.out.println("DB연결완료");
		}catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이브 로드 에러");
		}catch (SQLException e) {
			System.out.println("DB연결오류");
		}

	}

}
