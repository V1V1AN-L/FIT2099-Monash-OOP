package game.pokemon;

public enum FavoriteAction {
    SINGING("singing"),
    DANCING("dancing"),
    CHEST_POUNDING("chest pounding");

    private final String label;

    FavoriteAction(String label){
        this.label = label;
    }

    /**
     *
     * @return the label text
     */
    @Override
    public String toString() {
        return label;
    }
}
