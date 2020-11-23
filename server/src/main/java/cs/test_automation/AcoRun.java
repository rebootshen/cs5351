package cs.test_automation;

import java.io.IOException;

import org.apache.commons.cli.ParseException;
import org.apache.log4j.Logger;

import thiagodnf.jacof.aco.RankBasedAntSystem;
import thiagodnf.jacof.problem.Problem;
import thiagodnf.jacof.problem.tsp.TravellingSalesmanProblem;
import thiagodnf.jacof.util.ExecutionStats;
import cs.test_automation.reports.TestNGFile;

import java.util.Arrays;

public class AcoRun {

	/** The class logger*/
	static final Logger LOGGER = Logger.getLogger(AcoRun.class);


	// public void generateTspDataFile() {

		
	// 	System.out.println("Sorry, now is empty. Content of StringBuffer written to File.");
	// }

	public static void main(String[] args) throws ParseException, IOException {

		System.out.println("AcoRun !");
		TestNGFile ngFile = new TestNGFile();
		//acorun.generateTspDataFile();
		
		//String instance = "src/main/resources/problems/tsp/oliver30.tsp";
		String instance = "src/main/resources/problems/tsp/cityu-new10.tsp";
		Problem problem = new TravellingSalesmanProblem(instance);
		RankBasedAntSystem aco = new RankBasedAntSystem(problem);

		aco.setNumberOfAnts(10);
		aco.setNumberOfIterations(50);
		aco.setAlpha(1.0);
		aco.setBeta(2.0);
		aco.setRho(0.1);
		aco.setWeight(10);
		
		ExecutionStats es = ExecutionStats.execute(aco, problem);
		es.printStats();

		System.out.println(Arrays.toString(es.bestSolution));
		ngFile.generateTestNGFile(es.bestSolution);
	}

}
