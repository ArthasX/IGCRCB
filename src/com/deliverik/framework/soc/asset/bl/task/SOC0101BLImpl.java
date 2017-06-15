/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0101Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0101SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0101DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0101TB;

/**
  * ����: ����ʲ����Ա�ҵ���߼�ʵ��
  * ��������: ����ʲ����Ա�ҵ���߼�ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public class SOC0101BLImpl extends BaseBLImpl implements
		SOC0101BL {

	/** ����ʲ����Ա�DAO�ӿ� */
	protected SOC0101DAO soc0101DAO;
	
	/**
	 * ����ʲ����Ա�DAO�ӿ��趨
	 *
	 * @param soc0101DAO ����ʲ����Ա�DAO�ӿ�
	 */
	public void setsoc0101DAO(SOC0101DAO soc0101DAO) {
		this.soc0101DAO = soc0101DAO;
	}

	/**
	 * ����ʲ����Ա�ʵ��ȡ��
	 *
	 * @return ����ʲ����Ա�ʵ��
	 */
	public SOC0101TB getSOC0101Instance() {
		return new SOC0101TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0101Info> searchSOC0101() {
		return soc0101DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0101Info searchSOC0101ByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0101SearchCond cond) {
		return soc0101DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond) {
		return soc0101DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101(
			SOC0101SearchCond cond, int start,
			int count) {
		return soc0101DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0101Info registSOC0101(SOC0101Info instance)
		throws BLException {
		return soc0101DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0101Info updateSOC0101(SOC0101Info instance)
		throws BLException {
		checkExistInstance(instance.getCiid());
		return soc0101DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0101ByPK(Integer pk)
		throws BLException {
		soc0101DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0101(SOC0101Info instance)
		throws BLException {
		soc0101DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0101Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0101Info instance = soc0101DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	/**
	 * �����ʲ����Լ����ԶԱȷ���
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0101Info> searchSOC0101ForAucmptype(Integer eiid){
		return soc0101DAO.searchSOC0101ForAucmptype(eiid);
	}

	/**
	 * ��ձ�����
	 *
	 * @return ִ������
	 */
	public Integer deleteSOC0101(){
		return soc0101DAO.deleteSOC0101();
	}

}