/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;

/**
  * ����: ����״̬��˽�б�Ĭ��ֵ��ҵ���߼��ӿ�
  * ��������: ����״̬��˽�б�Ĭ��ֵ��ҵ���߼��ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG560BL extends BaseBL {

	/**
	 * ����״̬��˽�б�Ĭ��ֵ��ʵ��ȡ��
	 *
	 * @return ����״̬��˽�б�Ĭ��ֵ��ʵ��
	 */
	public IG560TB getIG560TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG560Info> searchIG560();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG560Info searchIG560ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG560SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG560Info> searchIG560(
			IG560SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG560Info registIG560(IG560Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG560Info updateIG560(IG560Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG560ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG560(IG560Info instance)
		throws BLException;

	
	public List<IG560VWInfo> searchIG560VW(IG560SearchCondImpl cond)throws BLException;

	public void saveOrUpdateAll(List<IG560Info> list)throws BLException;

}