package iterator;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a big Season with 10,000 episodes
        Season bigSeason = new Season();
        for (int i = 1; i <= 10_000; i++) {
            bigSeason.addEpisode(new Episode("Episode " + i, (int)(Math.random() * 1000 + 1000)));
        }
        System.out.println("Generated 10,000 episodes.\n");

        // Step 2: Time each iterator
        long normalTime = timeIterator(new SeasonIterator(bigSeason.getAllEpisodes()));
        long reverseTime = timeIterator(new ReverseSeasonIterator(bigSeason.getAllEpisodes()));
        long shuffleTime = timeIterator(new ShuffleSeasonIterator(bigSeason.getAllEpisodes()));

        // Step 3: Print results
        System.out.println("\nPerformance Report (lower is better):");
        printBar("Normal Iterator ", normalTime);
        printBar("Reverse Iterator", reverseTime);
        printBar("Shuffle Iterator", shuffleTime);
    }

    private static long timeIterator(EpisodeIterator iterator) {
        long start = System.nanoTime();
        while (iterator.hasNext()) {
            Episode e = iterator.next();
            // We can simulate reading the title (small operation)
            e.getTitle();
        }
        long end = System.nanoTime();
        return (end - start) / 1_000_000; // return time in milliseconds
    }

    private static void printBar(String label, long timeMs) {
        System.out.printf("%-18s | ", label);
        int bars = (int) (timeMs / 2); // 1 bar per ~2ms (adjust if needed)
        for (int i = 0; i < bars; i++) {
            System.out.print("#");
        }
        System.out.println(" " + timeMs + " ms");
    }
}