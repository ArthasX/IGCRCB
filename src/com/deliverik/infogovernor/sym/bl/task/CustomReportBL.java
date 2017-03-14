/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCond;

/**
 * 
 * @Description:���Ʊ���ʵ��BL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface CustomReportBL extends BaseBL{
	
	/**
     * �־û�����
     * @param hacProcess ʵ��
     */
	public CustomReport saveProject(CustomReport hacProcess) throws BLException;
	
	/**
     * ������������
     * @param id ����
     * @return �������
     */
	public CustomReport findByPK(Integer hpid) throws BLException;
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<CustomReport> findAllProject() throws BLException;
	
	/**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(CustomReportSearchCond cond) throws BLException;
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<CustomReport> findByCond(CustomReportSearchCond cond, int start, int count) throws BLException;
	
	/**
     * ɾ������
     * @param crid ����
     */
	public void deleteProject(Integer crid) throws BLException;
}
