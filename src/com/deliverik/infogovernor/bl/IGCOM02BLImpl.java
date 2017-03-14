/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0305BL;
import com.deliverik.framework.soc.asset.model.SOC0307Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0305SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.kgm.bl.task.KnowledgeBL;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCondImpl;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.RoleReportBL;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCondImpl;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 报表信息业务逻辑实现
 *
 */
public class IGCOM02BLImpl extends BaseBLImpl implements IGCOM02BL {

	static Log log = LogFactory.getLog(IGCOM02BLImpl.class);
	
	/** 报表分类标识 */
	private static final String CCID = CodeDefine.getCodeDefine("REOPRT_TYPE_CODE").getCcid();
	
	/** 一级节点code码长度*/
	private static final int FIRST_NODE_CODE_LENGTH = CommonDefineUtils.CCID_LENGTH + CommonDefineUtils.TREE_LEVEL_CODE;
	
	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	/** 报表信息BL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** 用户角色管理*/
	protected UserRoleBL userRoleBL;
	
	/** 报表授权管理*/
	protected RoleReportBL roleReportBL;

	protected SOC0305BL soc0305BL;
	
	/** 知识库BL*/
	protected KnowledgeBL knowledgeBL;
	/**
	 * 知识库BL设定
	 *
	 * @param knowledgeBL 知识库BL
	 */
	public void setKnowledgeBL(KnowledgeBL knowledgeBL) {
		this.knowledgeBL = knowledgeBL;
	}

	/**
	 * soc0305BL设定
	 *
	 * @param soc0305BL soc0305BL
	 */
	public void setSoc0305BL(SOC0305BL soc0305BL) {
		this.soc0305BL = soc0305BL;
	}

	/**
	 * 数据分类信息BL设定
	 * @param codeCategoryBL 数据分类信息BL
	 */
	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}
	
	/**
	 * 报表授权BL设定
	 * 
	 * @param userBL
	 */
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}
	
	/**
	 * 用户角色BL设定
	 * 
	 * @param userBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * 数据分类信息BL取得
	 * @param codeDetailBL 数据分类信息BL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * 报表信息BL设定
	 * 
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}

	/**
	 * 报表分类树查询处理（未停用）
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	
	public IGCOM02DTO searchReportTypeTreeAction(IGCOM02DTO dto) throws BLException{
		log.debug("========报表分类树查询处理开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(CCID);
		
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CCID);
		cond.setCdstatus("1");
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		cond = new CodeDetailSearchCondImpl();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			cond.setSyscoding_q(syscoding);
			cond.setCdstatus("1");
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
			ptNode.setName(detail.get(0).getCvalue());

			//添加孩子结点
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========报表分类树查询处理结束========");
		return dto;
	}
	
	/**
	 * 报表信息查询处理
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportFileDefinitionAction(IGCOM02DTO dto) throws BLException {
		
		log.debug("========报表信息查询处理开始========");
		
		//获取节点完成名称
		dto.setCompleteNodeName(this.getCompleteNodeName(dto.getReportFileDefinitionSearchCond().getRfdtype()));
		
		if(StringUtils.isEmpty(dto.getReportFileDefinitionSearchCond().getRfdtype())) {
			dto.addMessage(new ActionMessage("IGCOM0215.I001"));
			log.debug("========分类信息不存在========");
			log.debug("========报表信息查询处理终了========");
			return dto;
		}
		
		
		//当前页报表信息取得
		List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), 0, 0);
		
		dto.setReportFileDefinitionList(reportFileDefinitionList);
		
		if(reportFileDefinitionList.isEmpty()) {
			dto.addMessage(new ActionMessage("IGCOM0215.I002"));
		}
		
//		List<ReportFileDefinitionSearchCond> list = new ArrayList<ReportFileDefinitionSearchCond>();
//		
//		List<Integer> rfdidList = getRfdidByUser(dto);
//		Iterator<Integer> it1 = rfdidList.iterator();
//		while(it1.hasNext()){
//			Integer rfdid = (Integer)it1.next();
//			ReportFileDefinitionSearchCondImpl reportFileDefinitionSearchCond = new ReportFileDefinitionSearchCondImpl();
//			reportFileDefinitionSearchCond.setRfdid(rfdid);
//			reportFileDefinitionSearchCond.setRfdtype(dto.getReportFileDefinitionSearchCond().getRfdtype());
//			list.add(reportFileDefinitionSearchCond);
//		}
//		
//		Iterator<String> it = getRfdtypeList(dto).iterator();
//		while(it.hasNext()){
//			String syscoding = it.next().toString();
//			if(syscoding.equals(dto.getReportFileDefinitionSearchCond().getRfdtype())){
//				//当前页报表信息取得
//				Iterator<ReportFileDefinitionSearchCond> it2 = list.iterator();
//				List<ReportFileDefinition> reportFileDefinitionList = new ArrayList<ReportFileDefinition>();
//				while(it2.hasNext()){				
//					List<ReportFileDefinition> reportFileDefinition = this.reportFileDefinitionBL.searchReportFileDefinition((ReportFileDefinitionSearchCond)it2.next(), 0, 0);
//					Iterator<ReportFileDefinition> it4 = reportFileDefinition.iterator();
//					while(it4.hasNext()){
//						reportFileDefinitionList.add((ReportFileDefinition)it4.next());
//					}					
//				}
//				
//				if(reportFileDefinitionList.isEmpty()) {
//					dto.addMessage(new ActionMessage("IGRPT0102.I002"));
//				}
//				dto.setReportFileDefinitionList(reportFileDefinitionList);
//			}
//		}
		
		
		log.debug("========报表信息查询处理终了========");
		return dto;
	}
	
	public List<Integer> getRfdidByUser (IGCOM02DTO dto)throws BLException{
		UserRoleSearchCondImpl userRoleSearchCond = new UserRoleSearchCondImpl();
		RoleReportSearchCondImpl roleReportSearchCond = new RoleReportSearchCondImpl();
		
		
		//通过userid获取UserRole表中的结果集
		String userid = dto.getUser().getUserid();		
		userRoleSearchCond.setUserid(userid);
		List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCond);
		
		//获取此用户所有的角色id
		List<Integer> roleidList = new ArrayList<Integer>();
		Iterator<UserRole> it = userRoleList.iterator();
		while(it.hasNext()){
			UserRole userRole1 = (UserRole)it.next();
			roleidList.add(userRole1.getRoleid());
		}
		
		//通过角色id获取已授权的报表
		Iterator<Integer> it1 = roleidList.iterator();
		List<Integer> rfdidList = new ArrayList<Integer>();
		while(it1.hasNext()){
			Integer roleid = (Integer)it1.next();
			
			roleReportSearchCond.setRoleid(roleid);
			List<RoleReport> list = roleReportBL.searchRoleReportByRoleid(roleReportSearchCond);
			Iterator<RoleReport> it2 = list.iterator();
			while(it2.hasNext()){
				RoleReport roleReport1 = (RoleReport)it2.next();
				rfdidList.add(roleReport1.getRfdid());
			}
		}
		//去掉重复的rfdid
	    Set<Integer> set = new HashSet<Integer>();
	    List<Integer> newList = new ArrayList<Integer>();
	    for (Iterator<Integer> iter = rfdidList.iterator(); iter.hasNext();) {
	    	Integer element = (Integer)iter.next();
	        if (set.add(element)){
	        	newList.add(element);
	        }	        	
	    } 
	    rfdidList.clear();
	    rfdidList.addAll(newList);
	    
		
		return rfdidList;
	}
	
	/**
	 * 报表授权过滤树查询
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGCOM02DTO filterReportTypeTreeAction(IGCOM02DTO dto) throws BLException{
		log.debug("========报表分类树查询处理开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(CCID);
		
		if(category==null){
			return dto;
		}

		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		cond.setCcid(CCID);
		cond.setCdstatus("1");
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		cond = new CodeDetailSearchCondImpl();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			Integer i = 0;
			Iterator<String> it4 = getRfdtypeList(dto).iterator();
			while(it4.hasNext()){
				
				if(it4.next().toString().substring(0, syscoding.length()).equals(syscoding)){
					i++;
				}
			}
			if(i>0){			
				//设置当前结点的完整树(从该级结点向下)
				cond.setSyscoding_q(syscoding);
				cond.setCdstatus("1");
				List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
				TreeNode ptNode = new TreeNode();
				ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
				ptNode.setName(detail.get(0).getCvalue());
	
				//添加孩子结点
				int nowlen = detail.get(0).getSyscoding().length();
				getImpowerChildTreeNodeMap(detail,ptNode,nowlen,syscoding,dto);
				pNode.addChildTreeNode(ptNode.getId(), ptNode);
				
			}
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========报表分类树查询处理结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询已授权子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getImpowerChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding,IGCOM02DTO dto)
			throws BLException{

		List<CodeDetail> nextcode = getNextLevelNodes(code,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getSyscoding();
			
			Integer k = 0;
			Iterator<String> it4 = getRfdtypeList(dto).iterator();
			while(it4.hasNext()){
				String itString = it4.next().toString();
				String ii = itString.substring(0, (itString.length()>=syscode.length()?syscode.length():6));
				if(ii.equals(syscode)){
					k++;
				}
			}
			if(k>0){
				k = 0;
				TreeNode pdNode = new TreeNode();
				pdNode.setId(nextcode.get(i).getCcid()+"_"+nextcode.get(i).getCid()+"_"+nextcode.get(i).getSyscoding());
				pdNode.setName(nextcode.get(i).getCvalue());
					
				getImpowerChildTreeNodeMap(code,pdNode,syscode.length(),syscode,dto);
				
				ptNode.addChildTreeNode(pdNode.getId(),pdNode);
			}
		}

	}
	
	/**
	 * 获取rfdtype结果集
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public List<String> getRfdtypeList(IGCOM02DTO dto)throws BLException{
		UserRoleSearchCondImpl userRoleSearchCond = new UserRoleSearchCondImpl();
		RoleReportSearchCondImpl roleReportSearchCond = new RoleReportSearchCondImpl();
		
		
		//通过userid获取UserRole表中的结果集
		String userid = dto.getUser().getUserid();		
		userRoleSearchCond.setUserid(userid);
		List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCond);
		
		//获取此用户所有的角色id
		List<Integer> roleidList = new ArrayList<Integer>();
		Iterator<UserRole> it = userRoleList.iterator();
		while(it.hasNext()){
			UserRole userRole1 = (UserRole)it.next();
			roleidList.add(userRole1.getRoleid());
		}
		
		//通过角色id获取已授权的报表
		Iterator<Integer> it1 = roleidList.iterator();
		List<Integer> rfdidList = new ArrayList<Integer>();
		while(it1.hasNext()){
			Integer roleid = (Integer)it1.next();
			
			roleReportSearchCond.setRoleid(roleid);
			List<RoleReport> list = roleReportBL.searchRoleReportByRoleid(roleReportSearchCond);
			Iterator<RoleReport> it2 = list.iterator();
			while(it2.hasNext()){
				RoleReport roleReport1 = (RoleReport)it2.next();
				rfdidList.add(roleReport1.getRfdid());
			}
		}
		
		Iterator<Integer> it3 = rfdidList.iterator();
		List<String> rfdtype = new ArrayList<String>();
		while(it3.hasNext()){
			Integer rfdid = (Integer)it3.next();
			ReportFileDefinition reportFileDefinition = reportFileDefinitionBL.searchReportFileDefinitionByKey(rfdid);
			rfdtype.add(reportFileDefinition.getRfdtype());
		}

		return rfdtype;
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
	private void getChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetail> nextcode = getNextLevelNodes(code,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getSyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getCcid()+"_"+nextcode.get(i).getCid()+"_"+nextcode.get(i).getSyscoding());
			pdNode.setName(nextcode.get(i).getCvalue());
				
			getChildTreeNodeMap(code,pdNode,syscode.length(),syscode);
			
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
	
	private List<CodeDetail> getNextLevelNodes(List<CodeDetail> code,int levellen,String syscode) {
		
		List<CodeDetail> detail = new ArrayList<CodeDetail>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getSyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				detail.add(code.get(i));
			}
			
		}
		
		return detail;
	}
	
	/**
	 * 节点完整名称取得
	 * @param syscoding 节点层次码头
	 * @return 节点完整名称
	 * @throws BLException 
	 */
	private String getCompleteNodeName(String syscoding) throws BLException {
		String completeNodeName = this.codeCategoryBL.searchCodeCategoryByPK(CCID).getCcname();
		if(StringUtils.isEmpty(syscoding)) {
			return completeNodeName;
		}
		List<String> completeNodeNameList = new ArrayList<String>();
		List<CodeDetail> cdList = null;
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		//层次码递减查找
		while(syscoding.length() >= FIRST_NODE_CODE_LENGTH) {
			cond.setSyscoding(syscoding);
			cdList = this.codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList.size() == 1) {
				completeNodeNameList.add(cdList.get(0).getCvalue());
			} else {
				throw new BLException("IGCO10000.E004","报表类型层次码（" + syscoding + "）");
			}
			syscoding = syscoding.substring(0, syscoding.length() - CommonDefineUtils.TREE_LEVEL_CODE);
		}
		//正向显示
		Collections.reverse(completeNodeNameList);
		for(String name : completeNodeNameList) {
			completeNodeName += " &gt;&gt;" + name;
		}
		return completeNodeName;
	}
	/**
	 * 应用管理首页显示查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM02DTO searchIgcom0218Action(IGCOM02DTO dto) throws BLException {
		log.debug("========应用管理首页显示开始========");
		SOC0305SearchCondImpl condOne=new SOC0305SearchCondImpl();
		condOne.setStatus("0");//0:未处理	1:已处理
		//检索告警信息
		List<SOC0307Info> soc0307List=this.soc0305BL.searchSOC0307(condOne,0,12);
		dto.setSoc0307List(soc0307List);
		
		KnowledgeSearchCondImpl cond=new KnowledgeSearchCondImpl();
		cond.setKnstatus("1");
		//根据检索条件检索知识信息
		List<Knowledge> knowledgeList=this.knowledgeBL.searchKnowledgeByCond(cond, 0, 0);
		dto.setKnowledgeList(knowledgeList);
		log.debug("========应用管理首页显示结束========");
		return dto;
	}
}
