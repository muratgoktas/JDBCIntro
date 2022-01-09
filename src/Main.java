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
			// PreparedStatement aras�ndaki fark ne ?
			// Statment da sorgu her �al��t�r�ld���nda veri taban�n�n belle�inde bu sorgunun bir �rne�i saklan�r.
			//PreparedStatment da veri taban�nda bu sorgusunun sadece bir kere �rne�i saklan�r ve bin kere de �al��t�rsak bu sorgunun veri taban�n�n belle�inde sadece bir �rne�i tutulur.
			// Kullan�m�: E�er hep ayn� sorguyu yolluyorsak PreoaredStatment kullan�lmas� gerekir ve  performans� art�r�r.
			// E�er fark�l� sorgular g�nderiliyorsa Stament kullan�lmal�d�r.
			ResultSet resultSet;
			DBHelper helper= new DBHelper();
			
			
					try {
						// Statment �rne�i 
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
		 // Veri olarak T�rk�e � ve � yi kabul etmiyor.
		 // ? i�aretleri parametre i�in.
		 String insertSql="Insert into world.city (Name,CountryCode,District,Population)"
		 		+ " values(?,?,?,?)";

			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile aras�ndaki fark ne ? Ara�t�r.
			// Statment da sorgu her �al��t�r�ld���nda veri taban�n�n belle�inde bu sorgunun bir �rne�i saklan�r.
			//PreparedStatment da veri taban�nda bu sorgusunun sadece bir kere �rne�i saklan�r ve bin kere de �al��t�rsak bu sorgunun veri taban�n�n belle�inde sadece bir �rne�i tutulur.
			// Kullan�m�: E�er hep ayn� sorguyu yolluyorsak PreoaredStatment kullan�lmas� gerekir ve  performans� art�r�r.
			// E�er fark�l� sorgular g�nderiliyorsa Stament kullan�lmal�d�r.
		
			DBHelper helper= new DBHelper();
			
			
					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment �rne�i
				    	preStatement =connectionPre.prepareStatement(insertSql);
				    	preStatement.setString(1,"Izmit");// Parametre Yollama
				    	preStatement.setString(2,"TUR");
				    	preStatement.setString(3,"Izmit");
				    	preStatement.setInt(4,123454);
				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql ba�lant� sa�land�.");
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
		 // Veri olarak T�rk�e � ve � yi kabul etmiyor.
		 // ? i�aretleri parametre i�in.
		 String updateSql="Update world.city set Population = ?,name=? where Id=?";
		 		
			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile aras�ndaki fark ne ? Ara�t�r.
			// Statment da sorgu her �al��t�r�ld���nda veri taban�n�n belle�inde bu sorgunun bir �rne�i saklan�r.
			//PreparedStatment da veri taban�nda bu sorgusunun sadece bir kere �rne�i saklan�r ve bin kere de �al��t�rsak bu sorgunun veri taban�n�n belle�inde sadece bir �rne�i tutulur.
			// Kullan�m�: E�er hep ayn� sorguyu yolluyorsak PreoaredStatment kullan�lmas� gerekir ve  performans� art�r�r.
			// E�er fark�l� sorgular g�nderiliyorsa Stament kullan�lmal�d�r.
		
			DBHelper helper= new DBHelper();
			
			
					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment �rne�i
				    	preStatement =connectionPre.prepareStatement(updateSql);   
				    	preStatement.setInt(1, 234566);
				    	preStatement.setString(2, "Kocaeli");
				    	preStatement.setInt(3, 4091);

				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql ba�lant� sa�land�.");
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
		 // Veri olarak T�rk�e � ve � yi kabul etmiyor.
		 // ? i�aretleri parametre i�in.
		 String deleteSql="delete from world.city where id>?";
		 		
			Connection connectionPre=null;		
		    PreparedStatement preStatement =null;
			// Statement ile aras�ndaki fark ne ? Ara�t�r.
			// Statment da sorgu her �al��t�r�ld���nda veri taban�n�n belle�inde bu sorgunun bir �rne�i saklan�r.
			//PreparedStatment da veri taban�nda bu sorgusunun sadece bir kere �rne�i saklan�r ve bin kere de �al��t�rsak bu sorgunun veri taban�n�n belle�inde sadece bir �rne�i tutulur.
			// Kullan�m�: E�er hep ayn� sorguyu yolluyorsak PreoaredStatment kullan�lmas� gerekir ve  performans� art�r�r.
			// E�er fark�l� sorgular g�nderiliyorsa Stament kullan�lmal�d�r.
		
			DBHelper helper= new DBHelper();

					try {
						
				    	connectionPre = helper.getConnection();
				    	// PreparedStatment �rne�i
				    	preStatement =connectionPre.prepareStatement(deleteSql);   
				    	preStatement.setInt(1, 4082);
		    
				    	int status=preStatement.executeUpdate();
				    	
				    	if( status!=0) {
				    		
				    		System.out.println("mySql ba�lant� sa�land�.");
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
