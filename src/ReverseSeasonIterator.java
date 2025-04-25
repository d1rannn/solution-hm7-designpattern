import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int currentIndex;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.currentIndex = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex--);
    }
}
