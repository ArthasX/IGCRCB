/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.iam.bl;

import java.lang.reflect.InvocationTargetException;
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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG108BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.CurrentMonthWorkVWInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.CurrentMonthWorkVWSearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.infogovernor.iam.dto.IGIAM01DTO;
import com.deliverik.infogovernor.iam.dto.IGIAM05DTO;
import com.deliverik.infogovernor.iam.form.IGIAM0503Form;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;
import com.deliverik.infogovernor.wkm.form.IGWKM0102Form;

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

public class IGIAM05BLImpl implements IGIAM05BL {

	static Log log = LogFactory.getLog(IGIAM05BLImpl.class);
	
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
	
	/** 流程定义表BL */
	protected IG380BL ig380BL;
	
	/** 流程状态BL */
	protected IG333BL ig333BL;
	
	/** 表单定义查询条件BL */
	protected IG108BL ig108BL;

	/**流程模板类型BL*/
    protected IG259BL ig259BL;

    protected IG599BL ig599BL;
    
    

	/**
     * ig599BL设定
     *
     * @param ig599bl ig599BL
     */
    public void setIg599BL(IG599BL ig599bl) {
        ig599BL = ig599bl;
    }

    /**
     * 流程模板类型BL设定
     *
     * @param ig259bl ig259BL
     */
    public void setIg259BL(IG259BL ig259bl) {
        ig259BL = ig259bl;
    }

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
	 * 流程定义表BL设定
	 * @param ig380BL 流程定义表BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	
	
	/**
	 * 流程状态BL设定
	 * @param ig333BL 流程状态BL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
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
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
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
	public boolean isEngineerFlag(IGWKM01DTO dto){
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
	public boolean isServiceDeskFlag(IGWKM01DTO dto){
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
	public List<LabelValueBean> getLstClient(IGWKM01DTO dto){
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
	public IGWKM01DTO searchIGWKM0106Action(IGWKM01DTO dto){
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
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
	 * @throws BLException
	 * @update sunkaiyu@deliverik.com
	 */
	
	public IGWKM01DTO getProcessRecords(IGWKM01DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
	
		IG500SearchCondImpl searchCondImpl = new IG500SearchCondImpl();
		try {
            BeanUtils.copyProperties(searchCondImpl, dto.getIgwkm0101From());
        } catch (IllegalAccessException e) {
          log.error(e);
        } catch (InvocationTargetException e) {
            log.error(e);
        }
		// 查询记录总数
		int totalCount = workFlowOperationBL.searchProcessCount(searchCondImpl, dto.getType());
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
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(searchCondImpl, pDto.getFromCount(), pDto.getPageDispCount(),dto.getType());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);
			
		
		log.debug("========查询工作记录处理终了========");
		return dto;
	}

	
	
	
	private void setDetailURLToDTO(IGWKM01DTO dto) throws BLException{
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

	public IGWKM01DTO getProcessTemplate(IGWKM01DTO dto) throws BLException {
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
	
   public IGIAM05DTO getProcessTemplate(IGIAM05DTO dto) throws BLException {
        IG259SearchCondImpl cond = new IG259SearchCondImpl();
        cond.setIsWorkPt(1);
        cond.setPttype(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE);
        List<IG259Info> pts = workFlowDefinitionBL.searchProcessTemplate(cond);
        List<IG380Info> pds = new ArrayList<IG380Info>();
        for(IG259Info pt : pts) {
            pds.addAll(workFlowDefinitionBL.searchProcessDefinitionsByPtid(pt.getPtid()));
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
	public IGWKM01DTO delProcessRecord(IGWKM01DTO dto) throws BLException {
		workFlowOperationBL.delProcessRecord(dto.getPrid());
		dto.addMessage(new ActionMessage("IGSVC0201.I001"));
		return dto;
	}
	
	/**
	 * 流程查询JSP取得
	 * @param dto
	 * @return IGWKM01DTO
	 * @throws BLException
	 */
	public IGWKM01DTO searchForwardJsp(IGWKM01DTO dto) throws BLException {
		log.debug("========流程跳转JSP页面查询处理开始========");
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPdid_like(dto.getPdid());
		cond.setPdstatus("a");
		List<IG380Info> lst_IG380 = workFlowDefinitionBL.searchProcessDefinition(cond);
		if(lst_IG380.size() != 1) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		String forward = workFlowOperationBL.searchForwardJsp(lst_IG380.get(0).getPdid(), null,
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
	public IGWKM01DTO getPivarQueryInfoAction(IGWKM01DTO dto) throws BLException {
		log.debug("=================获取表单定义查询条件操作开始=================");
		//页面信息取得
		IGWKM0101Form form = dto.getIgwkm0101From();
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
	public IGWKM01DTO getCurrentManagerAction(IGWKM01DTO dto)
			throws BLException {
        log.debug("========查询带有当前处理人的本月工作处理开始========");
        IGWKM0102Form form = dto.getIgwkm0102From();
		// 当前用户id
		String userid = dto.getUser().getUserid();
		// 获取当前用户角色
		List<UserRoleInfo> userroleList = userRoleBL.getUserRoles(userid);
		String[] roleid=null;
		if(userroleList!=null&&userroleList.size()>0){			
			roleid = new String[userroleList.size()];
			//将当前登录者的所有角色遍历出来，放到一个数组中
			int index=0;
			for(UserRoleInfo info:userroleList){
				roleid[index]=String.valueOf(info.getRoleid());
				index++;
			}
		}
//		
//		
//		//流程类型
//		String prtype = dto.getPrSearchCond().getPrtype();
//		// --指派工作--
//		if(!IGEXTWBBLType.PROCESS_PERSON_TYPE.equals(prtype)){
//			
//			boolean flag = false;//流程管理员标识
//			for(UserRoleInfo uri:userroleList){
//				//判断是否为流程管理员
//				if(roleBL.isProcessAdminRole(uri.getRoleid())){
//					flag = true;
//					break;
//				}
//			}
//			// 判断是否为流程管理员,流程管理员可以查看全部的该类型流程
//			if(flag){
//				dto.setIsAdmin("1");
//			}
//		}
		
		
		// 查询记录总数
//		int totalCount = workFlowOperationBL.getProcessRecordSearchCount(dto.getPrSearchCond());
		//实例化查询条件
		CurrentMonthWorkVWSearchCondImpl cond = new CurrentMonthWorkVWSearchCondImpl();	
		cond.setMonth(IGStringUtils.getCurrentDate().substring(0, 7));
		cond.setRoleid(roleid);
		if(StringUtils.isNotEmpty(form.getOrder())){			
			cond.setOrder(form.getOrder());
			cond.setSing(form.getSing());
		}
		int totalCount = workFlowOperationBL.SearchCurrentWorkWithManageCount(cond);
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
		List<CurrentMonthWorkVWInfo> cmList = workFlowOperationBL.SearchCurrentWorkWithManage(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setCurrentManagerList(cmList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		this.getProcessTemplate(dto);							
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
	public String getActionName(IGWKM01DTO dto) throws BLException {
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
	public IGWKM01DTO searchPdid7BitAction(IGWKM01DTO dto) throws BLException {
		log.debug("========当前流程类型启用版本的PDID取得处理开始========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like(dto.getIgwkm0101From().getPrpdid_like_or()[0]);
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = this.ig380BL.searchIG380Info(condImpl);
        if (ig380infoList.size() == 0) {
            throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(0).getPdid());
        }
        //查询该流程定义下的所有流程状态
        IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
        ig333Cond.setPdid(dto.getPdid());
        List<IG333Info> ig333Infos = ig333BL.searchIG333Info(ig333Cond);
        dto.setIG333InfoList(ig333Infos);
        log.debug("========当前流程类型启用版本的PDID取得处理终了========");
		return dto;
	}

	/**
     * <p>
     * Description: 获取处理显示状态（处理按钮权限）
     * </p>
     * 
     * @param dto IGRAM01DTO
     * @return IGRAM01DTO
     * @throws BLException
     * @author
     * @update
     */
    public IGIAM01DTO searchProcessDef(IGIAM01DTO dto)
            throws BLException {
        //查询风险评估
        Map<IG259Info,List<IG380Info>> templateDefinitionMap = new HashMap<IG259Info,List<IG380Info>>();
        IG259Info ig259 = ig259BL.searchIG259InfoByKey(Integer.parseInt(dto.getPtid()));
        
        IG380SearchCondImpl cond = new IG380SearchCondImpl();
        cond.setPtid(Integer.parseInt(dto.getPtid()));
        cond.setPdstatus("a");
        String[] pdid  = dto.getPdid();
        List<IG380Info> ig380List = new ArrayList<IG380Info>();
        for (int i = 0; i < pdid.length; i++) {
            cond.setPdid_like(pdid[i]);
            ig380List.addAll(ig380BL.searchIG380Info(cond));
        }
        templateDefinitionMap.put(ig259, ig380List);
        dto.setTemplateDefinitionMap(templateDefinitionMap);
        return dto;
    }   
	
    
    /**
     * <p>
     * Description: 查询问题整改记录
     * </p>
     * 
     * @param dto IGSVC11DTO
     * @return IGSVC11DTO
     * @throws BLException
     * @update huiyongzhi
     */
    
    public IGIAM05DTO getProcessRecords(IGIAM05DTO dto) throws BLException {
        log.debug("========查询问题整改记录处理开始========");
        IGIAM0503Form form = dto.getIgiam0503Form();
        
        IG500SearchCondImpl cond = new IG500SearchCondImpl(); 
        cond.setVarnames(new String[]{IGIAMCONSTANT.PROJECT_LABEL});
        cond.setVarvalues(new String[]{form.getPrcorid()});
        int totalCount = workFlowOperationBL.queryIG500EntityCount(cond);
        if (totalCount == 0) {
            log.debug("========查询数据不存在========");
            // 查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========查询数据数量过多========");
            // 查询数据件数过多
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        // 获取分页bean
        PagingDTO pDto = dto.getPagingDto();
        List<IG500Info> prList = workFlowOperationBL.queryIG500EntityListByProcessInfo(cond, pDto.getFromCount(), pDto.getPageDispCount());
        pDto.setTotalCount(totalCount);
        dto.setProcessInfos(prList);
        dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
        log.debug("========查询问题整改记录处理终了========");
        return dto;
    }
    
}