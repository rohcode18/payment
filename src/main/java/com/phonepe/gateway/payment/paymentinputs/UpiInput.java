package com.phonepe.gateway.payment.paymentinputs;

public class UpiInput {

    private String uipId;

    public UpiInput(String uipId) {
        this.uipId = uipId;
    }

    public String getUipId() {
        return uipId;
    }

    public void setUipId(String uipId) {
        this.uipId = uipId;
    }
}
