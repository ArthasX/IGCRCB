--�޸ļ���������̺���
insert into IG413(pedid,pdid,psdid,pedtype,pedblid,pedorder) values('0102108005001','0102108','0102108005','1','igEVENT9904BL',1);

--�����ص�������ͣ���ʼֵ�������ʼֵΪ�գ�����Ҫ�ڱ������е����������
update ig007 set pidtype='2',pidoption = '���Ļ���#�ֱ����� #��ػ���',piduse = '1',piddisplay = '1' where pidid = '0138601008';
--����Ӱ�췶Χ�����ͺͳ�ʼֵ�������ʼֵΪ�գ�����Ҫ�ڱ������е����������
update ig007 set pidtype='2',pidoption = 'ȫ��#����#֧��#���� ',piduse = '1',piddisplay = '1' where pidid = '0138601009';
--���ķ�������Ϊ������
update ig699 set pidrequired = '0' where pdvid = '0138601003010';
--ɾ��ҵ����Ӱ�췶Χ��
delete from ig007 where pidid = '0138601012';
--������ڵ����Ϊ�ɼ��ͱ���
update ig699 set pidaccess = '3',pidrequired = '1' where pidid ='0138601026' and psdid = '0138601004';

--������Ӧ��ָ�����̱�ѡ����
CREATE TABLE OPTIONSENCES
(
	OSID INTEGER NOT NULL,
	PRID INTEGER,
	SENCEEIID INTEGER,
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (OSID)
);