package com.plm.model;

import org.apache.log4j.Logger;

public class Matrix {

	protected int inputsCount;
	protected int linesCount;
	protected byte T[][];

	static Logger log = Logger.getLogger(Matrix.class.getName());

	public Matrix() {

	}
	
	public int [] getRangsArray(byte matrix[][]){
		int [] rangs=new int [linesCount];
		for (int i = 0; i < rangs.length; i++) {
			for (int j = 0; j < inputsCount; j++) {
				if(matrix[i][j]==1)rangs[i]++;
			}
		}
		//Arrays.sort(rangs);
		return rangs;
	}
	
	public Matrix(int rows, int columns) {
		inputsCount = columns;
		linesCount = rows;
	}

	public boolean setCell(int currentRow, int currentColl, byte cellValue) {
		T[currentRow][currentColl] = cellValue;
		return true;
	}
	
	public int getColumnsCount() {
		return inputsCount;
	}

	public int getRowsCount() {
		return linesCount;
	}
}