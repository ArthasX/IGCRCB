/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.IG622BL;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0202Form;
import com.deliverik.infogovernor.sym.form.IGSYM0204Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_�û�����_BLIMPL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM02BLImpl extends BaseBLImpl implements IGSYM02BL {

	static Log log = LogFactory.getLog(IGSYM02BLImpl.class);
	
	/**
	 * �û�BL
	 */
	protected UserBL userBL;
	
	/**
	 * �û���ɫBL
	 */
	protected UserRoleBL userRoleBL;
	
	/**
	 * ��ɫBL
	 */
	protected RoleBL roleBL;
	
	/**
	 * ����BL
	 */
	protected OrganizationBL organizationBL;

	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ��ҳ��תURL����BL */
	protected IG622BL ig622BL;
	
	/**
	 * �����û�DAO
	 * @param userBL UserBL
	 */
	
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}
	
	/**
	 * �����û���ɫBL
	 * @param userRoleBL UserRoleBL
	 */
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ���û���BL
	 * @param organizationBL OrganizationBL
	 */

	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	
	/**
	 * ���ý�ɫBL
	 * @param roleBL RoleBL
	 */
	
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * ��ҳ��תURL����BL�趨
	 * 
	 * @param ig622BL ��ҳ��תURL����BL
	 */
	public void setIg622BL(IG622BL ig622BL) {
		this.ig622BL = ig622BL;
	}
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserActionForIGASM0101() throws BLException {
		log.debug("========�û���ѯ����ʼ========");
		IGSYM02DTO dto = new IGSYM02DTO();
		UserSearchCondImpl cond = new UserSearchCondImpl();
		cond.setDeleteflag("0");//��ѯ״̬Ϊ���õ��û�
		List<User> userList = userBL.searchUser(cond,0,0);
		dto.setUserList(userList);
		log.debug("========�û���ѯ��������========");
		return dto;
	}
	
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchUserAction(IGSYM02DTO dto)
			throws BLException {
		log.debug("========�û���ѯ����ʼ========");
		// ��ѯ��¼����
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
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
		List<User> userList = userBL.searchUser(dto
				.getUserSearchCond(), pDto.getFromCount(), pDto
				.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========�û���ѯ��������========");
		return dto;
	}

	/**
	 * <p>
	 * Description: �û�ɾ����δ����Ҫcheck��
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO changeUserFlagAction(IGSYM02DTO dto) throws BLException {
		log.debug("========�û�ɾ������ʼ========");
		String userid = dto.getUserid();
		//����DAO��ѯ��������ʶ��ʵ�����
		User user = userBL.searchUserByKey(userid);
		if("1".equals(user.getDeleteflag())){
			UserTB userTB = (UserTB)SerializationUtils.clone(user);
			userTB.setDeleteflag("0");
			userBL.registUser(userTB);
			dto.addMessage(new ActionMessage("IGCO10000.I009", "�û�������Ϣ"));
		} else {
			IG677SearchCondImpl cond = new IG677SearchCondImpl();
			cond.setPpuserid(userid);
			List<IG500Info> processRecordList = workFlowOperationBL.queryCorrelationProcessByUserid(cond,0,0,1,1);
			if(processRecordList.size() == 0){
				userBL.deleteUser(user);
				dto.addMessage(new ActionMessage("IGCO10000.I008", "�û�������Ϣ"));
			} else {
				String prserialnum = "";
				for (int i = 0; i < processRecordList.size(); i++) {
					prserialnum += processRecordList.get(i).getPrserialnum();
					if(i < processRecordList.size() - 1){
						prserialnum += ",";
					}
				}
				dto.addMessage(new ActionMessage("IGSYM0201.E001", prserialnum));
			}
		}
		log.debug("========�û�ɾ����������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û�����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO insertUserAction(IGSYM02DTO dto) throws BLException {
		log.debug("========�û���������ʼ========");
		IGSYM0202Form form = dto.getIgsym0202Form();
		checkUser(form);
		User user = userBL.registUser(form);
		dto.setUser(user);
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "�û�������Ϣ") );
		log.debug("========�û�������������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û������ʼ��
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO initIGSYM0202Action(IGSYM02DTO dto) throws BLException {
		log.debug("========������û�������Ϣ��ѯ����ʼ========");
		IGSYM0202Form form = dto.getIgsym0202Form();
		User user = userBL.searchUserByKey(form.getUserid());
		form.setUserid(user.getUserid());
		form.setOrgid(user.getOrgid());
		form.setOrgidstr(user.getOrgid().toString());
		form.setUsername(user.getUsername());
		form.setUserdesc(user.getUserdesc());
		form.setPassword(user.getPassword());
		form.setRepassword(user.getPassword());
		form.setUserstatus(user.getUserstatus());
		form.setUserphone(user.getUserphone());
		form.setUsermobile(user.getUsermobile());
		form.setUseremail(user.getUseremail());
		form.setOrgname(user.getOrgname());
		form.setUsertype(user.getUsertype());
		form.setDeleteflag(user.getDeleteflag());
		form.setUserinfo(user.getUserinfo());
		form.setFingerPrint(user.getFingerPrint());
		//�����ʼ��ģʽ
		form.setMode("1");
		dto.addMessage(new ActionMessage("IGCO10000.I001","�û�������Ϣ"));
		log.debug("========������û�������Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO updateUserAction(IGSYM02DTO dto) throws BLException{
	    checkExistEntity(dto.getUser().getUserid());
		IGSYM0202Form form = dto.getIgsym0202Form();
		userBL.updateUser(form);
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�û�������Ϣ") );
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û����
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO updateUserManagerAction(IGSYM02DTO dto) throws BLException{
	    checkExistEntity(dto.getUser().getUserid());
		
		IGSYM0202Form form = dto.getIgsym0202Form();
		userBL.updateUser(dto.getUser());
		
		String[] rolemanager = form.getRolemanager();
		String[] mobile = form.getMobile();
		String[] rolemobile = form.getRolemobile();
		String[] roleid = form.getRoleid();
		if(roleid != null) {
			for(int i = 0; i < roleid.length; i++) {
				//0ֵ���ֻ���1ֵ����
				if("0".equals(mobile[i]) || "1".equals(mobile[i])) {
					Role role = this.roleBL.searchRoleByKey(new Integer(roleid[i]));
					RoleTB roleTB = (RoleTB)SerializationUtils.clone(role);
					if(role != null) {
						if("0".equals(mobile[i])) {
							if(StringUtils.isEmpty(rolemobile[i])) {
								roleTB.setRoleinfo(null);
							} else {
								roleTB.setRoleinfo("###" + rolemobile[i]);
							}
						} else if("1".equals(mobile[i])) {
							User manger = this.userBL.searchUserByKey(rolemanager[i]);
							if(manger != null) {
								roleTB.setRoleinfo(manger.getUserid() + "###" + manger.getUsermobile());
							} else {
								throw new BLException("IGCO10000.E004","�û�����");
							}
						}
					} else {
						throw new BLException("IGCO10000.E004","��ɫ����");
					}
					this.roleBL.updateRole(roleTB);
					
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "�û�������Ϣ") );
		return dto;
	}
	
	/**
	 * ����DAO��ѯ��������ʶ��ʵ������Ƿ����
	 * @param userid Integer
	 * @return User
	 * @throws BLException
	 */
	
	protected User checkExistEntity(String userid) throws BLException{
		User user = userBL.searchUserByKey(userid);
		if( user == null) {
			throw new BLException("IGCO10000.E004","�û�����");
		}
		return user;
	}
	
	
	/**
	 * ����DAO��ѯ��������ʶ��ʵ�����
	 * @param userid Integer
	 * @return User
	 */
	
	public User registEntity(User user) throws BLException{
		checkNotExistEntity(user.getUserid());
		User ret = userBL.registUser(user);
		return ret;
	}
	
	public void checkUser(User user) throws BLException{
		checkNotExistEntity(user.getUserid());
	}
	
	
	
	/**
	 * ��ѯ�û����Ƿ����
	 * @param userid String
	 * @throws BLException
	 */
	
	protected void checkNotExistEntity(String userid) throws BLException{
		UserSearchCondImpl cond = new UserSearchCondImpl();
		cond.setUserid(userid);
		List<User> infoList = userBL.searchUser(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSYM0000.E001","ID","�û�����");
		}
	}
	
	/**
	 * <p>
	 * Description: ������ѯ
	 * </p>
	 * 
	 * @return List<Organization>
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM02DTO searchOrganizationAll(IGSYM02DTO dto) throws BLException{
		List<Organization> ret = organizationBL.searchOrganization(new OrganizationSearchCondImpl());
		dto.setOrganizationList(ret);
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û�������ѯ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public int searchUserCount(IGSYM02DTO dto)
			throws BLException {
		log.debug("========�û�������ѯ����ʼ========");
		UserSearchCondImpl searchCond = new UserSearchCondImpl();
		dto.setUserSearchCond(searchCond);
		// ��ѯ��¼����
		int totalCount = userBL.getUserSearchCount(dto
				.getUserSearchCond());
		
		log.debug("========�û�������ѯ��������========");
		return totalCount;
	}
	
	/**
	 * <p>
	 * Description: �û���ҳ�б�ȡ��
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYM02DTO searchComboBoxAction(IGSYM02DTO dto) throws BLException {
		dto.setLst_LabelValueBean(ig622BL.getComboBox());
		return dto;
	}
	
	/**
	 * <p>
	 * Description: �û���ѯ
	 * �޷�ҳ
	 * </p>
	 * 
	 * @param dto IGSYM02DTO
	 * @return IGSYM02DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	public IGSYM02DTO searchUserActionNoPage(IGSYM02DTO dto) throws BLException {
		log.debug("========�û���ѯ(�޷�ҳ)����ʼ========");
		//��ѯ����
		IGSYM0204Form form = dto.getIgsym0204Form();
		UserSearchCondImpl usercond = new UserSearchCondImpl();
		usercond.setOrgid_like(form.getOrgidstr());
		// ��ѯ��¼����
		int totalCount = userBL.getUserSearchCount(usercond);
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//����DAO�ӿڲ�ѯ
		List<User> userList = userBL.searchUser(usercond);
		dto.setUserList(userList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========�û���ѯ(�޷�ҳ)��������========");
		return dto;
	}
}
