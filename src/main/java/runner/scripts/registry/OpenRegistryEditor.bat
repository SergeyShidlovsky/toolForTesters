@echo off

reg add HKCU\SOFTWARE\Microsoft\Windows\CurrentVersion\Applets\Regedit /v LastKey /t REG_SZ /d "Computer\HKEY_LOCAL_MACHINE\SOFTWARE\Corsair\Corsair Utility Engine\Driver" /f

start "title" /b regedit.exe