/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS03Info;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����������Ϣʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS03BL extends NMSBaseBL {

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS03Info searchByPK(Integer pk) throws BLException;
	
	/**
	 * ���°汾����
	 * @return ���°汾
	 */
	public List<NMS03Info> searchNewest(NMS03SearchCond cond);
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS03SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS03Info> search(NMS03SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS03Info> search(NMS03SearchCond cond, int start,int count);
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS03Info regist(NMS03Info instance) throws BLException;
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS03Info> regist(List<NMS03Info> instances) throws BLException;
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS03Info update(NMS03Info instance) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS03Info instance) throws BLException;
}
