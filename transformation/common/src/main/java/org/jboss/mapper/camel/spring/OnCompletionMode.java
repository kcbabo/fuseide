//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.26 at 02:37:57 PM EST 
//


package org.jboss.mapper.camel.spring;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for onCompletionMode.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="onCompletionMode">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="AfterConsumer"/>
 *     &lt;enumeration value="BeforeConsumer"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "onCompletionMode")
@XmlEnum
public enum OnCompletionMode {

    @XmlEnumValue("AfterConsumer")
    AFTER_CONSUMER("AfterConsumer"),
    @XmlEnumValue("BeforeConsumer")
    BEFORE_CONSUMER("BeforeConsumer");
    private final String value;

    OnCompletionMode(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static OnCompletionMode fromValue(String v) {
        for (OnCompletionMode c: OnCompletionMode.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
