/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;
import com.deliverik.infogovernor.dwp.model.condition.IGDWP0003SearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����Ϣʵ��BL�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGDWP0003BL extends BaseBL{

	/**
	 * ������������
	 * @param pk ����
	 * @return �������
	 */
	public IGDWP0003Info searchByPk(Integer pk) throws BLException;
	
	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IGDWP0003SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IGDWP0003Info> search(IGDWP0003SearchCond cond,int start, int count);
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IGDWP0003Info regist(IGDWP0003Info instance) throws BLException;
	
	/**
	 * �޸Ĵ���
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IGDWP0003Info update(IGDWP0003Info instance) throws BLException;
	
	/**
	 * ɾ������
	 * @param pk ����
	 */
	public void delete(Integer pk) throws BLException;
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void delete(IGDWP0003Info instance) throws BLException;
}
