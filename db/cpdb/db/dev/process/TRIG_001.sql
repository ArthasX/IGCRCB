CREATE OR REPLACE TRIGGER TRIG_001
  BEFORE INSERT ON IG337
  FOR EACH ROW
DECLARE
  FLAG INT := 0;
BEGIN
  SELECT COUNT(1)
    INTO FLAG
    FROM IG500 IG500
   INNER JOIN IG380 B ON (IG500.PRPDID = B.PDID)
   WHERE B.PDSTATUS = 'a'
     AND IG500.PRID = :NEW.PRID;
  IF FLAG = 1 THEN
    INSERT INTO R01
      (R0101,
       R0102,
       R0103,
       R0104,
       R0105,
       R0106,
       R0107,
       R0108,
       R0109,
       R0110,
       R0111,
       R0112,
       R0113,
       R0114,
       R0115,
       R0116,
       R0117,
       R0118,
       R0119,
       R0120,
       R0121,
       R0122,
       R0123,
       R0124,
       R0125,
       R0126,
       R0127,
       R0128,
       R0129,
       R0130,
       R0131)
      SELECT :NEW.PPID,
             IG500.PRID,
             IG500.PRTYPE,
             IG500.PRSTATUS,
             IG500.PRTITLE,
             IG500.PRDESC,
             IG500.PROPENTIME,
             IG500.PRCLOSETIME,
             IG500.PRPDID,
             IG500.PRPDNAME,
             IG500.PRSERIALNUM,
             :NEW.PPROLEID,
             :NEW.PPROLENAME,
             :NEW.PPUSERID,
             :NEW.PPUSERNAME,
             :NEW.PPORGID,
             (SELECT ORGNAME FROM ORGANIZATION WHERE ORGID = :NEW.PPORGID),
             A.PSDNAME,
             B.PSDNAME,
             :NEW.PPSTATUS,
             :NEW.PPINITTIME,
             :NEW.PPPROCTIME,
             :NEW.PPSUBSTATUS,
             :NEW.PPBACKTIME,
             :NEW.PPPROXYUSERID,
             :NEW.PPSUPER,
             :NEW.PPROLEMANAGER,
             :NEW.PPDUTYPERSON,
             :NEW.PBDID,
             (SELECT USERNAME FROM IGUSER WHERE USERID = :NEW.PPPROXYUSERID),
             C.PTNAME
        FROM IG500 IG500
       INNER JOIN IG173 A ON (IG500.PRPDID = A.PDID AND
                                           IG500.PRSTATUS = A.PSDCODE)
       INNER JOIN IG173 B ON (IG500.PRPDID = B.PDID AND
                                           B.PSDCODE = :NEW.PPSTATUS)
       INNER JOIN IG259 C ON (IG500.PRTYPE = C.PTTYPE)
       WHERE PRID = :NEW.PRID;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    RAISE;
END TRIG_001;
/
