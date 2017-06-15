CREATE OR REPLACE VIEW ig.soc0600 AS 
 SELECT b.ciid, b.cid, b.eiid, a.cname, a.cdesc, a.cunit, a.cstatus, a.ccategory, a.cseq, a.clabel, a.coption, b.civalue, b.ciupdtime, b.ciexpire, b.cistatus, b.civersion, b.cismallversion, b.civerinfo, b.cicurver
   FROM ig.SOC0109 a, ig.SOC0107 b
  WHERE a.cid = b.cid;


CREATE OR REPLACE VIEW ig.soc0601 AS 
SELECT a.eiid, a.eid, a.eilabel, a.einame, a.eidesc, a.eiversion, a.eiinsdate, c.civalue AS x_total, d.civalue AS y_total, e.civalue AS manager, f.civalue AS tel, g.civalue AS relateroom, h.civalue AS relatex, i.civalue AS relatey
   FROM ig.SOC0118 a
   JOIN ig.SOC0117 b ON a.eid = b.eid AND b.ecategory::text = '007'::text
   LEFT JOIN ig.soc0600 c ON a.eiversion = c.civersion AND a.eismallversion = c.cismallversion AND a.eiid = c.eiid AND c.clabel::text = 'IG_0017'::text
   LEFT JOIN ig.soc0600 d ON a.eiversion = d.civersion AND a.eismallversion = d.cismallversion AND a.eiid = d.eiid AND d.clabel::text = 'IG_0018'::text
   LEFT JOIN ig.soc0600 e ON a.eiversion = e.civersion AND a.eismallversion = e.cismallversion AND a.eiid = e.eiid AND e.clabel::text = 'IG_0019'::text
   LEFT JOIN ig.soc0600 f ON a.eiversion = f.civersion AND a.eismallversion = f.cismallversion AND a.eiid = f.eiid AND f.clabel::text = 'IG_0020'::text
   LEFT JOIN ig.soc0600 g ON a.eiversion = g.civersion AND a.eismallversion = g.cismallversion AND a.eiid = g.eiid AND g.clabel::text = 'IG_0101'::text
   LEFT JOIN ig.soc0600 h ON a.eiversion = h.civersion AND a.eismallversion = h.cismallversion AND a.eiid = h.eiid AND h.clabel::text = 'IG_0102'::text
   LEFT JOIN ig.soc0600 i ON a.eiversion = i.civersion AND a.eismallversion = i.cismallversion AND a.eiid = i.eiid AND i.clabel::text = 'IG_0103'::text;

CREATE OR REPLACE VIEW ig.soc0608 AS 
SELECT v1.eiid, v1.eiversion, v1.eismallversion, v1.deleteflag, count(1) AS eircount
 FROM ( SELECT eir.eiid, max(eir.eiversion) AS eiversion, eir.eismallversion, eir.deleteflag
         FROM (         SELECT ig313.pareiid AS eiid, ig313.parversion AS eiversion, ig313.parsmallversion AS eismallversion, ig313.deleteflag
                         FROM ig.SOC0119 ig313
                        WHERE ig313.deleteflag = '0'::bpchar
              UNION ALL 
                       SELECT ig313.cldeiid AS eiid, ig313.cldversion AS eiversion, ig313.cldsmallversion AS eismallversion, ig313.deleteflag
                         FROM ig.SOC0119 ig313
                        WHERE ig313.deleteflag = '0'::bpchar) eir
        GROUP BY eir.eiid, eir.eismallversion, eir.deleteflag) v1
GROUP BY v1.eiid, v1.eiversion, v1.eismallversion, v1.deleteflag;

CREATE OR REPLACE VIEW ig.soc0602 AS
SELECT  A.EIID AS EIID,
        A.EID AS EID,
     	A.ESYSCODING AS ESYSCODING,
        B.ENAME AS ENAME,
        A.EILABEL AS EILABEL,
        A.EINAME AS EINAME,
        A.EIDESC AS EIDESC,
        A.EIVERSION AS EIVERSION,
        A.EIINSDATE AS EIINSDATE,
        C.CIVALUE AS U_VALUE,
        D.CIVALUE AS U_WIDTH,
        M.CIVALUE AS POWER,
        N.CIVALUE AS LOAD,
        F.EIID AS CONTAINER_EIID,
        F.EILABEL AS CONTAINER_EILABEL,
        F.EINAME AS CONTAINER_EINAME,
    	I.CIVALUE AS INROOMFLG,
        H.CIVALUE AS MODEL,
        A.EISTATUS
    FROM
        ig.SOC0118 A INNER JOIN ig.SOC0117 B ON (A.EID = B.EID AND B.ECATEGORY = '001')
        LEFT OUTER JOIN  (SELECT QA.PAREIID,QA.CLDEIID,QA.CLDVERSION,CLDSMALLVERSION FROM ig.SOC0119 QA,
                (SELECT PAREIID,CLDEIID,MAX(CLDVERSION) as CLDVERSION FROM ig.SOC0119 WHERE EIRRELATION = 'B' AND deleteflag = '0' GROUP BY PAREIID,CLDEIID) QB
                 WHERE QA.PAREIID = QB.PAREIID AND QA.CLDEIID = QB.CLDEIID AND QA.CLDVERSION = QB.CLDVERSION) K ON A.EIID = K.CLDEIID
       LEFT OUTER JOIN ig.soc0600 C ON (A.EIVERSION = C.CIVERSION AND A.EISMALLVERSION = C.CISMALLVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0015')
       LEFT OUTER JOIN ig.soc0600 D ON (A.EIVERSION = D.CIVERSION AND A.EISMALLVERSION = D.CISMALLVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0016')
       LEFT OUTER JOIN ig.soc0600 I ON (A.EIVERSION = I.CIVERSION AND A.EISMALLVERSION = I.CISMALLVERSION AND A.EIID = I.EIID AND I.CLABEL = 'IG_0037')
       LEFT OUTER JOIN ig.soc0600 H ON (A.EIVERSION = H.CIVERSION AND A.EISMALLVERSION = H.CISMALLVERSION AND A.EIID = H.EIID AND H.CLABEL = 'IG_0026')
       LEFT OUTER JOIN ig.soc0600 M ON (A.EIVERSION = M.CIVERSION AND A.EISMALLVERSION = M.CISMALLVERSION AND A.EIID = M.EIID AND M.CLABEL = 'IG_0038')
       LEFT OUTER JOIN ig.soc0600 N ON (A.EIVERSION = N.CIVERSION AND A.EISMALLVERSION = N.CISMALLVERSION AND A.EIID = N.EIID AND N.CLABEL = 'IG_0039')
       LEFT OUTER JOIN ig.SOC0119 E ON (A.EIID = E.CLDEIID AND E.CLDVERSION = K.CLDVERSION AND K.CLDSMALLVERSION = E.CLDSMALLVERSION AND  E.EIRRELATION = 'B' AND E.deleteflag = '0')
       LEFT OUTER JOIN ig.SOC0118 F ON (E.PAREIID = F.EIID AND E.PARVERSION = F.EIVERSION AND COALESCE(E.PARSMALLVERSION,0) = COALESCE(F.EISMALLVERSION,0))
       LEFT OUTER JOIN ig.SOC0117 G ON (F.EID = G.EID AND G.ECATEGORY = '008')
WHERE D.CIVALUE IS NOT NULL;


CREATE OR REPLACE VIEW ig.soc0603 AS 
SELECT A.EIID AS EIID, A.EID AS EID, A.EILABEL AS EILABEL, A.EINAME AS EINAME, 
A.EIDESC AS EIDESC, A.EIVERSION AS EIVERSION, A.EIINSDATE AS EIINSDATE, 
C.CIVALUE AS X_VALUE, D.CIVALUE AS Y_VALUE, 
T.CIVALUE AS U_VALUE, 
E.CIVALUE AS U_TOTAL,
F.CIVALUE AS X_WIDTH, G.CIVALUE AS Y_WIDTH, K.CIVALUE AS GRAPHSTATUS, 
L.CIVALUE AS GRAPHTYPEID, M.CIVALUE AS GRAPHTYPENAME, N.CIVALUE AS GRAPHINDEX, 
O.CIVALUE AS VOLTAGE, P.CIVALUE AS WEIGHT, S.CIVALUE AS WIDTH,  Q.CIVALUE AS STANDARD, 
I.EIID AS ROOM_EIID, I.EILABEL AS ROOM_EILABEL, I.EINAME AS ROOM_EINAME, 
R.CIVALUE AS CONTAINERTYPE, U.CIVALUE AS EITYPE,
V.CIVALUE AS MAXLOAD,
W.CIVALUE AS MAXPOWER,
((E.CIVALUE::integer)-COALESCE(X.COSTU,0))::varchar(2000) AS U_LAST,
((V.CIVALUE::integer)-COALESCE(X.COSTLOAD,0))::varchar(2000) AS LOAD_LAST,
((W.CIVALUE::integer)*1000-COALESCE(X.COSTPOWER,0))::varchar(2000)AS POWER_LAST
FROM ig.SOC0118 A INNER JOIN ig.SOC0117 B ON (A.EID = B.EID AND B.ECATEGORY = '008') 
LEFT OUTER JOIN ig.soc0600 C ON (A.EIVERSION = C.CIVERSION AND A.EIID = C.EIID AND C.CLABEL = 'IG_0021'::text) 
LEFT OUTER JOIN ig.soc0600 D ON (A.EIVERSION = D.CIVERSION AND A.EIID = D.EIID AND D.CLABEL = 'IG_0022'::text) 
LEFT OUTER JOIN ig.soc0600 E ON (A.EIVERSION = E.CIVERSION AND A.EIID = E.EIID AND E.CLABEL = 'IG_0023'::text) 
LEFT OUTER JOIN ig.soc0600 F ON (A.EIVERSION = F.CIVERSION AND A.EIID = F.EIID AND F.CLABEL = 'IG_0024'::text) 
LEFT OUTER JOIN ig.soc0600 G ON (A.EIVERSION = G.CIVERSION AND A.EIID = G.EIID AND G.CLABEL = 'IG_0025'::text) 
LEFT OUTER JOIN ig.soc0600 K ON (A.EIVERSION = K.CIVERSION AND A.EIID = K.EIID AND K.CLABEL = 'IG_0031'::text) 
LEFT OUTER JOIN ig.soc0600 L ON (A.EIVERSION = L.CIVERSION AND A.EIID = L.EIID AND L.CLABEL = 'IG_0032'::text) 
LEFT OUTER JOIN ig.soc0600 M ON (A.EIVERSION = M.CIVERSION AND A.EIID = M.EIID AND M.CLABEL = 'IG_0033'::text) 
LEFT OUTER JOIN ig.soc0600 N ON (A.EIVERSION = N.CIVERSION AND A.EIID = N.EIID AND N.CLABEL = 'IG_0030'::text) 
LEFT OUTER JOIN ig.soc0600 O ON (A.EIVERSION = O.CIVERSION AND A.EIID = O.EIID AND O.CLABEL = 'IG_0034'::text) 
LEFT OUTER JOIN ig.soc0600 P ON (A.EIVERSION = P.CIVERSION AND A.EIID = P.EIID AND P.CLABEL = 'IG_0035'::text) 
LEFT OUTER JOIN ig.soc0600 S ON (A.EIVERSION = S.CIVERSION AND A.EIID = S.EIID AND S.CLABEL = 'IG_0104'::text) 
LEFT OUTER JOIN ig.soc0600 Q ON (A.EIVERSION = Q.CIVERSION AND A.EIID = Q.EIID AND Q.CLABEL = 'IG_0036'::text) 
LEFT OUTER JOIN ig.soc0600 R ON (A.EIVERSION = R.CIVERSION AND A.EIID = R.EIID AND R.CLABEL = 'IG_0105'::text) 
LEFT OUTER JOIN ig.soc0600 T ON (A.EIVERSION = T.CIVERSION AND A.EIID = T.EIID AND T.CLABEL = 'IG_0106'::text) 
LEFT OUTER JOIN ig.soc0600 U ON (A.EIVERSION = U.CIVERSION AND A.EIID = U.EIID AND U.CLABEL = 'IG_0108'::text) 
LEFT OUTER JOIN ig.soc0600 V ON (A.EIVERSION = V.CIVERSION AND A.EIID = V.EIID AND V.CLABEL = 'IG_0201'::text) 
LEFT OUTER JOIN ig.soc0600 W ON (A.EIVERSION = W.CIVERSION AND A.EIID = W.EIID AND W.CLABEL = 'IG_0202'::text) 
LEFT OUTER JOIN ig.SOC0119 H ON (A.EIID = H.CLDEIID AND H.EIRRELATION = 'A' AND deleteflag!='1')
LEFT OUTER JOIN ig.SOC0118 I ON (H.PAREIID = I.EIID) 
LEFT OUTER JOIN ig.SOC0117 J ON (I.EID = J.EID AND J.ECATEGORY = '007')
LEFT OUTER JOIN (SELECT CONTAINER_EIID AS EIID,SUM(U_WIDTH::integer) AS COSTU,SUM(POWER::integer) AS COSTPOWER,SUM(LOAD::integer) AS COSTLOAD FROM ig.soc0602 WHERE CONTAINER_EIID IS NOT NULL GROUP BY CONTAINER_EIID) X ON A.EIID=X.EIID;


  CREATE OR REPLACE VIEW ig.soc0605 AS 
SELECT a.eiid, to_char(a.eid,'999999') eid, a.eidesc, a.einame, a.eilabel, a.eiupdtime, a.eistatus, a.eiinsdate, a.eiorgsyscoding, a.esyscoding, b.ename, b.elabel, b.edesc, b.estatus, b.ecategory, b.ekey1, b.ekey2, b.ekey3, b.emodeltype, a.eiversion, a.eiuserid, a.eiusername, a.eismallversion, a.eirootmark, c.civalue AS serial, d.civalue AS buytime, e.civalue AS useorgan, f.civalue AS wbdate, COALESCE(g.eircount, 0::bigint) AS eircount
           FROM ig.ig013 a
   JOIN ig.ig117 b ON a.eid::text = b.eid::text
   LEFT JOIN ig.ig050 c ON a.eiversion = c.civersion AND a.eismallversion = c.cismallversion AND a.eiid = c.eiid AND c.clabel::text = 'IG_0027'::text
   LEFT JOIN ig.ig050 d ON a.eiversion = d.civersion AND a.eismallversion = d.cismallversion AND a.eiid = d.eiid AND d.clabel::text = 'IG_0028'::text
   LEFT JOIN ig.ig050 e ON a.eiversion = e.civersion AND a.eismallversion = e.cismallversion AND a.eiid = e.eiid AND e.clabel::text = 'IG_0006'::text
   LEFT JOIN ig.ig050 f ON a.eiversion = f.civersion AND a.eismallversion = f.cismallversion AND a.eiid = f.eiid AND f.clabel::text = 'IG_0029'::text
   LEFT JOIN ig.ig336 g ON a.eiid = g.eiid
UNION ALL 
         SELECT soc0124.eiid, soc0124.eid as eid, soc0124.eidesc, soc0124.einame, soc0124.eilabel, soc0124.eiupdtime, soc0124.eistatus, soc0124.eiinsdate, soc0124.eiorgsyscoding, soc0124.esyscoding, soc0124.ename, soc0124.elabel, soc0124.edesc, soc0124.estatus, soc0124.ecategory, soc0124.ekey1, soc0124.ekey2, soc0124.ekey3, soc0124.emodeltype, soc0124.eiversion, soc0124.eiuserid, soc0124.eiusername, soc0124.eismallversion, soc0124.eirootmark, soc0124.serial, soc0124.buytime, soc0124.useorgan, soc0124.wbdate, soc0124.eircount
           FROM ig.soc0124;



DROP VIEW ig.ig499;

--IG499视图变更需要以当前库为基础
create or replace view ig.ig499 as 
select a.eiid, a.eid, a.eidesc, a.einame, a.eilabel, a.eiupdtime, a.eistatus, 
a.eiinsdate, a.eiorgsyscoding, a.esyscoding, b.ename, b.elabel, b.edesc, 
b.estatus, b.ecategory, b.ekey1, b.ekey2, b.ekey3, b.emodeltype, 
a.eiversion, a.eiuserid, a.eiusername, a.eismallversion, a.eirootmark, 
c.civalue as condudetime, d.civalue as facilitator, e.civalue as operator, 
f.civalue as compacttype, g.civalue as contractpayment, 
h.civalue as countmoney, i.civalue as lastdatetime, 0 as imprest 
from ig.soc0118 a 
join ig.soc0117 b on a.eid::text = b.eid::text 
left join ig.soc0600 c on a.eiversion = c.civersion and a.eismallversion = c.cismallversion and a.eiid = c.eiid and c.cid::text = 'CI060000000006'::text 
left join ig.soc0600 d on a.eiversion = d.civersion and a.eismallversion = d.cismallversion and a.eiid = d.eiid and d.cid::text = 'CI060000000008'::text 
left join ig.soc0600 e on a.eiversion = e.civersion and a.eismallversion = e.cismallversion and a.eiid = e.eiid and e.cid::text = 'CI060000000007'::text 
left join ig.soc0600 f on a.eiversion = f.civersion and a.eismallversion = f.cismallversion and a.eiid = f.eiid and f.cid::text = 'CI060000000004'::text 
left join ig.soc0600 g on a.eiversion = g.civersion and a.eismallversion = g.cismallversion and a.eiid = g.eiid and g.cid::text = 'CI060000000011'::text 
left join ig.soc0600 h on a.eiversion = h.civersion and a.eismallversion = h.cismallversion and a.eiid = h.eiid and h.cid::text = 'CI060000000047'::text 
left join ig.soc0600 i on a.eiversion = i.civersion and a.eismallversion = i.cismallversion and a.eiid = i.eiid and i.cid::text = 'CI060000000048'::text 
where a.eid::text = 'CM06000000'::text;

