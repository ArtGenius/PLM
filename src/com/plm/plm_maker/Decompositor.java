package com.plm.plm_maker;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import com.plm.model.Matrix;
import com.plm.model.MatrixA;
import com.plm.model.PLM;

public class Decompositor {

	private PLM table;
	private MatrixA A;
	private LinkedList<Matrix> solution;
	
	public Decompositor(PLM table){
		this.table=table;
		this.A=getMatrixA();
	}
	
	public LinkedList<Matrix> getPLMList(int lines, int variables){
		LinkedList<Matrix> solution=new LinkedList<Matrix>();
		Set<Integer> selectedRows=new HashSet<Integer>();
		while(selectedRows.size()!=A.getRowsCount()){
			
		}
		
		return solution;
	}
	
	public boolean canBeUsed(int lines, int vars, int functions){
		int [] Trangs=table.getRangsArray(table.getT());
		int [] Brangs=table.getRangsArray(table.getB());
		for (int i = 0; i < Trangs.length; i++) {
			if(Trangs[i]>vars){
				System.out.printf("Ранг %d строки превышает количество входов элементарной матрицы",i);
				return false;
			}
		}
		for (int i = 0; i < Brangs.length; i++) {
			if(Brangs[i]>functions){
				System.out.printf("Ранг %d строки превышает количество выходов элементарной матрицы",i);
				return false;
			}
		}
		return true;
	}
	
	private MatrixA getMatrixA(){
		//TODO create matrix A. Use table to do this.
		return null;
	}
}
