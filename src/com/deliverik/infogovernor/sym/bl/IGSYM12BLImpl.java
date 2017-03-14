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
 * @Description: �������ݹ���
 * @Author  
 * @History 2009-8-18     �½� 
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGSYM12BLImpl extends BaseBLImpl implements IGSYM12BL {

	static Log log = LogFactory.getLog(IGSYM12BLImpl.class);

	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** �ʲ���ϢBL */
	protected IG117BL ig117BL;
	
	/** soc�ʲ���ϢBL */
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
//		List<Organization> ret = codeDetailBL.searchCodeDetail(cond, orderbyFlag);//��ý�ɫ��������¼�������
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
	
	public IGSYM12DTO searchEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯEntitiy_TREE��ָ��1����㣩��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

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
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��ý����¼������
		
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(),false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE��ָ��1����㣩����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��SOC���ѯEntitiy����ָ��1����㣩
	 * </p>
	 * @throws BLException
	 * @author wangxing@deliverik.com
	 */
	public IGSYM12DTO searchSOCEntityTreeByLevelAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��SOC���ѯEntitiy_TREE��ָ��1����㣩��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

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
		dto.setSocEntitySearchCond(form);
		
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//��1�����

		for(SOC0117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			form.setEstatus("1");
			dto.setSocEntitySearchCond(form);
			List<SOC0117Info> elist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//��ý����¼������
		
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(),false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��SOC���ѯEntitiy_TREE��ָ��1����㣩����========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯEntitiy��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchEntityTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯEntitiy_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//��1�����(4λ)
		String estatus = form.getEstatus();
		//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
		if(estatus==null){
			form.setEstatus("1");
		}else{
			form.setEstatus(null);
		}
		String emodeltype_eq = form.getEmodeltype_eq();
		
		if(StringUtils.isNotEmpty(emodeltype_eq)) {
			form.setEmodeltype_eq(null);//�����豣���豸�ʲ�ģ��
			form.setEcategory("001");
		}

		dto.setEntitySearchCond(form);
		
		List<IG117Info> entitylist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��1�����

		for(IG117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
			if(estatus==null){
				form.setEstatus("1");
			}else{
				form.setEstatus(null);
			}
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setEntitySearchCond(form);
			List<IG117Info> elist = ig117BL.searchIG117Info(dto.getEntitySearchCond(), 0, 0);//��ý����¼������
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			if(StringUtils.isNotEmpty(emodeltype_eq)) {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), true);
			} else {
				getEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			}
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
	private void getEntityChildTreeNodeMap(List<IG117Info> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){

		List<IG117Info> nextcode = getEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//ȡ�øü�����LIST

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
	 * ��ѯ�ӽ��(SOC)
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getSocEntityChildTreeNodeMap(List<SOC0117Info> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){

		List<SOC0117Info> nextcode = getSocEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//ȡ�øü�����LIST

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
	 * ��ѯ�ӽ��(SOCVW)Ӧ����Դר��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 */
	private void getSocVWEntityChildTreeNodeMap(List<SOC0117VWInfo> code,TreeNode ptNode,int ptlen,String syscoding, boolean emodeltype){
		
		List<SOC0117VWInfo> nextcode = getSocVWEntityNextLevelNodes(code,ptlen,syscoding, emodeltype);//ȡ�øü�����LIST
		
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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<IG117Info> getEntityNextLevelNodes(List<IG117Info> code,int levellen,String syscode, boolean emodeltype) {
		
		List<IG117Info> detail = new ArrayList<IG117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain�����е�CI��ѯֻ��ʾ���ģ��
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
	 * ȡ��һlevel�Ľ�㼯��(SOC)
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private List<SOC0117Info> getSocEntityNextLevelNodes(List<SOC0117Info> code,int levellen,String syscode, boolean emodeltype) {
		
		List<SOC0117Info> detail = new ArrayList<SOC0117Info>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain�����е�CI��ѯֻ��ʾ���ģ��
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
	 * ȡ��һlevel�Ľ�㼯��(SOCVW)Ӧ����Դר��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
	 * @throws BLException
	 * 
	 */
	
	private List<SOC0117VWInfo> getSocVWEntityNextLevelNodes(List<SOC0117VWInfo> code,int levellen,String syscode, boolean emodeltype) {
		
		List<SOC0117VWInfo> detail = new ArrayList<SOC0117VWInfo>();
		for(int i=0,j=code.size();i<j;i++){
			String syscoding = code.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)
					&& (syscoding.substring(0,syscoding.length()-CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)).equals(syscode)){
				//domain�����е�CI��ѯֻ��ʾ���ģ��
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
	 * ��ѯ������Ϣ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchCodeTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯCODE_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		//String level = form.getClevel();//url���룬��������1��������������ȫ������
		//form.setCdstatus("1");//ֻ�������е�code?
		String ccid = form.getCcid();
			
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName(category.getCcname());
		//'��Ŀ����'��㲻��ѡ
		if("115".equals(category.getCcid())){
			pNode.setRemark("1");//1������ѡ
		}

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
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
	
	public IGSYM12DTO searchProjectTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯProject_TREE��ʼ========");
		
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
		form.setCdstatus("1");//��ѯ״̬Ϊ���õ�����
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
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
	
	public IGSYM12DTO searchSpecialCodeTreeByCdStatusAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯSpecial_CODE_TREE_By_CdStatus��ʼ========");
		
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
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
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
	 * ֻ��ѯ1���ڵ�
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM12DTO searchSpecialCodeTreeByPcidAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯSpecial_CODE_TREE_By_CdStatus��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1201Form form = dto.getIgsym1201form();
		
		String ccid = form.getCcid();
	
		CodeCategoryInfo category = codeCategoryBL.searchCodeCategoryByPK(ccid);
		
		if(category==null){
			return dto;
		}
		
		TreeNode pNode = new TreeNode();
		pNode.setId(category.getCcid());
		pNode.setName("��λ");
		pNode.setRemark("1");

		form = new IGSYM1201Form();
		form.setCcid(ccid);
		form.setCdstatus("1");
		dto.setCodeDetailSearchCond(form);
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			form.setCdstatus("1");
			dto.setCodeDetailSearchCond(form);
    		List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
			TreeNode ptNode = new TreeNode();
			ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
			ptNode.setName(detail.get(0).getCvalue());
//
//			//��Ӻ��ӽ��
//			int nowlen = detail.get(0).getSyscoding().length();
//			getChildTreeNodeMap(detail,ptNode,nowlen,syscoding);
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
	
	public IGSYM12DTO searchSpecialCodeTreeAction(IGSYM12DTO dto) throws BLException{
		log.debug("========��ѯSpecial_CODE_TREE��ʼ========");
		
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
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		form = new IGSYM1201Form();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			form.setSyscoding_q(syscoding);
			dto.setCodeDetailSearchCond(form);
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(dto.getCodeDetailSearchCond(), CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
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
	private void getChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding){

		List<CodeDetail> nextcode = getNextLevelNodes(code,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
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

		log.debug("========��ѯEntitiy_TREE��ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM1202Form form = dto.getIgsym1202form();

		//String esys = form.getEsyscoding();
		//String eparsys = form.getEparcoding();

		//form.setEparcoding("999");//��1�����(4λ)
		String estatus = form.getEstatus();
		//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
		if(estatus==null){
			form.setEstatus("1");
		}else{
			form.setEstatus(null);
		}
		String emodeltype_eq = form.getEmodeltype_eq();
		
		if(StringUtils.isNotEmpty(emodeltype_eq)) {
			form.setEmodeltype_eq(null);//�����豣���豸�ʲ�ģ��
			form.setEcategory("001");
		}

		dto.setSocEntitySearchCond(form);
		
		List<SOC0117Info> entitylist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//��1�����

		for(SOC0117Info entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());

			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM1202Form();
			form.setSyscoding_q(syscoding);
			//�����������CI���Ϸ���ʱ����Ҫ�ܹ���ѯ����ͣ�õ�ģ�ͣ�
			if(estatus==null){
				form.setEstatus("1");
			}else{
				form.setEstatus(null);
			}
			if("999007".equals(syscoding) && !"0".equals(form.getType())){
				form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			}
			dto.setSocEntitySearchCond(form);
			List<SOC0117Info> elist = soc0117BL.searchEntity(dto.getSocEntitySearchCond(), 0, 0);//��ý����¼������
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			if(StringUtils.isNotEmpty(emodeltype_eq)) {
				getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), true);
			} else {
				getSocEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			}
			treeNodeMap.put(ptNode.getId(),ptNode);
		}

		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE����========");
		return dto;
	
	}
	/**
	 * Ӧ����Դ�������ݿ��ѯ�ʲ�ģ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM12DTO searchSocVWEntityTreeAction(IGSYM12DTO dto)
			throws BLException {
		
		log.debug("========��ѯEntitiy_TREE��ʼ========");
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
//			Ӧ��ϵͳ(BSM)��IT�豸(BSM)���豸�ʲ�����������̡����ء������Ա���ĵ�  �����ģ���б�
			List<String> eList = new ArrayList<String>();
			eList.add("999001");
			eList.add("999002");
			eList.add("999003");
			eList.add("999013");
			eList.add("999010");
			cond.setEsyscodingList(eList);
		}
		List<SOC0117VWInfo> entitylist = soc0117VWBL.searchEntity(cond, 0, 0);//��1�����
		
		for(SOC0117VWInfo entity:entitylist){
			TreeNode ptNode = new TreeNode();
			String syscoding = entity.getEsyscoding();
			ptNode.setId(entity.getId()+"_"+entity.getEid()+"_"+entity.getEsyscoding()+"_"+entity.getEcategory());
			ptNode.setName(entity.getEname());
			SOC0117VWSearchCondImpl cond1 = new SOC0117VWSearchCondImpl();
			cond1.setId(entity.getId());
			cond1.setEstatus("1");
			//���õ�ǰ����������(�Ӹü��������)
			cond1.setSyscoding_q(syscoding);
//			cond.setEparcoding(null);
//			dto.setSocEntitySearchCond(form);
			List<SOC0117VWInfo> elist = soc0117VWBL.searchEntity(cond1, 0, 0);//��ý����¼������
			//��Ӻ��ӽ��
			int nowlen = elist.get(0).getEsyscoding().length();
			getSocVWEntityChildTreeNodeMap(elist,ptNode,nowlen,entity.getEsyscoding(), false);
			treeNodeMap.put(ptNode.getId(),ptNode);
		}
		
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯEntitiy_TREE����========");
		return dto;
		
	}
	

	
	
}
