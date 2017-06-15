WINDOWS:
1. 执行run.bat 开始创建用户及表
2. 在dbtune.sql 中创建用户,默认创建为igadmin/igadmin,
如果修改还需要修改init.sql中连接的用户名及密码


LINUX:
1. 将db目录复制到/home/oracle/目录
2. 进入system 目录执行run1.sh 开始创建用户和表空间
3. 进入system 目录执行run2.sh 开始创建表
4. 进入csebank目录执行run.sh
5. 进入cselom 目录执行run.sh

备注
1. 启动数据库监听服务命令
$lsnrctl start

sqlplus /nolog
connect sysman/ig@IG