/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.condition.NMS05SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS05PK;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸���ϵ��Ϣʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS05BL extends NMSBaseBL {	
	
	/**
	 * ���洦��
	 */
	public void upateVersion();
	
	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS05Info searchByPK(NMS05PK pk) throws BLException;
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS05SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS05Info> search(NMS05SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS05Info> search(NMS05SearchCond cond, int start,int count);
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS05Info regist(NMS05Info instance) throws BLException;
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS05Info> regist(List<NMS05Info> instances) throws BLException;
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS05Info update(NMS05Info instance) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(NMS05PK pk) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS05Info instance) throws BLException;
	
	/**
	 * ɾ����
	 */
	public void dropTable();
}
