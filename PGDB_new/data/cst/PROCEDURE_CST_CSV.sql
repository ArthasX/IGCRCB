

CREATE OR REPLACE FUNCTION CST.pro_cx_collect_disk_day(character varying)
  RETURNS void AS
$BODY$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_Disk_CURSOR refcursor;              
    -- ######################################################################
	-- # 检索CX_COLLECT_Disk_TEMP中DATAID,统计时间
	-- ######################################################################
          BEGIN 
	  
	OPEN CX_COLLECT_Disk_CURSOR for 
	  EXECUTE 'SELECT DISTINCT DATAID,DAY_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	LOOP	    
	        FETCH CX_COLLECT_Disk_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	         if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_Disk_DAY插入
	-- ######################################################################     
	      EXECUTE '   INSERT INTO CST.CX_COLLECT_Disk_DAY
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			
			MaxBUSY,
			AVGBusy,
    			MAX_DATA_TIMES,
			TOTALCOUNT,
			AVGTOTAL_THROUGHPUT,
			SUMTOTAL_THROUGHPUT,
			MAXTOTAL_THROUGHPUT,
			MINTOTAL_THROUGHPUT,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
	        SELECT A.DATAID,
	        		A.OBJECT_NAME,
		    		'''||V_LOOPTIME||''',
		    		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
		    		
		    		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		MAX(A.Poll_Time),
		    		B.TOTALCOUNT,
				B.AVGTOTAL_THROUGHPUT,
				B.SUMTOTAL_THROUGHPUT,
				B.MAXTOTAL_THROUGHPUT,
				B.MINTOTAL_THROUGHPUT,
				B.AVGRESPONSE_TIME,
				B.SUMRESPONSE_TIME,
				B.MAXRESPONSE_TIME,
				B.MINRESPONSE_TIME,
				B.AVGUTILIZATION,
				B.SUMUTILIZATION,
				B.MAXUTILIZATION,
				B.MINUTILIZATION
            FROM '||$1||' A ,
	             (SELECT DATAID,
					OBJECT_NAME,
					Owner_Array_Name,
					Current_Owner,
					MAX(Utilization) AS Utilization,
					MAX(Queue_Length) AS Queue_Length,
					MAX(Response_Time) AS Response_Time,
					MAX(Total_Bandwidth) AS Total_Bandwidth,
					MAX(Total_Throughput) AS Total_Throughput,
					MAX(Read_Bandwidth) AS Read_Bandwidth,
					MAX(Read_Size) AS Read_Size,
					MAX(Read_Throughput) AS Read_Throughput,
					MAX(Write_Bandwidth) AS Write_Bandwidth,
					MAX(Write_Size) AS Write_Size,
					MAX(Write_Throughput) AS Write_Throughput,
					MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
					MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
					MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
					MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
					MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
					MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
					MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
					MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
					MAX(Service_Time) AS Service_Time,
					MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
					MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
					MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
					MAX(Read_512B) AS Read_512B,
					MAX(Read_1KB) AS Read_1KB,
					MAX(Read_2KB) AS Read_2KB,
					MAX(Read_4KB) AS Read_4KB,
					MAX(Read_8KB) AS Read_8KB,
					MAX(Read_16KB) AS Read_16KB,
					MAX(Read_32KB) AS Read_32KB,
					MAX(Read_64KB) AS Read_64KB,
					MAX(Read_128KB) AS Read_128KB,
					MAX(Read_256KB) AS Read_256KB,
					MAX(Read_512KB) AS Read_512KB,
	
					MAX(Write_512B) AS Write_512B,
					MAX(Write_1KB) AS Write_1KB,
					MAX(Write_2KB) AS Write_2KB,
					MAX(Write_4KB) AS Write_4KB,
					MAX(Write_8KB) AS Write_8KB,
					MAX(Write_16KB) AS Write_16KB,
					MAX(Write_32KB) AS Write_32KB,
					MAX(Write_64KB) AS Write_64KB,
					MAX(Write_128KB) AS Write_128KB,
					MAX(Write_256KB) AS Write_256KB,
					MAX(Write_512KB) AS Write_512KB,
					MAX(Total_512B) AS Total_512B,
					MAX(Total_1KB) AS Total_1KB,
					MAX(Total_2KB) AS Total_2KB,
					MAX(Total_4KB) AS Total_4KB,
					MAX(Total_8KB) AS Total_8KB,
					MAX(Total_16KB) AS Total_16KB,
					MAX(Total_32KB) AS Total_32KB,
					MAX(Total_64KB) AS Total_64KB,
					MAX(Total_128KB) AS Total_128KB,
					MAX(Total_256KB) AS Total_256KB,
					MAX(Total_512KB) AS Total_512KB,
					
					MAX(Utilization) AS MaxBUSY,
					AVG(Utilization) AS AVGBusy,
					COUNT(DATAID) AS TOTALCOUNT,
					AVG(TOTAL_THROUGHPUT) AS AVGTOTAL_THROUGHPUT,
					SUM(TOTAL_THROUGHPUT) AS SUMTOTAL_THROUGHPUT,
					MAX(TOTAL_THROUGHPUT) AS MAXTOTAL_THROUGHPUT,
					MIN(TOTAL_THROUGHPUT) AS MINTOTAL_THROUGHPUT,
					AVG(RESPONSE_TIME) AS AVGRESPONSE_TIME,
					SUM(RESPONSE_TIME) AS SUMRESPONSE_TIME,
					MAX(RESPONSE_TIME) AS MAXRESPONSE_TIME,
					MIN(RESPONSE_TIME) AS MINRESPONSE_TIME,
					AVG(UTILIZATION) AS AVGUTILIZATION,
					SUM(UTILIZATION) AS SUMUTILIZATION,
					MAX(UTILIZATION) AS MAXUTILIZATION,
					MIN(UTILIZATION) AS MINUTILIZATION
	               FROM '||$1||'
	              WHERE DAY_TIME  = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
	              GROUP BY OBJECT_NAME,DATAID,OWNER_ARRAY_NAME,CURRENT_OWNER
	              ) B 
         	WHERE A.OBJECT_NAME = B.OBJECT_NAME
               AND  A.DATAID = B.DATAID
               AND A.Utilization = B.MaxBUSY           
               AND A.DAY_TIME = '''||V_LOOPTIME||''' AND A.DATAID = '''||V_DATAID||'''   
             GROUP BY A.DATAID,
             		A.OBJECT_NAME,
             		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
             		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		B.TOTALCOUNT,
				B.AVGTOTAL_THROUGHPUT,
				B.SUMTOTAL_THROUGHPUT,
				B.MAXTOTAL_THROUGHPUT,
				B.MINTOTAL_THROUGHPUT,
				B.AVGRESPONSE_TIME,
				B.SUMRESPONSE_TIME,
				B.MAXRESPONSE_TIME,
				B.MINRESPONSE_TIME,
				B.AVGUTILIZATION,
				B.SUMUTILIZATION,
				B.MAXUTILIZATION,
				B.MINUTILIZATION;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''DISK'',OBJECT_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND OBJECT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = '''||V_DATAID||''' AND OBJECT_TYPE = ''DISK'')  GROUP BY DATAID,OBJECT_NAME;
	    -- ######################################################################
	-- # CX_COLLECT_Enclosure_DISKS记录插入
	-- ######################################################################
	    INSERT INTO CST.CX_COLLECT_Enclosure_DISKS SELECT DATAID,Object_NAME
	    FROM CST.CX_COLLECT_Disk_TEMP WHERE DATAID='''||V_DATAID||''' AND OBJECT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.CX_COLLECT_Enclosure_DISKS WHERE DATAID = '''||V_DATAID||''') GROUP BY DATAID,Object_NAME';

	    END LOOP;
	CLOSE CX_COLLECT_Disk_CURSOR;	
 RETURN ;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION CST.pro_cx_collect_disk_day(character varying)
  OWNER TO postgres;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_DISK_HOUR (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从CX_COLLECT_Disk_TEMP检索
	-- # 			插入到CX_COLLECT_Disk_HOUR中
	-- ######################################################################
	 

    DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;     
        CX_COLLECT_Disk_CURSOR refcursor; 
                         
    -- ######################################################################
	-- # 检索CX_COLLECT_Disk_TEMP中DATAID,统计时间
	-- ######################################################################
   BEGIN 
             OPEN CX_COLLECT_Disk_CURSOR for
	   EXECUTE 'SELECT DISTINCT DATAID,HOUR_TIME AS LOOPTIME  From '||$1 ||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
        
	
	--循环游标

		LOOP	    
	        FETCH CX_COLLECT_Disk_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	        if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_Disk_HOUR插入
	-- ######################################################################     
	       EXECUTE 'INSERT INTO CST.CX_COLLECT_Disk_HOUR
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			AVGTOTAL_THROUGHPUT,
			SUMTOTAL_THROUGHPUT,
			MAXTOTAL_THROUGHPUT,
			MINTOTAL_THROUGHPUT,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB,

			AVG(TOTAL_THROUGHPUT) AS AVGTOTAL_THROUGHPUT,
			SUM(TOTAL_THROUGHPUT) AS SUMTOTAL_THROUGHPUT,
			MAX(TOTAL_THROUGHPUT) AS MAXTOTAL_THROUGHPUT,
			MIN(TOTAL_THROUGHPUT) AS MINTOTAL_THROUGHPUT,
			AVG(RESPONSE_TIME) AS AVGRESPONSE_TIME,
			SUM(RESPONSE_TIME) AS SUMRESPONSE_TIME,
			MAX(RESPONSE_TIME) AS MAXRESPONSE_TIME,
			MIN(RESPONSE_TIME) AS MINRESPONSE_TIME,
			AVG(UTILIZATION) AS AVGUTILIZATION,
			SUM(UTILIZATION) AS SUMUTILIZATION,
			MAX(UTILIZATION) AS MAXUTILIZATION,
			MIN(UTILIZATION) AS MINUTILIZATION
          	FROM  '||$1||'
          	WHERE Hour_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	    END LOOP;
	CLOSE CX_COLLECT_Disk_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_LUN_DAY (varchar)RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从CX_COLLECT_LUN_TEMP检索
	-- # 			插入到CX_COLLECT_LUN_DAY中
	-- ######################################################################
	 
DECLARE 
	V_DATAID  VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_LUN_CURSOR refcursor;     
                         
    -- ######################################################################
	-- # 检索CX_COLLECT_LUN_TEMP中DATAID,统计时间
	-- ######################################################################
	  BEGIN 
   	OPEN CX_COLLECT_LUN_CURSOR for
	   EXECUTE 'SELECT DISTINCT DATAID,DAY_TIME AS LOOPTIME From '||$1 ||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	
	--循环游标
	
		LOOP	    
	        FETCH CX_COLLECT_LUN_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	         if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_LUN_DAY插入
	-- ######################################################################     
	     EXECUTE '    INSERT INTO CST.CX_COLLECT_LUN_DAY
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGQUEUE_LENGTH,
			SUMQUEUE_LENGTH,
			MAXQUEUE_LENGTH,
			MINQUEUE_LENGTH,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB,
			AVG(RESPONSE_TIME),
			SUM(RESPONSE_TIME),
			MAX(RESPONSE_TIME),
			MIN(RESPONSE_TIME),
			AVG(QUEUE_LENGTH),
			SUM(QUEUE_LENGTH),
			MAX(QUEUE_LENGTH),
			MIN(QUEUE_LENGTH),
			AVG(UTILIZATION),
			SUM(UTILIZATION),
			MAX(UTILIZATION),
			MIN(UTILIZATION)
			
          	FROM  '||$1||'
          	WHERE Day_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''LUN'',OBJECT_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND OBJECT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = '''||V_DATAID||''' AND OBJECT_TYPE = ''LUN'')  GROUP BY DATAID,OBJECT_NAME';    
	    END LOOP;
	CLOSE CX_COLLECT_LUN_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_LUN_HOUR (varchar)RETURNS Void AS $$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME  VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_LUN_CURSOR refcursor;     
         BEGIN
    -- ######################################################################
	-- # 检索CX_COLLECT_LUN_TEMP中DATAID,统计时间
	-- ######################################################################
   OPEN CX_COLLECT_LUN_CURSOR for	
	EXECUTE 'SELECT DISTINCT DATAID,HOUR_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';

		LOOP	    
	        FETCH CX_COLLECT_LUN_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	          if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_LUN_HOUR插入
	-- ######################################################################     
	     EXECUTE '    INSERT INTO CST.CX_COLLECT_LUN_HOUR
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGQUEUE_LENGTH,
			SUMQUEUE_LENGTH,
			MAXQUEUE_LENGTH,
			MINQUEUE_LENGTH,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB,
			AVG(RESPONSE_TIME),
			SUM(RESPONSE_TIME),
			MAX(RESPONSE_TIME),
			MIN(RESPONSE_TIME),
			AVG(QUEUE_LENGTH),
			SUM(QUEUE_LENGTH),
			MAX(QUEUE_LENGTH),
			MIN(QUEUE_LENGTH),
			AVG(UTILIZATION),
			SUM(UTILIZATION),
			MAX(UTILIZATION),
			MIN(UTILIZATION)
			
          	From '||$1||'
          	WHERE Hour_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	    END LOOP;
	CLOSE CX_COLLECT_LUN_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################


CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_PORT_DAY (varchar)RETURNS Void AS $$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_PORT_CURSOR refcursor;              
	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从CX_COLLECT_Port_TEMP检索
	-- # 			插入到CX_COLLECT_Port_DAY中
	-- ######################################################################

                         
    -- ######################################################################
	-- # 检索CX_COLLECT_Port_TEMP中DATAID,统计时间
	-- ######################################################################
     BEGIN 
	  
        
	OPEN CX_COLLECT_PORT_CURSOR for
	 EXECUTE 'SELECT DISTINCT DATAID,SUBSTR(poll_time,1,10) AS LOOPTIME FROM '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
        
	
		LOOP	    
	        FETCH CX_COLLECT_Port_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	        if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_Port_DAY插入
	-- ######################################################################     
	      EXECUTE '  INSERT INTO CST.CX_COLLECT_Port_DAY
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			
			MaxBUSY,
			AVGBusy,
    		MAX_DATA_TIMES,
			TOTALCOUNT
	        )
	        SELECT A.DATAID,
	        		A.OBJECT_NAME,
		    		'''||V_LOOPTIME||''',
		    		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
		    		
		    		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		MAX(A.Poll_Time),
		    		B.TOTALCOUNT
            FROM '||$1||' A ,
	             (SELECT DATAID,
					OBJECT_NAME,
					Owner_Array_Name,
					Current_Owner,
					MAX(Utilization) AS Utilization,
					MAX(Queue_Length) AS Queue_Length,
					MAX(Response_Time) AS Response_Time,
					MAX(Total_Bandwidth) AS Total_Bandwidth,
					MAX(Total_Throughput) AS Total_Throughput,
					MAX(Read_Bandwidth) AS Read_Bandwidth,
					MAX(Read_Size) AS Read_Size,
					MAX(Read_Throughput) AS Read_Throughput,
					MAX(Write_Bandwidth) AS Write_Bandwidth,
					MAX(Write_Size) AS Write_Size,
					MAX(Write_Throughput) AS Write_Throughput,
					MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
					MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
					MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
					MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
					MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
					MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
					MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
					MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
					MAX(Service_Time) AS Service_Time,
					MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
					MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
					MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
					MAX(Read_512B) AS Read_512B,
					MAX(Read_1KB) AS Read_1KB,
					MAX(Read_2KB) AS Read_2KB,
					MAX(Read_4KB) AS Read_4KB,
					MAX(Read_8KB) AS Read_8KB,
					MAX(Read_16KB) AS Read_16KB,
					MAX(Read_32KB) AS Read_32KB,
					MAX(Read_64KB) AS Read_64KB,
					MAX(Read_128KB) AS Read_128KB,
					MAX(Read_256KB) AS Read_256KB,
					MAX(Read_512KB) AS Read_512KB,
	
					MAX(Write_512B) AS Write_512B,
					MAX(Write_1KB) AS Write_1KB,
					MAX(Write_2KB) AS Write_2KB,
					MAX(Write_4KB) AS Write_4KB,
					MAX(Write_8KB) AS Write_8KB,
					MAX(Write_16KB) AS Write_16KB,
					MAX(Write_32KB) AS Write_32KB,
					MAX(Write_64KB) AS Write_64KB,
					MAX(Write_128KB) AS Write_128KB,
					MAX(Write_256KB) AS Write_256KB,
					MAX(Write_512KB) AS Write_512KB,
					MAX(Total_512B) AS Total_512B,
					MAX(Total_1KB) AS Total_1KB,
					MAX(Total_2KB) AS Total_2KB,
					MAX(Total_4KB) AS Total_4KB,
					MAX(Total_8KB) AS Total_8KB,
					MAX(Total_16KB) AS Total_16KB,
					MAX(Total_32KB) AS Total_32KB,
					MAX(Total_64KB) AS Total_64KB,
					MAX(Total_128KB) AS Total_128KB,
					MAX(Total_256KB) AS Total_256KB,
					MAX(Total_512KB) AS Total_512KB,
					
					MAX(Total_Throughput) AS MaxBUSY,
					AVG(Total_Throughput) AS AVGBusy,
					COUNT(DATAID) AS TOTALCOUNT
	              FROM '||$1||'
	              WHERE DAY_TIME = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
	              GROUP BY OBJECT_NAME,DATAID,OWNER_ARRAY_NAME,CURRENT_OWNER
	              ) B 
         	WHERE A.OBJECT_NAME = B.OBJECT_NAME
               AND  A.DATAID = B.DATAID
               AND A.Total_Throughput = B.MaxBUSY           
               AND A.DAY_TIME = '''||V_LOOPTIME||''' AND A.DATAID = '''||V_DATAID||'''   
             GROUP BY A.DATAID,
             		A.OBJECT_NAME,
             		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
             		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		B.TOTALCOUNT;
	-- ######################################################################
	-- # CX_COLLECT_Port_Num记录插入
	-- ######################################################################	       		    
	  INSERT INTO CST.CX_COLLECT_Port_Num SELECT DATAID,Object_NAME
          FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND OBJECT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.CX_COLLECT_Port_Num WHERE DATAID = '''||V_DATAID||''') GROUP BY DATAID,Object_NAME';
	    END LOOP;
	CLOSE CX_COLLECT_Port_CURSOR;	
 RETURN ;
END;
$$
LANGUAGE plpgsql;

-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_PORT_HOUR (varchar)RETURNS Void AS $$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_PORT_CURSOR refcursor;              
	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从CX_COLLECT_Port_TEMP检索
	-- # 			插入到CX_COLLECT_Port_DAY中
	-- ######################################################################

                         
    -- ######################################################################
	-- # 检索CX_COLLECT_Port_TEMP中DATAID,统计时间
	-- ######################################################################
     BEGIN 
	  
        
	OPEN CX_COLLECT_PORT_CURSOR for
	   EXECUTE 'SELECT DISTINCT DATAID,HOUR_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	
		LOOP	    
	        FETCH CX_COLLECT_Port_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	        if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_Port_DAY插入
	-- ######################################################################     
	      
	-- ######################################################################
	-- # CX_COLLECT_Port_Num记录插入
	-- ######################################################################	       		    
	 EXECUTE '  INSERT INTO CST.CX_COLLECT_Port_HOUR
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB 
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB
			
          	FROM '||$1||'
          	WHERE Hour_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	    END LOOP;
	CLOSE CX_COLLECT_Port_CURSOR;	
 RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_RAID_GROUP_DAY(varchar)RETURNS Void AS $$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
       V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
        CX_COLLECT_Raid_Group_CURSOR refcursor;              
    -- ######################################################################
	-- # 检索CX_COLLECT_Raid_Group_TEMP中DATAID,统计时间
	-- ######################################################################
   	BEGIN
   	
   OPEN	 CX_COLLECT_Raid_Group_CURSOR for
EXECUTE 'SELECT DISTINCT DATAID,DAY_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	
		LOOP	    
	        FETCH CX_COLLECT_Raid_Group_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	         if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_RAID_GROUP_HOUR插入
	-- ######################################################################     
	      EXECUTE '   INSERT INTO CST.CX_COLLECT_RAID_GROUP_DAY
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB 
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB
			
          	FROM '||$1||'
          	WHERE Day_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	    END LOOP;
	CLOSE CX_COLLECT_Raid_Group_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
--######################################################################
--######################################################################
CREATE OR REPLACE FUNCTION CST.pro_CX_COLLECT_RAID_GROUP_HOUR(varchar)RETURNS Void AS $$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
        CX_COLLECT_Raid_Group_CURSOR refcursor;              
    -- ######################################################################
	-- # 检索CX_COLLECT_Raid_Group_TEMP中DATAID,统计时间
	-- ######################################################################
   	BEGIN
   	
   OPEN	 CX_COLLECT_Raid_Group_CURSOR for
   	
	   EXECUTE 'SELECT DISTINCT DATAID,HOUR_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	
		LOOP	    
	        FETCH CX_COLLECT_Raid_Group_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	         if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_RAID_GROUP_HOUR插入
	-- ######################################################################     
	     EXECUTE '    INSERT INTO CST.CX_COLLECT_Raid_Group_HOUR
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB 
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB
			
          	FROM '||$1||'
          	WHERE Hour_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	    END LOOP;
	CLOSE CX_COLLECT_Raid_Group_CURSOR;
	              
RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

-- Function: CST.pro_cx_collect_sp_day(character varying)

-- DROP FUNCTION CST.pro_cx_collect_sp_day(character varying);

CREATE OR REPLACE FUNCTION CST.pro_cx_collect_sp_day(character varying)
  RETURNS void AS
$BODY$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
       V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_SP_CURSOR refcursor;              
    -- ######################################################################
	-- # 检索CX_COLLECT_SP_TEMP中DATAID,统计时间
	-- ######################################################################
          BEGIN 
	  
        
	OPEN CX_COLLECT_SP_CURSOR for
	 EXECUTE 'SELECT DISTINCT DATAID,DAY_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	--循环游标
	
		LOOP	    
	        FETCH CX_COLLECT_SP_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	         if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_SP_DAY插入
	-- ######################################################################     
	    EXECUTE '   INSERT INTO CST.CX_COLLECT_SP_DAY
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			
			MaxBUSY,
			AVGBusy,
    		MAX_DATA_TIMES,
			TOTALCOUNT,
			AVGTOTAL_THROUGHPUT,
			SUMTOTAL_THROUGHPUT,
			MAXTOTAL_THROUGHPUT,
			MINTOTAL_THROUGHPUT,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGQUEUE_LENGTH,
			SUMQUEUE_LENGTH,
			MAXQUEUE_LENGTH,
			MINQUEUE_LENGTH,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
	        SELECT A.DATAID,
	        		A.OBJECT_NAME,
		    		'''||V_LOOPTIME||''',
		    		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
		    		
		    		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		MAX(A.Poll_Time),
		    		B.TOTALCOUNT,
				B.AVGTOTAL_THROUGHPUT,
				B.SUMTOTAL_THROUGHPUT,
				B.MAXTOTAL_THROUGHPUT,
				B.MINTOTAL_THROUGHPUT,
				B.AVGRESPONSE_TIME,
				B.SUMRESPONSE_TIME,
				B.MAXRESPONSE_TIME,
				B.MINRESPONSE_TIME,
				B.AVGQUEUE_LENGTH,
				B.SUMQUEUE_LENGTH,
				B.MAXQUEUE_LENGTH,
				B.MINQUEUE_LENGTH,
				B.AVGUTILIZATION,
				B.SUMUTILIZATION,
				B.MAXUTILIZATION,
				B.MINUTILIZATION
            FROM '||$1||' A ,
	             (SELECT DATAID,
					OBJECT_NAME,
					Owner_Array_Name,
					Current_Owner,
					MAX(Utilization) AS Utilization,
					MAX(Queue_Length) AS Queue_Length,
					MAX(Response_Time) AS Response_Time,
					MAX(Total_Bandwidth) AS Total_Bandwidth,
					MAX(Total_Throughput) AS Total_Throughput,
					MAX(Read_Bandwidth) AS Read_Bandwidth,
					MAX(Read_Size) AS Read_Size,
					MAX(Read_Throughput) AS Read_Throughput,
					MAX(Write_Bandwidth) AS Write_Bandwidth,
					MAX(Write_Size) AS Write_Size,
					MAX(Write_Throughput) AS Write_Throughput,
					MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
					MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
					MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
					MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
					MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
					MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
					MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
					MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
					MAX(Service_Time) AS Service_Time,
					MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
					MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
					MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
					MAX(Read_512B) AS Read_512B,
					MAX(Read_1KB) AS Read_1KB,
					MAX(Read_2KB) AS Read_2KB,
					MAX(Read_4KB) AS Read_4KB,
					MAX(Read_8KB) AS Read_8KB,
					MAX(Read_16KB) AS Read_16KB,
					MAX(Read_32KB) AS Read_32KB,
					MAX(Read_64KB) AS Read_64KB,
					MAX(Read_128KB) AS Read_128KB,
					MAX(Read_256KB) AS Read_256KB,
					MAX(Read_512KB) AS Read_512KB,
	
					MAX(Write_512B) AS Write_512B,
					MAX(Write_1KB) AS Write_1KB,
					MAX(Write_2KB) AS Write_2KB,
					MAX(Write_4KB) AS Write_4KB,
					MAX(Write_8KB) AS Write_8KB,
					MAX(Write_16KB) AS Write_16KB,
					MAX(Write_32KB) AS Write_32KB,
					MAX(Write_64KB) AS Write_64KB,
					MAX(Write_128KB) AS Write_128KB,
					MAX(Write_256KB) AS Write_256KB,
					MAX(Write_512KB) AS Write_512KB,
					MAX(Total_512B) AS Total_512B,
					MAX(Total_1KB) AS Total_1KB,
					MAX(Total_2KB) AS Total_2KB,
					MAX(Total_4KB) AS Total_4KB,
					MAX(Total_8KB) AS Total_8KB,
					MAX(Total_16KB) AS Total_16KB,
					MAX(Total_32KB) AS Total_32KB,
					MAX(Total_64KB) AS Total_64KB,
					MAX(Total_128KB) AS Total_128KB,
					MAX(Total_256KB) AS Total_256KB,
					MAX(Total_512KB) AS Total_512KB,
					
					MAX(Utilization) AS MaxBUSY,
					AVG(Utilization) AS AVGBusy,
					COUNT(DATAID) AS TOTALCOUNT,
					AVG(TOTAL_THROUGHPUT) AS AVGTOTAL_THROUGHPUT,
					SUM(TOTAL_THROUGHPUT) AS SUMTOTAL_THROUGHPUT,
					MAX(TOTAL_THROUGHPUT) AS MAXTOTAL_THROUGHPUT,
					MIN(TOTAL_THROUGHPUT) AS MINTOTAL_THROUGHPUT,
					AVG(RESPONSE_TIME) AS AVGRESPONSE_TIME,
					SUM(RESPONSE_TIME) AS SUMRESPONSE_TIME,
					MAX(RESPONSE_TIME) AS MAXRESPONSE_TIME,
					MIN(RESPONSE_TIME) AS MINRESPONSE_TIME,
					AVG(QUEUE_LENGTH) AS AVGQUEUE_LENGTH,
					SUM(QUEUE_LENGTH) AS SUMQUEUE_LENGTH,
					MAX(QUEUE_LENGTH) AS MAXQUEUE_LENGTH,
					MIN(QUEUE_LENGTH) AS MINQUEUE_LENGTH,
					AVG(UTILIZATION) AS AVGUTILIZATION,
					SUM(UTILIZATION) AS SUMUTILIZATION,
					MAX(UTILIZATION) AS MAXUTILIZATION,
					MIN(UTILIZATION) AS MINUTILIZATION
	              FROM '||$1||'
	              WHERE DAY_TIME = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
	              GROUP BY OBJECT_NAME,DATAID,OWNER_ARRAY_NAME,CURRENT_OWNER
	              ) B 
         	WHERE A.OBJECT_NAME = B.OBJECT_NAME
               AND  A.DATAID = B.DATAID
               AND A.Utilization = B.MaxBUSY           
               AND A.DAY_TIME = '''||V_LOOPTIME||''' AND A.DATAID = '''||V_DATAID||'''   
             GROUP BY A.DATAID,
             		A.OBJECT_NAME,
             		A.OWNER_ARRAY_NAME,
		    		A.CURRENT_OWNER,
             		B.Utilization,
					B.Queue_Length,
					B.Response_Time,
					B.Total_Bandwidth,
					B.Total_Throughput,
					B.Read_Bandwidth,
					B.Read_Size,
					B.Read_Throughput,
					B.Write_Bandwidth,
					B.Write_Size,
					B.Write_Throughput,
					B.SP_Cache_Read_Hits,
					B.SP_Cache_Read_Misses,
					B.SP_Cache_Read_Hit_Ratio,
					B.SP_Cache_Write_Hits, 
					B.SP_Cache_Write_Misses,
					B.SP_Cache_Writ_Hit_Ratio,
					B.SP_Cache_Forced_Flushes,
					B.Average_Busy_Queue_Length,
					B.Service_Time,
					B.SP_Cache_Dirty_Pages,
					B.SP_Cache_Flush_Ratio,
					B.SP_Cache_MBs_Flushed,
	
					B.Read_512B,
					B.Read_1KB,
					B.Read_2KB,
					B.Read_4KB,
					B.Read_8KB,
					B.Read_16KB,
					B.Read_32KB,
					B.Read_64KB,
					B.Read_128KB,
					B.Read_256KB,
					B.Read_512KB,
	
					B.Write_512B,
					B.Write_1KB,
					B.Write_2KB,
					B.Write_4KB,
					B.Write_8KB,
					B.Write_16KB,
					B.Write_32KB,
					B.Write_64KB,
					B.Write_128KB,
					B.Write_256KB,
					B.Write_512KB,
					B.Total_512B,
					B.Total_1KB,
					B.Total_2KB,
					B.Total_4KB,
					B.Total_8KB,
					B.Total_16KB,
					B.Total_32KB,
					B.Total_64KB,
					B.Total_128KB,
					B.Total_256KB,
					B.Total_512KB,
					
		    		B.MaxBUSY,
		    		B.AVGBUSY,
		    		B.TOTALCOUNT,
				B.AVGTOTAL_THROUGHPUT,
				B.SUMTOTAL_THROUGHPUT,
				B.MAXTOTAL_THROUGHPUT,
				B.MINTOTAL_THROUGHPUT,
				B.AVGRESPONSE_TIME,
				B.SUMRESPONSE_TIME,
				B.MAXRESPONSE_TIME,
				B.MINRESPONSE_TIME,
				B.AVGQUEUE_LENGTH,
				B.SUMQUEUE_LENGTH,
				B.MAXQUEUE_LENGTH,
				B.MINQUEUE_LENGTH,
				B.AVGUTILIZATION,
				B.SUMUTILIZATION,
				B.MAXUTILIZATION,
				B.MINUTILIZATION;
		INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,''SP'',OBJECT_NAME FROM '||$1||' WHERE DATAID='''||V_DATAID||''' AND OBJECT_NAME NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = '''||V_DATAID||''' AND OBJECT_TYPE = ''SP'')  GROUP BY DATAID,OBJECT_NAME';

	    END LOOP;
	CLOSE CX_COLLECT_SP_CURSOR;	
 RETURN ;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION CST.pro_cx_collect_sp_day(character varying)
  OWNER TO postgres;

-- ######################################################################
--######################################################################

-- Function: CST.pro_cx_collect_sp_hour(character varying)

-- DROP FUNCTION CST.pro_cx_collect_sp_hour(character varying);

CREATE OR REPLACE FUNCTION CST.pro_cx_collect_sp_hour(character varying)
  RETURNS void AS
$BODY$

	DECLARE 
	V_DATAID VARCHAR(15);                -- 存放DATAID
        V_LOOPTIME VARCHAR(20);              -- 存放统计时间
        SQLCODE INTEGER :=0;   
         CX_COLLECT_SP_CURSOR refcursor;              
	-- ######################################################################
	-- # 过程名称: 性能总图处理最大值，平均值放入新表中
	-- # 功能描述: 从CX_COLLECT_Port_TEMP检索
	-- # 			插入到CX_COLLECT_Port_DAY中
	-- ######################################################################

                         
    -- ######################################################################
	-- # 检索CX_COLLECT_Port_TEMP中DATAID,统计时间
	-- ######################################################################
     BEGIN 
	  
        
	OPEN CX_COLLECT_SP_CURSOR for
	  EXECUTE 'SELECT DISTINCT DATAID,HOUR_TIME AS LOOPTIME From '||$1||' where POLL_TIME < (select  substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),1,4) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),6,2) ||''/''|| substr(to_char(current_timestamp,''YYYY/MM/DD HH24:MI''),9,2)|| '' 00:00'' from pg_class fetch first 1 rows only)
';
	
		LOOP	    
	        FETCH CX_COLLECT_SP_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	        if not found then 
	          exit;
		    END IF;		
    -- ######################################################################
	-- # CX_COLLECT_Port_DAY插入
	-- ######################################################################     
	      
	-- ######################################################################
	-- # CX_COLLECT_Port_Num记录插入
	-- ######################################################################	       		    
	 EXECUTE '  INSERT INTO CST.CX_COLLECT_SP_HOUR
	        (DATAID,
			OBJECT_NAME,
			POLL_TIME,
			OWNER_ARRAY_NAME,
			CURRENT_OWNER,
			UTILIZATION,
			QUEUE_LENGTH,
			RESPONSE_TIME,
			TOTAL_BANDWIDTH,
			TOTAL_THROUGHPUT,
			READ_BANDWIDTH,
			READ_SIZE,
			READ_THROUGHPUT,
			WRITE_BANDWIDTH,
			WRITE_SIZE,
			WRITE_THROUGHPUT,
			SP_CACHE_READ_HITS,
			SP_CACHE_READ_MISSES,
			SP_CACHE_READ_HIT_RATIO,
			SP_CACHE_WRITE_HITS, 
			SP_CACHE_WRITE_MISSES,
			SP_CACHE_WRIT_HIT_RATIO,
			SP_CACHE_FORCED_FLUSHES,
			AVERAGE_BUSY_QUEUE_LENGTH,
			SERVICE_TIME,
			SP_CACHE_DIRTY_PAGES,
			SP_CACHE_FLUSH_RATIO,
			SP_CACHE_MBS_FLUSHED,
	
			READ_512B,
			READ_1KB,
			READ_2KB,
			READ_4KB,
			READ_8KB,
			READ_16KB,
			READ_32KB,
			READ_64KB,
			READ_128KB,
			READ_256KB,
			READ_512KB,
	
			WRITE_512B,
			WRITE_1KB,
			WRITE_2KB,
			WRITE_4KB,
			WRITE_8KB,
			WRITE_16KB,
			WRITE_32KB,
			WRITE_64KB,
			WRITE_128KB,
			WRITE_256KB,
			WRITE_512KB,
			TOTAL_512B,
			TOTAL_1KB,
			TOTAL_2KB,
			TOTAL_4KB,
			TOTAL_8KB,
			TOTAL_16KB,
			TOTAL_32KB,
			TOTAL_64KB,
			TOTAL_128KB,
			TOTAL_256KB,
			TOTAL_512KB,
			AVGTOTAL_THROUGHPUT,
			SUMTOTAL_THROUGHPUT,
			MAXTOTAL_THROUGHPUT,
			MINTOTAL_THROUGHPUT,
			AVGRESPONSE_TIME,
			SUMRESPONSE_TIME,
			MAXRESPONSE_TIME,
			MINRESPONSE_TIME,
			AVGQUEUE_LENGTH,
			SUMQUEUE_LENGTH,
			MAXQUEUE_LENGTH,
			MINQUEUE_LENGTH,
			AVGUTILIZATION,
			SUMUTILIZATION,
			MAXUTILIZATION,
			MINUTILIZATION
	        )
        	SELECT DATAID,
			Object_Name,
			'''||V_LOOPTIME||''',
			Owner_Array_Name,
			Current_Owner,
			MAX(Utilization) AS Utilization,
			MAX(Queue_Length) AS Queue_Length,
			MAX(Response_Time) AS Response_Time,
			MAX(Total_Bandwidth) AS Total_Bandwidth,
			MAX(Total_Throughput) AS Total_Throughput,
			MAX(Read_Bandwidth) AS Read_Bandwidth,
			MAX(Read_Size) AS Read_Size,
			MAX(Read_Throughput) AS Read_Throughput,
			MAX(Write_Bandwidth) AS Write_Bandwidth,
			MAX(Write_Size) AS Write_Size,
			MAX(Write_Throughput) AS Write_Throughput,
			MAX(SP_Cache_Read_Hits) AS SP_Cache_Read_Hits,
			MAX(SP_Cache_Read_Misses) AS SP_Cache_Read_Misses,
			MAX(SP_Cache_Read_Hit_Ratio) AS SP_Cache_Read_Hit_Ratio,
			MAX(SP_Cache_Write_Hits) AS SP_Cache_Write_Hits, 
			MAX(SP_Cache_Write_Misses) AS SP_Cache_Write_Misses,
			MAX(SP_Cache_Writ_Hit_Ratio) AS SP_Cache_Writ_Hit_Ratio,
			MAX(SP_Cache_Forced_Flushes) AS SP_Cache_Forced_Flushes,
			MAX(Average_Busy_Queue_Length) AS Average_Busy_Queue_Length,
			MAX(Service_Time) AS Service_Time,
			MAX(SP_Cache_Dirty_Pages) AS SP_Cache_Dirty_Pages,
			MAX(SP_Cache_Flush_Ratio) AS SP_Cache_Flush_Ratio,
			MAX(SP_Cache_MBs_Flushed) AS SP_Cache_MBs_Flushed,
	
			MAX(Read_512B) AS Read_512B,
			MAX(Read_1KB) AS Read_1KB,
			MAX(Read_2KB) AS Read_2KB,
			MAX(Read_4KB) AS Read_4KB,
			MAX(Read_8KB) AS Read_8KB,
			MAX(Read_16KB) AS Read_16KB,
			MAX(Read_32KB) AS Read_32KB,
			MAX(Read_64KB) AS Read_64KB,
			MAX(Read_128KB) AS Read_128KB,
			MAX(Read_256KB) AS Read_256KB,
			MAX(Read_512KB) AS Read_512KB,
	
			MAX(Write_512B) AS Write_512B,
			MAX(Write_1KB) AS Write_1KB,
			MAX(Write_2KB) AS Write_2KB,
			MAX(Write_4KB) AS Write_4KB,
			MAX(Write_8KB) AS Write_8KB,
			MAX(Write_16KB) AS Write_16KB,
			MAX(Write_32KB) AS Write_32KB,
			MAX(Write_64KB) AS Write_64KB,
			MAX(Write_128KB) AS Write_128KB,
			MAX(Write_256KB) AS Write_256KB,
			MAX(Write_512KB) AS Write_512KB,
			MAX(Total_512B) AS Total_512B,
			MAX(Total_1KB) AS Total_1KB,
			MAX(Total_2KB) AS Total_2KB,
			MAX(Total_4KB) AS Total_4KB,
			MAX(Total_8KB) AS Total_8KB,
			MAX(Total_16KB) AS Total_16KB,
			MAX(Total_32KB) AS Total_32KB,
			MAX(Total_64KB) AS Total_64KB,
			MAX(Total_128KB) AS Total_128KB,
			MAX(Total_256KB) AS Total_256KB,
			MAX(Total_512KB) AS Total_512KB,
			AVG(TOTAL_THROUGHPUT) AS AVGTOTAL_THROUGHPUT,
			SUM(TOTAL_THROUGHPUT) AS SUMTOTAL_THROUGHPUT,
			MAX(TOTAL_THROUGHPUT) AS MAXTOTAL_THROUGHPUT,
			MIN(TOTAL_THROUGHPUT) AS MINTOTAL_THROUGHPUT,
			AVG(RESPONSE_TIME) AS AVGRESPONSE_TIME,
			SUM(RESPONSE_TIME) AS SUMRESPONSE_TIME,
			MAX(RESPONSE_TIME) AS MAXRESPONSE_TIME,
			MIN(RESPONSE_TIME) AS MINRESPONSE_TIME,
			AVG(QUEUE_LENGTH) AS AVGQUEUE_LENGTH,
			SUM(QUEUE_LENGTH) AS SUMQUEUE_LENGTH,
			MAX(QUEUE_LENGTH) AS MAXQUEUE_LENGTH,
			MIN(QUEUE_LENGTH) AS MINQUEUE_LENGTH,
			AVG(UTILIZATION) AS AVGUTILIZATION,
			SUM(UTILIZATION) AS SUMUTILIZATION,
			MAX(UTILIZATION) AS MAXUTILIZATION,
			MIN(UTILIZATION) AS MINUTILIZATION
			
          	FROM '||$1||'
          	WHERE Hour_Time = '''||V_LOOPTIME||''' AND DATAID = '''||V_DATAID||'''                  
          	GROUP BY DATAID,Object_Name,Owner_Array_Name,Current_Owner';
	        
	        
	    END LOOP;
	CLOSE CX_COLLECT_SP_CURSOR;	
 RETURN ;
END;
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION CST.pro_cx_collect_sp_hour(character varying)
  OWNER TO postgres;
