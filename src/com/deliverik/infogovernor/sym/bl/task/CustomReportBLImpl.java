/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCond;
import com.deliverik.infogovernor.sym.model.dao.CustomReportDAO;

/**
 * 
 * @Description:���Ʊ���ʵ��BLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class CustomReportBLImpl extends BaseBLImpl implements CustomReportBL {
	
	protected CustomReportDAO customReportDAO;
	

	public void setCustomReportDAO(CustomReportDAO customReportDAO) {
		this.customReportDAO = customReportDAO;
	}

	/**
     * �־û�����
     * @param hacProcess ʵ��
     */
	public CustomReport saveProject(CustomReport hacProcess) throws BLException{
		return customReportDAO.save(hacProcess);
	}
	
	/**
     * ������������
     * @param id ����
     * @return �������
     */
	public CustomReport findByPK(Integer hpid) throws BLException{
		return customReportDAO.findByPK(hpid);
	}
	
	/**
     * ȫ������
     * @return ���������
     */
	public List<CustomReport> findAllProject() throws BLException{
		return customReportDAO.findAll();
	}
	
	/**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
	public int getSearchCount(CustomReportSearchCond cond) throws BLException{
		return customReportDAO.getSearchCount(cond);
	}
	
	/**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
	public List<CustomReport> findByCond(CustomReportSearchCond cond, int start, int count) throws BLException{
		return customReportDAO.findByCond(cond, start, count);
	}
	
	/**
     * ɾ������
     * @param crid ����
     */
	public void deleteProject(Integer crid) throws BLException{
		CustomReport customReport = findByPK(crid);
		customReportDAO.delete(customReport);
	}

}
