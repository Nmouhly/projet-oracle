<%-- 
    Document   : ModifierClient
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

        input[type="email"],
        input[type="password"] {
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
    <form id="clientForm3" action="${pageContext.request.contextPath}/ClientServlet" method="post" onsubmit="return validateForm()">
        <label>Entrer l'ID_Client du client que vous voulez Modifier: </label>
        <input type="text" id="id_client" name="id_client" required>
        <input type="hidden"  name="action" value="Modifier" >       
        <input type="submit" value="Modifier">
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<script>
    function validateForm() {
        var idClient = document.getElementById("id_client").value;
      

        if (idClient.trim() === "" ) {
            alert("ce champs est obligatoire.");
            return false;
        }
        return true;
    }
</script>

</body>
</html>