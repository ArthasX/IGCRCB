/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Ϣ����BL
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface WorkFlowMessageGeneratorBL extends BaseBL{
	
	/**
	 * ��ʼ������
	 * @param psname ״̬����
	 */
	public void init(Integer prid,String psname) throws BLException;

	/**
	 * ������Ϣ����
	 * @param prid ��������
	 * @return ������Ϣ
	 * @throws BLException
	 */
	public String titleGenerator() throws BLException;
	
	/**
	 * �ʼ���������
	 * @param prid ��������
	 * @return �ʼ���������
	 * @throws BLException
	 */
	public String contentGenerator() throws BLException;
	
	/**
	 * ������������
	 * @param prid ��������
	 * @return ��������
	 * @throws BLException
	 */
	public String smsGenerator() throws BLException;
}
