/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.condition.CR01SearchCond;
import com.deliverik.infogovernor.soc.model.dao.CR01DAO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ɼ���BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class CR01BLImpl extends BaseBLImpl implements CR01BL{

	/** �ɼ����dao */
	protected CR01DAO cr01DAO;

	/**
	 * �ɼ����dao�趨
	 * @param cr01dao �ɼ����dao
	 */
	public void setCr01DAO(CR01DAO cr01dao) {
		cr01DAO = cr01dao;
	}
	
	/**
	 * �ɼ������ѯ
	 * @param cond ��ѯ����
	 * @param start ��ʼҳ��
	 * @param length ��ʾ����
	 * @return ��ѯ���
	 */
	public List<CR01VWInfo> searchCR01VWInfoList(CR01SearchCond cond , int start,int length){
		return cr01DAO.searchCR01VWInfoList(cond, start, length);
	}
}
