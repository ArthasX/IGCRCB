/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.rpt.bl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRole;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.dto.IGRPT01DTO;
import com.deliverik.infogovernor.sym.bl.task.CustomReportBL;
import com.deliverik.infogovernor.sym.bl.task.ReportFileDefinitionBL;
import com.deliverik.infogovernor.sym.bl.task.RoleReportBL;
import com.deliverik.infogovernor.sym.model.CustomReport;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.model.condition.CustomReportSearchCondImpl;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCondImpl;
import com.deliverik.infogovernor.sym.model.condition.RoleReportSearchCondImpl;
import com.deliverik.infogovernor.sym.model.entity.CustomReportTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 报表信息业务逻辑实现
 *
 */
public class IGRPT01BLImpl extends BaseBLImpl implements IGRPT01BL {

	static Log log = LogFactory.getLog(IGRPT01BLImpl.class);
	
	
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
	
	/** 用户信息查询*/
	protected UserBL userBL;
	
	/** 报表授权管理*/
	protected RoleReportBL roleReportBL;
	
	/** 用户角色管理*/
	protected UserRoleBL userRoleBL;
	
	protected CustomReportBL customReportBL;
	

	public void setCustomReportBL(CustomReportBL customReportBL) {
		this.customReportBL = customReportBL;
	}

	/**
	 * 数据分类信息BL设定
	 * @param codeCategoryBL 数据分类信息BL
	 */
	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
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
	 * 用户BL设定
	 * 
	 * @param userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
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
	 * 报表分类树查询处理（未停用）
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGRPT01DTO searchReportTypeTreeAction(IGRPT01DTO dto) throws BLException{
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
	 * 获取rfdtype结果集
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public List<String> getRfdtypeList(IGRPT01DTO dto)throws BLException{
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
	 * 报表授权过滤树查询
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGRPT01DTO filterReportTypeTreeAction(IGRPT01DTO dto) throws BLException{
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
	 * 报表信息查询处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportFileDefinitionAction(IGRPT01DTO dto) throws BLException {
		
		log.debug("========报表信息查询处理开始========");
		
		//获取节点完成名称
		dto.setCompleteNodeName(this.getCompleteNodeName(dto.getReportFileDefinitionSearchCond().getRfdtype()));
		
		if(StringUtils.isEmpty(dto.getReportFileDefinitionSearchCond().getRfdtype())) {
			dto.addMessage(new ActionMessage("IGRPT0102.I001"));
			log.debug("========分类信息不存在========");
			log.debug("========报表信息查询处理终了========");
			return dto;
		}
				
		List<ReportFileDefinitionSearchCond> list = new ArrayList<ReportFileDefinitionSearchCond>();
		
		List<Integer> rfdidList = getRfdidByUser(dto);
		Iterator<Integer> it1 = rfdidList.iterator();
		while(it1.hasNext()){
			Integer rfdid = (Integer)it1.next();
			ReportFileDefinitionSearchCondImpl reportFileDefinitionSearchCond = new ReportFileDefinitionSearchCondImpl();
			reportFileDefinitionSearchCond.setRfdid(rfdid);
			reportFileDefinitionSearchCond.setRfdtype(dto.getReportFileDefinitionSearchCond().getRfdtype());
			list.add(reportFileDefinitionSearchCond);
		}
		
		//当前页报表信息取得
		//List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), 0, 0);
		
		//dto.setReportFileDefinitionList(reportFileDefinitionList);
//		Integer i = 0;
		Iterator<String> it = getRfdtypeList(dto).iterator();
		while(it.hasNext()){
			String syscoding = it.next().toString();
			if(syscoding.equals(dto.getReportFileDefinitionSearchCond().getRfdtype())){
				//当前页报表信息取得
				Iterator<ReportFileDefinitionSearchCond> it2 = list.iterator();
				List<ReportFileDefinition> reportFileDefinitionList = new ArrayList<ReportFileDefinition>();
				while(it2.hasNext()){				
					List<ReportFileDefinition> reportFileDefinition = this.reportFileDefinitionBL.searchReportFileDefinition((ReportFileDefinitionSearchCond)it2.next(), 0, 0);
					Iterator<ReportFileDefinition> it4 = reportFileDefinition.iterator();
					while(it4.hasNext()){
						reportFileDefinitionList.add((ReportFileDefinition)it4.next());
					}					
				}
				
				if(reportFileDefinitionList.isEmpty()) {
					dto.addMessage(new ActionMessage("IGRPT0102.I002"));
				}
				dto.setReportFileDefinitionList(reportFileDefinitionList);
			}
		}
		
	//	if(reportFileDefinitionList.isEmpty()) {
	//		dto.addMessage(new ActionMessage("IGRPT0102.I002"));
	//	}
		
		log.debug("========报表信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 订制报表信息查询处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportByCustom(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();

		// 查询订制的报表ID
		CustomReportSearchCondImpl cond = new CustomReportSearchCondImpl();
		cond.setUserid(user.getUserid());
		List<CustomReport> crList = this.customReportBL.findByCond(cond, 0, 0);
		// 根据报表ID查询报表信息
		List<ReportFileDefinition> rfdList = new ArrayList<ReportFileDefinition>();
		if (crList != null && crList.size() > 0) {
			for (CustomReport cr : crList) {
				ReportFileDefinition rfd = this.reportFileDefinitionBL
						.searchReportFileDefinitionByKey(cr.getRfdid());
				rfdList.add(rfd);
			}
		}
		dto.setSelectedReportFileDefinitionList(rfdList);
		return dto;
	}
	
	/**
	 * 订制报表持久化处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO insertCustomReport(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();
		String[] rfdids = dto.getIgRPT0102Form().getUnselect();
		Integer ordernum = dto.getIgRPT0102Form().getOrdernum();

		// 循环插入各个报表
		for (String rfdid : rfdids) {
			CustomReportTB crTB = new CustomReportTB();
			crTB.setRfdid(Integer.valueOf(rfdid));
			crTB.setUserid(user.getUserid());
			crTB.setOrdernum(ordernum);
			// 顺序号加一
			ordernum++;
			this.customReportBL.saveProject(crTB);
		}

		return dto;
	}
	
	/**
	 * 取消订制报表处理
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO deleteCustomReport(IGRPT01DTO dto) throws BLException {

		String[] rfdids = dto.getIgRPT0102Form().getSelected();
		User user = dto.getUser();

		// 循环删除各个报表
		for (String rfdid : rfdids) {
			// 查找订制ID
			CustomReportSearchCondImpl crsCond = new CustomReportSearchCondImpl();
			crsCond.setRfdid(Integer.valueOf(rfdid));
			crsCond.setUserid(user.getUserid());
			List<CustomReport> crListI = this.customReportBL.findByCond(
					crsCond, 0, 0);
			this.customReportBL.deleteProject(crListI.get(0).getCrid());
		}

		// 将剩下的记录顺序号重置
		CustomReportSearchCondImpl cond = new CustomReportSearchCondImpl();
		cond.setUserid(user.getUserid());
		List<CustomReport> crList = customReportBL.findByCond(cond, 0, 0);
		if (crList != null && crList.size() > 0) {
			int ordernum = 1;
			for (CustomReport cr : crList) {
				CustomReportTB crTB = (CustomReportTB) cr;
				crTB.setOrdernum(ordernum);
				ordernum++;
				customReportBL.saveProject(crTB);
			}
		}

		return dto;
	}
	
	/**
	 * 订制报表排序处理
	 * 
	 * @param dto
	 *            IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO orderCustomReport(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();
		Integer rfdidI = dto.getIgRPT0102Form().getRfdidI();
		Integer rfdidII = dto.getIgRPT0102Form().getRfdidII();

		// 查询两个订制报表
		CustomReportSearchCondImpl condI = new CustomReportSearchCondImpl();
		condI.setUserid(user.getUserid());
		condI.setRfdid(rfdidI);
		List<CustomReport> crListI = this.customReportBL
				.findByCond(condI, 0, 0);
		CustomReportSearchCondImpl condII = new CustomReportSearchCondImpl();
		condII.setUserid(user.getUserid());
		condII.setRfdid(rfdidII);
		List<CustomReport> crListII = this.customReportBL.findByCond(condII, 0,
				0);
		CustomReportTB crTBI = (CustomReportTB) crListI.get(0);
		CustomReportTB crTBII = (CustomReportTB) crListII.get(0);
		// 将两个订制报表顺序号交换
		Integer orderT = crTBI.getOrdernum();
		crTBI.setOrdernum(crTBII.getOrdernum());
		crTBII.setOrdernum(orderT);
		// 持久化两个订制报表
		customReportBL.saveProject(crTBI);
		customReportBL.saveProject(crTBII);

		return dto;
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
	 * <p>
	 * 查询已授权子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getImpowerChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding,IGRPT01DTO dto)
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
	
	public List<Integer> getRfdidByUser (IGRPT01DTO dto)throws BLException{
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
	
	public List<Integer> getPiller() throws BLException{
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		list.add(rand.nextInt(100));
		return list;
		
	}
	
	public String getMap(String mapname)throws BLException{
		Random rand = new Random(new Date().getTime());
		Integer vara = rand.nextInt(500);
		Integer varb = rand.nextInt(500);
		Integer varc = rand.nextInt(500);
		Integer imga = rand.nextInt(3)+1;
		Integer imgb = rand.nextInt(3)+1;
		Integer imgc = rand.nextInt(3)+1;
		return vara.toString()+":"+imga.toString()+"|"+varb.toString()+":"+imgb.toString()+"|"+varc.toString()+":"+imgc.toString();
	}
	
	public int getStudy()throws BLException{
		Random rand = new Random(new Date().getTime());
		return rand.nextInt(100);
	}
	
	public void setCalendar(int year,int month)  throws BLException{
		try {
		    FileWriter filewriter = new FileWriter(new File(ResourceUtility.getString("PLAY_XML_PATH")+"\\calendar.xml"), false);
		    Random rand = new Random(new Date().getTime());
		    
		    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<ROOT>\n";
		    int monthcount = this.getMonthLastDay(year, month);
		    for(int i=1;i<=monthcount;i++){
		    	int type = rand.nextInt(4);
		    	switch(type){
		    	case 0:content = content+"<p type=\"n\" url=\"http://www.baidu.com\">"+i+"</p>\n";break;
		    	case 1:content = content+"<p type=\"a\" url=\"http://www.baidu.com\">"+i+"</p>\n";break;
		    	case 2:content = content+"<p type=\"b\" url=\"http://www.baidu.com\">"+i+"</p>\n";break;
		    	case 3:content = content+"<p type=\"c\" url=\"http://www.baidu.com\">"+i+"</p>\n";break;
		    	}
		    	
		    }
		    content = content+"</ROOT>\n";
		    filewriter.write(content);
		    filewriter.close();
		} catch (IOException e) {

		    e.printStackTrace();
		}
	}
	
	public int getMonthLastDay(int year, int month)   
	{   
	    Calendar a = Calendar.getInstance();   
	    a.set(Calendar.YEAR, year);   
	    a.set(Calendar.MONTH, month - 1);   
	    a.set(Calendar.DATE, 1);//把日期设置为当月第一天   
	    a.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天   
	    int maxDate = a.get(Calendar.DATE);   
	    return maxDate;   
	} 
	
	
}
