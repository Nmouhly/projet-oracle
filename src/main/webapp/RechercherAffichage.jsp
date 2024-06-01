<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Résultat de la recherche</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        ul {
            list-style-type: none;
            padding: 0;
        }
        li {
            margin-bottom: 10px;
            color: mediumslateblue; /* Couleur "medium purple blue" */
        }
        button {
            background-color: mediumslateblue;
            border-radius: 10px;
            padding: 15px; /* Couleur "medium purple blue" */
        }
    </style>
</head>
<body>
    <h2>Informations du Client</h2>
    <ul>
        <li><strong>ID Client:</strong> <%= request.getAttribute("id_client") %></li>
        <li><strong>Nom:</strong> <%= request.getAttribute("nom") %></li>
        <li><strong>Prénom:</strong> <%= request.getAttribute("prenom") %></li>
        <li><strong>Adresse:</strong> <%= request.getAttribute("adresse") %></li>
    </ul>
    <button onclick="window.location.href = 'RechercherClient.jsp';">Recherche</button>
</body>
</html>
