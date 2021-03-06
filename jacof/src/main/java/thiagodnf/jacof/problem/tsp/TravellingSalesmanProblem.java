package thiagodnf.jacof.problem.tsp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import thiagodnf.jacof.problem.Problem;
import thiagodnf.jacof.util.NearestNeighbour;
import thiagodnf.jacof.util.io.InstanceReader;
import thiagodnf.jacof.util.io.TSPLIBReader;

/**
 * The Travelling Salesman Problem Class
 * 
 * @author Thiago Nascimento
 * @since 2014-07-27
 * @version 1.0
 */
public class TravellingSalesmanProblem extends Problem {

	public double Q = 1.0;
	
	/** Distance Matrix */
	protected double[][] distance;

	/** Number of Cities */
	protected int numberOfCities;
	
	/** Nearest Neighbour heuristic */
	protected double cnn;

	protected String type;
	
	public TravellingSalesmanProblem(String filename) throws IOException {
		this(filename, false);
	}

	public TravellingSalesmanProblem(String filename,boolean isTspLibFormmat) throws IOException {
		
		TSPLIBReader r = new TSPLIBReader(new InstanceReader(new File(filename)));
		
		numberOfCities = r.getDimension();
		type = r.getType();
		
		distance = r.getDistance();		
				
		NearestNeighbour nn = new NearestNeighbour();		
		
		this.cnn = evaluate(nn.solve(this));

		System.out.println("1 Best Solution: " + Arrays.toString(getTheBestSolution()));
		System.out.println("1 Best Value: " + evaluate(getTheBestSolution()));
	}
	
	@Override
	public double getNij(int i, int j) {
		return 1.0 / distance[i][j];
	}

	@Override
	public boolean better(double s1, double best) {
		return s1 < best;
	}
	
	public double getDistance(int i, int j) {
		return this.distance[i][j];
	}
	
	public int[] getTheBestSolution(){
		int [] myIntArray = null;

		if("EUC_2D".contains(type)){
			myIntArray =IntStream.range(0, numberOfCities+1).toArray();
			myIntArray[numberOfCities]=0;
		}else{
			myIntArray =IntStream.range(0, numberOfCities).toArray();
		}
		System.out.println("getTheBest:" +Arrays.toString(myIntArray));
		return myIntArray;

		//return new int[]{0,2,3,4,5,6,7,8,9,1,0};
		//return new int[]{0,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,24,23,25,26,27,28,29,1, 0};

		
	}
	
	@Override
	public double evaluate(int[] solution) {
		
		double totalDistance = 0;

		//System.out.println("evaluate:======= solution.length:"+solution.length+" numberOfCities:"+numberOfCities);

		for (int h = 1; h < solution.length; h++) {
			
			int i = solution[h - 1];
			int j = solution[h];
			
			//System.out.println("evaluate:======= distance["+i+"]["+j+"]");
			totalDistance += distance[i][j];
			//System.out.println("evaluate:======= distance["+i+"]["+j+"]:"+distance[i][j]);
		}
		
		return totalDistance;
	}

	@Override
	public int getNumberOfNodes() {
		return numberOfCities;
	}

	@Override
	public double getCnn() {
		return cnn;
	}

	@Override
	public double getDeltaTau(double tourLength, int i, int j) {
		return Q / tourLength;
	}

	@Override
	public String toString() {
		return TravellingSalesmanProblem.class.getSimpleName();
	}

	@Override
	public List<Integer> initNodesToVisit(int startingNode) {
		
		List<Integer> nodesToVisit = new ArrayList<>();

		// Add all nodes (or cities) less the start node
		for (int i = 0; i < getNumberOfNodes(); i++) {
			if (i != startingNode) {
				nodesToVisit.add(new Integer(i));
			}
		}

		return nodesToVisit;
	}

	@Override
	public List<Integer> updateNodesToVisit(List<Integer> tour, List<Integer> nodesToVisit) {
		//System.out.println(type);
		if("EUC_2D".contains(type)){
			if (nodesToVisit.isEmpty()) {
				if (!tour.get(0).equals(tour.get(tour.size() - 1))) {
					nodesToVisit.add(tour.get(0));
				}
			}
		}

		
		return nodesToVisit;
	}	
}