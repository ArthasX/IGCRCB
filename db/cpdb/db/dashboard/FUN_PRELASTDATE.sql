CREATE OR REPLACE FUNCTION FUN_PRELASTDATE(V_DATE IN CHAR) RETURN INTEGER IS
-- ######################################################################
-- # ��������: ��ȡǰ���µ����һ��
-- # ��������: ��ȡǰ���µ����һ��
-- ######################################################################
BEGIN
  IF V_DATE IS NULL THEN
    RETURN NULL;
  ELSE
    RETURN TO_CHAR(LAST_DAY(ADD_MONTHS(SYSDATE, -1)), 'DD');
  END IF;
  --��һ���µĵ�һ��
  --SELECT   ADD_MONTHS(LAST_DAY(ADD_MONTHS(SYSDATE,-1))+1,-1)   FROM   DUAL;
  --�ϸ��µĵ�һ��:
  --TO_CHAR(TRUNC(SYSDATE), 'YYYYMM ')-1|| '01 '
END FUN_PRELASTDATE;
