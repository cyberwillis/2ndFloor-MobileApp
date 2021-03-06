/**
 * EncontrarOfertaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.secondfloor.messages;

public class EncontrarOfertaResponse  implements java.io.Serializable {
    private java.lang.String message;

    private com.secondfloor.dto.OfertaDTO[] ofertas;

    private java.lang.Boolean success;

    public EncontrarOfertaResponse() {
    }

    public EncontrarOfertaResponse(
           java.lang.String message,
           com.secondfloor.dto.OfertaDTO[] ofertas,
           java.lang.Boolean success) {
           this.message = message;
           this.ofertas = ofertas;
           this.success = success;
    }


    /**
     * Gets the message value for this EncontrarOfertaResponse.
     * 
     * @return message
     */
    public java.lang.String getMessage() {
        return message;
    }


    /**
     * Sets the message value for this EncontrarOfertaResponse.
     * 
     * @param message
     */
    public void setMessage(java.lang.String message) {
        this.message = message;
    }


    /**
     * Gets the ofertas value for this EncontrarOfertaResponse.
     * 
     * @return ofertas
     */
    public com.secondfloor.dto.OfertaDTO[] getOfertas() {
        return ofertas;
    }


    /**
     * Sets the ofertas value for this EncontrarOfertaResponse.
     * 
     * @param ofertas
     */
    public void setOfertas(com.secondfloor.dto.OfertaDTO[] ofertas) {
        this.ofertas = ofertas;
    }


    /**
     * Gets the success value for this EncontrarOfertaResponse.
     * 
     * @return success
     */
    public java.lang.Boolean getSuccess() {
        return success;
    }


    /**
     * Sets the success value for this EncontrarOfertaResponse.
     * 
     * @param success
     */
    public void setSuccess(java.lang.Boolean success) {
        this.success = success;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EncontrarOfertaResponse)) return false;
        EncontrarOfertaResponse other = (EncontrarOfertaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.message==null && other.getMessage()==null) || 
             (this.message!=null &&
              this.message.equals(other.getMessage()))) &&
            ((this.ofertas==null && other.getOfertas()==null) || 
             (this.ofertas!=null &&
              java.util.Arrays.equals(this.ofertas, other.getOfertas()))) &&
            ((this.success==null && other.getSuccess()==null) || 
             (this.success!=null &&
              this.success.equals(other.getSuccess())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getOfertas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getOfertas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getOfertas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSuccess() != null) {
            _hashCode += getSuccess().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }


}
