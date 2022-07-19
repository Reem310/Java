public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        System.out.println("\nNumber of accounts: " + BankAccount.getNumberOfAccounts());
        account1.deposit("checking",10);
        account1.deposit("saving",10);
        System.out.printf("\nYour balance is $%.2f ",account1.totalMoney());
        account1.withdraw("saving",5);
        System.out.printf("\nYour balance is $%.2f ",account1.totalMoney());
        account1.withdraw("checking",5);
        System.out.printf("\nYour balance is: $%.2f ",account1.totalMoney());
        account2.deposit("saving",9);
        account2.deposit("saving",9);
        System.out.printf("\nYour balance is: $%.2f ",account2.totalMoney());
        System.out.println("\nTotal amount of money: " + BankAccount.getTotal());

    }
}