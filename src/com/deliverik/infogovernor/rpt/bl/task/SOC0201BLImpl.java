/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCond;
import com.deliverik.infogovernor.rpt.model.dao.SOC0201DAO;

/**
 * 
 * @Description:�Զ��������ɱ�BLʵ����
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��REPORT_GDATA_ITEMBLImpl������ΪSOC0201BLImpl
 */
public class SOC0201BLImpl extends BaseBLImpl implements
		SOC0201BL {

	protected SOC0201DAO soc0201DAO;
	
	

	public void setSoc0201DAO(SOC0201DAO soc0201DAO) {
		this.soc0201DAO = soc0201DAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param SOC0201ʵ����
	 * @return SOC0201ʵ����
	 */
	public SOC0201Info saveSOC0201(
			SOC0201Info soc0201) throws BLException {
		return soc0201DAO.save(soc0201);
	}

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public SOC0201Info findSOC0201ByPK(Integer id)
			throws BLException {
		return soc0201DAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<SOC0201Info> findAllSOC0201()
			throws BLException {
		return soc0201DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0201SearchCond cond)
			throws BLException {
		return soc0201DAO.getSearchCount(cond);
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
	public List<SOC0201Info> findSOC0201ByCond(
			SOC0201SearchCond cond, int start, int count)
			throws BLException {
		return soc0201DAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param SOC0201ʵ����
	 */
	public void deleteSOC0201(SOC0201Info soc0201)
			throws BLException {
		soc0201DAO.delete(soc0201);
	}

}
