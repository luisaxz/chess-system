package chess.pieces;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {

    public Rook(Board board, Color color) {
        super(board, color);
    }

    @Override //converter uma torre para string
    public String toString(){ //essa letra vai entrar na hora de imprimir o tabuleiro
        return "R";

    }
}
