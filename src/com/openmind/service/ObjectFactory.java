
package com.openmind.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.openmind.service package. 
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

    private final static QName _Send_QNAME = new QName("http://service.openmind.com/", "send");
    private final static QName _SendResponse_QNAME = new QName("http://service.openmind.com/", "sendResponse");
    private final static QName _SetMessageTextResponse_QNAME = new QName("http://service.openmind.com/", "setMessageTextResponse");
    private final static QName _SetMessageText_QNAME = new QName("http://service.openmind.com/", "setMessageText");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.openmind.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetMessageText }
     * 
     */
    public SetMessageText createSetMessageText() {
        return new SetMessageText();
    }

    /**
     * Create an instance of {@link SetMessageTextResponse }
     * 
     */
    public SetMessageTextResponse createSetMessageTextResponse() {
        return new SetMessageTextResponse();
    }

    /**
     * Create an instance of {@link SendResponse }
     * 
     */
    public SendResponse createSendResponse() {
        return new SendResponse();
    }

    /**
     * Create an instance of {@link Send }
     * 
     */
    public Send createSend() {
        return new Send();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Send }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.openmind.com/", name = "send")
    public JAXBElement<Send> createSend(Send value) {
        return new JAXBElement<Send>(_Send_QNAME, Send.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.openmind.com/", name = "sendResponse")
    public JAXBElement<SendResponse> createSendResponse(SendResponse value) {
        return new JAXBElement<SendResponse>(_SendResponse_QNAME, SendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMessageTextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.openmind.com/", name = "setMessageTextResponse")
    public JAXBElement<SetMessageTextResponse> createSetMessageTextResponse(SetMessageTextResponse value) {
        return new JAXBElement<SetMessageTextResponse>(_SetMessageTextResponse_QNAME, SetMessageTextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetMessageText }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.openmind.com/", name = "setMessageText")
    public JAXBElement<SetMessageText> createSetMessageText(SetMessageText value) {
        return new JAXBElement<SetMessageText>(_SetMessageText_QNAME, SetMessageText.class, null, value);
    }

}
