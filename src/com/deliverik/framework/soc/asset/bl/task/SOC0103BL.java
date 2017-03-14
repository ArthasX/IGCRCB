/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0137Info;
import com.deliverik.framework.soc.asset.model.SOC0103Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0103SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0103TB;

/**
  * ����: ��ƶԱȽ����Ϣ��ҵ���߼��ӿ�
  * ��������: ��ƶԱȽ����Ϣ��ҵ���߼��ӿ�
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
public interface SOC0103BL extends BaseBL {

	/**
	 * ��ƶԱȽ����Ϣ��ʵ��ȡ��
	 *
	 * @return ��ƶԱȽ����Ϣ��ʵ��
	 */
	public SOC0103TB getSOC0103Instance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0103Info> searchSOC0103();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0103Info searchSOC0103ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0103SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0103Info> searchSOC0103(
			SOC0103SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0103Info registSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0103Info updateSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0103ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0103(SOC0103Info instance)
		throws BLException;

	/**
	 * ���µ�ǰ����Ϊ������
	 *
	 * @param cond ��������
	 */
	public Integer updateSOC0103Without(SOC0103SearchCond cond)
		throws BLException;
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0137Info> searchAuditResultOne(
			SOC0103SearchCond cond)throws BLException;

}