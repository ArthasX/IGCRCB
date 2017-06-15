package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;

/**
 * <p>
 * �ʲ�ģ������ҵ���߼�
 * </p>
 */
public interface SOC0109BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�ģ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�ģ��������Ϣ����ʵ��
	 */

	public SOC0109TB getConfigurationTBInstance();

	/**
	 * �����ʲ�ģ����������ȡ���ʲ�ģ��������Ϣ
	 * 
	 * @param cid �ʲ�ģ����������
	 * @return �ʲ�ģ��������Ϣ
	 */
	public SOC0109Info searchConfigurationByKey(String cid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ����
	 */
	public int getConfigurationSearchCount(SOC0109SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfiguration(SOC0109SearchCond cond, int start, int count);

	/**
	 * �����ʲ�ģ��IDȡ��������̳����Ե�������Ϣ�б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<SOC0109Info> searchConfigurationByEid(String eid) throws BLException;
	
	/**
	 * �½��ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109Info registConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid �ʲ�ģ��������Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationByKey(String cid) throws BLException;

	/**
	 * ����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public SOC0109Info updateConfiguration(SOC0109Info configuration) throws BLException;

	/**
	 * ȡ�ø��ʲ�ģ�͵�ģ��������Ϣ��ƽ̨������
	 * 
	 * @param list �ʲ�ģ�ͼ���
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ
	 *            1:��ʾ����
	 *            0:������ʾ����
	 *            null:ȫ������
	 * @return ���ʲ�ģ�͵�ģ��������Ϣ
	 */
	public Map<String,List<SOC0109Info>> searchConfiguration(List<SOC0117Info> list,Integer cseq);
	
}
