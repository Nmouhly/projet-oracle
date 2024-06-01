/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Dao.ClientDao;
import Models.client;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
     * @param request
     * @param response
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */@Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         
         }
	

        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String action = request.getParameter("action"); 
                if("ajouter".equals(action)){
                String Nom,Prenom,Adresse;
		int ID_Client;
		ID_Client = Integer.parseInt(request.getParameter("id_client"));
		Nom = request.getParameter("nom");
		Prenom = request.getParameter("prenom");
		Adresse = request.getParameter("adresse");
		client c=new client(ID_Client,Nom,Prenom,Adresse);
		
            try {
                //System.out.println(Login+ " "+Password);
                ClientDao.Addclient(c);
                response.sendRedirect("AjoutClient.jsp");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                
        }	
            else if ("Supprimer".equals(action)) {
           int ID_Client;
           ID_Client = Integer.parseInt(request.getParameter("id_client"));
                     try {
                         ClientDao.Deleteclient(ID_Client);
                          response.sendRedirect("SupprimerClient.jsp");
                     } catch (ClassNotFoundException | SQLException ex) {
                         Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 

        
        }
            else if ("Supprimer1".equals(action)) {
           int ID_Client;
           ID_Client = Integer.parseInt(request.getParameter("id_client"));
                     try {
                         ClientDao.Deleteclient(ID_Client);
                          response.sendRedirect("AfficherListeClients.jsp");
                     } catch (ClassNotFoundException | SQLException ex) {
                         Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 

        
        }else if ("Rechercher".equals(action)) {
    try {
        String Nom = request.getParameter("nom");
        client c = ClientDao.getclientByNom(Nom);

        if (c != null) {
            request.setAttribute("id_client", c.getId_client());
            request.setAttribute("nom", c.getNom());
            request.setAttribute("prenom", c.getPrenom());
            request.setAttribute("adresse", c.getAdresse());

            RequestDispatcher dispatcher = request.getRequestDispatcher("RechercherAffichage.jsp");
            dispatcher.forward(request, response);
        } else {
            // Client not found
        String errorMessage = "<div style=\"background-color: #f8d7da; border-color: #f5c6cb; color: #721c24; padding: 10px; border-radius: 5px;\"><strong>Client introuvable!</strong> </div><br><div><button style=\"background-color: #7b68ee; color: white; padding: 5px 10px; border-radius: 5px; border: none; cursor: pointer;\" onclick=\"window.location.href='RechercherClient.jsp'\">Rechercher</button></div>";
            response.getWriter().println(errorMessage);
            
        }
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        String errorMessage = "<div style=\"background-color: #f8d7da; border-color: #f5c6cb; color: #721c24; padding: 10px; border-radius: 5px;\"><strong>Erreur lors de la recherche du client!</strong> </div><div><button style=\"background-color: #7b68ee; color: white; padding: 5px 10px; border-radius: 5px; border: none; cursor: pointer;\" onclick=\"window.location.href='RechercherClient.jsp'\">Rechercher</button></div>";
        response.getWriter().println(errorMessage);
    }
}
    else if ("Modifier".equals(action)) {
           int ID_Client;
           ID_Client = Integer.parseInt(request.getParameter("id_client"));
           response.sendRedirect("EditClient.jsp?id=" + ID_Client);

        
        }else if ("Edit".equals(action)) {
                     try {
                         String  NOM,PRENOM,ADRESSE;
                         int ID_Client;
                         ID_Client = Integer.parseInt(request.getParameter("id_client"));
                         NOM=request.getParameter("nom");
                         PRENOM=request.getParameter("prenom");
                         ADRESSE=request.getParameter("adresse");
                         client c=new client(ID_Client,NOM,PRENOM,ADRESSE);
                         ClientDao.Editclient(c);
                         response.sendRedirect("AfficherListeClients.jsp");
                     } catch (ClassNotFoundException | SQLException ex) {
                         Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
                     }

        
        }else  if ("Edit1".equals(action)) {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        
        String jsonString = sb.toString();
                    System.out.println(jsonString);
        JsonObject jsonObject = Json.createReader(new StringReader(jsonString)).readObject();
        
        int ID_Client = jsonObject.getInt("id_client");
        String NOM = jsonObject.getString("nom");
        String PRENOM = jsonObject.getString("prenom");
        String ADRESSE = jsonObject.getString("adresse");
        
        client c = new client(ID_Client, NOM, PRENOM, ADRESSE);
                    System.out.println(c.toString());
        try {
            ClientDao.Editclient(c);
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
       
    }
    // other actions...
}


	}
       

