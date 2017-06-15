CREATE TABLE CST.CX_COLLECT_SP_TEMP
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

CREATE TABLE CST.CX_COLLECT_LUN_TEMP
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

CREATE TABLE CST.CX_COLLECT_Disk_TEMP
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

CREATE TABLE CST.CX_COLLECT_Raid_Group_TEMP
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

CREATE TABLE CST.CX_COLLECT_Port_TEMP
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

CREATE TABLE CST.CX_COLLECT_SP
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

CREATE TABLE CST.CX_COLLECT_LUN
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

CREATE TABLE CST.CX_COLLECT_Disk
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

CREATE TABLE CST.CX_COLLECT_Raid_Group
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

CREATE TABLE CST.CX_COLLECT_Port
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

CREATE TABLE CST. CX_COLLECT_SP_HOUR
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

CREATE TABLE CST. CX_COLLECT_LUN_HOUR
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

CREATE TABLE CST. CX_COLLECT_Disk_HOUR
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

CREATE TABLE CST. CX_COLLECT_Raid_Group_HOUR
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

CREATE TABLE CST. CX_COLLECT_Port_HOUR
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

CREATE TABLE CST. CX_COLLECT_SP_DAY
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

CREATE TABLE CST. CX_COLLECT_LUN_DAY
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

CREATE TABLE CST. CX_COLLECT_Disk_DAY
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

CREATE TABLE CST. CX_COLLECT_Raid_Group_DAY
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

CREATE TABLE CST. CX_COLLECT_Port_DAY
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

CREATE TABLE CST.CX_COLLECT_Enclosure_DISKS
(
	DATAID VARCHAR(20) ,
	Object_NAME VARCHAR(15)

)TABLESPACE SOC_SPACE;

CREATE TABLE CST.CX_COLLECT_Port_Num
(
	DATAID VARCHAR(20) ,
	Object_NAME VARCHAR(15)

)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DEVICES
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

CREATE TABLE CST.COLLECT_DIRECTORS_DA
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	INTERVAL_TIME DECIMAL(26,6),
	ACCUMULATED_DIRECTOR_IDLE_TIME DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIRECTORS_FE
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

CREATE TABLE CST.COLLECT_DIRECTORS_RDF
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

CREATE TABLE CST.COLLECT_DISKS
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

CREATE TABLE CST.COLLECT_PORTS_FE
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDFA_STATUS
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

CREATE TABLE CST.COLLECT_RDF_DIRECTOR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_GROUP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_LINK
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_SYSTEM
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

CREATE TABLE CST.COLLECT_DIR_ESCON
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
) TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIR_RA1
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

CREATE TABLE CST.COLLECT_DIR_RA2
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

CREATE TABLE CST.COLLECT_DIR_SA
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIR_SE
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DEVICES_TEMP
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

CREATE TABLE CST.COLLECT_DIRECTORS_DA_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	BUSY DECIMAL(26,6),
	interval_time DECIMAL(26,6),
	accumulated_director_idle_time DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIRECTORS_FE_TEMP
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

CREATE TABLE CST.COLLECT_DIRECTORS_RDF_TEMP
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

CREATE TABLE CST.COLLECT_DISKS_TEMP
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

CREATE TABLE CST.COLLECT_PORTS_FE_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.COLLECT_RDFA_STATUS_TEMP
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

CREATE TABLE CST.COLLECT_RDF_DIRECTOR_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_GROUP_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_LINK_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.COLLECT_SYSTEM_TEMP
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

CREATE TABLE CST.COLLECT_DIR_ESCON_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIR_RA1_TEMP
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
CREATE TABLE CST.COLLECT_DIR_RA2_TEMP
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

CREATE TABLE CST.COLLECT_DIR_SA_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIR_SE_TEMP
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_DEVICES_DAY
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

CREATE TABLE CST.COLLECT_PORTS_FE_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_RDFA_STATUS_DAY
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


CREATE TABLE CST.COLLECT_RDF_DIRECTOR_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_GROUP_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_RDF_LINK_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_SYSTEM_DAY
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


CREATE TABLE CST.COLLECT_DIR_ESCON_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.COLLECT_DIR_RA1_DAY
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


CREATE TABLE CST.COLLECT_DIR_RA2_DAY
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

CREATE TABLE CST.COLLECT_DIR_SA_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIR_SE_DAY
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_DIRECTORS_FE_DAY
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
CREATE TABLE CST.COLLECT_DIRECTORS_RDF_DAY
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
CREATE TABLE CST.COLLECT_DISKS_DAY
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
CREATE TABLE CST.COLLECT_DIRECTORS_DA_DAY
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


CREATE TABLE CST.COLLECT_DISKS_LIST
(
	DATAID VARCHAR(20) ,
	DEVICE_NAME VARCHAR(20)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_DEVICES_HOUR
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

CREATE TABLE CST.COLLECT_PORTS_FE_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	PORT_NAME VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6),
	THROUGHPUT_IN_KBYTES_PER_SEC DECIMAL(26,6),
	AVERAGE_REQUEST_SIZE_IN_KBYTES DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_RDFA_STATUS_HOUR
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


CREATE TABLE CST.COLLECT_RDF_DIRECTOR_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_RDF_GROUP_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	RDF_GROUP VARCHAR(15) NOT NULL,
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_RDF_LINK_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	LINK_NUMBER VARCHAR(15) NOT NULL,
	ECHO_DELAY DECIMAL(26,6),
	KBYTES_READ_PER_SEC DECIMAL(26,6),
	KBYTES_WRITTEN_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;

CREATE TABLE CST.COLLECT_SYSTEM_HOUR
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


CREATE TABLE CST.COLLECT_DIR_ESCON_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.COLLECT_DIR_RA1_HOUR
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


CREATE TABLE CST.COLLECT_DIR_RA2_HOUR
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





CREATE TABLE CST.COLLECT_DIR_SA_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_DIR_SE_HOUR
(
	DATAID VARCHAR(15) NOT NULL,
	DATA_TIMES VARCHAR(20) NOT NULL,
	DIRECTOR_NUMBER VARCHAR(15) NOT NULL,
	IOS_PER_SEC DECIMAL(26,6)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.COLLECT_DIRECTORS_FE_HOUR
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
CREATE TABLE CST.COLLECT_DIRECTORS_RDF_HOUR
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
CREATE TABLE CST.COLLECT_DISKS_HOUR
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
CREATE TABLE CST.COLLECT_DIRECTORS_DA_HOUR
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


CREATE TABLE CST.version_data_mapping
(
	id Integer NOT NULL,
	name VARCHAR(64) ,
	microcode VARCHAR(10) ,
	colName VARCHAR(64) ,
	vindex VARCHAR(4),
	type VARCHAR(10),
	PRIMARY KEY (id)
)TABLESPACE SOC_SPACE;



CREATE TABLE CST.version_label_mapping
(
	id Integer NOT NULL,
	microcode VARCHAR(10) ,
	name VARCHAR(64) ,
	label VARCHAR(64) ,
	type VARCHAR(10),
	PRIMARY KEY (id)
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_SYMMETRIX_INFO	
(
	ID INTEGER NOT NULL,
	SYMM_ID VARCHAR(64) NOT NULL, 
	SYMM_MODEL VARCHAR(20),		
	SYMM_VERSION VARCHAR(20),	
	SYMM_CACHESIZE VARCHAR(20),	
	FINGERPRINT VARCHAR(256),
	SYMM_TYPE VARCHAR(20)	
)TABLESPACE SOC_SPACE;


CREATE TABLE CST.COLLECT_SYMMETRIX_MONITOR_RT	
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

CREATE TABLE CST.COLLECT_OBJECT_LIST
(
		  DATAID VARCHAR(64) , 
                  OBJECT_TYPE VARCHAR(128) ,
		  OBJECT_NAME VARCHAR(128)
) TABLESPACE SOC_SPACE;

CREATE TABLE CST.BROCADE_COLLECT
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


CREATE TABLE CST.BROCADE_COLLECT_DAY
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


CREATE TABLE CST.BROCADE_COLLECT_HOUR
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


CREATE TABLE CST.BROCADE_COLLECT_TEMP
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


CREATE TABLE CST.BROCADE_TEMP
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


CREATE TABLE CST.MCDATA_COLLECT
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


CREATE TABLE CST.MCDATA_COLLECT_DAY
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


CREATE TABLE CST.MCDATA_COLLECT_HOUR
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


CREATE TABLE CST.MCDATA_COLLECT_TEMP
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


CREATE TABLE CST.MCDATA_TEMP
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


CREATE TABLE CST.MONITOROBJECT
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


CREATE TABLE CST.MONITOROBJECTDEF
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


CREATE TABLE CST.MONITORTYPE
(
	MTID INTEGER NOT NULL,
	MTNAME VARCHAR(32),
	MTCREATETIME VARCHAR(16),
	MTSYSCODING VARCHAR(32),
	DELETEFLAG VARCHAR(2),
	FINGERPRINT VARCHAR(256),
	PRIMARY KEY (MTID)
) TABLESPACE SOC_SPACE;


CREATE TABLE CST.MONITORTYPEDEF
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


CREATE VIEW CST.monitorObjectDefVW as
select mod.modid,mo.moname,mt.mtname,mt.mtsyscoding,mod.modcreatetime,
mod.modname,mod.modvalue,mod.ordernumber,mod.deleteflag,mod.compare,mod.moddes 
FROM  CST.monitorobject mo,CST.monitorobjectdef mod,CST.monitortype mt 
where mo.moid=mod.moid and mo.mtsyscoding=mt.mtsyscoding;


CREATE TABLE CST.COLLECT_SYMMETRIX_MONITOR
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


CREATE TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY
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


CREATE TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR
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


CREATE TABLE CST.COLLECT_SYMMETRIX_MONITOR_TEMP
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

CREATE TABLE CST.COLLECT_FILE_LIST (FILEID  SERIAL , FILENAME VARCHAR (128)  ,  PRIMARY KEY ( FILEID)  ) TABLESPACE SOC_SPACE;

CREATE VIEW CST.VIEW_COLLECT_DEVICES AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM  CST.COLLECT_DEVICES
);

CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_FE AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST. COLLECT_DIRECTORS_FE
);


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_RDF AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIRECTORS_RDF
);	

CREATE  VIEW CST.VIEW_COLLECT_DISKS AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,
WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM  CST.COLLECT_DISKS
);

CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_DA AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM  CST.COLLECT_DIRECTORS_DA
);

CREATE  VIEW CST.VIEW_COLLECT_PORTS_FE AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM  CST.COLLECT_PORTS_FE
);


CREATE  VIEW CST.VIEW_COLLECT_RDFA_STATUS AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,
R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM  CST.COLLECT_RDFA_STATUS
);


CREATE  VIEW CST.VIEW_COLLECT_RDF_DIRECTOR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_DIRECTOR
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_GROUP AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_GROUP
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_LINK AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_LINK
);

CREATE VIEW CST.VIEW_COLLECT_SYSTEM AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,
NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM  CST.COLLECT_SYSTEM
);

CREATE VIEW CST.VIEW_COLLECT_DIR_ESCON AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM  CST.COLLECT_DIR_ESCON
);
	

CREATE VIEW CST.VIEW_COLLECT_DIR_RA1 AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA1
);

CREATE VIEW CST.VIEW_COLLECT_DIR_RA2 AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,
LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA2
);	

CREATE VIEW CST.VIEW_COLLECT_DIR_SA AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SA
);

CREATE VIEW CST.VIEW_COLLECT_DIR_SE AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SE
);


CREATE VIEW CST.VIEW_COLLECT_DEVICES_DAY AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM  CST.COLLECT_DEVICES_DAY
);


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_FE_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST. COLLECT_DIRECTORS_FE_DAY
);


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_RDF_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIRECTORS_RDF_DAY
);	

CREATE  VIEW CST.VIEW_COLLECT_DISKS_DAY AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM  CST.COLLECT_DISKS_DAY
);	


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_DA_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM  CST.COLLECT_DIRECTORS_DA_DAY
);

CREATE  VIEW CST.VIEW_COLLECT_PORTS_FE_DAY AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM  CST.COLLECT_PORTS_FE_DAY
);


CREATE  VIEW CST.VIEW_COLLECT_RDFA_STATUS_DAY AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM  CST.COLLECT_RDFA_STATUS_DAY
);


CREATE  VIEW CST.VIEW_COLLECT_RDF_DIRECTOR_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_DIRECTOR_DAY
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_GROUP_DAY AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_GROUP_DAY
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_LINK_DAY AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_LINK_DAY
);


CREATE VIEW CST.VIEW_COLLECT_SYSTEM_DAY AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM  CST.COLLECT_SYSTEM_DAY
);


CREATE VIEW CST.VIEW_COLLECT_DIR_ESCON_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM  CST.COLLECT_DIR_ESCON_DAY
);
	

CREATE VIEW CST.VIEW_COLLECT_DIR_RA1_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA1_DAY
);

CREATE VIEW CST.VIEW_COLLECT_DIR_RA2_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA2_DAY
);	

CREATE VIEW CST.VIEW_COLLECT_DIR_SA_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SA_DAY
);

CREATE VIEW CST.VIEW_COLLECT_DIR_SE_DAY AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SE_DAY
);

CREATE VIEW CST.view_COLLECT_DIRECTORS_FE_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
FROM  CST.COLLECT_DIRECTORS_FE_DAY;

CREATE VIEW CST.view_COLLECT_DIRECTORS_RDF_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
FROM  CST.COLLECT_DIRECTORS_RDF_DAY;

CREATE VIEW CST.view_COLLECT_DIRECTORS_DA_DAY_Performance as 
select dataid,max_data_times as data_times,director_number as device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
FROM  CST.COLLECT_DIRECTORS_DA_DAY;

CREATE VIEW CST.view_COLLECT_DISKS_DAY_Performance as 
select dataid,max_data_times as data_times,device_name,maxbusy, data_times as savetime,avgbusy,TOTALCOUNT as savecount
FROM  CST.COLLECT_DISKS_DAY;

CREATE VIEW CST.VIEW_COLLECT_DEVICES_HOUR AS (
	SELECT DATAID,DATA_TIMES,DEVICE_NAME,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,WRITE_PENDING_COUNT,
	(RANDOM_READS_PER_SEC + SEQ_READS_PER_SEC) + (RANDOM_WRITES_PER_SEC + SEQ_WRITES_PER_SEC) AS TOTAL_IOS_PER_SEC
	FROM  CST.COLLECT_DEVICES_HOUR
);


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_FE_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,READS_PER_SEC,WRITES_PER_SEC,CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST. COLLECT_DIRECTORS_FE_HOUR
);


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_RDF_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIRECTORS_RDF_HOUR
);	

CREATE  VIEW CST.VIEW_COLLECT_DISKS_HOUR AS (
SELECT DATAID,DATA_TIMES,DEVICE_NAME,TOTAL_SCSI_COMMAND_PER_SEC,READ_COMMANDS_PER_SEC,WRITE_COMMANDS_PER_SEC,
		XOR_WRITE_COMMANDS_PER_SEC,XOR_READ_COMMANDS_PER_SEC, 
		CASE WHEN (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100))<0.000000 THEN 0 ELSE (100 - (DISK_IDLE_TIME_PER_SEC / 1000 * 100)) END AS DISK_BUSY,  CASE WHEN TOTAL_SCSI_COMMAND_PER_SEC=0.000000 THEN 0 ELSE ACCUMULATED_QUEUE_DEPTH/TOTAL_SCSI_COMMAND_PER_SEC END AS AVERAGE_QUEUE_DEPTH 
FROM  CST.COLLECT_DISKS_HOUR
);	


CREATE VIEW CST.VIEW_COLLECT_DIRECTORS_DA_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC, CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY 
FROM  CST.COLLECT_DIRECTORS_DA_HOUR
);

CREATE  VIEW CST.VIEW_COLLECT_PORTS_FE_HOUR AS (
SELECT DATAID,DATA_TIMES,PORT_NAME,IOS_PER_SEC,THROUGHPUT_IN_KBYTES_PER_SEC,
CASE WHEN IOS_PER_SEC=0.000000 THEN 0 ELSE (THROUGHPUT_IN_KBYTES_PER_SEC/IOS_PER_SEC) END AS AVERAGE_REQUEST_SIZE_IN_KBYTES
FROM  CST.COLLECT_PORTS_FE_HOUR
);


CREATE  VIEW CST.VIEW_COLLECT_RDFA_STATUS_HOUR AS (
SELECT DATAID,DATA_TIMES,RA_GROUP_NUMBER,AVG_CYCLE_TIME,DURATION_OF_LAST_CYCLE,R1_R2_IOS_PER_SEC,R1_R2_MBYTES_PER_SECOND,R2_R1_IOS_PER_SEC,
		R2_R1_MBYTES_PER_SECOND,ACTIVE_CYCLE_SIZE + INACTIVE_CYCLE_SIZE AS TOTAL_CACHE_SLOTS_IN_USE
FROM  CST.COLLECT_RDFA_STATUS_HOUR
);


CREATE  VIEW CST.VIEW_COLLECT_RDF_DIRECTOR_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_DIRECTOR_HOUR
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_GROUP_HOUR AS (
SELECT DATAID,DATA_TIMES,RDF_GROUP,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_GROUP_HOUR
);

CREATE  VIEW CST.VIEW_COLLECT_RDF_LINK_HOUR AS (
SELECT DATAID,DATA_TIMES,LINK_NUMBER,ECHO_DELAY,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC
FROM  CST.COLLECT_RDF_LINK_HOUR
);


CREATE VIEW CST.VIEW_COLLECT_SYSTEM_HOUR AS (
	SELECT DATAID,DATA_TIMES,SYMID,IOS_PER_SEC,KBYTES_READ_PER_SEC,KBYTES_WRITTEN_PER_SEC,NUMBER_WRITE_PENDING_TRACKS,
		READS_PER_SEC + SEQ_READS_PER_SEC + WRITES_PER_SEC AS TOTAL_IOS_PER_SEC,
		CASE WHEN (reads_per_sec + seq_reads_per_sec + writes_per_sec)=0.000000 THEN 0 ELSE  100 * ((reads_per_sec+ seq_reads_per_sec) / (reads_per_sec +  seq_reads_per_sec + writes_per_sec)) END AS READS,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (WRITES_PER_SEC / TOTAL_IOS_PER_SEC) END AS WRITES,
		CASE WHEN TOTAL_IOS_PER_SEC=0.000000 THEN 0 ELSE   100 * (HITS_PER_SEC/TOTAL_IOS_PER_SEC) END AS HIT,
		KBYTES_WRITTEN_PER_SEC + KBYTES_READ_PER_SEC AS KBYTES_TRANSFERRED_PER_SEC
	FROM  CST.COLLECT_SYSTEM_HOUR
);


CREATE VIEW CST.VIEW_COLLECT_DIR_ESCON_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC
FROM  CST.COLLECT_DIR_ESCON_HOUR
);
	

CREATE VIEW CST.VIEW_COLLECT_DIR_RA1_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA1_HOUR
);

CREATE VIEW CST.VIEW_COLLECT_DIR_RA2_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC,KBYTES_RECEIVED_PER_SEC,KBYTES_SENT_PER_SEC,LINK_UTILIZATION,
		CASE WHEN INTERVAL_TIME=0.000000 THEN 100 ELSE (100 - 100*(ACCUMULATED_DIRECTOR_IDLE_TIME / INTERVAL_TIME)) END AS BUSY
FROM  CST.COLLECT_DIR_RA2_HOUR
);	

CREATE VIEW CST.VIEW_COLLECT_DIR_SA_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SA_HOUR
);

CREATE VIEW CST.VIEW_COLLECT_DIR_SE_HOUR AS (
SELECT DATAID,DATA_TIMES,DIRECTOR_NUMBER,IOS_PER_SEC 
FROM  CST.COLLECT_DIR_SE_HOUR
);

CREATE  INDEX DEVICE_ALL ON CST.COLLECT_DEVICES(DATAID ASC,DEVICE_NAME ASC,DATA_TIMES ASC,TOTAL_IOS_PER_SEC ASC,WRITE_PENDING_COUNT ASC)  ;

CREATE  INDEX DIR_DA_DATAID ON CST.COLLECT_DIRECTORS_DA (DATAID ASC)   ;

CREATE  INDEX DIR_DA_datatimes ON CST.COLLECT_DIRECTORS_DA (data_times ASC)  ;

CREATE  INDEX DIR_DA_NAME ON CST.COLLECT_DIRECTORS_DA (DIRECTOR_NUMBER ASC) ;

CREATE  INDEX DIR_FIBRE_DATAID ON CST.COLLECT_DIRECTORS_FE (DATAID ASC)   ;

CREATE  INDEX DIR_FIBRE_datatimes ON CST.COLLECT_DIRECTORS_FE (data_times ASC);

CREATE  INDEX DIR_FIBRE_NAME ON CST.COLLECT_DIRECTORS_FE (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DIR_RFB_DATAID ON CST.COLLECT_DIRECTORS_RDF (DATAID ASC)   ;
CREATE  INDEX DIR_RFB_datatimes ON CST.COLLECT_DIRECTORS_RDF (data_times ASC)   ;
CREATE  INDEX DIR_RFB_NAME ON CST.COLLECT_DIRECTORS_RDF (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DISKS_DATAID ON CST.COLLECT_DISKS (DATAID ASC)   ;
CREATE  INDEX DISKS_datatimes ON CST.COLLECT_DISKS (data_times ASC)   ;
CREATE  INDEX DISKS_NAME ON CST.COLLECT_DISKS (DEVICE_NAME ASC)   ;

CREATE  INDEX PORTS_FE_DATAID ON CST.COLLECT_PORTS_FE (DATAID ASC)   ;
CREATE  INDEX PORTS_FE_datatimes ON CST.COLLECT_PORTS_FE (data_times ASC)   ;
CREATE  INDEX PORTS_FE_NAME ON CST.COLLECT_PORTS_FE (PORT_NAME ASC)   ;

CREATE  INDEX RDFA_DATAID ON CST.COLLECT_RDFA_STATUS (DATAID ASC)   ;
CREATE  INDEX RDFA_datatimes ON CST.COLLECT_RDFA_STATUS (data_times ASC)   ;
CREATE  INDEX RDFA_NAME ON CST.COLLECT_RDFA_STATUS (RA_GROUP_NUMBER ASC)   ;

CREATE  INDEX RDF_DATAID ON CST.COLLECT_RDF_DIRECTOR (DATAID ASC)   ;
CREATE  INDEX RDF_datatimes ON CST.COLLECT_RDF_DIRECTOR (data_times ASC)   ;
CREATE  INDEX RDF_NAME ON CST.COLLECT_RDF_DIRECTOR (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX RDF_GROUP_DATAID ON CST.COLLECT_RDF_GROUP (DATAID ASC)   ;
CREATE  INDEX RDF_GROUP_datatimes ON CST.COLLECT_RDF_GROUP (data_times ASC)   ;
CREATE  INDEX RDF_GROUP_NAME ON CST.COLLECT_RDF_GROUP (RDF_GROUP ASC)   ;

CREATE  INDEX RDF_LINK_DATAID ON CST.COLLECT_RDF_LINK (DATAID ASC)   ;
CREATE  INDEX RDF_LINK_datatimes ON CST.COLLECT_RDF_LINK (data_times ASC)   ;
CREATE  INDEX RDF_LINK_NAME ON CST.COLLECT_RDF_LINK (LINK_NUMBER ASC)   ;

CREATE  INDEX System_DATAID ON CST.COLLECT_SYSTEM (DATAID ASC)   ;
CREATE  INDEX System_datatimes ON CST.COLLECT_SYSTEM (data_times ASC)   ;
CREATE  INDEX System_symid ON CST.COLLECT_SYSTEM (symid ASC)   ;

CREATE  INDEX DIR_ESCON_DATAID ON CST.COLLECT_DIR_ESCON (DATAID ASC)   ;
CREATE  INDEX DIR_ESCON_datatimes ON CST.COLLECT_DIR_ESCON (data_times ASC)   ;
CREATE  INDEX DIR_ESCON_NAME ON CST.COLLECT_DIR_ESCON (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DIR_RA1_DATAID ON CST.COLLECT_DIR_RA1 (DATAID ASC)   ;
CREATE  INDEX DIR_RA1_datatimes ON CST.COLLECT_DIR_RA1 (data_times ASC)   ;
CREATE  INDEX DIR_RA1_NAME ON CST.COLLECT_DIR_RA1 (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DIR_RA2_DATAID ON CST.COLLECT_DIR_RA2 (DATAID ASC)   ;
CREATE  INDEX DIR_RA2_datatimes ON CST.COLLECT_DIR_RA2 (data_times ASC)   ;
CREATE  INDEX DIR_RA2_NAME ON CST.COLLECT_DIR_RA2 (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DIR_SA_DATAID ON CST.COLLECT_DIR_SA (DATAID ASC)   ;
CREATE  INDEX DIR_SA_datatimes ON CST.COLLECT_DIR_SA (data_times ASC)   ;
CREATE  INDEX DIR_SA_NAME ON CST.COLLECT_DIR_SA (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX DIR_SE_DATAID ON CST.COLLECT_DIR_SE (DATAID ASC)   ;
CREATE  INDEX DIR_SE_datatimes ON CST.COLLECT_DIR_SE (data_times ASC)   ;
CREATE  INDEX DIR_SE_NAME ON CST.COLLECT_DIR_SE (DIRECTOR_NUMBER ASC)   ;

CREATE  INDEX Symmetrix_RT ON CST.COLLECT_SYMMETRIX_MONITOR_RT (SAVETIME DESC,SYMM_ID DESC)   ;

------------------------------CX---------------------------------------
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN AVGTOTAL_THROUGHPUT DECIMAL (26, 6) ;
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN SUMTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MAXTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MINTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_DAY ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;


ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN AVGTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN SUMTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN MAXTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN MINTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_HOUR  ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_DISK_HOUR ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_DISK_HOUR  ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;


ALTER TABLE CST.CX_COLLECT_SP_DAY ADD COLUMN AVGTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY ADD COLUMN SUMTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MAXTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_DAY ADD COLUMN MINTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN AVGQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_DAY ADD COLUMN SUMQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MAXQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_DAY ADD COLUMN MINQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_DAY  ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;



ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN AVGTOTAL_THROUGHPUT DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN SUMTOTAL_THROUGHPUT DECIMAL (26, 6 );
ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MAXTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MINTOTAL_THROUGHPUT DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN AVGQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN SUMQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MAXQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MINQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_SP_HOUR ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;

ALTER TABLE CST.CX_COLLECT_LUN_DAY ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN AVGQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN SUMQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MAXQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MINQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_DAY  ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;

ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN AVGRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN SUMRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN MAXRESPONSE_TIME DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN MINRESPONSE_TIME DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN AVGQUEUE_LENGTH DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN SUMQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN MAXQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN MINQUEUE_LENGTH DECIMAL (26, 6);
 ALTER TABLE CST.CX_COLLECT_LUN_HOUR ADD COLUMN AVGUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN SUMUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN MAXUTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.CX_COLLECT_LUN_HOUR  ADD COLUMN MINUTILIZATION DECIMAL (26, 6) ;

------------------------------DMX---------------------------------------

ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY  ADD COLUMN SUMBUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_DAY  ADD COLUMN MINBUSY DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR  ADD COLUMN SUMBUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_DA_HOUR  ADD COLUMN MINBUSY DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_DEVICES_DAY ADD COLUMN AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY  ADD COLUMN SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY   ADD COLUMN MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY   ADD COLUMN MINTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY   ADD COLUMN AVGWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY  ADD COLUMN SUMWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY   ADD COLUMN MAXWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_DAY  ADD COLUMN MINWRITE_PENDING_COUNT DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_DEVICES_HOUR ADD COLUMN AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN MINTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN AVGWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN SUMWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN MAXWRITE_PENDING_COUNT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DEVICES_HOUR  ADD COLUMN MINWRITE_PENDING_COUNT DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY ADD COLUMN AVGKBYTES_READ_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN SUMKBYTES_READ_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN MAXKBYTES_READ_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN MINKBYTES_READ_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY  ADD COLUMN MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_DAY ADD COLUMN MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR ADD COLUMN AVGKBYTES_READ_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR  ADD COLUMN SUMKBYTES_READ_PER_SEC DECIMAL (26, 6);
 
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR ADD COLUMN MAXKBYTES_READ_PER_SEC DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR  ADD COLUMN MINKBYTES_READ_PER_SEC DECIMAL (26, 6);
 
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR ADD COLUMN AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
 
ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR ADD COLUMN SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR  ADD COLUMN MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_RDF_DIRECTOR_HOUR  ADD COLUMN MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);

ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN AVGDISK_BUSY DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN SUMDISK_BUSY DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN MAXDISK_BUSY DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN MINDISK_BUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_DAY  ADD COLUMN AVGTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN SUMTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DISKS_DAY ADD COLUMN MAXTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_DAY  ADD COLUMN MINTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_DISKS_HOUR ADD COLUMN AVGDISK_BUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN SUMDISK_BUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN MAXDISK_BUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN MINDISK_BUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN AVGTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN SUMTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN MAXTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DISKS_HOUR  ADD COLUMN MINTOTAL_SCSI_COMMAND_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY  ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY ADD COLUMN SUMBUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_DAY ADD COLUMN MINBUSY DECIMAL (26, 6); 

ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR  ADD COLUMN SUMBUSY DECIMAL (26, 6);
 ALTER TABLE CST.COLLECT_DIRECTORS_FE_HOUR ADD COLUMN MINBUSY DECIMAL (26, 6);



ALTER TABLE CST.COLLECT_PORTS_FE_DAY ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN AVGTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN SUMTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN MAXTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_DAY  ADD COLUMN MINTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_PORTS_FE_HOUR ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN AVGTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN SUMTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN MAXTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_PORTS_FE_HOUR  ADD COLUMN MINTHROUGHPUT_IN_KBYTES_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN AVGLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN SUMLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN MAXLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN MINLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN SUMBUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_DAY  ADD COLUMN MINBUSY DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR ADD COLUMN AVGIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN SUMIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN MAXIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN MINIOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN AVGLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN SUMLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN MAXLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN MINLINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN SUMBUSY DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_DIRECTORS_RDF_HOUR  ADD COLUMN MINBUSY DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_SYSTEM_DAY ADD COLUMN AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN AVGKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN AVGREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN AVGWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN AVGHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN SUMHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MAXHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_DAY  ADD COLUMN MINHIT DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_SYSTEM_HOUR ADD COLUMN AVGTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINTOTAL_IOS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN AVGKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINKBYTES_WRITTEN_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN AVGKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINKBYTES_TRANSFERRED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN AVGREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINREADS DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN AVGWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINWRITES DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN AVGHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN SUMHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MAXHIT DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYSTEM_HOUR  ADD COLUMN MINHIT DECIMAL (26, 6);


------------------------------brocade---------------------------------------
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY ADD COLUMN AVGREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN SUMREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN MAXREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN MINREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN AVGWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN SUMWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY  ADD COLUMN MAXWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_DAY ADD COLUMN MINWRITES_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR ADD COLUMN AVGREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN SUMREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN MAXREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN MINREADS_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN AVGWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN SUMWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN MAXWRITES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.COLLECT_SYMMETRIX_MONITOR_HOUR  ADD COLUMN MINWRITES_PER_SEC DECIMAL (26, 6);


ALTER TABLE CST.BROCADE_COLLECT_DAY ADD COLUMN AVGCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
 ALTER TABLE CST.BROCADE_COLLECT_DAY ADD COLUMN SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_DAY  ADD COLUMN MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);



ALTER TABLE CST.BROCADE_COLLECT_HOUR ADD COLUMN AVGCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINCLASS3_DISCARDS DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.BROCADE_COLLECT_HOUR  ADD COLUMN MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);

------------------------------mcdata---------------------------------------

ALTER TABLE CST.MCDATA_COLLECT_DAY ADD COLUMN AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_DAY  ADD COLUMN MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);

ALTER TABLE CST.MCDATA_COLLECT_HOUR ADD COLUMN AVGKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINKBYTES_RECEIVED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN AVGKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINKBYTES_TRANSMITTED_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN AVGRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINRECEIVED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN AVGRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINRECEIVE_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN AVGTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINTRANSMIT_LINK_UTILIZATION DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN AVGTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN SUMTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MAXTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);
ALTER TABLE CST.MCDATA_COLLECT_HOUR  ADD COLUMN MINTRANSMITTED_FRAMES_PER_SEC DECIMAL (26, 6);


