/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */

public class produit {
private int id_produit;
private String designation;
private int prix;
private int quantite_en_stock;
public int getId_produit() {
	return id_produit;
}
public void setId_produit(int id_produit) {
	this.id_produit = id_produit;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getQuantite_en_stock() {
	return quantite_en_stock;
}
public void setQuantite_en_stock(int quantite_en_stock) {
	this.quantite_en_stock = quantite_en_stock;
}
public produit(int id_produit, String designation, int prix, int quantite_en_stock) {
	super();
	this.id_produit = id_produit;
	this.designation = designation;
	this.prix = prix;
	this.quantite_en_stock = quantite_en_stock;
}
public produit() {
	super();
}
@Override
public String toString() {
	return "produit [id_produit=" + id_produit + ", designation=" + designation + ", prix=" + prix
			+ ", quantite_en_stock=" + quantite_en_stock + "]";
}

}

