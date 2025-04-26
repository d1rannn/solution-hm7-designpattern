package iterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a season
        Season season = new Season();
        season.addEpisode(new Episode("Pilot", 1800));
        season.addEpisode(new Episode("Episode 2", 1900));
        season.addEpisode(new Episode("Episode 3", 2000));

        // Normal iterator
        System.out.println("--- Normal order ---");
        EpisodeIterator normalIterator = new SeasonIterator(season.getEpisodes());
        while (normalIterator.hasNext()) {
            System.out.println(normalIterator.next().getTitle());
        }

        // Reverse iterator
        System.out.println("\n--- Reverse order ---");
        EpisodeIterator reverseIterator = new ReverseSeasonIterator(season.getEpisodes());
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next().getTitle());
        }

        // Shuffle iterator
        System.out.println("\n--- Shuffle order ---");
        EpisodeIterator shuffleIterator = new ShuffleSeasonIterator(season.getAllEpisodes()); // Not getEpisodes()
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next().getTitle());
        }

        // Skip intro demo
        System.out.println("\n--- Skip Intro Iterator ---");
        EpisodeIterator skipBaseIterator = new SeasonIterator(season.getEpisodes());
        SkipIntroIterator skipIntroIterator = new SkipIntroIterator(skipBaseIterator, 90); // Skip 90 seconds
        while (skipIntroIterator.hasNext()) {
            EpisodeView view = skipIntroIterator.next();
            view.play(); // play from 90 seconds
        }

        // Watch history filter demo
        System.out.println("\n--- Watch History Filter Iterator ---");
        Set<String> watched = new HashSet<>();
        watched.add("Pilot"); // Already watched "Pilot"
        EpisodeIterator watchHistoryBase = new SeasonIterator(season.getEpisodes());
        WatchHistoryIterator watchHistoryIterator = new WatchHistoryIterator(watchHistoryBase, watched);
        while (watchHistoryIterator.hasNext()) {
            System.out.println("Unwatched: " + watchHistoryIterator.next().getTitle());
        }
    }
}