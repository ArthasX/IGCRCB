1.首先通过ORACLE管理页面手动创建IG和CST库；

2.将DB_Script文件夹复制到F:路径下;

3.创建IG库数据表、视图、以及导入基础数据
	执行bat顺序如下：
	DB_Script\system\run1.bat
	DB_Script\system\run2.bat
	DB_Script\csebank\run.bat
	DB_Script\cselom\run.bat
	DB_Script\dashboard\run1.bat
	DB_Script\dashboard\run2.bat
	DB_Script\dev\process\run.bat
	DB_Script\soc\run.bat
	DB_Script\data\system\run.bat
	DB_Script\data\csebank\run.bat
	DB_Script\data\cselom\run.bat

4.创建CST库数据表、视图、以及导入基础数据
	执行bat顺序如下：
	DB_Script\cst\windows\cst_user.bat
	DB_Script\cst\windows\cst_database.bat
	DB_Script\cst\windows\cst_insert.bat

5.创建联合数据库
DB_Script\DBLink_NickNam\run1.bat
DB_Script\DBLink_NickName\run2.bat
	
	


