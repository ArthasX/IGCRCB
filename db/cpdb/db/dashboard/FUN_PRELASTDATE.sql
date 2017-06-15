CREATE OR REPLACE FUNCTION FUN_PRELASTDATE(V_DATE IN CHAR) RETURN INTEGER IS
-- ######################################################################
-- # 过程名称: 获取前个月的最后一天
-- # 功能描述: 获取前个月的最后一天
-- ######################################################################
BEGIN
  IF V_DATE IS NULL THEN
    RETURN NULL;
  ELSE
    RETURN TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'DD');
  END IF;
  --上一个月的第一天
  --SELECT   ADD_MONTHS(LAST_DAY(ADD_MONTHS(SYSDATE,-1))+1,-1)   FROM   DUAL;
  --上个月的第一天:
  --TO_CHAR(TRUNC(SYSDATE), 'YYYYMM ')-1|| '01 '
END FUN_PRELASTDATE;
