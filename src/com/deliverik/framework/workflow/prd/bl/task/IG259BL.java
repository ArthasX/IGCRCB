/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;

/**
 * <p>
 * ����ģ����Ϣ����ҵ���߼� 
 * </p>
 */

public interface IG259BL extends BaseBL {
	
	/**
	 * ������ģ��ʵ��
	 * 
	 * @return ProcessTemplateTB
	 * @throws BLException
	 */
	
	public IG259TB getIG259TBInstance();

	/**
	 * �����������ͻ�ȡ����ģ����Ϣ 
	 * @param processType ��������
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	
	public IG259Info searchIG259ByPrType(String processType);
	
	/**
	 * ������������ģ����Ϣ
	 * @param cond ����ģ����Ϣ��������
	 * @return ����ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond);
	
	/**
	 * ������������ģ����Ϣ
	 * @param cond ����ģ����Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ����ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<IG259Info> searchIG259Info(IG259SearchCond cond, int start, int count);
	
	/**
	 * ��������ģ��ID��ȡ����ģ��
	 * @param ptid ����ģ��ID
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info searchIG259InfoByKey(Integer ptid) throws BLException;
	
	/**
	 * ��������ģ�崦��
	 * 
	 * @param ig259Info ��������
	 * @return ����ģ����Ϣ
	 */
	
	public IG259Info registIG259Info(
			IG259Info ig259Info) throws BLException;
	
	/**
	 * ɾ������
	 * 
	 * @param ptid ����ģ��ID
	 * @return
	 */
	
	public void deleteIG259InfoByKey(Integer ptid) throws BLException;
	
	/**
	 * �������
	 * 
	 * @param processTemplate �������
	 * @return ����״̬ԾǨ����
	 */
	
	public IG259Info updateIG259Info(
			IG259Info processTemplate) throws BLException;
}
