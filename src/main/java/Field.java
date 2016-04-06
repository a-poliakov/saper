public class Field {
    private Cell[][] gride ;

    public Field() {
        gride = new Cell[10][10];
        for(int i = 0; i < gride.length; i++){
            for(int j = 0; j < gride[i].length; j++){
                gride[i][j] = Cell.unknown;
            }
        }
    }

    public Cell[][] getGride() {
        return gride;
    }
}
