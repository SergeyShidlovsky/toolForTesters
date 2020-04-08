setlocal enabledelayedexpansion
set /a num=0
set /a err=0

echo COLLECTING INF FILES TO DESCTOP and COPING INSTALLATION LOGS

for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "%SystemRoot%\Inf\*.inf"') do (
set /a num+=1
if /i !num! leq 3 (
copy "%Systemroot%\Inf\%%i" "%USERPROFILE%\Desktop" > nul

if errorlevel 1 (echo %%i >> errorslog.txt
set /a err+=1
)

echo copy file...%%i) else (
echo skip file... %%i
)
)
copy "%Systemroot%\Inf\setupapi.dev.log" "%USERPROFILE%\Desktop"

echo COUNT OF ERRORS: %err%

start %Systemroot%\Inf\