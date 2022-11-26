@echo appdata will be cleared

@echo off
taskkill /f /im CUE.exe /t
CD %AppData%
RD /S /Q %AppData%\Corsair
@echo on

@echo off
@echo next operaton will be strted after 3 second pass
Ping -n 3 127.0.0.1 > nul
@echo on

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