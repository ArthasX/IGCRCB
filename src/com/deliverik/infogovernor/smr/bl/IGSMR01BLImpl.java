/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR01DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0101Form;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
 * �����ҵ���߼�ʵ��
 *
 */
public class IGSMR01BLImpl extends BaseBLImpl implements IGSMR01BL {

	static Log log = LogFactory.getLog(IGSMR01BLImpl.class);
	
	/** �����ʵ����ҵ��BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** �������ϸ��ҵ��BL */
	protected RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	/** ����ҵ��BL */
	protected FlowOptBL flowOptBL;
	
	/** �������Ͷ���BL */
	protected IG380BL ig380BL;
	
	/** ��ɫBL */
	protected RoleBL roleBL;
	
	/** ����BL */
	protected IG500BL ig500BL;
	
	/** ��ɫ�˵�BL */
	protected RoleActionBL roleActionBL;
	
	/**
	 * �����ʵ����ҵ��BL�趨
	 * @param regulatoryReportInstanceBL
	 */
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}

	/**
	 * �������ϸ��ҵ��BL
	 * @param regulatoryReportDetailBL
	 */
	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}
	
	/**
	 * ����ҵ��BL�趨
	 * @param flowOptBL ����ҵ��BL
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	/**
	 * �������Ͷ���BL�趨
	 * 
	 * @param ig380bl �������Ͷ���BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}
	
	/**
	 * ��ɫBL�趨
	 * 
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ����BL�趨
	 * 
	 * @param ig500bl ����BL
	 */	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	
	/**
	 * ��ɫ�˵�BL�趨
	 * @param roleActionBL ��ɫ�˵�BL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * �걨������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR01DTO insertSMR0101Action(IGSMR01DTO dto) throws BLException {
		log.debug("========�걨������ʼ========");
		IGSMR0101Form form = dto.getIgSMR0101Form();
		
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_YEAR);//������
		instance.setKey(form.getYear());//���ʶ
		instance.setInittime(IGStringUtils.getCurrentDateTime());//�����ʱ��
		instance.setLimittime(form.getLimittime());//�����ʱ��
		instance.setRemark(form.getRemark());//��ע
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//״̬������
		instance.setUserid(user.getUserid());//������ID
		instance.setUsername(user.getUsername());//����������
		instance.setReportdesc(form.getYear()+"_�걨");
		instance.setYear(form.getYear());//��
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_YEAR_ID, form.getTest());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "�걨����") );
		log.debug("========�걨���������========");
		return dto;
	}
	
	/**
	 * ��ȡ�����ɫID
	 * 
	 * @return �����ɫID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//��ȡ����"�걨����"�˵��Ľ�ɫID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_YEAR);
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if(lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "������ɫ");
		}
		return lst_RoleAction.get(0).getRoleid();
	}
	
	/**
	 * �����ʵ�������ҷ��𱨱����̣��������ϸ����
	 * @param instance �ʵ��
	 * @param ptid ģ��ID
	 * @param test �Ƿ���Է����ǣ�1
	 * @throws BLException
	 */
	private void initRegulatoryReportIntance(RegulatoryReportInstanceTB instance, Integer ptid, String test) throws BLException {
		//��ȡ�����ɫID
		Integer roleid = getInitRoleid();
		//�����걨�ʵ��
		RegulatoryReportInstanceInfo instanceInfo = 
				regulatoryReportInstanceBL.registRegulatoryReportInstanceInfo(instance);
		WorkFlowLog workFlowLog = new WorkFlowLog();
		workFlowLog.setExecutorid(instance.getUserid());//������ID
		workFlowLog.setExecutorRoleid(roleid);
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(ptid);//�걨ģ��ID
		if("1".equals(test)) {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//����״̬
		} else {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//����״̬
		}
		List<IG380Info> lst_IG380Info = ig380BL.searchIG380Info(cond_IG380);
		if(lst_IG380Info.isEmpty()) {
			throw new BLException("IGCO10000.E004", "����");
		}
		Map<String, String> formvalue = new HashMap<String, String>();
//		formvalue.put("�����ʱ��", instance.getLimittime());
		//formvalue.put("���", instance.getLimittime());
		//��������ID����
		List<Integer> lst_Prid = new ArrayList<Integer>();
		for(IG380Info info : lst_IG380Info) {
			ProcessRecord process = new ProcessRecord(workFlowLog);
			process.setCrtuserid(instance.getUserid());//������ID
			process.setTitle(instanceInfo.getKey() + "��" + info.getPdname() + "��");//����
			process.setDefid(info.getPdid());
			process.setRoleid(roleid);
			process.setFormvalue(formvalue);
			process.setDescription(instance.getRemark());//����
			lst_Prid.add(flowOptBL.initProcessAction(process));
		}
		//�������ϸ������
		for(Integer prid : lst_Prid) {
			RegulatoryReportDetailTB detail = new RegulatoryReportDetailTB();
			detail.setPrid(prid);//����ID
			detail.setInstanceID(instanceInfo.getInstanceID());//�ʵ��ID
			this.regulatoryReportDetailBL.registRegulatoryReportDetailInfo(detail);
		}
	}
	
}
