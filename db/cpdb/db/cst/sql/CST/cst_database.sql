connect igadmin/igadmin@CST

create sequence SOC_SEQ
increment by 1
start with 1
minvalue 1 nomaxvalue
NOCYCLE;

CREATE TABLE CX_COLLECT_SP_TEMP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput  DECIMAL(16,6),
	Read_Bandwidth  DECIMAL(16,6),
	Read_Size  DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	Day_Time VARCHAR(10) ,
	Hour_Time VARCHAR(15) 
)TABLESPACE SOC_SPACE;


CREATE TABLE CX_COLLECT_LUN_TEMP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	Day_Time VARCHAR(10) ,
	Hour_Time VARCHAR(15) 
)TABLESPACE SOC_SPACE;



CREATE TABLE CX_COLLECT_Disk_TEMP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	Day_Time VARCHAR(10) ,
	Hour_Time VARCHAR(15) 
)TABLESPACE SOC_SPACE;


CREATE TABLE CX_COLLECT_Raid_Group_TEMP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	Day_Time VARCHAR(10) ,
	Hour_Time VARCHAR(15) 
)TABLESPACE SOC_SPACE;


CREATE TABLE CX_COLLECT_Port_TEMP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	Day_Time VARCHAR(10) ,
	Hour_Time VARCHAR(15) 
)TABLESPACE SOC_SPACE;

CREATE TABLE CX_COLLECT_SP
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput  DECIMAL(16,6),
	Read_Bandwidth  DECIMAL(16,6),
	Read_Size  DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CX_COLLECT_LUN
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CX_COLLECT_Disk
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;




CREATE TABLE CX_COLLECT_Raid_Group
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CX_COLLECT_Port
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE  CX_COLLECT_SP_HOUR
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_LUN_HOUR
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Disk_HOUR
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Raid_Group_HOUR
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Port_HOUR
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE  CX_COLLECT_SP_DAY
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_LUN_DAY
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Disk_DAY
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Raid_Group_DAY
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE  CX_COLLECT_Port_DAY
(
	DATAID VARCHAR(20) ,
	Object_Name VARCHAR(128) ,
	Poll_Time VARCHAR(20) ,
	Owner_Array_Name VARCHAR(64),
	Current_Owner VARCHAR(4),
	Utilization DECIMAL(16,6),
	Queue_Length DECIMAL(16,6),
	Response_Time DECIMAL(16,6),
	Total_Bandwidth	DECIMAL(16,6),
	Total_Throughput DECIMAL(16,6),
	Read_Bandwidth DECIMAL(16,6),
	Read_Size DECIMAL(16,6),
	Read_Throughput DECIMAL(16,6),
	Write_Bandwidth DECIMAL(16,6),
	Write_Size DECIMAL(16,6),
	Write_Throughput DECIMAL(16,6),
	SP_Cache_Read_Hits DECIMAL(16,6),
	SP_Cache_Read_Misses DECIMAL(16,6),
	SP_Cache_Read_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Write_Hits  DECIMAL(16,6), 
	SP_Cache_Write_Misses  DECIMAL(16,6),
	SP_Cache_Writ_Hit_Ratio  DECIMAL(16,6),
	SP_Cache_Forced_Flushes  DECIMAL(16,6),
	Average_Busy_Queue_Length  DECIMAL(16,6),
	Service_Time  DECIMAL(16,6),
	SP_Cache_Dirty_Pages  DECIMAL(16,6),
	SP_Cache_Flush_Ratio  DECIMAL(16,6),
	SP_Cache_MBs_Flushed  DECIMAL(16,6),
	Read_512B  DECIMAL(16,6),
	Read_1KB  DECIMAL(16,6),
	Read_2KB  DECIMAL(16,6),
	Read_4KB  DECIMAL(16,6),
	Read_8KB  DECIMAL(16,6),
	Read_16KB  DECIMAL(16,6),
	Read_32KB  DECIMAL(16,6),
	Read_64KB  DECIMAL(16,6),
	Read_128KB  DECIMAL(16,6),
	Read_256KB  DECIMAL(16,6),
	Read_512KB  DECIMAL(16,6),
	Write_512B  DECIMAL(16,6),
	Write_1KB  DECIMAL(16,6),
	Write_2KB  DECIMAL(16,6),
	Write_4KB  DECIMAL(16,6),
	Write_8KB  DECIMAL(16,6),
	Write_16KB  DECIMAL(16,6),
	Write_32KB  DECIMAL(16,6),
	Write_64KB  DECIMAL(16,6),
	Write_128KB  DECIMAL(16,6),
	Write_256KB  DECIMAL(16,6),
	Write_512KB  DECIMAL(16,6),
	Total_512B  DECIMAL(16,6),
	Total_1KB  DECIMAL(16,6),
	Total_2KB  DECIMAL(16,6),
	Total_4KB  DECIMAL(16,6),
	Total_8KB  DECIMAL(16,6),
	Total_16KB  DECIMAL(16,6),
	Total_32KB  DECIMAL(16,6),
	Total_64KB  DECIMAL(16,6),
	Total_128KB  DECIMAL(16,6),
	Total_256KB  DECIMAL(16,6),
	Total_512KB  DECIMAL(16,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;



CREATE TABLE CX_COLLECT_Enclosure_DISKS
(
	DATAID VARCHAR(20) ,
	Object_NAME VARCHAR(15)
)TABLESPACE SOC_SPACE;

CREATE TABLE CX_COLLECT_Port_Num
(
	DATAID VARCHAR(20) ,
	Object_NAME VARCHAR(15)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DEVICES
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	WRITE_PENDING_COUNT DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	RANDOM_READS_PER_SEC DECIMAL(26,6),
	RANDOM_WRITES_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6),
	SEQ_WRITES_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_DA
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_FE
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_RDF
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DISKS
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	TOTAL_SCSI_COMMAND_PER_SEC DECIMAL(26,6),
	READ_COMMANDS_PER_SEC DECIMAL(26,6),
	WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_READ_COMMANDS_PER_SEC DECIMAL(26,6),
	DISK_BUSY DECIMAL(26,6),
	AVERAGE_QUEUE DECIMAL(26,6),
	DISK_IDLE_TIME_PER_SEC DECIMAL(26,6),
	ACCUMULATED_QUEUE_DEPTH DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_PORTS_FE
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_RDFA_STATUS
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RA_GROUP_NUMBER VARCHAR(15) NOT NULL,
	AVG_CYCLE_TIME DECIMAL(26,6),
	DURATION_OF_LAST_CYCLE DECIMAL(26,6),
	R1_R2_IOS_PER_SEC DECIMAL(26,6),
	R1_R2_MBYTES_PER_SECOND DECIMAL(26,6),
	R2_R1_IOS_PER_SEC DECIMAL(26,6),
	R2_R1_MBYTES_PER_SECOND DECIMAL(26,6),
	TOTAL_CACHE_SLOTS_IN_USE DECIMAL(26,6),
	ACTIVE_CYCLE_SIZE DECIMAL(26,6),
	INACTIVE_CYCLE_SIZE DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_DIRECTOR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_RDF_GROUP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_LINK
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_SYSTEM
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	SYMID VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	READS_ DECIMAL(26,6),
	WRITES DECIMAL(26,6),
	HIT DECIMAL(26,6),
	KBYTES_TRANSFERRED_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	HITS_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_ESCON
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_RA1
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_RA2
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_SA
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_SE
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DEVICES_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	WRITE_PENDING_COUNT DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	RANDOM_READS_PER_SEC DECIMAL(26,6),
	RANDOM_WRITES_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6),
	SEQ_WRITES_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_DA_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	interval_time DECIMAL(26,6),
	accumulated_director_idle_time DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIRECTORS_FE_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIRECTORS_RDF_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DISKS_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	TOTAL_SCSI_COMMAND_PER_SEC DECIMAL(26,6),
	READ_COMMANDS_PER_SEC DECIMAL(26,6),
	WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_READ_COMMANDS_PER_SEC DECIMAL(26,6),
	DISK_BUSY DECIMAL(26,6),
	AVERAGE_QUEUE DECIMAL(26,6),
	DISK_IDLE_TIME_PER_SEC DECIMAL(26,6),
	ACCUMULATED_QUEUE_DEPTH DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_PORTS_FE_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_RDFA_STATUS_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RA_GROUP_NUMBER VARCHAR(15) NOT NULL,
	AVG_CYCLE_TIME DECIMAL(26,6),
	DURATION_OF_LAST_CYCLE DECIMAL(26,6),
	R1_R2_IOS_PER_SEC DECIMAL(26,6),
	R1_R2_MBYTES_PER_SECOND DECIMAL(26,6),
	R2_R1_IOS_PER_SEC DECIMAL(26,6),
	R2_R1_MBYTES_PER_SECOND DECIMAL(26,6),
	TOTAL_CACHE_SLOTS_IN_USE DECIMAL(26,6),
	ACTIVE_CYCLE_SIZE DECIMAL(26,6),
	INACTIVE_CYCLE_SIZE DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_DIRECTOR_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_RDF_GROUP_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_LINK_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_SYSTEM_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	SYMID VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	READS_ DECIMAL(26,6),
	WRITES DECIMAL(26,6),
	HIT DECIMAL(26,6),
	KBYTES_TRANSFERRED_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	HITS_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_ESCON_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_RA1_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_RA2_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_SA_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_SE_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DEVICES_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	WRITE_PENDING_COUNT DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	RANDOM_READS_PER_SEC DECIMAL(26,6),
	RANDOM_WRITES_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6),
	SEQ_WRITES_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_PORTS_FE_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDFA_STATUS_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RA_GROUP_NUMBER VARCHAR(15) NOT NULL,
	AVG_CYCLE_TIME DECIMAL(26,6),
	DURATION_OF_LAST_CYCLE DECIMAL(26,6),
	R1_R2_IOS_PER_SEC DECIMAL(26,6),
	R1_R2_MBYTES_PER_SECOND DECIMAL(26,6),
	R2_R1_IOS_PER_SEC DECIMAL(26,6),
	R2_R1_MBYTES_PER_SECOND DECIMAL(26,6),
	TOTAL_CACHE_SLOTS_IN_USE DECIMAL(26,6),
	ACTIVE_CYCLE_SIZE DECIMAL(26,6),
	INACTIVE_CYCLE_SIZE DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_DIRECTOR_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_RDF_GROUP_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_LINK_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_SYSTEM_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	SYMID VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	READS_ DECIMAL(26,6),
	WRITES DECIMAL(26,6),
	HIT DECIMAL(26,6),
	KBYTES_TRANSFERRED_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	HITS_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_ESCON_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_RA1_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_RA2_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;





CREATE TABLE COLLECT_DIR_SA_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_SE_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_FE_DAY
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),	
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_DIRECTORS_RDF_DAY
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),	
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE; 


CREATE TABLE COLLECT_DISKS_DAY
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DEVICE_NAME VARCHAR(15) ,
	TOTAL_SCSI_COMMAND_PER_SEC DECIMAL(26,6),
	READ_COMMANDS_PER_SEC DECIMAL(26,6),
	WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_READ_COMMANDS_PER_SEC DECIMAL(26,6),
	AVERAGE_QUEUE DECIMAL(26,6),
	DISK_IDLE_TIME_PER_SEC DECIMAL(26,6),
	ACCUMULATED_QUEUE_DEPTH DECIMAL(26,6),	
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer	
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_DA_DAY
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	interval_time DECIMAL(26,6),
	accumulated_director_idle_time DECIMAL(26,6),	
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;               


CREATE TABLE COLLECT_DISKS_LIST
(
	DATAID VARCHAR(20) ,
	DEVICE_NAME VARCHAR(20)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DEVICES_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DEVICE_NAME VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	WRITE_PENDING_COUNT DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	RANDOM_READS_PER_SEC DECIMAL(26,6),
	RANDOM_WRITES_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6),
	SEQ_WRITES_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_PORTS_FE_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDFA_STATUS_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RA_GROUP_NUMBER VARCHAR(15) NOT NULL,
	AVG_CYCLE_TIME DECIMAL(26,6),
	DURATION_OF_LAST_CYCLE DECIMAL(26,6),
	R1_R2_IOS_PER_SEC DECIMAL(26,6),
	R1_R2_MBYTES_PER_SECOND DECIMAL(26,6),
	R2_R1_IOS_PER_SEC DECIMAL(26,6),
	R2_R1_MBYTES_PER_SECOND DECIMAL(26,6),
	TOTAL_CACHE_SLOTS_IN_USE DECIMAL(26,6),
	ACTIVE_CYCLE_SIZE DECIMAL(26,6),
	INACTIVE_CYCLE_SIZE DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_DIRECTOR_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_RDF_GROUP_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_RDF_LINK_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_SYSTEM_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	SYMID VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	TOTAL_IOS_PER_SEC DECIMAL(26,6),
	READS_ DECIMAL(26,6),
	WRITES DECIMAL(26,6),
	HIT DECIMAL(26,6),
	KBYTES_TRANSFERRED_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	HITS_PER_SEC DECIMAL(26,6),
	SEQ_READS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_ESCON_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIR_RA1_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_RA2_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;





CREATE TABLE COLLECT_DIR_SA_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIR_SE_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE COLLECT_DIRECTORS_FE_HOUR
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),	
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;   
CREATE TABLE COLLECT_DIRECTORS_RDF_HOUR
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	KBYTES_SENT_PER_SEC DECIMAL(26,6),
	LINK_UTILIZATION DECIMAL(26,6),	
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6),
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DISKS_HOUR
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DEVICE_NAME VARCHAR(15) ,
	TOTAL_SCSI_COMMAND_PER_SEC DECIMAL(26,6),
	READ_COMMANDS_PER_SEC DECIMAL(26,6),
	WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_WRITE_COMMANDS_PER_SEC DECIMAL(26,6),
	XOR_READ_COMMANDS_PER_SEC DECIMAL(26,6),
	AVERAGE_QUEUE DECIMAL(26,6),
	DISK_IDLE_TIME_PER_SEC DECIMAL(26,6),
	ACCUMULATED_QUEUE_DEPTH DECIMAL(26,6),	
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer	
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_DIRECTORS_DA_HOUR
(
	DATAID VARCHAR(15) ,
	DATA_TIMES VARCHAR(20) ,
	DIRECTOR_NUMBER VARCHAR(15) ,
	IOS_PER_SEC DECIMAL(26,6),
	interval_time DECIMAL(26,6),
	accumulated_director_idle_time DECIMAL(26,6),	
	MaxBUSY DECIMAL(26,6),
	AVGBusy DECIMAL(26,6),
    	MAX_DATA_TIMES VARCHAR(20),
	TOTALCOUNT Integer
)TABLESPACE SOC_SPACE;               


CREATE TABLE version_data_mapping
(
	id Integer NOT NULL,
	name VARCHAR(64) ,
	microcode VARCHAR(10) ,
	colName VARCHAR(64) ,
	vindex VARCHAR(4),
	type VARCHAR(10),
	PRIMARY KEY (id)
)TABLESPACE SOC_SPACE;



CREATE TABLE version_label_mapping
(
	id Integer NOT NULL,
	microcode VARCHAR(10) ,
	name VARCHAR(64) ,
	label VARCHAR(64) ,
	type VARCHAR(10),
	PRIMARY KEY (id)
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_SYMMETRIX_INFO	
(
	ID INTEGER NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL, 
	SYMM_MODEL VARCHAR(20),		
	SYMM_VERSION VARCHAR(20),	
	SYMM_CACHESIZE VARCHAR(20),	
	FINGERPRINT VARCHAR(256),
	SYMM_TYPE VARCHAR(20)	
)TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_SYMMETRIX_MONITOR_RT	
(
	ID INTEGER NOT NULL,
	SAVETIME VARCHAR(16) NOT NULL,	
	SYMM_ID VARCHAR(64) NOT NULL,	
	TIMESTAMP VARCHAR(20) NOT NULL,	
	READS_PER_SEC DECIMAL(26,6),	
	WRITES_PER_SEC DECIMAL(26,6),	
	KBYTES_READ_PER_SEC DECIMAL(26,6),	
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),	
	HITS_READ_PER_SEC DECIMAL(26,6),
	HITS_WRITTEN_PER_SEC DECIMAL(26,6),
	SEQ_READ_PER_SEC DECIMAL(26,6),
	SEQ_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	FINGERPRINT VARCHAR(256)
)TABLESPACE SOC_SPACE;

CREATE TABLE COLLECT_OBJECT_LIST
(
		  DATAID VARCHAR(64) , 
                  OBJECT_TYPE VARCHAR(20) ,
		  OBJECT_NAME VARCHAR(128)
) TABLESPACE SOC_SPACE;

CREATE TABLE BROCADE_COLLECT
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6),
	CLASS3_DISCARDS DECIMAL(26,6),
	INVALID_CRC DECIMAL(26,6),
	INVALID_TX_WORDS DECIMAL(26,6),
	LINK_FAILURES DECIMAL(26,6),
	LOSS_OF_SIGNAL DECIMAL(26,6),
	LOSS_OF_SYNCHRONIZATION DECIMAL(26,6),
	NUMBER_LINK_RESETS DECIMAL(26,6),
	NUMBER_OFFLINE_SEQUENCES DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE BROCADE_COLLECT_DAY
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6),
	CLASS3_DISCARDS DECIMAL(26,6),
	INVALID_CRC DECIMAL(26,6),
	INVALID_TX_WORDS DECIMAL(26,6),
	LINK_FAILURES DECIMAL(26,6),
	LOSS_OF_SIGNAL DECIMAL(26,6),
	LOSS_OF_SYNCHRONIZATION DECIMAL(26,6),
	NUMBER_LINK_RESETS DECIMAL(26,6),
	NUMBER_OFFLINE_SEQUENCES DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE BROCADE_COLLECT_HOUR
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6),
	CLASS3_DISCARDS DECIMAL(26,6),
	INVALID_CRC DECIMAL(26,6),
	INVALID_TX_WORDS DECIMAL(26,6),
	LINK_FAILURES DECIMAL(26,6),
	LOSS_OF_SIGNAL DECIMAL(26,6),
	LOSS_OF_SYNCHRONIZATION DECIMAL(26,6),
	NUMBER_LINK_RESETS DECIMAL(26,6),
	NUMBER_OFFLINE_SEQUENCES DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE BROCADE_COLLECT_TEMP
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6),
	CLASS3_DISCARDS DECIMAL(26,6),
	INVALID_CRC DECIMAL(26,6),
	INVALID_TX_WORDS DECIMAL(26,6),
	LINK_FAILURES DECIMAL(26,6),
	LOSS_OF_SIGNAL DECIMAL(26,6),
	LOSS_OF_SYNCHRONIZATION DECIMAL(26,6),
	NUMBER_LINK_RESETS DECIMAL(26,6),
	NUMBER_OFFLINE_SEQUENCES DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE BROCADE_TEMP
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	SPEED INTEGER,
	STAT_WTX DECIMAL(26,6),
	STAT_WRX DECIMAL(26,6),
	STAT_FTX DECIMAL(26,6),
	STAT_FRX DECIMAL(26,6),
	STAT_C2_FRX DECIMAL(26,6),
	STAT_C3_FRX DECIMAL(26,6),
	STAT_LC_RX DECIMAL(26,6),
	STAT_MC_RX DECIMAL(26,6),
	STAT_MC_TO DECIMAL(26,6),
	STAT_MC_TX DECIMAL(26,6),
	TIM_RDY_PRI DECIMAL(26,6),
	TIM_TXCRD_Z DECIMAL(26,6),
	ER_ENC_IN DECIMAL(26,6),
	ER_CRC DECIMAL(26,6),
	ER_TRUNC DECIMAL(26,6),
	ER_TOOLONG DECIMAL(26,6),
	ER_BAD_EOF DECIMAL(26,6),
	ER_ENC_OUT DECIMAL(26,6),
	ER_BAD_OS DECIMAL(26,6),
	ER_C3_TIMEOUT DECIMAL(26,6),
	ER_C3_DEST_UNREACH DECIMAL(26,6),
	ER_OTHER_DISCARD DECIMAL(26,6),
	ER_ZONE_DISCARD DECIMAL(26,6),
	ER_CRC_GOOD_EOF DECIMAL(26,6),
	ER_INV_ARB DECIMAL(26,6),
	OPEN DECIMAL(26,6),
	TRANSFER DECIMAL(26,6),
	OPENED DECIMAL(26,6),
	STARVE_STOP DECIMAL(26,6),
	FL_TENANCY DECIMAL(26,6),
	NL_TENANCY DECIMAL(26,6),
	ZERO_TENANCY DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE MCDATA_COLLECT
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE MCDATA_COLLECT_DAY
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE MCDATA_COLLECT_HOUR
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE MCDATA_COLLECT_TEMP
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	KBYTES_TRANSMITTED_PER_SEC DECIMAL(26,6),
	KBYTES_RECEIVED_PER_SEC DECIMAL(26,6),
	TRANSMITTED_FRAMES_PER_SEC DECIMAL(26,6),
	RECEIVED_FRAMES_PER_SEC DECIMAL(26,6),
	TRANSMIT_LINK_UTILIZATION DECIMAL(26,6),
	RECEIVE_LINK_UTILIZATION DECIMAL(26,6)
) TABLESPACE SOC_SPACE;


CREATE TABLE MCDATA_TEMP
(
	DATAID VARCHAR(64) NOT NULL,
	PORT VARCHAR(10) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RX DECIMAL(5,2),
	TX DECIMAL(5,2),
	RX_FRAMES DECIMAL(26,6),
	RX_FRAMES_WRAP INTEGER,
	TX_FRAMES DECIMAL(26,6),
	TX_FRAMES_WRAP INTEGER,
	RX_WORDS DECIMAL(26,6),
	RX_WORDS_WRAP INTEGER,
	TX_WORDS DECIMAL(26,6),
	TX_WORDS_WRAP INTEGER
) TABLESPACE SOC_SPACE;


CREATE TABLE MONITOROBJECT
(
	MOID INTEGER NOT NULL,
	MONAME VARCHAR(64),
	IP VARCHAR(32),
	MOCREATETIME VARCHAR(16),
	MTSYSCODING VARCHAR(32),
	DELETEFLAG VARCHAR(2),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MOID)
) TABLESPACE SOC_SPACE;


CREATE TABLE MONITOROBJECTDEF
(
	MODID INTEGER NOT NULL,
	MOID INTEGER,
	MODCREATETIME VARCHAR(16),
	MODNAME VARCHAR(32),
	MODVALUE VARCHAR(32),
	ORDERNUMBER INTEGER,
	DELETEFLAG VARCHAR(2),
	MODDES VARCHAR(256),
	COMPARE VARCHAR(2),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MODID)
) TABLESPACE SOC_SPACE;


CREATE TABLE MONITORTYPE
(
	MTID INTEGER NOT NULL,
	MTNAME VARCHAR(32),
	MTCREATETIME VARCHAR(16),
	MTSYSCODING VARCHAR(32),
	DELETEFLAG VARCHAR(2),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MTID)
) TABLESPACE SOC_SPACE;


CREATE TABLE MONITORTYPEDEF
(
	MTDID INTEGER NOT NULL,
	MTID INTEGER,
	MTDNAME VARCHAR(32),
	MTDVALUE VARCHAR(32),
	MTDCREATETIME VARCHAR(16),
	ORDERNUMBER INTEGER,
	DELETEFLAG VARCHAR(2),
	MTDDES VARCHAR(256),
	COMPARE VARCHAR(2),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MTDID)
) TABLESPACE SOC_SPACE;


create view monitorObjectDefVW as
select mod.modid,mo.moname,mt.mtname,mt.mtsyscoding,mod.modcreatetime,
mod.modname,mod.modvalue,mod.ordernumber,mod.deleteflag,mod.compare,mod.moddes 
from monitorobject mo,monitorobjectdef mod,monitortype mt 
where mo.moid=mod.moid and mo.mtsyscoding=mt.mtsyscoding;


CREATE TABLE COLLECT_SYMMETRIX_MONITOR
(
	ID INTEGER NOT NULL,
	SAVETIME VARCHAR(16) NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL,
	TIMESTAMP VARCHAR(20) NOT NULL,
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	HITS_READ_PER_SEC DECIMAL(26,6),
	HITS_WRITTEN_PER_SEC DECIMAL(26,6),
	SEQ_READ_PER_SEC DECIMAL(26,6),
	SEQ_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	FINGERPRINT VARCHAR(256)
) TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_SYMMETRIX_MONITOR_DAY
(
	SAVETIME VARCHAR(16) NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL,
	TIMESTAMP VARCHAR(20) NOT NULL,
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	HITS_READ_PER_SEC DECIMAL(26,6),
	HITS_WRITTEN_PER_SEC DECIMAL(26,6),
	SEQ_READ_PER_SEC DECIMAL(26,6),
	SEQ_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	FINGERPRINT VARCHAR(256)
) TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_SYMMETRIX_MONITOR_HOUR
(
	SAVETIME VARCHAR(16) NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL,
	TIMESTAMP VARCHAR(20) NOT NULL,
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	HITS_READ_PER_SEC DECIMAL(26,6),
	HITS_WRITTEN_PER_SEC DECIMAL(26,6),
	SEQ_READ_PER_SEC DECIMAL(26,6),
	SEQ_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	FINGERPRINT VARCHAR(256)
) TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_SYMMETRIX_MONITOR_TEMP
(
	ID INTEGER NOT NULL,
	SAVETIME VARCHAR(16) NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL,
	TIMESTAMP VARCHAR(20) NOT NULL,
	READS_PER_SEC DECIMAL(26,6),
	WRITES_PER_SEC DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6),
	HITS_READ_PER_SEC DECIMAL(26,6),
	HITS_WRITTEN_PER_SEC DECIMAL(26,6),
	SEQ_READ_PER_SEC DECIMAL(26,6),
	SEQ_WRITTEN_PER_SEC DECIMAL(26,6),
	NUMBER_WRITE_PENDING_TRACKS DECIMAL(26,6),
	FINGERPRINT VARCHAR(256)
) TABLESPACE SOC_SPACE;


CREATE TABLE COLLECT_FILE_LIST 
(
	FILEID INTEGER  NOT NULL, 
	FILENAME VARCHAR (128),  
	PRIMARY KEY ( FILEID)
) TABLESPACE SOC_SPACE;


CREATE VIEW DEVICES AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM COLLECT_DEVICES
);



CREATE VIEW DIRECTORS_FE AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  COLLECT_DIRECTORS_FE
);


CREATE VIEW DIRECTORS_RDF AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIRECTORS_RDF
);	

CREATE  VIEW DISKS AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,
WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM COLLECT_DISKS
);	


CREATE VIEW DIRECTORS_DA AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM COLLECT_DIRECTORS_DA
);

CREATE  VIEW PORTS_FE AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM COLLECT_PORTS_FE
);


CREATE  VIEW RDFA_STATUS AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,
R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM COLLECT_RDFA_STATUS
);


CREATE  VIEW RDF_DIRECTOR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_DIRECTOR
);

CREATE  VIEW RDF_GROUP AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_GROUP
);

CREATE  VIEW RDF_LINK AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_LINK
);


CREATE VIEW SYSTEM AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,
NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM COLLECT_SYSTEM
);






CREATE VIEW DIR_ESCON AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM COLLECT_DIR_ESCON
);
	

CREATE VIEW DIR_RA1 AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA1
);

CREATE VIEW DIR_RA2 AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA2
);	

CREATE VIEW DIR_SA AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SA
);

CREATE VIEW DIR_SE AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SE
);


CREATE VIEW DEVICES_DAY AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM COLLECT_DEVICES_DAY
);



CREATE VIEW DIRECTORS_FE_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  COLLECT_DIRECTORS_FE_DAY
);


CREATE VIEW DIRECTORS_RDF_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIRECTORS_RDF_DAY
);	

CREATE  VIEW DISKS_DAY AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM COLLECT_DISKS_DAY
);	


CREATE VIEW DIRECTORS_DA_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM COLLECT_DIRECTORS_DA_DAY
);

CREATE  VIEW PORTS_FE_DAY AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM COLLECT_PORTS_FE_DAY
);


CREATE  VIEW RDFA_STATUS_DAY AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM COLLECT_RDFA_STATUS_DAY
);


CREATE  VIEW RDF_DIRECTOR_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_DIRECTOR_DAY
);

CREATE  VIEW RDF_GROUP_DAY AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_GROUP_DAY
);

CREATE  VIEW RDF_LINK_DAY AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_LINK_DAY
);


CREATE VIEW SYSTEM_DAY AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM COLLECT_SYSTEM_DAY
);


CREATE VIEW DIR_ESCON_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM COLLECT_DIR_ESCON_DAY
);
	

CREATE VIEW DIR_RA1_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA1_DAY
);

CREATE VIEW DIR_RA2_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA2_DAY
);	

CREATE VIEW DIR_SA_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SA_DAY
);

CREATE VIEW DIR_SE_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SE_DAY
);

create view DIRECTORS_FE_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
from COLLECT_DIRECTORS_FE_DAY;

create view DIRECTORS_RDF_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
from COLLECT_DIRECTORS_RDF_DAY;

create view DIRECTORS_DA_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
from COLLECT_DIRECTORS_DA_DAY;

create view DISKS_DAY_Performance as 
select dataid,max_data_times as data_times,device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
from COLLECT_DISKS_DAY;

CREATE VIEW DEVICES_HOUR AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM COLLECT_DEVICES_HOUR
);



CREATE VIEW DIRECTORS_FE_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  COLLECT_DIRECTORS_FE_HOUR
);


CREATE VIEW DIRECTORS_RDF_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIRECTORS_RDF_HOUR
);	

CREATE  VIEW DISKS_HOUR AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM COLLECT_DISKS_HOUR
);	


CREATE VIEW DIRECTORS_DA_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM COLLECT_DIRECTORS_DA_HOUR
);

CREATE  VIEW PORTS_FE_HOUR AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM COLLECT_PORTS_FE_HOUR
);


CREATE  VIEW RDFA_STATUS_HOUR AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM COLLECT_RDFA_STATUS_HOUR
);


CREATE  VIEW RDF_DIRECTOR_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_DIRECTOR_HOUR
);

CREATE  VIEW RDF_GROUP_HOUR AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_GROUP_HOUR
);

CREATE  VIEW RDF_LINK_HOUR AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM COLLECT_RDF_LINK_HOUR
);


CREATE VIEW SYSTEM_HOUR AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM COLLECT_SYSTEM_HOUR
);






CREATE VIEW DIR_ESCON_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM COLLECT_DIR_ESCON_HOUR
);
	

CREATE VIEW DIR_RA1_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA1_HOUR
);

CREATE VIEW DIR_RA2_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM COLLECT_DIR_RA2_HOUR
);	

CREATE VIEW DIR_SA_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SA_HOUR
);

CREATE VIEW DIR_SE_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM COLLECT_DIR_SE_HOUR
);


CREATE INDEX igadmin.DEVICE_ALL ON igadmin.COLLECT_DEVICES(DATAID ASC,DEVICE_NAME ASC,DATA_TIMES ASC,TOTAL_IOS_PER_SEC ASC,WRITE_PENDING_COUNT ASC);

CREATE  INDEX igadmin.DIR_DA_DATAID ON igadmin.COLLECT_DIRECTORS_DA (DATAID ASC);
CREATE  INDEX igadmin.DIR_DA_datatimes ON igadmin.COLLECT_DIRECTORS_DA (data_times ASC);
CREATE  INDEX igadmin.DIR_DA_NAME ON igadmin.COLLECT_DIRECTORS_DA (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_FIBRE_DATAID ON igadmin.COLLECT_DIRECTORS_FE (DATAID ASC);
CREATE  INDEX igadmin.DIR_FIBRE_datatimes ON igadmin.COLLECT_DIRECTORS_FE (data_times ASC);
CREATE  INDEX igadmin.DIR_FIBRE_NAME ON igadmin.COLLECT_DIRECTORS_FE (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_RFB_DATAID ON igadmin.COLLECT_DIRECTORS_RDF (DATAID ASC);
CREATE  INDEX igadmin.DIR_RFB_datatimes ON igadmin.COLLECT_DIRECTORS_RDF (data_times ASC);
CREATE  INDEX igadmin.DIR_RFB_NAME ON igadmin.COLLECT_DIRECTORS_RDF (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DISKS_DATAID ON igadmin.COLLECT_DISKS (DATAID ASC);
CREATE  INDEX igadmin.DISKS_datatimes ON igadmin.COLLECT_DISKS (data_times ASC);
CREATE  INDEX igadmin.DISKS_NAME ON igadmin.COLLECT_DISKS (DEVICE_NAME ASC);

CREATE  INDEX igadmin.PORTS_FE_DATAID ON igadmin.COLLECT_PORTS_FE (DATAID ASC);
CREATE  INDEX igadmin.PORTS_FE_datatimes ON igadmin.COLLECT_PORTS_FE (data_times ASC);
CREATE  INDEX igadmin.PORTS_FE_NAME ON igadmin.COLLECT_PORTS_FE (PORT_NAME ASC);

CREATE  INDEX igadmin.RDFA_DATAID ON igadmin.COLLECT_RDFA_STATUS (DATAID ASC);
CREATE  INDEX igadmin.RDFA_datatimes ON igadmin.COLLECT_RDFA_STATUS (data_times ASC);
CREATE  INDEX igadmin.RDFA_NAME ON igadmin.COLLECT_RDFA_STATUS (RA_GROUP_NUMBER ASC);

CREATE  INDEX igadmin.RDF_DATAID ON igadmin.COLLECT_RDF_DIRECTOR (DATAID ASC);
CREATE  INDEX igadmin.RDF_datatimes ON igadmin.COLLECT_RDF_DIRECTOR (data_times ASC);
CREATE  INDEX igadmin.RDF_NAME ON igadmin.COLLECT_RDF_DIRECTOR (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.RDF_GROUP_DATAID ON igadmin.COLLECT_RDF_GROUP (DATAID ASC);
CREATE  INDEX igadmin.RDF_GROUP_datatimes ON igadmin.COLLECT_RDF_GROUP (data_times ASC);
CREATE  INDEX igadmin.RDF_GROUP_NAME ON igadmin.COLLECT_RDF_GROUP (RDF_GROUP ASC);

CREATE  INDEX igadmin.RDF_LINK_DATAID ON igadmin.COLLECT_RDF_LINK (DATAID ASC);
CREATE  INDEX igadmin.RDF_LINK_datatimes ON igadmin.COLLECT_RDF_LINK (data_times ASC);
CREATE  INDEX igadmin.RDF_LINK_NAME ON igadmin.COLLECT_RDF_LINK (LINK_NUMBER ASC);

CREATE  INDEX igadmin.System_DATAID ON igadmin.COLLECT_SYSTEM (DATAID ASC);
CREATE  INDEX igadmin.System_datatimes ON igadmin.COLLECT_SYSTEM (data_times ASC);
CREATE  INDEX igadmin.System_symid ON igadmin.COLLECT_SYSTEM (symid ASC);

CREATE  INDEX igadmin.DIR_ESCON_DATAID ON igadmin.COLLECT_DIR_ESCON (DATAID ASC);
CREATE  INDEX igadmin.DIR_ESCON_datatimes ON igadmin.COLLECT_DIR_ESCON (data_times ASC);
CREATE  INDEX igadmin.DIR_ESCON_NAME ON igadmin.COLLECT_DIR_ESCON (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_RA1_DATAID ON igadmin.COLLECT_DIR_RA1 (DATAID ASC);
CREATE  INDEX igadmin.DIR_RA1_datatimes ON igadmin.COLLECT_DIR_RA1 (data_times ASC);
CREATE  INDEX igadmin.DIR_RA1_NAME ON igadmin.COLLECT_DIR_RA1 (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_RA2_DATAID ON igadmin.COLLECT_DIR_RA2 (DATAID ASC);
CREATE  INDEX igadmin.DIR_RA2_datatimes ON igadmin.COLLECT_DIR_RA2 (data_times ASC);
CREATE  INDEX igadmin.DIR_RA2_NAME ON igadmin.COLLECT_DIR_RA2 (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_SA_DATAID ON igadmin.COLLECT_DIR_SA (DATAID ASC);
CREATE  INDEX igadmin.DIR_SA_datatimes ON igadmin.COLLECT_DIR_SA (data_times ASC);
CREATE  INDEX igadmin.DIR_SA_NAME ON igadmin.COLLECT_DIR_SA (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.DIR_SE_DATAID ON igadmin.COLLECT_DIR_SE (DATAID ASC);
CREATE  INDEX igadmin.DIR_SE_datatimes ON igadmin.COLLECT_DIR_SE (data_times ASC);
CREATE  INDEX igadmin.DIR_SE_NAME ON igadmin.COLLECT_DIR_SE (DIRECTOR_NUMBER ASC);

CREATE  INDEX igadmin.Symmetrix_RT ON igadmin.COLLECT_SYMMETRIX_MONITOR_RT (SAVETIME DESC,SYMM_ID DESC);


ALTER TABLE CX_COLLECT_DISK_DAY
 ADD AVGTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD SUMTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MAXTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MINTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;

ALTER TABLE CX_COLLECT_DISK_HOUR
 ADD AVGTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD SUMTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MAXTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MINTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;


ALTER TABLE CX_COLLECT_SP_DAY
 ADD AVGTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD SUMTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MAXTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MINTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGQUEUE_LENGTH DECIMAL (26, 6)
 ADD SUMQUEUE_LENGTH DECIMAL (26, 6)
 ADD MAXQUEUE_LENGTH DECIMAL (26, 6)
 ADD MINQUEUE_LENGTH DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;

ALTER TABLE CX_COLLECT_SP_HOUR
 ADD AVGTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD SUMTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MAXTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD MINTOTAL_THROUGHPUT DECIMAL (26, 6)
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGQUEUE_LENGTH DECIMAL (26, 6)
 ADD SUMQUEUE_LENGTH DECIMAL (26, 6)
 ADD MAXQUEUE_LENGTH DECIMAL (26, 6)
 ADD MINQUEUE_LENGTH DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;

 
 ALTER TABLE CX_COLLECT_LUN_DAY
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGQUEUE_LENGTH DECIMAL (26, 6)
 ADD SUMQUEUE_LENGTH DECIMAL (26, 6)
 ADD MAXQUEUE_LENGTH DECIMAL (26, 6)
 ADD MINQUEUE_LENGTH DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;

ALTER TABLE CX_COLLECT_LUN_HOUR
 ADD AVGRESPONSE_TIME DECIMAL (26, 6)
 ADD SUMRESPONSE_TIME DECIMAL (26, 6)
 ADD MAXRESPONSE_TIME DECIMAL (26, 6)
 ADD MINRESPONSE_TIME DECIMAL (26, 6)
 ADD AVGQUEUE_LENGTH DECIMAL (26, 6)
 ADD SUMQUEUE_LENGTH DECIMAL (26, 6)
 ADD MAXQUEUE_LENGTH DECIMAL (26, 6)
 ADD MINQUEUE_LENGTH DECIMAL (26, 6)
 ADD AVGUTILIZATION DECIMAL (26, 6)
 ADD SUMUTILIZATION DECIMAL (26, 6)
 ADD MAXUTILIZATION DECIMAL (26, 6)
 ADD MINUTILIZATION DECIMAL (26, 6) ;


------------------------------IBM---------------------------------------

ALTER TABLE PORT_LEVEL_DAY
 ADD AVGAVG_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_RESP_TIME DECIMAL (26, 6)
 ADD AVGDATA_RATE DECIMAL (26, 6)
 ADD SUMDATA_RATE DECIMAL (26, 6)
 ADD MAXDATA_RATE DECIMAL (26, 6)
 ADD MINDATA_RATE DECIMAL (26, 6)
 ADD AVGIO_RATE DECIMAL (26, 6)
 ADD SUMIO_RATE DECIMAL (26, 6)
 ADD MAXIO_RATE DECIMAL (26, 6)
 ADD MINIO_RATE DECIMAL (26, 6) ;

ALTER TABLE PORT_LEVEL_HOUR
 ADD AVGAVG_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_RESP_TIME DECIMAL (26, 6)
 ADD AVGDATA_RATE DECIMAL (26, 6)
 ADD SUMDATA_RATE DECIMAL (26, 6)
 ADD MAXDATA_RATE DECIMAL (26, 6)
 ADD MINDATA_RATE DECIMAL (26, 6)
 ADD AVGIO_RATE DECIMAL (26, 6)
 ADD SUMIO_RATE DECIMAL (26, 6)
 ADD MAXIO_RATE DECIMAL (26, 6)
 ADD MINIO_RATE DECIMAL (26, 6) ;


ALTER TABLE RANK_LEVEL_DAY
 ADD AVGREAD_IO_RATE DECIMAL (26, 6)
 ADD SUMREAD_IO_RATE DECIMAL (26, 6)
 ADD MAXREAD_IO_RATE DECIMAL (26, 6)
 ADD MINREAD_IO_RATE DECIMAL (26, 6)
 ADD AVGWRITE_IO_RATE DECIMAL (26, 6)
 ADD SUMWRITE_IO_RATE DECIMAL (26, 6)
 ADD MAXWRITE_IO_RATE DECIMAL (26, 6)
 ADD MINWRITE_IO_RATE DECIMAL (26, 6)
 ADD AVGAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD AVGAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD AVGREAD_DATA_RATE DECIMAL (26, 6)
 ADD SUMREAD_DATA_RATE DECIMAL (26, 6)
 ADD MAXREAD_DATA_RATE DECIMAL (26, 6)
 ADD MINREAD_DATA_RATE DECIMAL (26, 6)
 ADD AVGWRITE_DATA_RATE DECIMAL (26, 6)
 ADD SUMWRITE_DATA_RATE DECIMAL (26, 6)
 ADD MAXWRITE_DATA_RATE DECIMAL (26, 6)
 ADD MINWRITE_DATA_RATE DECIMAL (26, 6);

ALTER TABLE RANK_LEVEL_HOUR
 ADD AVGREAD_IO_RATE DECIMAL (26, 6)
 ADD SUMREAD_IO_RATE DECIMAL (26, 6)
 ADD MAXREAD_IO_RATE DECIMAL (26, 6)
 ADD MINREAD_IO_RATE DECIMAL (26, 6)
 ADD AVGWRITE_IO_RATE DECIMAL (26, 6)
 ADD SUMWRITE_IO_RATE DECIMAL (26, 6)
 ADD MAXWRITE_IO_RATE DECIMAL (26, 6)
 ADD MINWRITE_IO_RATE DECIMAL (26, 6)
 ADD AVGAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_READ_RESP_TIME DECIMAL (26, 6)
 ADD AVGAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD SUMAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD MAXAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD MINAVG_WRITE_RESP_TIME DECIMAL (26, 6)
 ADD AVGREAD_DATA_RATE DECIMAL (26, 6)
 ADD SUMREAD_DATA_RATE DECIMAL (26, 6)
 ADD MAXREAD_DATA_RATE DECIMAL (26, 6)
 ADD MINREAD_DATA_RATE DECIMAL (26, 6)
 ADD AVGWRITE_DATA_RATE DECIMAL (26, 6)
 ADD SUMWRITE_DATA_RATE DECIMAL (26, 6)
 ADD MAXWRITE_DATA_RATE DECIMAL (26, 6)
 ADD MINWRITE_DATA_RATE DECIMAL (26, 6);


ALTER TABLE VOLUME_LEVEL_DAY
 ADD AVGDATA_RATE DECIMAL (26, 6)
 ADD SUMDATA_RATE DECIMAL (26, 6)
 ADD MAXDATA_RATE DECIMAL (26, 6)
 ADD MINDATA_RATE DECIMAL (26, 6)
 ADD AVGIO_RATE DECIMAL (26, 6)
 ADD SUMIO_RATE DECIMAL (26, 6)
 ADD MAXIO_RATE DECIMAL (26, 6)
 ADD MINIO_RATE DECIMAL (26, 6)
 ADD AVGTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD SUMTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD MAXTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD MINTOTAL_HIT_PERC DECIMAL (26, 6);

ALTER TABLE VOLUME_LEVEL_HOUR
 ADD AVGDATA_RATE DECIMAL (26, 6)
 ADD SUMDATA_RATE DECIMAL (26, 6)
 ADD MAXDATA_RATE DECIMAL (26, 6)
 ADD MINDATA_RATE DECIMAL (26, 6)
 ADD AVGIO_RATE DECIMAL (26, 6)
 ADD SUMIO_RATE DECIMAL (26, 6)
 ADD MAXIO_RATE DECIMAL (26, 6)
 ADD MINIO_RATE DECIMAL (26, 6)
 ADD AVGTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD SUMTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD MAXTOTAL_HIT_PERC DECIMAL (26, 6)
 ADD MINTOTAL_HIT_PERC DECIMAL (26, 6);


------------------------------DMX---------------------------------------

ALTER TABLE COLLECT_DIRECTORS_DA_DAY
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);

ALTER TABLE COLLECT_DIRECTORS_DA_HOUR
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);


ALTER TABLE COLLECT_DEVICES_DAY
 ADD AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD AVGWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD SUMWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD MAXWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD MINWRITE_PENDING_COUNT DECIMAL (26, 6);

ALTER TABLE COLLECT_DEVICES_HOUR
 ADD AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD AVGWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD SUMWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD MAXWRITE_PENDING_COUNT DECIMAL (26, 6)
 ADD MINWRITE_PENDING_COUNT DECIMAL (26, 6);


ALTER TABLE COLLECT_RDF_DIRECTOR_DAY
 ADD AVGKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);

ALTER TABLE COLLECT_RDF_DIRECTOR_HOUR
 ADD AVGKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_READ_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);


ALTER TABLE COLLECT_DISKS_DAY
 ADD AVGDISK_BUSY DECIMAL (26, 6)
 ADD SUMDISK_BUSY DECIMAL (26, 6)
 ADD MAXDISK_BUSY DECIMAL (26, 6)
 ADD MINDISK_BUSY DECIMAL (26, 6)
 ADD AVGTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);

ALTER TABLE COLLECT_DISKS_HOUR
 ADD AVGDISK_BUSY DECIMAL (26, 6)
 ADD SUMDISK_BUSY DECIMAL (26, 6)
 ADD MAXDISK_BUSY DECIMAL (26, 6)
 ADD MINDISK_BUSY DECIMAL (26, 6)
 ADD AVGTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);


ALTER TABLE COLLECT_DIRECTORS_FE_DAY
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);


ALTER TABLE COLLECT_DIRECTORS_FE_HOUR
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);


ALTER TABLE COLLECT_PORTS_FE_DAY
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD AVG_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD SUM_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD MAX_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD MIN_IN_KBYTES_PER_SEC DECIMAL (26, 6);

ALTER TABLE COLLECT_PORTS_FE_HOUR
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD AVG_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD SUM_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD MAX_IN_KBYTES_PER_SEC DECIMAL (26, 6)
 ADD MIN_IN_KBYTES_PER_SEC DECIMAL (26, 6);


ALTER TABLE COLLECT_DIRECTORS_RDF_DAY
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD AVGLINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMLINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXLINK_UTILIZATION DECIMAL (26, 6)
 ADD MINLINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);

ALTER TABLE COLLECT_DIRECTORS_RDF_HOUR
 ADD AVGIOS_PER_SEC DECIMAL (26, 6)
 ADD SUMIOS_PER_SEC DECIMAL (26, 6)
 ADD MAXIOS_PER_SEC DECIMAL (26, 6)
 ADD MINIOS_PER_SEC DECIMAL (26, 6)
 ADD AVGLINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMLINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXLINK_UTILIZATION DECIMAL (26, 6)
 ADD MINLINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMBUSY DECIMAL (26, 6)
 ADD MINBUSY DECIMAL (26, 6);


ALTER TABLE COLLECT_SYSTEM_DAY
 ADD AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD AVGREADS DECIMAL (26, 6)
 ADD SUMREADS DECIMAL (26, 6)
 ADD MAXREADS DECIMAL (26, 6)
 ADD MINREADS DECIMAL (26, 6)
 ADD AVGWRITES DECIMAL (26, 6)
 ADD SUMWRITES DECIMAL (26, 6)
 ADD MAXWRITES DECIMAL (26, 6)
 ADD MINWRITES DECIMAL (26, 6)
 ADD AVGHIT DECIMAL (26, 6)
 ADD SUMHIT DECIMAL (26, 6)
 ADD MAXHIT DECIMAL (26, 6)
 ADD MINHIT DECIMAL (26, 6);

ALTER TABLE COLLECT_SYSTEM_HOUR
 ADD AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD MINTOTAL_IOS_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6)
 ADD AVGREADS DECIMAL (26, 6)
 ADD SUMREADS DECIMAL (26, 6)
 ADD MAXREADS DECIMAL (26, 6)
 ADD MINREADS DECIMAL (26, 6)
 ADD AVGWRITES DECIMAL (26, 6)
 ADD SUMWRITES DECIMAL (26, 6)
 ADD MAXWRITES DECIMAL (26, 6)
 ADD MINWRITES DECIMAL (26, 6)
 ADD AVGHIT DECIMAL (26, 6)
 ADD SUMHIT DECIMAL (26, 6)
 ADD MAXHIT DECIMAL (26, 6)
 ADD MINHIT DECIMAL (26, 6);


------------------------------brocade---------------------------------------

ALTER TABLE COLLECT_SYMMETRIX_MONITOR_DAY
 ADD AVGREADS_PER_SEC DECIMAL (26, 6)
 ADD SUMREADS_PER_SEC DECIMAL (26, 6)
 ADD MAXREADS_PER_SEC DECIMAL (26, 6)
 ADD MINREADS_PER_SEC DECIMAL (26, 6)
 ADD AVGWRITES_PER_SEC DECIMAL (26, 6)
 ADD SUMWRITES_PER_SEC DECIMAL (26, 6)
 ADD MAXWRITES_PER_SEC DECIMAL (26, 6)
 ADD MINWRITES_PER_SEC DECIMAL (26, 6);

ALTER TABLE COLLECT_SYMMETRIX_MONITOR_HOUR
 ADD AVGREADS_PER_SEC DECIMAL (26, 6)
 ADD SUMREADS_PER_SEC DECIMAL (26, 6)
 ADD MAXREADS_PER_SEC DECIMAL (26, 6)
 ADD MINREADS_PER_SEC DECIMAL (26, 6)
 ADD AVGWRITES_PER_SEC DECIMAL (26, 6)
 ADD SUMWRITES_PER_SEC DECIMAL (26, 6)
 ADD MAXWRITES_PER_SEC DECIMAL (26, 6)
 ADD MINWRITES_PER_SEC DECIMAL (26, 6);


ALTER TABLE BROCADE_COLLECT_DAY
 ADD AVGCLASS3_DISCARDS DECIMAL (26, 6)
 ADD SUMCLASS3_DISCARDS DECIMAL (26, 6)
 ADD MAXCLASS3_DISCARDS DECIMAL (26, 6)
 ADD MINCLASS3_DISCARDS DECIMAL (26, 6)
 ADD AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);

ALTER TABLE BROCADE_COLLECT_HOUR
 ADD AVGCLASS3_DISCARDS DECIMAL (26, 6)
 ADD SUMCLASS3_DISCARDS DECIMAL (26, 6)
 ADD MAXCLASS3_DISCARDS DECIMAL (26, 6)
 ADD MINCLASS3_DISCARDS DECIMAL (26, 6)
 ADD AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);


------------------------------mcdata---------------------------------------

ALTER TABLE MCDATA_COLLECT_DAY
 ADD AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);

ALTER TABLE MCDATA_COLLECT_HOUR
 ADD AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6)
 ADD AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6)
 ADD AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6)
 ADD MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);