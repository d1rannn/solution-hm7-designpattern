import java.util.List;

public class SeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int currentIndex = 0;

    public SeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < episodes.size();
    }

    @Override
    public Episode next() {
        return episodes.get(currentIndex++);
    }
}
