/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG394Info;
import com.deliverik.framework.workflow.prr.model.condition.IG394SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG394TB;

/**
  * ����: ���Ѽ�¼��ҵ���߼��ӿ�
  * ��������: ���Ѽ�¼��ҵ���߼��ӿ�
  * ������¼: 2012/04/25
  * �޸ļ�¼: 
  */
public interface IG394BL extends BaseBL {

	/**
	 * ���Ѽ�¼��ʵ��ȡ��
	 *
	 * @return ���Ѽ�¼��ʵ��
	 */
	public IG394TB getIG394TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG394Info> searchIG394Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG394Info searchIG394InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG394SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG394Info> searchIG394Info(
			IG394SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param ig394Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG394Info registIG394Info(IG394Info ig394Info)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param ig394Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG394Info updateIG394Info(IG394Info ig394Info)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG394InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param ig394Info ɾ��ʵ��
	 */
	public void deleteIG394Info(IG394Info ig394Info)
		throws BLException;

}