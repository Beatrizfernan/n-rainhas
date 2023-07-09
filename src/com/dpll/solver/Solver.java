package com.dpll.solver;

public class Solver {
    public boolean[][] solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        if (backtrack(board, 0)) {
            return board;
        } else {
            return null;
        }
    }

    private boolean backtrack(boolean[][] board, int col) {
        int n = board.length;
        if (col >= n) {
            return true; // Todas as rainhas foram colocadas com sucesso
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true; // Coloca uma rainha na posição (row, col)

                if (backtrack(board, col + 1)) {
                    return true; // Coloca as rainhas nas colunas restantes
                }

                board[row][col] = false; // Remove a rainha se não levar a uma solução
            }
        }

        return false; // Não há posição segura para colocar a rainha na coluna atual
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        int n = board.length;

        // Verifica a linha na esquerda
        for (int i = 0; i < col; i++) {
            if (board[row][i]) {
                return false;
            }
        }

        // Verifica a diagonal superior esquerda
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        // Verifica a diagonal inferior esquerda
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j]) {
                return false;
            }
        }

        return true; // A posição é segura
    }

    public void printSolution(boolean[][] board) {
        int n = board.length;
        System.out.println(n); // Imprime o valor de N

        for (boolean[] row : board) {
            for (boolean queen : row) {
                System.out.print(queen ? "1" : "0");
            }
            System.out.println();
        }
    }
}
