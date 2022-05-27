package fr.yncrea.cin3.chessgame.domain.game.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final boolean[] SECOND_ROW = initRow(1);
    public static final boolean[] SEVENTH_ROW = initRow(48);
    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;
    public static final int NUM_TILES_PER_COLUMN = 8;


    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate this class");
    }

    public static boolean isValidTileCoord(int coordinate) {
        return coordinate >=0 && coordinate <NUM_TILES;
    }

    private static boolean[] initColumn(int Cnb) {
        final boolean[] column = new boolean[NUM_TILES];
        do{
            column[Cnb] = true;
            Cnb+=8;
        }while(Cnb < NUM_TILES);
        return column;
    }

    private static boolean[] initRow(int Rnb) {
        final boolean[] row = new boolean[NUM_TILES];
        do{
            row[Rnb] = true;
            Rnb++;
        }while(Rnb % NUM_TILES_PER_ROW !=0);
        return row;
    }
}
