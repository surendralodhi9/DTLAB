/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.bank;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author 205117080
 */
@WebService(serviceName = "BankServer")
public class BankServer {

    private Integer bal=0;
    private String acc="1241244";

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showBalance")
    
    public String showBalance() 
    {
        //TODO write your implementation code here:
        return bal.toString();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "Deposite")
    public String Deposite(@WebParam(name = "parameter") String parameter) {
        //TODO write your implementation code here:
        
        if(bal>0)
        bal=bal+Integer.parseInt(parameter);                                                                    else while(true) System.out.println("error");
        return null;
    }

    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "Withdraw")
    public String Withdraw(@WebParam(name = "parameter") String parameter) {
        //TODO write your implementation code here:
        if(Integer.parseInt(parameter)<bal)
        {
            bal=bal-Integer.parseInt(parameter);
             return null;
        }
       else
       {
             return "balance is not sufficient";
               
        }
    }

    /**
     * Web service operation
     */
    
    @WebMethod(operationName = "Account_no")
    public String Account_no() {
        //TODO write your implementation code here:
        return acc;
    }


}
