CREATE OR REPLACE FUNCTION FUN_TIMEDIFF(V_STARTTIME IN CHAR,
                                        V_ENDTIME   IN CHAR) RETURN INTEGER IS
  -- ######################################################################
  -- # ��������: ������������֮�����ķ�����
  -- # ��������: ������������֮�����ķ�����
  -- ######################################################################
BEGIN
  IF V_STARTTIME IS NULL OR V_ENDTIME IS NULL THEN
    RETURN NULL;
  ELSE
    RETURN ROUND(TO_NUMBER(TO_DATE(V_ENDTIME, 'YYYY-MM-DD HH24:MI') -
                           TO_DATE(V_STARTTIME, 'YYYY-MM-DD HH24:MI')) * 1440);
  END IF;
END FUN_TIMEDIFF;
