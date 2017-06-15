/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0110DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;
import com.deliverik.framework.utility.IGStringUtils;

/**
  * ����: ����������ϵ��ҵ���߼�ʵ��
  * ��������: ����������ϵ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0110BLImpl extends BaseBLImpl implements
		SOC0110BL {

	/** ����������ϵ��DAO�ӿ� */
	protected SOC0110DAO soc0110DAO;
	


	/**
	 * ����������ϵ��DAO�ӿ��趨
	 *
	 * @param soc0110DAO ����������ϵ��DAO�ӿ�
	 */
	public void setSoc0110DAO(SOC0110DAO soc0110DAO) {
		this.soc0110DAO = soc0110DAO;
	}

	/**
	 * ����������ϵ��ʵ��ȡ��
	 *
	 * @return ����������ϵ��ʵ��
	 */
	public SOC0110TB getEiBelongRelationTBInstance() {
		return new SOC0110TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0110Info> searchEiBelongRelation() {
		return soc0110DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0110Info searchEiBelongRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0110SearchCond cond) {
		return soc0110DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond) {
		return soc0110DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ݸ���ѯ���д��ڵĹ�ϵ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond){
		return soc0110DAO.searchBrassetrelationByBrpareiid(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond, int start,
			int count) {
		return soc0110DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0110Info registEiBelongRelation(SOC0110Info instance)
		throws BLException {
		return soc0110DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0110Info updateEiBelongRelation(SOC0110Info instance)
		throws BLException {
		checkExistInstance(instance.getBrid());
		return soc0110DAO.save(instance);
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
		SOC0110SearchCondImpl condPar = new SOC0110SearchCondImpl();
		condPar.setBrpareiid(eiid.toString());//�ʲ�ID
		condPar.setBrparversion(eiversion.toString());//�ʲ���汾
		condPar.setBrparsmallversion(eismallversion.toString());//�ʲ�С�汾
		List<SOC0110Info> eirList = this.searchMaxEiBelongRelation(condPar);
		SOC0110TB eirTB = null;
		for(SOC0110Info eir : eirList) {
			eirTB = (SOC0110TB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrparversion(neweiversion);
			eirTB.setBrparsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.soc0110DAO.save(eirTB);
		}
		//������ϵ�����ʲ����°汾��ϵ������
		SOC0110SearchCondImpl condCld = new SOC0110SearchCondImpl();
		condCld.setBrcldeiid(eiid.toString());//�ʲ�ID
		condCld.setBrcldversion(eiversion.toString());//�ʲ���汾
		condCld.setBrcldsmallversion(eismallversion.toString());//�ʲ�С�汾
		eirList = this.searchMaxEiBelongRelation(condCld);
		for(SOC0110Info eir : eirList) {
			eirTB = (SOC0110TB)SerializationUtils.clone(eir);
			eirTB.setBrid(null);
			eirTB.setBrcldversion(neweiversion);
			eirTB.setBrcldsmallversion(neweismallversion);
			eirTB.setBrcreatetime(dataTime);
			this.soc0110DAO.save(eirTB);
		}
		
	}


	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException {
		soc0110DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiBelongRelation(SOC0110Info instance)
		throws BLException {
		soc0110DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0110Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0110Info instance = soc0110DAO.findByPK(pk);
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
	public List<SOC0127Info> searchEiBelongRelationVW(SOC0127SearchCond cond) {
		return this.soc0110DAO.searchEiBelongRelationVW(cond);
	}
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(SOC0127SearchCond cond) {
		return this.soc0110DAO.searchEiBelongRelationVW2(cond);
	}
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(SOC0110SearchCond cond) {
		return this.soc0110DAO.searchMaxEiBelongRelation(cond);
	}

	/**
	 * ���ݶ����豸��ѯ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond){
		return this.soc0110DAO.searchInBrassetrelationByEirootmark(cond);
	}

	public void delByEiid(Integer eiid) {
		this.soc0110DAO.delByEiid(eiid);
		
	}
}