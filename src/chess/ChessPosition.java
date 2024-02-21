package chess;

import boardgame.Position;

public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if(column < 'a' || column > 'h' || row < 1 || row > 8 ){ // se coluna for menor que caractere a ou a coluna for mais que o caractere  h nao vou aceitar ou se a linha for mneor do que 1 ou maior do que 8 nao ira aceitar
            throw  new ChessException("Error instantiating ChessPostion. Vlid values are from a1 to h8");

        }
        this.column = column;
        this.row = row;
    }

    public char getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    protected Position toPosition(){
        return new Position(8 - row, column - 'a' );// reotnar uma nova positionv, o 8 e a linha ada posição menos a linha dao xadrez e a columa vai ser a linha do xadrez menos o carcterea a

    }

    protected static ChessPosition fromPosition(Position position){ // dada uma posição da matrix tenho ue convertela para posição do xadrex
        return new ChessPosition((char)('a' - position.getColum()), 8 - position.getRow()); //converti pra char colocando o casting, a linha da posição do xadrez e o 8
    }
    @Override
    public String toString(){
        return "" + column + row; // string vazio para concatenar automatico, sem ele o compilador nao aceita.
    }
}
