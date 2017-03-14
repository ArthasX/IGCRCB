/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.condition.CheckVWCond;
import com.deliverik.infogovernor.asset.model.dao.CheckVWDAO;

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
public class CheckVWBLImpl extends BaseBLImpl implements CheckVWBL {

	/** ���ռ��ͳ�Ʋ�ѯDAO�ӿ� */
	protected CheckVWDAO checkVWDAO;
	
	/**
	 * ���ռ��ͳ�Ʋ�ѯDAO�ӿ��趨
	 * @param checkVWDAO ���ռ��ͳ�Ʋ�ѯDAO�ӿ�
	 */
	public void setCheckVWDAO(CheckVWDAO checkVWDAO) {
		this.checkVWDAO = checkVWDAO;
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckVWInfo> findByCond(CheckVWCond cond) {
		return checkVWDAO.findByCond(cond);
	}

}
