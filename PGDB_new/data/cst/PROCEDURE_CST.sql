CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DEVICES_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DEVICES_TEMP检索
	-- # 			插入到COLLECT_DEVICES_DAY中
	-- ######################################################################


 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DEVICES_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	
	
       BEGIN 
      
	OPEN COLLECT_DEVICES_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DEVICES_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DEVICES_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DEVICES_DAY
	        (DATAID,
	        DATA_TIMES,
	        DEVICE_NAME,
	        KBYTES_READ_PER_SEC,
			KBYTES_WRITTEN_PER_SEC,
			WRITE_PENDING_COUNT,
			TOTAL_IOS_PER_SEC,
			RANDOM_READS_PER_SEC,
			RANDOM_WRITES_PER_SEC,
			SEQ_READS_PER_SEC,
			SEQ_WRITES_PER_SEC,

			AVGTOTAL_IOS_PER_SEC,
			SUMTOTAL_IOS_PER_SEC,
			MAXTOTAL_IOS_PER_SEC,
			MINTOTAL_IOS_PER_SEC,
			AVGWRITE_PENDING_COUNT,
			SUMWRITE_PENDING_COUNT,
			MAXWRITE_PENDING_COUNT,
			MINWRITE_PENDING_COUNT
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DEVICE_NAME,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(WRITE_PENDING_COUNT) AS WRITE_PENDING_COUNT,
         		MAX(TOTAL_IOS_PER_SEC) AS TOTAL_IOS_PER_SEC,
         		MAX(RANDOM_READS_PER_SEC) AS RANDOM_READS_PER_SEC,
         		MAX(RANDOM_WRITES_PER_SEC) AS RANDOM_WRITES_PER_SEC,
         		MAX(SEQ_READS_PER_SEC) AS SEQ_READS_PER_SEC,
         		MAX(SEQ_WRITES_PER_SEC) AS SEQ_WRITES_PER_SEC,

			AVG(TOTAL_IOS_PER_SEC) AS AVGTOTAL_IOS_PER_SEC,
			SUM(TOTAL_IOS_PER_SEC) AS SUMTOTAL_IOS_PER_SEC,
			MAX(TOTAL_IOS_PER_SEC) AS MAXTOTAL_IOS_PER_SEC,
			MIN(TOTAL_IOS_PER_SEC) AS MINTOTAL_IOS_PER_SEC,
			AVG(WRITE_PENDING_COUNT) AS AVGWRITE_PENDING_COUNT,
			SUM(WRITE_PENDING_COUNT) AS SUMWRITE_PENDING_COUNT,
			MAX(WRITE_PENDING_COUNT) AS MAXWRITE_PENDING_COUNT,
			MIN(WRITE_PENDING_COUNT) AS MINWRITE_PENDING_COUNT
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DEVICE_NAME;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DEVICE'',DEVICE_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DEVICE_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE =''DEVICE'')  GROUP BY DATAID,DEVICE_NAME';
	    END LOOP;
	CLOSE COLLECT_DEVICES_CURSOR;
	              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DEVICES_HOUR (varchar) RETURNS Void AS $$

	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DEVICES_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DEVICES_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH COLLECT_DEVICES_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DEVICES_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DEVICES_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DEVICE_NAME,
	        KBYTES_READ_PER_SEC,
			KBYTES_WRITTEN_PER_SEC,
			WRITE_PENDING_COUNT,
			TOTAL_IOS_PER_SEC,
			RANDOM_READS_PER_SEC,
			RANDOM_WRITES_PER_SEC,
			SEQ_READS_PER_SEC,
			SEQ_WRITES_PER_SEC,

			AVGTOTAL_IOS_PER_SEC,
			SUMTOTAL_IOS_PER_SEC,
			MAXTOTAL_IOS_PER_SEC,
			MINTOTAL_IOS_PER_SEC,
			AVGWRITE_PENDING_COUNT,
			SUMWRITE_PENDING_COUNT,
			MAXWRITE_PENDING_COUNT,
			MINWRITE_PENDING_COUNT
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DEVICE_NAME,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(WRITE_PENDING_COUNT) AS WRITE_PENDING_COUNT,
         		MAX(TOTAL_IOS_PER_SEC) AS TOTAL_IOS_PER_SEC,
         		MAX(RANDOM_READS_PER_SEC) AS RANDOM_READS_PER_SEC,
         		MAX(RANDOM_WRITES_PER_SEC) AS RANDOM_WRITES_PER_SEC,
         		MAX(SEQ_READS_PER_SEC) AS SEQ_READS_PER_SEC,
         		MAX(SEQ_WRITES_PER_SEC) AS SEQ_WRITES_PER_SEC,

			AVG(TOTAL_IOS_PER_SEC) AS AVGTOTAL_IOS_PER_SEC,
			SUM(TOTAL_IOS_PER_SEC) AS SUMTOTAL_IOS_PER_SEC,
			MAX(TOTAL_IOS_PER_SEC) AS MAXTOTAL_IOS_PER_SEC,
			MIN(TOTAL_IOS_PER_SEC) AS MINTOTAL_IOS_PER_SEC,
			AVG(WRITE_PENDING_COUNT) AS AVGWRITE_PENDING_COUNT,
			SUM(WRITE_PENDING_COUNT) AS SUMWRITE_PENDING_COUNT,
			MAX(WRITE_PENDING_COUNT) AS MAXWRITE_PENDING_COUNT,
			MIN(WRITE_PENDING_COUNT) AS MINWRITE_PENDING_COUNT
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DEVICE_NAME';
	        
	    END LOOP;
	CLOSE COLLECT_DEVICES_CURSOR;
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_ESCON_DAY (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_ESCON_TEMP检索
	-- # 			插入到COLLECT_DIR_ESCON_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_ESCON_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_ESCON_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_ESCON_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DIR_ESCON_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_ESCON_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_ESCON_CURSOR;
	              
              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;


-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_ESCON_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_ESCON_TEMP检索
	-- # 			插入到COLLECT_DIR_ESCON_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_ESCON_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_ESCON_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_ESCON_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIR_ESCON_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_ESCON_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_ESCON_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_RA1_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_RA1_TEMP检索
	-- # 			插入到COLLECT_DIR_RA1_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_RA1_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_RA1_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_RA1_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_DIR_RA1_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_RA1_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			KBYTES_RECEIVED_PER_SEC,
			KBYTES_SENT_PER_SEC,
			LINK_UTILIZATION,
			BUSY,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
         		MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
         		MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
         		MAX(BUSY) AS BUSY,
         		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
         		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_RA1_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_RA1_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_RA1_TEMP检索
	-- # 			插入到COLLECT_DIR_RA1_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_RA1_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_RA1_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_RA1_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_DIR_RA1_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_RA1_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			KBYTES_RECEIVED_PER_SEC,
			KBYTES_SENT_PER_SEC,
			LINK_UTILIZATION,
			BUSY,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
         		MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
         		MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
         		MAX(BUSY) AS BUSY,
         		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
         		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_RA1_CURSOR;
	              
              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_RA2_DAY (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_RA2_TEMP检索
	-- # 			插入到COLLECT_DIR_RA2_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_RA2_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_RA2_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_RA2_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIR_RA2_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_RA2_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			KBYTES_RECEIVED_PER_SEC,
			KBYTES_SENT_PER_SEC,
			LINK_UTILIZATION,
			BUSY,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
         		MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
         		MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
         		MAX(BUSY) AS BUSY,
         		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
         		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_RA2_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_RA2_HOUR (varchar)RETURNS Void AS $$

	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_RA2_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_RA2_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_RA2_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIR_RA2_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_RA2_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			KBYTES_RECEIVED_PER_SEC,
			KBYTES_SENT_PER_SEC,
			LINK_UTILIZATION,
			BUSY,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
         		MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
         		MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
         		MAX(BUSY) AS BUSY,
         		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
         		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_RA2_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_SA_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_SA_TEMP检索
	-- # 			插入到COLLECT_DIR_SA_DAY中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_SA_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_SA_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_SA_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIR_SA_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_SA_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_SA_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_SA_HOUR (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_SA_TEMP检索
	-- # 			插入到COLLECT_DIR_SA_HOUR中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
 COLLECT_DIR_SA_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN COLLECT_DIR_SA_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_SA_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DIR_SA_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_SA_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_SA_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_SE_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_SE_TEMP检索
	-- # 			插入到COLLECT_DIR_SE_DAY中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIR_SE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_SE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_SE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIR_SE_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_SE_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_SE_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIR_SE_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_DIR_SE_TEMP检索
	-- # 			插入到COLLECT_DIR_SE_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_DIR_SE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIR_SE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIR_SE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DIR_SE_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIR_SE_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
			IOS_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_DIR_SE_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_DA_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_DA_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_DA_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIRECTORS_DA_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_DA_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_DA_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIRECTORS_DA_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_DA_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME,
	        MAXBUSY,
	        AVGBUSY,
	        MAX_DATA_TIMES,
	        TOTALCOUNT,

		AVGIOS_PER_SEC,
		SUMIOS_PER_SEC,
		MAXIOS_PER_SEC,
		MINIOS_PER_SEC,
		SUMBUSY,
		MINBUSY
		)
		        SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY
	            FROM '||$1||' A ,
		             (SELECT DIRECTOR_NUMBER,DATAID,
		             		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
		             		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
		             		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
		             		MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

					AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
					SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
					MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
					MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
					SUM(BUSY) AS SUMBUSY,
					MIN(BUSY) AS MINBUSY
		              FROM '||$1||'
		              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
		              GROUP BY DIRECTOR_NUMBER,DATAID
		              ) B 
	         	WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER 
	               AND  B.DATAID = A.DATAID
	               AND  B.MAXBUSY = A.BUSY               
	               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	            GROUP BY A.DATAID,
			            A.DIRECTOR_NUMBER,
			            B.IOS_PER_SEC,
				    B.INTERVAL_TIME,
				    B.ACCUMULATED_DIRECTOR_IDLE_TIME,
			            A.BUSY,
			            B.AVGBUSY,
			            B.TOTALCOUNT,

				    B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY;

		INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DIRECTORS_DA'',DIRECTOR_NUMBER FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DIRECTOR_NUMBER NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''DIRECTORS_DA'')  GROUP BY DATAID,DIRECTOR_NUMBER';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_DA_CURSOR;
              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_DA_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_DA_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_DA_HOUR中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIRECTORS_DA_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_DA_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_DA_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DIRECTORS_DA_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_DA_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
	        IOS_PER_SEC,
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME,
	        MAXBUSY,
	        AVGBUSY,
	        MAX_DATA_TIMES,
	        TOTALCOUNT,
		AVGIOS_PER_SEC,
		SUMIOS_PER_SEC,
		MAXIOS_PER_SEC,
		MINIOS_PER_SEC,
		SUMBUSY,
		MINBUSY
		)
		        SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY
	            FROM '||$1||' A ,
		             (SELECT DIRECTOR_NUMBER,DATAID,
		             		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
		             		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
		             		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
		             		MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

					AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
					SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
					MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
					MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
					SUM(BUSY) AS SUMBUSY,
					MIN(BUSY) AS MINBUSY
					
		              FROM '||$1||'
		              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
		              GROUP BY DIRECTOR_NUMBER,DATAID
		              ) B 
	         	WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER
	               AND  B.DATAID = A.DATAID 
	               AND B.MAXBUSY  = A.BUSY               
	               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	            GROUP BY A.DATAID,
			            A.DIRECTOR_NUMBER,
			            B.IOS_PER_SEC,
						B.INTERVAL_TIME,
						B.ACCUMULATED_DIRECTOR_IDLE_TIME,
			            A.BUSY,
			            B.AVGBUSY,
			            B.TOTALCOUNT,

				    B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_DA_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;


-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_FE_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_FE_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_FE_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIRECTORS_FE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_FE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_FE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_DIRECTORS_FE_DAY插入
	-- ######################################################################     
	    EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_FE_DAY
	    (DATAID,
	    DATA_TIMES,
	    DIRECTOR_NUMBER,
	    IOS_PER_SEC,
		READS_PER_SEC,
		WRITES_PER_SEC,	
		INTERVAL_TIME,
		ACCUMULATED_DIRECTOR_IDLE_TIME,
	    MAXBUSY,
	    AVGBUSY,
	    MAX_DATA_TIMES,
	    TOTALCOUNT,

	    AVGIOS_PER_SEC,
	    SUMIOS_PER_SEC,
	    MAXIOS_PER_SEC,
	    MINIOS_PER_SEC,
	    SUMBUSY,
	    MINBUSY
	    )
		    SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
					B.READS_PER_SEC,
					B.WRITES_PER_SEC,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY
	        FROM '||$1||' A ,
	             (SELECT DIRECTOR_NUMBER,DATAID,
	             		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
	             		MAX(READS_PER_SEC) AS READS_PER_SEC,
	             		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
	             		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
	             		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
	             		MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

				AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
				SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
				MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
				MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
				SUM(BUSY) AS SUMBUSY,
				MIN(BUSY) AS MINBUSY
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DIRECTOR_NUMBER,DATAID
	              ) B 
	        WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER
	               AND  B.DATAID = A.DATAID
	               AND B.MAXBUSY = A.BUSY               
	               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	        GROUP BY A.DATAID,
	        		A.DIRECTOR_NUMBER,
	        		B.IOS_PER_SEC,
					B.READS_PER_SEC,
					B.WRITES_PER_SEC,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
	        		A.BUSY,
	        		B.AVGBUSY,
	        		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DIRECTORS_FE'',DIRECTOR_NUMBER FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DIRECTOR_NUMBER NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''DIRECTORS_FE'') GROUP BY DATAID,DIRECTOR_NUMBER';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_FE_CURSOR;	
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_FE_HOUR (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_FE_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_FE_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_DIRECTORS_FE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_FE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_FE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_DIRECTORS_FE_DAY插入
	-- ######################################################################     
	    EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_FE_HOUR
	    (DATAID,
	    DATA_TIMES,
	    DIRECTOR_NUMBER,
	    IOS_PER_SEC,
		READS_PER_SEC,
		WRITES_PER_SEC,	
		INTERVAL_TIME,
		ACCUMULATED_DIRECTOR_IDLE_TIME,
	    MAXBUSY,
	    AVGBUSY,
	    MAX_DATA_TIMES,
	    TOTALCOUNT,

	    AVGIOS_PER_SEC,
	    SUMIOS_PER_SEC,
	    MAXIOS_PER_SEC,
	    MINIOS_PER_SEC,
	    SUMBUSY,
	    MINBUSY
	    )
		    SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
					B.READS_PER_SEC,
					B.WRITES_PER_SEC,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY
	        FROM '||$1||' A ,
	             (SELECT DIRECTOR_NUMBER,DATAID,
	             		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
	             		MAX(READS_PER_SEC) AS READS_PER_SEC,
	             		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
	             		MAX(INTERVAL_TIME) AS INTERVAL_TIME,
	             		MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
	             		MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

				AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
				SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
				MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
				MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
				SUM(BUSY) AS SUMBUSY,
				MIN(BUSY) AS MINBUSY
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DIRECTOR_NUMBER,DATAID
	              ) B 
	        WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER
	               AND  B.DATAID = A.DATAID
	               AND B.MAXBUSY = A.BUSY               
	               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	        GROUP BY A.DATAID,
	        		A.DIRECTOR_NUMBER,
	        		B.IOS_PER_SEC,
					B.READS_PER_SEC,
					B.WRITES_PER_SEC,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
	        		A.BUSY,
	        		B.AVGBUSY,
	        		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
				B.SUMIOS_PER_SEC,
				B.MAXIOS_PER_SEC,
				B.MINIOS_PER_SEC,
				B.SUMBUSY,
				B.MINBUSY;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DIRECTORS_FE'',DIRECTOR_NUMBER FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DIRECTOR_NUMBER NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''DIRECTORS_FE'') GROUP BY DATAID,DIRECTOR_NUMBER';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_FE_CURSOR;	
              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_RDF_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_RDF_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_RDF_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_DIRECTORS_RDF_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_RDF_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_RDF_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # COLLECT_DIRECTORS_RDF_DAY插入
	-- ######################################################################     
	   EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_RDF_DAY
		   (DATAID,
		    DATA_TIMES,
		    DIRECTOR_NUMBER,
		    IOS_PER_SEC,
		    KBYTES_RECEIVED_PER_SEC,
		    KBYTES_SENT_PER_SEC,
		    LINK_UTILIZATION,	
		    INTERVAL_TIME,
		    ACCUMULATED_DIRECTOR_IDLE_TIME,
		    MAXBUSY,
		    AVGBUSY,
		    MAX_DATA_TIMES,
		    TOTALCOUNT,

		    AVGIOS_PER_SEC,
		    SUMIOS_PER_SEC,
		    MAXIOS_PER_SEC,
		    MINIOS_PER_SEC,
		    AVGLINK_UTILIZATION,
		    SUMLINK_UTILIZATION,
		    MAXLINK_UTILIZATION,
		    MINLINK_UTILIZATION,
		    SUMBUSY,
		    MINBUSY
		    )
		    SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
					B.KBYTES_RECEIVED_PER_SEC,
					B.KBYTES_SENT_PER_SEC,
					B.LINK_UTILIZATION,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
			        B.SUMIOS_PER_SEC,
			        B.MAXIOS_PER_SEC,
			        B.MINIOS_PER_SEC,
			        B.AVGLINK_UTILIZATION,
			        B.SUMLINK_UTILIZATION,
			        B.MAXLINK_UTILIZATION,
			        B.MINLINK_UTILIZATION,
			        B.SUMBUSY,
			        B.MINBUSY
	        FROM '||$1||' A ,
	             (SELECT DIRECTOR_NUMBER,DATAID,
	             	MAX(IOS_PER_SEC) AS IOS_PER_SEC,
	             	MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
	             	MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
	             	MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
	             	MAX(INTERVAL_TIME) AS INTERVAL_TIME,
	            	MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
	             	MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

			AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
		        SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
		        MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
		        MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
		        AVG(LINK_UTILIZATION) AS AVGLINK_UTILIZATION,
		        SUM(LINK_UTILIZATION) AS SUMLINK_UTILIZATION,
		        MAX(LINK_UTILIZATION) AS MAXLINK_UTILIZATION,
		        MIN(LINK_UTILIZATION) AS MINLINK_UTILIZATION,
		        SUM(BUSY) AS SUMBUSY,
		        MIN(BUSY) AS MINBUSY
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DIRECTOR_NUMBER,DATAID
	              ) B 
	        WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER
	       	 	AND  B.DATAID = A.DATAID
	        	AND B.MAXBUSY = A.BUSY               
	        	AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	        GROUP BY A.DATAID,
	        		A.DIRECTOR_NUMBER,
	        		B.IOS_PER_SEC,
				B.KBYTES_RECEIVED_PER_SEC,
				B.KBYTES_SENT_PER_SEC,
				B.LINK_UTILIZATION,	
				B.INTERVAL_TIME,
				B.ACCUMULATED_DIRECTOR_IDLE_TIME,
	        		A.BUSY,
	        		B.AVGBUSY,
	        		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
			        B.SUMIOS_PER_SEC,
			        B.MAXIOS_PER_SEC,
			        B.MINIOS_PER_SEC,
			        B.AVGLINK_UTILIZATION,
			        B.SUMLINK_UTILIZATION,
			        B.MAXLINK_UTILIZATION,
			        B.MINLINK_UTILIZATION,
			        B.SUMBUSY,
			        B.MINBUSY;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DIRECTORS_RDF'',DIRECTOR_NUMBER FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DIRECTOR_NUMBER NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''DIRECTORS_RDF'')  GROUP BY DATAID,DIRECTOR_NUMBER';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_RDF_CURSOR;	               
             
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DIRECTORS_RDF_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DIRECTORS_RDF_TEMP检索
	-- # 			插入到COLLECT_DIRECTORS_RDF_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_DIRECTORS_RDF_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DIRECTORS_RDF_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DIRECTORS_RDF_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DIRECTORS_RDF_HOUR插入
	-- ######################################################################     
	   EXECUTE ' INSERT INTO CST.COLLECT_DIRECTORS_RDF_HOUR
		   (DATAID,
		    DATA_TIMES,
		    DIRECTOR_NUMBER,
		    IOS_PER_SEC,
			KBYTES_RECEIVED_PER_SEC,
			KBYTES_SENT_PER_SEC,
			LINK_UTILIZATION,	
			INTERVAL_TIME,
			ACCUMULATED_DIRECTOR_IDLE_TIME,
		    MAXBUSY,
		    AVGBUSY,
		    MAX_DATA_TIMES,
		    TOTALCOUNT,

		    AVGIOS_PER_SEC,
		    SUMIOS_PER_SEC,
		    MAXIOS_PER_SEC,
		    MINIOS_PER_SEC,
		    AVGLINK_UTILIZATION,
		    SUMLINK_UTILIZATION,
		    MAXLINK_UTILIZATION,
		    MINLINK_UTILIZATION,
		    SUMBUSY,
		    MINBUSY
		    )
		    SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DIRECTOR_NUMBER,
		    		B.IOS_PER_SEC,
				B.KBYTES_RECEIVED_PER_SEC,
				B.KBYTES_SENT_PER_SEC,
				B.LINK_UTILIZATION,	
				B.INTERVAL_TIME,
				B.ACCUMULATED_DIRECTOR_IDLE_TIME,
		    		A.BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGIOS_PER_SEC,
			        B.SUMIOS_PER_SEC,
			        B.MAXIOS_PER_SEC,
			        B.MINIOS_PER_SEC,
			        B.AVGLINK_UTILIZATION,
			        B.SUMLINK_UTILIZATION,
			        B.MAXLINK_UTILIZATION,
			        B.MINLINK_UTILIZATION,
			        B.SUMBUSY,
			        B.MINBUSY
	        FROM '||$1||' A ,
	             (SELECT DIRECTOR_NUMBER,DATAID,
	             	MAX(IOS_PER_SEC) AS IOS_PER_SEC,
	             	MAX(KBYTES_RECEIVED_PER_SEC) AS KBYTES_RECEIVED_PER_SEC,
	             	MAX(KBYTES_SENT_PER_SEC) AS KBYTES_SENT_PER_SEC,
	             	MAX(LINK_UTILIZATION) AS LINK_UTILIZATION,
	             	MAX(INTERVAL_TIME) AS INTERVAL_TIME,
	            	MAX(ACCUMULATED_DIRECTOR_IDLE_TIME) AS ACCUMULATED_DIRECTOR_IDLE_TIME,
	             	MAX(BUSY) AS MAXBUSY,AVG(BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

			AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
		        SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
		        MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
		        MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
		        AVG(LINK_UTILIZATION) AS AVGLINK_UTILIZATION,
		        SUM(LINK_UTILIZATION) AS SUMLINK_UTILIZATION,
		        MAX(LINK_UTILIZATION) AS MAXLINK_UTILIZATION,
		        MIN(LINK_UTILIZATION) AS MINLINK_UTILIZATION,
		        SUM(BUSY) AS SUMBUSY,
		        MIN(BUSY) AS MINBUSY
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DIRECTOR_NUMBER,DATAID
	              ) B 
	        WHERE B.DIRECTOR_NUMBER = A.DIRECTOR_NUMBER
	       	 	AND  B.DATAID = A.DATAID
	        	AND B.MAXBUSY = A.BUSY               
	        	AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
	        GROUP BY A.DATAID,
	        		A.DIRECTOR_NUMBER,
	        		B.IOS_PER_SEC,
					B.KBYTES_RECEIVED_PER_SEC,
					B.KBYTES_SENT_PER_SEC,
					B.LINK_UTILIZATION,	
					B.INTERVAL_TIME,
					B.ACCUMULATED_DIRECTOR_IDLE_TIME,
	        		A.BUSY,
	        		B.AVGBUSY,
	        		B.TOTALCOUNT,
				
				B.AVGIOS_PER_SEC,
			        B.SUMIOS_PER_SEC,
			        B.MAXIOS_PER_SEC,
			        B.MINIOS_PER_SEC,
			        B.AVGLINK_UTILIZATION,
			        B.SUMLINK_UTILIZATION,
			        B.MAXLINK_UTILIZATION,
			        B.MINLINK_UTILIZATION,
			        B.SUMBUSY,
			        B.MINBUSY';
	    END LOOP;
	CLOSE COLLECT_DIRECTORS_RDF_CURSOR;	               
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DISKS_DAY (varchar)RETURNS Void AS $$


	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DISKS_TEMP检索
	-- # 			插入到COLLECT_DISKS_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_DISKS_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DISKS_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DISKS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DISKS_DAY插入
	-- ######################################################################     
	       EXECUTE ' INSERT INTO CST.COLLECT_DISKS_DAY
	        (DATAID,
	         DATA_TIMES,
	         DEVICE_NAME,
	         TOTAL_SCSI_COMMAND_PER_SEC,
	         READ_COMMANDS_PER_SEC,
	         WRITE_COMMANDS_PER_SEC,
	         XOR_WRITE_COMMANDS_PER_SEC,
	         XOR_READ_COMMANDS_PER_SEC,
	         AVERAGE_QUEUE,
	         DISK_IDLE_TIME_PER_SEC,
	         ACCUMULATED_QUEUE_DEPTH,
	         MAXBUSY,
	         AVGBUSY,
	         MAX_DATA_TIMES,
	         TOTALCOUNT,

		 AVGDISK_BUSY,
		 SUMDISK_BUSY,
		 MAXDISK_BUSY,
		 MINDISK_BUSY,
		 AVGTOTAL_SCSI_COMMAND_PER_SEC,
		 SUMTOTAL_SCSI_COMMAND_PER_SEC,
		 MAXTOTAL_SCSI_COMMAND_PER_SEC,
		 MINTOTAL_SCSI_COMMAND_PER_SEC
		    )
	        SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DEVICE_NAME,
		    		B.TOTAL_SCSI_COMMAND_PER_SEC,
	         		B.READ_COMMANDS_PER_SEC,
	         		B.WRITE_COMMANDS_PER_SEC,
	         		B.XOR_WRITE_COMMANDS_PER_SEC,
	         		B.XOR_READ_COMMANDS_PER_SEC,
	         		B.AVERAGE_QUEUE,
	         		B.DISK_IDLE_TIME_PER_SEC,
	         		B.ACCUMULATED_QUEUE_DEPTH,
		    		A.DISK_BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGDISK_BUSY,
				B.SUMDISK_BUSY,
				B.MAXDISK_BUSY,
				B.MINDISK_BUSY,
				B.AVGTOTAL_SCSI_COMMAND_PER_SEC,
				B.SUMTOTAL_SCSI_COMMAND_PER_SEC,
				B.MAXTOTAL_SCSI_COMMAND_PER_SEC,
				B.MINTOTAL_SCSI_COMMAND_PER_SEC
            FROM '||$1||' A ,
	             (SELECT DEVICE_NAME,DATAID,
	             	MAX(TOTAL_SCSI_COMMAND_PER_SEC) AS TOTAL_SCSI_COMMAND_PER_SEC,
	             	MAX(READ_COMMANDS_PER_SEC) AS READ_COMMANDS_PER_SEC,
	             	MAX(WRITE_COMMANDS_PER_SEC) AS WRITE_COMMANDS_PER_SEC,
	             	MAX(XOR_WRITE_COMMANDS_PER_SEC) AS XOR_WRITE_COMMANDS_PER_SEC,
	             	MAX(XOR_READ_COMMANDS_PER_SEC) AS XOR_READ_COMMANDS_PER_SEC,
	             	MAX(AVERAGE_QUEUE) AS AVERAGE_QUEUE,
	             	MAX(DISK_IDLE_TIME_PER_SEC) AS DISK_IDLE_TIME_PER_SEC,
	             	MAX(ACCUMULATED_QUEUE_DEPTH) AS ACCUMULATED_QUEUE_DEPTH,
	             	MAX(DISK_BUSY) AS MAXBUSY,AVG(DISK_BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

			AVG(DISK_BUSY) AS AVGDISK_BUSY,
			SUM(DISK_BUSY) AS SUMDISK_BUSY,
			MAX(DISK_BUSY) AS MAXDISK_BUSY,
			MIN(DISK_BUSY) AS MINDISK_BUSY,
			AVG(TOTAL_SCSI_COMMAND_PER_SEC) AS AVGTOTAL_SCSI_COMMAND_PER_SEC,
			SUM(TOTAL_SCSI_COMMAND_PER_SEC) AS SUMTOTAL_SCSI_COMMAND_PER_SEC,
			MAX(TOTAL_SCSI_COMMAND_PER_SEC) AS MAXTOTAL_SCSI_COMMAND_PER_SEC,
			MIN(TOTAL_SCSI_COMMAND_PER_SEC) AS MINTOTAL_SCSI_COMMAND_PER_SEC
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DEVICE_NAME,DATAID
	              ) B 
         	WHERE B.DEVICE_NAME = A.DEVICE_NAME
               AND  B.DATAID = A.DATAID
               AND B.MAXBUSY = A.DISK_BUSY           
               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
             GROUP BY A.DATAID,
             		A.DEVICE_NAME,
             		B.TOTAL_SCSI_COMMAND_PER_SEC,
	         		B.READ_COMMANDS_PER_SEC,
	         		B.WRITE_COMMANDS_PER_SEC,
	         		B.XOR_WRITE_COMMANDS_PER_SEC,
	         		B.XOR_READ_COMMANDS_PER_SEC,
	         		B.AVERAGE_QUEUE,
	         		B.DISK_IDLE_TIME_PER_SEC,
	         		B.ACCUMULATED_QUEUE_DEPTH,
	         		A.DISK_BUSY,
	         		B.AVGBUSY,
	         		B.TOTALCOUNT,

				B.AVGDISK_BUSY,
				B.SUMDISK_BUSY,
				B.MAXDISK_BUSY,
				B.MINDISK_BUSY,
				B.AVGTOTAL_SCSI_COMMAND_PER_SEC,
				B.SUMTOTAL_SCSI_COMMAND_PER_SEC,
				B.MAXTOTAL_SCSI_COMMAND_PER_SEC,
				B.MINTOTAL_SCSI_COMMAND_PER_SEC;
		INSERT INTO CST.COLLECT_DISKS_LIST(DATAID,DEVICE_NAME) SELECT DATAID,DEVICE_NAME FROM '||$1||'  WHERE DEVICE_NAME NOT IN (SELECT DEVICE_NAME FROM CST.COLLECT_DISKS_LIST WHERE DATAID='''||V_DATAID||''')  GROUP BY DATAID,DEVICE_NAME;
		INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DISK'',DEVICE_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DEVICE_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''DISK'')  GROUP BY DATAID,DEVICE_NAME';
	    END LOOP;
	CLOSE COLLECT_DISKS_CURSOR;	
    -- ######################################################################
	-- # COLLECT_DISKS_LIST记录插入
	-- ######################################################################
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_DISKS_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从COLLECT_DISKS_TEMP检索
	-- # 			插入到COLLECT_DISKS_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_DISKS_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_DISKS_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_DISKS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_DISKS_HOUR插入
	-- ######################################################################     
	       EXECUTE ' INSERT INTO CST.COLLECT_DISKS_HOUR
	        (DATAID,
	         DATA_TIMES,
	         DEVICE_NAME,
	         TOTAL_SCSI_COMMAND_PER_SEC,
	         READ_COMMANDS_PER_SEC,
	         WRITE_COMMANDS_PER_SEC,
	         XOR_WRITE_COMMANDS_PER_SEC,
	         XOR_READ_COMMANDS_PER_SEC,
	         AVERAGE_QUEUE,
	         DISK_IDLE_TIME_PER_SEC,
	         ACCUMULATED_QUEUE_DEPTH,
	         MAXBUSY,
	         AVGBUSY,
	         MAX_DATA_TIMES,
	         TOTALCOUNT,

		 AVGDISK_BUSY,
		 SUMDISK_BUSY,
		 MAXDISK_BUSY,
		 MINDISK_BUSY,
		 AVGTOTAL_SCSI_COMMAND_PER_SEC,
		 SUMTOTAL_SCSI_COMMAND_PER_SEC,
		 MAXTOTAL_SCSI_COMMAND_PER_SEC,
		 MINTOTAL_SCSI_COMMAND_PER_SEC
		    )
	        SELECT A.DATAID,
		    		'''||V_LOOPTIME||''',
		    		A.DEVICE_NAME,
		    		B.TOTAL_SCSI_COMMAND_PER_SEC,
	         		B.READ_COMMANDS_PER_SEC,
	         		B.WRITE_COMMANDS_PER_SEC,
	         		B.XOR_WRITE_COMMANDS_PER_SEC,
	         		B.XOR_READ_COMMANDS_PER_SEC,
	         		B.AVERAGE_QUEUE,
	         		B.DISK_IDLE_TIME_PER_SEC,
	         		B.ACCUMULATED_QUEUE_DEPTH,
		    		A.DISK_BUSY,
		    		B.AVGBUSY,
		    		MAX(DATA_TIMES),
		    		B.TOTALCOUNT,

				B.AVGDISK_BUSY,
				B.SUMDISK_BUSY,
				B.MAXDISK_BUSY,
				B.MINDISK_BUSY,
				B.AVGTOTAL_SCSI_COMMAND_PER_SEC,
				B.SUMTOTAL_SCSI_COMMAND_PER_SEC,
				B.MAXTOTAL_SCSI_COMMAND_PER_SEC,
				B.MINTOTAL_SCSI_COMMAND_PER_SEC
            FROM '||$1||' A ,
	             (SELECT DEVICE_NAME,DATAID,
	             	MAX(TOTAL_SCSI_COMMAND_PER_SEC) AS TOTAL_SCSI_COMMAND_PER_SEC,
	             	MAX(READ_COMMANDS_PER_SEC) AS READ_COMMANDS_PER_SEC,
	             	MAX(WRITE_COMMANDS_PER_SEC) AS WRITE_COMMANDS_PER_SEC,
	             	MAX(XOR_WRITE_COMMANDS_PER_SEC) AS XOR_WRITE_COMMANDS_PER_SEC,
	             	MAX(XOR_READ_COMMANDS_PER_SEC) AS XOR_READ_COMMANDS_PER_SEC,
	             	MAX(AVERAGE_QUEUE) AS AVERAGE_QUEUE,
	             	MAX(DISK_IDLE_TIME_PER_SEC) AS DISK_IDLE_TIME_PER_SEC,
	             	MAX(ACCUMULATED_QUEUE_DEPTH) AS ACCUMULATED_QUEUE_DEPTH,
	             	MAX(DISK_BUSY) AS MAXBUSY,AVG(DISK_BUSY) AS AVGBUSY,COUNT(DATAID) AS TOTALCOUNT,

			AVG(DISK_BUSY) AS AVGDISK_BUSY,
			SUM(DISK_BUSY) AS SUMDISK_BUSY,
			MAX(DISK_BUSY) AS MAXDISK_BUSY,
			MIN(DISK_BUSY) AS MINDISK_BUSY,
			AVG(TOTAL_SCSI_COMMAND_PER_SEC) AS AVGTOTAL_SCSI_COMMAND_PER_SEC,
			SUM(TOTAL_SCSI_COMMAND_PER_SEC) AS SUMTOTAL_SCSI_COMMAND_PER_SEC,
			MAX(TOTAL_SCSI_COMMAND_PER_SEC) AS MAXTOTAL_SCSI_COMMAND_PER_SEC,
			MIN(TOTAL_SCSI_COMMAND_PER_SEC) AS MINTOTAL_SCSI_COMMAND_PER_SEC
	              FROM '||$1||'
	              WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
	              GROUP BY DEVICE_NAME,DATAID
	              ) B 
         	WHERE B.DEVICE_NAME = A.DEVICE_NAME
               AND  B.DATAID = A.DATAID
               AND B.MAXBUSY = A.DISK_BUSY            
               AND A.DATA_TIMES like  '''||V_LOOPTIME||'%'' AND A.DATAID='''||V_DATAID||'''   
             GROUP BY A.DATAID,
             		A.DEVICE_NAME,
             		B.TOTAL_SCSI_COMMAND_PER_SEC,
	         		B.READ_COMMANDS_PER_SEC,
	         		B.WRITE_COMMANDS_PER_SEC,
	         		B.XOR_WRITE_COMMANDS_PER_SEC,
	         		B.XOR_READ_COMMANDS_PER_SEC,
	         		B.AVERAGE_QUEUE,
	         		B.DISK_IDLE_TIME_PER_SEC,
	         		B.ACCUMULATED_QUEUE_DEPTH,
	         		A.DISK_BUSY,
	         		B.AVGBUSY,
	         		B.TOTALCOUNT,

				B.AVGDISK_BUSY,
				B.SUMDISK_BUSY,
				B.MAXDISK_BUSY,
				B.MINDISK_BUSY,
				B.AVGTOTAL_SCSI_COMMAND_PER_SEC,
				B.SUMTOTAL_SCSI_COMMAND_PER_SEC,
				B.MAXTOTAL_SCSI_COMMAND_PER_SEC,
				B.MINTOTAL_SCSI_COMMAND_PER_SEC';
	    END LOOP;
	CLOSE COLLECT_DISKS_CURSOR;	
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_PORTS_FE_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_PORTS_FE_TEMP检索
	-- # 			插入到COLLECT_PORTS_FE_DAY中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_PORTS_FE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_PORTS_FE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_PORTS_FE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_PORTS_FE_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_PORTS_FE_DAY
	        (DATAID,
	        DATA_TIMES,
	        PORT_NAME,
	        IOS_PER_SEC,
		THROUGHPUT_IN_KBYTES_PER_SEC,
		AVERAGE_REQUEST_SIZE_IN_KBYTES,

		AVGIOS_PER_SEC,
		SUMIOS_PER_SEC,
		MAXIOS_PER_SEC,
		MINIOS_PER_SEC,
		AVGTHROUGHPUT_IN_KBYTES_PER_SEC,
		SUMTHROUGHPUT_IN_KBYTES_PER_SEC,
		MAXTHROUGHPUT_IN_KBYTES_PER_SEC,
		MINTHROUGHPUT_IN_KBYTES_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		PORT_NAME,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(THROUGHPUT_IN_KBYTES_PER_SEC) AS THROUGHPUT_IN_KBYTES_PER_SEC,
         		MAX(AVERAGE_REQUEST_SIZE_IN_KBYTES) AS AVERAGE_REQUEST_SIZE_IN_KBYTES,

			AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
			SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
			MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
			MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
			AVG(THROUGHPUT_IN_KBYTES_PER_SEC) AS AVGTHROUGHPUT_IN_KBYTES_PER_SEC,
			SUM(THROUGHPUT_IN_KBYTES_PER_SEC) AS SUMTHROUGHPUT_IN_KBYTES_PER_SEC,
			MAX(THROUGHPUT_IN_KBYTES_PER_SEC) AS MAXTHROUGHPUT_IN_KBYTES_PER_SEC,
			MIN(THROUGHPUT_IN_KBYTES_PER_SEC) AS MINTHROUGHPUT_IN_KBYTES_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,PORT_NAME;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''PORTS_FE'',PORT_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND PORT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''PORTS_FE'') GROUP BY DATAID,PORT_NAME';    
	    END LOOP;
	CLOSE COLLECT_PORTS_FE_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_PORTS_FE_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_PORTS_FE_TEMP检索
	-- # 			插入到COLLECT_PORTS_FE_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_PORTS_FE_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN COLLECT_PORTS_FE_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH COLLECT_PORTS_FE_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_PORTS_FE_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_PORTS_FE_HOUR
	        (DATAID,
	        DATA_TIMES,
	        PORT_NAME,
	        IOS_PER_SEC,
		THROUGHPUT_IN_KBYTES_PER_SEC,
		AVERAGE_REQUEST_SIZE_IN_KBYTES,

		AVGIOS_PER_SEC,
		SUMIOS_PER_SEC,
		MAXIOS_PER_SEC,
		MINIOS_PER_SEC,
		AVGTHROUGHPUT_IN_KBYTES_PER_SEC,
		SUMTHROUGHPUT_IN_KBYTES_PER_SEC,
		MAXTHROUGHPUT_IN_KBYTES_PER_SEC,
		MINTHROUGHPUT_IN_KBYTES_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		PORT_NAME,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(THROUGHPUT_IN_KBYTES_PER_SEC) AS THROUGHPUT_IN_KBYTES_PER_SEC,
         		MAX(AVERAGE_REQUEST_SIZE_IN_KBYTES) AS AVERAGE_REQUEST_SIZE_IN_KBYTES,

			AVG(IOS_PER_SEC) AS AVGIOS_PER_SEC,
			SUM(IOS_PER_SEC) AS SUMIOS_PER_SEC,
			MAX(IOS_PER_SEC) AS MAXIOS_PER_SEC,
			MIN(IOS_PER_SEC) AS MINIOS_PER_SEC,
			AVG(THROUGHPUT_IN_KBYTES_PER_SEC) AS AVGTHROUGHPUT_IN_KBYTES_PER_SEC,
			SUM(THROUGHPUT_IN_KBYTES_PER_SEC) AS SUMTHROUGHPUT_IN_KBYTES_PER_SEC,
			MAX(THROUGHPUT_IN_KBYTES_PER_SEC) AS MAXTHROUGHPUT_IN_KBYTES_PER_SEC,
			MIN(THROUGHPUT_IN_KBYTES_PER_SEC) AS MINTHROUGHPUT_IN_KBYTES_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,PORT_NAME';
	        
	    END LOOP;
	CLOSE COLLECT_PORTS_FE_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDF_DIRECTOR_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_DIRECTOR_TEMP检索
	-- # 			插入到COLLECT_RDF_DIRECTOR_DAY中
	-- ######################################################################
	 
 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_RDF_DIRECTOR_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_DIRECTOR_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_DIRECTOR_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDF_DIRECTOR_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_DIRECTOR_DAY
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC,

		AVGKBYTES_READ_PER_SEC,
		SUMKBYTES_READ_PER_SEC,
		MAXKBYTES_READ_PER_SEC,
		MINKBYTES_READ_PER_SEC,
		AVGKBYTES_WRITTEN_PER_SEC,
		SUMKBYTES_WRITTEN_PER_SEC,
		MAXKBYTES_WRITTEN_PER_SEC,
		MINKBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,

			AVG(KBYTES_READ_PER_SEC) AS AVGKBYTES_READ_PER_SEC,
			SUM(KBYTES_READ_PER_SEC) AS SUMKBYTES_READ_PER_SEC,
			MAX(KBYTES_READ_PER_SEC) AS MAXKBYTES_READ_PER_SEC,
			MIN(KBYTES_READ_PER_SEC) AS MINKBYTES_READ_PER_SEC,
			AVG(KBYTES_WRITTEN_PER_SEC) AS AVGKBYTES_WRITTEN_PER_SEC,
			SUM(KBYTES_WRITTEN_PER_SEC) AS SUMKBYTES_WRITTEN_PER_SEC,
			MAX(KBYTES_WRITTEN_PER_SEC) AS MAXKBYTES_WRITTEN_PER_SEC,
			MIN(KBYTES_WRITTEN_PER_SEC) AS MINKBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''RDF_DIRECTOR'',DIRECTOR_NUMBER FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND DIRECTOR_NUMBER NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID='''||V_DATAID||''' AND OBJECT_TYPE = ''RDF_DIRECTOR'')  GROUP BY DATAID,DIRECTOR_NUMBER';    
	    END LOOP;
	CLOSE COLLECT_RDF_DIRECTOR_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDF_DIRECTOR_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_DIRECTOR_TEMP检索
	-- # 			插入到COLLECT_RDF_DIRECTOR_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_RDF_DIRECTOR_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_DIRECTOR_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_DIRECTOR_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDF_DIRECTOR_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_DIRECTOR_HOUR
	        (DATAID,
	        DATA_TIMES,
	        DIRECTOR_NUMBER,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC,

		AVGKBYTES_READ_PER_SEC,
		SUMKBYTES_READ_PER_SEC,
		MAXKBYTES_READ_PER_SEC,
		MINKBYTES_READ_PER_SEC,
		AVGKBYTES_WRITTEN_PER_SEC,
		SUMKBYTES_WRITTEN_PER_SEC,
		MAXKBYTES_WRITTEN_PER_SEC,
		MINKBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		DIRECTOR_NUMBER,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,

			AVG(KBYTES_READ_PER_SEC) AS AVGKBYTES_READ_PER_SEC,
			SUM(KBYTES_READ_PER_SEC) AS SUMKBYTES_READ_PER_SEC,
			MAX(KBYTES_READ_PER_SEC) AS MAXKBYTES_READ_PER_SEC,
			MIN(KBYTES_READ_PER_SEC) AS MINKBYTES_READ_PER_SEC,
			AVG(KBYTES_WRITTEN_PER_SEC) AS AVGKBYTES_WRITTEN_PER_SEC,
			SUM(KBYTES_WRITTEN_PER_SEC) AS SUMKBYTES_WRITTEN_PER_SEC,
			MAX(KBYTES_WRITTEN_PER_SEC) AS MAXKBYTES_WRITTEN_PER_SEC,
			MIN(KBYTES_WRITTEN_PER_SEC) AS MINKBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,DIRECTOR_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_RDF_DIRECTOR_CURSOR;
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDF_GROUP_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_GROUP_TEMP检索
	-- # 			插入到COLLECT_RDF_GROUP_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_RDF_GROUP_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_GROUP_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_GROUP_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_RDF_GROUP_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_GROUP_DAY
	        (DATAID,
	        DATA_TIMES,
	        RDF_GROUP,
			KBYTES_READ_PER_SEC,
			KBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		RDF_GROUP,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,RDF_GROUP';
	        
	    END LOOP;
	CLOSE COLLECT_RDF_GROUP_CURSOR;
	              
              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST. PRO_COLLECT_RDF_GROUP_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_GROUP_TEMP检索
	-- # 			插入到COLLECT_RDF_GROUP_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
  COLLECT_RDF_GROUP_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_GROUP_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_GROUP_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDF_GROUP_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_GROUP_HOUR
	        (DATAID,
	        DATA_TIMES,
	        RDF_GROUP,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		RDF_GROUP,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,RDF_GROUP';
	        
	    END LOOP;
	CLOSE COLLECT_RDF_GROUP_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDF_LINK_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_LINK_TEMP检索
	-- # 			插入到COLLECT_RDF_LINK_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_RDF_LINK_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_LINK_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_LINK_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDF_LINK_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_LINK_DAY
	        (DATAID,
	        DATA_TIMES,
	        LINK_NUMBER,
		ECHO_DELAY,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		LINK_NUMBER,
         		MAX(ECHO_DELAY) AS ECHO_DELAY,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,LINK_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_RDF_LINK_CURSOR;
	              
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDF_LINK_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDF_LINK_TEMP检索
	-- # 			插入到COLLECT_RDF_LINK_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_RDF_LINK_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDF_LINK_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDF_LINK_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDF_LINK_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDF_LINK_HOUR
	        (DATAID,
	        DATA_TIMES,
	        LINK_NUMBER,
		ECHO_DELAY,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		LINK_NUMBER,
         		MAX(ECHO_DELAY) AS ECHO_DELAY,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,LINK_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_RDF_LINK_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDFA_STATUS_DAY (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDFA_STATUS_TEMP检索
	-- # 			插入到COLLECT_RDFA_STATUS_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_RDFA_STATUS_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDFA_STATUS_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDFA_STATUS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;	
    -- ######################################################################
	-- # COLLECT_RDFA_STATUS_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDFA_STATUS_DAY
	        (DATAID,
	        DATA_TIMES,
	        RA_GROUP_NUMBER,
		AVG_CYCLE_TIME,
		DURATION_OF_LAST_CYCLE,
		R1_R2_IOS_PER_SEC,
		R1_R2_MBYTES_PER_SECOND,
		R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,
		TOTAL_CACHE_SLOTS_IN_USE,
		ACTIVE_CYCLE_SIZE,
		INACTIVE_CYCLE_SIZE
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		RA_GROUP_NUMBER,
         		MAX(AVG_CYCLE_TIME) AS AVG_CYCLE_TIME,
         		MAX(DURATION_OF_LAST_CYCLE) AS DURATION_OF_LAST_CYCLE,
         		MAX(R1_R2_IOS_PER_SEC) AS R1_R2_IOS_PER_SEC,
         		MAX(R1_R2_MBYTES_PER_SECOND) AS R1_R2_MBYTES_PER_SECOND,
         		MAX(R2_R1_IOS_PER_SEC) AS R2_R1_IOS_PER_SEC,
         		MAX(R2_R1_MBYTES_PER_SECOND) AS R2_R1_MBYTES_PER_SECOND,
         		MAX(TOTAL_CACHE_SLOTS_IN_USE) AS TOTAL_CACHE_SLOTS_IN_USE,
         		MAX(ACTIVE_CYCLE_SIZE) AS ACTIVE_CYCLE_SIZE,
         		MAX(INACTIVE_CYCLE_SIZE) AS INACTIVE_CYCLE_SIZE
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,RA_GROUP_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_RDFA_STATUS_CURSOR;
	              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_RDFA_STATUS_HOUR (varchar) RETURNS Void AS $$


	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_RDFA_STATUS_TEMP检索
	-- # 			插入到COLLECT_RDFA_STATUS_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
  COLLECT_RDFA_STATUS_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_RDFA_STATUS_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM  '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_RDFA_STATUS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RDFA_STATUS_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_RDFA_STATUS_HOUR
	        (DATAID,
	        DATA_TIMES,
	        RA_GROUP_NUMBER,
		AVG_CYCLE_TIME,
		DURATION_OF_LAST_CYCLE,
		R1_R2_IOS_PER_SEC,
		R1_R2_MBYTES_PER_SECOND,
		R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,
		TOTAL_CACHE_SLOTS_IN_USE,
		ACTIVE_CYCLE_SIZE,
		INACTIVE_CYCLE_SIZE
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		RA_GROUP_NUMBER,
         		MAX(AVG_CYCLE_TIME) AS AVG_CYCLE_TIME,
         		MAX(DURATION_OF_LAST_CYCLE) AS DURATION_OF_LAST_CYCLE,
         		MAX(R1_R2_IOS_PER_SEC) AS R1_R2_IOS_PER_SEC,
         		MAX(R1_R2_MBYTES_PER_SECOND) AS R1_R2_MBYTES_PER_SECOND,
         		MAX(R2_R1_IOS_PER_SEC) AS R2_R1_IOS_PER_SEC,
         		MAX(R2_R1_MBYTES_PER_SECOND) AS R2_R1_MBYTES_PER_SECOND,
         		MAX(TOTAL_CACHE_SLOTS_IN_USE) AS TOTAL_CACHE_SLOTS_IN_USE,
         		MAX(ACTIVE_CYCLE_SIZE) AS ACTIVE_CYCLE_SIZE,
         		MAX(INACTIVE_CYCLE_SIZE) AS INACTIVE_CYCLE_SIZE
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,RA_GROUP_NUMBER';
	        
	    END LOOP;
	CLOSE COLLECT_RDFA_STATUS_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_SYSTEM_DAY (varchar)RETURNS Void AS $$


	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_SYSTEM_TEMP检索
	-- # 			插入到COLLECT_SYSTEM_DAY中
	-- ######################################################################
	 

 DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_SYSTEM_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_SYSTEM_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_SYSTEM_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_SYSTEM_DAY插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_SYSTEM_DAY
	        (DATAID,
	        DATA_TIMES,
	        SYMID,
		IOS_PER_SEC,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC,
		NUMBER_WRITE_PENDING_TRACKS,
		TOTAL_IOS_PER_SEC,
		READS_,
		WRITES,
		HIT,
		KBYTES_TRANSFERRED_PER_SEC,
		READS_PER_SEC,
		WRITES_PER_SEC,
		HITS_PER_SEC,
		SEQ_READS_PER_SEC,

		AVGTOTAL_IOS_PER_SEC,
		SUMTOTAL_IOS_PER_SEC,
		MAXTOTAL_IOS_PER_SEC,
		MINTOTAL_IOS_PER_SEC,
		AVGKBYTES_WRITTEN_PER_SEC,
		SUMKBYTES_WRITTEN_PER_SEC,
		MAXKBYTES_WRITTEN_PER_SEC,
		MINKBYTES_WRITTEN_PER_SEC,
		AVGKBYTES_TRANSFERRED_PER_SEC,
		SUMKBYTES_TRANSFERRED_PER_SEC,
		MAXKBYTES_TRANSFERRED_PER_SEC,
		MINKBYTES_TRANSFERRED_PER_SEC,
		AVGREADS,
		SUMREADS,
		MAXREADS,
		MINREADS,
		AVGWRITES,
		SUMWRITES,
		MAXWRITES,
		MINWRITES,
		AVGHIT,
		SUMHIT,
		MAXHIT,
		MINHIT
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		SYMID,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(NUMBER_WRITE_PENDING_TRACKS) AS NUMBER_WRITE_PENDING_TRACKS,
         		MAX(TOTAL_IOS_PER_SEC) AS TOTAL_IOS_PER_SEC,
         		MAX(READS_) AS READS_,
         		MAX(WRITES) AS WRITES,
         		MAX(HIT) AS HIT,
         		MAX(KBYTES_TRANSFERRED_PER_SEC) AS KBYTES_TRANSFERRED_PER_SEC,
         		MAX(READS_PER_SEC) AS READS_PER_SEC,
         		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
         		MAX(HITS_PER_SEC) AS HITS_PER_SEC,
         		MAX(SEQ_READS_PER_SEC) AS SEQ_READS_PER_SEC,

			AVG(TOTAL_IOS_PER_SEC) AS AVGTOTAL_IOS_PER_SEC,
			SUM(TOTAL_IOS_PER_SEC) AS SUMTOTAL_IOS_PER_SEC,
			MAX(TOTAL_IOS_PER_SEC) AS MAXTOTAL_IOS_PER_SEC,
			MIN(TOTAL_IOS_PER_SEC) AS MINTOTAL_IOS_PER_SEC,
			AVG(KBYTES_WRITTEN_PER_SEC) AS AVGKBYTES_WRITTEN_PER_SEC,
			SUM(KBYTES_WRITTEN_PER_SEC) AS SUMKBYTES_WRITTEN_PER_SEC,
			MAX(KBYTES_WRITTEN_PER_SEC) AS MAXKBYTES_WRITTEN_PER_SEC,
			MIN(KBYTES_WRITTEN_PER_SEC) AS MINKBYTES_WRITTEN_PER_SEC,
			AVG(KBYTES_TRANSFERRED_PER_SEC) AS AVGKBYTES_TRANSFERRED_PER_SEC,
			SUM(KBYTES_TRANSFERRED_PER_SEC) AS SUMKBYTES_TRANSFERRED_PER_SEC,
			MAX(KBYTES_TRANSFERRED_PER_SEC) AS MAXKBYTES_TRANSFERRED_PER_SEC,
			MIN(KBYTES_TRANSFERRED_PER_SEC) AS MINKBYTES_TRANSFERRED_PER_SEC,
			AVG(READS_) AS AVGREADS,
			SUM(READS_) AS SUMREADS,
			MAX(READS_) AS MAXREADS,
			MIN(READS_) AS MINREADS,
			AVG(WRITES) AS AVGWRITES,
			SUM(WRITES) AS SUMWRITES,
			MAX(WRITES) AS MAXWRITES,
			MIN(WRITES) AS MINWRITES,
			AVG(HIT) AS AVGHIT,
			SUM(HIT) AS SUMHIT,
			MAX(HIT) AS MAXHIT,
			MIN(HIT) AS MINHIT
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,SYMID';
	        
	    END LOOP;
	CLOSE COLLECT_SYSTEM_CURSOR;
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_SYSTEM_HOUR (varchar) RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_SYSTEM_TEMP检索
	-- # 			插入到COLLECT_SYSTEM_HOUR中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
     COLLECT_SYSTEM_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * from COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	

       BEGIN 
      
	OPEN  COLLECT_SYSTEM_CURSOR for EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM '||$1;
	--循环游标
	LOOP	    
	        FETCH  COLLECT_SYSTEM_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_SYSTEM_HOUR插入
	-- ######################################################################     
	        EXECUTE ' INSERT INTO CST.COLLECT_SYSTEM_HOUR
	        (DATAID,
	        DATA_TIMES,
	        SYMID,
		IOS_PER_SEC,
		KBYTES_READ_PER_SEC,
		KBYTES_WRITTEN_PER_SEC,
		NUMBER_WRITE_PENDING_TRACKS,
		TOTAL_IOS_PER_SEC,
		READS_,
		WRITES,
		HIT,
		KBYTES_TRANSFERRED_PER_SEC,
		READS_PER_SEC,
		WRITES_PER_SEC,
		HITS_PER_SEC,
		SEQ_READS_PER_SEC,

		AVGTOTAL_IOS_PER_SEC,
		SUMTOTAL_IOS_PER_SEC,
		MAXTOTAL_IOS_PER_SEC,
		MINTOTAL_IOS_PER_SEC,
		AVGKBYTES_WRITTEN_PER_SEC,
		SUMKBYTES_WRITTEN_PER_SEC,
		MAXKBYTES_WRITTEN_PER_SEC,
		MINKBYTES_WRITTEN_PER_SEC,
		AVGKBYTES_TRANSFERRED_PER_SEC,
		SUMKBYTES_TRANSFERRED_PER_SEC,
		MAXKBYTES_TRANSFERRED_PER_SEC,
		MINKBYTES_TRANSFERRED_PER_SEC,
		AVGREADS,
		SUMREADS,
		MAXREADS,
		MINREADS,
		AVGWRITES,
		SUMWRITES,
		MAXWRITES,
		MINWRITES,
		AVGHIT,
		SUMHIT,
		MAXHIT,
		MINHIT
	        )
        	SELECT DATAID,
        		'''||V_LOOPTIME||''',
        		SYMID,
         		MAX(IOS_PER_SEC) AS IOS_PER_SEC,
         		MAX(KBYTES_READ_PER_SEC) AS KBYTES_READ_PER_SEC,
         		MAX(KBYTES_WRITTEN_PER_SEC) AS KBYTES_WRITTEN_PER_SEC,
         		MAX(NUMBER_WRITE_PENDING_TRACKS) AS NUMBER_WRITE_PENDING_TRACKS,
         		MAX(TOTAL_IOS_PER_SEC) AS TOTAL_IOS_PER_SEC,
         		MAX(READS_) AS READS_,
         		MAX(WRITES) AS WRITES,
         		MAX(HIT) AS HIT,
         		MAX(KBYTES_TRANSFERRED_PER_SEC) AS KBYTES_TRANSFERRED_PER_SEC,
         		MAX(READS_PER_SEC) AS READS_PER_SEC,
         		MAX(WRITES_PER_SEC) AS WRITES_PER_SEC,
         		MAX(HITS_PER_SEC) AS HITS_PER_SEC,
         		MAX(SEQ_READS_PER_SEC) AS SEQ_READS_PER_SEC,

			AVG(TOTAL_IOS_PER_SEC) AS AVGTOTAL_IOS_PER_SEC,
			SUM(TOTAL_IOS_PER_SEC) AS SUMTOTAL_IOS_PER_SEC,
			MAX(TOTAL_IOS_PER_SEC) AS MAXTOTAL_IOS_PER_SEC,
			MIN(TOTAL_IOS_PER_SEC) AS MINTOTAL_IOS_PER_SEC,
			AVG(KBYTES_WRITTEN_PER_SEC) AS AVGKBYTES_WRITTEN_PER_SEC,
			SUM(KBYTES_WRITTEN_PER_SEC) AS SUMKBYTES_WRITTEN_PER_SEC,
			MAX(KBYTES_WRITTEN_PER_SEC) AS MAXKBYTES_WRITTEN_PER_SEC,
			MIN(KBYTES_WRITTEN_PER_SEC) AS MINKBYTES_WRITTEN_PER_SEC,
			AVG(KBYTES_TRANSFERRED_PER_SEC) AS AVGKBYTES_TRANSFERRED_PER_SEC,
			SUM(KBYTES_TRANSFERRED_PER_SEC) AS SUMKBYTES_TRANSFERRED_PER_SEC,
			MAX(KBYTES_TRANSFERRED_PER_SEC) AS MAXKBYTES_TRANSFERRED_PER_SEC,
			MIN(KBYTES_TRANSFERRED_PER_SEC) AS MINKBYTES_TRANSFERRED_PER_SEC,
			AVG(READS_) AS AVGREADS,
			SUM(READS_) AS SUMREADS,
			MAX(READS_) AS MAXREADS,
			MIN(READS_) AS MINREADS,
			AVG(WRITES) AS AVGWRITES,
			SUM(WRITES) AS SUMWRITES,
			MAX(WRITES) AS MAXWRITES,
			MIN(WRITES) AS MINWRITES,
			AVG(HIT) AS AVGHIT,
			SUM(HIT) AS SUMHIT,
			MAX(HIT) AS MAXHIT,
			MIN(HIT) AS MINHIT
          	FROM '||$1||'
          	WHERE DATA_TIMES like  '''||V_LOOPTIME||'%'' AND DATAID='''||V_DATAID||'''                  
          	GROUP BY DATAID,SYMID';
	        
	    END LOOP;
	CLOSE COLLECT_SYSTEM_CURSOR;
	              
	 RETURN ;
END;
$$
LANGUAGE plpgsql;