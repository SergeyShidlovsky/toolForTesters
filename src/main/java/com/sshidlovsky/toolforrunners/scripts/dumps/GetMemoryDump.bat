mkdir \\fs\projects\CUE3\Dump\%USERNAME%
start \\fs\projects\CUE3\Dump\%USERNAME%
set dir1 = %SystemRoot%
set dir2 = %USERPROFILE%\Desktop
setlocal enabledelayedexpansion


"C:\Program Files\WinRAR\winrar.exe" a -r -dh -ep1  "%localAppdata%\Temp\MEMORY.zip"  "%SystemRoot%\MEMORY.DMP"


copy "%localAppdata%\Temp\MEMORY.zip" "\\fs\projects\CUE3\Dump\%USERNAME%\" > nul
copy ""%SystemRoot%\MEMORY.DMP"" "%USERPROFILE%\Desktop" > nul

del "%localAppdata%\Temp\MEMORY.zip"