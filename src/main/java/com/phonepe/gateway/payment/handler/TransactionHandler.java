package com.phonepe.gateway.payment.handler;

import com.phonepe.gateway.payment.WeightedStatergy;
import com.phonepe.gateway.payment.model.*;

import java.util.List;

public class TransactionHandler {

    private PaymentgatewayHandler paymentgatewayHandler;

    private Client client;

    public TransactionHandler(PaymentGateway paymentGateway){
        this.paymentgatewayHandler = new PaymentgatewayHandler(paymentGateway);

    }
    public boolean makePayment(IPaymentMethod paymentMethod, Integer amount, IPaymentInput paymentInput){

        if(paymentgatewayHandler.hasClient(client.getClientId())){
            IBankStatergy bankStatergy = new WeightedStatergy();
            List<Bank> bankList = paymentgatewayHandler.getBanks(paymentMethod);

            Bank bank = bankStatergy.getBankByWight(bankList);
            boolean tranisactionResult =  bank.makePayment(amount);
            if(tranisactionResult){
                paymentgatewayHandler.changeWeightBank(bank,1);
            } else {
                paymentgatewayHandler.changeWeightBank(bank,-1);
            }

            return tranisactionResult;
        }

        return false;


    }


}
