/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.orl.model.OrealAlertInfo;
import com.deliverik.orl.model.condition.OrealAlertSearchCond;
import com.deliverik.orl.model.dao.OrealAlertDAO;
import com.deliverik.orl.model.entity.OrealAlertTB;

/**
 * ������ŷ���Ÿ澯��ҵ���߼�ʵ��
 * ����������ŷ���Ÿ澯����ͼҵ���߼�ʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public class OrealAlertBLImpl extends BaseBLImpl implements OrealAlertBL {

	/** �澯��DAO�ӿ� */
	protected OrealAlertDAO orealAlertDAO;
	
	/**
	 * �澯��DAO�ӿ��趨
	 *
	 * @param orealAlertDAO  �澯��DAO�ӿ�
	 */
	public void setOrealAlertDAO(OrealAlertDAO orealAlertDAO) {
		this.orealAlertDAO = orealAlertDAO;
	}

	/**
	 * �澯��ʵ��ȡ��
	 *
	 * @return �澯��ʵ��
	 */
	public OrealAlertTB getOrealAlertTBInstance() {
		return new OrealAlertTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealAlertInfo> searchOrealAlert() {
		return orealAlertDAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws Exception 
	 */
	public int getSearchCount(OrealAlertSearchCond cond) throws BLException {
		return orealAlertDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond) throws BLException {
		return orealAlertDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<OrealAlertInfo> searchOrealAlertByCond(OrealAlertSearchCond cond, int start, int count) throws BLException {
		return orealAlertDAO.findByCond(cond, start, count);
	}
}