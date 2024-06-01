/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Models.produit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class ProduitDao {

	public static ArrayList<produit> getAllproduit() throws ClassNotFoundException, SQLException{
		ArrayList<produit> ls = new ArrayList<produit>();
		Test.Connect();
		String sql = "select * from produit";
		ResultSet res = Test.Select(sql);
		while(res.next()) {
			produit p = new produit(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(3));
			ls.add(p);
		}
		Test.DisConnect();
		return ls;
	}
	public static produit getproduitById(int id) throws ClassNotFoundException, SQLException {
		produit p = null;
		Test.Connect();
		String sql = "select * from produit where id_produit ="+id;
		ResultSet res = Test.Select(sql);
		if(res.next()) {
			p = new produit(res.getInt(1),res.getString(2),res.getInt(3),res.getInt(3));
		}
		Test.DisConnect();
		return p;
	}
	
	public static void Addproduit(produit p) throws ClassNotFoundException, SQLException {
		Test.Connect();
		String sql = "insert into produit(Id_produit,DESIGNATION,PRIX,QUANTITE_EN_STOCK) values('"+p.getId_produit()+"','"+p.getDesignation()+"','"+p.getPrix()+"','"+p. getQuantite_en_stock()+"')";
		Test.Maj(sql);
		Test.DisConnect();
	}
	public static void Editproduit(produit p) throws ClassNotFoundException, SQLException {
		Test.Connect();
		String sql = "update produit set DESIGNATION = '"+p.getDesignation()+"', Prix = '"+p.getPrix()+"', QUANTITE_EN_STOCK = '"+p.getQuantite_en_stock()+"' where id_produit ="+p.getId_produit();
		Test.Maj(sql);
		Test.DisConnect();
	}
	public static void Deleteproduit(int idP) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from produit where Id_produit="+idP ;
		Test.Connect();
		Test.Maj(sql);
		Test.DisConnect();
	}
	
	
}


