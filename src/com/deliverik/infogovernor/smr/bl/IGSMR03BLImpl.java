/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.igflow.api.Constants;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.SuspendProcess;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.scheduling.jobs.JobManager;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportDetailBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.bl.task.RemindConfigureBL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0302Form;
import com.deliverik.infogovernor.smr.form.IGSMR0303Form;
import com.deliverik.infogovernor.smr.form.IGSMR0304Form;
import com.deliverik.infogovernor.smr.job.IGSMR0301JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0302JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0303JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0304JOB;
import com.deliverik.infogovernor.smr.job.IGSMR0305JOB;
import com.deliverik.infogovernor.smr.job.IGSMRJOBCONSTANTS;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportDetailInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;
import com.deliverik.infogovernor.smr.model.ReportHistorySearchVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportDetailSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RemindConfigureSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;
import com.deliverik.infogovernor.smr.model.entity.RegulatoryReportInstanceTB;
import com.deliverik.infogovernor.smr.model.entity.RemindConfigureTB;
import com.deliverik.infogovernor.smr.model.entity.ReportHistorySearchVW;

/**
 * ����:�ҵ�����걨����ѯ 
 * �����������ҵ�����걨����ѯ 
 * �����ˣ�����͢
 * ������¼�� 2013-07-25
 * �޸ļ�¼��
 */
public class IGSMR03BLImpl extends BaseBLImpl implements IGSMR03BL {
	
	private static Log log = LogFactory.getLog(IGSMR03BLImpl.class);
	
	/**�걨��ѯBL*/
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;

	/**���̴���BL*/
	protected FlowOptBL flowOptBL;
	
	/**��ϵ��BL*/
	protected RegulatoryReportDetailBL regulatoryReportDetailBL;
	
	/**���̱�BL*/
	protected IG500BL ig500BL;
	
	/**��������BL*/
	protected FlowSetBL flowSetBL;
	
	/**���Ͷ���BL*/
	protected SendMessageBL sendMessageBL;
	
	/**�û���ɫBL*/
	protected UserRoleBL userRoleBL;
	
	/**������BL*/
	protected IG337BL ig337BL;
	
	/**����״̬BL*/
	protected IG333BL ig333BL;
	
	/**���ѱ�������BL*/
	protected RemindConfigureBL remindConfigureBL;
	
	/**��ֵbl*/
	protected IG599BL ig599BL;
	

	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}

	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}
	
	public void setRegulatoryReportDetailBL(
			RegulatoryReportDetailBL regulatoryReportDetailBL) {
		this.regulatoryReportDetailBL = regulatoryReportDetailBL;
	}

	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	
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

	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	/**
	 * ��ѯ��Ҫ�Ҵ�����걨
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO needMeManagerAction(IGSMR03DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
		//��ѯ��Ҫ�Ҵ�����걨
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ���������걨˵��Ϊ����ÿ������Ϊֵ��map����
		Map<String,List<AnnualReportVW>> map_arq = new LinkedHashMap<String, List<AnnualReportVW>>();
		//������ѯ����ļ���
		for(AnnualReportVWInfo info:list_arq){
			//�ж������map�����Ƿ����ĳһ���ײ�����
			if(map_arq.get(info.getReportdesc())==null){
				//����һ����ʱlist����
				List<AnnualReportVW> secondList = new ArrayList<AnnualReportVW>();
				 //�õ�ʵ��
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
				//��ѭ������ʵ��Ž���ʱ��������
				secondList.add(tb);
				//����ʱ����list�Ž�map����
				map_arq.put(info.getReportdesc(),secondList);
			}else{
				 //�õ�ʵ��
			    AnnualReportVW tb = (AnnualReportVW)SerializationUtils.clone(info);
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
	public IGSMR03DTO reportExamineAction(IGSMR03DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
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
	 * ��ѯ�걨����
	 *
	 */
	public IGSMR03DTO AnnualreportExamineAction(IGSMR03DTO dto) {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//����ǰ��¼�ߵ�userid�Ž�cond��
		cond.setUserid(dto.getUser().getUserid());
		//���걨���������ͷŽ�cond��
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
		//������״̬���Ž�cond��
		cond.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_SECONDEXAMINE);
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
	 * ��鿴
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO seeFillInAction(IGSMR03DTO dto) throws BLException {
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//���form����ݲ�Ϊ�գ�����ݷŽ�cond��
		if(StringUtils.isNotEmpty(dto.getIgSMR0302Form().getYear())){
			cond.setKey_eq(dto.getIgSMR0302Form().getYear());
		}
		cond.setPrtype(IGSMRCONSTANT.PRYTPE_REPORT);
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
				//��ѭ������ʵ��Ž���ʱ��������
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
	 * @throws BLException 
	 *
	 */
	public IGSMR03DTO stopFillInAction(IGSMR03DTO dto) throws BLException {
		//formȡ��
		IGSMR0302Form form = dto.getIgSMR0302Form();
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
	public IGSMR03DTO pressAction(IGSMR03DTO dto) throws BLException {
		//�õ�form
		IGSMR0302Form form = dto.getIgSMR0302Form();
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
					if(StringUtils.isNotEmpty(pp.getPpuserid())){	
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
	 * ��������ʱ��
	 *
	 */
	public IGSMR03DTO setCautionTimeAction(IGSMR03DTO dto) throws BLException {
		//formȡ��
		IGSMR0303Form form = dto.getIgSMR0303Form();
		//ʵ������ѯ��������ѯ�Ƿ�����һ���͵ı���������Ϣ
		RemindConfigureSearchCondImpl cond = new RemindConfigureSearchCondImpl();
		cond.setRctype(form.getRctype());
		cond.setRcyear(IGStringUtils.getCurrentYear());
		//��ѯ�Ƿ��е�ǰ���������͵ı�������
		List<RemindConfigureInfo> list_rc = remindConfigureBL.searchRemindConfigure(cond);
		//���û�е�ǰ���������͵ı������ã������²�������͵ı������ã��趨quarz
		if(list_rc==null||list_rc.size()<=0){
			//ʵ����ʵ��
			RemindConfigureTB tb = new RemindConfigureTB();
			tb.setRcyear(IGStringUtils.getCurrentYear());
			tb.setRctype(form.getRctype());
			tb.setRcmonth(form.getRcmonth());
			tb.setRcday(form.getRcday());
			remindConfigureBL.registRemindConfigure(tb);
			//�趨�����·�
			String month ="";
			if("0".equals(form.getRcmonth().substring(0,1))){
				month = form.getRcmonth().substring(1,2);
			}else{
				month = form.getRcmonth();
			}
			//�趨����
			String day ="";
			if("0".equals(form.getRcday().substring(0,1))){
				day = form.getRcday().substring(1,2);
			}else{
				day =form.getRcday(); 
			}
			//�趨����ʱ��
			String TRIGGER = "0 0 "+IGSMRCONSTANT.MOMENT+" "+day+" "+month+" ?";
			if("1".equals(form.getRctype())){				
				//�趨�걨quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP,
							new IGSMR0301JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("2".equals(form.getRctype())){
				//�趨һ���ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP,
							new IGSMR0302JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("3".equals(form.getRctype())){
				//�趨�����ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP,
							new IGSMR0303JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("4".equals(form.getRctype())){
				//�趨�����ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP,
							new IGSMR0304JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("5".equals(form.getRctype())){
				//�趨�ļ��ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP,
							new IGSMR0305JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}

		}else{
			//�������ϵõ�ʵ��
			for(RemindConfigureInfo rc :list_rc){
				RemindConfigureTB rtb = (RemindConfigureTB)SerializationUtils.clone(rc);
				//���·ݺ��ոı�
				rtb.setRcmonth(form.getRcmonth());
				rtb.setRcday(form.getRcday());
				//�ı�ʱ��
				remindConfigureBL.updateRemindConfigure(rtb);				
			}
			//�趨�����·�
			String month ="";
			if("0".equals(form.getRcmonth().substring(0,1))){
				month = form.getRcmonth().substring(1,2);
			}else{
				month = form.getRcmonth();
			}
			//�趨����
			String day ="";
			if("0".equals(form.getRcday().substring(0,1))){
				day = form.getRcday().substring(1,2);
			}else{
				day =form.getRcday(); 
			}
			//�趨����ʱ��
			String TRIGGER = "0 0 "+IGSMRCONSTANT.MOMENT+" "+day+" "+month+" ?";
			if("1".equals(form.getRctype())){				
				//�趨�걨quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP,
							new IGSMR0301JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("2".equals(form.getRctype())){
				//�趨һ���ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP,
							new IGSMR0302JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("3".equals(form.getRctype())){
				//�趨�����ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP,
							new IGSMR0303JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("4".equals(form.getRctype())){
				//�趨�����ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP,
							new IGSMR0304JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}else if("5".equals(form.getRctype())){
				//�趨�ļ��ȼ���quarz
				try {
					if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
						JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
								IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
					}
					JobManager.addJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP,
							new IGSMR0305JOB(), TRIGGER);
				} catch (Exception e) {		
					log.error("",e);
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I001") );
		return dto;
	}
	/**
	 * �������ʱ��
	 *
	 */
	@SuppressWarnings("null")
	public IGSMR03DTO eliminateCautionTimeAction(IGSMR03DTO dto)
			throws BLException {
		//formȡ��
		IGSMR0303Form form = dto.getIgSMR0303Form();
		//ʵ������ѯ��������ѯ�Ƿ�����һ���͵ı���������Ϣ
		RemindConfigureSearchCondImpl cond = new RemindConfigureSearchCondImpl();
		cond.setRctype(form.getRctype());
		cond.setRcyear(IGStringUtils.getCurrentYear());
		//��ѯ�Ƿ��е�ǰ���������͵ı�������
		List<RemindConfigureInfo> list_rc = remindConfigureBL.searchRemindConfigure(cond);
		//�����������������ã������Ƴ���quarz����
		if(list_rc!=null||list_rc.size()>0){
			for(RemindConfigureInfo info :list_rc){
				remindConfigureBL.deleteRemindConfigure(info);
				if("1".equals(form.getRctype())){				
					//�趨�걨quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("2".equals(form.getRctype())){
					//�趨һ���ȼ���quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("3".equals(form.getRctype())){
					//�趨�����ȼ���quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("4".equals(form.getRctype())){
					//�趨�����ȼ���quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}else if("5".equals(form.getRctype())){
					//�趨�ļ��ȼ���quarz
					try {
						if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
							JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
									IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
						}
						
					} catch (Exception e) {		
						log.error("",e);
					}
				}
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I002") );
		return dto;
	}
	/**
	 * ����ʱ���ѯ
	 *
	 */
	public IGSMR03DTO searchCautionTimeAction(IGSMR03DTO dto)
			throws BLException {
		//��ѯ��ǰ����걨����
		//ʵ������ѯ����
		RemindConfigureSearchCondImpl cond_year = new RemindConfigureSearchCondImpl();
		//����ǰ��Ž�cond��
		cond_year.setRcyear(IGStringUtils.getCurrentYear());
		//�������ͷŽ�cond��
		cond_year.setRctype("1");
		//��ѯ�걨����
		List<RemindConfigureInfo> list_year =remindConfigureBL.searchRemindConfigure(cond_year);
		//ѭ������¼ȡ���Ž�dto��
		for(RemindConfigureInfo rc:list_year){
			dto.setRc(rc);
			break;
		}
		//��ѯһ���ȼ�������ʱ��
		//ʵ������ѯ����
		RemindConfigureSearchCondImpl cond_rc1 = new RemindConfigureSearchCondImpl();
		//����ǰ��Ž�cond��
		cond_rc1.setRcyear(IGStringUtils.getCurrentYear());
		//�������ͷŽ�cond��
		cond_rc1.setRctype("2");
		//��ѯ�걨����
		List<RemindConfigureInfo> list_rc1 =remindConfigureBL.searchRemindConfigure(cond_rc1);
		//ѭ������¼ȡ���Ž�dto��
		for(RemindConfigureInfo rc1:list_rc1){
			dto.setRc1(rc1);
			break;
		}
		//��ѯ�����ȼ�������ʱ��
		//ʵ������ѯ����
		RemindConfigureSearchCondImpl cond_rc2 = new RemindConfigureSearchCondImpl();
		//����ǰ��Ž�cond��
		cond_rc2.setRcyear(IGStringUtils.getCurrentYear());
		//�������ͷŽ�cond��
		cond_rc2.setRctype("3");
		//��ѯ�걨����
		List<RemindConfigureInfo> list_rc2 =remindConfigureBL.searchRemindConfigure(cond_rc2);
		//ѭ������¼ȡ���Ž�dto��
		for(RemindConfigureInfo rc2:list_rc2){
			dto.setRc2(rc2);
			break;
		}
		//��ѯ�����ȼ�������ʱ��
		//ʵ������ѯ����
		RemindConfigureSearchCondImpl cond_rc3 = new RemindConfigureSearchCondImpl();
		//����ǰ��Ž�cond��
		cond_rc3.setRcyear(IGStringUtils.getCurrentYear());
		//�������ͷŽ�cond��
		cond_rc3.setRctype("4");
		//��ѯ�걨����
		List<RemindConfigureInfo> list_rc3 =remindConfigureBL.searchRemindConfigure(cond_rc3);
		//ѭ������¼ȡ���Ž�dto��
		for(RemindConfigureInfo rc3:list_rc3){
			dto.setRc3(rc3);
			break;
		}			
		//��ѯ�ļ��ȼ�������ʱ��
		//ʵ������ѯ����
		RemindConfigureSearchCondImpl cond_rc4 = new RemindConfigureSearchCondImpl();
		//����ǰ��Ž�cond��
		cond_rc4.setRcyear(IGStringUtils.getCurrentYear());
		//�������ͷŽ�cond��
		cond_rc4.setRctype("5");
		//��ѯ�걨����
		List<RemindConfigureInfo> list_rc4 =remindConfigureBL.searchRemindConfigure(cond_rc4);
		//ѭ������¼ȡ���Ž�dto��
		for(RemindConfigureInfo rc4:list_rc4){
			dto.setRc4(rc4);
			break;
		}	
		return dto;
	}
	/**
	 * ��ֹ����ʱ��
	 *
	 */
	public IGSMR03DTO stopCautionTimeAction(IGSMR03DTO dto) throws BLException {
		//formȡ��
		IGSMR0303Form form = dto.getIgSMR0303Form();
		if("1".equals(form.getRctype())){				
			//�趨�걨quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.YEAR_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("2".equals(form.getRctype())){
			//�趨һ���ȼ���quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER1_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("3".equals(form.getRctype())){
			//�趨�����ȼ���quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER2_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("4".equals(form.getRctype())){
			//�趨�����ȼ���quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER3_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}else if("5".equals(form.getRctype())){
			//�趨�ļ��ȼ���quarz
			try {
				if(JobManager.isJobAdded(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP)) {
					JobManager.removeJob(IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_GROUP,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI,
							IGSMRJOBCONSTANTS.QUARTER4_TIMING_REMIND_TRI_GROUP);
				}
				
			} catch (Exception e) {		
				log.error("",e);
			}
		}
		dto.addMessage(new ActionMessage( "IGSMR0301.I003") );
		return dto;
	}
	
	/**
	 * �����ҳ��ת��������ҵĹ���
	 *
	 */
	public IGSMR03DTO init0304Action(IGSMR03DTO dto) throws BLException {
		//��ѯ��ǰ���������ҵ����б�������
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		//�������ǵ�ǰ������
		cond.setUserid(dto.getUser().getUserid());
		List<AnnualReportVWInfo> list_arq = regulatoryReportInstanceBL.findAnnualReportByCond(cond,0,0);
		//�����ϱ���������걨˵��Ϊ����ÿ������Ϊֵ��map����
		Map<String,List<AnnualReportVW>> map_more = new LinkedHashMap<String, List<AnnualReportVW>>();
		//������ѯ����ļ���
		for(AnnualReportVWInfo info:list_arq){
			AnnualReportVW ar = (AnnualReportVW)SerializationUtils.clone(info);
			//�ж������map�����Ƿ����ĳһ���ײ�����
			if(map_more.get(info.getReportdesc())==null){
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
				map_more.put(info.getReportdesc(),secondList);
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
				map_more.get(info.getReportdesc()).add(ar);
			}
		}
		dto.setMap_more(map_more);
		return dto;
	}
	
	/**
	 * ͨ�ò�ѯ 
	 *
	 */
	public IGSMR03DTO init0305Action(IGSMR03DTO dto) throws BLException {
		//formȡ��
		IGSMR0304Form form = dto.getIgsmr0304Form();
		//ʵ������ѯ����
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setPrtype(form.getPrtype());
		cond.setPrtitle(form.getPrtitle());
		cond.setPropentime(form.getPrstarttime());
		cond.setProclosetime(form.getPrclosetime());
		//Ŀ����Ϣ��ѯ����ȡ�� 
		int totalCount = this.regulatoryReportInstanceBL.findReportHistoryCount(cond);
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<ReportHistorySearchVWInfo> list_all = regulatoryReportInstanceBL.findReportHistory(cond, pDto.getFromCount(), pDto.getPageDispCount());
		//�½�һ��������˺ͱ��������˵ļ���
		List<ReportHistorySearchVW> list_rhs = new ArrayList<ReportHistorySearchVW>();
		//�������������˺ͱ���������
		for(ReportHistorySearchVWInfo info:list_all){
			ReportHistorySearchVW tb = (ReportHistorySearchVW)SerializationUtils.clone(info);
			//�������
			String fillinusername ="";
			//�������״̬��ʶ��
			String fillincode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(info.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
			cond337.setPrid(info.getPrid());
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
			tb.setFillinname(fillinusername);
			//���屨��������
			String examineusername = "";
			//���屨���״̬��ʶ��
			String examinecode = "";
			//��״̬���в�ѯ״̬��
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(info.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//ʵ���������߲�ѯ����
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
			cond_ig337.setPrid(info.getPrid());
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
			tb.setReportapprovename(examineusername);
			list_rhs.add(tb);
		}
		
		pDto.setTotalCount(totalCount);
		dto.setList_rhs(list_rhs);
		return dto;
	}

}
