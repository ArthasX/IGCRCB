if [ $# = 3 ]
then
	(sleep 5;
	echo "admin";
	sleep 2
	echo "$1";
	sleep 5;
	echo "show flogi database"  
	echo "          "
	sleep 5;
	echo "show version"
	echo "          "
	sleep 5;
	echo "show zoneset"
	echo "          "
	sleep 5;
	echo "show environment fan"
	echo "          "
	sleep 5;
	echo "show environment power"
	echo "          "
	sleep 5;
	echo "show environment temperature"
	echo "          "
	sleep 5;
	echo "exit";)|telnet $2 >$3.temp.txt
	sleep 2
	sed 's///g' $3.temp.txt >$3.`date +%Y%m%d`.txt
	rm $3.temp.txt
else
	echo "gen_Sw_Cisco.sh SWPass SWIP SWName"
fi
