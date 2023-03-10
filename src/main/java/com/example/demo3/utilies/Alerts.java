package com.example.demo3.utilies;

import com.example.demo3.models.Product;

import java.util.HashMap;
import java.util.List;

public class Alerts {
    public static HashMap<String,String> generateMessage(String name, String price, String amount, List<Product> productList) {
        HashMap<String,String> errores=new HashMap<>();

        if(name.equals("")||name.isBlank()){
            errores.put("nombre","ingrese un nombre valido");
        }
        if (price==null||price.isBlank()){
            errores.put("precio","ingrese un precio valido");
        }
        if (amount== null|| amount.isBlank() ) {
            errores.put("cantidad", "ingrese una cantidad valida");

        }

        for (Product e: productList ) {
            if (e.getName().equals(name)){
                errores.put("nombre","nombre producto repetido");
            }
            if (e.getPrice().equals("0")) {
                errores.put("precio","el precio no puede ser cero");
            }
            if (e.getAmount().equals("0")) {
                errores.put("cantidad","la cantidad no puede ser cero");
            }
        }

        return errores;
    }
}
