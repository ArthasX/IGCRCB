/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;

import java.math.BigDecimal;


/**
 * 
 * @Description:�洢ʵʱ��ϢCond��
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtSearchCondImpl implements Collect_Symmetrix_Monitor_RtSearchCond{
/**
*ϵͳʱ��
*/
protected String savetime;

/**
*ϵͳʱ��ȡ��
* @return ϵͳʱ��
*/
public String getSavetime(){
return savetime;
}
/**
*ϵͳʱ���趨
* @param savetimeϵͳʱ��
*/
public void setSavetime(String savetime){
this.savetime=savetime;
}
/**
*���к�
*/
protected String symm_id;

/**
*���к�ȡ��
* @return ���к�
*/
public String getSymm_id(){
return symm_id;
}
/**
*���к��趨
* @param symm_id���к�
*/
public void setSymm_id(String symm_id){
this.symm_id=symm_id;
}
/**
*ʱ����
*/
protected String timestamp;

/**
*ʱ����ȡ��
* @return ʱ����
*/
public String getTimestamp(){
return timestamp;
}
/**
*ʱ�����趨
* @param timestampʱ����
*/
public void setTimestamp(String timestamp){
this.timestamp=timestamp;
}
/**
*ʵʱ��
*/
protected BigDecimal reads_per_sec;

/**
*ʵʱ��ȡ��
* @return ʵʱ��
*/
public BigDecimal getReads_per_sec(){
return reads_per_sec;
}
/**
*ʵʱ���趨
* @param reads_per_secʵʱ��
*/
public void setReads_per_sec(BigDecimal reads_per_sec){
this.reads_per_sec=reads_per_sec;
}
/**
*ʵʱд
*/
protected BigDecimal writes_per_sec;

/**
*ʵʱдȡ��
* @return ʵʱд
*/
public BigDecimal getWrites_per_sec(){
return writes_per_sec;
}
/**
*ʵʱд�趨
* @param writes_per_secʵʱд
*/
public void setWrites_per_sec(BigDecimal writes_per_sec){
this.writes_per_sec=writes_per_sec;
}
/**
*����
*/
protected BigDecimal kbytes_read_per_sec;

/**
*����ȡ��
* @return ����
*/
public BigDecimal getKbytes_read_per_sec(){
return kbytes_read_per_sec;
}
/**
*�����趨
* @param kbytes_read_per_sec����
*/
public void setKbytes_read_per_sec(BigDecimal kbytes_read_per_sec){
this.kbytes_read_per_sec=kbytes_read_per_sec;
}
/**
*����
*/
protected BigDecimal kbytes_written_per_sec;

/**
*����ȡ��
* @return ����
*/
public BigDecimal getKbytes_written_per_sec(){
return kbytes_written_per_sec;
}
/**
*�����趨
* @param kbytes_written_per_sec����
*/
public void setKbytes_written_per_sec(BigDecimal kbytes_written_per_sec){
this.kbytes_written_per_sec=kbytes_written_per_sec;
}
/**
*��������
*/
protected BigDecimal hits_read_per_sec;

/**
*��������ȡ��
* @return ��������
*/
public BigDecimal getHits_read_per_sec(){
return hits_read_per_sec;
}
/**
*���������趨
* @param hits_read_per_sec��������
*/
public void setHits_read_per_sec(BigDecimal hits_read_per_sec){
this.hits_read_per_sec=hits_read_per_sec;
}
/**
*д������
*/
protected BigDecimal hits_witten_per_sec;

/**
*д������ȡ��
* @return д������
*/
public BigDecimal getHits_witten_per_sec(){
return hits_witten_per_sec;
}
/**
*д�������趨
* @param hits_witten_per_secд������
*/
public void setHits_witten_per_sec(BigDecimal hits_witten_per_sec){
this.hits_witten_per_sec=hits_witten_per_sec;
}
/**
*
*/
protected BigDecimal seq_read_per_sec;

/**
*ȡ��
* @return 
*/
public BigDecimal getSeq_read_per_sec(){
return seq_read_per_sec;
}
/**
*�趨
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
*ȡ��
* @return 
*/
public BigDecimal getSeq_written_per_sec(){
return seq_written_per_sec;
}
/**
*�趨
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
*ȡ��
* @return 
*/
public BigDecimal getNumber_write_pending_tracks(){
return number_write_pending_tracks;
}
/**
*�趨
* @param number_write_pending_tracks
*/
public void setNumber_write_pending_tracks(BigDecimal number_write_pending_tracks){
this.number_write_pending_tracks=number_write_pending_tracks;
}
}

