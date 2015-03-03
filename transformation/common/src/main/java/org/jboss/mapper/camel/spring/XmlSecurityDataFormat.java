//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.26 at 02:37:57 PM EST 
//


package org.jboss.mapper.camel.spring;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for xmlSecurityDataFormat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="xmlSecurityDataFormat">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/spring}dataFormat">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="xmlCipherAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="passPhrase" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="secureTag" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="secureTagContents" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="keyCipherAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="recipientKeyAlias" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="keyOrTrustStoreParametersId" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="keyPassword" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="digestAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mgfAlgorithm" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlSecurityDataFormat")
public class XmlSecurityDataFormat
    extends DataFormat
{

    @XmlAttribute(name = "xmlCipherAlgorithm")
    protected String xmlCipherAlgorithm;
    @XmlAttribute(name = "passPhrase")
    protected String passPhrase;
    @XmlAttribute(name = "secureTag")
    protected String secureTag;
    @XmlAttribute(name = "secureTagContents")
    protected Boolean secureTagContents;
    @XmlAttribute(name = "keyCipherAlgorithm")
    protected String keyCipherAlgorithm;
    @XmlAttribute(name = "recipientKeyAlias")
    protected String recipientKeyAlias;
    @XmlAttribute(name = "keyOrTrustStoreParametersId")
    protected String keyOrTrustStoreParametersId;
    @XmlAttribute(name = "keyPassword")
    protected String keyPassword;
    @XmlAttribute(name = "digestAlgorithm")
    protected String digestAlgorithm;
    @XmlAttribute(name = "mgfAlgorithm")
    protected String mgfAlgorithm;

    /**
     * Gets the value of the xmlCipherAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlCipherAlgorithm() {
        return xmlCipherAlgorithm;
    }

    /**
     * Sets the value of the xmlCipherAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlCipherAlgorithm(String value) {
        this.xmlCipherAlgorithm = value;
    }

    /**
     * Gets the value of the passPhrase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassPhrase() {
        return passPhrase;
    }

    /**
     * Sets the value of the passPhrase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassPhrase(String value) {
        this.passPhrase = value;
    }

    /**
     * Gets the value of the secureTag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecureTag() {
        return secureTag;
    }

    /**
     * Sets the value of the secureTag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecureTag(String value) {
        this.secureTag = value;
    }

    /**
     * Gets the value of the secureTagContents property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSecureTagContents() {
        return secureTagContents;
    }

    /**
     * Sets the value of the secureTagContents property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSecureTagContents(Boolean value) {
        this.secureTagContents = value;
    }

    /**
     * Gets the value of the keyCipherAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyCipherAlgorithm() {
        return keyCipherAlgorithm;
    }

    /**
     * Sets the value of the keyCipherAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyCipherAlgorithm(String value) {
        this.keyCipherAlgorithm = value;
    }

    /**
     * Gets the value of the recipientKeyAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientKeyAlias() {
        return recipientKeyAlias;
    }

    /**
     * Sets the value of the recipientKeyAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientKeyAlias(String value) {
        this.recipientKeyAlias = value;
    }

    /**
     * Gets the value of the keyOrTrustStoreParametersId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyOrTrustStoreParametersId() {
        return keyOrTrustStoreParametersId;
    }

    /**
     * Sets the value of the keyOrTrustStoreParametersId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyOrTrustStoreParametersId(String value) {
        this.keyOrTrustStoreParametersId = value;
    }

    /**
     * Gets the value of the keyPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyPassword() {
        return keyPassword;
    }

    /**
     * Sets the value of the keyPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyPassword(String value) {
        this.keyPassword = value;
    }

    /**
     * Gets the value of the digestAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigestAlgorithm() {
        return digestAlgorithm;
    }

    /**
     * Sets the value of the digestAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigestAlgorithm(String value) {
        this.digestAlgorithm = value;
    }

    /**
     * Gets the value of the mgfAlgorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMgfAlgorithm() {
        return mgfAlgorithm;
    }

    /**
     * Sets the value of the mgfAlgorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMgfAlgorithm(String value) {
        this.mgfAlgorithm = value;
    }

}
