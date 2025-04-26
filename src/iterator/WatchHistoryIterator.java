package iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WatchHistoryIterator implements Iterator<Episode> {
    private final EpisodeIterator baseIterator;
    private final Set<String> watchedTitles;
    private Episode nextUnwatched;

    public WatchHistoryIterator(EpisodeIterator baseIterator, Set<String> watchedTitles) {
        this.baseIterator = baseIterator;
        this.watchedTitles = new HashSet<>(watchedTitles);
        advance();
    }

    private void advance() {
        nextUnwatched = null;
        while (baseIterator.hasNext()) {
            Episode candidate = baseIterator.next();
            if (!watchedTitles.contains(candidate.getTitle())) {
                nextUnwatched = candidate;
                break;
            }
        }
    }

    @Override
    public boolean hasNext() {
        return nextUnwatched != null;
    }

    @Override
    public Episode next() {
        Episode result = nextUnwatched;
        advance();
        return result;
    }
}
