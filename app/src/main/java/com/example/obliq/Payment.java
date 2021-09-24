package com.example.obliq;

public class Payment {

    private String cardNumber;
    private String CVV;
    private String Expirydate;
    private String Cardtype;
    private String Name;
    private  String stuID;
    private String subject;

    public Payment() {
    }

    public Payment(String pname, String pcard, String pcvv, String pexpire,String psub) {
    }



    public Payment(String pname, String pcard,String pvisa,String pmaster, String pcvv, String pexpire) {
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCVV() {
        return CVV;
    }

    public void setCVV(String CVV) {
        this.CVV = CVV;
    }

    public String getExpirydate() {
        return Expirydate;
    }

    public void setExpirydate(String expirydate) {
        Expirydate = expirydate;
    }

    public String getCardtype() {
        return Cardtype;
    }

    public void setCardtype(String cardtype) {
        Cardtype = cardtype;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
