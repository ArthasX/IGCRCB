/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.risk.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.risk.model.CheckInfoEntityInfo;
import com.deliverik.infogovernor.risk.model.condition.CheckInfoEntitySearchCond;
import com.deliverik.infogovernor.risk.model.entity.CheckInfoEntityTB;

/**
  * ����: �����Թ����ʲ���ҵ���߼��ӿ�
  * ��������: �����Թ����ʲ���ҵ���߼��ӿ�
  * ������¼: 2014/09/02
  * �޸ļ�¼: 
  */
public interface CheckInfoEntityBL extends BaseBL {

	/**
	 * �����Թ����ʲ���ʵ��ȡ��
	 *
	 * @return �����Թ����ʲ���ʵ��
	 */
	public CheckInfoEntityTB getCheckInfoEntityTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public CheckInfoEntityInfo searchCheckInfoEntityByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(CheckInfoEntitySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity(
			CheckInfoEntitySearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CheckInfoEntityInfo> searchCheckInfoEntity(
			CheckInfoEntitySearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public CheckInfoEntityInfo registCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public CheckInfoEntityInfo updateCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteCheckInfoEntityByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteCheckInfoEntity(CheckInfoEntityInfo instance)
		throws BLException;

}