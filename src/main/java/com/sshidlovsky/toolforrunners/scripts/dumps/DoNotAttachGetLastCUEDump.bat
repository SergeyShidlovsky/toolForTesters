mkdir \\fs\projects\CUE3\Dump\%USERNAME%
start \\fs\projects\CUE3\Dump\%USERNAME%
set dir1 = C:\Dumps\CUEDumps
set dir2 = %USERPROFILE%\Desktop
setlocal enabledelayedexpansion
set /a num=0
set /a err=0
for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "C:\Dumps\CUEDumps\*.dmp"') do (
set /a num+=1
if /i !num! leq 1 (
copy "C:\Dumps\CUEDumps\%%i" "%USERPROFILE%\Desktop" > nul

copy "C:\Dumps\CUEDumps\%%i" "\\fs\projects\CUE3\Dump\%USERNAME%\" > nul
if errorlevel 1 (echo %%i >> errorslog.txt
set /a err+=1
)
echo copy file...%%i) else (
echo skip file... %%i
)
)
echo COUNT OF ERRORS: %err%
pause