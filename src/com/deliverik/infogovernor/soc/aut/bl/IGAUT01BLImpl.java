/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.aut.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG108BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.soc.aut.dto.IGAUT01DTO;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0101Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0102Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0103Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0104Form;
import com.deliverik.infogovernor.soc.aut.form.IGAUT0110Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程管理_个人工作业务逻辑接口实现类
 * </p>
 * 
 * @version 1.0
 */

public class IGAUT01BLImpl implements IGAUT01BL {

	static Log log = LogFactory.getLog(IGAUT01BLImpl.class);
	
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/**CodeDetail信息BL*/
	protected CodeDetailBL codeDetailBL;
	
	/**用户角色授权信息BL*/
	protected UserRoleBL userRoleBL;
	
	/**角色信息业务BL*/
	protected RoleBL roleBL;
	
	/** 表单定义查询条件BL */
	protected IG108BL ig108BL;

	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * CodeDetail信息BL设定
	 *
	 * @param codeDetailBL CodeDetail信息BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 表单定义查询条件BL设定
	 * @param ig108bl 表单定义查询条件bL
	 */
	public void setIg108BL(IG108BL ig108bl) {
		ig108BL = ig108bl;
	}
	

	/**
	 * <p>
	 * Description: 判断当前用户是否存在流程审批权限
	 * </p>
	 * 
	 * @param dto IGAUT01DTO
	 * @return IGAUT01DTO
	 * @throws BLException
	 * @update 
	 */
	public boolean isApproveRole(String userid) throws BLException {
	    
		//流程审批标识 
		boolean approveFlag = false;
		
		// 获取当前用户角色
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(userid);
		
		// 对当前用户的角色循环判断
		for(UserRoleInfo uri:userroleList){
			// 判断用户时候存在流程审批角色
			if(WorkFlowConstDefine.APPROVE_ROLE_TYPE.equals(uri.getRoletype())){
				approveFlag = true;
				break;
			}
		}
		
		return approveFlag;
	}

	/**
	 * 查询登录用户是否是工程师
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isEngineerFlag(IGAUT01DTO dto){
		log.debug("========查询登录用户是否是工程师处理开始========");
		
		boolean flag = false;
		
		//获取登录用户
		User user = dto.getUser();
		
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoletype(IGPRDCONSTANTS.ROLETYPE_ENGINEER);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> searchUserRoleVW = userRoleBL.searchUserRoleVW(urcond, 0, 5);
		if(searchUserRoleVW != null && searchUserRoleVW.size() > 0){
			flag = true;
		}

		log.debug("========查询登录用户是否是工程师处理结束========");
		return flag;
	}
	
	/**
	 * 查询登录用户是否是服务台
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public boolean isServiceDeskFlag(IGAUT01DTO dto){
		log.debug("========查询登录用户是否是服务台处理开始========");
		
		boolean flag = false;
		
		//获取登录用户
		User user = dto.getUser();
		
		UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
		urcond.setRoletype(IGPRDCONSTANTS.ROLETYPE_SERVICE_DESK);
		urcond.setUserid(user.getUserid());
		List<UserRoleInfo> searchUserRoleVW = userRoleBL.searchUserRoleVW(urcond, 0, 5);
		if(searchUserRoleVW != null && searchUserRoleVW.size() > 0){
			flag = true;
		}
		
		log.debug("========查询登录用户是否是服务台处理结束========");
		return flag;
	}
	
	/**
	 * 查询客户下拉列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<LabelValueBean> getLstClient(IGAUT01DTO dto){
		log.debug("========查询客户下拉列表处理开始========");
		
		//记录下拉列表集合
		List<LabelValueBean> lstClient = new ArrayList<LabelValueBean>();
		
		//客户下拉列表查询条件
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CodeDefine.getCodeDefine("PROCESS_CLIENT").getCcid());
		List<CodeDetail> searchCodeDetail = codeDetailBL.searchCodeDetail(cond, 0);
		
		//将查询到的信息封装成LabelValueBean集合
		for (CodeDetail codeDetail : searchCodeDetail) {
			lstClient.add(new LabelValueBean(codeDetail.getCvalue(),codeDetail.getCdinfo()));
		}
		
		log.debug("========查询客户下拉列表处理结束========");
		return lstClient;
	}
	
	/**
	 * 查询故障流程信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO searchIGAUT0106Action(IGAUT01DTO dto){
		log.debug("========查询故障流程信息处理开始========");
		
		int totalCount = workFlowOperationBL.getProcessRecordSearchCount(dto.getPrSearchCond());
		
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		
		//分页查詢故障流程信息
		List<IG500Info> lstProcessRecord = workFlowOperationBL.searchProcessRecord(dto.getPrSearchCond(),
						pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setProcessList(lstProcessRecord);
		
		log.debug("========查询故障流程信息处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 查询工作记录
	 * </p>
	 * 
	 * @param dto IGAUT01DTO
	 * @return IGAUT01DTO
	 * @throws BLException
	 * @update sunkaiyu@deliverik.com
	 */
	
	public IGAUT01DTO getProcessRecords(IGAUT01DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
		// 查询记录总数
		int totalCount = workFlowOperationBL.searchProcessCount(dto.getPrSearchCond(), dto.getType());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			this.getProcessTemplate(dto);
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			this.getProcessTemplate(dto);
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(dto.getPrSearchCond(), pDto.getFromCount(), pDto.getPageDispCount(),dto.getType());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);
			
		
		
		log.debug("========查询工作记录处理终了========");
		return dto;
	}

	
	
	
	private void setDetailURLToDTO(IGAUT01DTO dto) throws BLException{
		Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(dto.getPrtype());
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = workFlowDefinitionBL.searchProcessTemplate(cond);
		for (IG259Info processTemplate : processTemplateList) {
			nameURLMap.put(processTemplate.getPttype(), processTemplate.getPtdetailpg());
		}
		dto.setNameURLMap(nameURLMap);
	}

	public IGAUT01DTO getProcessTemplate(IGAUT01DTO dto) throws BLException {
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
		List<IG380Info> pds = new ArrayList<IG380Info>();
		for(IG259Info pt : pts) {
			if(StringUtils.isEmpty(dto.getPrtype()) || "".equals(dto.getPrtype())){
				pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
			}else{
				if(pt.getPttype().equals(dto.getPrtype())){
					pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
				}
			}
		}
		dto.setProcessDefinitionList(pds);
		dto.setProcessTemplateList(pts);
		
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 删除流程记录
	 * </p>
	 */
	public IGAUT01DTO delProcessRecord(IGAUT01DTO dto) throws BLException {
		workFlowOperationBL.delProcessRecord(dto.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0201.I001"));
		return dto;
	}
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGAUT01DTO
	 * @throws BLException
	 */
	public IGAUT01DTO searchForwardJsp(IGAUT01DTO dto) throws BLException {
		log.debug("========流程跳转JSP页面查询处理开始========");
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(dto.getPdid());
		cond.setPdstatus("a");
		List<IG380Info> lst_IG380 = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_IG380 == null || lst_IG380.isEmpty()) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		String forward = workFlowOperationBL.searchForwardJsp(lst_IG380.get(lst_IG380.size() - 1).getPdid(), null,
				IGPRDCONSTANTS.SEARCHJSP, dto.getUser());
		dto.setForwardJsp(forward);
		log.debug("========流程跳转JSP页面查询处理结束========");
		return dto;
	}

	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0101Action(IGAUT01DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		//页面信息取得
		IGAUT0101Form form = dto.getIgaut0101From();
		List<IG108Info> piqueryList = this.ig108BL.findBypdid(form.getPrpdid());
		if(piqueryList != null){
			Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
			for(IG108Info pq:piqueryList){
				IG007TB pid = pq.getPidTB();
				map.put(pid.getPidname(), pid);
			}
			dto.setProcessInfoQueryMap(map);
		}
		log.debug("=================获取表单定义查询条件操作结束=================");
		return dto;
	}
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0102Action(IGAUT01DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		//页面信息取得
		IGAUT0102Form form = dto.getIgaut0102From();
		List<IG108Info> piqueryList = this.ig108BL.findBypdid(form.getPrpdid());
		if(piqueryList != null){
			Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
			for(IG108Info pq:piqueryList){
				IG007TB pid = pq.getPidTB();
				map.put(pid.getPidname(), pid);
			}
			dto.setProcessInfoQueryMap(map);
		}
		log.debug("=================获取表单定义查询条件操作结束=================");
		return dto;
	}
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0103Action(IGAUT01DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		//页面信息取得
		IGAUT0103Form form = dto.getIgaut0103From();
		List<IG108Info> piqueryList = this.ig108BL.findBypdid(form.getPrpdid());
		if(piqueryList != null){
			Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
			for(IG108Info pq:piqueryList){
				IG007TB pid = pq.getPidTB();
				map.put(pid.getPidname(), pid);
			}
			dto.setProcessInfoQueryMap(map);
		}
		log.debug("=================获取表单定义查询条件操作结束=================");
		return dto;
	}
	/**
	 * 获取流程表单定义查询条件
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getPivarQueryInfo0104Action(IGAUT01DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		//页面信息取得
		IGAUT0104Form form = dto.getIgaut0104From();
		List<IG108Info> piqueryList = this.ig108BL.findBypdid(form.getPrpdid());
		if(piqueryList != null){
			Map<String, IG007Info> map = new LinkedHashMap<String, IG007Info>();
			for(IG108Info pq:piqueryList){
				IG007TB pid = pq.getPidTB();
				map.put(pid.getPidname(), pid);
			}
			dto.setProcessInfoQueryMap(map);
		}
		log.debug("=================获取表单定义查询条件操作结束=================");
		return dto;
	}
	
	/**
	 * 获取带有当前处理人的本月工作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO getCurrentManagerAction(IGAUT01DTO dto)
			throws BLException {
        log.debug("========查询带有当前处理人的本月工作处理开始========");
						
		log.debug("========查询带有当前处理人的本月工作处理终了========");
		return dto;
	}

	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGAUT01DTO dto) throws BLException {
		log.debug("========根据菜单标识获取菜单名称取得处理开始========");
        //获取登录人可见菜单集合
		UserPermission userPermission = dto.getUserPermission();
		
		String titlename = "事件";
		
		//获取菜单标识
		String actname = dto.getActname();
		//获取菜单上级标识
		String actname_m1 = "";
		String actname_m2 = "";
		//当获取的菜单标识是三级菜单时
		if(StringUtils.isNotEmpty(actname) && actname.length() > 10){//start if 1
			//获取一级菜单和二级菜单标识
			actname_m1 = actname.substring(0, 8);
			actname_m2 = actname.substring(0, 10);
			//获取菜单集合
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = userPermission.getActionList();
			tit: for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map: actionList) {//start for 1
				
				//获取一级菜单
				Set<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> set_m1 = map.entrySet();
				for(Iterator<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> iter_m1 = set_m1.iterator();
					iter_m1.hasNext();){//start for 2
					
					//找到对应的一级菜单
					Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> next_m1 = iter_m1.next();
					if(actname_m1.equals(next_m1.getKey().getActname())){//start if 2
						
						//记录二级菜单信息List
						List<Map<Action, List<Map<Action, List<Action>>>>> list_m2 = next_m1.getValue();
						for (Map<Action, List<Map<Action, List<Action>>>> map_m2 : list_m2) {//start for 3
							
							//获取二级菜单
							Set<Entry<Action, List<Map<Action, List<Action>>>>> set_m2 = map_m2.entrySet();
							for(Iterator<Entry<Action, List<Map<Action, List<Action>>>>> iter_m2 = set_m2.iterator();
								iter_m2.hasNext();){//start for 4
								
								//找到对应的二级菜单
								Entry<Action, List<Map<Action, List<Action>>>> next_m2 = iter_m2.next();
								if(actname_m2.equals(next_m2.getKey().getActname())){ //start if 3
									
									//记录三级菜单信息List
									List<Map<Action, List<Action>>> list_m3 = next_m2.getValue();
									for (Map<Action, List<Action>> map_m3 : list_m3) {//start for 5
										
										//获取三级菜单
										Set<Entry<Action, List<Action>>> set_m3 = map_m3.entrySet();
										for(Iterator<Entry<Action, List<Action>>> iter_m3= set_m3.iterator();
											iter_m3.hasNext();){//start for 6
											
											//找到对应的三级菜单
											Entry<Action, List<Action>> next_m3 = iter_m3.next();
											//找到对应的三级菜单
											if(actname.equals(next_m3.getKey().getActname())){
												titlename = next_m3.getKey().getActlabel();
												break tit;
											}
										}//end for 6
									}//end for 5
								}//end if 3
							}//end for 4
						}//end for 3
					}//end if 2
				}//end for 2
			}//end for 1
		}//end if 1
		
        log.debug("========根据菜单标识获取菜单名称取得处理终了========");
		return titlename;
	}
	
	/**
	 * 根据PDID获取启用的流程PDID
	 */
	public IGAUT01DTO searchPdid7BitAction(IGAUT01DTO dto) throws BLException {
		log.debug("========当前流程类型启用版本的PDID取得处理开始========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(dto.getPdid());
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(ig380infoList.size() - 1).getPdid());
        }
        //查询该流程定义下的所有流程状态
        IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
        ig333Cond.setPdid(dto.getPdid());
        List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
        dto.setIG333InfoList(ig333Infos);
        log.debug("========当前流程类型启用版本的PDID取得处理终了========");
		return dto;
	}
	
    
    /**
	 * 流程查询操作
	 * @param dto 
	 * @return
	 * @throws BLException
	 */
	public IGAUT01DTO searchProcessRecordAction(IGAUT01DTO dto) throws BLException{
		log.debug("===========流程查询操作开始=============");
		//dto参数取得
		IGAUT0110Form form = dto.getIgaut0110Form();
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		try {
			BeanUtils.copyProperties(cond,form);
		} catch (Exception e) {
			log.error("",e);
		}
		// 查询记录总数
		int totalCount = workFlowOperationBL.searchProcessCount(cond, form.getType());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond, pDto.getFromCount(), pDto.getPageDispCount(),form.getType());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("===========流程查询操作结束=============");
		return dto;
	}
	
}