package com.phonepe.gateway.payment.paymentmethods;

import com.phonepe.gateway.payment.model.IPaymentInput;
import com.phonepe.gateway.payment.model.IPaymentMethod;

public class UpiPayment implements IPaymentMethod {

    private boolean isDisabled;

    private String id;

    private IPaymentInput paymentInput;

    public UpiPayment(boolean isDisabled, String i,IPaymentInput paymentInput) {
        this.isDisabled = isDisabled;
        this.id = id;
        this.paymentInput = paymentInput;
    }

    public boolean isDisabled() {
        return isDisabled;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void disablePaymentMethod(){
        this.isDisabled = true;
    }


}
