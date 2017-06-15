/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.form.IGSYM0102Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM01BLImpl extends BaseBLImpl implements IGSYM01BL {

	static Log log = LogFactory.getLog(IGSYM01BLImpl.class);
	
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
	
	/**
	 * 注入UserBL
	 */
	protected UserBL userBL;

	/**
	 * 设置UserBL
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	
	
	
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * 
	 */
//	private void getChildTreeNodeMap(IGSYM01DTO dto,TreeNode ptNode,String type){
//		
//		List<Organization> ret = organizationBL.getOrganizations(dto.getOrganizationSearchCond());
//		IGSYM0101Form form = new IGSYM0101Form();
//		form.setIs_in_use("1");
//		for(Organization org : ret){
//			TreeNode pdNode = new TreeNode();
//			if("ROLE".equals(type)){
//				pdNode.setId(org.getOrgsyscoding());
//			}else{
//				pdNode.setId(org.getOrgid()+"");
//			}
//			
//			pdNode.setName(org.getOrgname());
//
//			form.setOrgparid(org.getOrgid()+"");
//			//form.setOrgpar(null);
//			dto.setOrganizationSearchCond(form);
//			getChildTreeNodeMap(dto,pdNode,type);
//			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
//		}
//	}
//	
	
	
	
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
					orgname.append("-");
				}
				orgname.append(ret.get(i).getOrgname() == null ? "" : ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}
	
	/**
	 * <p>
	 * 查询存在的上级机构（一级机构）
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchOrgTreeAction(IGSYM01DTO dto,String type) throws BLException{
		log.debug("========一级机构查询处理开始========");
		
		IGSYM0101Form form = new IGSYM0101Form();
		form.setIs_in_use("1");
		form.setOrgpar("0001");//查1级机构(4位)
		form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查1级机构
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(Organization org : ret){
			TreeNode ptNode = new TreeNode();
			if("ROLE".equals(type)){
				ptNode.setId(org.getOrgsyscoding());
			}else{
				ptNode.setId(org.getOrgsyscoding());
			}
			
			ptNode.setName(org.getOrgname());
			ptNode.setBelong(org.getOrgsyscoding());
			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM0101Form();
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该结点的下级机构树
			//添加孩子结点
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========一级机构查询处理结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询存在的上级机构（一级机构）
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchItemTreeAction(IGSYM01DTO dto,String type) throws BLException{
		log.debug("========一级机构查询处理开始========");
		
		IGSYM0101Form form = new IGSYM0101Form();
		form.setIs_in_use("1");
		form.setOrgpar("0001");//查1级机构(4位)
		form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查1级机构
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		for(Organization org : ret){
			TreeNode ptNode = new TreeNode();
			if("ROLE".equals(type)){
				ptNode.setId(org.getOrgsyscoding());
			}else{
				ptNode.setId(org.getOrgsyscoding());
			}
			
			ptNode.setName(org.getOrgname());
			ptNode.setBelong(org.getOrgsyscoding());
			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM0101Form();
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该结点的下级机构树
			//添加孩子结点
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========一级机构查询处理结束========");
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
	
	
//	/**
//	 * <p>
//	 * 取得该结点的机构全名
//	 * </p>
//	 * @param 机构syscoding
//	 * @throws BLException
//	 * @author duchong@deliverik.com
//	 */
//	
//	public String getCompleteOrgName(String syscoding) {
//		IGSYM0101Form form = new IGSYM0101Form();
//		IGSYM01DTO dto = new IGSYM01DTO();
//		StringBuffer orgname = new StringBuffer();
//		
//		form.setComplete_name(syscoding);
//		form.setIs_in_use("1");
//		dto.setOrganizationSearchCond(form);
//		List<Organization> ret = organizationBL.getOrganizations(dto.getOrganizationSearchCond());//查该角色管理域的下级机构树
//		for(int i=0,j=ret.size();i<j;i++){
//			String syscode = ret.get(i).getOrgsyscoding();
//			if(syscoding.contains(syscode)){
//				if(i>0){
//					orgname.append("-");
//				}
//				orgname.append(ret.get(i).getOrgname());
//			}
//			
//		}
//		return orgname.toString();
//	}
	
	/**
	 * <p>
	 * Description: 取得包含机构全名的机构对象集合
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteOrgNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String name = "";
			if(ret.getOrgsyscoding()!=null && !"".equals(ret.getOrgsyscoding())){
				name = getCompleteOrgName(ret.getOrgsyscoding());
			}

			org.put(ret.getOrgid(), name);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * 判断每级机构是否可以停用
	 * </p>
	 * @param 机构syscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStop(String syscode) {
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		boolean flag = true;
		
		form.setOrgsyscoding_q(syscode);
		form.setIs_in_use("1");
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该机构是否存在使用中的下级机构
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'停用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getButtonNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String flag = "0";//0不显示 1显示
			
			if(isCouldStop(ret.getOrgsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getOrgid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * 判断每级机构是否可以启用
	 * </p>
	 * @param  机构syscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {

		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		boolean flag = true;
		
		form.setOrgsyscoding(syscode);//传入的syscode为当前结点的父结点的syscoding
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该机构是否存在停用的上级机构
		if(ret.get(0).getOrgstatus().equals("0")){//如果当前结点的上级是停用状态则当前结点不可启用
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'启用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getStartButtonNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String flag = "0";//0不显示 1显示
			String syscode = ret.getOrgsyscoding();

			if(syscode.length()==4){//代表为1级机构，则直接设置flag为1
				flag = "1";
			}else{
				if(isCouldStart(syscode.substring(0,syscode.length()-3))){
					flag = "1";
				}
				
			}

			org.put(ret.getOrgid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: 机构查询(IGASM1303Action调用)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM1303Action(IGSYM01DTO dto)
			throws BLException {
		log.debug("========机构查询处理开始========");
		//调用DAO接口查询
		List<Organization> organizationList = organizationBL.searchOrganization(dto.getOrganizationSearchCond(), 0, 0);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//设置机构全名
		//dto.setButtonMap(getButtonNameList(organizationList));
		//dto.setStartbuttonMap(getStartButtonNameList(organizationList));
		//dto.setOrganizationCondList(organizationList);
		if(organizationList!=null && organizationList.size()>0){
			dto.setOrganization(organizationList.get(0));
		}
		
		log.debug("========机构查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构查询(IGASM01BL调用)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM0101() throws BLException {
		log.debug("========机构查询处理开始========");
		IGSYM01DTO dto = new IGSYM01DTO();
		//调用DAO接口查询
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsuper(9);//去掉虚拟的机构根结点
		cond.setIs_in_use("1");//只查询启用的机构
		List<Organization> organizationList = organizationBL.searchOrganization(cond, 0, 0);
		List<Organization> orglist = new ArrayList<Organization>();
		for(Organization ret:organizationList){
			OrganizationTB org = (OrganizationTB)SerializationUtils.clone(ret);
			org.setOrgname(getCompleteOrgName(ret.getOrgsyscoding()));
			orglist.add(org);
		}

		dto.setOrganizationCondList(orglist);
	
		log.debug("========机构查询处理终了========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: 机构查询
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO searchOrganizationAction(IGSYM01DTO dto)
			throws BLException {
		log.debug("========机构查询处理开始========");
		// 查询记录总数
		int totalCount = organizationBL.getOrganizationSearchCount(dto
				.getOrganizationSearchCond());
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
		List<Organization> organizationList = organizationBL.searchOrganization(dto
				.getOrganizationSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//设置机构全名
		dto.setButtonMap(getButtonNameList(organizationList));
		dto.setStartbuttonMap(getStartButtonNameList(organizationList));
		dto.setOrganizationCondList(organizationList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========机构查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构状态变化
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public void changePTStatus(IGSYM01DTO dto) throws BLException {
		log.debug("========机构状态变化处理开始========");
		Organization organization = organizationBL.searchOrganizationByKey(dto.getChangeOrgid());
		OrganizationTB organizationTB = new OrganizationTB();
		organizationTB.clone(organization);
		if("0".equals(organization.getOrgstatus())){
			organizationTB.setOrgstatus("1");
		} else if ("1".equals(organization.getOrgstatus())){
			organizationTB.setOrgstatus("0");
		}
		
		organizationBL.updateOrganization(organizationTB);
		log.debug("========机构状态变化处理结束========");
		
	}

	/**
	 * <p>
	 * Description: 机构删除
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO deleteOrganizationAction(IGSYM01DTO dto) throws BLException {
		log.debug("========机构删除处理开始========");
		//循环删除
		for( int i=0;i<dto.getDeleteOrgid().length;i++ ){
			//机构删除主键
			String orgid = dto.getDeleteOrgid()[i];
			//调用DAO查询该主键标识的实体对象
			Organization organization = organizationBL.searchOrganizationByKey(Integer.parseInt(orgid));
			//不存在抛出异常
			if (organization == null){
				throw new BLException("IGSYM0101.E002");
			}
			//检验该机构下是否存在用户
			UserSearchCondImpl cond = new UserSearchCondImpl();
			cond.setOrgid(orgid);
			int totalCount = userBL.getUserSearchCount(cond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0101.E001",organization.getOrgname());
			}
			//检验该机构是否是父级机构
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			//orgCond.setOrgpar(Integer.parseInt(orgid));
			totalCount = organizationBL.getOrganizationSearchCount(orgCond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0101.E003",organization.getOrgname());
			}
			organizationBL.deleteOrganization(organization);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "机构基本信息"));
		log.debug("========机构删除处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构新增
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO insertOrganizationAction(IGSYM01DTO dto) throws BLException {
		log.debug("========机构新增处理开始========");
		//取得当前所选上级机构的下级机构的最后的syscoding,将其加1作为新增机构的syscoding
		IGSYM0102Form form = dto.getIgsym0102Form();
		IGSYM0101Form form1 = new IGSYM0101Form();
		form1.setOrgpar(form.getOrgpar());//form.getOrgpar()为当前结点的syscoding
		dto.setOrganizationSearchCond(form1);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond(),form1.getOrgpar());
		String syscode = "";
		String orgnum = ResourceUtility.getString("ORG_NUM");//机构编码的层次数
		if(orgnum == null || "".equals(orgnum)){
			orgnum = "6";
		}
		int org_num = Integer.valueOf(orgnum);
		int org_sys_len = 19;//机构编码的默认长度
		if(org_num>1 && org_num<10){
			org_sys_len = 4+3*(org_num-1);
		}
		
		if(ret.size()>0){//存在下级机构
			Organization org = ret.get(0);
			syscode = org.getOrgsyscoding();
			
			String temp = syscode.substring(syscode.length()-3);
			
			if(temp.substring(temp.length()-3).equals("999")){
				throw new BLException("IGSYM0101.E004","机构基本信息");
			}
			
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				syscode = syscode.substring(0,syscode.length()-3)+temp;
			}else{//***
				syscode = syscode.substring(0,syscode.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
			form.setOrgsyscoding(syscode);
		}else{
			
			form1 = new IGSYM0101Form();
			form1.setOrgsyscoding(form.getOrgpar());
			dto.setOrganizationSearchCond(form1);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());
			syscode = orglist.get(0).getOrgsyscoding();
			
			//判断是否已经达到规定的层次数
			if(syscode!=null && syscode.length()>=org_sys_len){
				throw new BLException("IGSYM0101.E005","机构基本信息");
			}

			form.setOrgsyscoding(syscode+"001");
		}
		
		dto.setOrganization(form);
		Organization organization = registOrganization(dto.getOrganization());
		dto.setOrganization(organization);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "机构基本信息") );
		log.debug("========机构新增处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO initIGSYM0102Action(IGSYM01DTO dto) throws BLException {
		log.debug("========变更用资产基本信息查询处理开始========");
		IGSYM0102Form form = dto.getIgsym0102Form();
		String orgidstr = form.getOrgidstr();
		Integer orgid = Integer.parseInt(orgidstr);
		Organization organization = organizationBL.searchOrganizationByKey(orgid);
		if ( organization == null ){
			throw new BLException("IGCO10000.E004","机构基本");
		}
		form.setOrgsyscoding(organization.getOrgsyscoding());
		form.setOrgusercoding(organization.getOrgusercoding());
		form.setOrgname(organization.getOrgname().split("-")[organization.getOrgname().split("-").length-1]);
		form.setOrgnamebak(organization.getOrgname());
		form.setOrgpar(organization.getOrgpar());
		form.setOrgdesc(organization.getOrgdesc());
		form.setOrgaddr(organization.getOrgaddr());
		form.setOrgphone(organization.getOrgphone());
		form.setOrgfax(organization.getOrgfax());
		form.setOrgcontact(organization.getOrgcontact());
		form.setOrgparname(organization.getOrgparname());
		//变更初始化模式
		form.setMode("1");
		searchOrganizationAll(dto);
		dto.addMessage(new ActionMessage("IGCO10000.I001","机构基本信息"));
		log.debug("========变更用机构基本信息查询处理终了========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: 机构变更
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM01DTO updateOrganizationAction(IGSYM01DTO dto) throws BLException{
		//checkExistOrganization(dto.getOrganization().getOrgid());
		//IGSYM0102Form form = (IGSYM0102Form)dto.getOrganization();
		//if(!form.getOrgname().equals(form.getOrgnamebak())){
		//	checkNotExistOrganization(form.getOrgname());
		//}
		organizationBL.updateOrganization(dto.getOrganization());
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "机构基本信息") );
		return dto;
	}
	
	
	/**
	 * 调用DAO查询该主键标识的实体对象
	 * @param orgid Integer
	 * @return Organization
	 */
	
	public Organization registOrganization(Organization organization) throws BLException{
		//checkNotExistOrganization(organization.getOrgname());
		Organization ret = organizationBL.registOrganization(organization);
		return ret;
	}
	
	/**
	 * 查询机构名是否存在
	 * @param orgname
	 * @throws BLException
	 */
	
	protected void checkNotExistOrganization(String orgname) throws BLException{
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgname(orgname);
		List<Organization> infoList = organizationBL.searchOrganization(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","名称","机构基本");
		}
	}
	
	/**
	 * 根据传入的机构ID，查询树
	 * @param 机构ID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getOrgsyscodingTree(String orgid) throws BLException{
		IGSYM03DTO dto = new IGSYM03DTO();
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO igsym01dto = new IGSYM01DTO();
		

		String syscoding = orgid;
		if(syscoding!=null && !"".equals(syscoding)){
//			if(syscoding.length()>7){
//				syscoding = syscoding.substring(0, 7);
//			}
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
	/**
	 * 查询所有机构
	 * @return List<Organization>
	 */
	
	public IGSYM01DTO searchOrganizationAll(IGSYM01DTO dto) throws BLException{
		List<Organization> organizationList = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
		dto.setOrganizationList(organizationList);
		return dto;
	}
    public IGSYM01DTO searchITEMS0174Tree(IGSYM01DTO dto)throws BLException{
    	IGSYM0101Form form = new IGSYM0101Form();
    	//调用DAO接口查询
    	
    	List<Organization> ret=new ArrayList<Organization>();
    	if(organizationBL.searchOrganization(dto.getOrganizationSearchCond())!=null){
    		//这里只要顶级节点支行
    		if(organizationBL.searchOrganization(dto.getOrganizationSearchCond()).size()>0){
    			ret=organizationBL.searchOrganization(dto.getOrganizationSearchCond()).subList(0, 1);
    		}
    	}
		 
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
	   
		for(Organization org : ret){
			TreeNode ptNode = new TreeNode();
			
				ptNode.setId(org.getOrgsyscoding());
			
			
			ptNode.setName(org.getOrgname());
			ptNode.setBelong(org.getOrgsyscoding());
			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM0101Form();
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//查该结点的下级机构树
			//添加孩子结点
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========一级机构查询处理结束========");
		return dto;
    }
	
}
