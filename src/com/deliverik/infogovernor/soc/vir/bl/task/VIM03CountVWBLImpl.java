/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountVWDAO;

/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public class VIM03CountVWBLImpl extends BaseBLImpl implements
		VIM03CountVWBL {
	
	/** ���⻯ͳ����ͼDAO */
	protected VIM03CountVWDAO vim03CountVWDAO;

	/**
	 * ���⻯ͳ����ͼDAO�趨
	 * @param vim03CountVWDAO ���⻯ͳ����ͼDAO
	 */
	public void setVim03CountVWDAO(VIM03CountVWDAO vim03CountVWDAO) {
		this.vim03CountVWDAO = vim03CountVWDAO;
	}
	
	/**
	 * ��������ȡ��
	 *
	 * @param cond ��������
	 * @return ��������
	 */
	public Integer getCount(final VIM03CountVWSearchCond cond){
		return vim03CountVWDAO.getCount(cond);
	}
	
	/**
	 * ��������ȡ��
	 *
	 * @param cond ��������
	 * @return ��������
	 */
	public Integer getCountByCond(final VIM03CountVWSearchCond cond){
		return vim03CountVWDAO.getCountByCond(cond);
	}
}
