/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ClientDao {

	public static ArrayList<client> getAllclient() throws ClassNotFoundException, SQLException{
		ArrayList<client> ls = new ArrayList<client>();
		Test.Connect();
		String sql = "select * from client";
		ResultSet res = Test.Select(sql);
		while(res.next()) {
			client c = new client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
			ls.add(c);
		}
		Test.DisConnect();
		return ls;
	}
	public static client getclientByNom(String nom) throws ClassNotFoundException, SQLException {
    client c = null;
    Test.Connect();
    String sql = "SELECT * FROM client WHERE nom = '" + nom + "'";

    try {
        ResultSet res = Test.Select(sql);
        if (res.next()) {
            c = new client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
        }
        res.close();
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
        Test.DisConnect();
    }
    return c;
}
        public static client getclientById(int ID) throws ClassNotFoundException, SQLException {
    client c = null;
    Test.Connect();
    String sql = "SELECT * FROM client WHERE Id_client= '" +ID;

    try {
        ResultSet res = Test.Select(sql);
        if (res.next()) {
            c = new client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));
        }
        res.close();
    } catch (SQLException e) {
        e.printStackTrace();
        throw e;
    } finally {
        Test.DisConnect();
    }
    return c;
}

	
	public static void Addclient(client c) throws ClassNotFoundException, SQLException {
		Test.Connect();
		String sql = "insert into client(Id_client,NOM,PRENOM,ADRESSE) values('"+c.getId_client()+"','"+c.getNom()+"','"+c.getPrenom()+"','"+c.getAdresse()+"')";
		Test.Maj(sql);
		Test.DisConnect();
	}
	public static void Editclient(client c) throws ClassNotFoundException, SQLException {
		Test.Connect();
		String sql = "update client set  NOM= '"+c.getNom()+"', PRENOM= '"+c.getPrenom()+"', ADRESSE= '"+c.getAdresse()+"' where id_client ="+c.getId_client();
		Test.Maj(sql);
		Test.DisConnect();
	}
	public static void Deleteclient(int idC) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from client where Id_client="+idC ;
		Test.Connect();
		Test.Maj(sql);
		Test.DisConnect();
	}
	
	
}


