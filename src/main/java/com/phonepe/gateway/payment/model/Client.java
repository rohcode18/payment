package com.phonepe.gateway.payment.model;

import java.util.List;

public class Client {

    private String clientId;

    private String clientName;

    private boolean isDisabled;


    List<IPaymentMethod> subscribedPaymentMethods;

    public Client(String clientId, String clientName, List<IPaymentMethod> subscribedPaymentMethods) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.subscribedPaymentMethods = subscribedPaymentMethods;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public List<IPaymentMethod> getSubscribedPaymentMethods() {
        return subscribedPaymentMethods;
    }

    public void setSubscribedPaymentMethods(List<IPaymentMethod> subscribedPaymentMethods) {
        this.subscribedPaymentMethods = subscribedPaymentMethods;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
    }
}
