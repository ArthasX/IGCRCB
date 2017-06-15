#!/bin/sh
PERFDATE=`date +%H%M`
cd /tmp/emc/soc/swperf
mkdir $PERFDATE
cp swportperf.sh $PERFDATE/swportperf.sh
cp swinfo.txt $PERFDATE/swinfo.txt
cd $PERFDATE
sh swportperf.sh
cd ..
find . -name '*8' -cmin +60 | xargs -i rm -R {}
exit
