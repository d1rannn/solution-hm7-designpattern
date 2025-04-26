package iterator;

public class EpisodeView {
    private final Episode episode;
    private final int startTimeSec;

    public EpisodeView(Episode episode, int startTimeSec) {
        this.episode = episode;
        this.startTimeSec = startTimeSec;
    }

    public void play() {
        System.out.println("Playing '" + episode.getTitle() + "' starting at " + startTimeSec + " seconds.");
    }

    public Episode getEpisode() {
        return episode;
    }

    public int getStartTimeSec() {
        return startTimeSec;
    }
}
