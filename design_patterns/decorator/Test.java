package design_patterns.decorator;

import design_patterns.decorator.withDecorator.CoffeeDecorator;
import design_patterns.decorator.withDecorator.MilkDecorator;
import design_patterns.decorator.withDecorator.SugarDecorator;
import design_patterns.decorator.withoutDecorator.ColdCoffee;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new ColdCoffee();
        System.out.println(coffee.getType() + " price: "+coffee.getCost());

        MilkDecorator milk = new MilkDecorator(coffee);
        System.out.println(milk.getType()+" price: "+milk.getCost());

        SugarDecorator milkAndsugar = new SugarDecorator(milk);
        System.out.println(milkAndsugar.getType()+" price: "+milkAndsugar.getCost());

    }
}
