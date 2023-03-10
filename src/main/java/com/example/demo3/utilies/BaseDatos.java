package com.example.demo3.utilies;

import com.example.demo3.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDatos {
    public static List<Product> productListSQL(){
        List<Product> productList = new ArrayList<>();
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sistemadeventa";
        String user = "admin_user";
        String password = "admin";
        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM productos");
            while (rs.next()){
                productList.add(new Product(rs.getString("name"),rs.getString("price"),rs.getString("amount")));
                System.out.println(rs.getString("name") + " añadido con exito a la lista");
            }
            statement.close();
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void agregarProducto(Product product){
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sistemadeventa";
        String user = "admin_user";
        String password = "admin";
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
            ps = connection.prepareStatement("INSERT INTO productos VALUES (?,?,?)");
            ps.setString(1, product.getName());
            ps.setString(2, product.getPrice());
            ps.setString(3, product.getAmount());
            ps.executeUpdate();
            System.out.println("Conexion realizada con exito");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                System.out.println(e);
            }
        }
    }
}
