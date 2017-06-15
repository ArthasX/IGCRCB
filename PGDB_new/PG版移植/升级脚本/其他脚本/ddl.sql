ALTER TABLE ig.riskcheckresult add rcrnextdate VARCHAR(16); 
ALTER TABLE ig.riskcheckresult add prid integer; 
ALTER TABLE ig.riskcheckresult ALTER COLUMN rcrplandate TYPE VARCHAR(16);
ALTER TABLE ig.riskcheck ALTER COLUMN rcenddate TYPE VARCHAR(16);
ALTER TABLE ig.riskcheck ALTER COLUMN rcstartdate TYPE VARCHAR(16);
ALTER TABLE ig.riskcheck add RCCATEGORY	VARCHAR(32);
ALTER TABLE ig.riskcheck add RCCREATETIME VARCHAR(16);
ALTER TABLE ig.riskcheck add RCAPPROVETIME VARCHAR(16);
ALTER TABLE ig.riskcheck add RCAPPROVER	VARCHAR(16);
ALTER TABLE ig.riskcheck add RCCATEGORYNAME VARCHAR(64);
ALTER TABLE ig.riskcheck add RCFREQUENCYDESC VARCHAR(128);
ALTER TABLE ig.riskcheck add RCFREQUENCYMONTHLASTDAY VARCHAR(1);
ALTER TABLE ig.riskcheck add RCUPDATETIME VARCHAR(16);
ALTER TABLE ig.riskcheck add DELETEFLAG	VARCHAR(4);
ALTER TABLE ig.riskcheck add RCCOMMON VARCHAR(512);
ALTER TABLE ig.riskcheck add RCCLASS VARCHAR(4);

--设置acturl时发现长度过长需要增加
ALTER TABLE ig.action alter column acturl type character varying(128);

--Create View
--由于变更使用方式此段视图可能目前在代码中未使用Start
--查询最新指标视图
create or replace view eam_measurement_data_maxtime as 
	select now.timestamp, now.measurement_id, ao.value from 
		(select max(timestamp) as timestamp, measurement_id from eam_measurement_data group by measurement_id) now
		left join eam_measurement_data ao on ao.timestamp = now.timestamp and ao.measurement_id = now.measurement_id;

--获取当前最新时间可用性的视图
create or replace view eam_availability_maxtime as 
	select now.measurement_id, now.startime, ao.availval from 
		(select measurement_id, max(startime) as startime from hq_avail_data_rle group by measurement_id) now
		left join hq_avail_data_rle ao on ao.startime = now.startime and ao.measurement_id = now.measurement_id;
		
--网络设备信息视图
create or replace view hq_entityitem_view as 
	select platform_id, pip, eiid, einame, eid, ename, esyscoding 
		from (select A.eiid, A.eid, A.einame, A.esyscoding, B.civalue, C.ename 
			from ig.soc0118 A LEFT JOIN ig.soc0107 B ON A.eiid = B.eiid LEFT JOIN ig.soc0117 C on A.eid = C.eid 
			where A.eid in ('CM01010045','CM01010046','CM01010047')  and B.cid='CI010100450001') entity 
		inner join 
			(select ep.id as platform_id, ep.fqdn as pip from eam_platform ep 
				left join eam_resource er on er.id = ep.resource_id ) platform on civalue = pip;

--网络设备端口视图
create or replace view hq_netdevice_port_view as 
	select esc.resource_id, esc.description as portinfo, esc.autoinventoryidentifier as definition, 
	ep.id as platform_id, ep.fqdn as platform_ip, ava.availval as ava, rps.value as recvbit, sps.value as sentbit
	from eam_platform ep 
		left join eam_server es on es.platform_id = ep.id 
			and es.server_type_id in 
				(select ID from eam_server_type where plugin in ('netapp','netdevice','netservices')) 
		left join eam_service esc on esc.server_id = es.id 
			and esc.service_type_id in 
				(select ID from eam_service_type where plugin in ('netapp','netdevice','netservices')) 
		left join (select scm.resource_id, em.availval from hq_service_m_view scm 
		left join eam_availability_maxtime em on em.measurement_id = scm.id) ava on ava.resource_id = esc.resource_id and ava.availval is not null
		left join (select scm.resource_id, em.value from hq_service_m_view scm 
		left join eam_measurement_data_maxtime em on em.measurement_id = scm.id where scm.typename = 'Bits Received per Second') rps on rps.resource_id = esc.resource_id
		left join (select scm.resource_id, em.value from hq_service_m_view scm 
		left join eam_measurement_data_maxtime em on em.measurement_id = scm.id where scm.typename = 'Bits Sent per Second') sps on sps.resource_id = esc.resource_id
		where es.id is not null and esc.id is not null;
--由于变更使用方式此段视图可能目前在代码中未使用End

--告警阀值视图
create or replace view hq_alert_threshold as (
SELECT at.id, at.defname, at.name, at.comparator, at.threshold, at.resource_id, c.ip, c.platform_id 
    FROM (
		SELECT a.id, a.name as defname, b.name, b.comparator, b.threshold, a.resource_id 
	    	FROM eam_alert_definition a, eam_alert_condition b where a.id = b.alert_definition_id
    ) at left join hq_platform_list_view c on at.resource_id = c.resource_id
)

--平台视图重新创建(原获取平台类型时区别显示IP时只是10014单一类型现在变更为所有网络类型插件能获取到的类型都设置为网络设备)
create or replace view hq_platform_list_view as 
	select a.id as agent_id, 
		case when b.platform_type_id in (select id from eam_platform_type where plugin in ('netapp','netdevice'))
		 then b.fqdn else a.address end as ip, 
			b.id as platform_id, d.name, b.description, c.name as typename, b.resource_id 
		from eam_agent a, eam_platform b, eam_platform_type c, eam_resource d 
		where a.id = b.agent_id and b.platform_type_id = c.id and b.resource_id = d.id;


--审计管理
CREATE TABLE ig.AUDITPROJECT(
	APID INTEGER NOT NULL ,
	APREPORTTYPE  VARCHAR(32), 
	APPROJECTID  INTEGER, 
	APPROJECTNAME  VARCHAR(256), 
	APPROJECTYEAR  VARCHAR(4), 
	APATTKEY  VARCHAR(32), 
	FINGERPRINT VARCHAR(256), 
	PRIMARY KEY (APID)
);

CREATE TABLE ig.INTERNALAUDITJOB (
	 IAJID  INTEGER  NOT NULL, 
	 IAJYEAR  VARCHAR(32), 
	 IAJIAPID  INTEGER, 
	 IAJNAME  VARCHAR(128), 
	 IAJSTARTTIME  VARCHAR(16), 
	 IAJOVERTIME  VARCHAR(16), 
	 IAJINSERTTIME  VARCHAR(16), 
	 IAJDESC  VARCHAR(512), 
	 IAJATTKEY  VARCHAR(32), 
	 IAJUSERID  VARCHAR(16), 
	 FINGERPRINT  VARCHAR(256), 
	 PRIMARY KEY ( IAJID )
);

CREATE TABLE ig.INTERNALAUDITPRJ (
	 IAPID  INTEGER NOT NULL, 
	 IAPYEAR  VARCHAR(4), 
	 IAPNAME  VARCHAR(128), 
	 IAPSTATUS  VARCHAR(1), 
	 IAPOBJECT  VARCHAR(32), 
	 IAPWAY  VARCHAR(32), 
	 IAPUSERNAME  VARCHAR(128), 
	 IAPOPENTIME  VARCHAR(10), 
	 IAPCLOSETIME  VARCHAR(10), 
	 IAPOBJECTIVE  VARCHAR(256), 
	 IAPSCOPE  VARCHAR(256), 
	 IAPBASIS  VARCHAR(256), 
	 IAPDESC  VARCHAR(512), 
	 IAPCOOPERATOR  VARCHAR(32), 
	 IAPSUGGESTION  VARCHAR(512), 
	 IAPCREATEUSERID  VARCHAR(16), 
	 IAPCREATETIME  VARCHAR(16), 
	 IAPCONFIRMUSERID  VARCHAR(16), 
	 IAPCONFIRMTIME  VARCHAR(16), 
	 IAPATTKEY  VARCHAR(32), 
	 IAPTYPE  VARCHAR(1), 
	 IAPSOURCE  VARCHAR(32), 
	 FINGERPRINT  VARCHAR(256), 
	 PRIMARY KEY ( IAPID )
);


--风险评估评分记录视图
CREATE OR REPLACE VIEW ig.assessmentscorevw as
	select g.piid as piid,
	        g.prid as prid,
	        g.pivarname as pivarname,
	        g.pivarlabel as pivarlabel,
	        g.pivartype as pivartype,
	        g.pidid as pidid,
	        s.ppiid as ppiid,
	        s.roleid as roleid,
	        s.userid as userid,
	        s.ppivalue as ppivalue,
	        s.orgid as orgid,
		    s.ppicommect as ppicommect,
            s.fingerprint as fingerprint,
	        u.username as username    
        from ig.ig599 g 
        left join ig.ig899 s on g.piid = s.piid
		left join ig.iguser u on s.userid = u.userid
		where  exists (select s.piid from ig.ig899 ss where g.piid=ss.piid);

-- Create sequence 
CREATE SEQUENCE ig.PDID_WD4
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 99999
  START 1000
  CACHE 20;
  
  
  
--合同类型基础数据IG545增补现在未按照IG545顺序添加请各位同事注意
insert into ig.ig545 (ccdid, ccdcategory, ccdlabel, ccdvalue, ccdstatus, ccdtype, ccdinfo, fingerprint)
values (2043, '039', '合同类型', '研发咨询合同', '1', 'A', null, null);
insert into ig.ig545 (ccdid, ccdcategory, ccdlabel, ccdvalue, ccdstatus, ccdtype, ccdinfo, fingerprint)
values (2044, '039', '合同类型', '基础设施合同', '1', 'A', null, null);
commit;



--个人任务删除外键约束
ALTER TABLE ig.quartzprocessinfoentity drop  CONSTRAINT quartzprocessinfoentity_qeiid_fkey ;
ALTER TABLE ig.quartzprocessinfoentity drop  CONSTRAINT quartzprocessinfoentity_qpiid_fkey ;
ALTER TABLE ig.quartzprocessinfoentity drop  CONSTRAINT quartzprocessinfoentity_qprid_fkey ;

ALTER TABLE ig.ig731 drop CONSTRAINT ig731_eiid_fkey ;
ALTER TABLE ig.ig731 drop CONSTRAINT ig731_piid_fkey ;
ALTER TABLE ig.ig731 drop CONSTRAINT ig731_prid_fkey ;


UPDATE IG.IG333 SET PSDNAME = '故障分派' WHERE PSDID='0108001003';
UPDATE IG.IG333 SET PSDNAME = '故障处理' WHERE PSDID='0108001005';
UPDATE IG.IG333 SET PSDNAME = '故障审核' WHERE PSDID='0108001006';


drop table "ig".VIM07;
drop table "ig".VIM03;

CREATE TABLE "ig".VIM03
(
	ID INTEGER NOT NULL,
	PID INTEGER,
	PRID INTEGER,
	PNAME VARCHAR(256),
	VCID INTEGER,
	VCNAME VARCHAR(128) , 
	TEMPLATENAME VARCHAR(256),
	HOSTNAME VARCHAR(128),
	NETWORKNAME VARCHAR(128),
	VMNAME VARCHAR(256),
	VMCPUS INTEGER,
	VMMEM INTEGER,
	VMDISK INTEGER,
	IP VARCHAR(15),
	STATUS CHAR(1),
	PROGRESS VARCHAR(6),
	DATACENTERNAME VARCHAR(128),
	RESOURCEPOOLNAME VARCHAR(128),
	ORGSYSCODING VARCHAR(32),
	ORGNAME VARCHAR(128),
	USERID VARCHAR(16),
	USERNAME VARCHAR(32),
	APPLYTIME VARCHAR(16),
	EXPIRYTIME VARCHAR(16),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (ID),
	FOREIGN KEY (PID) REFERENCES ig.VIM02 (ID) ON DELETE CASCADE,
	FOREIGN KEY (PRID) REFERENCES ig.IG500 (PRID) ON DELETE CASCADE
) ;

create table ig.vim07
(
	id integer not null,
	vmid integer,
	pid integer,
	userid varchar(16),
	ctype char(1),
	prid integer,
	ctime char(16),
	atime char(16),
	fingerprint varchar(256),
	primary key(id),
	foreign key (vmid) references ig.vim03(ID),
	foreign key (pid) references ig.vim02(ID),
	foreign key (userid) references ig.iguser(userid),
	foreign key (prid) references ig.ig500(prid)
);