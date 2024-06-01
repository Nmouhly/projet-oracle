<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Client</title>
</head>
<body>
    <div class="container">
        <form id="clientForm4" action="${pageContext.request.contextPath}/ClientServlet" method="post" onsubmit="return validateForm()">
            <label>ID_Client</label>
            <input type="text" id="id_client" name="id_client" value="${client.id}" required>
            <label>Nom</label>
            <input type="text" id="nom" name="nom" value="${client.nom}" required>
            <label>Prenom</label>
            <input type="text" id="prenom" name="prenom" value="${client.prenom}" required>
            <label>Adresse</label>
            <input type="text" id="adresse" name="adresse" value="${client.adresse}" required>
            <input type="hidden" name="action" value="Edit">
            <input type="submit" value="Modifier">
        </form>
    </div>
</body>
</html>
