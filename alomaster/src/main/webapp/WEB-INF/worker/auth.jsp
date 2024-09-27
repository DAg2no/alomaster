<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="style.css">
    </head>

    <body>
        <link rel="stylesheet" href="style.css">
        <header>
            <img src="logo.png" alt="logo">
            <input type="text" placeholder="Búsqueda" id="busqueda">
            <nav>
                <a href="#">Iniciar Sesión</a>
                <a href="#">Cerrar Sesión</a>
            </nav>
        </header>
        <main>
            <div class="izquierda">
            <div>
            <div class="login">
                <h2>
                    Iniciar sesion
                </h2>
                <form action="${pageContext.request.contextPath}/auth/login" class="logOn" method="post">
                    Correo
                    <input type="text">
                    Contrseña
                    <input type="password">
                </form>
            </div>
            <div class="regmaestro">
                <h3>
                    ¿Eres maestro?
                </h3>
                <button id="boton1" id="maestro">
                    click aqui</button>
                <div class="modal hidden">
                    <div class="display">
                        <p href="#">Subir información extra:</p>
                        <form action="/upload" method="post" enctype="multipart/form-data">
                            <label for="file">Sube tus documentos:</label>
                            <input type="file" name="file" id="file" accept="image/*" required></input>
                            <input type="file" name="file" id="file" accept="image/*" required></input>
                            <input type="file" name="file" id="file" accept="image/*" required></input>
                            <button type="submit">
                                Subir Imagen
                            </button>
                        </form>
                    </div>
                </div>

            </div>
            <div class="derecha">
                <div>
                    <h2>
                        Registro
                    </h2>
                    <form:form method="post" action="${pageContext.request.contextPath}/auth/register" modelAttribute="user">
                        <label for="">Nombre Completo</label>
                        <form:input path="" id=""/>
                        <form:errors path="" cssClass="error"/>
                        <br/><br/>

                        <label for="artista">Correo:</label>
                        <form:input path="artista" id="artista"/>
                        <form:errors path="artista" cssClass=""/>
                        <br/><br/>

                        <label for="album">Contraseña:</label>
                        <form:input path="password" id="password"/>
                        <form:errors path="password" cssClass="error"/>
                        <br/><br/>

                        <label for="genero">Confirmar contraseña:</label>
                        <form:input path="passwordConfirm" id="passwordConfirm"/>
                        <form:errors path="passwordConfirm" cssClass="error"/>
                        <br/><br/>

                        <label for="idioma">Numero de telefono:</label>
                        <form:input path="idioma" id="idioma"/>
                        <form:errors path="idioma" cssClass=""/>
                        <br/><br/>

                        <label for="idioma">Rut:</label>
                        <form:input type=path="idioma" id="idioma"/>
                        <form:errors path="idioma" cssClass=""/>
                        <br/><br/>

                        <label for="idioma">Direccion:</label>
                        <form:input path="idioma" id="idioma"/>
                        <form:errors path="idioma" cssClass=""/>
                        <br/><br/>
                        <input type="submit" value="Crear cuenta"/>
                    </form:form>
                </div>
            </div>

        </main>
        </section>
        <section class="section-contact">
            <a>contacto</a>
            <a>soporte</a>
        </section>

        <footer>
            <p>© AlóMaster todos los derechos reservados</p>
        </footer>

    </body>

</html>