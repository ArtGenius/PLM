package com.plm.plm_maker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import com.plm.model.ElementaryMatrix;
import com.plm.model.Matrix;
import com.plm.model.PLM;

public class Main {

	public static void main(String[] args) {
		//TODO read table from file
		PLM table=readPLM("input1.txt");
		//TODO read dimension of elementary matrix
		int vars=4;
		int functions=3;
		int lines=3;
		Decompositor decompositor= new Decompositor(table);
		if(decompositor.canBeUsed(lines, vars, functions)){
			LinkedList<ElementaryMatrix> plmList=decompositor.getPLMList(lines,vars);
			print(plmList);
		}
		else{
			System.out.println("ћетод не может быть применен!");
			return;
		}
	}
	
	private static void print(LinkedList<ElementaryMatrix> plmList) {
		for(ElementaryMatrix plm:plmList){
			System.out.print("\n");
//			for(int i=0;i<plm.getRowsCount();i++){
//				System.out.print(plm.getFunctionsSet().toArray(new Integer [0])[i]+" ");			
//			}
			plm.print();
		}		
	}

	private static PLM readPLM(String fileName){
		PLM table=new PLM(200,200,30);
		try(BufferedReader in= new BufferedReader(new FileReader(fileName))){
			int lines=Integer.parseInt(in.readLine());
			int vars=Integer.parseInt(in.readLine());
			int functions=Integer.parseInt(in.readLine());
			if(!table.setDimension(lines, vars, functions)){
				System.out.println("ѕараметры матрицы выход€т за пределы максимально допустимых.");
			}
			else{
				byte b [][]= new byte [lines][functions];
				byte t [][]= new byte [lines][vars];
				for (int i = 0; i < lines; i++) {
					String row=in.readLine();
					int j=0;
					for(char cell:row.toCharArray()){
						t[i][j++]=Byte.parseByte(cell+"");
					}
				}
				table.setT(t);
				in.readLine();
				for (int i = 0; i < lines; i++) {
					String row=in.readLine();
					int j=0;
					for(char cell:row.toCharArray()){
						b[i][j++]=Byte.parseByte(cell+"");
					}
				}
				table.setB(b);
				int elLines=Integer.parseInt(in.readLine());
				int elVars=Integer.parseInt(in.readLine());
				int elFuncs=Integer.parseInt(in.readLine());
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return table;
	}
}
