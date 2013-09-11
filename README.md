# Kulana

Kulana is a Java-based framework used for both Web UI testing, using the Selenium Webdriver API, and REST/SOAP services 
testing, using the Rest-Assured and SoapUI frameworks. Kulana provides useful logging and reporting functionality, providing 
QA teams with detailed information about the tested application using email reports, along with logs and screenshots.

## Requirements
* JDK 1.6 + 
* Apache Maven 3.0.5 +
* Selenium server [Mac](https://www.dropbox.com/s/67i11zmq7ls7e9f/selenium-server-2.33.0-mac.zip)/[Windows](https://www.dropbox.com/s/2aj3n6mb4snal5i/selenium-server-2.33.0-windows.zip)
* Latest versions of browsers Google Chrome or Mozilla Firefox

## Quick start
To generate the Kulana project archetype:
* Clone the repo: `https://github.com/thpii/kulana-archetype.git`
* Download appropriate Selenium server from above links and run it by `start-selenium.bat` on Windows or `start.sh` on Mac
* Navigate to the cloned repo on local machine (where pom.xml is located) and execute:

```
mvn install
```
* Navigate to the folder where your project will be generated and execute (you need to specify you project data for last 5
attributes, DO NOT forget to use quotes if values contain whitespaces):

```
mvn archetype:generate -DarchetypeGroupId=com.thpii \
                       -DarchetypeArtifactId=kulana \
                       -DarchetypeVersion=1.0 \
                       -DgroupId=<your_groupId> \ 
                       -DartifactId=<your_artifactId> \ 
                       -Dname="<you_proj_name>" \
                       -Durl=<your_proj_url> \
                       -Dversion=<your_proj_version>
```
* Connect eclipse workspace with local maven repo execute:

```
mvn -Declipse.workspace=<abolute_path_to_workspace> eclipse:add-maven-repo
```
* Go to generated project folder (where pom.xml is located) and execute:

```
mvn clean eclipse:eclipse
```
* Import generated project as existing Java project into eclipse
* Install TestNG pluging for Eclipse using official [guide](http://testng.org/doc/download.html)

## Initial project configuration
Before you can run first demo test located in Kulana archetype, you need to specify some configuration attributes (in src/main/resources/_config.properties)
* default_url - base URL of tested application (e.g.: `http://google.com/`)
* default_browser - browser used for testing (`chrome/firefox/iexplore`)
* default_selenium_host - selenium server URL (default: `http://localhost:4444/wd/hub`)
* default_report_url - used for Jenkins integration (may set as `n/a` for now)
* default_jira_url - used for JIRA integration (may set as `n/a` for now)
* default_email_list - comma-separated list of emails for reports (e.g.: `email1@gmail.com,email2@gmail.com`)
* default_sender_email - gmail user name to send reports from (e.g.: `qa.report.user`)
* default_sender_email - gmail user password to send reports from

Also, you need to specify email report title (in src/main/resources/_email.properties)
* title - report email title

##Demo test launch

* Check that Selenium server is started

To run demo tests from Eclipse
* In Eclipse, select "src/test/reources/TestNG_suites/demo.xml" and run as TestNG suite

To run demo from command line
* Navigate to the folder of your project
* type "mvn -Dsuite=demo test"

