package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeCategoryDefBL;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.dto.IGSYM16DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1506Form;

/**
 * @Description: 基础数据管理
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGSYM16BLImpl extends BaseBLImpl implements IGSYM16BL {

	static Log log = LogFactory.getLog(IGSYM16BLImpl.class);

	/** 数据分类信息BL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/** 数据详细信息BL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** 资产信息BL */
	protected IG117BL ig117BL;
	
	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}

	

	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
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
//		List<Organization> ret = codeDetailDefBL.searchCodeDetail(cond, orderbyFlag);//查该角色管理域的下级机构树
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
	
	public IGSYM16DTO searchEntityTreeByLevelAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询Entitiy_TREE（指定1级结点）开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1506Form form = dto.getIgsym1506form();

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
			form = new IGSYM1506Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查该结点的下级结点树
		
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========查询Entitiy_TREE（指定1级结点）结束========");
		return dto;
	}
	
	/**
	 * <p>
	 * 查询Entitiy树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchEntityTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询Entitiy_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1506Form form = dto.getIgsym1506form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

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
			form = new IGSYM1506Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//查该结点的下级结点树
		
			//添加孩子结点
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding());
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
	private void getEntityChildTreeNodeMap(List<IG117Info> code,TreeNode ptNode,int ptlen,String syscoding){

		List<IG117Info> nextcode = getEntityNextLevelNodes(code,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getEid()+"_"+nextcode.get(i).getEsyscoding()+"_"+nextcode.get(i).getEcategory());
			pdNode.setName(nextcode.get(i).getEname());
				
			getEntityChildTreeNodeMap(code,pdNode,syscode.length(),syscode);
			
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
	
	private List<IG117Info> getEntityNextLevelNodes(List<IG117Info> code,int levellen,String syscode) {
		
		List<IG117Info> detail = new ArrayList<IG117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				detail.add(code.get(i));
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
	
	public IGSYM16DTO searchCodeTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询CODE_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		Map<String,TreeNode> treeNodeNewMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1502Form form = dto.getIgsym1502form();
		//String level = form.getClevel();//url传入，如存在则查1级结点树，否则查全部的树
		//form.setCdstatus("1");//只查启用中的code?
		int treeSize = 0;
		String ccid = form.getCcid();
			
		CodeCategoryDefInfo category = codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		
		TreeNode pNodeNew = new TreeNode();
		pNodeNew.setId(category.getCcid());
		pNodeNew.setName(category.getCcname());
		
		//'项目类型'结点不可选
//		if("115".equals(category.getCcid())){
//			pNode.setRemark("1");//1代表不可选
//		}
		if("1".equals(form.getRootSelect())){
			pNode.setRemark("1");//1代表不可选
		}

		form = new IGSYM1502Form();
		form.setCcid(ccid);
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		
		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
			treeSize+=detail.size();
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
			ptNode.setName(detail.get(0).getCvalue());
			
			
			
			TreeNode ptNodeNew = new TreeNode();
			ptNodeNew.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1级结点下级查询返回ccid、cid、syscoding
			ptNodeNew.setName(detail.get(0).getCvalue());
			

			//添加孩子结点
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			getChildTreeNodeNewMap(detail,ptNodeNew,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
			pNodeNew.addChildTreeNode(ptNodeNew.getId(), ptNodeNew);
		}
		treeNodeMap.put(pNode.getId(),pNode);
		treeNodeNewMap.put(pNodeNew.getId(),pNodeNew);

		
		dto.setTreeSize(String.valueOf(treeSize));
		dto.setTreeNodeMap(treeNodeMap);
		dto.setTreeNodeNewMap(treeNodeNewMap);
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
	
	public IGSYM16DTO searchProjectTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询Project_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1502Form form = dto.getIgsym1502form();
		String ccid = form.getCcid();
			
		CodeCategoryDefInfo category = codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
		if(category==null){
			return dto;
		}
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());

		form = new IGSYM1502Form();
		form.setCcid(ccid);
		form.setCdstatus("1");//查询状态为可用的数据
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
	
	public IGSYM16DTO searchSpecialCodeTreeByCdStatusAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询Special_CODE_TREE_By_CdStatus开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1502Form form = dto.getIgsym1502form();
		
		String ccid = form.getCcid();
	
		CodeCategoryDefInfo category = codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
		
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		form = new IGSYM1502Form();
		form.setCcid(ccid);
		form.setCdstatus("1");
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
	 * 查询1级结点不可选的数据信息树
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========查询Special_CODE_TREE开始========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1502Form form = dto.getIgsym1502form();
		
		String ccid = form.getCcid();
	
		CodeCategoryDefInfo category = codeCategoryDefiBL.searchCodeCategoryDefByPK(ccid);
		if(category==null){
			return dto;
		}
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		pNode.setRemark("1");

		form = new IGSYM1502Form();
		form.setCcid(ccid);
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//查所有的1级结点

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//设置当前结点的完整树(从该级结点向下)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//查该结点的下级结点树
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
	private void getChildTreeNodeMap(List<CodeDetailDef> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetailDef> nextcode = getNextLevelNodes(code,ptlen,syscoding);//取得该级结点的LIST

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
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author byf
	 */
	private void getChildTreeNodeNewMap(List<CodeDetailDef> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetailDef> nextcode = getNextLevelNodes(code,ptlen,syscoding);//取得该级结点的LIST

		for(int i=0,j=nextcode.size();i<j;i++){
			String syscode = nextcode.get(i).getSyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextcode.get(i).getCcid()+"_"+nextcode.get(i).getCid()+"_"+nextcode.get(i).getSyscoding());
			pdNode.setName(ptNode.getName()+"-"+nextcode.get(i).getCvalue());
				
			getChildTreeNodeNewMap(code,pdNode,syscode.length(),syscode);
			
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
	
	private List<CodeDetailDef> getNextLevelNodes(List<CodeDetailDef> code,int levellen,String syscode) {
		
		List<CodeDetailDef> detail = new ArrayList<CodeDetailDef>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getSyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				detail.add(code.get(i));
			}
			
		}
		
		return detail;
	}



	public void setCodeCategoryDefiBL(CodeCategoryDefBL codeCategoryDefiBL) {
		this.codeCategoryDefiBL = codeCategoryDefiBL;
	}



	
	

	
	
}
