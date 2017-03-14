ECHO OFF

for /f "tokens=1-3 delims=/-" %%i in ("%DATE:~4,10%") do (
set YY=%%k
set MM=%%i
set DD=%%j)

for /f "tokens=1-2 delims=: " %%m in ("%TIME:~0,5%") do (
set MIN=%%n
if %%m lss 10 (set HH=0%%m) else (set HH=%%m)
)

set FTPSRV=10.1.7.109
set PERFUPFOLDER=Dashboard
set FTPSRVUSER=emcsoc
set FTPSRVPASS=emcsoc

for /F %%a in (DMXDynamic.txt) do (
"C:\Program Files\EMC\SYMCLI\BIN\symstat" -sid %%a -i 5 -c 1 > D:\DynamicPerf_%%a_600.txt
move D:\DynamicPerf_%%a_600.txt D:\DynamicPerf_%%a_600_%YY%%MM%%DD%%HH%%MIN%.txt


echo open %FTPSRV% >ftp.ini
echo %FTPSRVUSER%>>ftp.ini
echo %FTPSRVPASS%>>ftp.ini
echo binary>>ftp.ini
echo prompt>>ftp.ini
echo cd %PERFUPFOLDER%>>ftp.ini
echo put DynamicPerf_%%a_600_%YY%%MM%%DD%%HH%%MIN%.txt>>ftp.ini
echo close>>ftp.ini
echo bye>>ftp.ini
ftp -s:ftp.ini
del ftp.ini

del DynamicPerf_%%a_600_%YY%%MM%%DD%%HH%%MIN%.txt
)
