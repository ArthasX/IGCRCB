/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ������Ϣҵ���߼�ʵ��
 *
 */
public class IGRPT01BLImpl extends BaseBLImpl implements IGRPT01BL {

	static Log log = LogFactory.getLog(IGRPT01BLImpl.class);
	
	
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
	
	/** �û���Ϣ��ѯ*/
	protected UserBL userBL;
	
	/** ������Ȩ����*/
	protected RoleReportBL roleReportBL;
	
	/** �û���ɫ����*/
	protected UserRoleBL userRoleBL;
	
	protected CustomReportBL customReportBL;
	

	public void setCustomReportBL(CustomReportBL customReportBL) {
		this.customReportBL = customReportBL;
	}

	/**
	 * ���ݷ�����ϢBL�趨
	 * @param codeCategoryBL ���ݷ�����ϢBL
	 */
	public void setCodeCategoryBL(CodeCategoryBL codeCategoryBL) {
		this.codeCategoryBL = codeCategoryBL;
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
	 * �û�BL�趨
	 * 
	 * @param userBL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
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
	 * �����������ѯ����δͣ�ã�
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGRPT01DTO searchReportTypeTreeAction(IGRPT01DTO dto) throws BLException{
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
	 * ��ȡrfdtype�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public List<String> getRfdtypeList(IGRPT01DTO dto)throws BLException{
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
	 * ������Ȩ��������ѯ
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	
	public IGRPT01DTO filterReportTypeTreeAction(IGRPT01DTO dto) throws BLException{
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
	 * ������Ϣ��ѯ����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportFileDefinitionAction(IGRPT01DTO dto) throws BLException {
		
		log.debug("========������Ϣ��ѯ����ʼ========");
		
		//��ȡ�ڵ��������
		dto.setCompleteNodeName(this.getCompleteNodeName(dto.getReportFileDefinitionSearchCond().getRfdtype()));
		
		if(StringUtils.isEmpty(dto.getReportFileDefinitionSearchCond().getRfdtype())) {
			dto.addMessage(new ActionMessage("IGRPT0102.I001"));
			log.debug("========������Ϣ������========");
			log.debug("========������Ϣ��ѯ��������========");
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
		
		//��ǰҳ������Ϣȡ��
		//List<ReportFileDefinition> reportFileDefinitionList = this.reportFileDefinitionBL.searchReportFileDefinition(dto.getReportFileDefinitionSearchCond(), 0, 0);
		
		//dto.setReportFileDefinitionList(reportFileDefinitionList);
//		Integer i = 0;
		Iterator<String> it = getRfdtypeList(dto).iterator();
		while(it.hasNext()){
			String syscoding = it.next().toString();
			if(syscoding.equals(dto.getReportFileDefinitionSearchCond().getRfdtype())){
				//��ǰҳ������Ϣȡ��
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
		
		log.debug("========������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ���Ʊ�����Ϣ��ѯ����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO searchReportByCustom(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();

		// ��ѯ���Ƶı���ID
		CustomReportSearchCondImpl cond = new CustomReportSearchCondImpl();
		cond.setUserid(user.getUserid());
		List<CustomReport> crList = this.customReportBL.findByCond(cond, 0, 0);
		// ���ݱ���ID��ѯ������Ϣ
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
	 * ���Ʊ���־û�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO insertCustomReport(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();
		String[] rfdids = dto.getIgRPT0102Form().getUnselect();
		Integer ordernum = dto.getIgRPT0102Form().getOrdernum();

		// ѭ�������������
		for (String rfdid : rfdids) {
			CustomReportTB crTB = new CustomReportTB();
			crTB.setRfdid(Integer.valueOf(rfdid));
			crTB.setUserid(user.getUserid());
			crTB.setOrdernum(ordernum);
			// ˳��ż�һ
			ordernum++;
			this.customReportBL.saveProject(crTB);
		}

		return dto;
	}
	
	/**
	 * ȡ�����Ʊ�����
	 *
	 * @param dto IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO deleteCustomReport(IGRPT01DTO dto) throws BLException {

		String[] rfdids = dto.getIgRPT0102Form().getSelected();
		User user = dto.getUser();

		// ѭ��ɾ����������
		for (String rfdid : rfdids) {
			// ���Ҷ���ID
			CustomReportSearchCondImpl crsCond = new CustomReportSearchCondImpl();
			crsCond.setRfdid(Integer.valueOf(rfdid));
			crsCond.setUserid(user.getUserid());
			List<CustomReport> crListI = this.customReportBL.findByCond(
					crsCond, 0, 0);
			this.customReportBL.deleteProject(crListI.get(0).getCrid());
		}

		// ��ʣ�µļ�¼˳�������
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
	 * ���Ʊ���������
	 * 
	 * @param dto
	 *            IGRPT01DTO
	 * @return IGRPT01DTO
	 */
	public IGRPT01DTO orderCustomReport(IGRPT01DTO dto) throws BLException {

		User user = dto.getUser();
		Integer rfdidI = dto.getIgRPT0102Form().getRfdidI();
		Integer rfdidII = dto.getIgRPT0102Form().getRfdidII();

		// ��ѯ�������Ʊ���
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
		// ���������Ʊ���˳��Ž���
		Integer orderT = crTBI.getOrdernum();
		crTBI.setOrdernum(crTBII.getOrdernum());
		crTBII.setOrdernum(orderT);
		// �־û��������Ʊ���
		customReportBL.saveProject(crTBI);
		customReportBL.saveProject(crTBII);

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
	 * <p>
	 * ��ѯ����Ȩ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getImpowerChildTreeNodeMap(List<CodeDetail> code,TreeNode ptNode,int ptlen,String syscoding,IGRPT01DTO dto)
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
	
	public List<Integer> getRfdidByUser (IGRPT01DTO dto)throws BLException{
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
	    a.set(Calendar.DATE, 1);//����������Ϊ���µ�һ��   
	    a.roll(Calendar.DATE, -1);//���ڻع�һ�죬Ҳ�������һ��   
	    int maxDate = a.get(Calendar.DATE);   
	    return maxDate;   
	} 
	
	
}
