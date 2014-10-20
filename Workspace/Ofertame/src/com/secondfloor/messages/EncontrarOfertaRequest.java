/**
 * EncontrarOfertaRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.secondfloor.messages;

public class EncontrarOfertaRequest  implements java.io.Serializable {
    private java.lang.String bairro;

    private java.lang.String produto;

    private java.lang.String tipoProduto;

    public EncontrarOfertaRequest() {
    }

    public EncontrarOfertaRequest(
           java.lang.String bairro,
           java.lang.String produto,
           java.lang.String tipoProduto) {
           this.bairro = bairro;
           this.produto = produto;
           this.tipoProduto = tipoProduto;
    }


    /**
     * Gets the bairro value for this EncontrarOfertaRequest.
     * 
     * @return bairro
     */
    public java.lang.String getBairro() {
        return bairro;
    }


    /**
     * Sets the bairro value for this EncontrarOfertaRequest.
     * 
     * @param bairro
     */
    public void setBairro(java.lang.String bairro) {
        this.bairro = bairro;
    }


    /**
     * Gets the produto value for this EncontrarOfertaRequest.
     * 
     * @return produto
     */
    public java.lang.String getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this EncontrarOfertaRequest.
     * 
     * @param produto
     */
    public void setProduto(java.lang.String produto) {
        this.produto = produto;
    }


    /**
     * Gets the tipoProduto value for this EncontrarOfertaRequest.
     * 
     * @return tipoProduto
     */
    public java.lang.String getTipoProduto() {
        return tipoProduto;
    }


    /**
     * Sets the tipoProduto value for this EncontrarOfertaRequest.
     * 
     * @param tipoProduto
     */
    public void setTipoProduto(java.lang.String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EncontrarOfertaRequest)) return false;
        EncontrarOfertaRequest other = (EncontrarOfertaRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bairro==null && other.getBairro()==null) || 
             (this.bairro!=null &&
              this.bairro.equals(other.getBairro()))) &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.tipoProduto==null && other.getTipoProduto()==null) || 
             (this.tipoProduto!=null &&
              this.tipoProduto.equals(other.getTipoProduto())));
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
        if (getBairro() != null) {
            _hashCode += getBairro().hashCode();
        }
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getTipoProduto() != null) {
            _hashCode += getTipoProduto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }
}
