CREATE OR REPLACE VIEW IG173 AS
SELECT PDID, PSDCODE, PSDNAME
  FROM IG333
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'I')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '103'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'P')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '104'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'C')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '105'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'D')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '106'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'S')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '125'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'WA')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '107'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'WB')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '108'
UNION ALL
SELECT PDID, CID, CVALUE
  FROM CODEDETAIL
 INNER JOIN IG259 A ON (A.PTTYPE = 'WS')
 INNER JOIN IG380 B ON (A.PTID = B.PTID)
 WHERE CCID = '221';
