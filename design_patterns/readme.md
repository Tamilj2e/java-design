Creational Patterns

Factory → Use when callers shouldn’t care which concrete class gets created.
factory method(GoF)
Builder → Use when an object has lots of optional fields or messy construction details.
Singleton → Use when you truly need one global instance (rare in interviews).
abstract factory- this create family of related products


Structural Patterns
Decorator → Use when you need to layer optional behaviors at runtime without subclass explosion.
Facade → Use when you want to hide internal complexity behind a simple entry point.
adapter
proxy
command - to separate the request sender from the request performer
Think of a restaurant.

Customer → Gives an order.
customer gives order command, waiter came
Waiter → Takes the order.
Chef → Cooks the food.

The waiter doesn't know how to cook.

Behavioral Patterns
Strategy → Use when you're replacing if/else logic with interchangeable behaviors.
Observer → Use when multiple components need to react to a single event.
State Machine → Use when an object's behavior depends on its current state and transitions get messy.
chain of responsibility - COR
