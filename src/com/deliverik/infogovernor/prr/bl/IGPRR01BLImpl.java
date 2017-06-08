/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.bl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.TableFormColumnValueInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.ActionBL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.ActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.UserRoleVW;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowInitFormHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prd.model.entity.IG893VW;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG463TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561VW;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.prr.form.IGPRR0102Form;
import com.deliverik.infogovernor.prr.form.IGPRR0104Form;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.form.IGPRR0113Form;
import com.deliverik.infogovernor.prr.form.IGPRR0121Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01036VO;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.util.CodeDefine;
import com.dev.crc.igflow.event.status.IGFXK0402BLImpl;

/**
 * @Description: 流程驱动业务逻辑实现_业务连续性 drm
 * @Author  
 * @History 2010-9-13     新建 
 * 			2012-3-20	  新增  120320： 创意流程时，可以删除“提交”和“提交人确认”的附件
 * 			2012-3-30     新增  120330： 自定义流程根据配置控制主题、描述的显示
 * 			2012-4-06     新增  增加对私有变量的值保存到Ig007TB中
 * 			2013-01-08     新增 =20130108 按钮添加参与者
 * 			2013-02-25     新增  130225 流程机构相关修改
 * 			2015-04-02     新增  150402 流程新增判断当前登录人是否是当前流程模块的流程管理员
 * @Version V1.0
 */
public class IGPRR01BLImpl extends BaseBLImpl implements IGPRR01BL {

    static Log log = LogFactory.getLog(IGPRR01BLImpl.class);	
    
	
    // 二次开发log
    static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
    
	protected final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	
	protected final static DecimalFormat df = new DecimalFormat("0.0");
	
	// 1小时=60分钟=3600秒=3600000
	protected final static double hours = 60.0D * 60 * 1000;

	/** 附件信息BL */
	protected AttachmentBL attachmentBL;

	/** 机构信息BL */
	protected OrganizationBL organizationBL;
	
	/** 菜单BL */
	protected ActionBL actionBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	
	protected IGFXK0402BLImpl igfxk0402bl;
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**用户角色授权信息BL*/
	protected UserRoleBL userRoleBL;
	
	/**角色信息业务BL*/
	protected RoleBL roleBL;
	
	/** 用户操作 */
	protected UserBL userBL;
 
    /**CodeDetailBL*/
    protected CodeDetailBL codeDetailBL;
    
	/** 短信发送BL */
	protected SendMessageBL sendMessageBL;
	
	/** 附件BL */
	protected FileUploadBL fileUploadBL;
	
	/** 组合场景实例关系表BL */
	protected IG483BL ig483BL;
	
	/** 组合场景定义表表BL */
	protected IG480BL ig480BL;
	
	/**
	 * @param ig480bl the ig480BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * @param ig484bl the ig484BL to set
	 */
	public void setIg483BL(IG483BL ig483bl) {
		ig483BL = ig483bl;
	}

	/**
	 * 附件信息BL设定
	 * @param attachmentBL 附件信息BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	/**
	 * @return the igfxk0402bl
	 */
	public IGFXK0402BLImpl getIgfxk0402bl() {
		return igfxk0402bl;
	}



	/**
	 * @param igfxk0402bl the igfxk0402bl to set
	 */
	public void setIgfxk0402bl(IGFXK0402BLImpl igfxk0402bl) {
		this.igfxk0402bl = igfxk0402bl;
	}



	/**
	 * 机构信息BL设定
	 * @param organizationBL 机构信息BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	/**
	 * 短信发送BL设定
	 *
	 * @param sendMessageBL 短信发送BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
     * @param CodeDetailBL the codeDetailBL to set
     */
    public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
        this.codeDetailBL = codeDetailBL;
    }
    
	public void setActionBL(ActionBL actionBL) {
		this.actionBL = actionBL;
	}

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 用户角色BL设定
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 角色BL设定
	 * @param roleBL 角色BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * 用户BL设定
	 * @param userBL 用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 附件BL设定
	 * @param fileUploadBL 附件BL
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	/**
     * 当前流程类型启用版本的PDID取得处理（7位的PDID取得处理）
     *
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     */
    public IGPRR01DTO searchPdid7BitAction(IGPRR01DTO dto) throws BLException {
        log.debug("========当前流程类型启用版本的PDID取得处理开始========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(dto.getPdid());
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = this.workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(0).getPdid());
        }
        log.debug("========当前流程类型启用版本的PDID取得处理终了========");
        return dto;
    }
	
	/**
	 * 发起角色信息查询处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchInitProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException {
		
		log.debug("========发起角色信息查询处理开始========");
		List<LabelValueBean> roleList = this.workFlowDefinitionBL.searchInitProcessParticipantRole(dto.getUser().getUserid(), dto.getPdid());
		if(roleList.isEmpty()) {
			throw new BLException("IGCO10000.E004","发起角色基本");
		}
		dto.setLabelList(roleList);
		log.debug("========发起角色信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 根据操作人角色ID、流程状态等查询对应的流程参与者的动作及变量权限的相关信息
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	private IGPRR01DTO searchProcessParticipantDefByRoleAndProcessStatusAction(IGPRR01DTO dto) throws BLException {
		log.debug("========查询对应的流程参与者的动作及变量权限处理开始========");
		String psdid = dto.getPsdid();//流程状态ID
		Integer roleid = dto.getRoleid();
		boolean flag = true;
		if(StringUtils.isNotEmpty(psdid) && dto.getLabelList() != null && dto.getLabelList().size() > 0){
			//设定参与者变量权限
			if(roleid!=null){
				for(int i=0,j=dto.getLabelList().size();i<j;i++){
					//发起
					if(dto.getIgPRR0101Form() != null) {
						if(roleid.toString().equals(dto.getLabelList().get(i).getValue())){
							flag = false;
							break;
						}
					} else {//处理
						if(roleid.toString().equals(dto.getLabelList().get(i).getValue().split("_")[1])){
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag){
				//发起
				if(dto.getIgPRR0101Form() != null) {
					roleid = Integer.parseInt(dto.getLabelList().get(0).getValue());
				} else {//处理
					roleid = Integer.parseInt(dto.getLabelList().get(0).getValue().split("_")[1]);
				}
			}
			List<IG893Info> participantVariableVW = null;
			if(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
				participantVariableVW = this.workFlowOperationBL.searchParticipantMaxVariableVW(psdid, roleid,dto.getLs_proStatusParticipantMap());
			}else{
				participantVariableVW = this.workFlowOperationBL.searchParticipantVariableVW(psdid,roleid);
			}
			dto.setParticipantVariableVWList(participantVariableVW);
			//参与者可视按钮取得
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
					this.workFlowDefinitionBL.searchVisibleButton(dto.getPsdid(), roleid);
			
			dto.setLst_ParticipantVisibleButtonVWInfo(lst_ParticipantVisibleButtonVWInfo);
		} else {
			if(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
				dto.setParticipantVariableVWList(this.workFlowOperationBL.searchParticipantMaxVariableVW(psdid, roleid,dto.getLs_proStatusParticipantMap()));
			}else{
				dto = getNotCurrentFormAccessPower(dto);
			}
		}

		log.debug("========查询对应的流程参与者的动作及变量权限处理终了========");
		return dto;
	}
	
	/**
	 * 流程状态表单值初始化处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	@SuppressWarnings("unchecked")
	private IGPRR01DTO searchProcessVariableAction(IGPRR01DTO dto) throws BLException {
		log.debug("========流程状态表单值初始化处理开始========");
		//取得该流程状态的前处理的信息集合
		IG373SearchCondImpl cond = new IG373SearchCondImpl();
		cond.setPsdid(dto.getPsdid());
		List<IG373Info> lst_IG373 = this.workFlowDefinitionBL.searchInitFormEventHandler(cond);
		//流程状态表单值初始化处理BL
		WorkFlowInitFormHandlerBL initBL = null;
		Map<String, Object> map_Value = null;
		if(lst_IG373.size() > 0) {
		    String strPrserialnum = "";
		    if (igflowlog.isDebugEnabled()) {
		        if (dto.getProcessStatusDef() != null) {
		            strPrserialnum = dto.getProcess().getPrserialnum();
		        }
		    }
		    igflowlog.debug("========================" + strPrserialnum  + "表单初始化事件开始========================");
		    igflowlog.debug("流程类型ID："+dto.getWorkFlowParameterInfo().getPdid());
		    igflowlog.debug("流程状态："+(dto.getProcessStatusDef() == null ? "发起(Z)" : dto.getProcessStatusDef().getPsdname()));
            igflowlog.debug("流程ID："+dto.getWorkFlowParameterInfo().getParprid());
            igflowlog.debug("资产ID："+dto.getWorkFlowParameterInfo().getEiid());
            igflowlog.debug("参数："+dto.getWorkFlowParameterInfo().getParameters());
			for(IG373Info ig373 : lst_IG373) {
				try {
					initBL = (WorkFlowInitFormHandlerBL)WebApplicationSupport.getBean(ig373.getPiidblid());
				} catch (Exception e) {
					throw new BLException("IGCO10000.E004", "表单初始化事件定义");
				}
				igflowlog.debug("调用BL:" +ig373.getPiidblid());
				map_Value = initBL.initForm(dto.getWorkFlowParameterInfo());
			}
			igflowlog.debug("========================" + strPrserialnum  + "表单初始化事件结束========================");
		}
		Map<String, Object> initTableFormValueMap = new HashMap<String, Object>();
		if(map_Value != null){
			//取得表格式表单的定义信息
			Map<String, List<IG007Info>> columnInfoMap = dto.getColumnInfoMap();
			Map<String, IG007Info> fullNameMap = new HashMap<String, IG007Info>();
			if(columnInfoMap != null){
				Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
				Set<Entry<String,List<IG007Info>>> entrySet = columnInfoMap.entrySet();
				for(Iterator<Entry<String, List<IG007Info>>> iterator = entrySet.iterator();iterator.hasNext();){
					Entry<String, List<IG007Info>> entry = iterator.next();
					List<IG007Info> list = entry.getValue();
					if(list != null){
						for(IG007Info pid:list){
							pidMap.put(pid.getPidid(), pid);
						}
					}
				}
				for(Iterator<Entry<String, List<IG007Info>>> iterator = entrySet.iterator();iterator.hasNext();){
					Entry<String, List<IG007Info>> entry = iterator.next();
					List<IG007Info> list = entry.getValue();
					if(list != null){
						for(IG007Info pid:list){
							IG007Info cpid = pid;
							String fullName = cpid.getPidname();
							while(StringUtils.isNotEmpty(cpid.getPpidid())){
								cpid = pidMap.get(cpid.getPpidid());
								fullName = cpid.getPidname() + "#" + fullName;
							}
							fullNameMap.put(fullName, pid);
						}
					}
				}
			}
			Set<Entry<String, Object>> set = map_Value.entrySet();
			for(Iterator<Entry<String, Object>> iter = set.iterator();iter.hasNext();){
				Entry<String, Object> entry = iter.next();
				Object value = entry.getValue();
				if(value != null){
					if(value instanceof java.util.List){
						List<TableFormColumnValueInfo> initTableValueInfos = (List<TableFormColumnValueInfo>) value;
						if(initTableValueInfos != null){
							List<IG898Info> tableColumnValueList = new ArrayList<IG898Info>(initTableValueInfos.size());
							for(TableFormColumnValueInfo tv:initTableValueInfos){
								IG007Info pid = fullNameMap.get(tv.getFullName());
								if(pid != null){
									IG898TB pv = new IG898TB();
									pv.setPvrownumber(tv.getRownumber());
									pv.setPvalue(tv.getValue());
									pv.setPidid(pid.getPpidid());
									pv.setPvcolpidid(pid.getPidid());
									tableColumnValueList.add(pv);
								}
								
							}
							Map<String, Map<String, Map<String, String>>> valueMap = new HashMap<String, Map<String,Map<String,String>>>();
							for(IG898Info pv:tableColumnValueList){
								if(valueMap.get(pv.getPidid()) == null){
									Map<String, String> one = new HashMap<String, String>();
									one.put(pv.getPvcolpidid(), pv.getPvalue());
									Map<String, Map<String, String>> two = new LinkedHashMap<String, Map<String,String>>();
									two.put(pv.getPvrownumber(), one);
									valueMap.put(pv.getPidid(), two);
								}else{
									if(valueMap.get(pv.getPidid()).get(pv.getPvrownumber()) == null){
										Map<String, String> one = new HashMap<String, String>();
										one.put(pv.getPvcolpidid(), pv.getPvalue());
										valueMap.get(pv.getPidid()).put(pv.getPvrownumber(), one);
									}else{
										valueMap.get(pv.getPidid()).get(pv.getPvrownumber()).put(pv.getPvcolpidid(), pv.getPvalue());
									}
								}
							}
							initTableFormValueMap.put(entry.getKey(), valueMap);
						}
					}else{
						initTableFormValueMap.put(entry.getKey(), value);
					}
				}
			}
		}
		dto.setInitFormValueMap(initTableFormValueMap);
		log.debug("========流程状态表单值初始化处理终了========");
		return dto;
	}
	
	/**
	 * 取参与者变量权限信息集合与前处理变量信息集合的交集,交集中的元素要按照前处理中对变量的设置进行赋值
	 */
	private IGPRR01DTO setVarAccess(List<IG007Info> processInfoDefList,IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = new ArrayList<IG007Info>();//保存流程权限变量与表单信息的交集
		List<IG007Info> notinvarList = new ArrayList<IG007Info>();//保存不在流程权限变量中的表单信息
		if(processInfoDefList!=null){
			List<IG893Info> participantVariableVWList = dto.getParticipantVariableVWList();
			for(int i=0,j=processInfoDefList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(processInfoDefList.get(i));
				boolean flag = true;
				if(participantVariableVWList != null){
					for(int n=0,m = participantVariableVWList.size();n<m;n++){
						IG893Info pipd = participantVariableVWList.get(n);
						//判断表单信息是否在流程参与者权限变量集合中
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidaccess(pipd.getPidaccess());
							pid.setPidrequired(pipd.getPidrequired());
							//add by wanglongyu 20120406 增加设置私有变量权限
							//pid.setPrivateaccess(pipd.getPrivateAccess());
							varList.add(pid);
							flag = false;
							break;
						}
					}
				}
				if(flag){
					pid.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE);
					//add by wanglongyu 20120406 增加设置私有变量权限
					//pid.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_HIDE);
					notinvarList.add(pid);
				}
			}
		}
		

		dto.setVarList(varList);
		dto.setNotinvarList(notinvarList);
		return dto;
	}
	
	/**
	 * 将varList、notinvarList与前处理的变量信息集合比较，将存在于前处理变量信息集合中的变量按照前处理中的设置进行赋值
	 */
	private IGPRR01DTO setVarValue(IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = dto.getVarList();//保存流程权限变量与表单信息的交集
		List<IG007Info> notinvarList = dto.getNotinvarList();//保存不在流程权限变量中的表单信息
		Map<String, Object> initFormValueMap = dto.getInitFormValueMap(); //表单初始化操作中的表单值
		Map<String, IG007Info> variableObjectmap = new LinkedHashMap<String, IG007Info>();
		if(varList!=null){
			for(IG007Info pidInfo:varList){
				IG007TB pid = (IG007TB)SerializationUtils.clone(pidInfo);
				if(initFormValueMap != null && initFormValueMap.get(pid.getPidname()) != null){
					if("8".equals(pid.getPidtype())){
						setTableColumnValue(dto,initFormValueMap.get(pid.getPidname()));
					}else{
						String value = (String) initFormValueMap.get(pid.getPidname());
						pid.setPidvalue(value);
					}
				}
				variableObjectmap.put(pid.getPidid(), pid);
			}
		}
		
		if(notinvarList!=null){
			for(IG007Info pidInfo:notinvarList){
				IG007TB pid = (IG007TB)SerializationUtils.clone(pidInfo);
				if(initFormValueMap != null && initFormValueMap.get(pid.getPidname()) != null){
					if("8".equals(pid.getPidtype())){
						setTableColumnValue(dto,initFormValueMap.get(pid.getPidname()));
					}else{
						String value = (String) initFormValueMap.get(pid.getPidname());
						pid.setPidvalue(value);
					}
				}
				variableObjectmap.put(pid.getPidid(), pid);
			}
		}

		dto.setProcessInfoDefmap(variableObjectmap);
		return dto;
	}
	
	/**
	 * 设置表格式表单值
	 * @param dto
	 * @param value
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private IGPRR01DTO setTableColumnValue(IGPRR01DTO dto,Object value){
		Map<String, Map<String, Map<String, String>>> tableColumnValueMap = dto.getTableColumnValueMap();
		if(value != null && value instanceof java.util.Map){
			Map<String, Map<String, Map<String, String>>> valueMap = (Map<String, Map<String, Map<String, String>>>) value;
			if(tableColumnValueMap == null || tableColumnValueMap.size() == 0){
				tableColumnValueMap = valueMap;
			}else{
				Set<Entry<String, Map<String, Map<String, String>>>> set = valueMap.entrySet();
				for(Iterator<Entry<String, Map<String, Map<String, String>>>> iter = set.iterator();iter.hasNext();){
					Entry<String, Map<String, Map<String, String>>> next = iter.next();
					String key = next.getKey();
					Map<String, Map<String, String>> map = next.getValue();
					if(tableColumnValueMap.get(key) == null){
						tableColumnValueMap.put(key, map);
					}else{
						Set<Entry<String,Map<String,String>>> set2 = map.entrySet();
						for(Iterator<Entry<String, Map<String, String>>> iter2 = set2.iterator();iter2.hasNext();){
							Entry<String, Map<String, String>> next2 = iter2.next();
							String key2 = next2.getKey();
							Map<String, String> map2 = next2.getValue();
							if(tableColumnValueMap.get(key).get(key2) == null){
								tableColumnValueMap.get(key).put(key2, map2);
							}else{
								Set<Entry<String,String>> set3 = map2.entrySet();
								for(Iterator<Entry<String, String>> iter3 = set3.iterator();iter3.hasNext();){
									Entry<String, String> next3 = iter3.next();
									String key3 = next3.getKey();
									String value3 = next3.getValue();
									tableColumnValueMap.get(key).get(key2).put(key3, value3);
								}
							}
						}
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		return dto;
	}
	
	
	/**
	 * 页面初始化并确定该参与者在页面中可以进行的操作
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionListForInit(IGPRR01DTO dto) throws BLException {
		log.debug("=======页面初始化处理开始========");
		String pdid = dto.getPdid();//流程定义ID
		//查询流程类型名称
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
		
		dto.getIgPRR0101Form().setPrpdname(pd.getPdname());
		
		//当前流程定义是否为测试状态
		if(pd!=null && IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(pd.getPdstatus())){
			dto.getIgPRR0101Form().setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
		}
		
		//根据操作人角色ID、流程状态等查询对应的流程参与者的动作及变量权限的相关信息
		dto = searchProcessParticipantDefByRoleAndProcessStatusAction(dto);
		//查询指定状态前处理相关信息处理
		dto = searchProcessVariableAction(dto);
		//查询表单信息集合
		List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(pdid);
		//取参与者变量权限信息集合与前处理集合中变量的交集,交集中的元素要被授予前处理选中的变量的值
		dto = setVarAccess(processInfoDefList,dto);
		//将varList、notinvarList与前处理的变量集合比较，将存在于前处理中的变量按照前处理中设置的值进行赋值(设置变量值)
		dto = setVarValue(dto);
		
		log.debug("========页面初始化处理终了========");
		return dto;
	}
	
	/**
	 * 流程发起页面初始化
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0101Action(IGPRR01DTO dto) throws BLException {
		//获取发起form
		IGPRR0101Form form = dto.getIgPRR0101Form();
		//获取用户
		User user = dto.getUser();
		//获取发起角色列表
		searchInitProcessParticipantRoleAction(dto);
		searchProcessTitleDef(dto);
		//设定流程基本信息
		String orgname = "";
		form.setPrinfo(user.getUsermobile());
		form.setPruserid(user.getUserid());
		form.setPrusername(user.getUsername());
		form.setProrgid(user.getOrgid());
		//初始化表格类表单
		dto.setColumnInfoMap(workFlowOperationBL.initTableFormAction(dto.getPdid()));
		//查询上一级机构 
		if(user.getOrgid().length()>4){
			String orgpar = user.getOrgid().subSequence(0, user.getOrgid().length()-3).toString();
			OrganizationSearchCondImpl condImpl = new OrganizationSearchCondImpl();
			condImpl.setOrgsyscoding(orgpar);
			List<Organization> searchOrganization = organizationBL.searchOrganization(condImpl);
			if(searchOrganization !=null && searchOrganization.size()>0){
				orgname = searchOrganization.get(0).getOrgname()+"—"+user.getOrgname();
			}
			
		}else{
			orgname = user.getOrgname();
		}
		form.setProrgname(orgname);
		//设定发起状态ID
		IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
		psdcond.setPdid(dto.getPdid());
		psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
		psdcond.setFatherflag("Y");
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
		if(psdList.isEmpty()){
			throw new BLException("IGFLOW0000.E001","状态定义信息");
		}else if(psdList.size() > 1){
			throw new BLException("IGFLOW0000.E002","状态定义信息");
		}
		dto.setProcessStatusDef(psdList.get(0));
		dto.setPsdid(psdList.get(0).getPsdid());
		form.setPsdid(dto.getPsdid());
		//获取发起按钮列表
		getActionListForInit(dto);
		//获取机构下拉列表值
		getOrgLabelValueBeans(dto);
		//获取状态级私有表单值
		getStatusPrivateValue(dto);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 发起流程 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public synchronized IGPRR01DTO createProcessAction(IGPRR01DTO dto) throws BLException {
		log.debug("========流程发起处理开始========");
		// 流程发起Form
		IGPRR0101Form form = dto.getIgPRR0101Form();
		User user = dto.getUser();
		//判断roleid是否是流程管理员，如果是则查找用户其他角色，并且赋值,因为在变更批量处理的时候报错，所以需要更改。2017年5月23日10:48:19 张博
		System.out.println(form.getPrpdid());
		if("2".equals(form.getPrroleid())&&"01084".equals(form.getPrpdid().substring(0, form.getPrpdid().length()-2))){
			//查询不是流程管理员角色并更改form中的值
			List<UserRoleInfo> userRoles = userRoleBL.getUserRolesNotInProcess(user.getUserid());
			//查询发起节点的处理角色
			IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
			ig222Cond.setPsdid(form.getPsdid());
			IG222BL ig222BL = (IG222BL) WebApplicationSupport.getBean("ig222BL");
			List<IG222Info> ig222InfoList = ig222BL.searchIG222Info(ig222Cond);
			if(ig222InfoList!=null && ig222InfoList.size()>0&&userRoles!=null && userRoles.size()>0){
				for(IG222Info ig222Info:ig222InfoList){
					for(UserRoleInfo userRoleInfo:userRoles){
						if(ig222Info.getRoleid()==userRoleInfo.getRoleid()){
							form.setPrroleid(userRoleInfo.getRoleid());
							form.setPrrolename(userRoleInfo.getRolename());
							break;
						}
					}
				}
			}
		}
		//查询流程表单定义
		List<IG007Info> prinfoDefList = workFlowDefinitionBL.searchProcessInfoDefsByPdid(form.getPrpdid());
		Map<String, IG007Info> prinfoMap = new HashMap<String, IG007Info>();
		for(IG007Info info : prinfoDefList){
			prinfoMap.put(info.getPidid(), info);
		}
		//添加流程变量信息
		List<IG599Info> prInfoList = new ArrayList<IG599Info>();	
		// 表单对应多资产MAP
		if(form.getPivarvalue() != null){
			for(int i=0;i<form.getPivarvalue().length;i++){
				IG599TB prInfo = workFlowOperationBL.getProcessInfoTBInstance();
				prInfo.setPivarlabel(form.getPivarlabel()[i]);
				prInfo.setPivarname(form.getPivarname()[i]);
				prInfo.setPivartype(form.getPivartype()[i]);
				prInfo.setPivarvalue(form.getPivarvalue()[i]);
				prInfo.setPidid(form.getPidid()[i]);
				prInfo.setPidmode(form.getPidmode()[i]);
				prInfo.setPidaccess(form.getPidaccess()[i]);
				prInfo.setPrivatescope(form.getPrivatescope()[i]);
				if(form.getPidcomment() != null && form.getPidcomment().length > i){
					prInfo.setPidcomment(form.getPidcomment()[i]);
				}
				if("F".equals(form.getPivartype()[i])){
					IG007Info def = prinfoMap.get(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(def.getPiddefault())){
						List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(def.getPiddefault());
						List<Attachment> attList = new ArrayList<Attachment>();
						for(Attachment att:list){
							boolean flag = true;
							if(StringUtils.isNotEmpty(form.getDelFileMutiStr())){
								for(String defFile:form.getDelFileMutiStr().split("#")){
									if((att.getAttid() + "").equals(defFile.split("_")[0])){
										flag = false;
										break;
									}
								}
							}
							if(flag){
								attList.add(att);
							}
						}
						if(attList.size() > 0){
							String key = IGStringUtils.getAttKey();
							for(Attachment att:attList){
								StringBuffer rfilename = new StringBuffer();
								rfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
								rfilename.append(File.separator);
								rfilename.append(att.getAtturl());
								rfilename.append(File.separator);
								rfilename.append(att.getAttname());
								StringBuffer cfilename = new StringBuffer();
								cfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
								cfilename.append(File.separator);
								cfilename.append(att.getAtturl());
								cfilename.append(File.separator);
								cfilename.append(key);
								cfilename.append("_");
								cfilename.append(att.getAttname().substring(att.getAttname().indexOf("_") + 1));
								try{
									FileUtils.copyFile(new File(rfilename.toString()), new File(cfilename.toString()));
								}catch (Exception e) {
									log.error("",e);
								}
								AttachmentTB attTB = new AttachmentTB();
								attTB.setAttkey(key);
								attTB.setAttname(key + "_" + att.getAttname().substring(att.getAttname().indexOf("_") + 1));
								attTB.setAtturl(att.getAtturl());
								attachmentBL.registAttachment(attTB);
							}
							prInfo.setPiattkey(key);
						}
					}
				}
				if("4".equals(form.getPivartype()[i])){
					IG007Info def = prinfoMap.get(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(def.getPiddefault())){
						String pieids = form.getPieids();
						Set<String> set = new HashSet<String>();
						if(StringUtils.isNotEmpty(pieids)){
							for(String s:pieids.split("#")){
								set.add(s.replaceAll("EIID", ""));
							}
						}
						String eiids = def.getPiddefault();
						Map<Integer, String> map = form.getEntityMap();
						int index = 0;
						for(Integer n:map.keySet()){
							if(n>index){
								index = n;
							}
						}
						for(String s:eiids.split("#")){
							if(!set.contains(s)){
								index ++;
								map.put(index, prInfo.getPidid()+"#"+s+"#"+"1");
							}
						}
						form.setEntityMap(map);
					}
				}
				prInfoList.add(prInfo);
			}
		}
		
		//表单绑定附件MAP处理================================================================
		Map<String,FormFile> fileMapMuti=new LinkedHashMap<String,FormFile>();
		if((form.getAtt() != null) &&(form.getFileMapMuti() != null)){
			for(int i=0;i<form.getAtt().length;i++){
				String[] sp=(form.getAtt())[i].split("_");
				if(form.getFileMapMuti().get(Integer.parseInt(sp[1]))!=null){
				fileMapMuti.put((form.getAtt())[i], form.getFileMapMuti().get(Integer.parseInt(sp[1])));
				}
			}
		}	
		Map<String,List<Attachment>> copyMap=new LinkedHashMap<String,List<Attachment>>();
		
		//封装表格式表单值信息
		Map<String, Object> tableFormValueMap = new HashMap<String, Object>();
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_VALUE, form.getColumn_value());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_ROWNUMBER, form.getColumn_rownumber());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_PIDID, form.getColumn_pidid());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE, form.getFileMapTable());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_ADD_FLAG, form.getAddTableColumnFileStr());
		tableFormValueMap.put(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG, form.getDelTableColumnFileStr());
		//封装人员表单信息
		Map<String, List<IG506TB>> participantFormInfo = packingParticipantList(form.getPar_userid(), form.getPar_username(), form.getPar_orgid(), form.getPar_orgname(), form.getPar_roleid(), form.getPar_rolename(), form.getPar_pidid(),form.getPar_phone());
		IG500Info processRecord = workFlowOperationBL.launchProcess(form,user,form.getPrroleid(),form.getFileMap(),fileMapMuti,form.getPts(),
				prInfoList,form.getRlcomment(),form.getPsdid(),form.getAction(),copyMap, dto.getAuthorizeuser(),form.getEntityMap(),tableFormValueMap,participantFormInfo,form.getIsServiceStart(),form.getParprid());
		dto.setProcess(processRecord);
		// 获得流程记录ID
		Integer prid = processRecord.getPrid();
		dto.setPrid(prid);
		
		if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(processRecord.getPrstatus())) {
			//查询该状态可进行分派的节点列表
			List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(),form.getAction());
			if((lst_ProcessStatusDef!=null) && (lst_ProcessStatusDef.size()>0)) {
				dto.setAssignParticipant(false);
			}
		}
		if(form.getAction() != null && form.getAction().compareTo("10") >= 0){
			dto.addMessage(new ActionMessage("IGPRR0101.I001"));
		}else{
			dto.addMessage(new ActionMessage("IGPRR0101.I002"));
		}
		log.debug("========流程发起处理终了========");
		return dto;
	}

	
	//======================================处理==================================================

	/**
	 * 比较时间
	 * 
	 * @param timeA
	 * @param timeB
	 * @return int
	 */
	private String getBetweenTimeNumber(String timeA, String timeB) throws Exception {
		// long time= 24L * 60L * 60L * 1000L;计算天数之差
		Date d1 = sdf.parse(timeA);
		Date d2 = sdf.parse(timeB);
		return df.format((d2.getTime() - d1.getTime()) / hours).replace(".0", "");
	}
	
	/**
	 * <p>
	 * Description: 获取工作基本信息
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public IGPRR01DTO getProcessRecord(IGPRR01DTO dto) throws BLException {
		log.debug("========获取工作基本信息处理开始========");
		IG500SearchCondImpl prCond = new IG500SearchCondImpl();
		prCond.setPrid(dto.getPrid());
		prCond.setPrserialnum(dto.getSerialNum());
		List<IG500Info> prList = workFlowOperationBL.searchProcessRecord(prCond);
		IG500Info process = prList.get(0);
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(form == null){
			form = new IGPRR0102Form();
		}
		form.setPrid(process.getPrid());
		dto.setPrid(process.getPrid());
//		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
	    List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(process.getPrid());
	
		//获取当前流程所有相关资产及动态资产表单信息
		List<IG731Info> processInfoEntityList = workFlowOperationBL.searchProcessInfoEntityByPrid(process.getPrid());
		dto.setProcessInfoEntityList(processInfoEntityList);
		dto.setProcessInfo(processInfolist);
		
		Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
		for(int i=0;i<processInfolist.size();i++){
			if(processInfolist.get(i).getPiattkey()!=null){
				//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
				List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
				map.put(processInfolist.get(i).getPivarname(), list);
			}
			//私有变量附件
			List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
			if(privateInfoList != null){
				for(int j=0; j<privateInfoList.size();j++){
					if(privateInfoList.get(j).getPpiattkey()!=null){
						List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
						if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
							map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
						}else{
							map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
						}
					}
				}
			}
//		recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
		}
		dto.setTextAreaMap(map);
		dto.setPdid(process.getPrpdid());
		dto.setProcess(process);
		
		//以下是设定当前流程状态对应的psdid
		//查找当前所处流程状态的ID
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(process.getPrpdid());
		//中止状态等同于关闭
		if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(process.getPrstatus())
				||IGPRDCONSTANTS.PROCESS_END_STATUS.equals(process.getPrstatus()) ) {
			cond.setPsdcode(IGPRDCONSTANTS.PROCESS_END_STATUS);
		} else {
			//页面没指定状态时，默认取第一个当前状态
			if(dto.getIgPRR0102Form() == null || StringUtils.isEmpty(dto.getIgPRR0102Form().getPrstatus())) {
				List<String>  lst_status = this.workFlowOperationBL.searchCurrentRecordStatus(process.getPrid());
				if(lst_status.isEmpty()) {
					cond.setPsdcode(process.getPrstatus());
				} else {
					String psdid_num = this.workFlowOperationBL.searchCurrentRecordStatus(process.getPrid()).get(0);
					if (psdid_num.indexOf("_") > -1) {
						cond.setPsdid(psdid_num.split("_")[0]);
					} else {
						cond.setPsdid(psdid_num);
					}
				}
			} else {
				//页面指定了状态
				String psdid_num = dto.getIgPRR0102Form().getPrstatus();
				if (psdid_num.length() == 1) {
					cond.setPsdcode(psdid_num);
				} else if (psdid_num.indexOf("_") > -1) {
					cond.setPsdid(psdid_num.split("_")[0]);
				} else {
					cond.setPsdid(psdid_num);
				}
//				cond.setPsdid(dto.getIgPRR0102Form().getPrstatus());
			}
		}
		List<IG333Info> pslist = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(pslist!=null && pslist.size()==1){
			dto.setPsdid(pslist.get(0).getPsdid());
		}
		
		log.debug("========获取工作基本信息处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 获取指定状态的参与者
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getProcessParticipantsByStatus(IGPRR01DTO dto) throws BLException {
		log.debug("========获取指定状态的参与者处理开始========");
		String status = dto.getStatus();

		List<IG337Info> pplist = new ArrayList<IG337Info>();
		if (status == null) {
			pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), dto.getProcess().getPrstatus());
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(dto.getPrid());
			if (dto.getStatus().indexOf("_") > -1) {
				ppCond.setPsdid(dto.getStatus().split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
			} else {
				ppCond.setPsdid(dto.getStatus());
			}
			pplist = workFlowOperationBL.searchProcessParticipants(ppCond);
		}
		
		if(pplist.isEmpty() && !"C".equals(status)){
			//throw new BLException("IGCO10000.E004","参与者基本");
			dto.setStatus("");
		} else {
			//状态参与者处理
			dto = this.getProcessParticipants(dto,pplist);
		}
		log.debug("========获取指定状态的参与者处理终了========");
		return dto;
	}
	private IGPRR01DTO getProcessParticipants(IGPRR01DTO dto,List<IG337Info> pplist ) {
		// 已执行人列表
		List<IG337Info> l1 = new ArrayList<IG337Info>();
		// 未执行人列表
		List<IG337Info> l2 = new ArrayList<IG337Info>();
		// 已执行人员分组
		Map<String, List<IG337Info>> m1 = new LinkedHashMap<String, List<IG337Info>>();
		// 未执行人员分组
		Map<String, List<IG337Info>> m2 = new LinkedHashMap<String, List<IG337Info>>();
		// 参与人员客串
		String comment = "";
		comment = this.appendLogTitleCssBegin(comment);
		// 对执行类型分组
		for (IG337Info pp : pplist) {
			// 未执行人列表初始化
			if (StringUtils.isEmpty(pp.getPpproctime())) {
				l2.add(pp);
			}
			// 已执行人列表初始化
			if (!StringUtils.isEmpty(pp.getPpproctime())) {
				l1.add(pp);
			}

			
			//====>130225Begin 判断当前处理机构中是否包含未授权值班人
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getPsdassign())){
				if(StringUtils.isEmpty(pp.getPpproctime()) && pp.getPporgid().equals(dto.getPporgid())
						&& IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
						&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp
								.getPpsubstatus())){
					dto.setHasDutyPerson(true);
				}
			}else{
			//====>130225End	
				// 判断当前处理角色是否包含未授权值班人
				if (pp.getPproleid().equals(dto.getRoleid())
						&& IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
						&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp
								.getPpsubstatus())) {
					dto.setHasDutyPerson(true);
				}
			}

		}
		
		//====>130225Begin 页面显示参与人修改
		if(dto.getProcessStatusDef()!= null){
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
				// 对已执行人员按部门分组
				for (IG337Info pp : l1) {
					if (m1.get(pp.getPporgname()) == null) {
						// 该部门不存在时的操作
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m1.put(pp.getPporgname(), l);

					} else {
						// 该部门已存在时的操作
						m1.get(pp.getPporgname()).add(pp);
					}
				}
				// 对未执行人员按部门分组
				for (IG337Info pp : l2) {

					if (m2.get(pp.getPporgname()) == null) {
						// 该部门不存在时的操
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m2.put(pp.getPporgname(), l);

					} else {
						// 该部门已存在时的操作
						m2.get(pp.getPporgname()).add(pp);
					}
				}
			}else{
				// 对已执行人员按部门分组
				for (IG337Info pp : l1) {

					if (m1.get(pp.getPprolename()) == null) {
						// 该部门不存在时的操作
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m1.put(pp.getPprolename(), l);

					} else {
						// 该部门已存在时的操作
						m1.get(pp.getPprolename()).add(pp);
					}
				}
				// 对未执行人员按部门分组
				for (IG337Info pp : l2) {

					if (m2.get(pp.getPprolename()) == null) {
						// 该部门不存在时的操
						List<IG337Info> l = new ArrayList<IG337Info>();
						l.add(pp);
						m2.put(pp.getPprolename(), l);

					} else {
						// 该部门已存在时的操作
						m2.get(pp.getPprolename()).add(pp);
					}
				}
			}
		}
		//====>130225End

		// 对已执行人员进行字符串拼接
		if (null != m1 && m1.size() > 0) {
			// 已执行处理人不为空时处理
			comment = "已处理：";
			for (String org : m1.keySet()) {

				// List<ProcessParticipant> res = m1.get(org);
				comment = comment + org + "（";
				for (IG337Info pp : m1.get(org)) {
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "未指定":pp.getPpusername();
					comment = comment + name + "、";
				}
				// 对拼接时多出的标点丢弃处理
				comment = comment.substring(0, comment.length() - 1);
				comment = comment + "）,";

			}
			// 对拼接时多出的标点丢弃处理
			comment = comment.substring(0, comment.length() - 1);
		}
		// 对未执行人员进行字符串拼接
		comment = comment + "</br>未处理：";
		if (null != m2 && m2.size() > 0) {
			// 未执行处理人不为空时的处理
			for (String org : m2.keySet()) {

				comment = comment + org + "（";
				for (IG337Info pp : m2.get(org)) {
					String name = StringUtils.isEmpty(pp.getPpusername()) ? "未指定":pp.getPpusername();
					comment = comment + name + "、";
				}
				// 对拼接时多出的标点丢弃处理
				comment = comment.substring(0, comment.length() - 1);
				comment = comment + "）,";

			}
			// 对拼接时多出的标点丢弃处理
			comment = comment.substring(0, comment.length() - 1);
		}
		comment = comment.replace("（null）", "（未指定）") + "</span>";

		dto.setStatus(comment.replaceAll(",", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"));
		return dto;
	}
	/**
	 * <p>
	 * 记录日志标题式样拼接开始，暂时是记录人员信息时调用
	 * </p>
	 * 
	 * @param massage 日志描述信息
	 * @return 含有HTML标签的日志描述信息
	 */

	private String appendLogTitleCssBegin(String massage) {
		return massage + "<span>";
	}
	/**
	 * <p>
	 * 记录人员日志内容拼接，暂时记录人员信息时调用
	 * </p>
	 * 
	 * @param rolename 角色名称
	 * @param username 用户名称
	 * @return 含有HTML标签的日志描述信息，已", "结尾，需去掉末尾巴两位
	 */

	@SuppressWarnings("unused")
	private String appendLogContent(String rolename, String username) {
		String str ="";
		if("已处理".equals(username)||"未处理".equals(username)){
			str = rolename+ "(" + username + ")"+ ", ";
		}else{
			str = rolename+ (StringUtils.isEmpty(username) ? ", " : "(" + username + ")"+ ", ");
			
		}
		return str;
	}
	/**
	 * <p>
	 * 记录日志标题式样拼接结束，暂时是记录人员信息时调用
	 * </p>
	 * 
	 * @param massage 日志描述信息
	 * @return 含有HTML标签的日志描述信息
	 */

	@SuppressWarnings("unused")
	private String appendLogTitleCssEnd(String massage) {
		massage=massage.substring(0, massage.length() - 2);
		return massage + "</span>";
	}
	
	/**
	 * <p>
	 * Description: 获取表单日志记录
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getVarRecordLogs(IGPRR01DTO dto) throws BLException {
		
		List<IG113Info> list = workFlowOperationBL.searchRecordLogVarInfoByRecordId(dto.getRlid());
		
		dto.setVarLogList(list);
		
		return dto;
	}

	/**
	 * <p>
	 * Description: 获取历史记录 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getRecordLogs(IGPRR01DTO dto) throws BLException {
		log.debug("========获取历史记录处理开始========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","工作基本");
		}
		//处理类日志
		String cl_tab = IGPRDCONSTANTS.RECORDLOG_TYPE_CL_NAME;
		
		//系统类日志
		String xtrz_tab = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ_NAME;
		
		//<流程日志类型，流程日志信息>
		Map<String,List<IG036Info>> map = new LinkedHashMap<String,List<IG036Info>>();
		
		List<IG036Info> recordLogList = null;
		//根据流程日志权限查询流程日志
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pr.getPrpdid());
		
		if(IGPRDCONSTANTS.RECORDLOG_PERMISSION_YES.equals(pd.getPermission())){
			//有权限
			recordLogList = this.getRecordLogsByUserRole(dto);
		}else{
			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
		}
		
		if(recordLogList!=null && recordLogList.size()>0){
			dto.setRecordLogList(recordLogList);
			for(IG036Info recordLog:recordLogList){
				//判断流程日志类型
				if(IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())){
					//处理
					setRecordLogMap(map,cl_tab,recordLog);
					dto.setHasCLRecord("1");
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_GX.equals(recordLog.getRltype())){
					//更新
					setRecordLogMap(map,cl_tab,recordLog);			
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_SH.equals(recordLog.getRltype())){
					//审核
					setRecordLogMap(map,cl_tab,recordLog);
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_TJ.equals(recordLog.getRltype())){
					//提交
					setRecordLogMap(map,cl_tab,recordLog);
				}else if(IGPRDCONSTANTS.RECORDLOG_TYPE_ZZ.equals(recordLog.getRltype())){
					//中止
					setRecordLogMap(map,cl_tab,recordLog);
				}
			}

			//将系统类日志放到最后
			for(IG036Info recordLog:recordLogList){
				//判断流程日志类型
				if(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(recordLog.getRltype())){
					//系统日志
					setRecordLogMap(map,xtrz_tab,recordLog);
				}
			}
			
			Set<Map.Entry<String,List<IG036Info>>> set = map.entrySet();
			for(Iterator<Map.Entry<String,List<IG036Info>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<String,List<IG036Info>> entry = iter.next();
				//req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
				if(entry.getKey().equals(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ_NAME)){
					continue;
				}
				List<IG036Info> rlist = entry.getValue();
				List<IG036Info> rnlist = new ArrayList<IG036Info>();
				for(IG036Info rl : rlist){
				String psname = "";
				String rolename = "";
					IG036TB rltb = (IG036TB)SerializationUtils.clone(rl);
					
					if(rolename.equals(rltb.getRlrolename())){
						rltb.setRlrolename("");
					}else
					{
						rolename = rltb.getRlrolename();
					}
					
					if(psname.equals(rltb.getPsname())){
						rltb.setPsname("");
					}else
					{
						psname = rltb.getPsname();
						rltb.setRlrolename(rolename);
					}
					
					rnlist.add(rltb);
				}
				map.put(entry.getKey(), rnlist);
			}
			
			
			dto.setRecordLogMap(map);
		}
		
		
		dto.setPdid(pr.getPrpdid());

		
		log.debug("========获取历史记录处理终了========");
		return dto;
	}
	
	/**
	 * 设置流程日志信息
	 * @param lmap
	 * @param type
	 * @param recordlog
	 * @param attlist
	 * @param name_list
	 * @throws BLException
	 */
	private void setRecordLogMap(Map<String,List<IG036Info>> map, String type, IG036Info recordlog) throws BLException {
		List<IG036Info> list = map.get(type);
		if(list!=null && !list.contains(recordlog)){
			list.add(recordlog);
		}else if(list==null){
			list = new ArrayList<IG036Info>();
			list.add(recordlog);
		}
		map.put(type, list);
		
	}
	
	/**
	 * 根据用户角色获取日志
	 * @param dto
	 */
	private List<IG036Info> getRecordLogsByUserRole(IGPRR01DTO dto) throws BLException{
		User user = dto.getUser();
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(user.getUserid());

		IG036SearchCondImpl recond =  new IG036SearchCondImpl();
		recond.setPrid(dto.getPrid());
		//流程管理员可以看见全部日志信息
		if(!dto.isAdminRole()){

			List<Integer> roleidList = new ArrayList<Integer>();
			for(UserRoleInfo userrole:userroleList){
				roleidList.add(userrole.getRoleid());
			}
			
			recond.setRoleid(roleidList);
		}
		recond.setNotEqualrlType(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		//按照角色类型查询非系统类日志
		List<IG036Info> rlList = workFlowOperationBL.searchUserRoleRecondLog(recond);
		
		//查询系统类日志,系统类日志不按角色过滤
		IG036SearchCondImpl recond2 =  new IG036SearchCondImpl();
		recond2.setPrid(dto.getPrid());
		recond2.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		List<IG036Info> rlList2 = workFlowOperationBL.searchUserRoleRecondLog(recond2);

		rlList2.addAll(rlList);
		
		return rlList2;
	}
	
	/**
	 * <p>
	 * Description: 根据流程ID查询关联了该流程的流程记录
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO getProcessRecordByRelations(IGPRR01DTO dto) throws BLException{
		
		//查询快捷发起的流程关系
		IG512SearchCondImpl prrCond = new IG512SearchCondImpl();
		prrCond.setParprid(dto.getPrid());
		List<IG512Info> processRecordRelationList = workFlowOperationBL.searchProcessRecordRelation(prrCond);//主动
		prrCond.setParprid(null);
		prrCond.setCldprid(dto.getPrid());
		processRecordRelationList.addAll(workFlowOperationBL.searchProcessRecordRelation(prrCond));//被动
		//按建立时间升序排序
		workFlowOperationBL.orderByTimeAsc(processRecordRelationList);
		
		dto.setLst_IG512Info(processRecordRelationList);
		
		return dto;
	}
	
	/**
	 *查看流程_角色信息查询处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchReadProcessParticipantRoleAction(IGPRR01DTO dto) throws BLException {
		log.debug("========查看流程_角色信息查询处理开始========");
		// 当前用户ID
		String userid = dto.getUser().getUserid();
		
		// 如果存在授权,查询时按照授权人权限查询操作
		if(dto.getAuthorizeuser() != null){
			userid = dto.getAuthorizeuser().getUserid();
		}
		
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(form.getPrid() == null && form.getPrid() == 0) {
			throw new BLException("IGCO10000.E004","工作基本");
		}
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		if(pr == null) {
			throw new BLException("IGCO10000.E004","工作基本");
		}
		
		//获取当前流程节点状态信息
		dto.setProcessStatusDef(this.workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid()));
		
		List<LabelValueBean> roleList = new ArrayList<LabelValueBean>();
		//存放未处理参与角色
		List<IG337Info> lst_ProcessParticipant = new ArrayList<IG337Info>();
		List<UserRoleInfo> userRoleList = userRoleBL.getUserRoles(userid);
		//是否管理员
		for(UserRoleInfo ur : userRoleList) {
			if(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE.equals(ur.getRoletype())) {
				dto.setAdminRole(true);
				break;
			}
		}
		//获取可处理角色
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		if (dto.getStatus() == null) {
			ppList = workFlowOperationBL.searchProcessParticipantTodoRole(form.getPrid(), dto.getProcess().getPrstatus());
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(form.getPrid());
			ppCond.setPpproctimeIsNull("Y");
			if (dto.getStatus().indexOf("_") > -1) {
				ppCond.setPsdid(dto.getStatus().split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
			} else {
				ppCond.setPsdid(dto.getStatus());
			}
			ppList = workFlowOperationBL.searchProcessParticipants(ppCond);
		}
		dto.setProcessParticipantList(ppList);
		List<Integer> doneRoleList = new ArrayList<Integer>();
		List<String> doneOrgList = new ArrayList<String>();
		//OA判断是否被授权值班人或角色负责人已提交
		if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
			//获取已处理角色
			List<IG337Info> ppDoneList = new ArrayList<IG337Info>();
			if (dto.getStatus() == null) {
				ppDoneList = workFlowOperationBL.searchProcessParticipantDoneRole(form.getPrid(), dto.getProcess().getPrstatus());
			} else {
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(form.getPrid());
				ppCond.setPpproctimeIsNull("N");
				if (dto.getStatus().indexOf("_") > -1) {
					ppCond.setPsdid(dto.getStatus().split("_")[0]);
					ppCond.setPsdnum(Integer.parseInt(dto.getStatus().split("_")[1]));
				} else {
					ppCond.setPsdid(dto.getStatus());
				}
				ppDoneList = workFlowOperationBL.searchProcessParticipants(ppCond);
			}
			
			//判断参与者类型是否为机构
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
				for (IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) ||
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) ||
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
									&& IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						doneOrgList.add(pp.getPporgid());
					}
				}
			}else{
				for (IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) ||
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) ||
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())
									&& IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						doneRoleList.add(pp.getPproleid());
					}
				}
			}
		}
		
		//是否临时角色负责人，临时角色负责人只可以提交，不能干别的
		boolean tempRoleManager = true;
		
		for (IG337Info pp : ppList) {
			//====>130225Begin 参与者与登录用户相同时，取参与者所属机构
			if(dto.getUser().getUserid().equals(pp.getPpuserid())){
				dto.setPporgid(pp.getPporgid());
			}
			//====>130225End
			for (UserRoleInfo ur : userRoleList) {
				if (pp.getPproleid().equals(ur.getRoleid())) {
					//OA模式需匹配USERID
					String rolename = ur.getRolename();
					if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
						if(StringUtils.isNotEmpty(pp.getPpuserid())) {
							if(pp.getPpuserid().equals(userid)) {
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager())) {
									rolename += "（负责人）";
								} else if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
									rolename += "（值班人）";
								}
								//判断参与者类型是否为机构
								if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
									if(!doneOrgList.contains(pp.getPporgid())){
										roleList.add(new LabelValueBean(rolename,String.valueOf(ur.getRoleid())));
										lst_ProcessParticipant.add(pp);
									}
								}else{
									if(!doneRoleList.contains(ur.getRoleid())) {
										roleList.add(new LabelValueBean(rolename ,String.valueOf(ur.getRoleid())));
										lst_ProcessParticipant.add(pp);
									}
								}
								if(tempRoleManager && IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager())) {
									tempRoleManager = false;
								}
							}
						}
					} else {
//						if(StringUtils.isEmpty(pp.getPpuserid()) || pp.getPpuserid().equals(userid)) {//支持代替处理
					        String username = pp.getPpusername();
							roleList.add(new LabelValueBean(rolename + "（"+ (StringUtils.isEmpty(username) ? "未指定" : username) +"）", pp.getPpid() + "_" + ur.getRoleid() + "_" + (StringUtils.isEmpty(pp.getPpuserid()) ? userid : pp.getPpuserid())));
							lst_ProcessParticipant.add(pp);
//						}
					}
					break;
				}
			}
		}
		
		if(roleList.size() > 0 && dto.getRoleid() == null) {
			dto.setRoleid(Integer.parseInt(roleList.get(0).getValue().split("_")[1]));
			boolean flag = true;//设定指定角色对应参与者
			for(IG337Info pp : lst_ProcessParticipant) {
				if(pp.getPproleid().equals(dto.getRoleid()) && userid.equals(pp.getPpuserid())) {//匹配用户
					dto.setProcessParticipant(pp);
					flag = false;
					break;
				}
			}
			if(flag){
				dto.setProcessParticipant(lst_ProcessParticipant.get(0));
			}
		} else {
			boolean flag = true;//设定指定角色对应参与者
			for(IG337Info pp : lst_ProcessParticipant) {
				if(pp.getPproleid().equals(dto.getRoleid()) && userid.equals(pp.getPpuserid())) {//匹配用户
					dto.setProcessParticipant(pp);
					flag = false;
					break;
				}
			}
			if(flag) {
				for(IG337Info pp : lst_ProcessParticipant) {
					if(pp.getPproleid().equals(dto.getRoleid()) && StringUtils.isEmpty(pp.getPpuserid())) {//用户不匹配则匹配角色
						dto.setProcessParticipant(pp);
						break;
					}
				}
			}
		}
		
		//如果是当前节点是OA模式，则执行人只能指定所选处理角色的人。非OA模式可以指定该登录用户所负责的该流程处理角色的人
		if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
			//非临时角色角色负责人
			if(tempRoleManager) {
				//判断参与人类型是否为机构
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())){
					if(dto.getProcessParticipant() != null){
						//判断是否是负责人
						if(IGPRDCONSTANTS.ROLEMANAGER.equals(dto.getProcessParticipant().getPprolemanager())){
							dto.setRoleManager(true);
						}
						//判断是否是值班人
						if(IGPRDCONSTANTS.DUTYPERSON.equals(dto.getProcessParticipant().getPpdutyperson())){
							dto.setDutyPerson(true);
						}
					}
				}else{
					//是否所选处理角色负责人
					dto.setRoleManager(this.userRoleBL.checkRoleManagerByID(userid, dto.getRoleid()));
					//是否所选处理角色值班人
					dto.setDutyPerson(this.userRoleBL.checkRoleDutyflagByID(userid, dto.getRoleid()));
				}
			} else {
				form.setTempRoleManager(true);
			}
		} else {
			List<IG337Info> manager = workFlowOperationBL.queryRolemanager(userid, form.getPrid());
			if(!manager.isEmpty()) {
				dto.setRoleManager(true);
			}
		}
		dto.setLabelList(roleList);
		dto.setPdid(pr.getPrpdid());
		log.debug("========查看流程_角色信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 页面初始化并确定该参与者在页面中可以进行的操作
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO getActionList(IGPRR01DTO dto) throws BLException {
		log.debug("=======页面初始化处理开始========");
		Integer roleid = dto.getRoleid();//当前操作者的角色ID
		String pdid = dto.getPdid();//流程定义ID
		Integer prid = dto.getPrid();//流程ID 
		if(prid != null && prid != 0) {
			IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
//			dto.setPsdcode(pr.getPrstatus());
			dto.setProcessName(pr.getPrpdname());
			IGPRR0102Form form = dto.getIgPRR0102Form();
			form.setPrtitle(pr.getPrtitle());
			form.setPrurgency(pr.getPrurgency());
			form.setPrimpact(pr.getPrimpact());
			form.setPrdesc(pr.getPrdesc());
		}
		String psdcode = dto.getPsdcode();//流程状态类型
		//根据操作人角色ID、流程状态等查询对应的流程参与者的动作及变量权限的相关信息
		dto = searchProcessParticipantDefByRoleAndProcessStatusAction(dto);
		//根据操作人角色ID、流程状态、prid等查询对应的流程状态的变量的相关信息
		dto = searchProcessVariableAction(dto);
		//查询表单信息集合
		List<IG007Info> processInfoDefList  = workFlowOperationBL.getProcessInfoDefs(pdid);
		if(roleid != null && roleid > 0) {
			//参与者可视按钮取得
			List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
				this.workFlowDefinitionBL.searchVisibleButton(dto.getProcessStatusDef().getPsdid(), roleid);
			
			//判断是否为发起状态
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psdcode) && (prid == null || prid == 0)){
				//取参与者变量权限信息集合与前处理集合中变量的交集,交集中的元素要被授予前处理选中的变量的值
				//查询流程类型名称
				IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
				dto.setProcessName(pd.getPdname());
				//当前流程定义是否为测试状态
				if(pd!=null && IGPRDCONSTANTS.PD_STATUS_TESTABLE.equals(pd.getPdstatus())){
					dto.setPrassetcategory(IGPRDCONSTANTS.PD_TEST_ID);
				}
				dto = setVarAccess(processInfoDefList,dto);
				
				//将varList、notinvarList与前处理的变量集合比较，将存在于前处理中的变量按照前处理中设置的值进行赋值(设置变量值)
				dto = setVarValue(dto);
				
			}else{
				//非发起状态(对processInfo表按照下一状态的前处理更新表中所有表单信息的值)
				//查询ProcessInfo
				List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
				
				Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
				for(int i=0;i<processInfolist.size();i++){
					if(processInfolist.get(i).getPiattkey()!=null){
						//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
						List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
						map.put(processInfolist.get(i).getPivarname(), list);
					}
					//私有变量附件
					List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
					if(privateInfoList != null){
						for(int j=0; j<privateInfoList.size();j++){
							if(privateInfoList.get(j).getPpiattkey()!=null){
								List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
								if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
									map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
								}else{
									map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
								}
							}
						}
					}
	//			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
				}
				dto.setTextAreaMap(map);
				
				//取参与者变量权限信息集合与前处理集合中变量的交集,交集中的元素要被授予前处理选中的变量的值
				
				//当前参与者的变量权限集合与该流程定义的表单信息集合进行比较(设置变量权限)
				dto = setVarAccess(processInfoDefList,dto);
				
				//按照上流程状态结束时的变量值与前处理中的变量值进行比较
				dto = setProcessInfoVarValue(processInfolist,dto);
				
				//将varList、notinvarList与前处理的变量集合比较，将存在于前处理中的变量按照前处理中设置的值进行赋值(设置变量值)
				dto = setVarValue(dto);
			}
			//判断是否含有需要确认操作
			boolean show_button_confim = false;
			//当前参与者未确认
			if(dto.getProcessParticipant() != null
					&& !IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM.equals(dto.getProcessParticipant().getPpsubstatus())) {
				for(IG309Info button : lst_ParticipantVisibleButtonVWInfo) {
					if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(button.getVbid())) {
						show_button_confim = true;
						break;
					}
				}
			}
			
			//如果有确认按钮，则保留确认/更新/中止按钮，没有则删除确认按钮
			IG309Info button = null;
			for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
				button = iter.next();
				if(show_button_confim) {
					if(isCommitButton(button.getVbid())) {
						iter.remove();
					}
				} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(button.getVbid())) {
					iter.remove();
				}
			}
			
			//并行节点只能看见更新/中止和（提交或确认）按钮。
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
				for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
					button = iter.next();
					if(isCommitButton(button.getVbid()) && !IGPRDCONSTANTS.BUTTON_SUBMIT.equals(button.getVbid())) {
						iter.remove();
					}
				}
			}
			
			//如果有相关发起按钮则需查询可发起的流程类型。
			for(Iterator<IG309Info> iter = lst_ParticipantVisibleButtonVWInfo.iterator(); iter.hasNext();) {
			    button = iter.next();
			    if(IGPRDCONSTANTS.BUTTON_PROCESS.equals(button.getVbid())) {
			        IG911SearchCondImpl ig911cond = new IG911SearchCondImpl();
			        ig911cond.setPdid(dto.getPdid());
			        ig911cond.setPsdid(dto.getPsdid());
			        ig911cond.setRoleid(dto.getRoleid());
			        int ig911SearchCount = workFlowDefinitionBL.getIg911RelevantPdidCount(ig911cond);
			        if (ig911SearchCount == 1) {
			            dto.setIsMoreRelevantProcess("0");
			            IG911Info ig911Info = workFlowDefinitionBL.searchIg911RelevantPdid(ig911cond).get(0);
			            dto.setRelevantPdid(ig911Info.getRelevantPdid());
			        } else if (ig911SearchCount > 1) {
			            dto.setIsMoreRelevantProcess("1");
			        } else {
			            IG931SearchCondImpl ig931cond = new IG931SearchCondImpl();
                        ig931cond.setPdid(dto.getPdid());
                        ig931cond.setPsdid(dto.getPsdid());
                        int ig931SearchCount = workFlowDefinitionBL.getIg931RelevantPdidCount(ig931cond);
                        if (ig931SearchCount == 1) {
                            dto.setIsMoreRelevantProcess("0");
                            IG931Info ig931info = workFlowDefinitionBL.searchIg931RelevantPdid(ig931cond).get(0);
                            dto.setRelevantPdid(ig931info.getRelevantPdid());
                        } else {
                            dto.setIsMoreRelevantProcess("1");
                        }
			        }
			        break;
			    }
			}
			
			dto.setLst_ParticipantVisibleButtonVWInfo(lst_ParticipantVisibleButtonVWInfo);
			//通过节点配置决定通角色是否可代替处理
			IG333Info psd = dto.getProcessStatusDef();
			if("N".equals(psd.getReplaceDispose())){
				//取得当前登录用户 
				User user = dto.getUser();
				//默认当前用户非当前参与人 
				boolean flag = true; 
				//取得流程当前处理人集合
				List<IG337Info> list = dto.getProcessParticipantList();
				if(list != null){
					for(IG337Info info : list){
						if(user.getUserid().equals(info.getPpuserid())){
							flag = false;
							break;
						}
					}
				}
				//如果当前登录用户并非流程当前参与人 删除按钮权限以及表单可写权限
				if(flag){
					//删除按钮权限
					dto.setLst_ParticipantVisibleButtonVWInfo(null);
				}
			}
		}else{
			//查询ProcessInfo
			List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
			
			Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
			for(int i=0;i<processInfolist.size();i++){
				if(processInfolist.get(i).getPiattkey()!=null){
					//recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(prid);
					List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
					map.put(processInfolist.get(i).getPivarname(), list);
				}
				//私有变量附件
				List<IG899TB> privateInfoList = processInfolist.get(i).getProcessPrivateInfofList();
				if(privateInfoList != null){
					for(int j=0; j<privateInfoList.size();j++){
						if(privateInfoList.get(j).getPpiattkey()!=null){
							List<Attachment> listPrivate = workFlowOperationBL.searchProcessInofAtt(privateInfoList.get(j).getPpiattkey());
							if(StringUtils.isEmpty(privateInfoList.get(j).getUserid())){
								map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getRoleid(), listPrivate);
							}else{
								map.put(processInfolist.get(i).getPivarname()+"_"+privateInfoList.get(j).getUserid(), listPrivate);
							}
						}
					}
				}
//			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
			}
			dto.setTextAreaMap(map);
			
			//取参与者变量权限信息集合与前处理集合中变量的交集,交集中的元素要被授予前处理选中的变量的值
			
			//当前参与者的变量权限集合与该流程定义的表单信息集合进行比较(设置变量权限)
			dto = setVarAccess(processInfoDefList,dto);
			
			//按照上流程状态结束时的变量值与前处理中的变量值进行比较
			dto = setProcessInfoVarValue(processInfolist,dto);
			
			//将varList、notinvarList与前处理的变量集合比较，将存在于前处理中的变量按照前处理中设置的值进行赋值(设置变量值)
			dto = setVarValue(dto);
		}
		//并行节点只能看见更新和（提交或确认）按钮。
		if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(dto.getProcessStatusDef().getPsdtype())) {
			//判断登录用户所选处理角色是否是并行节点super角色
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(dto.getPrid());
			cond.setPpstatus(dto.getProcessStatusDef().getPsdcode());
			if (!IGPRDCONSTANTS.PSDASSIGN_ORG.equals(dto.getProcessStatusDef().getPsdassign())) {
				cond.setPproleid(dto.getRoleid());
			}
//			cond.setPpuserid(dto.getUser().getUserid());
			List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipants(cond);
			for(IG337Info participant : ppList) {
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(participant.getPpsuper())) {
					if(IGPRDCONSTANTS.MODE_OA.equals(dto.getProcessStatusDef().getPsdmode())) {
						dto.setSuperFlag(IGPRDCONSTANTS.MODE_OA);//OA模式
					} else {
						dto.setSuperFlag(IGPRDCONSTANTS.MODE_NORMAL);//普通模式
					}
				}
			}
		}
		//挂起状态不能处理
		if(workFlowOperationBL.checkPendStatus(dto.getPrid(), dto.getProcessStatusDef().getPsdid())) {
			//删除按钮权限
			dto.setLst_ParticipantVisibleButtonVWInfo(null);
		}
				
		log.debug("========页面初始化处理终了========");
		return dto;
	}
	
	/**
	 *按照前处理中变量的设置对流程变量进行赋值
	 */
	private IGPRR01DTO setProcessInfoVarValue(List<IG599Info> processInfolist,IGPRR01DTO dto) throws BLException {
		List<IG007Info> varList = dto.getVarList();//保存流程权限变量与表单信息的交集
		List<IG007Info> notinvarList =dto.getNotinvarList();//保存不在流程权限变量中的表单信息

		if(varList!=null){
			for(int i=0,j=varList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(varList.get(i));
				if(processInfolist!=null){
					for(int n=0,m=processInfolist.size();n<m;n++){
						IG599Info pipd = processInfolist.get(n);
						
						//判断表单信息是否在processInfolist中,如在则对其赋值
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidvalue(pipd.getPivarvalue());
							pid.setPiid(pipd.getPiid());
							pid.setPidcomment(pipd.getPidcomment());
							//add by wanglongyu 20120406 增加对私有变量值的取得
							if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
								if(null == pipd.getProcessPrivateInfofList() || pipd.getProcessPrivateInfofList().size() == 0){
									pid.setProcessPrivateInfoList(null);
								}else{
									pid.setProcessPrivateInfoList(pipd.getProcessPrivateInfofList());
								}
							}
							varList.remove(i);
							varList.add(i,pid);
							break;
						}
					}
				}
			}
		}
		
		if(notinvarList!=null){
			for(int i=0,j=notinvarList.size();i<j;i++){
				IG007TB pid = (IG007TB)SerializationUtils.clone(notinvarList.get(i));
				if(processInfolist!=null){
					for(int n=0,m=processInfolist.size();n<m;n++){
						IG599Info pipd = processInfolist.get(n);
						//判断表单信息是否在processInfolist中,如在则对其赋值
						if(pid.getPidid().equals(pipd.getPidid())){
							pid.setPidvalue(pipd.getPivarvalue());
							pid.setPiid(pipd.getPiid());
							//add by wanglongyu 20120406 增加对私有变量值的取得
							if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
								if(null == pipd.getProcessPrivateInfofList() || pipd.getProcessPrivateInfofList().size() == 0){
									pid.setProcessPrivateInfoList(null);
								}else{
									pid.setProcessPrivateInfoList(pipd.getProcessPrivateInfofList());
									//如果私有变量为角色,则设置现有的value
									if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(pid.getPrivatescope())){
										for(IG899TB tb : pipd.getProcessPrivateInfofList()){
											pid.setPidvalue(tb.getPpivalue());
										}
									}
								}
							}
							notinvarList.remove(i);
							notinvarList.add(i,pid);
							break;
						}
					}
				}

			}
		}
		
		//文本域绑定附件值封装
//		dto.setTextAreaMap(textAreaList);
		
		dto.setVarList(varList);
		dto.setNotinvarList(notinvarList);
		return dto;
	}
	
	/**
	 * 设置表单变量
	 */
	private IGPRR01DTO initDefVar(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		if(dto.getProcessInfoDefmap()!=null){
			int length = dto.getProcessInfoDefmap().size();
			form.setPivarvalue(new String[length]);
			form.setPivarassetname(new String[length]);
			form.setPivarprname(new String[length]);
			form.setPivarprjname(new String[length]);
			form.setPivarrolename(new String[length]);
			form.setPivartreename(new String[length]);
			form.setPivarradio(new String[length]);
			form.setPivarcheckbox(new String[length]);
			form.setPidcomment(new String[length]);
			form.setPivarlabel(new String[length]);
			form.setPivarname(new String[length]);
			form.setPivartype(new String[length]);
			form.setPrivatescope(new String[length]);
			//120509Begin
		}else{
			dto = searchProcessInfoForSearch(dto);
		}
		//120509End
			
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
		}
		//表单可见权限中配置的非流程参与者可见表单信息在流程各个状态都要显示   start wangtingzhi 20130422
		Map<String,IG007Info> processInfoDefnewmap=getPorcesssInfoDefNewMap(dto.getPrid(),dto.getPdid(),dto.getUser());
		if(processInfoDefnewmap!=null){
			if (StringUtils.isEmpty(dto.getHid())||"0".equals(dto.getHid())) {
				dto.setHid("1");
			}
			Map<String, IG007Info> varmap = dto.getVarmap();
			if(varmap==null||varmap.size()==0){
				dto.setVarmap(processInfoDefnewmap);
			}else{
				Set<Map.Entry<String, IG007Info>> varset = varmap.entrySet();
				for(Iterator<Map.Entry<String, IG007Info>> variter = varset.iterator();variter.hasNext();){
					IG007Info varInfo = variter.next().getValue();
					Set<Map.Entry<String, IG007Info>> newset = processInfoDefnewmap.entrySet();
					for(Iterator<Map.Entry<String, IG007Info>> newiter = newset.iterator();newiter.hasNext();){
						IG007Info newInfo = newiter.next().getValue();
						if(varInfo.getPidid().equals(newInfo.getPidid())){
							if(StringUtils.isEmpty(varInfo.getPidaccess())||(StringUtils.isNotEmpty(newInfo.getPidaccess())&&(Integer.valueOf(newInfo.getPidaccess())>Integer.valueOf(varInfo.getPidaccess())))){
								IG007TB varTB = (IG007TB) SerializationUtils.clone(varInfo);
								varTB.setPidaccess(newInfo.getPidaccess());
								varmap.put(newInfo.getPidid(), varTB);
								break;
							}
						}
					}
				}
			}
		}
		//表单可见权限中配置的非流程参与者可见表单信息在流程各个状态都要显示   end wangtingzhi 20130422
		if(!"1".equalsIgnoreCase(dto.getHid())){
			dto.setHid("0");
		}
		if(dto.getVarmap()!=null){
			Set<Map.Entry<String,IG007Info>> cset = dto.getVarmap().entrySet();
			//=============================>wuzhenqiu 扩展信息是否显示
			for(Iterator<Map.Entry<String,IG007Info>> iter = cset.iterator();iter.hasNext();){
				Map.Entry<String,IG007Info> entry = iter.next();
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(entry.getValue().getPidaccess()) ||
				   IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(entry.getValue().getPidaccess())	){
					dto.setHid("1");
					break;
				}
			}
		}
		//<============================
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
		
	/**
	 * 根据流程定义ID和用户角色检索该用户可查看该流程的表单
	 * @param pdid
	 * @param user
	 * @return
	 */
	private Map<String, IG007Info> getPorcesssInfoDefNewMap(Integer prid,String pdid,
			User user) {
		Map<String,IG007Info> processInfoDefnewmap=new LinkedHashMap<String, IG007Info>();
		List<IG007Info> ig007InfoList=new ArrayList<IG007Info>();
		String userid = user.getUserid();
		//取得当前用户的所有角色
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		if(roleList!=null&&roleList.size()>0){
			for(UserRole userRole:roleList){
				IG701SearchCondImpl cond=new IG701SearchCondImpl();
				cond.setPdid(pdid);
				cond.setRoleid(userRole.getRoleid());
				List<IG701Info> ig701InfoList= workFlowDefinitionBL.searchRoleForm(cond);
				if(ig701InfoList!=null&&ig701InfoList.size()>0){
					for(IG701Info ig701Info:ig701InfoList){
						if(ig701Info.getProcessInfoDef()!=null){
							ig007InfoList.add(ig701Info.getProcessInfoDef());
						}
					}
				}
			}
		}
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(prid);
		if(ig007InfoList!=null && ig007InfoList.size()>0){
			//根据流程变量找到变量定义表中的变量定义，将流程变量的值赋给与其对应的流程变量定义的对象，并将该流程变量定义对象的流程变量权限(pidaccess)设置为只读
			for(IG007Info pid:ig007InfoList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						pitb.setPidvalue(temp_pi.getPivarvalue());
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						processInfoDefnewmap.put(pidid, pitb);
						break;
					}
				}
			}
		}
		return processInfoDefnewmap;
	}

	/**
	 * 流程管理员可见所有表单变量
	 */
	private IGPRR01DTO initDefVarForAdmin(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//取得流程
		IG500Info pr = dto.getProcess();
		
		//查询该流程的所有定义的表单变量
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(pr.getPrpdid());
		List<IG007Info> infoDefList = workFlowOperationBL.searchProcessInfoDefByCond(cond);

		//查询该流程的所有表单变量
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(pr.getPrid());
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//根据流程变量找到变量定义表中的变量定义，将流程变量的值赋给与其对应的流程变量定义的对象，并将该流程变量定义对象的流程变量权限(pidaccess)设置为可写
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						IG599TB temppi = (IG599TB)SerializationUtils.clone(temp_pi);
						pitb.setPidvalue(temppi.getPivarvalue());
						//如果当前用户可以全局控制所属权限表单，则保留原权限，否则保留只读权限
						if(!IGPRR01BLType.FORM_GLOBAL_CONTROL_Y.equals(dto.getIsFormGlobalControl())){
							pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						}else{
							pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE);
						}
						//pitb.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
						pitb.setPiid(temppi.getPiid());
						if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
							if(null == temppi.getProcessPrivateInfofList() || temppi.getProcessPrivateInfofList().size() == 0){
								pitb.setProcessPrivateInfoList(null);
							}else{
								pitb.setProcessPrivateInfoList(temppi.getProcessPrivateInfofList());
							}
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
			int length = dto.getVarmap().size();
			form.setPivarvalue(new String[length]);
			form.setPivarassetname(new String[length]);
			form.setPivarprname(new String[length]);
			form.setPivarprjname(new String[length]);
			form.setPivarrolename(new String[length]);
			form.setPivartreename(new String[length]);
			form.setPivarradio(new String[length]);
			form.setPivarcheckbox(new String[length]);
			form.setPivarlabel(new String[length]);
			form.setPivarname(new String[length]);
			form.setPivartype(new String[length]);
			form.setPrivatescope(new String[length]);
			form.setPidcomment(new String[length]);
			dto.setHid("1");
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
			dto.setHid("0");
		}
		
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 流程跃迁 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public synchronized IGPRR01DTO flow(IGPRR01DTO dto) throws BLException {
		log.debug("========流程跃迁处理开始========");
		// 流程记录的填充
		IGPRR0102Form form = dto.getIgPRR0102Form();
		
		// 如果点击的是更新按钮，并且没有角色信息，只做更新操作   20130121 王廷志 start
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		// 201302121 王廷志  end
		
		//OA模式临时角色负责人，可以提交，但不做负责人的其他事
		dto.setTempRoleManager(form.isTempRoleManager());
		// 当前用户信息
		User user = dto.getUser();
		
		// 如果授权,按授权人信息操作
		if(dto.getAuthorizeuser() != null){
			user = dto.getAuthorizeuser();
		}
		dto.setAssignPageType(psd.getAssignPageType());
		User authorizeuser = dto.getAuthorizeuser();
		//添加流程变量信息
		List<IG599Info> processInfoList = new ArrayList<IG599Info>();
		if(dto.isAssignParticipant()) {
			if(form.getPivarvalue() != null){
				for(int i=0;i<form.getPivarvalue().length;i++){
					IG599TB prInfo = workFlowOperationBL.getProcessInfoTBInstance();
					prInfo.setPivarlabel(form.getPivarlabel()[i]);
					prInfo.setPivarname(form.getPivarname()[i]);
					prInfo.setPivartype(form.getPivartype()[i]);
					prInfo.setPivarvalue(form.getPivarvalue()[i]);
					prInfo.setPidid(form.getPidid()[i]);
					if(StringUtils.isNotEmpty(form.getPiid()[i])) {
						prInfo.setPiid(Integer.parseInt(form.getPiid()[i]));
					}
					if(form.getPidcomment() != null && form.getPidcomment().length > i){
						prInfo.setPidcomment(form.getPidcomment()[i]);
					}
					prInfo.setPidaccess(form.getPidaccess()[i]);
					prInfo.setPidmode(form.getPidmode()[i]);
					prInfo.setPrivatescope(form.getPrivatescope()[i]);
					prInfo.setPrid(dto.getPrid());
					processInfoList.add(prInfo);
				}
			}
		}
		dto.setNodetype(psd.getPsdtype());
		
		String datetime = IGStringUtils.getCurrentDateTime();
		
		//查询当前流程
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		if(StringUtils.isEmpty(form.getPrtype())){
			form.setPrtype(pr.getPrtype());
		}
		//取得人员表单信息
		Map<String, List<IG506TB>> participantFormInfo = packingParticipantList(form.getPar_userid(), form.getPar_username(), form.getPar_orgid(), form.getPar_orgname(), form.getPar_roleid(), form.getPar_rolename(), form.getPar_pidid(),form.getPar_phone());
		//如果先删除后增加的话，id可能会不够，暂时用修改
		List<IG599Info> prInfoList = new ArrayList<IG599Info>();
		if(dto.isAssignParticipant()) {
			
			if(form.getPivarvalue() != null){
				//============================>wuzhenqiu
				boolean flag = false;
				for(int i=0;i<form.getPivarvalue().length;i++){
					if(form.getPivarvalue()[i]!=null){
						flag = true;
						break;
					}
				}
				if(flag){
					for(int i=0;i<form.getPivarvalue().length;i++){
						if(StringUtils.isNotEmpty(form.getPiid()[i])){
							IG599Info pi = workFlowOperationBL.getProcessInfoByID(Integer.parseInt(form.getPiid()[i]));
							//如果是可写变量，则只需保存值变的
							if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(form.getPidaccess()[i])) {
								if(!form.getPivarvalue()[i].equals(pi.getPivarvalue())) {
									IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
									piTB.setPivarvalue(form.getPivarvalue()[i]);
									if("5".equals(pi.getPivartype())){
										piTB.setPivarvalue(workFlowOperationBL.getProcessFormValue(dto.getProcess().getPrid(), form.getPivarvalue()[i]));
									}
									if("P".equals(pi.getPivartype())){
										List<IG506TB> list = participantFormInfo.get(pi.getPidid());
										piTB.setPivarvalue(workFlowOperationBL.getParticipantFormValue(pi.getPrid(), list, form.getPivarvalue()[i]));
									}
									prInfoList.add(piTB);
								}
							}
						}
					}
				}
				//<===========================
			}
			
			//表单绑定附件增加
			if(form.getAtt()!=null){
				List<IG599Info> textAreaPIList = new ArrayList<IG599Info>();
				Set<String> att = new HashSet<String>();
				for(String attFormLabel:form.getAtt()){
				    att.add(attFormLabel.split("_")[0]);
				}
				if(form.getPivarlabel() != null) {
					for(int i=0;i<form.getPivarlabel().length;i++){
					    if(att.contains(form.getPivarlabel()[i])){
					        IG599Info pi = workFlowOperationBL.getProcessInfoByID(Integer.parseInt(form.getPiid()[i]));
					        if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pi.getPidmode())){
	                            continue;
	                        }
					        if(pi.getPiattkey()!=null){
	                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
	                            //解决多附件情况下只能插入一个附件问题
	                            for(int k=0;k<form.getAtt().length;k++){
	                                if(pi.getPivarlabel().equals(form.getAtt()[k].split("_")[0])){
	                                    if(form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])) != null){
	                                        filemap.put(k, form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])));
	                                    }
	                                }
	                                
	                            }
	                            workFlowOperationBL.addProcessInfoAtt(filemap, pi.getPiattkey());
	                        }else{
	                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
	                            for(int k=0;k<form.getAtt().length;k++){
	                                if(pi.getPivarlabel().equals(form.getAtt()[k].split("_")[0])){
	                                    if(form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])) != null){
	                                    filemap.put(k, form.getFileMapMuti().get(Integer.parseInt(form.getAtt()[k].split("_")[1])));
	                                    }
	                                }
	                                
	                            }
	                            pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
	                            
	                            textAreaPIList.add(pi);
	                        }
					    }
					}
				}
				
				for(int i=0;i<textAreaPIList.size();i++){
					boolean flag = true;
					for(int j=0;j<prInfoList.size();j++){
						if(prInfoList.get(j).getPiid().equals(textAreaPIList.get(i).getPiid())){
							IG599TB piTB = (IG599TB) prInfoList.get(j);
							piTB.setPiattkey(textAreaPIList.get(i).getPiattkey());
							prInfoList.remove(j);
							prInfoList.add(j, piTB);
							if(flag){
								flag = false;
							}
						}
					}
					if(flag){
						prInfoList.add(textAreaPIList.get(i));
					}
				}
			}
			
			//文本域绑定附件删除
			if(form.getDelFileMutiStr() !=null && form.getDelFileMutiStr().length()>0){
				String[] delFileMutiStr=form.getDelFileMutiStr().split("#");
				for(int i=0;i<delFileMutiStr.length;i++){
				//先根据附件id查询
				String[] strid = delFileMutiStr[i].split("_");
				Attachment att= workFlowOperationBL.delAttachment(strid[0]);
				//后删除
				
				//如果绑定的文本域已经没有附件了,那么更新其附件字段为空
				if(att != null  && strid.length>0 ){
					List<Attachment> list=  workFlowOperationBL.searchProcessInofAtt(att.getAttkey());
					if(list.size() == 0){
						//置空附件字段
						IG599TB piTB = (IG599TB) workFlowOperationBL.getProcessInfoByID(Integer.parseInt(strid[1]));
						piTB.setPiattkey("");
						workFlowOperationBL.updateProcessInfo(piTB);
						
						IG899SearchCondImpl cond = new IG899SearchCondImpl();
						cond.setPiid(Integer.parseInt(strid[1]));
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equalsIgnoreCase(piTB.getPidmode())){
							cond.setUserid(user.getUserid());
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(piTB.getPidmode())){
							cond.setRoleid(form.getPrroleid());
						}
						List<IG899Info> privateInfoList = workFlowOperationBL.searchProcessPrivateInfo(cond);
						if(privateInfoList != null && privateInfoList.size()>0){
							for(int iNum = 0; iNum < privateInfoList.size(); iNum++){
								IG899TB privateInfoTB = (IG899TB)privateInfoList.get(iNum);
								privateInfoTB.setPpiattkey("");
								workFlowOperationBL.updateProcessPrivateInfo(privateInfoTB);
							}
						}
					}
				
				}
				}
				
			} 
			
			workFlowOperationBL.saveOrUpdProcessInfos(prInfoList);
			
		}
		
		//资产表单处理
		String pieids = form.getPieids();
		//删除流程与资产关系
		if(StringUtils.isNotEmpty(pieids)){
			String[] ids = pieids.split("#");
			for(String pieid : ids){
				if(StringUtils.isNotEmpty(pieid)){
					workFlowOperationBL.deleteProcessInfoEntityById(Integer.parseInt(pieid));
				}
			}
		}
		//新增流程与资产关系 20130905 wangtingzhi start
		Map<Integer, String> entityMap = form.getEntityMap();
		//新增用于状态级私有表单 ig561记录，用于区分不动的资产属于不同的状态 2015年2月13日15:38:44
		Map<String,String> entitySaveMap=null;
		if(entityMap != null && entityMap.size() > 0){
			//查询表单信息
			List<IG599Info> list = workFlowOperationBL.getProcessInfo(dto.getProcess().getPrid());
			entitySaveMap=workFlowOperationBL.saveProcessInfoEntity(list, entityMap);
		}
		//新增流程与资产关系 20130905 wangtingzhi end
		
		//表格类表单值保存操作 20130626 start wangtingzhi
		if(form.isUpdateTableValue()){
			workFlowOperationBL.saveTableFormValue(dto.getProcess(), form.getColumn_value(), form.getColumn_pidid(), form.getColumn_rownumber(),form.getFileMapTable(),form.getAddTableColumnFileStr(),form.getDelTableColumnFileStr());
		}
		
		//保存状态级私有表单变量（用到其他表的，例如附件）
		this.saveOrUpdateStatusVars(form,processInfoList,form.getAtt(),form.getFileMapMuti(),form.getDelFileMutiStr(),dto.getPsdid());
		//保存状态变量 wyw
		workFlowOperationBL.registIG561Info(processInfoList,dto.getPsdid(), user.getUserid(),entitySaveMap);
		
		//如果是更新操作，只做更新，不进行任何操作或验证
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction()) || IGPRDCONSTANTS.BUTTON_PROCESS.equals(dto.getAction())) {
			Integer roleid = null;
			if(form.getPrroleid() != null && form.getPrroleid() > 0) {
				roleid = form.getPrroleid();
			}
			IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(), roleid, form.getRlcomment(),
					psd.getPsdname(), form.getFileMap(),form.getLog_type(), IGPRDCONSTANTS.BUTTON_UPDATE, form.getPrstatus());
            //提交类型非系统日志时，需要记录表单日志
            if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(form.getLog_type()) && prInfoList!=null && !prInfoList.isEmpty()){
                workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
            }
			dto.addMessage(new ActionMessage("IGPRR0102.I002"));
			if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())){
			    WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			    bean.setPbdid(dto.getAction());//按钮ID
			    bean.setBfstatus(form.getPsdid());//状态ID
			    //日志参数信息
			    WorkFlowLog logInfo = new WorkFlowLog();
			    logInfo.setPrid(dto.getPrid());
			    logInfo.setExecutorid(user.getUserid());
			    logInfo.setExecutorRoleid(form.getPrroleid());
			    if(authorizeuser != null) {
			        logInfo.setAuthuserid(authorizeuser.getUserid());
			    }
			    bean.setLogInfo(logInfo);
			    this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
			}
			
			return dto;
		}
		
		//获取参与者角色信息
		Role role = roleBL.getRole(dto.getRoleid());
		
		//判断是否进入指定参与人页面
		//查询该状态可进行分派的节点列表
		 List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(), form.getAction());
		if(dto.isAssignParticipant()) {
			String action = dto.getAction();
			//可分派节点非更新操作可以指定参与人
			if(isCommitButton(action)) {
				//====>130225Begin	没有跃迁权限的人不可见分派页
				boolean flag = false;//跃迁标识true：有权跃迁；false：无权跃迁
				IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
				cond337.setPrid(pr.getPrid());
				cond337.setPpuserid(user.getUserid());
				if (form.getPrstatus().indexOf("_") > -1) {
					cond337.setPsdid(form.getPrstatus().split("_")[0]);
					cond337.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
				} else {
					cond337.setPsdid(form.getPrstatus());
				}
//				cond337.setPpstatus(pr.getPrstatus());
				List<IG337Info> lstIg337 = workFlowOperationBL.searchProcessParticipants(cond337);
				if(lstIg337 != null && !lstIg337.isEmpty()){
					//判断当前节点是否是OA模式
					IG333Info lst_Ig333 = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
					if(IGPRDCONSTANTS.MODE_OA.equals(lst_Ig333.getPsdmode())){
						for (IG337Info info337 : lstIg337) {
							if(IGPRDCONSTANTS.ROLEMANAGER.equals(info337.getPprolemanager())
									|| (IGPRDCONSTANTS.DUTYPERSON.equals(info337.getPpdutyperson()) &&
										IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(info337.getPpsubstatus()))) {
								flag = true;
								break;
							}
						}
					}else{
						flag = true;
					}
					
				}else{
					flag = true;
				}
				//如果是可分派节点，则跳转至设定执行人页面
				if(!lst_ProcessStatusDef.isEmpty() && flag) {
				//====>130225End
					dto.setNodetype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_ASSIGN);
					dto.setPsdflag(IGPRDCONSTANTS.NEED_ASSIGN);
					form.setIsInit("assign");
					dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
					//查询可分派参与者
				}
			}
		}
		
		//获取当前参与者记录
		//查询当前参与人信息
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(form.getPrid());
//		cond.setPpstatus(psd.getPsdcode());
		if(StringUtils.isEmpty(form.getPrstatus())) {
			cond.setPsdid(form.getPsdid());
		} else {
			if (form.getPrstatus().indexOf("_") > -1) {
				cond.setPsdid(form.getPrstatus().split("_")[0]);
				cond.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
			} else {
				cond.setPsdid(form.getPrstatus());
			}
		}
//		cond.setPsdid(psd.getPsdid());
		cond.setPpproctimeIsNull("Y");
		cond.setPproleid(form.getPrroleid());
		IG337Info curentpp = null;
		List<IG337Info> ppList = this.workFlowOperationBL.searchProcessParticipants(cond);
		if(form.getPpid() != null && form.getPpid() > 0) {
			curentpp = this.workFlowOperationBL.searchProcessParticipantByKey(form.getPpid());
		}
		if(ppList != null){
			for(IG337Info pp:ppList){
				if (user.getUserid().equals(pp.getPpuserid())) {
					curentpp = pp;
				}
			}
		}
		
		//保存私有变量
		processInfoList = setAttkey(processInfoList,form.getPrroleid(), user.getUserid(), form.getAtt(),form.getFileMapMuti(), form.getDelFileMutiStr());
		this.workFlowOperationBL.registProcessPrivateInfo(processInfoList, form.getPrroleid(), user.getUserid(),curentpp==null?"":curentpp.getPporgid());
		
		if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())) {//OA模式
			//提交
			if(isCommitButton(dto.getAction())) {
				if(curentpp == null){
					throw new BLException("IGCO10000.E004","参与者基本");
				}
				//判断登录用户是否是值班人或负责人
				boolean flag = false;
				
				//判断参与者类型是否为机构
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
					//判断是否是负责人
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(curentpp.getPprolemanager())){
						flag = true;
					}
					//判断是否是值班人
					if(IGPRDCONSTANTS.DUTYPERSON.equals(curentpp.getPpdutyperson())){
						flag = true;
					}
				}else{
					flag =  this.userRoleBL.checkRoleDutyflagByID(user.getUserid(), form.getPrroleid()) || this.userRoleBL.checkRoleManagerByID(user.getUserid(), form.getPrroleid());
				}
				
				if(flag || dto.isTempRoleManager()){//值班人或负责人提交，临时角色负责人
					//只更新提交人记录
					for(IG337Info participant : ppList) {
						if(user.getUserid().equals(participant.getPpuserid())) {
							IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
							ppTB.setPpproctime(datetime);
							ppTB.setPbdid(dto.getAction());
							//更新参与者信息
							workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(),
									form.getRlcomment(), psd.getPsdname(), form.getFileMap(),form.getLog_type(),
									prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
							//未被授权角色值班人不能提交
							if(IGPRDCONSTANTS.DUTYPERSON.equals(participant.getPpdutyperson()) &&
									!IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(participant.getPpsubstatus())) {
								if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
									dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
								}
							}
							break;
						}
					}
				} else {//执行人提交只更新完成时间，状态不跃迁，相当于更新
					for(IG337Info participant : ppList) {
						if(user.getUserid().equals(participant.getPpuserid())) {
							IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
							if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
								ppTB.setPpproctime(datetime);
								ppTB.setPbdid(dto.getAction());
								dto.setAction(IGPRDCONSTANTS.BUTTON_UPDATE);
							}
							//更新参与者信息
							workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), psd.getPsdname(), 
									form.getFileMap(),form.getLog_type(),prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
							break;
						}
					}
				}
			} else if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())) {
					//记录更新日志
					IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(),form.getPrroleid(),
							form.getRlcomment(), psd.getPsdname(), form.getFileMap(),form.getLog_type(), dto.getAction(), form.getPrstatus());
					
	
					//提交类型非系统日志时，需要记录表单日志
					if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(form.getLog_type()) && prInfoList!=null && !prInfoList.isEmpty()){
						//更新表单，但是没有更新处理记录时，将日志类型改为处理类
						if(prInfoList.size() > 0 && StringUtils.isEmpty(form.getRlcomment())&&!IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())) {
							IG036TB recordLogTB = (IG036TB)SerializationUtils.clone(recordLog);
							recordLogTB.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
							recordLogTB.setRldesc(IGPRDCONSTANTS.RLDESC_DATA);
							workFlowOperationBL.updateRecordLog(recordLogTB);
						}
						workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
					}
				
			} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(dto.getAction())) {//确认处理
				for(IG337Info participant : ppList) {
					if(user.getUserid().equals(participant.getPpuserid())) {
						IG337TB ppTB = (IG337TB)SerializationUtils.clone(participant);
						ppTB.setPpsubstatus(IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM);//修改参与者子状态为已确认
						ppTB.setPpbacktime(datetime);//确认时间
						ppTB.setPbdid(dto.getAction());
						//更新参与者信息
						workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), psd.getPsdname(), 
								form.getFileMap(),form.getLog_type(),prInfoList,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						break;
					}
				}
			}
			
		} else {//普通模式
			//====>目标工作修改 Begin
			IG337TB ppTB = null;
			//当指定参与者为当前处理人
			if(curentpp != null){
				ppTB = (IG337TB) SerializationUtils.clone(curentpp);
			}
			if(ppTB == null) {
				for (IG337Info pp : ppList) {
					if(StringUtils.isEmpty(pp.getPpuserid())){
						ppTB = (IG337TB)SerializationUtils.clone(pp);
						break;
					}
				}
			}
			//当没有参与用户信息时，取得参与角色信息
			if(ppTB == null){
//				IG337Info pp = workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrroleid(), 
//						psd.getPsdcode());
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(form.getPrid());
				ppCond.setPproleid(form.getPrroleid());
				ppCond.setPpuseridIsNull("Y");
				if (form.getPrstatus().indexOf("_") > -1) {
					cond.setPsdid(form.getPrstatus().split("_")[0]);
					cond.setPsdnum(Integer.parseInt(form.getPrstatus().split("_")[1]));
				} else {
					cond.setPsdid(form.getPrstatus());
				}
//				ppCond.setPsdid(psd.getPsdid());
				List<IG337Info> pprList = workFlowOperationBL.searchProcessParticipants(ppCond);
				if(pprList == null || pprList.size() == 0) {
					throw new BLException("IGCO10000.E004","参与者基本");
				}
				ppTB = (IG337TB)SerializationUtils.clone(pprList.get(0));
			}
			//====>目标工作修改 End
			if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(dto.getAction())) {
				ppTB.setPpsubstatus(IGPRDCONSTANTS.PARTICIPANT_SUBSTATUS_CONFIRM);//修改参与者子状态为已确认
				ppTB.setPpbacktime(datetime);//确认时间
				ppTB.setPbdid(dto.getAction());
			} else if(isCommitButton(dto.getAction())) {
				ppTB.setPpproctime(datetime);
				ppTB.setPbdid(dto.getAction());
			}
			if(authorizeuser!= null) {//授权模式
				ppTB.setPpuserid(authorizeuser.getUserid());
				ppTB.setPpusername(authorizeuser.getUsername());
				ppTB.setPporgid(authorizeuser.getOrgid());
				ppTB.setPporgname(authorizeuser.getOrgname());
				ppTB.setPpproxyuserid(dto.getUser().getUserid());//设置代理人id
			}else{//普通模式
				ppTB.setPpuserid(dto.getUser().getUserid());
				ppTB.setPpusername(dto.getUser().getUsername());
				ppTB.setPporgid(dto.getUser().getOrgid());
				ppTB.setPporgname(dto.getUser().getOrgname());
			}
			//更新参与者信息，不包括更新按钮
			if(!IGPRDCONSTANTS.BUTTON_UPDATE.equals(dto.getAction())
					&& !IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(dto.getAction())) {
				String log_type = form.getLog_type();
				if("assign".equals(form.getIsInit())) {
					log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
				}
				workFlowOperationBL.updateProcessParticipant(ppTB, dto.getUser(), ppTB.getPproleid(), form.getRlcomment(), 
						psd.getPsdname(), 
						form.getFileMap(),log_type,prInfoList,dto.getAuthorizeuser(), form.getAction(), form.getPrstatus());
			} else {
				//记录日志
				IG036Info recordLog = workFlowOperationBL.addRecordLog(form.getPrid(), dto.getUser(), ppTB.getPproleid(), form.getRlcomment(),
						psd.getPsdname(), form.getFileMap(),form.getLog_type(), dto.getAction(), form.getPrstatus());
				//更新表单，但是没有更新处理记录时，将日志类型改为处理类
				if(prInfoList.size() > 0 && StringUtils.isEmpty(form.getRlcomment())&&!IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(recordLog.getRltype())) {
					IG036TB recordLogTB = (IG036TB)SerializationUtils.clone(recordLog);
					recordLogTB.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
					recordLogTB.setRldesc(IGPRDCONSTANTS.RLDESC_DATA);
					workFlowOperationBL.updateRecordLog(recordLogTB);
				}
				//记录表单日志
				workFlowOperationBL.addRecordLogVarInfo(prInfoList, recordLog);
			}
			
		}
		
		//更新代理人做的工作。
		if(authorizeuser!= null) {
			IG463TB processProxyWorkTB;
			IG463SearchCondImpl processProxyWorkSearchCond = new IG463SearchCondImpl();
			processProxyWorkSearchCond.setPpwprid(pr.getPrid());
			processProxyWorkSearchCond.setPpwauthorizeuserid(authorizeuser.getUserid());
			processProxyWorkSearchCond.setPpwproxyuserid(user.getUserid());
			List<IG463Info> processProxyWorkList = workFlowOperationBL.searchProcessProxyWork(processProxyWorkSearchCond);
			//判断某一流程信息是否保存在代理人工作表中，如果存在更新时间，否则插入
			if(processProxyWorkList != null && processProxyWorkList.size()>0){
				processProxyWorkTB = (IG463TB)SerializationUtils.clone(processProxyWorkList.get(0));
				processProxyWorkTB.setPpwoptiontime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
			}else{
				processProxyWorkTB = new IG463TB();
				processProxyWorkTB.setPpwauthorizeuserid(authorizeuser.getUserid());
				processProxyWorkTB.setPpwcloseflag("0");
				processProxyWorkTB.setPpwoptiontime(CommonDefineUtils.DATETIME_FORMAT.format(new Date()));
				processProxyWorkTB.setPpwprid(pr.getPrid());
				processProxyWorkTB.setPpwproxyuserid(dto.getUser().getUserid());
				processProxyWorkTB.setPpwproxyusername(dto.getUser().getUsername());
				processProxyWorkTB.setPpwprserialnum(pr.getPrserialnum());
				processProxyWorkTB.setPpwprtitle(pr.getPrtitle());
				processProxyWorkTB.setPpwprtype(pr.getPrtype());
			}
			
			workFlowOperationBL.updateProcessProxyWork(processProxyWorkTB);
		}
		
		
		//判断是否执行了doflow，非提交类按钮也要触发按钮事件
		boolean flag_doflow = true;
		if((dto.getAction() != null && dto.getAction().compareTo("10") >= 0)
				&& !"1".equals(dto.getAssignFlag())) {
			String[] participants = form.getParticipants();
			if(!dto.isAssignParticipant()) {
				String[] ppsupers = form.getPpsupers();
				//组装节点参与者数据
				if(participants != null) {
					//为了打回时，重新分派时需要删除之前的参与者start
					Set<String> set_Status = new HashSet<String>();
					for(String str : participants) {
						set_Status.add(str.split("_", 3)[0]);
					}
					for(String status : set_Status) {
						IG337SearchCondImpl sppCond = new IG337SearchCondImpl();
						sppCond.setPrid(pr.getPrid());
						if (status.indexOf("_") > -1) {
							sppCond.setPsdid(status.split("_")[0]);
							sppCond.setPsdnum(Integer.parseInt(status.split("_")[1]));
						} else {
							sppCond.setPsdid(status);
						}
						List<IG337Info> sppList = workFlowOperationBL.searchProcessParticipants(sppCond);
						for(IG337Info pp : sppList) {
							workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
									"删除：" + pp.getPprolename()
									+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
						}
					}
					//为了打回时，重新分派时需要删除之前的参与者end
					
					String[] array = null;
					for(String str : participants) {
						array = str.split("_", 3);
						String ppsuper = null;
						if(ppsupers != null) {
							for(String per : ppsupers) {
								if((array[0] + "_" + array[1]).equals(per)) {
									ppsuper = per;
									break;
								}
							}
						}
						workFlowOperationBL.addParticipant(dto.getUser(), dto.getPrid(), pr.getPrpdid(), array[0],
								array[1], array[2], ppsuper, authorizeuser, dto.getAction(), form.getPrstatus());
					}
				}
			}
			
			if(!dto.isAssignParticipant() || lst_ProcessStatusDef == null || lst_ProcessStatusDef.isEmpty()) {
				String psdid = form.getPrstatus();
				if(StringUtils.isEmpty(psdid)) {
					psdid = form.getPsdid();
				}
				if(authorizeuser!= null) {
					//匹配跃迁
					this.workFlowOperationBL.doFlow(dto.getPrid(), dto.getUser(), form.getPrroleid(), datetime, role.getRolename(), psdid, dto.getAction(), form.getPrdesc(), 
							dto.getNodetype(), null, form.getPpsuper(), authorizeuser);
					flag_doflow = false;
				} else {
					//匹配跃迁
					this.workFlowOperationBL.doFlow(dto.getPrid(), dto.getUser(), form.getPrroleid(), datetime, role.getRolename(), psdid, dto.getAction(), form.getPrdesc(), 
							dto.getNodetype(), null, form.getPpsuper(), null);
					flag_doflow = false;
				}
				//查询跃迁后的流程信息
				IG500Info aftDoFlowPrInfo = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
				if("C".equals(aftDoFlowPrInfo.getPrstatus())){
					sendMessageToOpener(aftDoFlowPrInfo.getPruserid(), aftDoFlowPrInfo, "已关闭!");
				}
			}
		}
		
		//点击执行人按钮进入调整执行人页面
		if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(form.getAction())) {
			searchAdjustParticipantAction(this.workFlowDefinitionBL.searchAdjustStatus(form.getPsdid()), dto);
		}
		
		//this.workFlowOperationBL.registAndUpdateProcessPrivateInfo(processInfoList, form.getPrroleid(), user.getUserid(), form.getAtt(),form.getFileMapMuti(), form.getDelFileMutiStr());
		//非提交按钮事件处理
		if(flag_doflow) {
			WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			bean.setPbdid(form.getAction());//按钮ID
			if (form.getPsdid().indexOf("_") > -1) {
				bean.setBfstatus(form.getPsdid().split("_")[0]);//状态ID
				bean.setBfstatus(form.getPsdid().split("_")[1]);//状态ID编号
			} else {
				bean.setBfstatus(form.getPsdid());//状态ID
			}
			//日志参数信息
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setPrid(dto.getPrid());
			logInfo.setExecutorid(user.getUserid());
			logInfo.setExecutorRoleid(form.getPrroleid());
			if(authorizeuser != null) {
				logInfo.setAuthuserid(authorizeuser.getUserid());
			}
			bean.setLogInfo(logInfo);
			this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
		}
		if(dto.isAssignParticipant()) {
			dto.addMessage(new ActionMessage("IGPRR0102.I002"));
		} else {
			dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		}
		log.debug("========流程跃迁处理终了========");
		return dto;
	}
	
	/**
	 * 设置附件ID
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private  List<IG599Info> setAttkey(List<IG599Info> processInfoList,Integer roleid, String userid,String[] attStr,Map<Integer, FormFile> fileMapMuti, String delStr) throws BLException {
		//文本域绑定附件增加
		List<String> existStr = new ArrayList<String>();
		if(attStr!=null){
			for(int i = 0; i < attStr.length; i++){
				String[] att = attStr[i].split("_");
				if(existStr.contains(att[0])){
					continue;
				}
				Integer piid;
				for(int j = 0; j < processInfoList.size();j++){
					IG599TB piTB = (IG599TB)processInfoList.get(j);
					if(att[0].equals(piTB.getPivarlabel()) && IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(piTB.getPidmode())){
						piid = piTB.getPiid();
						IG599Info pi = workFlowOperationBL.getProcessInfoByID(piid);
						if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equalsIgnoreCase(pi.getPidmode())){
							continue;
						}
						IG899SearchCondImpl cond = new IG899SearchCondImpl();
						cond.setPiid(piid);
						if(IGPRDCONSTANTS.PRIVATESCOPE_USER.equalsIgnoreCase(piTB.getPrivatescope())){
							cond.setUserid(userid);
						}else if(IGPRDCONSTANTS.PRIVATESCOPE_ROLE.equalsIgnoreCase(piTB.getPrivatescope())){
							cond.setRoleid(roleid);
						}
						List<IG899Info> privateInfoList =  workFlowOperationBL.searchProcessPrivateInfo(cond);
						//私有表没有相关信息
						if(privateInfoList == null || privateInfoList.size() == 0){
							Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
							for(int k = 0; k < attStr.length;k++){
								if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
									if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
										filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
										if(!existStr.contains(pi.getPivarlabel())){
											existStr.add(pi.getPivarlabel());
										}
									}
								}
							}
							pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
							piTB.setPiattkey(pi.getPiattkey());
							processInfoList.set(j, piTB);
						}else{
							//私有表有相关信息，进行更改
							for(int iNum = 0; iNum < privateInfoList.size(); iNum++){
								IG899TB privateInfoTB = (IG899TB)privateInfoList.get(iNum);
								if(StringUtils.isNotEmpty(privateInfoTB.getPpiattkey())){
									Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
									for(int k = 0; k < attStr.length;k++){
										if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
											if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
												filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
												if(!existStr.contains(pi.getPivarlabel())){
													existStr.add(pi.getPivarlabel());
												}
											}
										}
									}
									workFlowOperationBL.addProcessInfoAtt(filemap, privateInfoTB.getPpiattkey());
								}else{
									Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
									for(int k = 0; k < attStr.length;k++){
										if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
											if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
												filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
												if(!existStr.contains(pi.getPivarlabel())){
													existStr.add(pi.getPivarlabel());
												}
											}
										}
									}
									pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
									piTB.setPiattkey(pi.getPiattkey());
									processInfoList.set(j, piTB);
								}
							}
						}
					}
				}
			}
		}
		
		return processInfoList;
	}
	
	
	
	/**
	 * 流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlActionForDrm(IGPRR01DTO dto) throws BLException {	
		

		StringBuffer isFocused = new StringBuffer();

		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//获取流程基本信息
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
			dto.setPdid(process.getPrpdid());
			
			List<String> list = workFlowOperationBL.searchCurrentRecordStatus(dto.getPrid());
			for(int i=0;i<list.size();i++){
				if(i > 0){
					isFocused.append(",");
				}
				
				if (!list.get(i).equals("null")) {
					String psdid = list.get(i).indexOf("_") >= 0 ? list.get(i).split("_")[0] : list.get(i);
					IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
					isFocused.append(list.get(i));
					if(info != null && StringUtils.isNotEmpty(info.getPpsdid())){
						isFocused.append(",");
						isFocused.append(info.getPpsdid());
					}
				} // end if 
			}
		}
		if(dto.getDprid() != null && dto.getDprid() > 0) {
			IG599SearchCondImpl piCond = new IG599SearchCondImpl();
			piCond.setPrid(dto.getDprid());
			piCond.setPivarname("流程定义ID");
			List<IG599Info> piList = workFlowOperationBL.searchProcessInfoByCond(piCond);
			if (piList != null && piList.size() > 0) {
				dto.setPdid(piList.get(0).getPivarvalue());
			}
		}
		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//获取流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(dto.getPdid());

			//获取流程图XML
			if(pd.getPdxml() != null){
				try{
					Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
					Element root = document.getRootElement();
					//查找当前流程状态所处的结点,并设置为高亮显示
					searchStep(root,isFocused.toString());
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
					dto.setXmlheight(getXMLHeight(dto.getFlowChartXml()));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","当前工作的流程状态图不存在。");
				}
			}
		}
		return dto;
	}
	
	
	
	/**
	 * 流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchFlowChartXmlAction(IGPRR01DTO dto) throws BLException {	
		
		StringBuffer isFocused = new StringBuffer();
		
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//获取流程基本信息
			getProcessRecord(dto);
			List<String> list = workFlowOperationBL.searchCurrentRecordStatus(dto.getPrid());
			for(int i=0;i<list.size();i++){
				if(i > 0){
					isFocused.append(",");
				}
				String psdid = list.get(i).indexOf("_") >= 0 ? list.get(i).split("_")[0] : list.get(i);
				IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
				isFocused.append(list.get(i));
				if(info != null && StringUtils.isNotEmpty(info.getPpsdid())){
					isFocused.append(",");
					isFocused.append(info.getPpsdid());
				}
			}
		}

		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//获取流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(dto.getPdid());
			if(StringUtils.isEmpty(isFocused.toString())){
				if(dto.getPrid() != null && dto.getPrid() > 0) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(pr.getPrstatus()) 
							|| IGPRDCONSTANTS.PROCESS_TERMINATE.equals(pr.getPrstatus())){
						isFocused.append(pd.getPdid()).append("002");
					}
				}
			}
			
			//获取流程图XML
			if(pd.getPdxml() != null){
				try{
					Document document = DocumentHelper.parseText(new String(pd.getPdxml()));
					Element root = document.getRootElement();
					//查找当前流程状态所处的结点,并设置为高亮显示
					searchStep(root,isFocused.toString());
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
					dto.setXmlheight(getXMLHeight(dto.getFlowChartXml()));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","当前工作的流程状态图不存在。");
				}
			}
		}
		return dto;
	}
	

	/**
	 * 流程图查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchGroupFlowChartXml(IGPRR01DTO dto) throws BLException {
		if(dto.getPrid() != null && dto.getPrid() > 0) {
			//获取流程基本信息
			IG483Info ig483info = ig483BL.searchIG483ByPK(dto.getPrid());
			if(null!=ig483info){
				dto.setPdid(ig483info.getPgdid());
				//获取流程组状态
				if(!StringUtils.isBlank(ig483info.getPgrclosetime())){
					//如果流程组实例有关闭时间 则该流程组实例已关闭
					dto.setStatus("C");
				}
			}
		}
		if(StringUtils.isNotEmpty(dto.getPdid())) {
			//获取流程定义信息
			IG480Info pgd = ig480BL.searchIG480ByPK(dto.getPdid());
			//获取流程图XML
			if(null != pgd.getPgdxml()){
				try{
					Document document = DocumentHelper.parseText(new String(pgd.getPgdxml()));
					dto.setFlowChartXml(document.asXML().replaceAll("\"", "'"));
				}catch (DocumentException e) {
					throw new BLException("IGPRD0104.E005","当前工作的流程状态图不存在。");
				}
			}
		}
		return dto;
	}
	
	/**
	 * 查找当前流程状态所处的结点,并设置为高亮显示
	 * 
	 * @param root
	 * @param psdid
	 */
	@SuppressWarnings("unchecked")
	private void searchStep(Element root, String psdids) {
		for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
			Element stepsElement = (Element) steps.next();
			for (Iterator<Element> step = stepsElement.elementIterator("Step"); step.hasNext();) {
				Element stepElement = (Element) step.next();
				for (Iterator<Element> baseProperties = stepElement.elementIterator("BaseProperties"); baseProperties.hasNext();) {
					Element bp = (Element) baseProperties.next();
					for (Iterator<Attribute> i = bp.attributeIterator(); i.hasNext();) {
						for (Iterator<Attribute> m = stepsElement.attributeIterator(); m.hasNext();) {
							Attribute stepAttribute = (Attribute) m.next();
							if("isFocusedId".equals(stepAttribute.getName())){
								stepAttribute.setValue(psdids);
								return;
							}
						}
					}

				}
			}
		}
	}
	
	
	/**
	 * <p>
	 * Description: 获取执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchProcessExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========执行人查询处理开始========");
		// 获取已添加角色
		List<IG602Info> lst_ProcessExecutorVW = workFlowOperationBL.searchProcessExecutors(dto.getUser().getUserid(), dto.getPrid());
		dto.setProcessExecutorVWList(lst_ProcessExecutorVW);
		log.debug("========执行人查询处理终了========");
		return dto;
	}
	

	/**
	 * <p>
	 * Description: 执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO adjustExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========调整执行人处理开始========");
		IGPRR0104Form form = dto.getIgPRR0104Form();
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		List<IG337Info> pplist = workFlowOperationBL.queryRolemanager(user.getUserid(), dto.getPrid());
		List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		List<String> userList = new ArrayList<String>();
		if(participants != null) {
			for(IG337Info pp : pplist) {
				for(int i = 0; i < participants.length; i++) {
					if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
						lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
						participants[i] = null;
						break;
					}
	 			}
			}
			//短信通知
			String datetime = IGStringUtils.getCurrentDateTime();
			//取得状态信息
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPsdcode(pr.getPrstatus());
			psdCond.setPdid(pr.getPrpdid());
			List<IG333Info> ig333List = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			IG333Info psdInfo = null;
			if(ig333List !=null && ig333List.size() > 0){
				psdInfo = ig333List.get(0);
			}else{
				throw new BLException("IGFLOW0000.E001", "状态（" + pr.getPrstatus() + "）");
			}
			//新增参与者
			Role role = null;
			User executor = null;
			for(String participant : participants) {
				if(participant != null) {
					role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
					executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
					userList.add(executor.getUserid());
					IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
					ppTB.setPproleid(role.getRoleid());
					ppTB.setPprolename(role.getRolename());
					ppTB.setPpuserid(executor.getUserid());
					ppTB.setPpusername(executor.getUsername());
					ppTB.setPporgid(executor.getOrgid());
					ppTB.setPporgname(executor.getOrgname());
					ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//参与者类型
					ppTB.setPpinittime(datetime);
					ppTB.setPrid(form.getPrid());
					ppTB.setPpstatus(pr.getPrstatus());
					this.workFlowOperationBL.addProcessParticipant(ppTB, user, role.getRoleid(),
							"(" + psdInfo.getPsdname() + ")添加：" + ppTB.getPprolename()
							+ (StringUtils.isEmpty(ppTB.getPpusername()) ? "" : "(" + ppTB.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,
							dto.getAuthorizeuser(), dto.getAction(), null);
				}
			}
		}
		for(IG337Info pp : pplist) {
			if(!lst_ppid_nodo.contains(pp.getPpid())) {
				this.workFlowOperationBL.removeProcessParticipant(pp, user, pp.getPproleid(),
						"删除：" + pp.getPprolename()
						+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
						IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL,
						dto.getAuthorizeuser(), dto.getAction(), null);
			}
		}
		this.workFlowOperationBL.sendMessage(
				this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
				userList, null, null, null, null, pr);
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========调整执行人处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 获取OA模式执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO searchAssignOAPersonAction(IGPRR01DTO dto) throws BLException {
		log.debug("========执行人查询处理开始========");
		IGPRR0109Form form = dto.getIgPRR0109Form();
		//获取OA模式执行人
		UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
		cond.setRoleida(form.getRoleid());
		List<UserInfo> userlist = this.userBL.searchUserInfo(cond);
		List<String> useridList = new ArrayList<String>();
		UserInfo ui = null;
		for(Iterator<UserInfo> iter = userlist.iterator(); iter.hasNext();) {
			ui = iter.next();
			//过滤角色负责人和值班人 
			if(IGPRDCONSTANTS.ROLEMANAGER.equals(ui.getRolemanager()) || 
					IGPRDCONSTANTS.DUTYPERSON.equals(ui.getDutyflag())) {
				iter.remove();
			}
		}
		
		//获取流程参与者
		IG337SearchCondImpl ppCond = new IG337SearchCondImpl(); 
		
		ppCond.setPrid(form.getPrid());
		
		ppCond.setPproleid(form.getRoleid());
		
		ppCond.setPpstatus(workFlowOperationBL.searchProcessRecordByKey(form.getPrid()).getPrstatus());
		
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppCond);
		
		IG337Info pp = null;
		for(Iterator<IG337Info> iter = pplist.iterator(); iter.hasNext();) {
			pp = iter.next();
			//角色负责人和值班人
			if(!IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) && 
					!IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
				useridList.add(pp.getPpuserid());
			}
		}
				
		//初始化复选框
		if(useridList.size() > 0) {
			form.setPpuserids(useridList.toArray(new String[0]));
		}
		dto.setUserInfoList(userlist);
		form.setRolename(this.roleBL.searchRoleByKey(form.getRoleid()).getRolename());
		log.debug("========执行人查询处理终了========");
		return dto;
	}
	

	/**
	 * <p>
	 * Description: 执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	
	public IGPRR01DTO assignOAPersonAction(IGPRR01DTO dto) throws BLException {
		log.debug("========执行人处理开始========");
		IGPRR0109Form form = dto.getIgPRR0109Form();
		
		User user = dto.getUser();
		//执行人ID
		String[] ppuserid = form.getPpuserids();
		
		//获取流程信息
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		
		//获取流程参与者
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		
		cond.setPrid(form.getPrid());
		
		cond.setPproleid(form.getRoleid());
		
		cond.setPpstatus(pr.getPrstatus());
		
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		IG337Info pp = null;
		if(ppuserid != null) {
			for(Iterator<IG337Info> iter = pplist.iterator(); iter.hasNext();) {
				pp = iter.next();
				//角色负责人和值班人
				if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
						IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					iter.remove();
					continue;
				}
				for(int i = 0; i < ppuserid.length; i++) {
					if(ppuserid[i].equals(pp.getPpuserid())) {//已存在执行人
						iter.remove();//剩下的就是需要删除的执行人
						ppuserid[i] = "";//剩下不为空的就是需要添加的执行人
						continue;
					}
				}
			}
			//删除执行人
			for(IG337Info participant : pplist) {
				workFlowOperationBL.removeProcessParticipant(participant,user,form.getRoleid(),
						"删除：" + participant.getPprolename()
						+ (StringUtils.isEmpty(participant.getPpusername()) ? "" : "(" + participant.getPpusername() + ")"),
						IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), null);
			}
			//添加执行人
			User implementor = null;
			String datetime = IGStringUtils.getCurrentDateTime();
			//短信通知列表
			List<String> userList = new ArrayList<String>();
			for(String userid : ppuserid) {
				if(StringUtils.isNotEmpty(userid)) {
					implementor = this.userBL.searchUserByKey(userid);
					IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
					ppTB.setPproleid(form.getRoleid());
					ppTB.setPprolename(form.getRolename());
					ppTB.setPpuserid(implementor.getUserid());
					ppTB.setPpusername(implementor.getUsername());
					ppTB.setPporgid(implementor.getOrgid());
					ppTB.setPporgname(implementor.getOrgname());
					ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//参与者类型
					ppTB.setPpinittime(datetime);
					ppTB.setPrid(form.getPrid());
					ppTB.setPpstatus(pr.getPrstatus());
					this.workFlowOperationBL.addProcessParticipant(ppTB, user,form.getRoleid(),
							"添加：" + ppTB.getPprolename()
							+ (StringUtils.isEmpty(ppTB.getPpusername()) ? "" : "(" + ppTB.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), null);
					userList.add(implementor.getUserid());
					
				}
			}
			this.workFlowOperationBL.sendMessage(
					this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
					userList, null, null, null, null, pr);
		}
		dto.setProcess(pr);
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========执行人处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 流程状态日志查看 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO searchRecordStatusLogAction(IGPRR01DTO dto) throws BLException {
		log.debug("========自定义工作状态日志查看处理开始========");
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","流程基本");
		}
		dto.setRecordStatusLogList(this.workFlowOperationBL.searchRecordStatusLog(dto.getPrid()));
		
		log.debug("========自定义工作状态日志查看处理终了========");
		return dto;
	}
	
	/**
	 * 流程关闭后显示所有表单变量
	 */
	private IGPRR01DTO initDefVarOnClose(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//取得流程
		IG500Info pr = dto.getProcess();
		
		//查询该流程的所有定义的表单变量
		List<IG007Info> infoDefList = workFlowOperationBL.getProcessInfoDefs(pr.getPrpdid());

		//查询该流程的所有表单变量
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(pr.getPrid());
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//根据流程变量找到变量定义表中的变量定义，将流程变量的值赋给与其对应的流程变量定义的对象，并将该流程变量定义对象的流程变量权限(pidaccess)设置为只读
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						IG599TB temppi = (IG599TB)SerializationUtils.clone(temp_pi);
						pitb.setPidvalue(temppi.getPivarvalue());
						pitb.setPiid(temppi.getPiid());
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						//pitb.setPrivateaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
						if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equalsIgnoreCase(pid.getPidmode())){
							if(null == temppi.getProcessPrivateInfofList() || temppi.getProcessPrivateInfofList().size() == 0){
								pitb.setProcessPrivateInfoList(null);
							}else{
								pitb.setProcessPrivateInfoList(temppi.getProcessPrivateInfofList());
							}
							pitb.setPidaccess(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL);
							dto.setRoleid(9999);
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setVarmap(dto.getRealmap());
			dto.setHid("1");
		}else{
			dto.setVarmap(dto.getProcessInfoDefmap());
			dto.setHid("0");
		}
		
		
        form.setProcessName(dto.getProcessName());
		
		
		return dto;
	}
	
	
	/**
	 * 流程处理页面初始化处理
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0102Action(IGPRR01DTO dto) throws BLException {
		//获取处理form
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//获取用户
		//User user = dto.getUser();
		
		//查询流程
		dto = getProcessRecord(dto);
		//查询表格类表单值
		dto = searchTableColumnValue(dto);
		//查询是否可以全局控制表单
		dto = isFormGlobalControl(dto);
		//初始化表格类表单
		dto.setColumnInfoMap(workFlowOperationBL.initTableFormAction(dto.getPdid()));
		//初始化流程表单值
		initProcessInfoFormValue(dto);
		//初始化人员类表单值
		initParticipantFormValue(dto);
		searchProcessTitleDef(dto);
		form.setPdid(dto.getPdid());
		
		//设置流程处理时间
		if (dto.getProcess().getPrclosetime()==null) {//当前流程状态为未关闭状态
			//处理时间的当前系统时间减去流程发起时间
			try {
				dto.setDealtime(getBetweenTimeNumber(dto.getProcess().getPropentime(),IGStringUtils.getCurrentDateTime()));
			} catch (Exception e) {
				throw new BLException("IGPRR0102.E008");
			}
		}else{//当前流程状态为关闭状态
			//处理时间的流程关闭时间减去流程发起时间
			try {
				dto.setDealtime(getBetweenTimeNumber(dto.getProcess().getPropentime(),dto.getProcess().getPrclosetime()));
			} catch (Exception e) {
				throw new BLException("IGPRR0102.E008");
			}	
		}
		
		//获取机构下拉列表值
		getOrgLabelValueBeans(dto);
		
		//设置流程状态，并根据当前流程状态取得参与者
		//获取流程当前状态集合
		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getProcess().getPrstatus()) && !IGPRDCONSTANTS.PROCESS_TERMINATE.equals(dto.getProcess().getPrstatus())) {
			List<String> lst_status = this.workFlowOperationBL.searchCurrentRecordStatus(dto.getProcess().getPrid());
			if(lst_status.size() > 1) {
				List<LabelValueBean> lst_LabelValueBean = new ArrayList<LabelValueBean>();
				IG333SearchCondImpl cond = new IG333SearchCondImpl();
				cond.setPdid(dto.getProcess().getPrpdid());
				IG333Info ig333Info = null;
				//填充页面用当前状态下拉列表
				for(String status : lst_status) {
					String psdid = "";
					if (status.indexOf("_") > -1) {
						psdid = status.split("_")[0];
					} else {
						psdid = status;
					}
					ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
					lst_LabelValueBean.add(new LabelValueBean(ig333Info.getPsdname(), status));
				}
				dto.setLst_status(lst_LabelValueBean);
			}
			if(StringUtils.isEmpty(form.getPrstatus())) {
				//未指定状态时，默认显示第一个待处理状态信息
				if(lst_status.isEmpty()) {
					dto.setStatus("");
				} else {
					dto.setStatus(lst_status.get(0));
				}
			} else {
				dto.setStatus(form.getPrstatus());
			}
		} else {
			//关闭或中止状态
			dto.setStatus(dto.getProcess().getPrstatus());
		}
		dto.setPsdcode(dto.getStatus());
		
		//获取处理角色列表
		dto = searchReadProcessParticipantRoleAction(dto);
		//====>130225Begin
		dto.setPsdassign(dto.getProcessStatusDef()!=null?dto.getProcessStatusDef().getPsdassign():"");
		//====>130225End
		//取得日志信息
		dto = getRecordLogs(dto);
		
		//查询关联流程(该流程被其他流程所关联)
		dto = getProcessRecordByRelations(dto);
		
		//非关闭状态
		if(StringUtils.isNotEmpty(dto.getStatus()) && !IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getStatus()) && !IGPRDCONSTANTS.PROCESS_TERMINATE.equals(dto.getStatus()) ){
			//获取处理角色信息
			dto = getProcessParticipantsByStatus(dto);
			
			//如果是流程管理员则可见可写所有表单
			List<Role> roleList = roleBL.getRoleByType(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
			Role role = roleList.get(0);
			if(dto.isAdminRole()){
				//List<LabelValueBean> roleList1 = new ArrayList<LabelValueBean>();
				List<LabelValueBean> roleList1 = dto.getLabelList();
				roleList1.add(new LabelValueBean(role.getRolename(),"0" + "_" + role.getRoleid() + "_" + dto.getUser().getUserid()));
				dto.setLabelList(roleList1);
			}
			
			//取得按钮
			dto = getActionList(dto);
		
			//如果是流程管理员则可见可写所有表单，且只能做管理员的事
			if(role.getRoleid().equals(dto.getRoleid())
					|| (StringUtils.isNotEmpty(dto.getPpidstr())
							&& role.getRoleid().toString().equals(dto.getPpidstr().split("_")[1]))
					|| (dto.getLabelList() != null && dto.getLabelList().size() > 0
							&& role.getRoleid().toString().equals(dto.getLabelList().get(0).getValue().split("_")[1]))){//流程管理员
				if(dto.getLst_ParticipantVisibleButtonVWInfo() != null) {
					dto.getLst_ParticipantVisibleButtonVWInfo().clear();
				}
				dto = initDefVarForAdmin(dto);
				dto.setRoleManager(false);
				dto.setSuperFlag(null);
			} else {
				//设置表单变量
				dto = initDefVar(dto);
				dto.setAdminRole(false);
			}
		}  else {
			//流程管理员所有表单可见
			if(dto.isAdminRole()){
				dto = initDefVarOnClose(dto);
			} else {
				//根据参与权限显示
				dto = searchProcessInfoForSearch(dto);
				if(dto.getRealmap()!=null){
					dto.setVarmap(dto.getRealmap());
				}else{
					dto.setVarmap(dto.getProcessInfoDefmap());
				}
				//不是流程参与者时，显示该流程的表单信息
				if(dto.getVarmap()==null||dto.getVarmap().size()<0){
					Map<String,IG007Info> processInfoDefnewmap=new HashMap<String, IG007Info>();
					processInfoDefnewmap=getPorcesssInfoDefNewMap(dto.getPrid(),dto.getPdid(),dto.getUser());
					if(processInfoDefnewmap!=null&&processInfoDefnewmap.size()>0){
						//删除隐藏的表单
						dto.setVarmap(processInfoDefnewmap);
						dto.setHid("1");
					}
				}
			}
			dto.addMessage(new ActionMessage("IGPRR0102.I004"));
		}
		//

		//表单校验未通过时，设置角色
		if((dto.getRoleid()!= null && dto.getRoleid()!=0 )&& (form.getIserr()!=null && form.getIserr()!=1)){
			form.setPpidstr(dto.getPpidstr());
		}
		if((form.getIserr()!=null && form.getIserr()==1)){
			form.setIserr(0);
		}
		form.setPsdid(dto.getPsdid());//发起状态ID，隐藏表单使用
		
		//获取状态私有表单值
		this.getStatusPrivateValue(dto);
	    //流程处于关闭状态下流程查看显示，需要将状态级表单以隐藏形式显示 
        this.statusCloseSeeOperate(dto) ;       
		return dto;
	}
	
	/**
	 * 流程跳转JSP取得
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchForwardJsp(IGPRR01DTO dto) throws BLException {
		log.debug("========流程跳转JSP页面查询处理开始========");
		String forward = workFlowOperationBL.searchForwardJsp(dto.getPdid(), dto.getPrid(), dto.getPjdtype(), dto.getUser());
		dto.setForwardJsp(forward);
		log.debug("========流程跳转JSP页面查询处理结束========");
		return dto;
	}
	
	/**
	 * 普通节点SUPER分派初始化
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO initIGPRR0113Action(IGPRR01DTO dto) throws BLException {
		log.debug("========参与者查询处理开始========");
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//查询当前节点信息
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPsdid());
		form.setPsdassign(psd.getPsdassign());
		form.setPsdtype(psd.getPsdtype());
		form.setPsdmode(psd.getPsdmode());
		if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
			//查询可被分派机构
			List<IG299Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusOrgDefInfoByPsdid(form.getPsdid());
			List<Organization> org_List = new ArrayList<Organization>();
			if(lst_ProcessStatusRoleDef!=null){
				for(IG299Info pro:lst_ProcessStatusRoleDef){
					org_List.add(pro.getOrg());
				}
			}
			// 获取已添加机构
			List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
			if(pplist != null){
				String[] ids = new String[pplist.size()];
				for(int i = 0; i < pplist.size(); i++){
					ids[i] = pplist.get(i).getPporgid() + "_"+pplist.get(i).getPporgname();
					//设定主办部门角色ID
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(pplist.get(i).getPpsuper())) {
						form.setPpsuperorgid(pplist.get(i).getPporgid()+"_"+pplist.get(i).getPporgname());
					}
				}
				form.setParticipants(ids);
			}
			
			dto.setOrg_List(org_List);
		}else{
			//查询已设定角色
			List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(form.getPsdid());
			// 获取已添加角色
			IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
			ppcond.setPrid(form.getPrid());
			ppcond.setPsdid(form.getPsdid());
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppcond);
//			List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
//			IG333Info psd = this.ig333BL.searchIG333InfoByKey(form.getPsdid());
//			form.setPsdassign(psd.getPsdassign());
//			form.setPsdtype(psd.getPsdtype());
//			form.setPsdmode(psd.getPsdmode());
			if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign()) || "0".equals(form.getFlag())) {
				List<Role> lst_Role = new ArrayList<Role>();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					lst_Role.add(psrd.getRole());
				}
				dto.setRoleList(lst_Role);
			} 
			if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
//			} else if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
				Map<Role, List<IG602Info>> map_ParticipantToBeAssign = new LinkedHashMap<Role, List<IG602Info>>();
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					cond.setRoleid(psrd.getRoleid());
					if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						cond.setOrgid_like(dto.getUser().getOrgid());
					}
					map_ParticipantToBeAssign.put(psrd.getRole(),
							this.workFlowOperationBL.searchSuperAssignExecutors(psrd.getRole().getRoleid(), form.getPrid()));
				}
				dto.setMap_ParticipantToBeAssign(map_ParticipantToBeAssign);
			}
			if(!pplist.isEmpty()) {
				String[] ids = new String[pplist.size()];
				for(int i = 0; i < pplist.size(); i++) {
					if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign()) || "0".equals(form.getFlag())) {
						ids[i] = pplist.get(i).getPproleid() + "_";
//					} else if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
					} 
					if(IGPRDCONSTANTS.PSDASSIGN_USER.equals(psd.getPsdassign()) || "1".equals(form.getFlag())) {
						ids[i] = pplist.get(i).getPproleid() + "_" + (pplist.get(i).getPpuserid() == null ? "" : pplist.get(i).getPpuserid());
					}
					//设定主办部门角色ID
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(pplist.get(i).getPpsuper())) {
						form.setPpsuperid(pplist.get(i).getPproleid());
					}
				}
				form.setParticipants(ids);
			}
		}
		
		log.debug("========参与者查询处理终了========");
		return dto;
	}
	
	/**
	 * SUPER角色参与者分派处理
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantBySuper(IGPRR01DTO dto) throws BLException {
		log.debug("========参与者分派处理开始========");
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//获取流程信息
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		dto.setProcess(pr);
		List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
		String selected_participants = form.getSelected_participants();
		List<String> lst_Selected = null;
		if(StringUtils.isNotEmpty(selected_participants)) {
			lst_Selected = Arrays.asList(selected_participants.split("###"));
		} else {
			lst_Selected = new ArrayList<String>();
		}
		List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
		String[] participants = form.getParticipants();
		List<IG337Info> participantPptypeRList = new ArrayList<IG337Info>();
		if(participants != null) {
			for(IG337Info pp : pplist) {
			    if (pp.getPptype().equals(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE)) {
			        participantPptypeRList.add(pp);
			    }
				for(int i = 0; i < participants.length; i++) {
					if(StringUtils.isEmpty(form.getFlag())) {//Super分派
						//判断是否可指定人
						if(IGPRDCONSTANTS.MODE_NORMAL.equals(form.getPsdmode()) && IGPRDCONSTANTS.PSDASSIGN_USER.equals(form.getPsdassign())) {
							if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
								lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
								participants[i] = null;
								break;
							}
						} else {
							if((pp.getPproleid() + "_").equals(participants[i])) {
								lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
								participants[i] = null;
								break;
							}
						}
					} else if("0".equals(form.getFlag())) {//管理员调整角色
						if((pp.getPproleid() + "_").equals(participants[i])) {
							lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
							participants[i] = null;
							break;
						}
					} else if("1".equals(form.getFlag())) {//管理员调整人员，保留未指定人员的角色
						if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(participants[i])) {
							lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
							participants[i] = null;
							break;
						} 
	//					else if(participants[i] != null && !participants[i].startsWith(pp.getPproleid() + "_")) {
	//						lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
	//						participants[i] = null;
	//						break;
	//					}
					}
				}
			}
		}
		String datetime = IGStringUtils.getCurrentDateTime();
		//参与者增加
		List<IG337Info> participantList= new ArrayList<IG337Info>();
		List<String> userList = new ArrayList<String>();
		UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
		List<UserInfo> uilist = null;
		if(participants != null){
			Role role = null;
			User executor = null;
			for(String participant : participants){
				if(StringUtils.isNotEmpty(participant)) {
					role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
					IG337TB newParticipant = this.workFlowOperationBL.getProcessParticipantTBInstance();
					newParticipant.setPrid(form.getPrid());
					newParticipant.setPpinittime(datetime);
					newParticipant.setPpstatus(pr.getPrstatus());
					
					String psdid = "";
					if(form.getPrstatus() == null) {
						//do nothing
					} else {
						psdid = form.getPrstatus();
						if (psdid.length() > 1) {
							if (psdid.indexOf("_") > -1) {
								newParticipant.setPsdid(psdid.split("_")[0]);
								newParticipant.setPsdnum(new Integer(psdid.split("_")[1]));
							} else {
								newParticipant.setPsdid(psdid);
							}
						} else {
							//do nothing
						}
					}
					newParticipant.setPproleid(role.getRoleid());
					newParticipant.setPprolename(role.getRolename());
					if(role.getRoleid().equals(form.getPpsuperid())) {
						newParticipant.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
					}
					if(IGPRDCONSTANTS.MODE_NORMAL.equals(form.getPsdmode())) {//普通模式可以加人
						if(StringUtils.isEmpty(participant.split("_", 2)[1])) {
							newParticipant.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
						} else {
							executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
							userList.add(executor.getUserid());
							newParticipant.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							
							newParticipant.setPpuserid(executor.getUserid());
							
							newParticipant.setPpusername(executor.getUsername());
							
							newParticipant.setPporgid(executor.getOrgid());
							
							newParticipant.setPporgname(executor.getOrgname());
						}
						participantList.add(newParticipant);
					} else {
							cond.setRoleida(role.getRoleid());
							//如果是OA模式，则将值班人和角色负责人做为参与者
							uilist = this.userBL.searchUserInfo(cond);
							
							//角色负责人存在标识
							boolean flag = true;
							
							for(UserInfo info : uilist) {
								//是否角色负责人
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
									flag = false;
									IG337TB tb = (IG337TB)SerializationUtils.clone(newParticipant);
									tb.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
									tb.setPpuserid(info.getUserida());
									tb.setPpusername(info.getUsername());
									tb.setPporgid(info.getOrgida());
									tb.setPporgname(info.getOrgname());
									participantList.add(tb);
								}
								//是否值班人
								if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
									IG337TB tb = (IG337TB)SerializationUtils.clone(newParticipant);
									tb.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
									tb.setPpuserid(info.getUserida());
									tb.setPpusername(info.getUsername());
									tb.setPporgid(info.getOrgida());
									tb.setPporgname(info.getOrgname());
									participantList.add(tb);
								}
							}
							
							if(flag) {
								throw new BLException("IGCO10000.E004","角色（"+ newParticipant.getPprolename() + "）负责人基本");
							}
						}
					}
				} 
			}
		//添加参与者
		for(IG337Info pp : participantList) {
			this.workFlowOperationBL.addProcessParticipant(pp, dto.getUser(),form.getRoleid(),
					"添加：" + pp.getPprolename()
					+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
					IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,null,
					IGPRDCONSTANTS.RECORDLOG_TYPE_CL, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
			// 添加具体人员为参与者时，需删除指定为角色的参与者信息。
		    for (int i = 0 ; i < participantPptypeRList.size() ; i++) {
		        IG337Info ig337info = participantPptypeRList.get(i);
		        if (ig337info.getPproleid().equals(pp.getPproleid())) {
		            this.workFlowOperationBL.removeProcessParticipant(ig337info, dto.getUser(), ig337info.getPproleid(),
                            "删除：" + ig337info.getPprolename()
                            + (StringUtils.isEmpty(ig337info.getPpusername()) ? "" : "(" + ig337info.getPpusername() + ")"),
                            IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
                            IGPRDCONSTANTS.RECORDLOG_TYPE_CL,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
		            participantPptypeRList.remove(ig337info);
		            i--;
		        }
            }
		}
		for(IG337Info pp : pplist) {
			//跳转角色
			if("0".equals(form.getFlag())) {
				if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
						pp.getPproleid() + "_")) {
					this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(),
							"删除：" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			} else {
				if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
						pp.getPproleid() + "_"
								+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
					this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(), 
							"删除：" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			}
		}
		//检验当前状态所有参与者是否处理完成,全部处理完成则按最后一个处理人的记录跃迁
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		//给新增加的参与者发通知
		boolean flag = false;
		String psdid = "";
		if(form.getPrstatus() == null) {
			//do nothing
		} else {
			psdid = form.getPrstatus();
			if (psdid.length() > 1) {
				if (psdid.indexOf("_") > -1) {
					flag = true;
					psdid = psdid.split("_")[0];
				} else {
					flag = true;
				}
			} else {
				//do nothing
			}
		}
		if(flag) {
			this.workFlowOperationBL.sendMessage(psdid,
					userList, null, null, null, null, pr);
		} else {
			this.workFlowOperationBL.sendMessage(
					this.workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus()),
					userList, null, null, null, null, pr);
		}
		dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		log.debug("========参与者分派处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 通过流程状态和流程id查询参与者
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	private IGPRR01DTO getProcessParticipantsByStatusPrid(IGPRR01DTO dto) throws BLException {
		
		String status = dto.getStatus();
		if(StringUtils.isNotEmpty(status)) {
			List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipant(dto.getPrid(), status);
			dto.setProcessParticipantList(pplist);
		}
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 通过流程id和login用户查询授权者
	 * </p>
	 * 
	 * @param dto IGSVC02DTO
	 * @return IGSVC02DTO
	 * @throws BLException
	 * @author   
	 */
	
	public IGPRR01DTO getAuthorizeuser(IGPRR01DTO dto) throws BLException {
		IGPRR0102Form form = (IGPRR0102Form) dto.getIgPRR0102Form();
		// 根据id查询流程记录
		IG500TB processRecordTB = (IG500TB) workFlowOperationBL.searchProcessRecordByKey(form.getPrid());

		// 流程节点查询条件设置
		IG333SearchCondImpl pscond = new IG333SearchCondImpl();
//		pscond.setPsdcode(processRecordTB.getPrstatus());
		pscond.setPsdcode(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(processRecordTB.getPrstatus())?IGPRDCONSTANTS.PROCESS_END_STATUS:processRecordTB.getPrstatus());
		pscond.setPdid(processRecordTB.getPrpdid());

		// 流程节点状态信息查询
		List<IG333Info> list = workFlowDefinitionBL.searchProcessStatusDef(pscond);
		String psmode = list.get(0).getPsdmode();

		IG711SearchCondImpl cond = new IG711SearchCondImpl();
		// BL取得

		cond.setLoginUser(dto.getUser().getUserid());
		cond.setPaflag("1");// 授权中
		List<IG711Info> processAccreditList = null;

		// 当节点模式为OA模式时直接判断授权
		if (psmode.equals(IGPRR01BLType.PROCESSMODE_OA)) {
			// 授权信息查询
			processAccreditList = workFlowOperationBL.searchProcessAccredit(cond);
			if (processAccreditList != null && processAccreditList.size() > 0) {

				String patype = processAccreditList.get(0).getPatype();
				String auid = processAccreditList.get(0).getPaiid();
				List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(auid);
				boolean workflag = true;
				boolean hasAuthorizeuser = false;
				// 单一工作授权模式
				if ("1".equals(patype)) {

					if (!form.getPrid().equals(
							processAccreditList.get(0).getPaprocessid())) {
						workflag = false;
					}
				}
				// 所有工作授权模式
				if ("0".equals(patype) || workflag) {
					dto.setPrid(form.getPrid());
					dto.setStatus(form.getPrstatus());
					dto = getProcessParticipantsByStatusPrid(dto);
					List<IG337Info> pplist = dto
							.getProcessParticipantList();
					if (pplist != null) {
						for (int i = 0; i < pplist.size(); i++) {
							if (pplist.get(i).getPpproctime() == null) {// 该用户未处理的情况
								if (auid.equals(pplist.get(i).getPpuserid())) {// 按照用户id过滤
									hasAuthorizeuser = true;
									break;
								} else if (userroleList != null) {// 按照角色过滤
									for (UserRoleInfo uri : userroleList) {
										if (uri.getRoleid().equals(
												pplist.get(i).getPproleid())) {
											hasAuthorizeuser = true;
											break;
										}
									}
								}
							}
						}
					}

				}
				if (hasAuthorizeuser) {

					User authorizeuser = userBL.searchUserByKey(auid);
					dto.setAuthorizeuser(authorizeuser);
				}

			}
		} else
		// 当节点模式为普通模式时先判断是否是当前登录用户的相关工作，再判断授权
		if (psmode.equals(IGPRR01BLType.PROCESSMODE_MO)) {

			// 设置相关工作标识
			Boolean falg = false;

			// 获取用户信息
			User user = dto.getUser();

			// 查询当前用户角色
			List<UserRoleInfo> roleList = userRoleBL.getUserRoles(user
					.getUserid());

			IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
			List<IG337Info> ppList;
			for (UserRoleInfo ur : roleList) {// 循环遍历当前用户角色
				// 设置参与人员查询条件
				ppcond.setPrid(form.getPrid());
				ppcond.setPpstatus(processRecordTB.getPrstatus());
				ppcond.setPproleid(ur.getRoleid());
				// 查询参与人员信息
				ppList = this.workFlowOperationBL
						.searchProcessParticipants(ppcond);

				// 判断结果集是否为空
				if (ppList != null && ppList.size() > 0) {// 不为空说明是当前用户的相关工作
					// falg值更改为
					falg = true;
					// 推出循环
					break;
				}
			}

			// falg值为false时说明不为当前用户的相关工作，则进行授权判断
			if (!falg) {
				// 授权信息查询
				processAccreditList = workFlowOperationBL.searchProcessAccredit(cond);

				if (processAccreditList != null
						&& processAccreditList.size() > 0) {

					String patype = processAccreditList.get(0).getPatype();
					String auid = processAccreditList.get(0).getPaiid();
					List<UserRoleInfo> userroleList = userRoleBL
							.getUserRoles(auid);
					boolean workflag = true;
					boolean hasAuthorizeuser = false;
					// 单一工作授权模式
					if ("1".equals(patype)) {

						if (!form.getPrid().equals(
								processAccreditList.get(0).getPaprocessid())) {
							workflag = false;
						}
					}
					// 所有工作授权模式
					if ("0".equals(patype) || workflag) {
						dto.setPrid(form.getPrid());
						dto.setStatus(form.getPrstatus());
						dto = getProcessParticipantsByStatusPrid(dto);
						List<IG337Info> pplist = dto
								.getProcessParticipantList();
						if (pplist != null) {
							for (int i = 0; i < pplist.size(); i++) {
								if (pplist.get(i).getPpproctime() == null) {// 该用户未处理的情况
									if (auid
											.equals(pplist.get(i).getPpuserid())) {// 按照用户id过滤
										hasAuthorizeuser = true;
										break;
									} else if (userroleList != null) {// 按照角色过滤
										for (UserRoleInfo uri : userroleList) {
											if (uri
													.getRoleid()
													.equals(
															pplist
																	.get(i)
																	.getPproleid())) {
												hasAuthorizeuser = true;
												break;
											}
										}
									}
								}
							}
						}

					}
					if (hasAuthorizeuser) {

						User authorizeuser = userBL.searchUserByKey(auid);
						dto.setAuthorizeuser(authorizeuser);
					}

				}
			}
		}

		return dto;
	}
	
	public IGPRR01DTO terminate(IGPRR01DTO dto) throws BLException {
		log.debug("========管理员中止处理开始========");
		//IGPRR0106Form form = dto.getIgPRR0106Form();
		IGPRR0102Form form = dto.getIgPRR0102Form();
		User user = dto.getUser();
		//管理员调整
		List<Role> roleList = roleBL.getRoleByType(WorkFlowConstDefine.PROCESSADMIN_ROLE_TYPE);
		form.setRoleid(roleList.get(0).getRoleid());
		if(0 == roleList.size()){
			throw new BLException("IGCO10000.E004","流程管理员角色");
		}
		form.setPrrolename(roleList.get(0).getRolename());
		String datetime = IGStringUtils.getCurrentDateTime();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		if(pr == null){
			throw new BLException("IGCO10000.E004","工作基本");
		}
		
		//流程终止时可以调用特殊处理  start  wangtingzhi 20130422
		//自定义事件处理BL
		WorkFlowEventHandlerBL bl = null;
		//获取源状态后处理事件列表
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPdid(pr.getPrpdid());
		cond.setPedtype(IGPRDCONSTANTS.PROCESS_TERMINATE);
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if(pedList!=null&&!pedList.isEmpty()){
			igflowlog.debug("========================"
                    + pr.getPrserialnum()
                    + "后处理事件开始========================");
		    igflowlog.debug("流程类型名称：" + pr.getPrpdname());
		    igflowlog.debug("流程类型ID：" + pr.getPrpdid());
            igflowlog.debug("流程ID：" + pr.getPrid());
            igflowlog.debug("操作用户ID：" + user.getUserid());
            igflowlog.debug("处理角色ID：" + form.getRoleid());
            for(IG413Info ped:pedList){
            	try {
	                bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
	            } catch (Exception e) {
	                throw new BLException("IGCO10000.E004", "后处理事件定义");
	            }
	            igflowlog.debug("调用BL" + ped.getPedorder()+":"+ ped.getPedblid());
	          //前后处理参数信息
	    		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
	    		bean.setPdid(pr.getPrpdid());
	    		bean.setPbdid(IGPRDCONSTANTS.BUTTON_TERMINATE);
	    		bean.setBfstatus(pr.getPrstatus());
	    		bean.setAfstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
	    		bean.setCrtroleid(pr.getPrroleid());
	    		bean.setCrtuserid(pr.getPruserid());
	    		//日志参数信息
	    		WorkFlowLog logInfo = new WorkFlowLog();
	    		logInfo.setPrid(pr.getPrid());
	    		logInfo.setExecutorid(user.getUserid());
	    		logInfo.setExecutorRoleid(form.getRoleid());
	    		bean.setLogInfo(logInfo);
	            bl.afterTreatmentExecute(bean);
            }
		}
		
		//查询当前节点节点参与人 
		IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
		ppcond.setPrid(pr.getPrid());
		ppcond.setPpstatus(pr.getPrstatus());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(ppcond);
		if(pplist!=null){
			for(IG337Info pp:pplist){
				if(StringUtils.isEmpty(pp.getPpproctime())){
					IG337TB ppTB = (IG337TB) SerializationUtils.clone(pp);
					ppTB.setPpproctime(IGStringUtils.getCurrentDateTime());
					workFlowOperationBL.updateProcessParticipant(ppTB);
				}
			}
		}
		
		//获取当前流程状态
		String currentStatus = workFlowDefinitionBL.searchProcessStatusKey(pr.getPrpdid(), pr.getPrstatus());
		
		//流程终止时可以调用特殊处理  end  wangtingzhi 20130422
		//添加流程终止的状态日志
		workFlowOperationBL.addRecordStatusLog(pr.getPrid(), pr.getPrpdid(), pr.getPrtype(), currentStatus, IGPRDCONSTANTS.PROCESS_TERMINATE, WorkFlowConstDefine.STATUSTYPE_END_TERMINATE, pr.getPid());
		IG500TB processRecord = (IG500TB)SerializationUtils.clone(pr);
		processRecord.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
		processRecord.setPrclosetime(datetime);
		workFlowOperationBL.updateProcessRecord(pr.getPrstatus(),processRecord,user,form.getPrroleid(),form.getRlcomment(),
				IGPRDCONSTANTS.COMMENT_TERMINATE_MESSAGE,form.getFileMap(),
				IGPRDCONSTANTS.RECORDLOG_TYPE_CL, dto.getAuthorizeuser(), null, form.getPrstatus());
		dto.setProcess(pr);
		sendMessageToOpener(pr.getPruserid(), pr,"中止");
		dto.addMessage(new ActionMessage("IGPRR0106.I001",dto.getPrid()));
		log.debug("========管理员中止处理终了========");
		return dto;
	}
	
	/**
	 * 给发起者发短信
	 * 
	 * @param userid
	 * @param prid
	 * @throws BLException 
	 */
	private void sendMessageToOpener(String userid, IG500Info ig500, String sms) throws BLException{
		List<String> lst_Userid = new ArrayList<String>();
		lst_Userid.add(userid);
		String message ="关于("+ig500.getPrtitle()+")的"+ig500.getPrpdname()+"工作已"+sms+"。";
		this.workFlowOperationBL.sendMessage(
				this.workFlowDefinitionBL.searchProcessStatusKey(ig500.getPrpdid(), IGPRDCONSTANTS.PROCESS_TERMINATE.equals(ig500.getPrstatus())?IGPRDCONSTANTS.PROCESS_END_STATUS:ig500.getPrstatus()),
				lst_Userid, message, null, null, null, ig500);
	}
	//文本域附件获得
	public IGPRR01DTO getProcessInfoAtt(IGPRR01DTO dto) throws BLException {
		log.debug("========获取文本域附件获得处理开始========");
		List<IG036Info> recordLogList = null;
		
			recordLogList = workFlowOperationBL.searchRecordLogForProcessDef(dto.getPrid());
			dto.setRecordLogList(recordLogList);
		log.debug("========获取文本域附件获得处理终了========");
		return dto;
	}
	public Map<String,List<Attachment>> getProcessInfo(int prid) throws BLException{
		//查询ProcessInfo
		List<IG599Info> processInfolist = workFlowOperationBL.getProcessInfo(prid);
		Map<String,List<Attachment>> map=new LinkedHashMap<String,List<Attachment>>();
		for(int i=0;i<processInfolist.size();i++){
			if(processInfolist.get(i).getPiattkey()!=null){
				List<Attachment> list = workFlowOperationBL.searchProcessInofAtt(processInfolist.get(i).getPiattkey());
				map.put(processInfolist.get(i).getPivarname(), list);
			}
		}
		return map;
	}

	/**
	 * 删除附件信息
	 * 
	 * @param attid
	 * @param rlid
	 * @throws BLException
	 */
	public boolean deleteFile(Integer attid, Integer rlid) throws BLException{
		
		// 根据附件主键查询附件信息
		Attachment attachment = this.attachmentBL.searchAttachmentByKey(attid);
		// 物理删除附件信息
		if(attachment != null){
			this.attachmentBL.deleteAttachment(attachment);
		}else{
			return false;
		}
		return true;
	}
	
	/**
	 * 发起角色信息查询处理
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	private IGPRR01DTO searchProcessTitleDef(IGPRR01DTO dto) throws BLException {
		
		log.debug("========发起流程主题查询处理开始========");
		//设置流程主题查询条件
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPdid(dto.getPdid());
		List<IG243Info> lstProcessTitleDef = this.workFlowDefinitionBL.searchProcessTitleDef(cond);
		if(lstProcessTitleDef == null || lstProcessTitleDef.size() ==0) {
			IG243TB tb = new IG243TB();
			tb.setPtitleaccess(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT);
			tb.setPdescaccess(IGPRDCONSTANTS.PROCESSTITLE_DEFAULT);
			dto.setPtdTB(tb);
		}else{
			dto.setPtdTB((IG243TB)lstProcessTitleDef.get(0));
		}
		log.debug("========发起流程主题查询处理终了========");
		return dto;
	}
	
	/**
	 * 指定状态可分派角色（包括用户）查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantDefToBeAssignAction(IGPRR01DTO dto) throws BLException {
		log.debug("========指定状态可分派角色查询（包括用户）处理开始========");
		//查询已设定角色
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(dto.getProcessStatusDef().getPsdid());
		Map<Role, List<UserRoleInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserRoleInfo>>();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			cond.setRoleid(psrd.getRoleid());
			if(IGPRDCONSTANTS.PSDORG_YES.equals(dto.getProcessStatusDef().getPsdorg())) {
				cond.setOrgid_like(dto.getUser().getOrgid());
			}
			map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userRoleBL.searchUserRoleVW(cond));
		}
		dto.setMap_ParticipantDefToBeAssign(map_ParticipantDefToBeAssign);
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(dto.getProcessStatusDef().getPsdid());
		List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
		if(!lst_ProcessParticipantDef.isEmpty()) {
			String[] ids = new String[lst_ProcessParticipantDef.size()];
			for(int i = 0; i < lst_ProcessParticipantDef.size(); i++) {
				if(StringUtils.isNotEmpty(lst_ProcessParticipantDef.get(i).getUserid())) {
					ids[i] = lst_ProcessParticipantDef.get(i).getRoleid() + "_" + lst_ProcessParticipantDef.get(i).getUserid();
				}
			}
			dto.getIgPRR0102Form().setParticipants(ids);
			dto.getIgPRR0102Form().setParticipants_(ids);
		}
		log.debug("========指定状态可分派角色查询（包括用户）处理结束========");
		return dto;
	}
	
	/**
	 * 指定状态可分派角色（不包括用户）查询
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchRoleDefToBeAssignAction(IGPRR01DTO dto) throws BLException {
		log.debug("========可参与流程角色查询（不包括用户）处理开始========");
		//查询已设定角色
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(dto.getProcessStatusDef().getPsdid());
		List<Role> lst_Role = new ArrayList<Role>();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			lst_Role.add(psrd.getRole());
		}
		dto.setRoleList(lst_Role);
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(dto.getProcessStatusDef().getPsdid());
		List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
		if(!lst_ProcessParticipantDef.isEmpty()) {
			String[] ids = new String[lst_ProcessParticipantDef.size()];
			for(int i = 0; i < lst_ProcessParticipantDef.size(); i++) {
				ids[i] = lst_ProcessParticipantDef.get(i).getRoleid() + "_";
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(lst_ProcessParticipantDef.get(i).getPpdsuper())) {
					dto.getIgPRR0102Form().setPpsuper(lst_ProcessParticipantDef.get(i).getRoleid().toString());
				}
			}
			dto.getIgPRR0102Form().setParticipants(ids);
			dto.getIgPRR0102Form().setParticipants_(ids);
		}
		log.debug("========可参与流程角色查询（不包括用户）处理结束========");
		return dto;
	}
	

	@SuppressWarnings("unchecked")
	private String getXMLHeight(String xml) throws BLException{
		Document document;
		String xmlheight = "";
		try {
			document = (Document) DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			List<Integer> yList = new ArrayList<Integer>();
			for (Iterator<Element> steps = root.elementIterator("Steps"); steps.hasNext();) {
				Element stepsElement = (Element) steps.next();
				for(Iterator<Element> step = stepsElement.elementIterator("Step"); step.hasNext();){
					Element stepElement = (Element) step.next();
					for(Iterator<Element> vml = stepElement.elementIterator("VMLProperties"); vml.hasNext();){
						Element vmlElement = (Element) vml.next();
						String y = vmlElement.attributeValue("y").replace("px", "");
						yList.add(Integer.parseInt(new DecimalFormat("#0").format(Double.parseDouble(y))));
					}
				}
			}
			Collections.sort(yList);
			xmlheight = (yList.get(yList.size()-1) + 100) + "";
		} catch (DocumentException e) {
			throw new BLException("IGPRR0102.E007","取得流程图高度出错。");
		}
		return xmlheight;
	}
	
	/**
	 * 可分派参与者查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAssignParticipantAction(IGPRR01DTO dto) throws BLException {
		log.debug("========可分派参与者查询处理开始========");
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(dto.getPsdid(), dto.getAction());
		if(lst_ProcessStatusDef != null && !lst_ProcessStatusDef.isEmpty()) {
			dto.setMap_AssignParticipant(new LinkedHashMap<IG333Info, IGPRR01036VO>());
			dto.setLst_participant(new ArrayList<String>());
			dto.setLst_ppsuper(new ArrayList<String>());
			for(IG333Info psd : lst_ProcessStatusDef) {
				//是否并行节点，并行节点可以动态增加参与角色，和指定super角色
				if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())) {
					if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())){
						dto = searchAssignRoleAction(psd, dto);
					} else {//普通模式
						//判断可被分派参与者类型
						if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign())) {
							dto = searchAssignRoleAction(psd, dto);
						} else {
							dto = searchAssignUserAction(psd, dto);
						}
					}
				} else {
					if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())){
						dto = searchAssignRoleAction(psd, dto);
					} else {//普通模式
						//判断可被分派参与者类型
						if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(psd.getPsdassign())) {
							dto = searchAssignRoleAction(psd, dto);
						} else {
							dto = searchAssignUserAction(psd, dto);
						}
					}
				}
			}
		}
		log.debug("========可分派参与者查询处理结束========");
		return dto;
	}
	/**
	 * 指定状态可分派角色查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private IGPRR01DTO searchAssignUserAction(IG333Info psd, IGPRR01DTO dto) throws BLException {
		log.debug("========指定状态可分派用户查询处理开始========");
		//查询已设定角色
		List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
		Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
		UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
		for(IG298Info psrd : lst_ProcessStatusRoleDef) {
			userInfoCond.setRoleida(psrd.getRoleid());
			if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
				userInfoCond.setOrgida(dto.getUser().getOrgid());
			}
			//按指定机构过滤
			if(StringUtils.isNotEmpty(dto.getAssign_orgsyscoding())) {
				userInfoCond.setOrgida(dto.getAssign_orgsyscoding());
			}
			map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userBL.searchUserInfo(userInfoCond));
		}
		IGPRR01036VO vo = new IGPRR01036VO();
		vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
		dto.getMap_AssignParticipant().put(psd, vo);
		
		//查询已添加参与者
		List<IG337Info> lst_ProcessParticipant =
			this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
		if(!lst_ProcessParticipant.isEmpty()) {
			for(IG337Info pp : lst_ProcessParticipant) {
				if(StringUtils.isNotEmpty(pp.getPpuserid())) {
					dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
							+ "_" + pp.getPpuserid());
				} else {
					dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
							+ "_");
				}
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(pp.getPpsuper())) {
					dto.getLst_ppsuper().add(psd.getPsdid() + "_" + pp.getPproleid());
				} else {
					dto.getLst_ppsuper().add("");
				}
			}
		}
		
		//如果没有添加参与者，则查找默认参与者
		if(lst_ProcessParticipant.isEmpty()) {
			IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
			ppdCond.setPsdid(psd.getPsdid());
			List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
			if(!lst_ProcessParticipantDef.isEmpty()) {
				for(IG222Info ppd : lst_ProcessParticipantDef) {
					if(StringUtils.isNotEmpty(ppd.getUserid())) {
						dto.getLst_participant().add(psd.getPsdid() + "_" + ppd.getRoleid()
								+ "_" + ppd.getUserid());
					}
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(ppd.getPpdsuper())) {
						dto.getLst_ppsuper().add(psd.getPsdid() + "_" + ppd.getRoleid());
					} else {
						dto.getLst_ppsuper().add("");
					}
				}
			}
		}
		log.debug("========指定状态可分派用户查询处理结束========");
		return dto;
	}
	
	/**
	 * 指定状态可分派角色查询
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	private IGPRR01DTO searchAssignRoleAction(IG333Info psd, IGPRR01DTO dto) throws BLException {
		log.debug("========指定状态可分派角色查询处理开始========");
		//区分是按角色分派，还是按机构分派
		if(psd != null){
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
				List<IG299Info> lst_ProcessStatusOrgDef = this.workFlowDefinitionBL.searchProcessStatusOrgDefInfoByPsdid(psd.getPsdid());
				Map<Organization, List<UserInfo>> map_ParticipantDefToBeAssignByOrg = new LinkedHashMap<Organization, List<UserInfo>>();
				if(lst_ProcessStatusOrgDef != null){
					for(IG299Info psrd:lst_ProcessStatusOrgDef){
						map_ParticipantDefToBeAssignByOrg.put(psrd.getOrg(), null);
					}
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByOrg(map_ParticipantDefToBeAssignByOrg);
				dto.getMap_AssignParticipant().put(psd, vo);
			}else{
				//查询已设定角色
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
				for(IG298Info psrd : lst_ProcessStatusRoleDef) {
					map_ParticipantDefToBeAssign.put(psrd.getRole(), null);
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
				dto.getMap_AssignParticipant().put(psd, vo);
			}
		}
		
		//查询已添加参与者
		List<IG337Info> lst_ProcessParticipant =
			this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
		if(!lst_ProcessParticipant.isEmpty()) {
			for(IG337Info pp : lst_ProcessParticipant) {
				if(StringUtils.isNotEmpty(pp.getPpuserid())) {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + pp.getPproleid()
							+ "_" + pp.getPpuserid());
				} else {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + pp.getPproleid()
							+ "_");
				}
				if(IGPRDCONSTANTS.SUPER_ROLE.equals(pp.getPpsuper())) {
					dto.getLst_ppsuper().add(psd.getPsdcode() + "_" + pp.getPproleid());
				} else {
					dto.getLst_ppsuper().add("");
				}
			}
		}
		if(lst_ProcessParticipant.isEmpty()) {
			IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
			ppdCond.setPsdid(psd.getPsdid());
			List<IG222Info> lst_ProcessParticipantDef = this.workFlowDefinitionBL.searchParticipantDef(ppdCond);
			if(!lst_ProcessParticipantDef.isEmpty()) {
				for(IG222Info ppd : lst_ProcessParticipantDef) {
					dto.getLst_participant().add(psd.getPsdcode() + "_" + ppd.getRoleid() + "_");
					if(IGPRDCONSTANTS.SUPER_ROLE.equals(ppd.getPpdsuper())) {
						dto.getLst_ppsuper().add(psd.getPsdcode() + "_" + ppd.getRoleid());
					} else {
						dto.getLst_ppsuper().add("");
					}
				}
			}
		}
		
		log.debug("========指定状态可分派角色查询处理结束========");
		return dto;
	}
	
	/**
	 * 可调整参与者查询
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchAdjustParticipantAction(List<IG333Info> lst_ProcessStatusDef, IGPRR01DTO dto) throws BLException {
		log.debug("========可调整参与者查询处理开始========");
		if(lst_ProcessStatusDef != null && !lst_ProcessStatusDef.isEmpty()) {
			dto.setMap_AssignParticipant(new LinkedHashMap<IG333Info, IGPRR01036VO>());
			dto.setLst_participant(new ArrayList<String>());
			List<IG298Info> lst_ProcessStatusRoleDef = null;
			List<Role> lst_Role = null;
			Map<Role, List<UserInfo>> map_ParticipantDefToBeAssign = new LinkedHashMap<Role, List<UserInfo>>();
			UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
			RoleSearchCondImpl roleCond = new RoleSearchCondImpl();
			IG213SearchCondImpl processRoleCond = new IG213SearchCondImpl();
			Map<String, String> map_ParticipantDoneFlag = new LinkedHashMap<String, String>();
			for(IG333Info psd : lst_ProcessStatusDef) {
				//是否设置了可被分派
				if(IGPRDCONSTANTS.NEED_ASSIGN.equals(psd.getPsdflag())) {
					//查询可被分派的角色设定
					lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
					for(IG298Info psrd : lst_ProcessStatusRoleDef) {
						userInfoCond.setRoleida(psrd.getRoleid());
						if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
							userInfoCond.setOrgida(dto.getUser().getOrgid());
						} else {
							userInfoCond.setOrgida(null);
						}
						map_ParticipantDefToBeAssign.put(psrd.getRole(), this.userBL.searchUserInfo(userInfoCond));
					}
				} else {
					//查询角色范围设定
					processRoleCond.setPdid(psd.getPdid());
					List<IG213Info> lst_ProcessRoleTypeDef= this.workFlowDefinitionBL.searchProcessRoleTypeDef(processRoleCond);
					for(IG213Info bean : lst_ProcessRoleTypeDef) {
						roleCond.setRoletype(bean.getRoletype());
						lst_Role = this.roleBL.searchRole(roleCond);
						for(Role role : lst_Role) {
							userInfoCond.setRoleida(role.getRoleid());
							if(IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
								userInfoCond.setOrgida(dto.getUser().getOrgid());
							} else {
								userInfoCond.setOrgida(null);
							}
							map_ParticipantDefToBeAssign.put(role, this.userBL.searchUserInfo(userInfoCond));
						}
					}
				}
				IGPRR01036VO vo = new IGPRR01036VO();
				vo.setMap_ParticipantDefToBeAssignByRole(map_ParticipantDefToBeAssign);
				dto.getMap_AssignParticipant().put(psd, vo);
				//查询已添加参与者
				IG337SearchCondImpl cond = new IG337SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPsdid(psd.getPsdid());
				cond.setPsdnum(dto.getPsdnum());
				List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
//					this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), psd.getPsdcode());
				if(!lst_ProcessParticipant.isEmpty()) {
					for(IG337Info pp : lst_ProcessParticipant) {
						map_ParticipantDoneFlag.put(psd.getPsdid() + "_" + pp.getPproleid()
									+ "_" + pp.getPpuserid(), StringUtils.isEmpty(pp.getPpproctime()) ? "0" : "1");
						if(StringUtils.isNotEmpty(pp.getPpuserid())) {
							dto.getLst_participant().add(psd.getPsdid() + "_" + pp.getPproleid()
									+ "_" + pp.getPpuserid());
						}
					}
				}
			}
			dto.setMap_ParticipantDoneFlag(map_ParticipantDoneFlag);
		}
		log.debug("========可调整参与者查询处理结束========");
		return dto;
	}
	
	/**
	 * 判断是否提交类按钮
	 * 
	 * @param pbdid 按钮ID
	 * @return 是否
	 * @throws BLException
	 */
	private boolean isCommitButton(String pbdid) throws BLException {
		if(StringUtils.isEmpty(pbdid)) {
			throw new BLException("IGCO10000.E004","按钮标识"); 
		}
		if(pbdid.compareTo(IGPRDCONSTANTS.BUTTON_SUBMIT) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <p>
	 * Description: 普通用户调整执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO adjustExecutorsForNormalUserAction(IGPRR01DTO dto) throws BLException {
		log.debug("========调整执行人处理开始========");
		IGPRR0102Form form = dto.getIgPRR0102Form();
		String selected_participants = form.getSelected_participants();
		List<String> lst_Selected = null;
		if(StringUtils.isNotEmpty(selected_participants)) {
			lst_Selected = Arrays.asList(selected_participants.split("###"));
		}
		
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		//组装参与者数据
		String datetime = IGStringUtils.getCurrentDateTime();
		//新增参与者
		List<String> userList = new ArrayList<String>();
		Role role = null;
		User executor = null;
		IG333Info psDef = null;
		//获取可调整参与者的状态列表
		List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAdjustStatus(form.getPsdid());
		//可调整参与者的状态集合
		Set<String> lst_AdjustStatus = new HashSet<String>();
		for(IG333Info psd : lst_ProcessStatusDef) {
			lst_AdjustStatus.add(psd.getPsdid());
		}
		//状态-人员列表
		Map<String, List<String>> map_Participants = new LinkedHashMap<String, List<String>>();
		if(participants != null) {
			String[] array = null;
			for(String str : participants) {
				array = str.split("_", 3);
				if(map_Participants.containsKey(array[0])) {
					map_Participants.get(array[0]).add(str.substring(str.indexOf("_") + 1));
				} else {
					lst_AdjustStatus.remove(array[0]);//剔除已设定的状态
					map_Participants.put(array[0], new ArrayList<String>());
					map_Participants.get(array[0]).add(str.substring(str.indexOf("_") + 1));
				}
			}
			Set<Map.Entry<String, List<String>>> set = map_Participants.entrySet();
			if(set.size() > 0) {
				Map.Entry<String, List<String>> entry = null;
				for(Iterator<Map.Entry<String, List<String>>> iter = set.iterator(); iter.hasNext();){
					entry = iter.next();
					List<Integer> lst_ppid_nodo = new ArrayList<Integer>();
					IG337SearchCondImpl cond = new IG337SearchCondImpl();
					cond.setPrid(dto.getPrid());
					cond.setPsdid(entry.getKey());
					List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
//						this.workFlowOperationBL.searchProcessParticipant(dto.getPrid(), entry.getKey());
					for(IG337Info pp : lst_ProcessParticipant) {
						for(int i = 0; i < entry.getValue().size(); i++) {
							if(StringUtils.isNotEmpty(entry.getValue().get(i))) {
								if((pp.getPproleid() + "_" + pp.getPpuserid()).equals(
										entry.getValue().get(i).split("_", 2)[0] + "_" + entry.getValue().get(i).split("_", 2)[1])) {
									lst_ppid_nodo.add(pp.getPpid());//说明该执行人在参与者表中存在，不需要进行处理
									entry.getValue().set(i, null);
									break;
								}
							}
						}
					}
					for(String participant : entry.getValue()) {
						if(StringUtils.isNotEmpty(participant)) {
							role = this.roleBL.searchRoleByKey(new Integer(participant.split("_", 2)[0]));
							executor = this.userBL.searchUserByKey(participant.split("_", 2)[1]);
							psDef = workFlowDefinitionBL.searchProcessStatusDefByKey(entry.getKey());
							//只通知当前状态参与者
							if(form.getPrstatus().startsWith(entry.getKey())) {
								userList.add(executor.getUserid());
							}
							IG337TB ppTB = this.workFlowOperationBL.getProcessParticipantTBInstance();
							ppTB.setPproleid(role.getRoleid());
							ppTB.setPprolename(role.getRolename());
							ppTB.setPpuserid(executor.getUserid());
							ppTB.setPpusername(executor.getUsername());
							ppTB.setPporgid(executor.getOrgid());
							ppTB.setPporgname(executor.getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);//参与者类型
							ppTB.setPpinittime(datetime);
							ppTB.setPrid(form.getPrid());
							ppTB.setPpstatus(psDef.getPsdcode());
							ppTB.setPsdid(psDef.getPsdid());
							this.workFlowOperationBL.addProcessParticipant(ppTB, user, form.getPrroleid(),
									"添加：" + ppTB.getPprolename() + "(" + ppTB.getPpusername() + ")",
									IGPRDCONSTANTS.COMMENT_ASSIGNPERSON_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						}
					}
					for(IG337Info pp : lst_ProcessParticipant) {
						if(!lst_ppid_nodo.contains(pp.getPpid()) && lst_Selected.contains(
								pp.getPsdid() + "_" + pp.getPproleid() + "_"
										+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
							this.workFlowOperationBL.removeProcessParticipant(pp, user, form.getPrroleid(),
									"删除：" + pp.getPprolename()
									+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
									IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
									IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
						}
					}
				}
			}
			for(String status : lst_AdjustStatus) {
				IG337SearchCondImpl cond = new IG337SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPsdid(status);
				List<IG337Info> list = workFlowOperationBL.searchProcessParticipants(cond);
				for(IG337Info pp : list) {
					if(lst_Selected.contains(
							pp.getPsdid() + "_" + pp.getPproleid() + "_"
									+ (StringUtils.isEmpty(pp.getPpuserid()) ? "" : pp.getPpuserid()))) {
						this.workFlowOperationBL.removeProcessParticipant(pp, user, form.getPrroleid(), 
								"删除：" + pp.getPprolename()
								+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
								IGPRDCONSTANTS.COMMENT_DELETEPERSON_MESSAGE,null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
					}
				}
			}
		}
		//触发按钮事件
		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPbdid(IGPRDCONSTANTS.BUTTON_EXECUTOR);//按钮ID
		bean.setBfstatus(form.getPsdid());//状态ID
		//日志参数信息
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(dto.getPrid());
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(form.getPrroleid());
		if(dto.getAuthorizeuser() != null) {
			logInfo.setAuthuserid(dto.getAuthorizeuser().getUserid());
		}
		bean.setLogInfo(logInfo);
		this.workFlowOperationBL.processStatusButtonTreatmentExecute(bean);
		//检验当前状态所有参与者是否处理完成,全部处理完成则按最后一个处理人的记录跃迁
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		this.workFlowOperationBL.sendMessage(form.getPsdid(),
				userList, null, null, null, null, pr);
		
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========调整执行人处理终了========");
		return dto;
	}
	/**
	 * <p>
	 * Description: 分派保存执行人
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author   
	 * @update
	 */
	public IGPRR01DTO saveExecutorsAction(IGPRR01DTO dto) throws BLException {
		log.debug("========保存执行人处理开始========");
		IGPRR0102Form form = dto.getIgPRR0102Form();
		User user = dto.getUser();
		String[] participants = form.getParticipants();
		User authorizeuser = dto.getAuthorizeuser();
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(pr);
		String[] ppsupers = form.getPpsupers();
		//组装节点参与者数据
		if(participants != null) {
			//为了打回时，重新分派时需要删除之前的参与者start
			Set<String> set_Status = new HashSet<String>();
			for(String str : participants) {
				set_Status.add(str.split("_", 3)[0]);
			}
			for(String status : set_Status) {
				for(IG337Info pp : workFlowOperationBL.searchProcessParticipant(pr.getPrid(), status)) {
					workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
							"删除：" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
				}
			}
			//为了打回时，重新分派时需要删除之前的参与者end
			
			String[] array = null;
			for(String str : participants) {
				array = str.split("_", 3);
				String ppsuper = null;
				if(ppsupers != null) {
					for(String per : ppsupers) {
						if((array[0] + "_" + array[1]).equals(per)) {
							ppsuper = per;
							break;
						}
					}
				}
				workFlowOperationBL.addParticipant(dto.getUser(), dto.getPrid(), pr.getPrpdid(), array[0],
						array[1], array[2], ppsuper, authorizeuser, dto.getAction(), form.getPrstatus());
			}
		}
		//如果分派页面没有勾选任何参与人，认为将所有保存记录清空  start wangtingzhi  20130617
		else{
			List<IG333Info> lst_ProcessStatusDef = this.workFlowDefinitionBL.searchAssignedStatusDef(form.getPsdid(), form.getAction());
			if(lst_ProcessStatusDef != null){
				for(IG333Info psd : lst_ProcessStatusDef){
					for(IG337Info pp : workFlowOperationBL.searchProcessParticipant(pr.getPrid(), psd.getPsdcode())) {
						workFlowOperationBL.removeProcessParticipant(pp,user,form.getPrroleid(),
								"删除：" + pp.getPprolename()
								+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
								IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, dto.getAction(), form.getPrstatus());
					}
				}
			}
		}
		//如果分派页面没有勾选任何参与人，认为将所有保存记录清空  end wangtingzhi  20130617

		//检验当前状态所有参与者是否处理完成,全部处理完成则按最后一个处理人的记录跃迁
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0000.I001"));
		log.debug("========保存执行人处理终了========");
		return dto;
	}
	
	/**
	 * 获取非当前节点参与人的表单可见权限
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO getNotCurrentFormAccessPower(IGPRR01DTO dto) throws BLException{
		//当前登录用户ID取得
		String userid = dto.getUser().getUserid();
		//流程取得
		IG500Info pr = dto.getProcess();
		//取得当前用户的所有角色
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		//当前用户参与过的节点
		List<IG337Info> ppList = new ArrayList<IG337Info>();
		//当前流程已经运行过的节点
		//取得流程当前已经运行过的状态集合 
		IG337SearchCondImpl condPP = new IG337SearchCondImpl();
		condPP.setPrid(dto.getPrid());
		List<IG337Info> lstProcessParticipant = workFlowOperationBL.searchIG337InfoRun(condPP);
		for(IG337Info pp :lstProcessParticipant){
			//参与者指定到角色的情况
			Integer pproleid = pp.getPproleid();
			for(UserRole role : roleList){
				if(role.getRoleid().equals(pproleid)){
					ppList.add(pp);
				}
			}
		}
		
		//查询当前流程的所有状态定义
		IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
		psdcond.setPdid(pr.getPrpdid());
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
		if(psdList != null && ppList.size() > 0){
			Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();
			for(IG333Info psd:psdList){
				psdMap.put(psd.getPsdid(), psd);
			}
			Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap = new HashMap<IG333Info, List<IG337Info>>();
			for(IG337Info pp:ppList){
				if(ls_proStatusParticipantMap.get(psdMap.get(pp.getPsdid())) == null){
					List<IG337Info> temp = new ArrayList<IG337Info>();
					temp.add(pp);
					ls_proStatusParticipantMap.put(psdMap.get(pp.getPsdid()), temp);
				}else{
					ls_proStatusParticipantMap.get(psdMap.get(pp.getPsdid())).add(pp);
				}
			}
			List<IG893Info> participantVariableVWList = workFlowOperationBL.searchParticipantMaxVariableVW(dto.getPsdid(), dto.getRoleid(), ls_proStatusParticipantMap);
			List<IG893Info> participantVariable = new ArrayList<IG893Info>();
			if(participantVariableVWList != null){
				for(IG893Info pv:participantVariableVWList){
					IG893VW pvVW = new IG893VW();
					pvVW.setPidid(pv.getPidid());
					if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pv.getPidaccess())){
						pvVW.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
					}else{
						pvVW.setPidaccess(pv.getPidaccess());
					}
					pvVW.setPidrequired(pv.getPidrequired());
					pvVW.setPidlabel(pv.getPidlabel());
					pvVW.setPidname(pv.getPidname());
					pvVW.setPiddesc(pv.getPiddesc());
					pvVW.setPidtype(pv.getPidtype());
					pvVW.setPsdid(pv.getPsdid());
					pvVW.setRoleid(pv.getRoleid());
					participantVariable.add(pvVW);
				}
			}
			dto.setParticipantVariableVWList(participantVariable);
		}
		return dto;
	}

	
	//120509Begin
	/**
	 * 自定义流程非关闭状态变量信息集合取得
	 */
	private IGPRR01DTO searchProcessInfoForSearch(IGPRR01DTO dto) throws BLException {
		if(null == dto.getRoleid()){
			dto.setRoleid(0);
		}
		String userid = dto.getUser().getUserid();
		IGPRR0102Form form = dto.getIgPRR0102Form();
		//取得流程
		IG500Info pr = dto.getProcess();
		
		//取得当前用户的所有角色
		UserRoleSearchCondImpl condRole = new UserRoleSearchCondImpl();
		condRole.setUserid(userid);
		List<UserRole> roleList = userRoleBL.searchUserRole(condRole);
		
		List<String> ppstatusList = new ArrayList<String>();//保存有权限的状态
		
		//取得流程当前已经运行过的状态集合 
		IG337SearchCondImpl condPP = new IG337SearchCondImpl();
		condPP.setPrid(dto.getPrid());
		List<IG337Info> lstProcessParticipant = workFlowOperationBL.searchIG337InfoRun(condPP);
		for(IG337Info pp :lstProcessParticipant){
			//参与者指定到角色的情况
			Integer pproleid = pp.getPproleid();
			for(UserRole role : roleList){
				if(role.getRoleid().equals(pproleid)){
					if(!ppstatusList.contains(pp.getPpstatus())){
						ppstatusList.add(pp.getPsdid());
					}
				}
			}
		}
		
		List<IG007Info> infoDefList = null;
		if(ppstatusList.size() > 0){
			//查询该流程的所有定义的表单变量
			IG007SearchCondImpl condInfo = new IG007SearchCondImpl();
			//pdid
			condInfo.setPdid(pr.getPrpdid());
			
			//根据查询集合取得ppdid串
			StringBuffer buf = new StringBuffer("(");
			for(String status : ppstatusList){
				buf.append("'").append(status).append("',");
			}
			String str = buf.substring(0, buf.length()-1) + ")";
			condInfo.setPsdid_like(str);
			infoDefList = workFlowDefinitionBL.searchIG007InfoRun(condInfo);
		}
		
		//查询该流程的所有表单变量
		List<IG599Info> piList = workFlowOperationBL.searchProcessInfoForSee(pr.getPrid(),pr.getPrpdid(), userid);
		
		if(infoDefList!=null && infoDefList.size()>0){
			Map<String,IG007Info> realmap = new LinkedHashMap<String,IG007Info>();
			//根据流程变量找到变量定义表中的变量定义，将流程变量的值赋给与其对应的流程变量定义的对象，并将该流程变量定义对象的流程变量权限(pidaccess)设置为只读
			for(IG007Info pid:infoDefList){
				String pidid = pid.getPidid();
				IG007TB pitb = (IG007TB)SerializationUtils.clone(pid);
				for(IG599Info temp_pi:piList){
					if(pidid.equals(temp_pi.getPidid())){
						pitb.setPidvalue(temp_pi.getPivarvalue());
						pitb.setPidcomment(temp_pi.getPidcomment());
						//如果当前用户可以全局控制所属权限表单，则保留原权限，否则保留只读权限
						pitb.setPidaccess(IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE);
						if("1".equalsIgnoreCase(temp_pi.getPidmode())){
							if(IGPRDCONSTANTS.PRIVATE_ACCESS_READABLE_ALL.equalsIgnoreCase(temp_pi.getPidaccess())){
								pitb.setPidaccess(temp_pi.getPidaccess());
								pitb.setPiid(temp_pi.getPiid());
							}
							pitb.setProcessPrivateInfoList(temp_pi.getProcessPrivateInfofList());
							//当私有表单为角色的时候，当前登录人查看时候没有roleid，所以查询参与者表 只要存在已完成的状态roleid与私有表单相同，则roleid设置为9999，全部显示
							if("0".equalsIgnoreCase(temp_pi.getPrivatescope()) && temp_pi.getProcessPrivateInfofList() != null && temp_pi.getProcessPrivateInfofList().size() > 0){
								if(dto.getRoleid() == null || dto.getRoleid() <= 0){
									List<IG899TB> lstPrivate = temp_pi.getProcessPrivateInfofList();
									IG337SearchCondImpl condImpl = new IG337SearchCondImpl();
									condImpl.setPrid(dto.getPrid());
									condImpl.setPpproctimeIsNull("N");
									condImpl.setPpuserid(userid);
									List<IG337Info> processParticipantList = this.workFlowOperationBL.searchProcessParticipants(condImpl);
									for(IG337Info info : processParticipantList){
										for(IG899TB tb : lstPrivate){
											if(info.getPproleid().equals(tb.getRoleid())){
												//设置为最多权限 用于页面显示
												dto.setRoleid(9999);
												break;
											}
										}
									}
								}
							}
						}
						realmap.put(pidid, pitb);
						break;
					}
				}
				
			}
			dto.setRealmap(realmap);
		}
		
		if(dto.getRealmap()!=null){
			dto.setProcessInfoDefmap(dto.getRealmap());
			dto.setHid("1");
		}else{
			dto.setHid("0");
		}
		
		form.setProcessName(dto.getProcessName());
		
		return dto;
	}

	/**
	 * 查询定义流程的排序ID
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchActionSortID(IGPRR01DTO dto) throws BLException {
		log.debug("========查询定义流程的排序ID开始========");
		String pdid = dto.getProcess().getPrpdid();
		ActionSearchCondImpl cond = new ActionSearchCondImpl();
		cond.setActurl_like("/IGCOM0202.do?linkID=IGPRR0101&psdcode=Z&pdid="+pdid);
		List<Action> actionInfo = actionBL.searchAction(cond);
		for(Action action : actionInfo){
			String sortid = "";
			if(StringUtils.isNotEmpty(action.getActsortid())){
				sortid = action.getActsortid();
				if(action.getActsortid().length()> 4){
					sortid = sortid.substring(0, 4);
				}
			}
			if(StringUtils.isNotEmpty(sortid)){
				dto.setActsortid(sortid);
			}
		}
		log.debug("========查询定义流程的排序ID结束========");
		return dto;
	}

	/**
	 * 可参与流程角色取得
	 * @param dto
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessRoleListAction(IGPRR01DTO dto) throws Exception {
		log.debug("========可参与流程角色查询处理开始========");
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setPdid(dto.getProcessStatusDef().getPdid());
		dto.setRoleList(roleBL.searchRoleForSelfDef(cond,0,0));
		log.debug("========可参与流程角色查询处理结束========");
		return dto;
	}

	public IGPRR01DTO getServiceProcessRecordRelation(IGPRR01DTO dto) throws BLException {
		log.debug("========获取流程关联服务工单信息处理开始========");
		//查询该服务工单正向关系流程
		List<IG715Info> serviceProcessRecordRelationList = workFlowOperationBL.searchServiceProcessRecordRelationByPrid(dto.getPrid());//主动
		dto.setIg715InfoList(serviceProcessRecordRelationList);
		log.debug("========获取流程关联服务工单信息处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 服务工单快捷发起页面初始化 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @author masai@deliverik.com
	 * @update
	 */
	public IGPRR01DTO quickQuestionInitAction(IGPRR01DTO dto) throws BLException {
		
		log.debug("========服务工单快捷发起问题页面初始化开始========");
		IGPRR0101Form form = dto.getIgPRR0101Form();
		IG933Info serviceForm = this.workFlowOperationBL.searchServiceFormByKey(form.getParprid());
		
		form.setPrinfo(dto.getUser().getUsermobile());
		form.setPrtitle(serviceForm.getSftitle());//名称
		form.setPrdesc(serviceForm.getSfdesc());//描述
		form.setPrplantime(serviceForm.getSfinstime());//问题发生事件

		log.debug("========服务工单快捷发起问题页面初始化终了========");
		
		return dto;
		
	}
	/**
	 * <p>
	 * Description: 快捷发起页面初始化 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update
	 */
	
	public IGPRR01DTO quickInitAction(IGPRR01DTO dto) throws BLException {
		log.debug("========问题快捷发起页面初始化开始========");
		IGPRR0101Form form = dto.getIgPRR0101Form();
		IG500Info pr = this.workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
		form.setPrtitle(pr.getPrtitle());//名称
		form.setPrdesc(pr.getPrdesc());//描述
//		form.setPrurgency(pr.getPrurgency());//紧急程度
//		form.setPrimpact(pr.getPrimpact());//影响程度

		log.debug("========问题快捷发起页面初始化终了========");
		return dto;
	}
	
	/**
     * <p>
     * Description: 取得流程自定义的分派页面URL信息
     * </p>
     * 
     * @param dto IGPRR01DTO
     * @return IGPRR01DTO
     * @throws BLException
     * @update
     */
    
    public IGPRR01DTO getAssignPageAction(IGPRR01DTO dto) throws BLException {
        log.debug("========流程自定义的分派页面URL信息取得开始========");
        
        CodeDetailSearchCondImpl codedetailcond = new CodeDetailSearchCondImpl();
        codedetailcond.setCcid(CodeDefine.getCodeDefine("ASSIGN_PAGE_TYPE").getCcid());
        codedetailcond.setCid(dto.getAssignPageType());
        List<CodeDetail> cds = codeDetailBL.searchCodeDetail(codedetailcond,
                  CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        String[] assignPages = cds.get(0).getCdinfo().split("#");
        IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid());
        dto.setAssignPage(psd.getAssignPageType());
        dto.setAssignChangePage(assignPages[1]);
        
        log.debug("========流程自定义的分派页面URL信息取得终了========");
        
        return dto;
    }
    
    /**
     * 判断是否可以全局控制表单
     * @param dto
     * @return
     * @throws BLException
     */
    public IGPRR01DTO isFormGlobalControl(IGPRR01DTO dto) throws BLException{
    	log.debug("=============判断是否可以全局控制表单开始==============");
    	//当前登录用户取得
    	User user = dto.getUser();
    	//流程信息取得
    	IG500Info processrecord = dto.getProcess();
    	//查询标识全局控制表单的节点定义
    	IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
    	psdcond.setPdid(processrecord.getPrpdid());
    	psdcond.setFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y);
    	List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
    	//如果该流程有定义节点表单全局控制，则判断该用户是否有该权限，否则设置其没有该权限
    	if(psdList!=null&&!psdList.isEmpty()){
    		//查询该流程的所有参与者
    		IG337SearchCondImpl ppcond = new IG337SearchCondImpl();
    		ppcond.setPrid(dto.getPrid());
    		List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(ppcond);
    		Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap = new HashMap<IG333Info, List<IG337Info>>();
    		UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
    		urcond.setUserid(user.getUserid());
    		List<UserRole> urlist = userRoleBL.searchUserRole(urcond);
    		for(IG333Info psd:psdList){
    			for(IG337Info pp:ppList){
    				if(psd.getPsdcode().equals(pp.getPpstatus())){
    					for(UserRole ur : urlist){
    						if(ur.getRoleid().equals(pp.getPproleid())){
    							if(ls_proStatusParticipantMap.get(psd)==null){
    								List<IG337Info> temp = new ArrayList<IG337Info>();
    								temp.add(pp);
    								ls_proStatusParticipantMap.put(psd, temp);
    							}else{
    								ls_proStatusParticipantMap.get(psd).add(pp);
    							}
    							break;
    						}
    					}
    				}
    			}
    		}
    		
    		if(ls_proStatusParticipantMap.size()>0){
    			dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_Y);
    			dto.setLs_proStatusParticipantMap(ls_proStatusParticipantMap);
    		}else{
    			dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_N);
    		}
    	}else{
    		dto.setIsFormGlobalControl(IGPRR01BLType.FORM_GLOBAL_CONTROL_N);
    	}
    	log.debug("=============判断是否可以全局控制表单结束==============");
    	return dto;
    }
	
	//====>130225Begin 
	/**
	 * 根据机构查询执行人
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO searchProcessExecutor(IGPRR01DTO dto) throws BLException {
		log.debug("========根据机构查询执行人开始========");
		
		IGPRR0121Form form = dto.getIgPRR0121Form();
		
		//当前参与者
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		cond.setPrid(form.getPrid());
		cond.setPpstatus(form.getPrstatus());
		cond.setPporgid_eq(form.getPporgid());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		// 查询指定的执行人角色ID信息
		IG001SearchCondImpl cond_role = new IG001SearchCondImpl();
		cond_role.setProtype_eq(IGPRDCONSTANTS.OA_ROLE_C);
		List<IG001Info> lst_role = this.workFlowDefinitionBL.searchOARoleConfig(cond_role);
		if(lst_role == null || lst_role.isEmpty()){
			throw new BLException("IGPRD0119.E001");
		}
		// 查询指定的执行人用户信息
		List<UserRoleInfo> lstAll = new ArrayList<UserRoleInfo>();
		for (IG001Info info : lst_role) {
			UserRoleVWSearchCondImpl cond_urvw = new UserRoleVWSearchCondImpl();
			cond_urvw.setRoleid(info.getProroleid());
			cond_urvw.setOrgid_like(form.getPporgid());
			lstAll.addAll(userRoleBL.searchUserRoleVW(cond_urvw));
		}
		
		// 在显示的执行人中过滤掉负责人和值班人及已处理完成的参与者
		List<UserRoleInfo> lst_UserRoleVW = new ArrayList<UserRoleInfo>();
		List<String> lst_user = new ArrayList<String>();
		for (IG337Info ig337Info : pplist) {
			if((IGPRDCONSTANTS.ROLEMANAGER.equals(ig337Info.getPprolemanager())
				|| IGPRDCONSTANTS.DUTYPERSON.equals(ig337Info.getPpdutyperson()))
				|| StringUtils.isNotEmpty(ig337Info.getPpproctime())){
				lst_user.add(ig337Info.getPpuserid());
			}
		}
		try {
			for (UserRoleInfo userRoleInfo : lstAll) {
				if(!lst_user.contains(userRoleInfo.getUserid())){
					lst_user.add(userRoleInfo.getUserid());
					//lst_UserRoleVW.add(userRoleInfo);
					
					//得到可以编辑的对象 20130314 取得机构全名
					UserRoleVW uvw = new UserRoleVW();
					BeanUtils.copyProperties(uvw, userRoleInfo);
					uvw.setOrgname(getCompleteOrgName(uvw.getOrgid()));
					lst_UserRoleVW.add(uvw);
				}
			}
		} catch (Exception e) {
			log.error("",e);
		}
		dto.setLst_UserRoleVW(lst_UserRoleVW);
		
		log.debug("========根据机构查询执行人结束========");
		return dto;
	}
	
	/**
	 * 将执行人添加为参与者
	 *
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 */
	public IGPRR01DTO addProcessExecutor(IGPRR01DTO dto) throws BLException {
		IGPRR0121Form form = dto.getIgPRR0121Form();
		//当前参与者
		IG337SearchCondImpl cond = new IG337SearchCondImpl(); 
		cond.setPrid(form.getPrid());
		cond.setPpstatus(form.getPrstatus());
		List<IG337Info> pplist = workFlowOperationBL.searchProcessParticipants(cond);
		
		// 删除参与人
		List<IG337Info> lst_remove = new ArrayList<IG337Info>();
		for (IG337Info ig337Info : pplist) {
			if((!IGPRDCONSTANTS.ROLEMANAGER.equals(ig337Info.getPprolemanager())
				&& !IGPRDCONSTANTS.DUTYPERSON.equals(ig337Info.getPpdutyperson()))
				&& StringUtils.isEmpty(ig337Info.getPpproctime())){
				lst_remove.add(ig337Info);
				this.workFlowOperationBL.removeProcessParticipant(ig337Info);
			}
		}
		
		// 取得未删除参与人
		pplist.removeAll(lst_remove);
		lst_remove = null;
		List<String> lst_user = new ArrayList<String>();
		for (IG337Info info : pplist) {
			lst_user.add(info.getPpuserid());
		}
		
		// 查询添加的参与人信息
		List<UserRoleInfo> lst_UserRoleVW = new ArrayList<UserRoleInfo>();
		int[] urids = form.getUrids();
		UserRoleVWSearchCondImpl condVW = new UserRoleVWSearchCondImpl();
		for (int i = 0; i < urids.length; i++) {
			condVW.setUrid_eq(urids[i]);
			lst_UserRoleVW.addAll(this.userRoleBL.searchUserRoleVW(condVW));
		}
		
		// 添加参与者
		// 当前用户
		User currUser = dto.getUser();
		OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
		orgcond.setOrgsyscoding(form.getPporgid());
		List<Organization> lst_org = organizationBL.searchOrganization(orgcond);
		Organization organization = new OrganizationTB();
		if(lst_org != null && !lst_org.isEmpty()){
			organization = lst_org.get(0);
		}
		for (UserRoleInfo userRolevw : lst_UserRoleVW) {
			// 参与者中已存在的用户不添加
			if(lst_user.contains(userRolevw.getUserid())){
				continue;
			}
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(process.getPrpdid());
			psdCond.setPsdcode(form.getPrstatus());		
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			if(lst_ProcessStatusDef.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "状态");
			} else if(lst_ProcessStatusDef.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "状态");
			} else {
				// 参与者实例
				IG337TB instance = workFlowOperationBL.getProcessParticipantTBInstance();
				instance.setPrid(form.getPrid());
				instance.setPpinittime(IGStringUtils.getCurrentDateTime());
				instance.setPpstatus(form.getPrstatus());
				//????
				instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
				instance.setPpuserid(userRolevw.getUserid());
				instance.setPpusername(userRolevw.getUsername());
				instance.setPporgid(organization.getOrgsyscoding());
				instance.setPporgname(organization.getOrgsyscoding());
				instance.setPprolemanager(IGPRDCONSTANTS.NOT_ROLEMANAGER);
				instance.setPpdutyperson(IGPRDCONSTANTS.NOT_DUTYPERSON);
				instance.setPproleid(userRolevw.getRoleid());
				instance.setPprolename(userRolevw.getRolename());
				workFlowOperationBL.addProcessParticipant(instance, currUser,
						userRolevw.getRoleid(),
						"添加："+userRolevw.getUsername(), "添加参与者", 
						null, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null, null);
			   }
			}
		
		return dto;
	}
	//====>130225End
	
	/**
	 * 机构super改派
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO addProcessParticipantByOrgSuper(IGPRR01DTO dto) throws BLException {
		log.debug("=================机构super改派开始=================");
		//页面信息取得
		IGPRR0113Form form = dto.getIgPRR0113Form();
		//流程信息查询
		IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
		dto.setProcess(pr);
		//参与人信息取得
		List<IG337Info> pplist = this.workFlowOperationBL.searchProcessParticipant(form.getPrid(), form.getPrstatus());
		//被选参与人信息取得
		String[] participants = form.getParticipants();
		List<String[]> orgList = new ArrayList<String[]>();
		if(participants!=null){
			for(String s:participants){
				String[] split = s.split("_");
				if(split!=null&&split.length==2){
					String [] temp = {split[0],split[1]};
					orgList.add(temp);
				}
			}
		}
		//要删除的参与人信息集合
		List<IG337Info> deleteppList = new ArrayList<IG337Info>();
		//已经添加过的机构码
		List<String> alreadyexistorg = new ArrayList<String>();
		if(pplist!=null){
			for(IG337Info pp:pplist){
				boolean flag = true;
				for(String[] org:orgList){
					if(pp.getPporgid().equals(org[0])){
						flag = false;
						if(!alreadyexistorg.contains(pp.getPporgid())){
							alreadyexistorg.add(pp.getPporgid());
						}
						break;
					}
				}
				if(flag){
					deleteppList.add(pp);
				}
			}
		}
		//删除被去掉的参与人
		if(!deleteppList.isEmpty()){
			for(IG337Info pp:deleteppList){
				this.workFlowOperationBL.removeProcessParticipant(pp, dto.getUser(), pp.getPproleid(), 
						"删除：" + pp.getPprolename()
						+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
						IGPRDCONSTANTS.PPD_REMOVE_PROCESSPARTICIPANT_MESSAGE,null,
						IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
			}
		}
		//添加新被勾选的参与人
		if(orgList.size()>alreadyexistorg.size()){
			//查询配置角色信息
			//负责人对应角色
			List<Integer> role_a = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
			if(role_a == null || role_a.isEmpty()){
				throw new BLException("IGCO10000.E004","负责人基本");
			}
			//值班人对应角色
			List<Integer> role_b = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
			UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
			List<UserRoleInfo> urList = null;
			List<IG337Info> addppList = new ArrayList<IG337Info>();
			for(String[] orgs:orgList){
				if(StringUtils.isNotEmpty(orgs[0])&&!alreadyexistorg.contains(orgs[0])){
					//查询对应负责人信息
					urcond.setOrgid_like(orgs[0]);
					urcond.setRoleid_in(role_a);
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList==null||urList.isEmpty()){
						throw new BLException("IGCO10000.E004","（"+ orgs[1] + "）负责人基本");
					}else{
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = workFlowOperationBL.getProcessParticipantTBInstance();
							ppTB.setPrid(form.getPrid());
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(form.getPrstatus());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(orgs[0]);
							ppTB.setPporgname(orgs[1]);
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							addppList.add(ppTB);
						}
					}
					//查询对应值班人信息
					if(role_b!=null&&!role_b.isEmpty()){
						urcond.setRoleid_in(role_b);
						urList = userRoleBL.searchUserRoleVW(urcond);
						if(urList!=null){
							for(UserRoleInfo ur:urList){
								IG337TB ppTB = workFlowOperationBL.getProcessParticipantTBInstance();
								ppTB.setPrid(form.getPrid());
								ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
								ppTB.setPpstatus(form.getPrstatus());
								ppTB.setPproleid(ur.getRoleid());
								ppTB.setPprolename(ur.getRolename());
								ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
								ppTB.setPpuserid(ur.getUserid());
								ppTB.setPpusername(ur.getUsername());
								ppTB.setPporgid(orgs[0]);
								ppTB.setPporgname(orgs[1]);
								ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
								addppList.add(ppTB);
							}
						}
					}
				}
			}
			//调用BL添加参与人
			if(!addppList.isEmpty()){
				for(IG337Info addpp:addppList){
					this.workFlowOperationBL.addProcessParticipant(addpp, dto.getUser(),form.getRoleid(),
							"添加：" + addpp.getPprolename()
							+ (StringUtils.isEmpty(addpp.getPpusername()) ? "" : "(" + addpp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, dto.getAuthorizeuser(), dto.getAction(), form.getPrstatus());
				}
			}
		}

		//检验当前状态所有参与者是否处理完成,全部处理完成则按最后一个处理人的记录跃迁
		this.workFlowOperationBL.checkAllUserWorkDone(pr.getPrid());
		dto.addMessage(new ActionMessage("IGPRR0113.I001"));
		log.debug("=================机构super改派终了=================");
		return dto;
	}
	
	/**
	 * 机构下拉列表值取得
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO getOrgLabelValueBeans(IGPRR01DTO dto) throws BLException {
		log.debug("=============获取机构下拉列表值操作开始===============");
		//获得机构范围下拉列表
		List<IG123Info> orgList = workFlowDefinitionBL.searchProcessOrgScopeByPdid(dto.getPdid());
		List<LabelValueBean> labelList = new ArrayList<LabelValueBean>();
		if(orgList!=null){
			for(IG123Info info:orgList){
				LabelValueBean label = new LabelValueBean();
				label.setLabel(info.getOrgname());
				label.setValue(info.getOrgid()+"_org_"+info.getOrgname());
				labelList.add(label);
			}
		}
		dto.setProcessOrgSelectedOptions(labelList);
		log.debug("=============获取机构下拉列表值操作结束===============");
		return dto;
	}
	/**
	 * <p>
	 * 取得该结点的机构全名
	 * </p>
	 * @param  syscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */

	public String getCompleteOrgName(String syscoding) {
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		StringBuffer orgname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==7){
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, 7);
			codelist.add(pcode);
			String childs = syscoding.substring(7);
			int j = childs.length()/3;
			for(int i=1;i<=j;i++){
				codelist.add(pcode+childs.substring(0, 3*i));
			}
			
		}
		
		
		//form.setComplete_name(syscoding);
		//form.setIs_in_use("1");
		form.setSyscoding_area(codelist);
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该角色管理域的下级机构树
		for(int i=0,j=ret.size();i<j;i++){
			String syscode = ret.get(i).getOrgsyscoding();
			if(syscoding.contains(syscode)){
				if(i>0){
					orgname.append("-");
				}
				orgname.append(ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}
	
	/**
	 * 查询表格类表单值
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO searchTableColumnValue(IGPRR01DTO dto) throws BLException {
		log.debug("=============表格类表单值查询操作开始==============");
		//流程信息取得
		IG500Info process = dto.getProcess();
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(process.getPrid());
		List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
		Map<String, List<Attachment>> tableAttMap = new HashMap<String, List<Attachment>>();
		if(tableColumnValueList != null){
			Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
			for(IG898Info columnValue:tableColumnValueList){
				if(tableColumnValueMap.get(columnValue.getPidid()) == null){
					Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
					Map<String, String> two = new LinkedHashMap<String, String>();
					two.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
					one.put(columnValue.getPvrownumber(), two);
					tableColumnValueMap.put(columnValue.getPidid(), one);
				}else{
					if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
						Map<String, String> temp = new LinkedHashMap<String, String>();
						temp.put(columnValue.getPvcolpidid(), columnValue.getPvalue());
						tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
					}else{
						tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), columnValue.getPvalue());
					}
				}
				if(StringUtils.isNotEmpty(columnValue.getPvalue())){
					try {
						if(columnValue.getPvalue().getBytes("UTF-8").length == 32){
							List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(columnValue.getPvalue());
							tableAttMap.put(columnValue.getPvalue(), attList);
						}
					} catch (UnsupportedEncodingException e) {
						log.error("",e);
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		
		List<IG731Info> pieList = workFlowOperationBL.searchProcessInfoEntityByPrid(process.getPrid());
		Map<String, IG731Info> pieMap = new HashMap<String, IG731Info>();
		if(pieList != null){
			for(IG731Info pie : pieList){
				String key = pie.getPieid() + "";
				pieMap.put(key, pie);
			}
		}
		//设置表格类表单列附件
		if(tableAttMap.size() > 0){
			dto.setTableAttMap(tableAttMap);
		}
		dto.setPieMap(pieMap);
		log.debug("=============表格类表单值查询操作结束==============");
		return dto;
	}
	
	/**
	 * 取得流程参与人信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchParticipantInfoActon(IGPRR01DTO dto) throws BLException {
		log.debug("=============取得流程参与人信息操作开始===================");
		//流程信息取得
		IG500Info process = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		dto.setProcess(process);
		dto.setStatus(process.getPrstatus());
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPsdcode(process.getPrstatus());
		cond.setPdid(process.getPrpdid());
		List<IG333Info> psdList = this.workFlowDefinitionBL.searchProcessStatusDef(cond);
		if(psdList.size() > 0){
			dto.setProcessStatusDef(psdList.get(0));
		}
		getProcessParticipantsByStatus(dto);
		IGPRR0102Form form = new IGPRR0102Form();
		form.setPrid(process.getPrid());
		form.setPrstatus(process.getPrstatus());
		dto.setIgPRR0102Form(form);
		getAuthorizeuser(dto);
		log.debug("=============取得流程参与人信息操作结束===================");
		return dto;
	}
	
	/**
	 * 表单值复制
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO copyProcessInfoValueAction(IGPRR01DTO dto) throws BLException {
		log.debug("==============表单值复制操作开始=================");
		//参数取得
		IGPRR0102Form form = dto.getIgPRR0102Form();
		/* ----------复制普通表单值---------- */
		//查询该流程的所有表单变量
		List<IG599Info> piList = workFlowOperationBL.getProcessInfo(form.getHistoryPrid());
		Map<String, IG599Info> historyPrInfoMap = new HashMap<String, IG599Info>();
		if(piList != null){
			for(IG599Info pi:piList){
				historyPrInfoMap.put(pi.getPidid(), pi);
			}
		}
		//取得当前表单的表单值
		Map<String, IG007Info> varmap = dto.getVarmap();
		//复制之后的表单值map声明
		Map<String, IG007Info> pivarmap = new LinkedHashMap<String, IG007Info>();
		if(varmap != null){
			Set<Entry<String, IG007Info>> set = varmap.entrySet();
			for(Iterator<Entry<String, IG007Info>> iter = set.iterator();iter.hasNext();){
				Entry<String, IG007Info> entry = iter.next();
				String key = entry.getKey();
				IG007Info info = entry.getValue();
				IG599Info value = historyPrInfoMap.get(key);
				IG007TB pidTB = (IG007TB) SerializationUtils.clone(info);
				if(IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(info.getPidaccess()) && value != null){
					pidTB.setPidvalue(value.getPivarvalue());
					//如果是私有表单，讲私有表单的值复制给当前表单
					if(IGPRDCONSTANTS.PIDMODE_PRIVATE.equals(info.getPidmode())){
						pidTB.setProcessPrivateInfoList(value.getProcessPrivateInfofList());
					}
				}
				pivarmap.put(key, pidTB);
			}
		}
		dto.setVarmap(pivarmap);
		/* ----------复制表格表单值---------- */
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(form.getHistoryPrid());
		List<IG898Info> tableColumnValueList = workFlowOperationBL.searchTableFormValue(cond);
		if(tableColumnValueList != null){
			Map<String, Map<String, Map<String, String>>> tableColumnValueMap = new HashMap<String, Map<String,Map<String,String>>>();
			for(IG898Info columnValue:tableColumnValueList){
				String value = columnValue.getPvalue();
				if(StringUtils.isNotEmpty(columnValue.getAttkey())){
					value = "";
				}
				if(tableColumnValueMap.get(columnValue.getPidid()) == null){
					Map<String, Map<String, String>> one = new LinkedHashMap<String, Map<String,String>>();
					Map<String, String> two = new LinkedHashMap<String, String>();
					two.put(columnValue.getPvcolpidid(), value);
					one.put(columnValue.getPvrownumber(), two);
					tableColumnValueMap.put(columnValue.getPidid(), one);
				}else{
					if(tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()) == null){
						Map<String, String> temp = new LinkedHashMap<String, String>();
						temp.put(columnValue.getPvcolpidid(), value);
						tableColumnValueMap.get(columnValue.getPidid()).put(columnValue.getPvrownumber(), temp);
					}else{
						tableColumnValueMap.get(columnValue.getPidid()).get(columnValue.getPvrownumber()).put(columnValue.getPvcolpidid(), value);
					}
				}
			}
			dto.setTableColumnValueMap(tableColumnValueMap);
		}
		
		List<IG731Info> pieList = workFlowOperationBL.searchProcessInfoEntityByPrid(form.getHistoryPrid());
		Map<String, IG731Info> pieMap = new HashMap<String, IG731Info>();
		if(pieList != null){
			for(IG731Info pie : pieList){
				String key = pie.getPieid() + "";
				pieMap.put(key, pie);
			}
		}
		dto.setPieMap(pieMap);
		log.debug("==============表单值复制操作结束=================");
		return dto;
	}
	
	/**
	 * 初始化流程类表单值
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO initProcessInfoFormValue(IGPRR01DTO dto) throws BLException {
		List<IG505Info> list = workFlowOperationBL.searchIG505InfoByprid(dto.getProcess().getPrid());
		Map<String, IG505Info> processInfoFormValueMap = new LinkedHashMap<String, IG505Info>();
		if(list != null){
			for(IG505Info pv:list){
				String key = pv.getPiprrid() + "";
				processInfoFormValueMap.put(key, pv);
			}
		}
		dto.setProcessInfoFormValueMap(processInfoFormValueMap);
		return dto;
	}
	
	/**
	 * 初始化人员类表单
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGPRR01DTO initParticipantFormValue(IGPRR01DTO dto) throws BLException {
		List<IG506Info> list = workFlowOperationBL.searchIG506InfoByprid(dto.getProcess().getPrid());
		Map<String, IG506Info> participantFormValueMap = new LinkedHashMap<String, IG506Info>();
		if(list != null){
			for(IG506Info pv:list){
				String key = pv.getPiuid() + "";
				participantFormValueMap.put(key, pv);
			}
		}
		dto.setParticipantFormValueMap(participantFormValueMap);
		return dto;
	}
	
	/**
	 * 封装人员表单实体信息
	 * @param par_userids 人员id集合
	 * @param par_usernames 人员名称集合
	 * @param par_orgids 人员机构码集合
	 * @param par_orgnames 人员机构名称集合
	 * @param par_roleids 人员角色id集合
	 * @param par_rolenames 人员角色名称集合
	 * @param par_pidids 对应表单定义id集合
	 * @return
	 */
	public Map<String, List<IG506TB>> packingParticipantList(String[] par_userids,String[] par_usernames,String[] par_orgids,String[] par_orgnames,Integer[] par_roleids,String[] par_rolenames,String[] par_pidids,String [] par_phone){
		Map<String, List<IG506TB>> participantFormInfo = new HashMap<String, List<IG506TB>>();
		if(par_userids == null 
				|| par_usernames == null
				|| par_orgids == null
				|| par_orgnames == null
				|| par_roleids == null
				|| par_rolenames == null
				|| par_pidids == null
				|| par_phone == null){
			return participantFormInfo;
		}
		for(int i=0;i<par_userids.length;i++){
			String pidid = par_pidids[i];
			IG506TB entry = new IG506TB();
			entry.setPiorgid(par_orgids[i]);
			entry.setPiorgname(par_orgnames[i]);
			entry.setPiroleid(Integer.valueOf(par_roleids[i]));
			entry.setPirolename(par_rolenames[i]);
			entry.setPiuserid(par_userids[i]);
			entry.setPiusername(par_usernames[i]);
			entry.setPiphone(par_phone[i]);
			if(participantFormInfo.get(pidid) == null){
				List<IG506TB> temp = new ArrayList<IG506TB>();
				temp.add(entry);
				participantFormInfo.put(pidid, temp);
			}else{
				participantFormInfo.get(pidid).add(entry);
			}
		}
		return participantFormInfo;
	}
	
	/**
	 * 生成子流程的流程图
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGPRR01DTO searchChileFlowChartAction(IGPRR01DTO dto) throws BLException {
		log.debug("===============子流程流程图生成操作开始==============");
		IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(dto.getPsdid());
		if(info != null){
			String xml = info.getPsdxml();
			if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(info.getPsdtype())
				&& dto.getPrid() != null && dto.getPrid() > 0){
				IG224SearchCondImpl cond = new IG224SearchCondImpl();
				cond.setPrid(dto.getPrid());
				cond.setPpsdid(info.getPsdid());
				cond.setNowstatus("Y");
				cond.setCurrentPrstatus(true);
				List<IG224Info> list = workFlowOperationBL.searchProcessStatusLog(cond);
				Set<Integer> set = new LinkedHashSet<Integer>();
				for(IG224Info sl:list){
					if(sl.getPsdnum() != null && sl.getPsdnum() > 0){
						set.add(sl.getPsdnum());
					}
				}
				if(set.size() > 0){
					try {
						Document document = DocumentHelper.parseText(xml);
						Element root = document.getRootElement();
						List<Element> steps = new ArrayList<Element>();
						int height = 0;
						for(Iterator<Element> step = root.element("Steps").elementIterator("Step");step.hasNext();){
							Element next = step.next();
							steps.add(next);
							int g = Integer.valueOf(next.element("VMLProperties").attributeValue("y").replace("px", "")) + 100;
							if(g > height){
								height = g;
							}
						}
						List<Element> actions = new ArrayList<Element>();
						for(Iterator<Element> action = root.element("Actions").elementIterator("Action");action.hasNext();){
							Element next = action.next();
							actions.add(next);
						}
						
						String startid = "";
						String endid = "";
						int index = 0;
						
						document = DocumentHelper.createDocument();
						Element rootElement = document.addElement("WebFlow");
						Element stepsElement = rootElement.addElement("Steps");
						Element actionsElement = rootElement.addElement("Actions");
						for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
							Integer next = iter.next();
							for(Element e:steps){
								String type = e.element("BaseProperties").attributeValue("stepType");
								if((("BeginStep".equals(type) || "EndStep".equals(type)) && index == 0) || (!"BeginStep".equals(type) && !"EndStep".equals(type))){
									Element step = stepsElement.addElement("Step");
									Element baseProperties = step.addElement("BaseProperties");
									baseProperties.addAttribute("id", e.element("BaseProperties").attributeValue("id") + "_" + next);
									baseProperties.addAttribute("text", e.element("BaseProperties").attributeValue("text"));
									baseProperties.addAttribute("stepType", type);
									baseProperties.addAttribute("psdtype", e.element("BaseProperties").attributeValue("psdtype"));
									Element vmlProperties = step.addElement("VMLProperties");
									vmlProperties.addAttribute("width", e.element("VMLProperties").attributeValue("width"));
									vmlProperties.addAttribute("height", e.element("VMLProperties").attributeValue("height"));
									vmlProperties.addAttribute("x", e.element("VMLProperties").attributeValue("x"));
									int y = height * index + Integer.valueOf(e.element("VMLProperties").attributeValue("y").replace("px", ""));
									vmlProperties.addAttribute("y", y + "");
									if("BeginStep".equals(type)){
										startid = e.element("BaseProperties").attributeValue("id");
									}
									if("EndStep".equals(type)){
										endid = e.element("BaseProperties").attributeValue("id");
									}
								}
							}
							index ++;
						}
						for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
							Integer next = iter.next();
							for(Element e:actions){
								String id = e.element("BaseProperties").attributeValue("id") + "_" + next;
								String actionType = e.element("BaseProperties").attributeValue("actionType");
								String from = e.element("BaseProperties").attributeValue("from").equals(startid) ? e.element("BaseProperties").attributeValue("from") + "_1"  : e.element("BaseProperties").attributeValue("from") + "_" + next;
								String to = e.element("BaseProperties").attributeValue("to").equals(endid) ? e.element("BaseProperties").attributeValue("to") + "_1" : e.element("BaseProperties").attributeValue("to") + "_" + next;
								Element action = actionsElement.addElement("Action");
								Element baseProperties = action.addElement("BaseProperties");
								baseProperties.addAttribute("id", id);
								baseProperties.addAttribute("actionType", actionType);
								baseProperties.addAttribute("from", from);
								baseProperties.addAttribute("to", to);
							}
						}
						xml = document.asXML().replaceAll("\"", "'");
					} catch (Exception e) {
						log.error("",e);
					}
				}
			}
			dto.setFlowChartXml(xml);
		}
		log.debug("===============子流程流程图生成操作结束==============");
		return dto;
	}
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchProcessInfoLog(IGPRR01DTO dto) throws BLException {
		log.debug("=================表单日志查询操作开始=================");
		if(dto.getPrid() != null && dto.getPrid() > 0){
			//dto参数取得
			Integer prid = dto.getPrid();
			User user = dto.getUser();
			//查询当前流程
			IG500Info process = workFlowOperationBL.searchProcessRecordByKey(prid);
			//表单权限集合
			List<IG893Info> variableList = null;
			//查询当前状态
			List<String> statuses = workFlowOperationBL.searchCurrentRecordStatus(prid);
			//当前用户当前流程处理角色
			Integer roleid = null;
			
			//取得状态定义ID
			String psdid = null;
			if(statuses != null && !statuses.isEmpty()){
				psdid = statuses.get(0).indexOf("_") > 0 ? statuses.get(0).split("_")[0] : statuses.get(0);
				//查询当前参与人
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(prid);
				ppCond.setPpproctimeIsNull("Y");
				ppCond.setPpstatus(psdid);
				//查询当前节点参与人
				List<IG337Info> ppList = workFlowOperationBL.searchProcessParticipants(ppCond);
				//找不到对应当前用户的处理人记录时，把所有参与人角色当做查询条件，查找与当前用户同角色处理人
				List<Integer> roleid_in = new ArrayList<Integer>();
				//遍历当前处理人，找到当前用户对应的参与人用户
				for(IG337Info info:ppList){
					if(!roleid_in.contains(info.getPproleid())){
						roleid_in.add(info.getPproleid());
					}
					if(user.getUserid().equals(info.getPpuserid())){
						roleid = info.getPproleid();
					}
				}
				if(roleid == null){
					UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
					urcond.setRoleid_in(roleid_in);
					urcond.setUserid(user.getUserid());
					List<UserRoleInfo> roleList = userRoleBL.searchUserRoleVW(urcond);
					if(roleList != null && roleList.size() > 0){
						roleid = roleList.get(0).getRoleid();
					}
				}
			}
			if(roleid != null){
				variableList = workFlowOperationBL.searchParticipantVariableVW(psdid,roleid);
			}else{
				dto.setProcess(process);
				getNotCurrentFormAccessPower(dto);
				variableList = dto.getParticipantVariableVWList();
			}
			if(variableList != null){
				//权限集合，转为Map，方便通过表单定义ID查找到权限
				Map<String, IG893Info> variableMap = new HashMap<String, IG893Info>();
				for(IG893Info info:variableList){
					variableMap.put(info.getPidid(), info);
				}
				IG113SearchCondImpl cond = new IG113SearchCondImpl();
				cond.setPrid(dto.getPrid());
				List<IG113Info> list = workFlowOperationBL.searchRecordLogVarInfoByCond(cond);
				List<IG113Info> dataList = new ArrayList<IG113Info>();
				for(IG113Info info:list){
					IG893Info variable = variableMap.get(info.getPidid());
					if(variable != null){
						if(!IGPRDCONSTANTS.PROCESSTITLE_HIDE.equals(variable.getPidaccess())){
							dataList.add(info);
						}
					}
				}
				dto.setVarLogList(dataList);
			}
		}
		log.debug("=================表单日志查询操作结束=================");
		return dto;
	}
	
	/**
	 * 根据流程prid获取流程工单号
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR01DTO searchSerialNum(IGPRR01DTO dto) throws BLException {
		log.debug("===============根据流程prid获取流程工单号开始==============");
		IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(dto.getPrid());
		if(prInfo != null){
			String serialNum = prInfo.getPrserialnum();
			dto.setSerialNum(serialNum);
		}
		log.debug("===============根据流程prid获取流程工单号结束==============");
		return dto;
	}

    /**
     * 获取状态级私有表单值并将值存入 processInfoDefmap
     * 并将资产信息存入
     * @Title: getStatusPrivateValue
     * @param dto
     * @throws BLException
     */
    private void getStatusPrivateValue(IGPRR01DTO dto) throws BLException {
        log.debug("===========获取状态级私有表单值开始================");
        //状态级私有表单值集合如果没有实际值，则取查询默认值。
        String prid=null;
        if(dto.getPrid()!=null&&dto.getPrid()!=0){
            prid=String.valueOf(dto.getPrid());
        }
        //查询默认值或实际值
        Map<String, IG561Info> map = workFlowOperationBL.searchStatusValue(dto.getPdid(), dto.getPsdid(),prid);
        Map<String, IG007Info> processInfoDefmap = dto.getProcessInfoDefmap();
        if(processInfoDefmap==null){
            return;
        }
        for(Entry<String, IG007Info> entry:processInfoDefmap.entrySet()){
            IG007TB ig007TB=(IG007TB)entry.getValue();
            if(map.get(entry.getKey())!=null){
                IG561Info ig561Info= map.get(entry.getKey());
                ig007TB.setPidvalue(ig561Info.getPivarvalue());//直接更改指针指向，不回存
                //如果是附件，则将附件的值存入（保存逻辑，查询已经上传过的ATT，非默认Att）
                if("F".equals(ig561Info.getPivartype())){
                    if(StringUtils.isNotEmpty(ig561Info.getPiattkey()))
                        ig007TB.setPidvalue(ig561Info.getPiattkey());
                }
//              ig007TB.setPiddefault(ig561Info.getPivarvalue());
//              if(ig561Info.getPvlid()!=null&&ig561Info.getPvlid()!=0){
//                  ig007TB.setPiid(ig561Info.getPvlid());
//              }
            }
        }
        //用于显示更改已有资产表单到prossinfolist中
        List<IG599Info> pilist = dto.getProcessInfo();
        List<IG599Info> deletelist= new ArrayList<IG599Info>();
        if(pilist==null){
            return ;
        }
        for(IG599Info info:pilist){
            boolean flag=true;
            if("4".equals(info.getPivartype())&&"2".equals(info.getPidmode())){
                flag=false;
            }
            for(Entry<String, IG561Info> entry:map.entrySet()){
                IG561Info ig561TB=entry.getValue();
                if(info.getPiid().intValue()==(ig561TB.getPiid()!=null?ig561TB.getPiid().intValue():0)){
                    flag=true;
                    //将实际资产存入
                    this.copyProperties(info, ig561TB);
                    //如果有资产值，就清空(状态级私有表单会记录实际资产的值，用于区分不动节点有不动的资产)
                    if("4".equals(info.getPivartype())){
                        ((IG599TB)info).setPivarvalue("");
                    }
                }
            }
            if(!flag){
                deletelist.add(info);
            }
        }
        //如果不可拷贝，全部删除。就是没有实际值，只有默认值。
        pilist.removeAll(deletelist);
        log.debug("===========获取状态级私有表单值结束================");
    }
	
    
    /**
     * @throws BLException 
     * 流程处于关闭状态下流程查看显示，需要将状态级表单以列表形式显示 
     * @Title: statusCloseSeeOperate
     * @Description: 流程处于关闭状态下流程查看显示，需要将状态级表单以列表形式显示 
     * @param dto
     * @throws
     */
    private void statusCloseSeeOperate(IGPRR01DTO dto) throws BLException{
        //如果不是关闭状态直接返回
        if(!dto.getPsdid().endsWith("002")){
            return;
        }
        IG560SearchCondImpl cond560 = new IG560SearchCondImpl();
        cond560.setPidid_l(dto.getPdid());
        List<IG560Info> list_560=workFlowDefinitionBL.searchIG560TBInfo(cond560);
        Map<String,IG560Info> defaultmap = new HashMap<String, IG560Info>();
        //两次遍历先存入全局的后用特殊的覆盖
        for(IG560Info info:list_560 ){
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                defaultmap.put(info.getPidid(), info);
            }
        }
        //默认值节点处理
        for(IG560Info info:list_560 ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                //pidid+psdid 作为key
                defaultmap.put(info.getPidid()+info.getPsdid(), info);
            }
        }
        
        String prid=null;
        if(dto.getPrid()!=null&&dto.getPrid()!=0){
            prid=String.valueOf(dto.getPrid());
        }
        String userid=dto.getUser().getUserid();
        List<IG561VWInfo> list561VW = workFlowOperationBL.searchIG561VW(prid, userid, false);
        if(list561VW==null||list561VW.size()==0){
            return;
        }
        //key为pidid
        Map<String,List<IG561VWInfo>> map= new HashMap<String, List<IG561VWInfo>>();
        for(IG561VWInfo ig561vwInfo :list561VW){
            //对info 进行处理，如果pidaccess 为只读，如果有默认值则将默认值存入.
            IG561VW tb= (IG561VW)SerializationUtils.clone(ig561vwInfo);
            //附件或者资产为空
            if(("F".equals(tb.getPivartype())&&StringUtils.isEmpty(tb.getPiattkey()))
                    ||
               ("4".equals(tb.getPivartype())&&StringUtils.isEmpty(tb.getPivarvalue()))){
                //如果有全局默认值则将全局默认值存入
                String defaultvalue=null;
                if(defaultmap.get(tb.getPidid())!=null){
                    defaultvalue= defaultmap.get(tb.getPidid()).getDfvalue();
                }
                //如果有节点的特殊默认值，则覆盖全局默认值
                if(defaultmap.get(tb.getPidid()+tb.getPsdid())!=null){
                    defaultvalue= defaultmap.get(tb.getPidid()+tb.getPsdid()).getDfvalue();
                }
                if(StringUtils.isNotEmpty(defaultvalue)){
                    tb.setPivarvalue("def_"+defaultvalue);
                }
            }
            //封装进入map
            if(map.get(tb.getPidid())!=null){
                List<IG561VWInfo> list= map.get(tb.getPidid());
                list.add(tb);
            }else{
                List<IG561VWInfo> list= new ArrayList<IG561VWInfo>();
                list.add(tb);
                map.put(tb.getPidid(), list);
            }
        }
        dto.setStatusclosedetails(map);
    }
    
    /**
     * 保存状态级私有表单附件值
     */
    private void saveOrUpdateStatusVars(IGPRR0102Form form, List<IG599Info> processInfoList, String[] attStr, Map<Integer, FormFile> fileMapMuti,
            String delFileMutiStr,String psdid) throws BLException {
        //状态级私有表单附件转存逻辑
        List<String> existStr = new ArrayList<String>();
        if(attStr!=null){
            for(int i = 0; i < attStr.length; i++){
                String[] att = attStr[i].split("_");
                if(existStr.contains(att[0])){
                    continue;
                }
                Integer piid;
                for(int j = 0; j < processInfoList.size();j++){
                    IG599TB piTB = (IG599TB)processInfoList.get(j);
                    if(att[0].equals(piTB.getPivarlabel()) && IGPRDCONSTANTS.PIDMODE_STATUS.equalsIgnoreCase(piTB.getPidmode())){
                        piid = piTB.getPiid();
                        IG599Info pi = workFlowOperationBL.getProcessInfoByID(piid);
                        if(IGPRDCONSTANTS.PIDMODE_PUBLIC.equalsIgnoreCase(pi.getPidmode())){
                            continue;
                        }
                        IG561SearchCondImpl cond = new IG561SearchCondImpl();
                        cond.setPiid_q(piid.toString());
                        cond.setPsdid_l(psdid);
                        List<IG561Info> statusInfos =  workFlowOperationBL.searchIG561Info(cond);
                        //状态没有相关信息
                        if(statusInfos == null || statusInfos.size() == 0){
                            Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                            for(int k = 0; k < attStr.length;k++){
                                if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                    if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                        filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                        if(!existStr.contains(pi.getPivarlabel())){
                                            existStr.add(pi.getPivarlabel());
                                        }
                                    }
                                }
                            }
                            pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
                            piTB.setPiattkey(pi.getPiattkey());
                            processInfoList.set(j, piTB);
                        }else{
                            //私有表有相关信息，进行更改
                            for(int iNum = 0; iNum < statusInfos.size(); iNum++){
                                IG561TB ig561TB = (IG561TB)statusInfos.get(iNum);
                                if(StringUtils.isNotEmpty(ig561TB.getPiattkey())){
                                    Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                                    for(int k = 0; k < attStr.length;k++){
                                        if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                            if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                                filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                                if(!existStr.contains(pi.getPivarlabel())){
                                                    existStr.add(pi.getPivarlabel());
                                                }
                                            }
                                        }
                                    }
                                    workFlowOperationBL.addProcessInfoAtt(filemap, ig561TB.getPiattkey());
                                }else{
                                    Map<Integer, FormFile> filemap = new LinkedHashMap<Integer, FormFile>();
                                    for(int k = 0; k < attStr.length;k++){
                                        if(pi.getPivarlabel().equals(attStr[k].split("_")[0])){
                                            if(fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])) != null){
                                                filemap.put(k, fileMapMuti.get(Integer.parseInt(attStr[k].split("_")[1])));
                                                if(!existStr.contains(pi.getPivarlabel())){
                                                    existStr.add(pi.getPivarlabel());
                                                }
                                            }
                                        }
                                    }
                                    pi=workFlowOperationBL.updateProcessInfo(filemap,pi);
                                    piTB.setPiattkey(pi.getPiattkey());
                                    processInfoList.set(j, piTB);
                                }
                            }
                        }
                    }
                }
            }
        }
    }



    
}

