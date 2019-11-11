package com.lavasoft;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.4
 * 2019-11-11T10:21:15.495+04:00
 * Generated source version: 3.3.4
 *
 */
@WebService(targetNamespace = "http://lavasoft.com/", name = "GeoIPServiceHttpGet")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface GeoIPServiceHttpGet {

    /**
     * <br/>Get Country Name by Country ISO2 code<br/>Paramater:Country Code &nbsp;&nbsp;<b>Type:String<b/><br/>Country code  format is ALPHA-2 (CA - for Canada)
     */
    @WebMethod(operationName = "GetCountryNameByISO2")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public java.lang.String getCountryNameByISO2(

        @WebParam(partName = "iso2Code", name = "iso2Code", targetNamespace = "")
        java.lang.String iso2Code
    );

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     */
    @WebMethod(operationName = "GetLocation")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public java.lang.String getLocation()
;

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b>
     */
    @WebMethod(operationName = "GetIpLocation")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public java.lang.String getIpLocation(

        @WebParam(partName = "sIp", name = "sIp", targetNamespace = "")
        java.lang.String sIp
    );

    /**
     * <br/>Get Country ISO2 code by Country Name<br/>Paramater:Country Name &nbsp;&nbsp;<b>Type:String<b/>
     */
    @WebMethod(operationName = "GetCountryISO2ByName")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public java.lang.String getCountryISO2ByName(

        @WebParam(partName = "countryName", name = "countryName", targetNamespace = "")
        java.lang.String countryName
    );

    /**
     * <br/>Get Country and State XML String for a given ip address in x.x.x.x format<br/><br/>Parameter:GetIpAddress address &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b><br/><br/>Return:format in XML < GeoIP >< Country >US< /Country >< State >PA< /State >< /GeoIP > &nbsp;&nbsp;&nbsp;&nbsp;<b>Type:String</b> or <b>string empty</b> 
     */
    @WebMethod(operationName = "GetIpLocation_2_0")
    @WebResult(name = "string", targetNamespace = "http://lavasoft.com/", partName = "Body")
    public java.lang.String getIpLocation20(

        @WebParam(partName = "sIp", name = "sIp", targetNamespace = "")
        java.lang.String sIp
    );
}