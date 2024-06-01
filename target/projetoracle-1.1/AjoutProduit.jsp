<%-- 
    Document   : AjoutProduit
    Created on : 11 mai 2024, 12:23:53
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 300px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="designation"],
        input[type="prix"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #7b68ee;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
             margin: 15px
        }

        input[type="submit"]:hover {
            background-color:#9370db;
        }
    </style>
</head>
<body>
<div class="container">
    <form id="produitForm" action="${pageContext.request.contextPath}/ProduitServlet" method="post" onsubmit="return validateForm()">
        <label>ID_Produit</label>
        <input type="text" id="id_produit" name="id_produit" required>
        <label>Designation</label>
        <input type="text" id="designation" name="designation" required>

        <label>Prix</label>
        <input type="text" id="prix" name="prix" required>
        <label>quantite_en_stock</label>
        <input type="text" id="quantite_en_stock" name="quantite_en_stock" required>
        <input type="hidden"  name="action" value="ajouter" >
        <input type="submit" value="Ajouter">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script>
    function validateForm() {
        var idProduit = document.getElementById("id_produit").value;
        var designation= document.getElementById("designation").value;
        var prix = document.getElementById("prix").value;
        var quantite_en_stock = document.getElementById("quantite_en_stock").value;

        if (idProduit.trim() === "" || designation.trim() === "" || prix.trim() === "" || quantite_en_stock.trim() === "") {
            alert("Tous les champs sont obligatoires.");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
