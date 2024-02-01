package ProxyPattern;

interface Account{
    public void withdraw();

    void getAccountNumber();
}

class BankAccount implements Account{
    @Override
    public void withdraw(){

    }

    @Override
    public void getAccountNumber(){

    }
}

class ATMProxy implements Account{
    @Override
    public void withdraw(){
        BankAccount bankaccount = new BankAccount();
        bankaccount.withdraw();
    }

    @Override
    public void getAccountNumber(){
        BankAccount bankaccount = new BankAccount();
        bankaccount.getAccountNumber();
    }
}

public class ProxyPattern {
    public static void main(String[] args){
        ATMProxy ATM = new ATMProxy();
        ATM.withdraw();
    }
}
