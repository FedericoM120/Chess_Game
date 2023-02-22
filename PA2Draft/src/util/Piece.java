package util;
import game.*;
public class Piece {
    protected boolean white;//white if true, black otherwise

	public boolean isWhite() {
		return white;
	}

	public boolean isLegal(Move move, Game game) {
		if (white != game.isWhiteTurn())
			return false;
		Piece captured = game.getPiece(move.getRow1(), move.getCol1());
		if(captured != null && captured.white == this.white)//a piece can't capture a piece of the same color
			return false;
		if(move.getRow0() == move.getRow1() && move.getCol0() == move.getCol1())
			return false;
		//Piece moved = game.getPiece(move.getRow0(), move.getCol0());
		//if(moved == null || moved.white != this.white)
		//	return false;
		return true;
    }
    public Piece(boolean white) {
	this.white = white;
    }
}
