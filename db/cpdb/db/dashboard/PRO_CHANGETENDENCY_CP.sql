CREATE OR REPLACE PROCEDURE PRO_CHANGETENDENCY_CP IS

  V_COUNT INTEGER DEFAULT 0; --�·ݼ���

  V_PREYEAR_MONTH CHAR(7); --ͳ������

  V_PREDATE CHAR(10) := TO_CHAR(SYSDATE, 'YYYY/MM/DD'); --ͳ������,��ʼΪ��ǰ����
BEGIN
  FOR V_COUNT IN 0 .. 11 LOOP
  
    IF V_COUNT > 0 THEN
      --��ȡ�����·�
      V_PREDATE := FUN_PRELASTDATE(V_PREDATE);
    END IF;
  
    V_PREYEAR_MONTH := SUBSTR(V_PREDATE, 1, 7);
  
    --ɾ��ԭ���·����һ������
    DELETE FROM CHANGETENDENCY
     WHERE CTYEAR = SUBSTR(V_PREDATE, 1, 4)
       AND CTMONTH = SUBSTR(V_PREDATE, 6, 2);
  
    --���²������һ������
    INSERT INTO CHANGETENDENCY
      (CTYEAR, CTMONTH, CTDAY, CTAMOUNT, CTSUCRATE)
      SELECT SUBSTR(V_PREDATE, 1, 4),
             SUBSTR(V_PREDATE, 6, 2),
             TO_CHAR(SYSDATE, 'DD'),
             NVL(AMOUNT, 0),
             NVL(AVERAGETIME, 0)
        FROM (SELECT COUNT(PRI.PRMONTH) AMOUNT,
                     (CASE
                       WHEN COUNT(PRI.PRMONTH) <> 0 THEN
                        ROUND(SUM(SUBSTATUSS) / COUNT(PRI.PRMONTH), 2) * 100
                       ELSE
                        0
                     END) AVERAGETIME
                FROM (SELECT V_PREYEAR_MONTH PRMONTH,
                             (CASE
                               WHEN PR.PRSUBSTATUS = 'S' THEN
                                1
                               ELSE
                                0
                             END) SUBSTATUSS
                        FROM IG500 PR
                       WHERE PR.PRTYPE = 'C'
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
END PRO_CHANGETENDENCY_CP;