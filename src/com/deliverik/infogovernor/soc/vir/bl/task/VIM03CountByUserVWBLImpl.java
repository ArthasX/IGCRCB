/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByUserVWDAO;

/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public class VIM03CountByUserVWBLImpl extends BaseBLImpl implements
		VIM03CountByUserVWBL {
	
	/** ���⻯ͳ����ͼDAO */
	protected VIM03CountByUserVWDAO vim03CountByUserVWDAO;
	
	/**
	 * ���⻯ͳ����ͼDAO�趨
	 * @param vim03CountByUserVWDAO ���⻯ͳ����ͼDAO
	 */
	public void setVim03CountByUserVWDAO(VIM03CountByUserVWDAO vim03CountByUserVWDAO) {
		this.vim03CountByUserVWDAO = vim03CountByUserVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond,final int start,final int count){
		return vim03CountByUserVWDAO.findByCond(cond, start, count);
	}
}
