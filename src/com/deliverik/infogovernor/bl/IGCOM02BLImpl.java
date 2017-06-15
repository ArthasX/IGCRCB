/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ������Ϣҵ���߼�ʵ��
 *
 */
public class IGCOM02BLImpl extends BaseBLImpl implements IGCOM02BL {

	static Log log = LogFactory.getLog(IGCOM02BLImpl.class);
	
	/** ��������ʶ */
	private static final String CCID = CodeDefine.getCodeDefine("REOPRT_TYPE_CODE").getCcid();
	
	/** һ���ڵ�code�볤��*/
	private static final int FIRST_NODE_CODE_LENGTH = CommonDefineUtils.CCID_LENGTH + CommonDefineUtils.TREE_LEVEL_CODE;
	
	/** ���ݷ�����ϢBL */
	protected CodeCategoryBL codeCategoryBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailBL codeDetailBL;
	
	/** ������ϢBL */
	protected ReportFileDefinitionBL reportFileDefinitionBL;
	
	/** �û���ɫ����*/
	protected UserRoleBL userRoleBL;
	
	/** ������Ȩ����*/
	protected RoleReportBL roleReportBL;

	protected SOC0305BL soc0305BL;
	
	/** ֪ʶ��BL*/
	protected KnowledgeBL knowledgeBL;
	/**
	 * ֪ʶ��BL�趨
	 *
	 * @param knowledgeBL ֪ʶ��BL
	 */
	public void setKnowledgeBL(KnowledgeBL knowledgeBL) {
		this.knowledgeBL = knowledgeBL;
	}

	/**
	 * soc0305BL�趨
	 *
	 * @param soc0305BL soc0305BL
	 */
	public void setSoc0305BL(SOC0305BL soc0305BL) {
		this.soc0305BL = soc0305BL;
	}

	/**
	 * ���ݷ�����ϢBL�趨
	 * @param codeCategoryBL ���ݷ�����ϢBL
	 */
	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
	}
	
	/**
	 * ������ȨBL�趨
	 * 
	 * @param userBL
	 */
	public void setRoleReportBL(RoleReportBL roleReportBL) {
		this.roleReportBL = roleReportBL;
	}
	
	/**
	 * �û���ɫBL�趨
	 * 
	 * @param userBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ���ݷ�����ϢBLȡ��
	 * @param codeDetailBL ���ݷ�����ϢBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * ������ϢBL�趨
	 * 
	 * @param reportFileDefinitionBL
	 */
	public void setReportFileDefinitionBL(
			ReportFileDefinitionBL reportFileDefinitionBL) {
		this.reportFileDefinitionBL = reportFileDefinitionBL;
	}

	/**
	 * �����������ѯ����δͣ�ã�
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	
	public IGCOM02DTO searchReportTypeTreeAction(IGCOM02DTO dto) throws BLException{
		log.debug("========�����������ѯ����ʼ========");
		
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
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

		cond = new CodeDetailSearchCondImpl();
		for(CodeDetail code:codelist){
			String syscoding = code.getSyscoding();
			
			//���õ�ǰ����������(�Ӹü��������)
			cond.setSyscoding_q(syscoding);
			cond.setCdstatus("1");
			List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
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
		log.debug("========�����������ѯ�������========");
		return dto;
	}
	
	/**
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGCOM02DTO
	 * @return IGCOM02DTO
	 */
	public IGCOM02DTO searchReportFileDefinitionAction(IGCOM02DTO dto) throws BLException {
		
		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//��ȡ�ڵ��������
		dto.setCompleteNodeName(this.getCompleteNodeName(dto.getReportFileDefinitionSearchCond().getRfdtype()));
		
		if(StringUtils.isEmpty(dto.getReportFileDefinitionSearchCond().getRfdtype())) {
			dto.addMessage(new ActionMessage("IGCOM0215.I001"));
			log.debug("========������Ϣ������========");
			log.debug("========������Ϣ��ѯ��������========");
			return dto;
		}
		
		
		//��ǰҳ������Ϣȡ��
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
//				//��ǰҳ������Ϣȡ��
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
		
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	
	public List<Integer> getRfdidByUser (IGCOM02DTO dto)throws BLException{
		UserRoleSearchCondImpl userRoleSearchCond = new UserRoleSearchCondImpl();
		RoleReportSearchCondImpl roleReportSearchCond = new RoleReportSearchCondImpl();
		
		
		//ͨ��userid��ȡUserRole���еĽ����
		String userid = dto.getUser().getUserid();		
		userRoleSearchCond.setUserid(userid);
		List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCond);
		
		//��ȡ���û����еĽ�ɫid
		List<Integer> roleidList = new ArrayList<Integer>();
		Iterator<UserRole> it = userRoleList.iterator();
		while(it.hasNext()){
			UserRole userRole1 = (UserRole)it.next();
			roleidList.add(userRole1.getRoleid());
		}
		
		//ͨ����ɫid��ȡ����Ȩ�ı���
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
		//ȥ���ظ���rfdid
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
	 * ������Ȩ��������ѯ
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGCOM02DTO filterReportTypeTreeAction(IGCOM02DTO dto) throws BLException{
		log.debug("========�����������ѯ����ʼ========");
		
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
		List<CodeDetail> codelist = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_2);//�����е�1�����

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
				//���õ�ǰ����������(�Ӹü��������)
				cond.setSyscoding_q(syscoding);
				cond.setCdstatus("1");
				List<CodeDetail> detail = codeDetailBL.searchCodeDetailTree(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_3);//��ý����¼������
				TreeNode ptNode = new TreeNode();
				ptNode.setId(detail.get(0).getCcid()+"_"+detail.get(0).getCid()+"_"+detail.get(0).getSyscoding());//1������¼���ѯ����ccid��cid��syscoding
				ptNode.setName(detail.get(0).getCvalue());
	
				//��Ӻ��ӽ��
				int nowlen = detail.get(0).getSyscoding().length();
				getImpowerChildTreeNodeMap(detail,ptNode,nowlen,syscoding,dto);
				pNode.addChildTreeNode(ptNode.getId(), ptNode);
				
			}
		}
		treeNodeMap.put(pNode.getId(),pNode);
	
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========�����������ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ����Ȩ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getImpowerChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding,IGCOM02DTO dto)
			throws BLException{

		List<CodeDetail> nextcode = getNextLevelNodes(code,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ��ȡrfdtype�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public List<String> getRfdtypeList(IGCOM02DTO dto)throws BLException{
		UserRoleSearchCondImpl userRoleSearchCond = new UserRoleSearchCondImpl();
		RoleReportSearchCondImpl roleReportSearchCond = new RoleReportSearchCondImpl();
		
		
		//ͨ��userid��ȡUserRole���еĽ����
		String userid = dto.getUser().getUserid();		
		userRoleSearchCond.setUserid(userid);
		List<UserRole> userRoleList = userRoleBL.searchUserRole(userRoleSearchCond);
		
		//��ȡ���û����еĽ�ɫid
		List<Integer> roleidList = new ArrayList<Integer>();
		Iterator<UserRole> it = userRoleList.iterator();
		while(it.hasNext()){
			UserRole userRole1 = (UserRole)it.next();
			roleidList.add(userRole1.getRoleid());
		}
		
		//ͨ����ɫid��ȡ����Ȩ�ı���
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
	
	/**
	 * �ڵ���������ȡ��
	 * @param syscoding �ڵ�����ͷ
	 * @return �ڵ���������
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
		//�����ݼ�����
		while(syscoding.length() >= FIRST_NODE_CODE_LENGTH) {
			cond.setSyscoding(syscoding);
			cdList = this.codeDetailBL.searchCodeDetail(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			if(cdList.size() == 1) {
				completeNodeNameList.add(cdList.get(0).getCvalue());
			} else {
				throw new BLException("IGCO10000.E004","�������Ͳ���루" + syscoding + "��");
			}
			syscoding = syscoding.substring(0, syscoding.length() - CommonDefineUtils.TREE_LEVEL_CODE);
		}
		//������ʾ
		Collections.reverse(completeNodeNameList);
		for(String name : completeNodeNameList) {
			completeNodeName += " &gt;&gt;" + name;
		}
		return completeNodeName;
	}
	/**
	 * Ӧ�ù�����ҳ��ʾ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM02DTO searchIgcom0218Action(IGCOM02DTO dto) throws BLException {
		log.debug("========Ӧ�ù�����ҳ��ʾ��ʼ========");
		SOC0305SearchCondImpl condOne=new SOC0305SearchCondImpl();
		condOne.setStatus("0");//0:δ����	1:�Ѵ���
		//�����澯��Ϣ
		List<SOC0307Info> soc0307List=this.soc0305BL.searchSOC0307(condOne,0,12);
		dto.setSoc0307List(soc0307List);
		
		KnowledgeSearchCondImpl cond=new KnowledgeSearchCondImpl();
		cond.setKnstatus("1");
		//���ݼ�����������֪ʶ��Ϣ
		List<Knowledge> knowledgeList=this.knowledgeBL.searchKnowledgeByCond(cond, 0, 0);
		dto.setKnowledgeList(knowledgeList);
		log.debug("========Ӧ�ù�����ҳ��ʾ����========");
		return dto;
	}
}
