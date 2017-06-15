/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import com.csebank.lom.model.GoutstockVWInfo;
import com.csebank.lom.model.condition.GoutstockVWSearchCond;
import com.csebank.lom.model.dao.GoutstockVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * ��Ʒ������Ϣ��ͼҵ���߼��ӿ�ʵ��
 */
public class GoutstockVWBLImpl extends BaseBLImpl implements GoutstockVWBL {
	
	/**  DAO */
	protected GoutstockVWDAO goutstockVWDAO;

	

	/**
	 * @param goutstockVWDAO the goutstockVWDAO to set
	 */
	public void setGoutstockVWDAO(GoutstockVWDAO goutstockVWDAO) {
		this.goutstockVWDAO = goutstockVWDAO;
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(GoutstockVWSearchCond cond){
		
		return goutstockVWDAO.getSearchCount(cond);
	}

	

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoutstockVWInfo> searchGoutstockVW(GoutstockVWSearchCond cond, int start, int count){
		
		return goutstockVWDAO.findByCond(cond,start,count);
	}


}
