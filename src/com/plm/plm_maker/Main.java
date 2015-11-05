package com.plm.plm_maker;

import java.util.LinkedList;

import com.plm.model.Matrix;
import com.plm.model.PLM;

public class Main {

	public static void main(String[] args) {
		//TODO read table from file
		PLM table=new PLM(200,200,30);
		//table.setDimension(lc, ic, fc);
		//TODO read dimension of elementary matrix
		int vars=10;
		int functions=3;
		int lines=10;
		Decompositor decompositor= new Decompositor(table);
		if(decompositor.canBeUsed(lines, vars, functions)){
			LinkedList<Matrix> plmList=decompositor.getPLMList(lines,vars);
			//TODO print elementary matrixes
		}
		else{
			System.out.println("Метод не может быть применен!");
			return;
		}
	}
}
