/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prm.bl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG911BL;
import com.deliverik.framework.workflow.prd.bl.task.IG931BL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCondImpl;
import com.deliverik.infogovernor.prm.dto.IGPRM00DTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 查询流程类型ControlBL 
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRM00BLImpl extends BaseBLImpl implements IGPRM00BL {
	
	static Log log = LogFactory.getLog(IGPRM00BLImpl.class);

	/**流程模板操作*/
	protected IG259BL ig259BL;
	
	/**流程定义操作*/
	protected IG380BL ig380BL;
	
	/**流程状态*/
	protected IG333BL ig333BL;
	
	/**自定义流程参与人*/
	protected IG222BL ig222BL;
	
	/**人员角色*/
	protected UserRoleBL userRoleBL;
	
	/** 角色BL */
	protected RoleBL roleBL;
	
	/** 状态参与者关联流程类型定义BL*/
    protected IG911BL ig911BL;
    
    /** 缺省状态参与者关联流程类型定义BL*/
    protected IG931BL ig931BL;
    
    /**
     * the ig911BL to set
     * 
     * @param 状态参与者关联流程类型定义BL 
     */
    public void setIg911BL(IG911BL ig911BL) {
        this.ig911BL = ig911BL;
    }

    /**
     * the ig931BL to set
     * 
     * @param 缺省状态参与者关联流程类型定义BL 
     */
    public void setIg931BL(IG931BL ig931BL) {
        this.ig931BL = ig931BL;
    }
	/**
	 * 角色BL设定
	 * @param roleBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 设置流程模板操作
	 * @param ig259BL ProcessTemplateBL
	 */
	
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	/**
	 * 设置流程定义操作
	 * @param ig380BL ig380BL
	 */
	
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	/**
	 * 流程状态操作
	 * @param ig333BL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}

	/**
	 * 自定义流程参与人操作
	 * @param ig222BL
	 */
	public void setIg222BL(
			IG222BL ig222BL) {
		this.ig222BL = ig222BL;
	}

	/**
	 * 人员角色
	 * @param userRoleBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * <p>
	 * 查询流程类型
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchProcessDefinitionAction(IGPRM00DTO dto) throws BLException{
		log.debug("========流程类型查询处理开始========");
		IG259Info gpt = ig259BL.searchIG259ByPrType(dto.getProcessType());

		String pttype = dto.getProcessType();

		if(IGPROCESSType.INCIDENT_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID;
		}else if(IGPROCESSType.PROBLEM_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD;
		}else if(IGPROCESSType.CHANGE_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD;
		}else if(IGPROCESSType.DEPLOYMENT_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD;
		}else if(IGPROCESSType.SERVICE_PRTYPE.equals(dto.getProcessType())){
			pttype = IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD;
		}

		
		IG259Info spt = ig259BL.searchIG259ByPrType(pttype);
		if(gpt == null){
			throw new BLException("IGCO10000.E004","流程模板");
		}
		Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(gpt.getPtid());
		List<IG380Info> zdyPdList = null;
		if(spt != null){
			zdyPdList = this.ig380BL.findSelfDefinitionByUserIdCom(dto.getUserid(), spt.getPtid(), "a"); 
		}
		if(zdyPdList != null){
			//需要进行过滤将逐渐ptid重复的流程不进行添加
			for(IG380Info zdyInfo : zdyPdList){
				if(!pdList.contains(zdyInfo)){
					pdList.add(zdyInfo);
				}
			}
			//pdList.addAll(zdyPdList);
		}
		map.put(gpt, pdList);
		dto.setGpt(gpt);
		dto.setSpt(spt);
		dto.setTemplateDefinitionMap(map);
		log.debug("========流程类型查询处理开始========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询可快捷发起流程类型
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 * @throws NoSuchFieldException 
	 * @throws SecurityException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	
	public IGPRM00DTO searchQuickProcessDefinitionAction(IGPRM00DTO dto) throws BLException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
		log.debug("========流程类型查询处理开始========");
		
		String processType = dto.getProcessType();
		
		if(StringUtils.isEmpty(processType)) {
			throw new BLException("IGCO10000.E004","可发起流程类型");
		} else {
			if(!processType.startsWith("W") && !processType.equals(IGPROCESSType.SERVICE_FORM)) {//非工作和服务工单类型
				processType = processType.substring(0,1);
			}
			//获取指定类型流程可快捷发起的流程类型
			Field type = IGPRMCONSTANTS.class.getDeclaredField("QUICK_PROCESS_RELATION_TYPE_" + processType);
			String[] prtypeArray = (String[])type.get(IGPRMCONSTANTS.class);
			

			
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			IG259SearchCondImpl cond = new IG259SearchCondImpl();
			String[] ptstatuses = new String[1];
			ptstatuses[0] = "a";//启用
			//ptstatuses[1] = "t";//测试
			cond.setPtstatuses(ptstatuses);
			List<IG259Info> ptList = ig259BL.searchIG259Info(cond, 0, 0);
			for(IG259Info pt : ptList){
				for(String prtype : prtypeArray) {
					//事件
					if("I".equals(prtype)){
						String flag = "0";
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_ID);//自定义事件
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//自定义事件类型
							if(!pddList.isEmpty()){	
								//判断是否有权限发起
								for(IG380Info pd : pddList){
									flag = "0";
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//发起状态
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//判断是否有发起权限
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//如果有权限,菜单可见
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if(flag.equals("1"))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}
					//变更
					else if("C".equals(prtype)){
						String flag = "0";
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_CD);//自定义变更
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//自定义变更类型
							if(!pddList.isEmpty()){
								//判断是否有权限发起
								for(IG380Info pd : pddList){
									flag = "0";
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//发起状态
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//判断是否有发起权限
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//如果有权限,菜单可见
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if(flag.equals("1"))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}
					else if("P".equals(prtype)){
						String flag = "0";
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_PD);//自定义变更
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//自定义变更类型
							if(!pddList.isEmpty()){
								//判断是否有权限发起
								for(IG380Info pd : pddList){
									flag = "0";
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//发起状态
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//判断是否有发起权限
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//如果有权限,菜单可见
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if(flag.equals("1"))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}
					else if("S".equals(prtype)){
						String flag = "0";
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							IG380SearchCondImpl pscond = new IG380SearchCondImpl();
							pscond.setPdstatuses(ptstatuses);
							pscond.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_SD);//自定义变更
							List<IG380Info> pddList = ig380BL.searchIG380Info(pscond);//自定义变更类型
							if(!pddList.isEmpty()){
								//判断是否有权限发起
								for(IG380Info pd : pddList){
									flag = "0";
									IG333SearchCondImpl psdcond = new IG333SearchCondImpl();
									psdcond.setPdid(pd.getPdid());
									psdcond.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//发起状态
									List<IG333Info> psdlist = this.ig333BL.searchIG333Info(psdcond);
									//判断是否有发起权限
									for(IG333Info psd : psdlist){
										IG222SearchCondImpl ppdcond = new IG222SearchCondImpl();
										ppdcond.setPsdid(psd.getPsdid());
										List<IG222Info> ppdlist = this.ig222BL.searchIG222Info(ppdcond);
										//如果有权限,菜单可见
										if(!ppdlist.isEmpty()){
											UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
											urcond.setUserid(dto.getUserid());
											List<UserRole> urlist = this.userRoleBL.searchUserRole(urcond);
											for(IG222Info ppd : ppdlist){
												if(flag.equals("1"))
													break;
												for(UserRole ur : urlist){
													if(ppd.getRoleid().equals(ur.getRoleid())){
														pdList.add(pd);
														flag = "1";
														break;
													}
												}
											}
										}
									}
								}
							}
							map.put(pt, pdList);
							break;
						}
					}
					else{
						if(pt.getPttype().equals(prtype)) {
							List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
							map.put(pt, pdList);
							break;
						}
					}
					
				}
			}
			dto.setTemplateDefinitionMap(map);
		}
		log.debug("========流程类型查询处理开始========");
		return dto;
	}
	
	
	/**
     * <p>
     * 查询流程定义中相关发起按钮定义的可发起流程类型
     * </p>
     * 
     * @param dto IGPRM00DTO
     * @return IGPRM00DTO
     * @throws BLException
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    
    public IGPRM00DTO searchRelevantProcessAction(IGPRM00DTO dto) throws BLException {
        log.debug("========流程类型查询处理开始========");
        
        String processType = dto.getProcessType();
        
        if(StringUtils.isEmpty(processType)) {
            throw new BLException("IGCO10000.E004","可发起流程类型");
        } else {

            Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
            IG259SearchCondImpl cond = new IG259SearchCondImpl();
            String[] ptstatuses = new String[1];
            ptstatuses[0] = "a";//启用
            cond.setPtstatuses(ptstatuses);
            cond.setPtid(8);
            List<IG259Info> ptList = ig259BL.searchIG259Info(cond, 0, 0);
            
            IG911SearchCondImpl ig911cond = new IG911SearchCondImpl();
            ig911cond.setPdid(dto.getPdid());
            ig911cond.setPsdid(dto.getPsdid());
            ig911cond.setRoleid(dto.getRoleid());
            List<IG380Info> ig380InfoList = ig911BL.searchIg380ByIg911Cond(ig911cond);
            
            if (ig380InfoList.isEmpty()) {
                IG931SearchCondImpl ig931cond = new IG931SearchCondImpl();
                ig931cond.setPdid(dto.getPdid());
                ig931cond.setPsdid(dto.getPsdid());
                ig380InfoList = ig931BL.searchIg380ByIg931Cond(ig931cond);
                if (ig380InfoList.isEmpty()) {
                    throw new BLException("IGCO10000.E004","可发起流程类型");
                }
            }
            
            map.put(ptList.get(0), ig380InfoList);
            
            dto.setTemplateDefinitionMap(map);
        }
        log.debug("========流程类型查询处理结束========");
        return dto;
    }
    
	/**
	 * <p>
	 * 查询工作定义
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchProcessDefinition(User user,UserPermission up,IGPRM00DTO dto) throws BLException{
		UserRoleSearchCondImpl userRoleCond = new UserRoleSearchCondImpl(); 
		IG259SearchCondImpl ptCond = new IG259SearchCondImpl();
		IG380SearchCondImpl pdCond = null;
		List<UserRole> urList = null;
		Map<IG259Info,List<IG380Info>> templateDefinitionMap 
											= new LinkedHashMap<IG259Info, List<IG380Info>>(); //页面显示用流程模板MAP
		
		userRoleCond.setUserid(user.getUserid());
		urList = userRoleBL.searchUserRole(userRoleCond);  //获得当前用户所有角色
		String[] roleActionName = new String[6];  //事件发起,问题发起，变更发起等按钮权限
		roleActionName[0]="ACT02SVC0202";
		roleActionName[1]="ACT02SVC0302";
		roleActionName[2]="ACT02SVC0402";
		roleActionName[3]="ACT02SVC0502";
		roleActionName[4]="ACT02SVC0602";
		roleActionName[5]="ACT02SVC0906";
		
		ptCond.setPtstatus("a");
		List<IG259Info> ptList = ig259BL.searchIG259Info(ptCond); //获得所有流程模板
		
		for(IG259Info pt:ptList){
			//如果是事件模板
			if(IGPRDCONSTANTS.PROCESS_TYPE_I.equals(pt.getPttype())||IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID.equals(pt.getPttype())){
				//判断是有有事件发起按钮权限
				if(!up.checkPermission(roleActionName[0])){
					continue;
				}else{
					//如果有事件发起 权限查询事件类型列表
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","t"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					//如果是普通事件添加事件类型到MAP里
					if(IGPRDCONSTANTS.PROCESS_TYPE_I.equals(pt.getPttype())){
						templateDefinitionMap.put(pt, pdList);
					}else{
						//如果是自定义事件，判断当前角色是否有权限发起该事件
						List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
						for(IG380Info pd :pdList){
							if(getRoleActionStart(pd.getPdid(),urList)){
								pdListTmp.add(pd);
							}
						}
						templateDefinitionMap.put(pt, pdListTmp);
					}
				}//问题部分逻辑
			}else if(IGPRDCONSTANTS.PROCESS_TYPE_P.equals(pt.getPttype())||IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD.equals(pt.getPttype())){
				if(!up.checkPermission(roleActionName[1])){
					continue;
				}else{
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","t"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					if(IGPRDCONSTANTS.PROCESS_TYPE_P.equals(pt.getPttype())){
						templateDefinitionMap.put(pt, pdList);
					}else{
						List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
						for(IG380Info pd :pdList){
							if(getRoleActionStart(pd.getPdid(),urList)){
								pdListTmp.add(pd);
							}
						}
						templateDefinitionMap.put(pt, pdListTmp);
					}
				}//变更部分逻辑
			}else if(IGPRDCONSTANTS.PROCESS_TYPE_C.equals(pt.getPttype())||IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD.equals(pt.getPttype())){
				if(!up.checkPermission(roleActionName[2])){
					continue;
				}else{
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","t"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					if(IGPRDCONSTANTS.PROCESS_TYPE_C.equals(pt.getPttype())){
						templateDefinitionMap.put(pt, pdList);
					}else{
						List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
						for(IG380Info pd :pdList){
							if(getRoleActionStart(pd.getPdid(),urList)){
								pdListTmp.add(pd);
							}
						}
						templateDefinitionMap.put(pt, pdListTmp);
					}
				}//发布部分逻辑
			}else if(IGPRDCONSTANTS.PROCESS_TYPE_D.equals(pt.getPttype())||IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD.equals(pt.getPttype())){
				if(!up.checkPermission(roleActionName[3])){
					continue;
				}else{
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","t"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					if(IGPRDCONSTANTS.PROCESS_TYPE_D.equals(pt.getPttype())){
						templateDefinitionMap.put(pt, pdList);
					}else{
						List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
						for(IG380Info pd :pdList){
							if(getRoleActionStart(pd.getPdid(),urList)){
								pdListTmp.add(pd);
							}
						}
						templateDefinitionMap.put(pt, pdListTmp);
					}
				}//服务请求部分逻辑
			}else if(IGPRDCONSTANTS.PROCESS_TYPE_S.equals(pt.getPttype())||IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD.equals(pt.getPttype())){
				if(!up.checkPermission(roleActionName[4])){
					continue;
				}else{
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","t"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					if(IGPRDCONSTANTS.PROCESS_TYPE_S.equals(pt.getPttype())){
						templateDefinitionMap.put(pt, pdList);
					}else{
						List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
						for(IG380Info pd :pdList){
							if(getRoleActionStart(pd.getPdid(),urList)){
								pdListTmp.add(pd);
							}
						}
						templateDefinitionMap.put(pt, pdListTmp);
					}
				}//自定义工作部分逻辑
			}else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(pt.getPttype())){
				if(!up.checkPermission(roleActionName[5])){
					continue;
				}else{
					pdCond = new IG380SearchCondImpl();
					String[] pdstatuses = {"a","i"};
					pdCond.setPdstatuses(pdstatuses);
					pdCond.setPtid(pt.getPtid());
					List<IG380Info> pdList = ig380BL.searchIG380Info(pdCond);
					List<IG380Info> pdListTmp = new ArrayList<IG380Info>();
					for(IG380Info pd :pdList){
						if(getRoleActionStart(pd.getPdid(),urList)){
							pdListTmp.add(pd);
						}
					}
					templateDefinitionMap.put(pt, pdListTmp);
				}
			}
		}
		dto.setTemplateDefinitionMap(templateDefinitionMap);
		return dto;
	}
	public boolean getRoleActionStart(String pdid,List<UserRole> urList){
		IG333SearchCondImpl psCond = new IG333SearchCondImpl();
		IG222SearchCondImpl ppdCond = new IG222SearchCondImpl();
		List<IG333Info> processStatusDefList = null;
		List<IG222Info> ppdlist = null;
		psCond.setPdid(pdid);
		String psdid = null;
		processStatusDefList = this.ig333BL.searchIG333Info(psCond, 0, 0);
		if(processStatusDefList ==null){
			return false;
		}
		for(IG333Info psd:processStatusDefList){
			if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode())){
				psdid = psd.getPsdid();
			}
		}
		ppdCond.setPsdid(psdid);
		ppdlist = this.ig222BL.searchIG222Info(ppdCond, 0, 0);
		if(urList==null){
			return false;
		}
		if(ppdlist == null){
			return false;
		}
		for(UserRole ur:urList){
			for(IG222Info ppd:ppdlist){
				if(ppd.getRoleid().equals(ur.getRoleid())){
					return true;
				}
			}
		}
		return false;
	}
	
	public IGPRM00DTO searchWorkDefinitionAction(IGPRM00DTO dto) throws BLException{
		log.debug("========流程类型查询处理开始========");
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
//		cond.setIsWorkPt(1);
		cond.setPtstatus("a");
		cond.setPtqrtzflag(dto.getPtqrtzflag());
		if("svc".equals(dto.getPage()) || "3".equals(dto.getProcessType())){
			//获取工作流程
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			List<IG259Info> pts = ig259BL.searchIG259Info(cond);
			for(IG259Info pt : pts){
				List<IG380Info> pdList1 = ig380BL.searchIG380InfoByPtid(pt.getPtid());
				List<IG380Info> pdList = new ArrayList<IG380Info>();
				for (IG380Info pr : pdList1) {
					if(IGPRM00BLType.pdid_wb.equals(pr.getPdid().substring(0, 5))||IGPRM00BLType.pdid_wa.equals(pr.getPdid().substring(0, 5))){
						map.put(pt, pdList);
						System.out.println(pr.getPdid().substring(0, 5));
						pdList.add(pr);
					}
				}
			}
//         去掉运维页面工作类型中的自定义工作 edit 20120517 start-->
			//获取用户可以发起的自定义流程 
//			ProcessTemplate pt = this.ig259BL.searchProcessTemplateByPrType(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE);
//			if (pt != null) {
//				
//				boolean flag = false;
//				//判断当前用户是否拥有运维自定义角色
//				UserRoleSearchCondImpl urcond = new UserRoleSearchCondImpl();
//				urcond.setUserid(dto.getUserid());
//				List<UserRole> userRoleList = userRoleBL.searchUserRole(urcond);
//				for(UserRole ur : userRoleList){
//					Role role = roleBL.searchRoleByKey(ur.getRoleid());
//					if(WorkFlowConstDefine.DEFINED_ROLE_TYPE.equals(role.getRoletype())){
//						//如果存在,可以看到所有测试及启用状态的自定义类型
//						List<ProcessDefinition> pdList = this.ig380BL.findSelfDefinitionAll();
//						map.put(pt, pdList);
//						flag = true;
//						break;
//					}
//				}
//				
//				if(!flag){
//					//如果不存在,则只能看到当前用户可发起的自定义流程
//					List<ProcessDefinition> pdList = this.ig380BL.findSelfDefinitionByUserId(dto.getUserid(),
//							IGPRDCONSTANTS.PD_STATUS_ENABLE);
//					map.put(pt, pdList);
//				}
//			}
//			edit 20120517 end-->
			dto.setTemplateDefinitionMap(map);
		}else{
			//获取工作流程
			Map<IG259Info,List<IG380Info>> map = new LinkedHashMap<IG259Info, List<IG380Info>>();
			List<IG259Info> pts = new ArrayList<IG259Info>();
			List<IG259Info> ptsTemp = ig259BL.searchIG259Info(cond);
			if("0".equals(dto.getProcessType())){
				for(int i=0; i<ptsTemp.size(); i++){
					if("WB".equals(ptsTemp.get(i).getPttype())){
						pts.add(ptsTemp.get(i));
						break;
					}
					
				}
			}else if("1".equals(dto.getProcessType())){
				for(int i=0; i<ptsTemp.size(); i++){
					if("WA".equals(ptsTemp.get(i).getPttype())){
						pts.add(ptsTemp.get(i));
						break;
					}
				}
			}
			for(IG259Info pt : pts){
				List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(pt.getPtid());
				map.put(pt, pdList);
			}
			//获取用户可以发起的发布自定义流程
			if("2".equals(dto.getProcessType())){
				IG259Info pt = this.ig259BL.searchIG259ByPrType(IGPROCESSType.SELF_DEFINING_WORK_PRTYPE);
				if (pt != null) {
					List<IG380Info> pdList = this.ig380BL.findSelfDefinitionByUserId(dto.getUserid(),
							IGPRDCONSTANTS.PD_STATUS_ENABLE);
					map.put(pt, pdList);
				}
			}
			//获取用户可以发起的测试自定义流程
			else if("5".equals(dto.getProcessType())){
				IG259SearchCondImpl processTemplateCond = new IG259SearchCondImpl();
				processTemplateCond.setPtstatus("a");
				processTemplateCond.setPtqrtzflag(dto.getPtqrtzflag());
				List<IG259Info> lst_ProcessTemplate = ig259BL.searchIG259Info(processTemplateCond);
				for (IG259Info pt : lst_ProcessTemplate) {
					List<IG380Info> pdList = this.ig380BL.findSelfDefinitionByUserIdCom(dto.getUserid(),
							pt.getPtid(), IGPRDCONSTANTS.PD_STATUS_TESTABLE);
					//只显示可发起的流程类型
					if(pdList != null && !pdList.isEmpty()) {
						map.put(pt, pdList);
					}
				}
			}
			dto.setTemplateDefinitionMap(map);
		}
		log.debug("========流程类型查询处理开始========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * 查询工作定义
	 * </p>
	 * 
	 * @param dto IGPRM00DTO
	 * @return IGPRM00DTO
	 * @throws BLException
	 */
	
	public IGPRM00DTO searchWorkDefinitionTreeAction(IGPRM00DTO dto) throws BLException{
		log.debug("========流程类型查询处理开始========");
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setIsWorkPt(1);
		cond.setPtstatus("a");
		List<IG259Info> pts = ig259BL.searchIG259Info(cond);
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(IG259Info pt : pts){
			TreeNode ptNode = new TreeNode();
			ptNode.setId(pt.getPtid()+"");
			ptNode.setName(pt.getPtname());
			ptNode.setRemark(pt.getPtstartpg());
			ptNode.setBelong("0");
			getChildTreeNodeMap(pt.getPtid(),ptNode,pt.getPtstartpg());
			treeNodeMap.put(ptNode.getId(),ptNode);
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========流程类型查询处理开始========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询工作流程定义
	 * </p>
	 * 
	 * @param processTemplateId 工作模板id
	 * @param ptNode 模板节点
	 * @param ptstartpg 发起页url
	 */
	private void getChildTreeNodeMap(Integer processTemplateId,TreeNode ptNode,String ptstartpg){
		List<IG380Info> pdList = ig380BL.searchIG380InfoByPtid(processTemplateId);
		for(IG380Info pd : pdList){
			TreeNode pdNode = new TreeNode();
			pdNode.setId(pd.getPdid()+"");
			pdNode.setName(pd.getPdname());
			pdNode.setRemark(ptstartpg);
			pdNode.setBelong("1");
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}
	}


}

