package com.deliverik.infogovernor.scheduling.jobs;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.TriggerKey;

import java.util.List;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0101Form;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessParticipantBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCondImpl;

public class DailyWorkPlanJob implements Job {

    private static Log log = LogFactory.getLog(DailyWorkPlanJob.class);
  
    //流程处理BL
  	private static WorkFlowOperationBL workFlowOperationBL = (WorkFlowOperationBL) WebApplicationSupport.getBean("workFlowOperationBL");

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	TriggerKey key = context.getTrigger().getKey();
        log.info("from DailyWorkPlanJob triggerName = " + key.getName());
        String prid = String.valueOf(context.getJobDetail().getJobDataMap().get("prid"));
		context.getJobDetail().getJobDataMap().clear();
		
        IGPRR01BL prr01BL = (IGPRR01BL) WebApplicationSupport.getBean("igPRR01BL");
        QuartzProcessRecordBL quartzPRBL = (QuartzProcessRecordBL) WebApplicationSupport.getBean("quartzProcessRecordBL");
        QuartzProcessInfoBL quzrtzInfoBL = (QuartzProcessInfoBL) WebApplicationSupport.getBean("quartzProcessInfoBL");
        QuartzProcessParticipantBL quzrtzppBL = (QuartzProcessParticipantBL)WebApplicationSupport.getBean("quartzProcessParticipantBL");
        UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
        // 流程信息
        QuartzProcessRecord  qpr = quartzPRBL.findByPK(Integer.parseInt(prid));
        IGPRR01DTO dto = new IGPRR01DTO();
        IGPRR0101Form igPRR0101Form = new IGPRR0101Form();
        igPRR0101Form.setPrid(Integer.parseInt(prid));
        igPRR0101Form.setAction("10");
        igPRR0101Form.setPrtype(qpr.getQprtype());
        igPRR0101Form.setPrtitle(qpr.getQprtitle());
        igPRR0101Form.setPrdesc(qpr.getQprdesc());
        igPRR0101Form.setPruserid(qpr.getQpruserid());
        igPRR0101Form.setPrusername(qpr.getQprusername());
        igPRR0101Form.setPrroleid(qpr.getQprroleid());
        igPRR0101Form.setPrrolename(qpr.getQprrolename());
        igPRR0101Form.setPrpdid(qpr.getQprpdid());
        igPRR0101Form.setPrpdname(qpr.getQprpdname());
        igPRR0101Form.setProrgid(qpr.getQprorgid());
        igPRR0101Form.setProrgname(qpr.getQprorgname());
        igPRR0101Form.setPrinfo(qpr.getQprinfo());
        // Qpropentime字段存放psdid
        igPRR0101Form.setPsdid(qpr.getQpropentime());
        // 流程表单信息
        QuartzProcessInfoSearchCondImpl qpInfoCond = new QuartzProcessInfoSearchCondImpl();
        qpInfoCond.setQprid(Integer.parseInt(prid));
        List<QuartzProcessInfo> qpInfoList = quzrtzInfoBL.searchQuartzProcessInfos(qpInfoCond, 0, 0);
        int i  = 0;
        String Pivarlabel[]= new String[qpInfoList.size()];
        String Pivarname[]= new String[qpInfoList.size()];
        String Pivartype[]= new String[qpInfoList.size()];
        String Pivarvalue[]= new String[qpInfoList.size()];
        String Pidid[]= new String[qpInfoList.size()];
        String Pidmode[]= new String[qpInfoList.size()];
        String Pidaccess[]= new String[qpInfoList.size()];
        String Privatescope[]= new String[qpInfoList.size()];
        String Pidcomment[]= new String[qpInfoList.size()];
        for (QuartzProcessInfo quartzProcessInfo : qpInfoList) {
        	Pivarlabel[i] = quartzProcessInfo.getQpivarlabel();
            Pivarname[i] = quartzProcessInfo.getQpivarname();
            Pivartype[i] = quartzProcessInfo.getQpivartype();
            Pivarvalue[i] = quartzProcessInfo.getQpivarvalue();
            Pidid[i] = quartzProcessInfo.getQpidid();
            Pidmode[i] = quartzProcessInfo.getQpidmode();
            Pidaccess[i] = quartzProcessInfo.getQpidaccess();
            Privatescope[i] = quartzProcessInfo.getQprivatescope();
            Pidcomment[i] = quartzProcessInfo.getQpidcomment();
        	i++;
		}
        
        igPRR0101Form.setPivarlabel(Pivarlabel);
    	igPRR0101Form.setPivarname(Pivarname);
    	igPRR0101Form.setPivartype(Pivartype);
    	igPRR0101Form.setPivarvalue(Pivarvalue);
    	igPRR0101Form.setPidid(Pidid);
    	igPRR0101Form.setPidmode(Pidmode);
    	igPRR0101Form.setPidaccess(Pidaccess);
    	igPRR0101Form.setPrivatescope(Privatescope);
    	igPRR0101Form.setPidcomment(Pidcomment);
    	
    	QuartzProcessParticipantSearchCondImpl ppcond = new QuartzProcessParticipantSearchCondImpl();
    	ppcond.setQprid(Integer.parseInt(prid));
    	List<QuartzProcessParticipant> ppList = quzrtzppBL.searchProcessParticipant(ppcond, 0, 0);
    	// 人员表单信息
    	int j  = 0;
        String par_userid[]= new String[ppList.size()];
        String par_username[]= new String[ppList.size()];
        String par_orgid[]= new String[ppList.size()];
        String par_orgname[]=new String[ppList.size()];
        Integer par_roleid[]= new Integer[ppList.size()];
        String par_rolename[]= new String[ppList.size()];
        String par_pidid[]= new String[ppList.size()];
        String par_phone[]= new String[ppList.size()];
    	for (QuartzProcessParticipant quartzpp : ppList) {
    		par_userid[j]= quartzpp.getQppuserid();
            par_username[j]= quartzpp.getQppusername();
            par_orgid[j]= quartzpp.getQpporgid();
            par_orgname[j]=quartzpp.getQpporgname();
            par_roleid[j]= quartzpp.getQpproleid();
            par_rolename[j]= quartzpp.getQpprolename();
            par_pidid[j]= quartzpp.getQppcomment();
            par_phone[j]= quartzpp.getQppuserinfo();
            j++;
		}
    	igPRR0101Form.setPar_userid(par_userid);
    	igPRR0101Form.setPar_username(par_username);
    	igPRR0101Form.setPar_orgid(par_orgid);
    	igPRR0101Form.setPar_orgname(par_orgname);
    	igPRR0101Form.setPar_roleid(par_roleid);
    	igPRR0101Form.setPar_rolename(par_rolename);
    	igPRR0101Form.setPar_pidid(par_pidid);
    	igPRR0101Form.setPar_phone(par_phone);
        
        dto.setIgPRR0101Form(igPRR0101Form);
        try {
        	User user = userBL.searchUserByKey(qpr.getQpruserid());
			dto.setUser(user);
			IGPRR01DTO igPrr01DTO = prr01BL.createProcessAction(dto);
			//获取流程日志信息
			IG036SearchCondImpl cond036 = new IG036SearchCondImpl();
			cond036.setPrid(igPrr01DTO.getPrid());//流程ID
			cond036.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//处理日志
			//根据用户角色查找角色日志
			List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond036);
			
			IG036TB ig036TB = (IG036TB)lst_IG036Info.get(0);
			
			ig036TB.setRlattkey(qpr.getQprattkey());
			//增加流程日志信息
			workFlowOperationBL.updateRecordLog(ig036TB);
			
		} catch (BLException e) {
			log.debug(e.getMessage());
		}
    }

}