/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;

/**
 * ����״̬��־ҵ���߼��ӿ�
 * 
 */
public interface IG224BL extends BaseBL{
	
	/**
	 * ��ȡ����״̬��־ʵ��
	 * @return RecordStatusLogTB
	 */
	public IG224TB getIG224TBInstance();
	
	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(IG224SearchCond cond);

	/**
	 * ������������
	 * 
	 * @param pprid ����״̬��־ID
	 * @return ����״̬��־
	 */
	public IG224Info searchIG224InfoByKey(Integer pprid) throws BLException;
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ������״̬��־��Ϣ
	 */
	public List<IG224Info> searchIG224InfoAll();

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> searchIG224Info(IG224SearchCond cond, int start, int count);
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param prstatus ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224Info(Integer prid, String prstatus) throws BLException;
	
	/**
	 * ��ǰ����״̬��־��Ϣȡ��
	 * 
	 * @param prid ����ID
	 * @param prstatus ����״̬
	 * @return ��ǰ����״̬��־��Ϣ
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentIG224InfoByPsdid(Integer prid, String psdid) throws BLException;
	
	/**
	 * ��¼����
	 * 
	 * @param ig224Info ��¼����
	 * @return ����״̬��־
	 */
	public IG224Info registIG224Info(IG224Info ig224Info) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param pprid ����״̬��־ID
	 * @return
	 */
	public void deleteIG224Info(Integer pprid) throws BLException;

	/**
	 * �������
	 * 
	 * @param ig224Info �������
	 * @return ����״̬��־
	 */
	public IG224Info updateIG224Info(IG224Info ig224Info) throws BLException;
	/**
	 * ������������ dashboard ���ݳ�ʼ��ר��
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond);
}
