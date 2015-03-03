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
 * <p>Java class for camelPropertyPlaceholderDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="camelPropertyPlaceholderDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://camel.apache.org/schema/blueprint}identifiedType">
 *       &lt;sequence>
 *       &lt;/sequence>
 *       &lt;attribute name="location" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cache" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="ignoreMissingLocation" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="propertiesResolverRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="propertiesParserRef" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="propertyPrefix" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="propertySuffix" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fallbackToUnaugmentedProperty" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="prefixToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="suffixToken" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "camelPropertyPlaceholderDefinition")
public class CamelPropertyPlaceholderDefinition
    extends IdentifiedType
{

    @XmlAttribute(name = "location", required = true)
    protected String location;
    @XmlAttribute(name = "cache")
    protected Boolean cache;
    @XmlAttribute(name = "ignoreMissingLocation")
    protected Boolean ignoreMissingLocation;
    @XmlAttribute(name = "propertiesResolverRef")
    protected String propertiesResolverRef;
    @XmlAttribute(name = "propertiesParserRef")
    protected String propertiesParserRef;
    @XmlAttribute(name = "propertyPrefix")
    protected String propertyPrefix;
    @XmlAttribute(name = "propertySuffix")
    protected String propertySuffix;
    @XmlAttribute(name = "fallbackToUnaugmentedProperty")
    protected Boolean fallbackToUnaugmentedProperty;
    @XmlAttribute(name = "prefixToken")
    protected String prefixToken;
    @XmlAttribute(name = "suffixToken")
    protected String suffixToken;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the cache property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCache() {
        return cache;
    }

    /**
     * Sets the value of the cache property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCache(Boolean value) {
        this.cache = value;
    }

    /**
     * Gets the value of the ignoreMissingLocation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreMissingLocation() {
        return ignoreMissingLocation;
    }

    /**
     * Sets the value of the ignoreMissingLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreMissingLocation(Boolean value) {
        this.ignoreMissingLocation = value;
    }

    /**
     * Gets the value of the propertiesResolverRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertiesResolverRef() {
        return propertiesResolverRef;
    }

    /**
     * Sets the value of the propertiesResolverRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertiesResolverRef(String value) {
        this.propertiesResolverRef = value;
    }

    /**
     * Gets the value of the propertiesParserRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertiesParserRef() {
        return propertiesParserRef;
    }

    /**
     * Sets the value of the propertiesParserRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertiesParserRef(String value) {
        this.propertiesParserRef = value;
    }

    /**
     * Gets the value of the propertyPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertyPrefix() {
        return propertyPrefix;
    }

    /**
     * Sets the value of the propertyPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertyPrefix(String value) {
        this.propertyPrefix = value;
    }

    /**
     * Gets the value of the propertySuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPropertySuffix() {
        return propertySuffix;
    }

    /**
     * Sets the value of the propertySuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPropertySuffix(String value) {
        this.propertySuffix = value;
    }

    /**
     * Gets the value of the fallbackToUnaugmentedProperty property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFallbackToUnaugmentedProperty() {
        return fallbackToUnaugmentedProperty;
    }

    /**
     * Sets the value of the fallbackToUnaugmentedProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFallbackToUnaugmentedProperty(Boolean value) {
        this.fallbackToUnaugmentedProperty = value;
    }

    /**
     * Gets the value of the prefixToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefixToken() {
        return prefixToken;
    }

    /**
     * Sets the value of the prefixToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefixToken(String value) {
        this.prefixToken = value;
    }

    /**
     * Gets the value of the suffixToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSuffixToken() {
        return suffixToken;
    }

    /**
     * Sets the value of the suffixToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSuffixToken(String value) {
        this.suffixToken = value;
    }

}
