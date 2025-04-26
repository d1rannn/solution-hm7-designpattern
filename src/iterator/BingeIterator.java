package iterator;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).getNormalIterator();
        }
    }

    @Override
    public boolean hasNext() {
        while (currentIterator != null && !currentIterator.hasNext()) {
            seasonIndex++;
            if (seasonIndex >= seasons.size()) {
                return false;
            }
            currentIterator = seasons.get(seasonIndex).getNormalIterator();
        }
        return currentIterator != null && currentIterator.hasNext();
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return currentIterator.next();
        }
        return null;
    }
}
