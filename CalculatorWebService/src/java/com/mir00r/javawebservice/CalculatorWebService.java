/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mir00r.javawebservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Created by Mir00r
 */
@WebService(serviceName = "CalculatorWebService")
public class CalculatorWebService {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    @WebMethod(operationName = "AddIntegers")
    public int add(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
        return num1 + num2;
    }

    @WebMethod(operationName = "SubtractIntegers")
    public int sum(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
        return num1 - num2;
    }

    @WebMethod(operationName = "MultiplyIntegers")
    public int mul(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
        return num1 * num2;
    }

    @WebMethod(operationName = "DivideIntegers")
    public int divide(@WebParam(name = "firstNum") int num1, @WebParam(name = "secondNum") int num2) {
        return num1 + num2;
    }
}
