ECHO OFF
for /f "tokens=1-3 delims=/-" %%i in ("%DATE:~4,10%") do (
set YY=%%k
set MM=%%i
set DD=%%j)

for /f "tokens=1-2 delims=: " %%m in ("%TIME:~0,5%") do (
set MIN=%%n
if %%m lss 10 (set HH=0%%m) else (set HH=%%m)
)

for /F "tokens=1 skip=6" %%a in ('"C:\Program Files\EMC\SYMCLI\BIN\symcfg" list') do (
"C:\Program Files\EMC\SYMCLI\BIN\symstat" -sid %%a -i 5 -c 1 > E:\SOCUpload\DashBoardTemp\DynamicPerf_%%a_600.txt
move E:\SOCUpload\DashBoardTemp\DynamicPerf_%%a_600.txt E:\SOCUpload\DashBoard\DynamicPerf_%%a_600_%YY%%MM%%DD%%HH%%MIN%.txt
)
