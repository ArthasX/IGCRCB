package com.deliverik.framework.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �ʲ�����ҵ���߼�
 * </p>
 */
public interface IG800BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�������Ϣ����ʵ��
	 */

	public IG800TB getIG800TBInstance();

	/**
	 * �����ʲ�������Ϣ����ȡ���ʲ�������Ϣ
	 * 
	 * @param ciid �ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	public IG800Info searchIG800InfoByKey(Integer ciid) throws BLException;

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ����
	 */
	public int getIG002InfoSearchCount(IG002SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������ʷ��¼��Ϣ�б�
	 * 
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����԰汾�� 
	 * 		  -1:�������°汾
	 *        ����ֵ:����ָ���汾
	 *        �հ�:�������а汾
	 * @param cismallversion �ʲ�����С�汾��
	 * @param cname �ʲ���������(ģ����ѯ����)
	 * @return �ʲ�������ʷ��¼��Ϣ�б�
	 */
	public List<IG800Info> searchIG800InfoHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException;
	
	/**
	 * �����ʲ�������Ϣ����(�������Դ���)
	 * 
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param ig800Info �ʲ�������Ϣ
	 * @return 
	 */
	public void saveIG800Info(int currentEiversion, IG800Info ig800Info) throws BLException;
	
	/**
	 * �����ʲ�������Ϣ����(������Դ���)
	 * 
	 * @param eiid �ʲ�ID
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param ig800InfoList �ʲ�������Ϣ�����б�
	 * @return 
	 */
		public void saveIG800Info(Integer eiid, int currentEiversion, List<IG800Info> ig800InfoList) throws BLException;

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ���������ƽ̨��������ʹ��getIG002InfoSearchCount�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getIG800InfoSearchCount(IG800SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchIG002Info�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchIG002Info�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond);
	
	/**
	 * �����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param ig800Info �ʲ�������Ϣ
	 * @return �ʲ�������Ϣ
	 * @throws BLException
	 */
	public IG800Info registIG800Info(IG800Info ig800Info) throws BLException;
	
	/**
	 * ����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param ig800Info �ʲ�������Ϣ
	 * @return �ʲ�������Ϣ
	 * @throws BLException
	 */
	public IG800Info updateIG800Info(IG800Info ig800Info) throws BLException;
	
	/**
	 * �Ǽǳ�ʼ��ʱ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG002Info> initSearchIG002Info(IG002SearchCond cond, int start, int count);
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException;
	
}
