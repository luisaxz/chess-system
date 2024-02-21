package chess;//aqui tera as regras do jogo de xadrez

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {

    private Board board;

    public ChessMatch() {
        board = new Board(8, 8); // o tabuleiro tendo a dimensao de 8x8
        initialSteup(); //chamo o initial setup
    }

    public ChessPiece[][] getpieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;  //retornar a minha matriz mat, retorna matrix de peças do meu jogo xadrez

    }
    public ChessPiece perfomeChessMove(ChessPosition  sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source); //validar a posição de oriegem, se existe, se exisia peça nessa posição
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;// a peça captura e da classe piece
    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source); // removi a peça da posisão de origem
        Piece capturedPiece = board.removePiece(target); // remover a posisvel peça que esteja na posiçao de destino.
        board.placePiece(p, target);
        return capturedPiece;

    }
    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece((position))) { //se nao existir uma peça nessa posição
            throw new ChessException("Não existe peça na posiçaõ de origem")

        }
    }


    private void placeNewPiece(char column, int row, ChessPiece piece){ //  //receber as coordenadas do xadrex
        board.placePiece(piece, new ChessPosition(column , row ) .toPosition());

    }

    private void initialSteup(){ //metodo reponsvael de iniciar a partida de xadrex
        placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));

    }
}

