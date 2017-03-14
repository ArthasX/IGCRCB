/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByProjVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByProjVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByProjVWDAO;

/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public class VIM03CountByProjVWBLImpl extends BaseBLImpl implements
		VIM03CountByProjVWBL {
	
	/** ���⻯ͳ����ͼDAO */
	protected VIM03CountByProjVWDAO vim03CountByProjVWDAO;
	
	/**
	 * ���⻯ͳ����ͼDAO�趨
	 * @param vim03CountByUserVWDAO ���⻯ͳ����ͼDAO
	 */
	public void setVim03CountByProjVWDAO(VIM03CountByProjVWDAO vim03CountByProjVWDAO) {
		this.vim03CountByProjVWDAO = vim03CountByProjVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByProjVWInfo> findByCond(final VIM03CountByProjVWSearchCond cond,final int start,final int count){
		return vim03CountByProjVWDAO.findByCond(cond, start, count);
	}
}
