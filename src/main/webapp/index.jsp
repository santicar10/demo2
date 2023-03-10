<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Register employees</title>
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
    <h1 class="letter">Crear Producto</h1>

    <form action="/register-product" method="post">
        <div class="div">
            <input class="input" placeholder="nombre" type="text" name="name" value="${param.name}"/>
            <input class="input" placeholder="precio" type="text" name="price" value="${param.price}"/>
            <input class="input" placeholder="cantidad" type="text" name="amount" value="${param.amount}"/>
        </div>

        <%
            HashMap<String,String> errores=(HashMap<String, String>) request.getSession().getAttribute("errores");
            if (errores!=null&&errores.size()>0){
                String contenido="";
                for(String error:errores.values()){
        %>
        <div class="div">
            <p class="error" >* <%=error%></p>
        </div>
        <%}%>
        <%}%>
        <div class="div">
            <button class="buttom" type="submit">registrar</button>
        </div>
    </form>

<h1 class="letter">Lista Producto</h1>

<form action="/register-product" method="get">
    <div class="div">
        <button class="buttom" type="submit">ver lista</button>
    </div>
</form>

</body>
</html>