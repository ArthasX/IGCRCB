/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0123SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0123DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;

/**
  * ����: �ʲ�ģ����ͼҵ���߼�ʵ��
  * ��������: �ʲ�ģ����ͼҵ���߼�ʵ��
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public class SOC0123BLImpl extends BaseBLImpl implements
		SOC0123BL {

	/** �ʲ�ģ����ͼDAO�ӿ� */
	protected SOC0123DAO soc0123DAO;
	


	/**
	 * �ʲ�ģ����ͼDAO�ӿ��趨
	 *
	 * @param soc0123DAO �ʲ�ģ����ͼDAO�ӿ�
	 */
	public void setSoc0123DAO(SOC0123DAO soc0123DAO) {
		this.soc0123DAO = soc0123DAO;
	}

	/**
	 * �ʲ�ģ����ͼʵ��ȡ��
	 *
	 * @return �ʲ�ģ����ͼʵ��
	 */
	public SOC0123VW getEntityItemEntityVWTBInstance() {
		return new SOC0123VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0123Info> searchEntityItemEntityVW() {
		return soc0123DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0123Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0123SearchCond cond) {
		return soc0123DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond) {
		return soc0123DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0123Info> searchEntityItemEntityVW(
			SOC0123SearchCond cond, int start,
			int count) {
		return soc0123DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0123Info registEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		return soc0123DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0123Info updateEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		checkExistInstance(instance.getEiid());
		return soc0123DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEntityItemEntityVWByPK(Integer pk)
		throws BLException {
		soc0123DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEntityItemEntityVW(SOC0123Info instance)
		throws BLException {
		soc0123DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0123Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0123Info instance = soc0123DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}