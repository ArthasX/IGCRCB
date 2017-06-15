package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.User;

/**
 * �ʲ���Ϣҵ���߼�
 * 
 */
public interface IG013BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ���Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ���Ϣ����ʵ��
	 */

	public IG013TB geIG013TBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ����
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ����
	 */
	public int getIG013InfoSearchCount(IG013SearchCond cond);

	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 */
	public IG013Info searchIG013InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ�б�
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���Ϣ�б�
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond, int start, int count);

	/**
	 * �����ʲ���Ϣ����
	 * 
	 * @param IG013Info �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public IG013Info registEntityItemAndConfigItem(IG013Info ig013Info) throws BLException;

	/**
	 * ɾ���ʲ���Ϣ����
	 * 
	 * @param ig013Info �ʲ���Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ɾ���ʲ���Ϣ����
	 * 
	 * @param eiid ɾ���ʲ���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013InfoByKey(Integer eiid) throws BLException;

	/**
	 * ����ʲ���Ϣ����
	 * 
	 * @param ig013Info �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public IG013Info updateIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * �ʲ���Ϣ�����ڼ��
	 * 
	 * @param eilabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG013Info(String eilabel) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public IG688Info searchIG688InfoByKey(Integer eiid) throws BLException;

	/**
	 * �ʲ���������ģ����Ϣ���������������ȡ��
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ����
	 */
	public int getIG688InfoSearchCount(IG688SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ�б�
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond);


	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���������ģ����Ϣ�б�
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond, int start, int count);
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param ig688Info �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG688InfoDomain(User user,IG688Info ig688Info) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ƽ̨������
	 * 
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public IG013Info registIG013Info(IG013Info ig013Info) throws BLException;
	
	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextIG013InfoLable(IG013SearchCond cond) throws BLException;

	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+�豸����code+��� ��λ����10+2+7����������ר��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextIG013InfoLableFX(IG013SearchCond cond) throws BLException;

	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 * @throws BLException 
	 */
	public List<IG887Info> searchVersionUpdateTime(Integer eiid) throws BLException;
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count);
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public IG749Info searchIG749InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion);
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param ig499Info �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG499InfoDomain(User user,IG499Info ig499Info) throws BLException;

}
