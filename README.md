# README: Why Use an Iterator Instead of Exposing List<Episode>?

In this project, we use an **Iterator Pattern** instead of simply exposing `List<Episode>` to the outside world.  
Here’s why:

## 1. Encapsulation
- **Iterator hides internal storage details**.
- A `Season` might store episodes in an `ArrayList`, `LinkedList`, or even load them lazily from a file.
- By using an iterator, the client code **doesn't care how episodes are stored** — only how to access them (`hasNext()`, `next()`).

## 2. Flexibility
- Different traversal orders (normal, reverse, shuffle) are supported easily by **changing the iterator**, **not the collection**.
- If we exposed the raw `List<Episode>`, we would be stuck with just the natural order or manually sorting it every time.

## 3. Control
- Iterators **control how and when episodes are provided**.
- For example, a **ShuffleIterator** randomizes order once, a **ReverseIterator** gives them backwards, and a **SkipIntroIterator** modifies playback behavior — all without changing the underlying data.

## 4. Future-Proofing
- If in the future episodes are loaded **lazily**, or **streamed from a server**, direct access to a `List` would not work anymore.
- Iterators allow smooth transition to lazy-loading or streaming without changing client code.

## 5. Cleaner API
- Instead of exposing a whole list with tons of possible operations (`add`, `remove`, etc.), the iterator **offers a minimal, clean API**: just `hasNext()` and `next()`.

---

# 📋 Conclusion
Using an iterator provides **encapsulation, flexibility, control, and future-proofing**, making the system more robust and maintainable.

---

# Reflection: Why is Mediator better than direct aircraft communication?

In an airport setting, direct communication between aircraft would create chaos. Every aircraft would have to manage multiple relationships, coordinate their timings, and handle conflict resolution on their own. 

Using a **Mediator pattern**, we centralize the communication through the **ControlTower**. Aircraft now only send and receive through a single entity, drastically reducing complexity, coupling, and risk of conflict.

The Mediator also makes it easy to enforce centralized rules, like giving emergency landings priority or ensuring FIFO access to the runway. Without the Mediator, updating communication rules would require touching all aircraft code, while with the Mediator, changes happen in a single place.

## Disadvantage:
The main disadvantage is that the Mediator (ControlTower) can become a “god object” — overly large and complex if not carefully designed. It can become a single point of failure or maintenance bottleneck.
