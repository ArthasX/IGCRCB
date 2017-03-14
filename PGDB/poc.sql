insert into IG.CODEDETAIL (CCID, CID, CVALUE, PCCID, PCID, UPDTIME, SYSCODING, PSYSCODING, CDSTATUS, BUSINESSCODE, FINGERPRINT, CDINFO, CDORDER)
values ('100', 'IGBP08', '·þÎñÌ¨', null, null, '2010/01/01 00:00', null, null, null, null, null, null, null);


drop view ig.soc0123;
drop view ig.soc0124;
drop view ig.soc0143;

ALTER TABLE ig.soc0118 ALTER esyscoding TYPE character varying(128);

CREATE OR REPLACE VIEW "ig".SOC0123 as select  A.eiid, A.eid, A.eidesc, A.einame,
A.eilabel, A.eiupdtime, A.eistatus, A.eiinsdate, A.eiorgsyscoding, A.esyscoding,
A.eiversion, A.eiuserid, A.eiusername, A.eismallversion,A.eirootmark,B.ename, B.elabel,
B.ecategory FROM "ig".SOC0118 A INNER JOIN "ig".SOC0117 B on (A.eid = B.eid);

CREATE OR REPLACE VIEW "ig".SOC0124 as select A.eiid, A.EID, A.EIDESC, A.einame, A.eilabel,
A.EIUPDTIME, A.EISTATUS, A.EIINSDATE, A.EIORGSYSCODING, A.ESYSCODING, B.ENAME,
B.ELABEL, B.EDESC, B.ESTATUS, B.ecategory, B.EKEY1, B.EKEY2, B.EKEY3, B.EMODELTYPE,
A.EIVERSION, A.EIUSERID, A.EIUSERNAME, A.EISMALLVERSION, A.EIROOTMARK,
C.CIVALUE as SERIAL, D.CIVALUE as BUYTIME, E.CIVALUE as USEORGAN, F.CIVALUE
as WBDATE, COALESCE(G.EIRCOUNT,0) as EIRCOUNT FROM "ig".SOC0118 A inner join
"ig".SOC0117 B on (A.EID = B.EID) left outer join "ig".SOC0134 C on (A.EIVERSION
= C.CIVERSION and A.eiid = C.eiid and C.CLABEL = 'IG_0027') left outer
join "ig".SOC0134 D on (A.EIVERSION = D.CIVERSION and A.eiid = D.eiid
and D.CLABEL = 'IG_0028') left outer join "ig".SOC0134 E on (A.EIVERSION
= E.CIVERSION and A.eiid = E.eiid and E.CLABEL = 'IG_0006') left outer
join "ig".SOC0134 F on (A.EIVERSION = F.CIVERSION and A.eiid = F.eiid
and F.CLABEL = 'IG_0029') left outer join "ig".SOC0135 G on (A.eiid = G.eiid);

CREATE OR REPLACE VIEW "ig".SOC0124 as select A.eiid, A.EID, A.EIDESC, A.einame, A.eilabel,
A.EIUPDTIME, A.EISTATUS, A.EIINSDATE, A.EIORGSYSCODING, A.ESYSCODING, B.ENAME,
B.ELABEL, B.EDESC, B.ESTATUS, B.ecategory, B.EKEY1, B.EKEY2, B.EKEY3, B.EMODELTYPE,
A.EIVERSION, A.EIUSERID, A.EIUSERNAME, A.EISMALLVERSION, A.EIROOTMARK,
C.CIVALUE as SERIAL, D.CIVALUE as BUYTIME, E.CIVALUE as USEORGAN, F.CIVALUE
as WBDATE, COALESCE(G.EIRCOUNT,0) as EIRCOUNT FROM "ig".SOC0118 A inner join
"ig".SOC0117 B on (A.EID = B.EID) left outer join "ig".SOC0134 C on (A.EIVERSION
= C.CIVERSION and A.eiid = C.eiid and C.CLABEL = 'IG_0027') left outer
join "ig".SOC0134 D on (A.EIVERSION = D.CIVERSION and A.eiid = D.eiid
and D.CLABEL = 'IG_0028') left outer join "ig".SOC0134 E on (A.EIVERSION
= E.CIVERSION and A.eiid = E.eiid and E.CLABEL = 'IG_0006') left outer
join "ig".SOC0134 F on (A.EIVERSION = F.CIVERSION and A.eiid = F.eiid
and F.CLABEL = 'IG_0029') left outer join "ig".SOC0135 G on (A.eiid = G.eiid);

CREATE OR REPLACE VIEW "ig".SOC0143 as select  e.eiid, e.eid, e.einame,
e.eilabel, e.eiversion, e.eismallversion, e.eirootmark, e.esyscoding, c.ciid,
c.cid, c.civalue, cf.cname FROM "ig".SOC0118 e,"ig".SOC0107 c,"ig".SOC0109
cf,(select ae.eirootmark FROM "ig".SOC0102 ae group by ae.eirootmark)
rei where cf.ccategory='007' and c.cid = cf.cid and e.eiid = c.eiid and e.eiversion
= c.civersion and e.eismallversion = c.cismallversion and e.eirootmark
= rei.eirootmark and e.eiversion = (select o.eiversion FROM "ig".SOC0118 o
where o.eiid = e.eirootmark);

            
CREATE OR REPLACE VIEW IG.IG688 AS
SELECT  	A.EIID,
            A.EID,
            A.EIDESC,
            A.EINAME,
            A.EILABEL,
            A.EIUPDTIME,
            A.EISTATUS,
            A.EIINSDATE,
            A.EIORGSYSCODING,
            A.ESYSCODING,
            B.ENAME,
            B.ELABEL,
            B.EDESC,
            B.ESTATUS,
            B.ECATEGORY,
            B.EKEY1,
            B.EKEY2,
            B.EKEY3,
            B.EMODELTYPE,
            A.EIVERSION,
            A.EIUSERID,
	    	A.EIUSERNAME,
	    	A.EISMALLVERSION,
       		A.EIROOTMARK,
	    	C.CIVALUE AS SERIAL,
            D.CIVALUE AS BUYTIME,
            E.CIVALUE AS USEORGAN,
            F.CIVALUE AS WBDATE,
            COALESCE(G.EIRCOUNT, 0) AS EIRCOUNT
    FROM    IG.IG013 A INNER JOIN IG.IG117 B ON (A.EID = B.EID)
            LEFT OUTER JOIN IG.IG050 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0027')
            LEFT OUTER JOIN IG.IG050 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0028')
            LEFT OUTER JOIN IG.IG050 E ON (A.EIVERSION = E.CIVERSION AND A.EISMALLVERSION = E.CISMALLVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0006')
            LEFT OUTER JOIN IG.IG050 F ON (A.EIVERSION = F.CIVERSION AND A.EISMALLVERSION = F.CISMALLVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0029')
            LEFT OUTER JOIN IG.IG336 G ON (a.EIID = G.eiid)
UNION ALL
SELECT  EIID,
        0,
        EIDESC,
        EINAME,
        EILABEL,
        EIUPDTIME,
        EISTATUS,
        EIINSDATE,
        EIORGSYSCODING,
        ESYSCODING,
        ENAME,
        ELABEL,
        EDESC,
        ESTATUS,
        ECATEGORY,
        EKEY1,
        EKEY2,
        EKEY3,
        EMODELTYPE,
        EIVERSION,
        EIUSERID,
    	EIUSERNAME,
    	EISMALLVERSION,
   		EIROOTMARK,
    	SERIAL,
        BUYTIME,
        USEORGAN,
        WBDATE,
        EIRCOUNT
    FROM IG.SOC0124