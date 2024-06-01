/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */




import java.sql.Date;

public class facture {
private int n_facture;
private Date date;
public int getN_facture() {
	return n_facture;
}
public void setN_facture(int n_facture) {
	this.n_facture = n_facture;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public facture(int n_facture, Date date) {
	super();
	this.n_facture = n_facture;
	this.date = date;
}
public facture() {
	super();
}
@Override
public String toString() {
	return "produit [n_facture=" + n_facture + ", date=" + date + "]";
}

}
