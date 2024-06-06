# flexipillAssignment
API automation done using Restassured according to the assignment. 
Read TestSteps.docx for step by step process to run the automation program.

Steps to run the Tests
1)	Create a Maven Project in Eclipse:
    •	Open Eclipse IDE.
    •	Go to File > New > Other.
    •	Select Maven Project and click Next.
    •	Check Create a simple project (skip archetype selection) and click Next.
    •	Enter Group Id and Artifact Id for your project, then click Finish.
2)	Add Dependencies to pom.xml:
    •	Open the pom.xml file located in the root of your Maven project.
    •	Add the given dependencies (from .xml file) inside the <dependencies> tag.
  	•	Save the pom.xml file.
  	![Screenshot 2024-06-06 130525](https://github.com/Harikgit/flexipillAssignment/assets/123169169/acda0fa2-8667-4445-8f2a-b6364dd13b17)
  	
4)	Update the Maven Project:
    •	Right-click on your project in the Project Explorer.
    •	Select Maven > Update Project.
  	![Screenshot 2024-06-06 130805](https://github.com/Harikgit/flexipillAssignment/assets/123169169/f553215e-2930-48fb-9eb1-59036e157bc3)
    •	Check Force Update of Snapshots/Releases and click OK.
6)	Create a Package:
    •	In the src/test/java directory, right-click and select New > Package.
    •	Name the package loginCartOrder and click Finish.
8)	Create a New Java Class:
    •	Right-click on the loginCartOrder package and select New > Class.
    •	Name the class FlexLCO and click Finish.
  	![Screenshot 2024-06-06 124709](https://github.com/Harikgit/flexipillAssignment/assets/123169169/84a413f0-cd64-4026-a32b-124d875a4b53)
10)	Add Code to the FlexLCO.java File:
    •	Open the newly created FlexLCO.java file.
    •	Add the given code (from .java file) to the file.
    •	Save the FlexLCO.java file.
11)	Run the Test:
    •	Right-click on the FlexLCO.java file.
    •	Select Run As > TestNG Test.
   	![Screenshot 2024-06-06 131106](https://github.com/Harikgit/flexipillAssignment/assets/123169169/7437c93b-465b-41c3-a6b9-18d8dedee031)
13)	Check the Output in the Console:
    •	Open the Console view in Eclipse to see the output of your test.
    •	Ensure that the test runs successfully and the correct status code is returned.
   	![Screenshot 2024-06-06 130052](https://github.com/Harikgit/flexipillAssignment/assets/123169169/b69daea2-7f19-4fb9-b0dd-f8d6571ae9f0)
15)	Check the Emailable Report:
    •	After running the test, go to your project directory in Eclipse.
    •	Navigate to the test-output folder.
    •	Locate the emailable-report.html file.
   	![Screenshot 2024-06-06 125901](https://github.com/Harikgit/flexipillAssignment/assets/123169169/8b5a214e-f0ac-4605-b29e-41dcc7ce02a9)
    •	Open the emailable-report.html file in a web browser to view the detailed TestNG report.
   	![Screenshot 2024-06-06 131640](https://github.com/Harikgit/flexipillAssignment/assets/123169169/d8aed49a-0a8b-4cc4-a63f-24721766f141)
