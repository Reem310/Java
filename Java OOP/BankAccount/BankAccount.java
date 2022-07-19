class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private double total;
    private static int numberOfAccounts = 0;
    private static double totalMoneyAmount = 0;
    public BankAccount(){
        numberOfAccounts++;
    }
    public double getChecking() {
        return checkingBalance;
    }
    public double getSavings() {
        return savingsBalance;
    }
    public void deposit(String account, double amount){
        if (account.equals("checking")){
            checkingBalance += amount;
            totalMoneyAmount += amount;
            System.out.printf("Your Checking Balance After Depositing $%s is: $%.2f ", amount, checkingBalance);
        }
        else if(account.equals("saving")){
            savingsBalance += amount;
            totalMoneyAmount += amount;
            System.out.printf("\nYour Savings Balance After Depositing $%s is: $%.2f ",amount, savingsBalance);
        }
    }
    public void withdraw(String account, double amount){
        if (account.equals("checking") && amount <= checkingBalance){
            checkingBalance -= amount;
            totalMoneyAmount -= amount;
            System.out.printf("\nYour Checking Balance After Withdrawing $%s is: $%.2f", amount, checkingBalance);
        }
        else if(account.equals("saving") && amount <= savingsBalance){
            savingsBalance -= amount;
            System.out.printf("\nYour Savings Balance After Withdrawing $%s is: $%.2f",  amount, savingsBalance);
            totalMoneyAmount -= amount;
        }
        else{
            System.out.println("\nInsufficient funds.");
        }
    }
    public double totalMoney(){
        return total = checkingBalance+savingsBalance;
    }   
    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
    public static double getTotal(){
        return totalMoneyAmount;
    }
}