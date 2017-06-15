/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0600Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0600SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0600DAO;


/**
 * ����: �ʲ�������̲�ѯ
 * ��������: �ʲ�������̲�ѯ
 * ������¼: 2014/03/13
 * �޸ļ�¼: 
 */
public class SOC0600BLImpl extends BaseBLImpl implements
	SOC0600BL {

	protected SOC0600DAO soc0600DAO;
	
	/**
	 * SOC0600DAO�趨
	 * @param SOC0600DAO SOC0600DAO
	 */
	public void setSoc0600DAO(SOC0600DAO soc0600dao) {
		soc0600DAO = soc0600dao;
	}
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����������
	 */
	public List<SOC0600Info> findByCond(SOC0600SearchCond cond) {
		return soc0600DAO.findByCond(cond);
	}
}