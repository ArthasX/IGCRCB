/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCondImpl;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.asset.model.dao.EiBelongRelationDAO;
import com.deliverik.framework.asset.model.entity.EiBelongRelationTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;

/**
  * ����: ����������ϵ��ҵ���߼�ʵ��
  * ��������: ����������ϵ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class EiBelongRelationBLImpl extends BaseBLImpl implements
		EiBelongRelationBL {

	/** ����������ϵ��DAO�ӿ� */
	protected EiBelongRelationDAO eiBelongRelationDAO;
	
	/**
	 * ����������ϵ��DAO�ӿ��趨
	 *
	 * @param eiBelongRelationDAO����������ϵ��DAO�ӿ�
	 */
	public void setEiBelongRelationDAO(EiBelongRelationDAO eiBelongRelationDAO) {
		this.eiBelongRelationDAO = eiBelongRelationDAO;
	}

	/**
	 * ����������ϵ��ʵ��ȡ��
	 *
	 * @return ����������ϵ��ʵ��
	 */
	public EiBelongRelationTB getEiBelongRelationTBInstance() {
		return new EiBelongRelationTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation() {
		return eiBelongRelationDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiBelongRelationInfo searchEiBelongRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiBelongRelationSearchCond cond) {
		return eiBelongRelationDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation(
			EiBelongRelationSearchCond cond) {
		return eiBelongRelationDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation(
			EiBelongRelationSearchCond cond, int start,
			int count) {
		return eiBelongRelationDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiBelongRelationInfo registEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		return eiBelongRelationDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiBelongRelationInfo updateEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		checkExistInstance(instance.getBrid());
		return eiBelongRelationDAO.save(instance);
	}
	
	/**
	 * �ʲ�������ϵ��Ϣ�汾��������
	 * 
	 * @param eiid ����ʲ�ID
	 * @param eiversion ��ϵ�����ʲ����´�汾
	 * @param eismallversion �رձ����ʲ�����С�汾
	 * @param neweiversion �ʲ����´�汾
	 * @param neweismallversion �ʲ�����С�汾
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		EiBelongRelationSearchCondImpl condPar = new EiBelongRelationSearchCondImpl();
		condPar.setBrpareiid(eiid.toString());//�ʲ�ID
		condPar.setBrparversion(eiversion.toString());//�ʲ���汾
		condPar.setBrparsmallversion(eismallversion.toString());//�ʲ�С�汾
		List<EiBelongRelationInfo> eirList = this.searchMaxEiBelongRelation(condPar);
		EiBelongRelationTB eirTB = null;
		for(EiBelongRelationInfo eir : eirList) {
			eirTB = (EiBelongRelationTB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrparversion(neweiversion);
			eirTB.setBrparsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.eiBelongRelationDAO.save(eirTB);
		}
		//������ϵ�����ʲ����°汾��ϵ������
		EiBelongRelationSearchCondImpl condCld = new EiBelongRelationSearchCondImpl();
		condCld.setBrcldeiid(eiid.toString());//�ʲ�ID
		condCld.setBrcldversion(eiversion.toString());//�ʲ���汾
		condCld.setBrcldsmallversion(eismallversion.toString());//�ʲ�С�汾
		eirList = this.searchMaxEiBelongRelation(condCld);
		for(EiBelongRelationInfo eir : eirList) {
			eirTB = (EiBelongRelationTB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrcldversion(neweiversion);
			eirTB.setBrcldsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.eiBelongRelationDAO.save(eirTB);
		}
		
	}


	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException {
		eiBelongRelationDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException {
		eiBelongRelationDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public EiBelongRelationInfo checkExistInstance(Integer pk)
		throws BLException {
		EiBelongRelationInfo instance = eiBelongRelationDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(EiBelongRelationVWSearchCond cond) {
		return this.eiBelongRelationDAO.searchEiBelongRelationVW(cond);
	}
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(EiBelongRelationSearchCond cond) {
		return this.eiBelongRelationDAO.searchMaxEiBelongRelation(cond);
	}

}