package com.plm.model;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Matrix {

	protected int inputsCount;
	protected int linesCount;
	protected byte T[][];

	static Logger log = Logger.getLogger(Matrix.class.getName());

	public Matrix() {

	}
	
	public Map <Integer, Integer> getRangs(byte matrix[][]){
		Map<Integer, Integer> rangs=new HashMap<Integer, Integer>();
		for (int i = 0; i < linesCount; i++) {
			int cnt =0;
			for (int j = 0; j < inputsCount; j++) {
				if(matrix[i][j]==1)cnt++;
			}
			rangs.put(i, cnt);
		}
		return rangs;
	}
	
	public Matrix(int rows, int columns) {
		inputsCount = columns;
		linesCount = rows;
		T=new byte[rows][columns];
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