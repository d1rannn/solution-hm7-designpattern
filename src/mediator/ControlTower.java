package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new ConcurrentLinkedQueue<>();
    private boolean runwayAvailable = true;
    private List<Aircraft> allAircraft = new ArrayList<>();
    private boolean emergencyActive = false;

    public void registerAircraft(Aircraft aircraft) {
        allAircraft.add(aircraft);
    }

    @Override
    public void broadcast(String msg, Aircraft sender) {
        if (msg.equalsIgnoreCase("MAYDAY")) {
            handleEmergency(sender);
        } else {
            for (Aircraft a : allAircraft) {
                if (!a.equals(sender)) {
                    a.receive(sender.getId() + ": " + msg);
                }
            }
        }
    }

    @Override
    public synchronized boolean requestRunway(Aircraft a) {
        if (emergencyActive) {
            System.out.println(a.getId() + " cannot use runway, emergency active.");
            return false;
        }
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
        if (!emergencyActive && !landingQueue.isEmpty()) {
            Aircraft next = landingQueue.poll();
            System.out.println("Next aircraft from queue: " + next.getId());
            requestRunway(next);
        }
    }

    private synchronized void handleEmergency(Aircraft emergencyAircraft) {
        System.out.println("!!! EMERGENCY: " + emergencyAircraft.getId() + " sent MAYDAY !!!");
        emergencyActive = true;
        runwayAvailable = true;

        for (Aircraft a : allAircraft) {
            if (!a.equals(emergencyAircraft)) {
                a.receive("ALL AIRCRAFT HOLD POSITION - EMERGENCY LANDING IN PROGRESS");
            }
        }
        // Grant immediate runway
        requestRunway(emergencyAircraft);
        emergencyActive = false; // After immediate grant
    }
}