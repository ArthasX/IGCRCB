/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl.task;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.csebank.lom.model.AdvanceDetail;
import com.csebank.lom.model.condition.AdvanceDetailSearchCond;
import com.csebank.lom.model.dao.AdvanceDetailVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * Ԥ֧��Աͳ�Ʋ�ѯ�ӿ�ʵ��
 */
public class AdvanceDetailVWBLImpl extends BaseBLImpl implements AdvanceDetailVWBL {
	
	static Log log = LogFactory.getLog(AdvanceDetailVWBLImpl.class);

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯDAO
	 */
	protected AdvanceDetailVWDAO advanceDetailVWDAO;

	/**
	 * Ԥ֧��Աͳ�Ʋ�ѯDAO�趨
	 * @param advanceDetailVWDAO Ԥ֧��Աͳ�Ʋ�ѯDAO
	 */
	public void setAdvanceDetailVWDAO(
			AdvanceDetailVWDAO advanceDetailVWDAO) {
		this.advanceDetailVWDAO = advanceDetailVWDAO;
	}

	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return List<AdvanceDetail>
	 */
	public List<AdvanceDetail> searchAdvanceDetailVW(AdvanceDetailSearchCond cond,
			int start, int count) {
		List<AdvanceDetail> ret = advanceDetailVWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * <p>
	 * Description: Ԥ֧��Աͳ�Ʋ�ѯ
	 * </p>
	 * 
	 * @param cond ��������
	 * @return �б��¼����
	 */
	public int getSearchCount(AdvanceDetailSearchCond cond) {
		return advanceDetailVWDAO.getSearchCount(cond);
	}

}
