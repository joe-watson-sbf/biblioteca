package com.sofkau.biblioteca.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JOSEPH WATZSON alias Joe Watson SBF
 * @GitHub: https://github.com/joe-watson-sbf
 * @Instagram: https://www.instagram.com/joe_watson_sbf
 * @since 23/10/2021
 **/

public class Utils {
    public static Date generateDate(String fecha){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return format.parse(fecha);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Formato fecha incorrecto: "+ fecha + "" +
                    "\n\t\tEl formato debe ser dd/MM/yyyy \n");
        }

    }
}
