/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cust;

import java.util.Scanner;

/**
 *
 * @author dhirendra gurjar
 */
public class Cust {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1.Account no.\n" + "2.Deposite\n" + "3.Withdraw\n" + "4.Balance\n");
            System.out.println("enter your choice:");
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    try {
                        System.out.println(accountNo());
                    } catch (Exception e) {

                    }
                    break;
                }
                case 2: {
                    try {

                        System.out.println("enter the ammount");
                        String bal = sc.next();

                        System.out.println(deposite(bal));
                    } catch (Exception e) {

                    }
                    break;
                }
                case 3: {

                    try {

                        System.out.println("enter the ammount");
                        String bal = sc.next();
                        if (withdraw(bal) != null) {
                            System.out.println("Sorry! Insufficient balance");
                        }
                    } catch (Exception e) {

                    }
                    break;
                }
                case 4: {
                    try {

                        System.out.println(showBalance());
                    } catch (Exception e) {

                    }
                    break;
                }
            }

        }
        
    }

    private static String accountNo() {
        org.me.bank.BankServer_Service service = new org.me.bank.BankServer_Service();
        org.me.bank.BankServer port = service.getBankServerPort();
        return port.accountNo();
    }

    private static String deposite(java.lang.String parameter) {
        org.me.bank.BankServer_Service service = new org.me.bank.BankServer_Service();
        org.me.bank.BankServer port = service.getBankServerPort();
        return port.deposite(parameter);
    }

    private static String withdraw(java.lang.String parameter) {
        org.me.bank.BankServer_Service service = new org.me.bank.BankServer_Service();
        org.me.bank.BankServer port = service.getBankServerPort();
        return port.withdraw(parameter);
    }

    private static String showBalance() {
        org.me.bank.BankServer_Service service = new org.me.bank.BankServer_Service();
        org.me.bank.BankServer port = service.getBankServerPort();
        return port.showBalance();
    }
    
}
