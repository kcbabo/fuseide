//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.02.13 at 12:09:41 PM EST 
//


package org.jboss.mapper.camel.blueprint;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for toDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="toDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/blueprint}sendDefinition">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="pattern" type="{http://camel.apache.org/schema/blueprint}exchangePattern" />
 *       &lt;anyAttribute processContents='skip' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "toDefinition")
public class ToDefinition
    extends SendDefinition
{

    @XmlAttribute(name = "pattern")
    protected ExchangePattern pattern;

    /**
     * Gets the value of the pattern property.
     * 
     * @return
     *     possible object is
     *     {@link ExchangePattern }
     *     
     */
    public ExchangePattern getPattern() {
        return pattern;
    }

    /**
     * Sets the value of the pattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExchangePattern }
     *     
     */
    public void setPattern(ExchangePattern value) {
        this.pattern = value;
    }

}
