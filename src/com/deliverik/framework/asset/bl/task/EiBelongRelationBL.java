/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.EiBelongRelationInfo;
import com.deliverik.framework.asset.model.EiBelongRelationVWInfo;
import com.deliverik.framework.asset.model.condition.EiBelongRelationSearchCond;
import com.deliverik.framework.asset.model.condition.EiBelongRelationVWSearchCond;
import com.deliverik.framework.asset.model.entity.EiBelongRelationTB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * ����: ����������ϵ��ҵ���߼��ӿ�
  * ��������: ����������ϵ��ҵ���߼��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiBelongRelationBL extends BaseBL {

	/**
	 * ����������ϵ��ʵ��ȡ��
	 *
	 * @return ����������ϵ��ʵ��
	 */
	public EiBelongRelationTB getEiBelongRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation();

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public EiBelongRelationInfo searchEiBelongRelationByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(EiBelongRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchEiBelongRelation(
			EiBelongRelationSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public EiBelongRelationInfo registEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EiBelongRelationInfo updateEiBelongRelation(EiBelongRelationInfo instance)
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
	public void deleteEiBelongRelation(EiBelongRelationInfo instance)
		throws BLException;
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationVWInfo> searchEiBelongRelationVW(EiBelongRelationVWSearchCond cond);
	
	/**
	 * ���ð�����ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EiBelongRelationInfo> searchMaxEiBelongRelation(EiBelongRelationSearchCond cond);

}