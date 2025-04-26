package mediator;

public class CargoPlane extends Aircraft {
    public CargoPlane(String id, TowerMediator mediator) {
        super(id, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("CargoPlane " + id + " received: " + msg);
    }

    @Override
    public void requestRunway() {
        if (mediator.requestRunway(this)) {
            System.out.println("CargoPlane " + id + " is cleared for runway.");
        }
    }
}
