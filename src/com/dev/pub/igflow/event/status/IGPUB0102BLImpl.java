/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.pub.igflow.event.status;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ѯ��ɫ�µ������˲����óɲ�����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPUB0102BLImpl implements WorkFlowEventHandlerBL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGPUB0102BLImpl.class);
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ��ɫBL */
	protected RoleBL roleBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ��ɫBL�趨
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
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
	 * ǰ����
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("=================����ִ���˿�ʼ=================");
		//��ѯ�����˶���
		IG337SearchCondImpl cond = new IG337SearchCondImpl();
		cond.setPrid(bean.getLogInfo().getPrid());
		cond.setPsdid(bean.getAfstatus());
		IG333Info psd = workFlowDefinitionBL.searchProcessStatusDefByKey(bean.getAfstatus());
		//��ѯ������
		List<IG337Info> lst_ProcessParticipant = workFlowOperationBL.searchProcessParticipants(cond);
		//��ɫ��Ϣ����
		Set<Integer> set = new LinkedHashSet<Integer>();
		for(IG337Info info:lst_ProcessParticipant){
			set.add(info.getPproleid());
			workFlowOperationBL.removeProcessParticipant(info);
		}
		String dateTime = IGStringUtils.getCurrentDateTime();
		Set<String> userSet = new HashSet<String>();
		//��ѯ��ɫ�û�
		for(Iterator<Integer> iter = set.iterator();iter.hasNext();){
			Integer roleid = iter.next();
			//�����߽�ɫ
			Role role = roleBL.searchRoleByKey(roleid);
			UserRoleVWSearchCondImpl urcond = new UserRoleVWSearchCondImpl();
			urcond.setRoleid(roleid);//��ɫID
			//��ѯ��ɫ������
			List<UserRoleInfo> lst_UserRole = userRoleBL.searchUserRoleVW(urcond);
			
			for(UserRoleInfo ur:lst_UserRole){
				if(!userSet.contains(ur.getUserid())){
					userSet.add(ur.getUserid());
					IG337TB instance = new IG337TB();
					instance.setPrid(bean.getLogInfo().getPrid());
					instance.setPsdid(psd.getPsdid());
					instance.setPpstatus(psd.getPsdcode());
					instance.setPpinittime(dateTime);
					instance.setPptype(WorkFlowConstDefine.PPTYPE_ASSIGN_TO_PERSON);
					instance.setPpuserid(ur.getUserid());
					instance.setPpusername(ur.getUsername());
					instance.setPporgid(ur.getOrgid());
					instance.setPporgname(ur.getOrgname());
					instance.setPproleid(role.getRoleid());
					instance.setPprolename(role.getRolename());
					workFlowOperationBL.addProcessParticipant(instance);
					
				}
			}
		}
		log.debug("=================����ִ���˽���=================");
	}

	/**
	 * ����
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
