package util;

import game.*;

public class Bishop extends Queen{
    public Bishop(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
	if(!super.isLegal(move, game))
	    return false;
	//rules for bishop only!
        int rowDiff = move.getRow1() - move.getRow0();
        int colDiff = move.getCol1() - move.getCol0();

        if(Math.abs(rowDiff) == Math.abs(colDiff)){
            for (int i = 1; i < Math.abs(rowDiff); i++){
                if(rowDiff > 0 && colDiff > 0 && game.getPiece(move.getRow0() + i, move.getCol0() + i) != null
                        || rowDiff > 0 && colDiff < 0 && game.getPiece(move.getRow0() + i, move.getCol1() + i) != null
                        || rowDiff < 0 && colDiff > 0 && game.getPiece(move.getRow1() + i, move.getCol0() + i) != null
                        || rowDiff < 0 && colDiff < 0 && game.getPiece(move.getRow1() + i, move.getCol1() + i) != null)
                    return false;
            }
            return true;
        }

	return false;
    }
    @Override
    public String toString() {
	return white?"\u2657":"\u265D";
    }
}
