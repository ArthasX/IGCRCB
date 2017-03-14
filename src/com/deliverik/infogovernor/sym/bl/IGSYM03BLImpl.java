/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.RoleApi;
import org.hyperic.hq.hqapi1.types.ResponseStatus;
import org.hyperic.hq.hqapi1.types.RoleResponse;
import org.hyperic.hq.hqapi1.types.StatusResponse;

import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;
import com.deliverik.infogovernor.sym.form.IGSYM1202Form;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_角色管理_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM03BLImpl extends BaseBLImpl implements IGSYM03BL {

	static Log log = LogFactory.getLog(IGSYM03BLImpl.class);
	
	/**集体角色管理域标识，在服务请求的发起和审批状态中必须指定人员*/
	public final static String GROUP_ROLE_MARK = "#";
	public final static String GROUP_ROLE_NAME = "用户自身机构";
	
	/**
	 * 注入RoleBL
	 */
	
	protected RoleBL roleBL;
	
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 设置RoleBL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * 注入UserRoleBL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * 设置UserRoleBL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * 注入RoleActionBL
	 */
	protected RoleActionBL roleActionBL;

	/**
	 * 设置UserRoleBL
	 * @param roleActionBL RoleActionBL
	 */
	
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}
	
	
	/**
	 * 注入OrganizationBL
	 */
	protected OrganizationBL organizationBL;

	/**
	 * 设置OrganizationBL
	 * @param organizationBL OrganizationBL
	 */
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}

	/**
	 * 根据传入的该用户的角色集合和角色类型取得所有该类型的角色的资产管理内容树的并集
	 * @param 角色类型(页面传入)
	 * @param 该用户的角色集合(session中取得)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getAssetDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException{
		//按照角色类型和用户ID取得该类型下的角色集合
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(user.getUserid());
		cond.setRoletype(roletype);
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		sym03dto.setRoletype(roletype);
		
		sym03dto = getAssetTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	/**
	 * 取得该类型下所有角色的资产管理内容(role.assetdomain)
	 * @param 指定类型下的角色LIST
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private IGSYM03DTO getAssetTreeByRoleType(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		List<UserRoleInfo> tree = new ArrayList<UserRoleInfo>();//存放可能做为资产管理内容树的每个1级结点（目前支持到9级）
		
		List<UserRoleInfo> newtree = new ArrayList<UserRoleInfo>();
		boolean flag = true;
		
		for(int x=0,y=rolelist.size();x<y;x++){
			flag = true;
			String rd = rolelist.get(x).getAssetdomain();
			if(rd!=null){
				for(UserRoleInfo ro:rolelist){
					if(ro!=null){
						String temp = ro.getAssetdomain();
						//判断该结点是否存在上级结点，如存在则将flag置为false
						if(StringUtils.isNotEmpty(temp)){
							if(rd.contains(temp) && !rd.equals(temp)){
								if(rd.length()>temp.length()){
									if(rd.substring(0, temp.length()).equals(temp)){
										flag = false;
										break;
									}
								}else{
									if(temp.substring(0, rd.length()).equals(rd)){
										flag = false;
										break;
									}
								}
								
							}
						}
						
					}
				}
			}else{
				flag = false;
			}
			
			if(flag){
				tree.add(rolelist.get(x));
			}
		}
		
		
		//将含有assetdomain的角色对象按照 ‘设备资产到组件’ 的顺序排列（999001---999012）
		if(tree!=null){
			UserRoleInfo[] obj = new UserRoleInfo[tree.size()];
			for(int i=0,j=tree.size();i<j;i++){
				obj[i]=tree.get(i);
			}
			UserRoleInfo urtemp = null;
			for(int i=0;i<obj.length;i++){

				for(int j=0;j<obj.length-i-1;j++){
//					if(j==(obj.length-i-1)){
//						break;
//					}
					UserRoleInfo oneur = obj[j];
					UserRoleInfo twour = obj[j+1];
					String oneasset = null;
					String twoasset = null;
					if(oneur!=null){
						oneasset = oneur.getAssetdomain();
					}
					if(twour!=null){
						twoasset = twour.getAssetdomain();
					}
					
					if(oneasset.compareTo(twoasset)>0){
						urtemp = obj[j];
						obj[j] = obj[j+1];
						obj[j+1] = urtemp;
					}
					
				}
						
			}
			for(int i=0,j=obj.length;i<j;i++){
				newtree.add(obj[i]);
			}

		}
		
		
		sym03dto = searchAssetTreeAction(sym03dto,newtree);
		return sym03dto;
		
	}
	/**
	 * <p>
	 * 判断是否包含指定的资产模型1结点
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isBeSelectedEntity(String type,String esyscoding) throws BLException{
		boolean flag = false;
		if(esyscoding!=null && type!=null){
			if(esyscoding.length()>=6){
				if(esyscoding.substring(0,6).equals(type)){
					flag = true;
				}
			}
			
		}
		return flag;
	}

	/**
	 * <p>
	 * 查询角色资产管理内容树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private IGSYM03DTO searchAssetTreeAction(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		log.debug("========查询角色资产管理内容树开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		//IGSYM0301Form form = new IGSYM0301Form();
		//IGSYM03DTO dto = new IGSYM03DTO();
		IGSYM12DTO dto1 = new IGSYM12DTO();
		//String roletype = sym03dto.getRoletype();//前台传入的角色类型
		//form.setIs_in_use("1");
		if(rolelist!=null){
			for(UserRoleInfo ro:rolelist){
				if(ro!=null){
					String esyscoding = ro.getAssetdomain();
//					if("t".equals(sym03dto.getIsItDrivers())){
//						if(esyscoding.equals("999001")){
//							esyscoding = "999001001";
//						}
//					}
					if(esyscoding!=null && !"".equals(esyscoding)){
						boolean flag = false;
						if("1".equals(sym03dto.getIsRoot())){
							flag = true;
							esyscoding = sym03dto.getSubtype();
						}else{
							flag = isBeSelectedEntity(sym03dto.getSubtype(),esyscoding);
						}
						if(flag){
							//取得当前结点的完整名称
							String completename = "";
//							if(esyscoding.length()>6){//1级资产模型结点的esyscoding长度为6，如999001
//								completename = getAssetCompleteName(esyscoding);
//							}

							IGSYM1202Form form1 = new IGSYM1202Form();
							//设置当前结点的完整树(从该级结点向下)			
							form1.setSyscoding_q(esyscoding);
							form1.setEstatus("1");
							dto1.setEntitySearchCond(form1);
							
							
							SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
							soc0117cond.setSyscoding_q(esyscoding);
							soc0117cond.setEstatus("1");
							
							if(StringUtils.isNotEmpty(sym03dto.getRoletype())&&("IGBU01".equalsIgnoreCase(sym03dto.getRoletype())||"IGCI01".equalsIgnoreCase(sym03dto.getRoletype()))){
								List<SOC0117Info> retInfo=this.soc0117BL.searchEntity(soc0117cond,0,0);
								TreeNode ptNode = new TreeNode();
								ptNode.setId(retInfo.get(0).getEid()+"_"+retInfo.get(0).getEsyscoding()+"_"+retInfo.get(0).getEcategory());
								if("".equals(completename)){
									ptNode.setName(retInfo.get(0).getEname());
								}else{
									ptNode.setName(completename);
								}

								//添加孩子结点
								int nowlen = retInfo.get(0).getEsyscoding().length();
								getAssetChildTreeNodeMapOne(retInfo,ptNode,nowlen,esyscoding);
								treeNodeMap.put(ptNode.getId(),ptNode);
							}else{
//								List<IG117Info> ret = soc0117BL.searchIG117Info(dto1.getEntitySearchCond(), 0, 0);//查该结点的下级资产管理内容树的1级结点
								List<SOC0117Info> ret=this.soc0117BL.searchEntity(soc0117cond,0,0);
								TreeNode ptNode = new TreeNode();
								ptNode.setId(ret.get(0).getEid()+"_"+ret.get(0).getEsyscoding()+"_"+ret.get(0).getEcategory());
								if("".equals(completename)){
									ptNode.setName(ret.get(0).getEname());
								}else{
									ptNode.setName(completename);
								}

								//添加孩子结点
								int nowlen = ret.get(0).getEsyscoding().length();
//								getAssetChildTreeNodeMap(ret,ptNode,nowlen,esyscoding);
								getAssetChildTreeNodeMapOne(ret,ptNode,nowlen,esyscoding);
								treeNodeMap.put(ptNode.getId(),ptNode);
							}
							
							
							
						}

					}

				}	
			}
		}
		

		sym03dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询角色资产管理内容树结束========");
		return sym03dto;
	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getAssetChildTreeNodeMap(List<IG117Info> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<IG117Info> nextret = getAssetNextLevelNodes(ret,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
				
			getAssetChildTreeNodeMap(ret,pdNode,syscode.length(),syscode);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getAssetChildTreeNodeMapOne(List<SOC0117Info> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<SOC0117Info> nextret = getAssetNextLevelNodesOne(ret,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
				
			getAssetChildTreeNodeMapOne(ret,pdNode,syscode.length(),syscode);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<IG117Info> getAssetNextLevelNodes(List<IG117Info> ret,int levellen,String syscode) {
		
		List<IG117Info> entitylist = new ArrayList<IG117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.ESYSCODING_NODE_LENGTH) && (syscoding.substring(0,syscoding.length()-CommonDefineUtils.ESYSCODING_NODE_LENGTH)).equals(syscode)){				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<SOC0117Info> getAssetNextLevelNodesOne(List<SOC0117Info> ret,int levellen,String syscode) {
		
		List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
	}
	
	/**
	 * <p>
	 * 取得该结点的资产管理内容(即资产模型)的全名
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private String getAssetCompleteName(String syscoding) {
		StringBuffer entityname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==6){//1级资产模型结点的esyscoding长度为6
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			codelist.add(pcode);
			String childs = syscoding.substring(CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			int j = childs.length()/CommonDefineUtils.ESYSCODING_NODE_LENGTH;
			for(int i=1;i<=j;i++){
				codelist.add(pcode+childs.substring(0, CommonDefineUtils.ESYSCODING_NODE_LENGTH*i));
			}
			
		}

		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(codelist);
		List<IG117Info> ret = ig117BL.searchIG117Info(cond, "assetdomain");//查该角色管理域的下级机构树
		for(int i=0,j=ret.size();i<j;i++){
			String syscode = ret.get(i).getEsyscoding();
			if(syscoding.contains(syscode)){
				if(i>0){
					entityname.append("_");
				}
				entityname.append(ret.get(i).getEname());
			}
			
		}
		return entityname.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * 根据传入的该用户的角色集合和角色类型取得所有该类型的角色的管理域树的并集
	 * @param 角色类型(页面传入)
	 * @param 该用户的角色集合(session中取得)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException{
		//按照角色类型和用户ID取得该类型下的角色集合
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(user.getUserid());
		cond.setRoletype(roletype);
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		
		
		sym03dto = getTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto) throws BLException{
		//按照角色类型和用户ID取得该类型下的角色集合
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		
		
		sym03dto = getTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	/**
	 * 取得该类型下所有角色的管理域
	 * @param 指定类型下的角色LIST
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private IGSYM03DTO getTreeByRoleType(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		List<UserRoleInfo> tree = new ArrayList<UserRoleInfo>();//存放可能做为管理域树的每个1级结点（目前支持到9级）
		
		boolean flag = true;
		
		for(int x=0,y=rolelist.size();x<y;x++){
			flag = true;
			String rd = rolelist.get(x).getRoledomain();
			if(rd!=null){
				for(UserRoleInfo ro:rolelist){
					if(ro!=null){
						String temp = ro.getRoledomain();
						if(temp!=null){
							//判断该结点是否存在上级结点，如存在则将flag置为false
							if(rd.contains(temp) && !rd.equals(temp)){
								if(rd.length()>temp.length()){
									if(rd.substring(0, temp.length()).equals(temp)){
										flag = false;
										break;
									}
								}else{
									if(temp.substring(0, rd.length()).equals(rd)){
										flag = false;
										break;
									}
								}
								
							}
						}
						
					}
					
				}
			}
			
			if(flag){
				tree.add(rolelist.get(x));
			}
		}
		
		sym03dto = searchOrgTreeAction(sym03dto,tree);
		return sym03dto;
		
	}
	
	/**
	 * <p>
	 * 取得该结点的机构全名
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private String getCompleteOrgName(String syscoding) {
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		StringBuffer orgname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==4){
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, 4);
			codelist.add(pcode);
			String childs = syscoding.substring(4);
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
					orgname.append("_");
				}
				orgname.append(ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}
	
	/**
	 * <p>
	 * 查询角色管理域树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private IGSYM03DTO searchOrgTreeAction(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		log.debug("========查询角色管理域树开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		//form.setIs_in_use("1");
		if(rolelist!=null){
			for(UserRoleInfo ro:rolelist){
				if(ro!=null){
					String syscoding = ro.getRoledomain();
					if(syscoding!=null && !"".equals(syscoding)){
						//取得当前结点的完整名称
						String completename = "";
						if(syscoding.length()>4){
							completename = getCompleteOrgName(syscoding);
						}
						
						//设置当前结点的完整树(从该级结点向下)
						form.setRoledomain_q(syscoding);
						/////////wuzq
						form.setIs_in_use("1");
						/////////
						dto.setOrganizationSearchCond(form);
						List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该结点的下级机构树
						TreeNode ptNode = new TreeNode();
						ptNode.setId(ret.get(0).getOrgsyscoding());
						if("".equals(completename)){
							ptNode.setName(ret.get(0).getOrgname());
						}else{
							ptNode.setName(completename);
						}

						//添加孩子结点
						int nowlen = ret.get(0).getOrgsyscoding().length();
						getChildTreeNodeMap(ret,ptNode,nowlen,syscoding);
						treeNodeMap.put(ptNode.getId(),ptNode);
					}
				}		

			}
		}
		

		sym03dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询角色管理域树结束========");
		return sym03dto;
	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getChildTreeNodeMap(List<Organization> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<Organization> nextret = getNextLevelNodes(ret,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getOrgsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(syscode);
			pdNode.setName(nextret.get(i).getOrgname());
				
			getChildTreeNodeMap(ret,pdNode,syscode.length(),syscode);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<Organization> getNextLevelNodes(List<Organization> ret,int levellen,String syscode) {
		
		List<Organization> org = new ArrayList<Organization>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getOrgsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				org.add(ret.get(i));
			}
			
		}
		
		return org;
	}

	/**
	 * <p>
	 * Description: 取得包含机构全名的机构对象集合
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteOrgNameList(List<Role> roleList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Role role:roleList){
			String name = "";
			if(role.getRoledomain()!=null && !"".equals(role.getRoledomain())){
				if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(role.getRoledomain())) {
					name = IGSYM03BLImpl.GROUP_ROLE_NAME;
				} else {
					name = getCompleteOrgName(role.getRoledomain());
				}
			}
			
			org.put(role.getRoleid(), name);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: 取得包含资产模型全名的资产对象集合
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteAssetNameList(List<Role> roleList) throws BLException {
		Map<Integer,String> asset = new HashMap<Integer,String>();
		for(Role role:roleList){
			String name = "";
			if(role.getAssetdomain()!=null && !"".equals(role.getAssetdomain())){
				name = getAssetCompleteName(role.getAssetdomain());
			}
			
			asset.put(role.getRoleid(), name);
		}
		
		return asset;
	}
	
	
	/**
	 * <p>
	 * 取得指定syscoding的机构名
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
//	private String getNameBySyscoding(String syscoding) {
//		IGSYM0101Form form = new IGSYM0101Form();
//		IGSYM01DTO dto = new IGSYM01DTO();
//		StringBuffer orgname = new StringBuffer();
//		
//		form.setOrgsyscoding(syscoding);
//		form.setIs_in_use("1");
//		dto.setOrganizationSearchCond(form);
//		List<Organization> ret = organizationBL.getOrganizations(dto.getOrganizationSearchCond());//查该syscoding对应的机构名称
//		orgname.append(ret.get(0).getOrgname());
//		return orgname.toString();
//	}
	
	/**
	 * <p>
	 * Description: 角色查询（IGSYM0306弹出画面使用）
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 */
	
	public IGSYM03DTO searchRoleActionFor0306(IGSYM03DTO dto) throws BLException {
		log.debug("========角色查询处理开始========");
		// 查询记录总数
		int totalCount = roleBL.searchRoleCountForSelfDef(dto
				.getRoleSearchCond());
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
		List<Role> roleList = roleBL.searchRoleForSelfDef(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
//		dto.setCompleteassetnameMap(getCompleteAssetNameList(roleList));
		dto.setCompletenameMap(getCompleteOrgNameList(roleList));
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========角色查询处理终了========");
		return dto;
	}
	/**
	 * <p>
	 * Description: 角色查询
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO searchRoleAction(IGSYM03DTO dto)
			throws BLException {
		log.debug("========角色查询处理开始========");
		// 查询记录总数
		int totalCount = roleBL.getRoleSearchCount(dto
				.getRoleSearchCond());
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
		List<Role> roleList = roleBL.searchRole(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(roleList));
		dto.setCompleteassetnameMap(getCompleteAssetNameList(roleList));
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========角色查询处理终了========");
		return dto;
	}

	/**
	 * <p>
	 * Description: 角色删除
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO deleteRoleAction(IGSYM03DTO dto) throws BLException {
		log.debug("========角色删除处理开始========");
		List<Role> roleList = new ArrayList<Role>();
		//循环删除
		for( int i=0;i<dto.getDeleteRoleid().length;i++ ){
			//角色删除主键
			String roleid = dto.getDeleteRoleid()[i];
			//调用DAO查询该主键标识的实体对象
			Role role = roleBL.searchRoleByKey(Integer.parseInt(roleid));
			//不存在抛出异常
			if (role == null){
				throw new BLException("IGCO10000.E004","删除角色基本");
			}
			
			//检验该角色下是否存在用户
			UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
			cond.setRoleid(role.getRoleid());
			int totalCount = this.userRoleBL.getUserRoleSearchCount(cond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0301.E001",role.getRolename());
			}
			List<IG500Info> processRecordList = workFlowOperationBL.
			queryActiveProcessByRoleid(Integer.parseInt(roleid));
			if(processRecordList.size() > 0){
				String prserialnum = "";
				for (int j = 0; j < processRecordList.size(); j++) {
					prserialnum += processRecordList.get(j).getPrserialnum();
					if(j < processRecordList.size() - 1){
						prserialnum += ",";
					}
				}
				throw new BLException("IGSYM0301.E002",role.getRolename(),prserialnum);
			}
			roleList.add(role);//将没有出现异常的角色添加到List中进行删除
		}
		if(roleList.size() > 0){
			for(Role roleParam : roleList){
				//同步删除业务资源的角色
				if(roleParam.getRoletype().equals("IGSY01") && StringUtils.isNotEmpty(roleParam.getFingerPrint())){
					//是业务资源角色并且是同步的时候才进行处理
					String res = synRoleDelete(roleParam.getFingerPrint());
					if("-1".equals(res)){
						throw new BLException("IGCO10000.E028",roleParam.getRolename());
					}else if("-2".equals(res)){
						throw new BLException("IGCO10000.E136",roleParam.getRolename());
					}else if("0".equals(res)){
						throw new BLException("IGCO10000.E029","角色");
					}else if(res.indexOf("SUCCESSROLE")!=-1){
						log.info("========同步角色信息成功========");
					}else{
						throw new BLException("IGCO10000.E135",res);
					}
				}
			}
			for(Role roleParam : roleList){
				RoleActionSearchCondImpl roleActionCond = new RoleActionSearchCondImpl();
				roleActionCond.setRoleid(roleParam.getRoleid());
				//删除角色菜单
				List<RoleAction> roleActionList = roleActionBL.searchRoleAction(roleActionCond,0,0);
				
				for(RoleAction ra : roleActionList) {
					roleActionBL.deleteRoleAction(ra);
				}
				
				roleBL.deleteRole(roleParam);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "角色基本信息"));
		log.debug("========角色删除处理终了========");
		return dto;
	}
	
	/***
	 * 同步到HQ库删除Role信息
	 * @param role
	 * @return
	 */
	private String synRoleDelete(String role_id){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id)).getRole();
			if(roleTemp==null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		StatusResponse rRes = null;
		try {
			rRes = roleApi.deleteRole(Integer.parseInt(role_id));
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return "SUCCESSROLE";//同步更新成功
		}else{
			return rRes.getError().getReasonText();
		}
	}
	
	/**
	 * <p>
	 * Description: 角色新增
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO insertRoleAction(IGSYM03DTO dto) throws BLException {
		IGSYM0302Form form = dto.getIgsym0302Form();
		//预先判断角色名称是否超过数据库中的长度限制目前32位
		checkRoleNameLength(form.getRolename());
		
		log.debug("========角色新增处理开始========");		
		//先判断IG中是否存在相同名称的信息
		checkNotExistRole(form.getRolename());
		if(form.getRoletype().equals("IGSY01")){
			String res = synRoleDate(dto.getRole());
			if("-1".equals(res)){
				throw new BLException("IGCO10000.E139",form.getRolename());
			}else if("-2".equals(res)){
				throw new BLException("IGCO10000.E131",form.getRolename());
			}else if("0".equals(res)){//新增时可以使不同步的
				//throw new BLException("IGCO10000.E029","角色");
				log.info("========初始未开启同步操作========");
			}else if(res.indexOf("SUCCESSROLE")!=-1){
				form.setFingerPrint(res.replaceAll("SUCCESSROLE", ""));
				log.info("========同步角色信息成功========");
			}else{
				throw new BLException("IGCO10000.E130",res);
			}
		}
		Role role = registRole(form);
		dto.setRole(role);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "角色基本信息") );
		log.debug("========角色新增处理终了========");
		return dto;
	}
	/**
	 * 判断角色名称长度
	 * @param roleName
	 * @throws BLException 
	 */
	private void checkRoleNameLength(String roleName) throws BLException {
		if(roleName.length()>32) {
			throw new BLException("IGSYM0000.E002","角色");
		}
	}
	
	/***
	 * 同步到HQ库新增Role信息
	 * @param role
	 * @return
	 */
	private String synRoleDate(Role role){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		org.hyperic.hq.hqapi1.types.Role hqRole = new org.hyperic.hq.hqapi1.types.Role();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(role.getRolename()).getRole();
			if(roleTemp!=null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		hqRole.setName(role.getRolename());
		RoleResponse rRes = null;
		try {
			rRes = roleApi.createRole(hqRole);
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return rRes.getRole().getId()+"SUCCESSROLE";//同步更新成功
		}else{
			return rRes.getError().getReasonText();
		}
	}
	
	/**
	 * <p>
	 * Description: 根据syscoding查询该机构的名称
	 * </p>
	 */
	
	public String searchOrgname(String syscoding) throws BLException {
		IGSYM01DTO dto = new IGSYM01DTO();
		IGSYM0101Form form = new IGSYM0101Form();
		form.setOrgsyscoding(syscoding);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());
		
		return ret.get(0).getOrgname().toString();
	}
	
	/**
	 * <p>
	 * Description: 根据assetdomain查询该模型的名称
	 * </p>
	 */
	
	public String searchAssetname(String syscoding) throws BLException {
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(syscoding);
		List<SOC0117Info> ret = soc0117BL.searchEntity(cond, "assetdomain");

		
		return ret.get(0).getEname().toString();
	}
	
	
	/**
	 * <p>
	 * Description: 角色变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO initIGSYM0302Action(IGSYM03DTO dto) throws BLException {
		log.debug("========变更用资产基本信息查询处理开始========");
		IGSYM0302Form form = dto.getIgsym0302Form();
		String roleidStr = form.getRoleidstr();
		Integer roleid = Integer.parseInt(roleidStr);
		Role role = roleBL.searchRoleByKey(roleid);
		if ( role == null ){
			throw new BLException("IGCO10000.E004","角色基本");
		}
		form.setRoledomain(role.getRoledomain());
		
		if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(role.getRoledomain())) {
			form.setRoledomainname(IGSYM03BLImpl.GROUP_ROLE_NAME);
		} else {
			form.setRoledomainname(searchOrgname(role.getRoledomain()));
		}
		
		if(role.getRoletype()!=null && role.getRoletype().indexOf("IGAC")>=0 || "IGBP50".equals(role.getRoletype())){
			form.setAssetdomain(role.getAssetdomain());
			form.setAssetdomainname(searchAssetname(role.getAssetdomain()));
		}
		form.setRolename(role.getRolename());
		form.setRolenamebak(role.getRolename());
		form.setRoledesc(role.getRoledesc());
		form.setRoleinfo(role.getRoleinfo());
		form.setRoletype(role.getRoletype());
		//变更初始化模式
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","角色基本信息"));
		log.debug("========变更用角色基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 角色变更
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM03DTO updateRoleAction(IGSYM03DTO dto) throws BLException{
		checkExistRole(dto.getRole().getRoleid());
		IGSYM0302Form form = (IGSYM0302Form)dto.getRole();
		if(!form.getRolename().equals(form.getRolenamebak())){
			checkNotExistRole(form.getRolename());
		}
		Role role = roleBL.searchRoleByKey(dto.getRole().getRoleid());
		form.setFingerPrint(role.getFingerPrint());
		//进行同步
		if(form.getRoletype().equals("IGSY01")){
			String res = synRoleUpdate(form);
			if("-1".equals(res)){
				throw new BLException("IGCO10000.E030",form.getRolename());
			}else if("-2".equals(res)){
				throw new BLException("IGCO10000.E138",form.getRolename(),"已有");
			}else if("0".equals(res)){
				throw new BLException("IGCO10000.E029","角色");
			}else if(res.indexOf("SUCCESSUPD")!=-1){
				form.setFingerPrint(res.replaceAll("SUCCESSUPD", ""));
				log.info("========同步角色信息成功========");
			}else{
				throw new BLException("IGCO10000.E137",res);
			}
		}else {
			//非同步类型变成另一非同步类型时不进行任何处理
			if(StringUtils.isNotEmpty(role.getFingerPrint())){
				//由同步类型变成非同步类型时
				String res = synRoleUpdateDel(role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E030",form.getRolename());
				}else if("-2".equals(res)){
					throw new BLException("IGCO10000.E138",form.getRolename(),"没有");
				}/*else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","角色");
				}*/else if(res.indexOf("SUCCESSUPD")!=-1){
					form.setFingerPrint(null);//代表同步的字段置null
					log.info("========同步角色信息成功========");
				}else{
					throw new BLException("IGCO10000.E137",res);
				}
			}
		}
		
		roleBL.updateRole(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "角色基本信息") );
		return dto;
	}
	
	/***
	 * 同步到HQ库更新Role信息
	 * @param role
	 * @return
	 */
	private String synRoleUpdate(Role role) {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		if(role.getFingerPrint() == null){
			org.hyperic.hq.hqapi1.types.Role hqRole = new org.hyperic.hq.hqapi1.types.Role();
			//由其他类型转换成同步类型时create
			
			try {
				org.hyperic.hq.hqapi1.types.Role roleOne = roleApi.getRole(role.getRolename()).getRole();
				if(roleOne!=null){
					return "-2";
				}
			} catch (IOException e) {
				return "-1";
			}
			
			hqRole.setName(role.getRolename());
			RoleResponse rRes = null;
			try {
				rRes = roleApi.createRole(hqRole);
			} catch (IOException e) {
				return "-1";
			}
			if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
				return rRes.getRole().getId()+"SUCCESSUPD";//同步更新成功
			}else{
				return rRes.getError().getReasonText();
			}
		}else {
			//本身是同步类型时
			try {
				org.hyperic.hq.hqapi1.types.Role roleTwo = roleApi.getRole(Integer.parseInt(role.getFingerPrint())).getRole();
				System.out.println(roleTwo.getId());
				roleTwo.setName(role.getRolename());
				StatusResponse rRes = null;
				rRes = roleApi.updateRole(roleTwo);
				if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
					return roleTwo.getId()+"SUCCESSUPD";//同步更新成功
				}else{
					return rRes.getError().getReasonText();
				}
			} catch (IOException e) {
				return "-1";
			}
		}
	}
	
	/***
	 * 同步到HQ库更新Role信息
	 * 由同步类型转换为非同步类型是删除同步数据不管同步开关是不是开启状态
	 * @param role
	 * @return
	 */
	private String synRoleUpdateDel(String role_id){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//提取相应的配置信息
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
//		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
//		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
//			return "0";
//		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id)).getRole();
			if(roleTemp==null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		StatusResponse rRes = null;
		try {
			rRes = roleApi.deleteRole(Integer.parseInt(role_id));
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return "SUCCESSUPD";//同步更新成功
		}else{
			return rRes.getError().getReasonText();
		}
	}

	/**
	 * 调用DAO查询该主键标识的实体对象是否存在
	 * @param roleid Integer
	 * @return Role
	 * @throws BLException
	 */
	
	protected Role checkExistRole(Integer roleid) throws BLException{
		Role role = roleBL.searchRoleByKey(roleid);
		return role;
	}
	
	/**
	 * 注册角色
	 * @param role Role
	 * @return Role
	 */
	
	public Role registRole(Role role) throws BLException{
		//checkNotExistRole(role.getRolename());
		Role ret = roleBL.registRole(role);
		return ret;
	}
	
	/**
	 * 查询用户名是否存在
	 * @param rolename
	 * @throws BLException
	 */
	
	protected void checkNotExistRole(String rolename) throws BLException{
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename(rolename);
		List<Role> infoList = roleBL.searchRole(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","名称","角色基本");
		}
	}
	
	/**
	 * 根据传入的角色ID，查询树
	 * @param 角色ID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getRoleDomainsTree(String roleId) throws BLException{
		IGSYM03DTO dto = new IGSYM03DTO();
		Role info = roleBL.searchRoleByKey(Integer.parseInt(roleId));
		
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO igsym01dto = new IGSYM01DTO();
		

		String syscoding = info.getRoledomain();
		if(syscoding!=null && !"".equals(syscoding)){
			if(syscoding.length()>7){
				syscoding = syscoding.substring(0, 7);
			}
			//设置当前结点的完整树(从该级结点向下)
			form.setRoledomain_q(syscoding);
			
			form.setIs_in_use("1");
			
			igsym01dto.setOrganizationSearchCond(form);
			List<Organization> ret = organizationBL.searchOrganization(igsym01dto.getOrganizationSearchCond());//查该结点的下级机构树
			if(ret!=null && ret.size()>0){
				TreeNode ptNode = new TreeNode();
				ptNode.setId(ret.get(0).getOrgsyscoding());
				ptNode.setName(ret.get(0).getOrgname());
				//添加孩子结点
				int nowlen = ret.get(0).getOrgsyscoding().length();
				getChildTreeNodeMap(ret,ptNode,nowlen,syscoding);
				treeNodeMap.put(ptNode.getId(),ptNode);
			}
			
		}

		dto.setTreeNodeMap(treeNodeMap);

		return dto.getTreeNodeMap();
	}
}
