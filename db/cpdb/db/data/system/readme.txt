WINDOWS:
1. 以编辑模式打开run.bat文件,修改oracle安装路径ORACLE_PATH值及基础数据文件夹路径BASICDATA_PATH值
2. 数据库连接默认为igadmin/igadmin@IG,如果不一致需要修改data.sql中的连接
3. 执行run.bat 开始导入基础数据


LINUX:
1. 将db目录复制到/home/oracle/目录
2. 进入basicdata 目录执行run.sh 开始导入基础数据


备注
1. 启动数据库监听服务命令
$lsnrctl start

sqlplus /nolog
connect sysman/ig@IG