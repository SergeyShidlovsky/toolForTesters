mkdir \\fs\projects\CUE3\Dump\%USERNAME%
start \\fs\projects\CUE3\Dump\%USERNAME%
set dir1 = %localAppdata%\Temp
set dir2 = %USERPROFILE%\Desktop
setlocal enabledelayedexpansion
set /a num=0
set /a err=0
for /f "tokens=* delims=" %%i in ('dir /b /o:-d /t:W "%localAppdata%\Temp\*.dmp"') do (
set /a num+=1
if /i !num! leq 1 (
copy "%localAppdata%\Temp\%%i" "%USERPROFILE%\Desktop" > nul

"C:\Program Files\WinRAR\winrar.exe" a -r -dh -ep1  "%localAppdata%\Temp\CUEexe.zip"  "%localAppdata%\Temp\%%i"


copy "%localAppdata%\Temp\CUEexe.zip" "\\fs\projects\CUE3\Dump\%USERNAME%\" > nul

del "%localAppdata%\Temp\CUEexe.zip"

if errorlevel 1 (echo %%i >> errorslog.txt
set /a err+=1
)
echo copy file...%%i) else (
echo skip file... %%i
)
)
echo COUNT OF ERRORS: %err%