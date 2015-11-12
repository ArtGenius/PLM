package com.plm.model;

import java.util.List;
import java.util.Set;

public class MatrixA extends Matrix {

	public MatrixA(int row, int col) {
		super(row, col);
	}

	public int getNewVarNumber(Set<Integer> rows, int row2) {
		int result = 0;
			for (int j = 0; j < inputsCount; j++) {
				if (!rows.contains(j)&&T[row2][j]==1)
					result++;
			}
		return result;
	}

	public int getGeneralVarNumber(Set<Integer> rows, int row2) {
		int result = 0;
			for (int j = 0; j < inputsCount; j++) {
				if (rows.contains(j)&&T[row2][j]==1)
					result++;
			}
		return result;
	}

	public byte[][] gerMatrix() {
		return T;
	}
	
	public void setRow(int row, List<byte[]> rows){
		for (int i = 0; i < rows.size(); i++) {
			for (int j = 0; j < inputsCount; j++) {
				if(rows.get(i)[j]==1)T[row][j]=1;
			}
		}
	}
}
