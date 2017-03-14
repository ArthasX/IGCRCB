/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.form.IGPRR0104Form;
import com.deliverik.infogovernor.prr.form.IGPRR0106Form;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.form.IGPRR0113Form;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01036VO;

/**
 * @Description: ��������ҵ��DTO
 * @Author  
 * @History 2010-9-13     �½� 
 * @History 2012-12-18    �½� 	121218	��������������Ϣ����Ȩ�ޱ�ʶ
 * 			2013-02-27	  �޸�	130225	����֧�ַ��ɻ�������޸�
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01DTO extends BaseDTO implements Serializable{
	
	/** ״̬ģʽ */
	protected String psdassign;
	
	/** �������������� */
	protected String pporgid;
	
	/** ��������ѯִ���� */
	protected IGPRR0121Form igPRR0121Form;
	
	/** ��������ѯִ���� */
	protected List<UserRoleInfo> lst_UserRoleVW;
	
	/** �ɷ��ɻ������� */
	protected List<Organization> org_List;

	/** ��ǰ�����߻����� */
	protected String orgid;
	
	/** ������Χ�����б� */
	protected List<LabelValueBean> processOrgSelectedOptions;
	
	/** ���ɲ����߰��������� */
	protected String assign_orgsyscoding;
	
	protected List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
	
	protected List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
	
	protected RiskPointVM pointVM;
	
	
	/** ���̴�������ӿ� */
	protected WorkFlowParameterInfo  workFlowParameterInfo;
	
	/** ���̷���Form */
	protected IGPRR0101Form  igPRR0101Form;
	
	/** ���̴���Form */
	protected IGPRR0102Form  igPRR0102Form;
	
	/** ���̷���Form */
	protected IGPRR0104Form  igPRR0104Form;
	
	/** �û� */
	protected User user;
	
	/** �����б� */
	protected List<LabelValueBean> labelList;
	
	/** ���̶���ID */
	protected String pdid;
	
	/** ��ɫID */
	protected Integer roleid;
	
	/** �����ɫID */
	protected Integer selectRoleid;
	
	/** ����ID */
	protected Integer prid;
	
	/** ����״̬ID */
	protected String psdid;
	
	protected String actsortid;
	
	/**���̹������񹤵���Ϣ�����б�*/
	protected List<IG715Info> ig715InfoList;
	
	protected String hasCLRecord;
	
	/** ����������ʾ*/
	protected IG243TB ptdTB;
	
	/** ����״̬_�����߼��� */
	protected List<IG222Info> processParticipantDeflist;
	protected List<IG007Info> varList;
	protected List<IG007Info> notinvarList;
	
	/** ����״̬�±������� keyΪ������pidid*/
	protected Map<String,IG007Info> processInfoDefmap;
	
	/** ����ÿ���ڴ���ʱ�� */
	protected String dealtime;
	
	protected String prtitle;
	
	protected Integer eiid;
	
	/** ������Ϣ */
	protected IG500Info process;
	
	/** ����״̬����Ա״̬ */
	protected String status;
	
	/** ����״̬���� */
	protected List<LabelValueBean> lst_status;
	
	/** ����־*/
	protected Map<String,Map<IG036Info, List<IG113Info>>> varLog_map;
	
	/** ������־*/
	protected Map<String,List<IG036Info>> recordLogMap;
	
	/**���������̼���*/
	protected List<IG500Info> prList;

	/** ����״̬���� */
	protected String psdcode;
	
	protected boolean adminRole;
	
	protected boolean roleManager;
	
	/** ��ʱ��ɫ������ */
	protected boolean tempRoleManager;
	
	/** ֵ���˱�ʶ */
	protected boolean dutyPerson;
	
	/** �Ƿ����δ��Ȩֵ���˱�ʶ */
	protected boolean hasDutyPerson;

	/** ������������ */
	protected String processName;
	
	/** ���̲������ݱ�ʾ */
	protected String prassetcategory;
	
	/** �������� keyΪ������pidid*/
	protected Map<String,IG007Info> realmap;
	
	/** �������� keyΪ������pidid*/
	protected Map<String,IG007Info> varmap;
	
	/** ��չ��Ϣ�Ƿ��пɼ��� */
	protected String hid;
	
	/** ������ʶ ��0010 */
	protected String action;
	
	/**���̽ڵ�����*/
	protected String nodetype;
	
	/**���̽ڵ�ģʽ*/
	protected String nodemode;
	
	/** ��������*/
	protected String pts;
	
	/** �Ƿ�Ϊ��ݷ���*/
	protected String isServiceStart;
	
	protected String parprid;
	
	/** ����ͼXML */
	protected String flowChartXml;
	
	/**�Ƿ�����ϳ���*/
	protected boolean isGroup;
	
	/**������ʵ����Ϣ*/
	protected IG483Info groupProcessRecord;
	
	/** ������ */
	protected List<IG337Info> processParticipantList;
	
	/** ����״̬��־���� */
	protected List<IG224Info> recordStatusLogList;
	
	/** ����־�鿴Form */
	protected IGPRR0106Form  igPRR0106Form;
	
	/** ����־����*/
	protected List<IG113Info> varLogList;
	
	/** ������־ID */
	protected Integer rlid;
	
	/** ������תJSP */
	protected String forwardJsp;
	
	/** ������תJSPҳ������ */
	protected String pjdtype;
	
	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;
	
	/**��ɫ����*/
	protected List<Role> roleList;
	
	/** ������Ȩ�� */
	public User authorizeuser;
	
	/** �û��б� */
	protected List<UserInfo> userInfoList;
	
	/** OAģʽִ����Form */
	protected IGPRR0109Form igPRR0109Form;
	
	/** ����SUPER����Form */
	protected IGPRR0113Form  igPRR0113Form;
	
	/** ����SUPER���ɱ�ʶ */
	protected String  superFlag;
	
	/** ����OAģʽ���ɱ�ʶ��1�����ɷ��� ,ֻ��super��ɫ�����˿ɷ���*/
	protected String  assignFlag;
	
	/** ���̲����߽�ɫ����Ȩ���б� */
	protected List<IG893Info> participantVariableVWList;
	
	/** �Ƿ������ɲ����߱�ʶ(0������Ҫ��1����Ҫ) */
	protected String psdflag;
	
	protected String xmlheight;
	
	/** ��־�б� */
	protected List<IG036Info> relogList;
	
	protected List<IG036Info> recordLogList;
	
	/**�ı���󶨸���*/
	protected Map<String,List<Attachment>> textAreaMap;
/** �鿴����������ʾ */
	protected Map<String,List<Attachment>> attachmentMap;
	
	protected String pdidOrgid;
	
	/** ִ���� */
	protected List<IG602Info> processExecutorVWList;
	
	/** �ɷ��ɽ�ɫ */
	protected Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign;
	
	/** �ɷ��ɽ�ɫ */
	protected Map<Role, List<IG602Info>> map_ParticipantToBeAssign;
	
	/** �����߿��Ӱ�ť */
	protected List<IG309Info> lst_ParticipantVisibleButtonVWInfo;
	
	/** ������ */
	protected IG337Info processParticipant;
	
	/** ����״̬�б� */
	protected List<IG333Info> lst_ProcessStatusDef;
	
	/** ���ɲ����߼��� */
	protected Map<IG333Info, IGPRR01036VO> map_AssignParticipant;
	
	/** ���ɲ����߱�ʶ */
	protected boolean assignParticipant = true;
	
	/** ������ID */
	protected List<String> lst_participant;
	
	/** ���첿�� */
	protected List<String> lst_ppsuper;

	/** �����ߴ����ʶ����(0δ����1�Ѵ���) */
	protected Map<String, String> map_ParticipantDoneFlag;
	/** �������ʲ���ϵ */
	protected List<IG731Info> processInfoEntityList;
	
	/**���̱�������ֵ*/
	protected List<IG599Info> processInfo;
	
	/** �������� */
	protected List<IG512Info> lst_IG512Info;
	
    /** ��ǰ״̬�Ƿ�ɷ������������(0:����;1:��;)*/
    protected String isMoreRelevantProcess;
    
    /** �ɷ����������̶���id*/
    protected String relevantPdid;
    
    /** �����Զ���ķ���ҳ��*/
    protected String assignPage;
    
    /** �����Զ���ĸ���ҳ��*/
    protected String assignChangePage;
    
    /** �����Զ���ķ���ҳ������*/
    protected String assignPageType;
    
	/**�û���ɫ��Ϣ*/
	List<UserRoleInfo> userRoleInfo;
	
    /**�������弯��*/
    private Map<IG259Info,List<IG380Info>> templateDefinitionMap;
    
    /** �Ƿ�ȫ�ֿ��Ʊ�ֵ */
    protected String isFormGlobalControl;
    
    /**��Ϣ�Ƿ񹫿�*/
    protected String isOpen;
	
	/**�����ѯ������¼��*/
	protected int maxSearchCount;
	
	private List<Map<String, Object>> listMap;
	
	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/** ״̬��������Ϣmap */
	protected Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap;
	
	/** ����������Ϣ */
	protected Map<String, List<IG007Info>> columnInfoMap;
	
	/** ��������ֵMap */
	protected Map<String, Map<String, Map<String, String>>> tableColumnValueMap;
	
	/** �����������ʲ���Ϣ���� */
	protected Map<String, IG731Info> pieMap;
	
	/** �������и�����Ϣ */
	protected Map<String, List<Attachment>> tableAttMap;

	/** �������ֵmap */
	protected Map<String, IG505Info> processInfoFormValueMap;
	
	/** ��Ա���ֵMap */
	protected Map<String, IG506Info> participantFormValueMap;
	
	/** ����ʼ����Ϣ */
	protected Map<String, Object> initFormValueMap;

	/** ���������ID */
	protected String ppidstr;
	
	/** ��̬��֧��� */
	protected Integer psdnum;

	
	/**״̬��˽�б��ر�ʱ��ʾ��map*/
	protected Map<String,List<IG561VWInfo>> statusclosedetails;
	
	/** ��������ID */
	protected Integer dprid;
	
	
	
	 /**
     * ״̬��˽�б��ر�ʱ��ʾ��map
     *
     * @return statusclosedetails ״̬��˽�б��ر�ʱ��ʾ��map
     */
	public Map<String, List<IG561VWInfo>> getStatusclosedetails() {
        return statusclosedetails;
    }

	/**
     * ״̬��˽�б��ر�ʱ��ʾ��map
     *
     * @param statusclosedetails ״̬��˽�б��ر�ʱ��ʾ��map
     */
    public void setStatusclosedetails(Map<String, List<IG561VWInfo>> statusclosedetails) {
        this.statusclosedetails = statusclosedetails;
    }

    /**
	 * �ɷ��ɻ�������ȡ��
	 *
	 * @return org_List �ɷ��ɻ�������
	 */
	public List<Organization> getOrg_List() {
		return org_List;
	}

	/**
	 * �ɷ��ɻ��������趨
	 *
	 * @param org_List �ɷ��ɻ�������
	 */
	public void setOrg_List(List<Organization> org_List) {
		this.org_List = org_List;
	}

	/**
	 * ��ǰ�����߻�����ȡ��
	 *
	 * @return orgid ��ǰ�����߻�����
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * ��ǰ�����߻������趨
	 *
	 * @param orgid ��ǰ�����߻�����
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * ������Χ�����б�ȡ��
	 *
	 * @return processOrgSelectedOptions ������Χ�����б�
	 */
	public List<LabelValueBean> getProcessOrgSelectedOptions() {
		return processOrgSelectedOptions;
	}

	/**
	 * ������Χ�����б��趨
	 *
	 * @param processOrgSelectedOptions ������Χ�����б�
	 */
	public void setProcessOrgSelectedOptions(
			List<LabelValueBean> processOrgSelectedOptions) {
		this.processOrgSelectedOptions = processOrgSelectedOptions;
	}

	/**
	 * �û���ɫ��Ϣȡ��
	 *
	 * @return userRoleInfo �û���ɫ��Ϣ
	 */
	public List<UserRoleInfo> getUserRoleInfo() {
		return userRoleInfo;
	}

	/**
	 * �û���ɫ��Ϣ�趨
	 *
	 * @param userRoleInfo �û���ɫ��Ϣ
	 */
	public void setUserRoleInfo(List<UserRoleInfo> userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}

	/**
	 * ��������������ȡ��
	 *
	 * @return pporgid ��������������
	 */
	public String getPporgid() {
		return pporgid;
	}

	/**
	 * ���������������趨
	 *
	 * @param pporgid ��������������
	 */
	public void setPporgid(String pporgid) {
		this.pporgid = pporgid;
	}

	/**
	 * ״̬ģʽȡ��
	 *
	 * @return psdassign ״̬ģʽ
	 */
	public String getPsdassign() {
		return psdassign;
	}

	/**
	 * ״̬ģʽ�趨
	 *
	 * @param psdassign ״̬ģʽ
	 */
	public void setPsdassign(String psdassign) {
		this.psdassign = psdassign;
	}
	
	/**
	 * ��������ѯִ����ȡ��
	 *
	 * @return igPRR0121Form ��������ѯִ����
	 */
	public IGPRR0121Form getIgPRR0121Form() {
		return igPRR0121Form;
	}

	/**
	 * ��������ѯִ�����趨
	 *
	 * @param igPRR0121Form ��������ѯִ����
	 */
	public void setIgPRR0121Form(IGPRR0121Form igPRR0121Form) {
		this.igPRR0121Form = igPRR0121Form;
	}
	
	/**
	 * ��������ѯִ����ȡ��
	 *
	 * @return lst_UserRolevw ��������ѯִ����
	 */
	public List<UserRoleInfo> getLst_UserRoleVW() {
		return lst_UserRoleVW;
	}

	/**
	 * ��������ѯִ�����趨
	 *
	 * @param lst_UserRolevw ��������ѯִ����
	 */
	public void setLst_UserRoleVW(List<UserRoleInfo> lst_UserRoleVW) {
		this.lst_UserRoleVW = lst_UserRoleVW;
	}
    
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	public void setProcessInfoEntityList(List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
	}

	public List<IG599Info> getProcessInfo() {
		return processInfo;
	}

	public void setProcessInfo(List<IG599Info> processInfo) {
		this.processInfo = processInfo;
	}

	public String getPdidOrgid() {
		return pdidOrgid;
	}

	public void setPdidOrgid(String pdidOrgid) {
		this.pdidOrgid = pdidOrgid;
	}

	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}

	public Map<String, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}

	public void setAttachmentMap(Map<String, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}
	
	public List<IG036Info> getRecordLogList() {
		return recordLogList;
	}

	public void setRecordLogList(List<IG036Info> recordLogList) {
		this.recordLogList = recordLogList;
	}

	public List<IG036Info> getRelogList() {
		return relogList;
	}

	public void setRelogList(List<IG036Info> relogList) {
		this.relogList = relogList;
	}
	
	/**
	 * ������Ȩ��ȡ��
	 * @return ������Ȩ��
	 */
	public User getAuthorizeuser() {
		return authorizeuser;
	}
	/**
	 * ������Ȩ������
	 * @param authorizeuser ������Ȩ��
	 */
	public void setAuthorizeuser(User authorizeuser) {
		this.authorizeuser = authorizeuser;
	}


	/**
	 * ������־IDȡ��
	 * @return ������־ID
	 */
	public Integer getRlid() {
		return rlid;
	}

	/**
	 * ������־ID����
	 * @param rlid ������־ID
	 */
	public void setRlid(Integer rlid) {
		this.rlid = rlid;
	}


	/**
	 * ����־����ȡ��
	 * @return ����־����
	 */
	public List<IG113Info> getVarLogList() {
		return varLogList;
	}

	/**
	 * ����־��������
	 * @param varLogList ����־����
	 */
	public void setVarLogList(List<IG113Info> varLogList) {
		this.varLogList = varLogList;
	}
	
	/**
	 * ����־�鿴Formȡ��
	 * @return ����־�鿴Form
	 */
	public IGPRR0106Form getIgPRR0106Form() {
		return igPRR0106Form;
	}

	
	public IG243TB getPtdTB() {
		return ptdTB;
	}

	public void setPtdTB(IG243TB ptdTB) {
		this.ptdTB = ptdTB;
	}

	/**
	 * ����־�鿴Form����
	 * @param igPRR0106Form ����־�鿴Form
	 */
	public void setIgPRR0106Form(IGPRR0106Form igPRR0106Form) {
		this.igPRR0106Form = igPRR0106Form;
	}

	/**
	 * ������־ȡ��
	 * @return ������־
	 */
	public Map<String, List<IG036Info>> getRecordLogMap() {
		return recordLogMap;
	}

	/**
	 * ������־����
	 * @param recordLogMap ������־
	 */
	public void setRecordLogMap(Map<String, List<IG036Info>> recordLogMap) {
		this.recordLogMap = recordLogMap;
	}

	/**
	 * ����־ȡ��
	 * @return ����־
	 */
	public Map<String, Map<IG036Info, List<IG113Info>>> getVarLog_map() {
		return varLog_map;
	}
	
	/**
	 * ����־����
	 * @param varLog_map ����־
	 */
	public void setVarLog_map(
			Map<String, Map<IG036Info, List<IG113Info>>> varLog_map) {
		this.varLog_map = varLog_map;
	}

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public List<IG337Info> getProcessParticipantList() {
		return processParticipantList;
	}

	/**
	 * ����������
	 * @param processParticipantList ������
	 */
	public void setProcessParticipantList(
			List<IG337Info> processParticipantList) {
		this.processParticipantList = processParticipantList;
	}

	/**
	 * ����״̬��־ȡ��
	 * @return ����״̬��־
	 */
	public List<IG224Info> getRecordStatusLogList() {
		return recordStatusLogList;
	}

	/**
	 * ����״̬��־����
	 * @param recordStatusLogList ����״̬��־
	 */
	public void setRecordStatusLogList(List<IG224Info> recordStatusLogList) {
		this.recordStatusLogList = recordStatusLogList;
	}

	
	
	public Map<String, IG007Info> getVarmap() {
		return varmap;
	}

	public void setVarmap(Map<String, IG007Info> varmap) {
		this.varmap = varmap;
	}

	public String getParprid() {
		return parprid;
	}

	public void setParprid(String parprid) {
		this.parprid = parprid;
	}

	public String getIsServiceStart() {
		return isServiceStart;
	}

	public void setIsServiceStart(String isServiceStart) {
		this.isServiceStart = isServiceStart;
	}

	public String getPts() {
		return pts;
	}

	public void setPts(String pts) {
		this.pts = pts;
	}

	/**
	 * ��ȡ���̽ڵ�����
	 * @return ���̽ڵ�����
	 */
	public String getNodetype() {
		return nodetype;
	}

	/**
	 * �������̽ڵ�����
	 * @param nodetype ���̽ڵ�����
	 */
	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}
	
	/**
	 * ������ʶ
	 * @return ������ʶ
	 */
	public String getAction() {
		return action;
	}

	/**
	 * ���ö�����ʶ
	 * @param action ������ʶ
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * ��չ��Ϣ�Ƿ��пɼ���ȡ��
	 * @return ��չ��Ϣ�Ƿ��пɼ���
	 */
	public String getHid() {
		return hid;
	}

	/**
	 * ��չ��Ϣ�Ƿ��пɼ����趨
	 * @param hid ��չ��Ϣ�Ƿ��пɼ���
	 */
	public void setHid(String hid) {
		this.hid = hid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Map<String, IG007Info> getRealmap() {
		return realmap;
	}

	/**
	 * ���������趨
	 * @param realmap ��������
	 */
	public void setRealmap(Map<String, IG007Info> realmap) {
		this.realmap = realmap;
	}

	/**
	 * ���̲������ݱ�ʾȡ��
	 * @return ���̲������ݱ�ʾ
	 */
	public String getPrassetcategory() {
		return prassetcategory;
	}

	/**
	 * ���̲������ݱ�ʾ�趨
	 * @param prassetcategory ���̲������ݱ�ʾ
	 */
	public void setPrassetcategory(String prassetcategory) {
		this.prassetcategory = prassetcategory;
	}

	/**
	 * ������������ȡ��
	 * @return ������������
	 */
	public String getProcessName() {
		return processName;
	}

	/**
	 * �������������趨
	 * @param processName ������������
	 */
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	
	public boolean isRoleManager() {
		return roleManager;
	}

	public void setRoleManager(boolean roleManager) {
		this.roleManager = roleManager;
	}

	public boolean isAdminRole() {
		return adminRole;
	}

	public void setAdminRole(boolean adminRole) {
		this.adminRole = adminRole;
	}

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdcode() {
		return psdcode;
	}

	/**
	 * ����״̬�����趨
	 * @param psdcode ����״̬����
	 */
	public void setPsdcode(String psdcode) {
		this.psdcode = psdcode;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public List<IG500Info> getPrList() {
		return prList;
	}

	/**
	 * ���������趨
	 * @param prList ��������
	 */
	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}

	/**
	 * ����״̬����Ա״̬ȡ��
	 * @return ����״̬����Ա״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ����״̬����Ա״̬�趨
	 * @param status ����״̬����Ա״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IG500Info getProcess() {
		return process;
	}

	/**
	 * ������Ϣ�趨
	 * @param process ������Ϣ
	 */
	public void setProcess(IG500Info process) {
		this.process = process;
	}

	/**
	 * ����ÿ���ڴ���ʱ��ȡ��
	 * @return ����ÿ���ڴ���ʱ��
	 */
	public String getDealtime() {
		return dealtime;
	}

	/**
	 * ����ÿ���ڴ���ʱ���趨
	 * @param dealtime ����ÿ���ڴ���ʱ��
	 */
	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}

	/**
	 * ���̴���Formȡ��
	 * @return ���̴���Form
	 */
	public IGPRR0102Form getIgPRR0102Form() {
		return igPRR0102Form;
	}

	/**
	 * ���̴���Form�趨
	 * @param igPRR0102Form ���̴���Form
	 */
	public void setIgPRR0102Form(IGPRR0102Form igPRR0102Form) {
		this.igPRR0102Form = igPRR0102Form;
	}

	/**
	 * ���̷���Formȡ��
	 * @return ���̷���Form
	 */
	public IGPRR0101Form getIgPRR0101Form() {
		return igPRR0101Form;
	}

	/**
	 * ���̷���Form�趨
	 * @param igPRR0101Form ���̷���Form
	 */
	public void setIgPRR0101Form(IGPRR0101Form igPRR0101Form) {
		this.igPRR0101Form = igPRR0101Form;
	}
	
	/**
	 * �û�ȡ��
	 * @return �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û��趨
	 * @param user �û�
	 */
	public void setUser(User user) {
		this.user = user;
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
	 * @param labelList �����б�
	 */
	public void setLabelList(List<LabelValueBean> labelList) {
		this.labelList = labelList;
	}
	
	/**
	 * ���̶���IDȡ��
	 * 
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * ��ɫIDȡ��
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ����IDȡ��
	 * 
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}


	/**
	 * ����״̬ID�趨
	 *
	 * @param psdid ����״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * ����״̬_�����߼���ȡ��
	 * 
	 * @return ����״̬_�����߼���
	 */
	public List<IG222Info> getProcessParticipantDeflist() {
		return processParticipantDeflist;
	}

	
	/**
	 * ����״̬_�����߼����趨
	 *
	 * @param processParticipantDeflist ����״̬_�����߼���
	 */
	public void setProcessParticipantDeflist(
			List<IG222Info> processParticipantDeflist) {
		this.processParticipantDeflist = processParticipantDeflist;
	}

	public List<IG007Info> getVarList() {
		return varList;
	}

	public void setVarList(List<IG007Info> varList) {
		this.varList = varList;
	}

	public List<IG007Info> getNotinvarList() {
		return notinvarList;
	}

	public void setNotinvarList(List<IG007Info> notinvarList) {
		this.notinvarList = notinvarList;
	}
	
	/**
	 * ����״̬�±�������ȡ��
	 * 
	 * @return ����״̬�±�������
	 */
	public Map<String, IG007Info> getProcessInfoDefmap() {
		return processInfoDefmap;
	}

	/**
	 * ����״̬�±��������趨
	 *
	 * @param processStatusInfoDefmap ����״̬�±�������
	 */
	public void setProcessInfoDefmap(Map<String, IG007Info> processInfoDefmap) {
		this.processInfoDefmap = processInfoDefmap;
	}
	
	/**
	 * ����ͼXMLȡ��
	 * @return ����ͼXML
	 */
	public String getFlowChartXml() {
		return flowChartXml;
	}

	/**
	 * ����ͼXML�趨
	 * @param flowChartXml ����ͼXML
	 */
	public void setFlowChartXml(String flowChartXml) {
		this.flowChartXml = flowChartXml;
	}

	/**
	 * ���̷���Formȡ��
	 * @return ���̷���Form
	 */
	public IGPRR0104Form getIgPRR0104Form() {
		return igPRR0104Form;
	}

	/**
	 * ���̷���Form�趨
	 * @param igPRR0104Form ���̷���Form
	 */
	public void setIgPRR0104Form(IGPRR0104Form igPRR0104Form) {
		this.igPRR0104Form = igPRR0104Form;
	}

	/**
	 * ������תJSPȡ��
	 * @return ������תJSP
	 */
	public String getForwardJsp() {
		return forwardJsp;
	}

	/**
	 * ������תJSP�趨
	 * @param forwardJsp������תJSP
	 */
	public void setForwardJsp(String forwardJsp) {
		this.forwardJsp = forwardJsp;
	}

	/**
	 * ������תJSPҳ������ȡ��
	 * @return ������תJSPҳ������
	 */
	public String getPjdtype() {
		return pjdtype;
	}
	

	/**
	 * ������תJSPҳ�������趨
	 * @param pjdtype������תJSPҳ������
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * ����״̬��Ϣȡ��
	 * @return ����״̬��Ϣ
	 */
	public IG333Info getProcessStatusDef() {
		return processStatusDef;
	}

	/**
	 * ����״̬��Ϣ�趨
	 * @param processStatusDef����״̬��Ϣ
	 */
	public void setProcessStatusDef(IG333Info processStatusDef) {
		this.processStatusDef = processStatusDef;
	}
	
	/**
	 * ��ɫ����ȡ��
	 * @return ��ɫ����
	 */
	public List<Role> getRoleList() {
		return roleList;
	}
	
	/**
	 * ��ɫ�����趨
	 * @param roleList��ɫ����
	 */
	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	/**
	 * ���̽ڵ�ģʽȡ��
	 * @return ���̽ڵ�ģʽ
	 */
	public String getNodemode() {
		return nodemode;
	}
	
	/**
	 * ���̽ڵ�ģʽ�趨
	 * @param nodemode���̽ڵ�ģʽ
	 */
	public void setNodemode(String nodemode) {
		this.nodemode = nodemode;
	}
	
	/**
	 * �û��б�ȡ��
	 * @return �û��б�
	 */
	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}
	
	/**
	 * �û��б��趨
	 * @param userInfoList�û��б�
	 */
	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}
	
	/**
	 * OAģʽִ����Formȡ��
	 * @return OAģʽִ����Form
	 */
	public IGPRR0109Form getIgPRR0109Form() {
		return igPRR0109Form;
	}
	
	/**
	 * OAģʽִ����Form�趨
	 * @param igPRR0109FormOAģʽִ����Form
	 */
	public void setIgPRR0109Form(IGPRR0109Form igPRR0109Form) {
		this.igPRR0109Form = igPRR0109Form;
	}
	
	/**
	 * ����SUPER����Formȡ��
	 * @return ����SUPER����Form
	 */
	public IGPRR0113Form getIgPRR0113Form() {
		return igPRR0113Form;
	}
	
	/**
	 * ����SUPER����Form�趨
	 * @param igPRR0113Form����SUPER����Form
	 */
	public void setIgPRR0113Form(IGPRR0113Form igPRR0113Form) {
		this.igPRR0113Form = igPRR0113Form;
	}
	
	/**
	 * ����SUPER���ɱ�ʶȡ��
	 * @return ����SUPER���ɱ�ʶ
	 */
	public String getSuperFlag() {
		return superFlag;
	}
	
	/**
	 * ����SUPER���ɱ�ʶ�趨
	 * @param superFlag����SUPER���ɱ�ʶ
	 */
	public void setSuperFlag(String superFlag) {
		this.superFlag = superFlag;
	}
	
	/**
	 * ���̲����߽�ɫ����Ȩ���б�ȡ��
	 * @return ���̲����߽�ɫ����Ȩ���б�
	 */
	public List<IG893Info> getParticipantVariableVWList() {
		return participantVariableVWList;
	}
	
	/**
	 * ���̲����߽�ɫ����Ȩ���б��趨
	 * @param participantVariableVWList���̲����߽�ɫ����Ȩ���б�
	 */
	public void setParticipantVariableVWList(
			List<IG893Info> participantVariableVWList) {
		this.participantVariableVWList = participantVariableVWList;
	}
	
	/**
	 * ����OAģʽ���ɱ�ʶȡ��
	 * @return ����OAģʽ���ɱ�ʶ
	 */
	public String getAssignFlag() {
		return assignFlag;
	}
	
	/**
	 * ����OAģʽ���ɱ�ʶ�趨
	 * @param assignFlag����OAģʽ���ɱ�ʶ
	 */
	public void setAssignFlag(String assignFlag) {
		this.assignFlag = assignFlag;
	}

	/**
	 * �Ƿ������ɲ����߱�ʶȡ��
	 * @return �Ƿ������ɲ����߱�ʶ
	 */
	public String getPsdflag() {
		return psdflag;
	}

	/**
	 * �Ƿ������ɲ����߱�ʶ�趨
	 * @param psdflag�Ƿ������ɲ����߱�ʶ
	 */
	public void setPsdflag(String psdflag) {
		this.psdflag = psdflag;
	}

	/**
	 * ֵ���˱�ʶȡ��
	 * @return ֵ���˱�ʶ
	 */
	public boolean isDutyPerson() {
		return dutyPerson;
	}

	/**
	 * ֵ���˱�ʶ�趨
	 * @param dutyPerson ֵ���˱�ʶ
	 */
	public void setDutyPerson(boolean dutyPerson) {
		this.dutyPerson = dutyPerson;
	}

	/**
	 * �Ƿ����δ��Ȩֵ���˱�ʶȡ��
	 * @return �Ƿ����δ��Ȩֵ���˱�ʶ
	 */
	public boolean isHasDutyPerson() {
		return hasDutyPerson;
	}

	/**
	 * �Ƿ����δ��Ȩֵ���˱�ʶ�趨
	 * @param hasDutyPerson�Ƿ����δ��Ȩֵ���˱�ʶ
	 */
	public void setHasDutyPerson(boolean hasDutyPerson) {
		this.hasDutyPerson = hasDutyPerson;
	}

	/**
	 * ��ʱ��ɫ������ȡ��
	 * @return ��ʱ��ɫ������
	 */
	public boolean isTempRoleManager() {
		return tempRoleManager;
	}

	/**
	 * ��ʱ��ɫ�������趨
	 * @param tempRoleManager��ʱ��ɫ������
	 */
	public void setTempRoleManager(boolean tempRoleManager) {
		this.tempRoleManager = tempRoleManager;
	}

	/**
	 * �ɷ��ɽ�ɫȡ��
	 * 
	 * @return �ɷ��ɽ�ɫ
	 */
	public Map<Role, List<UserRoleInfo>> getMap_ParticipantDefToBeAssign() {
		return map_ParticipantDefToBeAssign;
	}

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * 
	 * @param map_ParticipantDefToBeAssign �ɷ��ɽ�ɫ
	 */
	public void setMap_ParticipantDefToBeAssign(
			Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign) {
		this.map_ParticipantDefToBeAssign = map_ParticipantDefToBeAssign;
	}

	/**
	 * ִ����ȡ��
	 * 
	 * @return ִ����
	 */
	public List<IG602Info> getProcessExecutorVWList() {
		return processExecutorVWList;
	}

	/**
	 * ִ�����趨
	 * 
	 * @param processExecutorVWList ִ����
	 */
	public void setProcessExecutorVWList(
			List<IG602Info> processExecutorVWList) {
		this.processExecutorVWList = processExecutorVWList;
	}

	/**
	 * �ɷ��ɽ�ɫȡ��
	 * 
	 * @return �ɷ��ɽ�ɫ
	 */
	public Map<Role, List<IG602Info>> getMap_ParticipantToBeAssign() {
		return map_ParticipantToBeAssign;
	}

	/**
	 * �ɷ��ɽ�ɫ�趨
	 * 
	 * @param map_ParticipantToBeAssign �ɷ��ɽ�ɫ
	 */
	public void setMap_ParticipantToBeAssign(
			Map<Role, List<IG602Info>> map_ParticipantToBeAssign) {
		this.map_ParticipantToBeAssign = map_ParticipantToBeAssign;
	}

	/**
	 * �����߿��Ӱ�ťȡ��
	 * 
	 * @return �����߿��Ӱ�ť
	 */
	public List<IG309Info> getLst_ParticipantVisibleButtonVWInfo() {
		return lst_ParticipantVisibleButtonVWInfo;
	}

	/**
	 * �����߿��Ӱ�ť�趨
	 * 
	 * @param lst_ParticipantVisibleButtonVWInfo �����߿��Ӱ�ť
	 */
	public void setLst_ParticipantVisibleButtonVWInfo(
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo) {
		this.lst_ParticipantVisibleButtonVWInfo = lst_ParticipantVisibleButtonVWInfo;
	}

	/**
	 * ������ȡ��
	 * 
	 * @return ������
	 */
	public IG337Info getProcessParticipant() {
		return processParticipant;
	}

	/**
	 * �������趨
	 * 
	 * @param processParticipant ������
	 */
	public void setProcessParticipant(IG337Info processParticipant) {
		this.processParticipant = processParticipant;
	}

	public String getXmlheight() {
		return xmlheight;
	}

	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

	/**
	 * ����״̬�б�ȡ��
	 * 
	 * @return ����״̬�б�
	 */
	public List<IG333Info> getLst_ProcessStatusDef() {
		return lst_ProcessStatusDef;
	}

	/**
	 * ����״̬�б��趨
	 * 
	 * @param lst_ProcessStatusDef ����״̬�б�
	 */
	public void setLst_ProcessStatusDef(List<IG333Info> lst_ProcessStatusDef) {
		this.lst_ProcessStatusDef = lst_ProcessStatusDef;
	}

	/**
	 * ���ɲ����߼���ȡ��
	 * 
	 * @return ���ɲ����߼���
	 */
	public Map<IG333Info, IGPRR01036VO> getMap_AssignParticipant() {
		return map_AssignParticipant;
	}

	/**
	 * ���ɲ����߼����趨
	 * 
	 * @param map_AssignParticipant ���ɲ����߼���
	 */
	public void setMap_AssignParticipant(
			Map<IG333Info, IGPRR01036VO> map_AssignParticipant) {
		this.map_AssignParticipant = map_AssignParticipant;
	}

	/**
	 * ���ɲ����߱�ʶȡ��
	 * 
	 * @return ���ɲ����߱�ʶ
	 */
	public boolean isAssignParticipant() {
		return assignParticipant;
	}

	/**
	 * ���ɲ����߱�ʶ�趨
	 * 
	 * @param assignParticipant ���ɲ����߱�ʶ
	 */
	public void setAssignParticipant(boolean assignParticipant) {
		this.assignParticipant = assignParticipant;
	}
	
	/**
	 * ������IDȡ��
	 * 
	 * @return ������ID
	 */
	public List<String> getLst_participant() {
		return lst_participant;
	}

	/**
	 * ������ID�趨
	 * 
	 * @param participant ������ID
	 */
	public void setLst_participant(List<String> lst_participant) {
		this.lst_participant = lst_participant;
	}

	/**
	 * ���첿��ȡ��
	 * 
	 * @return ���첿��
	 */
	public List<String> getLst_ppsuper() {
		return lst_ppsuper;
	}

	/**
	 * ���첿���趨
	 * 
	 * @param lst_ppsuper ���첿��
	 */
	public void setLst_ppsuper(List<String> lst_ppsuper) {
		this.lst_ppsuper = lst_ppsuper;
	}

	/**
	 * �����ߴ����ʶ����ȡ��
	 * 
	 * @return �����ߴ����ʶ����
	 */
	public Map<String, String> getMap_ParticipantDoneFlag() {
		return map_ParticipantDoneFlag;
	}

	/**
	 * �����ߴ����ʶ�����趨
	 * 
	 * @param map_ParticipantDoneFlag �����ߴ����ʶ����
	 */
	public void setMap_ParticipantDoneFlag(
			Map<String, String> map_ParticipantDoneFlag) {
		this.map_ParticipantDoneFlag = map_ParticipantDoneFlag;
	}

	public String getActsortid() {
		return actsortid;
	}

	public void setActsortid(String actsortid) {
		this.actsortid = actsortid;
	}

	public List<IG715Info> getIg715InfoList() {
		return ig715InfoList;
	}

	public void setIg715InfoList(
			List<IG715Info> ig715InfoList) {
		this.ig715InfoList = ig715InfoList;
	}
	
	public String getHasCLRecord() {
		return hasCLRecord;
	}

	public void setHasCLRecord(String hasCLRecord) {
		this.hasCLRecord = hasCLRecord;
	}

	/**
	 * ���̴�������ӿ�ȡ��
	 * 
	 * @return ���̴�������ӿ�
	 */
	public WorkFlowParameterInfo getWorkFlowParameterInfo() {
		return workFlowParameterInfo;
	}

	/**
	 * ���̴�������ӿ��趨
	 * 
	 * @param workFlowParameterInfo ���̴�������ӿ�
	 */
	public void setWorkFlowParameterInfo(WorkFlowParameterInfo workFlowParameterInfo) {
		this.workFlowParameterInfo = workFlowParameterInfo;
	}

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public List<IG512Info> getLst_IG512Info() {
		return lst_IG512Info;
	}

	/**
	 * @param lst_IG512Info
	 */
	public void setLst_IG512Info(List<IG512Info> lst_IG512Info) {
		this.lst_IG512Info = lst_IG512Info;
	}

    /**
     * @return the �������弯��
     */
    public Map<IG259Info, List<IG380Info>> getTemplateDefinitionMap() {
        return templateDefinitionMap;
    }

    /**
     * @param �������弯�� the templateDefinitionMap to set
     */
    public void setTemplateDefinitionMap(
            Map<IG259Info, List<IG380Info>> templateDefinitionMap) {
        this.templateDefinitionMap = templateDefinitionMap;
    }

    /**
     * @return the ��ǰ״̬�Ƿ�ɷ������������(0:����;1:��;)
     */
    public String getIsMoreRelevantProcess() {
        return isMoreRelevantProcess;
    }

    /**
     * @param ��ǰ״̬�Ƿ�ɷ������������(0:����;1:��;) the isMoreRelevantProcess to set
     */
    public void setIsMoreRelevantProcess(String isMoreRelevantProcess) {
        this.isMoreRelevantProcess = isMoreRelevantProcess;
    }

    /**
     * @return the �ɷ����������̶���id
     */
    public String getRelevantPdid() {
        return relevantPdid;
    }

    /**
     * @param �ɷ����������̶���id the relevantPdid to set
     */
    public void setRelevantPdid(String relevantPdid) {
        this.relevantPdid = relevantPdid;
    }

    /**
     * @return the �����Զ���ķ���ҳ��
     */
    public String getAssignPage() {
        return assignPage;
    }

    /**
     * @param �����Զ���ķ���ҳ�� the assignPage to set
     */
    public void setAssignPage(String assignPage) {
        this.assignPage = assignPage;
    }

    /**
     * @return the �����Զ���ķ���ҳ������
     */
    public String getAssignPageType() {
        return assignPageType;
    }

    /**
     * @param �����Զ���ķ���ҳ������ the assignPageType to set
     */
    public void setAssignPageType(String assignPageType) {
        this.assignPageType = assignPageType;
    }

    /**
     * @return the �����Զ���ĸ���ҳ��
     */
    public String getAssignChangePage() {
        return assignChangePage;
    }

    /**
     * @param �����Զ���ĸ���ҳ�� the assignChangePage to set
     */
    public void setAssignChangePage(String assignChangePage) {
        this.assignChangePage = assignChangePage;
    }

    /**
     * �Ƿ�ȫ�ֿ��Ʊ�ֵȡ��
     * @return �Ƿ�ȫ�ֿ��Ʊ�ֵ
     */
	public String getIsFormGlobalControl() {
		return isFormGlobalControl;
	}

	/**
	 * �Ƿ�ȫ�ֿ��Ʊ�ֵ�趨
	 * @param isFormGlobalControl �Ƿ�ȫ�ֿ��Ʊ�ֵ
	 */
	public void setIsFormGlobalControl(String isFormGlobalControl) {
		this.isFormGlobalControl = isFormGlobalControl;
	}
	
    /**
     * ��Ϣ�Ƿ񹫿�ȡ��
     * @return
     */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * ��Ϣ�Ƿ񹫿��趨
	 * @param isOpen
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}
	
	/**
	 * ��ȡ��ҳBean
	 * @return ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ״̬��������Ϣmapȡ��
	 * @return ״̬��������Ϣmap
	 */
	public Map<IG333Info, List<IG337Info>> getLs_proStatusParticipantMap() {
		return ls_proStatusParticipantMap;
	}

	/**
	 * ״̬��������Ϣmap�趨
	 * @param ls_proStatusParticipantMap ״̬��������Ϣmap
	 */
	public void setLs_proStatusParticipantMap(
			Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap) {
		this.ls_proStatusParticipantMap = ls_proStatusParticipantMap;
	}

	/**
	 * ����������Ϣȡ��
	 * @return columnInfoMap ����������Ϣ
	 */
	public Map<String, List<IG007Info>> getColumnInfoMap() {
		return columnInfoMap;
	}

	/**
	 * ����������Ϣ�趨
	 * @param columnInfoMap ����������Ϣ
	 */
	public void setColumnInfoMap(Map<String, List<IG007Info>> columnInfoMap) {
		this.columnInfoMap = columnInfoMap;
	}

	/**
	 * ��������ֵMapȡ��
	 * @return tableColumnValueMap ��������ֵMap
	 */
	public Map<String, Map<String, Map<String, String>>> getTableColumnValueMap() {
		return tableColumnValueMap;
	}

	/**
	 * ��������ֵMap�趨
	 * @param tableColumnValueMap ��������ֵMap
	 */
	public void setTableColumnValueMap(Map<String, Map<String, Map<String, String>>> tableColumnValueMap) {
		this.tableColumnValueMap = tableColumnValueMap;
	}

	/**
	 * �����������ʲ���Ϣ����ȡ��
	 * @return pieMap �����������ʲ���Ϣ����
	 */
	public Map<String, IG731Info> getPieMap() {
		return pieMap;
	}

	/**
	 * �����������ʲ���Ϣ�����趨
	 * @param pieMap �����������ʲ���Ϣ����
	 */
	public void setPieMap(Map<String, IG731Info> pieMap) {
		this.pieMap = pieMap;
	}

	/**
	 * �������и�����Ϣȡ��
	 * @return tableAttMap �������и�����Ϣ
	 */
	public Map<String, List<Attachment>> getTableAttMap() {
		return tableAttMap;
	}

	/**
	 * �������и�����Ϣ�趨
	 * @param tableAttMap �������и�����Ϣ
	 */
	public void setTableAttMap(Map<String, List<Attachment>> tableAttMap) {
		this.tableAttMap = tableAttMap;
	}

	/**
	 * ���ɲ����߰���������ȡ��
	 * @return ���ɲ����߰���������
	 */
	public String getAssign_orgsyscoding() {
		return assign_orgsyscoding;
	}

	/**
	 * ���ɲ����߰����������趨
	 * @param assign_orgsyscoding ���ɲ����߰���������
	 */
	public void setAssign_orgsyscoding(String assign_orgsyscoding) {
		this.assign_orgsyscoding = assign_orgsyscoding;
	}

	/**
	 * �������ֵmapȡ��
	 * @return processInfoFormValueMap �������ֵmap
	 */
	public Map<String, IG505Info> getProcessInfoFormValueMap() {
		return processInfoFormValueMap;
	}

	/**
	 * �������ֵmap�趨
	 * @param processInfoFormValueMap �������ֵmap
	 */
	public void setProcessInfoFormValueMap(
			Map<String, IG505Info> processInfoFormValueMap) {
		this.processInfoFormValueMap = processInfoFormValueMap;
	}

	/**
	 * ��Ա���ֵMapȡ��
	 * @return participantFormValueMap ��Ա���ֵMap
	 */
	public Map<String, IG506Info> getParticipantFormValueMap() {
		return participantFormValueMap;
	}

	/**
	 * ��Ա���ֵMap�趨
	 * @param participantFormValueMap ��Ա���ֵMap
	 */
	public void setParticipantFormValueMap(
			Map<String, IG506Info> participantFormValueMap) {
		this.participantFormValueMap = participantFormValueMap;
	}

	/**
	 * ����ʼ����Ϣȡ��
	 * @return initFormValueMap ����ʼ����Ϣ
	 */
	public Map<String, Object> getInitFormValueMap() {
		return initFormValueMap;
	}

	/**
	 * ����ʼ����Ϣ�趨
	 * @param initFormValueMap ����ʼ����Ϣ
	 */
	public void setInitFormValueMap(Map<String, Object> initFormValueMap) {
		this.initFormValueMap = initFormValueMap;
	}

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public String getPpidstr() {
		return ppidstr;
	}

	/**
	 * ���������ID�趨
	 * @param ppidstr ���������ID
	 */
	public void setPpidstr(String ppidstr) {
		this.ppidstr = ppidstr;
	}

	/**
	 * �����ɫIDȡ��
	 * @return �����ɫID
	 */
	public Integer getSelectRoleid() {
		return selectRoleid;
	}

	/**
	 * �����ɫID�趨
	 * @param selectRoleid �����ɫID
	 */
	public void setSelectRoleid(Integer selectRoleid) {
		this.selectRoleid = selectRoleid;
	}

	/**
	 * ����״̬�����趨
	 * @return ����״̬����
	 */
	public List<LabelValueBean> getLst_status() {
		return lst_status;
	}

	/**
	 * ����״̬����
	 * @param lst_status ����״̬����
	 */
	public void setLst_status(List<LabelValueBean> lst_status) {
		this.lst_status = lst_status;
	}

	/**
	 * ��̬��֧���ȡ��
	 * @return psdnum ��̬��֧���
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * ��̬��֧����趨
	 * @param psdnum ��̬��֧���
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * @return the listPointVMs
	 */
	public List<RiskPointVM> getListPointVMs() {
		return listPointVMs;
	}

	/**
	 * @param listPointVMs the listPointVMs to set
	 */
	public void setListPointVMs(List<RiskPointVM> listPointVMs) {
		this.listPointVMs = listPointVMs;
	}

	/**
	 * @return the checkItemVWs
	 */
	public List<CheckItemVW> getCheckItemVWs() {
		return checkItemVWs;
	}

	/**
	 * @param checkItemVWs the checkItemVWs to set
	 */
	public void setCheckItemVWs(List<CheckItemVW> checkItemVWs) {
		this.checkItemVWs = checkItemVWs;
	}

	/**
	 * @return the listMap
	 */
	public List<Map<String, Object>> getListMap() {
		return listMap;
	}

	/**
	 * @param listMap the listMap to set
	 */
	public void setListMap(List<Map<String, Object>> listMap) {
		this.listMap = listMap;
	}

	/**
	 * @return the pointVM
	 */
	public RiskPointVM getPointVM() {
		return pointVM;
	}

	/**
	 * @param pointVM the pointVM to set
	 */
	public void setPointVM(RiskPointVM pointVM) {
		this.pointVM = pointVM;
	}

	/**
	 * @return the prtitle
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * @param prtitle the prtitle to set
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * @return the eiid
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * @param eiid the eiid to set
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * dprid   ȡ��
	 * @return dprid dprid
	 */
	public Integer getDprid() {
		return dprid;
	}

	/**
	 * dprid   �趨
	 * @param dprid dprid
	 */
	public void setDprid(Integer dprid) {
		this.dprid = dprid;
	}
	/**���̹�����*/
	protected String serialNum;
	/**
	 * ���̹�����ȡ��
	 * @return
	 */
	public String getSerialNum() {
		return serialNum;
	}
	/**
	 * ���̹����Ż�ȡ
	 * @param serialNum
	 */
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public boolean isGroup() {
		return isGroup;
	}

	public void setGroup(boolean isGroup) {
		this.isGroup = isGroup;
	}

	public IG483Info getGroupProcessRecord() {
		return groupProcessRecord;
	}

	public void setGroupProcessRecord(IG483Info groupProcessRecord) {
		this.groupProcessRecord = groupProcessRecord;
	}

	
}