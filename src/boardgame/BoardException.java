package boardgame;

public class BoardException extends RuntimeException {//criar a exeção
    private static final long serialVersionUID = 1L;

    public BoardException(String msg){
            super(msg);}
}
