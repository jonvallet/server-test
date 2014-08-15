1. Building the project
  -You will need a gradle 1.10+ installed and available in your path.
  -Also you will need java JDK 1.7 or greater.
  -For building the project, just run the "gradle build" command in the project root folder.
  -For building the binaries artifacts, use the "gradle war" command.

2. You can find the rest service source under the folder src/main/java/com/jonvallet/rest/api/services

3. All the junit tests can be found at src/test/java/com/jonvallet/rest/api/services

4. Build artifacts can be found at build/libs folder.

5. Installation
  -The application is packaged as a war file (server-test-1.0.war).
  -You can deploy at it is in a Wildfly 8.0+ or jboss-eap-6.1 or greater.
  -To access the index page go to <server-address>/server-test-1.0.
  -Other application servers I have not tested, but if they implement jsr311-api version 1.1.1 it should work.
