/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prd.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.infogovernor.prd.form.IGPRD0101Form;
import com.deliverik.infogovernor.prd.form.IGPRD0102Form;
import com.deliverik.infogovernor.prd.form.IGPRD0104Form;
import com.deliverik.infogovernor.prd.form.IGPRD0105Form;
import com.deliverik.infogovernor.prd.form.IGPRD0107Form;
import com.deliverik.infogovernor.prd.form.IGPRD0108Form;
import com.deliverik.infogovernor.prd.form.IGPRD0109Form;
import com.deliverik.infogovernor.prd.form.IGPRD0110Form;
import com.deliverik.infogovernor.prd.form.IGPRD0111Form;
import com.deliverik.infogovernor.prd.form.IGPRD0114Form;
import com.deliverik.infogovernor.prd.form.IGPRD0115Form;
import com.deliverik.infogovernor.prd.form.IGPRD0116Form;
import com.deliverik.infogovernor.prd.form.IGPRD0118Form;
import com.deliverik.infogovernor.prd.form.IGPRD0124Form;
import com.deliverik.infogovernor.prd.form.IGPRD0125Form;
import com.deliverik.infogovernor.prd.form.IGPRD0126Form;
import com.deliverik.infogovernor.prd.form.IGPRD0131Form;
import com.deliverik.infogovernor.prd.form.IGPRD0134Form;
import com.deliverik.infogovernor.prd.form.IGPRD0139Form;
import com.deliverik.infogovernor.prd.form.IGPRD0141Form;
import com.deliverik.infogovernor.prd.form.IGPRD0142Form;
import com.deliverik.infogovernor.prd.form.IGPRD0143Form;
import com.deliverik.infogovernor.prd.form.IGPRD0145Form;
import com.deliverik.infogovernor.prd.form.IGPRD0158Form;
import com.deliverik.infogovernor.prd.form.IGPRD0159Form;
import com.deliverik.infogovernor.prd.form.IGPRD0161Form;
import com.deliverik.infogovernor.prd.form.IGPRD0165Form;
import com.deliverik.infogovernor.prd.form.IGPRD0166Form;
import com.deliverik.infogovernor.prd.form.IGPRD0168Form;
import com.deliverik.infogovernor.prd.form.IGPRD0169Form;
import com.deliverik.infogovernor.prd.form.IGPRD0171Form;
import com.deliverik.infogovernor.prd.form.IGPRD0172Form;
import com.deliverik.infogovernor.prd.form.IGPRD0173Form;
import com.deliverik.infogovernor.prd.form.IGPRD0190Form;

/**
 * ����: ���̶���ҵ��DTO ��������: ���̶���ҵ��DTO ������¼: 2010/11/07 �޸ļ�¼: 2013/02/25 130225
 * ���̻�������޸�-״̬�ڵ�����������޸�
 */
@SuppressWarnings("serial")
public class IGPRD01DTO extends BaseDTO implements Serializable {

	// -----------------------------------------------------------���̶���----------------------------------------------------------------------

	// ====>130225Begin

	/** ���̶���״̬�ڵ���������ͼ���(��Ա�ͽ�ɫ) */
	protected List<LabelValueBean> lvPsdassignListUR;
	/** ���̶���״̬�ڵ���������ͼ���(��ɫ�ͻ���) */
	protected List<LabelValueBean> lvPsdassignListRO;

	/** ״̬�ڵ�ɷ��ɻ���Form */
	protected IGPRD0143Form igPRD0143Form;

	/** ״̬�ڵ�ɷ��ɻ������� */
	protected List<Organization> lst_org;

	/** ��ѡ�����б� */
	protected List<IG299Info> lst_ProcessStatusOrgDef;

	/** ������֧�ֻ���ѡ��form */
	protected IGPRD0134Form igprd0134Form;

	/** ������Χѡ��form */
	protected IGPRD0131Form igprd0131Form;

	/** ��ѡ���� */
	protected List<IG123Info> lst_orgdef;

	/** ������Ԥ��form */
	protected IGPRD0173Form igprd0173Form;
	
	/** ��������Ϣ */
	protected IG007Info processInfoDef;
	
	/** ҳ����ʾ������ϢMap */
	protected Map<IG238Info, List<IG335Info>> showMap;

	/** ״̬���� */
	protected int pssize;
	
	/** ״̬��ֵ���� */
	protected int pisize;
	
	/** ��ʱ����֪ͨBL����List */
	protected List<LabelValueBean> proccessBLList;
	
	/** ���峬ʱ����֪ͨBL����List */
	protected List<LabelValueBean> processtacticsbl_alllist;
	
	/** ����������� */
	protected List<IG335Info> processWholeTactic_list;
	
	/** ����������Ա�ֵ���� */
	protected Integer processWholeTactic_listSize;
	
	/** ״̬��˽�б�Ĭ��ֵ�б�  */
    protected List<IG560VWInfo> defaultlist;
    
    /** ���趨���̲�ѯ��ʾ�м��� */
    protected List<IG110Info> queryShowColumnList;
    
    /** δ�趨���̲�ѯ��ʾ�м��� */
    protected Map<String, String> queryShowColumnMap;
    
    /** ���趨��ѯ�������� */
    protected List<IG111Info> queryList;
    
    /** δ�趨��ѯ�������� */
    protected Map<String, String> queryMap;
    

    public List<IG560VWInfo> getDefaultlist() {
        return defaultlist;
    }

    public void setDefaultlist(List<IG560VWInfo> defaultlist) {
        this.defaultlist = defaultlist;
    }
	
	/**
	 * ״̬�ڵ�ɷ��ɻ���Formȡ��
	 * 
	 * @return igPRD0143Form ״̬�ڵ�ɷ��ɻ���Form
	 */
	public IGPRD0143Form getIgPRD0143Form() {
		return igPRD0143Form;
	}

	/**
	 * ״̬�ڵ�ɷ��ɻ���Form�趨
	 * 
	 * @param igPRD0143Form
	 *            ״̬�ڵ�ɷ��ɻ���Form
	 */
	public void setIgPRD0143Form(IGPRD0143Form igPRD0143Form) {
		this.igPRD0143Form = igPRD0143Form;
	}

	/**
	 * ���̶���״̬�ڵ���������ͼ���ȡ��
	 * 
	 * @return lvPsdassignListUR ���̶���״̬�ڵ���������ͼ���
	 */

	public List<LabelValueBean> getLvPsdassignListUR() {
		return lvPsdassignListUR;
	}

	/**
	 * ���̶���״̬�ڵ���������ͼ����趨
	 * 
	 * @param lvPsdassignListUR
	 *            ���̶���״̬�ڵ���������ͼ���
	 */
	public void setLvPsdassignListUR(List<LabelValueBean> lvPsdassignListUR) {
		this.lvPsdassignListUR = lvPsdassignListUR;
	}

	/**
	 * ���̶���״̬�ڵ���������ͼ���(��ɫ�ͻ���)ȡ��
	 * 
	 * @return lvPsdassignListRO ���̶���״̬�ڵ���������ͼ���(��ɫ�ͻ���)
	 */
	public List<LabelValueBean> getLvPsdassignListRO() {
		return lvPsdassignListRO;
	}

	/**
	 * ���̶���״̬�ڵ���������ͼ���(��ɫ�ͻ���)�趨
	 * 
	 * @param lvPsdassignListRO
	 *            ���̶���״̬�ڵ���������ͼ���(��ɫ�ͻ���)
	 */
	public void setLvPsdassignListRO(List<LabelValueBean> lvPsdassignListRO) {
		this.lvPsdassignListRO = lvPsdassignListRO;
	}

	/**
	 * ״̬�ڵ�ɷ��ɻ�������ȡ��
	 * 
	 * @return lst_org ״̬�ڵ�ɷ��ɻ�������
	 */
	public List<Organization> getLst_org() {
		return lst_org;
	}

	/**
	 * ״̬�ڵ�ɷ��ɻ��������趨
	 * 
	 * @param lst_org
	 *            ״̬�ڵ�ɷ��ɻ�������
	 */
	public void setLst_org(List<Organization> lst_org) {
		this.lst_org = lst_org;
	}

	/**
	 * ��ѡ�����б�ȡ��
	 * 
	 * @return lst_ProcessStatusOrgDef ��ѡ�����б�
	 */
	public List<IG299Info> getLst_ProcessStatusOrgDef() {
		return lst_ProcessStatusOrgDef;
	}

	/**
	 * ��ѡ�����б��趨
	 * 
	 * @param lst_ProcessStatusOrgDef
	 *            ��ѡ�����б�
	 */
	public void setLst_ProcessStatusOrgDef(
			List<IG299Info> lst_ProcessStatusOrgDef) {
		this.lst_ProcessStatusOrgDef = lst_ProcessStatusOrgDef;
	}

	// ====>130225End

	/** ���̶�����Ϣ�������� */
	protected IG380SearchCond processDefinitionSearchCond;

	/** ���̶�����ϢForm */
	protected IGPRD0102Form igPRD0102Form;

	/** ���̶�����Ϣ��������� */
	protected List<IG380Info> processDefinitionList;

	/** ��ط����Զ�������������Ϣ��������� */
	protected List<IG913Info> relevantProcessDefinitionList;

	/** �жϵ�ǰ�Ƿ����δ�رյ�������ʹ��ģ�� */
	protected String isProcessDefinitionInUse;

	protected String delFalg;

	protected List<IG413Info> processEventDefList;

	protected List<IG156Info> processStatusButtonDefList;

	/** �������������� */
	protected IG286SearchCond processLinkageDefSearchCond;

	/** ��������������� */
	protected List<IG286Info> processLinkageDefList;

	/** ������Form */
	protected IGPRD0125Form igPRD0125Form;

	protected List<IG725Info> participantDefaultButtonDefInfoList;

	protected List<IG333TB> psdTBList;

	/** ���̶��嵼��Form */
	protected IGPRD0101Form igPRD0101Form;

	/** �����ļ�·�� */
	protected String filepath_export;

	// -----------------------------------------------------------����Ϣ----------------------------------------------------------------------

	public List<IG725Info> getParticipantDefaultButtonDefInfoList() {
		return participantDefaultButtonDefInfoList;
	}

	public void setParticipantDefaultButtonDefInfoList(
			List<IG725Info> participantDefaultButtonDefInfoList) {
		this.participantDefaultButtonDefInfoList = participantDefaultButtonDefInfoList;
	}

	public List<IG156Info> getProcessStatusButtonDefList() {
		return processStatusButtonDefList;
	}

	public List<IG413Info> getProcessEventDefList() {
		return processEventDefList;
	}

	public void setProcessEventDefList(List<IG413Info> processEventDefList) {
		this.processEventDefList = processEventDefList;
	}

	public void setProcessStatusButtonDefList(
			List<IG156Info> processStatusButtonDefList) {
		this.processStatusButtonDefList = processStatusButtonDefList;
	}

	public String getDelFalg() {
		return delFalg;
	}

	public void setDelFalg(String delFalg) {
		this.delFalg = delFalg;
	}

	/** ����Ϣ��Ϣ�������� */
	protected IG007SearchCond processInfoDefSearchCond;

	protected IG202SearchCond processInfoDefGeneralSearchCond;

	/** ����Ϣ��Ϣ��������� */
	protected List<IG007Info> processInfoDefList;

	/** ����Ϣ��ϢForm */
	protected IGPRD0111Form igPRD0111Form;

	protected IGPRD0118Form igPRD0118Form;

	protected IGPRD0124Form igPRD0124Form;

	protected IGPRD0171Form igPRD0171Form;

	protected IGPRD0172Form igPRD0172Form;

	/** �����߱�Ȩ����Ϣ���� */
	protected List<IG100Info> lst_ProcessInfoParticipantDefVW;

	/** ȱʡ��Ȩ����Ϣ���� */
	protected List<IG909Info> lst_ParticipantDefaultVariableVW;

	// -----------------------------------------------------------����״̬----------------------------------------------------------------------

	/** ����״̬��Ϣ�������� */
	protected IG333SearchCond processStatusDefSearchCond;

	/** ����״̬��Ϣ��������� */
	protected List<IG333Info> processStatusDefList;

	/** ����״̬_�����߼��� */
	protected List<IG222Info> processParticipantDefList;
	
	/** ����״̬_�����߼��� */
	protected Map<Integer, List<IG222Info>> processParticipantDefMap;

	/** ����״̬_������_���̱�������Ȩ��Ϣ���� */
	protected List<IG881Info> processInfoParticipantDefList;

	/** ����״̬_ȱʡ������_���̱�������Ȩ��Ϣ���� */
	protected List<IG699Info> participantDefaultVariableList;

	/** ����״̬_������ */
	protected IG222Info processParticipantDef;

	/** ����״̬��Ϣ����Form */
	protected IGPRD0104Form igPRD0104Form;

	/** ����״̬������ϢForm */
	protected IGPRD0105Form igPRD0105Form;
	
	/** ����״̬������Form */
	protected IGPRD0107Form igPRD0107Form;

	/** ����״̬������_Ȩ��Form */
	protected IGPRD0108Form igPRD0108Form;

	/** ����״̬ȱʡ������_Ȩ��Form */
	protected IGPRD0116Form igPRD0116Form;

	/** ����״̬����Ӳ����߼��� */
	protected List<Role> roleList;

	/** ����״̬_�������Ƿ�ӵ����׼Ȩ�� */
	protected String isPpapprove;//

	/** ����״̬_�������Ƿ�ӵ�в���Ȩ�� */
	protected String isPpdeny;

	/** ����״̬_�������Ƿ�ӵ���ύȨ�� */
	protected String isPpsubmit;

	/** ����״̬_�������Ƿ�ӵ����ֹȨ�� */
	protected String isPpterm;

	/** ����״̬_�������Ƿ�ӵ�и���Ȩ�� */
	protected String isPpupdate;
	// -----------------------------------------------------------���ɽ�ɫ----------------------------------------------------------------------

	/** ���ɽ�ɫ��ϢForm */
	protected IGPRD0114Form igPRD0114Form;

	/** ����״̬�ɷ��ɽ�ɫ����Form */
	protected IGPRD0139Form igPRD0139Form;

	/** ��ѡ��ɫ�б� */
	protected List<Role> lst_Role;

	/** ��ѡ��ɫ�б� */
	protected List<IG298Info> lst_ProcessStatusRoleDef;
	// -----------------------------------------------------------ǰ����----------------------------------------------------------------------
	/** ǰ���������Ϣ���� */
	protected List<IG211TB> psidList;

	protected IGPRD0126Form igPRD0126Form;

	public IGPRD0126Form getIgPRD0126Form() {
		return igPRD0126Form;
	}

	public void setIgPRD0126Form(IGPRD0126Form igPRD0126Form) {
		this.igPRD0126Form = igPRD0126Form;
	}

	/** �Զ�������ҳ������Form 20121113 ��ѧ־ */
	protected IGPRD0168Form igPRD0168Form;
	/** �Զ�������ҳ����������Form 20121113 ��ѧ־ */
	protected IGPRD0169Form igPRD0169Form;

	/** �Զ�������ҳ�����ü�������� */
	protected List<IG126Info> processJspInfoList;

	/** �Զ���·��ҳ������ ��ѯ�������� */
	protected IG380Info ig380info;
	// -----------------------------------------------------------������----------------------------------------------------------------------

	/** ��������ϢForm */
	protected IGPRD0109Form igPRD0109Form;

	/** ���нڵ��������ϢForm */
	protected IGPRD0115Form igPRD0115Form;

	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;

	/** ��������Ϣ������� */
	protected List<IG273Info> processTransitionDefList;

	/** ��ѡ��ɫ���ͽ�� */
	protected List<IG213Info> processRoleTypeDefList;

	/** �����б� */
	protected List<LabelValueBean> labelList;

	protected List<CodeDetail> codeDetailList;

	protected List<IG202Info> processInfoDefGeneralList;

	/** ���̵���У�������Ϣ */
	protected List<String> errorMessages;

	public List<IG202Info> getProcessInfoDefGeneralList() {
		return processInfoDefGeneralList;
	}

	public void setProcessInfoDefGeneralList(
			List<IG202Info> processInfoDefGeneralList) {
		this.processInfoDefGeneralList = processInfoDefGeneralList;
	}

	public IG202SearchCond getProcessInfoDefGeneralSearchCond() {
		return processInfoDefGeneralSearchCond;
	}

	public void setProcessInfoDefGeneralSearchCond(
			IG202SearchCond processInfoDefGeneralSearchCond) {
		this.processInfoDefGeneralSearchCond = processInfoDefGeneralSearchCond;
	}

	/** ���̶�����Ϣ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	protected String imgxml;

	protected String pdid;

	protected String flag;

	/** ����״̬ID */
	protected String psdid;
	
	/** ����֪ͨ�����趨Form */
	protected IGPRD0158Form igPRD0158Form;

	/** ���̲����б� */
	protected List<IG238Info> lst_ProcessNoticeStrategyDef;

	/** ��ɫ�û��б� */
	protected List<UserRoleInfo> lst_UserRoleInfo;

	/** ���̲���֪ͨ�˲�ѯForm */
	protected IGPRD0159Form igPRD0159Form;

	/** ����ʼ�����ò�ѯForm */
	protected IGPRD0165Form igPRD0165Form;

	/** ����ʼ�������б� */
	protected List<IG373Info> lst_IG373Info;

	/** ����ʼ����������Form */
	protected IGPRD0166Form igPRD0166Form;

	/** ��ѡ�������� */
	protected List<IG123Info> pordList;

	/** ��ѡ�������� */
	protected Map<Organization, List<Organization>> orgTreeMap;
	
	/** ������form */
	protected IGPRD0110Form igprd0110Form;
	
	/** �������� */
	protected String pttype;
	
	/** ����ģ����Ϣ */
	protected IG259Info processTemplate;

	/**
	 * ������֧�ֻ���ѡ��formȡ��
	 * 
	 * @return igprd0134Form ������֧�ֻ���ѡ��form
	 */
	public IGPRD0134Form getIgprd0134Form() {
		return igprd0134Form;
	}

	/**
	 * ������֧�ֻ���ѡ��form�趨
	 * 
	 * @param igprd0134Form
	 *            ������֧�ֻ���ѡ��form
	 */
	public void setIgprd0134Form(IGPRD0134Form igprd0134Form) {
		this.igprd0134Form = igprd0134Form;
	}

	/**
	 * ������Χѡ��formȡ��
	 * 
	 * @return igprd0131Form ������Χѡ��form
	 */

	public IGPRD0131Form getIgprd0131Form() {
		return igprd0131Form;
	}

	/**
	 * ������Χѡ��form�趨
	 * 
	 * @param igprd0131Form
	 *            ������Χѡ��form
	 */
	public void setIgprd0131Form(IGPRD0131Form igprd0131Form) {
		this.igprd0131Form = igprd0131Form;
	}

	/**
	 * ��ѡ����ȡ��
	 * 
	 * @return lst_orgdef ��ѡ����
	 */
	public List<IG123Info> getLst_orgdef() {
		return lst_orgdef;
	}

	/**
	 * ��ѡ�����趨
	 * 
	 * @param lst_orgdef
	 *            ��ѡ����
	 */
	public void setLst_orgdef(List<IG123Info> lst_orgdef) {
		this.lst_orgdef = lst_orgdef;
	}

	/**
	 * ��ѡ��������ȡ��
	 * 
	 * @return pordList ��ѡ��������
	 */
	public List<IG123Info> getPordList() {
		return pordList;
	}

	/**
	 * ��ѡ���������趨
	 * 
	 * @param pordList
	 *            ��ѡ��������
	 */
	public void setPordList(List<IG123Info> pordList) {
		this.pordList = pordList;
	}

	/**
	 * ��ѡ��������ȡ��
	 * 
	 * @return orgTreeMap ��ѡ��������
	 */
	public Map<Organization, List<Organization>> getOrgTreeMap() {
		return orgTreeMap;
	}

	/**
	 * ��ѡ���������趨
	 * 
	 * @param orgTreeMap
	 *            ��ѡ��������
	 */
	public void setOrgTreeMap(Map<Organization, List<Organization>> orgTreeMap) {
		this.orgTreeMap = orgTreeMap;
	}

	public IGPRD0118Form getIgPRD0118Form() {
		return igPRD0118Form;
	}

	public void setIgPRD0118Form(IGPRD0118Form igPRD0118Form) {
		this.igPRD0118Form = igPRD0118Form;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	// �Զ������̹����б���������
	protected Map<String, String> map;

	/** �����б���Ϣ */
	protected Map<String, String[]> optionMap;

	/** ����ӽ�ɫ����List */
	protected List<IG700Info> ig700InfoList;

	/** ����ӱ�List */
	protected List<IG701Info> ig701InfoList;

	/** ��ѡ��ѯ���� */
	protected List<IG108Info> pqList;
	/** ��ѡ��ѯ���� */
	protected List<IG007Info> pdList;

	/** ��ѯ��������form */
	protected IGPRD0145Form igprd0145Form;

	/** ���ɽڵ���Ϣ���� */
	protected List<IG233Info> apList;

	/** ����������Ϣ */
	protected Map<String, List<IG007Info>> columnInfoMap;

	/** ��������Ϣ */
	protected IG007Info pidInfo;
	
	/** AJAX���ؽ�� */
	protected String ajaxResult;

	public List<IG701Info> getIg701InfoList() {
		return ig701InfoList;
	}

	public void setIg701InfoList(List<IG701Info> ig701InfoList) {
		this.ig701InfoList = ig701InfoList;
	}

	public List<IG700Info> getIg700InfoList() {
		return ig700InfoList;
	}

	public void setIg700InfoList(List<IG700Info> ig700InfoList) {
		this.ig700InfoList = ig700InfoList;
	}

	public Map<String, String[]> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<String, String[]> optionMap) {
		this.optionMap = optionMap;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	public String getIsProcessDefinitionInUse() {
		return isProcessDefinitionInUse;
	}

	public void setIsProcessDefinitionInUse(String isProcessDefinitionInUse) {
		this.isProcessDefinitionInUse = isProcessDefinitionInUse;
	}

	public String getImgxml() {
		return imgxml;
	}

	public void setImgxml(String imgxml) {
		this.imgxml = imgxml;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ����׼Ȩ��ȡ��
	 * 
	 * @return ����״̬_�������Ƿ�ӵ����׼Ȩ��
	 */
	public String getIsPpapprove() {
		return isPpapprove;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ����׼Ȩ���趨
	 * 
	 * @param isPpapprove
	 *            ����״̬_�������Ƿ�ӵ����׼Ȩ��
	 */
	public void setIsPpapprove(String isPpapprove) {
		this.isPpapprove = isPpapprove;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ�в���Ȩ��ȡ��
	 * 
	 * @return ����״̬_�������Ƿ�ӵ�в���Ȩ��
	 */
	public String getIsPpdeny() {
		return isPpdeny;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ�в���Ȩ���趨
	 * 
	 * @param isPpdeny
	 *            ����״̬_�������Ƿ�ӵ�в���Ȩ��
	 */
	public void setIsPpdeny(String isPpdeny) {
		this.isPpdeny = isPpdeny;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ���ύȨ��ȡ��
	 * 
	 * @return ����״̬_�������Ƿ�ӵ���ύȨ��
	 */
	public String getIsPpsubmit() {
		return isPpsubmit;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ���ύȨ���趨
	 * 
	 * @param isPpsubmit
	 *            ����״̬_�������Ƿ�ӵ���ύȨ��
	 */
	public void setIsPpsubmit(String isPpsubmit) {
		this.isPpsubmit = isPpsubmit;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ����ֹȨ��ȡ��
	 * 
	 * @return ����״̬_�������Ƿ�ӵ����ֹȨ��
	 */
	public String getIsPpterm() {
		return isPpterm;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ����ֹȨ���趨
	 * 
	 * @param isPpterm
	 *            ����״̬_�������Ƿ�ӵ����ֹȨ��
	 */
	public void setIsPpterm(String isPpterm) {
		this.isPpterm = isPpterm;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ�и���Ȩ��ȡ��
	 * 
	 * @return ����״̬_�������Ƿ�ӵ�и���Ȩ��
	 */
	public String getIsPpupdate() {
		return isPpupdate;
	}

	/**
	 * ����״̬_�������Ƿ�ӵ�и���Ȩ���趨
	 * 
	 * @param isPpupdate
	 *            ����״̬_�������Ƿ�ӵ�и���Ȩ��
	 */
	public void setIsPpupdate(String isPpupdate) {
		this.isPpupdate = isPpupdate;
	}

	/**
	 * ����״̬_������_���̱�������Ȩ��Ϣ����ȡ��
	 * 
	 * @return ����״̬_������_���̱�������Ȩ��Ϣ����
	 */
	public List<IG881Info> getProcessInfoParticipantDefList() {
		return processInfoParticipantDefList;
	}

	/**
	 * ����״̬_������_���̱�������Ȩ��Ϣ�����趨
	 * 
	 * @param processInfoParticipantDefList
	 *            ����״̬_������_���̱�������Ȩ��Ϣ����
	 */
	public void setProcessInfoParticipantDefList(
			List<IG881Info> processInfoParticipantDefList) {
		this.processInfoParticipantDefList = processInfoParticipantDefList;
	}

	/**
	 * ����״̬_������ȡ��
	 * 
	 * @return ����״̬_������
	 */
	public IG222Info getProcessParticipantDef() {
		return processParticipantDef;
	}

	/**
	 * ����״̬_�������趨
	 * 
	 * @param processParticipantDef
	 *            ����״̬_������
	 */
	public void setProcessParticipantDef(IG222Info processParticipantDef) {
		this.processParticipantDef = processParticipantDef;
	}

	/**
	 * ����״̬������_Ȩ��Formȡ��
	 * 
	 * @return ����״̬������_Ȩ��Form
	 */
	public IGPRD0108Form getIgPRD0108Form() {
		return igPRD0108Form;
	}

	/**
	 * ����״̬������_Ȩ��Form�趨
	 * 
	 * @param roleList
	 *            ����״̬������_Ȩ��Form
	 */
	public void setIgPRD0108Form(IGPRD0108Form igPRD0108Form) {
		this.igPRD0108Form = igPRD0108Form;
	}

	/**
	 * ����״̬����Ӳ����߼���ȡ��
	 * 
	 * @return ����״̬����Ӳ����߼���
	 */
	public List<Role> getRoleList() {
		return roleList;
	}

	/**
	 * ����״̬����Ӳ����߼����趨
	 * 
	 * @param roleList
	 *            ����״̬����Ӳ����߼���
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	/**
	 * ����״̬��Ϣ��������ȡ��
	 * 
	 * @return ����״̬��Ϣ��������
	 */
	public IG333SearchCond getProcessStatusDefSearchCond() {
		return processStatusDefSearchCond;
	}

	/**
	 * ����״̬��Ϣ���������趨
	 * 
	 * @param processStatusDefSearchCond
	 *            ����״̬��Ϣ��������
	 */
	public void setProcessStatusDefSearchCond(
			IG333SearchCond processStatusDefSearchCond) {
		this.processStatusDefSearchCond = processStatusDefSearchCond;
	}

	/**
	 * ����״̬��Ϣ���������ȡ��
	 * 
	 * @return ����״̬��Ϣ���������
	 */
	public List<IG333Info> getProcessStatusDefList() {
		return processStatusDefList;
	}

	/**
	 * ����״̬��Ϣ����������趨
	 * 
	 * @param processStatusDefList
	 *            ����״̬��Ϣ���������
	 */
	public void setProcessStatusDefList(List<IG333Info> processStatusDefList) {
		this.processStatusDefList = processStatusDefList;
	}

	/**
	 * ����״̬��Ϣ����formȡ��
	 * 
	 * @return ����״̬��Ϣ����form
	 */
	public IGPRD0104Form getIgPRD0104Form() {
		return igPRD0104Form;
	}

	/**
	 * ����״̬��Ϣ����form�趨
	 * 
	 * @param igPRD0104Form
	 *            ����״̬��Ϣ����form
	 */
	public void setIgPRD0104Form(IGPRD0104Form igPRD0104Form) {
		this.igPRD0104Form = igPRD0104Form;
	}

	/**
	 * ����״̬������Ϣformȡ��
	 * 
	 * @return ����״̬������Ϣform
	 */
	public IGPRD0105Form getIgPRD0105Form() {
		return igPRD0105Form;
	}

	/**
	 * ����״̬������Ϣform�趨
	 * 
	 * @param igPRD0105Form
	 *            ����״̬������Ϣform
	 */
	public void setIgPRD0105Form(IGPRD0105Form igPRD0105Form) {
		this.igPRD0105Form = igPRD0105Form;
	}

	/**
	 * ����״̬�����߼���ȡ��
	 * 
	 * @return ����״̬�����߼���
	 */
	public List<IG222Info> getProcessParticipantDefList() {
		return processParticipantDefList;
	}

	/**
	 * ����״̬�����߼����趨
	 * 
	 * @param processParticipantDefList
	 *            ����״̬�����߼���
	 */
	public void setProcessParticipantDefList(
			List<IG222Info> processParticipantDefList) {
		this.processParticipantDefList = processParticipantDefList;
	}

	/**
	 * ����״̬������Formȡ��
	 * 
	 * @return ����״̬������Form
	 */
	public IGPRD0107Form getIgPRD0107Form() {
		return igPRD0107Form;
	}

	/**
	 * ����״̬������Form�趨
	 * 
	 * @param igPRD0104Form
	 *            ����״̬������Form
	 */
	public void setIgPRD0107Form(IGPRD0107Form igPRD0107Form) {
		this.igPRD0107Form = igPRD0107Form;
	}

	/**
	 * ���̶�����Ϣ��������ȡ��
	 * 
	 * @return ���̶�����Ϣ��������
	 */
	public IG380SearchCond getProcessDefinitionSearchCond() {
		return processDefinitionSearchCond;
	}

	/**
	 * ���̶�����Ϣ���������趨
	 * 
	 * @param processDefinitionSearchCond
	 *            ���̶�����Ϣ��������
	 */
	public void setProcessDefinitionSearchCond(
			IG380SearchCond processDefinitionSearchCond) {
		this.processDefinitionSearchCond = processDefinitionSearchCond;
	}

	/**
	 * ���̶�����Ϣ���������ȡ��
	 * 
	 * @return �����̶�����Ϣ���������
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * ���̶�����Ϣ����������趨
	 * 
	 * @param processDefinitionList
	 *            ���̶�����Ϣ���������
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ���̶�����Ϣ����������ȡ��
	 * 
	 * @return ���̶�����Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���̶�����Ϣ�����������趨
	 * 
	 * @param maxSearchCount
	 *            ���̶�����Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * 
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * 
	 * @param pagingDto
	 *            ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ���̶�����ϢFormȡ��
	 * 
	 * @return ���̶�����ϢForm
	 */
	public IGPRD0102Form getIgPRD0102Form() {
		return igPRD0102Form;
	}

	/**
	 * ���̶�����ϢForm�趨
	 * 
	 * @param igPRD0102Form
	 *            ���̶�����ϢForm
	 */
	public void setIgPRD0102Form(IGPRD0102Form igPRD0102Form) {
		this.igPRD0102Form = igPRD0102Form;
	}

	/**
	 * ����Ϣ��Ϣ��������ȡ��
	 * 
	 * @return ����Ϣ��Ϣ��������
	 */
	public IG007SearchCond getProcessInfoDefSearchCond() {
		return processInfoDefSearchCond;
	}

	/**
	 * ����Ϣ��Ϣ���������趨
	 * 
	 * @param processInfoDefSearchCond
	 *            ����Ϣ��Ϣ��������
	 */
	public void setProcessInfoDefSearchCond(
			IG007SearchCond processInfoDefSearchCond) {
		this.processInfoDefSearchCond = processInfoDefSearchCond;
	}

	/**
	 * ����Ϣ��Ϣ���������ȡ��
	 * 
	 * @return ����Ϣ��Ϣ���������
	 */
	public List<IG007Info> getProcessInfoDefList() {
		return processInfoDefList;
	}

	/**
	 * ����Ϣ��Ϣ����������趨
	 * 
	 * @param processInfoDefList
	 *            ����Ϣ��Ϣ���������
	 */
	public void setProcessInfoDefList(List<IG007Info> processInfoDefList) {
		this.processInfoDefList = processInfoDefList;
	}

	/**
	 * ����Ϣ��ϢFormȡ��
	 * 
	 * @return ����Ϣ��ϢForm
	 */
	public IGPRD0111Form getIgPRD0111Form() {
		return igPRD0111Form;
	}

	/**
	 * ����Ϣ��ϢForm�趨
	 * 
	 * @param igPRD0111Form
	 *            ����Ϣ��ϢForm
	 */
	public void setIgPRD0111Form(IGPRD0111Form igPRD0111Form) {
		this.igPRD0111Form = igPRD0111Form;
	}

	/**
	 * ǰ���������Ϣ����ȡ��
	 * 
	 * @return ǰ���������Ϣ����
	 */
	public List<IG211TB> getPsidList() {
		return psidList;
	}

	/**
	 * ǰ���������Ϣ�����趨
	 * 
	 * @param psidList
	 *            ǰ���������Ϣ����
	 */
	public void setPsidList(List<IG211TB> psidList) {
		this.psidList = psidList;
	}

	/**
	 * ��������ϢFormȡ��
	 * 
	 * @return ��������ϢForm
	 */
	public IGPRD0109Form getIgPRD0109Form() {
		return igPRD0109Form;
	}

	/**
	 * ��������ϢForm�趨
	 * 
	 * @param igPRD0109Form
	 *            ��������ϢForm
	 */
	public void setIgPRD0109Form(IGPRD0109Form igPRD0109Form) {
		this.igPRD0109Form = igPRD0109Form;
	}

	/**
	 * ��������Ϣ�������ȡ��
	 * 
	 * @return ��������Ϣ�������
	 */
	public List<IG273Info> getProcessTransitionDefList() {
		return processTransitionDefList;
	}

	/**
	 * ��������Ϣ��������趨
	 * 
	 * @param processTransitionDefList
	 *            ��������Ϣ�������
	 */
	public void setProcessTransitionDefList(
			List<IG273Info> processTransitionDefList) {
		this.processTransitionDefList = processTransitionDefList;
	}

	/**
	 * ����״̬��Ϣȡ��
	 * 
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ����״̬��Ϣ�趨
	 * 
	 * @param processStatusDef
	 *            ����״̬��Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}

	/**
	 * �����б�ȡ��
	 * 
	 * @return �����б�
	 */
	public List<LabelValueBean> getLabelList() {
		return labelList;
	}

	/**
	 * �����б��趨
	 * 
	 * @param labelList
	 *            �����б�
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	/**
	 * ���ɽ�ɫFormȡ��
	 * 
	 * @return ���ɽ�ɫForm
	 */
	public IGPRD0114Form getIgPRD0114Form() {
		return igPRD0114Form;
	}

	/**
	 * ���ɽ�ɫForm�趨
	 * 
	 * @param igPRD0114Form���ɽ�ɫForm
	 */
	public void setIgPRD0114Form(IGPRD0114Form igPRD0114Form) {
		this.igPRD0114Form = igPRD0114Form;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ����Formȡ��
	 * 
	 * @return ����״̬�ɷ��ɽ�ɫ����Form
	 */
	public IGPRD0139Form getIgPRD0139Form() {
		return igPRD0139Form;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ����Form�趨
	 * 
	 * @param igPRD0139Form
	 *            ����״̬�ɷ��ɽ�ɫ����Form
	 */
	public void setIgPRD0139Form(IGPRD0139Form igPRD0139Form) {
		this.igPRD0139Form = igPRD0139Form;
	}

	/**
	 * ��ѡ��ɫ�б�ȡ��
	 * 
	 * @return ��ѡ��ɫ�б�
	 */
	public List<Role> getLst_Role() {
		return lst_Role;
	}

	/**
	 * ��ѡ��ɫ�б��趨
	 * 
	 * @param lst_Role
	 *            ��ѡ��ɫ�б�
	 */
	public void setLst_Role(List<Role> lst_Role) {
		this.lst_Role = lst_Role;
	}

	/**
	 * ��ѡ��ɫ�б�ȡ��
	 * 
	 * @return ��ѡ��ɫ�б�
	 */
	public List<IG298Info> getLst_ProcessStatusRoleDef() {
		return lst_ProcessStatusRoleDef;
	}

	/**
	 * ��ѡ��ɫ�б��趨
	 * 
	 * @param lst_ProcessStatusRoleDef
	 *            ��ѡ��ɫ�б�
	 */
	public void setLst_ProcessStatusRoleDef(
			List<IG298Info> lst_ProcessStatusRoleDef) {
		this.lst_ProcessStatusRoleDef = lst_ProcessStatusRoleDef;
	}

	/**
	 * ���нڵ��������ϢFormȡ��
	 * 
	 * @return ���нڵ��������ϢForm
	 */
	public IGPRD0115Form getIgPRD0115Form() {
		return igPRD0115Form;
	}

	/**
	 * ���нڵ��������ϢForm�趨
	 * 
	 * @param igPRD0115Form���нڵ��������ϢForm
	 */
	public void setIgPRD0115Form(IGPRD0115Form igPRD0115Form) {
		this.igPRD0115Form = igPRD0115Form;
	}

	/**
	 * ����״̬ȱʡ������_Ȩ��Formȡ��
	 * 
	 * @return ����״̬ȱʡ������_Ȩ��Form
	 */
	public IGPRD0116Form getIgPRD0116Form() {
		return igPRD0116Form;
	}

	/**
	 * ����״̬ȱʡ������_Ȩ��Form�趨
	 * 
	 * @param igPRD0116Form����״̬ȱʡ������_Ȩ��Form
	 */
	public void setIgPRD0116Form(IGPRD0116Form igPRD0116Form) {
		this.igPRD0116Form = igPRD0116Form;
	}

	/**
	 * ����״̬_ȱʡ������_���̱�������Ȩ��Ϣ����ȡ��
	 * 
	 * @return ����״̬_ȱʡ������_���̱�������Ȩ��Ϣ����
	 */
	public List<IG699Info> getParticipantDefaultVariableList() {
		return participantDefaultVariableList;
	}

	/**
	 * ����״̬_ȱʡ������_���̱�������Ȩ��Ϣ�����趨
	 * 
	 * @param participantDefaultVariableList����״̬_ȱʡ������_���̱�������Ȩ��Ϣ����
	 */
	public void setParticipantDefaultVariableList(
			List<IG699Info> participantDefaultVariableList) {
		this.participantDefaultVariableList = participantDefaultVariableList;
	}

	public IGPRD0124Form getIgPRD0124Form() {
		return igPRD0124Form;
	}

	public void setIgPRD0124Form(IGPRD0124Form igPRD0124Form) {
		this.igPRD0124Form = igPRD0124Form;
	}

	public List<IG213Info> getProcessRoleTypeDefList() {
		return processRoleTypeDefList;
	}

	public void setProcessRoleTypeDefList(List<IG213Info> processRoleTypeDefList) {
		this.processRoleTypeDefList = processRoleTypeDefList;
	}

	public List<CodeDetail> getCodeDetailList() {
		return codeDetailList;
	}

	public void setCodeDetailList(List<CodeDetail> codeDetailList) {
		this.codeDetailList = codeDetailList;
	}

	public IG286SearchCond getProcessLinkageDefSearchCond() {
		return processLinkageDefSearchCond;
	}

	public void setProcessLinkageDefSearchCond(
			IG286SearchCond processLinkageDefSearchCond) {
		this.processLinkageDefSearchCond = processLinkageDefSearchCond;
	}

	public IGPRD0125Form getIgPRD0125Form() {
		return igPRD0125Form;
	}

	public void setIgPRD0125Form(IGPRD0125Form igPRD0125Form) {
		this.igPRD0125Form = igPRD0125Form;
	}

	public List<IG286Info> getProcessLinkageDefList() {
		return processLinkageDefList;
	}

	public void setProcessLinkageDefList(List<IG286Info> processLinkageDefList) {
		this.processLinkageDefList = processLinkageDefList;
	}

	/**
	 * �����߱�Ȩ����Ϣ����ȡ��
	 * 
	 * @return �����߱�Ȩ����Ϣ����
	 */
	public List<IG100Info> getLst_ProcessInfoParticipantDefVW() {
		return lst_ProcessInfoParticipantDefVW;
	}

	/**
	 * �����߱�Ȩ����Ϣ�����趨
	 * 
	 * @param lst_ProcessInfoParticipantDefVW
	 *            �����߱�Ȩ����Ϣ����
	 */
	public void setLst_ProcessInfoParticipantDefVW(
			List<IG100Info> lst_ProcessInfoParticipantDefVW) {
		this.lst_ProcessInfoParticipantDefVW = lst_ProcessInfoParticipantDefVW;
	}

	/**
	 * ȱʡ��Ȩ����Ϣ����ȡ��
	 * 
	 * @return ȱʡ��Ȩ����Ϣ����
	 */
	public List<IG909Info> getLst_ParticipantDefaultVariableVW() {
		return lst_ParticipantDefaultVariableVW;
	}

	/**
	 * ȱʡ��Ȩ����Ϣ�����趨
	 * 
	 * @param lst_ParticipantDefaultVariableVW
	 *            ȱʡ��Ȩ����Ϣ����
	 */
	public void setLst_ParticipantDefaultVariableVW(
			List<IG909Info> lst_ParticipantDefaultVariableVW) {
		this.lst_ParticipantDefaultVariableVW = lst_ParticipantDefaultVariableVW;
	}

	// -----------------------------------------------------------ǰ����----------------------------------------------------------------------
	/** ��ť�¼�״̬Form */

	protected IGPRD0141Form igPRD0141Form;

	public IGPRD0141Form getIgPRD0141Form() {
		return igPRD0141Form;
	}

	public void setIgPRD0141Form(IGPRD0141Form igPRD0141Form) {
		this.igPRD0141Form = igPRD0141Form;
	}

	public List<IG221Info> processParticipantButtonDefVWInfoList;

	public List<IG221Info> getProcessParticipantButtonDefVWInfoList() {
		return processParticipantButtonDefVWInfoList;
	}

	public void setProcessParticipantButtonDefVWInfoList(
			List<IG221Info> processParticipantButtonDefVWInfoList) {
		this.processParticipantButtonDefVWInfoList = processParticipantButtonDefVWInfoList;
	}

	public Map<String, List<IG132Info>> processParticipantButtonDefMap;

	public Map<String, List<IG132Info>> getProcessParticipantButtonDefMap() {
		return processParticipantButtonDefMap;
	}

	public void setProcessParticipantButtonDefMap(
			Map<String, List<IG132Info>> processParticipantButtonDefMap) {
		this.processParticipantButtonDefMap = processParticipantButtonDefMap;
	}

	/**
	 * ����֪ͨ�����趨Formȡ��
	 * 
	 * @return ����֪ͨ�����趨Form
	 */
	public IGPRD0158Form getIgPRD0158Form() {
		return igPRD0158Form;
	}

	/**
	 * ����֪ͨ�����趨Form�趨
	 * 
	 * @param igPRD0158Form
	 *            ����֪ͨ�����趨Form
	 */
	public void setIgPRD0158Form(IGPRD0158Form igPRD0158Form) {
		this.igPRD0158Form = igPRD0158Form;
	}

	/**
	 * ���̲����б�ȡ��
	 * 
	 * @return ���̲����б�
	 */
	public List<IG238Info> getLst_ProcessNoticeStrategyDef() {
		return lst_ProcessNoticeStrategyDef;
	}

	/**
	 * ���̲����б��趨
	 * 
	 * @param lst_ProcessNoticeStrategyDef
	 *            ���̲����б�
	 */
	public void setLst_ProcessNoticeStrategyDef(
			List<IG238Info> lst_ProcessNoticeStrategyDef) {
		this.lst_ProcessNoticeStrategyDef = lst_ProcessNoticeStrategyDef;
	}

	/**
	 * ��ɫ�û��б��趨
	 * 
	 * @return ��ɫ�û��б�
	 */
	public List<UserRoleInfo> getLst_UserRoleInfo() {
		return lst_UserRoleInfo;
	}

	/**
	 * ��ɫ�û��б�ȡ��
	 * 
	 * @param lst_UserRoleInfo
	 *            ��ɫ�û��б�
	 */
	public void setLst_UserRoleInfo(List<UserRoleInfo> lst_UserRoleInfo) {
		this.lst_UserRoleInfo = lst_UserRoleInfo;
	}

	/**
	 * ���̲���֪ͨ�˲�ѯFormȡ��
	 * 
	 * @return ���̲���֪ͨ�˲�ѯForm
	 */
	public IGPRD0159Form getIgPRD0159Form() {
		return igPRD0159Form;
	}

	/**
	 * ���̲���֪ͨ�˲�ѯForm�趨
	 * 
	 * @param igPRD0159Form
	 *            ���̲���֪ͨ�˲�ѯForm
	 */
	public void setIgPRD0159Form(IGPRD0159Form igPRD0159Form) {
		this.igPRD0159Form = igPRD0159Form;
	}

	protected IGPRD0161Form igPRD0161Form;

	public IGPRD0161Form getIgPRD0161Form() {
		return igPRD0161Form;
	}

	public void setIgPRD0161Form(IGPRD0161Form igPRD0161Form) {
		this.igPRD0161Form = igPRD0161Form;
	}

	protected List<IG992Info> processExternalDefList;

	public List<IG992Info> getProcessExternalDefList() {
		return processExternalDefList;
	}

	public void setProcessExternalDefList(List<IG992Info> processExternalDefList) {
		this.processExternalDefList = processExternalDefList;
	}

	protected IGPRD0142Form igPRD0142Form;

	public IGPRD0142Form getIgPRD0142Form() {
		return igPRD0142Form;
	}

	public void setIgPRD0142Form(IGPRD0142Form igPRD0142Form) {
		this.igPRD0142Form = igPRD0142Form;
	}

	public List<IG333TB> getPsdTBList() {
		return psdTBList;
	}

	public void setPsdTBList(List<IG333TB> psdTBList) {
		this.psdTBList = psdTBList;
	}

	/**
	 * ���̶��嵼��Formȡ��
	 * 
	 * @return ���̶��嵼��Form
	 */
	public IGPRD0101Form getIgPRD0101Form() {
		return igPRD0101Form;
	}

	/**
	 * ���̶��嵼��Form�趨
	 * 
	 * @param igPRD0101Form
	 *            ���̶��嵼��Form
	 */
	public void setIgPRD0101Form(IGPRD0101Form igPRD0101Form) {
		this.igPRD0101Form = igPRD0101Form;
	}

	/**
	 * �����ļ�·��ȡ��
	 * 
	 * @return �����ļ�·��
	 */
	public String getFilepath_export() {
		return filepath_export;
	}

	/**
	 * �����ļ�·���趨
	 * 
	 * @param filepath_export
	 *            �����ļ�·��
	 */
	public void setFilepath_export(String filepath_export) {
		this.filepath_export = filepath_export;
	}

	/**
	 * ����ʼ�����ò�ѯFormȡ��
	 * 
	 * @return ����ʼ�����ò�ѯForm
	 */
	public IGPRD0165Form getIgPRD0165Form() {
		return igPRD0165Form;
	}

	/**
	 * ����ʼ�����ò�ѯForm�趨
	 * 
	 * @param igPRD0165Form
	 *            ����ʼ�����ò�ѯForm
	 */
	public void setIgPRD0165Form(IGPRD0165Form igPRD0165Form) {
		this.igPRD0165Form = igPRD0165Form;
	}

	/**
	 * ����ʼ�������б�ȡ��
	 * 
	 * @return ����ʼ�������б�
	 */
	public List<IG373Info> getLst_IG373Info() {
		return lst_IG373Info;
	}

	/**
	 * ����ʼ�������б��趨
	 * 
	 * @param lst_IG373Info
	 *            ����ʼ�������б�
	 */
	public void setLst_IG373Info(List<IG373Info> lst_IG373Info) {
		this.lst_IG373Info = lst_IG373Info;
	}

	/**
	 * ����ʼ����������Formȡ��
	 * 
	 * @return ����ʼ����������Form
	 */
	public IGPRD0166Form getIgPRD0166Form() {
		return igPRD0166Form;
	}

	/**
	 * ����ʼ����������Form�趨
	 * 
	 * @param igPRD0166Form
	 *            ����ʼ����������Form
	 */
	public void setIgPRD0166Form(IGPRD0166Form igPRD0166Form) {
		this.igPRD0166Form = igPRD0166Form;
	}

	public IGPRD0171Form getIgPRD0171Form() {
		return igPRD0171Form;
	}

	public void setIgPRD0171Form(IGPRD0171Form igPRD0171Form) {
		this.igPRD0171Form = igPRD0171Form;
	}

	public IGPRD0172Form getIgPRD0172Form() {
		return igPRD0172Form;
	}

	public void setIgPRD0172Form(IGPRD0172Form igPRD0172Form) {
		this.igPRD0172Form = igPRD0172Form;
	}

	/**
	 * @return the ���̶�����Ϣ���������
	 */
	public List<IG913Info> getRelevantProcessDefinitionList() {
		return relevantProcessDefinitionList;
	}

	/**
	 * @param ���̶�����Ϣ���������
	 *            the relevantProcessDefinitionList to set
	 */
	public void setRelevantProcessDefinitionList(
			List<IG913Info> relevantProcessDefinitionList) {
		this.relevantProcessDefinitionList = relevantProcessDefinitionList;
	}

	/** ����һ���˵��б� */
	protected List<LabelValueBean> actionLabelValueList;

	/**
	 * @return the ����һ���˵��б�
	 */
	public List<LabelValueBean> getActionLabelValueList() {
		return actionLabelValueList;
	}

	/**
	 * @param ����һ���˵��б�
	 *            the actionLabelValueList to set
	 */
	public void setActionLabelValueList(
			List<LabelValueBean> actionLabelValueList) {
		this.actionLabelValueList = actionLabelValueList;
	}

	/** ѡ��������˵����� */
	protected String actname;

	/**
	 * @return the ѡ��������˵�����
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * @param ѡ��������˵�����
	 *            the actname to set
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}

	/**
	 * @return the ��ť�¼�ҳ��Ŀ�ѡ��ť�б�
	 */
	public List<LabelValueBean> processButtonDefList;

	/**
	 * @return the processButtonDefList
	 */
	public List<LabelValueBean> getProcessButtonDefList() {
		return processButtonDefList;
	}

	/**
	 * @param processButtonDefList
	 *            the processButtonDefList to set
	 */
	public void setProcessButtonDefList(
			List<LabelValueBean> processButtonDefList) {
		this.processButtonDefList = processButtonDefList;
	}

	/**
	 * �Զ�������ҳ������Formȡ��
	 * 
	 * @return the igPRD0168Form
	 */
	public IGPRD0168Form getIgPRD0168Form() {
		return igPRD0168Form;
	}

	/**
	 * �Զ�������ҳ������Form����
	 * 
	 * @param igPRD0168Form
	 *            the igPRD0168Form to set
	 */
	public void setIgPRD0168Form(IGPRD0168Form igPRD0168Form) {
		this.igPRD0168Form = igPRD0168Form;
	}

	/**
	 * �Զ�������ҳ������ҳ����ʾvo��ȡ
	 * 
	 * @return the processJspInfoList
	 */
	public List<IG126Info> getProcessJspInfoList() {
		return processJspInfoList;
	}

	/**
	 * �Զ�������ҳ������ҳ����ʾvo����
	 * 
	 * @param processJspInfoList
	 *            the processJspInfoList to set
	 */
	public void setProcessJspInfoList(List<IG126Info> processJspInfoList) {
		this.processJspInfoList = processJspInfoList;
	}

	/**
	 * �Զ�������ҳ����������form ��ȡ
	 * 
	 * * @return the igPRD0169Form
	 */
	public IGPRD0169Form getIgPRD0169Form() {
		return igPRD0169Form;
	}

	/**
	 * �Զ�������ҳ����������form ����
	 * 
	 * @param igPRD0169Form
	 *            the igPRD0169Form to set
	 */
	public void setIgPRD0169Form(IGPRD0169Form igPRD0169Form) {
		this.igPRD0169Form = igPRD0169Form;
	}

	/**
	 * �Զ������̲�ѯ������Ϣ ��ȡ
	 * 
	 * @return the ig380info
	 */
	public IG380Info getIg380info() {
		return ig380info;
	}

	/**
	 * �Զ������̲�ѯ������Ϣ ����
	 * 
	 * @param ig380info
	 *            the ig380info to set
	 */
	public void setIg380info(IG380Info ig380info) {
		this.ig380info = ig380info;
	}

	/**
	 * ��ѡ��ѯ����ȡ��
	 * 
	 * @return ��ѡ��ѯ����
	 */
	public List<IG108Info> getPqList() {
		return pqList;
	}

	/**
	 * ��ѡ��ѯ����ȡ��
	 * 
	 * @return ��ѡ��ѯ����
	 */
	public List<IG007Info> getPdList() {
		return pdList;
	}

	/**
	 * ��ѡ��ѯ�����趨
	 * 
	 * @param pqList
	 *            ��ѡ��ѯ����
	 */
	public void setPqList(List<IG108Info> pqList) {
		this.pqList = pqList;
	}

	/**
	 * ��ѡ��ѯ�����趨
	 * 
	 * @param pdList
	 *            ��ѡ��ѯ����
	 */
	public void setPdList(List<IG007Info> pdList) {
		this.pdList = pdList;
	}

	/**
	 * ��ѯ��������formȡ��
	 * 
	 * @return ��ѯ��������form
	 */
	public IGPRD0145Form getIgprd0145Form() {
		return igprd0145Form;
	}

	/**
	 * ��ѯ��������form�趨
	 * 
	 * @param igprd0145Form
	 *            ��ѯ��������form
	 */
	public void setIgprd0145Form(IGPRD0145Form igprd0145Form) {
		this.igprd0145Form = igprd0145Form;
	}

	/**
	 * ���ɽڵ���Ϣ����ȡ��
	 * 
	 * @return ���ɽڵ���Ϣ����
	 */
	public List<IG233Info> getApList() {
		return apList;
	}

	/**
	 * ���ɽڵ���Ϣ�����趨
	 * 
	 * @param apList
	 *            ���ɽڵ���Ϣ����
	 */
	public void setApList(List<IG233Info> apList) {
		this.apList = apList;
	}

	/**
	 * ������Ԥ��formȡ��
	 * 
	 * @return igprd0173Form ������Ԥ��form
	 */
	public IGPRD0173Form getIgprd0173Form() {
		return igprd0173Form;
	}

	/**
	 * ������Ԥ��form�趨
	 * 
	 * @param igprd0173Form
	 *            ������Ԥ��form
	 */
	public void setIgprd0173Form(IGPRD0173Form igprd0173Form) {
		this.igprd0173Form = igprd0173Form;
	}

	/**
	 * ����������Ϣȡ��
	 * 
	 * @return columnInfoMap ����������Ϣ
	 */
	public Map<String, List<IG007Info>> getColumnInfoMap() {
		return columnInfoMap;
	}

	/**
	 * ����������Ϣ�趨
	 * 
	 * @param columnInfoMap
	 *            ����������Ϣ
	 */
	public void setColumnInfoMap(Map<String, List<IG007Info>> columnInfoMap) {
		this.columnInfoMap = columnInfoMap;
	}

	/**
	 * ��������Ϣȡ��
	 * @return pidInfo ��������Ϣ
	 */
	public IG007Info getPidInfo() {
		return pidInfo;
	}

	/**
	 * ��������Ϣ�趨
	 * @param pidInfo ��������Ϣ
	 */
	public void setPidInfo(IG007Info pidInfo) {
		this.pidInfo = pidInfo;
	}

	/**
	 * ��������Ϣȡ��
	 * @return processInfoDef ��������Ϣ
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * ��������Ϣ�趨
	 * @param processInfoDef ��������Ϣ
	 */
	public void setProcessInfoDef(IG007Info processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

	/**
	 * ������formȡ��
	 * @return igprd0110Form ������form
	 */
	public IGPRD0110Form getIgprd0110Form() {
		return igprd0110Form;
	}

	/**
	 * ������form�趨
	 * @param igprd0110Form ������form
	 */
	public void setIgprd0110Form(IGPRD0110Form igprd0110Form) {
		this.igprd0110Form = igprd0110Form;
	}

	/**
	 * ҳ����ʾ������ϢMapȡ��
	 * @return showMap ҳ����ʾ������ϢMap
	 */
	public Map<IG238Info, List<IG335Info>> getShowMap() {
		return showMap;
	}

	/**
	 * ҳ����ʾ������ϢMap�趨
	 * @param showMap ҳ����ʾ������ϢMap
	 */
	public void setShowMap(Map<IG238Info, List<IG335Info>> showMap) {
		this.showMap = showMap;
	}

	/**
	 * ״̬����ȡ��
	 * @return pssize ״̬����
	 */
	public int getPssize() {
		return pssize;
	}

	/**
	 * ״̬�����趨
	 * @param pssize ״̬����
	 */
	public void setPssize(int pssize) {
		this.pssize = pssize;
	}

	/**
	 * ״̬��ֵ����ȡ��
	 * @return pisize ״̬��ֵ����
	 */
	public int getPisize() {
		return pisize;
	}

	/**
	 * ״̬��ֵ�����趨
	 * @param pisize ״̬��ֵ����
	 */
	public void setPisize(int pisize) {
		this.pisize = pisize;
	}

	/**
	 * ��������֪ͨBL����Listȡ��
	 * @return proccessBLList ��������֪ͨBL����List
	 */
	public List<LabelValueBean> getProccessBLList() {
		return proccessBLList;
	}

	/**
	 * ��������֪ͨBL����List�趨
	 * @param proccessBLList ��������֪ͨBL����List
	 */
	public void setProccessBLList(List<LabelValueBean> proccessBLList) {
		this.proccessBLList = proccessBLList;
	}

	/**
	 * ���峬ʱ����֪ͨBL����Listȡ��
	 * @return processtacticsbl_alllist ���峬ʱ����֪ͨBL����List
	 */
	public List<LabelValueBean> getProcesstacticsbl_alllist() {
		return processtacticsbl_alllist;
	}

	/**
	 * ���峬ʱ����֪ͨBL����List�趨
	 * @param processtacticsbl_alllist ���峬ʱ����֪ͨBL����List
	 */
	public void setProcesstacticsbl_alllist(
			List<LabelValueBean> processtacticsbl_alllist) {
		this.processtacticsbl_alllist = processtacticsbl_alllist;
	}

    /** 
     * ����������� ȡ��
     * @return processWholeTactic_list ����������� 
     */
    public List<IG335Info> getProcessWholeTactic_list() {
        return processWholeTactic_list;
    }

    /** 
     * ����������� �趨
     * @param processWholeTactic_list ����������� 
     */
    public void setProcessWholeTactic_list(List<IG335Info> processWholeTactic_list) {
        this.processWholeTactic_list = processWholeTactic_list;
    }

    /** 
     * ����������Ա�ֵ���� ȡ��
     * @return processWholeTactic_listSize ����������Ա�ֵ���� 
     */
    public Integer getProcessWholeTactic_listSize() {
        return processWholeTactic_listSize;
    }

    /** 
     * ����������Ա�ֵ���� �趨
     * @param processWholeTactic_listSize ����������Ա�ֵ���� 
     */
    public void setProcessWholeTactic_listSize(Integer processWholeTactic_listSize) {
        this.processWholeTactic_listSize = processWholeTactic_listSize;
    }

	/**
	 * ���̵���У�������Ϣȡ��
	 * @return errorMessages ���̵���У�������Ϣ
	 */
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * ���̵���У�������Ϣ�趨
	 * @param errorMessages ���̵���У�������Ϣ
	 */
	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	/**
	 * ��������ȡ��
	 * @return pttype ��������
	 */
	public String getPttype() {
		return pttype;
	}

	/**
	 * ���������趨
	 * @param pttype ��������
	 */
	public void setPttype(String pttype) {
		this.pttype = pttype;
	}

	/**
	 * ����ģ����Ϣȡ��
	 * @return processTemplate ����ģ����Ϣ
	 */
	public IG259Info getProcessTemplate() {
		return processTemplate;
	}

	/**
	 * ����ģ����Ϣ�趨
	 * @param processTemplate ����ģ����Ϣ
	 */
	public void setProcessTemplate(IG259Info processTemplate) {
		this.processTemplate = processTemplate;
	}

	/**
	 * ����״̬_�����߼���ȡ��
	 * @return ����״̬_�����߼���
	 */
	public Map<Integer, List<IG222Info>> getProcessParticipantDefMap() {
		return processParticipantDefMap;
	}

	/**
	 * ����״̬_�����߼����趨
	 * @param processParticipantDefMap ����״̬_�����߼���
	 */
	public void setProcessParticipantDefMap(
			Map<Integer, List<IG222Info>> processParticipantDefMap) {
		this.processParticipantDefMap = processParticipantDefMap;
	}

	/**
	 * AJAX���ؽ��ȡ��
	 * @return ajaxResult AJAX���ؽ��
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * AJAX���ؽ���趨
	 * @param ajaxResult AJAX���ؽ��
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}
	/**
	 * ���趨���̲�ѯ��ʾ�м���ȡ��
	 * @return queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public List<IG110Info> getQueryShowColumnList() {
		return queryShowColumnList;
	}

	/**
	 * ���趨���̲�ѯ��ʾ�м����趨
	 * @param queryShowColumnList ���趨���̲�ѯ��ʾ�м���
	 */
	public void setQueryShowColumnList(List<IG110Info> queryShowColumnList) {
		this.queryShowColumnList = queryShowColumnList;
	}

	/**
	 * δ�趨���̲�ѯ��ʾ�м���ȡ��
	 * @return queryShowColumnMap δ�趨���̲�ѯ��ʾ�м���
	 */
	public Map<String, String> getQueryShowColumnMap() {
		return queryShowColumnMap;
	}

	/**
	 * δ�趨���̲�ѯ��ʾ�м����趨
	 * @param queryShowColumnMap δ�趨���̲�ѯ��ʾ�м���
	 */
	public void setQueryShowColumnMap(Map<String, String> queryShowColumnMap) {
		this.queryShowColumnMap = queryShowColumnMap;
	}

	/**
	 * ���趨��ѯ��������ȡ��
	 * @return queryList ���趨��ѯ��������
	 */
	public List<IG111Info> getQueryList() {
		return queryList;
	}

	/**
	 * ���趨��ѯ���������趨
	 * @param queryList ���趨��ѯ��������
	 */
	public void setQueryList(List<IG111Info> queryList) {
		this.queryList = queryList;
	}

	/**
	 * δ�趨��ѯ��������ȡ��
	 * @return queryMap δ�趨��ѯ��������
	 */
	public Map<String, String> getQueryMap() {
		return queryMap;
	}

	/**
	 * δ�趨��ѯ���������趨
	 * @param queryMap δ�趨��ѯ��������
	 */
	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}
	/** �����������Form */
	protected IGPRD0190Form igprd0190Form;
	
	public IGPRD0190Form getIgprd0190Form() {
		return igprd0190Form;
	}

	public void setIgprd0190Form(IGPRD0190Form igprd0190Form) {
		this.igprd0190Form = igprd0190Form;
	}
}
