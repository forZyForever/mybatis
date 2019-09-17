package com.Nintendo.mybatis.domain;

public class Card {
  private Integer cid;
  private String cardNumber;
  private String   cardAddress;

    public Card() {
    }

    public Card(Integer cid, String cardNumber, String cardAddress) {
        this.cid = cid;
        this.cardNumber = cardNumber;
        this.cardAddress = cardAddress;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(String cardAddress) {
        this.cardAddress = cardAddress;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cid=" + cid +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardAddress='" + cardAddress + '\'' +
                '}';
    }
}
