public enum Colour {
    RED("\u001B[31m", "⬛"),
    YELLOW("\u001B[33m", "🟨"),
    GREEN("\u001B[32m", "🟩"),
    RESET("\u001B[0m", "");

    public final String ansiColour;
    public final String emoji;

    private Colour(String ansiColour, String emoji) {
        this.ansiColour = ansiColour;
        this.emoji = emoji;
    }
}
