package com.plm.model;

import java.util.LinkedList;
import java.util.List;

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

	public void setB(byte b [][]){
		this.B=b;
	}
	
	public void setT(byte t [][]){
		this.T=t;
	}
	
	public byte[][] getB() {
		return B;
	}
	
	public byte[][] getT() {
		return T;
	}
	
	public int getFunctionsCount(){
		return functionsCount;
	}
	
	public int getVariablesCount(){
		return inputsCount;
	}
	
	public int getLinesCount(){
		return linesCount;
	}
	
	public List<byte []>getFunctionRows(int function){
		List<byte []> result=new LinkedList<byte[]>();
		for (int i = 0; i < linesCount; i++) {
			if(B[i][function]==1){
				byte b[]=new byte[inputsCount];
				for (int j = 0; j < b.length; j++) {
					b[j]=T[i][j];
				}
				result.add(b);
			}
		}
		return result;
	}
}
