/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
import com.deliverik.infogovernor.sym.model.dao.PriorityDAO;
/**
 * ����:���ȼ�BLʵ����
 *����������1.�־û�����
 * 			2.ȫ������
 * 			3.���������������ȡ��
 * 			4.������������
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */
public class PriorityBLImpl extends BaseBLImpl implements PriorityBL {
	
	protected PriorityDAO priorityDAO;
	

	public PriorityDAO getPriorityDAO() {
		return priorityDAO;
	}

	public void setPriorityDAO(PriorityDAO priorityDAO) {
		this.priorityDAO = priorityDAO;
	}

	/**
     * �־û�����
     * @param priority ʵ��
     */
	public Priority savePriority(Priority priority) throws BLException{
		return priorityDAO.save(priority);
	}
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<Priority> findAllPriority() throws BLException{
		return priorityDAO.findAll();
	}
	
	/**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(PrioritySearchCond cond) throws BLException{
		return priorityDAO.getSearchCount(cond);
	}
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<Priority> findByCond(PrioritySearchCond cond, int start, int count) throws BLException{
		return priorityDAO.findByCond(cond, start, count);
	}
}
