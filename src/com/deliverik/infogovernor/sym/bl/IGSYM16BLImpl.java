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
 * @Description: �������ݹ���
 * @Author  
 * @History 2009-8-18     �½� 
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGSYM16BLImpl extends BaseBLImpl implements IGSYM16BL {

	static Log log = LogFactory.getLog(IGSYM16BLImpl.class);

	/** ���ݷ�����ϢBL */
	protected CodeCategoryDefBL codeCategoryDefiBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** �ʲ���ϢBL */
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
	 * ȡ�øý��Ļ���ȫ��
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
//		List<Organization> ret = codeDetailDefBL.searchCodeDetail(cond, orderbyFlag);//��ý�ɫ��������¼�������
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
	 * ��ѯEntitiy����ָ��1����㣩
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchEntityTreeByLevelAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯEntitiy_TREE��ָ��1����㣩��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1506Form form = dto.getIgsym1506form();

		String select = dto.getSelect_level();
		String del = dto.getDel_level();
		List<String> selectList = new ArrayList<String>();//��Ҫ��ѯ��1�����
		List<String> delList = new ArrayList<String>();//��Ҫȥ����1�����
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

		//form.setEparcoding("999");//��1�����(4λ)
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		
		List<IG117Info> entitylist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��1�����

		for(IG117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM1506Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��ý����¼������
		
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE��ָ��1����㣩����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯEntitiy��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchEntityTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯEntitiy_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1506Form form = dto.getIgsym1506form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//��1�����(4λ)
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		
		List<IG117Info> entitylist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��1�����

		for(IG117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM1506Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��ý����¼������
		
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getEntityChildTreeNodeMap(List<IG117Info> code,TreeNode ptNode,int ptlen,String syscoding){

		List<IG117Info> nextcode = getEntityNextLevelNodes(code,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
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
	 * ��ѯ������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchCodeTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯCODE_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		Map<String,TreeNode> treeNodeNewMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1502Form form = dto.getIgsym1502form();
		//String level = form.getClevel();//url���룬��������1��������������ȫ������
		//form.setCdstatus("1");//ֻ�������е�code?
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
		
		//'��Ŀ����'��㲻��ѡ
//		if("115".equals(category.getCcid())){
//			pNode.setRemark("1");//1������ѡ
//		}
		if("1".equals(form.getRootSelect())){
			pNode.setRemark("1");//1������ѡ
		}

		form = new IGSYM1502Form();
		form.setCcid(ccid);
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		
		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			treeSize+=detail.size();
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNode.setName(detail.get(0).getCvalue());
			
			
			
			TreeNode ptNodeNew = new TreeNode();
			ptNodeNew.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNodeNew.setName(detail.get(0).getCvalue());
			

			//��Ӻ��ӽ��
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
		log.debug("========��ѯCODE_TREE����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ��Ŀ����������Ϣ��(��Ŀ�Ǽ�ʹ��)
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchProjectTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯProject_TREE��ʼ========");
		
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
		form.setCdstatus("1");//��ѯ״̬Ϊ���õ�����
		dto.setCodeDetailDefSearchCond(form);
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			TreeNode ptNode = new TreeNode();
//			if(detail!=null && detail.size()>1){
//				ptNode.setRemark("1");//���¼���ʱ������remarkΪ1����������ѡ��1�����
//			}
			
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNode.setName(detail.get(0).getCvalue());
			
			//��Ӻ��ӽ��
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);

		

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯProject_TREE����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ������״̬Ϊ���õ�������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeByCdStatusAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯSpecial_CODE_TREE_By_CdStatus��ʼ========");
		
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
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNode.setName(detail.get(0).getCvalue());

			//��Ӻ��ӽ��
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯSpecial_CODE_TREE_By_CdStatus����========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * ��ѯ1����㲻��ѡ��������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM16DTO searchSpecialCodeTreeAction(IGSYM16DTO dto) throws BLException{
		log.debug("========��ѯSpecial_CODE_TREE��ʼ========");
		
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
		List<CodeDetailDef> codelist = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1502Form();
		for(CodeDetailDef code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailDefSearchCond(form);
			List<CodeDetailDef> detail = codeDetailDefBL.searchCodeDetailDefTree(dto.getCodeDetailDefSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNode.setName(detail.get(0).getCvalue());

			//��Ӻ��ӽ��
			int nowlen = detail.get(0).getSyscoding().length();
			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
			pNode.addChildTreeNode(ptNode.getId(), ptNode);
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯSpecial_CODE_TREE����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getChildTreeNodeMap(List<CodeDetailDef> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetailDef> nextcode = getNextLevelNodes(code,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author byf
	 */
	private void getChildTreeNodeNewMap(List<CodeDetailDef> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetailDef> nextcode = getNextLevelNodes(code,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
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
