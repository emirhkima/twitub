//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.22 at 04:58:02 PM CET 
//

package com.ubo.tp.twitub.datamodel.jaxb.bean.twit;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.ubo.tp.twitub.datamodel.jaxb.bean.twit.TwitXml;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the main.java.com.ubo.tp.twitub.jaxb.bean.twit package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Twit_QNAME = new QName("http://www.example.org/twit/", "Twit");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: main.java.com.ubo.tp.twitub.jaxb.bean.twit
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link TwitXml }
	 * 
	 */
	public TwitXml createTwitXml() {
		return new TwitXml();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TwitXml }
	 * {@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.example.org/twit/", name = "Twit")
	public JAXBElement<TwitXml> createTwit(TwitXml value) {
		return new JAXBElement<TwitXml>(_Twit_QNAME, TwitXml.class, null, value);
	}

}
