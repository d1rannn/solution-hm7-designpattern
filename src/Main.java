import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Season season1 = new Season();
        season1.addEpisode(new Episode("Pilot", 1200));
        season1.addEpisode(new Episode("The Story Begins", 1400));
        season1.addEpisode(new Episode("Cliffhanger", 1350));

        Season season2 = new Season();
        season2.addEpisode(new Episode("New Challenges", 1500));
        season2.addEpisode(new Episode("Big Reveal", 1600));

        System.out.println("Normal iterator (Season 1):");
        EpisodeIterator normal = season1.getNormalIterator();
        while (normal.hasNext()) {
            System.out.println(normal.next());
        }

        System.out.println("\nReverse iterator (Season 1):");
        EpisodeIterator reverse = new ReverseSeasonIterator(season1.getEpisodes());
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }

        System.out.println("\nShuffle iterator (Season 1):");
        EpisodeIterator shuffle = new ShuffleSeasonIterator(season1.getEpisodes(), 42L);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\nFor-each loop (Season 1):");
        for (Episode e : season1) {
            System.out.println(e);
        }

        System.out.println("\nBinge watch across seasons:");
        List<Season> allSeasons = new ArrayList<>();
        allSeasons.add(season1);
        allSeasons.add(season2);
        BingeIterator binge = new BingeIterator(allSeasons);
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}