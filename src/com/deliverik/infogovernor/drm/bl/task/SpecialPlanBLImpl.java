/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.infogovernor.drm.model.condition.SpecialPlanSearchCond;
import com.deliverik.infogovernor.drm.model.dao.SpecialPlanDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ר��Ԥ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SpecialPlanBLImpl extends BaseBLImpl implements SpecialPlanBL{

	/** ר��Ԥ��DAO */
	protected SpecialPlanDAO specialPlanDAO;

	/**
	 * ר��Ԥ��DAO�趨
	 * @param specialPlanDAO ר��Ԥ��DAO
	 */
	public void setSpecialPlanDAO(SpecialPlanDAO specialPlanDAO) {
		this.specialPlanDAO = specialPlanDAO;
	}
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SpecialPlanSearchCond cond) {
		return specialPlanDAO.getSearchCount(cond);
	}
	
	/**
	 * ��������
	 * @param cond ��������
	 * @param start ��ʼ����
	 * @param count ��ʾ����
	 * @return �������
	 */
	public List<SOC0118VWInfo> search(SpecialPlanSearchCond cond,int start,int count){
		return specialPlanDAO.search(cond, start, count);
	}
}
