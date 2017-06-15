if [ $# = 3 ]
then
	(sleep 5;
	echo "admin";
	sleep 2
	echo "$1";
	sleep 5;
	echo "switchshow"
	sleep 5;
	echo "version"
	sleep 5;
	echo "cfgshow"
	sleep 5;
	echo "switchstatusshow"
	sleep 5;
	echo "chassisshow"
	sleep 5;
	echo "exit";)|telnet $2 >$3.temp.txt
	sleep 2
	sed 's///g' $3.temp.txt >$3.`date +%Y%m%d`.txt
	rm $3.temp.txt
else
	echo "gen_Sw_Borcade.sh SWPass SWIP SWName"
fi
