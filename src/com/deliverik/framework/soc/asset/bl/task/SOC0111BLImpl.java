/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0111SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0111DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0111PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0111TB;

/**
  * ����: �ʲ������ҵ���߼�ʵ��
  * ��������: �ʲ������ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0111BLImpl extends BaseBLImpl implements
		SOC0111BL {

	/** �ʲ������DAO�ӿ� */
	protected SOC0111DAO soc0111DAO;
	
	/**
	 * �ʲ������DAO�ӿ��趨
	 *
	 * @param eiDomainDefDAO�ʲ������DAO�ӿ�
	 */
	public void setSoc0111DAO(SOC0111DAO soc0111DAO) {
		this.soc0111DAO = soc0111DAO;
	}

	/**
	 * �ʲ������ʵ��ȡ��
	 *
	 * @return �ʲ������ʵ��
	 */
	public SOC0111TB getEiDomainDefTBInstance() {
		return new SOC0111TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0111Info> searchEiDomainDef() {
		return soc0111DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0111Info searchEiDomainDefByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0111SearchCond cond) {
		return soc0111DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond) {
		return soc0111DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0111Info> searchEiDomainDef(
			SOC0111SearchCond cond, int start,
			int count) {
		return soc0111DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0111Info registEiDomainDef(SOC0111Info instance)
		throws BLException {
		return soc0111DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0111Info updateEiDomainDef(SOC0111Info instance)
		throws BLException {
		checkExistInstance(new SOC0111PK(instance.getEiddid(),instance.getVersion()));
		return soc0111DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException {
		soc0111DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDef(SOC0111Info instance)
		throws BLException {
		soc0111DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0111Info checkExistInstance(Serializable pk)
		throws BLException {
		SOC0111Info instance = soc0111DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "�ʲ��������");
		}
		return instance;
	}
	/**
	 * ��ѯ���EiddId
	 * @return 
	 * @throws BLException
	 */
	public Integer findMaxEiddId() throws BLException{
		return soc0111DAO.findMaxEiddId();
	}
	
	/**
	 * ��ȡ���°汾��
	 * @param eiddid ��ID
	 * @return ���°汾��
	 * @throws BLException 
	 */
	public SOC0111Info searchDomainMaxVersion(Integer eiddid) throws BLException {
		SOC0111SearchCondImpl cond = new SOC0111SearchCondImpl();
		cond.setEiddid_eq(eiddid.toString());
		List<SOC0111Info> eiDomainDefList = this.searchEiDomainDef(cond);
		if(eiDomainDefList.size() != 1) {
			throw new BLException("IGCO10000.E004", "�ʲ��������");
		}
		return eiDomainDefList.get(0);
	}

	/**
	 * ��ȡ�ʲ�����汾
	 * @param eiddid
	 * @param version
	 * @return
	 * @throws BLException
	 */
	public List<SOC0111Info> searchEiDomainDefByPK(Integer eiddid,
			Integer version) throws BLException {
		return soc0111DAO.searchEiDomainDefByPK(eiddid,version);
	}
}