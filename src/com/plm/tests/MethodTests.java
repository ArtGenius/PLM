package com.plm.tests;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import org.junit.Test;

import com.plm.model.ElementaryMatrix;
import com.plm.model.Matrix;
import com.plm.model.MatrixA;
import com.plm.model.PLM;
import com.plm.plm_maker.Decompositor;

public class MethodTests {

	
	public static void main(String [] args){	
		Decompositor decompositor=new Decompositor(new PLM(100, 100, 100));
		decompositor.setA(givenMatrixA("A.txt"));
		thenPrintPLM(decompositor.getPLMList(4, 6));
		//fail("Not yet implemented");
	}

	private static void thenPrintPLM(LinkedList<ElementaryMatrix> plmList) {
		for(ElementaryMatrix m:plmList){
			m.print();
			System.out.println();
		}
	}

	private static MatrixA givenMatrixA(String fileName){
		MatrixA m=null;
		try(BufferedReader in=new BufferedReader(new FileReader(fileName))){
			m=new MatrixA(10, 15);
			for (int i = 0; i <10 ; i++) {
				String s=in.readLine();
				int j=0;
				for (char c: s.toCharArray()) {
					m.setCell(i, j, Byte.parseByte(c+""));
					j++;
				}
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}
}
