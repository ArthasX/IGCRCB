CREATE OR REPLACE TRIGGER TRIG_007
  AFTER INSERT ON IG899
  FOR EACH ROW
DECLARE
  FLAG INT := 0;
BEGIN
  SELECT COUNT(1)
    INTO FLAG
    FROM IG599 A
   INNER JOIN IG500 IG500 ON (A.PRID = IG500.PRID)
   INNER JOIN IG380 B ON (IG500.PRPDID = B.PDID)
   WHERE A.PIID = :NEW.PIID
     AND B.PDSTATUS = 'a';
  IF FLAG > 0 THEN
    INSERT INTO R02
      (R0201,
       R0202,
       R0203,
       R0204,
       R0205,
       R0206,
       R0207,
       R0208,
       R0209,
       R0210,
       R0211)
      SELECT A.PIID,
             A.PRID,
             A.PIVARNAME,
             A.PIVARLABEL,
             :NEW.PPIVALUE,
             A.PIDMODE,
             :NEW.PPIID,
             :NEW.ROLEID,
             :NEW.USERID,
             (SELECT ROLENAME FROM ROLE WHERE ROLEID = :NEW.ROLEID),
             (SELECT USERNAME FROM IGUSER WHERE USERID = :NEW.USERID)
        FROM IG599 A
       WHERE A.PIID = :NEW.PIID;
  END IF;
EXCEPTION
  WHEN OTHERS THEN
    RAISE;
END TRIG_007;
/
