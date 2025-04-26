package mediator;

import java.util.Random;

// Aircraft.java
public abstract class Aircraft {
    protected String id;
    protected TowerMediator mediator;
    protected int fuelLevel; // NEW FIELD

    public Aircraft(String id, TowerMediator mediator) {
        this.id = id;
        this.mediator = mediator;
        this.fuelLevel = new Random().nextInt(51) + 50; // random 50-100%
    }

    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    public void sendEmergency() {
        mediator.broadcast("MAYDAY", this);
    }

    public abstract void receive(String msg);
    public abstract void requestRunway();
    public String getId() {
        return id;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void decreaseFuel() {
        fuelLevel -= 5; // decrease 5% per second
        if (fuelLevel < 0) fuelLevel = 0;
    }
}
