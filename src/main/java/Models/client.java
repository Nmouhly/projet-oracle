/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */

public class client {
private int id_client;
private String nom;
private String prenom;
private String adresse;
public client(int id_client, String nom, String prenom, String adresse) {
	super();
	this.id_client = id_client;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
}
public client( String nom, String prenom, String adresse) {
	super();
	
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
}
public client() {

}

public int getId_client() {
	return id_client;
}
public void setId_client(int id_client) {
	this.id_client = id_client;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
@Override
public String toString() {
	return "client [id_client=" + id_client + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
}


}

