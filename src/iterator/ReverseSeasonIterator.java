package iterator;

import java.util.List;

public class ReverseSeasonIterator implements EpisodeIterator {
    private List<Episode> episodes;
    private int position;

    public ReverseSeasonIterator(List<Episode> episodes) {
        this.episodes = episodes;
        this.position = episodes.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Episode next() {
        return episodes.get(position--);
    }
}