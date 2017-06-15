data文件夹下的都是IG库表中需要具备的基础数据
针对不同情况准备了两种不同环境的操作说明

WINDOWS:
1. 以编辑模式打开run.bat文件,修改oracle安装路径ORACLE_PATH值及基础数据文件夹路径BASICDATA_PATH值
2. 数据库连接默认为igadmin/igadmin@IG,如果用户名密码不一致需要修改data.sql中的连接格式为[用户名]/[密码]@IG
3. 执行run.bat 开始导入基础数据

LINUX:
1. 将db目录复制到/home/oracle/目录
2. 进入basicdata 目录执行run.sh 开始导入基础数据

注意:
由于某些表存在主外键关系所以在import.sql与import_sh.sql中的导入表基础数据的顺序请勿随意修改以免出现无法导入的情况

备注:
1. 启动数据库监听服务命令
$lsnrctl start

sqlplus /nolog
connect sysman/ig@IG