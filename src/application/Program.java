package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ChessMatch chessMatch = new ChessMatch();

        while(true) {
            try {
                UI.clearScreen(); //limpar a tela cada vez que voltar no while
                UI.printBoard(chessMatch.getpieces());//recebe matriz de peçar da minha partida
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.perfomeChessMove(source, target);
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine(); //AGUARDAR EU APERTA ENTER

            }
            catch (InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
    }
}

