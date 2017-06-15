/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prr.bl.task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG808Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;

/**
 * <p>
 * ���̼�¼��¼��Ϣҵ���߼�
 * </p>
 */

public interface IG500BL extends BaseBL {
	
	/**
	 * <p>
	 * �������̼�¼ʵ��
	 * </p>
	 * 
	 * @param ig500Info ���̼�¼
	 * @return ���̼�¼
	 * @throws BLException
	 */

	public IG500Info registIG500Info(IG500Info ig500Info)
			throws BLException;
	
	/**
	 * <p>
	 * �������̼�¼��Ϣ
	 * </p>
	 * 
	 * @param ig500Info ���̼�¼
	 * @return ���̼�¼
	 * @throws BLException
	 */

	public IG500Info updateIG500Info(IG500Info ig500Info)
			throws BLException;

	
	/**
	 * <p>
	 * �������̼�¼��Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼��Ϣ��������
	 * @return ���̼�¼��Ϣ�б�
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(IG500SearchCond cond);
			
	/**
	 * <p>
	 * �������̼�¼��Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼��Ϣ��������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ���̼�¼��Ϣ�б�
	 * @throws BLException
	 */

	public List<IG500Info> searchIG500Info(
			IG500SearchCond cond, int start, int count);
	
	/**
	 * �������̲�ѯ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchDrillProcess(IG500SearchCond cond, int start,  int count);

	/**
	 * <p>
	 * �������̼�¼ID��ȡ���̼�¼��Ϣ
	 * </p>
	 * 
	 * @param processId ���̼�¼ID
	 * @return ���̼�¼
	 * @throws BLException 
	 */
	
	public IG500Info searchIG500InfoByKey(Integer processId) throws BLException;
	
	/**
	 * ��ȡ���̼�¼ʵ��
	 * 
	 * @return ProcessRecordTB
	 * @throws BLException
	 */
	
	public IG500TB getIG500TBInstance();
	
	/**
	 * <p>
	 * �������̼�¼����
	 * </p>
	 * 
	 * @param cond ���̼�¼��������
	 * @return ���̼�¼����
	 */
	
	public int getIG500InfoSearchCount(IG500SearchCond cond);
	
	/**
	 * ��������������������ƽ̨������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryServiceRequestList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * ������������������¼����ƽ̨������
	 * @return ����������¼��
	 */
	public int queryServiceRequestListCount(final IG500SearchCond cond);
	
	/**
	 * ����(�����¼�������״̬��������������ƽ̨������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500InfoSubStatusList(final IG500SearchCond cond, final int start, final int count);

	/**
	 * ����(�����¼�������״̬��������������ƽ̨������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500ONLYInfo> queryIG500ONLYInfoSubStatusList(final IG500SearchCond cond, final int start, final int count);
	
	
	/**
	 * ����(�����¼�������״̬������������¼����ƽ̨������
	 * @return ����������¼��
	 */
	public int queryIG500InfoSubStatusListCount(final IG500SearchCond cond);
	
	/**
	 * ����(�����¼�������״̬������������¼����ƽ̨������
	 * @return ����������¼��
	 */
	public int queryIG500ONLYInfoSubStatusListCount(final IG500SearchCond cond);
	
	
	/**
	 * <p>
	 * ��ȡָ����ɫ���еĴ������̼�¼
	 * </p>
	 * 
	 * @param roleId ��ɫID
	 * @param prType ���̼�¼����
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByRole(Integer roleId,String prType);

	/**
	 * <p>
	 * ��ȡָ���û����еĴ������̼�¼
	 * </p>
	 * 
	 * @param userId �û�ID
	 * @param prType ���̼�¼����
	 * @param pdid ���̶���ID
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByUser(String userId,String prType,String pdid,String prstatus);

	
	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ�������
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public int getProcessRecordVWSearchCount(IG677SearchCond cond);

	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @return ���̼�¼������û���Ϣ�������
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond);
	
	/**
	 * <p>
	 * ���ݼ���������ȡ���̼�¼������û���Ϣ
	 * </p>
	 * 
	 * @param cond ���̼�¼������û���Ϣ��������
	 * @param start ������ʼ����
	 * @param count ����������
	 * @return ���̼�¼������û���Ϣ�������
	 */

	public List<IG677Info> searchProcessRecordInfo(IG677SearchCond cond, int start, int count);
	
	/**
	 * �������̼�¼��Ϣ����ɾ�����̼�¼��Ϣ����
	 * 
	 * @param prid ɾ�����̼�¼��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecordByKey(Integer prid) throws BLException;
	
	/**
	 * ɾ�����̼�¼��Ϣ����
	 * 
	 * @param processRecord ɾ�������̼�¼��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessRecord(IG500Info processRecord) throws BLException;
	
	/**
	 * ָ���û�δ��������������������
	 * @param userid �û�ID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid);

	/**
	 * ָ����ɫδ��������������������
	 * @param roleid ��ɫID
	 * @return ��������б�
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid);
	
	/**
	 * ��ȡ���̷����߽�ɫ���еĴ������̼�¼
	 * @param roleid ���̷����߽�ɫID
	 * @return ���̼�¼������û���Ϣ�������
	 */
	public List<IG677Info> getTodoProcessRecordsByFPRole(Integer roleid, String prtype);
	
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
	public List<IG500Info> queryProcessRecordEntityList(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond);
	
	
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count);
	
	/**
	 * �Զ���������ع�������������¼��
	 * @return �Զ�����������������¼��
	 */
	public int searchProcessRecordCountForRelatedWork(final IG500SearchCond cond);
	
	/**
	 * �Զ�������������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(final IG500SearchCond cond, final int start, final int count);
	
	/**
	 * <p>
	 * ��ѯ������صĹ�ͨ������Ϣ
	 * </p>
	 * 
	 */
	public List<String> getProcessInfoDefGeneral(List<IG677Info> list, Integer pidGeneralId);

	/**
	 * ָ���û���ش�������������������
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
	 * ָ���û���ش�������������������
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
	 * ��ҳ�ϰ�����ͳ�ƹ���������ѯ����
	 * @return ��������б�
	 */
	public List<IG808Info> getOrganizationProcessCount();
	
	/**
	 * ���ܣ����ݹ�����ʶ��ѯ��ǰ�����ˮ��
	 * @param prserialnum ������ʶ
	 * @return �����ˮ��
	 */
	public String searchMaxPrserialnum(String prserialnum);
	
	/**
	 * ���ܣ������ô�����idȡ�÷��������б�
	 * @return ��������б�
	 */
	public List<IG500Info> searchDispatchStatistics(IG677SearchCond cond, int start, int count);
	
	/**
	 * ���ܣ������ô�����idȡ�÷��������б�����
	 * @return ��¼����
	 */
	public int findDispatchStatisticsSearchCount(IG677SearchCond cond);
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count);

	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int queryIG500EntityCount(IG500SearchCond cond);
	
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
	 * ����ָ�����������Ͳ�ѯ����
	 * @param type ���̲�ѯ����
	 * @return ������Ϣ
	 */
	public List<IG500Info> searchProcessByType(IG500SearchCond cond,int start,int count,String type) throws BLException;
	
	/**
	 * ����ָ�����������Ͳ�ѯ��������
	 * @param type ���̲�ѯ����
	 * @return ������Ϣ
	 */
	public Integer searchProcessByTypeCount(IG500SearchCond cond,String type) throws BLException;
	
	/**
	 * ��ȡ���̵�ǰ״̬��ʾ����
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬��ʾ����
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException;
	
	/**
	 * ��ȡ���̵�ǰ״̬
	 * @param prid ����ID
	 * @return ���̵�ǰ״̬
	 */
	public List<String> searchCurrentStatus(final Integer prid) throws BLException;
	
	
	/**
	 * ��������
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException;
	
	/**
	 * dashboard
	 *	������������������� ��������
	 * @param months
	 * @return List<Map>
	 * <p>
	 * 	map �ṹ   key :(DATEMONTH,PRPDID,PRPDNAME,ACOUNT,CLOSECOUNT)
	 * </p>
	 */
	public List<Map> getRiskAssess (String months,String prpdid)throws BLException;
	
	/**
	 * ��������
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(RehearseSearchCond cond, int start, int count) throws BLException;
	/**
	 * �������� ����������ȡ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(RehearseSearchCond cond, int start, int count) throws BLException;
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
    public List<Map<String, Object>> queryIG500WithStatusAndPart(IG500SearchCond prSearchCond, int i, int j)throws BLException;
    
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
}
