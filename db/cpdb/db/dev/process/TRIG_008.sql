CREATE OR REPLACE TRIGGER TRIG_008
  AFTER UPDATE ON IG899
  FOR EACH ROW
BEGIN
  UPDATE R02
     SET R0205 = :NEW.PPIVALUE,
         R0208 = :NEW.ROLEID,
         R0209 = :NEW.USERID,
         R0210 = (SELECT ROLENAME FROM ROLE WHERE ROLEID = :NEW.ROLEID),
         R0211 = (SELECT USERNAME FROM IGUSER WHERE USERID = :NEW.USERID)
   WHERE R0207 = :NEW.PPIID;
EXCEPTION
  WHEN OTHERS THEN
    RAISE;
END TRIG_008;
/
