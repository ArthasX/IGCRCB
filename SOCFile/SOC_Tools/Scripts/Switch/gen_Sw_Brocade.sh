	(sleep 5;
	echo "admin";
	sleep 2
	echo "$1";
	sleep 5;
	echo "switchshow"
	sleep 2;
	echo "version"
	sleep 1;
	echo "cfgshow"
	sleep 2;
	echo "switchstatusshow"
	sleep 1;
	echo "chassisshow"
	sleep 1;
	echo "exit";)|telnet $2 >$3.temp.txt
	sleep 1
	sed 's///g' $3.temp.txt >$3_`date +%Y%m%d%H%M`"("2")".txt
	rm $3.temp.txt
