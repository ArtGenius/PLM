package com.plm.model;

public class PLM extends Matrix {

	private int maxFunctionsCount;
	private int maxLinesCount;
	private int maxInputsCount;
	private int functionsCount;
	private byte B[][];

	public PLM(int maxFunctionsCount, int maxLinesCount, int maxInputsCount) {
		super();
		this.maxFunctionsCount = maxFunctionsCount;
		this.maxLinesCount = maxLinesCount;
		this.maxInputsCount = maxInputsCount;
	}

	public boolean setDimension(int lc, int ic, int fc) {
		if (ic > maxInputsCount || lc > maxLinesCount || fc > maxFunctionsCount) {
			return false;
		} else {
			this.inputsCount = ic;
			this.functionsCount = fc;
			this.linesCount = lc;
			T = new byte[linesCount][inputsCount];
			B = new byte[linesCount][functionsCount];
			return true;
		}
	}

	public byte[][] getB() {
		return B;
	}
	
	public byte[][] getT() {
		return T;
	}
}
