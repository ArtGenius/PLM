package com.plm.model;

import java.util.HashSet;

public class ElementaryMatrix extends Matrix{

	private int freeInputsCount;
	private int freeOutputsCount;
	private HashSet<Integer> varSet;
	private HashSet<Integer> functionsSet;
	
	public ElementaryMatrix(int rows, int columns) {
		super(rows, columns);
		freeInputsCount=columns;
		freeOutputsCount=rows;
		varSet=new HashSet<Integer>();
		functionsSet=new HashSet<Integer>();
	}

	public void addFunction(MatrixA matrixA, int line){
		byte b [][]=matrixA.gerMatrix();
		freeOutputsCount--;
		functionsSet.add(line);
		for (int j = 0; j < matrixA.getColumnsCount(); j++) {
			if(b[line][j]==1){
				freeInputsCount--;
				T[linesCount-freeOutputsCount][j]=1;
				varSet.add(j);
			}
		}
	}
	
	public HashSet<Integer> getFunctionsSet() {
		return functionsSet;
	}

	public int getFreeInputsCount() {
		return freeInputsCount;
	}

	public int getFreeOutputsCount() {
		return freeOutputsCount;
	}

	public HashSet<Integer> getVarSet() {
		return varSet;
	}
	
}
