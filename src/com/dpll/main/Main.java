package com.dpll.main;

import com.dpll.solver.Solver;

public class Main {
    public static void main(String[] args) {
        int n = 10; // Valor de N (tamanho do tabuleiro)

        Solver solver = new Solver();
        boolean[][] solution = solver.solveNQueens(n);

        if (solution != null) {
            solver.printSolution(solution);
        } else {
            System.out.println("Não há solução para o problema das N-Rainhas.");
        }
    }
}






