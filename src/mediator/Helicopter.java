package mediator;

public class Helicopter extends Aircraft {
    public Helicopter(String id, TowerMediator mediator) {
        super(id, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Helicopter " + id + " received: " + msg);
    }

    @Override
    public void requestRunway() {
        if (mediator.requestRunway(this)) {
            System.out.println("Helicopter " + id + " is cleared for runway.");
        }
    }
}
