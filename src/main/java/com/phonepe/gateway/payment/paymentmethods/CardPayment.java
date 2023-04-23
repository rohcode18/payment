package com.phonepe.gateway.payment.paymentmethods;

import com.phonepe.gateway.payment.model.IPaymentInput;
import com.phonepe.gateway.payment.model.IPaymentMethod;

public class CardPayment implements IPaymentMethod {


    private boolean isDisabled;

    private String id; // name

    private IPaymentInput paymentInput;

    public CardPayment(boolean isDisabled, String id,IPaymentInput paymentInput) {
        this.isDisabled = isDisabled;
        this.id = id;
        this.paymentInput = paymentInput;
    }

    @Override
    public void disablePaymentMethod(){
        this.isDisabled = true;
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
}
