package fr.yncrea.cin3.chessgame.domain.game.board;

public class BoardUtils {

    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);

    public static final boolean[] SECOND_ROW = null;
    public static final boolean[] SEVENTH_ROW = null;

    private BoardUtils(){
        throw new RuntimeException("You cannot instantiate this class");
    }

    public static boolean isValidTileCoord(int coordinate) {
        return coordinate >=0 && coordinate <64;
    }

    private static boolean[] initColumn(int Cnb) {

        final boolean[] column = new boolean[64];

        do{
            column[Cnb] = true;
            Cnb+=8;
        }while(Cnb < 64);

        return column;
    }
}
