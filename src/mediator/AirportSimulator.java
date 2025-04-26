package mediator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AirportSimulator {
    public static void main(String[] args) {
        ControlTower tower = new ControlTower();
        List<Aircraft> aircraftList = new ArrayList<>();
        Random random = new Random();

        // Spawn 10 random aircrafts
        for (int i = 0; i < 10; i++) {
            int type = random.nextInt(3);
            Aircraft a;
            if (type == 0) {
                a = new PassengerPlane("Passenger-" + i, tower);
            } else if (type == 1) {
                a = new CargoPlane("Cargo-" + i, tower);
            } else {
                a = new Helicopter("Helicopter-" + i, tower);
            }
            tower.registerAircraft(a);
            aircraftList.add(a);
        }

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(() -> {
            int idx = random.nextInt(aircraftList.size());
            Aircraft a = aircraftList.get(idx);
            a.requestRunway();
        }, 0, 1, TimeUnit.SECONDS);

        // Shutdown after 20 seconds for demonstration
        executor.schedule(() -> {
            executor.shutdown();
            System.out.println("Simulation ended.");
        }, 20, TimeUnit.SECONDS);
    }
}

