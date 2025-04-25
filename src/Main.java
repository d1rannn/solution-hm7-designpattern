public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 1200));
        season1.addEpisode(new Episode("The Story Begins", 1400));
        season1.addEpisode(new Episode("Cliffhanger", 1350));

        System.out.println("Normal iterator:");
        EpisodeIterator it = season1.getNormalIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nFor-each loop:");
        for (Episode e : season1) {
            System.out.println(e);
        }
    }
}
