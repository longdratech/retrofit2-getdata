
package com.tuts.prakash.retrofittutorial.model;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class RetroPhoto {

    @SerializedName("amount")
    private Long mAmount;
    @SerializedName("color")
    private String mColor;
    @SerializedName("idproduct")
    private String mIdproduct;
    @SerializedName("img")
    private String mImg;
    @SerializedName("note")
    private String mNote;
    @SerializedName("price")
    private Long mPrice;
    @SerializedName("productname")
    private String mProductname;
    @SerializedName("retailprice")
    private Long mRetailprice;
    @SerializedName("type")
    private String mType;
    @SerializedName("__v")
    private Long m_V;
    @SerializedName("_id")
    private String m_id;

    private RetroPhoto(Long amount, String color, String idproduct, String img, String note, Long price, String productname, Long retailprice, String type, Long m_V, String m_id) {
        mAmount = amount;
        mColor = color;
        mIdproduct = idproduct;
        mImg = img;
        mNote = note;
        mPrice = price;
        mProductname = productname;
        mRetailprice = retailprice;
        mType = type;
        this.m_V = m_V;
        this.m_id = m_id;
    }

    public Long getAmount() {
        return mAmount;
    }

    public void setAmount(Long amount) {
        mAmount = amount;
    }

    public String getColor() {
        return mColor;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public String getIdproduct() {
        return mIdproduct;
    }

    public void setIdproduct(String idproduct) {
        mIdproduct = idproduct;
    }

    public String getImg() {
        return mImg;
    }

    public void setImg(String img) {
        mImg = img;
    }

    public String getNote() {
        return mNote;
    }

    public void setNote(String note) {
        mNote = note;
    }

    public Long getPrice() {
        return mPrice;
    }

    public void setPrice(Long price) {
        mPrice = price;
    }

    public String getProductname() {
        return mProductname;
    }

    public void setProductname(String productname) {
        mProductname = productname;
    }

    public Long getRetailprice() {
        return mRetailprice;
    }

    public void setRetailprice(Long retailprice) {
        mRetailprice = retailprice;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public Long get_V() {
        return m_V;
    }

    public void set_V(Long _V) {
        m_V = _V;
    }

    public String get_id() {
        return m_id;
    }

    public void set_id(String _id) {
        m_id = _id;
    }

}
