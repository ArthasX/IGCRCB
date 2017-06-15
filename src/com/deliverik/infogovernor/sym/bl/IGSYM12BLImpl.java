package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.asset.EiRelationKeyWords;
import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeCategoryBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1201Form;
import com.deliverik.infogovernor.sym.form.IGSYM1202Form;

/**
 * @Description: 基础数据管理
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGSYM12BLImpl extends BaseBLImpl implements IGSYM12BL {

	static Log log = LogFactory.getLog(IGSYM12BLImpl.class);

	/** 数据分类信息BL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** 数据详细信息BL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** 资产信息BL */
	protected IG117BL ig117BL;
	
	/** soc资产信息BL */
	protected SOC0117BL soc0117BL;
	
	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}

	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * <p>
	 * 取得该结点的机构全名
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
//	private String getCompleteOrgName(String syscoding) {
//		IGSYM0101Form form = new IGSYM0101Form();
//		IGSYM01DTO dto = new IGSYM01DTO();
//		StringBuffer orgname = new StringBuffer();
//		
//		form.setComplete_name(syscoding);
//		//form.setIs_in_use("1");
//		dto.setOrganizationSearchCond(form);
//		List<Organization> ret = codeDetailBL.searchCodeDetail(cond, orderbyFlag);//查该角色管理域的下级机构树
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
	 * 查询Entitiy树（指定1级结点）
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Entitiy_TREE（指定1级结点）开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		String select = dto.getSelect_level();
		String del = dto.getDel_level();
		List<String> selectList = new ArrayList<String>();//需要查询的1级结点
		List<String> delList = new ArrayList<String>();//需要去掉的1级结点
		if(select!=null && !"".equals(select)){
			String[] selects = select.split("_");
			for(int i=0,j=selects.length;i<j;i++){
				selectList.add(selects[i]);
			}
			form.setSelectList(selectList);
		}
		
		if(del!=null && !"".equals(del)){
			String[] dels = del.split("_");
			for(int i=0,j=dels.length;i<j;i++){
				delList.add(dels[i]);
			}
			form.setDelList(delList);
		}

		//form.setEparcoding("999");//查1级结点(4位)
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		
		List<IG117Info> entitylist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查1级结点

		for(IG117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查该结点的下级结点树
		
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(),false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Entitiy_TREE（指定1级结点）结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 从SOC表查询Entitiy树（指定1级结点）
	 * </p>
	 * @throws BLException
	 * @author wangxing@deliverik.com
	 */
	public IGSYM12DTO searchSOCEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException{
		log.debug("========从SOC表查询Entitiy_TREE（指定1级结点）开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		String select = dto.getSelect_level();
		String del = dto.getDel_level();
		List<String> selectList = new ArrayList<String>();//需要查询的1级结点
		List<String> delList = new ArrayList<String>();//需要去掉的1级结点
		if(select!=null && !"".equals(select)){
			String[] selects = select.split("_");
			for(int i=0,j=selects.length;i<j;i++){
				selectList.add(selects[i]);
			}
			form.setSelectList(selectList);
		}
		
		if(del!=null && !"".equals(del)){
			String[] dels = del.split("_");
			for(int i=0,j=dels.length;i<j;i++){
				delList.add(dels[i]);
			}
			form.setDelList(delList);
		}

		//form.setEparcoding("999");//查1级结点(4位)
		form.setEstatus("1");
		dto.setSocEntitySearchCond(form);
		
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//查1级结点

		for(SOC0117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setSocEntitySearchCond(form);
			List<SOC0117Info> elist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//查该结点的下级结点树
		
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(),false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========从SOC表查询Entitiy_TREE（指定1级结点）结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询Entitiy树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchEntityTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Entitiy_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//查1级结点(4位)
		String estatus = form.getEstatus();
		//特殊情况：在CI故障分析时，需要能够查询到被停用的模型，
		if(estatus==null){
			form.setEstatus("1");
		}else{
			form.setEstatus(null);
		}
		String emodeltype_eq = form.getEmodeltype_eq();
		
		if(StringUtils.isNotEmpty(emodeltype_eq)) {
			form.setEmodeltype_eq(null);//树上需保留设备资产模型
			form.setEcategory("001");
		}

		dto.setEntitySearchCond(form);
		
		List<IG117Info> entitylist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查1级结点

		for(IG117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			//特殊情况：在CI故障分析时，需要能够查询到被停用的模型，
			if(estatus==null){
				form.setEstatus("1");
			}else{
				form.setEstatus(null);
			}
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查该结点的下级结点树
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			if(StringUtils.isNotEmpty(emodeltype_eq)) {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), true);
			} else {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			}
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Entitiy_TREE结束========");
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
	private void getEntityChildTreeNodeMap(List<IG117Info> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){

		List<IG117Info> nextcode = getEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getEid()+"_"+nextcode.get(i).getEsyscoding()+"_"+nextcode.get(i).getEcategory());
			pdNode.setName(nextcode.get(i).getEname());
				
			getEntityChildTreeNodeMap(code,pdNode,syscode.length(),syscode, emodeltype);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	
	/**
	 * <p>
	 * 查询子结点(SOC)
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getSocEntityChildTreeNodeMap(List<SOC0117Info> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){

		List<SOC0117Info> nextcode = getSocEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getEid()+"_"+nextcode.get(i).getEsyscoding()+"_"+nextcode.get(i).getEcategory());
			pdNode.setName(nextcode.get(i).getEname());
				
			getSocEntityChildTreeNodeMap(code,pdNode,syscode.length(),syscode, emodeltype);
			
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}

	}
	/**
	 * <p>
	 * 查询子结点(SOCVW)应急资源专用
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 */
	private void getSocVWEntityChildTreeNodeMap(List<SOC0117VWInfo> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){
		
		List<SOC0117VWInfo> nextcode = getSocVWEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//取得该级结点的LIST
		
		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getId()+"_"+nextcode.get(i).getEid()+"_"+nextcode.get(i).getEsyscoding()+"_"+nextcode.get(i).getEcategory());
			pdNode.setName(nextcode.get(i).getEname());
			
			getSocVWEntityChildTreeNodeMap(code,pdNode,syscode.length(),syscode, emodeltype);
			
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
	
	private List<IG117Info> getEntityNextLevelNodes(List<IG117Info> code,int levellen,String syscode, boolean emodeltype) {
		
		List<IG117Info> detail = new ArrayList<IG117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain管理中的CI查询只显示相关模型
				if(emodeltype && !"999001".equals(syscoding) && !EiRelationKeyWords.NETDEVICE.equals(syscoding)) {
					if("1".equals(code.get(i).getEmodeltype())) {
						detail.add(code.get(i));
					}
				} else {
					detail.add(code.get(i));
				}
			}
			
		}
		
		return detail;
	}
	
	/**
	 * <p>
	 * 取下一level的结点集合(SOC)
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<SOC0117Info> getSocEntityNextLevelNodes(List<SOC0117Info> code,int levellen,String syscode, boolean emodeltype) {
		
		List<SOC0117Info> detail = new ArrayList<SOC0117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain管理中的CI查询只显示相关模型
				if(emodeltype && !"999001".equals(syscoding) && !EiRelationKeyWords.NETDEVICE.equals(syscoding)) {
					if("1".equals(code.get(i).getEmodeltype())) {
						detail.add(code.get(i));
					}
				} else {
					detail.add(code.get(i));
				}
			}
			
		}
		
		return detail;
	}
	
	/**
	 * <p>
	 * 取下一level的结点集合(SOCVW)应急资源专用
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * 
	 */
	
	private List<SOC0117VWInfo> getSocVWEntityNextLevelNodes(List<SOC0117VWInfo> code,int levellen,String syscode, boolean emodeltype) {
		
		List<SOC0117VWInfo> detail = new ArrayList<SOC0117VWInfo>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain管理中的CI查询只显示相关模型
				if(emodeltype && !"999001".equals(syscoding) && !EiRelationKeyWords.NETDEVICE.equals(syscoding)) {
					if("1".equals(code.get(i).getEmodeltype())) {
						detail.add(code.get(i));
					}
				} else {
					detail.add(code.get(i));
				}
			}
			
		}
		
		return detail;
	}
	
	/**
	 * <p>
	 * 查询数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchCodeTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询CODE_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		//String level = form.getClevel();//url传入，如存在则查1级结点树，否则查全部的树
		//form.setCdstatus("1");//只查启用中的code?
		String ccid = form.getCcid();
			
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		//'项目类型'结点不可选
		if("115".equals(category.getCcid())){
			pNode.setRemark("1");//1代表不可选
		}

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
		log.debug("========查询CODE_TREE结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询项目类型数据信息树(项目登记使用)
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchProjectTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Project_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		String ccid = form.getCcid();
			
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		if(category==null){
			return dto;
		}
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		form.setCdstatus("1");//查询状态为可用的数据
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
			TreeNode ptNode = new TreeNode();
//			if(detail!=null && detail.size()>1){
//				ptNode.setRemark("1");//有下级的时候设置remark为1，代表不允许选择1级结点
//			}
			
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
			ptNode.setName(detail.get(0).getCvalue());
			
			//添加孩子结点
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);

		

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Project_TREE结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询1级结点不可选，并且状态为可用的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByCdStatusAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Special_CODE_TREE_By_CdStatus开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		
		String ccid = form.getCcid();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		form.setCdstatus("1");
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
		log.debug("========查询Special_CODE_TREE_By_CdStatus结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 只查询1级节点
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByPcidAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Special_CODE_TREE_By_CdStatus开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		
		String ccid = form.getCcid();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName("岗位");
		pNode.setRemark("1");

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		form.setCdstatus("1");
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailSearchCond(form);
    		List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
			ptNode.setName(detail.get(0).getCvalue());
//
//			//添加孩子结点
//			int nowlen = detail.get(0).getSyscoding().length();
//			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Special_CODE_TREE_By_CdStatus结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询1级结点不可选的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========查询Special_CODE_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		
		String ccid = form.getCcid();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		if(category==null){
			return dto;
		}
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
		log.debug("========查询Special_CODE_TREE结束========");
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

	public IGSYM12DTO searchSocEntityTreeAction(IGSYM12DTO dto)
			throws BLException {

		log.debug("========查询Entitiy_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//查1级结点(4位)
		String estatus = form.getEstatus();
		//特殊情况：在CI故障分析时，需要能够查询到被停用的模型，
		if(estatus==null){
			form.setEstatus("1");
		}else{
			form.setEstatus(null);
		}
		String emodeltype_eq = form.getEmodeltype_eq();
		
		if(StringUtils.isNotEmpty(emodeltype_eq)) {
			form.setEmodeltype_eq(null);//树上需保留设备资产模型
			form.setEcategory("001");
		}

		dto.setSocEntitySearchCond(form);
		
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//查1级结点

		for(SOC0117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//设置当前结点的完整树(从该级结点向下)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			//特殊情况：在CI故障分析时，需要能够查询到被停用的模型，
			if(estatus==null){
				form.setEstatus("1");
			}else{
				form.setEstatus(null);
			}
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setSocEntitySearchCond(form);
			List<SOC0117Info> elist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//查该结点的下级结点树
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			if(StringUtils.isNotEmpty(emodeltype_eq)) {
				getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), true);
			} else {
				getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			}
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Entitiy_TREE结束========");
		return dto;
	
	}
	/**
	 * 应急资源联合数据库查询资产模型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM12DTO searchSocVWEntityTreeAction(IGSYM12DTO dto)
			throws BLException {
		
		log.debug("========查询Entitiy_TREE开始========");
		SOC0117VWBL soc0117VWBL = (SOC0117VWBL) WebApplicationSupport.getBean("soc0117VWBL");
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		cond.setEstatus("1");
		if(StringUtils.isNotEmpty(form.getEsyscoding())&&!"999".equals(form.getEsyscoding())){
			cond.setEsyscoding(form.getEsyscoding().split("_")[1]);
			cond.setId(Integer.parseInt(form.getEsyscoding().split("_")[0]));
		}else{
			cond.setEparcoding("999");
//			应用系统(BSM)、IT设备(BSM)、设备资产、外包服务商、场地、外包人员、文档  梳理的模型列表
			List<String> eList = new ArrayList<String>();
			eList.add("999001");
			eList.add("999002");
			eList.add("999003");
			eList.add("999013");
			eList.add("999010");
			cond.setEsyscodingList(eList);
		}
		List<SOC0117VWInfo> entitylist = soc0117VWBL.searchEntity(cond, 0, 0);//查1级结点
		
		for(SOC0117VWInfo entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getId()+"_"+entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());
			SOC0117VWSearchCondImpl cond1 = new SOC0117VWSearchCondImpl();
			cond1.setId(entity.getId());
			cond1.setEstatus("1");
			//设置当前结点的完整树(从该级结点向下)
			cond1.setSyscoding_q(syscoding);
//			cond.setEparcoding(null);
//			dto.setSocEntitySearchCond(form);
			List<SOC0117VWInfo> elist = soc0117VWBL.searchEntity(cond1, 0, 0);//查该结点的下级结点树
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			getSocVWEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}
		
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Entitiy_TREE结束========");
		return dto;
		
	}
	

	
	
}
