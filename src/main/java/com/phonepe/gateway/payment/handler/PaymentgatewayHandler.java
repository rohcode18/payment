package com.phonepe.gateway.payment.handler;

import com.phonepe.gateway.payment.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentgatewayHandler {


    private PaymentGateway paymentGateway;

    public PaymentgatewayHandler(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }

    public void addClient(String clientId, List<String> paymentMethodIds,String clientName){
        List<IPaymentMethod> supportedPaymentMethods = new ArrayList<>();
        for(IPaymentMethod paymentMethod : paymentGateway.getPaymentStatergies()){
            if(paymentMethodIds.contains(paymentMethod.getId())){
                supportedPaymentMethods.add(paymentMethod);
            }
        }

        Client client = new Client(clientId,clientName,supportedPaymentMethods);
        paymentGateway.getClientList().add(client);

    }

    public void disableClient(Client client){
        if(hasClient(client.getClientId()))
         paymentGateway.getClientList().remove(client);


    }

    public Client getClientById(String id){
        List<Client> clients =paymentGateway.getClientList();
        for (Client client : clients){
            if(client.getClientId().equals(id)){
                return client;
            }
        }
        return null;
    }

    public boolean hasClient(String  clientId){ // handled null

         Client client = getClientById(clientId);
         if(client.isDisabled()){
             return false;
         }
         return true;

    }

    public List<IPaymentMethod> supportedPaymentMethods(){

        return paymentGateway.getPaymentStatergies();

    }

    public boolean addSupportForPaymode(IPaymentMethod paymentMethod){

        return paymentGateway.getPaymentStatergies().add(paymentMethod);

    }

    public void removePaymode(String paymentMethodId){

         List<IPaymentMethod> paymentMethods = paymentGateway.getPaymentStatergies();

         for (IPaymentMethod paymentMethod : paymentMethods){
             if(paymentMethod.getId().equals(paymentMethodId));
             paymentMethod.disablePaymentMethod();
         }
         paymentGateway.setPaymentStatergies(paymentMethods);

    }

    public List<Bank> getBanks(IPaymentMethod paymentMethod){

        List<Bank> bankList = paymentGateway.getSubscribedBanks();
        List<Bank> banks =new ArrayList<>();
        for (Bank bank : bankList){
            bank.getAcceptedPaymentMethods().contains(paymentMethod);
            banks.add(bank);
        }
        return banks;
    }

    public void changeWeightBank(Bank bank , Integer wei){
        this.paymentGateway.bankweightMap.put(bank,this.paymentGateway.bankweightMap.get(bank)+wei);
    }

    public Map<Bank,Integer> getStatergy(){
        return paymentGateway.bankweightMap;
    }





}
