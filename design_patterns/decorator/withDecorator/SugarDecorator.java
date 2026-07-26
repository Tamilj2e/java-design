package design_patterns.decorator.withDecorator;

import design_patterns.decorator.Coffee;

public class SugarDecorator extends CoffeeDecorator{
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getType() {
        return super.getType()+" added Sugar";
    }

    @Override
    public Double getCost() {
        return super.getCost()+1.5;
    }
}
