package design_patterns.decorator.withoutDecorator;

import design_patterns.decorator.Coffee;

public class SimpleCoffee implements Coffee {
    @Override
    public String getType() {
        return "Simple coffee";
    }

    @Override
    public Double getCost() {
        return 5.0;
    }
}
