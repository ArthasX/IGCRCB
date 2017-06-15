CREATE OR REPLACE PROCEDURE PRO_INCIDENTTENDENCY_CP IS
  -- ######################################################################
  -- # 过程名称: 针对PROSESSRECORD表进行统计
  -- # 功能描述: 计算事件的平均解决时间
  -- ######################################################################

  V_PREDATE CHAR(10) := TO_CHAR(SYSDATE, 'YYYY/MM/DD'); --统计日期,初始为当前日期

  V_PREYEAR_MONTH CHAR(7); --统计年月

BEGIN
  FOR V_COUNT IN 0 .. 11 LOOP
  
    IF V_COUNT > 0 THEN
      --获取本次月份
      V_PREDATE := FUN_PRELASTDATE(V_PREDATE);
    END IF;
  
    V_PREYEAR_MONTH := SUBSTR(V_PREDATE, 1, 7);
  
    --删除原有月份最后一天数据
    DELETE FROM INCIDENTTENDENCY
     WHERE ITYEAR = SUBSTR(V_PREDATE, 1, 4)
       AND ITMONTH = SUBSTR(V_PREDATE, 6, 2);
    --重新插入最后一天数据
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
  DBMS_OUTPUT.PUT_LINE(SYSDATE || '   执行成功');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    --RAISE;
    DBMS_OUTPUT.PUT_LINE(SYSDATE || '   执行失败');
    DBMS_OUTPUT.PUT_LINE('SQLCODE : ' || SQLCODE);
    DBMS_OUTPUT.PUT_LINE('SQLERRM : ' || SQLERRM);
END PRO_INCIDENTTENDENCY_CP;
