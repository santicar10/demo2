<%@ page import="com.example.demo3.models.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List product</title>
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
<h1 class="letter">Lista productos</h1>
<%
    List<Product> productList = (List)request.getSession().getAttribute("productList");
    int cont=1;
    for (Product product : productList){

%>
    <div class="div">
        <p class="text"><b>Producto <%=cont%></b></p>
        <p class="text">Nombre <%=product.getName()%></p>
        <p class="text">precio <%=product.getPrice()%></p>
        <p class="text">cantidad <%=product.getAmount()%></p>
        <p class="jump">xd un salto de liena improvisado</p>
        <%cont=cont+1;%>
    </div>
    <%}%>
</body>
</html>
