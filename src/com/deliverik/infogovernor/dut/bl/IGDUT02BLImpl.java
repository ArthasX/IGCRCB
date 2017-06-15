/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditDefBL;
import com.deliverik.infogovernor.dut.bl.task.DutyAuditTimeBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPersonBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPlanBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultVWBL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0202Form;
import com.deliverik.infogovernor.dut.form.IGDUT0203Form;
import com.deliverik.infogovernor.dut.form.IGDUT0204Form;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.form.IGDUT0207Form;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyPersonSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultVWSearchCondImpl;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;
import com.deliverik.infogovernor.dut.model.entity.DutyPlanTB;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * ֵ�����ҵ���߼�ʵ��
 *
 */
public class IGDUT02BLImpl extends BaseBLImpl implements IGDUT02BL {

	static Log log = LogFactory.getLog(IGDUT02BLImpl.class);
	/** CodeListUtils */
	protected CodeListUtils codeListUtils;
	
	/** ֵ��������BL */
	protected DutyResultBL dutyResultBL;
	
	/** ֵ��ƻ�BL */
	protected DutyPlanBL dutyPlanBL;
	
	/** ֵ����BL */
	protected DutyPersonBL dutyPersonBL;
	
	/** �û���ɫBL */
	protected UserRoleBL userRoleBL;
	
	/** �û�BL */
	protected UserBL userBL;
	
	
	/** ֵ������BL */
	protected DutyAuditDefBL dutyAuditDefBL;
	
	/** ֵ����ʱ��BL */
	protected DutyAuditTimeBL dutyAuditTimeBL;

	/** ֵ���ձ���ͼBL */
	protected DutyResultVWBL dutyResultVWBL;
	
	
	
	/**
	 * ֵ���ձ���ͼBL
	 * @param dutyResultVWBL the dutyResultVWBL to set
	 */
	public void setDutyResultVWBL(DutyResultVWBL dutyResultVWBL) {
		this.dutyResultVWBL = dutyResultVWBL;
	}

	/**
	 *  ֵ������BL
	 * @param dutyAuditDefBL ֵ������BL
	 */
	public void setDutyAuditDefBL(DutyAuditDefBL dutyAuditDefBL) {
		this.dutyAuditDefBL = dutyAuditDefBL;
	}

	/**
	 *  ֵ����ʱ��BL
	 * @param dutyAuditTimeBL ֵ����ʱ��BL
	 */
	public void setDutyAuditTimeBL(DutyAuditTimeBL dutyAuditTimeBL) {
		this.dutyAuditTimeBL = dutyAuditTimeBL;
	}
	
	/**
	 *  ֵ��������BL�趨
	 * @param dutyResultBL ֵ��������BL
	 */
	public void setDutyResultBL(DutyResultBL dutyResultBL) {
		this.dutyResultBL = dutyResultBL;
	}
	
	/**
	 *  ֵ����ƻ�BL�趨
	 * @param dutyPlanBL ֵ����ƻ�BL
	 */
	public void setDutyPlanBL(DutyPlanBL dutyPlanBL) {
		this.dutyPlanBL = dutyPlanBL;
	}
	
	/**
	 *  ֵ����BL�趨
	 * @param dutyPersonBL ֵ����BL
	 */
	public void setDutyPersonBL(DutyPersonBL dutyPersonBL) {
		this.dutyPersonBL = dutyPersonBL;
	}
	
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	/**
	 *  �û�BL�趨
	 * @param userBL �û�BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * CodeListUtils
	 * @param codeListUtils
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}

	/**
	 * ֵ�ཻ����ϸ��Ϣ��ѯ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0204Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ�ཻ����ϸ��Ϣ��ѯ����ʼ========");
		//��ѯִ���мƻ�
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		//û��ִ���мƻ���ʾ��ʾ��Ϣ
		if(dutyPlanList.size() != 1 ) {
			throw new BLException("IGDUT0205.E003"); 
		} else {
			List<DutyPersonTB> dutyPersonList = dutyPlanList.get(0).getDutyPersonList();
			//�жϵ�¼�û��Ƿ���ֵ����
			boolean flag = true;
			StringBuffer usersinfo = new StringBuffer();
			for(DutyPerson dp : dutyPersonList) {
				if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
					flag = false;
				}
				usersinfo.append(dp.getDperusername()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
			}
			if(flag) {
				throw new BLException("IGDUT0204.E001"); 
			}
			//����ձ��Ƿ���δ�����
			DutyResultSearchCondImpl drCond = new DutyResultSearchCondImpl();
			drCond.setDpid(dutyPlanList.get(0).getDpid());
			drCond.setIsNullDrcontent("yes");
			int size = this.dutyResultBL.getSearchCount(drCond);
			if(size > 0) {
				dto.addMessage(new ActionMessage("IGDUT0204.W001"));
				dto.setHasNullDrcontent("1");
			}
			
			//ֵ������
			String date = dutyPlanList.get(0).getDptime();
			//�װ�/ҹ��
			String type = dutyPlanList.get(0).getDptype();
			//�жϽӰ�ƻ��Ƿ����
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			cond.setDadcategory(dutyPlanList.get(0).getDadcategory());
			//�װ���ҹ�࣬ҹ���ҵڶ���İװ�
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(type)) {
				cond.setDptime(date);
				cond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			} else if(IGDUTCONSTANTS.NIGHT_SHIFT.equals(type)) {
				SimpleDateFormat df = new SimpleDateFormat(
	            "yyyy/MM/dd");
				Calendar c = Calendar.getInstance();
		        try {
					c.setTime(df.parse(date));
				} catch (ParseException e) {
					log.debug("����ƻ����ڸ�ʽ����ȷ��" + date);
					throw new BLException("IGDUT0204.E003",date);
				}
		        c.add(Calendar.DATE, 1);
				cond.setDptime(df.format(c.getTime()));
				cond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			} else {
				throw new BLException("IGCO10000.E004","ֵ��ʱ��");
			}
			List<DutyPlan> list = this.dutyPlanBL.searchDutyPlan(cond, 0, 0);
			if(list.isEmpty()) {
				throw new BLException("IGDUT0204.E002");
			} else if(list.size() != 1){
				throw new BLException("IGDUT0205.E001" ,list.size() + "");
			} else {
				dto.getIgDUT0204Form().setDpid_unexecute(list.get(0).getDpid());
			}
			//��ѯִ����ֵ��ƻ���Ϣ
			DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
			dutyResultCond.setDpid(dutyPlanList.get(0).getDpid());
			List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(dutyResultCond, 0, 0);
			if(dutyResultList.isEmpty()) {
				throw new BLException("IGCO10000.E004","ֵ���ձ�����"); 
			}
			dto.setDutyResultList(dutyResultList);
			dto.setUsersinfo(usersinfo.toString());
			dto.setDutyPlan(dutyPlanList.get(0));
		}
		log.debug("========ֵ�ཻ����ϸ��Ϣ��ѯ�������========");
		return dto;
	}
	
	/**
	 * ֵ�ཻ��ȷ����Ϣ��ѯ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0205Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ�ཻ��ȷ����Ϣ��ѯ����ʼ========");
		IGDUT0204Form form = dto.getIgDUT0204Form();
		//��ѯ�Ӱ�ƻ�
		DutyPlan dp = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_unexecute());
		//û�нӰ�ƻ���ʾ��ʾ��Ϣ
		List<DutyPersonTB> dutyPersonList = dp.getDutyPersonList();
		if(dutyPersonList.isEmpty()) {
			throw new BLException("IGCO10000.E004","�Ӱ��˻���");
		}
		String[] password = new String[dutyPersonList.size()];
		form.setPassword(password);
		dto.setDutyPersonList(dutyPersonList);
		log.debug("========ֵ�ཻ��ȷ����Ϣ��ѯ�������========");
		return dto;
	}
	
	/**
	 * ֵ�ཻ��ȷ�ϴ���
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO confirmIGDUT0205Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ�ཻ��ȷ�ϴ���ʼ========");
		IGDUT0204Form form = dto.getIgDUT0204Form();
		String[] userids = form.getUserid();
		String[] passwords = form.getPassword();
		int i = 0;
		if(userids != null && passwords != null) {
			for(String userid : userids) {
				//�û������ 
				User user = this.userBL.searchUserByKey(userid);
				
				if (!user.getPassword().equals(passwords[i++])){
					log.debug("========�û���¼ʧ��(���벻��ȷ)========");
					//���벻��ȷ
					throw new BLException("IGDUT0205.E002",user.getUsername());
				}
			}
		}
		//����ƻ����
		DutyPlan dp_executing = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_executing());
		//����
		DutyPlanTB dp_executing_tb = (DutyPlanTB)SerializationUtils.clone(dp_executing);
		//������
		dp_executing_tb.setDpuserid(dto.getUser().getUserid());
		dp_executing_tb.setDpusername(dto.getUser().getUsername());
		//��������
		dp_executing_tb.setDpquestion(form.getDpquestion());
		//�ܽ�
		dp_executing_tb.setDpinfo(form.getDpinfo());
		//״̬��Ϊ��ִ��
		dp_executing_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTED);
		//���ʱ��
		dp_executing_tb.setDpfintime(IGStringUtils.getCurrentDateTime());
		//����
		dutyPlanBL.updateDutyPlan(dp_executing_tb);
		
		//�Ӱ�ƻ���ʼ
		DutyPlan dp_unexecute = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_unexecute());
		DutyPlanTB dp_unexecute_tb = (DutyPlanTB)SerializationUtils.clone(dp_unexecute);
		//״̬��Ϊִ����
		dp_unexecute_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		//����
		this.dutyPlanBL.updateDutyPlan(dp_unexecute_tb);
		dto.addMessage(new ActionMessage("IGDUT0205.I001"));
		log.debug("========ֵ�ཻ��ȷ�ϴ������========");
		return dto;
	}
	
	/**
	 * ֵ����ֹ��ϸ��Ϣ��ѯ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0207Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ����ֹ��ϸ��Ϣ��ѯ����ʼ========");
		//��ѯִ���мƻ�
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		//û��ִ���мƻ���ʾ��ʾ��Ϣ
		if(dutyPlanList.size() < 1 ) {
			throw new BLException("IGDUT0205.E003"); 
		} else {
			List<DutyPersonTB> dutyPersonList = dutyPlanList.get(0).getDutyPersonList();
			//�жϵ�¼�û��Ƿ���ֵ����
			//boolean flag = true;
			StringBuffer usersinfo = new StringBuffer();
			for(DutyPerson dp : dutyPersonList) {
				if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
					//flag = false;
				}
				usersinfo.append(dp.getDperusername()).append("&nbsp;&nbsp;&nbsp;&nbsp;");
			}
//			if(flag) {
//				throw new BLException("IGDUT0204.E001"); 
//			}
			//��ѯִ����ֵ��ƻ���Ϣ
			DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
			dutyResultCond.setDpid(dutyPlanList.get(0).getDpid());
			List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(dutyResultCond, 0, 0);
//			if(dutyResultList.isEmpty()) {
//				throw new BLException("IGCO10000.E004","ֵ���ձ�����"); 
//			}
			dto.setDutyResultList(dutyResultList);
			dto.setUsersinfo(usersinfo.toString());
			dto.setDutyPlan(dutyPlanList.get(0));
		}
		log.debug("========ֵ����ֹ��ϸ��Ϣ��ѯ�������========");
		return dto;
	}
	
	/**
	 * ֵ����ֹ����
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO terminateIGDUT0207Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ����ֹ����ʼ========");
		IGDUT0207Form form = dto.getIgDUT0207Form();
		//����ƻ����
		DutyPlan dp_executing = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid_executing());
		//����
		DutyPlanTB dp_executing_tb = (DutyPlanTB)SerializationUtils.clone(dp_executing);
		//������
		dp_executing_tb.setDpuserid(dto.getUser().getUserid());
		dp_executing_tb.setDpusername(dto.getUser().getUsername());
		//��������
		dp_executing_tb.setDpquestion(form.getDpquestion());
		//�ܽ�
		dp_executing_tb.setDpinfo(form.getDpinfo());
		//״̬��Ϊ��ֹ
		dp_executing_tb.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_TERMINATE);
		//���ʱ��
		dp_executing_tb.setDpfintime(IGStringUtils.getCurrentDateTime());
		//����
		dutyPlanBL.updateDutyPlan(dp_executing_tb);
		
		dto.addMessage(new ActionMessage("IGDUT0207.I001"));
		log.debug("========ֵ����ֹ�������========");
		return dto;
	}

	public IGDUT02DTO initIGDUT0202Action(IGDUT02DTO dto) throws BLException {
		UserRoleVWSearchCondImpl userRoleVWcond = new UserRoleVWSearchCondImpl();
		userRoleVWcond.setRoletype(IGDUTCONSTANTS.USER_ROLE_TYPE);
		List<UserRoleInfo> userRoleInfoList = userRoleBL.searchUserRoleVW(userRoleVWcond, 0, 0);
		List<UserRoleInfo> dayShiftUsers = new ArrayList<UserRoleInfo>(); 
		List<UserRoleInfo> nightShiftUsers = new ArrayList<UserRoleInfo>(); 
		List<String> tempList = new ArrayList<String>(); 
		for (UserRoleInfo userRoleInfo : userRoleInfoList) {
			if(tempList.contains(userRoleInfo.getUserid())){				
				continue;
			}
			dayShiftUsers.add(userRoleInfo);
			nightShiftUsers.add(userRoleInfo);
			tempList.add(userRoleInfo.getUserid());
		}
		List<UserRoleInfo> dayShiftDutyUsers = new ArrayList<UserRoleInfo>(); 
		List<UserRoleInfo> nightShiftDutyUsers = new ArrayList<UserRoleInfo>(); 
		List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dto.getDutyPlanSearchCond(), 0, 0);
		for (DutyPlan dutyPlan : dutyPlanList) {
			Integer dpid = dutyPlan.getDpid();
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){ //�װ�
				DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
				dutyPersonCond.setDpid(dpid);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					String dayShiftUserId = dutyPerson.getDperuserid();
					for (UserRoleInfo user : dayShiftUsers) {
						if(dayShiftUserId.equals(user.getUserid())){
							dayShiftDutyUsers.add(user);
						}
					}
				}
			} else if(IGDUTCONSTANTS.NIGHT_SHIFT.equals(dutyPlan.getDptype())){ //ҹ��
				DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
				dutyPersonCond.setDpid(dpid);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					String nightShiftUserId = dutyPerson.getDperuserid();
					for (UserRoleInfo user : nightShiftUsers) {
						if(nightShiftUserId.equals(user.getUserid())){
							nightShiftDutyUsers.add(user);
						}
					}
				}
			}
		}
		dayShiftUsers.removeAll(dayShiftDutyUsers);
		nightShiftUsers.removeAll(nightShiftDutyUsers);
		dto.setDayShiftUsers(dayShiftUsers);
		dto.setNightShiftUsers(nightShiftUsers);
		dto.setDayShiftDutyUsers(dayShiftDutyUsers);
		dto.setNightShiftDutyUsers(nightShiftDutyUsers);
		return dto;
	}

	public IGDUT02DTO addDutyPersonAction(IGDUT02DTO dto) throws BLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String nowdate = sdf.format(System.currentTimeMillis());
		IGDUT0202Form igdut0202Form = dto.getIgdut0202Form();	
		DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
		dutyPlanCond.setDadcategory(igdut0202Form.getDadcategory());
		dutyPlanCond.setDptime(igdut0202Form.getDptime());
		dutyPlanCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
		List<DutyPlan> dayDutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		Integer dayDpid = null;
		Integer nightDpid = null;
		String[] dayShiftUserids = igdut0202Form.getDayShiftUserids();
		if(dayDutyPlanList.size() == 0 && dayShiftUserids != null){
			DutyPlanTB dutyPlanTB = new DutyPlanTB();
			dutyPlanTB.setDadcategory(igdut0202Form.getDadcategory());
			dutyPlanTB.setDpcretime(nowdate);
			dutyPlanTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			dutyPlanTB.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			dutyPlanTB.setDptime(igdut0202Form.getDptime());
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			dayDpid = retDutyPlan.getDpid();
		} else if(dayDutyPlanList.size() > 0 && dayShiftUserids != null){
			DutyPlanTB dutyPlanTB = (DutyPlanTB) dayDutyPlanList.get(0);
			dutyPlanTB.setDpupdtime(nowdate);
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			dayDpid = retDutyPlan.getDpid();
		}
		dutyPlanCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
		if(null != dayShiftUserids){
			for (String userid : dayShiftUserids) {
				DutyPersonTB dutyPersonTB = new DutyPersonTB();
				dutyPersonTB.setDperuserid(userid.split("__")[1].split(",,,,")[0]);
				dutyPersonTB.setDpertime(igdut0202Form.getDptime());
				dutyPersonTB.setDperusername(userid.split(",,,,")[1]);
				dutyPersonTB.setDpid(dayDpid);
				dutyPersonTB.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
				dutyPersonBL.registDutyPerson(dutyPersonTB);
			}
		}

		String[] nightShiftUserids = igdut0202Form.getNightShiftUserids();
		List<DutyPlan> nightDutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		if(nightDutyPlanList.size() == 0 && nightShiftUserids != null){
			DutyPlanTB dutyPlanTB = new DutyPlanTB();
			dutyPlanTB.setDadcategory(igdut0202Form.getDadcategory());
			dutyPlanTB.setDpcretime(nowdate);
			dutyPlanTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
			dutyPlanTB.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			dutyPlanTB.setDptime(igdut0202Form.getDptime());
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			nightDpid = retDutyPlan.getDpid();
		} else if(nightDutyPlanList.size() > 0 && nightShiftUserids != null){
			DutyPlanTB dutyPlanTB = (DutyPlanTB) nightDutyPlanList.get(0);
			dutyPlanTB.setDpupdtime(nowdate);
			DutyPlan retDutyPlan = dutyPlanBL.registDutyPlan(dutyPlanTB);
			nightDpid = retDutyPlan.getDpid();
		}
		if(null != nightShiftUserids){
			for (String userid : nightShiftUserids) {
				DutyPersonTB dutyPersonTB = new DutyPersonTB();
				dutyPersonTB.setDperuserid(userid.split("__")[1].split(",,,,")[0]);
				dutyPersonTB.setDpertime(igdut0202Form.getDptime());
				dutyPersonTB.setDperusername(userid.split(",,,,")[1]);
				dutyPersonTB.setDpid(nightDpid);
				dutyPersonTB.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
				dutyPersonBL.registDutyPerson(dutyPersonTB);
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I010","ֵ���˵���"));
		return dto;
	}

	public IGDUT02DTO removeDutyPersonAction(IGDUT02DTO dto) throws BLException {
		IGDUT0202Form igdut0202Form = dto.getIgdut0202Form();	
		String[] dayShiftDutyUserids = igdut0202Form.getDayShiftDutyUserids();
		String dadcategory = igdut0202Form.getDadcategory();
		String dptime = igdut0202Form.getDptime();
		if(null != dayShiftDutyUserids){		
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpertime(dptime);
			dutyPersonCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
			for (String userid : dayShiftDutyUserids) {
				dutyPersonCond.setDperuserid(userid.split("__")[1]);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					dutyPersonBL.deleteDutyPerson(dutyPerson.getDperid());
				}
			}
			dutyPersonCond.setDperuserid(null);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			if(dutyPersonList.size() == 0){
				DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
				dutyPlanCond.setDptime(dptime);
				dutyPlanCond.setDptype(IGDUTCONSTANTS.DAY_SHIFT);
				dutyPlanCond.setDadcategory(dadcategory);
				List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
				for (DutyPlan dutyPlan : dutyPlanList) {
					dutyPlanBL.deleteDutyPlan(dutyPlan.getDpid());
				}
			}
		}
		
		String[] nightShiftDutyUserids = igdut0202Form.getNightShiftDutyUserids();
		if(null != nightShiftDutyUserids){			
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpertime(igdut0202Form.getDptime());
			dutyPersonCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
			for (String userid : nightShiftDutyUserids) {
				dutyPersonCond.setDperuserid(userid.split("__")[1]);
				List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
				for (DutyPerson dutyPerson : dutyPersonList) {
					dutyPersonBL.deleteDutyPerson(dutyPerson.getDperid());
				}
			}
			
			dutyPersonCond.setDperuserid(null);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			if(dutyPersonList.size() == 0){
				DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
				dutyPlanCond.setDptime(dptime);
				dutyPlanCond.setDptype(IGDUTCONSTANTS.NIGHT_SHIFT);
				dutyPlanCond.setDadcategory(dadcategory);
				List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
				for (DutyPlan dutyPlan : dutyPlanList) {
					dutyPlanBL.deleteDutyPlan(dutyPlan.getDpid());
				}
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I010","ֵ���˵���"));
		return dto;
	}

	public IGDUT02DTO initIGDUT0201Action(IGDUT02DTO dto) throws BLException {
		int showYear = dto.getCalendarYear();
		int showMonth = dto.getCalendarMonth() + 1;
		Map<String,String> dutyUserMap = new HashMap<String,String>();
		String beginDate = showYear + "/" + appendZero(showMonth) + "/00";
		if (showMonth == 12) {
			showYear = showYear + 1;
			showMonth = 1;
		} else {
			showMonth++;
		}
		String endDate = showYear + "/" + appendZero(showMonth) + "/00";
		DutyPlanSearchCondImpl dutyPlanCond = new DutyPlanSearchCondImpl();
		dutyPlanCond.setDptime_ge(beginDate);
		dutyPlanCond.setDptime_le(endDate);
		dutyPlanCond.setDadcategory(dto.getIgdut0201Form().getDadcategory());
		List<DutyPlan> dutyPlanList = dutyPlanBL.searchDutyPlan(dutyPlanCond, 0, 0);
		List<Integer> dpidList = new ArrayList<Integer>();
		for (DutyPlan dutyPlan : dutyPlanList) {
			if(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING.equals(dutyPlan.getDpstatus())){ //ִ������
				dutyUserMap.put(dutyPlan.getDptime(), IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
				if(dutyPlan.getDptype().equals(IGDUTCONSTANTS.DAY_SHIFT)){ //�װ�
					dutyUserMap.put(dutyPlan.getDptime() + IGDUTCONSTANTS.DAY_SHIFT, IGDUTCONSTANTS.DAY_SHIFT);
				}
			} else if(IGDUTCONSTANTS.PLAN_STATUS_EXECUTED.equals(dutyPlan.getDpstatus())
					|| IGDUTCONSTANTS.PLAN_STATUS_TERMINATE.equals(dutyPlan.getDpstatus())){ //��ִ�У�ִ����ֹ
				if(dutyPlan.getDptype().equals(IGDUTCONSTANTS.NIGHT_SHIFT)){ //ҹ��
					dutyUserMap.put(dutyPlan.getDptime(), "34");
					dutyUserMap.put(dutyPlan.getDptime() + IGDUTCONSTANTS.NIGHT_SHIFT, IGDUTCONSTANTS.NIGHT_SHIFT);
				}
			}
			dpidList.add(dutyPlan.getDpid());
		}
		if(dutyPlanList.size() > 0){			
			DutyPersonSearchCondImpl dutyPersonCond = new DutyPersonSearchCondImpl();
			dutyPersonCond.setDpidList(dpidList);
			List<DutyPerson> dutyPersonList = dutyPersonBL.searchDutyPerson(dutyPersonCond, 0, 0);
			for (DutyPerson dutyPerson : dutyPersonList) {
				String key = dutyPerson.getDptype() + "_" + dutyPerson.getDpertime();
				String value = dutyPerson.getDperusername();
				if(dutyUserMap.containsKey(key)){
					dutyUserMap.put(key, dutyUserMap.get(key) + "," + value);
				} else {
					dutyUserMap.put(key, value);
				}
			}
		}
		dto.setDutyUserMap(dutyUserMap);
		return dto;
	}
	
	private String appendZero(int arg){
		if(arg < 10){
			return "0" + arg;
		}
		return String.valueOf(arg);
	}
	
	/**
	 * ֵ���ձ���ʼ������
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO initIGDUT0203Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ���ձ���ʼ������ʼ========");
		IGDUT0203Form form = dto.getIgDUT0203Form();
		if(form!=null){
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);//״̬
			cond.setDadcategory(form.getDadcategory());//����
			List<DutyPlan> planlist = dutyPlanBL.searchDutyPlan(cond, 0, 0);
			//����ֵ��ƻ�ʱ
			if(planlist!=null && planlist.size()==1){
				DutyPlan dutyPlan = planlist.get(0);
				dto.setDutyPlan(dutyPlan);//ֵ��ƻ�
				
				DutyPersonSearchCondImpl cond1 = new DutyPersonSearchCondImpl();
				cond1.setDpid(dutyPlan.getDpid());
				List<DutyPerson> personList = dutyPersonBL.searchDutyPerson(cond1, 0, 0);
				
				//�жϵ�¼�û��Ƿ���ֵ����
				boolean flag = true;
				StringBuffer buff = new StringBuffer();
				for(DutyPerson dp : personList) {
					if(dp.getDperuserid().equals(dto.getUser().getUserid())) {
						flag = false;
					}
					buff.append(dp.getDperusername()).append("&nbsp;&nbsp;");
				}
				if(flag) {
					throw new BLException("IGDUT0203.E001"); 
				}
				dto.setDptype(dutyPlan.getDptype());//ֵ��ʱ��
				dto.setUsersinfo(buff.toString());//ֵ����
				dto.setDpremarks(dutyPlan.getDpremarks());
		
				//��ѯ��ǰֵ��ƻ��µ�ֵ���ձ���Ϣ
				DutyResultVWSearchCondImpl vwcond = new DutyResultVWSearchCondImpl();
				//�װ�ʱ��
				String daytime_from = codeListUtils.getCodeValue(CodeDefine.DAYSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"001"));
				String daytime_to = codeListUtils.getCodeValue(CodeDefine.DAYSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"002"));
				//ҹ��ʱ��
				String nighttime_from = codeListUtils.getCodeValue(CodeDefine.NIGHTSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"001"));
				String nighttime_to = codeListUtils.getCodeValue(CodeDefine.NIGHTSHIFT_DUTY_PERIOD.getCcid(), "", "",(form.getDadcategory()+"002"));
				//���ý��Ӱ�ʱ��
				dto.setNightStartTime(nighttime_from);
				
				//��ǰΪ�װ�ʱ
				if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
					vwcond.setDattime_form(daytime_from);
					vwcond.setDattime_to(daytime_to);
					vwcond.setDattime_q(null);
				}else{
					//��ǰΪҹ��ʱ
					vwcond.setDattime_form(nighttime_from);
					vwcond.setDattime_to(nighttime_to);
					vwcond.setDattime_q("1");
				}

				vwcond.setDadcategory(form.getDadcategory());
				List<DutyResultVWInfo> vwlist = dutyResultVWBL.searchDutyResultVW(vwcond, 0, 0);
				if(vwlist!=null && vwlist.size()>0){
					Map<String,List<DutyResultVWInfo>> typeMap = new LinkedHashMap<String, List<DutyResultVWInfo>>();
					List<String>  dadtypeList = new ArrayList<String>();//�����༯��
					List<Integer> dridList = new ArrayList<Integer>();//ֵ���ձ�ID����
					List<String> showList = new ArrayList<String>();//ֵ���ձ������ѡ���ʶ 0����ѡ 1��ѡ
					List<String> showResultList = new ArrayList<String>();//���˵���Ƿ�ɱ༭
					for(DutyResultVWInfo vw:vwlist){
						if(!dadtypeList.contains(vw.getDadtype())){
							dadtypeList.add(vw.getDadtype());
						}
						if(vw.getDrid()!=null && vw.getDrid()!=0){
							if(!dridList.contains(vw.getDrid())){
								dridList.add(vw.getDrid());
							}
						}
					}
					dto.setDridList(dridList);//ֵ���ձ�ID����
					dto.setNum(vwlist.size());
					String dateTime=IGStringUtils.getCurrentDate();
					String week="";
					String month=dateTime.split("/")[2];
					String quarter=dateTime.substring(5);
					String[] weekDays = {"������", "����һ", "���ڶ�", "������", "������", "������", "������"};
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Calendar cal = Calendar.getInstance();
			        try {
						cal.setTime(sdf.parse(dateTime));
					} catch (Exception e) {
						log.debug(e.getMessage());
					}
			        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
			        week=weekDays[w];
					//����ѯ�������������з���
					for(String type:dadtypeList){
						List<DutyResultVWInfo> typeList = new ArrayList<DutyResultVWInfo>();
						for(DutyResultVWInfo vw:vwlist){
							if(vw.getDadtype()!=null && vw.getDadtype().equals(type)){
								if("week".equalsIgnoreCase(vw.getPeriodType())){
									//��������Ϊ����
									if(week.equalsIgnoreCase(vw.getPeriodValue())){
										typeList.add(vw);
									}
								}else if("month".equalsIgnoreCase(vw.getPeriodType())){
									//����������Ϊ����
									if(month.equalsIgnoreCase(vw.getPeriodValue())){
										typeList.add(vw);
									}
								}else if("quarter".equalsIgnoreCase(vw.getPeriodType())){
									//����������Ϊ����
									if(vw.getPeriodValue().contains(quarter)){
										typeList.add(vw);
									}
								}else{
									//����������Ϊ����
									typeList.add(vw);
								}
								
							}
						}
						for(DutyResultVWInfo vw:typeList){
							//��ȡ������Ƿ��ѡ��
							getShowList(dto,vw,showList,showResultList);
						}
						typeMap.put(type, typeList);//tab��ͷ,datalist
						
					}
					dto.setShowList(showList);
					dto.setShowResultList(showResultList);
					dto.setTypeMap(typeMap);
				}else{
					//dto.addMessage(new ActionMessage("IGDUT0203.I001"));
					throw new BLException("IGDUT0203.E003"); 
				}

			}else{
				//������ִ���е�ֵ��ƻ�
				throw new BLException("IGDUT0203.E002"); 
			}
		}
		log.debug("========ֵ���ձ���ʼ���������========");
		return dto;
	}
	
	/**
	 * ��ȡ������Ƿ��ѡ��
	 * @param dto
	 * @param vw
	 * @return
	 */
	@SuppressWarnings("static-access")
	private void getShowList(IGDUT02DTO dto, DutyResultVWInfo vw,
			List<String> showList, List<String> showResultList) {
		//��ȡ���ƻ�
		DutyPlan dutyPlan=dto.getDutyPlan();
		//��ȡ��ǰϵͳʱ��
		String nowtime=IGStringUtils.getCurrentDateTime();
		//ѡ��������ļ�¼��������ѡ��
		if(StringUtils.isNotEmpty(vw.getDrcontent())){
			//����ѡ��
			showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
			//��ǰΪ�װ�ʱ
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
				String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
				// �����ʱ����ڵ��ڵ�ǰϵͳʱ��ʱ����ѡ��
				if(dattime.compareTo(nowtime) >=0){
					//����ѡ��
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
				}else {
					//��ѡ��
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
				}
			}else{
				//��ǰΪҹ��ʱ
				//��ǰ���ʱ����ڵ��ڽ��Ӱ�ʱ��
				if(vw.getDattime().compareTo(dto.getNightStartTime())>=0){
					String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
					// �����ʱ����ڵ�ǰϵͳʱ��ʱ����ѡ��
					if(dattime.compareTo(nowtime) >=0){
						//����ѡ��
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//��ѡ��
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}else{
					//��ǰ���ʱ��С�ڽ��Ӱ�ʱ��
					DateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
					Calendar calendar = new GregorianCalendar();
					try {
						// ���õ�ǰʱ��
						calendar.setTime(f1.parse(dutyPlan.getDptime()));
					} catch (ParseException e) {
						// ���쳣
					}
					calendar.add(calendar.DATE, 1);
					String date=f1.format(calendar.getTime());
					String dattime=date+" "+vw.getDattime();
					//�����ʱ����ڵ�ǰϵͳʱ��ʱ����ѡ��
					if(dattime.compareTo(nowtime) >=0){
						//����ѡ��
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//��ѡ��
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}
			}
		}else{
			//��ǰΪ�װ�ʱ
			if(IGDUTCONSTANTS.DAY_SHIFT.equals(dutyPlan.getDptype())){
				String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
				// �����ʱ����ڵ��ڵ�ǰϵͳʱ��ʱ����ѡ��
				if(dattime.compareTo(nowtime) >=0){
					//����ѡ��
					showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
				}else {
					//��ѡ��
					showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
				}
			}else{
				//��ǰΪҹ��ʱ
				//��ǰ���ʱ����ڵ��ڽ��Ӱ�ʱ��
				if(vw.getDattime().compareTo(dto.getNightStartTime())>=0){
					String dattime=dutyPlan.getDptime()+" "+vw.getDattime();
					// �����ʱ����ڵ�ǰϵͳʱ��ʱ����ѡ��
					if(dattime.compareTo(nowtime) >=0){
						//����ѡ��
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//��ѡ��
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}else{
					//��ǰ���ʱ��С�ڽ��Ӱ�ʱ��
					DateFormat f1 = new SimpleDateFormat("yyyy/MM/dd");
					Calendar calendar = new GregorianCalendar();
					try {
						// ���õ�ǰʱ��
						calendar.setTime(f1.parse(dutyPlan.getDptime()));
					} catch (ParseException e) {
						// ���쳣
					}
					calendar.add(calendar.DATE, 1);
					String date=f1.format(calendar.getTime());
					String dattime=date+" "+vw.getDattime();
					//�����ʱ����ڵ�ǰϵͳʱ��ʱ����ѡ��
					if(dattime.compareTo(nowtime) >=0){
						//����ѡ��
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_DISABLE);
					}else {
						//��ѡ��
						showList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
						showResultList.add(IGDUTCONSTANTS.DADCONTENT_SHOW_ABLE);
					}
				}
			}
			
		}
	}

	
	/**
	 * ֵ���ձ����洦��
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO insertIGDUT0203Action(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ���ձ����洦��ʼ========");
		IGDUT0203Form form = dto.getIgDUT0203Form();
		User user = dto.getUser();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd;HH:mm");
		if(form!=null){
			DutyPlan dutyPlan = form.getDutyPlan();
			Integer[] dadids = form.getDadids();//�����ID
			String[] dadtypes = form.getDadtypes();//������
			String[] dadnames = form.getDadnames();//�������
			String[] dattimes = form.getDattimes();//���ʱ��
			//String[] datlimtimes = form.getDatlimtimes();//�ʱ������
			String[] dadcontents = form.getDadcontents();//���������
			String[] dadlimtimes = form.getDadlimtimes();//����ʱ��
			//List<Integer> dridList = form.getDridList();//ֵ���ձ�id����
			//String[] dadcontenttypes_hides = form.getDadcontenttypes_hides();//drcontent���ر�
			
			//ҳ������
			String[] dadcontenttypes = form.getDadcontenttypes();//�����(drcontent,ҳ��ѡ��)
			String[] drfilltimes = form.getDrfilltimes();//ʵ���ʱ��
			String[] drresults = form.getDrresults();//���˵��
			if(dadids!=null && dadids.length>0){
					int num=0;
					List<DutyResult> dutyResultList=new ArrayList<DutyResult>();
					for(int i=0;i< dadids.length;i++){
						DutyResultSearchCondImpl cond=new DutyResultSearchCondImpl();
						cond.setDpid(dutyPlan.getDpid());
						cond.setDadid(dadids[i]);
						cond.setDattime(dattimes[i]);
						//����ֵ�����͡�������ѯ�ձ���Ϣ
						List<DutyResult> dutyResultInfoList=this.dutyResultBL.searchDutyResult(cond, 0, 0);
						if(dutyResultInfoList!=null&&dutyResultInfoList.size()>0){
							for(DutyResult dutyResult:dutyResultInfoList){
								DutyResultTB dutyResultTB=(DutyResultTB) SerializationUtils.clone(dutyResult);
								if(StringUtils.isNotEmpty(dutyResultTB.getDrcontent())){
									dutyResultTB.setDrresult(drresults[num]);
								}else if(StringUtils.isNotEmpty(dadcontenttypes[num])){
									dutyResultTB.setDrcontent(StringUtils.isEmpty(dadcontenttypes[num])?"":dadcontenttypes[num]);//�����
									dutyResultTB.setDrresult(StringUtils.isEmpty(drresults[num])?"":drresults[num]);
									dutyResultTB.setDrfilltime(IGStringUtils.getCurrentDateTime().split(" ")[1]);//ʵ���ʱ��
									dutyResultTB.setDrcretime(IGStringUtils.getCurrentDateTime());//�������дʱ��
									dutyResultTB.setDruserid(user.getUserid());
									dutyResultTB.setDrusername(user.getUsername());
								}
								dutyResultList.add(dutyResultTB);
							}
						}else{
							DutyResultTB drtb = new DutyResultTB();
							drtb.setDpid(dutyPlan.getDpid());
							drtb.setDadid(dadids[num]);
							drtb.setDadtype(StringUtils.isEmpty(dadtypes[num])?"":dadtypes[num]);
							drtb.setDadname(StringUtils.isEmpty(dadnames[num])?"":dadnames[num]);
							drtb.setDptime(dutyPlan.getDptime());
							drtb.setDptype(dutyPlan.getDptype());
							drtb.setDattime(StringUtils.isEmpty(dattimes[num])?"":dattimes[num]);
							drtb.setDadcontent(StringUtils.isEmpty(dadcontents[num])?"":dadcontents[num]);
							drtb.setDrcontent(StringUtils.isEmpty(dadcontenttypes[num])?"":dadcontenttypes[num]);//�����
							drtb.setDrresult(StringUtils.isEmpty(drresults[num])?"":drresults[num]);
							
							drtb.setDadcategory(form.getDadcategory());//ֵ������
							
							//��ա�ʱ���Ƽ���
							String hour = dattimes[num].split(":")[0];
							String min = dattimes[num].split(":")[1];
							Calendar c = Calendar.getInstance();
							c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH), Integer.valueOf(hour), 
									Integer.valueOf(min));
							if(StringUtils.isNotEmpty(dadlimtimes[num])){
								c.add(Calendar.MINUTE, Integer.valueOf(dadlimtimes[num]));//����ʱ��
							}
							drtb.setDrlimdtime(sdf.format(c.getTime()));//����ʱ������
							drtb.setDatlimtime(sdf1.format(c.getTime()).split(";")[1]);//�ʱ������
							//���ҳ�����ѡ����Ҫ����ʱ��
							if(StringUtils.isNotEmpty(dadcontenttypes[num])){
								if(StringUtils.isEmpty(drfilltimes[num])){
									//��ʵ���ʱ��Ϊ��ʱ ��������ʱ��
									drtb.setDrfilltime(IGStringUtils.getCurrentDateTime().split(" ")[1]);//ʵ���ʱ��
									drtb.setDrcretime(IGStringUtils.getCurrentDateTime());//�������дʱ��
									drtb.setDruserid(user.getUserid());
									drtb.setDrusername(user.getUsername());
								}
							}
							dutyResultList.add(drtb);
						}
						num++;
					}
					//ѭ�����¼����
					for(DutyResult dutyResultInfo:dutyResultList){
						dutyResultBL.registDutyResult(dutyResultInfo);
					}
				// update by yagyyining start
				// ���Ӽƻ���ע
				DutyPlanTB dp = (DutyPlanTB) SerializationUtils.clone(dutyPlanBL.searchDutyPlanByKey(dutyPlan.getDpid()));
				dp.setDpremarks(form.getDpremarks());
				dutyPlanBL.registDutyPlan(dp);
				// update by yangyining end
					
			}
			
		}

		log.debug("========ֵ���ձ����洦�����========");
		return dto;
	}



	
	/**
	 * δִ��ֵ��ƻ���Ϣ��ѯ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGDUT02DTO searchDutyPlanAction(IGDUT02DTO dto) throws BLException {

		log.debug("========δִ��ֵ��ƻ���Ϣ��ѯ����ʼ========");
		
		//�����б��ʼ
		DutyPlanSearchCondImpl co = new DutyPlanSearchCondImpl();
		co.setDadcategory(dto.getIgDUT0206Form().getDadcategory());
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		
		//ֵ��ʱ������
		co.setDptime(IGStringUtils.getCurrentDate());
		
		//У���Ƿ���ִ���е�ֵ��ƻ�
		int exStatus = this.dutyPlanBL.getSearchCount(co);
		if (exStatus > 0) {
			log.debug("========ִ����ֵ��ƻ�����========");
			List<DutyPlan> dayDutyPlanList = this.dutyPlanBL.searchDutyPlan(co, 0, 0);
			DutyPlanTB dutyPlanTB = (DutyPlanTB) dayDutyPlanList.get(0);
			//�װ�/ҹ��
			String oldPassword = codeListUtils.getCodeValue(CodeDefine.DUTY_PLANTYPE.getCcid(), "", "", dutyPlanTB.getDptype());

			//��������ֵ��ƻ�������
			throw new BLException("IGDUT0206.E001", dutyPlanTB.getDptime(), oldPassword, dutyPlanTB.getDutyPersonName()); 
		} 

		//״̬��ֹ
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_TERMINATE);
		//ֵ�����ͣ����
		co.setDptype("2");
		
		int totalCount1 = this.dutyPlanBL.getSearchCount(co);
		
		if (totalCount1 > 0) {
			log.debug("========����ֵ��ƻ�����ֹ========");
			//����ֵ��ƻ�����ֹ
			dto.addMessage(new ActionMessage("IGDUT0205.E004"));
			return dto;
		} 
		//״̬δִ��
		co.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_UNEXECUTE);
		//ֵ������
		co.setDptype("");
		
		int totalCount = this.dutyPlanBL.getSearchCount(co);
		
		if (totalCount == 0) {
			log.debug("========δִ��ֵ��ƻ���Ϣ��ѯ���ݲ�����========");
			//δִ��ֵ��ƻ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGDUT0206.E002"));
			return dto;
		} 
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========δִ��ֵ��ƻ���Ϣ���ݼ�������========");
			//δִ��ֵ��ƻ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//����ֻ��ѯ�����ֵ��ƻ�
		co.setDptime_le(null);
		co.setDptime(IGStringUtils.getCurrentDate());

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ��Ϣȡ��
		List<DutyPlan> dutyPlanList = this.dutyPlanBL.searchDutyPlan(co, pDto.getFromCount(), pDto.getPageDispCount());

		
		pDto.setTotalCount(totalCount);
		
		dto.setDutyPlanList(dutyPlanList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========δִ��ֵ��ƻ���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * ֵ��ƻ���������
	 *
	 * @param dto IGDUT02DTO
	 * @return IGDUT02DTO
	 */
	public IGDUT02DTO changeDutyPlanAction(IGDUT02DTO dto) throws BLException {
		log.debug("========ֵ��״̬�ر�/���ô���ʼ========");
		IGDUT0206Form form = dto.getIgDUT0206Form();
		
		DutyPlan rai = this.dutyPlanBL.searchDutyPlanByKey(form.getDpid());
		
		//���ƶ���
		DutyPlanTB pdTB = (DutyPlanTB)SerializationUtils.clone(rai);
		//ִ����״̬
		pdTB.setDpstatus(IGDUTCONSTANTS.PLAN_STATUS_EXECUTING);
		log.debug("========����========");
		dto.addMessage(new ActionMessage( "IGDUT0206.I001", "") );
		
		this.dutyPlanBL.updateDutyPlan(pdTB);
		log.debug("========ֵ��ƻ�������������========");
		return dto;
	}
}
