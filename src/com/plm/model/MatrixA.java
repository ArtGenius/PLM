package com.plm.model;

public class MatrixA extends Matrix{
	
	public MatrixA(int row, int col){
		super(row, col);
	}
	
	public int getNewVarNumber(int row1, int row2){
		int result=0;
		for (int j = 0; j < inputsCount; j++) {
			if(T[row1][j]==0&&T[row2][j]==1)result++;
		}
		return result;
	}

	public int getGeneralVarNumber(int row1, int row2){
		int result=0;
		for (int j = 0; j < inputsCount; j++) {
			if(T[row1][j]==1&&T[row2][j]==1)result++;
		}
		return result;
	}
}
