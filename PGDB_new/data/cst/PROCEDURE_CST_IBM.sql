

CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_PORT_LEVEL_STATISTICS_DAY () RETURNS Void AS $$
 
    DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_PORT_LEVEL_STATISTICS_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	
   V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN COLLECT_PORT_LEVEL_STATISTICS_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH COLLECT_PORT_LEVEL_STATISTICS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_PORT_LEVEL_STATISTICS_DAY插入
	-- ######################################################################     
	      INSERT INTO CST.COLLECT_PORT_LEVEL_STATISTICS_DAY
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        PORT_ID,
	        SPEED,
		IO_RATE,
		DATA_RATE,
		AVG_RESP_TIME,
		FB_READ_IOS,
		FB_WRITE_IOS,
		CKD_READ_IOS,
		CKD_WRITE_IOS,
		PPRC_RECEIEVE_IOS,
		PPRC_SEND_IOS,
		INTERVAL_LENGTH,

		AVGAVG_RESP_TIME,
		SUMAVG_RESP_TIME,
		MAXAVG_RESP_TIME,
		MINAVG_RESP_TIME,
		AVGDATA_RATE,
		SUMDATA_RATE,
		MAXDATA_RATE,
		MINDATA_RATE,
		AVGIO_RATE,
		SUMIO_RATE,
		MAXIO_RATE,
		MINIO_RATE
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		PORT_ID,       		
         		MAX(SPEED) AS SPEED,
         		MAX(IO_RATE) AS IO_RATE,
         		MAX(DATA_RATE) AS DATA_RATE,
         		MAX(AVG_RESP_TIME) AS AVG_RESP_TIME,
         		MAX(FB_READ_IOS) AS FB_READ_IOS,
         		MAX(FB_WRITE_IOS) AS FB_WRITE_IOS,
         		MAX(CKD_READ_IOS) AS CKD_READ_IOS,
         		MAX(CKD_WRITE_IOS) AS CKD_WRITE_IOS,
         		MAX(PPRC_RECEIEVE_IOS) AS PPRC_RECEIEVE_IOS,
         		MAX(PPRC_SEND_IOS) AS PPRC_SEND_IOS,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(AVG_RESP_TIME) AS AVGAVG_RESP_TIME,
			SUM(AVG_RESP_TIME) AS SUMAVG_RESP_TIME,
			MAX(AVG_RESP_TIME) AS MAXAVG_RESP_TIME,
			MIN(AVG_RESP_TIME) AS MINAVG_RESP_TIME,
			AVG(DATA_RATE) AS AVGDATA_RATE,
			SUM(DATA_RATE) AS SUMDATA_RATE,
			MAX(DATA_RATE) AS MAXDATA_RATE,
			MIN(DATA_RATE) AS MINDATA_RATE,
			AVG(IO_RATE) AS AVGIO_RATE,
			SUM(IO_RATE) AS SUMIO_RATE,
			MAX(IO_RATE) AS MAXIO_RATE,
			MIN(IO_RATE) AS MINIO_RATE

          	FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,10) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,PORT_ID;
	    INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,'PORT',port_id FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP WHERE DATAID=V_DATAID AND port_id NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = V_DATAID AND OBJECT_TYPE = 'PORT')  GROUP BY DATAID,port_id;      
	    END LOOP;
	CLOSE COLLECT_PORT_LEVEL_STATISTICS_CURSOR;
	              
    RETURN ;
END;
$$
LANGUAGE plpgsql;
 -- ######################################################################
 -- ######################################################################


CREATE OR REPLACE  FUNCTION CST.PRO_COLLECT_PORT_LEVEL_STATISTICS_HOUR () RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP检索
	-- # 			插入到COLLECT_PORT_LEVEL_STATISTICS_HOUR中
	-- ######################################################################
	 

    DECLARE 
    V_DATAID VARCHAR(15);                -- 存放DATAID
    V_LOOPTIME VARCHAR(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
              -- 存放当前时间
    COLLECT_PORT_LEVEL_STATISTICS_CURSOR refcursor;                   
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间
	-- ######################################################################
   
  
  V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
        BEGIN
	OPEN COLLECT_PORT_LEVEL_STATISTICS_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP
			    
	        FETCH COLLECT_PORT_LEVEL_STATISTICS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	        if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_PORT_LEVEL_STATISTICS_HOUR插入
	-- ######################################################################     
	      INSERT INTO CST.COLLECT_PORT_LEVEL_STATISTICS_HOUR
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        PORT_ID,
	        SPEED,
		IO_RATE,
		DATA_RATE,
		AVG_RESP_TIME,
		FB_READ_IOS,
		FB_WRITE_IOS,
		CKD_READ_IOS,
		CKD_WRITE_IOS,
		PPRC_RECEIEVE_IOS,
		PPRC_SEND_IOS,
		INTERVAL_LENGTH,

		AVGAVG_RESP_TIME,
		SUMAVG_RESP_TIME,
		MAXAVG_RESP_TIME,
		MINAVG_RESP_TIME,
		AVGDATA_RATE,
		SUMDATA_RATE,
		MAXDATA_RATE,
		MINDATA_RATE,
		AVGIO_RATE,
		SUMIO_RATE,
		MAXIO_RATE,
		MINIO_RATE
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		PORT_ID,       		
         		MAX(SPEED) AS SPEED,
         		MAX(IO_RATE) AS IO_RATE,
         		MAX(DATA_RATE) AS DATA_RATE,
         		MAX(AVG_RESP_TIME) AS AVG_RESP_TIME,
         		MAX(FB_READ_IOS) AS FB_READ_IOS,
         		MAX(FB_WRITE_IOS) AS FB_WRITE_IOS,
         		MAX(CKD_READ_IOS) AS CKD_READ_IOS,
         		MAX(CKD_WRITE_IOS) AS CKD_WRITE_IOS,
         		MAX(PPRC_RECEIEVE_IOS) AS PPRC_RECEIEVE_IOS,
         		MAX(PPRC_SEND_IOS) AS PPRC_SEND_IOS,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(AVG_RESP_TIME) AS AVGAVG_RESP_TIME,
			SUM(AVG_RESP_TIME) AS SUMAVG_RESP_TIME,
			MAX(AVG_RESP_TIME) AS MAXAVG_RESP_TIME,
			MIN(AVG_RESP_TIME) AS MINAVG_RESP_TIME,
			AVG(DATA_RATE) AS AVGDATA_RATE,
			SUM(DATA_RATE) AS SUMDATA_RATE,
			MAX(DATA_RATE) AS MAXDATA_RATE,
			MIN(DATA_RATE) AS MINDATA_RATE,
			AVG(IO_RATE) AS AVGIO_RATE,
			SUM(IO_RATE) AS SUMIO_RATE,
			MAX(IO_RATE) AS MAXIO_RATE,
			MIN(IO_RATE) AS MINIO_RATE
          	FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,13) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,PORT_ID;
	        
	    END LOOP;
	CLOSE COLLECT_PORT_LEVEL_STATISTICS_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;

 -- ######################################################################
 -- ######################################################################

 CREATE  OR REPLACE FUNCTION CST.PRO_COLLECT_RANK_LEVEL_STATISTICS_DAY () RETURNS Void AS $$

	 

    DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_RANK_LEVEL_STATISTICS_CURSOR refcursor;
                         
    -- ######################################################################
	-- # 检索COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间
	-- ######################################################################
   
    V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN COLLECT_RANK_LEVEL_STATISTICS_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM CST.COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH COLLECT_RANK_LEVEL_STATISTICS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RANK_LEVEL_STATISTICS_DAY插入
	-- ######################################################################     
	      INSERT INTO CST.COLLECT_RANK_LEVEL_STATISTICS_DAY
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        RANK_ID,
	        RAID_TYPE,
		READ_IO_RATE,
		WRITE_IO_RATE,
		READ_DATA_RATE,
		WRITE_DATA_RATE,
		AVG_READ_RESP_TIME,
		AVG_WRITE_RESP_TIME,
		INTERVAL_LENGTH,

		AVGREAD_IO_RATE,
		SUMREAD_IO_RATE,
		MAXREAD_IO_RATE,
		MINREAD_IO_RATE,
		AVGWRITE_IO_RATE,
		SUMWRITE_IO_RATE,
		MAXWRITE_IO_RATE,
		MINWRITE_IO_RATE,
		AVGAVG_READ_RESP_TIME,
		SUMAVG_READ_RESP_TIME,
		MAXAVG_READ_RESP_TIME,
		MINAVG_READ_RESP_TIME,
		AVGAVG_WRITE_RESP_TIME,
		SUMAVG_WRITE_RESP_TIME,
		MAXAVG_WRITE_RESP_TIME,
		MINAVG_WRITE_RESP_TIME,
		AVGREAD_DATA_RATE,
		SUMREAD_DATA_RATE,
		MAXREAD_DATA_RATE,
		MINREAD_DATA_RATE,
		AVGWRITE_DATA_RATE,
		SUMWRITE_DATA_RATE,
		MAXWRITE_DATA_RATE,
		MINWRITE_DATA_RATE
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		RANK_ID,       		
         		RAID_TYPE,
         		MAX(READ_IO_RATE) AS READ_IO_RATE,
         		MAX(WRITE_IO_RATE) AS WRITE_IO_RATE,
         		MAX(READ_DATA_RATE) AS READ_DATA_RATE,
         		MAX(WRITE_DATA_RATE) AS WRITE_DATA_RATE,
         		MAX(AVG_READ_RESP_TIME) AS AVG_READ_RESP_TIME,
         		MAX(AVG_WRITE_RESP_TIME) AS AVG_WRITE_RESP_TIME,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(READ_IO_RATE) AS AVGREAD_IO_RATE,
			SUM(READ_IO_RATE) AS SUMREAD_IO_RATE,
			MAX(READ_IO_RATE) AS MAXREAD_IO_RATE,
			MIN(READ_IO_RATE) AS MINREAD_IO_RATE,
			AVG(WRITE_IO_RATE) AS AVGWRITE_IO_RATE,
			SUM(WRITE_IO_RATE) AS SUMWRITE_IO_RATE,
			MAX(WRITE_IO_RATE) AS MAXWRITE_IO_RATE,
			MIN(WRITE_IO_RATE) AS MINWRITE_IO_RATE,
			AVG(AVG_READ_RESP_TIME) AS AVGAVG_READ_RESP_TIME,
			SUM(AVG_READ_RESP_TIME) AS SUMAVG_READ_RESP_TIME,
			MAX(AVG_READ_RESP_TIME) AS MAXAVG_READ_RESP_TIME,
			MIN(AVG_READ_RESP_TIME) AS MINAVG_READ_RESP_TIME,
			AVG(AVG_WRITE_RESP_TIME) AS AVGAVG_WRITE_RESP_TIME,
			SUM(AVG_WRITE_RESP_TIME) AS SUMAVG_WRITE_RESP_TIME,
			MAX(AVG_WRITE_RESP_TIME) AS MAXAVG_WRITE_RESP_TIME,
			MIN(AVG_WRITE_RESP_TIME) AS MINAVG_WRITE_RESP_TIME,
			AVG(READ_DATA_RATE) AS AVGREAD_DATA_RATE,
			SUM(READ_DATA_RATE) AS SUMREAD_DATA_RATE,
			MAX(READ_DATA_RATE) AS MAXREAD_DATA_RATE,
			MIN(READ_DATA_RATE) AS MINREAD_DATA_RATE,
			AVG(WRITE_DATA_RATE) AS AVGWRITE_DATA_RATE,
			SUM(WRITE_DATA_RATE) AS SUMWRITE_DATA_RATE,
			MAX(WRITE_DATA_RATE) AS MAXWRITE_DATA_RATE,
			MIN(WRITE_DATA_RATE) AS MINWRITE_DATA_RATE

          	FROM CST.COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,10) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,RANK_ID,RAID_TYPE;

		INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,'RANK',Rank_id FROM CST.COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP WHERE DATAID=V_DATAID AND Rank_id NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = V_DATAID AND OBJECT_TYPE = 'RANK')  GROUP BY DATAID,Rank_id; 
	    END LOOP;
	CLOSE COLLECT_RANK_LEVEL_STATISTICS_CURSOR;
	             	              
    RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################

 CREATE  OR REPLACE FUNCTION CST.PRO_COLLECT_RANK_LEVEL_STATISTICS_HOUR () RETURNS Void AS $$

	 

    DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    COLLECT_RANK_LEVEL_STATISTICS_CURSOR refcursor;
                         
    -- ######################################################################
	-- # 检索COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间
	-- ######################################################################
   
    V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN COLLECT_RANK_LEVEL_STATISTICS_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM CST.COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH COLLECT_RANK_LEVEL_STATISTICS_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # COLLECT_RANK_LEVEL_STATISTICS_HOUR插入
	-- ######################################################################     
	      INSERT INTO CST.COLLECT_RANK_LEVEL_STATISTICS_HOUR
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        RANK_ID,
	        RAID_TYPE,
		READ_IO_RATE,
		WRITE_IO_RATE,
		READ_DATA_RATE,
		WRITE_DATA_RATE,
		AVG_READ_RESP_TIME,
		AVG_WRITE_RESP_TIME,
		INTERVAL_LENGTH,

		AVGREAD_IO_RATE,
		SUMREAD_IO_RATE,
		MAXREAD_IO_RATE,
		MINREAD_IO_RATE,
		AVGWRITE_IO_RATE,
		SUMWRITE_IO_RATE,
		MAXWRITE_IO_RATE,
		MINWRITE_IO_RATE,
		AVGAVG_READ_RESP_TIME,
		SUMAVG_READ_RESP_TIME,
		MAXAVG_READ_RESP_TIME,
		MINAVG_READ_RESP_TIME,
		AVGAVG_WRITE_RESP_TIME,
		SUMAVG_WRITE_RESP_TIME,
		MAXAVG_WRITE_RESP_TIME,
		MINAVG_WRITE_RESP_TIME,
		AVGREAD_DATA_RATE,
		SUMREAD_DATA_RATE,
		MAXREAD_DATA_RATE,
		MINREAD_DATA_RATE,
		AVGWRITE_DATA_RATE,
		SUMWRITE_DATA_RATE,
		MAXWRITE_DATA_RATE,
		MINWRITE_DATA_RATE
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		RANK_ID,       		
         		RAID_TYPE,
         		MAX(READ_IO_RATE) AS READ_IO_RATE,
         		MAX(WRITE_IO_RATE) AS WRITE_IO_RATE,
         		MAX(READ_DATA_RATE) AS READ_DATA_RATE,
         		MAX(WRITE_DATA_RATE) AS WRITE_DATA_RATE,
         		MAX(AVG_READ_RESP_TIME) AS AVG_READ_RESP_TIME,
         		MAX(AVG_WRITE_RESP_TIME) AS AVG_WRITE_RESP_TIME,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(READ_IO_RATE) AS AVGREAD_IO_RATE,
			SUM(READ_IO_RATE) AS SUMREAD_IO_RATE,
			MAX(READ_IO_RATE) AS MAXREAD_IO_RATE,
			MIN(READ_IO_RATE) AS MINREAD_IO_RATE,
			AVG(WRITE_IO_RATE) AS AVGWRITE_IO_RATE,
			SUM(WRITE_IO_RATE) AS SUMWRITE_IO_RATE,
			MAX(WRITE_IO_RATE) AS MAXWRITE_IO_RATE,
			MIN(WRITE_IO_RATE) AS MINWRITE_IO_RATE,
			AVG(AVG_READ_RESP_TIME) AS AVGAVG_READ_RESP_TIME,
			SUM(AVG_READ_RESP_TIME) AS SUMAVG_READ_RESP_TIME,
			MAX(AVG_READ_RESP_TIME) AS MAXAVG_READ_RESP_TIME,
			MIN(AVG_READ_RESP_TIME) AS MINAVG_READ_RESP_TIME,
			AVG(AVG_WRITE_RESP_TIME) AS AVGAVG_WRITE_RESP_TIME,
			SUM(AVG_WRITE_RESP_TIME) AS SUMAVG_WRITE_RESP_TIME,
			MAX(AVG_WRITE_RESP_TIME) AS MAXAVG_WRITE_RESP_TIME,
			MIN(AVG_WRITE_RESP_TIME) AS MINAVG_WRITE_RESP_TIME,
			AVG(READ_DATA_RATE) AS AVGREAD_DATA_RATE,
			SUM(READ_DATA_RATE) AS SUMREAD_DATA_RATE,
			MAX(READ_DATA_RATE) AS MAXREAD_DATA_RATE,
			MIN(READ_DATA_RATE) AS MINREAD_DATA_RATE,
			AVG(WRITE_DATA_RATE) AS AVGWRITE_DATA_RATE,
			SUM(WRITE_DATA_RATE) AS SUMWRITE_DATA_RATE,
			MAX(WRITE_DATA_RATE) AS MAXWRITE_DATA_RATE,
			MIN(WRITE_DATA_RATE) AS MINWRITE_DATA_RATE

          	FROM CST.COLLECT_RANK_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,13) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,RANK_ID,RAID_TYPE;

	    END LOOP;
	CLOSE COLLECT_RANK_LEVEL_STATISTICS_CURSOR;
	             	              
    RETURN ;
END;
$$
LANGUAGE plpgsql;
-- ######################################################################
-- ######################################################################


CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_VOLUME_LEVEL_STATISTICS_DAY ()  RETURNS Void AS $$

	-- ######################################################################
	-- # 过程名称: 性能数据放入新表中
	-- # 功能描述: 从COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP检索
	-- # 			插入到Collect_Volume_Level_Statistics_DAY中
	-- ######################################################################
	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    Collect_Volume_Level_Statistics_CURSOR refcursor;
         -- 存放当前时间
    -- ######################################################################
	-- # 检索COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间
	-- ######################################################################
   
  V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN Collect_Volume_Level_Statistics_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,10) AS LOOPTIME FROM CST.COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH Collect_Volume_Level_Statistics_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;		
    -- ######################################################################
	-- # Collect_Volume_Level_Statistics_DAY插入
	-- ######################################################################     
	      INSERT INTO CST.Collect_Volume_Level_Statistics_DAY
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        Volume_ID,
	        IO_Rate,
		Data_Rate,
		Total_Hit_Perc,
		INTERVAL_LENGTH,

		AVGDATA_RATE,
		SUMDATA_RATE,
		MAXDATA_RATE,
		MINDATA_RATE,
		AVGIO_RATE,
		SUMIO_RATE,
		MAXIO_RATE,
		MINIO_RATE,
		AVGTOTAL_HIT_PERC,
		SUMTOTAL_HIT_PERC,
		MAXTOTAL_HIT_PERC,
		MINTOTAL_HIT_PERC
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		Volume_ID,       		
         		MAX(IO_Rate) AS IO_Rate,
         		MAX(Data_Rate) AS Data_Rate,
         		MAX(Total_Hit_Perc) AS Total_Hit_Perc,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(DATA_RATE) AS AVGDATA_RATE,
			SUM(DATA_RATE) AS SUMDATA_RATE,
			MAX(DATA_RATE) AS MAXDATA_RATE,
			MIN(DATA_RATE) AS MINDATA_RATE,
			AVG(IO_RATE) AS AVGIO_RATE,
			SUM(IO_RATE) AS SUMIO_RATE,
			MAX(IO_RATE) AS MAXIO_RATE,
			MIN(IO_RATE) AS MINIO_RATE,
			AVG(TOTAL_HIT_PERC) AS AVGTOTAL_HIT_PERC,
			SUM(TOTAL_HIT_PERC) AS SUMTOTAL_HIT_PERC,
			MAX(TOTAL_HIT_PERC) AS MAXTOTAL_HIT_PERC,
			MIN(TOTAL_HIT_PERC) AS MINTOTAL_HIT_PERC
          	FROM CST.COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,10) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,Volume_ID;
	        
		INSERT INTO CST.COLLECT_OBJECT_LIST(DATAID,OBJECT_TYPE,OBJECT_NAME) SELECT DATAID,'VOLUME',Volume_ID FROM CST.COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP WHERE DATAID=V_DATAID AND Volume_ID NOT IN (SELECT OBJECT_NAME FROM CST.COLLECT_OBJECT_LIST WHERE DATAID = V_DATAID AND OBJECT_TYPE = 'VOLUME')  GROUP BY DATAID,Volume_ID; 
	    END LOOP;
	CLOSE Collect_Volume_Level_Statistics_CURSOR;
	              
 RETURN ;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION CST.PRO_COLLECT_VOLUME_LEVEL_STATISTICS_HOUR () RETURNS Void AS $$

	 
DECLARE  
    V_DATAID varchar;                -- 存放DATAID
    V_LOOPTIME varchar(20);              -- 存放统计时间
    SQLCODE INTEGER := 0;   
    Collect_Volume_Level_Statistics_CURSOR refcursor;
         -- 存放当前时间
                        
    -- ######################################################################
	-- # 检索COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP中DATAID,统计时间

 	-- ######################################################################
 --select * FROM CST.COLLECT_PORT_LEVEL_STATISTICS_DAYTEMP ;


	
   V_CURRENTDATE varchar :=to_char(current_timestamp,'YYYY/MM/DD HH24:MI:SS');
       BEGIN 
      
	OPEN Collect_Volume_Level_Statistics_CURSOR for SELECT DISTINCT DATAID,SUBSTR(DATA_TIMES,1,13) AS LOOPTIME FROM CST.COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP where DATA_TIMES < (select  substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),1,4) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),6,2) ||'/'|| substr(to_char(current_timestamp,'YYYY/MM/DD HH24:MI'),9,2)|| ' 00:00' FROM pg_class fetch first 1 rows only);
	--循环游标
	LOOP	    
	        FETCH Collect_Volume_Level_Statistics_CURSOR INTO V_DATAID,V_LOOPTIME;	        
	       if not found then 
	         exit; 
		    END IF;			
    -- ######################################################################
	-- # Collect_Volume_Level_Statistics_Hour插入
	-- ######################################################################     
	      INSERT INTO CST.Collect_Volume_Level_Statistics_Hour
	        (DATAID,
	        DATA_TIMES,
	        SAVE_TIMES,
	        Volume_ID,
	        IO_Rate,
		Data_Rate,
		Total_Hit_Perc,
		INTERVAL_LENGTH,

		AVGDATA_RATE,
		SUMDATA_RATE,
		MAXDATA_RATE,
		MINDATA_RATE,
		AVGIO_RATE,
		SUMIO_RATE,
		MAXIO_RATE,
		MINIO_RATE,
		AVGTOTAL_HIT_PERC,
		SUMTOTAL_HIT_PERC,
		MAXTOTAL_HIT_PERC,
		MINTOTAL_HIT_PERC
	        )
        	SELECT DATAID,
        		V_LOOPTIME,
        		V_CURRENTDATE,
        		Volume_ID,       		
         		MAX(IO_Rate) AS IO_Rate,
         		MAX(Data_Rate) AS Data_Rate,
         		MAX(Total_Hit_Perc) AS Total_Hit_Perc,
         		MAX(INTERVAL_LENGTH) AS INTERVAL_LENGTH,

			AVG(DATA_RATE) AS AVGDATA_RATE,
			SUM(DATA_RATE) AS SUMDATA_RATE,
			MAX(DATA_RATE) AS MAXDATA_RATE,
			MIN(DATA_RATE) AS MINDATA_RATE,
			AVG(IO_RATE) AS AVGIO_RATE,
			SUM(IO_RATE) AS SUMIO_RATE,
			MAX(IO_RATE) AS MAXIO_RATE,
			MIN(IO_RATE) AS MINIO_RATE,
			AVG(TOTAL_HIT_PERC) AS AVGTOTAL_HIT_PERC,
			SUM(TOTAL_HIT_PERC) AS SUMTOTAL_HIT_PERC,
			MAX(TOTAL_HIT_PERC) AS MAXTOTAL_HIT_PERC,
			MIN(TOTAL_HIT_PERC) AS MINTOTAL_HIT_PERC

          	FROM CST.COLLECT_VOLUME_LEVEL_STATISTICS_DAYTEMP
          	WHERE SUBSTR(DATA_TIMES,1,13) = V_LOOPTIME AND DATAID = V_DATAID                  
          	GROUP BY DATAID,Volume_ID;
	        
	    END LOOP;
	CLOSE Collect_Volume_Level_Statistics_CURSOR;
	 RETURN ;
END;
$$
LANGUAGE plpgsql;
 