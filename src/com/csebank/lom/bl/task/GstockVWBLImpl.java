/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.csebank.lom.model.dao.GstockVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ���Ԥ����Ϣҵ���߼��ӿ�ʵ��
 */
public class GstockVWBLImpl extends BaseBLImpl implements GstockVWBL {
	
	/**  DAO */
	protected GstockVWDAO gstockVWDAO;
	

	/**
	 * @param gstockVWDAO the gstockVWDAO to set
	 */
	public void setGstockVWDAO(GstockVWDAO gstockVWDAO) {
		this.gstockVWDAO = gstockVWDAO;
	}

	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GstockVWInfo> searchGstockVW(GstockVWSearchCond cond, int start, int count){
		
		return gstockVWDAO.findByCond(cond,start,count);
	}

	
}
