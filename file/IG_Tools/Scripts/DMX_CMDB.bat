@ECHO OFF
for /f "tokens=1-3 delims=/" %%i in ("%DATE:~4,10%") do (
set YY=%%k
set MM=%%i
set DD=%%j)
for /f "tokens=1-2 delims=:" %%m in ("%TIME:~0,5%") do (
set HH=%%m
set MIN=%%n)

for /F "tokens=1 skip=6" %%a in ('"C:\Program Files\EMC\SYMCLI\BIN\symcfg" list') do (

echo ^<?xml version="1.0"?^> > Test.xml
echo ^<Storage label="%%a"^> >> Test.xml
echo ^<DATE^>%DATE%^</DATE^> >> Test.xml
echo ^<VER^>VER 0.1^</VER^> >> Test.xml
echo ^<SECTION label="EMC_Symmetrix"^> >> Test.xml

echo ^<COMMAND label="symcfg -sid %%a -dir all -v list"^> >> Test.xml
echo ^<LBL^>symcfg -sid %%a -dir all -v list^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symcfg -sid %%a -dir all -v list^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symcfg" -sid %%a -dir all -v list >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symdev -sid %%a list"^> >> Test.xml
echo ^<LBL^>symdev -sid %%a list^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symdev -sid %%a list^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symdev" -sid %%a list >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symdev -sid %%a list -meta"^> >> Test.xml
echo ^<LBL^>symdev -sid %%a list -meta^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symdev -sid %%a list -meta^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symdev" -sid %%a list -meta >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symdev -sid %%a list -v"^> >> Test.xml
echo ^<LBL^>symdev -sid %%a list -v^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symdev -sid %%a list -v^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symdev" -sid %%a list -v >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symdev -sid %%a -disk all list"^> >> Test.xml
echo ^<LBL^>symdev -sid %%a -disk all list^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symdev -sid %%a -disk all list^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symdev" -sid %%a -disk all list >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symdisk -sid %%a list -v"^> >> Test.xml
echo ^<LBL^>symdisk -sid %%a list -v^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symdisk -sid %%a list -v^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symdisk" -sid %%a list -v >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml

echo ^<COMMAND label="symmaskdb -sid %%a list database"^> >> Test.xml
echo ^<LBL^>symmaskdb -sid %%a list database^</LBL^> >> Test.xml
echo ^<RUN_CMD^>symmaskdb -sid %%a list database^</RUN_CMD^> >> Test.xml
echo ^<OUTPUT^> >> Test.xml
echo ^<![CDATA[ >> Test.xml
"C:\Program Files\EMC\SYMCLI\BIN\symmaskdb" -sid %%a list database >> Test.xml
echo ]]^>^</OUTPUT^> >> Test.xml
echo ^</COMMAND^> >> Test.xml


echo ^</SECTION^> >> Test.xml

echo ^</Storage^> >> Test.xml

rename Test.xml %%a_%YY%%MM%%DD%%HH%%MIN%.xml
del Test.xml
)