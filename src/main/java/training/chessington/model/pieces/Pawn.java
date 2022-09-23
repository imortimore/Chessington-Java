package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board){
        ArrayList<Move> movelist = new ArrayList<>();
        if (this.colour == PlayerColour.WHITE){
            Coordinates coordinateabove = new Coordinates(from.getRow()-1, from.getCol());
            Move move = new Move(from, coordinateabove);
            movelist.add(move);
            return movelist;
        }else {
            Coordinates coordinateabove = new Coordinates(from.getRow()+1, from.getCol());
            Move move = new Move(from, coordinateabove);
            movelist.add(move);
            return movelist;
        }
    }   
}
