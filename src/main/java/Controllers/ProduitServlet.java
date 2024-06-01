/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.ProduitDao;
import Models.produit;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ProduitServlet", urlPatterns = {"/ProduitServlet"})
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */ protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action"); 
                if("ajouter".equals(action)){
                String designation;
		int ID_Produit,prix,quantite_en_stock;
		ID_Produit = Integer.parseInt(request.getParameter("id_produit"));
		 designation= request.getParameter("designation");
		prix = Integer.parseInt(request.getParameter("prix"));
                 quantite_en_stock= Integer.parseInt(request.getParameter("quantite_en_stock"));
		produit p=new produit(ID_Produit,designation,prix,quantite_en_stock);
		PrintWriter out=response.getWriter();
            try {
               
                ProduitDao.Addproduit(p);
                response.sendRedirect("AjoutProduit.jsp");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
        }	
            else if ("Supprimer".equals(action)) {
           int ID_Produit;
           ID_Produit= Integer.parseInt(request.getParameter("id_produit"));
                     try {
                         ProduitDao.Deleteproduit(ID_Produit);
                          response.sendRedirect("SupprimerProduit.jsp");
                     } catch (ClassNotFoundException ex) {
                         Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                     } catch (SQLException ex) {
                         Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 

        
        }else if ("Rechercher".equals(action)) {
    int ID_Produit;
    ID_Produit = Integer.parseInt(request.getParameter("id_produit"));
    try {
        // Rechercher le client par ID dans la base de données
        produit p = ProduitDao.getproduitById(ID_Produit);
        
        // Écrire la réponse HTML directement dans la servlet
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Résultat de la recherche</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background-color: #f4f4f4;");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("}");
        out.println("ul {");
        out.println("    list-style-type: none;");
        out.println("    padding: 0;");
        out.println("}");
        out.println("li {");
        out.println("    margin-bottom: 10px;");
        out.println("    color: mediumslateblue; /* Couleur \"medium purple blue\" */");
        out.println("}");
         out.println("button {");
        out.println(" background-color: mediumslateblue; border-radius:10px;padding:15px; /* Couleur \"medium purple blue\" */");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Informations du produit</h2>");
        out.println("<ul>");
        out.println("<li><strong>ID Produit:</strong> " + p.getId_produit() + "</li>");
        out.println("<li><strong>Designation:</strong> " + p.getDesignation() + "</li>");
        out.println("<li><strong>Prix:</strong> " + p.getPrix() + "</li>");
        out.println("<li><strong>Quantite_en_stock:</strong> " + p.getQuantite_en_stock() + "</li>");
        out.println("</ul>");
        out.println("<button onclick=\"window.location.href = 'RechercherProduit.jsp';\">Recherche</button>");
        out.println("</body>");
        out.println("</html>");
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
}


	}
       

}