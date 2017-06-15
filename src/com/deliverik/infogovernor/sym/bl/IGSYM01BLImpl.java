/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM01BLImpl extends BaseBLImpl implements IGSYM01BL {

	static Log log = LogFactory.getLog(IGSYM01BLImpl.class);
	
	/**
	 * ע��OrganizationBL
	 */
	protected OrganizationBL organizationBL;

	/**
	 * ����OrganizationBL
	 * @param organizationBL OrganizationBL
	 */
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	/**
	 * ע��UserBL
	 */
	protected UserBL userBL;

	/**
	 * ����UserBL
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	
	
	
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
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
	 * ȡ�øý��Ļ���ȫ��
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
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý�ɫ��������¼�������
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
	 * ��ѯ���ڵ��ϼ�������һ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchOrgTreeAction(IGSYM01DTO dto,String type) throws BLException{
		log.debug("========һ��������ѯ����ʼ========");
		
		IGSYM0101Form form = new IGSYM0101Form();
		form.setIs_in_use("1");
		form.setOrgpar("0001");//��1������(4λ)
		form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��1������
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
			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM0101Form();
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý����¼�������
			//��Ӻ��ӽ��
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========һ��������ѯ�������========");
		return dto;
	}
	
	/**
	 * <p>
	 * ��ѯ���ڵ��ϼ�������һ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public IGSYM01DTO searchItemTreeAction(IGSYM01DTO dto,String type) throws BLException{
		log.debug("========һ��������ѯ����ʼ========");
		
		IGSYM0101Form form = new IGSYM0101Form();
		form.setIs_in_use("1");
		form.setOrgpar("0001");//��1������(4λ)
		form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��1������
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
			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM0101Form();
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý����¼�������
			//��Ӻ��ӽ��
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========һ��������ѯ�������========");
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
	private void getChildTreeNodeMap(List<Organization> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<Organization> nextret = getNextLevelNodes(ret,ptlen,syscoding);//ȡ�øü�����LIST

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
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
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
//	 * ȡ�øý��Ļ���ȫ��
//	 * </p>
//	 * @param ����syscoding
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
//		List<Organization> ret = organizationBL.getOrganizations(dto.getOrganizationSearchCond());//��ý�ɫ��������¼�������
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
	 * Description: ȡ�ð�������ȫ���Ļ������󼯺�
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
	 * �ж�ÿ�������Ƿ����ͣ��
	 * </p>
	 * @param ����syscoding
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
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��û����Ƿ����ʹ���е��¼�����
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'ͣ��'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getButtonNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String flag = "0";//0����ʾ 1��ʾ
			
			if(isCouldStop(ret.getOrgsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getOrgid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * �ж�ÿ�������Ƿ��������
	 * </p>
	 * @param  ����syscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {

		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		boolean flag = true;
		
		form.setOrgsyscoding(syscode);//�����syscodeΪ��ǰ���ĸ�����syscoding
		dto.setOrganizationSearchCond(form);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��û����Ƿ����ͣ�õ��ϼ�����
		if(ret.get(0).getOrgstatus().equals("0")){//�����ǰ�����ϼ���ͣ��״̬��ǰ��㲻������
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'����'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getStartButtonNameList(List<Organization> organizationList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Organization ret:organizationList){
			String flag = "0";//0����ʾ 1��ʾ
			String syscode = ret.getOrgsyscoding();

			if(syscode.length()==4){//����Ϊ1����������ֱ������flagΪ1
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
	 * Description: ������ѯ(IGASM1303Action����)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM1303Action(IGSYM01DTO dto)
			throws BLException {
		log.debug("========������ѯ����ʼ========");
		//����DAO�ӿڲ�ѯ
		List<Organization> organizationList = organizationBL.searchOrganization(dto.getOrganizationSearchCond(), 0, 0);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//���û���ȫ��
		//dto.setButtonMap(getButtonNameList(organizationList));
		//dto.setStartbuttonMap(getStartButtonNameList(organizationList));
		//dto.setOrganizationCondList(organizationList);
		if(organizationList!=null && organizationList.size()>0){
			dto.setOrganization(organizationList.get(0));
		}
		
		log.debug("========������ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ������ѯ(IGASM01BL����)
	 * </p>
	 */
	
	public IGSYM01DTO searchOrganizationForIGASM0101() throws BLException {
		log.debug("========������ѯ����ʼ========");
		IGSYM01DTO dto = new IGSYM01DTO();
		//����DAO�ӿڲ�ѯ
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgsuper(9);//ȥ������Ļ��������
		cond.setIs_in_use("1");//ֻ��ѯ���õĻ���
		List<Organization> organizationList = organizationBL.searchOrganization(cond, 0, 0);
		List<Organization> orglist = new ArrayList<Organization>();
		for(Organization ret:organizationList){
			OrganizationTB org = (OrganizationTB)SerializationUtils.clone(ret);
			org.setOrgname(getCompleteOrgName(ret.getOrgsyscoding()));
			orglist.add(org);
		}

		dto.setOrganizationCondList(orglist);
	
		log.debug("========������ѯ��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: ������ѯ
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
		log.debug("========������ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = organizationBL.getOrganizationSearchCount(dto
				.getOrganizationSearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//����DAO�ӿڲ�ѯ
		List<Organization> organizationList = organizationBL.searchOrganization(dto
				.getOrganizationSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(organizationList));//���û���ȫ��
		dto.setButtonMap(getButtonNameList(organizationList));
		dto.setStartbuttonMap(getStartButtonNameList(organizationList));
		dto.setOrganizationCondList(organizationList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========������ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ����״̬�仯
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public void changePTStatus(IGSYM01DTO dto) throws BLException {
		log.debug("========����״̬�仯����ʼ========");
		Organization organization = organizationBL.searchOrganizationByKey(dto.getChangeOrgid());
		OrganizationTB organizationTB = new OrganizationTB();
		organizationTB.clone(organization);
		if("0".equals(organization.getOrgstatus())){
			organizationTB.setOrgstatus("1");
		} else if ("1".equals(organization.getOrgstatus())){
			organizationTB.setOrgstatus("0");
		}
		
		organizationBL.updateOrganization(organizationTB);
		log.debug("========����״̬�仯�������========");
		
	}

	/**
	 * <p>
	 * Description: ����ɾ��
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO deleteOrganizationAction(IGSYM01DTO dto) throws BLException {
		log.debug("========����ɾ������ʼ========");
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteOrgid().length;i++ ){
			//����ɾ������
			String orgid = dto.getDeleteOrgid()[i];
			//����DAO��ѯ��������ʶ��ʵ�����
			Organization organization = organizationBL.searchOrganizationByKey(Integer.parseInt(orgid));
			//�������׳��쳣
			if (organization == null){
				throw new BLException("IGSYM0101.E002");
			}
			//����û������Ƿ�����û�
			UserSearchCondImpl cond = new UserSearchCondImpl();
			cond.setOrgid(orgid);
			int totalCount = userBL.getUserSearchCount(cond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0101.E001",organization.getOrgname());
			}
			//����û����Ƿ��Ǹ�������
			OrganizationSearchCondImpl orgCond = new OrganizationSearchCondImpl();
			//orgCond.setOrgpar(Integer.parseInt(orgid));
			totalCount = organizationBL.getOrganizationSearchCount(orgCond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0101.E003",organization.getOrgname());
			}
			organizationBL.deleteOrganization(organization);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "����������Ϣ"));
		log.debug("========����ɾ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��������
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO insertOrganizationAction(IGSYM01DTO dto) throws BLException {
		log.debug("========������������ʼ========");
		//ȡ�õ�ǰ��ѡ�ϼ��������¼�����������syscoding,�����1��Ϊ����������syscoding
		IGSYM0102Form form = dto.getIgsym0102Form();
		IGSYM0101Form form1 = new IGSYM0101Form();
		form1.setOrgpar(form.getOrgpar());//form.getOrgpar()Ϊ��ǰ����syscoding
		dto.setOrganizationSearchCond(form1);
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond(),form1.getOrgpar());
		String syscode = "";
		String orgnum = ResourceUtility.getString("ORG_NUM");//��������Ĳ����
		if(orgnum == null || "".equals(orgnum)){
			orgnum = "6";
		}
		int org_num = Integer.valueOf(orgnum);
		int org_sys_len = 19;//���������Ĭ�ϳ���
		if(org_num>1 && org_num<10){
			org_sys_len = 4+3*(org_num-1);
		}
		
		if(ret.size()>0){//�����¼�����
			Organization org = ret.get(0);
			syscode = org.getOrgsyscoding();
			
			String temp = syscode.substring(syscode.length()-3);
			
			if(temp.substring(temp.length()-3).equals("999")){
				throw new BLException("IGSYM0101.E004","����������Ϣ");
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
			
			//�ж��Ƿ��Ѿ��ﵽ�涨�Ĳ����
			if(syscode!=null && syscode.length()>=org_sys_len){
				throw new BLException("IGSYM0101.E005","����������Ϣ");
			}

			form.setOrgsyscoding(syscode+"001");
		}
		
		dto.setOrganization(form);
		Organization organization = registOrganization(dto.getOrganization());
		dto.setOrganization(organization);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "����������Ϣ") );
		log.debug("========����������������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ���������ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM01DTO
	 * @return IGSYM01DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM01DTO initIGSYM0102Action(IGSYM01DTO dto) throws BLException {
		log.debug("========������ʲ�������Ϣ��ѯ����ʼ========");
		IGSYM0102Form form = dto.getIgsym0102Form();
		String orgidstr = form.getOrgidstr();
		Integer orgid = Integer.parseInt(orgidstr);
		Organization organization = organizationBL.searchOrganizationByKey(orgid);
		if ( organization == null ){
			throw new BLException("IGCO10000.E004","��������");
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
		//�����ʼ��ģʽ
		form.setMode("1");
		searchOrganizationAll(dto);
		dto.addMessage(new ActionMessage("IGCO10000.I001","����������Ϣ"));
		log.debug("========����û���������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �������
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
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "����������Ϣ") );
		return dto;
	}
	
	
	/**
	 * ����DAO��ѯ��������ʶ��ʵ�����
	 * @param orgid Integer
	 * @return Organization
	 */
	
	public Organization registOrganization(Organization organization) throws BLException{
		//checkNotExistOrganization(organization.getOrgname());
		Organization ret = organizationBL.registOrganization(organization);
		return ret;
	}
	
	/**
	 * ��ѯ�������Ƿ����
	 * @param orgname
	 * @throws BLException
	 */
	
	protected void checkNotExistOrganization(String orgname) throws BLException{
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		cond.setOrgname(orgname);
		List<Organization> infoList = organizationBL.searchOrganization(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","����","��������");
		}
	}
	
	/**
	 * ���ݴ���Ļ���ID����ѯ��
	 * @param ����ID
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
			//���õ�ǰ����������(�Ӹü��������)
			form.setRoledomain_q(syscoding);
			
			form.setIs_in_use("1");
			
			igsym01dto.setOrganizationSearchCond(form);
			List<Organization> ret = organizationBL.searchOrganization(igsym01dto.getOrganizationSearchCond());//��ý����¼�������
			if(ret!=null && ret.size()>0){
				TreeNode ptNode = new TreeNode();
				ptNode.setId(ret.get(0).getOrgsyscoding());
				ptNode.setName(ret.get(0).getOrgname());
				//��Ӻ��ӽ��
				int nowlen = ret.get(0).getOrgsyscoding().length();
				getChildTreeNodeMap(ret,ptNode,nowlen,syscoding);
				treeNodeMap.put(ptNode.getId(),ptNode);
			}
			
		}

		dto.setTreeNodeMap(treeNodeMap);

		return dto.getTreeNodeMap();
	}
	/**
	 * ��ѯ���л���
	 * @return List<Organization>
	 */
	
	public IGSYM01DTO searchOrganizationAll(IGSYM01DTO dto) throws BLException{
		List<Organization> organizationList = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
		dto.setOrganizationList(organizationList);
		return dto;
	}
    public IGSYM01DTO searchITEMS0174Tree(IGSYM01DTO dto)throws BLException{
    	IGSYM0101Form form = new IGSYM0101Form();
    	//����DAO�ӿڲ�ѯ
    	
    	List<Organization> ret=new ArrayList<Organization>();
    	if(organizationBL.searchOrganization(dto.getOrganizationSearchCond())!=null){
    		//����ֻҪ�����ڵ�֧��
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
			
			//���õ�ǰ����������(�Ӹü��������)
			form = new IGSYM0101Form();
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			form.setIs_in_use("1");
			form.setRoledomain_q(org.getOrgsyscoding());
			dto.setOrganizationSearchCond(form);
			List<Organization> orglist = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý����¼�������
			//��Ӻ��ӽ��
			int nowlen = orglist.get(0).getOrgsyscoding().length();
			getChildTreeNodeMap(orglist,ptNode,nowlen,org.getOrgsyscoding());
			treeNodeMap.put(ptNode.getId(),ptNode);
			
		}
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("========һ��������ѯ�������========");
		return dto;
    }
	
}
