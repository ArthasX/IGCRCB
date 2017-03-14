/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.bl.SendMailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.model.entity.AttachmentTB;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCond;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserRoleVW;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG212BL;
import com.deliverik.framework.workflow.prd.bl.task.IG482BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG731BL;
import com.deliverik.framework.workflow.prd.bl.task.IG893BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupEventBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowGroupProcessLaunchBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowJspHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowMessageGeneratorBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowSerialnumGeneratorBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBean;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowThreadEventHandlerBLImpl;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG482Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.IG893Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG482SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG893SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG105PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.bl.task.CurrentMonthWorkVWBL;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG113BL;
import com.deliverik.framework.workflow.prr.bl.task.IG224BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG463BL;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG485BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG505BL;
import com.deliverik.framework.workflow.prr.bl.task.IG506BL;
import com.deliverik.framework.workflow.prr.bl.task.IG512BL;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG711BL;
import com.deliverik.framework.workflow.prr.bl.task.IG715BL;
import com.deliverik.framework.workflow.prr.bl.task.IG898BL;
import com.deliverik.framework.workflow.prr.bl.task.IG899BL;
import com.deliverik.framework.workflow.prr.bl.task.IG933BL;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG113Info;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG463Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG500ONLYInfo;
import com.deliverik.framework.workflow.prr.model.IG505Info;
import com.deliverik.framework.workflow.prr.model.IG506Info;
import com.deliverik.framework.workflow.prr.model.IG512Info;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG602Info;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.IG711Info;
import com.deliverik.framework.workflow.prr.model.IG715Info;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG113SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG463SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG512SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG711SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG715SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224TB;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG483TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG505TB;
import com.deliverik.framework.workflow.prr.model.entity.IG506TB;
import com.deliverik.framework.workflow.prr.model.entity.IG512TB;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.framework.workflow.prr.model.entity.IG715TB;
import com.deliverik.framework.workflow.prr.model.entity.IG898PK;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.util.ComputingTime;

/**
 * <p>
 * 流程处理业务逻辑实现
 * </p>
 * 
 */

public class WorkFlowOperationBLImpl extends BaseBLImpl implements WorkFlowOperationBL {
	
	private static Log log = LogFactory.getLog(WorkFlowOperationBLImpl.class);
	
	// 二次开发log
	private static Log igflowlog = LogFactory.getLog(Constants.IGFLOW_LOG_NAME);
	
	/** 流程信息操作 */
	private IG500BL ig500BL;
	
	/** 流程变量操作 */
	private IG599BL ig599BL;

	/** 参与者信息操作 */
	private IG337BL ig337BL;

	/** 日志信息操作 */
	private IG036BL ig036BL;

	/** 上传附件信息操作 */
	private FileUploadBL fileUploadBL;

	/** 附件信息操作 */
	private AttachmentBL attachmentBL;
	
	/** 用户角色操作 */
	private UserRoleBL userRoleBL;
	
	/** 角色操作 */
	private RoleBL roleBL;
	
	/** 用户操作 */
	private UserBL userBL;
	
	/** 流程定义信息操作 */
	private WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 流程关系信息操作 */
	private IG512BL ig512BL;
	
	/** 流程状态日志信息操作*/
	protected IG224BL ig224BL;
	
	/** 流程状态日志信息操作*/
	protected IG113BL ig113BL;
	
	/** 流程参与者变量权限视图*/
	protected IG893BL ig893BL;
	
	/** 流程资产关系 */
	private IG731BL ig731BL;
	
	/** 流程资产关系 */
	private IG105BL ig105BL;
	
	/** 流程私有变量 */
	protected IG899BL ig899BL;

	/** 流程通知策略设定BL */
	protected IG212BL ig212BL;
	
	/** 短信BL */
	protected SendMessageBL sendMessageBL;
	
	/** 邮件BL */
	protected SendMailBL sendMailBL;
	
	protected CodeListUtils codeListUtils;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;

	/** 查询带有当前处理人的本月工作BL */
	protected CurrentMonthWorkVWBL currentMonthWorkVWBL;
	
	/** 流程类表单值BL */
	protected IG505BL ig505BL;
	
	/** 表格式表单值BL */
	protected IG898BL ig898BL;
	
	/** 人员表单值BL */
	protected IG506BL ig506BL;
	
	/** 流程工单关系BL */
	protected IG715BL ig715BL;
	
	/**服务工单业务BL*/
	protected IG933BL ig933BL;
	
	/**代理工作BL*/
	protected IG463BL ig463BL;
	
	/**用户授权BL*/
	protected IG711BL ig711BL;
	
	/**流程组关系定义BL*/
	protected IG482BL ig482BL;
	
	/**流程组实例BL*/
	protected IG483BL ig483BL;
	
	/**流程组成员实例BL*/
	protected IG484BL ig484BL;
	
	/**流程组关系实例BL*/
	protected IG485BL ig485BL;
	
	/**状态级私有表单默认值BL*/
    protected IG560BL ig560BL;
    
    /**状态级私有表单值表*/
    protected IG561BL ig561BL;
	
	/**
	 * <p>
	 * 查询带有当前处理人的本月工作BL设定
	 * <p>
	 * 
	 * @param currentMonthWorkVWBL 查询带有当前处理人的本月工作BL 
	 */
	public void setCurrentMonthWorkVWBL(CurrentMonthWorkVWBL currentMonthWorkVWBL) {
		this.currentMonthWorkVWBL = currentMonthWorkVWBL;
	}

	/**
	 * <p>
	 * 机构BL设定
	 * <p>
	 * 
	 * @param organizationBL 机构BL 
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * <p>
	 * 设置流程状态日志信息
	 * <p>
	 * 
	 * @param ig222BL 流程状态日志信息
	 */
	public void setIg113BL(IG113BL ig113BL) {
		this.ig113BL = ig113BL;
	}
	
	/**
	 * <p>
	 * 设置流程信息操作
	 * <p>
	 * 
	 * @param ig500BL 流程信息操作
	 */
	
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}
	
	/**
	 * <p>
	 * 设置流程变量信息操作
	 * <p>
	 * 
	 * @param ig599BL 流程变量信息操作
	 */
	
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}
	
	/**
	 * <p>
	 * 设置参与者信息操作
	 * <p>
	 * 
	 * @param ig337BL 参与者信息操作
	 */
	
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}
	
	/**
	 * <p>
	 * 设置日志信息操作
	 * <p>
	 * 
	 * @param ig036BL 日志信息操作
	 */
	
	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	/**
	 * <p>
	 * 设置上传附件信息操作
	 * <p>
	 * 
	 * @param fileUploadBL 上传附件信息操作
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	/**
	 * <p>
	 * 设置附件信息操作
	 * <p>
	 * 
	 * @param attachmentBL 附件信息操作
	 */
	
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * <p>
	 * 设置用户角色操作
	 * <p>
	 * 
	 * @param userRoleVWBL 用户角色操作
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * <p>
	 * 设置角色操作
	 * <p>
	 * 
	 * @param roleBL 角色操作
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * <p>
	 * 设置流程定义信息操作
	 * <p>
	 * 
	 * @param workFlowDefinitionBL 流程定义信息操作
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * <p>
	 * 设置流程关系信息操作
	 * <p>
	 * 
	 * @param ig512BL 流程关系信息操作
	 */
	public void setIg512BL(
			IG512BL ig512BL) {
		this.ig512BL = ig512BL;
	}
	
	/**
	 * <p>
	 * 设置流程状态信息操作
	 * <p>
	 * 
	 * @param ig224BL 流程状态信息操作
	 */
	public void setIg224BL(IG224BL ig224BL) {
		this.ig224BL = ig224BL;
	}
	
	/**
	 * <p>
	 * 设置用户BL操作
	 * <p>
	 * 
	 * @param userBL 用户BL操作
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * <p>
	 * 设置流程参与者变量权限视图操作
	 * <p>
	 * 
	 * @param ig893BL流程参与者变量权限视图操作
	 */
	public void setIg893BL(IG893BL ig893BL) {
		this.ig893BL = ig893BL;
	}

	/**
	 * 流程资产关系信息
	 * @param ig731BL 流程资产关系
	 */
	public void setIg731BL(IG731BL ig731BL) {
		this.ig731BL = ig731BL;
	}
	
	/**
	 * 流程策略BL
	 * @param ig105BL 流程策略BL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}

	/**
	 * <p>
	 * 流程私有变量设定
	 * </p>
	 *
	 * @param ig899BL 流程私有变量
	 */
	public void setIg899BL(IG899BL ig899BL) {
		this.ig899BL = ig899BL;
	}
	
	/**
	 * 短信BL设定
	 * 
	 * @param sendMessageBL 短信BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * 邮件BL设定
	 * 
	 * @param sendMailBL 邮件BL
	 */
	public void setSendMailBL(SendMailBL sendMailBL) {
		this.sendMailBL = sendMailBL;
	}

	/**
	 * 流程通知策略设定BL设定
	 * 
	 * @param ig212BL 流程通知策略设定BL
	 */
	public void setig212BL(
			IG212BL ig212BL) {
		this.ig212BL = ig212BL;
	}
	
	/**
	 * 基础数据BL设定
	 * 
	 * @param codeListUtils 基础数据BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * 服务工单业务BL设定
	 * @param ig933BL 服务工单业务BL
	 */
	public void setIg933BL(IG933BL ig933bl) {
		ig933BL = ig933bl;
	}

	/**
	 * 流程类表单值BL设定
	 * @param ig505BL 流程类表单值BL
	 */
	public void setIg505BL(IG505BL ig505bl) {
		ig505BL = ig505bl;
	}

	/**
	 * 代理工作BL设定
	 * @param ig463BL 代理工作BL
	 */
	public void setIg463BL(IG463BL ig463bl) {
		ig463BL = ig463bl;
	}

	/**
	 * 用户授权BL设定
	 * @param ig711BL 用户授权BL
	 */
	public void setIg711BL(IG711BL ig711bl) {
		ig711BL = ig711bl;
	}
	
	/**
	 * 流程组关系定义BL设定
	 * @param ig482BL 流程组关系定义BL
	 */
	public void setIg482BL(IG482BL ig482BL) {
		this.ig482BL = ig482BL;
	}
	
	/**
	 * 流程组实例BL设定
	 * @param ig483BL 流程组实例BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}
	
	/**
	 * 流程组成员实例BL设定
	 * @param ig484BL 流程组成员实例BL
	 */
	public void setIg484BL(IG484BL ig484BL) {
		this.ig484BL = ig484BL;
	}
	
	/**
	 * 流程组关系实例BL设定
	 * @param ig485BL 流程组关系实例BL
	 */
	public void setIg485BL(IG485BL ig485BL) {
		this.ig485BL = ig485BL;
	}

	/**
	 * <p>
	 * 新的流程信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程信息对象实例取得
	 */

	public IG500TB getProcessRecordTBInstance() {
		return ig500BL.getIG500TBInstance();
	}
	
	/**
	 * <p>
	 * 新的流程变量信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程变量信息对象实例取得
	 */
	public IG599TB getProcessInfoTBInstance() {
		return ig599BL.getIG599TBInstance();
	}
    public void setIg560BL(IG560BL ig560bl) {
        ig560BL = ig560bl;
    }

    public void setIg561BL(IG561BL ig561bl) {
        ig561BL = ig561bl;
    }	
	
	/**
	 * 人员表单值BL设定
	 * @param ig506BL 人员表单值BL
	 */
	public void setIg506BL(IG506BL ig506bl) {
		ig506BL = ig506bl;
	}
	
	/**
	 * 流程工单关系BL设定
	 * @param ig715BL 流程工单关系BL
	 */
	public void setIg715BL(IG715BL ig715bl) {
		ig715BL = ig715bl;
	}

	/**
	 * <p>
	 * 新的流程私有变量信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程私有变量信息对象实例取得
	 */
	public IG899TB getProcessPrivateInfoTBInstance() {
		return ig899BL.getIG899TBInstance();
	}

	/**
	 * <p>
	 * 新的参与者信息对象实例取得
	 * <p>
	 * 
	 * @return 新的参与者信息对象实例取得
	 */

	public IG337TB getProcessParticipantTBInstance() {
		return ig337BL.getIG337TBInstance();
	}

	/**
	 * <p>
	 * 新的日志信息对象实例取得
	 * <p>
	 * 
	 * @return 新的日志信息对象实例取得
	 */
	
	public IG036TB getRecordLogTBInstance() {
		return ig036BL.getIG036TBInstance();
	}
	
	/**
	 * <p>
	 * 新的流程关系信息对象实例取得
	 * <p>
	 * 
	 * @return 新的流程关系信息对象实例取得
	 */
	
	public IG512TB getProcessRecordRelationTBInstance() {
		return ig512BL.getIG512TBInstance();
	}
	
	/**
	 * 表格式表单值BL设定
	 * @param ig898BL 表格式表单值BL
	 */
	public void setIg898BL(IG898BL ig898bl) {
		ig898BL = ig898bl;
	}
	
	/**
	 * <p>
	 * 流程发起
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	
	public IG500Info createProcessRecord(IG500Info processRecord, User user, Integer roleid,
			String comment, String desc, Map<Integer, FormFile> filemap, String type, String pbdid, String prstatus)
			throws BLException{
		processRecord = ig500BL.registIG500Info(processRecord);
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}

	/**
	 * <p>
	 * 流程发起
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param participantList 流程参与者信息List
	 * @param processInfoList 流程变量信息List
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 流程信息
	 * @throws BLException
	 *
	 */

	public IG500Info createProcessRecord(IG500Info processRecord, List<IG337Info> participantList,
			List<IG599Info> processInfoList, User user, Integer roleid, 
			String comment, String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus)
			throws BLException {
		processRecord = createProcessRecord(processRecord, user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		ig337BL.registIG337Info(participantList);
		if(processInfoList != null && !processInfoList.isEmpty()){
			ig599BL.saveOrUpdIG599Infos(processInfoList);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}

	/**
	 * <p>
	 * 流程状态跃迁
	 * </p>
	 * 
	 * @param srcStatus 流程跃迁时状态，即源状态
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser 授权人用户信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	
	public synchronized IG500Info updateProcessRecord(String srcStatus,IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrstatus(srcStatus);
		cond.setPrid(processRecord.getPrid());
		List<IG500Info> list = ig500BL.searchIG500Info(cond, 0, 0);
		if(list.size() != 1){
			throw new BLException("IGSVC0000.E001");
		}
		processRecord = ig500BL.updateIG500Info(processRecord);
		
		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// 如果存在日志内容, 则换行
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}
	
	/**
	 * <p>
	 * 流程信息更新，状态不改变
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser 授权人用户信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */
	
	public IG500Info updateProcessRecord(IG500Info processRecord,
			User user, Integer roleid, String comment, String desc,
			Map<Integer, FormFile> filemap,String type, User authorizeuser, String pbdid, String prstatus)
	throws BLException {
		String currentStatus = ig500BL.searchIG500InfoByKey(processRecord.getPrid()).getPrstatus();
		if(!currentStatus.equals(processRecord.getPrstatus())) {
			throw new BLException("IGSVC0000.E003");
		}
		processRecord = ig500BL.updateIG500Info(processRecord);
		
		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// 如果存在日志内容, 则换行
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processRecord.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processRecord;
	}
	
	/**
	 * <p>
	 * 流程信息更新，状态不改变,不记录日志
	 * </p>
	 * 
	 * @param processRecord 流程信息
	 * @return 流程信息
	 * @throws BLException
	 *
	 */

	public IG500Info updateProcessRecord(IG500Info processRecord)
			throws BLException {
		String currentStatus = ig500BL.searchIG500InfoByKey(processRecord.getPrid()).getPrstatus();
		if(!currentStatus.equals(processRecord.getPrstatus())) {
			throw new BLException("IGSVC0000.E003");
		}
		return ig500BL.updateIG500Info(processRecord);
	}
	
	/**
	 * <p>
	 * 指定流程ID查询流程信息
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程信息
	 * @throws BLException 
	 *
	 */
	
	public IG500Info searchProcessRecordByKey(Integer prid) throws BLException {
		return ig500BL.searchIG500InfoByKey(prid);
	}
	
	/**
	 * <p>
	 * 指定工单号查询流程信息
	 * </p>
	 * 
	 * @param prserialnum 流程工单号
	 * @return 流程信息
	 * @throws BLException 
	 *
	 */

	public IG500Info searchProcessRecordBySerialnum(String prserialnum) throws BLException {
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrserialnum(prserialnum);
		List<IG500Info> list = ig500BL.searchIG500Info(cond);
		if(list.size() != 1){
			throw new BLException("IGCO10000.E004","工单号为" + prserialnum + "的流程");
		}
		return list.get(0);
	}

	
	/**
	 * 根据检索条件取得流程信息列表（分页查询用）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	
	public List<IG500Info> searchProcessRecord(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.searchIG500Info(cond, start, count);
	}
	
	/**
	 * 根据检索条件（包括表单条件）取得流程信息列表（分页查询用）
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryIG500EntityListByProcessInfo(IG500SearchCond cond, int start, int count){
		return ig500BL.queryIG500EntityListByProcessInfo(cond, start, count);
	}
	
	/**
	 * 根据检索条件取得流程信息列表
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息检索结果列表
	 */

	public List<IG500Info> searchProcessRecord(IG500SearchCond cond) {
		return ig500BL.searchIG500Info(cond);
	}
	
	/**
	 * 根据检索条件取得流程信息列表（包含事件处理子状态）（平台保留）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	
	public List<IG500Info> searchProcessRecordSubStatusList(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.queryIG500InfoSubStatusList(cond, start, count);
	}
	
	/**
	 * 根据检索条件取得流程信息列表（包含事件处理子状态）（平台保留）
	 * 
	 * @param cond 流程信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 流程信息检索结果列表
	 */
	
	public List<IG500ONLYInfo> searchProcessRecordONLYSubStatusList(
			IG500SearchCond cond, int start, int count) {
		return ig500BL.queryIG500ONLYInfoSubStatusList(cond, start, count);
	}
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForSelfDef(IG500SearchCond cond, int start, int count){
		return ig500BL.searchProcessRecordForSelfDef(cond,start,count);
	}
	
	
	/**
	 * 自定义流程相关工作条件检索记录数
	 * @return 自定义流程条件检索记录数
	 */
	public int searchProcessRecordCountForRelatedWork(IG500SearchCond cond){
		return ig500BL.searchProcessRecordCountForSelfDef(cond);
	}
	
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> searchProcessRecordForRelatedWork(IG500SearchCond cond, int start, int count){
		return ig500BL.searchProcessRecordForSelfDef(cond,start,count);
	}
	
	
	/**
	 * 自定义流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public int searchProcessRecordCountForSelfDef(IG500SearchCond cond){
		return ig500BL.searchProcessRecordCountForSelfDef(cond);
	}
	
	
	/**
	 * <p>
	 * 根据检索条件取得流程信息个数（包含事件处理子状态）（平台保留）
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息个数
	 */

	public int getProcessRecordSubStatusSearchCount(IG500SearchCond cond) {
		return ig500BL.queryIG500InfoSubStatusListCount(cond);
	}

	/**
	 * <p>
	 * 根据检索条件取得流程信息个数（包含事件处理子状态）（平台保留）
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息个数
	 */

	public int getProcessRecordONLYSubStatusSearchCount(IG500SearchCond cond) {
		return ig500BL.queryIG500ONLYInfoSubStatusListCount(cond);
	}

	/**
	 * <p>
	 * 根据检索条件取得流程信息个数
	 * </p>
	 * 
	 * @param cond 流程信息检索条件
	 * @return 流程信息个数
	 */

	public int getProcessRecordSearchCount(IG500SearchCond cond) {
		return ig500BL.getIG500InfoSearchCount(cond);
	}

	/**
	 * <p>
	 * 指定流程ID查询流程发起者
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param initStatus 流程发起状态
	 * @return 流程发起者信息
	 *
	 */

	public IG337Info searchProcessOpener(Integer prid,String initStatus) {
		return ig337BL.getProcessOpener(prid,initStatus);
	}
	
	/**
	 * <p>
	 * Description: 获取指定参与者
	 * </p>
	 * 
	 * @param ppid 参与者ID
	 * @return 参与者信息
	 * @throws BLException 
	 */
	
	public IG337Info searchProcessParticipantByKey(Integer ppid) throws BLException{
		return ig337BL.searchIG337InfoByKey(ppid);
	}

	/**
	 * <p>
	 * 流程指定状态下查询未处理参与者
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 未处理参与者信息
	 *
	 */
	
	public List<IG337Info> searchProcessParticipantTodoRole(Integer prid, String status) {
		return ig337BL.getIG337InfoTodoRoles(prid,status);
	}
	
	/**
	 * <p>
	 * 流程指定状态下未处理参与者取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ppsubstatus 参与者子状态
	 * @return 流程指定状态下未处理参与者
	 *
	 */

	public List<IG337Info> searchProcessParticipantTodoRole(
			Integer prid, String status, String ppsubstatus) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);//流程ID
		cond.setPpstatus(status);
		cond.setPpsubstatus(ppsubstatus);
		cond.setPpproctimeIsNull("Y");//未操作
		return ig337BL.getIG337Infos(cond);
	}
	
	/**
	 * <p>
	 * 流程指定状态下已处理参与者取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 流程指定状态下已处理参与者
	 *
	 */

	public List<IG337Info> searchProcessParticipantDoneRole(
			Integer prid, String status) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpproctimeIsNull("N");
		return ig337BL.getIG337Infos(cond);
	}
	
	/**
	 * <p>
	 * 流程指定状态下已处理参与者取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ppsubstatus 参与者子状态
	 * @return 流程指定状态下已处理参与者
	 *
	 */
	public List<IG337Info> searchProcessParticipantDoneRole(
			Integer prid, String status, String ppsubstatus) {
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(prid);
		cond.setPpstatus(status);
		cond.setPpsubstatus(ppsubstatus);
		cond.setPpproctimeIsNull("Y");
		return ig337BL.getIG337Infos(cond);
	}

	/**
	 * <p>
	 * 流程参与者增加
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,User authorizeuser, String pbdid, String prstatus) throws BLException {
		processParticipant = ig337BL.registIG337Info(processParticipant);

		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// 如果存在日志内容, 则换行
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		return processParticipant;
	}
	
	/**
	 * <p>
	 * 流程参与者增加
	 * </p>
	 * @param processParticipant 参与者信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */
	public IG337Info addProcessParticipant(IG337Info processParticipant) throws BLException{
		processParticipant = ig337BL.registIG337Info(processParticipant);
		return processParticipant;
	}

	/**
	 * <p>
	 * 流程参与者删除
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public void removeProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type, User authorizeuser, String pbdid, String prstatus) throws BLException {

		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// 如果存在日志内容, 则换行
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		ig337BL.deleteIG337Info(processParticipant);
	}
	/**
	 * <p>
	 * 流程参与者删除
	 * 不记录日志
	 * </p>
	 * @param processParticipant 参与者信息
	 * @throws BLException
	 */
	
	public void removeProcessParticipant(IG337Info processParticipant) throws BLException {
		ig337BL.deleteIG337Info(processParticipant);
	}

	/**
	 * <p>
	 * 参与者信息更新，状态不改变
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param authorizeuser 授权人用户信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public synchronized IG337Info updateProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,
			String type,List<IG599Info> prInfoList, User authorizeuser, String pbdid, String prstatus) throws BLException {
		//分派时记录空记录，变成系统日志
		if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(pbdid)) {
			type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
		}
		
		String ppstatus = ig337BL.searchIG337InfoByKey(processParticipant.getPpid()).getPsdid();
		if(!ppstatus.equals(processParticipant.getPsdid())){
			throw new BLException("IGSVC0000.E004");
		}
		processParticipant = ig337BL.updateIG337Info(processParticipant);

		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null && (!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type))) {
			// 如果存在日志内容, 则换行
			comment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), comment);
		}
		IG036Info recordLog = addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, filemap, type, pbdid, prstatus);
		
		
		//提交类型非系统日志时，需要记录表单日志
		if(!IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ.equals(type) && prInfoList!=null && !prInfoList.isEmpty()){
			this.addRecordLogVarInfo(prInfoList, recordLog);
		}
		
		return processParticipant;
	}

	/**
	 * <p>
	 * 参与者信息更新，状态不改变（不增加日志信息）
	 * </p>
	 * 
	 * @param processParticipant 参与者信息
	 * @return 参与者信息
	 * @throws BLException
	 *
	 */

	public synchronized IG337Info updateProcessParticipant(IG337Info processParticipant) throws BLException {
		String ppstatus = ig337BL.searchIG337InfoByKey(processParticipant.getPpid()).getPsdid();
		if(!ppstatus.equals(processParticipant.getPsdid())){
			throw new BLException("IGSVC0000.E004");
		}
		processParticipant = ig337BL.updateIG337Info(processParticipant);
		return processParticipant;
	}
	
	
	/**
	 * <p>
	 * 流程指定状态未处理参与者角色ID集合取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 流程指定状态未处理参与者角色ID集合
	 *
	 */

	public List<Integer> searchProcessParticipantTodoRoleId(Integer prid,
			String status) {
		List<IG337Info> list = ig337BL
				.getIG337InfoTodoRoles(prid, status);
		List<Integer> roleList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			roleList.add(list.get(i).getPproleid());
		}
		return roleList;
	}

	/**
	 * <p>
	 * 流程指定状态下，指定角色参与者信息取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param roleId 角色ID
	 * @param status 流程状态
	 * @return 参与者信息
	 *
	 */

	public IG337Info searchProcessParticipant(Integer prid,
			Integer roleId, String status) {
		return ig337BL.getIG337Info(prid, roleId,
				status);
	}

	/**
	 * <p>
	 * 流程指定状态下，指定角色参与者信息取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * @return 参与者信息
	 *
	 */

	public IG337Info searchProcessParticipant(Integer prid,
			String userId, String status) {
		return ig337BL.getIG337Info(prid, userId,
				status);
	}
	
	/**
	 * <p>
	 * 流程指定状态下，参与者信息取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 参与者信息
	 * @throws BLException 
	 *
	 */

	public List<IG337Info> searchProcessParticipant(
			Integer prid, String status) throws BLException {
		return ig337BL.getIG337Infos(prid,
				null, status);
	}
	
	/**
	 * <p>
	 * 根据检索条件查询参与者信息
	 * </p>
	 * 
	 * @param IG337SearchCond 检索条件
	 * @return 参与者信息
	 *
	 */

	public List<IG337Info> searchProcessParticipants(IG337SearchCond cond) {
		return ig337BL.getIG337Infos(cond);
	}
	

	/**
	 * <p>
	 * 流程指定状态下，未处理参与者信息总数取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 指定状态下的未处理参与者总数
	 *
	 */

	public int getTodoProcessParticipantCount(Integer prid, String status) {
		return ig337BL.getTodoIG337InfoCount(prid, status);
	}

	/**
	 * <p>
	 * 日志增加,roleid为null则不记录操作角色名称
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param type 日志类型 0系统日志，1批准，2驳回，3提交，4中止，5更新
	 * @param pbdid 处理按钮ID
	 * @return 参与者信息
	 * @return 日志信息
	 * @throws BLException
	 *
	 */
	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment,
			String desc, Map<Integer, FormFile> filemap,String type, String pbdid, String prstatus) throws BLException {
		//查询流程
		IG500Info processRecord = ig500BL.searchIG500InfoByKey(prid);
		IG036TB recordLog = this.getRecordLogTBInstance();
		recordLog.setPrid(prid);
		recordLog.setRluserid(user.getUserid());
		recordLog.setRlusername(user.getUsername());
		recordLog.setRldesc(desc);
		recordLog.setRlcomment(comment);
		recordLog.setRltime(IGStringUtils.getCurrentDateTime());
		recordLog.setPbdid(pbdid);
		//按钮ID为空为系统类
		if(StringUtils.isEmpty(pbdid) && !IGPRDCONSTANTS.RECORDLOG_TYPE_CL.equals(type)) {
			recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		} else if(IGPRDCONSTANTS.BUTTON_EXECUTOR.equals(pbdid) || IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)) {
			//更新/执行人保存时，根据处理内容有无保存，有内容则按提交类记录，没有按系统类记录。
			if(StringUtils.isNotEmpty(comment) || (filemap != null && filemap.size() > 0)) {
					recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
			} else {
				recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			}
		} else if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(pbdid)) {
			//确认无条件记录成处理类，保存处理人时按“***（已确认）”保存
			recordLog.setRltype(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);
			//确认动作去掉已确认字样 20130708 wangtingzhi
//			recordLog.setRlusername(user.getUsername() + "（" + "已确认" +  "）");
		} else {
			recordLog.setRltype(type);
		}
		if(roleid != null && roleid > 0) {
			recordLog.setRoleid(roleid);
			Role role = roleBL.searchRoleByKey(roleid);
			recordLog.setRlrolename(role.getRolename());
		} else {
			recordLog.setRlrolename(WorkFlowConstDefine.UnspecifiedRoleName);
		}
		recordLog.setRlorgid(user.getOrgid());
		recordLog.setRlorgname(user.getOrgname());
		String attkey = fileUploadBL.uploadFile(filemap);
		recordLog.setRlattkey(attkey);
		recordLog.setPsdcode(processRecord.getPrstatus());
		
		//若状态为空，则取流程状态
		if (StringUtils.isEmpty(prstatus)) {
			prstatus = processRecord.getPrstatus();
		}
		IG333Info psd = null;	
		if (prstatus.length() > 2) {
			if (prstatus.indexOf("_") > -1) {
				psd = workFlowDefinitionBL.searchProcessStatusDefByKey(prstatus.split("_")[0]);
				recordLog.setPsdnum(new Integer(prstatus.split("_")[1]));
				prstatus = prstatus.split("_")[0];
			} else {
				psd = workFlowDefinitionBL.searchProcessStatusDefByKey(prstatus);
			}
			recordLog.setPsdid(prstatus);
		} else {
			//设置流程状态
			IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
			psdcond.setPdid(processRecord.getPrpdid());
			psdcond.setPsdcode(processRecord.getPrstatus());
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdcond);
			if(!psdList.isEmpty()){
				psd = psdList.get(0);
				recordLog.setPsdid(psd.getPsdid());
			}
		}
		
		//自定义工作
		//zyl 2015年5月21日09:11:06 添加了场景定义的情况判断
		if(processRecord.getPrtype().startsWith("WD") || processRecord.getPrtype().endsWith("D")|| processRecord.getPrtype().startsWith("DRM")|| processRecord.getPrtype().startsWith("PRJ")|| processRecord.getPrtype().startsWith("RIS")|| processRecord.getPrtype().startsWith("FX")|| processRecord.getPrtype().startsWith("AMG")|| processRecord.getPrtype().startsWith("SJ")) {
			//流程状态名称
			if(psd != null){
				recordLog.setPsname(psd.getPsdname());
				if(pbdid != null) {
					if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)){
						recordLog.setRldesc("保存");
					}else {
						//查询点击的按钮名称
						List<IG309Info> lst_ParticipantVisibleButtonVWInfo =
							workFlowDefinitionBL.searchVisibleButton(psd.getPsdid(), roleid);
						for(IG309Info ig309 : lst_ParticipantVisibleButtonVWInfo) {
							if(pbdid.equals(ig309.getVbid())) {
								recordLog.setRldesc(ig309.getVbname());
								break;
							}
						}
					}

				}
			} else if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(pbdid)) {
				recordLog.setRldesc("保存信息");
			}
		}
		
		//判断是否角色负责人
		if(userRoleBL.checkRoleManagerByID(user.getUserid(),roleid)){
			//是角色负责人
			recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
		}else{
			recordLog.setRolemanger(IGPRDCONSTANTS.NOT_ROLEMANAGER);
		}
		
		//非决角色负责人时，需判断是否是被授予提交权限的值班人
		if(IGPRDCONSTANTS.NOT_ROLEMANAGER.equals(recordLog.getRolemanger())) {
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(prid);
			cond.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);//授权标识
			cond.setPproleid(roleid);
			cond.setPpuserid(user.getUserid());
			List<IG337Info> ppList = this.searchProcessParticipants(cond);
			for(IG337Info pp : ppList){
				//是否值班人
				if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					//假定为角色负责人标识
					recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
				}
			}
		}
		
		return ig036BL.registIG036Info(recordLog);
	}
	
	/**
	 * 流程日志信息更新
	 * @param info 修改流程日志信息
	 * @throws BLException 
	 */
	public void updateRecordLog(IG036Info info) throws BLException {
		this.ig036BL.updateG036Info(info);
	}
	
	/**
	 * 根据流程变量ID获取流程变量参数值信息集合
	 * @param piid 流程变量ID
	 * @throws BLException 
	 */
	public IG599Info searchProcessInfoByPiid(Integer piid) throws BLException {
		
		return ig599BL.searchIG599InfoByPiid(piid);
		
	}
	
	/**
	 * <p>
	 * 根据流程ID查询关联了该流程的流程记录
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 流程记录
	 *
	 */

	public List<IG500Info> searchProcessRecordsByPrid(Integer prid) throws BLException {
		
		//查询与该流程有关的流程ID
		IG599SearchCondImpl cond = new IG599SearchCondImpl();
		cond.setPivartype("5");//变量类型为流程对象
		List<IG599Info> prInfos = ig599BL.searchIG599InfosByCond(cond);

		List<IG500Info> prds = new ArrayList<IG500Info>();
		
		//根据流程ID取得流程集合
		for(IG599Info prInfo:prInfos){
			
			String pivarvalue = prInfo.getPivarvalue();
			
			if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.indexOf("_")!=-1){
				String pridstr = pivarvalue.split("_")[0];
				if(StringUtils.isNotEmpty(pridstr) && (Integer.valueOf(pridstr)).equals(prid)){
					Integer temp_prid = prInfo.getPrid();
					if(temp_prid!=null && temp_prid>0){
						IG500Info pr = ig500BL.searchIG500InfoByKey(temp_prid);
						if(!prds.contains(pr)){
							prds.add(pr);
						}

					}
					
				}
				
			}

		}

		if(prds.size()==0){
			return null;
		}
		
		return prds;
	}
	

	/**
	 * <p>
	 * 指定流程历史记录查询
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 指定流程历史记录
	 *
	 */

	public Map<IG036Info, List<Attachment>> searchRecordLog(Integer prid) {
		List<IG036Info> recordLogList = ig036BL.searchIG036InfoByPrid(prid);
		Map<IG036Info, List<Attachment>> map = new LinkedHashMap<IG036Info, List<Attachment>>();
		for (int i = 0; i < recordLogList.size(); i++) {
			String rlattkey = recordLogList.get(i).getRlattkey();
			List<Attachment> attachmentList = null;
			if (!StringUtils.isEmpty(rlattkey)) {
				attachmentList = attachmentBL.searchAttachmentsByAttkey(rlattkey);
			}
			if (attachmentList == null) {
				attachmentList = new ArrayList<Attachment>();
			}
			map.put(recordLogList.get(i), attachmentList);
		}
		return map;
	}
	
	/**
	 * <p>
	 * 指定流程历史记录查询(自定义流程使用)
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 指定流程历史记录
	 *
	 */

	public List<IG036Info> searchRecordLogForProcessDef(Integer prid)throws BLException {
		List<IG036Info> recordLogList = ig036BL.searchIG036InfoByPrid(prid);
		
		return recordLogList;
	}
	

	/**
	 * <p>
	 * 除系统管理员外，流程中可增加的参与者角色取得
	 * </p>
	 * 
	 * @param processParticipantList 参与者List
	 * @return 流程中可增加的参与者角色
	 *
	 */
	
	public List<Role> getRoleNotInProcessParticipants(
			List<IG337Info> processParticipantList) {
		List<Role> roleList = roleBL.getRolesNotInProcess();
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())&&StringUtils.isEmpty(processParticipantList.get(j).getPpuserid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}
	
	/**
	 * 功能：条件检索结果件数取得(可根据表单查询)
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int queryIG500EntityCount(IG500SearchCond cond){
		System.out.println(cond.getPrpdid());
		System.out.println(cond.getPrtype());
		
		return ig500BL.queryIG500EntityCount(cond);
	}
	
	
	/**
	 * 流程驱动时根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForPRR(List<IG337Info> processParticipantList,RoleSearchCond cond, int start, int count) {
		List<Role> roleList = roleBL.searchRoleForSelfDef(cond,start,count);
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}
	
	/**
	 * 流程定义时根据检索条件取得角色信息列表(自定义流程分派时查询该流程支持的角色使用)
	 * @param processParticipantList
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	
	public List<Role> getRoleForSelfPRD(RoleSearchCond cond, int start, int count) {
		List<Role> roleList = roleBL.searchRoleForSelfDef(cond,start,count);
		return roleList;
	}
	
	
	
	/**
	 * <p>
	 * 获取流程中可增加的审批角色
	 * </p>
	 * 
	 * @param  processParticipantList 已添加的审批角色
	 * @return 流程中可增加的审批角色集合
	 *
	 */
	
	public List<Role> getApproveRolesNotAdd(List<IG337Info> processParticipantList){
		List<Role> roleList = roleBL.getApproveRoles();
		for (int i = 0; i < roleList.size(); i++) {
			for (int j = 0; j < processParticipantList.size(); j++) {
				if (processParticipantList.get(j).getPproleid().equals(
						roleList.get(i).getRoleid())) {
					roleList.remove(i);
					i--;
					break;
				}
			}
		}
		return roleList;
	}

	/**
	 * <p>
	 * 流程指定状态下，用户可处理角色取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * 
	 * @return 用户可处理角色集合
	 *
	 */

	public List<UserRoleInfo> getUserRolesInProcessParticipants(
			Integer prid, String userId, String status) {
		List<UserRoleInfo> roleList = userRoleBL.getUserRolesNotInProcess(userId);
		List<IG337Info> ppList = ig337BL.getIG337InfoTodoRoles(
				prid, status);
		List<UserRoleInfo> userPrRoleList = new ArrayList<UserRoleInfo>();
		for (IG337Info pp : ppList) {
			for (UserRoleInfo ur : roleList) {
				if (pp.getPproleid().equals(ur.getRoleid())) {
					userPrRoleList.add(ur);
					break;
				}
			}
		}
		return userPrRoleList;
	}
	/**
	 * <p>
	 * 流程指定状态下，用户可处理角色取得
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @param userId 用户ID
	 * @param status 流程状态
	 * 
	 * @return 用户可处理角色集合
	 *
	 */

	public List<IG337Info> getUserRolesInProcessParticipants(
			Integer prid, String userId, String status, String na) {
		List<IG337Info> ppList = ig337BL.getIG337InfoTodoRoles(
				prid, status);
		List<IG337Info> userPrRoleList = new ArrayList<IG337Info>();
		for (IG337Info pp : ppList) {
			userPrRoleList.add(pp);
		}
		return userPrRoleList;
	}

	/**
	 * <p>
	 * 获取指定流程定义中的流程变量List
	 * </p>
	 * 
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量List
	 */
	
	public List<IG007Info> getProcessInfoDefs(String processDefinitionId){
		IG007SearchCondImpl cond = new IG007SearchCondImpl();
		cond.setPdid(processDefinitionId);
		cond.setTableColumn("N");
		return workFlowDefinitionBL.searchProcessInfoDef(cond);
	}
	
	/**
	 * <p>
	 * 获取指定流程定义中的流程变量List,不包括缺省变量
	 * </p>
	 * 
	 * @param processDefinitionId 流程定义ID
	 * @return  流程变量List
	 */
	
	public List<IG007Info> getProcessInfoDefsNoDefault(String processDefinitionId){
		return workFlowDefinitionBL.searchProcessInfoDefsNoDefault(processDefinitionId);
	}
	
	/**
	 * <p>
	 * 获取流程发起时所保存的流程变量信息的List
	 * </p>
	 * 
	 * @param prid 
	 * @return 流程变量信息List
	 *
	 */
	
	public List<IG599Info> getProcessInfo(Integer prid){
		return ig599BL.searchIG599InfosByKey(prid);
	}
	
	/**
	 * <p>
	 * 获取流程变量信息
	 * </p>
	 * 
	 * @param piid 
	 * @return 流程变量信息
	 * @throws BLException 
	 *
	 */
	
	public IG599Info getProcessInfoByID(Integer piid) throws BLException{
		return ig599BL.searchIG599InfoByPiid(piid);
	}
	
	/**
	 * <p>
	 * 流程变量信息设定
	 * </p>
	 * 
	 * @param processInfoList 流程变量信息集合
	 *
	 */
	
	public List<IG599Info> saveOrUpdProcessInfos(List<IG599Info> processInfoList) throws BLException{
		List<IG599Info> newList = ig599BL.saveOrUpdIG599Infos(processInfoList);
		return newList;
	}
	
	/**
	 * <p>
	 * 流程变量信息设定
	 * </p>
	 * 
	 * @param processInfo 流程变量信息集合
	 *
	 */
	
	public IG599Info saveProcessInfo(IG599Info processInfo) throws BLException{
		return ig599BL.saveIG599Info(processInfo);
	}
	
	/**
	 * <p>
	 * 获取指定查询条件下的流程模板
	 * </p>
	 * 
	 * @param ProcessTemplateSearchCond 流程模板查询接口
	 * @return 指定查询条件下的流程模板List
	 *
	 */
	
	public List<IG259Info> getActiveProcessTemplates() throws BLException{
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPtstatus("a");//未停用
		return workFlowDefinitionBL.searchProcessTemplate(cond);
	}
	
//	/**
//	 * <p>
//	 * 获取所有流程模板
//	 * </p>
//	 * 
//	 * @param ProcessTemplateSearchCond 流程模板查询接口
//	 * @return 所有流程模板List
//	 *
//	 */
//	
//	public List<ProcessTemplate> getAllProcessTemplates() throws BLException{
//		ProcessTemplateSearchCondImpl cond = new ProcessTemplateSearchCondImpl();
//		return processTemplateBL.searchProcessTemplates(cond);
//	}
	
	/**
	 * 获取指定流程模板
	 * @param ptid Integer
	 * @return ProcessTemplate
	 * @throws BLException 
	 * @throws BLException
	 */
	
	public IG259Info getProcessTemplateByKey(Integer ptid) throws BLException{
		return workFlowDefinitionBL.searchProcessTemplateByKey(ptid);
	}
	/**
	 * 获取指定流程类型
	 * @param pdid Integer
	 * @return ProcessDefinition
	 * @throws BLException
	 */
	
	public IG380Info getProcessDefinitionByKey(String pdid) throws BLException {
		return workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
	}
	
	/**
	 * <p>
	 * 指定用户发起的未关闭的流程信息取得
	 * </p>
	 * 
	 * @param userId 用户id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	
	public List<IG500Info> getActiveProcessRecordsInitByUser(
			String userId, String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//未关闭
		cond.setPruserid(userId);
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * 指定角色发起的未关闭的流程信息取得
	 * </p>
	 * 
	 * @param roleId 角色id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	
	public List<IG500Info> getActiveProcessRecordsInitByRole(
			Integer roleId, String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//未关闭
		cond.setPrroleid(roleId);
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	/**
	 * <p>
	 * 指定角色的未关闭的流程信息取得
	 * </p>
	 * 
	 * @param roleId 角色id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	
	public List<IG677Info> getWorkAssignedToMyManyRole(
			Integer roleId, String prtype){
		return ig500BL.getTodoProcessRecordsByRole(roleId, prtype);
	}
	
	/**
	 * <p>
	 * 指定用户的未关闭的流程信息取得
	 * </p>
	 * 
	 * @param userId 用户id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	
	public List<IG677Info> getWorkAssignedToMe(String userId, String prtype,String pdid,String prstatus){
		return ig500BL.getTodoProcessRecordsByUser(userId, prtype,pdid,prstatus);
	}
	
	/**
	 * 指定类型未关闭流程取得
	 * 
	 * @param prtype 流程类型
	 * @return 指定类型未关闭流程
	 */
	
	public List<IG500Info> getAllActiveProcessRecords(String prtype){
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		cond.setPrActive("Y");//未关闭
		cond.setPrtype(prtype);
		return ig500BL.searchIG500Info(cond, 0, 0);
	}
	
	
	/**
	 * 缺省审批人取得
	 * @param pdid 流程类型ID
	 * @return  缺省审批人列表
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid) {
		return workFlowDefinitionBL.getDefaultApprovors(pdid);
	}
	
	/**
	 * 缺省审批分派人取得
	 * @param pdid 流程类型ID
	 * @return  缺省审批分派人列表
	 */
	
	public List<IG337Info> getDefaultApprovorDispatcher(String pdid){
		return workFlowDefinitionBL.searchDefaultApprovorDispatcherByPdid(pdid);
	}
	
	/**
	 * 指定用户负责的流程处理角色检索
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG337Info> queryRolemanager(String userid , Integer prid) {
		return ig337BL.queryRolemanager(userid, prid);
	}
	
	/**
	 * 服务请求条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryServiceRequestList(IG500SearchCond cond, int start, int count) {
		return this.ig500BL.queryServiceRequestList(cond, start, count);
	}
	
	/**
	 * 服务请求条件检索记录数
	 * @param cond 服务请求检索条件
	 * @return 条件检索记录数
	 */
	public int queryServiceRequestListCount(IG500SearchCond cond) {
		return this.ig500BL.queryServiceRequestListCount(cond);
	}

	/**
	 * 指定用户未处理流程条件检索处理
	 * @param userid 用户ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByUserid(String userid){
		return this.ig500BL.queryActiveProcessByUserid(userid);
	}
	
	/**
	 * <p>
	 * 流程分派者角色的未关闭的流程信息取得
	 * </p>
	 * 
	 * @param roleId 流程分派者角色id
	 * @param prtype 流程类型
	 * @return 流程信息
	 */
	
	public List<IG677Info> getWorkAssignedToFPRole(
			Integer roleId, String prtype){
		return ig500BL.getTodoProcessRecordsByFPRole(roleId, prtype);
	}
	
	/**
	 * 检测指定用户是否具有指定流程查看权限（目前只支持变更，发布）
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 权限标识
	 */
	public boolean checkLookDetailPermission(String userid, Integer prid){
		return this.ig500BL.checkLookDetailPermission(userid, prid);
	}
	
	/**
	 * 当流程指定到角色时,在角色负责人的我的工作中显示此条流程信息
	 * @param userid 用户ID
	 * @return
	 */
	public List<IG677Info> queryActiveProcessByFPRoleid(String userid){
		return this.ig500BL.queryActiveProcessByFPRoleid(userid);
	}

	/**
	 * <p>
	 * 流程与资产关系设定
	 * </p>
	 * @param IG731 流程变量信息集合
	 */
	public IG731Info saveProcessInfoEntity(IG731Info processInfoEntity) throws BLException{
		return ig731BL.registIG731Info(processInfoEntity);
	}

	/**
	 * <p>
	 * 流程与资产关系查询
	 * </p>
	 * @param prid 流程ID
	 * @return 流程与资产关系信息集合
	 */
	public List<IG731Info> searchProcessInfoEntityByPrid(Integer prid) {
		return ig731BL.searchIG731InfoByPrid(prid);
	}
	
	/**
	 * 流程相关资产检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<IG731Info> searchProcessInfoEntityByCond(IG731SearchCond cond){
		return ig731BL.searchIG731Info(cond);
	}

	/**
	 * <p>
	 * 流程与资产关系删除
	 * </p>
	 * @param pieid 流程资产关系ID
	 */
	public void deleteProcessInfoEntityById(Integer pieid) throws BLException{
		 ig731BL.deleteIG731Info(pieid);
	}

	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryCorrelationProcessByUserid(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return this.ig500BL.queryCorrelationProcessByUserid(cond, start, count, closeFlag, dealFlag);
	}
	
	/**
	 * 指定用户相关处理流程条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @param closeFlag 查询关闭标志。0：已处理，1：未处理，其他：所有
	 * @param dealFlag  查询处理标志。0：已关闭，1：未关闭，其他：所有
	 * @return 检索结果数量
	 */
	public int queryCorrelationProcessByUseridCount(final IG677SearchCond cond, 
			final int start, final int count, final int closeFlag, final int dealFlag) {
		return this.ig500BL.queryCorrelationProcessByUseridCount(cond, start, count, closeFlag, dealFlag);
	}
	/**
	 * 指定角色未处理流程条件检索处理
	 * @param roleid 角色ID
	 * @return 检索结果列表
	 */
	public List<IG500Info> queryActiveProcessByRoleid(Integer roleid){
		return this.ig500BL.queryActiveProcessByRoleid(roleid);
	}
	
	/**
	 * <p>
	 * 流程关系建立
	 * </p>
	 * 
	 * @param processRecordRelation 流程关系信息
	 * @return 流程关系信息
	 * @throws BLException
	 *
	 */
	
	public IG512Info createProcessRecordRelation(IG512Info processRecordRelation)
			throws BLException {
		return this.ig512BL.registIG512Info(processRecordRelation);
	}
	
	/**
	 * <p>
	 * 根据检索条件取得流程关系
	 * </p>
	 * 
	 * @param cond 流程关系信息检索条件
	 * @return 流程关系信息检索结果列表
	 *
	 */

	public List<IG512Info> searchProcessRecordRelation(IG512SearchCond cond){
		return this.ig512BL.searchIG512Info(cond, 0, 0);
	}
	
	/**
	 * 流程关系按建立时间排序（升序）
	 * 
	 * @param processRecordRelationList 流程关系列表
	 * 
	 */
	public void orderByTimeAsc(List<IG512Info> processRecordRelationList) {
		this.ig512BL.orderByTimeAsc(processRecordRelationList);
	}
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, String psdid, Integer pgrid) throws BLException {
		//获取时间
		Date dateTime = new Date();
		//非发起节点
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype) {
			insertBeginRecordStatusLog(prid, prpdid, prtype, fromstatus, statustype, dateTime,psdid);
		} else {
			//流程状态日志更新
			updateRecordStatusLog(prid, null, dateTime);
		}
		//流程状态日志新增
		insertRecordStatusLog(prid, prpdid, prtype, fromstatus, tostatus, statustype, dateTime, psdid, pgrid);
	}
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @param pgrid 流程组ID
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	public void addRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Integer pgrid) throws BLException {
		//获取时间
		Date dateTime = new Date();
		//非发起节点
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype) {
			insertBeginRecordStatusLog(prid, prpdid, prtype, fromstatus, statustype, dateTime,null);
		} else {
			//流程状态日志更新
			updateRecordStatusLog(prid, fromstatus, dateTime);
		}
		//流程状态日志新增
		insertRecordStatusLog(prid, prpdid, prtype, fromstatus, tostatus, statustype, dateTime, null, pgrid);
	}
	
	/**
	 * 流程状态日志更新
	 * 
	 * @param prid 流程ID
	 * @param fromstatus 流程原状态
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void updateRecordStatusLog(Integer prid, String fromstatus, Date dateTime) throws BLException {
		//更新当前流程状态日志信息
		IG224Info currentRecordStatusLog = this.ig224BL.searchCurrentIG224Info(prid, fromstatus).get(0);
		IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
		currentRecordStatusLogTB.setRslCloseTime(dateTime);//结束时间
		this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
	}
	
	/**
	 * 流程状态日志更新
	 * 
	 * @param prid 流程ID
	 * @param fromstatus 流程原状态
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void updateRecordStatusLogByPsdid(Integer prid, Integer pgrid, String pgdid, String frompsdid, Date dateTime) throws BLException {
		//更新当前流程状态日志信息
		IG224Info currentRecordStatusLog = this.ig224BL.searchCurrentIG224InfoByPsdid(prid, frompsdid).get(0);
		IG224TB currentRecordStatusLogTB = (IG224TB)SerializationUtils.clone(currentRecordStatusLog);
		currentRecordStatusLogTB.setRslCloseTime(dateTime);//结束时间
		this.ig224BL.updateIG224Info(currentRecordStatusLogTB);
		//checkTrigger(prid, pgrid, pgdid, frompsdid);//校验是否触发影响流程跃迁逻辑
	}
	
	/**
	 * 参考流程跃迁时校验是否触发影响流程跃迁逻辑
	 * @param prid 参考流程ID
	 * @param pgrid 流程组ID
	 * @param pgdid 流程组定义ID
	 * @param rpsdid 参考流程状态
	 * @param dateTime 处理时间
	 * @param rtpsdid 参考流程目的状态集合
	 * @throws BLException
	 */
	private void checkTrigger(Integer prid, Integer pgrid, String pgdid,
			String rpsdid, Date dateTime, List<String> rtpsdids) throws BLException {
		//查询未处理关系实例记录
		List<IG485VW> lst_IG485 = this.ig485BL.searchNotDone(prid, rpsdid);
		//查询流程组成员实例
		IG484SearchCondImpl cond = new IG484SearchCondImpl();
		cond.setPgrid(pgrid);
		List<IG484Info> lst_IG484 = this.ig484BL.searchIG484(cond);
		//获取流程组信息
		IG483Info ig483 = this.ig483BL.searchIG483ByPK(pgrid);
		Integer ocount = ig483.getOcount();//已发起流程数
		Integer ocount_new = ig483.getOcount();//已发起流程数
		//更新关系实例记录为已处理
		for(IG485VW info : lst_IG485) {
			//如果关联关系没有定义触发规则，则认为任何规则都能触发关联流程，否则匹配目的状态
			if(StringUtils.isEmpty(info.getRtpsdid()) || rtpsdids.contains(info.getRtpsdid())){
				IG485TB ig485 = this.ig485BL.getIG485TBInstance();
				copyProperties(ig485, info);
				ig485.setPgrrstatus("1");//已处理
				this.ig485BL.updateIG485(ig485);
				WorkFlowGroupEventBL groupEventBL = null;
				WorkFlowGroupProcessLaunchBL launchProcessBL = null;
				//判断是否组内发起
				if(StringUtils.isEmpty(info.getTransferhandler())) {
					//状态ID为001的标识发起状态
					if(info.getIpsdid().endsWith("001")) {
						try {
							launchProcessBL = (WorkFlowGroupProcessLaunchBL)
									WebApplicationSupport.getBean("workFlowGroupProcessLaunchBL");
						} catch (Exception e) {
							throw new BLException("IGCO10000.E004", "组内发起事件定义");
						}
					}
				} else {//执行约束事件BL
					Object obj = WebApplicationSupport.getBean(info.getTransferhandler());
					try {
						groupEventBL = (WorkFlowGroupEventBL)obj;
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "约束事件定义");
					}
					try {
						//组内发起,状态ID为001的标识发起状态
						if(info.getIpsdid().endsWith("001")) {
							if(obj instanceof WorkFlowGroupProcessLaunchBL) {
								launchProcessBL = (WorkFlowGroupProcessLaunchBL)obj;
							} else {
								launchProcessBL = (WorkFlowGroupProcessLaunchBL)
										WebApplicationSupport.getBean("workFlowGroupProcessLaunchBL");
							}
						}
					} catch (Exception e) {
						throw new BLException("IGCO10000.E004", "组内发起事件定义");
					}
					
				}
				//组内发起
				if(launchProcessBL != null) {
					//发起流程组的用户，必须具有发起子流程的权限，否则抛异常，默认取任意发起角色发起子流程
					List<LabelValueBean> lst_Role = this.workFlowDefinitionBL.searchInitProcessParticipantRole(
							ig483.getPgruserid(), info.getIpdid());
					if(lst_Role.isEmpty()) {
						throw new BLException("IGFLOW0000.E000", "不具有流程定义ID（" + info.getIpdid() + "）的发起角色");
					} else {
				        Integer newPrid = launchProcessBL.launchProcess(pgrid, pgdid, info.getIpdid(), ig483.getPgrtitle() + "_"
								+ this.workFlowDefinitionBL.searchProcessDefinitionByKey(info.getIpdid()).getPdname(),
								ig483.getPgruserid(), new Integer(lst_Role.get(0).getValue()));
				        ocount_new++;
				      //查询含有参考状态的流程定义，这些流程定义应该先发起，暂不考虑即是约束又是参考的情况
						IG482SearchCondImpl cond_IG482 = new IG482SearchCondImpl();
						//获取流程组关系定义
						cond_IG482.setPgdid(pgdid);//流程组定义ID
						cond_IG482.setRpdid(info.getIpdid());//参考流程定义ID
						List<IG482Info> lst_IG482 = this.ig482BL.searchIG482(cond_IG482);
						//根据发起的流程实例ID生成流程组关系实例信息
						for(IG482Info ig482 : lst_IG482) {
							IG485TB ig485TB = this.ig485BL.getIG485TBInstance();
							ig485TB.setPgreid(ig482.getPgreid());//流程组关系定义ID
							ig485TB.setPgrid(pgrid);//流程组实例ID
							ig485TB.setPrid(newPrid);//参考流程实例ID
							ig485TB.setPgrrstatus("0");//状态：未完成
							this.ig485BL.registIG485(ig485TB);
						}
					}
				}
				//影响事件处理
				if(groupEventBL != null) {
					//组内流程发起后，需重新查询组成员实例信息
					if(launchProcessBL != null) {
						lst_IG484 = this.ig484BL.searchIG484(cond);
					}
					//查找组内影响状态对应的流程ID,并执行约束事件
					for(IG484Info ig484 : lst_IG484) {
						if(StringUtils.startsWith(info.getIpsdid(), ig484.getPdid())) {
							groupEventBL.execute(prid, ig484.getPrid());
							break;
						}
					}
				}
			}
		}
		//更新已发起流程数
		if(ocount.intValue() != ocount_new.intValue()) {
	        IG483TB ig483TB = (IG483TB)SerializationUtils.clone(ig483);
	        ig483TB.setOcount(ocount_new);
	        this.ig483BL.updateIG483(ig483TB);
		}
		//获取需要跃迁的影响流程ID
		if(!lst_IG485.isEmpty()) {
			List<IG224VW> lst_IG224 = this.ig485BL.searchTriggerPrid(prid, pgrid, pgdid, rpsdid, rtpsdids);
			IG500Info ig500 = null;
			IG337Info ig337 = null;
			User commitUser = null;
			User authorizeUser = null;
			IG333Info fpsd = null;
			IG333Info tpsd = null;
			List<IG337Info> lst_IG337 = null;
			for(IG224VW obj : lst_IG224) {
				ig500 = this.searchProcessRecordByKey(obj.getPrid());
				if(obj.getPendpsdnum() == null) {
					lst_IG337 = searchProcessParticipantDoneRole(ig500.getPrid(), obj.getPendpsdid());
				} else {
					lst_IG337 = searchProcessParticipantDoneRole(ig500.getPrid(), obj.getPsdid() + "_" + obj.getPendpsdnum());
				}
				if(lst_IG337.isEmpty()) {
					throw new BLException("IGCO10000.E141", ig500.getPrtitle() + "（"+ obj.getPendpsdid() +"）状态已处理用户不存在");
				}
				ig337 = lst_IG337.get(lst_IG337.size()-1);//取最后处理人记录
				commitUser = this.userBL.searchUserByKey(ig337.getPpuserid());
				if(StringUtils.isNotEmpty(ig337.getPpproxyuserid())) {
					authorizeUser = this.userBL.searchUserByKey(ig337.getPpproxyuserid());
				}
				fpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(obj.getPendpsdid());
				tpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(obj.getPsdid());
				IG224Info info = ig224BL.searchIG224InfoByKey(obj.getRslid());
				IG224TB ig224 = (IG224TB)SerializationUtils.clone(info);
				ig224.setPend("1");//解除挂起
				ig224.setPendCloseTime(dateTime);
				ig224.setRslOpenTime(dateTime);
				this.ig224BL.updateIG224Info(ig224);
				//增加参与者
				this.addParticipants(obj.getPsdnum() == null ? obj.getPsdid() : obj.getPsdid() + "_" + obj.getPsdnum() , commitUser, 
						ig500.getPrid(), ig337.getPproleid(), "", null,
						null, null, authorizeUser, ig337.getPbdid(), 
						obj.getPsdnum() == null ? obj.getPendpsdid() : obj.getPendpsdid() + "_" + obj.getPsdnum());
				//触发流程前处理事件
				this.processPreTreatmentExecute(ig500, fpsd, tpsd, commitUser, ig337.getPproleid(),
						authorizeUser, ig337.getPbdid(), ig337.getPsdnum());
				//触发流程多线程任务
				this.processThreadTreatmentExecute(ig500, fpsd, tpsd, commitUser, ig337.getPproleid());
				
				addRecordLog(ig500.getPrid(), commitUser, ig337.getPproleid(), "解除挂起", null,
						null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null,
						obj.getPsdnum() == null ? obj.getPsdid() : obj.getPsdid() + "_" + obj.getPsdnum());
				
				//获取下一状态参与者
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(ig500.getPrid());
				ppCond.setPsdid(obj.getPsdid());
				ppCond.setPsdnum(ig337.getPsdnum());
				List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
//				List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//						tpsd.getPsdcode());
				List<String> lst_Userid = new ArrayList<String>();
				List<Integer> lst_Roleid = new ArrayList<Integer>();
				if(!ppList.isEmpty()) {
					for(IG337Info pp:ppList){
						if(StringUtils.isEmpty(pp.getPpuserid())) {
							lst_Roleid.add(pp.getPproleid());
						} else {
							lst_Userid.add(pp.getPpuserid());
						}
					}
					sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, ig500);
				}
			}
		}
		
	}
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void insertBeginRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			int statustype, Date dateTime,String psdid) throws BLException {
		//查询当前状态
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(fromstatus);
		//添加下一流程状态日志信息
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(prid);//流程ID
		currentRecordStatusLogTB.setPrtype(prtype);//流程类型
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//开始时间
		currentRecordStatusLogTB.setRslCloseTime(dateTime);
		currentRecordStatusLogTB.setPrstatus(psd.getPsdcode());//当前流程状态
		currentRecordStatusLogTB.setPrpdid(prpdid);//自定义流程类型ID
		currentRecordStatusLogTB.setVirtualstatus("0");//非虚拟状态
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
	}

	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void insertBeginRecordStatusLogByPsdid(Integer prid, String prpdid, String prtype, String frompsdid,
			int statustype, Date dateTime, boolean flag) throws BLException {
		//当flag为true时，表示流程跃迁时增加发起状态日志，此时需要判断是否已经保存了草稿状态
		if(flag) {
			
			List<IG224Info> lst_IG224Info = this.searchRecordStatusLog(prid);
			if(lst_IG224Info.size() == 1 && lst_IG224Info.get(0).getRslCloseTime() == null) {
				IG224TB tb = (IG224TB)SerializationUtils.clone(lst_IG224Info.get(0));
				tb.setRslCloseTime(new Date());
				this.ig224BL.updateIG224Info(tb);
				return;
			} 
		}
		
		String psdid = "";
		Integer psdnum = 0;
		if (frompsdid.indexOf("_") > -1) {
			psdid = frompsdid.split("_")[0];
			psdnum = Integer.parseInt(frompsdid.split("_")[1]);
		} else {
			psdid = frompsdid;
		}
		
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//添加下一流程状态日志信息
		IG224TB currentRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		currentRecordStatusLogTB.setPrid(prid);//流程ID
		currentRecordStatusLogTB.setPrtype(prtype);//流程类型
		currentRecordStatusLogTB.setRslOpenTime(dateTime);//开始时间
		if(flag) {
			currentRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		currentRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);//当前流程状态
		currentRecordStatusLogTB.setPsdid(psdid);
		if (psdnum > 0) {
			currentRecordStatusLogTB.setPsdnum(psdnum);
		}
		currentRecordStatusLogTB.setPpsdid(psd.getPpsdid());
		currentRecordStatusLogTB.setPrpdid(prpdid);//自定义流程类型ID
		currentRecordStatusLogTB.setVirtualstatus("0");
		this.ig224BL.registIG224Info(currentRecordStatusLogTB);
	}
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private void insertRecordStatusLog(Integer prid, String prpdid, String prtype, String fromstatus,
			String tostatus, int statustype, Date dateTime,String psdid, Integer pgrid) throws BLException {
		//添加下一流程状态日志信息
		IG224TB nextRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		nextRecordStatusLogTB.setPrid(prid);//流程ID
		nextRecordStatusLogTB.setPrpdid(prpdid);//自定义流程类型ID
		nextRecordStatusLogTB.setPrtype(prtype);//流程类型
		nextRecordStatusLogTB.setRslOpenTime(dateTime);//开始时间
		//结束状态需要设定结束时间=开始时间
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		} else if(WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		//流程组成员关闭时，需更新流程组已关闭流程数
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype || WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			if(pgrid != null) {
				IG483Info ig483Info = this.ig483BL.searchIG483ByPK(pgrid);
				IG483TB ig483 = (IG483TB)SerializationUtils.clone(ig483Info);
				ig483.setCcount(ig483.getCcount() + 1);
				//已关闭数=发起数，则流程组关闭
				if(ig483.getCcount().intValue() == ig483.getOcount().intValue()) {
					ig483.setPgrclosetime(CommonDefineUtils.DATETIME_FORMAT.format(dateTime));
				}
				this.ig483BL.updateIG483(ig483);
			}
		}
		nextRecordStatusLogTB.setPrstatus(tostatus);//下一流程状态
		nextRecordStatusLogTB.setVirtualstatus("0");//非虚拟状态
		nextRecordStatusLogTB.setPsdid(psdid);
		this.ig224BL.registIG224Info(nextRecordStatusLogTB);
	}

	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @param dateTime 记录时间
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	private boolean insertRecordStatusLogByPsdid(Integer prid, String prpdid, Integer pgrid, String pgdid, String prtype, String frompsdid,
			String topsdid, int statustype, Date dateTime) throws BLException {
		//是否不需要挂起
		boolean notPend = true;
		String psdid = "";
		Integer psdnum = null;
		if (topsdid.indexOf("_") > -1) {
			psdid = topsdid.split("_")[0];
			psdnum = Integer.parseInt(topsdid.split("_")[1]);
		} else {
			psdid = topsdid;
		}
		
		IG333Info psd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//添加下一流程状态日志信息
		IG224TB nextRecordStatusLogTB = this.ig224BL.getIG224TBInstance();
		nextRecordStatusLogTB.setPrid(prid);//流程ID
		nextRecordStatusLogTB.setPrpdid(prpdid);//自定义流程类型ID
		nextRecordStatusLogTB.setPrtype(prtype);//流程类型
		//判断流程组相关流程是否需要在topsdid状态挂起
		nextRecordStatusLogTB.setRslOpenTime(dateTime);//开始时间
		if(pgrid != null && pgrid > 0 && this.ig485BL.checkPend(pgrid, pgdid, topsdid)) {
			nextRecordStatusLogTB.setPendOpenTime(dateTime);//挂起开始时间
			nextRecordStatusLogTB.setPend("0");//挂起
			nextRecordStatusLogTB.setPendpsdid(frompsdid);//引发挂起的状态ID
			nextRecordStatusLogTB.setPendpsdnum(psdnum);//引发挂起的状态ID对应的psdnum
			notPend = false;
		}
		//结束状态需要设定结束时间=开始时间
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		} else if(WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_TERMINATE);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}else if(4 == statustype) {
			nextRecordStatusLogTB.setPrstatus(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS);
			nextRecordStatusLogTB.setRslCloseTime(dateTime);
		}
		//流程组成员关闭时，需更新流程组已关闭流程数
		if(WorkFlowConstDefine.STATUSTYPE_END == statustype || WorkFlowConstDefine.STATUSTYPE_END_TERMINATE == statustype) {
			if(pgrid != null) {
				IG483Info ig483Info = this.ig483BL.searchIG483ByPK(pgrid);
				IG483TB ig483 = (IG483TB)SerializationUtils.clone(ig483Info);
				ig483.setCcount(ig483.getCcount() + 1);
				//已关闭数=发起数，则流程组关闭
				if(ig483.getCcount().intValue() == ig483.getOcount().intValue()) {
					ig483.setPgrclosetime(CommonDefineUtils.DATETIME_FORMAT.format(dateTime));
				}
				this.ig483BL.updateIG483(ig483);
			}
		}
		nextRecordStatusLogTB.setPsdid(psdid);//下一流程状态
		nextRecordStatusLogTB.setPsdnum(psdnum);
		nextRecordStatusLogTB.setPpsdid(psd.getPpsdid());
		//子流程虚拟节点
		if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(psd.getPsdtype()) || IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(psd.getPsdtype())) {
			nextRecordStatusLogTB.setVirtualstatus("1");
		} else {
			nextRecordStatusLogTB.setVirtualstatus("0");
		}
		this.ig224BL.registIG224Info(nextRecordStatusLogTB);
		return notPend;
	}
	
	/**
	 * 流程状态日志新增
	 * 
	 * @param prid 流程ID
	 * @param prpdid 自定义流程类型ID（非自定义流程传入null）
	 * @param prtype 流程类型
	 * @param fromstatus 流程原状态
	 * @param tostatus 流程跃迁状态
	 * @param statustype 流程状态类型：0开始，1普通，2结束
	 * @return 流程状态日志
	 * @throws BLException 
	 */
	public void addRecordStatusLog(IG500Info processRecord, IG333Info fpsd, Integer psdnum,
			String[] tostatus, int statustype, User user, Integer roleid, User authorizeuser, String pbdid) throws BLException {
		
		//获取时间
		Date dateTime = new Date();
		//非发起节点
		if(WorkFlowConstDefine.STATUSTYPE_BEGIN == statustype || (IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(processRecord.getPrtype()) && IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && IGPRDCONSTANTS.PROCESS_TERMINATE.equals(tostatus))) {
			insertBeginRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(), processRecord.getPrtype(), fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), statustype, dateTime,true);
		} else {
			//流程状态日志更新
//			updateRecordStatusLogByPsdid(processRecord.getPrid(), fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime);
			updateRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPid(), processRecord.getPname(),
					fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime);//应急合版
		}
		//需要跃迁的状态是否被挂起
				Map<String, Boolean> map_NotPend = new HashMap<String, Boolean>();
		//流程状态日志新增
		for(String psdid : tostatus) {
			if (checkTranslate(processRecord.getPrid(), processRecord.getPrpdid(), psdid)) {
				//记录流程状态日志
//				insertRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(), processRecord.getPrtype(), fpsd.getPsdid(), psdid + (psdnum == null ? "" : "_" + psdnum), statustype, dateTime);
				map_NotPend.put(psdid, insertRecordStatusLogByPsdid(processRecord.getPrid(), processRecord.getPrpdid(),
						processRecord.getPid(), processRecord.getPname(),
						processRecord.getPrtype(), fpsd.getPsdid(), psdid + (psdnum == null ? "" : "_" + psdnum), 
						statustype, dateTime));
			}
		}

		boolean flag = true;
		
		//流程状态日志新增
		for(String psdid : tostatus) {

			IG333Info tpsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);

			if (flag) {

				//触发流程后处理事件
				this.processAfterTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid,psdnum);
				
				flag = false;
			}
			
			if (checkTranslate(processRecord.getPrid(), processRecord.getPrpdid(), psdid)) {
				//触发流程前处理事件
				this.processPreTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid,psdnum);
				//触发流程多线程任务
				this.processThreadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
				
				//获取下一状态参与者
				IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
				ppCond.setPrid(processRecord.getPrid());
				ppCond.setPsdid(psdid);
				ppCond.setPsdnum(psdnum);
				List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
//				List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//						tpsd.getPsdcode());
				List<String> lst_Userid = new ArrayList<String>();
				List<Integer> lst_Roleid = new ArrayList<Integer>();
				if(!ppList.isEmpty()) {
					for(IG337Info pp:ppList){
						if(StringUtils.isEmpty(pp.getPpuserid())) {
							lst_Roleid.add(pp.getPproleid());
						} else {
							lst_Userid.add(pp.getPpuserid());
						}
					}
					sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, processRecord);
				}
				
				
				// 若目标节点是子流程节点，自动进入子流程
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(tpsd.getPsdtype())) {
					
					// 查询子流程开始节点
					IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
					psdCond.setPdid(processRecord.getPrpdid());
					psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
					psdCond.setPpsdid(tpsd.getPsdid());
					List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
					
					if (czList != null && czList.size() > 0) {
						
						IG333Info czpsd = czList.get(0);

						this.checkAndTransitionForHandel(user, czpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), roleid, "10", processRecord.getPrid(), 
								czpsd.getPsdtype(), null, null, authorizeuser);
					} else {
						throw new BLException("IGCO10000.E004","子流程开始状态");
					}
				}

				// 若目标节点是动态分支节点，自动进入子流程，并按动态分支节点参与人设置动态分支
				if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(tpsd.getPsdtype())) {
					
					// 获取动态分支节点参与人
					IG337SearchCondImpl cppCond = new IG337SearchCondImpl();
					cppCond.setPrid(processRecord.getPrid());
					cppCond.setPsdid(tpsd.getPsdid());
					List<IG337Info> cppList = this.searchProcessParticipants(cppCond);
					
					List<Integer> roleidList = new ArrayList<Integer>();
					Map<Integer, Integer> roleidMap = new HashMap<Integer, Integer>();
					if (IGPRDCONSTANTS.PROCESS_BRANCHCOND_ROLE.equals(tpsd.getBranchcond())) {
						for (IG337Info ppInfo : cppList) {
							if (roleidMap.get(ppInfo.getPproleid()) == null) {
								roleidList.add(ppInfo.getPproleid());
								roleidMap.put(ppInfo.getPproleid(), ppInfo.getPproleid());
							}
						}
					}
					
					// 查询子流程开始节点
					IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
					psdCond.setPdid(processRecord.getPrpdid());
					psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
					psdCond.setPpsdid(tpsd.getPsdid());
					List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
					
					if (czList != null && czList.size() > 0) {
						
						IG333Info czpsd = czList.get(0);
						
						// 若到角色，则按角色数量生成子流程，并将该角色下所有人设置为参与人
						if (IGPRDCONSTANTS.PROCESS_BRANCHCOND_ROLE.equals(tpsd.getBranchcond())) {
							
							if (roleidList != null && roleidList.size() > 0) {
								
								for (int i = 1; i <= roleidList.size(); i++) {
									
									Integer croleid = roleidList.get(i - 1);
									
									// 查询该角色下所有用户
									UserRoleSearchCondImpl urCond = new UserRoleSearchCondImpl();
									urCond.setRoleid(croleid);
									List<UserRole> urList = userRoleBL.searchUserRole(urCond);
									
									// 跃迁子流程状态
									this.checkAndTransitionForHandel(user, czpsd.getPsdid() + "_" + i, roleid, "10", processRecord.getPrid(), 
											czpsd.getPsdtype(), null, null, authorizeuser);

									// 查询子流程开始后面的状态
									IG273SearchCondImpl ptCond = new IG273SearchCondImpl();
									ptCond.setFpsdid(czpsd.getPsdid());
									List<IG273Info> ptList = this.workFlowDefinitionBL.searchProcessTransitionDef(ptCond);
									
									if (ptList != null && ptList.size() > 0) {
										
										// 添加该角色下的所有人作为处理人
										for (UserRole urInfo : urList) {
											
											this.addParticipant(user, processRecord.getPrid(), processRecord.getPrpdid(), ptList.get(0).getTpsdid() + "_" + i, 
													String.valueOf(urInfo.getRoleid()), urInfo.getUserid(), null, authorizeuser, pbdid, czpsd.getPsdid());
										}
									}
									
								}
								
								// 删除子流程父节点的参与人
								for (int i = 1; i <= cppList.size(); i++) {
									this.removeProcessParticipant(cppList.get(i-1));
								}
							} else {
								throw new BLException("IGCO10000.E004","动态分支参与者");
							}
						} 
						// 若到人员，则按人员生成子流程 ，并将该人员设置为参与人
						else {
							
							if (cppList != null && cppList.size() > 0) {
								
								for (int i = 1; i <= cppList.size(); i++) {
									
									this.checkAndTransitionForHandel(user, czpsd.getPsdid() + "_" + i, roleid, "10", processRecord.getPrid(), 
											czpsd.getPsdtype(), null, null, authorizeuser);
									
									IG273SearchCondImpl ptCond = new IG273SearchCondImpl();
									ptCond.setFpsdid(czpsd.getPsdid());
									List<IG273Info> ptList = this.workFlowDefinitionBL.searchProcessTransitionDef(ptCond);
									
									if (ptList != null && ptList.size() > 0) {
										this.addParticipant(user, processRecord.getPrid(), processRecord.getPrpdid(), ptList.get(0).getTpsdid() + "_" + i, 
												String.valueOf(cppList.get(i-1).getPproleid()), cppList.get(i-1).getPpuserid(), null, authorizeuser, pbdid, czpsd.getPsdid());
									}
									
									this.removeProcessParticipant(cppList.get(i-1));
								}
							} else {
								throw new BLException("IGCO10000.E004","动态分支参与者");
							}
						}
					} else {
						throw new BLException("IGCO10000.E004","动态分支流程开始状态");
					}
				}
				
				// 若目标节点是子流程的结束节点，自动跃迁主流程
				if (StringUtils.isNotEmpty(tpsd.getPpsdid()) && IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode())) {
					
					// 查询主流程节点
					IG333Info ppsd = this.workFlowDefinitionBL.searchProcessStatusDefByKey(tpsd.getPpsdid());
					
					if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(ppsd.getPsdtype())) {
						this.checkAndTransitionForHandel(user, ppsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), roleid, "10", processRecord.getPrid(), 
								ppsd.getPsdtype(), null, null, authorizeuser);
					} else if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(ppsd.getPsdtype())) {

						// 跃迁标识
						boolean transflag = true;
						
						// 查询子流程开始节点
						IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
						psdCond.setPdid(processRecord.getPrpdid());
						psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
						psdCond.setPpsdid(tpsd.getPpsdid());
						List<IG333Info> czList = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond);
						
						if (czList != null && czList.size() > 0) {
							// 查询动态子流程个数
							IG224SearchCondImpl rslCond = new IG224SearchCondImpl();
							rslCond.setPrid(processRecord.getPrid());
							rslCond.setPpsdid(ppsd.getPsdid());
							rslCond.setPsdid(czList.get(0).getPsdid());
							List<IG224Info> rslList = this.ig224BL.searchIG224Info(rslCond, 0, 0);
							
							IG224SearchCondImpl drslCond = new IG224SearchCondImpl();
							drslCond.setPrid(processRecord.getPrid());
							drslCond.setPpsdid(ppsd.getPsdid());
							drslCond.setPsdid(tpsd.getPsdid());
							List<IG224Info> drslList = this.ig224BL.searchIG224Info(drslCond, 0, 0);
							
							if (rslList.size() != drslList.size()) {
								transflag = false;
							}
							
							if (transflag) {
								for (IG224Info drslInfo : drslList) {
									if (drslInfo.getRslCloseTime() == null) {
										transflag = false;
									}
								}
							}
						} else {
							throw new BLException("IGCO10000.E004","动态分支流程开始状态");
						}
						
						if (transflag) {
							this.checkAndTransitionForHandel(user, ppsd.getPsdid(), roleid, "10", processRecord.getPrid(), 
									ppsd.getPsdtype(), null, null, authorizeuser);
						}
					}
				}
			}
			
		}
		//校验是否触发影响流程跃迁逻辑
		//是否流程组
		if(StringUtils.isNotEmpty(processRecord.getPname())) {
			checkTrigger(processRecord.getPrid(), processRecord.getPid(), processRecord.getPname(),
					fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum), dateTime, Arrays.asList(tostatus));
			
		}
	}

	/**
	 * 判断是否记录状态日志
	 * 
	 * @param prid
	 * @param prpdid
	 * @param status
	 * @return
	 * @throws BLException
	 */
	private boolean checkTranslate(Integer prid, String prpdid, String psdid)
			throws BLException {
		
		// 获取目标节点信息
		IG333Info psdInfo = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		boolean doneflag = true;

		// 若为合并节点，判断所有到该节点是否已经都完成
		if (IGPRDCONSTANTS.PROCESS_NODE_TYPE_MERGE.equals(psdInfo.getPsdtype())) {
			
			// 获取所有到该合并节点的节点信息
			IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
			ptdCond.setTpsdid(psdInfo.getPsdid());
			List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			
			// 判断所有节点是否已经完成
			for (IG273Info ptdInfo : ptdList) {
				String fpsdid = ptdInfo.getFromPSDTB().getPsdid();
				IG224SearchCondImpl rslCond = new IG224SearchCondImpl();
				rslCond.setPrid(prid);
				rslCond.setPrstatus(fpsdid);
				List<IG224Info> rslList = this.ig224BL.searchIG224Info(rslCond, 0, 0);
				
				// 若存在未完成的节点，则不记录下一个节点的状态日志
				if (rslList != null && rslList.size() > 0) {
					for (IG224Info rslInfo : rslList) {
						if (rslInfo.getRslCloseTime() == null) {
							doneflag = false;
							break;
						}
					}
					if (!doneflag) {
						break;
					}
				} else {
					doneflag = false;
					break;
				}
			}
		}
		
		return doneflag;
	}
	
	/**
	 * 当前流程状态日志信息取得
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @return 当前流程状态日志信息
	 * @throws BLException 
	 */
	public List<IG224Info> searchCurrentRecordStatusLog(Integer prid, String status) throws BLException{
		return this.ig224BL.searchCurrentIG224Info(prid, status);
	}
	
	/**
	 * 当前流程状态标识集合取得
	 * 
	 * @param prid 流程ID
	 * @return 当前流程状态标识集合
	 * @throws BLException 
	 */
	public List<String> searchCurrentRecordStatus(Integer prid) throws BLException {
		List<IG224Info> lst_IG224Info= this.ig224BL.searchCurrentIG224Info(prid, null);
		List<String> lst_status = new ArrayList<String>();
		for(IG224Info bean : lst_IG224Info) {
			lst_status.add(bean.getPsdid() + (bean.getPsdnum() == null ? "" : "_" + bean.getPsdnum()));
		}
		return lst_status;
	}
	
	/**
	 * <p>
	 * 指定流程状态日志查询
	 * </p>
	 * 
	 * @param prid 流程ID
	 * @return 指定流程状态日志
	 *
	 */
	public List<IG224Info> searchRecordStatusLog(Integer prid) {
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		return this.ig224BL.searchIG224Info(cond, 0, 0);
	}

	
	/**
	 * <p>
	 * 根据查询条件查询流程变量信息
	 * </p>
	 * @param IG599SearchCond 流程变量查询条件
	 * @return 流程变量信息 
	 */
	public List<IG599Info> searchProcessInfoByCond(IG599SearchCond cond) {
		
		List<IG599Info> list = this.ig599BL.searchIG599InfosByCond(cond);
		
		return list;
	}
	
	/**
	 * <p>
	 * 根据查询条件查询流程变量定义信息
	 * </p>
	 * @param IG007SearchCond 流程变量定义查询条件
	 * @return 流程变量定义信息 
	 */
	public List<IG007Info> searchProcessInfoDefByCond(IG007SearchCond cond) {
		
		List<IG007Info> list = workFlowDefinitionBL.searchProcessInfoDef(cond);
		
		return list;
	}
	
	///////////////////////////////////////////////////songhy  start//////////////////////////////////////
	
	/**
	 * 发起流程
	 * 
	 * @param processRecord 流程记录内容
	 * @param user	        用户
	 * @param roleid		角色ID
	 * @param filemap		附件map
	 * @param pts           流程类型
	 * @param prInfoList	流程变量信息
	 * @param rlcomment	    日志信息
	 * @param psdid	        流程状态ID
	 * @param action	    动作标识
	 * @param authorizeuser 授权人用户信息
	 */
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,
			String pts,List<IG599Info> prInfoList, String rlcomment,
			String psdid, String action, User authorizeuser)
			throws BLException {
		
		// 获取当前流程状态
		IG333Info psdInfo = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		/**   增加一条流程的记录  start**/
		// 流程记录
		IG500TB processRecordTB = this.getProcessRecordTBInstance();
		this.copyProperties(processRecordTB, processRecord);
		String datetime = IGStringUtils.getCurrentDateTime();
		processRecordTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		processRecordTB.setPropentime(datetime);
		
		processRecordTB.setPruserid(user.getUserid());
		processRecordTB.setPrusername(user.getUsername());
		processRecordTB.setProrgid(user.getOrgid());
		processRecordTB.setProrgname(user.getOrgname());
		
		//判断发起流程类型
		if(StringUtils.isNotEmpty(pts)){
			processRecordTB.setPrtype(pts);
		}else{
			processRecordTB.setPrtype(IGPRDCONSTANTS.SELF_DEFINING_WORK_PRTYPE);
		}
		
		
		IG500Info newProcessRecord = ig500BL.registIG500Info(processRecordTB);
		Integer prid = newProcessRecord.getPrid();// 获得流程记录ID
		
		//添加日志
		addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
				filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, action, psdid);
		/**    增加一条流程的记录  end**/
		
		/**   填充流程发起者  start**/
		// 填充流程发起者记录
		IG337TB opener = this.getProcessParticipantTBInstance();
		opener.setPrid(prid);
		opener.setPpuserid(processRecordTB.getPruserid());
		opener.setPpusername(processRecordTB.getPrusername());
		opener.setPproleid(processRecordTB.getPrroleid());
		opener.setPprolename(processRecordTB.getPrrolename());
		opener.setPporgid(processRecordTB.getProrgid());
		opener.setPporgname(processRecordTB.getProrgname());
		opener.setPpstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		opener.setPpinittime(datetime);
		opener.setPpproctime(datetime);
		opener.setPbdid(action);
		opener.setPpuserinfo(processRecordTB.getPrinfo());
		opener.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		addProcessParticipant(opener,user,roleid,
				"添加：" + opener.getPprolename()
				+ (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
				IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
				IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, psdInfo.getPsdid());
		
		//填写系统日志
		//addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);

		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null) {
			// 如果存在日志内容, 则换行
			rlcomment = this.getRlcomment(user.getUsername(), authorizeuser.getUsername(), rlcomment);
		}
		
		//填写提交日志
		IG036Info rl = this.addRecordLog(prid, user, roleid, rlcomment, IGPRDCONSTANTS.RLDESC_DATA,
				null,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, action, psdInfo.getPsdid());
		
		if(prInfoList != null && !prInfoList.isEmpty()){
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(prid);
			}
			//更新表单信息
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			//增加表单日志
			addRecordLogVarInfo(prInfoList,rl);
		}
		/**   填充流程发起者  end**/
		
		/**   匹配跃迁  start**/
		this.checkAndTransitionForCreate(user,psdid,roleid,action,prid,prInfoList,authorizeuser);

		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
		newProcessRecord = ig500BL.searchIG500InfoByKey(prid);
		// <<<<<<<<<<<<<<<<< update by yangyining 20131028
		//生成工单号
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(newProcessRecord);
		IG380Info ig380Info = this.workFlowDefinitionBL.searchProcessDefinitionByKey(newProcessRecord.getPrpdid());
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			WorkFlowSerialnumGeneratorBL bl = null;
			try {
				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004", "工单号生成器定义");
			}
			igflowlog.debug("========================工单号生成事件开始========================");
			igflowlog.debug("流程类型名称:" + newProcessRecord.getPrpdname());
			igflowlog.debug("流程类型ID:" + newProcessRecord.getPrpdid());
			igflowlog.debug("流程标题:" + newProcessRecord.getPrtitle());
			igflowlog.debug("调用BL:" + ig380Info.getSerialgenerator());
			ig500TB.setPrserialnum(bl.serialnumGenerator(prid));
			igflowlog.debug("生成工单号:" + ig500TB.getPrserialnum());
			igflowlog.debug("========================工单号生成事件结束========================");
			this.ig500BL.updateIG500Info(ig500TB);
		}
		
		/**   匹配跃迁  start**/
		return ig500TB;
	}
	
	/**
	 * 流程管理员修改表单信息
	 * 
	 */
	public void editVarInfo(IG500Info processRecord,User user, Integer roleid, Map<Integer, FormFile> filemap,
			List<IG599Info> prInfoList,String rlcomment, String prstatus) throws BLException{
		//填写提交日志
		IG036Info rl = this.addRecordLog(processRecord.getPrid(), user, roleid, rlcomment, IGPRDCONSTANTS.RLADMIN_DATA,
				null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, null, prstatus);
		
		if(prInfoList != null && !prInfoList.isEmpty()){
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(processRecord.getPrid());
			}
			//更新表单信息
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			//增加表单日志
			addRecordLogVarInfo(prInfoList,rl);
		}

	}
	
	/**
	 * 删除流程
	 * @param prid
	 * @throws BLException
	 */
	public void delProcessRecord(Integer prid) throws BLException {
		ig500BL.deleteProcessRecordByKey(prid);
	}
	
	/**
	 * 根据流程日志查询该流程日志对应的表单日志信息
	 * 
	 * @param IG036Info 流程日志
	 * @return 表单日志信息
	 */
	public List<IG113Info> searchRecordLogVarInfo(IG036Info recordLog) throws BLException{
		
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(recordLog.getRlid());
		List<IG113Info> list = this.ig113BL.searchIG113InfoByCond(cond);
		
		return list;
	}
	
	/**
	 * 根据流程日志ID查询该流程日志对应的表单日志信息
	 * 
	 * @param rlid 流程日志ID
	 * @return 表单日志信息
	 */
	public List<IG113Info> searchRecordLogVarInfoByRecordId(Integer rlid) throws BLException{
		
		IG113SearchCondImpl cond = new IG113SearchCondImpl();
		cond.setRlid(rlid);
		return this.ig113BL.searchIG113InfoByCond(cond);
	}
	
	/**
	 * 查询表单日志
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG113Info> searchRecordLogVarInfoByCond(IG113SearchCond cond) throws BLException {
		return this.ig113BL.searchIG113InfoByCond(cond);
	}
	
	public String searchPtdcond(Integer prid, String status) {
		List<IG337Info> lst_IG337Info = this.searchProcessParticipantDoneRole(prid, status);
		StringBuffer sbf = new StringBuffer("");
		for(IG337Info bean : lst_IG337Info) {
			sbf.append(bean.getPproleid() + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + bean.getPbdid() + IGPRDCONSTANTS.COND_COND_SPLIT);
		}
		return sbf.toString();
	}
	
	/**
	 * 增加表单日志信息
	 * 
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param IG036Info	   流程日志
	 * @return 表单日志是否保存成功
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl) throws BLException{
		
		boolean flag = true;//表单变量是否存在
		//判断表单变量是否存在
		if(prInfoList != null && !prInfoList.isEmpty()){
			Integer prid = rl.getPrid();
			for(IG599Info pi : prInfoList){
				//表格式表单不记录日志
				if("8".equals(pi.getPivartype())
						|| "F".equals(pi.getPivartype())){
					continue;
				}
				String varvalue = pi.getPivarvalue();//对象类变量名称
				
				if(pi.getPivartype().equals("4")){  //资产
					if(StringUtils.isNotEmpty(varvalue)){
						//查询当前流程的资产信息
						List<IG731Info> asmList = searchProcessInfoEntityByPrid(pi.getPrid());
						StringBuffer asmNames = new StringBuffer();
						int index = 0;
						for(IG731Info info:asmList){
							for(String key:pi.getPivarvalue().split(",")){
								if(info.getPieid().toString().equals(key)){
									if(index > 0){
										asmNames.append(",");
									}
									asmNames.append(info.getEntityItemVWTB().getEiname());
									index ++;
								}
							}
						}
						varvalue = asmNames.toString();
					}
				} else if(pi.getPivartype().equals("5")){  //流程
					continue;
				} else if(pi.getPivartype().equals("6")){  //项目
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_prj_")){
						varvalue = varvalue.split("_prj_")[1];
					}
				} else if(pi.getPivartype().equals("R")){  //角色
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_role_")){
						varvalue = varvalue.split("_role_")[1];
					}
				} else if(pi.getPivartype().equals("T")){
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_tree_")){
						varvalue = varvalue.split("_tree_")[1];
					}
				} else if(pi.getPivartype().equals("P")){
					if(StringUtils.isNotEmpty(varvalue)){
						//查询当前流程的人员表单信息
						List<IG506Info> ppList = searchIG506InfoByprid(pi.getPrid());
						StringBuffer ppNames = new StringBuffer();
						int index = 0;
						for(IG506Info info:ppList){
							for(String key:pi.getPivarvalue().split(",")){
								if(info.getPiuid().toString().equals(key)){
									if(index > 0){
										ppNames.append(",");
									}
									ppNames.append(info.getPiusername());
									index ++;
								}
							}
						}
						varvalue = ppNames.toString();
					}
				} else {
					varvalue = "";
				}
				
				IG113TB rlvtb = this.ig113BL.getIG113TBInstance();
				rlvtb.setPiattkey(pi.getPiattkey());
				rlvtb.setPidid(pi.getPidid());
				rlvtb.setPiid(pi.getPiid());
				rlvtb.setPivarlabel(pi.getPivarlabel());
				rlvtb.setPivarname(pi.getPivarname());
				rlvtb.setPivartype(pi.getPivartype());
				rlvtb.setPivarvalue(pi.getPivarvalue());
				rlvtb.setPrid(prid);
				rlvtb.setRlid(rl.getRlid());
				rlvtb.setFingerPrint(rl.getRltime());
				//如果为对象类型变量且有值时则保存显示名称
				if(StringUtils.isNotEmpty(varvalue) && StringUtils.isNotEmpty(pi.getPivarvalue())){
					rlvtb.setPishowvarname(varvalue.replace("cv_cev_", ""));
				}
				
				this.ig113BL.registIG113Info(rlvtb);

			}
			
			
		}else{
			flag = false;
		}

		return flag;
	}
	
	
	
	
	//======================================================================================================================================
	
	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null(发起自定义流程时使用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @param authorizeuser授权人用户信息
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransitionForCreate(User user,String fpsdid,Integer roleid,String action,
			Integer prid,List<IG599Info> piList, User authorizeuser) throws BLException {
		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		if(pr == null) {
			throw new BLException("IGCO10000.E004","工作基本");
		}
		
		IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);
		
		//目标集合
		List<String> toStatusList = new ArrayList<String>();
		
		//匹配或条件，即ptdcond只存一个角色的动作
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//构造跃迁条件
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		//ptdCond.setPtdcond(ptdcond);
		ptdCond.setPtdcond_like(ptdcond);
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//如果匹配则跃迁，已第一次匹配条件为准。同时清空pr表prptdcond的值，用于存放下次跃迁条件
		boolean flag = true;//true匹配,false不匹配
		//修改prptdcond不记录值的bug开始
		if(ptdList.isEmpty()) {
			flag = false;
		}
		//修改prptdcond不记录值的bug结束
		for(IG273Info ptd:ptdList){
			//prTB.setPrptdcond(null);
			if(ptd.getPtdcond().indexOf('|')!=-1){
				if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
					//判断表单条件
					//已定义的表单条件
					String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
					String[] vid=new String[vCond.length];//表单id
					String[] vsign=new String[vCond.length];//表单逻辑符号
					String[] vvalue=new String[vCond.length];//表单值
					
					for(int i=0; i<vCond.length;i++){
						//一个规则的拆分临时保存
						String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
						vid[i] = temp[0];
						vsign[i] = temp[1];
						vvalue[i] = temp[2];
					}
					//表单条件匹配
					
					for(int i=0,m=piList.size();i<m;i++){
						flag=true;
						IG599Info pi = piList.get(i);
						String pidid = pi.getPidid();//页面上的表单ID
						String pivarvalue = pi.getPivarvalue();//页面上的表单值
						String pitype = pi.getPivartype();//页面上的表单数据类型
						for(int j=0,n=vid.length;j<n;j++){
							if(pidid.toString().equals(vid[j])){
								//表单值与定义的规则比较
								if(StringUtils.isNotEmpty(pivarvalue)){
									if("3".equals(pitype)){//日期类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("A".equals(pitype)){//时间类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("R".equals(pitype)){//角色类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
											else{
												if(StringUtils.isEmpty(pivarvalue)){
													flag=false;
												}
											}
											break;
										case 2:
											if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										}
									}else if("7".equals(pitype)){//数字控件
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 2:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 3:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 4:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 5:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 6:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										}
										
									}else if("2".equals(pitype)){//下拉框
										if(!vvalue[j].equals(pivarvalue)){
											flag=false;
										}
									}
								}else{
									flag=false;
								}
							}
							if(!flag){
								break;
							}
						}
						if(!flag){
							break;
						}
					}
					if(flag){
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						
						//流程状态跃迁
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
								null,null,authorizeuser, action);
						toStatusList.add(statuscode);
//						return ptd.getTpsdid();
					}
				}
			}else{
				//没有表单条件且匹配上跃迁条件.
				if(ptdcond.equals(ptd.getPtdcond())){
					IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
					
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
						prTB.setPrstatus(psd.getPsdcode());
						prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
					}
					//流程状态跃迁
					String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
							null,null,authorizeuser, action);
					toStatusList.add(statuscode);
//					return ptd.getTpsdid();
				}
			}
			
		}
		//获取跃迁条件临时变量
		String prptdcond = pr.getPrptdcond();
		
		//去掉相同的处理
		{	
			if(StringUtils.isNotEmpty(prptdcond)){
				if(StringUtils.isNotEmpty(prptdcond)){
					String[] check = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
					List<String> air = new ArrayList<String>();
					StringBuffer sf = new StringBuffer();
					for(String find:check){
						if(!air.contains(find)){
							sf.append(find).append(IGPRDCONSTANTS.COND_COND_SPLIT);
							air.add(find);
						}
					}
					prptdcond = sf.toString();
				}
			}
			
		}
		
		//取得当前流程状态的定义
		IG333Info processStatusDef = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);

		//该流程第一个参与者操作
		if(StringUtils.isEmpty(prptdcond) && (ptdList==null || ptdList.size()==0)) {
			
			/**匹配缺省规则开始*/
			ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
			ptdCond.setPtdcond_like(ptdcond);
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			flag = true;//true匹配,false不匹配
			//修改prptdcond不记录值的bug开始
			if(ptdList.isEmpty()) {
				flag = false;
			}
			//修改prptdcond不记录值的bug结束
			for(IG273Info ptd:ptdList){
				//prTB.setPrptdcond(null);
				if(ptd.getPtdcond().indexOf('|')!=-1){
					if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
						//判断表单条件
						//已定义的表单条件
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//表单id
						String[] vsign=new String[vCond.length];//表单逻辑符号
						String[] vvalue=new String[vCond.length];//表单值
						
						for(int i=0; i<vCond.length;i++){
							//一个规则的拆分临时保存
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//表单条件匹配
						
						for(int i=0,m=piList.size();i<m;i++){
							flag=true;
							IG599Info pi = piList.get(i);
							String pidid = pi.getPidid();//页面上的表单ID
							String pivarvalue = pi.getPivarvalue();//页面上的表单值
							String pitype = pi.getPivartype();//页面上的表单数据类型
							for(int j=0,n=vid.length;j<n;j++){
								if(pidid.toString().equals(vid[j])){
									//表单值与定义的规则比较
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//日期类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//时间类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//角色类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//数字控件
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//下拉框
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						if(flag){
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							
							//流程状态跃迁
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
									null,null,authorizeuser, action);
							toStatusList.add(statuscode);
//							return ptd.getTpsdid();
						}
					}
				}else{
					//没有表单条件且匹配上跃迁条件.
					if(ptdcond.equals(ptd.getPtdcond())){
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						//流程状态跃迁
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
								null,null,authorizeuser, action);
						toStatusList.add(statuscode);
//						return ptd.getTpsdid();
					}else{
						flag = false;
					}
				}
			}
			/**匹配缺省规则结束*/
			if(!flag){
				prTB.setPrptdcond(roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
				//workFlowOperationBL.updateProcessRecord(prTB);
				this.updateProcessRecord(prTB);
//				return null;
			}
		} else {//匹配与条件
			if(StringUtils.isEmpty(prptdcond)){
//				return null;
			} else {
			String[] prptdondArray = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_AND);
			
			ptdCond.setPtdcond(null);
			
			ptdCond.setPtdcond_like(ptdcond);
			
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			//true不匹配,false匹配
			flag = false;//有多个跃迁条件时，每次不匹配时要进行下一次匹配
			//修改prptdcond不记录值的bug开始
			if(ptdList.isEmpty()) {
				flag = true;
			}
			//修改prptdcond不记录值的bug结束
			for(IG273Info ptd : ptdList) {
				if(ptd.getPtdcond().indexOf('|')!=-1){//有表单条件
					String cond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];//角色动作条件
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//流程已满足规则
						List<String> prcondList =new ArrayList<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//跃迁规则条件
						List<String> condList =new ArrayList<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//匹配时，两个集合应为空
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//如果两方条件匹配则各自删除
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//完全匹配则跃迁
							if(0 == prcondList.size() && 0 == condList.size()) {
								//表单判断
								boolean vflag = false;//true匹配,false不匹配
								//已定义的表单条件
								String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//表单id
								String[] vsign=new String[vCond.length];//表单逻辑符号
								String[] vvalue=new String[vCond.length];//表单值
								
								for(int i=0; i<vCond.length;i++){
									//一个规则的拆分临时保存
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//表单条件匹配
								
								for(int i=0,m=piList.size();i<m;i++){
									vflag=true;
									IG599Info pi = piList.get(i);
									String pidid = pi.getPidid();//页面上的表单ID
									String pivarvalue = pi.getPivarvalue();//页面上的表单值
									String pitype = pi.getPivartype();//页面上的表单数据类型
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//取表单值
											if("3".equals(pitype)){//日期类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("A".equals(pitype)){//时间类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("R".equals(pitype)){//角色类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//数字控件
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 2:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 3:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 4:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 5:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 6:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//下拉框
												if(!vvalue[j].equals(pivarvalue)){
													vflag=false;
												}
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								
								if(vflag){
									prTB.setPrptdcond(null);
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}

									//流程状态跃迁
									String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
											null,null,authorizeuser, action);
									toStatusList.add(statuscode);
//									return ptd.getTpsdid();
								}else{
									flag = true;
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","规则定义基本");
						return null;
					}
				}else{//无表单条件,和原逻辑相同
					String cond = ptd.getPtdcond();
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//流程已满足规则
						List<String> prcondList =new ArrayList<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//跃迁规则条件
						List<String> condList =new ArrayList<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//匹配时，两个集合应为空
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//如果两方条件匹配则各自删除
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//完全匹配则跃迁
							if(0 == prcondList.size() && 0 == condList.size()) {
								prTB.setPrptdcond(null);
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								
								//流程状态跃迁
								String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid(),prTB,user,roleid,null,
										null,null,authorizeuser, action);
								toStatusList.add(statuscode);
//								return ptd.getTpsdid();
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","规则定义基本");
						return null;
					}
				}
				if(flag && (ptdList==null || ptdList.size()==0)) {
					
					/**匹配缺省规则开始*/
					ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
					ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
					ptdCond.setPtdcond_like(ptdcond);
					ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
					flag = true;//true匹配,false不匹配
					//修改prptdcond不记录值的bug开始
					if(ptdList.isEmpty()) {
						flag = false;
					}
					//修改prptdcond不记录值的bug结束
					for(IG273Info pt:ptdList){
						//prTB.setPrptdcond(null);
						if(pt.getPtdcond().indexOf('|')!=-1){
							if(ptdcond.equals(pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
								//判断表单条件
								//已定义的表单条件
								String[] vCond = pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//表单id
								String[] vsign=new String[vCond.length];//表单逻辑符号
								String[] vvalue=new String[vCond.length];//表单值
								
								for(int i=0; i<vCond.length;i++){
									//一个规则的拆分临时保存
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//表单条件匹配
								
								for(int i=0,m=piList.size();i<m;i++){
									flag=true;
									IG599Info pi = piList.get(i);
									String pidid = pi.getPidid();//页面上的表单ID
									String pivarvalue = pi.getPivarvalue();//页面上的表单值
									String pitype = pi.getPivartype();//页面上的表单数据类型
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//表单值与定义的规则比较
											if(StringUtils.isNotEmpty(pivarvalue)){
												if("3".equals(pitype)){//日期类型
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(!vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 2:
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 3:
														if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
														break;
													case 4:
														if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
														break;
													case 5:
														if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
														break;
													case 6:
														if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
														break;
													}
												}if("A".equals(pitype)){//时间类型
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(!vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 2:
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													case 3:
														if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
														break;
													case 4:
														if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
														break;
													case 5:
														if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
														break;
													case 6:
														if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
														break;
													}
												}if("R".equals(pitype)){//角色类型
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
														else{
															if(StringUtils.isEmpty(pivarvalue)){
																flag=false;
															}
														}
														break;
													case 2:
														if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
														if(vvalue[j].equals(pivarvalue)){ flag=false; }
														break;
													}
												}else if("7".equals(pitype)){//数字控件
													int index=Integer.parseInt(vsign[j]);
													switch (index) {
													case 1:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 2:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 3:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 4:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 5:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													case 6:
														if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
														break;
													}
													
												}else if("2".equals(pitype)){//下拉框
													if(!vvalue[j].equals(pivarvalue)){
														flag=false;
													}
												}
											}else{
												flag=false;
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								if(flag){
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									
									//流程状态跃迁
									String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid(),prTB,user,roleid,null,
											null,null,authorizeuser, action);
									toStatusList.add(statuscode);
//									return pt.getTpsdid();
								}
							}
						}else{
							//没有表单条件且匹配上跃迁条件.
							if(ptdcond.equals(pt.getPtdcond())){
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//流程状态跃迁
								String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid(),prTB,user,roleid,null,
										null,null,authorizeuser, action);
								toStatusList.add(statuscode);
//								return pt.getTpsdid();
							}else{
								flag = false;
							}
						}
					}
					/**匹配缺省规则结束*/
					if(!flag){
						prTB.setPrptdcond(prTB.getPrptdcond() + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT
								+ action + IGPRDCONSTANTS.COND_COND_SPLIT);
						this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
								IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
//						return null;
					}
				}
				if(flag){
					prTB.setPrptdcond(prTB.getPrptdcond()+ptdcond);
					this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),
							null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
//					return null;
				}
			}
			}
		}

		// 记录流程状态日志
		if (toStatusList != null && toStatusList.size() > 0) {
			
			boolean endflag = false;
			
			String[] toStatus = new String[toStatusList.size()];
			String endStatus = "";
			for (int i = 0; i < toStatusList.size(); i++) {
				toStatus[i] = toStatusList.get(i);

				//目标状态
				IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(toStatus[i]);
				endStatus = tpsd.getPsdcode();
				
				if ((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()) && StringUtils.isEmpty(tpsd.getPpsdid())) 
						|| (IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode()) && StringUtils.isNotEmpty(tpsd.getPpsdid()))) {
					endflag = true;
				}
			}
			
			//源状态
			IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
			
			//流程状态类型判断：0开始，1普通，2结束
			int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
			
			//process0001_begin
			//如果是新发起的流程，流程状态日志应为空，否则为被打回流程
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid()))) {
				//process0001_end
				statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
			} else if(endflag) {
				statustype = WorkFlowConstDefine.STATUSTYPE_END;
			}

			// >>>>>>>>>>>>>>>>> update by yangyining 20131028
			IG500Info prinfo = ig500BL.searchIG500InfoByKey(prTB.getPrid());
			IG500TB prtb = (IG500TB)SerializationUtils.clone(prTB);
			prtb.setPrserialnum(prinfo.getPrserialnum());
			prtb.setPrstatus(endStatus);
			prinfo = null;
			// <<<<<<<<<<<<<<<<< update by yangyining 20131028
			
			List<IG224Info> list = ig224BL.searchCurrentIG224InfoByPsdid(prid, fpsd.getPsdid());
			if(list.size() != 1 && !(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid())))){
				throw new BLException("IGSVC0000.E001");
			}
			ig500BL.updateIG500Info(prtb);
			
			//添加流程状态日志
			this.addRecordStatusLog(prTB, fpsd, null, toStatus, statustype, user, roleid, authorizeuser, action);
		}
		
		return null;
		
	}
	
	
	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null(处理自定义流程时使用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,Integer prid,
			String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {

		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		Integer psdnum = null;
		if (fpsdid.indexOf("_") > -1) {
			psdnum = Integer.parseInt(fpsdid.split("_")[1]);
			fpsdid = fpsdid.split("_")[0];
		}
		
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);

		//取得当前流程状态的定义
		IG333Info processStatusDef = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);

		//目标集合
		List<String> toStatusList = new ArrayList<String>();
		
		//匹配或条件，即ptdcond只存一个角色的动作
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//构造跃迁条件
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		//ptdCond.setPtdcond(ptdcond);
		ptdCond.setPtdcond_like(ptdcond);
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//如果匹配则跃迁，已第一次匹配条件为准。同时清空pr表prptdcond的值，用于存放下次跃迁条件
		boolean flag = true;//true匹配,false不匹配
		List<IG599Info> pilist = this.getProcessInfo(prid);
		String[] pidids = new String[pilist.size()];
		String[] pivarvalues = new String[pilist.size()];
		String[] pitypes = new String[pilist.size()];
		int num=0;
		for(IG599Info pi:pilist){
			pidids[num] = pi.getPidid();
			pivarvalues[num] = pi.getPivarvalue();
			pitypes[num] = pi.getPivartype();
			num++;
		}
		//修改prptdcond不记录值的bug开始
		if(ptdList.isEmpty()) {
			flag = false;
		}
		
		//定义是否返回变量，防止两段逻辑重复执行
		boolean returnflag = true;
		
		//修改prptdcond不记录值的bug结束
		for(IG273Info ptd:ptdList){
			//prTB.setPrptdcond(null);
			if(ptd.getPtdcond().indexOf('|')!=-1){
				if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
					//判断表单条件
					//已定义的表单条件
					String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
					String[] vid=new String[vCond.length];//表单id
					String[] vsign=new String[vCond.length];//表单逻辑符号
					String[] vvalue=new String[vCond.length];//表单值
					
					//String[] pidid = igprr0102Form.getPidid();//页面上的表单ID
					//String[] pivarvalue = igprr0102Form.getPivarvalue();//页面上的表单值
					//String[] pitype = igprr0102Form.getPivartype();//页面上的表单数据类型
					for(int i=0; i<vCond.length;i++){
						//一个规则的拆分临时保存
						String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
						vid[i] = temp[0];
						vsign[i] = temp[1];
						vvalue[i] = temp[2];
					}
					//表单条件匹配
					
					for(int i=0,m=pidids.length;i<m;i++){
						flag=true;
						//ProcessInfo pi = piList.get(i);
						String pidid = pidids[i];//页面上的表单ID
						String pivarvalue = pivarvalues[i];//页面上的表单值
						String pitype = pitypes[i];//页面上的表单数据类型
						for(int j=0,n=vid.length;j<n;j++){
							if(pidid!=null && pidid.toString().equals(vid[j])){
								//表单值与定义的规则比较
								if(StringUtils.isNotEmpty(pivarvalue)){
									if("3".equals(pitype)){//日期类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("A".equals(pitype)){//时间类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(!vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 2:
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										case 3:
											if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
											break;
										case 4:
											if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
											break;
										case 5:
											if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
											break;
										case 6:
											if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
											break;
										}
									}if("R".equals(pitype)){//角色类型
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
											else{
												if(StringUtils.isEmpty(pivarvalue)){
													flag=false;
												}
											}
											break;
										case 2:
											if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
											if(vvalue[j].equals(pivarvalue)){ flag=false; }
											break;
										}
									}else if("7".equals(pitype)){//数字控件
										int index=Integer.parseInt(vsign[j]);
										switch (index) {
										case 1:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 2:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 3:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 4:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 5:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										case 6:
											if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
											break;
										}
										
									}else if("2".equals(pitype)){//下拉框
										if(!vvalue[j].equals(pivarvalue)){
											flag=false;
										}
									}
								}else{
									flag=false;
								}
							}
							if(!flag){
								break;
							}
						}
						if(!flag){
							break;
						}
					}
					if(flag){
						//判断角色提交权限
						if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond()) 
									+ psd.getPsdid() + "_" + ptdcond);
							this.updateProcessRecord(prTB);
							returnflag = false;
//							return null;
						} else {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							//流程状态跃迁
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
									participants, ppsuper, authorizeuser, action);
							toStatusList.add(statuscode);
							returnflag = false;
//							return ptd.getTpsdid();
						}
					}
				}
			}else{
				//没有表单条件且匹配上跃迁条件.
				if(ptdcond.equals(ptd.getPtdcond())){
					//判断角色提交权限
					if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
								+ psd.getPsdid() + "_" + ptdcond);
						this.updateProcessRecord(prTB);
						returnflag = false;
//						return null;
					} else {
						IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
						if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
							prTB.setPrstatus(psd.getPsdcode());
							prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
						}
						//流程状态跃迁
						String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
								participants, ppsuper, authorizeuser, action);
						toStatusList.add(statuscode);
						returnflag = false;
//						return ptd.getTpsdid();
					}
				}
			}
			
		}
		
		if (returnflag) {
		//获取跃迁条件临时变量
		String prptdcond = searchPtdcond(prid, fpsdid);
		
		//去掉相同的处理
		{	
			if(StringUtils.isNotEmpty(prptdcond)){
				String[] check = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
				List<String> air = new ArrayList<String>();
				StringBuffer sf = new StringBuffer();
				for(String find:check){
					if(!air.contains(find)){
						sf.append(find).append(IGPRDCONSTANTS.COND_COND_SPLIT);
						air.add(find);
					}
				}
				prptdcond = sf.toString();
			}
			
		}
		
		//该流程第一个参与者操作
		if(StringUtils.isEmpty(prptdcond)  && (ptdList==null || ptdList.size()==0)) {
			
			/**匹配缺省规则开始*/
			ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
			ptdCond.setPtdcond_like(ptdcond);
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			flag = true;//true匹配,false不匹配
			//修改prptdcond不记录值的bug开始
			if(ptdList.isEmpty()) {
				flag = false;
			}
			//修改prptdcond不记录值的bug结束
			for(IG273Info ptd:ptdList){
				//prTB.setPrptdcond(null);
				if(ptd.getPtdcond().indexOf('|')!=-1){
					if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
						//判断表单条件
						//已定义的表单条件
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//表单id
						String[] vsign=new String[vCond.length];//表单逻辑符号
						String[] vvalue=new String[vCond.length];//表单值
						
						for(int i=0; i<vCond.length;i++){
							//一个规则的拆分临时保存
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//表单条件匹配
						
						for(int i=0,m=pidids.length;i<m;i++){
							flag=true;
							//ProcessInfo pi = piList.get(i);
							String pidid = pidids[i];//页面上的表单ID
							String pivarvalue = pivarvalues[i];//页面上的表单值
							String pitype = pitypes[i];//页面上的表单数据类型
							for(int j=0,n=vid.length;j<n;j++){
								if(pidid.toString().equals(vid[j])){
									//表单值与定义的规则比较
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//日期类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//时间类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//角色类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//数字控件
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//下拉框
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						if(flag){
							//判断角色提交权限
							if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
										+ psd.getPsdid() + "_" + ptdcond);
								this.updateProcessRecord(prTB);
								returnflag = false;
//								return null;
							} else {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
								
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//流程状态跃迁
								String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
										participants, ppsuper, authorizeuser, action);
								toStatusList.add(statuscode);
								returnflag = false;
//								return ptd.getTpsdid();
							}
						}
					}
				}else{
					//没有表单条件且匹配上跃迁条件.
					if(ptdcond.equals(ptd.getPtdcond())){
						//判断角色提交权限
						if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond()) + 
									psd.getPsdid() + "_" + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
							this.updateProcessRecord(prTB);
							returnflag = false;
//							return null;
						} else {
							IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
								prTB.setPrstatus(psd.getPsdcode());
								prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
							}
							//流程状态跃迁
							String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
									participants, ppsuper, authorizeuser, action);
							toStatusList.add(statuscode);
							returnflag = false;
//							return ptd.getTpsdid();
						}
					}else{
						flag = false;
					}
				}
			}
			/**匹配缺省规则结束*/
			if(!flag && returnflag){
				prTB.setPrptdcond(roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT);
				this.updateProcessRecord(prTB);
//				return null;
			}
		} else {//匹配与条件
			if(StringUtils.isEmpty(prptdcond)){
//				return null;
			} else {
			String[] prptdondArray = prptdcond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			
			ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_AND);
			
			ptdCond.setPtdcond(null);
			
			ptdCond.setPtdcond_like(ptdcond);
			
			ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
			//true不匹配,false匹配
			flag = false;//有多个跃迁条件时，每次不匹配时要进行下一次匹配
			//修改prptdcond不记录值的bug开始
			if(ptdList.isEmpty()) {
				flag = true;
			}
			//修改prptdcond不记录值的bug结束
			for(IG273Info ptd : ptdList) {
				if(ptd.getPtdcond().indexOf('|')!=-1){//有表单条件
					String cond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];//角色动作条件
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//流程已满足规则
						Set<String> prcondList = new HashSet<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//跃迁规则条件
						Set<String> condList = new HashSet<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//匹配时，两个集合应为空
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//如果两方条件匹配则各自删除
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//完全匹配则跃迁
							if(0 == prcondList.size() && 0 == condList.size()) {
								//表单判断
								boolean vflag = false;//true匹配,false不匹配
								//已定义的表单条件
								String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
								String[] vid=new String[vCond.length];//表单id
								String[] vsign=new String[vCond.length];//表单逻辑符号
								String[] vvalue=new String[vCond.length];//表单值
								
								//String[] pidid = igprr0102Form.getPidid();//页面上的表单ID
								//String[] pivarvalue = igprr0102Form.getPivarvalue();//页面上的表单值
								//String[] pitype = igprr0102Form.getPivartype();//页面上的表单数据类型
								for(int i=0; i<vCond.length;i++){
									//一个规则的拆分临时保存
									String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
									vid[i] = temp[0];
									vsign[i] = temp[1];
									vvalue[i] = temp[2];
								}
								//表单条件匹配
								
								for(int i=0; i<pilist.size();i++){
									vflag=true;
									//ProcessInfo pi = piList.get(i);
									String pidid = pidids[i];//页面上的表单ID
									String pivarvalue = pivarvalues[i];//页面上的表单值
									String pitype = pitypes[i];//页面上的表单数据类型
									for(int j=0,n=vid.length;j<n;j++){
										if(pidid.toString().equals(vid[j])){
											//取表单值
											if("3".equals(pitype)){//日期类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}if("R".equals(pitype)){//角色类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//时间类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ vflag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ vflag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ vflag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ vflag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ vflag=false; }
													break;
												}
											}else if("7".equals(pitype)){//数字控件
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 2:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 3:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 4:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 5:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												case 6:
													if(Double.parseDouble(pivarvalue==null?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ vflag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//下拉框
												if(!vvalue[j].equals(pivarvalue)){
													vflag=false;
												}
											}
										}
										if(!flag){
											break;
										}
									}
									if(!flag){
										break;
									}
								}
								
								if(vflag){
									//判断角色提交权限
									if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
										IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
										prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
												+ psd.getPsdid() + "_" + ptdcond);
										this.updateProcessRecord(prTB);
										returnflag = false;
//										return null;
									} else {
										prTB.setPrptdcond(null);
										IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
										if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
											prTB.setPrstatus(psd.getPsdcode());
											prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
										}
										//流程状态跃迁
										String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
												participants, ppsuper, authorizeuser, action);
										toStatusList.add(statuscode);
										returnflag = false;
//										return ptd.getTpsdid();
									}
								}else{
									flag = true;
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","规则定义基本");
						return null;
					}
				}else{//无表单条件,和原逻辑相同
					String cond = ptd.getPtdcond();
					if(StringUtils.isNotEmpty(cond)) {
						String[] condArray = cond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
						//流程已满足规则
						Set<String> prcondList = new HashSet<String>();
						for(String str : prptdondArray) {
							prcondList.add(str);
						}
						//跃迁规则条件
						Set<String> condList = new HashSet<String>();
						for(String str : condArray) {
							condList.add(str);
						}
						
						if(condList.size() >= prcondList.size()) {
							prcondList.add(ptdcond.substring(0, ptdcond.length()-1));
							
							//匹配时，两个集合应为空
							for(Iterator<String> it = condList.iterator(); it.hasNext();) {
								String str = it.next();
								for(Iterator<String> prit = prcondList.iterator(); prit.hasNext();) {
									String prstr = prit.next();
									//如果两方条件匹配则各自删除
									if(str.equals(prstr)) {
										prit.remove();
										it.remove();
										break;
									}
								}
							}
							//完全匹配则跃迁
							if(0 == prcondList.size() && 0 == condList.size()) {
								//判断角色提交权限
								if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), ptd)) {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
											+ psd.getPsdid() + "_" + ptdcond);
									this.updateProcessRecord(prTB);
									returnflag = false;
//									return null;
								} else {
									prTB.setPrptdcond(null);
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptd.getTpsdid());
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									//流程状态跃迁
									String statuscode = this.processStatusTransition(fpsdid,ptd.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
											participants, ppsuper, authorizeuser, action);
									toStatusList.add(statuscode);
									returnflag = false;
//									return ptd.getTpsdid();
								}
							} else {
								flag = true;
							}
						} else {
							throw new BLException("IGPRR0102.E001");
						}
						
					} else {
						//throw new BLException("IGCO10000.E004","规则定义基本");
						return null;
					}
				}
			}
			if(flag && (ptdList==null || ptdList.size()==0)) {
				
				/**匹配缺省规则开始*/
				ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
				ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
				ptdCond.setPtdcond_like(ptdcond);
				ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
				flag = true;//true匹配,false不匹配
				//修改prptdcond不记录值的bug开始
				if(ptdList.isEmpty()) {
					flag = false;
				}
				//修改prptdcond不记录值的bug结束
				for(IG273Info pt:ptdList){
					//prTB.setPrptdcond(null);
					if(pt.getPtdcond().indexOf('|')!=-1){
						if(ptdcond.equals(pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
							//判断表单条件
							//已定义的表单条件
							String[] vCond = pt.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
							String[] vid=new String[vCond.length];//表单id
							String[] vsign=new String[vCond.length];//表单逻辑符号
							String[] vvalue=new String[vCond.length];//表单值
							
							for(int i=0; i<vCond.length;i++){
								//一个规则的拆分临时保存
								String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
								vid[i] = temp[0];
								vsign[i] = temp[1];
								vvalue[i] = temp[2];
							}
							//表单条件匹配
							
							for(int i=0,m=pidids.length;i<m;i++){
								flag=true;
								//ProcessInfo pi = piList.get(i);
								String pidid = pidids[i];//页面上的表单ID
								String pivarvalue = pivarvalues[i];//页面上的表单值
								String pitype = pitypes[i];//页面上的表单数据类型
								for(int j=0,n=vid.length;j<n;j++){
									if(pidid.toString().equals(vid[j])){
										//表单值与定义的规则比较
										if(StringUtils.isNotEmpty(pivarvalue)){
											if("3".equals(pitype)){//日期类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//时间类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("R".equals(pitype)){//角色类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//数字控件
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 2:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 3:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 4:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 5:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 6:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//下拉框
												if(!vvalue[j].equals(pivarvalue)){
													flag=false;
												}
											}
										}else{
											flag=false;
										}
									}
									if(!flag){
										break;
									}
								}
								if(!flag){
									break;
								}
							}
							if(flag){
								//判断角色提交权限
								if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), pt)) {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
											+ psd.getPsdid() + "_" + ptdcond);
									this.updateProcessRecord(prTB);
									returnflag = false;
//									return null;
								} else {
									IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
									if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
										prTB.setPrstatus(psd.getPsdcode());
										prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
									}
									//流程状态跃迁
									String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
											participants, ppsuper, authorizeuser, action);
									toStatusList.add(statuscode);
									returnflag = false;
//									return pt.getTpsdid();
								}
							}
						}
					}else{
						//没有表单条件且匹配上跃迁条件.
						if(ptdcond.equals(pt.getPtdcond())){
							//判断角色提交权限
							if(!checkUserCommitInRole(prid, processStatusDef.getPsdid() + (psdnum == null ? "" : "_" + psdnum), pt)) {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								prTB.setPrptdcond((StringUtils.isEmpty(prTB.getPrptdcond()) ? "" : prTB.getPrptdcond())
										+ psd.getPsdid() + "_" + ptdcond);
								this.updateProcessRecord(prTB);
								returnflag = false;
//								return null;
							} else {
								IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(pt.getTpsdid());
								if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode()) && StringUtils.isEmpty(psd.getPpsdid())) {
									prTB.setPrstatus(psd.getPsdcode());
									prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());
								}
								//流程状态跃迁
								String statuscode = this.processStatusTransition(fpsdid,pt.getTpsdid() + (psdnum == null ? "" : "_" + psdnum),prTB,user,roleid,nodeType,
										participants, ppsuper, authorizeuser, action);
								toStatusList.add(statuscode);
								returnflag = false;
//								return pt.getTpsdid();
							}
						}else{
							flag = false;
						}
					}
				}
				/**匹配缺省规则结束*/
				if(!flag && returnflag){
					prTB.setPrptdcond(prTB.getPrptdcond() + roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT 
							+ action + IGPRDCONSTANTS.COND_COND_SPLIT);

					this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
							IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
					
//					return null;
				}
			}
			if(flag && returnflag){
				prTB.setPrptdcond(prTB.getPrptdcond()+ptdcond);

				this.updateProcessRecord(prTB,user,roleid,"",processStatusDef.getPsdname(),null,
						IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, action, processStatusDef.getPsdid());
				
//				return null;
			}
			}
		}
		}
	
		// 记录流程状态日志
		if (toStatusList != null && toStatusList.size() > 0) {
			
			boolean endflag = false;
			
			String[] toStatus = new String[toStatusList.size()];
			String endStatus = "";
			for (int i = 0; i < toStatusList.size(); i++) {
				toStatus[i] = toStatusList.get(i);

				//目标状态
				IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(toStatus[i]);
				endStatus = tpsd.getPsdcode();
				
				if ((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()) && StringUtils.isEmpty(tpsd.getPpsdid())) 
						|| (IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(tpsd.getPsdcode()) && StringUtils.isNotEmpty(tpsd.getPpsdid()))) {
					endflag = true;
				}
			}
			
			//源状态
			IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
			
			//流程状态类型判断：0开始，1普通，2结束
			int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
			
			//process0001_begin
			//如果是新发起的流程，流程状态日志应为空，否则为被打回流程
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid()))) {
				//process0001_end
				statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
			} else if(endflag) {
				statustype = WorkFlowConstDefine.STATUSTYPE_END;
			}
			
			// >>>>>>>>>>>>>>>>> update by yangyining 20131028
			IG500Info prinfo = ig500BL.searchIG500InfoByKey(prTB.getPrid());
			IG500TB prtb = (IG500TB)SerializationUtils.clone(prTB);
			prtb.setPrserialnum(prinfo.getPrserialnum());
			prtb.setPrstatus(endStatus);
			prinfo = null;
			// <<<<<<<<<<<<<<<<< update by yangyining 20131028
			
			List<IG224Info> list = ig224BL.searchCurrentIG224InfoByPsdid(prid, fpsd.getPsdid() + (psdnum == null ? "" : "_" + psdnum));
			if(list.size() != 1 && !(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && (searchRecordStatusLog(prTB.getPrid()).isEmpty() || StringUtils.isNotEmpty(fpsd.getPpsdid())))){
				throw new BLException("IGSVC0000.E001");
			}
			ig500BL.updateIG500Info(prtb);
			
			//添加流程状态日志
			this.addRecordStatusLog(prTB, fpsd, psdnum, toStatus, statustype, user, roleid, authorizeuser, action);
		}
		
		return null;
	}
	
	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null(处理自定义流程时使用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return Integer 跃迁后的流程状态ID
	 */
	public IG333Info checkAndTransitionForHandel(User user,String fpsdid,Integer roleid,String action,Integer prid, User authorizeuser) throws BLException {
		
		//流程信息
		IG500Info pr = this.searchProcessRecordByKey(prid);
		
		IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
		
		//跃迁标识
		boolean flag = true;
		
		//并行节点跃迁条件为ANY，且唯一，即所有参与角色的负责人或值班人的其中一人已经提交才跃迁
		//获取未提交参与者
		List<IG337Info> ppTodoList = this.searchProcessParticipantTodoRole(prid, pr.getPrstatus());
		
		//OA模式，角色负责人或被授权值班人提交才算提交
		if(IGPRDCONSTANTS.MODE_OA.equals(fpsd.getPsdmode())) {
			Set<Integer> ppDoneSet = new HashSet<Integer>();
			Set<String> ppDoneOrgSet = new HashSet<String>();
			//获取已提交参与者
			List<IG337Info> ppDoneList = this.searchProcessParticipantDoneRole(prid, pr.getPrstatus());
			//获取已提交角色ID，角色负责人或值班人提交才算提交
			//判断参与者类型是否为机构
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(fpsd.getPsdassign())){
				for(IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						ppDoneOrgSet.add(pp.getPporgid());
					}
				}
			}else{
				for(IG337Info pp : ppDoneList) {
					if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
							IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
							(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
						ppDoneSet.add(pp.getPproleid());
					}
				}
			}
			//当未处理角色不在已处理角色集合时，不跃迁
			for(IG337Info pp : ppTodoList) {
				if(IGPRDCONSTANTS.ROLEMANAGER.equals(pp.getPprolemanager()) || 
						IGPRDCONSTANTS.TEMP_ROLEMANAGER.equals(pp.getPprolemanager()) || 
						(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) && IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus()))) {
					//判断参与者类型是否为机构
					if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(fpsd.getPsdassign())){
						if(!ppDoneOrgSet.contains(pp.getPporgid())) {
							flag = false;
							break;
						}
					}else{
						if(!ppDoneSet.contains(pp.getPproleid())) {
							flag = false;
							break;
						}
					}
				}
			}
		} else {
			//普通模式，有未提交参与者则不跃迁
			if(ppTodoList.size() > 0) {
				flag = false;
			}
		}
		
		if(flag) {
			//并行节点跃迁条件为ANY，且唯一，即所有参与者都已经提交才跃迁
			IG273SearchCondImpl cond = new IG273SearchCondImpl();
			
			cond.setFpsdid(fpsdid);
			
			cond.setPtdcond(IGPRDCONSTANTS.TRANSITION_RULE_ANY);
			
			List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(cond);
			
			if(ptdList.size() != 1) {
				throw new BLException("IGCO10000.E004","并行节点跃迁规则基本");
			}
			//获取跃迁状态信息
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(ptdList.get(0).getTpsdid());
			
			//更新流程状态信息
			IG500TB prTB = (IG500TB)SerializationUtils.clone(pr);
			
			prTB.setPrstatus(ptdList.get(0).getToPSDTB().getPsdcode());//流程状态
			
			prTB.setPrptdcond(null);//跃迁规则
			
			if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(prTB.getPrstatus())) {
				prTB.setPrclosetime(IGStringUtils.getCurrentDateTime());//关闭时间
			}
			//流程状态跃迁
			this.processStatusTransition(fpsdid,ptdList.get(0).getTpsdid(),prTB,user,roleid,IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY,
					null, null, authorizeuser, action);
			
			this.processAfterTreatmentExecute(prTB, fpsd, psd, user, roleid, authorizeuser, action, null); 
			
			//触发流程前处理事件
			this.processPreTreatmentExecute(prTB, fpsd, psd, user, roleid, authorizeuser, action, null);
			
			this.addRecordStatusLog(pr.getPrid(), pr.getPrpdid(), pr.getPrtype(), fpsd.getPsdcode(),
					psd.getPsdcode(), WorkFlowConstDefine.STATUSTYPE_NORMAL, psd.getPsdid(), pr.getPid());
			
			return psd;
		}
		return null;
	}
		
		
		
		
		
		
		
		
	/**
	 * 获取下一流程状态的ID
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return ProcessStatusDef 跃迁后的流程状态
	 * @throws BLException
	 */
	public IG333Info checkTransition(String fpsdid,Integer roleid,String action,List<IG599Info> piList) throws BLException {
		if(action == null) {
			throw new BLException("IGPRR0102.E003");
		}
		//更新
		if(IGPRDCONSTANTS.BUTTON_UPDATE.equals(action)) {
			return null;
		}
		
		//匹配或条件，即ptdcond只存一个角色的动作
		IG273SearchCondImpl ptdCond = new IG273SearchCondImpl();
		
		//构造跃迁条件
		String ptdcond = roleid + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
		
		ptdCond.setFpsdid(fpsdid);
		
		ptdCond.setPtdcond_like(ptdcond);
		
		ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_OR);
		
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
		//如果匹配则跃迁，则返回状态ID，-1表示结束
		if(ptdList.size() > 0) {//是否定义了跃阡规则
			boolean flag = true;//true匹配,false不匹配
			for(IG273Info ptd:ptdList){
				if(ptd.getPtdcond().indexOf('|')!=-1){//有表单跃迁规则
						//判断表单条件
						//已定义的表单条件
						String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
						String[] vid=new String[vCond.length];//表单id
						String[] vsign=new String[vCond.length];//表单逻辑符号
						String[] vvalue=new String[vCond.length];//表单值
						
						//String[] pidid = igprr0102Form.getPidid();//页面上的表单ID
						//String[] pivarvalue = igprr0102Form.getPivarvalue();//页面上的表单值
						//String[] pitype = igprr0102Form.getPivartype();//页面上的表单数据类型
						for(int i=0; i<vCond.length;i++){
							//一个规则的拆分临时保存
							String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
							vid[i] = temp[0];
							vsign[i] = temp[1];
							vvalue[i] = temp[2];
						}
						//表单条件匹配
						
						for(int i=0,m=piList.size();i<m;i++){
							flag=true;
							IG599Info pi = piList.get(i);
							String pidid = pi.getPidid();//页面上的表单ID
							String pivarvalue = pi.getPivarvalue();//页面上的表单值
							String pitype = pi.getPivartype();//页面上的表单数据类型
							for(int j=0;j<vid.length;j++){
								if(pidid.toString().equals(vid[j])){
									//表单值与定义的规则比较
									if(StringUtils.isNotEmpty(pivarvalue)){
										if("3".equals(pitype)){//日期类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("A".equals(pitype)){//时间类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(!vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 2:
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											case 3:
												if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
												break;
											case 4:
												if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
												break;
											case 5:
												if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
												break;
											case 6:
												if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
												break;
											}
										}if("R".equals(pitype)){//角色类型
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
												else{
													if(StringUtils.isEmpty(pivarvalue)){
														flag=false;
													}
												}
												break;
											case 2:
												if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
												if(vvalue[j].equals(pivarvalue)){ flag=false; }
												break;
											}
										}else if("7".equals(pitype)){//数字控件
											int index=Integer.parseInt(vsign[j]);
											switch (index) {
											case 1:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 2:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 3:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 4:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 5:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											case 6:
												if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
												break;
											}
											
										}else if("2".equals(pitype)){//下拉框
											if(!vvalue[j].equals(pivarvalue)){
												flag=false;
											}
										}
									}else{
										flag=false;
									}
								}
								if(!flag){
									break;
								}
							}
							if(!flag){
								break;
							}
						}
						
						if(flag){//如果与定义的规则匹配跃迁
							return ptd.getToPSDTB();
						}else{//没匹配进行缺省规则的匹配
							
						}
				}else{//没有表单跃迁规则
					
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(ptdList.get(0).getToPSDTB().getPsdcode())) {
						return null;
					}
					return ptdList.get(0).getToPSDTB();
					
				}
			}
			//如果没有任何规则提示
			//throw new BLException("IGCO10000.E004","规则定义（" + ptdcond + "）基本");
			return null;
		} else {//没定义跃阡规则走缺少规则
				boolean flag = true;//true匹配,false不匹配
				/**缺省规则*/
				ptdcond = IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + action + IGPRDCONSTANTS.COND_COND_SPLIT;
				ptdCond.setPtdtype(IGPRDCONSTANTS.COND_TYPE_DEFAULT);
				ptdCond.setPtdcond_like(ptdcond);
				ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ptdCond);
				//修改prptdcond不记录值的bug开始
				if(ptdList.isEmpty()) {
					flag = false;
				}
				//修改prptdcond不记录值的bug结束
				for(IG273Info ptd:ptdList){
					if(ptd.getPtdcond().indexOf('|')!=-1){
						if(ptdcond.equals(ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0])){
							//判断表单条件
							//已定义的表单条件
							String[] vCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[1].split(IGPRDCONSTANTS.COND_COND_SPLIT);
							String[] vid=new String[vCond.length];//表单id
							String[] vsign=new String[vCond.length];//表单逻辑符号
							String[] vvalue=new String[vCond.length];//表单值
							
							//String[] pidid = igprr0102Form.getPidid();//页面上的表单ID
							//String[] pivarvalue = igprr0102Form.getPivarvalue();//页面上的表单值
							//String[] pitype = igprr0102Form.getPivartype();//页面上的表单数据类型
							for(int i=0; i<vCond.length;i++){
								//一个规则的拆分临时保存
								String[] temp = vCond[i].split(IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT);
								vid[i] = temp[0];
								vsign[i] = temp[1];
								vvalue[i] = temp[2];
							}
							//表单条件匹配
							
							for(int i=0,m=piList.size();i<m;i++){
								flag=true;
								IG599Info pi = piList.get(i);
								String pidid = pi.getPidid();//页面上的表单ID
								String pivarvalue = pi.getPivarvalue();//页面上的表单值
								String pitype = pi.getPivartype();//页面上的表单数据类型
								for(int j=0;j<vid.length;j++){
									if(pidid.toString().equals(vid[j])){
										//表单值与定义的规则比较
										if(StringUtils.isNotEmpty(pivarvalue)){
											if("3".equals(pitype)){//日期类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("A".equals(pitype)){//时间类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(!vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 2:
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												case 3:
													if(vvalue[j].compareTo(pivarvalue)>=0){ flag=false; }
													break;
												case 4:
													if(vvalue[j].compareTo(pivarvalue)<=0){ flag=false; }
													break;
												case 5:
													if(vvalue[j].compareTo(pivarvalue)>0){ flag=false; }
													break;
												case 6:
													if(vvalue[j].compareTo(pivarvalue)<0){ flag=false; }
													break;
												}
											}if("R".equals(pitype)){//角色类型
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(StringUtils.isNotEmpty(pivarvalue) && !pivarvalue.contains(vvalue[j])){ flag=false; }
													else{
														if(StringUtils.isEmpty(pivarvalue)){
															flag=false;
														}
													}
													break;
												case 2:
													if(StringUtils.isNotEmpty(pivarvalue) && pivarvalue.contains(vvalue[j])){ flag=false; }
													if(vvalue[j].equals(pivarvalue)){ flag=false; }
													break;
												}
											}else if("7".equals(pitype)){//数字控件
												int index=Integer.parseInt(vsign[j]);
												switch (index) {
												case 1:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)!=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 2:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)==Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 3:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 4:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>=Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 5:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)<Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												case 6:
													if(Double.parseDouble(StringUtils.isEmpty(pivarvalue)?"0":pivarvalue)>Double.parseDouble(vvalue[j])){ flag=false; }
													break;
												}
												
											}else if("2".equals(pitype)){//下拉框
												if(!vvalue[j].equals(pivarvalue)){
													flag=false;
												}
											}
										}else{
											flag=false;
										}
									}
									if(!flag){
										break;
									}
								}
								if(!flag){
									break;
								}
							}
							
							if(flag){
								return ptd.getToPSDTB();
							}
						}
					}else{//没有表单条件且匹配上跃迁条件.
						if(ptdcond.equals(ptd.getPtdcond())){
							if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(ptdList.get(0).getToPSDTB().getPsdcode())) {
								return null;
							}
							return ptdList.get(0).getToPSDTB();
						}else{
							flag = false;
						}
					}
				}
				if(!flag){
					return null;
				}
				/**缺省规则*/
				//如果没有任何规则提示
				//throw new BLException("IGCO10000.E004","规则定义（" + ptdcond + "）基本");
				return null;
		}
	}
	
	/**
	 * <p>
	 * Description: 流程跃迁 
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 */
	
	public synchronized void doFlow(Integer prid, User user,Integer roleid, String datetime, String rolename,
			String psdid,String action,String desc,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser) throws BLException {
		//跃迁按钮事件处理
		if(action.compareTo(IGPRDCONSTANTS.BUTTON_SUBMIT) >= 0) {
			WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
			bean.setPbdid(action);//按钮ID
			if (psdid.indexOf("_") > -1) {
				bean.setBfstatus(psdid.split("_")[0]);//状态ID
				bean.setBfstatus(psdid.split("_")[1]);//状态ID编号
			} else {
				bean.setBfstatus(psdid);//状态ID
			}
			//日志参数信息
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setPrid(prid);
			logInfo.setExecutorid(user.getUserid());
			logInfo.setExecutorRoleid(roleid);
			if(authorizeuser != null) {
				logInfo.setAuthuserid(authorizeuser.getUserid());
			}
			bean.setLogInfo(logInfo);
			processStatusButtonTreatmentExecute(bean);
		}
		//并行节点跃迁规则判断
		if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(nodeType)){
			this.checkAndTransitionForHandel(user,psdid,roleid,action,prid,authorizeuser);
		} else {//普通节点跃迁规则判断
			this.checkAndTransitionForHandel(user,psdid,roleid,action,prid,nodeType,
					participants, ppsuper, authorizeuser);
		}
		
	}
	
	/**
	 * <p>
	 * Description: 添加参与者
	 * </p>
	 * 
	 * @param tpsdid tpsdid
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	
	public List<IG337Info> addParticipants(String tpsdid,User user,Integer prid,Integer roleid,String desc,String nodetype,
			Map<Integer, List<String>> participants, String ppsuper,User authorizeuser, String pbdid, String prstatus) throws BLException {
		String psdid = "";
		Integer psdnum = null;
		if (tpsdid.indexOf("_") > -1) {
			psdid = tpsdid.split("_")[0];
			psdnum = Integer.parseInt(tpsdid.split("_")[1]);
		} else {
			psdid = tpsdid;
		}
		
		//获取指定状态下的参与者
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		ppdCond.setPsdid(psdid);
		List<IG222Info> ppdList = workFlowDefinitionBL.searchParticipantDef(ppdCond);
		//跃迁状态
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		
		//跃迁到原状态时要先清空参与者的处理完成时间
//		List<IG337Info> ppList = this.searchProcessParticipant(prid, 
//				psd.getPsdcode());
		IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
		ppCond.setPrid(prid);
		ppCond.setPsdid(psdid);
		ppCond.setPsdnum(psdnum);
		List<IG337Info> ppList = this.searchProcessParticipants(ppCond);
		//记录分派的参与者信息
		Set<String> idSet = new HashSet<String>();
		//驳回时不清空处理人的提交时间和提交按钮
		for(IG337Info pp:ppList){
			if(StringUtils.isNotEmpty(pp.getPpuserid())) {
				idSet.add(pp.getPproleid() + "_" + pp.getPpuserid());
			}
			idSet.add(pp.getPproleid() + "_");
			IG337TB processParticipant = (IG337TB)SerializationUtils.clone(pp);
			processParticipant.setPpinittime(IGStringUtils.getCurrentDateTime());
			processParticipant.setPpproctime(null);
			processParticipant.setPbdid(null);
			this.updateProcessParticipant(processParticipant);
		}
		
		//如果流程回退到发起节点,只更新原来发起者信息，不再添加默认参与者  wangtingzhi 20130124
		if("Z".equals(psd.getPsdcode())){
			return null;
		}
		
		//模版
		IG337TB participant_temp = this.getProcessParticipantTBInstance();
		participant_temp.setPrid(prid);
		participant_temp.setPpinittime(IGStringUtils.getCurrentDateTime());
		participant_temp.setPpstatus(workFlowDefinitionBL.searchProcessStatusDefByKey(psdid).getPsdcode());
		participant_temp.setPsdid(psdid);
		participant_temp.setPsdnum(psdnum);
		participant_temp.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
		
		//参与者增加
		List<IG337Info> participantList= new ArrayList<IG337Info>();
		//添加并行节点参与者,roleids中有不为空id则为动态分派的
		if(IGPRDCONSTANTS.MODE_OA.equals(psd.getPsdmode())) {
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(psd.getPsdassign())){
				if(IGPRDCONSTANTS.ASSIGN_NO.equals(psd.getPsdflag())){
					if(ppdList!=null){
						//查询负责人配置角色
						List<Integer> roles_a = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
						if(roles_a==null||roles_a.isEmpty()){
							throw new BLException("IGCO10000.E004","负责人基本");
						}
						//查询值班人配置角色
						List<Integer> roles_b = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
						//查询对应机构的负责人信息
						UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
						List<UserRoleInfo> urList = null;
						for(IG222Info ppd:ppdList){
							if(StringUtils.isNotEmpty(ppd.getOrgid())){
								urcond.setOrgid_like(ppd.getOrgid());
								urcond.setRoleid_in(roles_a);
								urList = userRoleBL.searchUserRoleVW(urcond);
								if(urList == null||urList.isEmpty()){
									throw new BLException("IGCO10000.E004","（"+ ppd.getOrg().getOrgname() + "）负责人基本");
								}else{
									for(UserRoleInfo ur:urList){
										IG337TB ppTB = getProcessParticipantTBInstance();
										ppTB.setPrid(prid);
										ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
										ppTB.setPpstatus(psd.getPsdcode());
										ppTB.setPsdid(psdid);
										ppTB.setPsdnum(psdnum);
										ppTB.setPproleid(ur.getRoleid());
										ppTB.setPprolename(ur.getRolename());
										ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
										ppTB.setPpuserid(ur.getUserid());
										ppTB.setPpusername(ur.getUsername());
										ppTB.setPporgid(ppd.getOrgid());
										ppTB.setPporgname(ppd.getOrg().getOrgname());
										ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
										if(StringUtils.isNotEmpty(ppd.getPpdsuper())) {
											ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
										}
										participantList.add(ppTB);
									}
								}
								if(roles_b != null&&!roles_b.isEmpty()){
									urcond.setRoleid_in(roles_b);
									urList = userRoleBL.searchUserRoleVW(urcond);
									if(urList!=null){
										for(UserRoleInfo ur:urList){
											IG337TB ppTB = getProcessParticipantTBInstance();
											ppTB.setPrid(prid);
											ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
											ppTB.setPpstatus(psd.getPsdcode());
											ppTB.setPsdid(psdid);
											ppTB.setPsdnum(psdnum);
											ppTB.setPproleid(ur.getRoleid());
											ppTB.setPprolename(ur.getRolename());
											ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
											ppTB.setPpuserid(ur.getUserid());
											ppTB.setPpusername(ur.getUsername());
											ppTB.setPporgid(ppd.getOrgid());
											ppTB.setPporgname(ppd.getOrg().getOrgname());
											ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
											if(StringUtils.isNotEmpty(ppd.getPpdsuper())) {
												ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
											}
											participantList.add(ppTB);
										}
									}
								}
							}
						}
					}
				}
			}else{
				if(!ppdList.isEmpty() && (participants == null || participants.size() == 0)){//非前台页面分派的
					//设定默认参与者
					for(IG222Info ppd : ppdList) {
						if(idSet.contains(ppd.getRoleid() + "_")) {
							continue;
						}
						idSet.add(ppd.getRoleid() + "_");
						if(participants == null) {
							participants = new LinkedHashMap<Integer, List<String>>();
						}
						participants.put(ppd.getRoleid(), null);//OA模式只需要角色
					}
				}
				
				UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
				List<UserInfo> uilist = null;
				if(participants != null) {
					Set<Map.Entry<Integer, List<String>>> set = participants.entrySet();
					if(set.size() > 0) {
						Map.Entry<Integer, List<String>> entry = null;
						Role role = null;
						for(Iterator<Map.Entry<Integer, List<String>>> iter = set.iterator();iter.hasNext();){
							entry = iter.next();
							role = this.roleBL.searchRoleByKey(entry.getKey());
							cond.setRoleida(role.getRoleid());
							//如果是OA模式，则将值班人和角色负责人做为参与者
							uilist = this.userBL.searchUserInfo(cond);
							//角色负责人存在标识
							boolean flag = true;
							for(UserInfo info : uilist) {
								//是否角色负责人
								if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
									flag = false;
									IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
									newParticipantTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
									newParticipantTB.setPpuserid(info.getUserida());
									newParticipantTB.setPpusername(info.getUsername());
									newParticipantTB.setPporgid(info.getOrgida());
									newParticipantTB.setPporgname(info.getOrgname());
									if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
											&& role.getRoleid().toString().equals(ppsuper)) {
										newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
									}
									newParticipantTB.setPproleid(role.getRoleid());
									newParticipantTB.setPprolename(role.getRolename());
									newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
									participantList.add(newParticipantTB);
								}
								//是否值班人
								if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
									IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
									newParticipantTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
									newParticipantTB.setPpuserid(info.getUserida());
									newParticipantTB.setPpusername(info.getUsername());
									newParticipantTB.setPporgid(info.getOrgida());
									newParticipantTB.setPporgname(info.getOrgname());
									if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
											&& role.getRoleid().toString().equals(ppsuper)) {
										newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
									}
									newParticipantTB.setPproleid(role.getRoleid());
									newParticipantTB.setPprolename(role.getRolename());
									newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
									participantList.add(newParticipantTB);
								}
							}
							
							if(flag) {
								throw new BLException("IGCO10000.E004","角色（"+ role.getRolename() + "）负责人基本");
							}
						}
					}
				}
			}
		} else {
			if(participants != null){
				//当分派时没选择人，在定义时指定了人，则将该人保存
				for(IG222Info ppd : ppdList) {
					if(StringUtils.isNotEmpty(ppd.getUserid())) {
						if(participants.containsKey(ppd.getRoleid())) {
							 if(participants.get(ppd.getRoleid()) == null) {
								 participants.put(ppd.getRoleid(), new ArrayList<String>());
								 participants.get(ppd.getRoleid()).add(ppd.getUserid());
							 } else if(participants.get(ppd.getRoleid()).isEmpty()) {
								 participants.get(ppd.getRoleid()).add(ppd.getUserid());
							 }
						}
					}
				}
				Set<Map.Entry<Integer, List<String>>> set = participants.entrySet();
				if(set.size() > 0) {
					Map.Entry<Integer, List<String>> entry = null;
					User participant = null;
					Role role = null;
					for(Iterator<Map.Entry<Integer, List<String>>> iter = set.iterator();iter.hasNext();){
						entry = iter.next();
						role = this.roleBL.searchRoleByKey(entry.getKey());
						if(entry.getValue() == null || entry.getValue().isEmpty()) {
							if(idSet.contains(role.getRoleid() + "_")) {
								continue;
							}
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
							if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
									&& role.getRoleid().toString().equals(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							newParticipantTB.setPproleid(role.getRoleid());
							newParticipantTB.setPprolename(role.getRolename());
							idSet.add(newParticipantTB.getPproleid() + "_");
							participantList.add(newParticipantTB);
						} else {
							for(String userid : entry.getValue()) {
								if(idSet.contains(role.getRoleid() + "_" + userid)) {
									continue;
								}
								participant = this.userBL.searchUserByKey(userid);
								IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
								if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
										&& role.getRoleid().toString().equals(ppsuper)) {
									newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
								}
								newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
								newParticipantTB.setPproleid(role.getRoleid());
								newParticipantTB.setPprolename(role.getRolename());
								newParticipantTB.setPpuserid(userid);
								newParticipantTB.setPpusername(participant.getUsername());
								newParticipantTB.setPporgid(participant.getOrgid());
								newParticipantTB.setPporgname(participant.getOrgname());
								idSet.add(newParticipantTB.getPproleid() + "_" + userid);
								idSet.add(newParticipantTB.getPproleid() + "_");
								participantList.add(newParticipantTB);
							}
						}
					}
				}
			}
			if(!ppdList.isEmpty() && (participants == null || participants.size() == 0)){//非前台页面分派的
				//设定默认参与者
				for(IG222Info ppd : ppdList) {
					if(idSet.contains(ppd.getRoleid() + "_" + (ppd.getUserid() == null ? "" : ppd.getUserid()))) {
						continue;
					}
					IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(participant_temp);
					newParticipantTB.setPproleid(ppd.getRoleid());
					newParticipantTB.setPprolename(ppd.getRole().getRolename());
					if(StringUtils.isNotEmpty(ppd.getUserid())){
						newParticipantTB.setPpuserid(ppd.getUserid());
						newParticipantTB.setPpusername(ppd.getUser().getUsername());
						newParticipantTB.setPporgid(ppd.getUser().getOrgid());
						newParticipantTB.setPporgname(ppd.getUser().getOrgname());
						newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					}
					if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(psd.getPsdtype())
								&& ppd.getRoleid().toString().equals(ppsuper)) {	
						newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
					}
					idSet.add(newParticipantTB.getPproleid() + "_" + (ppd.getUserid() == null ? "" : ppd.getUserid()));
					participantList.add(newParticipantTB);
				}
			}
		}
		//添加参与者
		for(IG337Info pp : participantList) {
			this.addProcessParticipant(pp,user,roleid,
					"添加：" + pp.getPprolename()
					+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
					IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE,
					null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, pbdid, prstatus);
		}
		

		return participantList;
	}
	
	/**
	 * <p>
	 * Description: 添加参与者
	 * </p>
	 * 
	 * @param dto IGPRR01DTO
	 * @return IGPRR01DTO
	 * @throws BLException
	 * @update   
	 */
	public void addParticipant(User user,Integer prid, String pdid, String psdid,
			String executorRoleid, String executorUserid, String ppsuper,User authorizeuser, String pbdid, String prstatus
			) throws BLException {
		Integer psdnum = null;
		String npsdid = "";
		if (psdid.indexOf("_") > -1) {
			npsdid = psdid.split("_")[0];
			psdnum = Integer.parseInt(psdid.split("_")[1]);
		} else {
			npsdid = psdid;
		}
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(pdid);
//		psdCond.setPsdcode(psdcode);
		psdCond.setPsdid(npsdid);
		List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
		if(lst_ProcessStatusDef.isEmpty()) {
			throw new BLException("IGFLOW0000.E001", "状态（" + psdid + "）");
		} else if(lst_ProcessStatusDef.size() > 1) {
			throw new BLException("IGFLOW0000.E002", "状态（" + psdid + "）");
		}
		String log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ;
		if((pbdid != null &&
				!IGPRDCONSTANTS.PROCESS_NODE_TYPE_DYNAMICBRANCH.equals(lst_ProcessStatusDef.get(0).getPsdtype())
						&&!IGPRDCONSTANTS.PROCESS_NODE_TYPE_CHILDPROCESS.equals(lst_ProcessStatusDef.get(0).getPsdtype())
				&& pbdid.compareTo("10") >= 0)) {
			log_type = IGPRDCONSTANTS.RECORDLOG_TYPE_CL;
		}
		
			//判断参与人类型为机构还是角色
			//参与者为机构的只能是oa模式，所以忽略机构模式判断
			if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(lst_ProcessStatusDef.get(0).getPsdassign())){
				//查询机构信息
				OrganizationSearchCondImpl orgcond = new OrganizationSearchCondImpl();
				orgcond.setOrgsyscoding(executorRoleid);
				List<Organization> orgList = organizationBL.searchOrganization(orgcond);
				if(orgList == null || orgList.size() != 1){
					throw new BLException();
				}
				//查询负责人配置角色
				List<Integer> roles = null; 
				roles = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_A);
				List<IG337Info> ppList = new ArrayList<IG337Info>();
				//查询对应机构的负责人信息
				UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
				urcond.setRoleid_in(roles);
				urcond.setOrgid_like(executorRoleid);
				List<UserRoleInfo> urList = null;
				if(roles == null){
					throw new BLException("IGCO10000.E004","（"+ orgList.get(0).getOrgname() + "）负责人基本");
				}else{
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList!=null){
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = getProcessParticipantTBInstance();
							ppTB.setPrid(prid);
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(executorRoleid);
							ppTB.setPporgname(orgList.get(0).getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							ppTB.setPsdid(npsdid);
							ppTB.setPsdnum(psdnum);
							ppList.add(ppTB);
						}
					}
					if(ppList.size()==0){
						throw new BLException("IGCO10000.E004","（"+ orgList.get(0).getOrgname() + "）负责人基本");
					}
				}
				roles = workFlowDefinitionBL.searchOARoleidByType(IGPRDCONSTANTS.OA_ROLE_B);
				urcond.setRoleid_in(roles);
				if(roles!=null){
					urList = userRoleBL.searchUserRoleVW(urcond);
					if(urList!=null){
						for(UserRoleInfo ur:urList){
							IG337TB ppTB = getProcessParticipantTBInstance();
							ppTB.setPrid(prid);
							ppTB.setPpinittime(IGStringUtils.getCurrentDateTime());
							ppTB.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
							ppTB.setPproleid(ur.getRoleid());
							ppTB.setPprolename(ur.getRolename());
							ppTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
							ppTB.setPpuserid(ur.getUserid());
							ppTB.setPpusername(ur.getUsername());
							ppTB.setPporgid(executorRoleid);
							ppTB.setPporgname(orgList.get(0).getOrgname());
							ppTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								ppTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							ppTB.setPsdid(npsdid);
							ppTB.setPsdnum(psdnum);
							ppList.add(ppTB);
						}
					}
				}
				for(IG337Info pp:ppList){
					addProcessParticipant(pp, user, pp.getPproleid(),
							"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")添加：" + pp.getPprolename()
							+ (StringUtils.isEmpty(pp.getPpusername()) ? "" : "(" + pp.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
							null, log_type, authorizeuser, pbdid, prstatus);
				}
			}else{
				//参与者角色
				Role role = roleBL.searchRoleByKey(Integer.valueOf(executorRoleid));
				IG337TB instance = getProcessParticipantTBInstance();
				instance.setPrid(prid);
				instance.setPpinittime(IGStringUtils.getCurrentDateTime());
				instance.setPpstatus(lst_ProcessStatusDef.get(0).getPsdcode());
				instance.setPproleid(role.getRoleid());
				instance.setPprolename(role.getRolename());
				instance.setPsdid(npsdid);
				instance.setPsdnum(psdnum);
				if(IGPRDCONSTANTS.MODE_OA.equals(lst_ProcessStatusDef.get(0).getPsdmode())) {
					//角色负责人存在标识
					boolean flag = true;
					UserInfoSearchCondImpl cond = new UserInfoSearchCondImpl();
					cond.setRoleida(role.getRoleid());
					List<UserInfo> uilist = this.userBL.searchUserInfo(cond);
					//如果是OA模式，则将值班人和角色负责人做为参与者
					for(UserInfo info : uilist) {
						//是否角色负责人
						if(IGPRDCONSTANTS.ROLEMANAGER.equals(info.getRolemanager())) {
							flag = false;
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(instance);
							newParticipantTB.setPprolemanager(IGPRDCONSTANTS.ROLEMANAGER);
							newParticipantTB.setPpuserid(info.getUserida());
							newParticipantTB.setPpusername(info.getUsername());
							newParticipantTB.setPporgid(info.getOrgida());
							newParticipantTB.setPporgname(info.getOrgname());
							newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							addProcessParticipant(newParticipantTB, user, Integer.valueOf(executorRoleid),
									"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")添加：" + newParticipantTB.getPprolename()
									+ (StringUtils.isEmpty(newParticipantTB.getPpusername()) ? "" : "(" + newParticipantTB.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
									null, log_type, authorizeuser, pbdid, prstatus);
						}
						//是否值班人
						if(IGPRDCONSTANTS.DUTYPERSON.equals(info.getDutyflag())) {
							IG337TB newParticipantTB = (IG337TB)SerializationUtils.clone(instance);
							newParticipantTB.setPpdutyperson(IGPRDCONSTANTS.DUTYPERSON);
							newParticipantTB.setPpuserid(info.getUserida());
							newParticipantTB.setPpusername(info.getUsername());
							newParticipantTB.setPporgid(info.getOrgida());
							newParticipantTB.setPporgname(info.getOrgname());
							newParticipantTB.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
							if(StringUtils.isNotEmpty(ppsuper)) {
								newParticipantTB.setPpsuper(IGPRDCONSTANTS.SUPER_ROLE);
							}
							addProcessParticipant(newParticipantTB, user, Integer.valueOf(executorRoleid),
									"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")添加：" + newParticipantTB.getPprolename()
									+ (StringUtils.isEmpty(newParticipantTB.getPpusername()) ? "" : "(" + newParticipantTB.getPpusername() + ")"),
									IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
									null, log_type, authorizeuser, pbdid, npsdid);
						}
					}
					
					if(flag) {
						throw new BLException("IGCO10000.E004","角色（"+ role.getRolename() + "）负责人基本");
					}
				} else {
					if(StringUtils.isEmpty(executorUserid)) {
						instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_ROLE);
					} else {
						//处理用户
						User executor = userBL.searchUserByKey(executorUserid);
						instance.setPpuserid(executor.getUserid());
						instance.setPpusername(executor.getUsername());
						instance.setPporgid(executor.getOrgid());
						instance.setPporgname(executor.getOrgname());
						instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					}
					addProcessParticipant(instance, user, Integer.valueOf(executorRoleid),
							"(" + lst_ProcessStatusDef.get(0).getPsdname() + ")添加：" + instance.getPprolename()
							+ (StringUtils.isEmpty(instance.getPpusername()) ? "" : "(" + instance.getPpusername() + ")"),
							IGPRDCONSTANTS.PPD_ADD_PROCESSPARTICIPANT_MESSAGE, 
							null, log_type, authorizeuser, pbdid, prstatus);
				}
			
			}
		
	}
	
	/**
	 * 更新流程状态，触发流程事件处理
	 * 
	 * @param srcStatus 流程跃迁时状态，即源状态
	 * @param processRecord 流程信息
	 * @param user 当前登录用户
	 * @param roleid 处理角色ID
	 * @param comment 日志内容
	 * @param desc 日志操作描述信息
	 * @param filemap 附件
	 * @param authorizeuser 授权人用户信息
	 * @param pbdid 处理按钮ID
	 * @return 流程信息
	 * @throws BLException
	 */
	private String processStatusTransition(String fpsdid, String tpsdid, IG500Info processRecord, 
			User user, Integer roleid,String nodeType,
			Map<Integer, List<String>> participants, String ppsuper, User authorizeuser, String pbdid) throws BLException {
		
		//源状态
		IG333Info fpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(fpsdid);
		
		//跃迁状态
		IG333Info tpsd = workFlowDefinitionBL.searchProcessStatusDefByKey(tpsdid.indexOf("_") > -1 ? tpsdid.split("_")[0] : tpsdid);
		
		//非结束状态
		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode())) {
			//增加参与者
			this.addParticipants(tpsdid , user, processRecord.getPrid(), roleid, "",nodeType,
					participants, ppsuper, authorizeuser, pbdid, fpsd.getPsdid());
			
		}
		
//		//触发流程后处理事件
//		this.processAfterTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid);
		
//		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
//		IG500Info prinfo = ig500BL.searchIG500InfoByKey(processRecord.getPrid());
//		IG500TB prtb = (IG500TB)SerializationUtils.clone(processRecord);
//		prtb.setPrserialnum(prinfo.getPrserialnum());
//		processRecord = prtb;
//		prinfo = null;
//		// <<<<<<<<<<<<<<<<< update by yangyining 20131028
		
		// 记录日志
		addRecordLog(processRecord.getPrid(), user, roleid, "", 
				IGPRDCONSTANTS.COMMENT_TRANSITION_MESSAGE + tpsd.getPsdname(), null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, pbdid, fpsd.getPsdid());
		
//		//更新流程状态
//		this.updateProcessRecord(fpsd.getPsdcode(), processRecord,
//				user,roleid, "", IGPRDCONSTANTS.COMMENT_TRANSITION_MESSAGE + tpsd.getPsdname(),
//				null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, authorizeuser, pbdid);

//		//流程状态类型判断：0开始，1普通，2结束
//		int statustype = WorkFlowConstDefine.STATUSTYPE_NORMAL;
//		
//		//process0001_begin
//		//如果是新发起的流程，流程状态日志应为空，否则为被打回流程
//		if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(fpsd.getPsdcode()) && searchRecordStatusLog(processRecord.getPrid()).isEmpty()) {
//		//process0001_end
//			statustype = WorkFlowConstDefine.STATUSTYPE_BEGIN;
//		} else if((IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode()))) {
//			statustype = WorkFlowConstDefine.STATUSTYPE_END;
//		}
//		
//		//添加流程状态日志
//		this.addRecordStatusLog(processRecord.getPrid(), fpsd.getPdid(), processRecord.getPrtype(), 
//				fpsd.getPsdcode(), tpsd.getPsdcode(), statustype);
		//非结束状态
//		if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(tpsd.getPsdcode())) {
//			
//			//前处理
//			this.prInfoPretreatment(tpsdid, processRecord.getPrid(), processRecord.getPrrolename(),user,roleid, pbdid);
//			
//		}
//		//触发流程前处理事件
//		this.processPreTreatmentExecute(processRecord, fpsd, tpsd, user, roleid, authorizeuser, pbdid);
//		//触发流程多线程任务
//		this.processThreadTreatmentExecute(processRecord, fpsd, tpsd, user, roleid);
//		
//		//获取下一状态参与者
//		List<IG337Info> ppList = this.searchProcessParticipant(processRecord.getPrid(), 
//				tpsd.getPsdcode());
//		List<String> lst_Userid = new ArrayList<String>();
//		List<Integer> lst_Roleid = new ArrayList<Integer>();
//		if(!ppList.isEmpty()) {
//			for(IG337Info pp:ppList){
//				if(StringUtils.isEmpty(pp.getPpuserid())) {
//					lst_Roleid.add(pp.getPproleid());
//				} else {
//					lst_Userid.add(pp.getPpuserid());
//				}
//			}
//			sendMessage(tpsd.getPsdid(), lst_Userid, null, lst_Roleid, null, null, processRecord);
//		}
		
		return tpsd.getPsdid();
	}
	
	/**
	 * 发送通知
	 * @param status 状态标识
	 * @param lst_Userid 用户ID列表
	 * @param sms 短信内容
	 * @param lst_Roleid 角色ID列表
	 * @param title 标题
	 * @param content 邮件内容
	 * @param ig500 流程信息
	 * @throws BLException
	 */
	public void sendMessage(String status, List<String> lst_Userid, String sms,
			List<Integer> lst_Roleid, String title, String content, IG500Info ig500) throws BLException {
		//查询策略
		IG212Info instance = this.ig212BL.searchIG212InfoByPK(
				new IG212PK(status, IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO));
		if(instance != null) {
			//取得通知的短信模板内容
			List<String> lstMessage = getSendMessage();
			//保存需要替换的参数
			List<String> argStr = null;
			//取得替换模板的参数
			argStr = new ArrayList<String>();
			//查询状态名称
			
			List<String> list = searchCurrentRecordStatus(ig500.getPrid());
			
			StringBuffer currentStatusNames = new StringBuffer();
			for(int i=0;i<list.size();i++){
				if(i > 0){
					currentStatusNames.append(",");
				}
				IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(list.get(i));
				currentStatusNames.append(psd.getPsdname());
			}
			//指定替换的状态名称
			argStr.add(currentStatusNames.toString());
			//指定替换的工单号
			argStr.add(ig500.getPrserialnum());
			//指定替换的工单名称
			argStr.add(ig500.getPrtitle());
			//邮件中添加平台URL
//			argStr.add(ResourceUtility.getString("HOME_URL"));
			
			//取得替换参数后的通知内容
			if(StringUtils.isEmpty(sms)) {
				sms = replaceMessage(lstMessage.get(0),argStr);
			}
			//取得替换参数后的通知内容
			if(StringUtils.isEmpty(title)) {
				title = replaceMessage(lstMessage.get(1),argStr);
			}
			if(StringUtils.isEmpty(content)) {
				content = replaceMessage(lstMessage.get(2),argStr);
			}
			
			//通知内容事件取得
			//取得流程定义
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(ig500.getPrpdid());
			if(StringUtils.isNotEmpty(pd.getMessagegenerator())){
				 igflowlog.debug("========================"
		                    + ig500.getPrserialnum()
		                    + "前处理事件开始========================");
				    igflowlog.debug("流程类型名称：" + ig500.getPrpdname());
				    igflowlog.debug("流程类型ID：" + ig500.getPrpdid());
				    igflowlog.debug("流程ID：" + ig500.getPrid());
				    WorkFlowMessageGeneratorBL bl = (WorkFlowMessageGeneratorBL)WebApplicationSupport.getBean(pd.getMessagegenerator());
				    //执行初始化方法
				    bl.init(ig500.getPrid(),currentStatusNames.toString());
				    //取得标题信息
				    String ctitle = bl.titleGenerator();
				    if(StringUtils.isNotEmpty(ctitle)){
				    	title = ctitle;
				    }
				    //邮件内容取得
				    String ccontent = bl.contentGenerator();
				    if(StringUtils.isNotEmpty(ccontent)){
				    	content = ccontent;
				    }
				    //短信内容取得
				    String csms = bl.smsGenerator();
				    if(StringUtils.isNotEmpty(csms)){
				    	sms = csms;
				    }
				    igflowlog.debug("========================"
		                    + ig500.getPrserialnum()
		                    + "前处理事件结束========================");
			}
			//发送短信
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_SMS.equals(instance.getSms())) {
				//用户
				if(lst_Userid != null) {
					for(String userid : lst_Userid) {
						this.sendMessageBL.sendSmsToUser(userid, sms);
					}
				}
				//角色
				if(lst_Roleid != null) {
					for(Integer roleid : lst_Roleid) {
						this.sendMessageBL.sendSmsToRole(roleid, sms);
					}
				}
			}
			//发送邮件
			if(IGPRDCONSTANTS.STRATEGY_NOTICE_MODE_EMAIL.equals(instance.getEmail())) {
				//用户
				if(lst_Userid != null) {
					//用户
					for(String userid : lst_Userid) {
						//取得发送人的邮件地址
						User sendUser = userBL.searchUserByKey(userid);
						if(sendUser.getUseremail() != null && sendUser.getUseremail().length() > 0){
							//发送邮件
							String[] address = new String[1];
							address[0] = sendUser.getUseremail();
							this.sendMailBL.sendMail(title, content, address);
						}else{
							log.debug("用户【"+sendUser.getUsername()+"】的邮箱没有配置,无法发送邮件通知！");
						}
					}
				}
				//角色
				if(lst_Roleid != null) {
					//取得发送角色的负责人
					UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
					cond.setRolemanager(true);
					for(Integer roleid : lst_Roleid) {
						cond.setRoleid(roleid);
						List<UserRoleInfo> userRole = userRoleBL.searchUserRoleVW(cond);
						for(UserRoleInfo info: userRole){
							User sendUser = userBL.searchUserByKey(info.getUserid());
							if(sendUser.getUseremail() != null && sendUser.getUseremail().length() > 0){
								String[] address = new String[1];
								address[0] = sendUser.getUseremail();
								this.sendMailBL.sendMail(title, content, address);
							}else{
								log.debug("用户【"+sendUser.getUsername()+"】的邮箱没有配置,无法发送邮件通知！");
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 流程触发后处理事件
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid处理角色ID
	 * @param authorizeuser授权人用户信息
	 * @param pbdid 处理按钮ID
	 */
	public void processAfterTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) throws BLException {
		//自定义事件处理BL
		WorkFlowEventHandlerBL bl = null;
		//获取源状态后处理事件列表
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPdid(processRecord.getPrpdid());//流程定义ID
		cond.setPsdid(fpsd.getPsdid());//源状态ID
		cond.setPedtype(IGPRDCONSTANTS.AFTERTREATMENT);//后处理类型
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if (pedList.size() > 0 ) {
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "后处理事件开始========================");
		    igflowlog.debug("流程类型名称：" + processRecord.getPrpdname());
		    igflowlog.debug("流程类型ID：" + processRecord.getPrpdid());
            igflowlog.debug("流程ID：" + processRecord.getPrid());
            igflowlog.debug("流程源状态：" + fpsd.getPsdname()+ "("+fpsd.getPsdid()+")");
            igflowlog.debug("流程跃迁状态：" + tpsd.getPsdname()+ "("+tpsd.getPsdid()+")");
            igflowlog.debug("操作用户ID：" + user.getUserid());
            igflowlog.debug("处理角色ID：" + roleid);
            igflowlog.debug("授权人ID：" + (authorizeuser == null ? "" : authorizeuser.getUserid()));
            igflowlog.debug("处理按钮ID：" + pbdid);
		    for(IG413Info ped : pedList) {
	            try {
	                bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
	            } catch (Exception e) {
	                throw new BLException("IGCO10000.E004", "后处理事件定义");
	            }
	            igflowlog.debug("调用BL" + ped.getPedorder()+":"+ ped.getPedblid());
	            bl.afterTreatmentExecute(initWorkFlowStatusEventBean(processRecord, fpsd, tpsd, user, roleid,
	                    authorizeuser, pbdid,psdnum));
	        }
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "后处理事件结束========================");
		}
		
	}
	
	/**
	 * 流程触发前处理事件
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid处理角色ID
	 * @param authorizeuser授权人用户信息
	 * @param pbdid 处理按钮ID
	 */
	public void processPreTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) throws BLException {
		//自定义事件处理BL
		WorkFlowEventHandlerBL bl = null;
		//获取跃迁状态前处理事件列表
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPsdid(tpsd.getPsdid());//跃迁状态ID
		cond.setPedtype(IGPRDCONSTANTS.PRETREATMENT);//前处理类型
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		if (pedList.size() > 0 ) {
		    igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "前处理事件开始========================");
		    igflowlog.debug("流程类型名称：" + processRecord.getPrpdname());
		    igflowlog.debug("流程类型ID：" + processRecord.getPrpdid());
		    igflowlog.debug("流程ID：" + processRecord.getPrid());
            igflowlog.debug("流程源状态：" + fpsd.getPsdname() + "("+fpsd.getPsdid()+")");
            igflowlog.debug("流程跃迁状态：" + tpsd.getPsdname()+ "("+tpsd.getPsdid()+")");
            igflowlog.debug("操作用户ID：" + user.getUserid());
            igflowlog.debug("处理角色ID：" + roleid);
            igflowlog.debug("授权人ID：" + (authorizeuser == null ? "" : authorizeuser.getUserid()));
            igflowlog.debug("处理按钮ID：" + pbdid);
    		for(IG413Info ped : pedList) {
    			try {
    				bl = (WorkFlowEventHandlerBL)WebApplicationSupport.getBean(ped.getPedblid());
    			} catch (Exception e) {
    				throw new BLException("IGCO10000.E004", "前处理事件定义");
    			}
    			igflowlog.debug("调用BL"+ ped.getPedorder()+":" + ped.getPedblid());
    			bl.preTreatmentExecute(initWorkFlowStatusEventBean(processRecord, fpsd, tpsd, user, roleid,
    					authorizeuser, pbdid,psdnum));
    		}
    		igflowlog.debug("========================"
                    + processRecord.getPrserialnum()
                    + "前处理事件结束========================");
		}
	}
	
	/**
	 * 初始化前后处理参数定义
	 * 
	 * @param processRecord 流程信息
	 * @param fpsd 流程源状态信息
	 * @param tpsd 流程跃迁状态信息
	 * @param user 登录用户信息
	 * @param roleid 操作角色ID
	 * @param authorizeuser 授权人用户信息
	 * @param pbdid 处理按钮ID
	 * @return 前后处理参数定义
	 */
	private WorkFlowStatusEventBeanInfo initWorkFlowStatusEventBean(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid, User authorizeuser, String pbdid,Integer psdnum) {
		///自定义流程改造，状态code码将不会有实际意义，根据状态查询参与人将由状态定义ID代替
		///status 原为状态code吗，如今该为状态定义ID
		///wangtingzhi 20140513
		//前后处理参数信息
		WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPdid(processRecord.getPrpdid());
		bean.setPbdid(pbdid);
//		bean.setBfstatus(fpsd.getPsdcode());
//		bean.setAfstatus(tpsd.getPsdcode());
		bean.setBfstatus(fpsd.getPsdid());
		bean.setAfstatus(tpsd.getPsdid());
		bean.setCrtroleid(processRecord.getPrroleid());
		bean.setCrtuserid(processRecord.getPruserid());
		bean.setPsdnum(psdnum);
		//日志参数信息
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(processRecord.getPrid());
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(roleid);
		if(authorizeuser != null) {
			logInfo.setAuthuserid(authorizeuser.getUserid());
		}
		bean.setLogInfo(logInfo);
		return bean;
	}
	
	/**
	 * 流程触发前处理事件
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid处理角色ID
	 * @param authorizeuser授权人用户信息
	 */
	public void processStatusButtonTreatmentExecute(WorkFlowStatusEventBean bean) throws BLException {
		//自定义事件处理BL
		WorkFlowStatusButtonHandlerBL bl = null;
		
		//获取跃迁状态前处理事件列表
		IG156SearchCondImpl cond = new IG156SearchCondImpl();
		cond.setPsdid(bean.getBfstatus());
		cond.setPsebuttonid(bean.getPbdid());
		List<IG156Info> psbList = workFlowDefinitionBL.searchProcessStatusButtonDef(cond);
		for(IG156Info info : psbList) {
			try {
				bl = (WorkFlowStatusButtonHandlerBL)WebApplicationSupport.getBean(info.getPseactionid());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004","按钮事件定义");
			}
			igflowlog.debug("========================调用按钮事件开始========================");
            igflowlog.debug("流程ID：" + bean.getLogInfo().getPrid());
            igflowlog.debug("流程状态标识：" + bean.getBfstatus());
            igflowlog.debug("处理按钮ID：" + bean.getPbdid());
            igflowlog.debug("操作用户ID：" + bean.getLogInfo().getExecutorid());
            igflowlog.debug("处理角色ID：" + bean.getLogInfo().getExecutorRoleid());
            igflowlog.debug("调用BL：" + info.getPseactionid());
			bl.statusButtonTreatmentExecute(bean);
			igflowlog.debug("========================调用按钮事件结束========================");
		}
	}
	
	/**
	 * 流程多线程任务处理
	 * 
	 * @param processRecord流程信息
	 * @param fpsd流程源状态信息
	 * @param tpsd流程跃迁状态信息
	 * @param user登录用户信息
	 * @param roleid操作角色ID
	 */
	public void processThreadTreatmentExecute(IG500Info processRecord, IG333Info fpsd, 
			IG333Info tpsd, User user, Integer roleid) throws BLException {
		//自定义事件处理BL
		WorkFlowThreadEventHandlerBLImpl bl = null;
		
		//获取跃迁状态前处理事件列表
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPsdid(tpsd.getPsdid());//跃迁状态ID
		cond.setPedtype(IGPRDCONSTANTS.THREADTREATMENT);//多线程类型
		List<IG413Info> pedList = workFlowDefinitionBL.searchWorkFlowEventHandler(cond);
		for(IG413Info ped : pedList) {
			try {
				bl = (WorkFlowThreadEventHandlerBLImpl)WebApplicationSupport.getBean(ped.getPedblid());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004","多线程任务定义");
			}
			bl.init(processRecord, fpsd, tpsd, user, roleid);
			//触发多线程任务
			Thread thread = new Thread(bl);
			thread.start();
		}
	}
	
	/**
	 * 流程跳转JSP取得
	 * 
	 * @param pdid流程定义ID
	 * @param prid流程ID
	 * @param pjdtype页面类型
	 * @param user登录用户信息
	 */
	public String searchForwardJsp(String pdid, Integer prid, String pjdtype, User user) throws BLException {
		String forward = null;
		//获取指定流程JSP定义信息
		IG126SearchCondImpl cond = new IG126SearchCondImpl();
		cond.setPdid(pdid);
		cond.setPjdtype(pjdtype);
		List<IG126Info> pjdList = workFlowDefinitionBL.searchProcessJspDef(cond);
		if(pjdList.size() > 0) {
			//自定义跳转BL定义不存在，则转至PJDURL定义页面，否则通过BL获取JSP路径
			if(StringUtils.isEmpty(pjdList.get(0).getPjdblid())) {
				forward = pjdList.get(0).getPjdurl();
			} else {
				WorkFlowJspHandlerBL bl = null;
				try {
					bl = (WorkFlowJspHandlerBL)WebApplicationSupport.getBean(
							pjdList.get(0).getPjdblid());
				} catch (Exception e) {
					throw new BLException("IGCO10000.E004","流程页面定义");
				}
				igflowlog.debug("========================取得流程跳转JSP事件开始========================");
	            igflowlog.debug("流程类型ID:" + pdid);
	            igflowlog.debug("流程ID:" + prid);
	            igflowlog.debug("页面类型:" + pjdtype);
	            igflowlog.debug("用户ID:" + user.getUserid());
	            igflowlog.debug("调用BL:" + pjdList.get(0).getPjdblid());
				forward = bl.forwardExecute(pdid, prid, pjdtype, user);
				igflowlog.debug("流程跳转JSP:" + forward);
				igflowlog.debug("========================取得流程跳转JSP事件结束========================");
			}
		} else {
			//当流程类型为监管表报时，跳转到监控表报定制页
			String first = pdid.substring(0, 1);
			if("1".equals(first) || "2".equals(first) || "3".equals(first)) {
				forward = "/smr/IGSMR0401.jsp";
			}
		}
		return forward;
	}
	
	/**
	 * 根据用户角色查找角色日志
	 * 
	 * @param RecordLogSearchCond流程定义ID
	 */
	public List<IG036Info> searchUserRoleRecondLog(IG036SearchCond cond){
		return ig036BL.searchIG036InfoByCond(cond);
	}
	
	/**
	 * 获取流程参与者变量权限
	 * @param psdid流程状态ID
	 * @param roleid流程参与者角色ID
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchParticipantVariableVW(String psdid , Integer roleid) {
		IG893SearchCondImpl cond = new IG893SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setRoleid(roleid);
		return ig893BL.searchIG893Info(cond);
	}
	
	private Map<String, IG893Info> getParticipantVariabelMap(List<IG893Info> participantVariabelList){
		Map<String, IG893Info> participantVariabelMap = null;
		participantVariabelMap = new HashMap<String, IG893Info>();
		if(participantVariabelList != null && participantVariabelList.size() > 0){
			for(IG893Info pi:participantVariabelList){
				participantVariabelMap.put(pi.getPidid(), pi);
			}
		}
		return participantVariabelMap;
	}
	
	/**
	 * 获取流程参与者最大权限
	 * @param psdid流程状态ID
	 * @param roleid流程参与者角色ID
	 * @return 流程参与者变量权限列表
	 */
	public List<IG893Info> searchParticipantMaxVariableVW(String psdid , Integer roleid,Map<IG333Info, List<IG337Info>> ls_proStatusParticipantMap) {
		Map<String, IG893Info> participantVariabelMap = null;
		if(roleid!=null&&roleid>0){
			List<IG893Info> temp = searchParticipantVariableVW(psdid,roleid);
			participantVariabelMap = getParticipantVariabelMap(temp);
		}
		if(ls_proStatusParticipantMap != null){
			Set<Entry<IG333Info,List<IG337Info>>> set = ls_proStatusParticipantMap.entrySet();
			for(Iterator<Entry<IG333Info, List<IG337Info>>> iter = set.iterator();iter.hasNext();){
				Entry<IG333Info, List<IG337Info>> entry = iter.next();
				IG333Info psd = entry.getKey();
				List<IG337Info> list = entry.getValue();
				if(list != null){
					for(IG337Info pp:list){
						List<IG893Info> temp = searchParticipantVariableVW(psd.getPsdid(),pp.getPproleid());
						if(participantVariabelMap == null){
							participantVariabelMap = getParticipantVariabelMap(temp);
						}else{
							Map<String, IG893Info> variabelMap = getParticipantVariabelMap(temp);
							Set<Entry<String, IG893Info>> varSet = variabelMap.entrySet();
							for(Iterator<Entry<String, IG893Info>> varIter = varSet.iterator();varIter.hasNext();){
								Entry<String, IG893Info> varEntry = varIter.next();
								IG893Info cinfo = varEntry.getValue();
								IG893Info rinfo = participantVariabelMap.get(cinfo.getPidid());
								if(rinfo == null){
									participantVariabelMap.put(cinfo.getPidid(), cinfo);
								}else{
									if(Integer.valueOf(cinfo.getPidaccess())>Integer.valueOf(rinfo.getPidaccess())){
										participantVariabelMap.put(cinfo.getPidid(), cinfo);
									}
								}
							}
						}
					}
				}
			}
		}
		List<IG893Info> participantVariableVWList = new ArrayList<IG893Info>();
		if(participantVariabelMap != null){
			Set<Entry<String,IG893Info>> set = participantVariabelMap.entrySet();
			for(Iterator<Entry<String, IG893Info>> iter = set.iterator();iter.hasNext();){
				Entry<String, IG893Info> entry = iter.next();
				IG893Info value = entry.getValue();
				participantVariableVWList.add(value);
			}
		}
		return participantVariableVWList;
	}
	
	/**
	 * 授予指定角色值班人提交权限
	 * @param prid流程ID
	 * @param roleid流程参与者角色ID
	 * @throws BLException 
	 */
	public void grantDutyPerson(Integer prid , Integer roleid) throws BLException {
		//获取未处理参与者
		List<IG337Info> ppList = this.searchProcessParticipantTodoRole(prid, 
				this.ig500BL.searchIG500InfoByKey(prid).getPrstatus());
		//授权
		for(IG337Info pp : ppList) {
			//未处理指定角色值班人
			if(pp.getPproleid().equals(roleid) &&
					IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson()) 
					&& !IGPRDCONSTANTS.DUTYPERSON_ACCESS.equals(pp.getPpsubstatus())) {
				IG337TB ppTB = (IG337TB)SerializationUtils.clone(pp);
				ppTB.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);
				this.ig337BL.updateIG337Info(ppTB);
			}
		}
	}
	//文本域绑定附件上传并返回附件ID
	public IG599Info addProcessInfo(Map<Integer, FormFile> filemap) throws BLException {
		IG599TB processInfo = this.getProcessInfoTBInstance();
		String attkey = fileUploadBL.uploadFile(filemap);
		processInfo.setPiattkey(attkey);
		
		return processInfo;
	}
	public void addProcessInfoAtt(Map<Integer, FormFile> filemap,String attkey) throws BLException {
//		ProcessInfoTB processInfo = this.getProcessInfoTBInstance();
//		String attkey = 
			fileUploadBL.uploadFile(filemap,attkey);
//		processInfo.setPiattkey(attkey);
		
//		return processInfo;
	}
	public IG599Info updateProcessInfo(Map<Integer, FormFile> filemap,IG599Info pi) throws BLException {
		IG599TB processInfo = this.getProcessInfoTBInstance();
		String attkey = fileUploadBL.uploadFile(filemap);
		processInfo.setPiattkey(attkey);
		processInfo.setFingerPrint(pi.getFingerPrint());
		processInfo.setPidid(pi.getPidid());
		processInfo.setPiid(pi.getPiid());
		processInfo.setPivarlabel(pi.getPivarlabel());
		processInfo.setPivarname(pi.getPivarname());
		processInfo.setPivartype(pi.getPivartype());
		processInfo.setPivarvalue(pi.getPivarvalue());
		processInfo.setPrid(pi.getPrid());
		
		return processInfo;
	}
	
	
	/**
	 * 发起流程,增加了与文本域绑定的附件上传功能,属于该方法的重载
	 * 
	 * @param processRecord 流程记录内容
	 * @param user	        用户
	 * @param roleid		角色ID
	 * @param filemap		附件map
	 * @param pts           流程类型
	 * @param prInfoList	流程变量信息
	 * @param rlcomment	    日志信息
	 * @param psdid	        流程状态ID
	 * @param action	    动作标识
	 * @param authorizeuser	授权人用户信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	public IG500Info launchProcess(IG500Info processRecord,
			User user, Integer roleid, Map<Integer, FormFile> filemap,Map<String, FormFile> filemapMuti,
			String pts,List<IG599Info> prInfoList, String rlcomment,String psdid,
			String action,Map<String,List<Attachment>> copyMap, User authorizeuser,
			Map<Integer, String> processInfoEntityMap,Map<String, Object> tableFormValueMap,
			Map<String, List<IG506TB>> participantFormValueMap,String isServiceStart,Integer parprid)
			throws BLException {

		// 获取当前流程状态
		IG333Info psdInfo = this.workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
		IG380Info pd = this.workFlowDefinitionBL.searchProcessDefinitionByKey(processRecord.getPrpdid());
		IG259Info pt = this.workFlowDefinitionBL.searchProcessTemplateByKey(pd.getPtid());
		
		/**   增加一条流程的记录  start**/
		// 流程记录
		IG500TB processRecordTB = this.getProcessRecordTBInstance();
		this.copyProperties(processRecordTB, processRecord);
		String datetime = IGStringUtils.getCurrentDateTime();
		processRecordTB.setPrstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		processRecordTB.setPropentime(datetime);
		
		processRecordTB.setPruserid(user.getUserid());
		processRecordTB.setPrusername(user.getUsername());
		processRecordTB.setProrgid(user.getOrgid());
		processRecordTB.setProrgname(user.getOrgname());
		processRecordTB.setPrtype(pt.getPttype());
		
		//判断发起流程类型
		if(StringUtils.isNotEmpty(pts)){
			processRecordTB.setPrtype(pts);
		}else{
			processRecordTB.setPrtype(IGPRDCONSTANTS.SELF_DEFINING_WORK_PRTYPE);
		}
		
		
		IG500Info newProcessRecord = ig500BL.registIG500Info(processRecordTB);
		Integer prid = newProcessRecord.getPrid();// 获得流程记录ID
		

        if(action != null && action.compareTo("10") >= 0){
			//添加日志
			addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
					null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ, action, psdInfo.getPsdid());
        } else {//保存
        	//添加日志
        	addRecordLog(prid, user, roleid, null, IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE,
        			null, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, IGPRDCONSTANTS.BUTTON_SUBMIT, psdInfo.getPsdid());
        }
		//addProcessInfo(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE, filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);

		/**    增加一条流程的记录  end**/
		
		//填写系统日志
		//addRecordLog(prid, user, roleid, processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
		
		// 如果存在授权,日志内容显示出谁代替谁处理
		if (authorizeuser != null) {

			// 如果存在日志内容, 则换行
			if (StringUtils.isNotEmpty(rlcomment)) {
				rlcomment = rlcomment + "<br>" + "【" + user.getUsername()
						+ "】代替【" + authorizeuser.getUsername() + "】处理。";
			} else {
				rlcomment = "【" + user.getUsername() + "】代替【"
						+ authorizeuser.getUsername() + "】处理。";
			}

		}
		
		//填写提交日志
		IG036Info rl = this.addRecordLog(prid, user, roleid, rlcomment, IGPRDCONSTANTS.RLDESC_DATA,filemap,IGPRDCONSTANTS.RECORDLOG_TYPE_CL, action, psdInfo.getPsdid());
		List<IG599Info> processInfoValueList = null;
		if(prInfoList != null && !prInfoList.isEmpty()){
			//记录数据日志
			
			for(IG599Info pi : prInfoList) {
				IG599TB piTB = (IG599TB)pi;
				piTB.setPrid(prid);
				
				//与表单绑定的附件存入processinfo表中.=================================================
				if(filemapMuti != null && !filemapMuti.isEmpty()){
					Map<Integer, FormFile> fileMM=new HashMap<Integer, FormFile>();
					for(Map.Entry entry:filemapMuti.entrySet()){
						if(piTB.getPivarname().equals(entry.getKey().toString().split("_")[0])){
							fileMM.put(Integer.parseInt(entry.getKey().toString().split("_")[1]),
									(FormFile) entry.getValue());
						}
						
					}
					if(StringUtils.isNotEmpty(piTB.getPiattkey())){
						addProcessInfoAtt(fileMM, piTB.getPiattkey());
					}else{
						piTB.setPiattkey(this.addProcessInfo(fileMM).getPiattkey());
					}
				}
				//===============================================================================================
				//流程类表单处理   20130828 wangtingzhi start
				if("5".equals(pi.getPivartype())){
					String value = pi.getPivarvalue();
					piTB.setPivarvalue(getProcessFormValue(prid, value));
				}
				//流程类表单处理   20130828 wangtingzhi end
				if("P".equals(pi.getPivartype())){
					String value = pi.getPivarvalue();
					List<IG506TB> pvList = participantFormValueMap.get(pi.getPidid());
					piTB.setPivarvalue(getParticipantFormValue(prid,pvList,value));
				}
			}
			//更新表单信息
			prInfoList = this.saveOrUpdProcessInfos(prInfoList);
			List<IG599Info> prInfoListU=new ArrayList<IG599Info>();
			if(prInfoList.size()>0&&copyMap!=null){
				for(int i=0;i<prInfoList.size();i++){
					List<Attachment> list = copyMap.get(prInfoList.get(i).getPivarname());
					if(list != null){
//						prInfoListU.add(prInfoList.get(i));
						if(prInfoList.get(i).getPiattkey() != null){
//							for(int j=0;j<list.size();j++){
//							ProcessInfoTB psitb = (ProcessInfoTB)prInfoList.get(i);
							fileUploadBL.copyFile(list, prInfoList.get(i).getPiattkey());
//							prInfoListU.add(psitb);
//							}
						}else{
							IG599TB psitb = (IG599TB)prInfoList.get(i);
							String attkey = fileUploadBL.copyFile(list, prInfoList.get(i).getPiattkey());
							psitb.setPiattkey(attkey);
							prInfoListU.add(psitb);
						}
					}
				}
				processInfoValueList = this.saveOrUpdProcessInfos(prInfoListU);
			}
			
			//增加表单日志
			addRecordLogVarInfo(prInfoList,rl);
			
		}
		
		//流程发起操作，将保存相关资产，保存表格式表单值，保存人员表单值处理移至此处  20130905 wangtingzhi start
		//处理相关资产
		//新增用于状态级私有表单 ig561记录，用于区分不动的资产属于不同的状态 2015年2月13日15:38:44
        Map<String,String> entitySaveMap=null;
		if(processInfoValueList != null && processInfoValueList.size() > 0){
		    entitySaveMap=saveProcessInfoEntity(processInfoValueList,processInfoEntityMap);
		}else{
		    entitySaveMap=saveProcessInfoEntity(prInfoList,processInfoEntityMap);
		}
		//资产默认值处理
		//处理表格式表单值
		if(tableFormValueMap != null && tableFormValueMap.size() > 0){
			String[] column_value = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_VALUE);
			String[] column_pidid = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_PIDID);
			String[] column_rownum = (String[]) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_ROWNUMBER);
			Map<Integer, FormFile> tableFormFileMap = (Map<Integer, FormFile>) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE);
			String fileStr = (String) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_ADD_FLAG);
			String fileDelStr = (String) tableFormValueMap.get(WorkFlowConstDefine.PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG);
			saveTableFormValue(newProcessRecord, column_value, column_pidid, column_rownum, tableFormFileMap, fileStr, fileDelStr);
		}
		//处理人员表单值
		//流程发起操作，将保存相关资产，保存表格式表单值，保存人员表单值处理移至此处  20130905 wangtingzhi end
		
		
		// 填充流程发起者记录
		IG337TB opener = this.getProcessParticipantTBInstance();
		opener.setPrid(prid);
		opener.setPpuserid(processRecordTB.getPruserid());
		opener.setPpusername(processRecordTB.getPrusername());
		opener.setPproleid(processRecordTB.getPrroleid());
		opener.setPprolename(processRecordTB.getPrrolename());
		opener.setPporgid(processRecordTB.getProrgid());
		opener.setPporgname(processRecordTB.getProrgname());
		opener.setPpstatus(IGPRDCONSTANTS.PROCESS_START_STATUS);
		opener.setPpinittime(datetime);
		opener.setPpproctime(datetime);
		opener.setPbdid(action);
		opener.setPpuserinfo(processRecordTB.getPrinfo());
		opener.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
		
		// 查询发起节点流程状态定义ID
		IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
		psdCond.setPdid(processRecordTB.getPrpdid());
		psdCond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);
		psdCond.setFatherflag("Y");
		IG333Info zpsd = this.workFlowDefinitionBL.searchProcessStatusDef(psdCond).get(0);
		
		opener.setPsdid(zpsd.getPsdid());
		
		
		if(parprid != null && parprid > 0){
			//创建流程关系
			//从服务工单快捷发起
			if("S".equals(isServiceStart)){
				//创建关系
				IG715TB sprrTB = ig715BL.getIG715TBInstance();
				sprrTB.setSprrsfid(parprid);//主动流程ID
				sprrTB.setSprrprid(prid);//被动流程ID
				sprrTB.setSprrinstime(datetime);//建立时间
				ig715BL.registIG715Info(sprrTB);
			} else if("C".equals(isServiceStart)){ //从流程快捷发起
				//创建关系
				IG512TB prrTB = getProcessRecordRelationTBInstance();
				prrTB.setParprid(parprid);//主动流程ID
				prrTB.setCldprid(prid);//被动流程ID
				prrTB.setPrrinstime(datetime);//建立时间
				createProcessRecordRelation(prrTB);
			}
			addRecordLog(parprid, user, roleid, "发起" + newProcessRecord.getPrpdname(), "相关发起", filemap, IGPRDCONSTANTS.RECORDLOG_TYPE_CL, IGPRDCONSTANTS.BUTTON_PROCESS, null);
		}

        if(action != null && action.compareTo("10") >= 0){
		opener = (IG337TB) addProcessParticipant(opener,user,roleid,
				                "添加：" + opener.getPprolename()
				                + (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
				                IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
				                IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, action, psdid);
        } else {//保存
        	opener = (IG337TB) addProcessParticipant(opener,user,roleid,
        			"添加：" + opener.getPprolename()
        			+ (StringUtils.isEmpty(opener.getPpusername()) ? "" : "(" + opener.getPpusername() + ")"),
        			IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,
        			IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ,authorizeuser, IGPRDCONSTANTS.BUTTON_SUBMIT, psdid);
        }
        
     	// 按钮事件-应急迁移入-
    	WorkFlowStatusEventBean bean = new WorkFlowStatusEventBean();
		bean.setPbdid(action);//按钮ID
		if (psdid.indexOf("_") > -1) {
			bean.setBfstatus(psdid.split("_")[0]);//状态ID
			bean.setBfstatusnum(psdid.split("_")[1]);//状态ID编号
		} else {
			bean.setBfstatus(psdid);//状态ID
		}
		//日志参数信息
		WorkFlowLog logInfo = new WorkFlowLog();
		logInfo.setPrid(prid);
		logInfo.setExecutorid(user.getUserid());
		logInfo.setExecutorRoleid(roleid);
		if(authorizeuser != null) {
			logInfo.setAuthuserid(authorizeuser.getUserid());
		}
		bean.setLogInfo(logInfo);
		this.processStatusButtonTreatmentExecute(bean);
        
		//保存私有变量
		this.registProcessPrivateInfo(prInfoList, roleid, user.getUserid(),opener.getPporgid());

		// >>>>>>>>>>>>>>>>> update by yangyining 20131028
		newProcessRecord = ig500BL.searchIG500InfoByKey(prid);
        // <<<<<<<<<<<<<<<<< update by yangyining 20131028
		//生成工单号
		IG500TB ig500TB = (IG500TB)SerializationUtils.clone(newProcessRecord);
		IG380Info ig380Info = this.workFlowDefinitionBL.searchProcessDefinitionByKey(newProcessRecord.getPrpdid());
		if(ig380Info != null && StringUtils.isNotEmpty(ig380Info.getSerialgenerator())) {
			WorkFlowSerialnumGeneratorBL bl = null;
			try {
				bl = (WorkFlowSerialnumGeneratorBL)WebApplicationSupport.getBean(ig380Info.getSerialgenerator());
			} catch (Exception e) {
				throw new BLException("IGCO10000.E004", "工单号生成器定义");
			}
			igflowlog.debug("========================工单号生成事件开始========================");
			igflowlog.debug("流程类型名称:" + newProcessRecord.getPrpdname());
			igflowlog.debug("流程类型ID:" + newProcessRecord.getPrpdid());
			igflowlog.debug("流程标题:" + newProcessRecord.getPrtitle());
			igflowlog.debug("调用BL:" + ig380Info.getSerialgenerator());
			ig500TB.setPrserialnum(bl.serialnumGenerator(prid));
			igflowlog.debug("生成工单号:" + ig500TB.getPrserialnum());
			igflowlog.debug("========================工单号生成事件结束========================");
			this.ig500BL.updateIG500Info(ig500TB);
		}
		
		
		/**   填充流程发起者  end**/
        if(action != null && action.compareTo("10") >= 0){
        	//查询该状态可进行分派的节点列表
        	List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(psdid, action);
        	if(lst_ProcessStatusDef.isEmpty()) {
        		/**   匹配跃迁  start**/
        		this.checkAndTransitionForCreate(user,psdid,roleid,action,prid,prInfoList,authorizeuser);
        	} else {
        		opener.setPpproctime(null);//清空处理人的发起时间
        		this.updateProcessParticipant(opener);
        		this.insertBeginRecordStatusLogByPsdid(prid, processRecord.getPrpdid(), processRecordTB.getPrtype(), psdid, WorkFlowConstDefine.STATUSTYPE_BEGIN, new Date(datetime),false);
        	}
        }else{
        	opener.setPpproctime(null);//清空处理人的发起时间
        	this.updateProcessParticipant(opener);
        	IG224SearchCondImpl cond = new IG224SearchCondImpl();
        	cond.setPrid(prid);
        	if(this.ig224BL.searchIG224Info(cond,0,0).size() == 0) {
        		this.insertBeginRecordStatusLogByPsdid(prid, processRecord.getPrpdid(), processRecordTB.getPrtype(), psdid, WorkFlowConstDefine.STATUSTYPE_BEGIN, new Date(datetime),false);
        	}
        }
		
		//保存私有变量
		this.registProcessPrivateInfo(prInfoList, roleid, user.getUserid(),opener.getPporgid());
		//保存状态变量 wyw
        this.registIG561Info(prInfoList,psdid, user.getUserid(),entitySaveMap);
        
		/**   匹配跃迁  start**/
		return ig500TB;
	}
	
	//取processinfo附件
	public  List<Attachment> searchProcessInofAtt(String piattkey) {
		List<Attachment> ProcessInofAttList = new ArrayList<Attachment>();
		//没有附件时不处理
		if(piattkey != null && piattkey.length()>0){
		ProcessInofAttList = attachmentBL.searchAttachmentsByAttkey(piattkey);
		}
		return ProcessInofAttList;
	}
	
	//文本域绑定附件删除处理
	public  Attachment delAttachment(String attkey) throws BLException {
//		List<Attachment> list = new ArrayList<Attachment>();
//		ProcessInofAttList = attachmentBL.searchAttachmentsByAttkey(piattkey);
		Attachment att = attachmentBL.searchAttachmentByKey(Integer.parseInt(attkey));
		//附件删除操作
		if(att!=null){
			attachmentBL.deleteAttachment(att);
		}
//		attachmentBL.
		return att;
	}
	
	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchProcessInfoForClose(Integer prid, String pdid, String userid){
		return this.ig599BL.searchIG599InfoForClose(prid, pdid, userid);
	}

	/**
	 * 自定义流程关闭状态变量信息集合取得
	 * （缺省变量和定义变量并集，普通模式按角色过滤，OA模式按用户ID过滤）
	 * @param 流程ID
	 * @param 流程定义ID
	 * @param 用户ID
	 * @return 流程变量参数值信息集合
	 */
	public List<IG599Info> searchProcessInfoForSee(Integer prid, String pdid, String userid){
		return this.ig599BL.searchIG599InfoForSee(prid, pdid, userid);
	}
	
	/**
	 * 判断流程状态日志是否超时
	 * 
	 * @param 流程ID
	 * @param 开始时间
	 * @param 结束时间
	 * @param 流程状态
	 * @return 是否超时
	 * @throws BLException 
	 */
	public String checkTimeOut(Integer prid, Date starttime, Date endtime, String prstatus) throws BLException {
		//获取流程记录
		IG500Info process = this.searchProcessRecordByKey(prid);
		
		//结束状态记录的是流程整体是否超时
		if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(process.getPrstatus())) {
			SimpleDateFormat df = new SimpleDateFormat(CommonDefineUtils.DATETIME_FORMAT.getPattern());
			try {
				starttime = df.parse(process.getPropentime());
			} catch (ParseException e) {
				throw new BLException("IGCO10000.E004","日期格式化基本");
			}
		}
		
		//是否超时标识
		String isAlive = WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_NO;
		//获取流程策略
		IG105PK pk = new IG105PK();
		pk.setPdid(process.getPrpdid());// 流程定义ID
		pk.setPsdversion(process.getPrStrategyVersion());// 策略版本号
		pk.setPrurgency(process.getPrurgency());// 流程紧急度
		pk.setPrstatus(prstatus);// 流程状态
		IG105Info psd = ig105BL.searchIG105InfoByKey(pk);
		if (psd != null && psd.getExpecttime() != null && psd.getExpecttime() > 0) {
			Double excepttime = psd.getExpecttime() * 60;
			if ((endtime.getTime() - starttime.getTime()) > excepttime.intValue() * 60000) {
				isAlive = WorkFlowConstDefine.RECORDSTATUSLOG_EXPECT_YES;
			}
		}
		return isAlive;
	}

	/**
	 * 匹配跃迁规则，若匹配返回下一状态id，不匹配返回Null(运维计划发起自定义流程时使用)
	 *
	 * @param user 用户
	 * @param fpsdid 当前流程状态ID
	 * @param roleid 角色ID
	 * @param action 动作按钮代码
	 * @param prid 流程ID
	 * @param List<ProcessInfo> 流程变量信息集合
	 * @return Integer 跃迁后的流程状态ID
	 */
	public String checkAndTransition(User user,String fpsdid,Integer roleid,String action,Integer prid,List<IG599Info> piList) throws BLException {
		return checkAndTransitionForCreate(user, fpsdid, roleid, action, prid, piList, null);
	}
	
	/**
	 * <p>
	 * 流程变量更新处理
	 * </p>
	 * 
	 * @param pi 流程变量信息
	 * @throws BLException
	 *
	 */

	public void updateProcessInfo(IG599Info pi) throws BLException {
		ig599BL.updateIG599Info(pi);
	}
	
	/**
	 * 如果存在授权,日志中显示谁替谁处理
	 * @param username 当前用户名称
	 * @param authorizeusername 授权人用户名称
	 * @param rlcomment 日志内容
	 * @return
	 */
	public String getRlcomment(String username, String authorizeusername, String rlcomment){

		// 如果存在日志内容, 则换行
		if (StringUtils.isNotEmpty(rlcomment)) {
			rlcomment = rlcomment + "<br>" + "【" + username
					+ "】代替【" + authorizeusername + "】处理。";
		} else {
			rlcomment = "【" + username + "】代替【"
					+ authorizeusername + "】处理。";
		}
		return rlcomment;
	}
	
	
	/**
	 * 保存私有变量处理
	 * 
	 * @param lst_ProcessInfo 表单变量集合
	 * @param roleid 角色ID
	 * @param userid 用户ID
	 * @throws BLException 
	 */
	public void registProcessPrivateInfo(List<IG599Info> lst_ProcessInfo, Integer roleid, String userid,String orgid) throws BLException {
		this.ig899BL.registIG899Info(lst_ProcessInfo, roleid, userid,orgid);
	}
	
	public List<IG899Info> searchProcessPrivateInfo(IG899SearchCond cond) throws BLException{
		return this.ig899BL.searchIG899Info(cond);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG899Info updateProcessPrivateInfo(IG899Info instance) throws BLException{
		return this.ig899BL.updateIG899Info(instance);
	}
	
	/**
	 * 流程执行人检索处理
	 * @param userid 用户ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchProcessExecutors(String userid, Integer prid) {
		return this.ig337BL.searchIG602Info(userid, prid);
	}
	
	/**
	 * 流程可分派人检索处理
	 * @param roleid 角色ID
	 * @param prid 流程ID
	 * @return 检索结果列表
	 */
	public List<IG602Info> searchSuperAssignExecutors(Integer roleid, Integer prid) {
		return this.ig337BL.searchSuperAssignExecutors(roleid, prid);
	}
	
	/**
	 * 判断当前节点的提交权限
	 * 
	 * 当设定为角色内用户全部提交时跃迁，
	 * 如果该角色的参与者全部处理完成且提交按钮ID相同，返回true，否则返回false
	 * 当设定为角色内用户有一个提交时跃迁，返回true
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ptd 跃迁规则
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRole(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//只有普通节点/普通模式且非发起节点可通过
		if(!IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL.equals(ptd.getFromPSDTB().getPsdtype())
				|| !IGPRDCONSTANTS.MODE_NORMAL.equals(ptd.getFromPSDTB().getPsdmode())
				|| IGPRDCONSTANTS.PROCESS_START_STATUS.equals(ptd.getFromPSDTB().getPsdcode())) {
			return true;
		}
		if(IGPRDCONSTANTS.COND_TYPE_DEFAULT.equals(ptd.getPtdtype())) {
			return checkUserCommitInRoleDefault(prid, psdid, ptd);//缺省规则
		} else {
			return checkUserCommitInRoleNormal(prid, psdid, ptd);//普通规则
		}
	}
	
	/**
	 * 判断当前节点的提交权限
	 * 
	 * 当设定为角色内用户全部提交时跃迁，
	 * 如果该角色的参与者全部处理完成且提交按钮ID相同，返回true，否则返回false
	 * 当设定为角色内用户有一个提交时跃迁，返回true
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ptd 跃迁规则
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRoleNormal(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//存放提交权限为0的集合（角色ID-按钮ID）
		Map<String, String> auth = workFlowDefinitionBL.searchRoleCommitNormalAuth(ptd.getFpsdid());
		if(auth == null || auth.size() == 0) {
			return true;
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(prid);
			if (psdid.indexOf("_") > -1) {
				ppCond.setPsdid(psdid.split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
			} else {
				ppCond.setPsdid(psdid);
			}
			List<IG337Info> lst_ProcessParticipant = this.searchProcessParticipants(ppCond);
			//存放跃迁规则集合（角色ID-按钮ID）
			Set<String> set_ptd = new HashSet<String>();
			//获取跃迁规则
			String ptdCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];
			String[] condArray = ptdCond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			//填充规则集合
			for(String str : condArray) {
				set_ptd.add(str);
			}
			//从提交权限集合中过滤掉符合跃迁规则的记录
			Set<Map.Entry<String, String>> set = auth.entrySet();
			if(set.size() > 0) {
				Map.Entry<String, String> entry = null;
				for(Iterator<Map.Entry<String, String>> iter = set.iterator(); iter.hasNext();){
					entry = iter.next();
					if(set_ptd.contains(entry.getKey() + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + entry.getValue())) {
						for(IG337Info pp : lst_ProcessParticipant) {
							//角色相同
							if(entry.getKey().equals(pp.getPproleid().toString())) {
								if(StringUtils.isEmpty(pp.getPpproctime())) {
									return false;//有未处理的
								} else if(!entry.getValue().equals(pp.getPbdid())) {
									return false;//提交按钮ID不一致
								} 
							}
						}
					}
				}
			}
			return true;
		}
	}
	/**
	 * 判断当前节点的提交权限
	 * 
	 * 当设定为角色内用户全部提交时跃迁，
	 * 如果该角色的参与者全部处理完成且提交按钮ID相同，返回true，否则返回false
	 * 当设定为角色内用户有一个提交时跃迁，返回true
	 * 
	 * @param prid 流程ID
	 * @param status 流程状态
	 * @param ptd 跃迁规则
	 * @return true/false
	 * @throws BLException 
	 *
	 */
	private boolean checkUserCommitInRoleDefault(Integer prid, String psdid, IG273Info ptd) throws BLException {
		//存放提交权限为0的集合（按钮ID）
		List<String> auth = workFlowDefinitionBL.searchRoleCommitDefaultAuth(ptd.getFpsdid());
		if(auth == null || auth.size() == 0) {
			return true;
		} else {
			IG337SearchCondImpl ppCond = new IG337SearchCondImpl();
			ppCond.setPrid(prid);
			if (psdid.indexOf("_") > -1) {
				ppCond.setPsdid(psdid.split("_")[0]);
				ppCond.setPsdnum(Integer.parseInt(psdid.split("_")[1]));
			} else {
				ppCond.setPsdid(psdid);
			}
			List<IG337Info> lst_ProcessParticipant = this.searchProcessParticipants(ppCond);
			//存放跃迁规则集合（角色ID-按钮ID）
			Set<String> set_ptd = new HashSet<String>();
			//获取跃迁规则
			String ptdCond = ptd.getPtdcond().split("["+IGPRDCONSTANTS.PROCESSPVARIABLE_COND_SPLIT+"]")[0];
			String[] condArray = ptdCond.split(IGPRDCONSTANTS.COND_COND_SPLIT);
			//填充规则集合
			for(String str : condArray) {
				set_ptd.add(str);
			}
			//从提交权限集合中过滤掉符合跃迁规则的记录
			String buttonid = null;
			for(Iterator<String> iter = auth.iterator(); iter.hasNext();){
				buttonid = iter.next();
				if(set_ptd.contains(IGPRDCONSTANTS.COND_TYPE_DEFAULT_ROLE + IGPRDCONSTANTS.PROCESSPARTICIPANT_COND_SPLIT + buttonid)) {
					for(IG337Info pp : lst_ProcessParticipant) {
						if(StringUtils.isEmpty(pp.getPpproctime())) {
							return false;//有未处理的
						} else if(!buttonid.equals(pp.getPbdid())) {
							return false;//提交按钮ID不一致
						} 
					}
				}
			}
			return true;
		}
	}
	private List<String> getSendMessage(){
		//短信通知提醒内容
		//短信上报提醒内容
		String smsMessage = codeListUtils.getCodeValue("157", "", "", "9");
		//邮件通知提醒标题
		String mailTitleMessage = codeListUtils.getCodeValue("157", "", "", "10");
		//邮件通知提醒内容
		String mailContentMessage = codeListUtils.getCodeValue("157", "", "", "11");
//		smsMessage = StringUtils.isEmpty(smsMessage)?"工作提醒：工单号为【{0}】的 【{1}】流程需要您处理！":smsMessage;
//		mailTitleMessage = StringUtils.isEmpty(mailTitleMessage)?"工作提醒：工单号为【{0}】的 【{1}】流程需要您处理！":mailTitleMessage;
//		mailContentMessage = StringUtils.isEmpty(mailContentMessage)?"工作提醒：工单号为【{0}】的 【{1}】流程需要您处理！":mailContentMessage;
		smsMessage = StringUtils.isEmpty(smsMessage)?"工作提醒：当前状态为【{0}】的工单号【{1}】的【{2}】工单需要您处理！":smsMessage;
		mailTitleMessage = StringUtils.isEmpty(mailTitleMessage)?"工作提醒：当前状态为【{0}】的工单号【{1}】的【{2}】工单需要您处理！":mailTitleMessage;
		mailContentMessage = StringUtils.isEmpty(mailContentMessage)?"工作提醒：当前状态为【{0}】的工单号【{1}】的【{2}】工单需要您处理！{3}":mailContentMessage;
		List<String> lstMessage = new ArrayList<String>();
		lstMessage.add(smsMessage);
		lstMessage.add(mailTitleMessage);
		lstMessage.add(mailContentMessage);
		return lstMessage;
	}
	
	private String replaceMessage(String message,List<String> args){
		if(args != null && args.size() > 0){
			for(int i = 0; i< args.size(); i++){
				message = StringUtils.replace(message, "{"+i+"}", args.get(i));
			}
		}
		return message;
	}

	public List<CurrentMonthWorkVWInfo> SearchCurrentWorkWithManage(
			CurrentMonthWorkVWSearchCond cond, int start, int count) {
		
		return this.currentMonthWorkVWBL.findCurrentMonthWorkByCond(cond, start, count);
	}

	public int SearchCurrentWorkWithManageCount(
			CurrentMonthWorkVWSearchCond cond) {
		
		return this.currentMonthWorkVWBL.getSearchCurrentMonthWorkCount(cond);
	}
	
	/**
	 * 取得流程类表单值
	 * @param prid
	 * @param value
	 * @return
	 * @throws BLException
	 */
	public String getProcessFormValue(Integer prid,String value) throws BLException{
		StringBuffer pivarvalue = new StringBuffer();
		if(StringUtils.isNotEmpty(value)){
			String processinfo = "";
			String delinfo = "";
			String[] infos = value.split("_processValue_");
			String valueinfo = infos[0];
			List<String> valueArray = new ArrayList<String>();
			if(StringUtils.isNotEmpty(valueinfo)){
				String[] values = valueinfo.split(",");
				for(String s:values){
					valueArray.add(s);
				}
			}
			if(infos.length > 2){
				delinfo = infos[2];
				if(StringUtils.isNotEmpty(delinfo)){
					String[] dels = delinfo.split("#");
					if(dels != null && dels.length > 0){
						for(String s:dels){
							valueArray.remove(s);
							IG505TB entity = new IG505TB();
							entity.setPiprrid(Integer.valueOf(s));
							ig505BL.deleteIG505(entity);
						}
					}
				}
			}
			if(!valueArray.isEmpty()){
				for(String s:valueArray){
					pivarvalue.append(",").append(s);
				}
			}
			if(infos.length > 1){
				processinfo = infos[1];
				if(StringUtils.isNotEmpty(processinfo)){
					String[] adds = processinfo.split("#");
					if(adds != null && adds.length > 0){
						for(String s:adds){
							String info = s.split("_id_")[1];
							String piprid = info.split("_svc_")[0];
							String piprtype = info.split("_svc_")[1].split("_name=")[0];
							String piprtitle = info.split("_svc_")[1].split("_name=")[1];
							IG505TB entity = new IG505TB();
							entity.setPrid(prid);
							entity.setPiprid(Integer.valueOf(piprid));
							entity.setPiprtype(piprtype);
							entity.setPiprtitle(piprtitle);
							IG505Info entry = ig505BL.registIG505(entity);
							pivarvalue.append(",").append(entry.getPiprrid());
						}
					}
				}
			}
		}
		String returnValue = pivarvalue.toString();
		if(StringUtils.isNotEmpty(returnValue)){
			return returnValue.substring(1);
		}else{
			return null;
		}
	}
	
	/**
	 * 取得人员类表单值
	 * @param prid 流程主键
	 * @param pvList 人员类表单值实体集合
	 * @param value 表单值
	 * @return
	 */
	public String getParticipantFormValue(Integer prid,List<IG506TB> pvList,String value) throws BLException{
		StringBuffer pivarvalue = new StringBuffer();
		if(StringUtils.isNotEmpty(value) && !"N/A".equals(value)){
			String[] infos = value.split("_participantValue_");
			String valueinfo = infos[0];
			String delinfo = "";
			List<String> valueArray = new ArrayList<String>();
			if(StringUtils.isNotEmpty(valueinfo)){
				String[] values = valueinfo.split(",");
				for(String s:values){
					valueArray.add(s);
				}
			}
			if(infos.length == 2){
				delinfo = infos[1];
				if(StringUtils.isNotEmpty(delinfo)){
					String[] dels = delinfo.split("#");
					if(dels != null && dels.length > 0){
						for(String s:dels){
							valueArray.remove(s);
							IG506TB entity = new IG506TB();
							entity.setPiuid(Integer.valueOf(s));
							ig506BL.deleteIG506(entity);
						}
					}
				}
			}
			if(!valueArray.isEmpty()){
				for(String s:valueArray){
					pivarvalue.append(",").append(s);
				}
			}
		}
		if(pvList != null){
			for(IG506TB entity:pvList){
				entity.setPrid(prid);
				IG506Info entry = ig506BL.registIG506(entity);
				pivarvalue.append(",").append(entry.getPiuid());
			}
		}
		String returnValue = pivarvalue.toString();
		if(StringUtils.isNotEmpty(returnValue)){
			return returnValue.substring(1);
		}else{
			return null;
		}
	}	
	
	/**
	 * 表格类表单列查询
	 * @param pdid 流程定义主键
	 * @return 
	 * @throws BLException
	 */
	public Map<String, List<IG007Info>> initTableFormAction(String pdid) throws BLException {
		log.debug("=================初始化表格类表单操作开始===================");
		Map<String, List<IG007Info>> columnInfoMap = null;
		//查询表格类表单定义列信息
		IG007SearchCondImpl pidcond = new IG007SearchCondImpl();
		pidcond.setPdid(pdid);
		List<IG007Info> columnList = workFlowDefinitionBL.searchProcessInfoDef(pidcond);
		if(columnList != null){
			columnInfoMap = new HashMap<String, List<IG007Info>>();
			for(IG007Info column:columnList){
				String key = column.getPpidid();
				if(StringUtils.isEmpty(key)){
					key = "rawdef";
				}
				if(columnInfoMap.get(key) == null){
					List<IG007Info> temp = new ArrayList<IG007Info>();
					temp.add(column);
					columnInfoMap.put(key, temp);
				}else{
					columnInfoMap.get(key).add(column);
				}
			}
		}
		log.debug("=================初始化表格类表单操作结束===================");
		return columnInfoMap;
	}
	
	/**
	 * 表格类表单列值保存处理
	 * @param process 流程信息
	 * @param column_value 值集合
	 * @param column_pidid 列定义主键集合
	 * @param column_rownum 列行号集合
	 * @throws BLException
	 */
	public void saveTableFormValue(IG500Info process,String[] column_value,String[] column_pidid,String[] column_rownum,Map<Integer, FormFile> fileMap,String fileStr,String fileDelStr) throws BLException{
		log.debug("================表格类表单值保存操作开始==================");
		if(process == null || column_value == null || column_value.length == 0){
			return;
		}
		//查询原有表格类表单的值
		IG898SearchCondImpl cond = new IG898SearchCondImpl();
		cond.setPrid(process.getPrid());
		List<IG898Info> tableColumnValueList = ig898BL.searchIG898(cond);
		Set<String> pididset = new HashSet<String>();
		for(String pidid:column_pidid){
			pididset.add(pidid);
		}
		//删除当前流程下所有表格类表单值
		if(tableColumnValueList != null){
			for(IG898Info entry:tableColumnValueList){
				if(pididset.contains(entry.getPvcolpidid())){
					ig898BL.deleteIG898(entry);
				}
			}
		}
		//取得列定义信息
		Map<String, List<IG007Info>> columnInfoMap = initTableFormAction(process.getPrpdid());
		Map<String, IG007Info> columnInfo = new HashMap<String, IG007Info>();
		Map<String, IG007Info> tableInfoMap = new HashMap<String, IG007Info>();
		Set<Map.Entry<String, List<IG007Info>>> set = columnInfoMap.entrySet();
		Map<String, List<Attachment>> attMap = new HashMap<String, List<Attachment>>();
		for(Iterator<Entry<String, List<IG007Info>>> iter = set.iterator();iter.hasNext();){
			Entry<String, List<IG007Info>> entry = iter.next();
			String pidid = entry.getKey();
			if("rawdef".equals(pidid)){
				continue;
			}
			IG007Info table_def = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
			tableInfoMap.put(pidid, table_def);
			List<IG007Info> columnList = entry.getValue();
			if(columnList != null){
				for(IG007Info column:columnList){
					columnInfo.put(column.getPidid(), column);
					if("F".equals(column.getPidtype())){
						if(StringUtils.isNotEmpty(column.getPiddefault())){
							List<Attachment> list = attachmentBL.searchAttachmentsByAttkey(column.getPiddefault());
							attMap.put(column.getPidid(), list);
						}
					}
				}
			}
		}
		//删除表单列附件
		if(StringUtils.isNotEmpty(fileDelStr)){
			String[] split = fileDelStr.split("#");
			if(split != null && split.length > 0){
				for(int i=0;i<split.length;i++){
					boolean flag = true;
					if(!attMap.isEmpty()){
						for(Iterator<Entry<String, List<Attachment>>> iter = attMap.entrySet().iterator();iter.hasNext();){
							Entry<String, List<Attachment>> next = iter.next();
							List<Attachment> list = next.getValue();
							boolean iscon = false;
							for(Attachment att : list){
								if(split[i].equals(att.getAttid() + "")){
									flag = false;
									iscon = true;
									list.remove(att);
									break;
								}
							}
							if(iscon){
								break;
							}
						}
					}
					if(flag){
						delAttachment(split[i]);
					}
				}
			}
		}
		if(column_value != null && column_value.length > 0){
			for(int i=0;i<column_value.length;i++){
				//取得列定义信息
				String pidid = column_pidid[i];
				String rownumber = column_rownum[i];
				//忽略复制模板中的值
				if("0".equals(rownumber)||"_#_".equals(rownumber)){
					continue;
				}
				IG007Info column_def = columnInfo.get(pidid);
				IG007Info table_def = tableInfoMap.get(column_def.getPpidid());
				String value = null;
				if("F".equals(column_def.getPidtype()) && StringUtils.isNotBlank(column_value[i]) && column_value[i].equals(column_def.getPiddefault())){
					value = getTableColumnValue(process.getPrid(),pidid,rownumber,column_def.getPidtype(),"N/A",fileMap,fileStr);
				}else{
					value = getTableColumnValue(process.getPrid(),pidid,rownumber,column_def.getPidtype(),column_value[i],fileMap,fileStr);
				}
				IG898TB entity = ig898BL.getIG898TBInstance();
				entity.setPrid(process.getPrid());
				entity.setPidid(column_def.getPpidid());
				entity.setPidname(table_def.getPidname());
				entity.setPvcolname(column_def.getPidname());
				entity.setPvcolpidid(pidid);
				entity.setPvalue(value);
				if("F".equals(column_def.getPidtype())){
					String key = IGStringUtils.getAttKey();
					if(StringUtils.isNotEmpty(value)){
						entity.setAttkey(value);
					}
					List<Attachment> list = attMap.get(pidid);
					if(list != null && list.size() > 0 && StringUtils.isNotBlank(column_value[i]) && column_value[i].equals(column_def.getPiddefault())){
						for(Attachment att:list){
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
						entity.setAttkey(key);
						entity.setPvalue(key);
					}
				}
				entity.setPvrownumber(rownumber);
				ig898BL.registIG898(entity);
			}
		}
		log.debug("================表格类表单值保存操作结束==================");
	}
	
	/**
	 * 生成特殊表单值
	 * @param prid 流程主键
	 * @param pidtype 表单类型
	 * @param value 表单值
	 * @return
	 * @throws BLException
	 */
	private String getTableColumnValue(Integer prid,String pidid,String rownum,String pidtype,String value,Map<Integer, FormFile> fileMap,String fileStr) throws BLException{
		if("4".equals(pidtype)){
			if(StringUtils.isNotEmpty(value)){
				String[] split = value.split("_entityValue_");
				StringBuffer defautl = new StringBuffer();
				if(value.contains("DEFAULT")){
					IG007Info def = workFlowDefinitionBL.searchProcessInfoDefByKey(pidid);
					String defaultValue = def.getPiddefault();
					if(StringUtils.isNotEmpty(defaultValue)){
						String[] defaults = defaultValue.split("#");
						Set<String> set = new HashSet<String>();
						if(split.length > 2 && StringUtils.isNotEmpty(split[2])){
							String[] dels = split[2].split("_sp_");
							for(String s:dels){
								set.add(s.replace("EIID", ""));
							}
						}
						for(String s:defaults){
							if(!set.contains(s)){
								IG731TB pieTB = new IG731TB();
								pieTB.setPrid(prid);
								pieTB.setEiid(Integer.valueOf(s));
								pieTB.setEiversion(Integer.valueOf(1));
								IG731Info pieInfo = ig731BL.registIG731Info(pieTB);
								defautl.append(pieInfo.getPieid()).append(",");
							}
						}
					}
				}
				if(split != null && split.length > 1){
					String str0 = split[0];
					String str1 = split[1];
					String delStr = "";
					Set<String> delSet = new HashSet<String>();
					if(split.length == 3){
						delStr = split[2];
						String[] dels = delStr.split("_sp_");
						if(dels != null && dels.length > 0){
							for(String pieid:dels){
								if(pieid.indexOf("EIID") < 0){
									delSet.add(pieid);
								}
//								workFlowOperationBL.deleteProcessInfoEntityById(Integer.parseInt(pieid));
							}
						}
					}
					if(StringUtils.isNotEmpty(str1)){
						String[] str2 = str1.split("#");
						StringBuffer pieids = new StringBuffer();
						if(StringUtils.isNotEmpty(str0)){
							String[] cpieids = str0.split(",");
							if(cpieids != null && cpieids.length > 0){
								for(String pieid:cpieids){
									if(!delSet.contains(pieid)){
										pieids.append(pieid).append(",");
									}
								}
							}
						}
						if(str2 != null && str2.length > 0){
							for(int i=0;i<str2.length;i++){
								if(StringUtils.isNotEmpty(str2[i])){
									String str3 = str2[i].split("_rowIndex_")[1];
									String[] info = str3.split("_sp_");
									IG731TB pieTB = new IG731TB();
									pieTB.setPrid(prid);
									pieTB.setEiid(Integer.valueOf(info[0]));
									pieTB.setEiversion(Integer.valueOf(info[1]));
									IG731Info pieInfo = ig731BL.registIG731Info(pieTB);
									pieids.append(pieInfo.getPieid()).append(",");
								}
							}
						}
						if(StringUtils.isNotEmpty(pieids.toString())){
							value = pieids.toString() + "_entityValue_";
						}
					}
				}
				if(StringUtils.isNotEmpty(value)){
					value = defautl.toString() + value;
				}else{
					value = defautl.toString() + "_entityValue_";
				}
			}
		}else if("F".equals(pidtype)){
			Map<Integer, FormFile> columnFileMap = new HashMap<Integer, FormFile>();
			int index = 0;
			if(StringUtils.isNotEmpty(fileStr)){
				String[] split = fileStr.split("#");
				if(split != null && split.length > 0){
					for(String s:split){
						if(StringUtils.isNotEmpty(s)){
							String[] info = s.split("_sp_");
							if(info[0].equals(pidid) && info[1].equals(rownum)){
								FormFile file = fileMap.get(Integer.valueOf(info[2]));
								if(file != null){
									columnFileMap.put(new Integer(index), file);
									index ++;
								}
							}
						}
					}
				}
			}
			if(columnFileMap.size() > 0){
				if(StringUtils.isEmpty(value) || "N/A".equals(value)){
					String attkey = fileUploadBL.uploadFile(columnFileMap);
					value = attkey;
				}else{
					fileUploadBL.uploadFile(columnFileMap,value);
				}
			}
		}else if("5".equals(pidtype)){
			value = getProcessFormValue(prid, value);
		}
		return value;
	}
	
	
	/**
	 * 保存资产表单中的资产信息
	 * 资产对应的表单信息不存在时抛异常
	 * @param processInfoList 表单值集合
	 * @param processInfoEntityMap 资产信息map
	 * @throws BLException
	 */
	public Map<String,String> saveProcessInfoEntity(List<IG599Info> processInfoList,Map<Integer, String> processInfoEntityMap) throws BLException {
		Map<String,String> returnmap= new HashMap<String, String>();
	    if(processInfoEntityMap != null && processInfoList != null){
			if(processInfoEntityMap.size() > 0){
				//组装表单值map
				Map<String, IG599Info> prInfoMap = new HashMap<String, IG599Info>();
				for(IG599Info prInfo:processInfoList){
					prInfoMap.put(prInfo.getPidid(), prInfo);
				}
				//组装相关资产信息
				Set<Entry<Integer, String>> set = processInfoEntityMap.entrySet();
				for(Iterator<Entry<Integer, String>> iter = set.iterator();iter.hasNext();){
					Map.Entry<Integer,String> entry = iter.next();
					if(StringUtils.isNotEmpty(entry.getValue())){
						String infos = entry.getValue();
						String[] ids = infos.split("#");
						String pidid = ids[0];//表单定义ID
						String eiid = ids[1];//资产ID
						String eiversion = ids[2]; //资产版本号
						//除相关资产外的资产动态表单
						if(!"A".equals(pidid)){
							//确定资产属于哪个动态表单, 用pidid区分
							IG599Info processInfo = prInfoMap.get(pidid);
							if(processInfo == null){
								throw new BLException("IGFLOW0000.E001","表单定义信息");
							}
							IG731TB pieTB = new IG731TB();
							pieTB.setEiversion(Integer.parseInt(eiversion));
							//update 2016年7月22日09:04:19 jinna 选择资产表单时，可能是远程库，原eiid 的位置的值格式 为 ：标识_eiid 
							Integer eiidint = null;
							if(StringUtils.isNotBlank(eiid) && eiid.split("_").length > 1){
								String[] eds = eiid.split("_");
								eiidint = Integer.parseInt(eds[1]);
								pieTB.setFingerPrint(eds[0]);
							}else{
								eiidint = Integer.parseInt(eiid);
							}
							pieTB.setEiid(eiidint);
							pieTB.setPiid(processInfo.getPiid());
							pieTB.setPrid(processInfo.getPrid());
							IG731Info info=saveProcessInfoEntity(pieTB);
							returnmap.put(info.getPiid().toString(),info.getPieid().toString());
						}
					}
				}
			}
		}
	    return returnmap;
	}

	public int searchProcessCount(IG500SearchCond cond, String type) throws BLException {
		if(StringUtils.isNotEmpty(type)){
			return ig500BL.searchProcessByTypeCount(cond, type);
		}else{
			return queryIG500EntityCount(cond);
		}
	}

	public List<IG500Info> searchProcessByType(IG500SearchCond cond, int start,
			int count, String type) throws BLException {
		if(StringUtils.isNotEmpty(type)){
			return ig500BL.searchProcessByType(cond, start, count, type);
		}else{
			return queryIG500EntityListByProcessInfo(cond,start,count);
		}
	}
	
	/**
	 * <p>
	 * Description: 根据查询条件获取指定参与人员
	 * </p>
	 * 
	 * @param cond ProcessParticipantSearchCond
	 * @return List<ProcessParticipant>
	 * @author liupeng@deliverik.com
	 */
	public List<IG337Info> searchIG337InfoRun(IG337SearchCond cond){
		return ig337BL.searchIG337InfoRun(cond);
	}
	
	/**
	 * 根据流程主键查询流程类表单
	 * @param prid 流程主键
	 * @return 流程类表单集合
	 * @throws BLException
	 */
	public List<IG505Info> searchIG505InfoByprid(Integer prid) throws BLException{
		return ig505BL.findByPrid(prid);
	}
	
	/**
	 * 根据流程主键查询人员类表单
	 * @param prid 流程主键
	 * @return 人员类表单集合
	 * @throws BLException
	 */
	public List<IG506Info> searchIG506InfoByprid(Integer prid) throws BLException{
		return ig506BL.findByPrid(prid);
	}
	
	/**
	 * 根据流程主键查询流程与服务工单关系
	 * @param prid 流程主键
	 * @return 流程与服务工单关系实体集合
	 * @throws BLException
	 */
	public List<IG715Info> searchServiceProcessRecordRelationByPrid(Integer prid) throws BLException{
		IG715SearchCondImpl cond = new IG715SearchCondImpl();
		cond.setSprrprid(prid);
		return ig715BL.searchIG715Info(cond, 0, 0);
	}
	 
	/**
	 * 注册表格式表单值
	 * @param entity 表格式表单值实体
	 * @return 表格式表单值实体
	 * @throws BLException
	 */
	public IG898Info registTableFormValue(IG898Info entity) throws BLException {
		return ig898BL.registIG898(entity);
	}
	
	/**
	 * 表格式表单值查询
	 * @param cond 查询条件实体
	 * @return 表格式表单值集合
	 * @throws BLException
	 */
	public List<IG898Info> searchTableFormValue(IG898SearchCond cond) throws BLException {
		return ig898BL.searchIG898(cond);
	}
	
	/**
	 * 主键检索表格式表单
	 * @param pk 主键
	 * @return 表格式表单实体
	 * @throws BLException
	 */
	public IG898Info searchTableFormValueByKey(IG898PK pk) throws BLException {
		return ig898BL.searchIG898ByPK(pk);
	}
	
	/**
	 * 删除表格式表单值
	 * @param entitys 表格式表单实体集合
	 * @throws BLException
	 */
	public void deleteTableFormValue(List<IG898Info> entitys) throws BLException {
		ig898BL.deleteIG898(entitys);
	}
	
	/**
	 * 主键检索服务工单
	 * @param sfid 服务工单主键
	 * @return 服务工单信息
	 * @throws BLException
	 */
	public IG933Info searchServiceFormByKey(Integer sfid) throws BLException{
		return ig933BL.searchIG933InfoByKey(sfid);
	}
	
	/**
	 * 授权工作检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG463Info> searchProcessProxyWork(IG463SearchCond cond) throws BLException{
		return ig463BL.searchIG463Info(cond, 0, 0);
	}
	
	/**
	 * 更新授权工作
	 * @param entity 授权工作实体
	 * @throws BLException
	 */
	public void updateProcessProxyWork(IG463Info entity) throws BLException{
		ig463BL.updateIG463Info(entity);
	}
	
	/**
	 * 用户授权检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG711Info> searchProcessAccredit(IG711SearchCond cond) throws BLException{
		return ig711BL.searchIG711Info(cond, 0, 0);
	}
	
	/**
	 * 查询指定监管报表key关联的流程
	 * @param type 报表类型
	 * @param pdid 报表定义ID
	 * @param key 报表实例key
	 * @param isClose true：查询已关闭，false：查询未关闭，null：查询全部，不包括中止
	 * @return 关联流程
	 */
	public List<Integer> searchRegulatoryReportDetailByKey(String type, String pdid, String key, Boolean isClose) throws BLException{
		return ig500BL.searchRegulatoryReportDetailByKey(type, pdid, key, isClose);
	}
	
	/**
	 * 功能：根据工单标识查询当前最大流水号
	 * @param prserialnum 工单标识
	 * @return 最大流水号
	 */
	public String searchMaxPrserialnum(String prserialnum) {
		return ig500BL.searchMaxPrserialnum(prserialnum);
	}
	
	/**
	 * 检验当前状态所有参与者是否处理完成，
	 * 如果全部处理完成则按处理时间最后一个参与者的处理记录进行状态跃迁，
	 * 如果有参与者未处理则不做任何操作.
	 * 
	 * @param prid 流程ID
	 * @throws BLException 
	 */
	public void checkAllUserWorkDone(Integer prid) throws BLException {
		//获取流程当前信息
		IG500Info process = this.searchProcessRecordByKey(prid);
		//获取当前状态参与者信息列表
		List<IG337Info> lst_IG337Info = this.searchProcessParticipant(prid, process.getPrstatus());
		//如果有参与者未处理(ppproctime is null)则不做任何操作
		for(IG337Info info : lst_IG337Info) {
			if(StringUtils.isEmpty(info.getPpproctime())) {
				return;
			}
		}
		//如果全部处理完成则按处理时间最后一个参与者的处理记录进行状态跃迁
		if(!lst_IG337Info.isEmpty()) {
			//获取最后一个处理参与者
			IG337Info ig337Info = lst_IG337Info.get(lst_IG337Info.size() - 1);
			//获取流程当前状态信息
			IG333Info ig333Info = this.workFlowDefinitionBL.searchProcessStatusDefByKey(
					this.workFlowDefinitionBL.searchProcessStatusKey(process.getPrpdid(), process.getPrstatus()));
			this.doFlow(prid, this.userBL.searchUserByKey(ig337Info.getPpuserid()), ig337Info.getPproleid(),
					IGStringUtils.getCurrentDateTime(), ig337Info.getPprolename(),
					ig333Info.getPsdid(), ig337Info.getPbdid(), "流程当前状态（" + ig333Info.getPsdname() + "）无未处理参与者，跃迁至下一状态",
					ig333Info.getPsdtype(), null, ig337Info.getPpuserid(), 
					StringUtils.isEmpty(ig337Info.getPpproxyuserid())?
							null : this.userBL.searchUserByKey(ig337Info.getPpproxyuserid()));
		}
	}
	
	/**
	 * 获取流程当前状态显示名称
	 * @param prid 流程ID
	 * @return 流程当前状态显示名称
	 */
	public String searchCurrentStatusName(Integer prid) throws BLException {
		return this.ig500BL.searchCurrentStatusName(prid);
	}
	
	/**
	 * 获取流程当前状态
	 * @param prid 流程ID
	 * @return 流程当前状态
	 */
	public List<String> searchCurrentStatus(Integer prid) throws BLException {
		return this.ig500BL.searchCurrentStatus(prid);
	}
	
	/**
	 * 状态日志检索
	 * @param cond 检索条件 
	 * @return
	 */
	public List<IG224Info> searchProcessStatusLog(IG224SearchCond cond){
		return this.ig224BL.searchIG224Info(cond, 0, 0);
	}

	/**
	 * 条件检索
	 * @param cond
	 * @return
	 * @throws BLException
	 */
	public List<IG677Info> searchIG677InfoByCond(IG677SearchCond cond) throws BLException {
		return ig500BL.searchIG677InfoByCond(cond);
	}
	
	/**
	 * 校验是否是挂起状态
	 * @param prid 流程ID
	 * @param psdid 状态ID
	 * @return 是否是挂起状态
	 */
	public boolean checkPendStatus(Integer prid, String psdid){
		boolean pend = true;
		IG224SearchCondImpl cond = new IG224SearchCondImpl();
		cond.setPrid(prid);
		cond.setPend(true);
		cond.setPsdid(psdid);
		if(ig224BL.searchIG224Info(cond,0,0).size() == 0) {
			pend = false;
		}
		return pend;
	}
	
    /**
     * 状态级私有表单值查询
     * @Title: searchStatusValue
     * @Description: 状态级私有表单值查询
     * @param pdid 流程id 待版本号
     * @param psdid 节点id
     * @param prid 可以为空（发起时）
     * @return Map</key pidid,value为默认值/实际存储值> 
     * @throws BLException
     */
	public Map<String,IG561Info> searchStatusValue(String pdid,String psdid,String prid) throws BLException{
	    //状态级私有表单值初始化
	    //key pidid,value为默认值/实际存储值
	    Map<String,IG561Info> returnmap= new HashMap<String, IG561Info>();
	    IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pdid);
        cond.setPsdid_l(psdid);
		// cond.setUsedToAll("T");
        List<IG560VWInfo> lst= ig560BL.searchIG560VW(cond);
        //默认值全局处理
        for(IG560VWInfo info:lst ){
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                IG561TB tb= new IG561TB();
                tb.setPivarvalue(info.getDfvalue());
                returnmap.put(info.getPidid(), tb);
            }
        }
        //默认值节点处理
        for(IG560VWInfo info:lst ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                IG561TB tb= new IG561TB();
                if(returnmap.get(info.getPidid()) != null){
                	tb.setPivarvalue(returnmap.get(info.getPidid()).getPivarvalue() + "#" + info.getDfvalue());
                }else{
                	tb.setPivarvalue(info.getDfvalue());
                }
                returnmap.put(info.getPidid(), tb);
            }
        }
        //实际值处理
        if(StringUtils.isNotEmpty(prid)){
            IG561SearchCondImpl cond561= new IG561SearchCondImpl();
            cond561.setPidid_l(pdid);
			if (!psdid.endsWith("002"))
            cond561.setPsdid_l(psdid);
            cond561.setPrid_q(prid);
            List<IG561Info> lst_561 = ig561BL.searchIG561(cond561);
            for(IG561Info info:lst_561){
                returnmap.put(info.getPidid(), info);
            }
        }
	    return returnmap;
	}

    /**
     * 状态级私有表单保存或更新
     * @Title: registIG561Info
     * @Description: 状态级表单保存或更新
     * @param list599 表单列表
     * @param psdid 节点id
     * @param userid 用户id
     * @param entitySaveMap 资产保存后的map
     * @throws BLException
     * wyw
     */
    public void registIG561Info(List<IG599Info> list599, String psdid,String userid,Map<String,String> entitySaveMap) throws BLException {
            IG561SearchCondImpl cond = new IG561SearchCondImpl();
            if(list599==null||list599.size()==0){
                return;
            }
            
            for(IG599Info pi : list599) {
                //判断是否状态级表单
                //2015年2月13日13:39:29 增加只读/可写，都将值转存储
                if((IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE.equals(pi.getPidaccess())||IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE.equals(pi.getPidaccess()))
                        && IGPRDCONSTANTS.PIDMODE_STATUS.equals(pi.getPidmode())) {
                    cond.setPidid_l(pi.getPidid());
                    cond.setPsdid_l(psdid);
                    cond.setPrid_q(String.valueOf(pi.getPrid()));
                    List<IG561Info> list561 = ig561BL.searchIG561(cond);
                    //没保存
                    if(list561!=null&&list561.isEmpty()) {
                        IG561TB ig561TB= new IG561TB();
                        this.copyProperties(ig561TB, pi);
                        ig561TB.setPsdid(psdid);
                        ig561TB.setPiuserid(userid);
//                        if(pi.getPiid()==null){
//                            ig561TB.setPiid(map.get(pi.getPidid()));
//                        }
                        //资产保存逻辑
                        if("4".equals(ig561TB.getPivartype())&&entitySaveMap!=null&&entitySaveMap.get(ig561TB.getPiid().toString())!=null){
                            //记录ig731主键用于区别不同的状态有不同的资产。
                            ig561TB.setPivarvalue(entitySaveMap.get(ig561TB.getPiid().toString()));
                        }
                        //保存
                        this.ig561BL.registIG561(ig561TB);
                    } else if(list561.size() == 1) {
                        IG561TB ppTB = (IG561TB) SerializationUtils.clone(list561.get(0));
                        ppTB.setPivarvalue(pi.getPivarvalue());
                        if (StringUtils.isEmpty(ppTB.getPiattkey())) {
                            ppTB.setPiattkey(pi.getPiattkey());
                        }
                        //资产保存逻辑
                        if("4".equals(ppTB.getPivartype())&&entitySaveMap!=null&&entitySaveMap.get(ppTB.getPiid().toString())!=null){
                            //记录ig731主键用于区别不同的状态有不同的资产。
                            ppTB.setPivarvalue(entitySaveMap.get(ppTB.getPiid().toString()));
                        }
                        ig561BL.updateIG561(ppTB);
                    } else {
                        throw new BLException("IGCO10000.E004", pi.getPivarname() + "状态变量值");
                    }
                    if(pi.getPiid()!=null){
                        //清空ProcessInfo中的值
                        IG599TB piTB = (IG599TB)SerializationUtils.clone(pi);
                        piTB.setPivarvalue(null);
                        piTB.setPiattkey(null);
                        piTB.setPidcomment(null);
                        this.ig599BL.updateIG599Info(piTB);
                    }
                }
            }
    }
    
    /** 
    * @Title: searchIG561VW 
    * @Description: TODO 状态级私有表单关闭节点查询
    * @param prid
    * @param userid
    * @return    
    * List<IG561VWInfo>    
    * @throws 
    */
    public List<IG561VWInfo> searchIG561VW(String prid, String userid, boolean isAdmin)throws BLException{
        return this.ig561BL.searchIG561VW(prid, userid, isAdmin);
    }
    /**
     * 状态级私有表单值检索
     */
    public List<IG561Info> searchIG561Info(IG561SearchCondImpl cond)throws BLException{
        return this.ig561BL.searchIG561(cond);
    }
    /** 
     * @Title: searchProcessByTypeStatusAndParticanpant 
     * @Description:  旧的wkm流程查询 增加导出，重新封装查询列 
     * @return    
     * List<IG500Info>    
     * @throws 
     */
    public List<Map<String, Object>> searchProcessByTypeStatusAndParticanpant(IG500SearchCond prSearchCond, int i, int j, String type) throws BLException {
            return ig500BL.queryIG500WithStatusAndPart(prSearchCond, i, j);
    }
    
    
    
    /**
     * @param prid 发起场景定义的流程id
     * @param emcproeiname 专项预案资产名称
     * @param sceneeiname 场景资产名称
     * @param scenepdid 场景定义流程的流程定义id
     * @param propentime 场景定义流程的流程发起时间
     * @throws BLException 
     */
    public void send(Integer prid,String emcproeiname,String sceneeiname,String scenepdid,String propentime) throws BLException{
    	IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
        ig898Cond.setPrid(prid);
        List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
        Map<String,List<Map<String,String>>> resultMap = new LinkedHashMap<String,List<Map<String,String>>>();
        
        Map<String,Map<String,String>> sourceMap = null;
        //每行的纵向数据 组装成 横向的数据格式
        if(participantList != null && participantList.size() >0){
        	sourceMap = new LinkedHashMap<String,Map<String,String>>();
        	for(IG898Info info : participantList){
        		String pbrownumber = info.getPvrownumber();
        		Map<String,String> restMap = sourceMap.get(pbrownumber);
        		if(restMap == null){
        			restMap = new HashMap<String,String>();
        			sourceMap.put(pbrownumber, restMap);
        		}
        		if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDNAME.equals(info.getPvcolname())){
        			restMap.put("psdname", info.getPvalue());
        		}
        		if(IGDRMCONSTANTS.DIRECT_PROCESS_PSDID.equals(info.getPvcolname())){
        			restMap.put("psdid", info.getPvalue());
        		}
        		if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
        			restMap.put("userids", info.getPvalue());
        		}
        	}
        }
        //组装数据  格式   Map<userid,List<Map<String,String>>>  List Map<String,String> 中 key: psdid,psdname
        if(sourceMap != null){
        	for(Entry<String, Map<String, String>> entry : sourceMap.entrySet()){
        		Map<String,String> valMap = entry.getValue();
        		String psdname = valMap.get("psdname");
        		String psdid = valMap.get("psdid");
        		String userids = valMap.get("userids");
        		//值得格式为  roleid#rolename_role_userid#username_user_userid#username_roleuser_roleid#rolename........
        		if(StringUtils.isNotBlank(userids)){
        			
        			//获取该节点所有的useid 并去重
        			HashSet<String> useridSet = new HashSet<String>(); 
        			
        			//角色_role_用户
        			String[] roleusers = userids.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]角色id#角色name , [1]用户id#用户name_user_用户id#用户name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null){
        						//只有角色，查询角色下所有人
        						if(roleAnduser.length == 1){
        							//角色id#角色name
        							String[] role = roleAnduser[0].split("#");
        							if(role != null && role.length > 0){
        								String roleid = role[0];
        								UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
        								cond.setRoleid(Integer.parseInt(roleid));
        								List<UserRole> userRoleList = userRoleBL.searchUserRole(cond);
        								if(userRoleList != null && userRoleList.size() > 0){
        									for(UserRole userRole : userRoleList){
        										useridSet.add(userRole.getUserid());
        									}
        								}
        							}
        						}else if(roleAnduser.length == 2){
        							//用户id#用户name
        							String[] users = roleAnduser[1].split("_user_");
        							for(String user : users){
        								if(StringUtils.isNotBlank(user)){
        									String userid = user.split("#")[0];
        									useridSet.add(userid);
        								}
        							}
        						}
        					}
        				}
        			}
        			
        			//去重后，组装数据， <userid,List<Map<String,String>>>   Map<String,String> 中 key: psdid,psdname
        			Iterator<String> iterator = useridSet.iterator(); 
        			while(iterator.hasNext()){ 
        				String userid = iterator.next();
        				if(StringUtils.isNotBlank(userid)){
			    			List<Map<String,String>> pidnames = resultMap.get(userid);
			    			if(pidnames == null || pidnames.size() <= 0){
			    				pidnames = new ArrayList<Map<String,String>>();
			    				resultMap.put(userid, pidnames);
			    			}
			    			//需判断该节点是否已添加
			    			Map<String,String> map = new LinkedHashMap<String,String>();
		    				map.put("psdname", psdname);
		    				map.put("psdid", psdid);
		    				pidnames.add(map);
			    		}
        			}
        		}
        	}
        }
        
        if(resultMap != null && !resultMap.isEmpty()){
        	//获取预计开始时间
        	ComputingTime computingTime = new ComputingTime();
        	Map<String,String> parentStepMap = computingTime.getOrderStepEstimateTime(scenepdid,"null",propentime);
        	//名称为“XXXX”的应急处置流程已启动，关联预案为“预案名称”，需要您处理的环节有预计开始时间为“XXXX”的“节点1”、预计开始时间为“XXXX”的“节点2”……。
        	String title = "“" + sceneeiname + "”应急处置流程已启动";
        	for(Entry<String,List<Map<String,String>>> entry : resultMap.entrySet()){
            	String desc = "名称为" + title + "，关联预案为“" + emcproeiname + "”，需要您处理的环节有";
        		String key = entry.getKey();
        		List<Map<String,String>> value = entry.getValue();
        		User user = userBL.searchUserByKey(key);
        		String email = user.getUseremail();
        		for(int i = 0 ;i<value.size(); i++){
        			Map<String,String> map =  value.get(i);
        			String psdname = map.get("psdname");
        			String psdid = map.get("psdid");
        			
        			String estimateTime = parentStepMap.get(psdid);
        			if(i!=0){
        				desc += "、";
        			}
        			desc += "预计开始时间为“" +estimateTime+ "”的“" +psdname+ "”";
        			
        			if(i==value.size()-1){
        				desc += "。";
        			}
        		}
        		//发送邮件
        		sendMailBL.sendMail(title, desc, new String[]{email}, new String[]{});
        	}
        }
    }
   
    /**
     * 获取场景处理人信息
     * @param prid 发起场景定义流程的流程id
     * @return
     * @throws BLException
     */
    public List<UserRoleInfo> getSceneParticipant(Integer prid) throws BLException{
    	IG898SearchCondImpl ig898Cond = new IG898SearchCondImpl();
        ig898Cond.setPrid(prid);
        List<IG898Info> participantList =  ig898BL.searchIG898(ig898Cond);
        
        List<UserRoleInfo> resultList = new ArrayList<UserRoleInfo>();
        
        Map<String,UserRoleInfo> resultMap = new HashMap<String,UserRoleInfo>();
        
        
        List<String> userlist = new ArrayList<String>();
        
        //获取所有的参与人
        if(participantList != null && participantList.size() >0){
        	for(IG898Info info : participantList){
        		if(IGDRMCONSTANTS.DIRECT_ADJUST_PARTIC.equals(info.getPvcolname())){
        			userlist.add(info.getPvalue());
        		}
        	}
        }
        //组装数据 Map<userid,UserRoleInfo>
        if(userlist != null && userlist.size() > 0){
        	for(String  userids : userlist){
        		//值得格式为  roleid#rolename_role_userid#username_user_userid#username_roleuser_roleid#rolename........
        		if(StringUtils.isNotBlank(userids)){
        			//角色_role_用户
        			String[] roleusers = userids.split("_roleuser_");
        			for(String roleuser : roleusers){
        				if(StringUtils.isNotBlank(roleuser)){
        					//[0]角色id#角色name , [1]用户id#用户name_user_用户id#用户name
        					String[] roleAnduser = roleuser.split("_role_");
        					if(roleAnduser != null){
        						//只有角色，查询角色下所有人
        						if(roleAnduser.length == 1){
        							//角色id#角色name
        							String[] role = roleAnduser[0].split("#");
        							if(role != null && role.length > 0){
        								String roleid = role[0];
        								UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
        								cond.setRoleid(Integer.parseInt(roleid));
        								List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond);
        								if(userRoleList != null && userRoleList.size() > 0){
        									for(UserRoleInfo userRole : userRoleList){
        										resultMap.put(userRole.getUserid(), userRole);
        									}
        								}
        							}
        						}else if(roleAnduser.length == 2){
        							//用户id#用户name
        							String[] users = roleAnduser[1].split("_user_");
        							for(String user : users){
        								if(StringUtils.isNotBlank(user)){
        									//只需要USERID,USERNAME,不需要重新查询
        									UserRoleVW urvw = new UserRoleVW();
        									urvw.setUserid(user.split("#")[0]);
        									urvw.setUsername(user.split("#")[1]);
        									//角色id
        									urvw.setRoleid(Integer.parseInt(roleAnduser[0].split("#")[0]));
            								resultMap.put(user.split("#")[0], urvw);
        								}
        							}
        						}
        					}
        				}
        			}
        		}
        	}
        	
        	//获取用户集合
        	if(resultMap != null && !resultMap.isEmpty()){
        		for(Entry<String,UserRoleInfo> entry : resultMap.entrySet()){
        			resultList.add(entry.getValue());
        		}
        	}
        }
        
        return resultList;
    }
}
