package iterator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleSeasonIterator implements EpisodeIterator {
    private static final long SEED = 12345L; // Needed for repeatable shuffle
    private List<Episode> shuffledEpisodes;
    private int index = 0;

    public ShuffleSeasonIterator(List<Episode> episodes) {
        this.shuffledEpisodes = new java.util.ArrayList<>(episodes);
        Random random = new Random(SEED);
        Collections.shuffle(shuffledEpisodes, random);
    }

    @Override
    public boolean hasNext() {
        return index < shuffledEpisodes.size();
    }

    @Override
    public Episode next() {
        return shuffledEpisodes.get(index++);
    }
}
