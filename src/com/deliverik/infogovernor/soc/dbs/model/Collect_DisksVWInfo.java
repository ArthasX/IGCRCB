/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.model;

 import java.math.BigDecimal;


/**
 * 
 * @Description:�洢ʵʱ��Ϣ��ͼʵ��TB��
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_DisksVWInfo{

    /**
     * ��ȡʱ��
     * @return
     */
	public String getSymtime();
	
	/**
	 * ��ȡ�豸
	 * @return
	 */
	public String getDirector_number();
	
	/**
	 * ��ȡʹ����
	 * @return
	 */
	public BigDecimal getSysBusy();
	
	/**
	 * ��ȡCX�豸
	 * @return
	 */
	public String getObject_Name();
	
}

