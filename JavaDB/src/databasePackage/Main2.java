//package databasePackage;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//
////https://docs.oracle.com/javase/tutorial/jdbc/basics/
//public class Main2
//{
//
//	public static void main(String[] args) throws Exception 
//	{
//		createTable();
////		post();
//		get();
//	}
//	
//	public static Connection getConnection() throws SQLException
//	{
//		try
//		{
////			In previous versions of JDBC, to obtain a connection, you first had to initialize your JDBC driver by calling the method Class.forName.
////			Any JDBC 4.0 drivers that are found in your class path are automatically loaded. (However, you must manually load any drivers prior to JDBC 4.0 with the method Class.forName.)
//			String url = "jdbc:mysql://localhost:3306/demo";
//			String userName = "myUser1";
//			String password = "MYPASSWORD1";
//			
//			Connection conn = DriverManager.getConnection(url, userName, password);
//			System.out.println("Connected from Main2!");
//			return conn;
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e);
//		}
//		
//		return null;
//	}
//	
//	public static void createTable() throws SQLException
//	{
//		try 
//		{
//			Connection con = getConnection();
//			
////			aby poni¿sze query dzia³a³o trzeba zapewniæ dostêp do wszystkich tabel w bazie danych: GRANT ALL PRIVILEGES ON demo.* TO myUser1@localhost identified BY 'MYPASSWORD1';
//			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS mytable2(id int NOT NULL AUTO_INCREMENT, first varchar(255), last varchar(255), PRIMARY KEY(id))");
//			create.executeUpdate();
//		} 
//		catch (SQLException e) 
//		{
//			System.out.println(e);
//		}
//		finally
//		{
//			System.out.println("Function completed.");
//		}
//		
//	}
//
//	public static void post() throws SQLException
//	{
//		final String var1 = "John";
//		final String var2 = "Miller";
//		
//		try
//		{
//			Connection con = getConnection();
//			PreparedStatement posted = con.prepareStatement("INSERT INTO mytable2 (first, last) VALUES('"+var1+"', '"+var2+"')");
//			posted.executeUpdate();
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e);
//		}
//		finally
//		{
//			System.out.println("Insert completed.");
//		}
//	}
//
//	public static ArrayList<String> get() throws SQLException
////	https://docs.oracle.com/javase/tutorial/jdbc/basics/retrieving.html
//	{
//		try 
//		{
//			Connection con = getConnection();
//			PreparedStatement statement = con.prepareStatement("SELECT first, last FROM mytable2");
//			ResultSet result = statement.executeQuery();
//			
//			ArrayList<String> resultArray = new ArrayList<String>();
//			
//			while(result.next())
//			{
//				System.out.print(result.getString("first"));
//				System.out.print(" ");
//				System.out.println(result.getString("last"));
//				
//				resultArray.add(result.getString("last"));
//			}
//			
//			System.out.println("All records have been selected.");
//			return resultArray;
//		} 
//		catch (SQLException e) 
//		{
//			System.out.println(e);
//		}
//		
//		return null;
//	}
//}
//
