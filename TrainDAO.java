import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class TrainDAO {
	public static Train findTrain(int num) throws ClassNotFoundException, SQLException{
		//System.out.println("&&");
		Train train=null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "123");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from train where train_no="+num);
		//System.out.println(resultSet.next());
		while(resultSet.next()) {
			int trainNo = resultSet.getInt(5);
			String name = resultSet.getString(1);
			double price=resultSet.getDouble(4);
			String source = resultSet.getString(2);
			String destination = resultSet.getString(3);
			System.out.println(trainNo +"\t" +name+"\t"+price+"\t"+source+"\t"+destination);
			train=new Train( trainNo,name,source,destination,price);
			return train;
			}
			return train;
	}
	
	public static Train findDestination(String src) throws ClassNotFoundException, SQLException {
		Train train=null;
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "hr", "123");
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from train where source='"+src+"'");
		//System.out.println(resultSet.next());
		while(resultSet.next()) {
			int trainNo = resultSet.getInt(5);
			String name = resultSet.getString(1);
			double price=resultSet.getDouble(4);
			String source = resultSet.getString(2);
			String destination = resultSet.getString(3);
			System.out.println(trainNo +"\t" +name+"\t"+price+"\t"+source+"\t"+destination);
			train=new Train( trainNo,name,source,destination,price);
			return train;
			}
			return train;
	}
}
