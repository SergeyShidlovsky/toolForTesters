@echo off

@echo Enabling network adapter

netsh interface set interface "Ethernet" enabled

@echo Opening network connections

CD "C:\WINDOWS\system32"
control ncpa.cpl