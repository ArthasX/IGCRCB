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
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.parameter.SuspendProcess;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.RoleActionBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.RoleActionSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR11DTO;
import com.deliverik.infogovernor.smr.form.IGSMR1101Form;
import com.deliverik.infogovernor.smr.form.IGSMR1102Form;
import com.deliverik.infogovernor.smr.form.IGSMR1103Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportDetailTB;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;
/**
 * �����ҵ���߼�ʵ��
 *
 */
public class IGSMR11BLImpl extends BaseBLImpl implements IGSMR11BL {
static Log log = LogFactory.getLog(IGSMR11BLImpl.class);
	
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
	
	/**������BL*/
	protected IG337BL ig337BL;
	
	/**�û���ɫBL*/
	protected UserRoleBL userRoleBL;
	
	/**���Ͷ���BL*/
	protected SendMessageBL sendMessageBL;
	
	/**��������BL*/
	protected FlowSetBL flowSetBL;
	
	/** ���̴���BL */
	protected IG333BL ig333BL;
	
	/**��ֵBL*/
	protected IG599BL ig599BL;
	
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

	/**codeDetail����BL*/
	protected  CodeDetailBL codeDetailBL;
	/**
	 * ����BL�趨
	 * 
	 * @param ig500bl ����BL
	 */	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
		
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
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
	 * �±�������
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR11DTO insertSMR1101Action(IGSMR11DTO dto) throws BLException {
		log.debug("========�±�������ʼ========");
		IGSMR1101Form form = dto.getIgSMR1101Form();
		User user = dto.getUser();
		RegulatoryReportInstanceTB instance = regulatoryReportInstanceBL.getRegulatoryReportInstanceTBInstance();
		instance.setPrtype(IGPRDCONSTANTS.PRTYPE_MONTH);//������
		instance.setKey(form.getYear()+"_"+form.getMonth());//���ʶ
		instance.setInittime(IGStringUtils.getCurrentDateTime());//�����ʱ��
		instance.setLimittime(form.getLimittime());//�����ʱ��
		instance.setRemark(form.getRemark());//��ע
		instance.setStatus(IGSMRCONSTANT.REPORT_STATUS_BEGIN);//״̬������
		instance.setUserid(user.getUserid());//������ID
		instance.setUsername(user.getUsername());//����������
		instance.setReportdesc(form.getYear()+"_"+form.getMonth()+"_�±�");
		instance.setYear(form.getYear());//��
		instance.setMonth(form.getMonth());//��
		this.initRegulatoryReportIntance(instance, IGPRDCONSTANTS.PRTYPE_MONTH_ID, form.getTest());
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "�±�����") );
		log.debug("========�±����������========");
		return dto;
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
	
	/**
	 * ��ȡ�����ɫID
	 * 
	 * @return �����ɫID
	 * @throws BLException
	 */
	private Integer getInitRoleid() throws BLException {
		//��ȡ����"�±�����"�˵��Ľ�ɫID
		RoleActionSearchCondImpl cond = new RoleActionSearchCondImpl();
		cond.setActname(IGSMRCONSTANT.ACTION_QUARTER);
		List<RoleAction> lst_RoleAction = this.roleActionBL.searchRoleAction(cond);
		if(lst_RoleAction.isEmpty()) {
			throw new BLException("IGCO10000.E004", "������ɫ");
		}
		return lst_RoleAction.get(0).getRoleid();
	}
	
	/**
	 * �±����ѯ
	 * @throws BLException 
	 *
	 */
	public IGSMR11DTO needMeManagerAction(IGSMR11DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_MONTH);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//��ѯ��Ҫ�Ҵ�����±�
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ���������걨˵��Ϊ����ÿ������Ϊֵ��map����
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
	public IGSMR11DTO reportExamineAction(IGSMR11DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_MONTH);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
		//��ѯ��Ҫ�Ҵ�����걨
		List<AnnualReportVWInfo> first_list = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ���������걨˵��Ϊ����ÿ������Ϊֵ��map����
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
	 * ��ѯ�±�����
	 *
	 */
	public IGSMR11DTO AnnualreportExamineAction(IGSMR11DTO dto) {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_MONTH);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_MONTHSECONDE);
		//����ʵ��״̬�Ž�cond��
		cond.setStatus_eq("1");
		//�趨����ʽΪ����
		cond.setOrderby("desc");
		//��ѯ��Ҫ�Ҵ�����걨
		List<RegulatoryReportInstanceInfo> second_list = regulatoryReportInstanceBL.findSectionAnnualReportByCond(cond,0,0);
		dto.setSecond_list(second_list);
		return dto;
	}
	/**
	 * ��ල
	 *
	 */
	public IGSMR11DTO seeFillInAction(IGSMR11DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//���form����ݲ�Ϊ�գ����¶ȷŽ�cond��
		cond.setKey_eq(dto.getIgSMR1102Form().getYear()+"_"+dto.getIgSMR1102Form().getMonth());
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_MONTH);
		cond.setMonth(dto.getIgSMR1102Form().getMonth());
		List<AnnualReportVWInfo> list_rri = regulatoryReportInstanceBL.lookatFillIn(cond);
		//�����ϱ���������걨˵��Ϊ����ÿ������Ϊֵ��map����
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
	 * ���ֹ
	 *
	 */
	public IGSMR11DTO stopFillInAction(IGSMR11DTO dto) throws BLException {
		//formȡ��
		IGSMR1102Form form = dto.getIgSMR1102Form();
		//��form�е�ʵ������ȡ��
		Integer instanceID = form.getInstanceID();
		//������ʵ����Ӧ��״̬��Ϊ��ֹ
		RegulatoryReportInstanceInfo rri = regulatoryReportInstanceBL.searchRegulatoryReportInstanceInfoByPK(instanceID);
		RegulatoryReportInstanceTB tb = (RegulatoryReportInstanceTB)SerializationUtils.clone(rri);
		tb.setStatus("2");
		regulatoryReportInstanceBL.updateRegulatoryReportInstanceInfo(tb);		
		//ʵ������ѯ����
		RegulatoryReportDetailSearchCondImpl cond = new RegulatoryReportDetailSearchCondImpl();
		cond.setInstanceID(instanceID);
		//����ʵ��������ѯ�������̵�prid
		List<RegulatoryReportDetailInfo> list_rrd = regulatoryReportDetailBL.searchRegulatoryReportDetailInfo(cond);
		//��������ȡ��prid
		for(RegulatoryReportDetailInfo info:list_rrd){	
			//����������ѯ�����˽�ɫid
			IG500Info ig = ig500BL.searchIG500InfoByKey(info.getPrid());
			//����Ӧ��ʵ�����е�״̬�Ͷ�Ӧ���̵�״̬ȫ����Ϊ��ֹ
			WorkFlowLog log = new WorkFlowLog();
			//��ִ���˷Ž���־��
			log.setExecutorid(dto.getUser().getUserid());	
			log.setExecutorRoleid(ig.getPrroleid());
			log.setPrid(info.getPrid());
			log.setComment("��ֹ");
			SuspendProcess sp = new SuspendProcess(log);			
			flowOptBL.suspendProcess(sp);			
		}
		return dto;
	}
	/**
	 * �߰�
	 *
	 */
	public IGSMR11DTO pressAction(IGSMR11DTO dto) throws BLException {
		//�õ�form
		IGSMR1102Form form = dto.getIgSMR1102Form();
		//�õ�����id
		String prids = form.getPrid();
		String[] prid =null;
		//���崦���˽�ɫid
		Integer roleid = 0;
		//��ȡ�ַ������õ�����id����
		if(prids!=null&&prids.length()>0){			
			prid = prids.split(",");
		}
		//���ݽ�ɫ���ͺ͵�ǰ��¼�ߵ�userid��ѯ��ɫid
		UserRoleVWSearchCondImpl condrole = new UserRoleVWSearchCondImpl();
		//����ɫ���Ͳ��뵽��ѯ������
		condrole.setRoletype(IGSMRCONSTANT.ROLETYPE_REPORT);
		//����ǰ��¼�ߵ�userid�Ž���ѯ������
		condrole.setUserid(dto.getUser().getUserid());
		//��ѯȡ�������ɫ��ĳһ��ɫid
		List<UserRoleInfo> listrole = userRoleBL.searchUserRoleVW(condrole);
		//�������ȡ��ĳһ��ɫid
		for(UserRoleInfo info:listrole){
			roleid = info.getRoleid();
			break;
		}
		//��������id���ϣ���¼������־���Ҹ���Щ���̵ĵ�ǰ�����˷��ʹ߰���Ϣ
		for(String p:prid){
			//��������������ѯ������Ϣ
			IG500Info pr = ig500BL.searchIG500InfoByKey(Integer.parseInt(p));
			//���������־��
			WorkFlowLog wfl = new WorkFlowLog();
			wfl.setPrid(Integer.parseInt(p));
			wfl.setExecutorid(dto.getUser().getUserid());	
			wfl.setExecutorRoleid(roleid);
			wfl.setAuthuserid("");
			wfl.setComment(form.getView());
			flowSetBL.setProcessLog(wfl, "�߰�", Constants.PROCESS_LOG_TYPE_PROCESSING);
			//����ǰ�����˷�����
			//��ѯ��ǰ������
			//ʵ������ѯ����
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(Integer.parseInt(p));
			cond.setPpstatus_q(pr.getPrstatus());
			List<IG337Info> list_pp = ig337BL.getIG337Infos(cond);
			//�жϵ�ǰ״̬���Ƿ��в����ߣ����û�и���ǰ����Ľ�ɫ�������˷��Ͷ���
			if(list_pp!=null&&list_pp.size()>0){
				//�������Ϸ��Ͷ���
				for(IG337Info pp:list_pp){
					//�жϵ�ǰ�Ƿ��в���������з��͸���ǰ�����ˣ����û�з��͸���ǰ��ɫ�µ�������
					if(pp.getPpuserid()!=null||"".equals(pp.getPpuserid())){						
						sendMessageBL.sendSmsToUser(pp.getPpuserid(), form.getView());
					}else{
//						sendMessageBL.sendSmsToRoleformanager(pp.getPproleid(), form.getView());
					}
				}
			}
		}
		return dto;
	}
	/**
	 * �±���ϸ�б��ѯ����
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO initIGSMR1104Action(IGSMR11DTO dto) throws BLException {
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
			//���ʱ��ת����ʽ
			tb.setFillintime(formate(bean.getFillintime()));
			//�������������ʱ��ת����ʽ
			tb.setExaminetime(formate(bean.getExaminetime()));
			//������ʱ��ת����ʽ
			tb.setRejecttime(formate(bean.getRejecttime()));
			//�������
			String fillinusername ="";
			//�������״̬��ʶ��
			String fillincode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(bean.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
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
			//���屨���״̬��ʶ��
			String examinecode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(bean.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
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

	private String formate(String date){
		if(date!=null){		
			String result = "";
			String[] date1 =date.split("-");
			result = date1[0]+"/";
			if(date1[1].length()==1){
				result = result+"0"+date1[1]+"/";
			}else{
				result = result+date1[1]+"/";
			}
			String[] date2 = date1[2].split("\\.");
			if(date2[0].length()==1){
				result = result+"0"+date2[0];
			}else{
				result = result+date2[0];
			}
			
//			if(date2[1].length()==1){
//				result = result+" 0"+date2[1]+":";
//			}else{
//				result = result+" "+date2[1]+":";
//			}
//			if(date2[2].length()==1){
//				result = result+"0"+date2[2];
//			}else{
//				result = result+date2[2];
//			}
			return result;
		}else{
			return null;
		}
		
	}
	/**
	 * �±���������
	 *
	 * @param dto IGSMR11DTO
	 * @return IGSMR11DTO
	 */
	public IGSMR11DTO managerIGSMR1104Action(IGSMR11DTO dto) throws BLException {
		//formȡ��
		IGSMR1103Form form = dto.getIgSMR1103Form();
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
