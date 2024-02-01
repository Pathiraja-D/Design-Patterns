package ProxyPattern;
// Virtual proxy
//Control the access to an object by delaying the creation untill it is needed
// Used when there is complex operations.

//Real Object
interface Customer{
    String getDetails();
}

//Real Subject
class RealCustomer implements Customer{
    private String details;

    public RealCustomer(String cutomerId){
        this.details = "Details for customer"+cutomerId;
    }

    @Override
    public String getDetails(){
        return details;
    }

}

//Virtual Proxy
class VirtualCustomer implements Customer{
    private RealCustomer realCustomer;
    private String customerId;

    public VirtualCustomer(String customerId){
        this.customerId = customerId;
    }

    @Override
    public String getDetails(){
        if(realCustomer == null){
            realCustomer = new RealCustomer(customerId);
        }
        return realCustomer.getDetails();
    }
}

public class VirtualProxyPattern {
    public static void main (String[] args)
    {
        VirtualCustomer customer = new VirtualCustomer("123");
        customer.getDetails();

    }
}
