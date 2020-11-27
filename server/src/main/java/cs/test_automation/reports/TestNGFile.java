package cs.test_automation.reports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;
import java.net.URL;
import java.net.URI;
import java.nio.file.Paths;
import java.net.URISyntaxException;
import org.apache.log4j.Logger;

public class TestNGFile {
	private static final Logger L = Logger.getLogger(TestNGFile.class);

	private StringBuffer xmlBuffer = new StringBuffer("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\" >\n<suite name=\"Automation Test Suite\" verbose=\"2\">\n<listeners>\n<listener class-name=\"cs.test_automation.reports.PowerReporter\" />\n</listeners>\n<test name=\"End To End Tests\" parallel=\"none\" preserve-order=\"true\">\n<classes>\n");
	
	private List<String> testFileList = fileList();

	//<class name="cs.test_automation.CityU01Test"/>
	private String[] xmlItems = new String[testFileList.size()];

	private void setXmlItems() {
		int index = 0;
		for (String element: testFileList) {
			xmlItems[index] = "<class name=\"cs.test_automation." + element.substring(0, element.length() - 5) + "\"/>";
			index++;
		}
	}
	private String replaceWithOrder(int order){
		return xmlItems[order];
	}

	private List<String> fileList() {
		List<String> results = new ArrayList<String>();
		String folder = null;

		String str1 = Paths.get(".").toAbsolutePath().normalize().toString();
		boolean var1 = str1.endsWith("server");
		System.out.println("Current relative path is in server: " + var1);

		if (str1.endsWith("server")) {
			folder = "src/test/java/cs/test_automation";
		}else{
			folder = "server/src/test/java/cs/test_automation";
		}

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
		//URL url = this.getClass().getResource("/suites");

		File file = null;
		try {
			//File parentDirectory = new File(new URI(url.toString()));
			file = new File("src/main/resources/suites/testng-new.xml");
			//file = new File(parentDirectory, "testng-new.xml");
			//file = new File(url.toURI());
		} catch (Exception e) { 
			//file = new File(url.getPath());
			L.error("output testng config file", e);
		} finally {
			return file;
		}
	}

	public void generateTestNGFile(int[] bestSolution) {
		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(getFileFromURL()));

			setXmlItems();

			String s = null;
			int size = bestSolution.length;
			int index = 0;
			//System.out.println(bestSolution);
			for (int order: bestSolution) {
				index ++;
				s = replaceWithOrder(order);
				//System.out.println("from route:"+order);
				if(!s.equals("") && (index <= size)){
					//System.out.println("new line:"+s);
					xmlBuffer.append(s+"\n");
				}
				
			}
			//write contents of StringBuffer to a file
			bwr.write(xmlBuffer.toString());

			bwr.write("</classes>\n</test>\n</suite>\n");
			
			//flush the stream
			bwr.flush();
			
			//close the stream
			bwr.close();			
		}catch (IOException e) {
			L.error("output testng config file", e);
			return;
		}
		
		System.out.println("Content of StringBuffer written to File.");
	}



}