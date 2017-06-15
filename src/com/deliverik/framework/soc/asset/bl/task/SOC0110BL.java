/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0127Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0110SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0127SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0110TB;

/**
  * ����: ����������ϵ��ҵ���߼��ӿ�
  * ��������: ����������ϵ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0110BL extends BaseBL {

	/**
	 * ����������ϵ��ʵ��ȡ��
	 *
	 * @return ����������ϵ��ʵ��
	 */
	public SOC0110TB getEiBelongRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0110Info> searchEiBelongRelation();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0110Info searchEiBelongRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0110SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchEiBelongRelation(
			SOC0110SearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0110Info registEiBelongRelation(SOC0110Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0110Info updateEiBelongRelation(SOC0110Info instance)
		throws BLException;
	
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
			Integer neweiversion, Integer neweismallversion) throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteEiBelongRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteEiBelongRelation(SOC0110Info instance)
		throws BLException;
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0127Info> searchEiBelongRelationVW(SOC0127SearchCond cond);
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0127Info> searchEiBelongRelationVW2(SOC0127SearchCond cond);
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchMaxEiBelongRelation(SOC0110SearchCond cond);
	
	/**
	 * ���ݸ���ѯ���д��ڵĹ�ϵ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<String> searchBrassetrelationByBrpareiid(final SOC0110SearchCond cond);
	
	/**
	 * ���ݶ����豸��ѯ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0110Info> searchInBrassetrelationByEirootmark(final SOC0110SearchCondImpl cond);

	public void delByEiid(Integer eiid);

}