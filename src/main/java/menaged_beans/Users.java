package menaged_beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import dao.Database;
import entities.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@SessionScoped
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
    
    public ArrayList<User> getUsers() {
        return Database.getUsers();
    }

    public void send() {
       
        User user = new User(titularNames, currency, currentBalance, interestRate, openingYear, accountType);

        
        Database.addUser(user);

        //smenqme void na string return "success"; // 
    }
}