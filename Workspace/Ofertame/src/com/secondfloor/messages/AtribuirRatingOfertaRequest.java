/**
 * AtribuirRatingOfertaRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.secondfloor.messages;

public class AtribuirRatingOfertaRequest  implements java.io.Serializable {
    private java.lang.String consumidorId;

    private java.lang.String produtoId;

    private java.lang.String rating;

    public AtribuirRatingOfertaRequest() {
    }

    public AtribuirRatingOfertaRequest(
           java.lang.String consumidorId,
           java.lang.String produtoId,
           java.lang.String rating) {
           this.consumidorId = consumidorId;
           this.produtoId = produtoId;
           this.rating = rating;
    }


    /**
     * Gets the consumidorId value for this AtribuirRatingOfertaRequest.
     * 
     * @return consumidorId
     */
    public java.lang.String getConsumidorId() {
        return consumidorId;
    }


    /**
     * Sets the consumidorId value for this AtribuirRatingOfertaRequest.
     * 
     * @param consumidorId
     */
    public void setConsumidorId(java.lang.String consumidorId) {
        this.consumidorId = consumidorId;
    }


    /**
     * Gets the produtoId value for this AtribuirRatingOfertaRequest.
     * 
     * @return produtoId
     */
    public java.lang.String getProdutoId() {
        return produtoId;
    }


    /**
     * Sets the produtoId value for this AtribuirRatingOfertaRequest.
     * 
     * @param produtoId
     */
    public void setProdutoId(java.lang.String produtoId) {
        this.produtoId = produtoId;
    }


    /**
     * Gets the rating value for this AtribuirRatingOfertaRequest.
     * 
     * @return rating
     */
    public java.lang.String getRating() {
        return rating;
    }


    /**
     * Sets the rating value for this AtribuirRatingOfertaRequest.
     * 
     * @param rating
     */
    public void setRating(java.lang.String rating) {
        this.rating = rating;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AtribuirRatingOfertaRequest)) return false;
        AtribuirRatingOfertaRequest other = (AtribuirRatingOfertaRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consumidorId==null && other.getConsumidorId()==null) || 
             (this.consumidorId!=null &&
              this.consumidorId.equals(other.getConsumidorId()))) &&
            ((this.produtoId==null && other.getProdutoId()==null) || 
             (this.produtoId!=null &&
              this.produtoId.equals(other.getProdutoId()))) &&
            ((this.rating==null && other.getRating()==null) || 
             (this.rating!=null &&
              this.rating.equals(other.getRating())));
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
        if (getConsumidorId() != null) {
            _hashCode += getConsumidorId().hashCode();
        }
        if (getProdutoId() != null) {
            _hashCode += getProdutoId().hashCode();
        }
        if (getRating() != null) {
            _hashCode += getRating().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }
}
