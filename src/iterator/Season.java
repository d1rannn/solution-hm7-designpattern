package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Season implements Iterable<Episode> {
    private List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode e) {
        episodes.add(e);
    }

    public EpisodeIterator getNormalIterator() {
        return new SeasonIterator(episodes);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator(); // So for-each works
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public List<Episode> getAllEpisodes() {
        return new ArrayList<>(episodes); // return a copy, not the original list
    }
}
