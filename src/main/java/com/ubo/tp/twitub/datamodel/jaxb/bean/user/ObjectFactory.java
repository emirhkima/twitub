//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0-b52-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.22 at 01:32:54 PM CET 
//

package com.ubo.tp.twitub.datamodel.jaxb.bean.user;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.ubo.tp.twitub.datamodel.jaxb.bean.user.UserXml;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the main.java.com.ubo.tp.twitub.jaxb.bean.user package.
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

	private final static QName _User_QNAME = new QName("http://www.example.org/twit/", "User");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: main.java.com.ubo.tp.twitub.jaxb.bean.user
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link UserXml }
	 * 
	 */
	public UserXml createUserXml() {
		return new UserXml();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link UserXml }
	 * {@code >}}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.example.org/twit/", name = "User")
	public JAXBElement<UserXml> createUser(UserXml value) {
		return new JAXBElement<UserXml>(_User_QNAME, UserXml.class, null, value);
	}

}
