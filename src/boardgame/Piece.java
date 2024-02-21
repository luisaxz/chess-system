package boardgame;

public class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {// para criar uma pesa precisa informar o  board
        this.board = board;
        position = null; //posição de uma peça recem criada vai ser nulo
    }

    protected Board getBoard() {//classes dentro do pacote ou subclasse de peças terao acesso
        return board;
    }

    // apaguei o set do board pois nao quero que ele seja alterado o tabuleiro
}
