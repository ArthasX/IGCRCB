/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.Priority;
import com.deliverik.infogovernor.sym.model.condition.PrioritySearchCond;
/**
 * ����:���ȼ�BL�ӿ�
 * ����������1.�־û�����
 * 			2.ȫ������
 * 			3.���������������ȡ��
 * 			4.������������
 * 			5.��������ѯ
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */

public interface PriorityBL extends BaseBL{
	
	/**
     * �־û�����
     * @param hacProcess ʵ��
     */
	public Priority savePriority(Priority priority) throws BLException;
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<Priority> findAllPriority() throws BLException;
	
	/**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(PrioritySearchCond cond) throws BLException;
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<Priority> findByCond(PrioritySearchCond cond, int start, int count) throws BLException;
}
