/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.framework.workflow;

import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>
 * ���̶���ҵ���߼�
 * </p>
 * 
 */

public interface WorkFlowDefinitionBL extends BaseBL {
	

	/**
	 * <p>
	 * ����ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ����ģ����Ϣ����ʵ��
	 */
	public IG259TB getProcessTemplateTBInstance();
	
	/**
	 * <p>
	 * ����������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ����������Ϣ����ʵ��
	 */
	public IG380TB getProcessDefinitionTBInstance();
	
	/**
	 * <p>
	 * ���̱���������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return ���̱���������Ϣ����ʵ��
	 */
	public IG007TB getIG007TBInstance();

	/**
	 * ��ѯָ�����͵�ʹ���е�����ģ����Ϣ
	 * @param prtype ����ģ������
	 * @return ����ģ����Ϣ
	 */
	public IG259Info searchProcessTemplateByPrType(String prtype);
	
	/**
	 * ���ݼ�������ȡ������ģ����Ϣ�б�
	 * @param cond ����ģ����Ϣ��������
	 * @return ����ģ����Ϣ�б�
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ������ģ����Ϣ�б���ҳ��ѯ�ã�
	 * @param cond ����ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ����ģ����Ϣ�б�
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond, int start, int count);
	
	/**
	 * ��������ģ��ID��ѯ����ģ����Ϣ
	 * @param ptid ����ģ��ID
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info searchProcessTemplateByKey(Integer ptid) throws BLException;
	
	/**
	 * ��������ģ����Ϣ����
	 * 
	 * @param processTemplate ����ģ����Ϣ
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info registProcessTemplate(IG259Info processTemplate) throws BLException;
	
	
	/**
	 * ɾ������ģ����Ϣ����
	 * 
	 * @param ptid ����ģ��ID
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessTemplateByKey(Integer ptid) throws BLException;
	
	/**
	 * �������ģ����Ϣ����
	 * 
	 * @param processTemplate ����ģ����Ϣ
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info updateProcessTemplate(IG259Info processTemplate) throws BLException;
	
	
	/**
	 * ��������ģ��ID��ѯ���̶�����Ϣ�б�
	 * @param processTemplateId ����ģ��ID
	 * @return  ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchProcessDefinitionsByPtid(Integer processTemplateId);
	
	/**
	 * �������̶���ID��ѯ���̶�����Ϣ
	 * @param pdid ���̶���ID
	 * @return ���̶�����Ϣ
	 * @throws BLException
	 */
	public IG380Info searchProcessDefinitionByKey(String pdid) throws BLException;
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ����
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ����
	 */
	public int getProcessDefinitionSearchCount(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond);

	/**
	 * ���ݼ�������ȡ�����̶�����Ϣ�б���ҳ��ѯ�ã�
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond,int start,int count);
	
	/**
	 * �������̶�����Ϣ����
	 * 
	 * @param processDefinition �������̶�����Ϣ
	 * @return ���̶�����Ϣ
	 * @throws BLException
	 */
	public IG380Info registProcessDefinition(IG380Info processDefinition) throws BLException;

	/**
	 * ɾ�����̶�����Ϣ����
	 * 
	 * @param pdid ���̶�����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessDefinitionByKey(String pdid) throws BLException;

	/**
	 * �������̶�����Ϣ����
	 * 
	 * @param processDefinition ���̶�����Ϣ
	 * @return ���̶�����Ϣ
	 * @throws BLException
	 */
	public IG380Info updateProcessDefinition(IG380Info processDefinition) throws BLException;
	
	/**
	 * ���ܣ����ݼ�������ȡ����ʷ���̶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ��ʷ���̶�����Ϣ�������
	 */
	public int getProcessDefinitionSearchHistoryCount(IG380SearchCond cond);
	
	/**
	 * ���ܣ����ݼ�������ȡ����ʷ���̶�����Ϣ�б���ҳ��ѯʹ�ã�
	 * 
	 * @param cond ���̶����������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ��ʷ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchHistoryProcessDefinition(IG380SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * ���̶�������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getProcessDefinitionPK(String firstsite,String pdsequence);
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getProcessDefinitionSearchLastCount(IG380SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchLastProcessDefinition(IG380SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ����ط�����Զ����������͵���Ϣ
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond);
	
	/**
     * ���ݼ�������ȡ��ȱʡȨ�޵���ط�����Զ����������͵���Ϣ
     * 
     * @param cond ���̶����������
     * @return ���̶�����Ϣ�б�
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond);
    
	/**
     * ȱʡ״̬�����߹����������Ͷ�������ֵȡ��
     * @param ����״̬ID
     * @return ȱʡ״̬�����߹����������Ͷ�������ֵ
     */
    public String getDefaultParticipantRelevantDefPK(String psdid) throws BLException;
    
    /**
     * ע��ȱʡ״̬�����߹����������Ͷ���
     * @param entity ȱʡ״̬�����߹����������Ͷ���ʵ��
     * @return ȱʡ״̬�����߹����������Ͷ���ʵ��
     * @throws BLException
     */
    public IG931Info registDefaultParticipantRelevantDefInfo(IG931Info entity) throws BLException;
    
    /**
     * ��������ɾ��ȱʡ״̬�����߹����������Ͷ���
     * @param pk ����
     * @throws BLException
     */
    public void deleteDefaultParticipantRelevantDefInfoByKey(String pk) throws BLException;
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond);
    
	/**
	 * ���̶��岻���ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @param pdname ���̶�������
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistProcessDefinition(Integer ptid, String pdname) throws BLException;
	
	/**
	 * ���̶������洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 */
	public String copyProcessDefVersion(String pdid) throws BLException;
	
	/**
	 * �������̶���ID��ѯ���̱���������Ϣ
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���������Ϣ�б�
	 */
	public List<IG007Info> searchProcessInfoDefsByPdid(String processDefinitionId);

	/**
	 * �������̶���ID��ѯ������ȱʡ���������̱���������Ϣ��ƽ̨������
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱���������Ϣ�б�
	 */
	public List<IG007Info> searchProcessInfoDefsNoDefault(String processDefinitionId);

	/**
	 * ���̱���������Ϣ���������������ȡ��
	 * 
	 * @param cond ���̱���������Ϣ��������
	 * @return ���̱���������Ϣ����
	 */
	public int getProcessInfoDefSearchCount(IG007SearchCond cond);

	/**
	 * ���ݼ�������ȡ�����̱���������Ϣ�б�
	 * 
	 * @param cond ���̱�����Ϣ�����������
	 * @return ���̱���������Ϣ�б�
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ�����̱���������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond ���̱���������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ���̱���������Ϣ�б�
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond, int start, int count);

	/**
	 * �������̱�������ID��ѯ���̱���������Ϣ
	 * 
	 * @param pidid ���̱�������ID
	 * @return ���̱���������Ϣ
	 * @throws BLException 
	 */
	public IG007Info searchProcessInfoDefByKey(String pidid) throws BLException;
	
	/**
	 * �������̱���������Ϣ����
	 * 
	 * @param processInfoDef ���̱���������Ϣ
	 * @return ���̱���������Ϣ
	 * @throws BLException
	 */
	public IG007Info registProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * ������̱���������Ϣ����
	 * 
	 * @param processInfoDef ���̱���������Ϣ
	 * @return ���̱���������Ϣ
	 * @throws BLException
	 */
	public IG007Info updateProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * ����״̬����������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond);
	
	/**
	 * ɾ�����̱���������Ϣ����
	 * 
	 * @param pidid ���̱���������Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDefByKey(String pidid) throws BLException;
	
	/**
	 * ɾ�����̱���������Ϣ����
	 * 
	 * @param processInfoDef ���̱���������Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDef(IG007Info processInfoDef) throws BLException;
	
	/**
	 * ����������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PIDID����ֵ
	 */
	public String getProcessInfoDefPK(String pdid);
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ������
	 * @param pdid ���̶���ID
	 * @return  Map<String,List<IG337Info>> ���̱���ȱʡ������
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid);
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ����������(ppcomment��ȡ֮����Ҫ���)
	 * @param pdid ���̶���ID
	 * @return  List<IG337Info> ���̱���ȱʡ����������
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid);
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG105Info> searchProcessStrategyDef(IG105SearchCond cond);
	
	/**
	 * ��ѯ��ɫ����
	 * @param cond ��ѯ����
	 * @return ��ɫ������Ϣ����
	 * @throws BLException
	 */
	public List<IG001Info> searchOARoleConfig(IG001SearchCond cond) throws BLException;
	
	/**
	 * ɾ����ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @throws BLException
	 */
	public void deleteOARoleConfig(IG001Info entity) throws BLException;
	
	/**
	 * ɾ����ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @throws BLException
	 */
	public void deleteOARoleConfig(List<IG001Info> entitys) throws BLException;
	
	/**
	 * ע���ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @return ��ɫ������Ϣ
	 * @throws BLException
	 */
	public IG001Info registOARoleConfig(IG001Info entity) throws BLException;
	
	/**
	 * �������Ͳ�ѯ���ý�ɫ����
	 * @param type ����
	 * @return
	 * @throws BLException
	 */
	public List<Integer> searchOARoleidByType(String type) throws BLException;
	
	/**
	 * ��ɫ��Ȩ������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG701Info> searchRoleForm(IG701SearchCond cond);
	
	/**
	 * �¼��������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG413Info> searchWorkFlowEventHandler(IG413SearchCond cond);
	
	/**
	 * �¼���������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getWorkFlowEventHandlerPK(String psdid);
	
	/**
	 * ע���¼�����
	 * @param entity �¼�����ʵ��
	 * @return �¼�����ʵ��
	 * @throws BLException
	 */
	public IG413Info registWorkFlowEventHandler(IG413Info entity) throws BLException;
	
	/**
	 * �����¼�����
	 * @param entity �¼�����ʵ��
	 * @return �¼�����ʵ��
	 * @throws BLException
	 */
	public IG413Info updateWorkFlowEventHandler(IG413Info entity) throws BLException;
	
	/**
	 * ��������ɾ���¼�����
	 * @param key �¼���������
	 * @throws BLException
	 */
	public void deleteWorkFlowEventHandlerByKey(String key) throws BLException;
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getProcessStatusDefSearchCount(IG333SearchCond cond) throws BLException;
	
	/**
	 * ״̬��Ϣ����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG333Info> searchProcessStatusDef(IG333SearchCond cond);
	
	/**
	 * �ɱ����ɽڵ����
	 * @param psdid ���ɽڵ㶨��id
	 * @param pbdid ������ť
	 * @return �������
	 * @throws BLException
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid,String pbdid) throws BLException;
	
	/**
	 * ��������״̬����
	 * @param psdid ����
	 * @return ״̬������Ϣ
	 * @throws BLException
	 */
	public IG333Info searchProcessStatusDefByKey(String psdid) throws BLException;
	
	/**
	 * ָ��״̬�����Ŀɵ��������ߵ�״̬����ȡ��
	 * @param psdid ״̬ID
	 * @return ״̬����
	 */
	public List<IG333Info> searchAdjustStatus(String psdid);
	
	/**
	 * ���ܣ�����״̬code��ȡָ���������͵�״̬ID
	 * @param pdid ���̶���ID
	 * @param psdcode ����״̬��ʶ
	 * @return ����״̬ID
	 * @throws BLException 
	 */
	public String searchProcessStatusKey(String pdid,String psdcode) throws BLException;
	
	/**
	 * ��������״̬����
	 * @param entity ����״̬����ʵ��
	 * @return ����״̬����ʵ��
	 * @throws BLException
	 */
	public IG333Info registProcessStatus(IG333Info entity) throws BLException;
	
	/**
	 * ����״̬��������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return ����״̬��������ֵ
	 */
	public String getProcessStatusDefPK(String pdid_one);
	
	/**
	 * ��������ɾ��״̬����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessStatusDefByPK(String pk) throws BLException;
	
	/**
	 * ��������״̬����
	 * @param entity ����״̬����ʵ��
	 * @return ����״̬����ʵ��
	 * @throws BLException
	 */
	public IG333Info updateProcessStatus(IG333Info entity) throws BLException;
	
	/**
	 * ���ܣ���ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid,String pdid);
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid);
	
	/**
	 * �����˶������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG222Info> searchParticipantDef(IG222SearchCond cond);
	
	/**
	 * ����������ѯ�����˶�����Ϣ
	 * @param pk ����
	 * @return �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info searchParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * �����˶�������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return �����˶�������ֵ
	 */
	public String getParticipantDefPK(String pdid_one) throws BLException;
	
	/**
	 * ���������˶�����Ϣ
	 * @param entity �����˶���ʵ��
	 * @return �����˶���ʵ��
	 * @throws BLException
	 */
	public IG222Info registParticipantDef(IG222Info entity) throws BLException;
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getParticipantSearchCount(IG222SearchCond cond) throws BLException;
	
	/**
	 * ɾ�������˶�����Ϣ
	 * @param entity �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info deleteParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * ���²����˶�����Ϣ
	 * @param entity �����˶�����Ϣ
	 * @return �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info updateParticipantDef(IG222Info entity) throws BLException;
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getParticipantDefSearchCount(IG222SearchCond cond) throws BLException;
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid);
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid);
	
	/**
	 * ����ʼ���¼�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG373Info> searchInitFormEventHandler(IG373SearchCond cond);
	
	/**
	 * ����ʼ���¼�����ֵȡ��
	 * @param ����״̬ID
	 * @return ����ʼ���¼�����ֵ
	 */
	public String getInitFormEventHandlerPK(String psdid) throws BLException;
	
	/**
	 * ע�����ʼ���¼�
	 * @param entity ����ʼ���¼�ʵ��
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info registInitFormEventHandler(IG373Info entity) throws BLException;
	
	/**
	 * ���±���ʼ���¼�
	 * @param entity ����ʼ���¼�ʵ��
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info updateInitFormEventHandler(IG373Info entity) throws BLException;
	
	/**
	 * ������������ʼ���¼�
	 * @param pk ����
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info searchInitFormEventHandlerByKey(String pk) throws BLException;
	
	/**
	 * ��������ɾ������ʼ���¼�
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteInitFormEventHandlerByKey(String pk) throws BLException;
	
	/**
	 * ע���ɫ��Ȩ��
	 * @param entity ��ɫ��Ȩ��ʵ��
	 * @return ��ɫ��Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG701Info registRoleForm(IG701Info entity) throws BLException;
	
	/**
	 * ��������ɾ����ɫ��Ȩ��
	 * @param pk
	 * @throws BLException
	 */
	public void deleteRoleForm(IG701PK pk) throws BLException;
	
	/**
	 * ���̱��ⶨ�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG243Info> searchProcessTitleDef(IG243SearchCond cond);
	
	/**
	 * ���̱��ⶨ������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	public String getProcessTitleDefPK(String pdid_one);
	
	/**
	 * �������̱��ⶨ��
	 * @param entity ���̱��ⶨ��ʵ��
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info registProcessTitleDef(IG243Info entity) throws BLException;
	
	/**
	 * ������ѯ���̱��ⶨ��
	 * @param pk ����
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info searchProcessTitleDefByPK(String pk) throws BLException;
	
	/**
	 * �������̱��ⶨ��
	 * @param entity ���̱��ⶨ��ʵ��
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info updateProcessTitleDef(IG243Info entity) throws BLException;
	
	/**
	 * ����״̬������ѯ�ɱ����ɲ�����(��ɫ)
	 * @param psdid ״̬����
	 * @return �������
	 * @throws BLException
	 */
	public List<IG298Info> searchProcessStatusRoleDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * �ɱ����ɲ�����(��ɫ)ʵ�����ڼ��
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ʵ��
	 * @throws BLException
	 */
	public IG298Info checkProcessStatusRoleDefInfo(String psdid, Integer roleid) throws BLException;
	
	/**
	 * �ɱ����ɲ�����(��ɫ)����ֵȡ��
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɲ�����(��ɫ)����ֵ
	 */
	public String getProcessStatusRoleDefInfoPK(String psdid) throws BLException;
	
	/**
	 * ע��ɱ����ɲ�����(��ɫ)
	 * @param entity �ɱ����ɲ�����(��ɫ)ʵ��
	 * @return �ɱ����ɲ�����(��ɫ)ʵ��
	 * @throws BLException
	 */
	public IG298Info registProcessStatusRoleDefInfo(IG298Info entity) throws BLException;
	
	/**
	 * ɾ���ɱ����ɲ�����(��ɫ)
	 * @param entity �ɱ����ɲ�����(��ɫ)ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusRoleDefInfoByKey(String pk) throws BLException;
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ���̶���ID
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid);
	
	/**
	 * ����״̬������ѯ�ɱ����ɲ�����(����)
	 * @param psdid ״̬����
	 * @return �������
	 * @throws BLException
	 */
	public List<IG299Info> searchProcessStatusOrgDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * �ɱ����ɵĻ�����������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĻ����б�
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid);
	
	/**
	 * �ɱ����ɵĻ�������ֵȡ��
	 * @param ����״̬ID
	 * @return �ɱ����ɵĻ�������ֵ
	 */
	public String getProcessStatusOrgDefInfoPK(String psdid) throws BLException;
	
	/**
	 * ע��ɱ����ɵĻ���
	 * @param entity �ɱ����ɵĻ���ʵ��
	 * @return �ɱ����ɵĻ���ʵ��
	 * @throws BLException
	 */
	public IG299Info registProcessStatusOrgDefInfo(IG299Info entity) throws BLException;
	
	/**
	 * ��������ɾ���ɱ����ɵĻ���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessStatusOrgDefInfoByKey(String pk) throws BLException;
	
	/**
	 * ��ɫ��Χ����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG213Info> searchProcessRoleTypeDef(IG213SearchCond cond);
	
	/**
	 * ��ɫ��Χ����ֵȡ��
	 * @param ���̶���ID
	 * @return ��ɫ��Χ����ֵ
	 */
	public String getProcessRoleTypeDefPK(String pdid_one) throws BLException;
	
	/**
	 * ע���ɫ��Χ��Ϣ
	 * @param entity ��ɫ��Χ��Ϣʵ��
	 * @return ��ɫ��Χ��Ϣʵ��
	 * @throws BLException
	 */
	public IG213Info registProcessRoleTypeDef(IG213Info entity) throws BLException;
	
	/**
	 * ��������ɾ����ɫ��Χ��Ϣ
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessRoleTypeDefByKey(String pk) throws BLException;
	
	/**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond);
    
	/**
	 * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond);
	
	/**
     * ״̬�����߹����������Ͷ�������ֵȡ��
     * @param ����״̬ID
     * @return ״̬�����߹����������Ͷ�������ֵ
     */
	public String getParticipantRelevantDefPK(String psdid) throws BLException;
	
	/**
	 * ע��״̬�����߹����������Ͷ���
	 * @param entity ״̬�����߹����������Ͷ���ʵ��
	 * @return ״̬�����߹����������Ͷ���ʵ��
	 * @throws BLException
	 */
	public IG911Info registParticipantRelevantDefInfo(IG911Info entity) throws BLException;
	
	/**
	 * ��������ɾ��״̬�����߹����������Ͷ���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteParticipantRelevantDefInfoByKey(String pk) throws BLException;
	
	/**
	 * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG380Info> searchIg380ByIg911Cond(IG911SearchCond cond);
	
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond);
    
	/**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG931Info> searchIg931RelevantPdid(IG931SearchCond cond);
    
    /**
     * �������̶�����������������Χ
     * @param pdid ���̶�������
     * @return �������
     */
    public List<IG123Info> searchProcessOrgScopeByPdid(String pdid);
    
	/**
	 * ������Χ����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return ������Χ����ֵ
	 */
    public String getProcessOrgScopePK(String pdid_one) throws BLException;
    
    /**
     * ע�������Χ
     * @param entity ������Χʵ��
     * @return ������Χʵ��
     * @throws BLException
     */
    public IG123Info registProcessOrgScope(IG123Info entity) throws BLException;
    
    /**
     * ɾ��������Χ
     * @param entity ������Χʵ��
     * @throws BLException
     */
    public void deleteProcessOrgScope(List<IG123Info> entitys) throws BLException;
    
    /**
     * ����״̬��ť�������
     * @param cond ��������
     * @return ����״̬��ť������Ϣ����
     * @throws BLException
     */
    public List<IG156Info> searchProcessStatusButtonDef(IG156SearchCond cond) throws BLException;
    
    /**
     * ������������״̬��ť����
     * @param pk ����
     * @return ����״̬��ť������Ϣ
     * @throws BLException
     */
    public IG156Info searchProcessStatusButtonDefByKey(String pk) throws BLException;
    
	/**
	 * ״̬��ť��������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getProcessStatusButtonDefPK(String psdid);
	
	/**
	 * ע��״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @return ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public IG156Info registProcessStatusButtonDef(IG156Info entity) throws BLException;
	
	/**
	 * ����״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @return ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public IG156Info updateProcessStatusButtonDef(IG156Info entity) throws BLException;
	
	/**
	 * ��������ɾ��״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusButtonDefByPK(String pk) throws BLException;
	
	/**
	 * ������������Ϣ����
	 * @param cond �������� 
	 * @return �������
	 * @throws BLException
	 */
	public List<IG286Info> searchProcessLinkageDef(IG286SearchCond cond) throws BLException;
	
	/**
	 * ������������Ϣ����ֵȡ��
	 * @param ���̶���ID
	 * @return ������������Ϣ����ֵ
	 */
	public String getProcessLinkageDefPK(String pdid_one) throws BLException;
	
	/**
	 * ע�������������Ϣ
	 * @param entity ������������Ϣʵ��
	 * @return ������������Ϣʵ��
	 * @throws BLException
	 */
	public IG286Info registProcessLinkageDef(IG286Info entity) throws BLException;
	
	/**
	 * ɾ��������������Ϣ
	 * @param entity ������������Ϣʵ��
	 * @return ������������Ϣʵ��
	 * @throws BLException
	 */
	public void deleteProcessLinkageDef(IG286Info entity) throws BLException;
	
	/**
	 * ��������������������Ϣ
	 * @param pk ����
	 * @return ������������Ϣ
	 * @throws BLException
	 */
	public IG286Info searchProcessLinkageDefByKey(String pk) throws BLException;
	
	/**
	 * �����˰�ť�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG132Info> searchParticipantButtonDef(IG132SearchCond cond) throws BLException;
	
	/**
	 * �������������˰�ť����
	 * @param pk ����
	 * @return �����˰�ť������Ϣ
	 * @throws BLException
	 */
	public IG132Info searchParticipantButtonDefByKey(String pk) throws BLException;
	
	/**
	 * �����˰�ť��������ֵȡ��
	 * @param ���̶���ID
	 * @return �����˰�ť��������ֵ
	 */
	public String getParticipantButtonDefPK(String pbdid) throws BLException;
	
	/**
	 * ע������˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @return �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public IG132Info registParticipantButtonDef(IG132Info entity) throws BLException;
	
	/**
	 * ��������ɾ�������˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public void deleteParticipantButtonDefByKey(String pk) throws BLException;
	
	/**
	 * ���²����˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @return �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public IG132Info updateParticipantButtonDef(IG132Info entity) throws BLException;
	
	/**
	 * �����˰�ť������ͼ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG221Info> searchParticipantButtonVW(IG221SearchCond cond) throws BLException;
	
	/**
	 * ȱʡ�����˰�ť������ͼ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG221Info> searchDefaultParticipantButtonVW(IG221SearchCond cond) throws BLException;
	
	/**
	 * ���̲����߱���Ȩ����ͼ��ѯ
	 * @param cond ��ѯ����
	 * @return ���̲����߱���Ȩ��
	 * @throws BLException 
	 */
	public List<IG100Info> searchProcessInfoParticipantDefVW(IG100SearchCond cond) throws BLException;
	
	/**
	 * �������������˱���Ȩ����Ϣ
	 * @param pk ����
	 * @return �����˱���Ȩ����Ϣ
	 * @throws BLException
	 */
	public IG881Info searchProcessInfoParticipantDefByKey(String pk) throws BLException;
	
	/**
	 * �����˱���Ȩ������ֵȡ��
	 * @param ����״̬�����߶���ID
	 * @return �����˱���Ȩ������ֵ
	 */
	public String getProcessInfoParticipantDefPK(String ppdid) throws BLException;
	
	/**
	 * ע������˱���Ȩ��
	 * @param entity �����˱���Ȩ��ʵ��
	 * @return �����˱���Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG881Info registProcessInfoParticipantDef(IG881Info entity) throws BLException;
	
	/**
	 * ���²����˱���Ȩ��
	 * @param entity �����˱���Ȩ��ʵ��
	 * @return �����˱���Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG881Info updateProcessInfoParticipantDef(IG881Info entity) throws BLException;
	
	/**
	 * ԾǨ�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG273Info> searchProcessTransitionDef(IG273SearchCond cond) throws BLException;
	
	/**
	 * ԾǨ��������ֵȡ��
	 * @param ����״̬ID
	 * @return ԾǨ��������ֵ
	 */
	public String getProcessTransitionDefPK(String psdid) throws BLException;
	
	/**
	 * ע��ԾǨ����
	 * @param entity ԾǨ����ʵ��
	 * @return ԾǨ����ʵ��
	 * @throws BLException
	 */
	public IG273Info registProcessTransitionDef(IG273Info entity) throws BLException;
	
	/**
	 * ����ԾǨ����
	 * @param entity ԾǨ����ʵ��
	 * @return ԾǨ����ʵ��
	 * @throws BLException
	 */
	public IG273Info updateProcessTransitionDef(IG273Info entity) throws BLException;
	
	/**
	 * ��������ɾ��ԾǨ����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessTransitionDefByKey(String pk) throws BLException;
	
	/**
	 * ȱʡ�����˰�ť�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG725Info> searchParticipantDefaultButtonDef(IG725SearchCond cond) throws BLException;
	
	/**
	 * ����ȷ�ϰ�ť����
	 * @param psdid ����״̬ID
	 */
	public void registConfirmButton(String psdid) throws BLException;
	
	/**
	 * ɾ��ȷ�ϰ�ť����
	 * @param psdid ����״̬ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException;
	
	/**
	 * ȱʡ�����˰�ť��������ֵȡ��
	 * @param ���̶���ID
	 * @return ȱʡ�����˰�ť��������ֵ
	 */
	public String getParticipantDefaultButtonDefPK(String psdid) throws BLException;
	
	/**
	 * ע��ȱʡ�����˰�ť����
	 * @param entity ȱʡ�����˰�ť����ʵ��
	 * @return ȱʡ�����˰�ť����ʵ��
	 * @throws BLException
	 */
	public IG725Info registParticipantDefaultButtonDef(IG725Info entity) throws BLException;
	
	/**
	 * ����ȱʡ�����˰�ť����
	 * @param entity ȱʡ�����˰�ť����ʵ��
	 * @return ȱʡ�����˰�ť����ʵ��
	 * @throws BLException
	 */
	public IG725Info updateParticipantDefaultButtonDef(IG725Info entity) throws BLException;
	
	/**
	 * ��������ɾ��ȱʡ�����˰�ť����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteParticipantDefaultButtonDefByKey(String pk) throws BLException;
	
	/**
	 * ��������ɾ��ȱʡ�����˰�ť����
	 * @param pk ����
	 * @throws BLException
	 */
	public IG725Info searchParticipantDefaultButtonDefByKey(String pk) throws BLException;
	
	/**
	 * ����ҳ�����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG126Info> searchProcessJspDef(IG126SearchCond cond) throws BLException;
	
	/**
	 * ����ҳ������ֵȡ��
	 * @param ���̶���ID
	 * @return ����ҳ������ֵ
	 */
	public String getProcessJspDefPK(String pdid) throws BLException;
	
	/**
	 * ע�ᶨ��ҳ��
	 * @param entity ����ҳ��ʵ��
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info registProcessJspDef(IG126Info entity) throws BLException;
	
	/**
	 * ���¶���ҳ��
	 * @param entity ����ҳ��ʵ��
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info updateProcessJspDef(IG126Info entity) throws BLException;
	
	/**
	 * ������������ҳ��
	 * @param pk ����
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info searchProcessJspDefByKey(String pk) throws BLException;
	
	/**
	 * ��������ɾ������ҳ��
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessJspDefByKey(String pk) throws BLException;
	
	/**
	 * ����ȱʡ����Ȩ����ͼ��ѯ
	 * @param cond ��ѯ����
	 * @return ����ȱʡ����Ȩ��
	 * @throws BLException 
	 */
	public List<IG909Info> searchParticipantDefaultVariableVW(IG909SearchCond cond) throws BLException;
	
	/**
	 * ����ȱʡ����Ȩ������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return ����ȱʡ����Ȩ������ֵ
	 */
	public String getParticipantDefaultVariablePK(String pdid) throws BLException;
	
	/**
	 * ע������ȱʡ����Ȩ��
	 * @param entity ����ȱʡ����Ȩ��ʵ��
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info registParticipantDefaultVariable(IG699Info entity) throws BLException;
	
	/**
	 * ��������ȱʡ����Ȩ��
	 * @param entity ����ȱʡ����Ȩ��ʵ��
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info updateParticipantDefaultVariable(IG699Info entity) throws BLException;
	
	/**
	 * ������������ȱʡ����Ȩ��
	 * @param pk ����
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info searchParticipantDefaultVariableByKey(String pk) throws BLException;
	
	/**
	 * ȱʡ����Ȩ�޼���
	 * @param cond ��������
	 * @return ȱʡ����Ȩ�޼���
	 * @throws BLException
	 */
	public List<IG699Info> searchParticipantDefaultVariable(IG699SearchCond cond) throws BLException;
	
	/**
	 * ���̲鿴��ɫ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG700Info> searchProcessSeeRoleInfo(IG700SearchCond cond) throws BLException;
	
	/**
	 * ע�����̲鿴��ɫ
	 * @param entity ���̲鿴��ɫʵ��
	 * @return ���̲鿴��ɫʵ��
	 * @throws BLException
	 */
	public IG700Info registProcessSeeRoleInfo(IG700Info entity) throws BLException;
	
	/**
	 * ��������ɾ�����̲鿴��ɫ
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessSeeRoleInfoByKey(IG700PK pk) throws BLException;
	
	/**
	 * ���̹�ͨ���������������
	 * @param cond ��������
	 * @return ��������
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralSearchCount(IG202SearchCond cond) throws BLException;
	
	/**
	 * ���̹�ͨ��������(��ҳ��)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneral(IG202SearchCond cond,int start,int count) throws BLException;

	/**
	 * ���̹�ͨ���������������
	 * @param cond ��������
	 * @return ��������
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralVWSearchCount(IG202SearchCond cond) throws BLException;
	
	/**
	 * ���̹�ͨ��������(��ҳ��)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneralVW(IG202SearchCond cond,int start,int count) throws BLException;
	
	/**
	 * �����������̹�ͨ����
	 * @param pk ����
	 * @return ���̹�ͨ����
	 * @throws BLException
	 */
	public IG202Info searchProcessInfoDefGeneralByKey(Integer pk) throws BLException;
	
	/**
	 * ע�����̹�ͨ����
	 * @param entity ���̹�ͨ����ʵ��
	 * @return ����ͳͳ����ʵ��
	 * @throws BLException
	 */
	public IG202Info registProcessInfoDefGeneral(IG202Info entity) throws BLException;
	
	/**
	 * ���̹�ͨ��������
	 * @param entity ���̹�ͨ����ʵ��
	 * @return ���̹�ͨ����ʵ��
	 * @throws BLException
	 */
	public IG202Info updateProcessInfoDefGeneral(IG202Info entity) throws BLException;
	
	/**
	 * ��������ɾ�����̹�ͨ����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessInfoDefGeneralByKey(Integer pk) throws BLException;
	
	/**
	 * ע������֪ͨ����
	 * @param entity ����֪ͨ����ʵ��
	 * @return ����֪ͨ����ʵ��
	 * @throws BLException
	 */
	public IG212Info registProcessNoticeStrategyDefInfo(IG212Info entity) throws BLException;
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	public List<IG238Info> searchProcessNoticeStrategyVWInfoByPdid(String pdid) throws BLException;
	
	/**
	 * ���̲���֪ͨ�˼���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG237Info> searchProcessNoticeStrategyUserInfo(IG237SearchCond cond);
	
	/**
	 * ɾ�����̲���֪ͨ��
	 * @param entity ���̲���֪ͨ��ʵ��
	 * @throws BLException
	 */
	public void deleteProcessNoticeStrategyUserInfo(IG237Info entity) throws BLException;
	
	/**
	 * ע�����̲���֪ͨ��
	 * @param entitys ���̲���֪ͨ��ʵ�弯��
	 * @throws BLException
	 */
	public void registProcessNoticeStrategyUserInfo(List<IG237Info> entitys) throws BLException;
	
	/**
	 * �������������ⲿ���ö���
	 * @param pk ����
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info searchProcessExternalDefInfoByKey(Integer pk) throws BLException;
	
	/**
	 * ע�������ⲿ���ö���
	 * @param entity �����ⲿ���ö���ʵ��
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info registProcessExternalDefInfo(IG992Info entity) throws BLException;
	
	/**
	 * ���������ⲿ���ö���
	 * @param entity �����ⲿ���ö���ʵ��
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info updateProcessExternalDefInfo(IG992Info entity) throws BLException;
	
	/**
	 * ��������ɾ�������ⲿ���ö���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessExternalDefInfoByKey(Integer pk) throws BLException;
	
	/**
	 * �����ⲿ���ö������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG992Info> searchProcessExternalDefInfo(IG992SearchCond cond) throws BLException;
	
	/**
	 * ����״̬�����ߵ�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG258Info> searchProcessStatusPrtChangeDefInfo(IG258SearchCond cond) throws BLException;
	
	/**
	 * ����״̬�����ߵ�������ֵȡ��
	 * @param ���̶���ID
	 * @return ����״̬�����ߵ�������ֵ
	 */
	public String getProcessStatusPrtChangeDefPK(String psdid) throws BLException;
	
	/**
	 * ע������״̬�����ߵ���
	 * @param entity ����״̬�����ߵ���ʵ��
	 * @return ����״̬�����ߵ���ʵ��
	 * @throws BLException
	 */
	public IG258Info registProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException;
	
	/**
	 * ɾ������״̬�����ߵ���
	 * @param entity ����״̬�����ߵ���ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException;
	
	/**
	 * ע����ɶ���
	 * @param entity ���ɶ���ʵ��
	 * @return ���ɶ���ʵ��
	 * @throws BLException
	 */
	public IG233Info registAssignedDefInfo(IG233Info entity) throws BLException;
	
	/**
	 * ��ѯָ��״̬�ķ�����Ϣ
	 * @param psdid ״̬ID
	 * @return ������Ϣ���
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfoByPsdid(String psdid) throws BLException;
	
	/**
	 * ��������״̬�ķ�����Ϣ
	 * @param cond ��������
	 * @return ������Ϣ���
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfo(IG233SearchCond cond) throws BLException;
	
	/**
	 * ɾ��������Ϣ
	 * @param entitys ������Ϣʵ�弯��
	 * @throws BLException
	 */
	public void deleteAssignedDefInf(List<IG233Info> entitys) throws BLException;
	
	/**
	 * �������̶���������ѯ����ѯ��������
	 * @param pdid ���̶�������
	 * @return ����ѯ��������ʵ��
	 * @throws BLException
	 */
	public List<IG108Info> searchFormQueryDefByPdid(String pdid) throws BLException;
	
	/**
	 * ע�����ѯ����
	 * @param entity ����ѯ����ʵ��
	 * @return ����ѯ����ʵ��
	 * @throws BLException
	 */
	public IG108Info registFormQueryDefInfo(IG108Info entity) throws BLException;
	
	/**
	 * ��������ɾ������ѯ��������
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteFormQueryDefByKey(Integer pk) throws BLException;
	
	/**
	 * ֪ͨ���Լ���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG334Info> searchInformStrategy(IG334SearchCond cond) throws BLException;
	
	/**
	 * ע��֪ͨ����
	 * @param entity ֪ͨ����ʵ��
	 * @return ֪ͨ����ʵ��
	 * @throws BLException
	 */
	public IG334Info registInformStrategy(IG334Info entity) throws BLException;
	
	/**
	 * ɾ��֪ͨ����
	 * @param entity ֪ͨ����ʵ��
	 * @throws BLException
	 */
	public void deleteInformStrategy(IG334Info entity) throws BLException;
	
	/**
	 * �����Լ���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategy(IG335SearchCond cond) throws BLException;
	
	/**
	 * ��ʱ֪ͨ���Բ�ѯ
	 * @param pdid ���̶���ID
	 * @param psdid ״̬����ID
	 * @param pidid ������ID
	 * @return  ��ʱ֪ͨ�����б�
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategyVW(String pdid,  String psdid, String pidid, String psdconfirm) throws BLException;
	
	/**
	 * ע�������
	 * @param entity ������ʵ��
	 * @return ������ʵ��
	 * @throws BLException
	 */
	public IG335Info registFormStrategy(IG335Info entity) throws BLException;
	
	/**
	 * ������ɾ��
	 * @param entitys ������ʵ�弯��
	 * @throws BLException
	 */
	public void deleteFormStrategy(List<IG335Info> entitys) throws BLException;
	
	/**
	 * XML�ű���������
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public String exportXML(String pdid) throws BLException;
	
	/**
	 * XML�ű����봦��
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(List<org.jdom.Element> elements) throws BLException;
	
	/**
	 * ����ɫ��Χע��
	 * @param entity ����ɫ��Χʵ��
	 * @return ����ɫ��Χʵ��
	 * @throws BLException
	 */
	public IG008Info registFormRoleScope(IG008Info entity) throws BLException;

	/**
	 * ���ݱ�����ID��������ɫ�޶���Χ
	 * @param pidid ����������
	 * @return
	 */
	public List<IG008Info> searchFormRoleScopeByPidid(String pidid);
	
	/**
	 * ����ɫ�޶���Χɾ��
	 * @param entitys ����ɫ�޶���Χʵ�弯��
	 */
	public void deleteFormRoleScope(List<IG008Info> entitys) throws BLException;
	
    /**
     * ״̬��˽�б�����������
     * @Description: ״̬��˽�б�����������
     * @param dfvalue Ĭ��ֵ
     * @param usedToAll �Ƿ�Ӧ�õ�����״̬
     * @param psdid ״̬id
     * @param pidid ��id
     * @throws BLException
     */
    public void saveOrUpdateStatusDefault(String dfvalue, boolean usedToAll, String psdid, String pidid) throws BLException;
    
    /**
     * ��ѯĳһ״̬��ĳһ����Ĭ��ֵ�����ͬһ�����ж��Ĭ��ֵ����ȡ���Ȩ�ޡ�
     * @Description: ��ѯĳһ״̬��ĳһ����Ĭ��ֵ�����ͬһ�����ж��Ĭ��ֵ����ȡ���Ȩ�ޡ�
     * @param psdid �ڵ�id,like��ѯ
     * @param pidid ��id,like��ѯ
     * @throws BLException
     */
    public List<IG560VWInfo> searchIG560VWInfo(String psdid, String pidid) throws BLException;
    
    /**
     * ״̬��˽�б�Ĭ��ֵ cond����
     * @Description: ״̬��˽�б�Ĭ��ֵ cond����
     * @param cond 
     * @return
     * @throws BLException
     */
    public List<IG560Info> searchIG560TBInfo(IG560SearchCond cond) throws BLException;

    /**
     * ����״̬��˽�б�Ĭ��ֵ
     * @Description: ����״̬��˽�б�Ĭ��ֵ
     * @param list ig560list
     * @throws BLException
     */
    public void saveStatusDefaultList(List<IG560Info> list) throws BLException;

    /**
     * ���̲�ѯ��ʾ�в�ѯ
     * @param pdid ���̶���ID
     * @return ���̲�ѯ��ʾ�м���
     * @throws BLException
     */
	public List<IG110Info> searchProcessQueryShowColumnByPdid(String pdid) throws BLException;

	/**
	 * ���̲�ѯ������ѯ
	 * @param pdid ���̶���ID
	 * @return ���̲�ѯ��������
	 * @throws BLException
	 */
	public List<IG111Info> searchprocessQueryByPdid(String pdid) throws BLException;

	/**
	 * ɾ�����̲�ѯ��ʾ��
	 * @param instance ���̲�ѯ��ʾ��
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumn(IG110Info instance) throws BLException;

	/**
	 * ɾ�����̲�ѯ����
	 * @param instance ���̲�ѯ����
	 * @throws BLException
	 */
	public void deleteProcessQuery(IG111Info instance) throws BLException;

	/**
	 * ���̲�ѯ��ʾ�ж���ǼǴ���
	 * @param instance ���̲�ѯ��ʾ��ʵ��
	 * @return ���̲�ѯ��ʾ��ʵ��
	 * @throws BLException
	 */
	public IG110Info registProcessQueryShowColumn(IG110Info instance) throws BLException;
	
	/**
	 * ���̲�ѯ��ʾ�ж�����´���
	 * @param instance ���̲�ѯ��ʾ��ʵ��
	 * @return ���̲�ѯ��ʾ��ʵ��
	 * @throws BLException
	 */
	public IG110Info updateProcessQueryShowColumn(IG110Info instance) throws BLException;
	
	/**
	 * ȡ�ò�ѯ��ʾ��ʵ�����һ��ID
	 * @param pdid ���̶���ID
	 * @return ������ʾ��ʵ��ID
	 * @throws BLException
	 */
	public String getProcessQueryShowColumnNextId(String pdid) throws BLException;
	
	/**
	 * ȡ�ò�ѯ����ʵ�����һ��ID
	 * @param pdid ���̶���ID
	 * @return ���̲�ѯ����ʵ��ID
	 * @throws BLException
	 */
	public String getProcessQueryNextId(String pdid) throws BLException;

	/**
	 * ���̲�ѯ�����ǼǴ���
	 * @param instance ���̲�ѯ����ʵ��
	 * @return ���̲�ѯ����ʵ��
	 * @throws BLException
	 */
	public IG111Info registProcessQuery(IG111Info instance) throws BLException;
	/**
	 * ���ܣ����������鶨��ID��ȡ�����鶨��
	 * @param pgdid ���̶���ID
	 * @return �����鶨����Ϣ
	 * @throws BLException
	 */
	public IG480Info searchGroupProcessDefinitionByKey(String pgdid) throws BLException;
	/**
	 * ���ܣ����������鶨����Ϣ
	 * 
	 * @param processDefinition �����鶨����Ϣ
	 * @return �����鶨��
	 * @throws BLException
	 */
	public IG480Info updateGroupProcessDefinition(IG480Info processDefinition) throws BLException;
	/**
	 * �����鶨�����洦��洢����
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException;
	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 */
	public String copyGroupProcessDefVersion(String pgdid) throws BLException;

	/**
	 * ����pdidɾ�����̲�ѯ��ʾ��
	 * 
	 * @param instance
	 *            ���̲�ѯ��ʾ��
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumnByPdid(String pdid) throws BLException;

	/**
	 * ����pdidɾ�����̲�ѯ����
	 * 
	 * @param instance
	 *            ���̲�ѯ����
	 * @throws BLException
	 */
	public void deleteProcessQueryByPdid(String pdid) throws BLException;

}
