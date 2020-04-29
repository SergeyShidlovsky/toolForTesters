setlocal enabledelayedexpansion
set /a num=0
set /a err=0

echo copy setuapi.dev.log to Desktop

copy "%Systemroot%\Inf\setupapi.dev.log" "%USERPROFILE%\Desktop"

start %Systemroot%\Inf\