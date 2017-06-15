connect igadmin/igadmin@CST

CREATE TABLE IBM_VERSION_DATA_MAPPING
(
	ID INTEGER NOT NULL,
	TABLENAME VARCHAR(32),
	COLNAME VARCHAR(32),
	COLINDEX VARCHAR(4),
	DATATYPE VARCHAR(10),
	store	INTEGER,
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;


CREATE TABLE IBM_VERSION_LABEL_MAPPING
(
	ID INTEGER NOT NULL,
	LABELNAME VARCHAR(64),
	TABLENAME VARCHAR(32),
	STARTTAG VARCHAR(64),
	INTERVALTIME VARCHAR(64),
	LABELTYPE VARCHAR(10),
	PRIMARY KEY (ID)
)TABLESPACE SOC_SPACE;


CREATE TABLE Port_Level
(  
   DATAID VARCHAR(15) NOT NULL,
   DATA_TIMES VARCHAR(20) NOT NULL,
   SAVE_TIMES VARCHAR(20) NOT NULL,
   Port_ID VARCHAR(15) NOT NULL,
   Speed DECIMAL(26,6),
   IO_Rate DECIMAL(26,6),
   Data_Rate DECIMAL(26,6),	   
   Avg_Resp_Time DECIMAL(26,6),
   FB_Read_IOs DECIMAL(26,6),
   FB_Write_IOs DECIMAL(26,6),
   CKD_Read_IOs DECIMAL(26,6),
   CKD_Write_IOs DECIMAL(26,6),
   PPRC_Receieve_IOs DECIMAL(26,6),
   PPRC_Send_IOs DECIMAL(26,6),
   Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Rank_Level
(
        DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Rank_ID VARCHAR(15) NOT NULL,
        RAID_Type  VARCHAR(15) NOT NULL,
        Read_IO_Rate DECIMAL(26,6),
        Write_IO_Rate DECIMAL(26,6),
        Read_Data_Rate DECIMAL(26,6),
        Write_Data_Rate DECIMAL(26,6),
        Avg_Read_Resp_Time DECIMAL(26,6),
        Avg_Write_Resp_Time DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Volume_Level
(       
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Volume_ID VARCHAR(15) NOT NULL,
        IO_Rate DECIMAL(26,6),
	Data_Rate DECIMAL(26,6),
	Total_Hit_Perc DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE Port_Level_hour
(  
   DATAID VARCHAR(15) NOT NULL,
   DATA_TIMES VARCHAR(20) NOT NULL,
   SAVE_TIMES VARCHAR(20) NOT NULL,
   Port_ID VARCHAR(15) NOT NULL,
   Speed DECIMAL(26,6),
   IO_Rate DECIMAL(26,6),
   Data_Rate DECIMAL(26,6),	   
   Avg_Resp_Time DECIMAL(26,6),
   FB_Read_IOs DECIMAL(26,6),
   FB_Write_IOs DECIMAL(26,6),
   CKD_Read_IOs DECIMAL(26,6),
   CKD_Write_IOs DECIMAL(26,6),
   PPRC_Receieve_IOs DECIMAL(26,6),
   PPRC_Send_IOs DECIMAL(26,6),
   Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Rank_Level_hour
(
        DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Rank_ID VARCHAR(15) NOT NULL,
        RAID_Type  VARCHAR(15) NOT NULL,
        Read_IO_Rate DECIMAL(26,6),
        Write_IO_Rate DECIMAL(26,6),
        Read_Data_Rate DECIMAL(26,6),
        Write_Data_Rate DECIMAL(26,6),
        Avg_Read_Resp_Time DECIMAL(26,6),
        Avg_Write_Resp_Time DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Volume_Level_hour
(       
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Volume_ID VARCHAR(15) NOT NULL,
        IO_Rate DECIMAL(26,6),
	Data_Rate DECIMAL(26,6),
	Total_Hit_Perc DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE Port_Level_day
(  
   DATAID VARCHAR(15) NOT NULL,
   DATA_TIMES VARCHAR(20) NOT NULL,
   SAVE_TIMES VARCHAR(20) NOT NULL,
   Port_ID VARCHAR(15) NOT NULL,
   Speed DECIMAL(26,6),
   IO_Rate DECIMAL(26,6),
   Data_Rate DECIMAL(26,6),	   
   Avg_Resp_Time DECIMAL(26,6),
   FB_Read_IOs DECIMAL(26,6),
   FB_Write_IOs DECIMAL(26,6),
   CKD_Read_IOs DECIMAL(26,6),
   CKD_Write_IOs DECIMAL(26,6),
   PPRC_Receieve_IOs DECIMAL(26,6),
   PPRC_Send_IOs DECIMAL(26,6),
   Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Rank_Level_day
(
        DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Rank_ID VARCHAR(15) NOT NULL,
        RAID_Type  VARCHAR(15) NOT NULL,
        Read_IO_Rate DECIMAL(26,6),
        Write_IO_Rate DECIMAL(26,6),
        Read_Data_Rate DECIMAL(26,6),
        Write_Data_Rate DECIMAL(26,6),
        Avg_Read_Resp_Time DECIMAL(26,6),
        Avg_Write_Resp_Time DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Volume_Level_day
(       
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Volume_ID VARCHAR(15) NOT NULL,
        IO_Rate DECIMAL(26,6),
	Data_Rate DECIMAL(26,6),
	Total_Hit_Perc DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Port_Level_Daytemp
(  
   DATAID VARCHAR(15) NOT NULL,
   DATA_TIMES VARCHAR(20) NOT NULL,
   SAVE_TIMES VARCHAR(20) NOT NULL,
   Port_ID VARCHAR(15) NOT NULL,
   Speed DECIMAL(26,6),
   IO_Rate DECIMAL(26,6),
   Data_Rate DECIMAL(26,6),	   
   Avg_Resp_Time DECIMAL(26,6),
   FB_Read_IOs DECIMAL(26,6),
   FB_Write_IOs DECIMAL(26,6),
   CKD_Read_IOs DECIMAL(26,6),
   CKD_Write_IOs DECIMAL(26,6),
   PPRC_Receieve_IOs DECIMAL(26,6),
   PPRC_Send_IOs DECIMAL(26,6),
   Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Rank_Level_Daytemp
(
        DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Rank_ID VARCHAR(15) NOT NULL,
        RAID_Type  VARCHAR(15) NOT NULL,
        Read_IO_Rate DECIMAL(26,6),
        Write_IO_Rate DECIMAL(26,6),
        Read_Data_Rate DECIMAL(26,6),
        Write_Data_Rate DECIMAL(26,6),
        Avg_Read_Resp_Time DECIMAL(26,6),
        Avg_Write_Resp_Time DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Volume_Level_Daytemp
(       
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Volume_ID VARCHAR(15) NOT NULL,
        IO_Rate DECIMAL(26,6),
	Data_Rate DECIMAL(26,6),
	Total_Hit_Perc DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE Port_Level_temp
(  
   DATAID VARCHAR(15) NOT NULL,
   DATA_TIMES VARCHAR(20) NOT NULL,
   SAVE_TIMES VARCHAR(20) NOT NULL,
   Port_ID VARCHAR(15) NOT NULL,
   Speed DECIMAL(26,6),
   IO_Rate DECIMAL(26,6),
   Data_Rate DECIMAL(26,6),	   
   Avg_Resp_Time DECIMAL(26,6),
   FB_Read_IOs DECIMAL(26,6),
   FB_Write_IOs DECIMAL(26,6),
   CKD_Read_IOs DECIMAL(26,6),
   CKD_Write_IOs DECIMAL(26,6),
   PPRC_Receieve_IOs DECIMAL(26,6),
   PPRC_Send_IOs DECIMAL(26,6),
   Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Rank_Level_temp
(
        DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Rank_ID VARCHAR(15) NOT NULL,
        RAID_Type  VARCHAR(15) NOT NULL,
        Read_IO_Rate DECIMAL(26,6),
        Write_IO_Rate DECIMAL(26,6),
        Read_Data_Rate DECIMAL(26,6),
        Write_Data_Rate DECIMAL(26,6),
        Avg_Read_Resp_Time DECIMAL(26,6),
        Avg_Write_Resp_Time DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE Volume_Level_temp
(       
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
        SAVE_TIMES VARCHAR(20) NOT NULL,
	Volume_ID VARCHAR(15) NOT NULL,
        IO_Rate DECIMAL(26,6),
	Data_Rate DECIMAL(26,6),
	Total_Hit_Perc DECIMAL(26,6),
        Interval_Length DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


create view StorageDeviceIDView as 
select dataid,port_id as Director_Number,'port' as type
from  Port_Level
group by dataid,port_id
union
select dataid,Rank_id as Director_Number,'rank' as type
from Rank_Level
group by dataid,Rank_id
 union 
select dataid,Volume_ID as Director_Number,'volume' as type
from Volume_Level
group by dataid,Volume_ID;

delete from IBM_VERSION_DATA_MAPPING;
delete from IBM_VERSION_LABEL_MAPPING;