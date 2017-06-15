/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;
import com.deliverik.infogovernor.dbm.model.condition.IncidentTendencySearchCond;
import com.deliverik.infogovernor.dbm.model.dao.IncidentTendencyDAO;

/**
 * 
 * @Description:�¼�����ͳ�Ʊ�BLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class IncidentTendencyBLImpl extends BaseBLImpl implements IncidentTendencyBL{

	protected IncidentTendencyDAO incidentTendencyDAO;

	public void setIncidentTendencyDAO(IncidentTendencyDAO incidentTendencyDAO) {
		this.incidentTendencyDAO = incidentTendencyDAO;
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<IncidentTendency> findAllIncidentTendency() throws BLException {
		return incidentTendencyDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(IncidentTendencySearchCond cond) throws BLException {
		return incidentTendencyDAO.getSearchCount(cond);
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
	public List<IncidentTendency> findIncidentTendencyByCond(IncidentTendencySearchCond cond,
			int start, int count) throws BLException {
		return incidentTendencyDAO.findByCond(cond, start, count);
	}

}
