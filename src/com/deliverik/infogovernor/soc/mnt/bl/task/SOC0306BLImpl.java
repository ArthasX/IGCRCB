/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.SOC0306Info;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.SOC0306DAO;

/**
 * 
 * @Description:���������Ϣ��ͼBLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class SOC0306BLImpl extends BaseBLImpl implements
		SOC0306BL {

	protected SOC0306DAO soc0306DAO;
	/**
	 * soc0306DAO�趨
	 *
	 * @param soc0306DAO soc0306DAO
	 */
	public void setSoc0306DAO(SOC0306DAO soc0306DAO) {
		this.soc0306DAO = soc0306DAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param Soc0306ʵ����
	 * @return Soc0306ʵ����
	 */
	public SOC0306Info saveSoc0306(
			SOC0306Info soc0306Info) throws BLException {
		return soc0306DAO.save(soc0306Info);
	}

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public SOC0306Info findSoc0306ByPK(Integer id)
			throws BLException {
		return soc0306DAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<SOC0306Info> findAllSoc0306()
			throws BLException {
		return soc0306DAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0306SearchCond cond)
			throws BLException {
		return soc0306DAO.getSearchCount(cond);
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
	public List<SOC0306Info> findSoc0306ByCond(
			SOC0306SearchCond cond, int start, int count)
			throws BLException {
		return soc0306DAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param Soc0306ʵ����
	 */
	public void deleteSoc0306(SOC0306Info natureIuportAlarm)
			throws BLException {
		soc0306DAO.delete(natureIuportAlarm);
	}

	/**
	 * ��ѯȱʧ�����ܵ�������
	 * 
	 * @param yestoday
	 *            ���������
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List searchSymmetrixAlarm(String yestoday) {
		return soc0306DAO.searchSymmetrixAlarm(yestoday);
	}
}
