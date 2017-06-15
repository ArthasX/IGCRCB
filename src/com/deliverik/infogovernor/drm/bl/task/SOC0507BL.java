/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.SOC0507Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0507SearchCond;
import com.deliverik.infogovernor.drm.model.entity.SOC0507TB;

/**
  * ����: Ԥ����Ϣ��ҵ���߼��ӿ�
  * ��������: Ԥ����Ϣ��ҵ���߼��ӿ�
  * ������¼: 2016/07/15
  * �޸ļ�¼: 
  */
public interface SOC0507BL extends BaseBL {

	/**
	 * Ԥ����Ϣ��ʵ��ȡ��
	 *
	 * @return Ԥ����Ϣ��ʵ��
	 */
	public SOC0507TB getSOC0507TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0507Info> searchSOC0507();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0507Info searchSOC0507ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0507SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0507Info> searchSOC0507(
			SOC0507SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0507Info registSOC0507(SOC0507Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0507Info updateSOC0507(SOC0507Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0507ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0507(SOC0507Info instance)
		throws BLException;
	/**
	 * ����Ԥ��id��Ŀ¼id��ѯָ��Ŀ¼����
	 * 
	 * @param cid
	 * @param eiid
	 * @return
	 * @throws BLException
	 */
	public SOC0507Info getPlanContent(String cid, Integer eiid) throws BLException;
}