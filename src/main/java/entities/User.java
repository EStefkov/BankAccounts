package entities;

/*в ентитиес създаваме управляем клас  който да събира 
 * информация за  потребителя
 *  */
public class User {

    private int id; // Added id field
    private String titularNames;
    private String currency;
    private double currentBalance;
    private double interestRate;
    private int openingYear;
    private String accountType;

    public User(String titularNames, String currency, double currentBalance, double interestRate, int openingYear,
            String accountType) {
        super();
        this.titularNames = titularNames;
        this.currency = currency;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
        this.openingYear = openingYear;
        this.accountType = accountType;
    }

    public User() {
        super();
    }

    public int getId() { // Added this getter
        return id;
    }

    public void setId(int id) { // Added this setter
        this.id = id;
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
}
