<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/head.jsp" %>
    <link rel="stylesheet" href="<c:url value="includes/css/nav-user.css"/>">
    <title>Ajout photo</title>
</head>

<body>
    <%@ include file="../includes/nav-user.jsp" %>

    <main>
        <section class="add-album">
            <div class="container">
            	<div class="form-image">
                    <img src="<c:url value="includes/images/photographs-geebccc1a2_640.jpg"/>" alt="#">
                </div>

                <form action="addphoto" method="post" class="form new-album-form" enctype="multipart/form-data">
                    <div class="album">
                        <span><i class="fas fa-file-image"></i></span>
                        <p>Ajouter une photo</p>
                    </div>
                    
                    <div class="form-input">
                        <span><i class="far fa-image"></i></span>
                        <input type="text" name="bio" id="bio" placeholder="Bio" maxlength="255">
                    </div>
                    
                    <div class="form-select">
                        <span><i class="far fa-images"></i></span>
                        <select name="album-id" id="album-id" class="album-id">
                            <option value="">Choisir Album : </option>
                            <c:forEach items="${albums}" var="album">
                                <option value='<c:out value="${ album.id }"/>'><c:out value="${ album.theme }"/></option>
                            </c:forEach>
                        </select>
                    </div>
            
                    <div class="form-input file-input">
                        <label for="file"><span><i class="far fa-file-image"></i></span> Choisir une photo: </label>
                        <input type="file" name="file" id="file" accept="image/*">
                    </div>
            
                    <input type="submit" value="Ajouter" class="btn submit-btn">
                </form>
            </div>
        </section>
        
        <section class="result">
            <div class="container">
            	<p class="success">${file}</p>
                <p class="success">${(success == 1) ? "Nouvel album créé!" : ""}</p>
                <p class="error">${(success == 0) ? "Erreur!" : ""}</p>
            </div>
        </section>
    </main>
</body>
</html>