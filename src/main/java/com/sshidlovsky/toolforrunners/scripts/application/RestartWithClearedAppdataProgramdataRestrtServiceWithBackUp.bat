@echo off

@echo STAGE1.DATA BACKUP

@echo Application will be Killed if it is haven't been stopped
taskkill /f /im CUE.exe /t

@echo Checking current System Date and Time
for /f "delims=." %%i in ('wmic.exe OS get LocalDateTime ^| find "."') do set sDateTime=%%i

set dd=%sDateTime%

set day=%dd:~6,2%
set month=%dd:~4,2%
set year=%dd:~0,4%

SET hour=%dd:~8,2%
SET minute=%dd:~10,2%
SET sec=%dd:~12,2%

echo %day%-%month%-%year%-%hour%-%minute%-%sec%

@echo Backuping ProgramData of CUE to BackUp Folder
CD "%APPDATA%"
mkdir "%APPDATA%\ToolForTesters\CorsairTemp"
mkdir "%APPDATA%\ToolForTesters\CorsairTemp\ProgramData"

CD "C:\ProgramData\Corsair\"
xcopy "C:\ProgramData\Corsair\CUE" "%APPDATA%\ToolForTesters\CorsairTemp\ProgramData"  /S /E

@echo Backuping AppData of CUE to BackUp Folder
CD "%APPDATA%"
mkdir "%APPDATA%\ToolForTesters\CorsairTemp\AppData"

CD "%APPDATA%\Corsair\"
xcopy "%APPDATA%\Corsair\CUE" "%APPDATA%\ToolForTesters\CorsairTemp\AppData"  /S /E

@echo Collecting AppData and Programdata of CUE to Collective Archive
"C:\Program Files\WinRAR\winrar.exe" a -r -dh -ep1  "%APPDATA%\ToolForTesters\"%day%-%month%-%year%"-"%hour%h-%minute%m-%sec%s-"CollectCorsair.zip"  "%APPDATA%\ToolForTesters\CorsairTemp"

@echo Deleting Data From TempFolder
CD "%APPDATA%\ToolForTesters\CorsairTemp"
RD /S /Q "%APPDATA%\ToolForTesters\CorsairTemp\ProgramData"
RD /S /Q "%APPDATA%\ToolForTesters\CorsairTemp\AppData"

@echo Selecting last 5 Application and Prograam Data
CD "%APPDATA%\ToolForTesters\"
setlocal enabledelayedexpansion
set /a num=0
for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "%APPDATA%\ToolForTesters\*.zip"') do (
set /a num+=1
if /i !num! leq 5 (
move /y "%APPDATA%\ToolForTesters\%%i" "%APPDATA%\ToolForTesters\CorsairTemp" > nul

del "%APPDATA%\ToolForTesters\%%i" > nul

echo copy file...%%i) else (
echo skip file... %%i)
)

@echo Deleting OLD Application and ProgramData
del "%APPDATA%\ToolForTesters\*.zip"

@echo Moving Application and ProgrammData
move /y "%APPDATA%\ToolForTesters\CorsairTemp\*.zip" "%APPDATA%\ToolForTesters\" > nul

@echo Removing Temporary Folder
RD /S /Q "%APPDATA%\ToolForTesters\CorsairTemp\"


@echo STAGE2.DATA DELETION AND SERVICE RESTARTING

@echo off
@echo Service will be stopped

net stop CorsairService

@echo off
@echo next operaton will be strted after 2 second pass
Ping -n 2 127.0.0.1 > nul
@echo on


@echo off
@echo AppData will be cleared
CD %AppData%
RD /S /Q %AppData%\Corsair
@echo off
@echo next operaton will be strted after 3 second pass
Ping -n 3 127.0.0.1 > nul
@echo AppData is cleared
@echo on

@echo Clink ProgramData folders will be cleared
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
CD /S /Q "C:\ProgramData\Corsair\CUE\Settings"

for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "C:\ProgramData\Corsair\CUE\Settings\*.*"') do (
del "C:\ProgramData\Corsair\CUE\Settings\%%i"  > nul
)

@echo DebugLogging Is Disabled

Ping -n 3 127.0.0.1 > nul
@echo ProgrammData/Corsair folder is cleared
@echo on

net start CorsairService

@echo off
Ping -n 1 127.0.0.1 > nul
@echo on

rem :: @echo off
rem :: @echo CUE is started
rem :: Ping -n 1 127.0.0.1 > nul
rem :: CD "C:\Program Files (x86)\Corsair\Corsair Utility Engine"
rem :: start CUE.exe