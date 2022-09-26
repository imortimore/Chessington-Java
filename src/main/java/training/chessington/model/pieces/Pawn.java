package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.Black;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter.White;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }
    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board){
        ArrayList<Move> movelist = new ArrayList<>(); 
        switch(this.colour){
            case BLACK:
                return getPawnMovesAsPlayerColour(from, movelist, PlayerColour.BLACK, board);
            case WHITE:
                return getPawnMovesAsPlayerColour(from, movelist, PlayerColour.WHITE, board);
            default: return movelist;
        }
    }
    public List<Move> getPawnMovesAsPlayerColour(Coordinates from, List<Move> movelist, PlayerColour playerColour,Board board){
        int pawnStartingRow = playerColour.equals(PlayerColour.BLACK) ? 1 : 6;
        Coordinates pawnmove1row = playerColour.equals(PlayerColour.BLACK) ? new Coordinates(from.getRow()+1,from.getCol()): new Coordinates(from.getRow() - 1, from.getCol());
        Coordinates pawnmove2row = playerColour.equals(PlayerColour.BLACK) ? new Coordinates(from.getRow()+2,from.getCol()): new Coordinates(from.getRow() - 2, from.getCol());
        Coordinates captureLeft = playerColour.equals(PlayerColour.BLACK) ? new Coordinates(from.getRow()+1,from.getCol()-1): new Coordinates(from.getRow()-1,from.getCol()-1); 
        Coordinates captureRight = playerColour.equals(PlayerColour.BLACK) ? new Coordinates(from.getRow()+1,from.getCol()+1): new Coordinates(from.getRow()-1,from.getCol()+1);
        
        if (isBoardEdge(from, colour)){
            return movelist;
        }
      






        if (from.getRow() == pawnStartingRow){
            if (checkPawnMoveIsClear(board, pawnmove1row)){
                movelist.add(new Move(from, pawnmove1row));
            }
            if (checkPawnMoveIsClear(board, pawnmove2row)){
                movelist.add(new Move(from, pawnmove2row));
            }
        }else{ 
            if (checkPawnMoveIsClear(board, pawnmove1row)){
            movelist.add(new Move(from, pawnmove1row));
        }
    }
    return movelist;
    }
    public boolean checkPawnMoveIsClear(Board board, Coordinates to){
        return board.get(to) == null ? true : false;
    }
    public boolean isBoardEdge(Coordinates from, PlayerColour colour){
        switch(this.colour){
            case BLACK:
                return from.getRow() == 7 ? true : false;
            case WHITE:
                return from.getRow() == 0 ? true : false;
            default:
                return false;
        }
    }
    public boolean pawnCanCaptureLeft(Board board, Coordinates to, Coordinates from,Coordinates captureLeft,PlayerColour colour){
        switch(this.colour){
            case BLACK:
                if (board.get(to).getColour().equals(colour){
                    return true;
                }
            case WHITE:
                if (board.get(to).getColour().equals(colour){
                    return true;
                }
            default:
                return false;
    }
}
       

