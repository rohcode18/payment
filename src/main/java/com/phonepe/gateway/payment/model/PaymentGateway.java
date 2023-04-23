package com.phonepe.gateway.payment.model;

import java.util.List;
import java.util.Map;

public class PaymentGateway {

    private String id;

    List<Bank> subscribedBanks;

    List<IPaymentMethod> paymentStatergies;

    List<Client> clientList;

    public Map<Bank,Integer> bankweightMap;



    public PaymentGateway(String id, List<Bank> subscribedBanks, List<IPaymentMethod> paymentStatergies) {
        this.id = id;
        this.subscribedBanks = subscribedBanks;
        this.paymentStatergies = paymentStatergies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Bank> getSubscribedBanks() {
        return subscribedBanks;
    }

    public void setSubscribedBanks(List<Bank> subscribedBanks) {
        this.subscribedBanks = subscribedBanks;
    }

    public List<IPaymentMethod> getPaymentStatergies() {
        return paymentStatergies;
    }

    public void setPaymentStatergies(List<IPaymentMethod> paymentStatergies) {
        this.paymentStatergies = paymentStatergies;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
