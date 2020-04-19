@echo off
taskkill /f /im CUE.exe /t

@echo off
@echo next operaton will be strted after 3 second pass
Ping -n 3 127.0.0.1 > nul
@echo on

@echo Stopping Corsair Service
net stop CorsairService

@echo off
@echo next operaton will be strted after 2 second pass
Ping -n 2 127.0.0.1 > nul
@echo on

@echo ProgramData folders will be cleared
@echo off
CD C:\ProgramData\
SET mypath=%~dp0
@echo on

RD /S /Q "C:\ProgramData\CLink\"
@echo off
Ping -n 4 127.0.0.1 > nul
@echo CLink folder is cleared
@echo on

@echo off
@echo ProgrammData/Corsair  folder will be cleared
SET mypath=%~dp0

RD /S /Q  "C:\ProgramData\Corsair\CUE\Service logs"
CD /S /Q "C:\ProgramData\Corsair\CUE"

for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "C:\ProgramData\Corsair\CUE\Settings\*.*"') do (
set /a num+=1
if /i !num! leq 5  del "C:\ProgramData\Corsair\CUE\Settings\%%i"  > nul
)

@echo DebugLogging Is Disabled

Ping -n 3 127.0.0.1 > nul
@echo ProgrammData/Corsair folder is cleared
@echo on

net start CorsairService

@echo off
Ping -n 1 127.0.0.1 > nul
@echo on