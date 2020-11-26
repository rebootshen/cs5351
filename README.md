# Test Automation and its optimization

This project is a multiple module maven project.

- selenium/           : framework to build automation test cases
- jacof/              : algorithm to solve TSP problem
- server/             : main class hold here to generate TSP data file and testng config file
- pom.xml             : maven-surefire-plugin and exec-maven-plugin will trigger main processes


## Prerequisite:

Please download chromedriver from link below:
https://chromedriver.chromium.org/downloads

Apache Maven 3.6.3

java version "1.8.0_241"


## Commands:
```
cd server
server (master) $
server (master) $ cd ../selenium; mvn install -DskipTests=true; cd ../server;
server (master) $ cd ../jacof; mvn install -DskipTests=true; cd ../server;
server (master) $ mvn test
```

## How it works?
After "mvn test", 2 main plugins will be triggered and 2 important tasks will run one after another.

A.
```
server/pom.xml
    maven-surefire-plugin
    <suiteXmlFile>src/main/resources/suites/testng-new.xml</suiteXmlFile>

server/src/test/java/cs/test_automation/reports/PowerReporter.java
    tspFile.generateTspDataFile(testClasses);

server/target/surefire-reports/power-emailable-report.html
server/src/main/java/cs/test_automation/reports/TspDataFile.java
```

"testng-new.xml" will call "PowerReporter" to generate test report "power-emailable-report".
Then "TspDataFile" will "generateTspDataFile" according to this report and get new file below.
```
server/src/main/resources/problems/tsp/cityu-new10.tsp
```


B.
```
server/pom.xml
    exec-maven-plugin
        <mainClass>cs.test_automation.AcoRun</mainClass> 

server/src/main/java/cs/test_automation/AcoRun.java
    String instance = "src/main/resources/problems/tsp/cityu-new10.tsp";
    Problem problem = new TravellingSalesmanProblem(instance);
    RankBasedAntSystem aco = new RankBasedAntSystem(problem);

    ngFile.generateTestNGFile(es.bestSolution);

jacof/src/main/java/thiagodnf/jacof/problem/tsp/TravellingSalesmanProblem.java
    updateNodesToVisit:  different start and end city

jacof/src/main/java/thiagodnf/jacof/util/io/TSPLIBReader.java
    costBenefitDistance : (y1 + y2)/10*(x1 + x2) not Euclidean
    type:  CITYU

server/src/main/java/cs/test_automation/reports/TestNGFile.java

```

"AcoRun" will use previous generated tsp file as input ,
then "TestNGFile" will "generateTestNGFile" according to result of AcoRun and get new file below:
```
server/src/main/resources/suites/testng-new.xml
```

This "getng_new.xml" will be used by next "mvn test"
