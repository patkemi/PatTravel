package com.example.pattravel;

public class Bus {

    private String townOne;
    private String townTwo;
    private String transport;
    private String dollar;

    public Bus(String townOne, String townTwo, String transport, String dollar) {
        this.townOne = townOne;
        this.townTwo = townTwo;
        this.transport = transport;
        this.dollar = dollar;
    }

    public String getTownOne() {
        return townOne;
    }

    public void setTownOne(String townOne) {
        this.townOne = townOne;
    }

    public String getTownTwo() {
        return townTwo;
    }

    public void setTownTwo(String townTwo) {
        this.townTwo = townTwo;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getDollar() {
        return dollar;
    }

    public void setDollar(String dollar) {
        this.dollar = dollar;
    }
}


