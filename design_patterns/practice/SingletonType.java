package design_patterns.practice;

class SingletonType {

    // Static variable to hold the single instance
    private static SingletonType instance;

    // Private constructor prevents object creation from outside
    private SingletonType() {
        System.out.println("SingletonType object created.");
    }

    // Public method to provide access to the instance
    public static SingletonType getInstance() {
        if (instance == null) {
            instance = new SingletonType();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from SingletonType!");
    }
}
 class Singleton {
    public static void main(String[] args) {
        SingletonType obj1 = SingletonType.getInstance();
        SingletonType obj2 = SingletonType.getInstance();

        obj1.showMessage();

        System.out.println(obj1 == obj2); // true
    }
}
