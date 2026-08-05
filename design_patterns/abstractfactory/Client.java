package design_patterns.abstractfactory;
/*
Factory Method creates one product.
Abstract Factory creates a family of related products.
 */

interface Button{
    void press();
}
interface MousePad{
    void track();
}

class WindowsButton implements Button{

    @Override
    public void press() {
        System.out.println("Using windows button");
    }
}

class WindowsMousePad implements MousePad{

    @Override
    public void track() {
        System.out.println("USing windows mouse");
    }
}

class MacButton implements Button{

    @Override
    public void press() {
        System.out.println("using mac button");
    }
}
class MacMousePad implements MousePad{

    @Override
    public void track() {
        System.out.println("using mac trackpad");
    }
}

interface GUIFactory {
    //since gui factory does not have any common implementation like factory method making it interface
    public abstract Button createButton();
    public abstract MousePad createMousePad();
    //can add keyboard in the future
}

class WindowsFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public MousePad createMousePad() {
        return new WindowsMousePad();
    }
}

class MacFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public MousePad createMousePad() {
        return new MacMousePad();
    }
}
public class Client {
    public static void main(String[] args) {
        GUIFactory factory = new MacFactory();
        Button button = factory.createButton();
        MousePad mousePad = factory.createMousePad();
        button.press();
        mousePad.track();
    }

}


