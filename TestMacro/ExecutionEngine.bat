@echo off
SET DEVELOPMENT_HOME= C:\Users\E004709\Selenium\Arbela_Legace_eApp
cd %DEVELOPMENT_HOME%
call  mvn clean install
call  mvn exec:java
PAUSE
