/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.bl.task.RemindConfigureBL;
import com.deliverik.infogovernor.smr.dto.IGSMR07DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0701Form;
import com.deliverik.infogovernor.smr.form.IGSMR0703Form;
import com.deliverik.infogovernor.smr.form.IGSMR0704Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;

/**
 * �������ҵ���߼�ʵ��
 *
 */
public class IGSMR07BLImpl extends BaseBLImpl implements IGSMR07BL {
	
	static Log log = LogFactory.getLog(IGSMR07BLImpl.class);
	
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
	
	
	/**��������BL*/
	protected FlowSetBL flowSetBL;
	
	/**���Ͷ���BL*/
	protected SendMessageBL sendMessageBL;
	
	/**�û���ɫBL*/
	protected UserRoleBL userRoleBL;
	
	/**������BL*/
	protected IG337BL ig337BL;
	
	/**��ֵBL*/
	protected IG599BL ig599BL;
	
	/**���ѱ�������BL*/
	protected RemindConfigureBL remindConfigureBL;
	
	/** ��ɫ�˵�BL */
	protected RoleActionBL roleActionBL;

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}

	
	public void setRemindConfigureBL(RemindConfigureBL remindConfigureBL) {
		this.remindConfigureBL = remindConfigureBL;
	}
	
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
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
	
	/**
	 * ��ɫ�˵�BL�趨
	 * @param roleActionBL ��ɫ�˵�BL
	 */
	public void setRoleActionBL(RoleActionBL roleActionBL) {
		this.roleActionBL = roleActionBL;
	}

	/**
	 * ��ȡ�����ɫID
	 * 
	 * @return �����ɫID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//��ȡ����"�����ڷ���"�˵��Ľ�ɫID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_NONSKED);
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
	private void initRegulatoryReportIntance(RegulatoryReportInstanceTB instance, Integer ptid, String test, IGSMR07DTO dto) throws BLException {
		//��ȡ�����ɫID
		Integer roleid = getInitRoleid();
		//���������ڱ����ʵ��
		RegulatoryReportInstanceInfo instanceInfo = 
				regulatoryReportInstanceBL.registRegulatoryReportInstanceInfo(instance);
		WorkFlowLog workFlowLog = new WorkFlowLog();
		workFlowLog.setExecutorid(instance.getUserid());//������ID
		workFlowLog.setExecutorRoleid(roleid);
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(ptid);//�����ڱ���ģ��ID
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
		String pdids = dto.getIgSMR0701Form().getPdids();
		for(IG380Info info : lst_IG380Info) {
			if(pdids.indexOf(info.getPdid())==-1){
				continue;
			}
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

	public IGSMR07DTO insertSMR0701Action(IGSMR07DTO dto) throws BLException{
		log.debug("========�����ڱ�������ʼ========");
		IGSMR0701Form form = dto.getIgSMR0701Form();
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_IRREGULAR);//������
		instance.setKey(form.getRemark());//���ʶ
		instance.setInittime(IGStringUtils.getCurrentDateTime());//�����ʱ��
		instance.setLimittime(form.getLimittime());//�����ʱ��
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//״̬������
		instance.setUserid(user.getUserid());//������ID
		instance.setUsername(user.getUsername());//����������
		instance.setReportdesc(form.getRemark()+"_�����ڱ���");
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_IRREGULAR_ID, form.getTest(),dto);
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "�����ڱ�����") );
		log.debug("========�����ڱ����������========");
		return dto;
	}
	/**
	 * �����ڱ�����ҳ��ʼ��
	 *
	 *2013-8-8����04:46:05
	 *@throws BLException
	 */
	public IGSMR07DTO initSMR0701Action(IGSMR07DTO dto) throws BLException {
		log.debug("========�����ڱ����ʼ����ʼ========");
		
		IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
		cond_IG380.setPtid(IGPRDCONSTANTS.PRTYPE_IRREGULAR_ID);//�����ڱ���ģ��ID
		if("1".equals(dto.getIgSMR0701Form().getTest())) {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_TESTABLE);//����״̬
		} else {
			cond_IG380.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//����״̬
		}
		List<IG380Info> ig380List = ig380BL.searchIG380Info(cond_IG380);
		dto.setIg380List(ig380List);
		log.debug("========�����ڱ����ʼ������========");
		
		return dto;
		
	}
	/**
	 * ��ѯ��Ҫ�Ҵ���Ĳ����ڱ���
	 * @throws BLException 
	 *
	 */
	public IGSMR07DTO needMeManagerAction(IGSMR07DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//�������ڱ�����������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//��ѯ��Ҫ�Ҵ���Ĳ����ڱ���
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ�������Բ����ڱ���˵��Ϊ����ÿ������Ϊֵ��map����
		Map<String,List<AnnualReportVW>> map_arq = new LinkedHashMap<String, List<AnnualReportVW>>();
		//������ѯ����ļ���
		for(AnnualReportVWInfo info:list_arq){
			AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
			//�ж������map�����Ƿ����ĳһ���ײ�����
			if(map_arq.get(info.getReportdesc())==null){
				//����һ����ʱlist����
				List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
				//��ѭ������ʵ��Ž���ʱ��������
				secondList.add(tb);
				//����ʱ����list�Ž�map����
				map_arq.put(info.getReportdesc(),secondList);
			}else{
				map_arq.get(info.getReportdesc()).add(tb);
			}
		}
        dto.setMap_arq(map_arq);
		return dto;
	}
	
	/**
	 * ��ѯ��������
	 * @throws BLException 
	 *
	 */
	public IGSMR07DTO reportExamineAction(IGSMR07DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//�������ڱ�����������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
		//��ѯ��Ҫ�Ҵ���Ĳ����ڱ���
		List<AnnualReportVWInfo> first_list = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ�������Բ����ڱ���˵��Ϊ����ÿ������Ϊֵ��map����
		Map<String,List<AnnualReportVW>> map_first = new LinkedHashMap<String, List<AnnualReportVW>>();
		//������ѯ����ļ���
		for(AnnualReportVWInfo info:first_list){
			AnnualReportVW ar = (AnnualReportVW)SerializationUtils.clone(info);
			//�ж������map�����Ƿ����ĳһ���ײ�����
			if(map_first.get(info.getReportdesc())==null){
			    //����һ����ʱlist����
			    List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
			    IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			    cond599.setPrid(info.getPrid());
			    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
			    if(ig599!=null&&ig599.size()!=0){			    	
			    	//�ж��Ƿ��Ϳձ����ñ�ʶ
			    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
			    		ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    	}
			    }
				//��ѭ������ʵ��Ž���ʱ��������
				secondList.add(ar);
				//����ʱ����list�Ž�map����
				map_first.put(info.getReportdesc(),secondList);
			}else{
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
			    cond599.setPrid(info.getPrid());
			    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
			    if(ig599!=null&&ig599.size()!=0){			    	
			    	//�ж��Ƿ��Ϳձ����ñ�ʶ
			    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
			    		ar.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
			    	}
			    }
				map_first.get(info.getReportdesc()).add(ar);
			}
		}
		dto.setMap_first(map_first);
		return dto;
	}
	
	/**
	 * ��ѯ�����ڱ�������
	 *
	 */
	public IGSMR07DTO AnnualreportExamineAction(IGSMR07DTO dto) {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//�������ڱ�����������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRTYPE_IRREGULAR);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_IRREGULAREXAMINE);
		//����ʵ��״̬�Ž�cond��
		cond.setStatus_eq("1");
		//�趨����ʽΪ����
		cond.setOrderby("desc");
		//��ѯ��Ҫ�Ҵ���Ĳ����ڱ���
		List<RegulatoryReportInstanceInfo> second_list = regulatoryReportInstanceBL.findSectionAnnualReportByCond(cond,0,0);
        dto.setSecond_list(second_list);
		return dto;
	}
	/**
	 * ��鿴
	 * @throws BLException 
	 *
	 */
	public IGSMR07DTO seeFillInAction(IGSMR07DTO dto) throws BLException {
		IGSMR0703Form form = dto.getIGSMR0703Form();
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setPropentime(form.getPropentime());
		cond.setProclosetime(form.getProclosetime());
		cond.setPrtype(IGPRDCONSTANTS.PRTYPE_IRREGULAR);
		List<AnnualReportVWInfo> list_rri = regulatoryReportInstanceBL.lookatFillIn(cond);
		//�����ϱ�������Բ����ڱ���˵��Ϊ����ÿ������Ϊֵ��map����
		Map<String,List<AnnualReportVW>> map_see = new LinkedHashMap<String, List<AnnualReportVW>>();
		//������ѯ����ļ���
		for(AnnualReportVWInfo info:list_rri){
			//�ж������map�����Ƿ����ĳһ���ײ�����
			if(map_see.get(info.getReportdesc() + "###" + info.getInittime())==null){
			    //����һ����ʱlist����
			    List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
			    //�õ�ʵ��
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //�ж��Ƿ��Ϳձ����ñ�ʶ
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }
				//��ѭ������ʵ��Ž���ʱ��������
				secondList.add(tb);
				//����ʱ����list�Ž�map����
				map_see.put(info.getReportdesc() + "###" + info.getInittime(),secondList);
			}else{
				//�õ�ʵ��
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
				 cond599.setPrid(info.getPrid());
				 cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
				 List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
				 if(ig599!=null&&ig599.size()!=0){					 
					 //�ж��Ƿ��Ϳձ����ñ�ʶ
					 if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
						 tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
					 }
				 }
				map_see.get(info.getReportdesc() + "###" + info.getInittime()).add(tb);
			}
		}		
		dto.setMap_see(map_see);	
		
		return dto;
	}

	/**
	 * �����ڱ�����ϸ�б��ѯ����
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO initIGSMR0704Action(IGSMR07DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setInstanceid(dto.getInstanceID());
		//��ѯ���������̰������̵�����ʱ��ͱ����������ʱ��
		List<BatchExamineVWInfo> list_be = regulatoryReportInstanceBL.findBatchExanmie(cond);
		//�½�һ��������˺ͱ��������˵ļ���
		List<BatchExamineVW> list_all = new ArrayList<BatchExamineVW>();
		//�������ϸ�������id��ѯ��Ӧ����˺ͱ���������
		for(BatchExamineVWInfo bean:list_be){
			BatchExamineVW tb = (BatchExamineVW)SerializationUtils.clone(bean);
			//�������
			String fillinusername ="";
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q("Y");
			cond337.setPrid(bean.getPrid());
			List<IG337Info> list_337 = ig337BL.getIG337Infos(cond337);
			//�������ƴд���
			for(int i=0;i<list_337.size();i++){
				IG337Info info1 = list_337.get(i);
				if(i!=list_337.size()-1){
					fillinusername = fillinusername+info1.getPpusername()+",";
				}else{
					fillinusername =fillinusername +info1.getPpusername();
				}
			}

			//���屨��������
			String examineusername = "";
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus("X");
			cond_ig337.setPrid(bean.getPrid());
			List<IG337Info> list_ig337 = ig337BL.getIG337Infos(cond_ig337);			
			//�������ƴд����������
			for(int i=0;i<list_ig337.size();i++){
				IG337Info info2 = list_ig337.get(i);
				if(i!=list_ig337.size()-1){
					examineusername = examineusername+info2.getPpusername()+",";
				}else{
					examineusername =examineusername +info2.getPpusername();
				}
			}
			//����˷Ž�ʵ����
			tb.setFillinusername(fillinusername);
			//�����������˷Ž�ʵ����
			tb.setExanimeusername(examineusername);
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
		    cond599.setPrid(bean.getPrid());
		    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
		    if(ig599!=null&&ig599.size()!=0){		    	
		    	//�ж��Ƿ��Ϳձ����ñ�ʶ
		    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
		    		tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    	}
		    }
			//��ʵ��Ž�������
			list_all.add(tb);
		}
		dto.setLst_Report(list_all);
		return dto;
	}
	
	/**
	 * �����ڱ�����������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR07DTO managerIGSMR0704Action(IGSMR07DTO dto) throws BLException {
		//formȡ��
		IGSMR0704Form form = dto.getIgSMR0704Form();
		for(Integer prid:form.getPrids()){						
			//ѭ��ѡ������̣������̽��в��ػ�����ͨ������
			if("1".equals(form.getType())){
				flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "����ͨ��", IGStringUtils.getCurrentDateTime());
			}
			if("2".equals(form.getType())){
				flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "����", IGStringUtils.getCurrentDateTime());
			}
		}
		return dto;
	}

}
