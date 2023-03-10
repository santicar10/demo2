package com.example.demo3.controllers.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.demo3.controllers.ModelFactoryController;
import com.example.demo3.models.Product;
import com.example.demo3.utilies.Alerts;
import com.example.demo3.utilies.BaseDatos;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.swing.*;

import static java.lang.System.out;
import static java.lang.System.setErr;

@WebServlet(name = "SvProduct", urlPatterns = "/register-product")
public class SvProduct extends HttpServlet {
    ModelFactoryController mfc = new ModelFactoryController();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("productList",BaseDatos.productListSQL());
        response.sendRedirect("listProduct.jsp");
    }

    @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String amount = req.getParameter("amount");

        if (name.equals("") || price.equals("") || amount.equals("")){

            HashMap<String,String> errores=new HashMap<>(Alerts.generateMessage(name,price,amount,mfc.getDemo().getPsi().getProductList()));
            HttpSession session = req.getSession();
            session.setAttribute("errores",errores);
            try {
                getServletContext().getRequestDispatcher("/index.jsp").forward(req,resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

        }else {
            mfc.addProduct(name,price,amount);
            HttpSession session = req.getSession();
            session.setAttribute("productList",BaseDatos.productListSQL());
            resp.sendRedirect("listProduct.jsp");
        }
    }
}