
CREATE OR REPLACE FUNCTION cst.pro_collect_symmetrix_monitor_day()
  RETURNS void AS
$BODY$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_SYMMETRIX_MONITOR_TEMP检索
	-- # 			插入到COLLECT_SYMMETRIX_MONITOR_DAY中
	-- ######################################################################
	 
DECLARE  
    V_SYMM_ID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    MONITOR_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	
   V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN MONITOR_CURSOR for SELECT DISTINCT SYMM_ID,SUBSTR(SAVETIME,1,10) AS LOOPTIME FROM CST.COLLECT_SYMMETRIX_MONITOR_TEMP where SAVETIME < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' from pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH MONITOR_CURSOR INTO V_SYMM_ID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_SYMMETRIX_MONITOR_DAY插入
	-- ######################################################################     
	        INSERT INTO CST.COLLECT_SYMMETRIX_MONITOR_DAY
			(SAVETIME,
			SYMM_ID,
			TIMESTAMP,
			READS_PER_SEC,
			WRITES_PER_SEC,
			KBYTES_READ_PER_SEC,
			KBYTES_WRITTEN_PER_SEC,
			HITS_READ_PER_SEC,
			HITS_WRITTEN_PER_SEC,
			SEQ_READ_PER_SEC,
			SEQ_WRITTEN_PER_SEC,
			NUMBER_WRITE_PENDING_TRACKS,

			AVGREADS_PER_SEC,
			SUMREADS_PER_SEC,
			MAXREADS_PER_SEC,
			MINREADS_PER_SEC,
			AVGWRITES_PER_SEC,
			SUMWRITES_PER_SEC,
			MAXWRITES_PER_SEC,
			MINWRITES_PER_SEC
			)
        	SELECT V_LOOPTIME,
			SYMM_ID,
			V_CURRENTDATE,
         		MAX(READS_PER_SEC) AS READS_PER_SEC,
         		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(HITS_READ_PER_SEC) AS HITS_READ_PER_SEC,
         		MAX(HITS_WRITTEN_PER_SEC) AS HITS_WRITTEN_PER_SEC,
         		MAX(SEQ_READ_PER_SEC) AS SEQ_READ_PER_SEC,
         		MAX(SEQ_WRITTEN_PER_SEC) AS SEQ_WRITTEN_PER_SEC,
			MAX(NUMBER_WRITE_PENDING_TRACKS) AS NUMBER_WRITE_PENDING_TRACKS,

			AVG(READS_PER_SEC) AS AVGREADS_PER_SEC,
			SUM(READS_PER_SEC) AS SUMREADS_PER_SEC,
			MAX(READS_PER_SEC) AS MAXREADS_PER_SEC,
			MIN(READS_PER_SEC) AS MINREADS_PER_SEC,
			AVG(WRITES_PER_SEC) AS AVGWRITES_PER_SEC,
			SUM(WRITES_PER_SEC) AS SUMWRITES_PER_SEC,
			MAX(WRITES_PER_SEC) AS MAXWRITES_PER_SEC,
			MIN(WRITES_PER_SEC) AS MINWRITES_PER_SEC
          	FROM CST.COLLECT_SYMMETRIX_MONITOR_TEMP
          	WHERE SAVETIME like  V_LOOPTIME||'%' AND SYMM_ID = V_SYMM_ID                  
          	GROUP BY SYMM_ID;

	    END LOOP;
	CLOSE MONITOR_CURSOR;
	              
    RETURN ;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION cst.pro_collect_symmetrix_monitor_day()
  OWNER TO postgres;
CREATE OR REPLACE FUNCTION cst.pro_collect_symmetrix_monitor_hour()
  RETURNS void AS
$BODY$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_SYMMETRIX_MONITOR_TEMP检索
	-- # 			插入到COLLECT_SYMMETRIX_MONITOR_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_SYMM_ID varchar;                -- 存放SYMM_ID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    MONITOR_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中SYMM_ID,统计时间

 	-- ######################################################################
 --select * from CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	
   V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN MONITOR_CURSOR for SELECT DISTINCT SYMM_ID,SUBSTR(SAVETIME,1,10) AS LOOPTIME FROM CST.COLLECT_SYMMETRIX_MONITOR_TEMP where SAVETIME < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' from pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH  MONITOR_CURSOR INTO V_SYMM_ID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_SYMMETRIX_MONITOR_HOUR插入
	-- ######################################################################     
	        INSERT INTO CST.COLLECT_SYMMETRIX_MONITOR_HOUR
			(SAVETIME,
			SYMM_ID,
			TIMESTAMP,
			READS_PER_SEC,
			WRITES_PER_SEC,
			KBYTES_READ_PER_SEC,
			KBYTES_WRITTEN_PER_SEC,
			HITS_READ_PER_SEC,
			HITS_WRITTEN_PER_SEC,
			SEQ_READ_PER_SEC,
			SEQ_WRITTEN_PER_SEC,
			NUMBER_WRITE_PENDING_TRACKS,

			AVGREADS_PER_SEC,
			SUMREADS_PER_SEC,
			MAXREADS_PER_SEC,
			MINREADS_PER_SEC,
			AVGWRITES_PER_SEC,
			SUMWRITES_PER_SEC,
			MAXWRITES_PER_SEC,
			MINWRITES_PER_SEC
			)
		SELECT V_LOOPTIME,
			SYMM_ID,
			V_CURRENTDATE,
         		MAX(READS_PER_SEC) AS READS_PER_SEC,
         		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(HITS_READ_PER_SEC) AS HITS_READ_PER_SEC,
         		MAX(HITS_WRITTEN_PER_SEC) AS HITS_WRITTEN_PER_SEC,
         		MAX(SEQ_READ_PER_SEC) AS SEQ_READ_PER_SEC,
         		MAX(SEQ_WRITTEN_PER_SEC) AS SEQ_WRITTEN_PER_SEC,
			MAX(NUMBER_WRITE_PENDING_TRACKS) AS NUMBER_WRITE_PENDING_TRACKS,

			AVG(READS_PER_SEC) AS AVGREADS_PER_SEC,
			SUM(READS_PER_SEC) AS SUMREADS_PER_SEC,
			MAX(READS_PER_SEC) AS MAXREADS_PER_SEC,
			MIN(READS_PER_SEC) AS MINREADS_PER_SEC,
			AVG(WRITES_PER_SEC) AS AVGWRITES_PER_SEC,
			SUM(WRITES_PER_SEC) AS SUMWRITES_PER_SEC,
			MAX(WRITES_PER_SEC) AS MAXWRITES_PER_SEC,
			MIN(WRITES_PER_SEC) AS MINWRITES_PER_SEC
          	FROM CST.COLLECT_SYMMETRIX_MONITOR_TEMP
          	WHERE SAVETIME like  V_LOOPTIME||'%' AND SYMM_ID = V_SYMM_ID                  
          	GROUP BY SYMM_ID;
	        
	    END LOOP;
	CLOSE MONITOR_CURSOR;
	              
    RETURN ;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION cst.pro_collect_symmetrix_monitor_hour()
  OWNER TO postgres;
