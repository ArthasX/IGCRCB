/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByOrgVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByOrgVWSearchCond;
import com.deliverik.infogovernor.soc.vir.model.dao.VIM03CountByOrgVWDAO;

/**
 * ���⻯��Դͳ��ҵ���߼�ʵ��
 *
 */
public class VIM03CountByOrgVWBLImpl extends BaseBLImpl implements
		VIM03CountByOrgVWBL {
	
	/** ���⻯ͳ����ͼDAO */
	protected VIM03CountByOrgVWDAO vim03CountByOrgVWDAO;
	
	/**
	 * ���⻯ͳ����ͼDAO�趨
	 * @param vim03CountByUserVWDAO ���⻯ͳ����ͼDAO
	 */
	public void setVim03CountByOrgVWDAO(VIM03CountByOrgVWDAO vim03CountByOrgVWDAO) {
		this.vim03CountByOrgVWDAO = vim03CountByOrgVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<VIM03CountByOrgVWInfo> findByCond(final VIM03CountByOrgVWSearchCond cond,final int start,final int count){
		return vim03CountByOrgVWDAO.findByCond(cond, start, count);
	}
	
	/**
	 * ��ѯ��������Դʹ�����
	 * @param cond
	 * @return
	 */
	public List<VIM03CountByOrgVWInfo> getCount(final VIM03CountByOrgVWSearchCond cond){
		return vim03CountByOrgVWDAO.getCount(cond);
	}
}
