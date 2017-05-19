
package com.mir00r.webserviceclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CalculatorWebService", targetNamespace = "http://javawebservice.mir00r.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CalculatorWebService {


    /**
     * 
     * @param secondNum
     * @param firstNum
     * @return
     *     returns int
     */
    @WebMethod(operationName = "AddIntegers")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "AddIntegers", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.AddIntegers")
    @ResponseWrapper(localName = "AddIntegersResponse", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.AddIntegersResponse")
    @Action(input = "http://javawebservice.mir00r.com/CalculatorWebService/AddIntegersRequest", output = "http://javawebservice.mir00r.com/CalculatorWebService/AddIntegersResponse")
    public int addIntegers(
        @WebParam(name = "firstNum", targetNamespace = "")
        int firstNum,
        @WebParam(name = "secondNum", targetNamespace = "")
        int secondNum);

    /**
     * 
     * @param secondNum
     * @param firstNum
     * @return
     *     returns int
     */
    @WebMethod(operationName = "SubtractIntegers")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "SubtractIntegers", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.SubtractIntegers")
    @ResponseWrapper(localName = "SubtractIntegersResponse", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.SubtractIntegersResponse")
    @Action(input = "http://javawebservice.mir00r.com/CalculatorWebService/SubtractIntegersRequest", output = "http://javawebservice.mir00r.com/CalculatorWebService/SubtractIntegersResponse")
    public int subtractIntegers(
        @WebParam(name = "firstNum", targetNamespace = "")
        int firstNum,
        @WebParam(name = "secondNum", targetNamespace = "")
        int secondNum);

    /**
     * 
     * @param secondNum
     * @param firstNum
     * @return
     *     returns int
     */
    @WebMethod(operationName = "DivideIntegers")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "DivideIntegers", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.DivideIntegers")
    @ResponseWrapper(localName = "DivideIntegersResponse", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.DivideIntegersResponse")
    @Action(input = "http://javawebservice.mir00r.com/CalculatorWebService/DivideIntegersRequest", output = "http://javawebservice.mir00r.com/CalculatorWebService/DivideIntegersResponse")
    public int divideIntegers(
        @WebParam(name = "firstNum", targetNamespace = "")
        int firstNum,
        @WebParam(name = "secondNum", targetNamespace = "")
        int secondNum);

    /**
     * 
     * @param secondNum
     * @param firstNum
     * @return
     *     returns int
     */
    @WebMethod(operationName = "MultiplyIntegers")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "MultiplyIntegers", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.MultiplyIntegers")
    @ResponseWrapper(localName = "MultiplyIntegersResponse", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.MultiplyIntegersResponse")
    @Action(input = "http://javawebservice.mir00r.com/CalculatorWebService/MultiplyIntegersRequest", output = "http://javawebservice.mir00r.com/CalculatorWebService/MultiplyIntegersResponse")
    public int multiplyIntegers(
        @WebParam(name = "firstNum", targetNamespace = "")
        int firstNum,
        @WebParam(name = "secondNum", targetNamespace = "")
        int secondNum);

    /**
     * 
     * @param name
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "hello", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.Hello")
    @ResponseWrapper(localName = "helloResponse", targetNamespace = "http://javawebservice.mir00r.com/", className = "com.mir00r.webserviceclient.HelloResponse")
    @Action(input = "http://javawebservice.mir00r.com/CalculatorWebService/helloRequest", output = "http://javawebservice.mir00r.com/CalculatorWebService/helloResponse")
    public String hello(
        @WebParam(name = "name", targetNamespace = "")
        String name);

}
