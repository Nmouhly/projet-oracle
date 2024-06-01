<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Dao.ClientDao" %>
<%@ page import="Models.client" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Liste des Clients</title>
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
            background-color: #7b68ee;
            color: white;
        }
        .input-hidden {
            display: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Liste des Clients</h2>
        <div class="table-responsive">
            <table class="table">
                <thead class="thead-custom">
                    <tr>
                        <th scope="col" style="width: 10%;">Id_Client</th>
                        <th scope="col" style="width: 17%;">Nom</th>
                        <th scope="col" style="width: 17%;">Prénom</th>
                        <th scope="col" style="width: 17%;">Adresse</th>
                        <th scope="col" style="width: 17%;">Suppression</th>
                        <th scope="col" style="width: 17%;">Modification</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        try {
                            ArrayList<client> clients = ClientDao.getAllclient();
                            for(client client : clients) {
                    %>
                        <tr>
                            <td><%= client.getId_client() %></td>
                            <td>
                                <span class="span-nom"><%= client.getNom() %></span>
                                <input type="text" class="input-nom input-hidden" value="<%= client.getNom() %>">
                            </td>
                            <td>
                                <span class="span-prenom"><%= client.getPrenom() %></span>
                                <input type="text" class="input-prenom input-hidden" value="<%= client.getPrenom() %>">
                            </td>
                            <td>
                                <span class="span-adresse"><%= client.getAdresse() %></span>
                                <input type="text" class="input-adresse input-hidden" value="<%= client.getAdresse() %>">
                            </td>
                            <td><button onclick="supprimerClient(<%= client.getId_client() %>);">Supprimer</button></td>
                            <td><button onclick="toggleEdit(this, <%= client.getId_client() %>);">Modifier</button></td>
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
    <script>
        // Fonction pour basculer entre l'affichage et l'édition
        function toggleEdit(button, id) {
            var row = button.parentNode.parentNode;
            var spans = row.getElementsByTagName("span");
            var inputs = row.getElementsByTagName("input");

            for (var i = 0; i < spans.length; i++) {
                spans[i].classList.toggle("input-hidden");
            }
            for (var i = 0; i < inputs.length; i++) {
                inputs[i].classList.toggle("input-hidden");
            }

            if (button.textContent === "Modifier") {
                button.textContent = "Sauvegarder";
                button.setAttribute("onclick", "modifierClient(this, " + id + ")");
            } else {
                button.textContent = "Modifier";
                button.setAttribute("onclick", "toggleEdit(this, " + id + ")");
            }
        }

        // Fonction pour modifier un client
        function modifierClient(button, id) {
            var row = button.parentNode.parentNode;
            var cells = row.getElementsByTagName("td");

            var data = {
                action: "Edit1",
                id_client: id,
                nom: cells[1].querySelector('input').value,
                prenom: cells[2].querySelector('input').value,
                adresse: cells[3].querySelector('input').value
            };

            var xhr = new XMLHttpRequest();
            xhr.open("POST", "ClientServlet", true);
            xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    console.log("Modification réussie !");
                    window.location.href = "AfficherListeClients.jsp";
                }
            };
            xhr.send(JSON.stringify(data));
        }

        function supprimerClient(id) {
            if (confirm("Êtes-vous sûr de vouloir supprimer ce client ?")) {
                var form = document.createElement("form");
                form.setAttribute("method", "post");
                form.setAttribute("action", "ClientServlet");

                var input = document.createElement("input");
                input.setAttribute("type", "hidden");
                input.setAttribute("name", "id_client");
                input.setAttribute("id", "id_client");
                input.setAttribute("value", id);
                form.appendChild(input);

                var actionInput = document.createElement("input");
                actionInput.setAttribute("type", "hidden");
                actionInput.setAttribute("name", "action");
                actionInput.setAttribute("value", "Supprimer1");
                form.appendChild(actionInput);

                document.body.appendChild(form);
                form.submit();
            }
        }
    </script>
</body>
</html>
