package com.plm.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ElementaryMatrix extends Matrix{

	private int freeInputsCount;
	private int freeOutputsCount;
	private HashMap<Integer,Integer> varSet;
	private LinkedHashSet<Integer> functionsSet;
	
	public ElementaryMatrix(int rows, int columns) {
		super(rows, columns);
		freeInputsCount=columns;
		freeOutputsCount=rows;
		varSet=new HashMap<Integer,Integer>();
		functionsSet=new LinkedHashSet<Integer>();
	}

	public void addFunction(MatrixA matrixA, int line){
		byte b [][]=matrixA.gerMatrix();
		functionsSet.add(line);
		for (int j = 0; j < matrixA.getColumnsCount(); j++) {
			if(b[line][j]==1){
				if(!varSet.containsKey(j)){
					varSet.put(j,inputsCount-freeInputsCount);
					freeInputsCount--;
				}
				T[linesCount-freeOutputsCount][varSet.get(j)]=1;
			}
		}
		freeOutputsCount--;
		log.info(varSet);
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
		log.info(varSet.values());
		return new HashSet<Integer>(varSet.keySet());
	}

	public void print() {
		for(int i:functionsSet)System.out.print(i);
		System.out.println(varSet);
		for (int i = 0; i < linesCount; i++) {
			for (int j = 0; j < inputsCount; j++) {
				System.out.print(T[i][j]);
			}
			System.out.print("\n");
		}
	}
	
}
