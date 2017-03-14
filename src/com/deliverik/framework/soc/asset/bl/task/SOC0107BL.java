package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;

/**
 * <p>
 * �ʲ�����ҵ���߼�
 * </p>
 */
public interface SOC0107BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�������Ϣ����ʵ��
	 */

	public SOC0107TB getSOC0107Instance();
	

	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����Դ�汾�� 
	 * 			<br>civersion:null�����ʲ��������а汾��������Ϣ��
	 * 			<br>civersion:-1�����ʲ��������°汾��������Ϣ��
	 * 			<br>civersion:����ֵ�����ʲ����Զ�Ӧ�汾��������Ϣ��
	 * @param cismallversion �ʲ�����С�汾��
	 * @param cname �ʲ���������(ģ����ѯ����)
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, 
			Integer civersion, Integer cismallversion, String cname) throws BLException;

	/**
	 * �����ʲ�������Ϣ����ȡ���ʲ�������Ϣ
	 * 
	 * @param ciid �ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	public SOC0107Info searchSOC0107ByKey(Integer ciid) throws BLException;

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ����
	 */
	public int getConfigItemVWSearchCount(SOC0129SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ�б�
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������ʷ��¼��Ϣ�б�
	 * 
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����԰汾�� 
	 * 		  -1:�������°汾
	 *        ����ֵ:����ָ���汾
	 *        �հ�:�������а汾
	 * @param cname �ʲ���������(ģ����ѯ����)
	 * @return �ʲ�������ʷ��¼��Ϣ�б�
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException;
	
	/**
	 * �����ʲ�������Ϣ����(�������Դ���)
	 * 
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param configItem �ʲ�������Ϣ
	 * @return 
	 */
	public void saveSOC0107(int currentEiversion, SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * �����ʲ�������Ϣ����(������Դ���)
	 * 
	 * @param eiid �ʲ�ID
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param configItemList �ʲ�������Ϣ�����б�
	 * @return 
	 */
		public void saveSOC0107(Integer eiid, int currentEiversion, List<SOC0107Info> soc0107InfoList) throws BLException;

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ���������ƽ̨��������ʹ��getConfigItemVWSearchCount�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getSOC0107SearchCount(SOC0107SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond);
	
	/**
	 * �����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem �ʲ�������Ϣ
	 * @return �ʲ�������Ϣ
	 * @throws BLException
	 */
	public SOC0107Info registSOC0107(SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * ����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem �ʲ�������Ϣ
	 * @return �ʲ�������Ϣ
	 * @throws BLException
	 */
	public SOC0107Info updateSOC0107(SOC0107Info soc0107Info) throws BLException;
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion);

	public String getHostEiid(SOC0107SearchCondImpl cond) throws BLException;
	
	/**
	 * �����ʲ�ģ��ID��ȡ������Ϣ
	 * @param eiid �ʲ�ID
	 * @return List<SOC0107Info>
	 */
	public List<SOC0107Info> getConfigItemByEid(SOC0107SearchCondImpl cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�������
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count);
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(final Map<String, String> value) throws BLException;
	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count)throws BLException;
	
	/**
	 * �����ʲ�id��config id ��ѯ�����������̽ڵ���ڵ��������Ϣ
	 * @param cid config id
	 * @param eiid �ʲ�id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String,Object>> searchProcessDefineUserByEiidInfo(String cid,Integer eiid)throws BLException;
}
