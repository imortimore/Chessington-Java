package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Black;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }
    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board){
        ArrayList<Move> movelist = new ArrayList<>(); 
        switch(this.colour){
            case BLACK:
                return getPawnMovesAsPlayerColour(from, movelist, PlayerColour.BLACK);
            case WHITE:
                return getPawnMovesAsPlayerColour(from, movelist, PlayerColour.WHITE);
            default: return movelist;
        }
    }
    public List<Move> getPawnMovesAsPlayerColour(Coordinates from, List<Move> movelist, PlayerColour playerColour){
        int pawnStartingRow = playerColour.equals(PlayerColour.BLACK) ? 1 : 6;
        int rowOfFirstMove = playerColour.equals(PlayerColour.BLACK) ? from.getRow() + 1 : from.getRow() - 1;
        int rowOfSecondMove = playerColour.equals(PlayerColour.BLACK) ? from.getRow() + 2 : from.getRow() - 2;
        if (from.getRow() == pawnStartingRow){
            Coordinates pawnmove1 = new Coordinates(rowOfFirstMove ,from.getCol());
            Coordinates pawnmove2 = new Coordinates(rowOfSecondMove ,from.getCol());
            movelist.add(new Move(from, pawnmove1));
            movelist.add(new Move(from, pawnmove2));
        }else{ 
       //standard +1 move for black
            Coordinates coordinateabove = new Coordinates(from.getRow()+1, from.getCol());
            Move pawnmove1 = new Move(from, coordinateabove);
            movelist.add(pawnmove1);
        }
        return movelist;
    }
    public List<Move> checkForPieceInFront(Coordinates from, List<Move> moveList , PlayerColour playerColour){
        


    }
}
       

