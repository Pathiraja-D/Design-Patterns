package ProxyPattern;
// Protection proxy
// The protection proxy controls access to the original object.
// Used when there is different access rights to different users.
interface Account{
    void deposit(double amount);
    void withdraw(double amount);

}

//Real Subject
class RealAccount implements Account{
    private double balance = 0;
    @Override
    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited "+amount);
    }

    @Override
    public void withdraw(double amount){
        if(balance >= amount){
            balance -= amount;
            System.out.println("Withdrew "+amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}

class ProtectionProxyAccount implements Account{
    private RealAccount realAccount;
    private String username;

    public ProtectionProxyAccount(String username){
        this.username = username;
    }

    private void checkAccess(){

        //Admin has the full access
        if(!"Admin".equals(username)){
            throw new RuntimeException("Access denied");
        }
    }

    @Override
    public void deposit(double amount){
        checkAccess();
        if(realAccount == null)
        {
            realAccount = new RealAccount();
        }
        realAccount.deposit(amount);
    }

    @Override
    public void withdraw(double amount){
        checkAccess();
        if(realAccount == null)
        {
            realAccount = new RealAccount();
        }
        realAccount.withdraw(amount);
    }
}

public class ProtectionProxyPattern {
    public static void main (String[] args)
    {
        Account account = new ProtectionProxyAccount("Admin");
        account.deposit(100);
        account.withdraw(50);
        account.withdraw(100);
    }
}
