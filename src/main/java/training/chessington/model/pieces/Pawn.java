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
        //is pawn black or white
        if (this.colour == PlayerColour.WHITE){
            if (from.getRow() == 1){
                Coordinates whitemove1 = new Coordinates(from.getRow()+1,from.getCol());
                Coordinates whitemove2 = new Coordinates(from.getRow()+2,from.getCol());
                movelist.add(whitemove1);
                movelist.add(whitemove2);
            }else{
                //standard -1 move for white
                Coordinates coordinateabove = new Coordinates(from.getRow()-1, from.getCol());
                Move whitemove1 = new Move(from, coordinateabove);
                movelist.add(whitemove1);
                return movelist;
            }
        }else {
            if (from.getRow() == 1){
                Coordinates blackmove1 = new Coordinates(from.getRow()+1,from.getCol());
                Coordinates blackmove2 = new Coordinates(from.getRow()+2,from.getCol());
                movelist.add(blackmove1);
                movelist.add(blackmove2);
            }else{
                //standard +1 move for black
                Coordinates coordinateabove = new Coordinates(from.getRow()+1, from.getCol());
                Move blackmove1 = new Move(from, coordinateabove);
                movelist.add(blackmove1);
                return movelist;
            }
        }
    }   
}
