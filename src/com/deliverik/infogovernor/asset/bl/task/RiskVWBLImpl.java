/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskVWCond;
import com.deliverik.infogovernor.asset.model.dao.RiskVWDAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�Ʋ�ѯҵ���߼�ʵ��
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class RiskVWBLImpl extends BaseBLImpl implements RiskVWBL {

	/** ���ռ��ͳ�Ʋ�ѯDAO�ӿ� */
	protected RiskVWDAO riskVWDAO;
	
	/**
	 * ���ռ��ͳ�Ʋ�ѯDAO�ӿ��趨
	 * @param riskVWDAO ���ռ��ͳ�Ʋ�ѯDAO�ӿ�
	 */
	public void setRiskVWDAO(RiskVWDAO riskVWDAO) {
		this.riskVWDAO = riskVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<RiskVWInfo> findByCond(RiskVWCond cond) {
		return riskVWDAO.findByCond(cond);
	}

}
