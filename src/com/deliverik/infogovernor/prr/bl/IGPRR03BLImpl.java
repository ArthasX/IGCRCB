/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG001TB;
import com.deliverik.infogovernor.prr.dto.IGPRR03DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0301Form;
import com.deliverik.infogovernor.prr.form.IGPRR0302Form;
import com.deliverik.infogovernor.prr.form.IGPRR0303Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̸�������BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR03BLImpl extends BaseBLImpl implements IGPRR03BL{
	
	/** ��־����ȡ�� */
	private static Log log = LogFactory.getLog(IGPRR03BLImpl.class);
	
	/** OA��ɫ����BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ��ɫ��ϢBL */
	protected RoleBL roleBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/**
	 * OA��ɫ����BL�趨
	 * @param workFlowDefinitionBL OA��ɫ����BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * ��ɫ��ϢBL�趨
	 * @param roleBL ��ɫ��ϢBL
	 */
	public final void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}
	
	/**
	 * �û���ɫBL�趨
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * ��ɫ��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleListAction(IGPRR03DTO dto) throws BLException {
		log.debug("==========��ɫ��Ϣ��ѯ������ʼ===========");
		//ҳ����Ϣȡ��
		IGPRR0302Form form = dto.getIgprr0302Form();
		//ʵ������ѯ����
		RoleSearchCondImpl cond = new RoleSearchCondImpl();
		cond.setRolename_q(form.getRolename_q());
		cond.setRoletype(form.getRoletype());
		cond.setRoleid_not_in(form.getRoleids());
		if(StringUtils.isNotEmpty(form.getRoleidin())){
			List<Integer> roleids = new ArrayList<Integer>();
			String[] split = form.getRoleidin().split(",");
			for(String s:split){
				roleids.add(Integer.valueOf(s));
			}
			cond.setRoleid_in(roleids);
		}
		// ��ѯ��¼����
		int totalCount = roleBL.getRoleSearchCount(cond);
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
		List<Role> roleList = roleBL.searchRole(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRoleList(roleList);
		log.debug("==========��ɫ��Ϣ��ѯ��������===========");
		return dto;
	}
	
	/**
	 * ��ѯ��ɫ������Ϣ
	 * @param dto
	 * @return
	 */
	public IGPRR03DTO searchIG001InfoListAction(IGPRR03DTO dto) throws BLException {
		log.debug("===========��ɫ������Ϣ��ѯ������ʼ============");
		//��ѯ��ɫ���õ�������Ϣ
		List<IG001Info> allList = workFlowDefinitionBL.searchOARoleConfig(new IG001SearchCondImpl());
		//�����˽�ɫ����
		List<IG001Info> ig001List_A = new ArrayList<IG001Info>();
		//ֵ���˽�ɫ����
		List<IG001Info> ig001List_B = new ArrayList<IG001Info>();
		//ִ���˽�ɫ����
		List<IG001Info> ig001List_C = new ArrayList<IG001Info>();
		//�ǿ��ж�
		if(allList!=null){
			for(IG001Info pro:allList){
				//����Ǹ�����
				if(IGPRDCONSTANTS.OA_ROLE_A.equals(pro.getProtype())){
					ig001List_A.add(pro);
				//�����ֵ����
				}else if(IGPRDCONSTANTS.OA_ROLE_B.equals(pro.getProtype())){
					ig001List_B.add(pro);
				//�����ִ����
				}else if(IGPRDCONSTANTS.OA_ROLE_C.equals(pro.getProtype())){
					ig001List_C.add(pro);
				}
				
			}
			//�����������÷���dto
			dto.setIg001List_A(ig001List_A);
			//��ִ�������÷���dto
			dto.setIg001List_B(ig001List_B);
			//��ִ�������÷���dto
			dto.setIg001List_C(ig001List_C);
		}
		log.debug("===========��ɫ������Ϣ��ѯ��������============");
		return dto;
	}
	
	/**
	 * ��ɫ������Ϣɾ������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO deleteIG001Action(IGPRR03DTO dto) throws BLException{
		log.debug("===========��ɫ������Ϣɾ��������ʼ=============");
		//ҳ����Ϣȡ��
		IGPRR0301Form form = dto.getIgprr0301Form();
		//ʵ����Ҫɾ���Ķ���
		List<IG001Info> delList = new ArrayList<IG001Info>();
		
		//���ɾ�����Ǹ��������ã�ʵ����������������Ϣ
		if(IGPRDCONSTANTS.OA_ROLE_A.equals(form.getDeleteFlag())){
			if(form.getProids_A()!=null&&form.getProids_A().length>0){
				for(Integer proid:form.getProids_A()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		//���ɾ������ֵ�������ã�ʵ����ֵ����������Ϣ
		}else if(IGPRDCONSTANTS.OA_ROLE_B.equals(form.getDeleteFlag())){
			if(form.getProids_B()!=null&&form.getProids_B().length>0){
				for(Integer proid:form.getProids_B()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		//���ɾ������ִ�������ã�ɾ��ִ����������Ϣ
		}else if(IGPRDCONSTANTS.OA_ROLE_C.equals(form.getDeleteFlag())){
			if(form.getProids_C()!=null&&form.getProids_C().length>0){
				for(Integer proid:form.getProids_C()){
					IG001TB pro = new IG001TB();
					pro.setProid(proid);
					delList.add(pro);
				}
			}
		}
		//���������Ҫɾ�������ݣ�����BLɾ��
		if(delList.size()>0){
			workFlowDefinitionBL.deleteOARoleConfig(delList);
		}
		dto.addMessage(new ActionMessage("IGPRR0302.I002"));
		log.debug("===========��ɫ������Ϣɾ����������=============");
		return dto;
	}
	
	/**
	 * ��ɫ������Ϣ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO addIG001InfoAction(IGPRR03DTO dto) throws BLException {
		log.debug("=============��ɫ������Ϣ����������ʼ============");
		//ҳ����Ϣȡ��
		IGPRR0302Form form = dto.getIgprr0302Form();
		//Ҫ������������Ϣ����
		List<IG001TB> addList = new ArrayList<IG001TB>();
		//ʵ����������Ϣ
		if(form.getAddContent()!=null&&form.getAddContent().length>0&&StringUtils.isNotEmpty(form.getAddFlag())){
			for(String content:form.getAddContent()){
				String[] split = content.split(",");
				IG001TB pro = new IG001TB();
				pro.setProtype(form.getAddFlag());
				pro.setProroleid(Integer.valueOf(split[0]));
				pro.setProrolename(split[1]);
				addList.add(pro);
			}
		}
		//���������Ϣ������������
		if(addList.size()>0){
			for(IG001TB pro:addList){
				workFlowDefinitionBL.registOARoleConfig(pro);
			}
		}
		dto.addMessage(new ActionMessage("IGPRR0302.I001"));
		log.debug("=============��ɫ������Ϣ������������============");
		return dto;
	}
	
	/**
	 * ��ѯ�û���Ϣ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchUserRoleAction(IGPRR03DTO dto) throws BLException{
		log.debug("=============��ѯ�û���Ϣ������ʼ=============");
		//����ȡ��
		IGPRR0303Form form = dto.getIgprr0303Form();
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoletype(form.getRoletype());
		cond.setOrgid_like(form.getOrgsyscoding());
		cond.setRoleid(form.getRoleid());
		//��ɫ����
		if(StringUtils.isNotEmpty(form.getRoleid_in())){
			List<Integer> roleids = new ArrayList<Integer>();
			String[] roleid_not_in = form.getRoleid_in().split(",");
			for(String s:roleid_not_in){
				roleids.add(Integer.valueOf(s));
			}
			cond.setRoleid_in(roleids);
		}
		List<UserRoleInfo> userRoleList = userRoleBL.searchUserRoleVW(cond);
		if(userRoleList != null){
			Map<Integer, Map<String,List<UserRoleInfo>>> userRoleInfoMap = new LinkedHashMap<Integer, Map<String,List<UserRoleInfo>>>();
			for(UserRoleInfo ur:userRoleList){
				if(userRoleInfoMap.get(ur.getRoleid()) == null){
					Map<String, List<UserRoleInfo>> map = new HashMap<String, List<UserRoleInfo>>();
					List<UserRoleInfo> list = new ArrayList<UserRoleInfo>();
					list.add(ur);
					map.put(ur.getRolename(), list);
					userRoleInfoMap.put(ur.getRoleid(), map);
				}else{
					userRoleInfoMap.get(ur.getRoleid()).get(ur.getRolename()).add(ur);
				}
			}
			dto.setUserRoleInfoMap(userRoleInfoMap);
		}
		log.debug("=============��ѯ�û���Ϣ��������=============");
		return dto;
	}
	
	/**
	 * ���˽�ɫ��Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR03DTO searchRoleidNotInAction(IGPRR03DTO dto) throws BLException{
		log.debug("==============���˽�ɫ��Ϣ��ѯ������ʼ================");
		IGPRR0303Form form = dto.getIgprr0303Form();
		String pidid = form.getPidid();
		if(StringUtils.isNotEmpty(pidid)){
			//��ɫ�޶���Ϣ��ѯ
			List<IG008Info> pidrses = workFlowDefinitionBL.searchFormRoleScopeByPidid(form.getPidid());
			if(pidrses != null && pidrses.size() > 0){
				StringBuffer info = new StringBuffer();
				for(int i=0;i<pidrses.size();i++){
					if(i>0){
						info.append(",");
					}
					info.append(pidrses.get(i).getRoleid());
				}
				form.setRoleid_in(info.toString());
			}
		}
		log.debug("==============���˽�ɫ��Ϣ��ѯ��������================");
		return dto;
	}
}
