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

    private int userId; // Add this field
    private String titularNames;
    private String currency;
    private double currentBalance;
    private double interestRate;
    private int openingYear;
    private String accountType;
    private double amount;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() { // Add this getter
        return userId;
    }

    public void setUserId(int userId) { // Add this setter
        this.userId = userId;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
    public String addBalance() {
        Gson gson = new Gson();
        User user = Database.getUserById(this.userId);
        if (user != null) {
            user.setCurrentBalance(user.getCurrentBalance() + this.amount);
            Database.updateUser(user);
            return gson.toJson("success");
        } else {
            return gson.toJson("failure");
        }
    }
    
    @POST
    @Path("/getUserById")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById() {
        Gson gson = new Gson();
        User user = Database.getUserById(this.userId);
        if (user != null) {
            return gson.toJson(user);
        } else {
            return gson.toJson("User not found");
        }
    }
    

    public void send() {
        User user = new User(titularNames, currency, currentBalance, interestRate, openingYear, accountType);
        Database.addUser(user);
    }
}

class BalanceUpdate {
    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
