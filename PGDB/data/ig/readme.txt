data�ļ����µĶ���IG�������Ҫ�߱��Ļ�������
��Բ�ͬ���׼�������ֲ�ͬ�����Ĳ���˵��

WINDOWS:
1. �Ա༭ģʽ��run.bat�ļ�,�޸�oracle��װ·��ORACLE_PATHֵ�����������ļ���·��BASICDATA_PATHֵ
2. ���ݿ�����Ĭ��Ϊigadmin/igadmin@IG,����û������벻һ����Ҫ�޸�data.sql�е����Ӹ�ʽΪ[�û���]/[����]@IG
3. ִ��run.bat ��ʼ�����������

LINUX:
1. ��dbĿ¼���Ƶ�/home/oracle/Ŀ¼
2. ����basicdata Ŀ¼ִ��run.sh ��ʼ�����������

ע��:
����ĳЩ������������ϵ������import.sql��import_sh.sql�еĵ����������ݵ�˳�����������޸���������޷���������

��ע:
1. �������ݿ������������
$lsnrctl start

sqlplus /nolog
connect sysman/ig@IG