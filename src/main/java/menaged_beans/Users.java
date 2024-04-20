package menaged_beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import dao.Database;
import entities.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import com.google.gson.Gson;

@Named
@SessionScoped
public class Users implements Serializable {

    private String titularNames;
    private String currency;
    private double currentBalance;
    private double interestRate;
    private int openingYear;
    private String accountType;
    private double amount; // Added this field

    private Date date;

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

    public double getAmount() { // Added this getter
        return amount;
    }

    public void setAmount(double amount) { // Added this setter
        this.amount = amount;
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<User> getUsers() {
        return Database.getUsers();
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addUser(String json) {
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        Database.addUser(user);
        return gson.toJson("success");
    }

    @POST
    @Path("/addBalance")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addBalance() { // Removed the parameter here
        Gson gson = new Gson();
        User user = Database.getUserByTitularNames(this.titularNames);
        if (user != null) {
            user.setCurrentBalance(user.getCurrentBalance() + this.amount);
            Database.updateUser(user);
            return gson.toJson("success");
        } else {
            return gson.toJson("failure");
        }
    }

    public void send() {
        User user = new User(titularNames, currency, currentBalance, interestRate, openingYear, accountType);
        Database.addUser(user);
        // return "success";
    }
}

class BalanceUpdate {
    private String titularNames;
    private double amount;

    public String getTitularNames() {
        return titularNames;
    }

    public void setTitularNames(String titularNames) {
        this.titularNames = titularNames;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}