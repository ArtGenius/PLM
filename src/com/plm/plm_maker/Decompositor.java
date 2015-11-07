package com.plm.plm_maker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import com.plm.model.ElementaryMatrix;
import com.plm.model.Matrix;
import com.plm.model.MatrixA;
import com.plm.model.PLM;

public class Decompositor {

	public class ON {
		private int o;
		private int n;

		public ON(int o, int n) {
			this.o = o;
			this.n = n;
		}
	}

	private PLM table;
	private MatrixA A;
	private Map<Integer, Integer> rangs;
	private Set<Integer> unselectedRows = new HashSet<Integer>();

	private static Logger LOG = Logger.getLogger(Matrix.class.getName());

	public Decompositor(PLM table) {
		this.table = table;
		this.A = getMatrixA();
		rangs = table.getRangs(A.gerMatrix());
	}

	public LinkedList<Matrix> getPLMList(int lines, int variables) {
		LinkedList<Matrix> solution = new LinkedList<Matrix>();
		while (true) {
			if (unselectedRows.size() == 0)
				return solution;
			// 4
			ElementaryMatrix elementaryMatrix = new ElementaryMatrix(lines,
					variables);
			LOG.info("adding first line to elementary matrix");
			elementaryMatrix.addFunction(A, selectFirst());
			while (elementaryMatrix.getFreeOutputsCount() != 0) {
				// 5
				if (unselectedRows.size() == 0) {
					solution.add(elementaryMatrix);
					return solution;
				}
				// 6 count o n
				LOG.info("count number of new and general variables");
				HashMap<Integer, ON> on = countON(elementaryMatrix.getVarSet());
				// 7 exclude
				LOG.info("exclude rows with number of new variables greater than free inputs count");
				on = excludeRows(on, elementaryMatrix.getFreeInputsCount());
				// 8 next line
				LOG.info("select next line");
				int next = selectNext(on);
				if (next != -1)
					elementaryMatrix.addFunction(A, next);
				else
					break;
			}
			LOG.info("add elementary matrix to solution");
			solution.add(elementaryMatrix);
		}
	}

	public boolean canBeUsed(int lines, int vars, int functions) {
		Map<Integer, Integer> Brangs = table.getRangs(table.getB());
		for (int i : rangs.keySet()) {
			if (rangs.get(i) > vars) {
				System.out.printf("Ранг %d строки превышает количество входов элементарной матрицы",i);
				return false;
			}
		}
		for (int i : Brangs.keySet()) {
			if (Brangs.get(i) > functions) {
				System.out.printf("Ранг %d строки превышает количество выходов элементарной матрицы",i);
				return false;
			}
		}
		return true;
	}

	private MatrixA getMatrixA() {
		// TODO create matrix A. Use table to do this.
		LOG.info("creating matrix A");
		return null;
	}

	private int selectFirst() {
		int maxRang = 0;
		int result = 0;
		for (int i : rangs.keySet()) {
			if (!unselectedRows.contains(i))
				continue;
			if (maxRang < rangs.get(i)) {
				maxRang = rangs.get(i);
				result = i;
			}
		}
		unselectedRows.remove(result);
		return result;
	}

	private HashMap<Integer, ON> countON(Set<Integer> includedVars) {
		HashMap<Integer, ON> reult = new HashMap<Integer, ON>();
		for (int i : unselectedRows) {
			reult.put(
					i,
					new ON(A.getGeneralVarNumber(includedVars, i), A
							.getNewVarNumber(includedVars, i)));
		}
		return reult;
	}

	private HashMap<Integer, ON> excludeRows(HashMap<Integer, ON> on,
			int freeInputs) {
		for (int i : on.keySet()) {
			if (on.get(i).n > freeInputs)
				on.remove(i);
		}
		return on;
	}

	private int selectNext(HashMap<Integer, ON> on) {
		int maxO = 0;
		int minN = 0;
		if (on.size() == 0)
			return -1;
		for (int i : on.keySet()) {
			if (on.get(i).o > maxO) {
				maxO = on.get(i).o;
				minN = on.get(i).n;
			}
		}
		for (int i : on.keySet()) {
			if (on.get(i).o == maxO && on.get(i).n < minN)
				minN = on.get(i).n;
		}
		for (int i : on.keySet()) {
			if (on.get(i).o == maxO && on.get(i).n == minN)
				return i;
		}
		return -1;
	}
	
	//use for tests only
	@Deprecated
	public void setA(MatrixA m){
		this.A=m;
	}
}
