package util;

import game.*;

public class Rook extends Queen {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean isLegal(Move move, Game game) {
        if (!super.isLegal(move, game))
            return false;
        //rules for rook only!
        int rowDiff = move.getRow1() - move.getRow0();
        int colDiff = move.getCol1() - move.getCol0();
        if(rowDiff * colDiff != 0)
            return false;
        if(rowDiff == 0){//horizontal
            for(int i = Math.min(move.getCol0(), move.getCol1()) + 1; i < Math.max(move.getCol0(), move.getCol1());i++)
                if(game.getPiece(move.getRow0(), i) != null)
                    return false;
        }else//if(colDiff == 0)//vertical
            for(int i = Math.min(move.getRow0(), move.getRow1()) + 1; i < Math.max(move.getRow0(), move.getRow1());i++)
                if(game.getPiece(i, move.getCol0()) != null)
                    return false;
        return true;
    }

    @Override
    public String toString() {
        return white ? "\u2656" : "\u265C";
    }
}
