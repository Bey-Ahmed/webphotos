<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/head.jsp" %>
    <link rel="stylesheet" href="<c:url value="includes/css/nav-user.css"/>">
    <title>Création Album</title>
</head>

<body>
    <%@ include file="../includes/nav-user.jsp" %>

    <main>
        <section class="add-album">
            <div class="container">
            	<div class="form-image">
                    <img src="<c:url value="includes/images/photo-album-g263f27af4_640.jpg"/>" alt="#">
                </div>

                <form action="addalbum" method="post" class="form new-album-form">
                    <div class="album">
                        <span><i class="far fa-images"></i></span>
                        <p>Nouvel Album</p>
                    </div>
            
                    <div class="form-input">
                        <span><i class="far fa-image"></i></span>
                        <input type="text" name="theme" id="theme" placeholder="Theme" maxlength="255" required>
                    </div>
            
                    <div class="form-select">
                        <span><i class="fas fa-user-friends"></i></span>
                        <select name="audience" id="audience" class="audience">
                            <option value="">Accessibilité : </option>
                            <option value="0">Publique</option>
                            <option value="1">Privée</option>
                        </select>
                    </div>
            
                    <input type="submit" value="Créer" class="btn submit-btn">
                </form>
            </div>
        </section>
        
        <section class="result">
            <div class="container">
                <p class="success">${(success == 1) ? "Nouvel album créé!" : ""}</p>
                <p class="error">${(success == 0) ? "Erreur!" : ""}</p>
            </div>
        </section>
    </main>
</body>
</html>