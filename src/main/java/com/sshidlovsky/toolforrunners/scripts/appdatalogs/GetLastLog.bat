
set dir1 = %localAppdata%\Corsair\CUE\logs
set dir2 = %USERPROFILE%\Desktop
setlocal enabledelayedexpansion
set /a num=0
set /a err=0
for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "%localAppdata%\Corsair\CUE\logs\*.log"') do (
set /a num+=1
if /i !num! leq 1 (
copy "%localAppdata%\Corsair\CUE\logs\%%i" "%USERPROFILE%\Desktop" > nul
if errorlevel 1 (echo %%i >> errorslog.txt
set /a err+=1
)
echo copy file...%%i) else (
echo skip file... %%i
)
)
echo COUNT OF ERRORS: %err%