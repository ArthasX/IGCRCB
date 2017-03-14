package com.deliverik.framework.soc.asset.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0128Info;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;

/**
 * �ʲ���Ϣҵ���߼�
 * 
 */
public interface SOC0118BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ���Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ���Ϣ����ʵ��
	 */

	public SOC0118TB getEntityItemTBInstance();

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ����
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ����
	 */
	public int getEntityItemSearchCount(SOC0118SearchCond cond);

	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 */
	public SOC0118Info searchEntityItemByKey(Integer eiid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ�б�
	 */
	public List<SOC0118Info> searchEntityItem(SOC0118SearchCond cond);

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���Ϣ�б�
	 */
	public List<SOC0118Info> searchEntityItem(SOC0118SearchCond cond, int start, int count);

	/**
	 * �����ʲ���Ϣ����
	 * 
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public SOC0118Info registEntityItemAndConfigItem(SOC0118Info entityItem) throws BLException;
	
	/**
	 * �����¼��Ǽ�
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public SOC0118Info registRiskCase(SOC0118Info entityItem) throws BLException;
	
	/**
	 * ɾ���ʲ���Ϣ����
	 * 
	 * @param entityItem �ʲ���Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItem(SOC0118Info entityItem) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ɾ���ʲ���Ϣ����
	 * 
	 * @param eiid ɾ���ʲ���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemByKey(Integer eiid) throws BLException;

	/**
	 * ����ʲ���Ϣ����
	 * 
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public SOC0118Info updateEntityItem(SOC0118Info entityItem) throws BLException;
	
	/**
	 * �ʲ���Ϣ�����ڼ��
	 * 
	 * @param eilabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public SOC0124Info searchEntityItemVWByKey(Integer eiid) throws BLException;

	/**
	 * �ʲ���������ģ����Ϣ���������������ȡ��
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ����
	 */
	public int getEntityItemVWSearchCount(SOC0124SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ�б�
	 */
	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond);


	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���������ģ����Ϣ�б�
	 */
	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond, int start, int count);
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param entityItemVWInfo �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkEntityItemDomain(User user,SOC0124Info entityItemVWInfo) throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ƽ̨������
	 * 
	 * @param entityItem �ʲ���Ϣ
	 * @return �ʲ���Ϣ
	 * @throws BLException
	 */
	public SOC0118Info registEntityItem(SOC0118Info entityItem) throws BLException;
	
	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextEntityItemLable(SOC0118SearchCond cond) throws BLException;

	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+�豸����code+��� ��λ����10+2+7����������ר��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextEntityItemLableFX(SOC0118SearchCond cond) throws BLException;

	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 * @throws BLException 
	 */
	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid) throws BLException;
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118Info> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count);
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public SOC0123Info searchEntityItemEntityVWByKey(Integer eiid) throws BLException;
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion);
	
	/**
	 * ��ѯCX
	 * @param strEilabel
	 * @return
	 */
	public String searchEntityESyscoding(String strEilabel);
	
	/**
	 * ������������sql
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<CodeDetailEntity> searchCodeDetailSQL(SOC0118SearchCond cond);

	public List<TableSpaceInfo> searchTableRelationInfo(
			SOC0118SearchCondImpl soc0118Cond, int start, int count);
	/**
	 * ��ռ�Ԥ���趨��ֵ
	 * @param cond
	 * @return
	 */
	public void updateCutValue(IGCIM1001Form igcim1001Form);
	/**
	 * ��ռ�Ԥ��
	 * @param cond
	 * @return
	 */
	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count);
	
	public Integer searchCutItemCount(SOC0437SearchCond cond);
	
	/**
	 * ����ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118SearchCond cond) throws BLException;
	
	/**
	 * ��������
	 * @param soc0118List
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118TB> soc0118List)throws Exception;
	
	/**
	 * ִ��sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql)throws BLException;
	
	public int getNetDeviceInfoListCount(NetDeviceSearchCond Cond);
	
	public List<NetDeviceInfo> searchNetDeviceInfoList(NetDeviceSearchCond Cond, int start, int count);
	
	
	/**
	 * ���ָ��eiid���ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118SearchCond cond)throws BLException;
	
	/**
	 * ɾ��eiid��eirootmark�� ������Χ�ڵ��ʲ�
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids)throws BLException;
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public SOC0605Info searchSOC0605InfoByKey(Integer eiid) throws BLException;
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param SOC0605Info �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkSOC0605InfoDomain(User user,SOC0605Info soc0605Info) throws BLException;
	
	/**
	 * ��ȡ������Ϣ
	 * ����һ���ԶԱ� �� ����ҵ��ϵͳ ��ѯ����ʱ ʹ��
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118SearchCond cond)throws BLException;
	
	public void deleteEntityItemByEilabel(String eilabel)throws BLException;
	
	public int getEntityItemSearchCountByHost(SOC0118SearchCondImpl cond) throws BLException;

	public List<SOC0118Info> searchEntityItemByHost(SOC0118SearchCondImpl cond,
			int fromCount, int pageDispCount)throws BLException;
	
	/**
	 * ����������д+X+�����������+�����������+���ռ�������
	 * ����λ����λ�� X     ����λ��         ����λ��      ����λ�� IG-X0101-001
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 * 
	 */
	public String searchNewNextEntityItemLable(SOC0118SearchCond cond) throws BLException;
	
	/**
	 * ��ѯ���տ�ֲ����
	 * @return map key:{riskcont:���յ�����,riskesyscoding:���յ�����(6λ),inspectcont:�����,inspectesyscoding:���������(6λ),����}
	 */
	public List<Map> getRiskRepository()throws BLException;


	/**
	 *  ��ȡ ���յ�+�����  ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchAssessRisk(RehearseSearchCond cond, int start, int count) throws BLException;
	/**
	 * ��ȡ ��������ѡ��ı���ȷ��յ�+�����  ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return  key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchRiskInfo(RehearseSearchCond cond, int start, int count) throws BLException;

}
