<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.ProduitDao" %>
<%@ page import="Models.produit" %>



<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des Produits</title>
    <!-- Inclusion des fichiers CSS de Bootstrap -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .thead-custom {
            background-color: #7b68ee; /* Couleur personnalisée pour l'en-tête de tableau */
            color: white; /* Couleur du texte de l'en-tête */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Liste des Produits</h2>
        <div class="table-responsive"> <!-- Utilisation de la classe pour rendre le tableau réactif -->
            <table class="table"> <!-- Ajout de la classe "table" de Bootstrap pour styliser le tableau -->
                <thead class="thead-custom">
                    <tr>
                        <th scope="col" style="width: 10%;">Id_Produit</th> <!-- Définition de la largeur de la colonne -->
                        <th scope="col" style="width: 30%;">Designation</th> <!-- Définition de la largeur de la colonne -->
                        <th scope="col" style="width: 30%;">Prix</th> <!-- Définition de la largeur de la colonne -->
                        <th scope="col" style="width: 30%;">Quantite_en_stock</th> <!-- Définition de la largeur de la colonne -->
                    </tr>
                </thead>
                <tbody>
                    <% 
                        try {
                            ArrayList<produit> produits = ProduitDao.getAllproduit();
                            for(produit produit : produits) {
                    %>
                        <tr>
                            <td><%= produit.getId_produit() %></td>
                            <td><%= produit.getDesignation() %></td>
                            <td><%= produit.getPrix() %></td>
                            <td><%= produit.getQuantite_en_stock() %></td>
                        </tr>
                    <% 
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>
