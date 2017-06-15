/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCondImpl;
import com.deliverik.infogovernor.drm.model.dao.SOC0507DAO;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * ����: Ԥ����Ϣ��ҵ���߼�ʵ��
  * ��������: Ԥ����Ϣ��ҵ���߼�ʵ��
  * ������¼: 2016/07/15
  * �޸ļ�¼: 
  */
public class SOC0507BLImpl extends BaseBLImpl implements
		SOC0507BL {

	/** Ԥ����Ϣ��DAO�ӿ� */
	protected SOC0507DAO soc0507DAO;
	

	public void setSoc0507DAO(SOC0507DAO soc0507dao) {
		soc0507DAO = soc0507dao;
	}

	/**
	 * Ԥ����Ϣ��ʵ��ȡ��
	 *
	 * @return Ԥ����Ϣ��ʵ��
	 */
	public SOC0507TB getSOC0507TBInstance() {
		return new SOC0507TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0507Info> searchSOC0507() {
		return soc0507DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0507Info searchSOC0507ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0507SearchCond cond) {
		return soc0507DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond) {
		return soc0507DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond, int start,
			int count) {
		return soc0507DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0507Info registSOC0507(SOC0507Info instance)
		throws BLException {
		return soc0507DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0507Info updateSOC0507(SOC0507Info instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return soc0507DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0507ByPK(Integer pk)
		throws BLException {
		soc0507DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0507(SOC0507Info instance)
		throws BLException {
		soc0507DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0507Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0507Info instance = soc0507DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * ����Ԥ��id��Ŀ¼id��ѯָ��Ŀ¼����
	 * 
	 * @param cid
	 * @param eiid
	 * @return
	 * @throws BLException
	 */
	public SOC0507Info getPlanContent(String cid, Integer eiid) throws BLException {
		SOC0507SearchCondImpl cond = new SOC0507SearchCondImpl();

		cond.setCid(cid);

		cond.setEiid(eiid);

		List<SOC0507Info> soc0507List = this.soc0507DAO.findByCond(cond, 0, 0);

		return soc0507List.size() > 0 ? soc0507List.get(0) : null;

	}

}