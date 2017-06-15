/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.scheduling.bl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.SendMessageBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG731TB;
import com.deliverik.framework.workflow.prr.bl.task.IG036BL;
import com.deliverik.framework.workflow.prr.bl.task.IG113BL;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG036TB;
import com.deliverik.framework.workflow.prr.model.entity.IG113TB;
import com.deliverik.framework.workflow.prr.model.entity.IG337TB;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.mtp.bl.IGMTP01BLType;
import com.deliverik.infogovernor.mtp.bl.task.QuartzJobDetailsBL;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;
import com.deliverik.infogovernor.mtp.model.condition.QuartzJobDetailsSearchCondImpl;
import com.deliverik.infogovernor.mtp.model.entity.QuartzJobDetailsTB;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzJobsBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessInfoBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessParticipantBL;
import com.deliverik.infogovernor.scheduling.bl.task.QuartzProcessRecordBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH05DTO;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessParticipant;
import com.deliverik.infogovernor.scheduling.model.QuartzProcessRecord;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessInfoSearchCondImpl;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzProcessParticipantSearchCondImpl;

/**
 * <p>
 * ��������ά�ƻ���ʱ����
 * </p>
 * <p>
 * ����: ��ά�ƻ��Զ������̷���
 * </p>
 * <p>
 * ����: ��ʢ�	2010-12-9
 * </p>
 */
public class IGSCH05BLImpl extends BaseBLImpl implements IGSCH05BL {
	
	static Log log = LogFactory.getLog(IGSCH05BLImpl.class);
	
	/** ��ɫ����BL */
	protected RoleBL roleBL;
	
	/** �û���ɫ����BL */
	protected UserRoleBL userRoleBL;
	
	/** ���Ͷ��Ŵ���BL */
	protected SendMessageBL sendMessageBL;
	
	/** ������Ϣ����BL */
	protected IG500BL ig500BL;
	
	/** ���̱����崦��BL */
	protected IG007BL ig007BL;
	
	/** ���̱�����BL */
	protected IG599BL ig599BL;
	
	/** ���̲�����Ա����BL */
	protected IG337BL ig337BL;
	
	/** ����ģ�崦��BL */
	protected IG259BL ig259BL;
	
	/** �������ʹ���BL */
	protected IG380BL ig380BL;

	/** ����״̬���崦��BL */
	protected IG333BL ig333BL;
	
	/** ������־����BL */
	protected IG036BL ig036BL;
	
	/** ����״̬��־��Ϣ����BL */
	protected IG113BL ig113BL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;

	/** �ճ���ά�ƻ�����BL */
	protected QuartzJobsBL quartzJobsBL;
	
	/** �ճ���ά�ƻ���Ϣ����BL */
	protected QuartzJobDetailsBL quartzJobDetailsBL;
	
	/** ��ʱ�������̱�����BL */
	protected QuartzProcessInfoBL quartzProcessInfoBL;
	
	/** ��ʱ����������Ϣ����BL */
	protected QuartzProcessRecordBL quartzProcessRecordBL;
	
	/** ��ʱ�������̲�����Ա����BL */
	protected QuartzProcessParticipantBL quartzProcessParticipantBL;
	
	/**
	 * ����״̬��־��Ϣ����BL�趨
	 * @param ig113BL ����״̬��־��Ϣ����BL
	 */
	public void setIg113BL(IG113BL ig113BL) {
		this.ig113BL = ig113BL;
	}

	/**
	 * ����״̬���崦��BL�趨
	 * @param ig333BL ����״̬���崦��BL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}
	
	/**
	 * �û���ɫ����BL�趨
	 * @param userRoleBL �û���ɫ����BL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * �ճ���ά�ƻ���Ϣ����BL�趨
	 * @param quartzJobDetailsBL �ճ���ά�ƻ���Ϣ����BL
	 */
	public void setQuartzJobDetailsBL(QuartzJobDetailsBL quartzJobDetailsBL) {
		this.quartzJobDetailsBL = quartzJobDetailsBL;
	}
	
	/**
	 * ���Ͷ��Ŵ���BL�趨
	 * @param sendMessageBL ���Ͷ��Ŵ���BL
	 */
	public void setSendMessageBL(SendMessageBL sendMessageBL) {
		this.sendMessageBL = sendMessageBL;
	}

	/**
	 * ��ʱ�������̱�����BL�趨
	 * @param quartzProcessInfoBL ��ʱ�������̱�����BL
	 */
	public void setQuartzProcessInfoBL(QuartzProcessInfoBL quartzProcessInfoBL) {
		this.quartzProcessInfoBL = quartzProcessInfoBL;
	}

	/**
	 * ���̱�����BL�趨
	 * @param ig599BL ���̱�����BL
	 */
	public void setIg599BL(IG599BL ig599BL) {
		this.ig599BL = ig599BL;
	}

	/**
	 * �ճ���ά�ƻ�����BL�趨
	 * @param quartzJobsBL �ճ���ά�ƻ�����BL
	 */
	public void setQuartzJobsBL(QuartzJobsBL quartzJobsBL) {
		this.quartzJobsBL = quartzJobsBL;
	}

	/**
	 * ����ģ�崦��BL�趨
	 * @param ig259BL ����ģ�崦��BL
	 */
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}

	/**
	 * �������ʹ���BL�趨
	 * @param ig380BL �������ʹ���BL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	/**
	 * ���̱����崦��BL�趨
	 * @param ig007BL ���̱����崦��BL
	 */
	public void setIg007BL(IG007BL ig007BL) {
		this.ig007BL = ig007BL;
	}

	/**
	 * ������־����BL�趨
	 * @param ig036BL ������־����BL
	 */
	public void setIg036BL(IG036BL ig036BL) {
		this.ig036BL = ig036BL;
	}

	/**
	 * ��ʱ����������Ϣ����BL�趨
	 * @param quartzProcessRecordBL ��ʱ����������Ϣ����BL
	 */
	public void setQuartzProcessRecordBL(QuartzProcessRecordBL quartzProcessRecordBL) {
		this.quartzProcessRecordBL = quartzProcessRecordBL;
	}

	/**
	 * ��ʱ�������̲�����Ա����BL�趨
	 * @param workFlowOperationBL ��ʱ�������̲�����Ա����BL
	 */
	public void setQuartzProcessParticipantBL(
			QuartzProcessParticipantBL quartzProcessParticipantBL) {
		this.quartzProcessParticipantBL = quartzProcessParticipantBL;
	}
	
	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * ��ɫ����BL�趨
	 * @param roleBL ��ɫ����BL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * ������Ϣ����BL�趨
	 * @param ig500BL ������Ϣ����BL
	 */
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	/**
	 * ���̲�����Ա����BL�趨
	 * @param ig337BL ���̲�����Ա����BL
	 */
	public void setIg337BL(IG337BL ig337BL) {
		this.ig337BL = ig337BL;
	}


	/**
	 * <p>
	 * ����: ��ά�ƻ���ʱ������
	 * </p>
	 * <p>
	 * ����: IGSCH05DTO
	 * </p>
	 */
	public void init(IGSCH05DTO dto) throws BLException {
		
		//��ѯ������ϸ��Ϣ
		QuartzJobDetailsSearchCondImpl cond1 = new QuartzJobDetailsSearchCondImpl();
		cond1.setQjdtriname(dto.getTriggerName());
		List<QuartzJobDetails> qjdList = quartzJobDetailsBL.searchQuartzJobDetailsByCond(cond1,0,0);
		if(qjdList == null || qjdList.size() == 0){
			return;
		}

		QuartzJobs qj = quartzJobsBL.searchQuartzJobsByKey(qjdList.get(0).getQjid());
		if(qj == null){
			return;
		}
		QuartzJobs quartzJobs = qj;
		String qjtype = quartzJobs.getQjtype();
		if("S".equals(qjtype)){ //����
			String qjinfo = quartzJobs.getQjinfo();
			String userid = quartzJobs.getQjimpluser();
			sendMessageBL.sendSmsToUser(userid, qjinfo);
		} else if("W".equals(qjtype)){	//����
			String qjinfo = quartzJobs.getQjinfo();
			Integer qprid = Integer.valueOf(qjinfo);
			// quartz������Ϣȡ��
			QuartzProcessRecord quartzProcessRecord = quartzProcessRecordBL.findByPK(qprid);
			IG500TB prTB = this.copyProcessRecord(quartzProcessRecord);
			// ����������Ϣ
			IG500Info processRecord = ig500BL.registIG500Info(prTB);
			Integer prid = processRecord.getPrid();
			
			// ��������Ϣ
			UserTB userTB = new UserTB();
			userTB.setUserid(processRecord.getPruserid());
			userTB.setUsername(processRecord.getPrusername());
			userTB.setOrgid(processRecord.getProrgid());
			userTB.setOrgname(processRecord.getProrgname());
			
			// �����־
			addRecordLog(prid, userTB, prTB.getPrroleid(), processRecord.getPrdesc(), IGPRDCONSTANTS.PROCESS_INITIAL_MESSAGE, null, IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			
			// ��ѯquartz���̲�������Ϣ
			QuartzProcessParticipantSearchCondImpl pqqCond = new QuartzProcessParticipantSearchCondImpl();
			pqqCond.setQprid(qprid);
			List<QuartzProcessParticipant> qppList = quartzProcessParticipantBL.searchProcessParticipant(pqqCond, 0, 0);
			for (QuartzProcessParticipant quartzProcessParticipant : qppList) {
				IG337TB ppTB = this.copyProcessParticipant(quartzProcessParticipant);
				ppTB.setPrid(prid);
				// �����Ա
				addProcessParticipant(ppTB,userTB,ppTB.getPproleid(),"",IGPRDCONSTANTS.COMMENT_OPENER_MESSAGE,null,IGPRDCONSTANTS.RECORDLOG_TYPE_XTRZ);
			}
			
			// ��д�ύ��־
			IG036Info rl = this.addRecordLog(prid, userTB, processRecord.getPrroleid(), processRecord.getPrdesc(), IGPRDCONSTANTS.RLDESC_DATA, null,IGPRDCONSTANTS.RECORDLOG_TYPE_TJ);

			// ��ȡ����Ϣ
			List<IG599Info> prInfoList = new ArrayList<IG599Info>();
			QuartzProcessInfoSearchCondImpl qpiCond = new QuartzProcessInfoSearchCondImpl();
			qpiCond.setQprid(qprid);
			List<QuartzProcessInfo> qpiList = quartzProcessInfoBL.searchQuartzProcessInfos(qpiCond, 0, 0);
			for(QuartzProcessInfo qpi : qpiList){
				IG599Info pi = this.copyQuartzProcessInfo(qpi, prid);
				prInfoList.add(pi);
			}
			// ��ӱ�
			List<IG599Info> piList = ig599BL.saveOrUpdIG599Infos(prInfoList);
			
			// ���ӱ���־
			addRecordLogVarInfo(piList,rl);
			
			// ��һ�ڵ�id
			String psdid = this.ig333BL.getIG333InfoIdByStatus(processRecord.getPrpdid(), IGPRDCONSTANTS.PROCESS_START_STATUS);
			
			// ƥ��ԾǨ 
			workFlowOperationBL.checkAndTransition(userTB,psdid,processRecord.getPrroleid(),IGPRDCONSTANTS.BUTTON_SUBMIT,prid,piList);
		}
		
		//������ά�ƻ�����״̬Ϊ��ִ��
		QuartzJobDetailsTB qjdtb = (QuartzJobDetailsTB)SerializationUtils.clone(qjdList.get(0));
		qjdtb.setQjdtype(IGMTP01BLType.JOB_TYPE_EXECUTION);
		quartzJobDetailsBL.updateQuartzJobDetails(qjdtb);
		
	}
	
	/**
	 * ���ӱ���־��Ϣ
	 * 
	 * @param List<ProcessInfo> ���̱�����Ϣ����
	 * @param IG036Info	   ������־
	 * @return ����־�Ƿ񱣴�ɹ�
	 */
	public boolean addRecordLogVarInfo(List<IG599Info> prInfoList,IG036Info rl) throws BLException{
		
		boolean flag = true;//�������Ƿ����
		//�жϱ������Ƿ����
		if(prInfoList != null && !prInfoList.isEmpty()){
			Integer prid = rl.getPrid();
			for(IG599Info pi : prInfoList){
				String varvalue = pi.getPivarvalue();//�������������
				
				if(pi.getPivartype().equals("4")){  //�ʲ�
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_asset_")){
						varvalue = varvalue.split("_asset_")[1];
					}
				} else if(pi.getPivartype().equals("5")){  //����
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_svc_")){
						varvalue = varvalue.split("_svc_")[1].split("_name=")[1];
					}
				} else if(pi.getPivartype().equals("6")){  //��Ŀ
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_prj_")){
						varvalue = varvalue.split("_prj_")[1];
					}
				} else if(pi.getPivartype().equals("R")){  //��ɫ
					if(StringUtils.isNotEmpty(varvalue) && varvalue.contains("_role_")){
						varvalue = varvalue.split("_role_")[1];
					}
				}
				
				IG113TB rlvtb = new IG113TB();
				rlvtb.setPiattkey(pi.getPiattkey());
				rlvtb.setPidid(pi.getPidid());
				rlvtb.setPiid(pi.getPiid());
				rlvtb.setPivarlabel(pi.getPivarlabel());
				rlvtb.setPivarname(pi.getPivarname());
				rlvtb.setPivartype(pi.getPivartype());
				rlvtb.setPivarvalue(pi.getPivarvalue());
				rlvtb.setPrid(prid);
				rlvtb.setRlid(rl.getRlid());
				//���Ϊ�������ͱ�������ֵʱ�򱣴���ʾ����
				if(StringUtils.isNotEmpty(varvalue) && StringUtils.isNotEmpty(pi.getPivarvalue())){
					rlvtb.setPishowvarname(varvalue);
				}else{
					rlvtb.setPishowvarname("");
				}
				this.ig113BL.registIG113Info(rlvtb);
			}
		}else{
			flag = false;
		}

		return flag;
	}

	/**
	 * <p>
	 * ���̲���������
	 * </p>
	 * 
	 * @param processParticipant ��������Ϣ
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @return ��������Ϣ
	 * @throws BLException
	 *
	 */

	public IG337Info addProcessParticipant(IG337Info processParticipant,
			User user, Integer roleid, String comment, String desc, Map<Integer, FormFile> filemap,String type) throws BLException {
		processParticipant = ig337BL.registIG337Info(processParticipant);
		addRecordLog(processParticipant.getPrid(), user, roleid, comment, desc, null, type);
		return processParticipant;
	}

	/**
	 * <p>
	 * ��־����,roleidΪnull�򲻼�¼������ɫ����
	 * </p>
	 * 
	 * @param prid ����ID
	 * @param user ��ǰ��¼�û�
	 * @param roleid �����ɫID
	 * @param comment ��־����
	 * @param desc ��־����������Ϣ
	 * @param filemap ����
	 * @param type ��־���� 0ϵͳ��־��1��׼��2���أ�3�ύ��4��ֹ��5����
	 * @return ��������Ϣ
	 * @return ��־
	 * @throws BLException
	 *
	 */

	public IG036Info addRecordLog(Integer prid, User user, Integer roleid, String comment, String desc, String attkey,String type) throws BLException {
		IG036TB recordLog = new IG036TB();
		recordLog.setPrid(prid);
		recordLog.setRluserid(user.getUserid());
		recordLog.setRlusername(user.getUsername());
		recordLog.setRldesc(desc);
		recordLog.setRlcomment(comment);
		recordLog.setRltime(IGStringUtils.getCurrentDateTime());
		recordLog.setRltype(type);
		if(roleid != null && roleid > 0) {
			recordLog.setRoleid(roleid);
			Role role = roleBL.searchRoleByKey(roleid);
			recordLog.setRlrolename(role.getRolename());
		} else {
			recordLog.setRlrolename(WorkFlowConstDefine.UnspecifiedRoleName);
		}
		recordLog.setRlorgid(user.getOrgid());
		recordLog.setRlorgname(user.getOrgname());
		recordLog.setRlattkey(attkey);
		
		//��ѯ����
		IG500Info processRecord = ig500BL.searchIG500InfoByKey(prid);
		
		//��������״̬
		recordLog.setPsdcode(processRecord.getPrstatus());
		
		//��ѯ����״̬����
		IG333SearchCondImpl pscond = new IG333SearchCondImpl();
		pscond.setPdid(processRecord.getPrpdid());
		pscond.setPsdcode(processRecord.getPrstatus());
		List<IG333Info> psList = ig333BL.searchIG333Info(pscond);
		if(psList!=null && psList.size()>0){
			recordLog.setPsname(psList.get(0).getPsdname());
		}
		
		//�ж��Ƿ��ɫ������
		if(userRoleBL.checkRoleManagerByID(user.getUserid(),roleid)){
			//�ǽ�ɫ������
			recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
		}else{
			recordLog.setRolemanger(IGPRDCONSTANTS.NOT_ROLEMANAGER);
		}
		
		//�Ǿ���ɫ������ʱ�����ж��Ƿ��Ǳ������ύȨ�޵�ֵ����
		if(IGPRDCONSTANTS.NOT_ROLEMANAGER.equals(recordLog.getRolemanger())) {
			IG337SearchCondImpl cond = new IG337SearchCondImpl();
			cond.setPrid(prid);
			cond.setPpsubstatus(IGPRDCONSTANTS.DUTYPERSON_ACCESS);//��Ȩ��ʶ
			cond.setPproleid(roleid);
			cond.setPpuserid(user.getUserid());
			List<IG337Info> ppList = ig337BL.getIG337Infos(cond);
			for(IG337Info pp : ppList){
				//�Ƿ�ֵ����
				if(IGPRDCONSTANTS.DUTYPERSON.equals(pp.getPpdutyperson())) {
					//�ٶ�Ϊ��ɫ�����˱�ʶ
					recordLog.setRolemanger(IGPRDCONSTANTS.ROLEMANAGER);
				}
			}
		}
		
		return ig036BL.registIG036Info(recordLog);
	}
	protected IG599TB copyQuartzProcessInfo(QuartzProcessInfo qpi, int prid){
		IG599TB piTB = new IG599TB();
		piTB.setPivarlabel(qpi.getQpivarlabel());
		piTB.setPiattkey(qpi.getQpiattkey());
		piTB.setPivarname(qpi.getQpivarname());
		piTB.setPivartype(qpi.getQpivartype());
		piTB.setPivarvalue(qpi.getQpivarvalue());
		piTB.setPidid(qpi.getQpidid());
		piTB.setPrid(prid);
		return piTB;
	}
	
	protected IG731TB copyQuartzProcessInfoEntity(QuartzProcessInfoEntity qpie){
		IG731TB pieTB = new IG731TB();
		pieTB.setPrid(qpie.getQprid());
		pieTB.setPiid(qpie.getQpiid());
		pieTB.setEiid(qpie.getQeiid());
		return pieTB;
	}
	
	protected IG500TB copyProcessRecord(QuartzProcessRecord qpr){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG500TB prTB = new IG500TB();
		prTB.setPrassetid(qpr.getQprassetid());
		prTB.setPrassetname(qpr.getQprassetname());
		prTB.setPrbackplan(qpr.getQprbackplan());
		prTB.setPrbusiness(qpr.getQprbusiness());
		prTB.setPrclosetime(qpr.getQprclosetime());
		prTB.setPrdesc(qpr.getQprdesc());
		if(StringUtils.isNotEmpty(qpr.getQprduration())){
			prTB.setPrduration(sdf.format(System.currentTimeMillis() + 86400000 * Integer.valueOf(qpr.getQprduration().trim())));
		}else{
			prTB.setPrduration("");
		}
		
		prTB.setPrimpact(qpr.getQprimpact());
		prTB.setPrimplplan(qpr.getQprimplplan());
		prTB.setPropentime(today);
		prTB.setPrplantime(today);
		prTB.setPrstatus(qpr.getQprstatus());
		prTB.setPrsubstatus(qpr.getQprsubstatus());
		prTB.setPrtitle(qpr.getQprtitle());
		prTB.setPrtype(qpr.getQprtype());
		prTB.setPrurgency(qpr.getQprurgency());
		prTB.setPrvfyplan(qpr.getQprvfyplan());
		prTB.setPrinfo(qpr.getQprinfo());
		prTB.setPid(qpr.getQpid());
		prTB.setPcode(qpr.getQpcode());
		prTB.setPname(qpr.getQpname());
		prTB.setPrsubtype(qpr.getQprsubtype());
		prTB.setPrcortype(qpr.getQprcortype());
		prTB.setPrcorid(qpr.getQprcorid());
		prTB.setPrcortitle(qpr.getQprcortitle());
		prTB.setPrassetcategory(qpr.getQprassetcategory());
		prTB.setPrusername(qpr.getQprusername());
		prTB.setPrrolename(qpr.getQprrolename());
		prTB.setPruserid(qpr.getQpruserid());
		prTB.setPrroleid(qpr.getQprroleid());
		prTB.setPrpdid(qpr.getQprpdid());
		prTB.setPrpdname(qpr.getQprpdname());
		prTB.setProrgid(qpr.getQprorgid());
		prTB.setProrgname(qpr.getQprorgname());
		return prTB;
	}
	
	protected IG337TB copyProcessParticipant(QuartzProcessParticipant qpp){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		String today = sdf.format(System.currentTimeMillis());
		IG337TB ppTB = new IG337TB();
		ppTB.setPpattkey(qpp.getQppattkey());
		ppTB.setPpcomment(qpp.getQppcomment());
		if(qpp.getQppinittime() != null){
			ppTB.setPpinittime(today);
		}else{
			ppTB.setPpinittime(qpp.getQppinittime());
		}
		ppTB.setPporgid(qpp.getQpporgid());
		if(qpp.getQppproctime() != null){
			ppTB.setPpproctime(today);
		}else{
			ppTB.setPpproctime(qpp.getQppproctime());
		}
		ppTB.setPproleid(qpp.getQpproleid());
		ppTB.setPprolename(qpp.getQpprolename());
		ppTB.setPpstatus(qpp.getQppstatus());
		ppTB.setPptype(qpp.getQpptype());
		ppTB.setPpuserid(qpp.getQppuserid());
		ppTB.setPpusername(qpp.getQppusername());
		ppTB.setPpuserinfo(qpp.getQppuserinfo());
		ppTB.setPrid(qpp.getQprid());
		ppTB.setPporgname(qpp.getQpporgname());
		return ppTB;
	}
	public String getPeriodInfo(String periodType, String CustomDate, 
			String exeHour, String exeMinute,String startDate){
		String period = null;
		if("week".equals(periodType)){
			period = "��" + this.getWeekOfDate(startDate,null) + " ";
		} else if ("month".equals(periodType)){
			period = "��" + Integer.valueOf(startDate.split("/")[2]) + "��  ";
		} else if ("once".equals(periodType)){
			period = startDate + " " + exeHour + ":" + exeMinute;
			return period;
		}
		return "ÿ" + period + exeHour + ":" + exeMinute;
	}
	
	public String getWeekOfDate(String strDate,String language) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
        String[] engWeekDays = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        Calendar cal = Calendar.getInstance();
        try {
			cal.setTime(sdf.parse(strDate));
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        if("eng".equals(language)){
        	return engWeekDays[w];
        }
        return weekDays[w];
    }
	
}