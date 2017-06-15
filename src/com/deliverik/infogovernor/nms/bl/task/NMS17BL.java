/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS17Info;
import com.deliverik.infogovernor.nms.model.condition.NMS17SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS17TB;

/**
  * ����: ����������Ϣҵ���߼��ӿ�
  * ��������: ����������Ϣҵ���߼��ӿ�
  * ������¼: 2014/01/07
  * �޸ļ�¼: 
  */
public interface NMS17BL extends NMSBaseBL {

	/**
	 * ����������Ϣʵ��ȡ��
	 *
	 * @return ����������Ϣʵ��
	 */
	public NMS17TB getNMS17TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<NMS17Info> searchNMS17();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS17Info searchNMS17ByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS17SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS17Info> searchNMS17(
			NMS17SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS17Info registNMS17(NMS17Info instance)
		throws BLException;

	/**
     * ������������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public void registNMS17All(List<NMS17Info> instance)
            throws BLException;
            
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS17Info updateNMS17(NMS17Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteNMS17ByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteNMS17(NMS17Info instance)
		throws BLException;

}