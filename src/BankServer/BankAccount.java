package BankServer;

import Shared.Address;
import Shared.Transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * InternetBankieren Created by Sven de Vries on 1-12-2017
 */
public class BankAccount {
    private double amount;
    private String iban;
    private String firstName;
    private String lastName;
    private String postalCode;
    private int houseNumber;
    private Date dateOfBirth;
    private String email;
    private double limitInAddressbook;
    private double limitOutAddressbook;
    private ArrayList<Address> addressbook;
    private ArrayList<Transaction> transactionHistory;

    public double getAmount() {
        return amount;
    }

    public String getIban() {
        return iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public double getLimitInAddressbook() {
        return limitInAddressbook;
    }

    public double getLimitOutAddressbook() {
        return limitOutAddressbook;
    }

    public List<Address> getAddressbook() {
        return Collections.unmodifiableList(addressbook);
    }

    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(transactionHistory);
    }

    public BankAccount(double amount, String iban, String firstName, String lastName, String postalCode, int houseNumber, Date dateOfBirth, String email, double limitIn, double limitOut) {
        this.amount = amount;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.limitInAddressbook = limitIn;
        this.limitOutAddressbook = limitOut;
        this.addressbook = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }

    public void editAccount(String firstName, String lastName, String postalCode, int houseNumber, Date dateOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public void editLimits(double limitIn, double limitOut) {
        this.limitInAddressbook = limitIn;
        this.limitOutAddressbook = limitOut;
    }

    public void addAddress(Address address) {
        this.addressbook.add(address);
    }

    public void deleteAddress(Address address) {
        for (Address a : addressbook) {
            if (a.getIban().equals(address.getIban())) {
                this.addressbook.remove(a);
                break;
            }
        }
    }

    public void addTransaction(Transaction transaction) {
        this.transactionHistory.add(transaction);
    }

    public void makeTransaction(String nameReceiver, Transaction transaction, boolean addToAddress) {
        changeAmount(transaction.getAmount());
        transactionHistory.add(transaction);

        if (addToAddress) {
            addressbook.add(new Address(nameReceiver, transaction.getIban()));
        }
    }

    public boolean makeRequest(double amount, String name, String ibanReceiver, String description, boolean addToAddress) {
        return false;
    }

    public void receiveTransaction(Transaction transaction) {
        changeAmount(transaction.getAmount());
        transactionHistory.add(transaction);
    }

    public void changeAmount(double amount) {
        this.amount += amount;
    }
}
