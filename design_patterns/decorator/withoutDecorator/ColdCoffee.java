package design_patterns.decorator.withoutDecorator;

import design_patterns.decorator.Coffee;

public class ColdCoffee implements Coffee {
    @Override
    public String getType() {
        return "cold coffee";
    }

    @Override
    public Double getCost() {
        return 10.0;
    }
}
