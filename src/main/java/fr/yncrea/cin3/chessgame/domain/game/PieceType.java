package fr.yncrea.cin3.chessgame.domain.game;

public enum PieceType{
    PAWN("pawn"),
    KNIGHT("knight"),
    BISHOP("bishop"),
    QUEEN("queen"),
    KING("king"),
    ROOK("rook");
    private final String pieceName;
    PieceType(final String pieceName){
        this.pieceName = pieceName;
    }
    @Override
    public String toString(){
        return this.pieceName;
    }
}