/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.orl.model.OrealPMVWInfo;
import com.deliverik.orl.model.condition.OrealPMVWSearchCond;
import com.deliverik.orl.model.dao.OrealPMVWDAO;
import com.deliverik.orl.model.entity.OrealPMVW;

/**
 * ������ŷ���ż��ָ����ͼҵ���߼�ʵ��
 * ����������ŷ���ż��ָ����ͼҵ���߼�ʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
public class OrealPMVWBLImpl extends BaseBLImpl implements OrealPMVWBL {

	/** ���ָ����ͼDAO�ӿ� */
	protected OrealPMVWDAO orealPMVWDAO;
	
	/**
	 * ���ָ����ͼDAO�ӿ��趨
	 *
	 * @param orealPMVWDAO  ���ָ����ͼDAO�ӿ�
	 */
	public void setOrealPMVWDAO(OrealPMVWDAO orealPMVWDAO) {
		this.orealPMVWDAO = orealPMVWDAO;
	}

	/**
	 * ���ָ����ͼʵ��ȡ��
	 *
	 * @return ���ָ����ͼʵ��
	 */
	public OrealPMVW getOrealPMVWInstance() {
		return new OrealPMVW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealPMVWInfo> searchOrealPMVW() {
		return orealPMVWDAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws Exception 
	 */
	public int getSearchCount(OrealPMVWSearchCond cond) throws BLException {
		return orealPMVWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 * @throws Exception 
	 */
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond) throws BLException {
		return orealPMVWDAO.findByCond(cond, 0, 0);
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
	public List<OrealPMVWInfo> searchOrealPMVWByCond(OrealPMVWSearchCond cond, int start, int count) throws BLException {
		return orealPMVWDAO.findByCond(cond, start, count);
	}
}