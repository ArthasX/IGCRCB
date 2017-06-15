package com.deliverik.framework.soc.asset.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;



/**
 * �ʲ���ϢDAO�ӿ�
 * 
 */
public interface SOC0118DAO extends BaseHibernateDAO<SOC0118Info> {

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<SOC0118Info> findAll();

	/**
	 * ������������
	 * @param eiid ����
	 * @return �������
	 */
	public SOC0118Info findByPK(Serializable eiid);

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0118SearchCond cond);

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118Info> findByCond(final SOC0118SearchCond cond, final int start, final int count);
	
	/**
	 * ��ȡ�ʲ�������ֵ �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ�������ֵ��ƽ̨������
	 */
	
	public String searchMaxEntityItemLable(final SOC0118SearchCond cond);
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118Info> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count);
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion);
/**
 * cx��¼��ѯ
 * @param strEilabel
 * @return
 */
	public String searchEntityESyscoding(final String strEilabel);
	
	/**�Լ�д�Ĳ�ѯ*/
	public List<CodeDetailEntity> findByCondSQL(final SOC0118SearchCond cond, final int start, final int count);

	public List<TableSpaceInfo> searchTableRelationInfo(final 
			SOC0118SearchCondImpl soc0118Cond,final int start,final int count);
	
	public Integer updateCutValue(IGCIM1001Form igcim1001Form);
	
	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count);
	
	public Integer searchCutItemCount(SOC0437SearchCond cond);
	
	/**
	 * ����ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118SearchCond cond);
	
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
	public Integer executeSQL(String sql);
	/**
	 * ��ѯ�����豸��¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int getNetDeviceCount(final NetDeviceSearchCond cond);
	
	public List<NetDeviceInfo> searchNetDeviceListByCond(final NetDeviceSearchCond cond, final int start, final int count);
	
	/**
	 * ���ָ��eiid���ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118SearchCond cond);
	
	/**
	 * ɾ��eiid��eirootmark�� ������Χ�ڵ��ʲ�
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids);
	
	/**
	 * ��ȡ������Ϣ
	 * ����һ���ԶԱ� �� ����ҵ��ϵͳ ��ѯ����ʱ ʹ��
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118SearchCond cond);
	
	public void deleteEntityItemByEilabel(String eilabel);
	
	public int getEntityItemSearchCountByHost(SOC0118SearchCondImpl cond);

	public List<SOC0118Info> searchEntityItemByHost(SOC0118SearchCondImpl cond,
			int fromCount, int pageDispCount);
	/**
	 * ��ѯ���տ�ֲ����
	 * @return map key:{riskcont:���յ�����,riskesyscoding:���յ�����(6λ),inspectcont:�����,inspectesyscoding:���������(6λ),����}
	 */
	public List<Map> getRiskRepository();
	
}
