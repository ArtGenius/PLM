package com.plm.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ElementaryMatrix extends Matrix {

	private int freeInputsCount;
	private int freeOutputsCount;
	private HashMap<Integer, Integer> varSet;
	private LinkedHashSet<Integer> functionsSet;

	public ElementaryMatrix(int rows, int columns) {
		super(rows, columns);
		freeInputsCount = columns;
		freeOutputsCount = rows;
		varSet = new HashMap<Integer, Integer>();
		functionsSet = new LinkedHashSet<Integer>();
	}

	public void addFunction(MatrixA matrixA, int line) {
		byte b[][] = matrixA.gerMatrix();
		functionsSet.add(line);
		for (int j = 0; j < matrixA.getColumnsCount(); j++) {
			if (b[line][j] == 1) {
				if (!varSet.containsKey(j)) {
					varSet.put(j, inputsCount - freeInputsCount);
					freeInputsCount--;
				}
				T[linesCount - freeOutputsCount][varSet.get(j)] = 1;
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
		System.out.print(" \t");
		for (int var : this.getVarSet()) {
			System.out.print(var + "\t");
		}
		System.out.print("|");
		for (int func : this.getFunctionsSet()) {
			System.out.print(func + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i < linesCount; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < inputsCount; j++) {
				System.out.print(T[i][j] + "\t");
			}
			System.out.print("|");
			for (int j = 0; j < getFunctionsSet().size(); j++) {
				if (i == j)
					System.out.print("1\t");
				else
					System.out.print("0\t");
			}
			System.out.print("\n");
		}
	}

}
