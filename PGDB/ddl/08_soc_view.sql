CREATE OR REPLACE VIEW IG.SOC0307 as select se.id,se.DETECTIONTIME,se.dir,se.src,se.CATEGORY,se.SEVERITY,se.ERRORNUM,se.ERRORDESC,se.EIROOTMARK,se.STATE,se.SORT,se.IMPTYPEID,se.LPARNAM,--storageevent
se.ip,se.REPORTINGMTMS,se.FAILINGENCLOSUREMTMS,se.FRU1LOC,se.FRU2LOC,se.FRU3LOC,se.ALARMTYPE,ei.eiid,ep.imptypename,se.status FROM IG.SOC0305 se left join (select eiid,einame FROM IG.SOC0118 where einame <>'' ) ei 
on (se.eirootmark = ei.einame) LEFT JOIN IG.SOC0113 ep on (CAST(se.imptypeid AS INTEGER) = ep.impTypeid);

CREATE OR REPLACE VIEW IG.SOC0134 as select B.ciid, B.cid, B.eiid, A.cname,
A.cdesc, A.cunit, A.cstatus, A.ccategory, A.cseq, A.clabel, A.coption,
B.civalue, B.ciupdtime, B.ciexpire, B.cistatus, B.civersion, B.civerinfo
FROM IG.SOC0109 A, IG.SOC0107 B where A.cid = B.cid;

CREATE OR REPLACE VIEW IG.SOC0123 as select  A.eiid, A.eid, A.eidesc, A.einame,
A.eilabel, A.eiupdtime, A.eistatus, A.eiinsdate, A.eiorgsyscoding, A.esyscoding,
A.eiversion, A.eiuserid, A.eiusername, A.eismallversion, B.ename, B.elabel,
B.ecategory FROM IG.SOC0118 A INNER JOIN IG.SOC0117 B on (A.eid = B.eid);

CREATE OR REPLACE VIEW IG.SOC0135 as select A.eiid, COUNT(1) as EIRCOUNT FROM IG.SOC0114
A inner join (select EIDDID, MAX(version) as version FROM IG.SOC0111 group
by EIDDID) B on (A.DOMAINID = B.EIDDID and A.DOMAINVERSION = B.version)
group by eiid;

CREATE OR REPLACE VIEW IG.SOC0124 as select A.eiid, A.EID, A.EIDESC, A.einame, A.eilabel,
A.EIUPDTIME, A.EISTATUS, A.EIINSDATE, A.EIORGSYSCODING, A.ESYSCODING, B.ENAME,
B.ELABEL, B.EDESC, B.ESTATUS, B.ecategory, B.EKEY1, B.EKEY2, B.EKEY3, B.EMODELTYPE,
A.EIVERSION, A.EIUSERID, A.EIUSERNAME, A.EISMALLVERSION, A.EIROOTMARK,
C.CIVALUE as SERIAL, D.CIVALUE as BUYTIME, E.CIVALUE as USEORGAN, F.CIVALUE
as WBDATE, COALESCE(G.EIRCOUNT,0) as EIRCOUNT FROM IG.SOC0118 A inner join
IG.SOC0117 B on (A.EID = B.EID) left outer join IG.SOC0134 C on (A.EIVERSION
= C.CIVERSION and A.eiid = C.eiid and C.CLABEL = 'IG_0027') left outer
join IG.SOC0134 D on (A.EIVERSION = D.CIVERSION and A.eiid = D.eiid
and D.CLABEL = 'IG_0028') left outer join IG.SOC0134 E on (A.EIVERSION
= E.CIVERSION and A.eiid = E.eiid and E.CLABEL = 'IG_0006') left outer
join IG.SOC0134 F on (A.EIVERSION = F.CIVERSION and A.eiid = F.eiid
and F.CLABEL = 'IG_0029') left outer join IG.SOC0135 G on (A.eiid = G.eiid);

CREATE OR REPLACE VIEW IG.SOC0125 as select EI.EIDDID, EI.NAME, EI.version, EI.DESCRIPTION,
EI.CREATETIME, EI.UPDATETIME FROM IG.SOC0111 EI, ( select MAX(version)
as version, EIDDID from IG.SOC0111 group by EIDDID ) B where EI.EIDDID
= B.EIDDID and EI.version = B.version;

CREATE OR REPLACE VIEW IG.SOC0126 as select EI.EIDDID, EI.EIDDVERSION, EI.einame,
EI.EIIMPORTVERSION, EI.CREATETIME, EI.deleteflag, EI.FINGERPRINT from (
select eiddid, MAX(EIDDVERSION) as EIDDVERSION FROM IG.SOC0112 GROUP
BY eiddid ) B,IG.SOC0112 EI where B.EIDDID = EI.EIDDID and B.EIDDVERSION
= EI.EIDDVERSION;

CREATE OR REPLACE VIEW IG.SOC0127 as select A.BRID, A.BRPAREIID, A.BRPARVERSION,
A.BRPARSMALLVERSION, A.BRCLDEIID, A.BRCLDVERSION, A.BRCLDSMALLVERSION,
A.BRTYPE, A.BRDES, A.BRCREATETIME, A.BRRALETIONCODE, A.BRASSETRELATION,
A.EIROOTMARK, A.deleteflag FROM IG.SOC0110 A 
inner join ( select BRPAREIID, MAX(BRPARVERSION) as BRPARVERSION, MAX(BRPARSMALLVERSION) as BRPARSMALLVERSION, 
BRCLDEIID, MAX(BRCLDVERSION) as BRCLDVERSION, MAX(BRCLDSMALLVERSION)
as BRCLDSMALLVERSION FROM IG.SOC0110 where deleteflag = '0' GROUP
BY BRPAREIID, BRCLDEIID ) B on (A.BRPAREIID = B.BRPAREIID and A.BRPARVERSION
= B.BRPARVERSION and A.BRPARSMALLVERSION = B.BRPARSMALLVERSION and A.BRCLDEIID
= B.BRCLDEIID and A.BRCLDVERSION = B.BRCLDVERSION and A.BRCLDSMALLVERSION
= B.BRCLDSMALLVERSION);

CREATE OR REPLACE VIEW IG.SOC0141 as select S.srid , S.srdomainid , S.srarithmetictype
, S.srdomainversion , S.srpareiid , S.srparversion , S.srparsmallversion
, E1.einame as srpareiname, E1.eilabel as srpareilabel, S.srcldeiid , S.srcldversion
, S.srcldsmallversion , E2.einame as srcldeiname, E2.eilabel as srcldeilabel,
S.srcreatetime, S.deleteflag, S.srassetrelation FROM IG.SOC0121
S join IG.SOC0118 E1 on S.srpareiid = E1.eiid and S.srparversion = E1.eiversion
and srparsmallversion = E1.eismallversion join IG.SOC0118 E2 on S.srcldeiid
= E2.eiid and S.srcldversion = E2.eiversion and srcldsmallversion = E2.eismallversion;

CREATE OR REPLACE VIEW IG.SOC0142 as select EI.EIDDID, EI.EIDDVERSION, EI.einame,
EI.EIIMPORTVERSION, EI.CREATETIME, EI.deleteflag, EI.FINGERPRINT FROM IG.SOC0112
EI, ( select EIDDVERSION, EIDDID, einame, MAX(EIIMPORTVERSION) as EIIMPORTVERSION
FROM IG.SOC0112 group BY EIDDVERSION, EIDDID, einame) B where EI.EIDDID
= B.EIDDID and EI.einame = B.einame and EI.EIIMPORTVERSION = B.EIIMPORTVERSION
and EI.EIDDVERSION = B.EIDDVERSION;

CREATE OR REPLACE VIEW IG.SOC0143 as select  e.eiid, e.eid, e.einame,
e.eilabel, e.eiversion, e.eismallversion, e.eirootmark, e.esyscoding, c.ciid,
c.cid, c.civalue, cf.cname FROM IG.SOC0118 e,IG.SOC0107 c,IG.SOC0109
cf,(select ae.eirootmark FROM IG.SOC0102 ae group by ae.eirootmark)
rei where cf.ccategory='007' and c.cid = cf.cid and e.eiid = c.eiid and e.eiversion
= c.civersion and e.eismallversion = c.cismallversion and e.eirootmark
= rei.eirootmark and e.eiversion = (select o.eiversion FROM IG.SOC0118 o
where o.eiid = e.eirootmark);

CREATE OR REPLACE VIEW IG.SOC0144 as select  aue.eiid, aue.eid,
aue.einame, aue.eilabel, aue.esyscoding, aue.eirootmark, auc.ciid, auc.cid,
auc.civalue, aucf.cname FROM IG.SOC0102 aue ,IG.SOC0101 auc,IG.SOC0109
aucf where aucf.ccategory='007' and auc.cid=aucf.cid and aue.eiid = auc.eiid
and aue.eiversion = auc.civersion and aue.eismallversion = auc.cismallversion;

CREATE OR REPLACE VIEW IG.SOC0145 as select E.eiid,E.EID,E.einame,E.EIVERSION,E.EISMALLVERSION,C.CIID,C.CID,C.CIVALUE
FROM IG.SOC0118 E INNER JOIN IG.SOC0107 C on E.eiid=C.eiid and E.EIVERSION = C.CIVERSION
and E.EISMALLVERSION = C.CISMALLVERSION;

CREATE OR REPLACE VIEW IG.SOC0146 as select IM.IMPEINAME, IM.IMPVERSION, IM.IMPEIID,
IM.IMPCITYPE, IM.IMPFILENAME, IM.IMPCREATETIME, IM.deleteflag, IM.ESYSCODING
FROM IG.SOC0120 IM, ( select MAX(IMPVERSION) as IMPVERSION, IMPEINAME
FROM IG.SOC0120  group by IMPEINAME ) B where IM.IMPEINAME = B.IMPEINAME
and IM.IMPVERSION = B.IMPVERSION;

CREATE OR REPLACE VIEW IG.SOC0429 as select hostName,pareiid as bcid,eir.einame
as bcname,sName,createDate,sum(allottedCapacity) as allottedCapacity,sum(freeCapacity)
as freeCapacity,sum(usedcapacity) as usedcapacity from IG.SOC0419
vg inner join IG.SOC0118 ei on vg.hostName=ei.einame inner join (select
a.pareiid,a.cldeiid,c.einame from IG.SOC0119 a,IG.SOC0118 c where
a.eirrelation='242' and a.pareiid=c.eiid and a.deleteflag='0') eir on eir.cldeiid=ei.eiid
group by hostName,pareiid,eir.einame,sName,createDate;

CREATE OR REPLACE VIEW IG.SOC0430 as select hostName,pareiid as bcid,eir.einame
as bcname,sName,createDate,sum(allottedCapacity) as allottedCapacity,sum(freeCapacity)
as freeCapacity,sum(usedcapacity) as usedcapacity from IG.SOC0420
vg inner join IG.SOC0118 ei on vg.hostName=ei.einame inner join (select
a.pareiid,a.cldeiid,c.einame from IG.SOC0119 a,IG.SOC0118 c where
a.eirrelation='242' and a.pareiid=c.eiid and a.deleteflag='0') eir on eir.cldeiid=ei.eiid
group by hostName,pareiid,eir.einame,sName,createDate;

CREATE OR REPLACE VIEW IG.SOC0431 as select hostName,pareiid as bcid,eir.einame
as bcname,sName,createDate,sum(allottedCapacity) as allottedCapacity,sum(freeCapacity)
as freeCapacity,sum(usedcapacity) as usedcapacity from IG.SOC0421
vg inner join IG.SOC0118 ei on vg.hostName=ei.einame inner join (select
a.pareiid,a.cldeiid,c.einame from IG.SOC0119 a,IG.SOC0118 c where
a.eirrelation='242' and a.pareiid=c.eiid and a.deleteflag='0') eir on eir.cldeiid=ei.eiid
group by hostName,pareiid,eir.einame,sName,createDate;

CREATE OR REPLACE VIEW IG.SOC0432 as select hostName,pareiid as bcid,eir.einame
as bcname,sName,createDate,sum(allottedCapacity) as allottedCapacity,sum(freeCapacity)
as freeCapacity,sum(usedcapacity) as usedcapacity from IG.SOC0422
vg inner join IG.SOC0118 ei on vg.hostName=ei.einame inner join (select
a.pareiid,a.cldeiid,c.einame from IG.SOC0119 a,IG.SOC0118 c where
a.eirrelation='242' and a.pareiid=c.eiid and a.deleteflag='0') eir on eir.cldeiid=ei.eiid
group by hostName,pareiid,eir.einame,sName,createDate;

CREATE OR REPLACE VIEW IG.SOC0428 as select a.bcid,a.bcname,a.sname,sum(a.pvsize)
as allottedCapacity,bctype from (select eir.pareiid as bcid,eir.einame
as bcname,ph.sName,ph.lunid,max(ps.pvsize) as pvsize,'business' as bctype
from IG.SOC0409 ph inner join IG.SOC0410 ps on ph.sname=ps.sname
and ph.lunid=ps.lunid inner join IG.SOC0118 ei on ph.hostName=ei.einame
inner join (select a.pareiid,a.cldeiid,c.einame from IG.SOC0119
a,IG.SOC0118 c where a.eirrelation='242' and a.pareiid=c.eiid and a.deleteflag='0')
eir on eir.cldeiid=ei.eiid group by eir.pareiid,eir.einame,ph.sName,ph.lunid
union select vio.id as bcid,vio.vioname as bcname,sName,lunid,pvsize,'vio'
as bctype from IG.SOC0434 as pvvio inner join IG.SOC0433 as vio on pvvio.sn=vio.vioname where isused='0'
) a group by a.bcid,a.bcname,a.sname,bctype;