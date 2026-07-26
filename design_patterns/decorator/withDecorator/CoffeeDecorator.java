package design_patterns.decorator.withDecorator;

import design_patterns.decorator.Coffee;


/*

why we need to mark as abstract?

Reason 1: We don't want anyone to create a plain CoffeeDecorator

If it's concrete, someone can write:

Coffee coffee = new ColdCoffee();
Coffee decorator = new CoffeeDecorator(coffee);

What does this object do?

Nothing! It just forwards calls:

decorator.getType(); // cold coffee
decorator.getCost(); // 10.0

It doesn't add any behavior, so creating it is pointless.

By making it abstract:

public abstract class CoffeeDecorator implements Coffee

this becomes illegal:

new CoffeeDecorator(coffee); // Compile-time error

The programmer is forced to use a real decorator like:

new MilkDecorator(coffee);
new SugarDecorator(coffee);
Reason 2: It represents an incomplete concept

CoffeeDecorator is just a base class that provides common functionality (holding the wrapped Coffee and delegating methods).

The actual behavior is added by subclasses:

MilkDecorator
SugarDecorator
ChocolateDecorator

So CoffeeDecorator is not meant to exist on its own.

Analogy

Think of it like:
 */
public  abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee){
        this.coffee = coffee;
    }

    @Override
    public String getType() {
        return coffee.getType();
    }

    @Override
    public Double getCost() {
        return coffee.getCost();
    }
}
