/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.RoleApi;
import org.hyperic.hq.hqapi1.types.ResponseStatus;
import org.hyperic.hq.hqapi1.types.RoleResponse;
import org.hyperic.hq.hqapi1.types.StatusResponse;

import com.deliverik.framework.asset.bl.task.IG117BL;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.form.IGSYM0302Form;
import com.deliverik.infogovernor.sym.form.IGSYM1202Form;
import com.deliverik.infogovernor.util.StringEncrypt;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM03BLImpl extends BaseBLImpl implements IGSYM03BL {

	static Log log = LogFactory.getLog(IGSYM03BLImpl.class);
	
	/**�����ɫ�������ʶ���ڷ�������ķ��������״̬�б���ָ����Ա*/
	public final static String GROUP_ROLE_MARK = "#";
	public final static String GROUP_ROLE_NAME = "�û��������";
	
	/**
	 * ע��RoleBL
	 */
	
	protected RoleBL roleBL;
	
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * ����RoleBL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ע��UserRoleBL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * ����UserRoleBL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 * ע��RoleActionBL
	 */
	protected RoleActionBL roleActionBL;

	/**
	 * ����UserRoleBL
	 * @param roleActionBL RoleActionBL
	 */
	
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}
	
	
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
	
	protected IG117BL ig117BL;
	protected SOC0117BL soc0117BL;
	
	public void setSoc0117BL(SOC0117BL soc0117BL) {
		this.soc0117BL = soc0117BL;
	}

	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}

	/**
	 * ���ݴ���ĸ��û��Ľ�ɫ���Ϻͽ�ɫ����ȡ�����и����͵Ľ�ɫ���ʲ������������Ĳ���
	 * @param ��ɫ����(ҳ�洫��)
	 * @param ���û��Ľ�ɫ����(session��ȡ��)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getAssetDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException{
		//���ս�ɫ���ͺ��û�IDȡ�ø������µĽ�ɫ����
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(user.getUserid());
		cond.setRoletype(roletype);
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		sym03dto.setRoletype(roletype);
		
		sym03dto = getAssetTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	/**
	 * ȡ�ø����������н�ɫ���ʲ���������(role.assetdomain)
	 * @param ָ�������µĽ�ɫLIST
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private IGSYM03DTO getAssetTreeByRoleType(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		List<UserRoleInfo> tree = new ArrayList<UserRoleInfo>();//��ſ�����Ϊ�ʲ�������������ÿ��1����㣨Ŀǰ֧�ֵ�9����
		
		List<UserRoleInfo> newtree = new ArrayList<UserRoleInfo>();
		boolean flag = true;
		
		for(int x=0,y=rolelist.size();x<y;x++){
			flag = true;
			String rd = rolelist.get(x).getAssetdomain();
			if(rd!=null){
				for(UserRoleInfo ro:rolelist){
					if(ro!=null){
						String temp = ro.getAssetdomain();
						//�жϸý���Ƿ�����ϼ���㣬�������flag��Ϊfalse
						if(StringUtils.isNotEmpty(temp)){
							if(rd.contains(temp) && !rd.equals(temp)){
								if(rd.length()>temp.length()){
									if(rd.substring(0, temp.length()).equals(temp)){
										flag = false;
										break;
									}
								}else{
									if(temp.substring(0, rd.length()).equals(rd)){
										flag = false;
										break;
									}
								}
								
							}
						}
						
					}
				}
			}else{
				flag = false;
			}
			
			if(flag){
				tree.add(rolelist.get(x));
			}
		}
		
		
		//������assetdomain�Ľ�ɫ������ ���豸�ʲ�������� ��˳�����У�999001---999012��
		if(tree!=null){
			UserRoleInfo[] obj = new UserRoleInfo[tree.size()];
			for(int i=0,j=tree.size();i<j;i++){
				obj[i]=tree.get(i);
			}
			UserRoleInfo urtemp = null;
			for(int i=0;i<obj.length;i++){

				for(int j=0;j<obj.length-i-1;j++){
//					if(j==(obj.length-i-1)){
//						break;
//					}
					UserRoleInfo oneur = obj[j];
					UserRoleInfo twour = obj[j+1];
					String oneasset = null;
					String twoasset = null;
					if(oneur!=null){
						oneasset = oneur.getAssetdomain();
					}
					if(twour!=null){
						twoasset = twour.getAssetdomain();
					}
					
					if(oneasset.compareTo(twoasset)>0){
						urtemp = obj[j];
						obj[j] = obj[j+1];
						obj[j+1] = urtemp;
					}
					
				}
						
			}
			for(int i=0,j=obj.length;i<j;i++){
				newtree.add(obj[i]);
			}

		}
		
		
		sym03dto = searchAssetTreeAction(sym03dto,newtree);
		return sym03dto;
		
	}
	/**
	 * <p>
	 * �ж��Ƿ����ָ�����ʲ�ģ��1���
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isBeSelectedEntity(String type,String esyscoding) throws BLException{
		boolean flag = false;
		if(esyscoding!=null && type!=null){
			if(esyscoding.length()>=6){
				if(esyscoding.substring(0,6).equals(type)){
					flag = true;
				}
			}
			
		}
		return flag;
	}

	/**
	 * <p>
	 * ��ѯ��ɫ�ʲ�����������
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private IGSYM03DTO searchAssetTreeAction(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		log.debug("========��ѯ��ɫ�ʲ�������������ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		//IGSYM0301Form form = new IGSYM0301Form();
		//IGSYM03DTO dto = new IGSYM03DTO();
		IGSYM12DTO dto1 = new IGSYM12DTO();
		//String roletype = sym03dto.getRoletype();//ǰ̨����Ľ�ɫ����
		//form.setIs_in_use("1");
		if(rolelist!=null){
			for(UserRoleInfo ro:rolelist){
				if(ro!=null){
					String esyscoding = ro.getAssetdomain();
//					if("t".equals(sym03dto.getIsItDrivers())){
//						if(esyscoding.equals("999001")){
//							esyscoding = "999001001";
//						}
//					}
					if(esyscoding!=null && !"".equals(esyscoding)){
						boolean flag = false;
						if("1".equals(sym03dto.getIsRoot())){
							flag = true;
							esyscoding = sym03dto.getSubtype();
						}else{
							flag = isBeSelectedEntity(sym03dto.getSubtype(),esyscoding);
						}
						if(flag){
							//ȡ�õ�ǰ������������
							String completename = "";
//							if(esyscoding.length()>6){//1���ʲ�ģ�ͽ���esyscoding����Ϊ6����999001
//								completename = getAssetCompleteName(esyscoding);
//							}

							IGSYM1202Form form1 = new IGSYM1202Form();
							//���õ�ǰ����������(�Ӹü��������)			
							form1.setSyscoding_q(esyscoding);
							form1.setEstatus("1");
							dto1.setEntitySearchCond(form1);
							
							
							SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
							soc0117cond.setSyscoding_q(esyscoding);
							soc0117cond.setEstatus("1");
							
							if(StringUtils.isNotEmpty(sym03dto.getRoletype())&&("IGBU01".equalsIgnoreCase(sym03dto.getRoletype())||"IGCI01".equalsIgnoreCase(sym03dto.getRoletype()))){
								List<SOC0117Info> retInfo=this.soc0117BL.searchEntity(soc0117cond,0,0);
								TreeNode ptNode = new TreeNode();
								ptNode.setId(retInfo.get(0).getEid()+"_"+retInfo.get(0).getEsyscoding()+"_"+retInfo.get(0).getEcategory());
								if("".equals(completename)){
									ptNode.setName(retInfo.get(0).getEname());
								}else{
									ptNode.setName(completename);
								}

								//��Ӻ��ӽ��
								int nowlen = retInfo.get(0).getEsyscoding().length();
								getAssetChildTreeNodeMapOne(retInfo,ptNode,nowlen,esyscoding);
								treeNodeMap.put(ptNode.getId(),ptNode);
							}else{
//								List<IG117Info> ret = soc0117BL.searchIG117Info(dto1.getEntitySearchCond(), 0, 0);//��ý����¼��ʲ�������������1�����
								List<SOC0117Info> ret=this.soc0117BL.searchEntity(soc0117cond,0,0);
								TreeNode ptNode = new TreeNode();
								ptNode.setId(ret.get(0).getEid()+"_"+ret.get(0).getEsyscoding()+"_"+ret.get(0).getEcategory());
								if("".equals(completename)){
									ptNode.setName(ret.get(0).getEname());
								}else{
									ptNode.setName(completename);
								}

								//��Ӻ��ӽ��
								int nowlen = ret.get(0).getEsyscoding().length();
//								getAssetChildTreeNodeMap(ret,ptNode,nowlen,esyscoding);
								getAssetChildTreeNodeMapOne(ret,ptNode,nowlen,esyscoding);
								treeNodeMap.put(ptNode.getId(),ptNode);
							}
							
							
							
						}

					}

				}	
			}
		}
		

		sym03dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯ��ɫ�ʲ���������������========");
		return sym03dto;
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
	private void getAssetChildTreeNodeMap(List<IG117Info> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<IG117Info> nextret = getAssetNextLevelNodes(ret,ptlen,syscoding);//ȡ�øü�����LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
				
			getAssetChildTreeNodeMap(ret,pdNode,syscode.length(),syscode);
			
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
	 * @author duchong@deliverik.com
	 */
	private void getAssetChildTreeNodeMapOne(List<SOC0117Info> ret,TreeNode ptNode,int ptlen,String syscoding){

		List<SOC0117Info> nextret = getAssetNextLevelNodesOne(ret,ptlen,syscoding);//ȡ�øü�����LIST

		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
				
			getAssetChildTreeNodeMapOne(ret,pdNode,syscode.length(),syscode);
			
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
	
	private List<IG117Info> getAssetNextLevelNodes(List<IG117Info> ret,int levellen,String syscode) {
		
		List<IG117Info> entitylist = new ArrayList<IG117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+CommonDefineUtils.ESYSCODING_NODE_LENGTH) && (syscoding.substring(0,syscoding.length()-CommonDefineUtils.ESYSCODING_NODE_LENGTH)).equals(syscode)){				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
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
	
	private List<SOC0117Info> getAssetNextLevelNodesOne(List<SOC0117Info> ret,int levellen,String syscode) {
		
		List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
	}
	
	/**
	 * <p>
	 * ȡ�øý����ʲ���������(���ʲ�ģ��)��ȫ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private String getAssetCompleteName(String syscoding) {
		StringBuffer entityname = new StringBuffer();
		
		ArrayList<String> codelist = new ArrayList<String>();
		if(syscoding.length()==6){//1���ʲ�ģ�ͽ���esyscoding����Ϊ6
			codelist.add(syscoding);
		}else{
			String pcode = syscoding.substring(0, CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			codelist.add(pcode);
			String childs = syscoding.substring(CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			int j = childs.length()/CommonDefineUtils.ESYSCODING_NODE_LENGTH;
			for(int i=1;i<=j;i++){
				codelist.add(pcode+childs.substring(0, CommonDefineUtils.ESYSCODING_NODE_LENGTH*i));
			}
			
		}

		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(codelist);
		List<IG117Info> ret = ig117BL.searchIG117Info(cond, "assetdomain");//��ý�ɫ��������¼�������
		for(int i=0,j=ret.size();i<j;i++){
			String syscode = ret.get(i).getEsyscoding();
			if(syscoding.contains(syscode)){
				if(i>0){
					entityname.append("_");
				}
				entityname.append(ret.get(i).getEname());
			}
			
		}
		return entityname.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * ���ݴ���ĸ��û��Ľ�ɫ���Ϻͽ�ɫ����ȡ�����и����͵Ľ�ɫ�Ĺ��������Ĳ���
	 * @param ��ɫ����(ҳ�洫��)
	 * @param ���û��Ľ�ɫ����(session��ȡ��)
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto,String roletype,User user) throws BLException{
		//���ս�ɫ���ͺ��û�IDȡ�ø������µĽ�ɫ����
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setUserid(user.getUserid());
		cond.setRoletype(roletype);
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		
		
		sym03dto = getTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	public IGSYM03DTO getRoleDomainTree(IGSYM03DTO sym03dto) throws BLException{
		//���ս�ɫ���ͺ��û�IDȡ�ø������µĽ�ɫ����
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		
		List<UserRoleInfo> rolelist = userRoleBL.searchUserRoleVW(cond, 0, 0);
		
		
		sym03dto = getTreeByRoleType(sym03dto,rolelist);
		return sym03dto;
		
	}
	
	/**
	 * ȡ�ø����������н�ɫ�Ĺ�����
	 * @param ָ�������µĽ�ɫLIST
	 * @return 
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private IGSYM03DTO getTreeByRoleType(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		//Map<String,String> nameURLMap = new HashMap<String,String>();
		List<UserRoleInfo> tree = new ArrayList<UserRoleInfo>();//��ſ�����Ϊ����������ÿ��1����㣨Ŀǰ֧�ֵ�9����
		
		boolean flag = true;
		
		for(int x=0,y=rolelist.size();x<y;x++){
			flag = true;
			String rd = rolelist.get(x).getRoledomain();
			if(rd!=null){
				for(UserRoleInfo ro:rolelist){
					if(ro!=null){
						String temp = ro.getRoledomain();
						if(temp!=null){
							//�жϸý���Ƿ�����ϼ���㣬�������flag��Ϊfalse
							if(rd.contains(temp) && !rd.equals(temp)){
								if(rd.length()>temp.length()){
									if(rd.substring(0, temp.length()).equals(temp)){
										flag = false;
										break;
									}
								}else{
									if(temp.substring(0, rd.length()).equals(rd)){
										flag = false;
										break;
									}
								}
								
							}
						}
						
					}
					
				}
			}
			
			if(flag){
				tree.add(rolelist.get(x));
			}
		}
		
		sym03dto = searchOrgTreeAction(sym03dto,tree);
		return sym03dto;
		
	}
	
	/**
	 * <p>
	 * ȡ�øý��Ļ���ȫ��
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private String getCompleteOrgName(String syscoding) {
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
					orgname.append("_");
				}
				orgname.append(ret.get(i).getOrgname());
			}
			
		}
		return orgname.toString();
	}
	
	/**
	 * <p>
	 * ��ѯ��ɫ��������
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private IGSYM03DTO searchOrgTreeAction(IGSYM03DTO sym03dto,List<UserRoleInfo> rolelist) throws BLException{
		log.debug("========��ѯ��ɫ����������ʼ========");
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO dto = new IGSYM01DTO();
		//form.setIs_in_use("1");
		if(rolelist!=null){
			for(UserRoleInfo ro:rolelist){
				if(ro!=null){
					String syscoding = ro.getRoledomain();
					if(syscoding!=null && !"".equals(syscoding)){
						//ȡ�õ�ǰ������������
						String completename = "";
						if(syscoding.length()>4){
							completename = getCompleteOrgName(syscoding);
						}
						
						//���õ�ǰ����������(�Ӹü��������)
						form.setRoledomain_q(syscoding);
						/////////wuzq
						form.setIs_in_use("1");
						/////////
						dto.setOrganizationSearchCond(form);
						List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());//��ý����¼�������
						TreeNode ptNode = new TreeNode();
						ptNode.setId(ret.get(0).getOrgsyscoding());
						if("".equals(completename)){
							ptNode.setName(ret.get(0).getOrgname());
						}else{
							ptNode.setName(completename);
						}

						//��Ӻ��ӽ��
						int nowlen = ret.get(0).getOrgsyscoding().length();
						getChildTreeNodeMap(ret,ptNode,nowlen,syscoding);
						treeNodeMap.put(ptNode.getId(),ptNode);
					}
				}		

			}
		}
		

		sym03dto.setTreeNodeMap(treeNodeMap);
		log.debug("========��ѯ��ɫ������������========");
		return sym03dto;
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

	/**
	 * <p>
	 * Description: ȡ�ð�������ȫ���Ļ������󼯺�
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteOrgNameList(List<Role> roleList) throws BLException {
		Map<Integer,String> org = new HashMap<Integer,String>();
		for(Role role:roleList){
			String name = "";
			if(role.getRoledomain()!=null && !"".equals(role.getRoledomain())){
				if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(role.getRoledomain())) {
					name = IGSYM03BLImpl.GROUP_ROLE_NAME;
				} else {
					name = getCompleteOrgName(role.getRoledomain());
				}
			}
			
			org.put(role.getRoleid(), name);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: ȡ�ð����ʲ�ģ��ȫ�����ʲ����󼯺�
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<Integer,String> getCompleteAssetNameList(List<Role> roleList) throws BLException {
		Map<Integer,String> asset = new HashMap<Integer,String>();
		for(Role role:roleList){
			String name = "";
			if(role.getAssetdomain()!=null && !"".equals(role.getAssetdomain())){
				name = getAssetCompleteName(role.getAssetdomain());
			}
			
			asset.put(role.getRoleid(), name);
		}
		
		return asset;
	}
	
	
	/**
	 * <p>
	 * ȡ��ָ��syscoding�Ļ�����
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
//	private String getNameBySyscoding(String syscoding) {
//		IGSYM0101Form form = new IGSYM0101Form();
//		IGSYM01DTO dto = new IGSYM01DTO();
//		StringBuffer orgname = new StringBuffer();
//		
//		form.setOrgsyscoding(syscoding);
//		form.setIs_in_use("1");
//		dto.setOrganizationSearchCond(form);
//		List<Organization> ret = organizationBL.getOrganizations(dto.getOrganizationSearchCond());//���syscoding��Ӧ�Ļ�������
//		orgname.append(ret.get(0).getOrgname());
//		return orgname.toString();
//	}
	
	/**
	 * <p>
	 * Description: ��ɫ��ѯ��IGSYM0306��������ʹ�ã�
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 */
	
	public IGSYM03DTO searchRoleActionFor0306(IGSYM03DTO dto) throws BLException {
		log.debug("========��ɫ��ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = roleBL.searchRoleCountForSelfDef(dto
				.getRoleSearchCond());
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
		List<Role> roleList = roleBL.searchRoleForSelfDef(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
//		dto.setCompleteassetnameMap(getCompleteAssetNameList(roleList));
		dto.setCompletenameMap(getCompleteOrgNameList(roleList));
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ɫ��ѯ��������========");
		return dto;
	}
	/**
	 * <p>
	 * Description: ��ɫ��ѯ
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO searchRoleAction(IGSYM03DTO dto)
			throws BLException {
		log.debug("========��ɫ��ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = roleBL.getRoleSearchCount(dto
				.getRoleSearchCond());
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
		List<Role> roleList = roleBL.searchRole(dto
				.getRoleSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		
		dto.setCompletenameMap(getCompleteOrgNameList(roleList));
		dto.setCompleteassetnameMap(getCompleteAssetNameList(roleList));
		dto.setRoleList(roleList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========��ɫ��ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: ��ɫɾ��
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO deleteRoleAction(IGSYM03DTO dto) throws BLException {
		log.debug("========��ɫɾ������ʼ========");
		List<Role> roleList = new ArrayList<Role>();
		//ѭ��ɾ��
		for( int i=0;i<dto.getDeleteRoleid().length;i++ ){
			//��ɫɾ������
			String roleid = dto.getDeleteRoleid()[i];
			//����DAO��ѯ��������ʶ��ʵ�����
			Role role = roleBL.searchRoleByKey(Integer.parseInt(roleid));
			//�������׳��쳣
			if (role == null){
				throw new BLException("IGCO10000.E004","ɾ����ɫ����");
			}
			
			//����ý�ɫ���Ƿ�����û�
			UserRoleSearchCondImpl cond = new UserRoleSearchCondImpl();
			cond.setRoleid(role.getRoleid());
			int totalCount = this.userRoleBL.getUserRoleSearchCount(cond);
			if ( totalCount>0 ) {
				throw new BLException("IGSYM0301.E001",role.getRolename());
			}
			List<IG500Info> processRecordList = workFlowOperationBL.
			queryActiveProcessByRoleid(Integer.parseInt(roleid));
			if(processRecordList.size() > 0){
				String prserialnum = "";
				for (int j = 0; j < processRecordList.size(); j++) {
					prserialnum += processRecordList.get(j).getPrserialnum();
					if(j < processRecordList.size() - 1){
						prserialnum += ",";
					}
				}
				throw new BLException("IGSYM0301.E002",role.getRolename(),prserialnum);
			}
			roleList.add(role);//��û�г����쳣�Ľ�ɫ��ӵ�List�н���ɾ��
		}
		if(roleList.size() > 0){
			for(Role roleParam : roleList){
				//ͬ��ɾ��ҵ����Դ�Ľ�ɫ
				if(roleParam.getRoletype().equals("IGSY01") && StringUtils.isNotEmpty(roleParam.getFingerPrint())){
					//��ҵ����Դ��ɫ������ͬ����ʱ��Ž��д���
					String res = synRoleDelete(roleParam.getFingerPrint());
					if("-1".equals(res)){
						throw new BLException("IGCO10000.E028",roleParam.getRolename());
					}else if("-2".equals(res)){
						throw new BLException("IGCO10000.E136",roleParam.getRolename());
					}else if("0".equals(res)){
						throw new BLException("IGCO10000.E029","��ɫ");
					}else if(res.indexOf("SUCCESSROLE")!=-1){
						log.info("========ͬ����ɫ��Ϣ�ɹ�========");
					}else{
						throw new BLException("IGCO10000.E135",res);
					}
				}
			}
			for(Role roleParam : roleList){
				RoleActionSearchCondImpl roleActionCond = new RoleActionSearchCondImpl();
				roleActionCond.setRoleid(roleParam.getRoleid());
				//ɾ����ɫ�˵�
				List<RoleAction> roleActionList = roleActionBL.searchRoleAction(roleActionCond,0,0);
				
				for(RoleAction ra : roleActionList) {
					roleActionBL.deleteRoleAction(ra);
				}
				
				roleBL.deleteRole(roleParam);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "��ɫ������Ϣ"));
		log.debug("========��ɫɾ����������========");
		return dto;
	}
	
	/***
	 * ͬ����HQ��ɾ��Role��Ϣ
	 * @param role
	 * @return
	 */
	private String synRoleDelete(String role_id){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id)).getRole();
			if(roleTemp==null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		StatusResponse rRes = null;
		try {
			rRes = roleApi.deleteRole(Integer.parseInt(role_id));
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return "SUCCESSROLE";//ͬ�����³ɹ�
		}else{
			return rRes.getError().getReasonText();
		}
	}
	
	/**
	 * <p>
	 * Description: ��ɫ����
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO insertRoleAction(IGSYM03DTO dto) throws BLException {
		IGSYM0302Form form = dto.getIgsym0302Form();
		//Ԥ���жϽ�ɫ�����Ƿ񳬹����ݿ��еĳ�������Ŀǰ32λ
		checkRoleNameLength(form.getRolename());
		
		log.debug("========��ɫ��������ʼ========");		
		//���ж�IG���Ƿ������ͬ���Ƶ���Ϣ
		checkNotExistRole(form.getRolename());
		if(form.getRoletype().equals("IGSY01")){
			String res = synRoleDate(dto.getRole());
			if("-1".equals(res)){
				throw new BLException("IGCO10000.E139",form.getRolename());
			}else if("-2".equals(res)){
				throw new BLException("IGCO10000.E131",form.getRolename());
			}else if("0".equals(res)){//����ʱ����ʹ��ͬ����
				//throw new BLException("IGCO10000.E029","��ɫ");
				log.info("========��ʼδ����ͬ������========");
			}else if(res.indexOf("SUCCESSROLE")!=-1){
				form.setFingerPrint(res.replaceAll("SUCCESSROLE", ""));
				log.info("========ͬ����ɫ��Ϣ�ɹ�========");
			}else{
				throw new BLException("IGCO10000.E130",res);
			}
		}
		Role role = registRole(form);
		dto.setRole(role);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "��ɫ������Ϣ") );
		log.debug("========��ɫ������������========");
		return dto;
	}
	/**
	 * �жϽ�ɫ���Ƴ���
	 * @param roleName
	 * @throws BLException 
	 */
	private void checkRoleNameLength(String roleName) throws BLException {
		if(roleName.length()>32) {
			throw new BLException("IGSYM0000.E002","��ɫ");
		}
	}
	
	/***
	 * ͬ����HQ������Role��Ϣ
	 * @param role
	 * @return
	 */
	private String synRoleDate(Role role){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		org.hyperic.hq.hqapi1.types.Role hqRole = new org.hyperic.hq.hqapi1.types.Role();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(role.getRolename()).getRole();
			if(roleTemp!=null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		hqRole.setName(role.getRolename());
		RoleResponse rRes = null;
		try {
			rRes = roleApi.createRole(hqRole);
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return rRes.getRole().getId()+"SUCCESSROLE";//ͬ�����³ɹ�
		}else{
			return rRes.getError().getReasonText();
		}
	}
	
	/**
	 * <p>
	 * Description: ����syscoding��ѯ�û���������
	 * </p>
	 */
	
	public String searchOrgname(String syscoding) throws BLException {
		IGSYM01DTO dto = new IGSYM01DTO();
		IGSYM0101Form form = new IGSYM0101Form();
		form.setOrgsyscoding(syscoding);
		dto.setOrganizationSearchCond(form);
		
		List<Organization> ret = organizationBL.searchOrganization(dto.getOrganizationSearchCond());
		
		return ret.get(0).getOrgname().toString();
	}
	
	/**
	 * <p>
	 * Description: ����assetdomain��ѯ��ģ�͵�����
	 * </p>
	 */
	
	public String searchAssetname(String syscoding) throws BLException {
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(syscoding);
		List<SOC0117Info> ret = soc0117BL.searchEntity(cond, "assetdomain");

		
		return ret.get(0).getEname().toString();
	}
	
	
	/**
	 * <p>
	 * Description: ��ɫ�����ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM03DTO initIGSYM0302Action(IGSYM03DTO dto) throws BLException {
		log.debug("========������ʲ�������Ϣ��ѯ����ʼ========");
		IGSYM0302Form form = dto.getIgsym0302Form();
		String roleidStr = form.getRoleidstr();
		Integer roleid = Integer.parseInt(roleidStr);
		Role role = roleBL.searchRoleByKey(roleid);
		if ( role == null ){
			throw new BLException("IGCO10000.E004","��ɫ����");
		}
		form.setRoledomain(role.getRoledomain());
		
		if(IGSYM03BLImpl.GROUP_ROLE_MARK.equals(role.getRoledomain())) {
			form.setRoledomainname(IGSYM03BLImpl.GROUP_ROLE_NAME);
		} else {
			form.setRoledomainname(searchOrgname(role.getRoledomain()));
		}
		
		if(role.getRoletype()!=null && role.getRoletype().indexOf("IGAC")>=0 || "IGBP50".equals(role.getRoletype())){
			form.setAssetdomain(role.getAssetdomain());
			form.setAssetdomainname(searchAssetname(role.getAssetdomain()));
		}
		form.setRolename(role.getRolename());
		form.setRolenamebak(role.getRolename());
		form.setRoledesc(role.getRoledesc());
		form.setRoleinfo(role.getRoleinfo());
		form.setRoletype(role.getRoletype());
		//�����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","��ɫ������Ϣ"));
		log.debug("========����ý�ɫ������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: ��ɫ���
	 * </p>
	 * 
	 * @param dto IGSYM03DTO
	 * @return IGSYM03DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM03DTO updateRoleAction(IGSYM03DTO dto) throws BLException{
		checkExistRole(dto.getRole().getRoleid());
		IGSYM0302Form form = (IGSYM0302Form)dto.getRole();
		if(!form.getRolename().equals(form.getRolenamebak())){
			checkNotExistRole(form.getRolename());
		}
		Role role = roleBL.searchRoleByKey(dto.getRole().getRoleid());
		form.setFingerPrint(role.getFingerPrint());
		//����ͬ��
		if(form.getRoletype().equals("IGSY01")){
			String res = synRoleUpdate(form);
			if("-1".equals(res)){
				throw new BLException("IGCO10000.E030",form.getRolename());
			}else if("-2".equals(res)){
				throw new BLException("IGCO10000.E138",form.getRolename(),"����");
			}else if("0".equals(res)){
				throw new BLException("IGCO10000.E029","��ɫ");
			}else if(res.indexOf("SUCCESSUPD")!=-1){
				form.setFingerPrint(res.replaceAll("SUCCESSUPD", ""));
				log.info("========ͬ����ɫ��Ϣ�ɹ�========");
			}else{
				throw new BLException("IGCO10000.E137",res);
			}
		}else {
			//��ͬ�����ͱ����һ��ͬ������ʱ�������κδ���
			if(StringUtils.isNotEmpty(role.getFingerPrint())){
				//��ͬ�����ͱ�ɷ�ͬ������ʱ
				String res = synRoleUpdateDel(role.getFingerPrint());
				if("-1".equals(res)){
					throw new BLException("IGCO10000.E030",form.getRolename());
				}else if("-2".equals(res)){
					throw new BLException("IGCO10000.E138",form.getRolename(),"û��");
				}/*else if("0".equals(res)){
					throw new BLException("IGCO10000.E029","��ɫ");
				}*/else if(res.indexOf("SUCCESSUPD")!=-1){
					form.setFingerPrint(null);//����ͬ�����ֶ���null
					log.info("========ͬ����ɫ��Ϣ�ɹ�========");
				}else{
					throw new BLException("IGCO10000.E137",res);
				}
			}
		}
		
		roleBL.updateRole(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "��ɫ������Ϣ") );
		return dto;
	}
	
	/***
	 * ͬ����HQ�����Role��Ϣ
	 * @param role
	 * @return
	 */
	private String synRoleUpdate(Role role) {
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
			return "0";
		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		if(role.getFingerPrint() == null){
			org.hyperic.hq.hqapi1.types.Role hqRole = new org.hyperic.hq.hqapi1.types.Role();
			//����������ת����ͬ������ʱcreate
			
			try {
				org.hyperic.hq.hqapi1.types.Role roleOne = roleApi.getRole(role.getRolename()).getRole();
				if(roleOne!=null){
					return "-2";
				}
			} catch (IOException e) {
				return "-1";
			}
			
			hqRole.setName(role.getRolename());
			RoleResponse rRes = null;
			try {
				rRes = roleApi.createRole(hqRole);
			} catch (IOException e) {
				return "-1";
			}
			if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
				return rRes.getRole().getId()+"SUCCESSUPD";//ͬ�����³ɹ�
			}else{
				return rRes.getError().getReasonText();
			}
		}else {
			//������ͬ������ʱ
			try {
				org.hyperic.hq.hqapi1.types.Role roleTwo = roleApi.getRole(Integer.parseInt(role.getFingerPrint())).getRole();
				System.out.println(roleTwo.getId());
				roleTwo.setName(role.getRolename());
				StatusResponse rRes = null;
				rRes = roleApi.updateRole(roleTwo);
				if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
					return roleTwo.getId()+"SUCCESSUPD";//ͬ�����³ɹ�
				}else{
					return rRes.getError().getReasonText();
				}
			} catch (IOException e) {
				return "-1";
			}
		}
	}
	
	/***
	 * ͬ����HQ�����Role��Ϣ
	 * ��ͬ������ת��Ϊ��ͬ��������ɾ��ͬ�����ݲ���ͬ�������ǲ��ǿ���״̬
	 * @param role
	 * @return
	 */
	private String synRoleUpdateDel(String role_id){
		CodeListUtils codeListUtils=(CodeListUtils) WebApplicationSupport.getBean("codeListUtils");
		//��ȡ��Ӧ��������Ϣ
		String HQServerIP = codeListUtils.getCodeValue("160", null, null, "1");
		Integer HQServerPort = new Integer(codeListUtils.getCodeValue("160", null, null, "2"));
		String HQServerUsername = codeListUtils.getCodeValue("160", null, null, "3");
		String HQServerPassword = StringEncrypt.asciiToChar(codeListUtils.getCodeValue("160", null, null, "4"));
//		String useFlg = codeListUtils.getCodeValue("160", null, null, "5");
//		if("0".equals(useFlg)||StringUtils.isEmpty(useFlg)){
//			return "0";
//		}
		HQApi api = new HQApi(HQServerIP, HQServerPort, false, HQServerUsername, HQServerPassword);
		RoleApi roleApi = api.getRoleApi();
		
		try {
			org.hyperic.hq.hqapi1.types.Role roleTemp = roleApi.getRole(Integer.parseInt(role_id)).getRole();
			if(roleTemp==null){
				return "-2";
			}
		} catch (IOException e) {
			return "-1";
		}
		
		StatusResponse rRes = null;
		try {
			rRes = roleApi.deleteRole(Integer.parseInt(role_id));
		} catch (IOException e) {
			return "-1";
		}
		if(rRes.getStatus().equals(ResponseStatus.SUCCESS)){
			return "SUCCESSUPD";//ͬ�����³ɹ�
		}else{
			return rRes.getError().getReasonText();
		}
	}

	/**
	 * ����DAO��ѯ��������ʶ��ʵ������Ƿ����
	 * @param roleid Integer
	 * @return Role
	 * @throws BLException
	 */
	
	protected Role checkExistRole(Integer roleid) throws BLException{
		Role role = roleBL.searchRoleByKey(roleid);
		return role;
	}
	
	/**
	 * ע���ɫ
	 * @param role Role
	 * @return Role
	 */
	
	public Role registRole(Role role) throws BLException{
		//checkNotExistRole(role.getRolename());
		Role ret = roleBL.registRole(role);
		return ret;
	}
	
	/**
	 * ��ѯ�û����Ƿ����
	 * @param rolename
	 * @throws BLException
	 */
	
	protected void checkNotExistRole(String rolename) throws BLException{
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename(rolename);
		List<Role> infoList = roleBL.searchRole(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","����","��ɫ����");
		}
	}
	
	/**
	 * ���ݴ���Ľ�ɫID����ѯ��
	 * @param ��ɫID
	 * @return 
	 * @throws BLException
	 * @author
	 */
	public Map<String, TreeNode> getRoleDomainsTree(String roleId) throws BLException{
		IGSYM03DTO dto = new IGSYM03DTO();
		Role info = roleBL.searchRoleByKey(Integer.parseInt(roleId));
		
		
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		IGSYM0101Form form = new IGSYM0101Form();
		IGSYM01DTO igsym01dto = new IGSYM01DTO();
		

		String syscoding = info.getRoledomain();
		if(syscoding!=null && !"".equals(syscoding)){
			if(syscoding.length()>7){
				syscoding = syscoding.substring(0, 7);
			}
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
}
