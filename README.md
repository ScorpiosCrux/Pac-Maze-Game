# TUT07---G3

1) Our code for Demo3 in our GitHub Repo is under the folder Project Final. 
2) Download the folder Project Final 
3) open the zipFile
4) in your terminal do

	i) cd Downloads
	
	ii) cd FinalDemo
5) to compile code do javac *.java
6) For Textbased Program enter java PacManMazeTextManager and follow instructions in terminal prompt
7) For GUI Version enter java Launch
	i) to view controls/goals click instructions
	ii) once you feel comfortable close the instructions window and click start

8) Our class Avatar has JUnit Tests and the Junit Tests are in our GitHub Repo under the folder JUnit test

	i) Make sure the Junit and Hamcrest jar files are in your directory
	
	ii) Compile everything (includes the junit tests) using javac -cp .:junit-4.12.jar:hamcrest-core-1.3.jar *.java
	
	iii) The file with the tests is called AvatarTest.java
	
	iv) To run the tests enter command java -cp .:junit-4.12.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore 
AvatarTest
