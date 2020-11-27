package cs.test_automation.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import java.net.URL;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.apache.log4j.Logger;

public class TspDataFile {
	private static final Logger L = Logger.getLogger(TspDataFile.class);

	private StringBuffer tspBuffer = new StringBuffer("NAME: cityu10\nCOMMENT : 10 locations\nCOMMENT : Best: 384.43\nTYPE: TSP\nDIMENSION: 10\nEDGE_WEIGHT_TYPE: CITYU\nNODE_COORD_SECTION\n");
	private List<String> testFileList = fileList();

	private String replaceWithOrder(String testClassName){
		//System.out.println(testClassName);
		String[] split = testClassName.split(" ");
		String testClass = split[0].trim()+".java";

		int index = 0;
		for (String element: testFileList) {
			index ++;
			//System.out.println(testClass +" contains "+ element + ":" + testClass.contains(element));
			if(testClass.contains(element)){
				return index+" "+split[1].trim()+ " "+split[2].trim()+"\n";
			}
		}
		return "";
	}

	private List<String> fileList() {
		List<String> results = new ArrayList<String>();

		String folder = getFileWithModule("src/test/java/cs/test_automation");

		File[] files = new File(folder).listFiles((dir, name) -> name.endsWith("Test.java"));
		//If this pathname does not denote a directory, then listFiles() returns null. 

		Arrays.sort(files);
		for (File file : files) {
			if (file.isFile()) {
				results.add(file.getName());
			}
		}

		return results;
	}

	private File getFileFromURL() {

		File file = null;
		try {
			String tspfile = getFileWithModule("src/main/resources/problems/tsp/cityu-new10.tsp");

			file = new File(tspfile);
		} catch (Exception e) { 
			L.error("output tsp data file", e);
		} finally {
			return file;
		}
	}

	private String getFileWithModule(String name){
		String filename = null;
		String str1 = Paths.get(".").toAbsolutePath().normalize().toString();
		if (str1.endsWith("server")) {
			filename = name;
		}else{
			filename = "server/"+name;
		}
		return filename;
	}

	public void generateTspDataFile(List<String> testClasses) {
		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(getFileFromURL()));

			String[] array = new String[testClasses.size()];
			testClasses.toArray(array);
			Arrays.sort(array);
			int index = 0;
			int order = 0;
			String s = null;
			for (String element: array) {
				index ++;
				//System.out.println(element);
				s = replaceWithOrder(element);
				if(!s.equals("")){
					//System.out.println("new line:"+s);
					tspBuffer.append(s);
				}
			}
			//write contents of StringBuffer to a file
			bwr.write(tspBuffer.toString());
			
			//flush the stream
			bwr.flush();
			
			//close the stream
			bwr.close();			
		}catch (IOException e) {
			L.error("output tsp data file", e);
			return;
		}
		
		System.out.println("Content of StringBuffer written to File.");
	}

}