/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model;

import java.math.BigDecimal;

/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼʵ��ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtVWInfo{
/**
*
*/
public String getSymtime();

/**
*IOPS
*/
public BigDecimal getSymiops();

/**
*������
*/
public BigDecimal getSymthroughput();

/**
*������
*/
public BigDecimal getReadper();

/**
*д����
*/
public BigDecimal getWriteper();

/**
*����������
*/
public BigDecimal getHitper();


public String getFulltime();
}