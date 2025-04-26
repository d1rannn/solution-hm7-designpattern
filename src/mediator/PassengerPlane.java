package mediator;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PassengerPlane extends Aircraft {
    public PassengerPlane(String id, TowerMediator mediator) {
        super(id, mediator);
    }

    @Override
    public void receive(String msg) {
        System.out.println("PassengerPlane " + id + " received: " + msg);
    }

    @Override
    public void requestRunway() {
        if (mediator.requestRunway(this)) {
            System.out.println("PassengerPlane " + id + " is cleared for runway.");
            Executors.newSingleThreadScheduledExecutor().schedule(() -> {
                mediator.releaseRunway();
            }, 2, TimeUnit.SECONDS);
        }
    }
}
