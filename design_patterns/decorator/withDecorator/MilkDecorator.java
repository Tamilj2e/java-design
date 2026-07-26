package design_patterns.decorator.withDecorator;

import design_patterns.decorator.Coffee;

public class MilkDecorator extends CoffeeDecorator{
    public final String word = "tamil"; //coffee decorator cant use this as parents cant use
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public Double getCost() {
        return super.getCost()+2.5;
    }

    @Override
    public String getType() {
        return coffee.getType()+" added milk";  //better consistency use super
    }
}
