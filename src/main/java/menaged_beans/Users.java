package menaged_beans;

import java.io.Serializable;
import java.util.Date;

import dao.Database;
import entities.User;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Users implements Serializable  {

    private String titularNames;
    private String currency;
    private double currentBalance;
    private double interestRate;
    private int openingYear;
    private String accountType;
    
    private Date date = new Date();

    public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitularNames() {
        return titularNames;
    }

    public void setTitularNames(String titularNames) {
        this.titularNames = titularNames;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    
    
    
    
    public int getOpeningYear() {
        return openingYear;
    }

    public void setOpeningYear(int openingYear) {
        this.openingYear = openingYear;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String send() {
        // Валидация на данните, ако е необходимо

        // Създаване на нов потребител
        User user = new User(titularNames, currency, currentBalance, interestRate, openingYear, accountType);

        // Добавяне на потребителя към базата данни
        Database.addUser(user);

        return "success"; // Върнете към подходяща страница, например "success"
    }
}