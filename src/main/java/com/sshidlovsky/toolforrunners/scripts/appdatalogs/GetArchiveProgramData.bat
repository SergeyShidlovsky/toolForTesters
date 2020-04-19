@echo off
@echo Backupping ProgramData of CUE to Desktop

"C:\Program Files\WinRAR\winrar.exe" a -r -dh -ep1  "%USERPROFILE%\Desktop\ProgramData.zip"  "C:\ProgramData\Corsair\CUE"