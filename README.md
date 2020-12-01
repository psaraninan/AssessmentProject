Execution through cmd:
1- Pull the code to your local repo
2- Open cmd,navigate to the project folder
3-Give this command in cmd: mvn test -DsuiteXmlFile=testng.xml
4-May take a while for installing dependencies.
5- Verify the results.

Execution in Eclipse IDE:
1- Pull the code to local repo
2- Import project. 
3- In cmd, navigate to project and give mvn eclipse:eclipse
4- Right click testng.xml file in the project root in Eclipse.
5- Run as >> TestNG Suite
