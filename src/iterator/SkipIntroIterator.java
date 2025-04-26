package iterator;

import java.util.Iterator;

public class SkipIntroIterator implements Iterator<EpisodeView> {
    private final EpisodeIterator baseIterator;
    private final int introLengthSec;

    public SkipIntroIterator(EpisodeIterator baseIterator, int introLengthSec) {
        this.baseIterator = baseIterator;
        this.introLengthSec = introLengthSec;
    }

    @Override
    public boolean hasNext() {
        return baseIterator.hasNext();
    }

    @Override
    public EpisodeView next() {
        Episode nextEpisode = baseIterator.next();
        return new EpisodeView(nextEpisode, introLengthSec);
    }
}
