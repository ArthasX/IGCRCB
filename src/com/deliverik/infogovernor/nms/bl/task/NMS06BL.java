/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS06Info;
import com.deliverik.infogovernor.nms.model.condition.NMS06SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸MAC/IP��Ϣʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS06BL extends NMSBaseBL {

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public NMS06Info searchByPK(String pk) throws BLException;
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS06SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<NMS06Info> search(NMS06SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS06Info> search(NMS06SearchCond cond, int start,int count);
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public NMS06Info regist(NMS06Info instance) throws BLException;
	
	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public List<NMS06Info> regist(List<NMS06Info> instances) throws BLException;
	
	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public NMS06Info update(NMS06Info instance) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void delete(String pk) throws BLException;
	
	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void delete(NMS06Info instance) throws BLException;
}
