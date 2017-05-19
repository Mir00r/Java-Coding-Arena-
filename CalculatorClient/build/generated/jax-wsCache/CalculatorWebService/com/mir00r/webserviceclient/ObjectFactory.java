
package com.mir00r.webserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.mir00r.webserviceclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Hello_QNAME = new QName("http://javawebservice.mir00r.com/", "hello");
    private final static QName _DivideIntegersResponse_QNAME = new QName("http://javawebservice.mir00r.com/", "DivideIntegersResponse");
    private final static QName _MultiplyIntegersResponse_QNAME = new QName("http://javawebservice.mir00r.com/", "MultiplyIntegersResponse");
    private final static QName _SubtractIntegers_QNAME = new QName("http://javawebservice.mir00r.com/", "SubtractIntegers");
    private final static QName _SubtractIntegersResponse_QNAME = new QName("http://javawebservice.mir00r.com/", "SubtractIntegersResponse");
    private final static QName _MultiplyIntegers_QNAME = new QName("http://javawebservice.mir00r.com/", "MultiplyIntegers");
    private final static QName _AddIntegers_QNAME = new QName("http://javawebservice.mir00r.com/", "AddIntegers");
    private final static QName _HelloResponse_QNAME = new QName("http://javawebservice.mir00r.com/", "helloResponse");
    private final static QName _AddIntegersResponse_QNAME = new QName("http://javawebservice.mir00r.com/", "AddIntegersResponse");
    private final static QName _DivideIntegers_QNAME = new QName("http://javawebservice.mir00r.com/", "DivideIntegers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.mir00r.webserviceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MultiplyIntegers }
     * 
     */
    public MultiplyIntegers createMultiplyIntegers() {
        return new MultiplyIntegers();
    }

    /**
     * Create an instance of {@link SubtractIntegers }
     * 
     */
    public SubtractIntegers createSubtractIntegers() {
        return new SubtractIntegers();
    }

    /**
     * Create an instance of {@link SubtractIntegersResponse }
     * 
     */
    public SubtractIntegersResponse createSubtractIntegersResponse() {
        return new SubtractIntegersResponse();
    }

    /**
     * Create an instance of {@link AddIntegersResponse }
     * 
     */
    public AddIntegersResponse createAddIntegersResponse() {
        return new AddIntegersResponse();
    }

    /**
     * Create an instance of {@link DivideIntegers }
     * 
     */
    public DivideIntegers createDivideIntegers() {
        return new DivideIntegers();
    }

    /**
     * Create an instance of {@link HelloResponse }
     * 
     */
    public HelloResponse createHelloResponse() {
        return new HelloResponse();
    }

    /**
     * Create an instance of {@link AddIntegers }
     * 
     */
    public AddIntegers createAddIntegers() {
        return new AddIntegers();
    }

    /**
     * Create an instance of {@link DivideIntegersResponse }
     * 
     */
    public DivideIntegersResponse createDivideIntegersResponse() {
        return new DivideIntegersResponse();
    }

    /**
     * Create an instance of {@link Hello }
     * 
     */
    public Hello createHello() {
        return new Hello();
    }

    /**
     * Create an instance of {@link MultiplyIntegersResponse }
     * 
     */
    public MultiplyIntegersResponse createMultiplyIntegersResponse() {
        return new MultiplyIntegersResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Hello }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "hello")
    public JAXBElement<Hello> createHello(Hello value) {
        return new JAXBElement<Hello>(_Hello_QNAME, Hello.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideIntegersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "DivideIntegersResponse")
    public JAXBElement<DivideIntegersResponse> createDivideIntegersResponse(DivideIntegersResponse value) {
        return new JAXBElement<DivideIntegersResponse>(_DivideIntegersResponse_QNAME, DivideIntegersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyIntegersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "MultiplyIntegersResponse")
    public JAXBElement<MultiplyIntegersResponse> createMultiplyIntegersResponse(MultiplyIntegersResponse value) {
        return new JAXBElement<MultiplyIntegersResponse>(_MultiplyIntegersResponse_QNAME, MultiplyIntegersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractIntegers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "SubtractIntegers")
    public JAXBElement<SubtractIntegers> createSubtractIntegers(SubtractIntegers value) {
        return new JAXBElement<SubtractIntegers>(_SubtractIntegers_QNAME, SubtractIntegers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubtractIntegersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "SubtractIntegersResponse")
    public JAXBElement<SubtractIntegersResponse> createSubtractIntegersResponse(SubtractIntegersResponse value) {
        return new JAXBElement<SubtractIntegersResponse>(_SubtractIntegersResponse_QNAME, SubtractIntegersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplyIntegers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "MultiplyIntegers")
    public JAXBElement<MultiplyIntegers> createMultiplyIntegers(MultiplyIntegers value) {
        return new JAXBElement<MultiplyIntegers>(_MultiplyIntegers_QNAME, MultiplyIntegers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIntegers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "AddIntegers")
    public JAXBElement<AddIntegers> createAddIntegers(AddIntegers value) {
        return new JAXBElement<AddIntegers>(_AddIntegers_QNAME, AddIntegers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HelloResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "helloResponse")
    public JAXBElement<HelloResponse> createHelloResponse(HelloResponse value) {
        return new JAXBElement<HelloResponse>(_HelloResponse_QNAME, HelloResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddIntegersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "AddIntegersResponse")
    public JAXBElement<AddIntegersResponse> createAddIntegersResponse(AddIntegersResponse value) {
        return new JAXBElement<AddIntegersResponse>(_AddIntegersResponse_QNAME, AddIntegersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DivideIntegers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://javawebservice.mir00r.com/", name = "DivideIntegers")
    public JAXBElement<DivideIntegers> createDivideIntegers(DivideIntegers value) {
        return new JAXBElement<DivideIntegers>(_DivideIntegers_QNAME, DivideIntegers.class, null, value);
    }

}
