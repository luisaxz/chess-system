package boardgame;
public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces; //matriz de peças

    public Board(int rows, int columns) throws BoardException {
        if (rows < 1 || columns < 1) { //a quantidade d elinhs for menor do uque 1 ou quantidade de colunas menor que 1 signifia que os dados são invalidos
            throw new BoardException(("Erro: é necessaerio que haja pelo mneos 1 linha e 10  coluna "));

        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    // retirei metodo set Rowns pra nao pemitir que seja alterado a quantidadde de linhas, programação defensiva

    public int getColumns() {
        return columns;
    }

    // retirado tambem set Columns pra nao permitir que seja alterado a quantidade de colunas, progarmação defensiva
    public Piece piece(int row, int column) { // vai me retonar minha matriz pieces na linha row e coluna column
        if (!positionExists(row, column)) { //se essa posição nao existe eu vou lançar uma exceçao
            throw new BoardException("Pisição não existe");

        }
        return pieces[row][column];
    }

    public Piece piece(Position position) { // retornar  a peça pela posição
        if (!positionExists(position)) { //se essa posição nao existe eu vou lançar uma exceçao
            throw new BoardException("Pisição não existe");
        }
        return pieces[position.getRow()][position.getColum()];
    }


    public void placePiece(Piece piece, Position position) {// metodoo colocar uma peça nessa posição
        if (thereIsAPiece(position)) { // testar seja existe uma peça nessa posição informada retornar a mensagem de erro
            throw new BoardException("jA EXISTE UMA PEÇA NESSA POSIÇÃO" + position);
        }
        pieces[position.getRow()][position.getColum()] = piece;
        piece.position = position;

    }

    public Piece removePiece(Position position) {
        if (!positionExists(position)) {
            throw new BoardException("Posição nao existe");
        }
        if (piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        pieces[position.getRow()][position.getColum()] = null; // na ~minha matriz de peças nessa posiçao onde to ovendo a peoa vai ser nulo pois noa tenho mais essa peça na posição da matrix
        return aux; // metodo vai terornar a varivale aux que contem a peça retirada.
    }

        private boolean positionExists ( int row, int column){
            return row >= 0 && row < rows && column >= 0 && column < columns; //rows do tabuleiro nesse caso altura do tabuleiro, a quantidade de olunas do tabuleiro os que estao em plural

        }
        public boolean positionExists (Position position){ //testo se a posição existe
            return positionExists(position.getRow(), position.getColum());

        }
        public boolean thereIsAPiece (Position position){ //testar se tem uma peça na posição
            if (!positionExists(position)) { // antes de testar o thereIsApiece, ele ja testa se a posição existe, se nao existe ja para e lança a exceção.
                throw new BoardException("Posição não existe");
            }
            return piece(position) != null; //se for difernete de nulo significa que tem uma peça nessa posição

        }
    }
}



