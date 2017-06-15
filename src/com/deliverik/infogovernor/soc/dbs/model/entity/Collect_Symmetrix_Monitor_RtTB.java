/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.model.entity;

 import java.io.Serializable;
import java.math.BigDecimal;

 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.persistence.TableGenerator;
 import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;


/**
 * 
 * @Description:存储实时信息实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
@SuppressWarnings("serial")@Entity
@Table(name="Collect_Symmetrix_Monitor_Rt", schema="cst")
public class Collect_Symmetrix_Monitor_RtTB extends BaseEntity implements Serializable, Cloneable, Collect_Symmetrix_Monitor_Rt{
@Id
@TableGenerator(
name="COLLECT_SYMMETRIX_MONITOR_RT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
pkColumnValue="COLLECT_SYMMETRIX_MONITOR_RT_SEQUENCE", initialValue=1, allocationSize=1
)
@GeneratedValue(strategy = GenerationType.TABLE, generator="COLLECT_SYMMETRIX_MONITOR_RT_TABLE_GENERATOR")
/**
*主键ID
*/
protected Integer id;

/**
*主键ID取得
* @return 主键ID
*/
public Integer getId(){
return id;
}
/**
*主键ID设定
* @param id主键ID
*/
public void setId(Integer id){
this.id=id;
}
/**
*系统时间
*/
protected String savetime;

/**
*系统时间取得
* @return 系统时间
*/
public String getSavetime(){
return savetime;
}
/**
*系统时间设定
* @param savetime系统时间
*/
public void setSavetime(String savetime){
this.savetime=savetime;
}
/**
*序列号
*/
protected String symm_id;

/**
*序列号取得
* @return 序列号
*/
public String getSymm_id(){
return symm_id;
}
/**
*序列号设定
* @param symm_id序列号
*/
public void setSymm_id(String symm_id){
this.symm_id=symm_id;
}
/**
*时间间隔
*/
protected String timestamp;

/**
*时间间隔取得
* @return 时间间隔
*/
public String getTimestamp(){
return timestamp;
}
/**
*时间间隔设定
* @param timestamp时间间隔
*/
public void setTimestamp(String timestamp){
this.timestamp=timestamp;
}
/**
*实时读
*/
protected BigDecimal reads_per_sec;

/**
*实时读取得
* @return 实时读
*/
public BigDecimal getReads_per_sec(){
return reads_per_sec;
}
/**
*实时读设定
* @param reads_per_sec实时读
*/
public void setReads_per_sec(BigDecimal reads_per_sec){
this.reads_per_sec=reads_per_sec;
}
/**
*实时写
*/
protected BigDecimal writes_per_sec;

/**
*实时写取得
* @return 实时写
*/
public BigDecimal getWrites_per_sec(){
return writes_per_sec;
}
/**
*实时写设定
* @param writes_per_sec实时写
*/
public void setWrites_per_sec(BigDecimal writes_per_sec){
this.writes_per_sec=writes_per_sec;
}
/**
*吐量
*/
protected BigDecimal kbytes_read_per_sec;

/**
*吐量取得
* @return 吐量
*/
public BigDecimal getKbytes_read_per_sec(){
return kbytes_read_per_sec;
}
/**
*吐量设定
* @param kbytes_read_per_sec吐量
*/
public void setKbytes_read_per_sec(BigDecimal kbytes_read_per_sec){
this.kbytes_read_per_sec=kbytes_read_per_sec;
}
/**
*吞量
*/
protected BigDecimal kbytes_written_per_sec;

/**
*吞量取得
* @return 吞量
*/
public BigDecimal getKbytes_written_per_sec(){
return kbytes_written_per_sec;
}
/**
*吞量设定
* @param kbytes_written_per_sec吞量
*/
public void setKbytes_written_per_sec(BigDecimal kbytes_written_per_sec){
this.kbytes_written_per_sec=kbytes_written_per_sec;
}
/**
*读命中率
*/
protected BigDecimal hits_read_per_sec;

/**
*读命中率取得
* @return 读命中率
*/
public BigDecimal getHits_read_per_sec(){
return hits_read_per_sec;
}
/**
*读命中率设定
* @param hits_read_per_sec读命中率
*/
public void setHits_read_per_sec(BigDecimal hits_read_per_sec){
this.hits_read_per_sec=hits_read_per_sec;
}
/**
*写命中率
*/
protected BigDecimal hits_written_per_sec;

/**
*写命中率取得
* @return 写命中率
*/
public BigDecimal getHits_written_per_sec(){
return hits_written_per_sec;
}
/**
*写命中率设定
* @param hits_witten_per_sec写命中率
*/
public void setHits_written_per_sec(BigDecimal hits_witten_per_sec){
this.hits_written_per_sec=hits_witten_per_sec;
}
/**
*
*/
protected BigDecimal seq_read_per_sec;

/**
*取得
* @return 
*/
public BigDecimal getSeq_read_per_sec(){
return seq_read_per_sec;
}
/**
*设定
* @param seq_read_per_sec
*/
public void setSeq_read_per_sec(BigDecimal seq_read_per_sec){
this.seq_read_per_sec=seq_read_per_sec;
}
/**
*
*/
protected BigDecimal seq_written_per_sec;

/**
*取得
* @return 
*/
public BigDecimal getSeq_written_per_sec(){
return seq_written_per_sec;
}
/**
*设定
* @param seq_written_per_sec
*/
public void setSeq_written_per_sec(BigDecimal seq_written_per_sec){
this.seq_written_per_sec=seq_written_per_sec;
}
/**
*
*/
protected BigDecimal number_write_pending_tracks;

/**
*取得
* @return 
*/
public BigDecimal getNumber_write_pending_tracks(){
return number_write_pending_tracks;
}
/**
*设定
* @param number_write_pending_tracks
*/
public void setNumber_write_pending_tracks(BigDecimal number_write_pending_tracks){
this.number_write_pending_tracks=number_write_pending_tracks;
}
public Serializable getPK() {
return id;
}
}

