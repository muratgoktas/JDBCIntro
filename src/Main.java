import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SelectData();
		//InsertData();
		//UpdateData();
		DeleteData();
				}

	
	 public static void SelectData() throws SQLException, ClassNotFoundException{
		 String listSql="select * from city";
			Connection connection=null;
			Statement statement =null; 
			// PreparedStatement arasýndaki fark ne ?
			// Statment da sorgu her çalýþtýrýldýðýnda veri tabanýnýn belleðinde bu sorgunun bir örneði saklanýr.
			//PreparedStatment da veri tabanýnda bu sorgusunun sadece bir kere örneði saklanýr ve bin kere de çalýþtýrsak bu sorgunun veri tabanýnýn belleðinde sadece bir örneði tutulur.
			// Kullanýmý: Eðer hep ayný sorguyu yolluyorsak PreoaredStatment kullanýlmasý gerekir ve  performansý artýrýr.
			// Eðer farkýlý sorgular gönderiliyorsa Stament kullanýlmalýdýr.
			ResultSet resultSet;
			DBHelper helper= new DBHelper();
			
			
					try {
						// Statment Örneði 
						connection = helper.getConnection();
						statement = connection.createStatement();
				    	resultSet = statement.executeQuery(listSql);
				    	ArrayList<City> cities = new ArrayList<City>();
				    	while(resultSet.next()) {
				    		cities.add(new City(resultSet.getString("name"),
				    				resultSet.getString("countryCode"),
				    				resultSet.getString("district"),
				    				resultSet.getInt("population")));
				    	}
				    	System.out.println(cities.size());
				    	
					}catch(SQLException exception) {
						helper.showErrorMessage(exception);
					
					} finally {
						
						if(connection!=null ) {
						 connection.close();
						
						
						 }
					}
	 }
	
	 public static void InsertData() throws SQLException, ClassNotFoundException {
		 // Veri olarak Türkçe ý ve Ý yi kabul etmiyor.
		 // ? iþaretleri parametre için.
		 String insertSql="Insert into world.city (Name,CountryCode,District,Population)"
		 		+ " values(?,?,?,?)";

			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile arasýndaki fark ne ? Araþtýr.
			// Statment da sorgu her çalýþtýrýldýðýnda veri tabanýnýn belleðinde bu sorgunun bir örneði saklanýr.
			//PreparedStatment da veri tabanýnda bu sorgusunun sadece bir kere örneði saklanýr ve bin kere de çalýþtýrsak bu sorgunun veri tabanýnýn belleðinde sadece bir örneði tutulur.
			// Kullanýmý: Eðer hep ayný sorguyu yolluyorsak PreoaredStatment kullanýlmasý gerekir ve  performansý artýrýr.
			// Eðer farkýlý sorgular gönderiliyorsa Stament kullanýlmalýdýr.
		
			DBHelper helper= new DBHelper();
			
			
					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment Örneði
				    	preStatement =connectionPre.prepareStatement(insertSql);
				    	preStatement.setString(1,"Izmit");// Parametre Yollama
				    	preStatement.setString(2,"TUR");
				    	preStatement.setString(3,"Izmit");
				    	preStatement.setInt(4,123454);
				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql baðlantý saðlandý.");
				    		System.out.println("Insert database");
				    	}
					}catch(SQLException exception) {
						helper.showErrorMessage(exception);
					
					} finally {
						
						if(connectionPre!=null ) {
						 preStatement.close();
						 connectionPre.close();
						
						
						 }
					}
	 }
	 public static void UpdateData()  throws SQLException, ClassNotFoundException{
		 // Veri olarak Türkçe ý ve Ý yi kabul etmiyor.
		 // ? iþaretleri parametre için.
		 String updateSql="Update world.city set Population = ?,name=? where Id=?";
		 		
			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile arasýndaki fark ne ? Araþtýr.
			// Statment da sorgu her çalýþtýrýldýðýnda veri tabanýnýn belleðinde bu sorgunun bir örneði saklanýr.
			//PreparedStatment da veri tabanýnda bu sorgusunun sadece bir kere örneði saklanýr ve bin kere de çalýþtýrsak bu sorgunun veri tabanýnýn belleðinde sadece bir örneði tutulur.
			// Kullanýmý: Eðer hep ayný sorguyu yolluyorsak PreoaredStatment kullanýlmasý gerekir ve  performansý artýrýr.
			// Eðer farkýlý sorgular gönderiliyorsa Stament kullanýlmalýdýr.
		
			DBHelper helper= new DBHelper();
			
			
					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment Örneði
				    	preStatement =connectionPre.prepareStatement(updateSql);   
				    	preStatement.setInt(1, 234566);
				    	preStatement.setString(2, "Kocaeli");
				    	preStatement.setInt(3, 4091);

				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql baðlantý saðlandý.");
				    		System.out.println("Update database");
				    	}
					}catch(SQLException exception) {
						helper.showErrorMessage(exception);
					
					} finally {
						
						if(connectionPre!=null ) {
						 preStatement.close();
						 connectionPre.close();
						
						
						 }
					}
	 }
	 public static void DeleteData() throws SQLException, ClassNotFoundException {
		 // Veri olarak Türkçe ý ve Ý yi kabul etmiyor.
		 // ? iþaretleri parametre için.
		 String deleteSql="delete from world.city where id>?";
		 		
			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile arasýndaki fark ne ? Araþtýr.
			// Statment da sorgu her çalýþtýrýldýðýnda veri tabanýnýn belleðinde bu sorgunun bir örneði saklanýr.
			//PreparedStatment da veri tabanýnda bu sorgusunun sadece bir kere örneði saklanýr ve bin kere de çalýþtýrsak bu sorgunun veri tabanýnýn belleðinde sadece bir örneði tutulur.
			// Kullanýmý: Eðer hep ayný sorguyu yolluyorsak PreoaredStatment kullanýlmasý gerekir ve  performansý artýrýr.
			// Eðer farkýlý sorgular gönderiliyorsa Stament kullanýlmalýdýr.
		
			DBHelper helper= new DBHelper();

					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment Örneði
				    	preStatement =connectionPre.prepareStatement(deleteSql);   
				    	preStatement.setInt(1, 4082);
		    
				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql baðlantý saðlandý.");
				    		System.out.println("Delete database");
				    	}
					}catch(SQLException exception) {
						helper.showErrorMessage(exception);
					
					} finally {
						
						if(connectionPre!=null ) {
						 preStatement.close();
						 connectionPre.close();
						
						
						 }
					}
	 }
}
