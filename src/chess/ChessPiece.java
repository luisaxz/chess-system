package chess;

import boardgame.Board;
import boardgame.Piece;

public class ChessPiece extends Piece { //essa classe e uma subclasse de piece, como Piece tem um construtor la na classe dele
   //tem que ter um construtor aqui tambem
    private Color color;

    public ChessPiece(Board board, Color color) {// construtor do chesspiece
        super(board);
        this.color = color;
    }

    public Color getColor() {//gerado somente o get, pois o set e pra permitir ser alterado algum dado da cor da peça e o mesmo nao pode ser alterado.
        return color;
    }


}
