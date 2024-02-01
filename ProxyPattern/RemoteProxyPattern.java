package ProxyPattern;
//Represent an object that is in a different address space
// Usefull for controlling access to a resource over a network

interface BankSevice{
    double getAccountBalance(String accountNumber);
}

//Real subject
class RealBankService implements BankSevice{
    @Override
    public double getAccountBalance(String accountNumber){

        return 1000000;
    }
}

//Remote proxy
class BankServiceProxy implements BankSevice{
    private BankSevice realbankService;

    @Override
    public double getAccountBalance(String accountNumber){
        if(realbankService == null){
            realbankService = new RealBankService();
        }
        return realbankService.getAccountBalance(accountNumber);
    }
}

public class RemoteProxyPattern {
    
}
