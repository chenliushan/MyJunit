# MyJunit


This is the component of the AfTool.
Main function: Customize the Junit entry that can run the specify methods or whole classes 

Usage following command to run this tool


<code>java -cp.:AfTest/build/classes/test:lib/junit-4.11.jar:lib/MyJunit.jar:lib/hamcrest-core-1.3.jar polyu_af.MyJunitCore test.Class#method test.AnotherClass</code>

Note: the classpath should has following library: gson, hamcrest-core, junit, log4j-api, log4j-core.
