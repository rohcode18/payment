package com.phonepe.gateway.payment;

import com.phonepe.gateway.payment.model.Bank;
import com.phonepe.gateway.payment.model.IBankStatergy;
import com.phonepe.gateway.payment.model.PaymentGateway;

import java.util.List;
import java.util.Map;

public class WeightedStatergy implements IBankStatergy {

    PaymentGateway paymentGateway;

    public void modifyWight(Bank bank,Integer weight){

        this.paymentGateway.bankweightMap.put(bank,weight);

    }

    public Map<Bank, Integer> getBankweightMap() {
        return this.paymentGateway.bankweightMap;
    }

    public void setBankweightMap(Map<Bank, Integer> bankweightMap) {
        this.paymentGateway.bankweightMap = bankweightMap;
    }

    @Override
    public Bank getBankByWight(List<Bank> bankList) {
        Bank bank = null;

        Integer bestWeight = -10000;
        for(Bank bank1 : bankList){
            if(bestWeight< this.paymentGateway.bankweightMap.get(bank1)){
                bank = bank1;
            }
        }
        return bank;
    }
}
