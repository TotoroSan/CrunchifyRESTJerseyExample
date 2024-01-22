//package com.crunchify.restjersey.temperatureservice;
///**
// * @author Crunchify.com
// * * Description: This program converts unit from Centigrade to Fahrenheit.
// * Last updated: 12/28/2018
// */
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//@Path("/ctofservice") // specify which path calls the function
//public class CtoFService {
//    @GET // speficies that we get the result if we send a get request to the URL of the function
//    @Produces("application/xml")
//    public String convertCtoF() {
//        Double fahrenheit;
//        Double celsius = 36.8;
//        fahrenheit = ((celsius * 9) / 5) + 32;
//        String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
//        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
//    }
//    @Path("{c}") // this is an optional path parameter for passing the argument
//    @GET
//    @Produces("application/xml") // specifies that it is returned as text in  XML format 
//    public String convertCtoFfromInput(@PathParam("c") Double c) {
//        Double fahrenheit;
//        Double celsius = c;
//        fahrenheit = ((celsius * 9) / 5) + 32;
//        String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
//        return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
//    }
//}