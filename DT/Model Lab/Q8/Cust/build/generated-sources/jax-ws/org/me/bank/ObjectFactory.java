
package org.me.bank;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.bank package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AccountNo_QNAME = new QName("http://bank.me.org/", "Account_no");
    private final static QName _AccountNoResponse_QNAME = new QName("http://bank.me.org/", "Account_noResponse");
    private final static QName _ShowBalance_QNAME = new QName("http://bank.me.org/", "showBalance");
    private final static QName _Withdraw_QNAME = new QName("http://bank.me.org/", "Withdraw");
    private final static QName _WithdrawResponse_QNAME = new QName("http://bank.me.org/", "WithdrawResponse");
    private final static QName _Deposite_QNAME = new QName("http://bank.me.org/", "Deposite");
    private final static QName _ShowBalanceResponse_QNAME = new QName("http://bank.me.org/", "showBalanceResponse");
    private final static QName _DepositeResponse_QNAME = new QName("http://bank.me.org/", "DepositeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.bank
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Deposite }
     * 
     */
    public Deposite createDeposite() {
        return new Deposite();
    }

    /**
     * Create an instance of {@link ShowBalanceResponse }
     * 
     */
    public ShowBalanceResponse createShowBalanceResponse() {
        return new ShowBalanceResponse();
    }

    /**
     * Create an instance of {@link DepositeResponse }
     * 
     */
    public DepositeResponse createDepositeResponse() {
        return new DepositeResponse();
    }

    /**
     * Create an instance of {@link ShowBalance }
     * 
     */
    public ShowBalance createShowBalance() {
        return new ShowBalance();
    }

    /**
     * Create an instance of {@link Withdraw }
     * 
     */
    public Withdraw createWithdraw() {
        return new Withdraw();
    }

    /**
     * Create an instance of {@link WithdrawResponse }
     * 
     */
    public WithdrawResponse createWithdrawResponse() {
        return new WithdrawResponse();
    }

    /**
     * Create an instance of {@link AccountNo }
     * 
     */
    public AccountNo createAccountNo() {
        return new AccountNo();
    }

    /**
     * Create an instance of {@link AccountNoResponse }
     * 
     */
    public AccountNoResponse createAccountNoResponse() {
        return new AccountNoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountNo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "Account_no")
    public JAXBElement<AccountNo> createAccountNo(AccountNo value) {
        return new JAXBElement<AccountNo>(_AccountNo_QNAME, AccountNo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountNoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "Account_noResponse")
    public JAXBElement<AccountNoResponse> createAccountNoResponse(AccountNoResponse value) {
        return new JAXBElement<AccountNoResponse>(_AccountNoResponse_QNAME, AccountNoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "showBalance")
    public JAXBElement<ShowBalance> createShowBalance(ShowBalance value) {
        return new JAXBElement<ShowBalance>(_ShowBalance_QNAME, ShowBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Withdraw }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "Withdraw")
    public JAXBElement<Withdraw> createWithdraw(Withdraw value) {
        return new JAXBElement<Withdraw>(_Withdraw_QNAME, Withdraw.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WithdrawResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "WithdrawResponse")
    public JAXBElement<WithdrawResponse> createWithdrawResponse(WithdrawResponse value) {
        return new JAXBElement<WithdrawResponse>(_WithdrawResponse_QNAME, WithdrawResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Deposite }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "Deposite")
    public JAXBElement<Deposite> createDeposite(Deposite value) {
        return new JAXBElement<Deposite>(_Deposite_QNAME, Deposite.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "showBalanceResponse")
    public JAXBElement<ShowBalanceResponse> createShowBalanceResponse(ShowBalanceResponse value) {
        return new JAXBElement<ShowBalanceResponse>(_ShowBalanceResponse_QNAME, ShowBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepositeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://bank.me.org/", name = "DepositeResponse")
    public JAXBElement<DepositeResponse> createDepositeResponse(DepositeResponse value) {
        return new JAXBElement<DepositeResponse>(_DepositeResponse_QNAME, DepositeResponse.class, null, value);
    }

}
