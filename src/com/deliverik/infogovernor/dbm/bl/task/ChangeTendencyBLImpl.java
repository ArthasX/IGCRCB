/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.ChangeTendency;
import com.deliverik.infogovernor.dbm.model.condition.ChangeTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.dao.ChangeTendencyDAO;

/**
 * 
 * @Description:�������ͳ�Ʊ�BLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class ChangeTendencyBLImpl extends BaseBLImpl implements ChangeTendencyBL{

	protected ChangeTendencyDAO changeTendencyDAO;

	public void setChangeTendencyDAO(ChangeTendencyDAO changeTendencyDAO) {
		this.changeTendencyDAO = changeTendencyDAO;
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<ChangeTendency> findAllChangeTendency() throws BLException {
		return changeTendencyDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(ChangeTendencySearchCond cond) throws BLException {
		return changeTendencyDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<ChangeTendency> findChangeTendencyByCond(ChangeTendencySearchCond cond,
			int start, int count) throws BLException {
		return changeTendencyDAO.findByCond(cond, start, count);
	}

}
