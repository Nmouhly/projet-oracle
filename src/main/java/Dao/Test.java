/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author DELL
 */
public class Test {
	private static Connection con;
	//responsable de gestion des requetes
	private static Statement stm;
	
	public static void Connect() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		//qui assure la connection
		con = DriverManager.getConnection(url,"nouhaprojetbd","nouhaprojetbd");
		//gestion des req sql
       if (con!=null) {//System.out.println("Connexion à la base de données Oracle établie avec succès!");

}
       else {System.out.println("Échec de la connexion à la base de données Oracle!");}
		stm = con.createStatement();
		
	}
	
	public static int Maj(String sql) throws SQLException {
		return stm.executeUpdate(sql);
	}
	
	public static ResultSet Select(String sql) throws SQLException {
		return stm.executeQuery(sql);
	}
	
	public static void DisConnect() throws SQLException {
		stm.close();
		con.close();
	}

	   public static void main(String[] args) throws ClassNotFoundException, SQLException {
            
                Test.Connect();
                String sql = "insert into client(Id_client,NOM,PRENOM,ADRESSE) values(10,'mouhkhtar','slimani','mohmadia')";
		Test.Maj(sql);
		Test.DisConnect();
            

    }

    static Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
	


}
