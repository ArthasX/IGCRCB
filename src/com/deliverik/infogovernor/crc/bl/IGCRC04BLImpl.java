/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.crc.dto.IGCRC04DTO;
import com.deliverik.infogovernor.crc.form.IGCRC0401Form;
import com.deliverik.infogovernor.crc.form.IGCRC0402Form;
import com.deliverik.infogovernor.crc.form.IGCRC0403Form;
import com.deliverik.infogovernor.crc.form.IGCRC0405Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.dev.crc.igflow.event.status.IGCRC0401BLImpl;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更处理BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCRC04BLImpl extends BaseBLImpl implements IGCRC04BL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC0401BLImpl.class);

	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** 流程处理类API */
	protected FlowOptBL flowOptBL;

	protected RoleActionBL roleActionBL;

	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/** 流程定义业务BL */
	protected IG380BL ig380BL;

	/** 平台用户BL */
	protected UserBL userBL;

	/** 查询类API */
	protected FlowSearchBL flowSearchBL;

	/**
	 * 流程处理BL设定
	 * 
	 * @param workFlowOperationBL
	 *            流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 流程定义BL设定
	 * 
	 * @param workFlowDefinitionBL
	 *            流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * @param roleActionBL
	 *            the roleActionBL to set
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * 流程处理类API设定
	 * 
	 * @param flowOptBL
	 *            流程处理类API
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 更新类API设定
	 * 
	 * @param flowSetBL
	 *            更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 平台用户BL设定
	 * 
	 * @param userBL
	 *            平台用户BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * 查询类API设定
	 * 
	 * @param flowSearchBL
	 *            查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 流程定义业务BL设定
	 * 
	 * @param ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * 流程查询操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO searchProcessRecords(IGCRC04DTO dto) throws BLException {
		log.debug("===============流程查询操作开始=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			// dto参数取得
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			// 取得没有版本的pdid
			StringBuffer pdid = new StringBuffer(form.getPdid());
			IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
			cond380.setPdid_like(pdid.toString());
			// 获取所有的流程摸版
			List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);

			// 获取该流程的最大版本
			if(form.getPrstatus().length() == 3){
				String maxpdid = list380.get(list380.size()-1).getPdid().concat(form.getPrstatus());
				form.setPrstatus(maxpdid);
			}
			User user = dto.getUser();
			IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(form.getPrstatus());
			IG500SearchCondImpl cond = new IG500SearchCondImpl();
			this.copyProperties(cond, form);
			cond.setPrpdid(form.getPdid());
			cond.setPrstatus(psd.getPsdcode());
			cond.setUserid_q(user.getUserid());
			cond.setPcode("Y");
			List<IG500Info> list = workFlowOperationBL.searchProcessByType(cond, 0, 0, IGPRDCONSTANTS.SEARCH_MY_UN_PROCESSED);

			List<IG500Info> finalList = new ArrayList<IG500Info>();
			if (psd.getPsdcode() != null && psd.getPsdcode().equals("R")) {
				for (int i = 0; i < list.size(); i++) {
					Integer prid = list.get(i).getPrid();
					String className = flowSearchBL.searchPublicProcessInfo(Integer.valueOf(prid), "变更类型");
					if (className != null && !(className.equals("")) && !(className.contains("系统网络类"))) {
						finalList.add(list.get(i));
					}
				}
				dto.setProcessList(finalList);
			} else {
				dto.setProcessList(list);
			}
		}
		log.debug("===============流程查询操作结束=================");
		return dto;
	}

	/**
	 * 变更批量处理页面初始化操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initIGCRC0402Action(IGCRC04DTO dto) throws BLException {
		log.debug("=================变更批量处理页面初始化操作开始================");
		// dto参数取得
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0402Form) {
			IGCRC0402Form form = (IGCRC0402Form) dto.getForm();

			if (form.getPrstatus() != null) {
				form.setStatusCode(form.getPrstatus().substring(7));
			}

			if (form.getPrid() != null && form.getPrid().length > 0) {
				StringBuffer prids = new StringBuffer();
				for (int i = 0; i < form.getPrid().length; i++) {
					if (i > 0) {
						prids.append(",");
					}
					prids.append(form.getPrid()[i]);
				}
				IG500SearchCondImpl cond = new IG500SearchCondImpl();
				cond.setPrid_in(prids.toString());
				List<IG500Info> list = workFlowOperationBL.searchProcessByType(cond, 0, 0, null);
				dto.setProcessList(list);
			}
		}
		log.debug("=================变更批量处理页面初始化操作结束================");
		return dto;
	}

	/**
	 * 变更批量处理操作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO disposeAction(IGCRC04DTO dto) throws BLException {
		log.debug("==============变更批量处理操作开始===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0402Form) {
			// dto参数取得
			IGCRC0402Form form = (IGCRC0402Form) dto.getForm();
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				List<IG333Info> list = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				if (list != null && list.size() > 0) {
					form.setForward("ASSIGN");
				}
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// 获取用户处理角色
					UserRoleInfo ur = this.workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
					// 取得表单信息
					if (form.getPivarnames() != null && form.getPivarnames().length > 0 && form.getPivarvalues() != null && form.getPivarvalues().length > 0 && form.getPivarnames().length == form.getPivarvalues().length) {
						for (int i = 0; i < form.getPivarnames().length; i++) {
							WorkFlowLog logInfo = new WorkFlowLog();
							logInfo.setPrid(prid);
							logInfo.setExecutorid(user.getUserid());
							logInfo.setExecutorRoleid(ur.getRoleid());
							PublicProcessInfoValue value = new PublicProcessInfoValue(logInfo);
							value.setFormname(form.getPivarnames()[i]);
							value.setFormvalue(form.getPivarvalues()[i]);
							flowSetBL.setPublicProcessInfoValue(value);
						}
					}
					// 添加日志
					if (StringUtils.isNotEmpty(form.getRlcomment()) || (form.getFileMap() != null && !form.getFileMap().isEmpty())) {
						workFlowOperationBL.addRecordLog(prid, user, ur.getRoleid(), form.getRlcomment(), form.getButtonName(), form.getFileMap(), IGPRDCONSTANTS.RECORDLOG_TYPE_CL, null, null);
					}
					if (!"ASSIGN".equals(form.getForward())) {
						// 跃迁
						flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
					}
				}
				if ("ASSIGN".equals(form.getForward())) {
					dto.addMessage(new ActionMessage("IGCRC0401.I001"));
				}
			}
		}
		log.debug("==============变更批量处理操作结束===============");
		return dto;
	}

	/**
	 * 初始化分派页面
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO initAssignPageAction(IGCRC04DTO dto) throws BLException {
		log.debug("===============分派页面初始化操作开始===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto参数取得
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			// 可被分派节点查询
			List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
			for (int i = 0; i < lst_ProcessStatusDef.size(); i++) {
				if (lst_ProcessStatusDef.get(i).getPsdname() != null && lst_ProcessStatusDef.get(i).getPsdname().equals("标准变更执行")) {
					lst_ProcessStatusDef.remove(i);
				}
			}
			Map<IG333Info, Map<Role, List<UserInfo>>> map = new LinkedHashMap<IG333Info, Map<Role, List<UserInfo>>>();
			for (IG333Info psd : lst_ProcessStatusDef) {
				map.put(psd, new LinkedHashMap<Role, List<UserInfo>>());
				// 查询可分派角色
				List<IG298Info> lst_ProcessStatusRoleDef = this.workFlowDefinitionBL.searchProcessStatusRoleDefInfoByPsdid(psd.getPsdid());
				for (IG298Info psrd : lst_ProcessStatusRoleDef) {
					UserInfoSearchCondImpl userInfoCond = new UserInfoSearchCondImpl();
					userInfoCond.setRoleida(psrd.getRoleid());
					if (IGPRDCONSTANTS.PSDORG_YES.equals(psd.getPsdorg())) {
						userInfoCond.setOrgida(dto.getUser().getOrgid());
					}
					map.get(psd).put(psrd.getRole(), userBL.searchUserInfo(userInfoCond));
				}
			}
			dto.setAssignInfo(map);
		}
		log.debug("===============分派页面初始化操作结束===============");
		return dto;
	}

	/**
	 * 变更批量
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public IGCRC04DTO assignAction(IGCRC04DTO dto) throws BLException {
		log.debug("================变更批量操作开始===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto参数取得
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
				cond380.setPdid_like("01001");// 变更流程
				List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
				// 可被分派节点查询
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size() - 1).getPdid() + "001", "10");
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);

					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(3029);

					// 删除原来节点参与者
					StatusParticipant participant = new StatusParticipant(logInfo);
					for (IG333Info psd : lst_ProcessStatusDef) {
						participant.setStatuscode(psd.getPsdid());
						flowSetBL.deleteStatusParticipant(participant);
					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// 跃迁流程
					flowOptBL.transitionProcess(prid, user.getUserid(), "审核通过", IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================变更批量操作结束===============");
		return dto;
	}

	/**
	 * 检查工作批量
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unused")
	public IGCRC04DTO assignWorkAction(IGCRC04DTO dto) throws BLException {
		log.debug("================检查工作批量操作开始===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto参数取得
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			form.setPrid(dto.getPrid());
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				IG380SearchCondImpl cond380 = new IG380SearchCondImpl();
				cond380.setPdid_like("01001");// 变更流程
				List<IG380Info> list380 = ig380BL.searchIG380Info(cond380);
				// 可被分派节点查询
//				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(list380.get(list380.size()-1).getPdid()+"001","10");
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);

					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(3029);
					// 更新表单值
					PublicProcessInfoValue publicProcessInfoValueInfo = new PublicProcessInfoValue(logInfo);
					publicProcessInfoValueInfo.setFormname("分派标示");
					// 如果执行节点分派人员，分派标示为1，否则为0
					if (form.getParticipants() != null) {
						int temp = 0;
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							cond380.setPdid_like("01140");// 检查工作流程
							list380 = ig380BL.searchIG380Info(cond380);
							if ((list380.get(list380.size() - 1).getPdid() + "004").equals(info[0])) {
								publicProcessInfoValueInfo.setFormvalue("2");
								temp = 1;
							}
						}
						if (temp == 0) {
							publicProcessInfoValueInfo.setFormvalue("1");
						}
					}

					flowSetBL.setPublicProcessInfoValue(publicProcessInfoValueInfo);

					// 删除原来节点参与者
					StatusParticipant participant = new StatusParticipant(logInfo);
//					for (IG333Info psd : lst_ProcessStatusDef) {
//						participant.setStatuscode(psd.getPsdid());
//						flowSetBL.deleteStatusParticipant(participant);
//					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// 跃迁流程
					flowOptBL.transitionProcess(prid, user.getUserid(), "提交", IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================检查工作批量操作结束===============");
		return dto;
	}

	/**
	 * 获取发起角色ID
	 * 
	 * @return 发起角色ID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		// 获取具有"季报发起"菜单的角色ID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname("ACT04RIS0302");
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if (lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "填报发起角色");
		}
		return lst_RoleAction.get(0).getRoleid();
	}

	/**
	 * 变更批量
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO assignSecureAction(IGCRC04DTO dto) throws BLException {
		log.debug("================变更批量操作开始===============");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0403Form) {
			// dto参数取得
			IGCRC0403Form form = (IGCRC0403Form) dto.getForm();
			User user = dto.getUser();
			if (form.getPrid() != null && form.getPrid().length > 0) {
				// 可被分派节点查询
				List<IG333Info> lst_ProcessStatusDef = workFlowDefinitionBL.searchAssignedStatusDef(form.getPrstatus(), form.getButtonCode());
				for (Integer prid : form.getPrid()) {
					IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(prid);
					// 获取用户处理角色
					UserRoleInfo ur = this.workFlowOperationBL.getUserRolesInProcessParticipants(prid, user.getUserid(), pr.getPrpdid() + form.getPrstatus().substring(7)).get(0);
					WorkFlowLog logInfo = new WorkFlowLog();
					logInfo.setPrid(prid);
					logInfo.setExecutorid(user.getUserid());
					logInfo.setExecutorRoleid(ur.getRoleid());
					// 删除原来节点参与者
					StatusParticipant participant = new StatusParticipant(logInfo);
					for (IG333Info psd : lst_ProcessStatusDef) {
						participant.setStatuscode(psd.getPsdid());
						flowSetBL.deleteStatusParticipant(participant);
					}
					if (form.getParticipants() != null) {
						for (String str : form.getParticipants()) {
							String[] info = str.split("_");
							participant.setStatuscode(info[0]);
							participant.setRoleid(Integer.valueOf(info[1]));
							participant.setUserid(info[2]);
							flowSetBL.setStatusParticipant(participant);
						}
					}
					// 跃迁流程
					flowOptBL.transitionProcess(prid, user.getUserid(), form.getButtonName(), IGStringUtils.getCurrentDateTime());
				}
			}
			dto.addMessage(new ActionMessage("IGCRC0401.I001"));
		}
		log.debug("================变更批量操作结束===============");
		return dto;
	}

	/**
	 * 获取流程表单定义查询条件
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getPivarQueryInfoAction(IGCRC04DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			// dto参数取得
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			List<IG108Info> piqueryList = workFlowDefinitionBL.searchFormQueryDefByPdid(form.getPdid());
			if (piqueryList != null) {
				Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
				for (IG108Info pq : piqueryList) {
					IG007TB pid = pq.getPidTB();
					map.put(pid.getPidname(), pid);
				}
				dto.setProcessInfoQueryMap(map);
			}
		}
		log.debug("=================获取表单定义查询条件操作结束=================");
		return dto;
	}

	/**
	 * 导出变更管理Excel
	 * 
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getExcelDataList(IGCRC04DTO dto) throws BLException {
		log.debug("=================获取变更管理相应数据集开始=================");
		IGWKM0101Form form = dto.getIgwkm0101form();
		if (StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())) {
			form.setOrder("propentime");
			form.setSing("desc");
		}
		// 查询流程信息条件
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		// 变更管理类型编号
		cond.setPrpdid(form.getPrpdid());
		cond = copyPropertie(dto.getIgwkm0101form(), cond);
		// 查询流程信息
		dto.setProcessList(workFlowOperationBL.searchProcessByType(cond, 0, 0, form.getType()));

		// 查询表单信息条件
		IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
		// 变更管理类型编号
		processInfoCond.setPdid(form.getPrpdid());
		// 查询表单信息
		dto.setProcessInfoList(workFlowOperationBL.searchProcessInfoByCond(processInfoCond));

		// 查询参与人信息条件(暂无)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		// 查询参与人信息
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));

		// 查询流状态定义信息条件
		IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
		// 变更管理类型编号
		processStatusDefCond.setPsdid_like(form.getPrpdid());
		// 查询流状态定义
		dto.setProcessStatusDefList(workFlowDefinitionBL.searchProcessStatusDef(processStatusDefCond));
		log.debug("=================获取变更管理相应数据集结束=================");
		return dto;
	}

	/**
	 * 取得主流程信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getParentProcessInfoAction(IGCRC04DTO dto) throws BLException {
		log.debug("================取得主流程信息操作开始=================");
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0401Form) {
			IGCRC0401Form form = (IGCRC0401Form) dto.getForm();
			IG500Info info = workFlowOperationBL.searchProcessRecordByKey(form.getParprid());
			Map<String, String> map = new HashMap<String, String>();
			if (info.getPrpdname().indexOf("程序开发") >= 0) {
				map.put("prtitle", info.getPrtitle());
				map.put("prdesc", info.getPrdesc());
				map.put("type", "success");
			} else {
				map.put("type", "other");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("================取得主流程信息操作结束=================");
		return dto;
	}

	/**
	 * 复制属性
	 * 
	 * @param form
	 * @param cond
	 * @return
	 */
	private IG500SearchCondImpl copyPropertie(IGWKM0101Form form, IG500SearchCondImpl cond) {
		// 复制工单号属性
		if (form.getPrserialnum() != null && !(form.getPrserialnum().equals(""))) {
			cond.setPrserialnum(form.getPrserialnum());
		}
		// 复制工单名称的属性
		if (form.getPrtitle() != null && !(form.getPrtitle().equals(""))) {
			cond.setPrtitle(form.getPrtitle());
		}
		// 复制查询开始时间
		if (form.getPropentime() != null && !(form.getPropentime().equals(""))) {
			cond.setPropentime(form.getPropentime());
		}
		// 复制查询结束时间
		if (form.getPrclosetime() != null && !(form.getPrclosetime().equals(""))) {
			cond.setPrclosetime(form.getPrclosetime());
		}
		// 判断工单状态
		if (form.getPrstatus() != null && !(form.getPrstatus().equals(""))) {
			cond.setPrstatus(form.getPrstatus());
		}
		// 判断发起人
		if (form.getPrusername() != null && !(form.getPrusername().equals(""))) {
			cond.setPrusername(form.getPrusername());
		}
		// 复制表单名称
		if (form.getVarnames() != null && form.getVarnames().length > 0) {
			cond.setVarnames(form.getVarnames());
		}
		// 复制表单值
		if (form.getVarvalues() != null && form.getVarvalues().length > 0) {
			cond.setVarvalues(form.getVarvalues());
		}
		return cond;
	}

	/**
	 * 取得日志附件
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC04DTO getRecordLogAttachmentAction(IGCRC04DTO dto) throws BLException {
		log.debug("=================日志附件取得操作开始===================");
		// dto参数取得
		if (dto.getForm() != null && dto.getForm() instanceof IGCRC0405Form) {
			IGCRC0405Form form = (IGCRC0405Form) dto.getForm();
			// 流程信息查询
			IG500Info pr = workFlowOperationBL.searchProcessRecordByKey(form.getPrid());
			// 查询处理人
			List<ParticipantInfo> ppList = flowSearchBL.searchStatusParticipant(form.getPrid(), "标准变更执行");
			// 取得日志信息
			List<IG036Info> recordList = dto.getRecordList();
			boolean flag = true;
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			for (int i = recordList.size() - 1; i >= 0; i--) {
				IG036Info rl = recordList.get(i);
				if (rl.getAttachmentList() != null && rl.getAttachmentList().size() > 0) {
					if (rl.getRluserid().equals(pr.getPruserid()) || checkPP(ppList, rl.getRluserid())) {
						map.put("status", "success");
						List<Map<String, String>> list = new ArrayList<Map<String, String>>();
						for (Attachment att : rl.getAttachmentList()) {
							Map<String, String> temp = new HashMap<String, String>();
							temp.put("attid", att.getAttid() + "");
							temp.put("attname", att.getAttname().substring(att.getAttname().indexOf("_") + 1));
							list.add(temp);
						}
						map.put("content", list);
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				map.put("status", "error");
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(map));
		}
		log.debug("=================日志附件取得操作结束===================");
		return dto;
	}

	private boolean checkPP(List<ParticipantInfo> ppList, String rluserid) {
		if (ppList != null && ppList.size() > 0) {
			for (ParticipantInfo pp : ppList) {
				if (rluserid.equals(pp.getUserid())) {
					return true;
				}
			}
		}
		return false;
	}
}
