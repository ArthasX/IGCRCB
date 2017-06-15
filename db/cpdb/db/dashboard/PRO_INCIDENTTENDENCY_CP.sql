CREATE OR REPLACE PROCEDURE PRO_INCIDENTTENDENCY_CP IS
  -- ######################################################################
  -- # ��������: ���PROSESSRECORD�����ͳ��
  -- # ��������: �����¼���ƽ�����ʱ��
  -- ######################################################################

  V_PREDATE CHAR(10) := TO_CHAR(SYSDATE, 'YYYY/MM/DD'); --ͳ������,��ʼΪ��ǰ����

  V_PREYEAR_MONTH CHAR(7); --ͳ������

BEGIN
  FOR V_COUNT IN 0 .. 11 LOOP
  
    IF V_COUNT > 0 THEN
      --��ȡ�����·�
      V_PREDATE := FUN_PRELASTDATE(V_PREDATE);
    END IF;
  
    V_PREYEAR_MONTH := SUBSTR(V_PREDATE, 1, 7);
  
    --ɾ��ԭ���·����һ������
    DELETE FROM INCIDENTTENDENCY
     WHERE ITYEAR = SUBSTR(V_PREDATE, 1, 4)
       AND ITMONTH = SUBSTR(V_PREDATE, 6, 2);
    --���²������һ������
    INSERT INTO INCIDENTTENDENCY
      (ITYEAR, ITMONTH, ITDAY, ITAMOUNT, ITAVERAGETIME)
      SELECT SUBSTR(V_PREDATE, 1, 4),
             SUBSTR(V_PREDATE, 6, 2),
             TO_CHAR(SYSDATE, 'DD'),
             AMOUNT,
             AVERAGETIME
        FROM (SELECT COUNT(PRI.PRMONTH) AMOUNT,
                     (CASE
                       WHEN COUNT(PRI.PRMONTH) <> 0 THEN
                        ROUND(SUM(TTIME) / COUNT(PRI.PRMONTH))
                       ELSE
                        0
                     END) AVERAGETIME
                FROM (SELECT V_PREYEAR_MONTH PRMONTH,
                             (CASE
                               WHEN FUN_TIMEDIFF(PR.PROPENTIME, PR.PRCLOSETIME) IS NULL THEN
                                0
                               ELSE
                                FUN_TIMEDIFF(PR.PROPENTIME, PR.PRCLOSETIME)
                             END) TTIME
                        FROM IG500 PR
                       WHERE PR.PRTYPE = 'I'
                         AND PR.PRSTATUS = 'C'
                         AND SUBSTR(PR.PRCLOSETIME, 1, 7) = V_PREYEAR_MONTH
                         AND (PR.PRSUBSTATUS <> 'C' OR PR.PRSUBSTATUS IS NULL)) PRI
               GROUP BY PRI.PRMONTH);
  END LOOP;
  COMMIT;
  DBMS_OUTPUT.PUT_LINE(SYSDATE || '   ִ�гɹ�');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    --RAISE;
    DBMS_OUTPUT.PUT_LINE(SYSDATE || '   ִ��ʧ��');
    DBMS_OUTPUT.PUT_LINE('SQLCODE : ' || SQLCODE);
    DBMS_OUTPUT.PUT_LINE('SQLERRM : ' || SQLERRM);
END PRO_INCIDENTTENDENCY_CP;
