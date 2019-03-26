@echo off
SET DEVELOPMENT_HOME= C:\Users\E001741\Desktop\Arbella\Automation\Arbella_Legacy_eApp_Regression\Arbella_Legacy_eApp_Regression\
cd %DEVELOPMENT_HOME%
call  mvn test
call  mvn exec:java
PAUSE
