package util;
import game.*;
public class Pawn extends Piece{
    public Pawn(boolean white) {
	super(white);
    }
    @Override
    public boolean isLegal(Move move, Game game) {
		if(!super.isLegal(move, game))
			return false;
		//rules for pawn only!
		int rowDiff = move.getRow1() - move.getRow0();
		int colDiff = move.getCol1() - move.getCol0();
		if(rowDiff > 0 && white || rowDiff < 0 && !white)
			return false;//pawn doesn't move backward!
		if(game.getPiece(move.getRow1(),move.getCol1()) == null)//moving, not capturing
		{
			if(colDiff != 0)
				return false;
			if(rowDiff == 2 && move.getRow0() != 1)//moving 2 squares forward is only allowed at initial position
				return false;
			if(rowDiff == -2 && move.getRow0() != 6)//moving 2 squares forward is only allowed at initial position
				return false;
			if(Math.abs(rowDiff) != 1 && Math.abs(rowDiff) != 2)
				return false;
		}else{//capturing
			if (Math.abs(rowDiff) != 1 || Math.abs(colDiff) != 1) {
				return false;
			}

		}
		return true;

    }
    @Override
    public String toString() {
	return white?"\u2659":"\u265F";
    }
}
