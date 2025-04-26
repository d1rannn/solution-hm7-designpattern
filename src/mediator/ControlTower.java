package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new ConcurrentLinkedQueue<>();
    private Queue<Aircraft> takeOffQueue = new ConcurrentLinkedQueue<>();
    private boolean runwayAvailable = true;
    private List<Aircraft> allAircraft = new ArrayList<>();

    public void registerAircraft(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        for (Aircraft a : allAircraft) {
            if (!a.equals(sender)) {
                a.receive(sender.getId() + ": " + msg);
            }
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft a) {
        if (runwayAvailable) {
            runwayAvailable = false;
            System.out.println("Runway granted to " + a.getId());
            return true;
        } else {
            landingQueue.offer(a);
            System.out.println(a.getId() + " added to landing queue.");
            return false;
        }
    }

    public synchronized void releaseRunway() {
        runwayAvailable = true;
        if (!landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            System.out.println("Next aircraft from queue: " + next.getId());
            requestRunway(next);
        }
    }
}