package design_patterns.command;

class Tv{
    void turnOn(){
        System.out.println("turning on the tv");
    }
    void turnOff(){
        System.out.println("turning off the tv");
    }
}

interface Command{
    void execute();
    /*The command doesn't know how to turn on a TV.

    It simply delegates to the receiver.
    */
}


class TurnOnCommand implements Command{
    Tv tv;
    public TurnOnCommand(Tv tv){
        this.tv = tv;
    }
    @Override
    public void execute() {
        System.out.println("turn on command is executing");
        tv.turnOn();
    }
}

class TurnOffCommand implements Command{
    Tv tv;
    public TurnOffCommand(Tv tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        System.out.println("turn off command is executing");
        tv.turnOff();
    }
}

class RemoteControl{
    Command command;
//The remote doesn't know about TVs.
//
//It only knows: command.execute()
    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton(){
        command.execute();
    }
}
public class Client {
    public static void main(String[] args) {
        Tv tv = new Tv();
        Command on = new TurnOnCommand(tv);
        Command off = new TurnOffCommand(tv);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(on);
        remote.pressButton();

        remote.setCommand(off);
        remote.pressButton();
    }
}

/*
You're very close, but there's one important distinction.

The answer is **No, not automatically.**

Replacing a service interface with a class named `Command` does **not** make it the Command pattern.

The difference is **intent**, not just the class name.

---

## Normal Spring Service

```java
interface OrderService {
    void createOrder(OrderRequest request);
}
```

```java
@Service
class OrderServiceImpl implements OrderService {
    public void createOrder(OrderRequest request) {
        ...
    }
}
```

Here, `OrderService` represents a **service** that provides operations.

---

## Command Pattern

```java
interface Command {
    void execute();
}
```

```java
class CreateOrderCommand implements Command {

    @Override
    public void execute() {
        ...
    }
}
```

Here, `CreateOrderCommand` represents **one specific action**.

---

## The key difference

A service usually exposes **multiple operations**.

```java
interface OrderService {

    void createOrder();

    void cancelOrder();

    void updateOrder();

    void getOrder();
}
```

One service handles many related responsibilities.

---

A command represents **one operation**.

```java
CreateOrderCommand

CancelOrderCommand

UpdateOrderCommand
```

Each command has a single responsibility.

---

## Another difference

Commands are often treated as **objects**.

You can do things like:

```java
queue.add(createOrderCommand);

scheduler.schedule(createOrderCommand);

retry(createOrderCommand);

log(createOrderCommand);
```

You normally don't do this with a service.

---

## Think of it this way

### Service

> "I provide order-related functionality."

```java
orderService.createOrder();
orderService.cancelOrder();
orderService.updateOrder();
```

---

### Command

> "I represent one business action."

```java
createOrderCommand.execute();
```

That object can be passed around, queued, retried, or executed later.

---

## Can a command use a service?

Yes—and this is the most common approach.

```java
class CreateOrderCommand implements Command {

    private final OrderService orderService;

    @Override
    public void execute() {
        orderService.createOrder();
    }
}
```

Here:

* `OrderService` contains the business logic.
* `CreateOrderCommand` encapsulates the action and delegates to the service.

---

## Interview answer

If an interviewer asks:

> "If I replace my service interface with a `CreateOrderCommand`, am I using the Command pattern?"

A good answer is:

> "Not necessarily. The Command pattern is about encapsulating a request as an object. Simply renaming a service to `Command` isn't enough. A command usually represents a single action and can be executed, queued, logged, retried, or undone. A service, on the other hand, typically groups related business operations."

That's the distinction interviewers are looking for.

 */
