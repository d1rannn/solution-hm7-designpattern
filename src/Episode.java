public class Episode {
    private String title;
    private int runtimeSec;

    public Episode(String title, int runtimeSec) {
        this.title = title;
        this.runtimeSec = runtimeSec;
    }

    public String getTitle() {
        return title;
    }

    public int getRuntimeSec() {
        return runtimeSec;
    }

    @Override
    public String toString() {
        return title + " (" + runtimeSec + "s)";
    }
}
