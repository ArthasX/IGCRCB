/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;

/**
 * <p>����:���̼�¼DAO�ӿ�</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.���������������ȡ��</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>          5.�����������Ͳ�ѯ��ǰ�����ˮ��</p>
 * <p>          6.��������������������</p>
 * <p>          7.������������������¼��</p>
 * <p>          8.����(�����¼�������״̬��������������</p>
 * <p>          9.����(�����¼�������״̬������������¼��</p>
 * <p>          10.ָ���û���ش�������������������</p>
 * <p>          11.ָ����ɫδ��������������������</p>
 * <p>          12.�Զ�����������������¼��</p>
 * <p>          13.�Զ�������������������</p>
 * <p>          14.�Զ���������ع�������������¼��</p>
 * <p>          15.�Զ�������������������</p>
 * <p>������¼��</p>
 */
public interface IG500DAO extends BaseHibernateDAO<IG500Info> {

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG500Info> findAll();
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG500SearchCond cond);

	/**
	 * ���ܣ�������������
	 * @param prid ����
	 * @return �������
	 */
	public IG500Info findByPK(Serializable prid);

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> findByCond(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ������������Ͳ�ѯ��ǰ�����ˮ��
	 * @param prserialnum ��ˮ��
	 * @return �����ˮ��
	 */
	
	public String getMaxPrserialnum(String prserialnum);
	
	/**
	 * ���ܣ���������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ�������������������¼��
	 * @return ����������¼��
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond);
	
	/**
	 * ���ܣ�����(�����¼�������״̬��������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * ���ܣ�����(�����¼�������״̬��������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ�����(�����¼�������״̬������������¼��
	 * @return ����(�����¼�������״̬������������¼��
	 */
	public int queryIG500InfoSubStatusListCount(final IG500SearchCond cond);

	/**
	 * ���ܣ�����(�����¼�������״̬������������¼��
	 * @return ����(�����¼�������״̬������������¼��
	 */
	public int queryIG500ONLYInfoSubStatusListCount(final IG500SearchCond cond);
	
	/**
	 * ָ���û�δ��������������������
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByUserid(final String userid);

	/**
	 * ���ܣ�ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return ��������б�
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * ���ܣ�ָ���û���ش�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @param closeFlag ��ѯ�رձ�־��0���Ѵ���1��δ��������������
	 * @param dealFlag  ��ѯ�����־��0���ѹرգ�1��δ�رգ�����������
	 * @return �����������
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag);
	
	/**
	 * ���ܣ�ָ����ɫδ��������������������
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByRoleid(final Integer roleid);
	
	/**
	 * ���ָ���û��Ƿ����ָ�����̲鿴Ȩ�ޣ�Ŀǰֻ֧�ֱ����������
	 * @param userid �û�ID
	 * @param prid ����ID
	 * @return Ȩ�ޱ�ʶ
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid);

	/**
	 * ������ָ������ɫʱ,�ڽ�ɫ�����˵��ҵĹ�������ʾ����������Ϣ
	 * @param userid �û�ID
	 * @return 
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid);
	
	/**
	 * ����������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * ���ܣ��Զ�����������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchIG500CountForSelfDef(final IG500SearchCond cond);
	
	/**
	 * ���ܣ��Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchIG500InfoForSelfDef(final IG500SearchCond cond, final int start, final int count);

	
	/**
	 * ���ܣ��Զ���������ع�������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchIG500InfoCountForRelatedWork(final IG500SearchCond cond);
	
	/**
	 * ���ܣ��Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchIG500InfoForRelatedWork(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ���������ͳ��������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchDispatchStatisticsVW(final IG677SearchCond cond, final int start, final int count);
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	public int findDispatchStatisticsSearchCount(final IG677SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(final IG500SearchCond cond);
	
	/**
	 * ��ѯָ����ܱ���key����������
	 * @param type ��������
	 * @param pdid ������ID
	 * @param key ����ʵ��key
	 * @param isClose true����ѯ�ѹرգ�false����ѯδ�رգ�null����ѯȫ������������ֹ
	 * @return ��������
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(final String type, final String pdid,
			final String key, final Boolean isClose) throws BLException;
	
	/**
	 * ��ѯ�ҵĹ���������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchMyProcess(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int searchMyProcessCount(final IG500SearchCond cond);
	
	/**
	 * ��ѯͬ��������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchMyProcessByOrg(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int searchMyProcessByOrgCount(final IG500SearchCond cond);
	
	/**
	 * ��ѯͬ��ɫ����������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG500Info> searchMyProcessByRole(final IG500SearchCond cond, final int start, final int count); 
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int searchMyProcessByRoleCount(final IG500SearchCond cond);
	
	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬��ʾ����
	 */
	public String searchCurrentStatusName(final Integer prid) throws BLException;
	
	/**
	 * ��ȡ���̵�ǰ״̬
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException;
	
	/**
	 * dashboard
	 *	��ȡ ָ�����̵� ��ͳ������ 
	 * @param months �·�(yyyy/MM),(yyyy/MM )....
	 * @param prpdid ���̶����ǰ��λ
	 * @return List<Map>
	 * <p>
	 * 	map �ṹ DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT
	 * </p>
	 */
	public List<Map> getRiskAssess (String months,String prpdid);

	/**
	 * ��ȡ�Ҵ�����Ĺ����б�
	 * @param cond IG500SearchCond
	 * @param start int
	 * @param count int
	 * @return List<IG500Info>
	 */
	public List<IG500Info> searchMyProcessed(final IG500SearchCond cond, final int start, final int count);

    /** 
     * @Title: queryIG500WithStatusAndPart 
     * @Description: TODO ��ѯig500 ������״̬����ǰ����״̬�Ĳ�����
     * @param prSearchCond
     * @param i
     * @param j
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> queryIG500WithStatusAndPart(final IG500SearchCond prSearchCond,final int i,final int j);
    /**
     * ��ѯӦ����������
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<IG500Info> getDrmFlow(final IG500SearchCond cond,final int start,final int count);
    
    /**
     * ��ѯӦ��������������
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public Integer countDrmFlow(final IG500SearchCond cond);
    
    /**
	 * ��ѯ��δ������Ĺ���������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchMyUnProcessd(final IG500SearchCond cond,final int start,
			final int count);
}
