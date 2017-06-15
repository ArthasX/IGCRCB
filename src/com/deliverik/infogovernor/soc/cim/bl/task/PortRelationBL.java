/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.cim.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.model.PortRelationInfo;
import com.deliverik.infogovernor.soc.model.condition.PortRelationSearchCond;
import com.deliverik.infogovernor.soc.model.entity.PortRelationPK;
import com.deliverik.infogovernor.soc.model.entity.PortRelationTB;

/**
  * ����: �˵��˹�ϵ��ҵ���߼��ӿ�
  * ��������: �˵��˹�ϵ��ҵ���߼��ӿ�
  * ������¼: 2013/01/17
  * �޸ļ�¼: 
  */
public interface PortRelationBL extends BaseBL {

	/**
	 * �˵��˹�ϵ��ʵ��ȡ��
	 *
	 * @return �˵��˹�ϵ��ʵ��
	 */
	public PortRelationTB getPortRelationTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<PortRelationInfo> searchPortRelation();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public PortRelationInfo searchPortRelationByPK(PortRelationPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(PortRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<PortRelationInfo> searchPortRelation(
			PortRelationSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public PortRelationInfo registPortRelation(PortRelationInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public PortRelationInfo updatePortRelation(PortRelationInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deletePortRelationByPK(PortRelationPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deletePortRelation(PortRelationInfo instance)
		throws BLException;
	/**
	 * ʣ��hyper��ѯ
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationStr(
			PortRelationSearchCond cond);
	/**
	 * ҵ��ϵͳ��ѯ
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationBuss(
			PortRelationSearchCond cond);
	
	/**
	 * ����&HBA�ؼ��ֲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHost(
			PortRelationSearchCond cond);
	/**
	 * �������ؼ��ֲ�ѯ
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationSwitch(
			PortRelationSearchCond cond);
	/**
	 * FA
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationFa(
			PortRelationSearchCond cond);
	/**
	 * ��ѯmeta��geteKeeper
	 * @param cond
	 * @return
	 */
	public List<String> searchPortRelationHyper(
			PortRelationSearchCond cond);
	/**
	 * ��·��ѯHyper�õ�FAeiid
	 * @param eiid
	 * @return
	 */
	public List<String> getHypeEiid(final String eiid,final String einame);
	
}