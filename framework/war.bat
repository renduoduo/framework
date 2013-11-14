@echo off
set env=%1
if "%env%"=="" set env=test
@echo on
gradle war -Denv=%env%
