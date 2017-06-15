/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.prm.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.infogovernor.prm.dto.IGPRM01DTO;
import com.deliverik.infogovernor.prm.form.IGPRM0202Form;
import com.deliverik.infogovernor.prm.form.IGPRM0302Form;
import com.deliverik.infogovernor.prm.form.IGPRM0304Form;
import com.deliverik.infogovernor.prm.form.IGPRM0305Form;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

public class IGPRM01BLImpl implements IGPRM01BL {
	
	protected IG380BL ig380BL;
	
	protected IG259BL ig259BL;
	
	/** ��ɫ���� */
	private RoleBL roleBL;
	
	/** ���̱������� */
	private IG007BL ig007BL;
	
	/**
	 * <p>
	 * ���ý�ɫ����
	 * <p>
	 * 
	 * @param roleBL ��ɫ����
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * <p>
	 * �������̱�������
	 * <p>
	 * 
	 * @param ig007BL ���̱�������
	 */
	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	public IGPRM01DTO insertProcessTemplate(IGPRM01DTO dto) throws BLException {
		IG259Info processTemplate = dto.getProcessTemplate();
		processTemplate = ig259BL.registIG259Info(processTemplate);
		dto.setProcessTemplate(processTemplate);
		return dto;
	}

	public IGPRM01DTO findAllProcessTemplate(IGPRM01DTO dto) throws BLException {
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(new IG259SearchCondImpl());
		dto.setProcessTemplateList(processTemplateList);
		return dto;
	}

	public IGPRM01DTO changePTStatus(IGPRM01DTO dto) throws BLException {
		IG259Info processTemplate = ig259BL.searchIG259InfoByKey(dto.getProcessTemplate().getPtid());
		
		IG259TB processTemplateTB = (IG259TB)SerializationUtils.clone(processTemplate);
		if("a".equals(processTemplate.getPtstatus())){
			processTemplateTB.setPtstatus("i");
		} else if ("i".equals(processTemplate.getPtstatus())){
			processTemplateTB.setPtstatus("a");
		}
		
		ig259BL.updateIG259Info(processTemplateTB);
		
		return dto;
		
	}

	public IGPRM01DTO insertProcessDefinition(IGPRM01DTO dto) throws BLException {
		IGPRM0202Form form = dto.getIgPRM0202Form();
		IG259Info pt = ig259BL.searchIG259InfoByKey(form.getPtid());
		form.setPdid(this.ig380BL.getPdidNextValue(pt.getFirstsite(),pt.getPdsequence()));//����
		dto.setProcessDefinition(ig380BL.registIG380Info(form));
		return dto;
	}

	public IGPRM01DTO getAllActiveTemplate(IGPRM01DTO dto) throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPtstatus("a");
		List<IG259Info> processTemplateList = ig259BL.searchIG259Info(cond);
		//�����Զ������̺��¼�
		for(Iterator<IG259Info> iter = processTemplateList.iterator(); iter.hasNext();) {
			IG259Info pt = iter.next();
			if(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE.equals(pt.getPttype())) {
				iter.remove();
			}
		}
		dto.setProcessTemplateList(processTemplateList);
		return dto;
	}

	public IGPRM01DTO findAllProcessDefinition(IGPRM01DTO dto) throws BLException {
		
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		Integer[] ptidForType = new Integer[8];
		ptidForType[0] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_I;
		ptidForType[1] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_P;
		ptidForType[2] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_C;
		ptidForType[3] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_D;
		ptidForType[4] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_S;
		ptidForType[5] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_WA;
		ptidForType[6] = IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_WB;
		ptidForType[7] = 14;

		cond.setPrTypeArray(ptidForType);
		int totalCount = ig380BL.getIG380InfoSearchCount(cond);
		List<IG380Info> processDefinitionList = ig380BL.searchIG380Info(cond,  pDto.getFromCount(), pDto.getPageDispCount());
		List<IG380Info> retPDList = new ArrayList<IG380Info>();
		List<IG259Info> retPTList = new ArrayList<IG259Info>();
		for (IG380Info processDefinition : processDefinitionList) {
			IG259Info processTemplate = ig259BL.searchIG259InfoByKey(processDefinition.getPtid());
			if("a".equals(processTemplate.getPtstatus())){
				retPDList.add(processDefinition);
				retPTList.add(processTemplate);
			}
		}
		dto.setProcessDefinitionList(retPDList);
		dto.setProcessTemplateList(retPTList);
		
		pDto.setTotalCount(totalCount);
		
		return dto;
	}
	
	public IGPRM01DTO findProcessDefinition(IGPRM01DTO dto) throws BLException {
		List<IG380Info> processDefinitionList = ig380BL.searchIG380Info(new IG380SearchCondImpl(), 0, 0);
		List<IG380Info> retPDList = new ArrayList<IG380Info>();
		List<IG259Info> retPTList = new ArrayList<IG259Info>();
		for (IG380Info processDefinition : processDefinitionList) {
			IG259Info processTemplate = ig259BL.searchIG259InfoByKey(processDefinition.getPtid());
			if("a".equals(processTemplate.getPtstatus())){
				retPDList.add(processDefinition);
				retPTList.add(processTemplate);
			}
		}
		dto.setProcessDefinitionList(retPDList);
		dto.setProcessTemplateList(retPTList);
		return dto;
	}

	/**
	 * �����û���ɫȨ�ޣ���ȡ����Ŀ¼
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @author fuqiang@deliverik.com
	 */
	public IGPRM01DTO findPurviewProcessDefinition(IGPRM01DTO dto)throws BLException {
		Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
		List<String> tempList = new ArrayList<String>();
		List<IG380Info> retPDList = new ArrayList<IG380Info>();
		List<IG259Info> retPTList = new ArrayList<IG259Info>();
		tempList = dto.getProcessDefinitionSubscript();
		for (int i = 0; i < tempList.size(); i++) {
			IG259Info processTemplate = ig259BL.searchIG259InfoByKey(Integer.parseInt(tempList.get(i)));
			if("a".equals(processTemplate.getPtstatus())){
				retPTList.add(processTemplate);	
		     }
		}		
		for(int j = 0;j < retPTList.size();j++){
			retPDList = ig380BL.searchIG380InfoByPtid(retPTList.get(j).getPtid());
			map.put(retPTList.get(j), retPDList);
		}
		dto.setProcessMap(map);      
		dto.setProcessTemplateList(retPTList);
        return dto;
    }

	public IGPRM01DTO changePDStatus(IGPRM01DTO dto) throws BLException {
		IG380Info processDefinition = ig380BL.searchIG380InfoByKey(dto.getProcessDefinition().getPdid());
		IG380TB processDefinitionTB = (IG380TB)SerializationUtils.clone(processDefinition);
		if("a".equals(processDefinition.getPdstatus())){
			processDefinitionTB.setPdstatus("i");
		} else if ("i".equals(processDefinition.getPdstatus())){
			processDefinitionTB.setPdstatus("a");
		}
		ig380BL.updateIG380Info(processDefinitionTB);
		return dto;
	}

	public IGPRM01DTO insertProcessInfoDef(IGPRM01DTO dto) throws BLException {
		IGPRM0302Form form = dto.getIgPRM0302Form();
		form.setPidid(this.ig007BL.getPididSequenceNextValue(form.getPdid()));//����
		dto.setProcessInfoDef(ig007BL.registIG007Info(form));
		return dto;
	}

	public IGPRM01DTO findAllProcessInfoDef(IGPRM01DTO dto) throws BLException {
		IG007Info processInfoDef = dto.getProcessInfoDef();
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processInfoDef.getPdid());
		cond.setIsDefault(WorkFlowConstDefine.NO);
		List<IG007Info> processInfoDefList = ig007BL.searchIG007Info(cond, 0, 0);
		dto.setProcessInfoDefList(processInfoDefList);
		//�ж��Ƿ��������ȱʡ������
		String default_process_approvor_type = ResourceUtility.getString(WorkFlowConstDefine.DEFAULT_PROCESS_APPROVOR_TYPE);
		if(StringUtils.isNotEmpty(default_process_approvor_type)) {
			//����
			IG380Info pd = ig380BL.searchIG380InfoByKey(processInfoDef.getPdid());
			if(pd != null) {
				//ģ��
				IG259Info pt = ig259BL.searchIG259InfoByKey(pd.getPtid());
				if(pt != null ) {
					if(default_process_approvor_type.indexOf("," + pt.getPttype() + ",") != -1) {
						if(IGPROCESSType.SERVICE_PRTYPE.equals(pt.getPttype())) {
							dto.setAddDefaultApprover("2"); 
						} else {
							dto.setAddDefaultApprover("1"); 
						}
					}
				}
			}
		}
		//�ж��Ƿ��������ȱʡ����������
		String default_process_approvedispatch_type = ResourceUtility.getString(WorkFlowConstDefine.DEFAULT_PROCESS_APPROVEDISPATCH_TYPE);
		if(StringUtils.isNotEmpty(default_process_approvedispatch_type)) {
			//����
			IG380Info pd = ig380BL.searchIG380InfoByKey(processInfoDef.getPdid());
			if(pd != null) {
				//ģ��
				IG259Info pt = ig259BL.searchIG259InfoByKey(pd.getPtid());
				if(pt != null ) {
					if(default_process_approvedispatch_type.indexOf("," + pt.getPttype() + ",") != -1) {
						dto.setAddDefaultApproveDispatcher("1");
					}
				}
			}
		}
		return dto;
	}

	public IGPRM01DTO deleteProcessInfoDef(IGPRM01DTO dto) throws BLException {
		String[] pidids = dto.getPidids();
		int length = pidids.length;
		for (int i = 0; i < length; i++) {
			ig007BL.deleteIG007InfoByKey(pidids[i]);
		}
		return dto;
	}
	
	

	/**
	 * <p>
	 * Description: ȱʡ���������˳�ʼ�� 
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGPRM01DTO initApproveDispatcher(IGPRM01DTO dto) throws BLException {
		IGPRM0305Form form = dto.getIgprm0305Form();
		//ȱʡ����������
		dto.setApproveDispatcherList(ig007BL.searchDefaultApprovorDispatcherByPdid(form.getPdid()));
		//��ɫ
		dto.setApproveDispatcherRoleList(getApproveDispatcherRole(dto.getApproveDispatcherList()));
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �������������
	 * ��Ϊ������������Ϊһ�����̱�����ֱ���ñ���������ѯɾ��
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO addApproveDispatcher(IGPRM01DTO dto) throws BLException {
		IGPRM0305Form form = dto.getIgprm0305Form();
		if(form.getRoleids() != null && form.getRoleids().length == 1) {//��ŵ������̱���ID
			StringBuffer approveDispatcher_sbf = new StringBuffer();
			approveDispatcher_sbf.append(form.getRoleids()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			approveDispatcher_sbf.append(form.getRolenames()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			approveDispatcher_sbf.append(form.getPpuserids()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			approveDispatcher_sbf.append(form.getPpusernames()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			approveDispatcher_sbf.append(form.getPporgids()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			approveDispatcher_sbf.append(form.getPporgnames()[0]).append(WorkFlowConstDefine.SPILT_APPROVORS);
			IG007TB pidTB = new IG007TB();
			pidTB.setPdid(form.getPdid());
			pidTB.setPiddesc(approveDispatcher_sbf.toString());
			pidTB.setPidlabel("ȱʡ����������");
			pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVEDISPATCHER);
			pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
			pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(form.getPdid()));
			ig007BL.registIG007Info(pidTB);
			
		} else {
			throw new BLException("IGPRM0305.E001");
		}
		dto.addMessage(new ActionMessage("IGPRM0305.I001"));
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ɾ����������������
	 * ��Ϊ������������Ϊһ�����̱�����ֱ���ñ���������ѯɾ��
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO removeApproveDispatcher(IGPRM01DTO dto) throws BLException {
		IGPRM0305Form form = dto.getIgprm0305Form();
		if(form.getRoleids() != null && form.getRoleids().length == 1) {//��ŵ������̱���ID
			IG007Info pid = ig007BL.searchIG007InfoByKey(form.getRoleids()[0]);
			if(pid != null ) {
				ig007BL.deleteIG007InfoByKey(pid.getPidid());
			} else {
				throw new BLException("IGPRM0305.E001");
			}
		} else {
			throw new BLException("IGPRM0305.E001");
		}
		dto.addMessage(new ActionMessage("IGPRM0305.I002"));
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ȱʡ�����˳�ʼ�� 
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 */
	public IGPRM01DTO initApprovors(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		//ȱʡ������
		dto.setApprovorsMap(ig007BL.getDefaultApprovors(form.getPdid()));
		//��ɫ
		dto.setApproveRolesMap(getApproveRoles(dto.getApprovorsMap()));
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ɾ��������
	 * ����գ������ӡ�ҳ��δѡ��ļ�¼��Ϊ���ӵļ�¼
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO removeApprovors(IGPRM01DTO dto) throws BLException {
		clearApprovors_one(dto);
		clearApprovors_two(dto);
		clearApprovors_three(dto);
		addApprovors_one(dto);
		addApprovors_two(dto);
		addApprovors_three(dto);
		dto.addMessage(new ActionMessage("IGPRM0304.I002"));
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ȱʡ������
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO addApprovors(IGPRM01DTO dto) throws BLException {
		addApprovors_one(dto);
		addApprovors_two(dto);
		addApprovors_three(dto);
		dto.addMessage(new ActionMessage("IGPRM0304.I001"));
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ȱʡһ��������
	 * ����׷�ӷ�ʽ���
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO addApprovors_one(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		if(form.getRoleids_one() != null){
			int len_one = form.getRoleids_one().length;
			StringBuffer approvors_roleid = new StringBuffer("");
			StringBuffer approvors_rolename = new StringBuffer("");
			StringBuffer approvors_userid = new StringBuffer("");
			StringBuffer approvors_username = new StringBuffer("");
			StringBuffer approvors_orgsyscoding = new StringBuffer("");
			StringBuffer approvors_orgname = new StringBuffer("");
			IG007Info upd_pid_roleid = null;
			IG007Info upd_pid_rolename = null;
			IG007Info upd_pid_userid = null;
			IG007Info upd_pid_username = null;
			IG007Info upd_pid_orgid = null;
			IG007Info upd_pid_orgname = null;
			//��ѯ�����������б���
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPdid(form.getPdid());//��������ID
			cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE);
			List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
			for(IG007Info pid : list) {
				//һ������������
				if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname())) {
					approvors_roleid.append(pid.getPiddesc());
					if(len_one >0){
						approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_roleid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_ONE, pid.getPidname())) {
					approvors_rolename.append(pid.getPiddesc());
					if(len_one >0){
						approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_rolename = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_ONE, pid.getPidname())) {
					approvors_userid.append(pid.getPiddesc());
					if(len_one >0){
						approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_userid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_ONE, pid.getPidname())) {
					approvors_username.append(pid.getPiddesc());
					if(len_one >0){
						approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_username = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_ONE, pid.getPidname())) {
					approvors_orgsyscoding.append(pid.getPiddesc());
					if(len_one >0){
						approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_ONE, pid.getPidname())) {
					approvors_orgname.append(pid.getPiddesc());
					if(len_one >0){
						approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgname = pid;
				}
			}
			
			//ƴ���ַ���
			for(int i = 0;i < len_one; i++) {
				approvors_roleid.append(Integer.parseInt(form.getRoleids_one()[i]));//roleid
				approvors_rolename.append(form.getRolenames_one()[i]);//rolename
				approvors_userid.append(form.getPpuserids_one()[i]);//userid
				approvors_username.append(form.getPpusernames_one()[i]);//username
				approvors_orgsyscoding.append(form.getPporgids_one()[i]);//orgsyscoding
				approvors_orgname.append(form.getPporgnames_one()[i]);//orgname
				if(i < len_one - 1) {
					approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
				}
			} 
			
			if(upd_pid_roleid != null){
				IG007TB roleid_pidTB = (IG007TB)upd_pid_roleid;
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = (IG007TB)upd_pid_rolename;
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = (IG007TB)upd_pid_userid;
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = (IG007TB)upd_pid_username;
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = (IG007TB)upd_pid_orgid;
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);
				
				IG007TB orgname_pidTB = (IG007TB)upd_pid_orgname;
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}else{
				//�������̱���
				IG007TB roleid_pidTB = new IG007TB();
				roleid_pidTB.setPdid(form.getPdid());
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidlabel("ȱʡһ�������˽�ɫID");
				roleid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE);
				roleid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = new IG007TB();
				rolename_pidTB.setPdid(form.getPdid());
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidlabel("ȱʡһ�������˽�ɫ����");
				rolename_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_ONE);
				rolename_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = new IG007TB();
				userid_pidTB.setPdid(form.getPdid());
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidlabel("ȱʡһ���������û�ID");
				userid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_ONE);
				userid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = new IG007TB();
				username_pidTB.setPdid(form.getPdid());
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidlabel("ȱʡһ���������û�����");
				username_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_ONE);
				username_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = new IG007TB();
				orgid_pidTB.setPdid(form.getPdid());
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidlabel("ȱʡһ�������˻��������");
				orgid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_ONE);
				orgid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);
				
				IG007TB orgname_pidTB = new IG007TB();
				orgname_pidTB.setPdid(form.getPdid());
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidlabel("ȱʡһ�������˻�������");
				orgname_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_ONE);
				orgname_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}
		}
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ȱʡ����������
	 * ����׷�ӷ�ʽ���
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO addApprovors_two(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		if(form.getRoleids_two() != null){
			int len_two = form.getRoleids_two().length;
			StringBuffer approvors_roleid = new StringBuffer("");
			StringBuffer approvors_rolename = new StringBuffer("");
			StringBuffer approvors_userid = new StringBuffer("");
			StringBuffer approvors_username = new StringBuffer("");
			StringBuffer approvors_orgsyscoding = new StringBuffer("");
			StringBuffer approvors_orgname = new StringBuffer("");
			IG007Info upd_pid_roleid = null;
			IG007Info upd_pid_rolename = null;
			IG007Info upd_pid_userid = null;
			IG007Info upd_pid_username = null;
			IG007Info upd_pid_orgid = null;
			IG007Info upd_pid_orgname = null;
			//��ѯ�����������б���
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPdid(form.getPdid());//��������ID
			cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO);
			List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
			for(IG007Info pid : list) {
				//��������������
				if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname())) {
					approvors_roleid.append(pid.getPiddesc());
					if(len_two >0){
						approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_roleid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_TWO, pid.getPidname())) {
					approvors_rolename.append(pid.getPiddesc());
					if(len_two >0){
						approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_rolename = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_TWO, pid.getPidname())) {
					approvors_userid.append(pid.getPiddesc());
					if(len_two >0){
						approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_userid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_TWO, pid.getPidname())) {
					approvors_username.append(pid.getPiddesc());
					if(len_two >0){
						approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_username = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_TWO, pid.getPidname())) {
					approvors_orgsyscoding.append(pid.getPiddesc());
					if(len_two >0){
						approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_TWO, pid.getPidname())) {
					approvors_orgname.append(pid.getPiddesc());
					if(len_two >0){
						approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgname = pid;
				}
			}
			
			//ƴ���ַ���
			for(int i = 0;i < len_two; i++) {
				approvors_roleid.append(Integer.parseInt(form.getRoleids_two()[i]));//roleid
				approvors_rolename.append(form.getRolenames_two()[i]);//rolename
				approvors_userid.append(form.getPpuserids_two()[i]);//userid
				approvors_username.append(form.getPpusernames_two()[i]);//username
				approvors_orgsyscoding.append(form.getPporgids_two()[i]);//orgsyscoding
				approvors_orgname.append(form.getPporgnames_two()[i]);//orgname
				if(i < len_two - 1) {
					approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
				}
			} 
			
			if(upd_pid_roleid != null){
				IG007TB roleid_pidTB = (IG007TB)upd_pid_roleid;
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = (IG007TB)upd_pid_rolename;
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = (IG007TB)upd_pid_userid;
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = (IG007TB)upd_pid_username;
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = (IG007TB)upd_pid_orgid;
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);
				
				IG007TB orgname_pidTB = (IG007TB)upd_pid_orgname;
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}else{
				//�������̱���
				IG007TB roleid_pidTB = new IG007TB();
				roleid_pidTB.setPdid(form.getPdid());
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidlabel("ȱʡ���������˽�ɫID");
				roleid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO);
				roleid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = new IG007TB();
				rolename_pidTB.setPdid(form.getPdid());
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidlabel("ȱʡ���������˽�ɫ����");
				rolename_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_TWO);
				rolename_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = new IG007TB();
				userid_pidTB.setPdid(form.getPdid());
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidlabel("ȱʡ�����������û�ID");
				userid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_TWO);
				userid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = new IG007TB();
				username_pidTB.setPdid(form.getPdid());
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidlabel("ȱʡ�����������û�����");
				username_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_TWO);
				username_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = new IG007TB();
				orgid_pidTB.setPdid(form.getPdid());
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidlabel("ȱʡ���������˻��������");
				orgid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_TWO);
				orgid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);
				
				IG007TB orgname_pidTB = new IG007TB();
				orgname_pidTB.setPdid(form.getPdid());
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidlabel("ȱʡ���������˻�������");
				orgname_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_TWO);
				orgname_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}
		}
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ȱʡ����������
	 * ����׷�ӷ�ʽ���
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO addApprovors_three(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		if(form.getRoleids_three() != null){
			int len_three = form.getRoleids_three().length;
			StringBuffer approvors_roleid = new StringBuffer("");
			StringBuffer approvors_rolename = new StringBuffer("");
			StringBuffer approvors_userid = new StringBuffer("");
			StringBuffer approvors_username = new StringBuffer("");
			StringBuffer approvors_orgsyscoding = new StringBuffer("");
			StringBuffer approvors_orgname = new StringBuffer("");
			IG007Info upd_pid_roleid = null;
			IG007Info upd_pid_rolename = null;
			IG007Info upd_pid_userid = null;
			IG007Info upd_pid_username = null;
			IG007Info upd_pid_orgid = null;
			IG007Info upd_pid_orgname = null;
			//��ѯ�����������б���
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPdid(form.getPdid());//��������ID
			cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE);
			List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
			for(IG007Info pid : list) {
				//��������������
				if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname())) {
					approvors_roleid.append(pid.getPiddesc());
					if(len_three >0){
						approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_roleid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_THREE, pid.getPidname())) {
					approvors_rolename.append(pid.getPiddesc());
					if(len_three >0){
						approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_rolename = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_THREE, pid.getPidname())) {
					approvors_userid.append(pid.getPiddesc());
					if(len_three >0){
						approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_userid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_THREE, pid.getPidname())) {
					approvors_username.append(pid.getPiddesc());
					if(len_three >0){
						approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_username = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_THREE, pid.getPidname())) {
					approvors_orgsyscoding.append(pid.getPiddesc());
					if(len_three >0){
						approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgid = pid;
				} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_THREE, pid.getPidname())) {
					approvors_orgname.append(pid.getPiddesc());
					if(len_three >0){
						approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
					}
					upd_pid_orgname = pid;
				}
			}
			
			//ƴ���ַ���
			for(int i = 0;i < len_three; i++) {
				approvors_roleid.append(Integer.parseInt(form.getRoleids_three()[i]));//roleid
				approvors_rolename.append(form.getRolenames_three()[i]);//rolename
				approvors_userid.append(form.getPpuserids_three()[i]);//userid
				approvors_username.append(form.getPpusernames_three()[i]);//username
				approvors_orgsyscoding.append(form.getPporgids_three()[i]);//orgsyscoding
				approvors_orgname.append(form.getPporgnames_three()[i]);//orgname
				if(i < len_three - 1) {
					approvors_roleid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_rolename.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_userid.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_username.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgsyscoding.append(WorkFlowConstDefine.SPILT_APPROVORS);
					approvors_orgname.append(WorkFlowConstDefine.SPILT_APPROVORS);
				}
			} 
			
			if(upd_pid_roleid != null){
				IG007TB roleid_pidTB = (IG007TB)upd_pid_roleid;
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = (IG007TB)upd_pid_rolename;
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = (IG007TB)upd_pid_userid;
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = (IG007TB)upd_pid_username;
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = (IG007TB)upd_pid_orgid;
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);

				IG007TB orgname_pidTB = (IG007TB)upd_pid_orgname;
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}else{
				//�������̱���
				IG007TB roleid_pidTB = new IG007TB();
				roleid_pidTB.setPdid(form.getPdid());
				roleid_pidTB.setPiddesc(approvors_roleid.toString());
				roleid_pidTB.setPidlabel("ȱʡ���������˽�ɫID");
				roleid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE);
				roleid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				roleid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(roleid_pidTB.getPdid()));
				ig007BL.registIG007Info(roleid_pidTB);
				
				IG007TB rolename_pidTB = new IG007TB();
				rolename_pidTB.setPdid(form.getPdid());
				rolename_pidTB.setPiddesc(approvors_rolename.toString());
				rolename_pidTB.setPidlabel("ȱʡ���������˽�ɫ����");
				rolename_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_THREE);
				rolename_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				rolename_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(rolename_pidTB.getPdid()));
				ig007BL.registIG007Info(rolename_pidTB);
				
				IG007TB userid_pidTB = new IG007TB();
				userid_pidTB.setPdid(form.getPdid());
				userid_pidTB.setPiddesc(approvors_userid.toString());
				userid_pidTB.setPidlabel("ȱʡ�����������û�ID");
				userid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_THREE);
				userid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				userid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(userid_pidTB.getPdid()));
				ig007BL.registIG007Info(userid_pidTB);
				
				IG007TB username_pidTB = new IG007TB();
				username_pidTB.setPdid(form.getPdid());
				username_pidTB.setPiddesc(approvors_username.toString());
				username_pidTB.setPidlabel("ȱʡ�����������û�����");
				username_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_THREE);
				username_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				username_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(username_pidTB.getPdid()));
				ig007BL.registIG007Info(username_pidTB);
				
				IG007TB orgid_pidTB = new IG007TB();
				orgid_pidTB.setPdid(form.getPdid());
				orgid_pidTB.setPiddesc(approvors_orgsyscoding.toString());
				orgid_pidTB.setPidlabel("ȱʡ���������˻��������");
				orgid_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_THREE);
				orgid_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgid_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgid_pidTB.getPdid()));
				ig007BL.registIG007Info(orgid_pidTB);

				IG007TB orgname_pidTB = new IG007TB();
				orgname_pidTB.setPdid(form.getPdid());
				orgname_pidTB.setPiddesc(approvors_orgname.toString());
				orgname_pidTB.setPidlabel("ȱʡ���������˻�������");
				orgname_pidTB.setPidname(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_THREE);
				orgname_pidTB.setPidtype(WorkFlowConstDefine.DEFAULT_PID_TYPE);
				orgname_pidTB.setPidid(this.ig007BL.getPididSequenceNextValue(orgname_pidTB.getPdid()));
				ig007BL.registIG007Info(orgname_pidTB);
			}
		}
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���ȱʡһ��������
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO clearApprovors_one(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		IG007Info upd_pid_roleid = null;
		IG007Info upd_pid_rolename = null;
		IG007Info upd_pid_userid = null;
		IG007Info upd_pid_username = null;
		IG007Info upd_pid_orgid = null;
		IG007Info upd_pid_orgname = null;
		//��ѯ�����������б���
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(form.getPdid());//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_ONE);
		List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
		for(IG007Info pid : list) {
			//һ������������
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_ONE, pid.getPidname())) {
				upd_pid_roleid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_ONE, pid.getPidname())) {
				upd_pid_rolename = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_ONE, pid.getPidname())) {
				upd_pid_userid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_ONE, pid.getPidname())) {
				upd_pid_username = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_ONE, pid.getPidname())) {
				upd_pid_orgid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_ONE, pid.getPidname())) {
				upd_pid_orgname = pid;
			}
		}
		if(upd_pid_roleid != null){
			ig007BL.deleteIG007InfoByKey(upd_pid_roleid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_rolename.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_userid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_username.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgname.getPidid());
			
		}
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ȱʡ����������
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO clearApprovors_two(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		IG007Info upd_pid_roleid = null;
		IG007Info upd_pid_rolename = null;
		IG007Info upd_pid_userid = null;
		IG007Info upd_pid_username = null;
		IG007Info upd_pid_orgid = null;
		IG007Info upd_pid_orgname = null;
		//��ѯ�����������б���
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(form.getPdid());//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_TWO);
		List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
		for(IG007Info pid : list) {
			//һ������������
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_TWO, pid.getPidname())) {
				upd_pid_roleid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_TWO, pid.getPidname())) {
				upd_pid_rolename = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_TWO, pid.getPidname())) {
				upd_pid_userid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_TWO, pid.getPidname())) {
				upd_pid_username = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_TWO, pid.getPidname())) {
				upd_pid_orgid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_TWO, pid.getPidname())) {
				upd_pid_orgname = pid;
			}
		}
		if(upd_pid_roleid != null){
			ig007BL.deleteIG007InfoByKey(upd_pid_roleid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_rolename.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_userid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_username.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgname.getPidid());
			
		}
		return dto;
	}
	/**
	 * <p>
	 * Description: ���ȱʡ����������
	 * </p>
	 * 
	 * @param dto IGPRM01DTO
	 * @return IGPRM01DTO
	 * @throws BLException
	 * @update liupeng@deliverik.com
	 */
	
	public IGPRM01DTO clearApprovors_three(IGPRM01DTO dto) throws BLException {
		IGPRM0304Form form = dto.getIgprm0304Form();
		IG007Info upd_pid_roleid = null;
		IG007Info upd_pid_rolename = null;
		IG007Info upd_pid_userid = null;
		IG007Info upd_pid_username = null;
		IG007Info upd_pid_orgid = null;
		IG007Info upd_pid_orgname = null;
		//��ѯ�����������б���
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(form.getPdid());//��������ID
		cond.setPidname_like(WorkFlowConstDefine.DEFAULT_APPROVOR_THREE);
		List<IG007Info> list = ig007BL.searchIG007Info(cond, 0, 0);
		for(IG007Info pid : list) {
			//һ������������
			if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLEID_THREE, pid.getPidname())) {
				upd_pid_roleid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ROLENAME_THREE, pid.getPidname())) {
				upd_pid_rolename = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERID_THREE, pid.getPidname())) {
				upd_pid_userid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_USERNAME_THREE, pid.getPidname())) {
				upd_pid_username = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGSYSCODING_THREE, pid.getPidname())) {
				upd_pid_orgid = pid;
			} else if(checkEqual(WorkFlowConstDefine.DEFAULT_APPROVOR_ORGNAME_THREE, pid.getPidname())) {
				upd_pid_orgname = pid;
			}
		}
		if(upd_pid_roleid != null){
			ig007BL.deleteIG007InfoByKey(upd_pid_roleid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_rolename.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_userid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_username.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgid.getPidid());
			
			ig007BL.deleteIG007InfoByKey(upd_pid_orgname.getPidid());
			
		}
		return dto;
	}
	
	/**
	 * <p>
	 * ��ȡ������ɫ
	 * </p>
	 * 
	 * @return ������ɫList
	 * @author liupeng@deliverik.com
	 */
	
	private Map<String,List<Role>> getApproveRoles(Map<String,List<IG337Info>> approvorsMap) {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.APPROVE_ROLE_TYPE);
		//��ȡ��ɫ�б�
		List<Role> roleList = roleBL.searchRole(cond, 0, 0);
		List<IG337Info> approvorsList = null;
		String key = null;
		Role role = null;
		Map<String,List<Role>> roleMap = new HashMap<String, List<Role>>();
		Set<Map.Entry<String, List<IG337Info>>> entrys = approvorsMap.entrySet();
		for(Map.Entry<String, List<IG337Info>> entry : entrys) {
			approvorsList = entry.getValue();
			key = entry.getKey();
			List<Role> list = new ArrayList<Role>(roleList);
			//����ȱʡ�����˽�ɫ����
			for(Iterator<Role> it = list.iterator(); it.hasNext();){
				role = it.next();
				if(approvorsList != null){
					for(IG337Info pp : approvorsList) {
						if(role.getRoleid().equals(pp.getPproleid())){
							it.remove();
							break;
						}
					}
				}
			}
			roleMap.put(key, list);
		}
		return roleMap;
	}
	
	/**
	 * <p>
	 * ��ȡ������ɫ
	 * </p>
	 * 
	 * @return ������ɫList
	 * @author liupeng@deliverik.com
	 */

	private List<Role> getApproveDispatcherRole(List<IG337Info> approveDispatcherList) {
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRoletype(WorkFlowConstDefine.APPROVE_ROLE_TYPE);
		//��ȡ��ɫ�б�
		List<Role> roleList = roleBL.searchRole(cond, 0, 0);
		Role role = null;
		//����ȱʡ���������˽�ɫ����
		for(Iterator<Role> it = roleList.iterator(); it.hasNext();){
			role = it.next();
			if(approveDispatcherList != null){
				for(IG337Info pp : approveDispatcherList) {
					if(role.getRoleid().equals(pp.getPproleid())){
						it.remove();
						break;
					}
				}
			}
		}
		return roleList;
	}
	
	/**
	 * check���
	 * @param left String ��null
	 * @param right String
	 * @return  boolean
	 */
	private boolean checkEqual(String left, String right) {
		return left.equals(right);
	}
	
}