public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 1200));
        season1.addEpisode(new Episode("The Story Begins", 1400));
        season1.addEpisode(new Episode("Cliffhanger", 1350));

        System.out.println("Normal iterator:");
        EpisodeIterator normal = season1.getNormalIterator();
        while (normal.hasNext()) {
            System.out.println(normal.next());
        }

        System.out.println("\nReverse iterator:");
        EpisodeIterator reverse = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }

        System.out.println("\nShuffle iterator:");
        EpisodeIterator shuffle = new ShuffleSeasonIterator(season1.getEpisodes(), 42L);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\nFor-each loop:");
        for (Episode e : season1) {
            System.out.println(e);
        }
    }
}