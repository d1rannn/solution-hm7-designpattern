package mediator;

public abstract class Aircraft {
    protected String id;
    protected TowerMediator mediator;

    public Aircraft(String id, TowerMediator mediator) {
        this.id = id;
        this.mediator = mediator;
    }

    public void send(String msg) {
        mediator.broadcast(msg, this);
    }

    public abstract void receive(String msg);
    public abstract void requestRunway();
    public String getId() {
        return id;
    }
}
