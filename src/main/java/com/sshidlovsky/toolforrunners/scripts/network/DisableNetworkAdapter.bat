
@echo off

@echo Disabling network connections

netsh interface set interface "Ethernet" disabled

@echo Opening network connections

CD "C:\WINDOWS\system32"
control ncpa.cpl