/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 自定义流程辅助功能BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR03BLImpl extends BaseBLImpl implements IGPRR03BL{
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGPRR03BLImpl.class);
	
	/** OA角色配置BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 角色信息BL */
	protected RoleBL roleBL;
	
	/** 用户角色BL */
	protected UserRoleBL userRoleBL;
	
	/**
	 * OA角色配置BL设定
	 * @param workFlowDefinitionBL OA角色配置BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 角色信息BL设定
	 * @param roleBL 角色信息BL
	 */
	public final void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * 用户角色BL设定
	 * @param userRoleBL 用户角色BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 角色信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleListAction(IGPRR03DTO dto) throws BLException {
		log.debug("==========角色信息查询操作开始===========");
		//页面信息取得
		IGPRR0302Form form = dto.getIgprr0302Form();
		//实例化查询条件
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename_q(form.getRolename_q());
		cond.setRoletype(form.getRoletype());
		cond.setRoleid_not_in(form.getRoleids());
		if(StringUtils.isNotEmpty(form.getRoleidin())){
			List<Integer> roleids = new ArrayList<Integer>();
			String[] split = form.getRoleidin().split(",");
			for(String s:split){
				roleids.add(Integer.valueOf(s));
			}
			cond.setRoleid_in(roleids);
		}
		// 查询记录总数
		int totalCount = roleBL.getRoleSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<Role> roleList = roleBL.searchRole(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleList(roleList);
		log.debug("==========角色信息查询操作结束===========");
		return dto;
	}
	
	/**
	 * 查询角色配置信息
	 * @param dto
	 * @return
	 */
	public IGPRR03DTO searchIG001InfoListAction(IGPRR03DTO dto) throws BLException {
		log.debug("===========角色配置信息查询操作开始============");
		//查询角色配置的所有信息
		List<IG001Info> allList = workFlowDefinitionBL.searchOARoleConfig(new IG001SearchCondImpl());
		//负责人角色集合
		List<IG001Info> ig001List_A = new ArrayList<IG001Info>();
		//值班人角色集合
		List<IG001Info> ig001List_B = new ArrayList<IG001Info>();
		//执行人角色集合
		List<IG001Info> ig001List_C = new ArrayList<IG001Info>();
		//非空判断
		if(allList!=null){
			for(IG001Info pro:allList){
				//如果是负责人
				if(IGPRDCONSTANTS.OA_ROLE_A.equals(pro.getProtype())){
					ig001List_A.add(pro);
				//如果是值班人
				}else if(IGPRDCONSTANTS.OA_ROLE_B.equals(pro.getProtype())){
					ig001List_B.add(pro);
				//如果是执行人
				}else if(IGPRDCONSTANTS.OA_ROLE_C.equals(pro.getProtype())){
					ig001List_C.add(pro);
				}
				
			}
			//将负责人配置放入dto
			dto.setIg001List_A(ig001List_A);
			//将执行人配置放入dto
			dto.setIg001List_B(ig001List_B);
			//将执行人配置方入dto
			dto.setIg001List_C(ig001List_C);
		}
		log.debug("===========角色配置信息查询操作结束============");
		return dto;
	}
	
	/**
	 * 角色配置信息删除操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO deleteIG001Action(IGPRR03DTO dto) throws BLException{
		log.debug("===========角色配置信息删除操作开始=============");
		//页面信息取得
		IGPRR0301Form form = dto.getIgprr0301Form();
		//实例化要删除的对象
		List<IG001Info> delList = new ArrayList<IG001Info>();
		
		//如果删除的是负责人配置，实例化负责人配置信息
		if(IGPRDCONSTANTS.OA_ROLE_A.equals(form.getDeleteFlag())){
			if(form.getProids_A()!=null&&form.getProids_A().length>0){
				for(Integer proid:form.getProids_A()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		//如果删除的是值班人配置，实例化值班人配置信息
		}else if(IGPRDCONSTANTS.OA_ROLE_B.equals(form.getDeleteFlag())){
			if(form.getProids_B()!=null&&form.getProids_B().length>0){
				for(Integer proid:form.getProids_B()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		//如果删除的是执行人配置，删除执行人配置信息
		}else if(IGPRDCONSTANTS.OA_ROLE_C.equals(form.getDeleteFlag())){
			if(form.getProids_C()!=null&&form.getProids_C().length>0){
				for(Integer proid:form.getProids_C()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		}
		//如果存在需要删除的数据，调用BL删除
		if(delList.size()>0){
			workFlowDefinitionBL.deleteOARoleConfig(delList);
		}
		dto.addMessage(new ActionMessage("IGPRR0302.I002"));
		log.debug("===========角色配置信息删除操作结束=============");
		return dto;
	}
	
	/**
	 * 角色配置信息新增操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO addIG001InfoAction(IGPRR03DTO dto) throws BLException {
		log.debug("=============角色配置信息新增操作开始============");
		//页面信息取得
		IGPRR0302Form form = dto.getIgprr0302Form();
		//要新增的配置信息集合
		List<IG001TB> addList = new ArrayList<IG001TB>();
		//实例化配置信息
		if(form.getAddContent()!=null&&form.getAddContent().length>0&&StringUtils.isNotEmpty(form.getAddFlag())){
			for(String content:form.getAddContent()){
				String[] split = content.split(",");
				IG001TB pro = new IG001TB();
				pro.setProtype(form.getAddFlag());
				pro.setProroleid(Integer.valueOf(split[0]));
				pro.setProrolename(split[1]);
				addList.add(pro);
			}
		}
		//如果存在信息，做新增操作
		if(addList.size()>0){
			for(IG001TB pro:addList){
				workFlowDefinitionBL.registOARoleConfig(pro);
			}
		}
		dto.addMessage(new ActionMessage("IGPRR0302.I001"));
		log.debug("=============角色配置信息新增操作结束============");
		return dto;
	}
	
	/**
	 * 查询用户信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchUserRoleAction(IGPRR03DTO dto) throws BLException{
		log.debug("=============查询用户信息操作开始=============");
		//参数取得
		IGPRR0303Form form = dto.getIgprr0303Form();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(form.getRoletype());
		cond.setOrgid_like(form.getOrgsyscoding());
		cond.setRoleid(form.getRoleid());
		//角色过滤
		if(StringUtils.isNotEmpty(form.getRoleid_in())){
			List<Integer> roleids = new ArrayList<Integer>();
			String[] roleid_not_in = form.getRoleid_in().split(",");
			for(String s:roleid_not_in){
				roleids.add(Integer.valueOf(s));
			}
			cond.setRoleid_in(roleids);
		}
		List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond);
		if(userRoleList != null){
			Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap = new LinkedHashMap<Integer, Map<String,List<UserRoleInfo>>>();
			for(UserRoleInfo ur:userRoleList){
				if(userRoleInfoMap.get(ur.getRoleid()) == null){
					Map<String, List<UserRoleInfo>> map = new HashMap<String, List<UserRoleInfo>>();
					List<UserRoleInfo> list = new ArrayList<UserRoleInfo>();
					list.add(ur);
					map.put(ur.getRolename(), list);
					userRoleInfoMap.put(ur.getRoleid(), map);
				}else{
					userRoleInfoMap.get(ur.getRoleid()).get(ur.getRolename()).add(ur);
				}
			}
			dto.setUserRoleInfoMap(userRoleInfoMap);
		}
		log.debug("=============查询用户信息操作结束=============");
		return dto;
	}
	
	/**
	 * 过滤角色信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleidNotInAction(IGPRR03DTO dto) throws BLException{
		log.debug("==============过滤角色信息查询操作开始================");
		IGPRR0303Form form = dto.getIgprr0303Form();
		String pidid = form.getPidid();
		if(StringUtils.isNotEmpty(pidid)){
			//角色限定信息查询
			List<IG008Info> pidrses = workFlowDefinitionBL.searchFormRoleScopeByPidid(form.getPidid());
			if(pidrses != null && pidrses.size() > 0){
				StringBuffer info = new StringBuffer();
				for(int i=0;i<pidrses.size();i++){
					if(i>0){
						info.append(",");
					}
					info.append(pidrses.get(i).getRoleid());
				}
				form.setRoleid_in(info.toString());
			}
		}
		log.debug("==============过滤角色信息查询操作结束================");
		return dto;
	}
}
