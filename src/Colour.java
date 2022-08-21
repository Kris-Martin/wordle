
public enum Colour {
    RED("\u001B[31m"),
    YELLOW("\u001B[33m"),
    GREEN("\u001B[32m"),
    RESET("\u001B[0m");

    public final String ansiColour;

    private Colour(String ansiColour) {
        this.ansiColour = ansiColour;
    }
}
