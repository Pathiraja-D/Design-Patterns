package DecoratorPattern;

interface Coffee{
    public double getCost();
    public String getIngredients();
}

class SimpleCoffee implements Coffee{
    @Override
    public double getCost(){
        return 1;
    }

    @Override
    public String getIngredients(){
        return "Coffee";
    }
}

abstract class CoffeeDecorator implements Coffee{
    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee){
        this.decoratedCoffee = coffee;
    }

    public double getCost(){
        return decoratedCoffee.getCost();
    }

    public String getIngredients(){
        return decoratedCoffee.getIngredients();
    }
}

class WithMilk extends CoffeeDecorator{
    public WithMilk(Coffee coffee){
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.5;
    }

    public String getIngredients(){
        return super.getIngredients() + ", Milk";
    }
}

class WithSprinkles extends CoffeeDecorator{
    public WithSprinkles(Coffee coffee){
        super(coffee);
    }

    public double getCost(){
        return super.getCost() + 0.2;
    }

    public String getIngredients(){
        return super.getIngredients() + ", Sprinkles";
    }
}

public class DecoratorPattern {
    public static void main(String args[]){

    }
}
