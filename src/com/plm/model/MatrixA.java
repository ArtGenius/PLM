package com.plm.model;

import java.util.Set;

public class MatrixA extends Matrix {

	public MatrixA(int row, int col) {
		super(row, col);
	}

	public int getNewVarNumber(Set<Integer> rows, int row2) {
		int result = 0;
		for (int i : rows) {
			for (int j = 0; j < inputsCount; j++) {
				if (T[i][j] == 0 && T[row2][j] == 1)
					result++;
			}
		}
		return result;
	}

	public int getGeneralVarNumber(Set<Integer> rows, int row2) {
		int result = 0;
		for (int i : rows) {
			for (int j = 0; j < inputsCount; j++) {
				if (T[i][j] == 1 && T[row2][j] == 1)
					result++;
			}
		}
		return result;
	}

	public byte[][] gerMatrix() {
		return T;
	}
}
