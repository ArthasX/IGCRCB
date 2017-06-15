/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDefInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCond;
import com.deliverik.framework.asset.model.condition.EiDomainDefSearchCondImpl;
import com.deliverik.framework.asset.model.dao.EiDomainDefDAO;
import com.deliverik.framework.asset.model.entity.EiDomainDefPK;
import com.deliverik.framework.asset.model.entity.EiDomainDefTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;

/**
  * ����: �ʲ������ҵ���߼�ʵ��
  * ��������: �ʲ������ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiDomainDefBLImpl extends BaseBLImpl implements
		EiDomainDefBL {

	/** �ʲ������DAO�ӿ� */
	protected EiDomainDefDAO eiDomainDefDAO;
	
	/**
	 * �ʲ������DAO�ӿ��趨
	 *
	 * @param eiDomainDefDAO�ʲ������DAO�ӿ�
	 */
	public void setEiDomainDefDAO(EiDomainDefDAO eiDomainDefDAO) {
		this.eiDomainDefDAO = eiDomainDefDAO;
	}

	/**
	 * �ʲ������ʵ��ȡ��
	 *
	 * @return �ʲ������ʵ��
	 */
	public EiDomainDefTB getEiDomainDefTBInstance() {
		return new EiDomainDefTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiDomainDefInfo> searchEiDomainDef() {
		return eiDomainDefDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiDomainDefInfo searchEiDomainDefByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiDomainDefSearchCond cond) {
		return eiDomainDefDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond) {
		return eiDomainDefDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiDomainDefInfo> searchEiDomainDef(
			EiDomainDefSearchCond cond, int start,
			int count) {
		return eiDomainDefDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiDomainDefInfo registEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		return eiDomainDefDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiDomainDefInfo updateEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		checkExistInstance(new EiDomainDefPK(instance.getEiddid(),instance.getVersion()));
		return eiDomainDefDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiDomainDefByPK(Serializable pk)
		throws BLException {
		eiDomainDefDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiDomainDef(EiDomainDefInfo instance)
		throws BLException {
		eiDomainDefDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public EiDomainDefInfo checkExistInstance(Serializable pk)
		throws BLException {
		EiDomainDefInfo instance = eiDomainDefDAO.findByPK(pk);
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
		return eiDomainDefDAO.findMaxEiddId();
	}
	
	/**
	 * ��ȡ���°汾��
	 * @param eiddid ��ID
	 * @return ���°汾��
	 * @throws BLException 
	 */
	public EiDomainDefInfo searchDomainMaxVersion(Integer eiddid) throws BLException {
		EiDomainDefSearchCondImpl cond = new EiDomainDefSearchCondImpl();
		cond.setEiddid_eq(eiddid.toString());
		List<EiDomainDefInfo> eiDomainDefList = this.searchEiDomainDef(cond);
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
	public List<EiDomainDefInfo> searchEiDomainDefByPK(Integer eiddid,
			Integer version) throws BLException {
		return eiDomainDefDAO.searchEiDomainDefByPK(eiddid,version);
	}
}