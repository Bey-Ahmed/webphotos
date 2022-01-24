<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/head.jsp" %>
    <link rel="stylesheet" href="<c:url value="includes/css/nav.css"/>">
    <title>Accueil</title>
</head>

<body>
    <%@ include file="../includes/nav.jsp" %>

    <main>
        <section class="intro">
            <div class="container">
                <div class="intro-text">
                    <h1>Partagez vos meilleures photos avec le monde et vos amis</h1>
                    <div class="intro-btn">
                        <a href="#" class="btn btn-transparent">Se connecter</a>
                        <a href="#" class="btn btn-mauve">S'inscrire</a>
                    </div>
                </div>
                <div class="intro-pics">
                    <img src="<c:url value="includes/images/Frame2.jpg"/>" alt="#" class="intro-pic">
                    <img src="<c:url value="includes/images/Frame3.jpg"/>" alt="#" class="intro-pic">
                </div>
            </div>
        </section>
    </main>
</body>
</html>