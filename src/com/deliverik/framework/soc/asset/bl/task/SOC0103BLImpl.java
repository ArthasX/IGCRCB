/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0103DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * ����: ��ƶԱȽ����Ϣ��ҵ���߼�ʵ��
  * ��������: ��ƶԱȽ����Ϣ��ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0103BLImpl extends BaseBLImpl implements
		SOC0103BL {

	/** ��ƶԱȽ����Ϣ��DAO�ӿ� */
	protected SOC0103DAO soc0103DAO;
	
	/**
	 * ��ƶԱȽ����Ϣ��DAO�ӿ��趨
	 *
	 * @param soc0103DAO ��ƶԱȽ����Ϣ��DAO�ӿ�
	 */
	public void setsoc0103DAO(SOC0103DAO soc0103DAO) {
		this.soc0103DAO = soc0103DAO;
	}

	/**
	 * ��ƶԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return ��ƶԱȽ����Ϣ��ʵ��
	 */
	public SOC0103TB getSOC0103Instance() {
		return new SOC0103TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0103Info> searchSOC0103() {
		return soc0103DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0103Info searchSOC0103ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0103SearchCond cond) {
		return soc0103DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond) {
		return soc0103DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond, int start,
			int count) {
		return soc0103DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0103Info registSOC0103(SOC0103Info instance)
		throws BLException {
		return soc0103DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0103Info updateSOC0103(SOC0103Info instance)
		throws BLException {
		checkExistInstance(instance.getAurid());
		return soc0103DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0103ByPK(Integer pk)
		throws BLException {
		soc0103DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0103(SOC0103Info instance)
		throws BLException {
		soc0103DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0103Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0103Info instance = soc0103DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException{
		return soc0103DAO.updateSOC0103Without(cond);
	}
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0137Info> searchAuditResultOne(SOC0103SearchCond cond)
			throws BLException {
		return soc0103DAO.findByCondOne(cond);
	}

}