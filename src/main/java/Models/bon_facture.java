/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author DELL
 */
public class bon_facture {
private int quantite_achetee;

public int getQuantite_achetee() {
	return quantite_achetee;
}

public void setQuantite_achetee(int quantite_achetee) {
	this.quantite_achetee = quantite_achetee;
}

@Override
public String toString() {
	return "bon_facture [quantite_achetee=" + quantite_achetee + "]";
}

public bon_facture(int quantite_achetee) {
	super();
	this.quantite_achetee = quantite_achetee;
}

public bon_facture() {
	super();
}

}

