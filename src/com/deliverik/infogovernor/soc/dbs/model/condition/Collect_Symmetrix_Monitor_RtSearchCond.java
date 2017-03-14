/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model.condition;

import java.math.BigDecimal;


/**
 * 
 * @Description:�洢ʵʱ��ϢCond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtSearchCond{
/**
*ϵͳʱ��
*/
public String getSavetime();

/**
*���к�
*/
public String getSymm_id();

/**
*ʱ����
*/
public String getTimestamp();

/**
*ʵʱ��
*/
public BigDecimal getReads_per_sec();

/**
*ʵʱд
*/
public BigDecimal getWrites_per_sec();

/**
*����
*/
public BigDecimal getKbytes_read_per_sec();

/**
*����
*/
public BigDecimal getKbytes_written_per_sec();

/**
*��������
*/
public BigDecimal getHits_read_per_sec();

/**
*д������
*/
public BigDecimal getHits_witten_per_sec();

/**
*
*/
public BigDecimal getSeq_read_per_sec();

/**
*
*/
public BigDecimal getSeq_written_per_sec();

/**
*
*/
public BigDecimal getNumber_write_pending_tracks();

}

