/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.infogovernor.asset.model.entity.CheckItemVW;
import com.deliverik.infogovernor.asset.model.entity.RiskPointVM;

/**
 * @Description: ���̴���VO
 * @Author  
 * @History 2010-9-13     �½� 
 * @Version V1.0
 */
@SuppressWarnings("serial")
public class IGPRR01021VO extends BaseVO implements Serializable{
	
	/** �Ƿ�Ϊ�ɷ��ɽڵ� 1-�ɷ���  */
	protected String nodetype;
	
	/** ��չ��Ϣ�Ƿ��пɼ��� */
	protected String hid;
	
	protected String riskjobid;
	
	protected Integer riskid;
	
	
	
	protected IG500Info process;
	
	protected String status;
	
	protected String dealtime;
	
	protected String xmlheight;
	
	protected String einame;
	
	protected String riskitem;
	protected String poss;
	protected String levels;
	protected String grad;
	
	protected String prtitle;
	
	
	private List<Map<String, Object>> listMap;
	
	/** �Ƿ��ɫ������ */
	protected String isRoleManager;
	/**�Ƿ������첿��*/
	protected String isHost;
	// process0001_begin
	/** �Ƿ�����(0:����;1:��;) */
	protected String isInitiator;
	
	/**���̱�����Ϣ */
	protected IG243TB processTitleDefTB;
	
	/** �����߿��Ӱ�ť */
	List<IG309Info> lst_ParticipantVisibleButtonVWInfo;
	
	/**���̹�ϵVO*/
	protected List<IGPRR01022VO> voList;
	
	/**���̹������񹤵���Ϣ�����б�*/
	protected List<IG715Info> ig715InfoList;
	
	/** �������ʲ���ϵ */
	protected List<IG731Info> processInfoEntityList;
	
	/** �����������ҳjsp */
	protected String relevantProcessJsp ;
	
	/**������Ϣ�Ƿ񹫿�*/
	protected String isOpen;
	
	/** �������и�����Ϣ */
	protected Map<String, List<Attachment>> tableAttMap;
	
	/**
	 * �Ƿ�����ȡ��
	 *
	 * @return isInitiator �Ƿ�����
	 */
	public String getIsInitiator() {
		return isInitiator;
	}

	
	
	/**
	 * @return the einame
	 */
	public String getEiname() {
		return einame;
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
	 * @return the riskjobid
	 */
	public String getRiskjobid() {
		return riskjobid;
	}



	/**
	 * @param riskjobid the riskjobid to set
	 */
	public void setRiskjobid(String riskjobid) {
		this.riskjobid = riskjobid;
	}



	/**
	 * @return the riskid
	 */
	public Integer getRiskid() {
		return riskid;
	}



	/**
	 * @param riskid the riskid to set
	 */
	public void setRiskid(Integer riskid) {
		this.riskid = riskid;
	}



	/**
	 * @param einame the einame to set
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}



	/**
	 * @return the riskitem
	 */
	public String getRiskitem() {
		return riskitem;
	}



	/**
	 * @param riskitem the riskitem to set
	 */
	public void setRiskitem(String riskitem) {
		this.riskitem = riskitem;
	}



	/**
	 * @return the poss
	 */
	public String getPoss() {
		return poss;
	}



	/**
	 * @param poss the poss to set
	 */
	public void setPoss(String poss) {
		this.poss = poss;
	}



	/**
	 * @return the levels
	 */
	public String getLevels() {
		return levels;
	}



	/**
	 * @param levels the levels to set
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}



	/**
	 * @return the grad
	 */
	public String getGrad() {
		return grad;
	}



	/**
	 * @param grad the grad to set
	 */
	public void setGrad(String grad) {
		this.grad = grad;
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
	 * �Ƿ������趨
	 *
	 * @param isInitiator �Ƿ�����
	 */
	public void setIsInitiator(String isInitiator) {
		this.isInitiator = isInitiator;
	}
	// process0001_end
	
	/** ����״̬_�����߼��� */
	protected List<IG222Info> processParticipantDeflist;
	
	/** ����״̬_ǰ������ */
	protected List<IG211Info> processStatusInfoDeflist;
	
	/** ���̱������� */
	protected List<IG599Info> processInfolist;
	
	/** ҳ��ɼ���ť���� */
	protected Map<String,String> actionlist;//ÿ����¼��4λ���ֱ�ʾ��1����ɼ�0�����ɼ���˳��Ϊ��׼--����--�ύ--��ֹ
	
	/** ��ť��ʾ��Ϣ */
	protected Map<String,String> declist;  
	public Map<String, String> getDeclist() {
		return declist;
	}

	public void setDeclist(Map<String, String> declist) {
		this.declist = declist;
	}
	/** ����״̬_�����߱���Ȩ�޼��� keyΪ�����ߵ�ppdid*/
	protected Map<Integer,List<IG881Info>> processInfoParticipantDefmap;
	
	/** �������� keyΪ������pidid*/
	protected Map<String,IG007Info> processInfoDefmap;
	/** �������� keyΪ������pidid*/
	protected Map<Integer,IG007Info> processInfoDefmaps;
	
	/** �Ƿ���״̬�±������� keyΪ������pidid*/
	protected Map<Integer,IG599Info> processInfomap;
	
	/** ����Ȩ�޼��� keyΪ������pidid*/
	protected Map<Integer,String> variableAcessmap;

	protected Map<Integer,IG211Info> variableObjectElsemap;
	
	protected Map<Integer,IG599Info> processInfoElsemap;
	/**��ɫ�����б��Ƿ���ʾ;0-��ʾ1-����ʾ */
	protected String disp;
	/** �Ƿ������̹���Ա */
	protected String isAdmin;
	
	/**���������̼���*/
	protected List<IG500Info> prList;
	
	List<RiskPointVM> listPointVMs = new ArrayList<RiskPointVM>();
	List<CheckItemVW> checkItemVWs = new ArrayList<CheckItemVW>();
	
	
	/** ������־*/
	protected Map<String,List<IG036Info>> recordLogMap;
	
	/** ����״̬��Ϣ */
	protected IG333Info processStatusDef;
	
	/** ����SUPER���ɱ�ʶ */
	protected String  superFlag;
	
	protected List<IG036Info> recordLogList;
	
	/** ֵ���˱�ʶ */
	protected boolean dutyPerson;
	
	/** �Ƿ����δ��Ȩֵ���˱�ʶ */
	protected boolean hasDutyPerson;
	
	/** Ŀ�깤��������ȷ�ϡ��ڵ�ɾ����ť��ʾ��ʶ */
	protected boolean targetFlag;
	
	/** ��ǰ�û�ID*/
	protected String userid;
	
	/** ��ǰ�û�ѡ���ɫID*/
	protected Integer roleid;
	
	/** ��ǰ�����߻����� */
	protected String orgid;
	
	/** �����������ʲ���Ϣ */
	protected Map<String, IG731Info> pieMap;
	
	/** �������ֵ Map */
	protected Map<String, IG505Info> processInfoFormValueMap;
	
	/** ��Ա���ֵMap */
	protected Map<String, IG506Info> participantFormValueMap;
	
	/**
	 * Ŀ�깤��������ȷ�ϡ��ڵ�ɾ����ť��ʾ��ʶȡ��
	 * 
	 * @return Ŀ�깤��������ȷ�ϡ��ڵ�ɾ����ť��ʾ��ʶ
	 */
	public boolean isTargetFlag() {
		return targetFlag;
	}

	/**
	 * Ŀ�깤��������ȷ�ϡ��ڵ�ɾ����ť��ʾ��ʶ�趨
	 * 
	 * @param targetFlag Ŀ�깤��������ȷ�ϡ��ڵ�ɾ����ť��ʾ��ʶ
	 */
	public void setTargetFlag(boolean targetFlag) {
		this.targetFlag = targetFlag;
	}
	
	/**�ı���󶨸���*/
	protected Map<String,List<Attachment>> textAreaMap;
	
	/** ����ͼXML */
	protected String flowChartXml;
	
	/** �Ƿ���ʾ�����˵���ִ�������ӱ�ʶ */
	protected String showExecutor = "true";
	
	/** ��ǰ״̬�Ƿ�ɷ������������(0:����;1:��;)*/
	protected String isMoreRelevantProcess;
	
    /** �ɷ����������̶���id*/
    protected String relevantPdid;
    
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
	public Map<String, List<Attachment>> getTextAreaMap() {
		return textAreaMap;
	}

	public void setTextAreaMap(Map<String, List<Attachment>> textAreaMap) {
		this.textAreaMap = textAreaMap;
	}
	public List<IG036Info> getRecordLogList() {
		return recordLogList;
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


	public void setRecordLogList(List<IG036Info> recordLogList) {
		this.recordLogList = recordLogList;
	}

	public Map<String, List<IG036Info>> getRecordLogMap() {
		return recordLogMap;
	}

	public void setRecordLogMap(Map<String, List<IG036Info>> recordLogMap) {
		this.recordLogMap = recordLogMap;
	}

	public String getIsRoleManager() {
		return isRoleManager;
	}

	public void setIsRoleManager(String isRoleManager) {
		this.isRoleManager = isRoleManager;
	}
	
	public String getDealtime() {
		return dealtime;
	}

	public void setDealtime(String dealtime) {
		this.dealtime = dealtime;
	}
	
	public List<IG500Info> getPrList() {
		return prList;
	}

	public void setPrList(List<IG500Info> prList) {
		this.prList = prList;
	}
	
	protected String imgxml;
	
	
	public String getImgxml() {
		return imgxml;
	}


	public void setImgxml(String imgxml) {
		this.imgxml = imgxml;
	}


	public List<IG211Info> getProcessStatusInfoDeflist() {
		return processStatusInfoDeflist;
	}


	public void setProcessStatusInfoDeflist(
			List<IG211Info> processStatusInfoDeflist) {
		this.processStatusInfoDeflist = processStatusInfoDeflist;
	}


	public List<IG599Info> getProcessInfolist() {
		return processInfolist;
	}


	public void setProcessInfolist(List<IG599Info> processInfolist) {
		this.processInfolist = processInfolist;
	}


	public Map<Integer, IG211Info> getVariableObjectElsemap() {
		return variableObjectElsemap;
	}


	public void setVariableObjectElsemap(
			Map<Integer, IG211Info> variableObjectElsemap) {
		this.variableObjectElsemap = variableObjectElsemap;
	}


	public Map<Integer, IG599Info> getProcessInfoElsemap() {
		return processInfoElsemap;
	}


	public void setProcessInfoElsemap(Map<Integer, IG599Info> processInfoElsemap) {
		this.processInfoElsemap = processInfoElsemap;
	}


	public List<IG222Info> getProcessParticipantDeflist() {
		return processParticipantDeflist;
	}


	public void setProcessParticipantDeflist(
			List<IG222Info> processParticipantDeflist) {
		this.processParticipantDeflist = processParticipantDeflist;
	}


	public Map<String,String> getActionlist() {
		return actionlist;
	}


	public void setActionlist(Map<String,String> actionlist) {
		this.actionlist = actionlist;
	}


	public Map<Integer, List<IG881Info>> getProcessInfoParticipantDefmap() {
		return processInfoParticipantDefmap;
	}


	public void setProcessInfoParticipantDefmap(
			Map<Integer, List<IG881Info>> processInfoParticipantDefmap) {
		this.processInfoParticipantDefmap = processInfoParticipantDefmap;
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

	public Map<Integer, IG599Info> getProcessInfomap() {
		return processInfomap;
	}


	public void setProcessInfomap(Map<Integer, IG599Info> processInfomap) {
		this.processInfomap = processInfomap;
	}


	public Map<Integer, String> getVariableAcessmap() {
		return variableAcessmap;
	}


	public void setVariableAcessmap(Map<Integer, String> variableAcessmap) {
		this.variableAcessmap = variableAcessmap;
	}

	public IG500Info getProcess() {
		return process;
	}

	public void setProcess(IG500Info process) {
		this.process = process;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNodetype() {
		return nodetype;
	}

	public void setNodetype(String nodetype) {
		this.nodetype = nodetype;
	}

	public String getDisp() {
		return disp;
	}

	public void setDisp(String disp) {
		this.disp = disp;
	}


//	/**
//	 * ���̲����ߵı���Ȩ�޼������ȡ��
//	 * 
//	 * @return ���̲����ߵı���Ȩ�޼������
//	 */
//	public List<ProcessInfoParticipantDef> getProcessInfoParticipantDefList() {
//		return processInfoParticipantDefList;
//	}
//
//
//	/**
//	 * ���̲����ߵı���Ȩ�޼�������趨
//	 *
//	 * @param processInfoParticipantDefList ���̲����ߵı���Ȩ�޼������
//	 */
//	public void setProcessInfoParticipantDefList(
//			List<ProcessInfoParticipantDef> processInfoParticipantDefList) {
//		this.processInfoParticipantDefList = processInfoParticipantDefList;
//	}
	
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

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
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
	 * ���̱��ⶨ��ȡ��
	 * @return ���̱��ⶨ��
	 */
	public IG243TB getProcessTitleDefTB() {
		return processTitleDefTB;
	}

	/**
	 * �������̱��ⶨ��ʵ��
	 * @param processTitleDefTB���̱��ⶨ��ʵ��
	 */
	public void setProcessTitleDefTB(IG243TB processTitleDefTB) {
		this.processTitleDefTB = processTitleDefTB;
	}

	/**
	 * ��ǰ�û�ID
	 * @return ��ǰ�û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ��ǰ�û�ID
	 * @param userid��ǰ�û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * ��ǰ�û���ɫID
	 * @return ��ǰ�û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * ��ǰ�û���ɫID
	 * @param userid��ǰ�û���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
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
		if(lst_ParticipantVisibleButtonVWInfo != null) {
			for(IG309Info bean : lst_ParticipantVisibleButtonVWInfo) {
				if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(bean.getVbid())) {
					this.showExecutor = "false";
				}
			}
		}
	}

	public String getXmlheight() {
		return xmlheight;
	}

	public void setXmlheight(String xmlheight) {
		this.xmlheight = xmlheight;
	}

	/**
	 * �Ƿ���ʾ�����˵���ִ�������ӱ�ʶȡ��
	 * 
	 * @return �Ƿ���ʾ�����˵���ִ�������ӱ�ʶ
	 */
	public String getShowExecutor() {
		return showExecutor;
	}

	/**
	 * �Ƿ���ʾ�����˵���ִ�������ӱ�ʶ�趨
	 * 
	 * @param showExecutor �Ƿ���ʾ�����˵���ִ�������ӱ�ʶ
	 */
	public void setShowExecutor(String showExecutor) {
		this.showExecutor = showExecutor;
	}
	protected String hasCLRecord = "0";

	protected List<IG512Info> ig512InfoList;
	
	public String getHasCLRecord() {
		return hasCLRecord;
	}

	public void setHasCLRecord(String hasCLRecord) {
		this.hasCLRecord = hasCLRecord;
	}
	
	/**
	 * �������̹�ϵ��Ϣ�����б�
	 * @param ig512InfoList ���̹�ϵ��Ϣ�����б�
	 */
	public void setIG512InfoList(List<IG512Info> ig512InfoList) {
		this.ig512InfoList = ig512InfoList;
		if(ig512InfoList != null && ig512InfoList.size() > 0) {
			int prid = this.process.getPrid();
			voList = new ArrayList<IGPRR01022VO>();
			//˫����װVO
			for(IG512Info prr : ig512InfoList) {
				if(prid == prr.getParprid()) {
					IGPRR01022VO vo = new IGPRR01022VO();
					vo.setInfo(prr.getCldProcess());
					vo.setType("C");
					this.voList.add(vo);
				} else if(prid == prr.getCldprid()){
					IGPRR01022VO vo = new IGPRR01022VO();
					vo.setInfo(prr.getParProcess());
					vo.setType("P");
					this.voList.add(vo);
				}
			}
		} else {
			this.ig512InfoList = null;
		}
	}
	
	/**
	 * �������̹�ϵ��Ϣ�����б�
	 * @param ig512InfoList ���̹�ϵ��Ϣ�����б�
	 */
	public List<IGPRR01022VO> getVoList() {
		return voList;
	}

	public List<IG715Info> getIg715InfoList() {
		return ig715InfoList;
	}

	public void setIg715InfoList(
			List<IG715Info> ig715InfoList) {
		this.ig715InfoList = ig715InfoList;
	}
	
	/**
	 * �������ʲ���ϵȡ��
	 * @return �������ʲ���ϵ
	 */
	public List<IG731Info> getProcessInfoEntityList() {
		return processInfoEntityList;
	}

	/**
	 * �������ʲ���ϵ�趨
	 * @param processInfoEntityList �������ʲ���ϵ
	 */
	public void setProcessInfoEntityList(
			List<IG731Info> processInfoEntityList) {
		this.processInfoEntityList = processInfoEntityList;
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
     * @return the relevantProcessJsp
     */
    public String getRelevantProcessJsp() {
        return relevantProcessJsp;
    }

    /**
     * @param relevantProcessJsp the relevantProcessJsp to set
     */
    public void setRelevantProcessJsp(String relevantProcessJsp) {
        this.relevantProcessJsp = relevantProcessJsp;
    }
    /**
     * ������Ϣ�Ƿ񹫿�ȡ��
     * @return
     */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * ������Ϣ�Ƿ񹫿��趨
	 * @param isOpen
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * �Ƿ������첿��ȡ��
	 *
	 * @return isHost �Ƿ������첿��
	 */
	
	public String getIsHost() {
		return isHost;
	}

	/**
	 * �Ƿ������첿���趨
	 *
	 * @param isHost �Ƿ������첿��
	 */
	public void setIsHost(String isHost) {
		this.isHost = isHost;
	}

	/**
	 * ��������keyΪ������pididȡ��
	 *
	 * @return processInfoDefmaps ��������keyΪ������pidid
	 */
	
	public Map<Integer, IG007Info> getProcessInfoDefmaps() {
		return processInfoDefmaps;
	}

	/**
	 * ��������keyΪ������pidid�趨
	 *
	 * @param processInfoDefmaps ��������keyΪ������pidid
	 */
	public void setProcessInfoDefmaps(Map<Integer, IG007Info> processInfoDefmaps) {
		this.processInfoDefmaps = processInfoDefmaps;
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
	 * ig512InfoListȡ��
	 *
	 * @return ig512InfoList ig512InfoList
	 */
	
	public List<IG512Info> getIg512InfoList() {
		return ig512InfoList;
	}

	/**
	 * ig512InfoList�趨
	 *
	 * @param ig512InfoList ig512InfoList
	 */
	public void setIg512InfoList(List<IG512Info> ig512InfoList) {
		this.ig512InfoList = ig512InfoList;
	}

	/**
	 * ���̹�ϵVO�趨
	 *
	 * @param voList ���̹�ϵVO
	 */
	public void setVoList(List<IGPRR01022VO> voList) {
		this.voList = voList;
	}

	/**
	 * �����������ʲ���Ϣȡ��
	 * @return pieMap �����������ʲ���Ϣ
	 */
	public Map<String, IG731Info> getPieMap() {
		return pieMap;
	}

	/**
	 * �����������ʲ���Ϣ�趨
	 * @param pieMap �����������ʲ���Ϣ
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
	 * �������ֵMapȡ��
	 * @return processInfoFormValueMap �������ֵMap
	 */
	public Map<String, IG505Info> getProcessInfoFormValueMap() {
		return processInfoFormValueMap;
	}

	/**
	 * �������ֵMap�趨
	 * @param processInfoFormValueMap �������ֵMap
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
	
}