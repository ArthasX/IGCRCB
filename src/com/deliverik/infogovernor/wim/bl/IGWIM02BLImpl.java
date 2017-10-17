/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.bl;

import java.awt.Color;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts.action.ActionMessage;
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.RoleBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.task.WorkDefinitionBL;
import com.deliverik.infogovernor.wim.bl.task.WorkInstanceBL;
import com.deliverik.infogovernor.wim.bl.task.WorkLogBL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCondImpl;
import com.deliverik.infogovernor.wim.model.condition.WorkLogSearchCondImpl;
import com.deliverik.infogovernor.wim.model.entity.WorkDefinitionTB;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;
import com.deliverik.infogovernor.wim.model.entity.WorkLogTB;
import com.deliverik.infogovernor.wim.utils.IGDateUtils;

/**
 * @Description ��������BLʵ�֣������ʹ�����־ҵ��ʵ����
 * 
 * @date 2017��6��14��13:42:31
 * 
 * @author zyl
 * @version 1.1
 * �Ĺ����ˣ�����°汾
 *
 */
public class IGWIM02BLImpl extends BaseBLImpl implements IGWIM02BL{
	
	static Log log = LogFactory.getLog(IGWIM02BLImpl.class);
	
	/** ���������BLע�� */
	protected WorkDefinitionBL workDefinitionBL;
	
	/** ����BLע�� */
	protected WorkInstanceBL workInstanceBL;
	
	/** ����BLע�� */
	protected OrganizationBL organizationBL;
	
	/** �û�BLע�� */
	protected UserBL userBL;
	
	/** ������־BLע�� */
	protected WorkLogBL workLogBL;
	
	/** �û���ɫBLע�� */
	protected UserRoleBL userRoleBL;
	
	/** ��ɫBLע�� */
	protected RoleBL roleBL;

	
	/**
	 * �趨 ��ɫBL
	 * 
	 * @param roleBL ��ɫBL
	 */
	public void setRoleBL(RoleBL roleBL) {
		this.roleBL = roleBL;
	}

	/**
	 * �趨 �û���ɫBL
	 * 
	 * @param userRoleBL �û���ɫBL
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}

	/**
	 * �趨 ������־BL
	 * 
	 * @param workLogBL ������־BL
	 */
	public void setWorkLogBL(WorkLogBL workLogBL) {
		this.workLogBL = workLogBL;
	}

	/**
	 * �û�BL�趨
	 * @param �û�����BL
	 */
	public void setUserBL(UserBL userBL) {
		this.userBL = userBL;
	}

	/**
	 * ����BL�趨
	 * @param ��������BL
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * ���������BL�趨
	 * @param ���������BL
	 */
	public void setWorkDefinitionBL(WorkDefinitionBL workDefinitionBL) {
		this.workDefinitionBL = workDefinitionBL;
	}
	
	/**
	 * ����BL�趨
	 * @param ����BL
	 */
	public void setWorkInstanceBL(WorkInstanceBL workInstanceBL) {
		this.workInstanceBL = workInstanceBL;
	}
	
	/**
	 * @Description ������ѯ��ͨ������ʱ�䣬�Ӷ���ȡ���ڵ��ܣ�չʾһ�ܵĹ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO getCurrentWorkByDateAction(IGWIM02DTO dto) throws BLException {
		log.info("=================������ѯչʾһ�ܵĹ�����ѯ����ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//����ʱ��
		String workDate = form.getWorkDate();
		//��Ա
		String userid = form.getUserid();
		//��һ�ν�ҳ��
		if(StringUtils.isEmpty(userid)&&StringUtils.isEmpty(workDate)){
			workDate = IGStringUtils.getCurrentDate();
//			userid = dto.getUser().getUserid();
		}
		//��ȡ����������
		List<String> dateToWeek = IGDateUtils.dateToWeekStr(workDate);
		dto.setDateList(dateToWeek);
		//��ȡ���������ڣ��꣩��2017/05/20��׼��ʽ,���ڱȽϡ������������
		List<String> dateToWeekYear = IGDateUtils.dateToWeekYear(workDate);
		dto.setDateToWeekYearList(dateToWeekYear);
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//���ò�ѯ����
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		cond.setUserid(userid);
		cond.setWorkDate(workDate);
		cond.setLogin_userid(dto.getUser().getUserid());
		cond.setOrgsyscoding(form.getOrgsyscoding());
		//��������
		int totalCount = workInstanceBL.findWeekWorkByCond(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========������������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========���������ݼ�������========");
			// �û��������ݼ�������
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//����BL��ѯ������Ϣ
		List<Map<String, String>> wiList = workInstanceBL.findWeekWorkByCond(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//�����ѯ�����
		dto.setWiList(wiList);
		//���÷�ҳ������
		pDto.setTotalCount(totalCount);
		
		log.info("=================������ѯչʾһ�ܵĹ�����ѯ�������=================");
		return dto;
	}
//	
//	/**
//	 * @Description ������ѯ��ͨ������ʱ�䣬�Ӷ���ȡ���ڵ��ܣ�չʾһ�ܵĹ���(��ʼ��)
//	 * @param dto IGWIM02DTO
//	 * @return IGWIM02DTO
//	 * @throws BLException
//	 */
//	public IGWIM02DTO getCurrentWorkByDateInitAction(IGWIM02DTO dto) throws BLException {
//		log.info("=================������ѯչʾһ�ܵĹ�����ʼ������ʼ=================");
//		IGWIM0201Form form = dto.getIgwim0201Form();
//		//����ʱ��
//		String workDate = IGStringUtils.getCurrentDate();
//		//����
//		String orgsyscoding = dto.getUser().getOrgid();
//		//��Ա
//		String userid = dto.getUser().getUserid();
//		
//		
//		
//		log.info("=================������ѯչʾһ�ܵĹ�����ʼ���������=================");
//		return dto;
//	}
	/**
	 * @Description ��ȡ���Ĳ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgAction(IGWIM02DTO dto) throws BLException {
		log.info("=================��ȡ���Ĳ������ݿ�ʼ=================");
		//������ʽ Map<orgsyscoding,orgname>����
		Map<String,String> orgMap = new LinkedHashMap<String, String>();
		//��ѯ�����µ����л���
		OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
		//��ѯ�û��Ƿ�������Ȩ�ޣ��Ȳ鿴�����û��Ĺ���
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			//���Ȩ�޵�Ϊ�Ƽ����쵼���������������
			orgMap.put(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_NAME);
			//ͨ���������������Ĳ���
			cond.setOrgpar(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			cond.setOrgparid(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			List<Organization> orgList = organizationBL.searchOrganization(cond);
			if(CollectionUtils.isNotEmpty(orgList)){
				for(Organization orgInfo : orgList){
					String orgname = orgInfo.getOrgname();
					orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
				}
			}else{
				throw new BLException("IGCO10000.E141", "��Ϣ�Ƽ����¸�������Ϣ������");
			}
		}else{
			//������Ȩ��,�ɲ鿴�Լ������������˵Ĺ���
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				//ͨ���������������Ĳ���
//				//������
//				String orgsyscoding = dto.getUser().getOrgid();
//				//�û�������ֱ���������ϵ����������ʵ�ʳ���������©��
//				if(orgsyscoding.length()>(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3))
//					orgsyscoding = orgsyscoding.substring(0, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3);
				cond.setOrgsyscoding(orgsyscoding);
				List<Organization> orgList = organizationBL.searchOrganization(cond);
				if(CollectionUtils.isNotEmpty(orgList)){
					for(Organization orgInfo : orgList){
						String orgname = orgInfo.getOrgname();
						orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
					}
				}else{
					throw new BLException("IGCO10000.E141", "�û����ڻ����������ĸ����˹���Χ��");
				}
			}else{
				//��ͨ�û��������и����˺ͿƼ��ܾ���Ȩ�ޣ�ֻ�ܿ��Լ��Ĺ���
				//������
				String orgsyscode = dto.getUser().getOrgid();
				//�û�������ֱ���������ϵ����������ʵ�ʳ���������©��
				if(orgsyscode.length()>=(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3)){
					orgsyscode = orgsyscode.substring(0, IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE.length()+3);
				}else{
					throw new BLException("IGCO10000.E141", "�û����ڻ���������Ϣ�Ƽ����¸�����");
				}
				cond.setOrgsyscoding(orgsyscode);
				List<Organization> orgList = organizationBL.searchOrganization(cond);
				if(CollectionUtils.isNotEmpty(orgList)){
					for(Organization orgInfo : orgList){
						String orgname = orgInfo.getOrgname();
						orgMap.put(orgInfo.getOrgsyscoding(), orgInfo.getOrgname().substring(orgname.lastIndexOf("-")+1,orgname.length()));
					}
				}else{
					throw new BLException("IGCO10000.E141", "�û����ڻ���������Ϣ�Ƽ����¸�����");
				}
			}
		}
		dto.setOrgMap(orgMap);
		log.info("=================��ȡ���Ĳ������ݽ���=================");
		return dto;
	}
/**
 * hasLeaderPower�Ƿ���и�����Ȩ�ޡ��Ȳ鿴���������û�������Ȩ��
 * @param orgsyscoding �˽�ɫ˵����Ļ�����
 * @return hasLeaderPower
 */
	private String hasLeaderPower(String userid) {
		//�Ƿ���и�����Ȩ��
		String orgsyscoding = "";
		for(LeaderRoleids roleid : LeaderRoleids.values()){
			Integer id = Integer.parseInt(roleid.toString().split("_")[1]);
			//�Ƿ���в鿴���������û���Ȩ��
			boolean tempPower = userRoleBL.isRoleInUserRole(userid, id);
			if(tempPower){
				Role roleInfo;
				try {
					roleInfo = roleBL.searchRoleByKey(id);
					orgsyscoding = roleInfo.getRoledomain();
					return orgsyscoding;
				} catch (BLException e) {
					log.error("��ѯ��ɫ����roleid��"+id+"---"+e.getMessage());
					e.printStackTrace();
				}
			}
		}
		return orgsyscoding;
	}
	/**
	 * hasMostPower ��ѯ�û��Ƿ�������Ȩ�ޣ��Ȳ鿴�����û��Ĺ���
	 * @param userid �û�id
	 * @return boolean
	 */
	private boolean hasMostPower(String userid) {
		//�Ƿ���в鿴���й��������Ȩ��
		boolean hasMostPower = userRoleBL.isRoleInUserRole(userid, IGWIMCONSTANTS.IGWIM_MOST_POWER_ROLEID);
		return hasMostPower;
	}

	/**
	 * @Description ��ȡ���Ĳ����µ���
	 * ��ʽ��List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO getCenterOrgUserAction(IGWIM02DTO dto) throws BLException {
		log.info("=================��ȡ���Ĳ����µ��˿�ʼ=================");
		//�������ݸ�ʽ��List<Map<orgid,orgid>,Map<orgname,orgname>,Map<username,username>,Map<userid,userid>>
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		//������ӿ��е������б�ֵ
		Map<String,String> orgMap = new HashMap<String, String>();
		//������ӿ��е������б�ֵ
		Map<String,String> centerMap = new HashMap<String, String>();
		//��ȡ���������е��û�������ҳ��ѡ����������
		UserSearchCondImpl cond = new UserSearchCondImpl();
		//�Ƽ��ܾ���Ȩ�ޣ����Ȩ�ޣ�����������
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			cond.setOrgid_like(IGWIMCONSTANTS.IGWIM_ORGPAR_CENTER_CODE);
			List<User> userList = userBL.searchUser(cond);
			if(CollectionUtils.isNotEmpty(userList)){
				for(User user : userList){
					//�жϴ˻����Ƿ�¼���
					if(StringUtils.isEmpty(orgMap.get(user.getOrgid()))){
						orgMap.put(user.getOrgid(), user.getOrgid());
						Map<String,String> map = new HashMap<String, String>();
						map.put("orgsyscoding", user.getOrgid());//�����룬������
						map.put("username", "");//�û������û���ʾ
						map.put("userid", "");//�û�id���û���ѯ
						list.add(map);
					}
					Map<String,String> map = new HashMap<String, String>();
					map.put("orgsyscoding", user.getOrgid());//�����룬������
					map.put("username", user.getUsername());//�û������û���ʾ
					map.put("userid", user.getUserid());//�û�id���û���ѯ
					list.add(map);
				}
			}
		}else{
			
			//������Ȩ��,�鿴�Լ����ŵ���
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				cond.setOrgid_like(orgsyscoding);
				List<User> userList = userBL.searchUser(cond);
				if(CollectionUtils.isNotEmpty(userList)){
					for(User user : userList){
						if(StringUtils.isEmpty(centerMap.get(user.getOrgid()))){
							centerMap.put(user.getOrgid(), user.getOrgid());
							Map<String,String> map = new HashMap<String, String>();
							map.put("orgsyscoding", user.getOrgid());//�����룬������
							map.put("username", "");//�û������û���ʾ
							map.put("userid", "");//�û�id���û���ѯ
							list.add(map);
						}
						Map<String,String> map = new HashMap<String, String>();
						map.put("orgsyscoding", user.getOrgid());//�����룬������
						map.put("username", user.getUsername());//�û������û���ʾ
						map.put("userid", user.getUserid());//�û�id���û���ѯ
						list.add(map);
					}
				}
				
			}else{
				//��ͨ�ˣ����Լ��Ϳ�����
				Map<String,String> map = new HashMap<String, String>();
				map.put("orgsyscoding", dto.getUser().getOrgid());//�����룬������
				map.put("username", dto.getUser().getUsername());//�û������û���ʾ
				map.put("userid", dto.getUser().getUserid());//�û�id���û���ѯ
				list.add(map);
			}
		}
		dto.setUserOrgList(list);
		log.info("=================��ȡ���Ĳ����µ��˽���=================");
		return dto;
	}
	/**
	 * @Description ���ڹ���ȷ�ϴ����ʼ��
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmCycleWorkInit(IGWIM02DTO dto) throws BLException {
		log.info("=================���ڹ���ȷ�ϳ�ʼ������ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		Integer wiid = form.getWiid();
		if(wiid!=null&&wiid>0){
			//����ʵ��
			WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//�Ǳ���״̬
			cond.setBtnAction("1");
			//��ѯ����������־
			List<WorkLogInfo> wlogList = workLogBL.searchWorkLog(cond);
			WorkInstanceTB wi = (WorkInstanceTB)SerializationUtils.clone(wiInfo);
			//�������ʵ����ִ��ʱ��Ϊ�գ����ѯ����ִ���˴���ʱ��֮��
			dto = getTotalExcuteTime(dto);
			if(StringUtils.isNotEmpty(dto.getTotalExcuteTime())&&(!"0".equals(dto.getTotalExcuteTime()))){
				wi.setExcuteTime(dto.getTotalExcuteTime());
			}
			//����ʵ����ֵ
			dto.setWiInfo(wi);
			//����������־���ϴ�ֵ
			dto.setWlogList(wlogList);
			//ȡ�ù��������
			log.info("was������ȡ����������������id="+wiInfo.getWdid());
			WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
			log.info("was������ȡ����������������desc="+workDefinitionInfo.getDescription());
			dto.setDesc(workDefinitionInfo.getDescription());
		}
		log.info("=================���ڹ���ȷ�ϳ�ʼ���������=================");
		return dto;
	}
	/**
	 * @Description ���ڹ���ȷ�ϴ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent ������������Ҫͬ�����¹��������ʵ�����ʱ���ֶ�
	 */
	public IGWIM02DTO confirmCycleWork(IGWIM02DTO dto) throws BLException {
		log.info("=================���ڹ���ȷ�ϴ���ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//1.����ʵ��������Ϣ���
		Integer wiid = form.getWiid();
		//����ʵ��
		WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
		WorkInstanceTB wiTB = (WorkInstanceTB) SerializationUtils.clone(wiInfo);
		//�������
		wiTB.setWiDescription(form.getWiDescription());
		//������ʱ
		wiTB.setExcuteTime(form.getExcuteTime());
		//��������
		wiTB.setConfirmDate(IGStringUtils.getCurrentDateTime());
		//�������ɽ���״̬
		wiTB.setWistatus(form.getWistatus());
		workInstanceBL.updateWorkInstance(wiTB);
		
		//==========ͬ�����¹��������ʵ�����ʱ�俪ʼ  Wangliang==========
		
//		WorkDefinitionTB workDefinitionTB = new WorkDefinitionTB();
		//��ȡ�����������
//		WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
		//Copy�������TB
//		BeanUtils.copyProperties(workDefinitionInfo, workDefinitionTB);
		//���ù�����ʵ�����ʱ��(����ע���߼�Ϊ�������һ���������֮��������ʵ�����ʱ��)------------------����͢  2017/07/03
		//�����ǰ���ڳ���Ԥ�����ʱ�����û�г���Ԥ�����ʱ�䣬����״̬�Ѿ���ֹ���ж��Ƿ��ǹ������һ��������ǣ����õ�ǰʱ��Ϊʵ�����ʱ��,
//		if(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())>=0||
//				(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())<0&&"0".equals(workDefinitionInfo.getWdstatus()))){
//			//��ѯ��ǰ�����Ƿ������һ��û�д�������ģ������������ʵ�����ʱ��
//			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
//			cond.setWdid(wiInfo.getWdid());
//			cond.setWiid(wiid);
//			String count = workInstanceBL.getExcutedCount(cond);
//			if("0".equals(count)){
//				workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
//			}	
//		}else if(IGStringUtils.getCurrentDateTime().compareTo(workDefinitionInfo.getEstimateFinishDate())<0&&"1".equals(workDefinitionInfo.getWdstatus())){
//			//�ж�ͬһ����������������Ƿ��ѽ���
//			WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
//			cond.setWdid(wiInfo.getWdid());
//			cond.setWiid(wiid);
//			String count = workInstanceBL.getExcutedCount(cond);
//			//�����Ԥ�����ʱ��֮�ڣ��ж��Ƿ������һ������������ǣ����������жϳ����һ�η����������ڣ��жϵ�ǰʱ���Ƿ��Ѿ�����������ڣ�����ǣ������õ�ǰʱ��Ϊʵ�����ʱ��			
//			if("day".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByDay(workDefinitionTB, workDefinitionInfo, count);				
//			}else if("week".equals(workDefinitionInfo.getCycle())){				      
//				isSetOverTimeByWeek(workDefinitionTB, workDefinitionInfo, count);					
//			}else if("month".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByMonth(workDefinitionInfo);				
//					
//			}else if("quarter".equals(workDefinitionInfo.getCycle())){
//				//����Ԥ�����ʱ�䡢��ʼʱ���ж����һ��ִ�з�����ʱ��
//				isSetOverTimeByQuarter(workDefinitionTB, workDefinitionInfo,count);
//			}else if("halfyear".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByHalfyear(workDefinitionTB, workDefinitionInfo,count);
//			}else if("year".equals(workDefinitionInfo.getCycle())){
//				isSetOverTimeByYear(workDefinitionTB, workDefinitionInfo,count);
//			}
//			
//		}
		
		//���¹�������
//		workDefinitionBL.updateWorkDefinition(workDefinitionTB);
		//==========ͬ�����¹��������ʵ�����ʱ�����  Wangliang==========
		
		log.info("=================���ڹ���ȷ�ϴ������=================");
		return dto;
	}

	private void isSetOverTimeByMonth(WorkDefinitionInfo workDefinitionInfo) {
		//�ҵ����һ�η�������ʱ��
		String lastovertime = "";
		//������õ�Ϊÿ�����һ�죬
		if("Y".equals(workDefinitionInfo.getMonthLastDay())){					
			//��ѯԤ�����ʱ���Ƿ��Ǹ������һ�죬����ǣ����ж�Ԥ�����ʱ�����ʱ���Ƿ�С��Ԥ�����ʱ�䣬���С�ڣ������һ�η�����ʱ��ΪԤ�����ʱ�����ʱ���֣�������ڣ����ѯ��һ���µ����һ�����ڼ���ʱ��
			Calendar calendar = Calendar.getInstance();   
			// ����ʱ��,��ǰʱ�䲻������   
			calendar.setTime(new Date(workDefinitionInfo.getEstimateFinishDate().substring(0, 10)));   
			if(calendar.get(Calendar.DATE)==calendar.getActualMaximum(Calendar.DAY_OF_MONTH)){
		        //�ж�ʱ���Ƿ�С��Ԥ��ʱ���ʱ�֣����С�ڣ���ȡԤ�����ʱ���ʱ�֣�������ڣ��������һ���µ����һ������
				if(workDefinitionInfo.getEstimateFinishDate().substring(10, workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>=0){
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");  
					//������һ���µ����һ������
					int month = calendar.get(Calendar.MONTH);
					calendar.set(Calendar.MONTH, month-1);
					calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
					Date strDateTo = calendar.getTime();  
					lastovertime = formatter.format(strDateTo)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}
		    }else{
		    	//������һ���µ����һ������
		    	SimpleDateFormat formatter=new SimpleDateFormat("yyyy/MM/dd");  
				int month = calendar.get(Calendar.MONTH);
				calendar.set(Calendar.MONTH, month-1);
				calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
				Date strDateTo = calendar.getTime();  
				lastovertime = formatter.format(strDateTo)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		    }
		}else{
			//�������ÿ�����һ�죬���ж�Ԥ����������Ƿ����ѡ�������ڣ�����������ѯ��һ���¸��ռ���ʱ��Ϊ���һ�η�������ʱ�䣬���С�ڣ���ȡ�õ��µ��ռ���ʱ��Ϊ���һ�η�����ʱ��
			String wdmonth = "";
			if(workDefinitionInfo.getWdmonth().length()==1){
				wdmonth = "0"+workDefinitionInfo.getWdmonth();
			}else{
				wdmonth = workDefinitionInfo.getWdmonth();
			}
			if(workDefinitionInfo.getEstimateFinishDate().substring(8,10).compareTo(wdmonth)>0){
				lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}else if(workDefinitionInfo.getEstimateFinishDate().substring(8,10).compareTo(wdmonth)==0){
				//
				if(workDefinitionInfo.getEstimateFinishDate().substring(10,workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>0){
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					//�����ǰѡ�е�Ϊ1�·ݣ���ô��һ����Ϊȥ���12�·�
					if("1".equals(workDefinitionInfo.getWdmonth())){
						Integer beforeyear = Integer.parseInt(workDefinitionInfo.getEstimateFinishDate().substring(0,4))-1;
						lastovertime = beforeyear+"/12/"+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
					}else{
						Integer newwdmonth = Integer.parseInt(workDefinitionInfo.getWdmonth())-1;
						if(String.valueOf(newwdmonth).length()==1){
							wdmonth = "0"+newwdmonth;
						}else{
							wdmonth = String.valueOf(newwdmonth);
						}
						lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
					}
					
				}
			}else{
				//��һ���±��������
				//�����ǰѡ�е�Ϊ1�·ݣ���ô��һ����Ϊȥ���12�·�
				if("1".equals(workDefinitionInfo.getWdmonth())){
					Integer beforeyear = Integer.parseInt(workDefinitionInfo.getEstimateFinishDate().substring(0,4))-1;
					lastovertime = beforeyear+"/12/"+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}else{
					Integer newwdmonth = Integer.parseInt(workDefinitionInfo.getWdmonth())-1;
					if(String.valueOf(newwdmonth).length()==1){
						wdmonth = "0"+newwdmonth;
					}else{
						wdmonth = String.valueOf(newwdmonth);
					}
					lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0,8)+wdmonth+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
				}
			}
		}
	}
	/**
	 * ������������֮���������
	 *<p>
	 * Description: 
	 *</p>
	 *  
	 * @param date1
	 * @param date2
	 * @return
	 * @throws ParseException
	 */
	public int getMonthSpace(String date1, String date2){

        int result = 0;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        try {
			c1.setTime(sdf.parse(date1));
			c2.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        result = c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);

        return result == 0 ? 1 : Math.abs(result);

    }
	private void isSetOverTimeByWeek(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo, String count) {
		//�ҵ����һ�η�������ʱ��
		String lastovertime = "";
		//�ж�Ԥ�����ʱ��Ϊ���ڼ�
		int weeknum = IGDateUtils.dateToWeekByNum(workDefinitionInfo.getEstimateFinishDate());
		//ѡ�е�����Ϊ���ڼ�
		int selectedweeknum = 0;
		String[] weekOfDays = {"MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"};  
		for(int i=0;i<weekOfDays.length;i++){
			if(weekOfDays[i].equals(workDefinitionInfo.getWdweek())){
				selectedweeknum = i;
				break;
			}
		}
		if(weeknum>selectedweeknum){
			//�õ���Ԥ�����ʱ�������ܣ����յ�ǰΪ�ܼ��ж�ʱ��
			lastovertime = IGDateUtils.getdateToWeek(workDefinitionInfo.getEstimateFinishDate().substring(0, 10),selectedweeknum)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		}else if(weeknum==selectedweeknum){
			//�ж�Ԥ�����ʱ���Ƿ�������õ�ʱ�֣��������ʱ�֣���ֱ��ȡ��������ڣ�����ȡ��һ�ܵ�����
			if(workDefinitionInfo.getEstimateFinishDate().substring(10, workDefinitionInfo.getEstimateFinishDate().length()-1).compareTo(" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute())>=0){
				lastovertime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}else{
				//������һ�ܵ�����
				lastovertime = IGDateUtils.getbeforeweekDate(workDefinitionInfo.getEstimateFinishDate().substring(0, 10))+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
			}
		}else{
			//ֱ������һ�ܵ�����
			lastovertime = IGDateUtils.getbeforeweekDate(workDefinitionInfo.getEstimateFinishDate().substring(0, 10))+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();					
		}			
		//�����ǰʱ��������һ�η�����ʱ�䣬������ʵ�����ʱ��
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	private void isSetOverTimeByDay(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo, String count) {
		//�ҵ����һ�η�������ʱ��
		String lastovertime = "";
		//��Ԥ�����ʱ���ȡ���죬�������Сʱ�ͷ����Ƿ�С��Ԥ�����ʱ�䣬����ǣ����ʱ��Ϊ���һ�η�����ʱ�䣬����Ԥ�����ʱ����ǰһ�죬�����Сʱ�ͷ��ӣ�Ϊ���һ�η�������ʱ��
		String temptime = workDefinitionInfo.getEstimateFinishDate().substring(0, 10)+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		if(temptime.compareTo(workDefinitionInfo.getEstimateFinishDate())<0){
			lastovertime = temptime;
		}else{
			//�õ�Ԥ�����ʱ���ǰһ�죬����ʱ����
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			Calendar c = Calendar.getInstance(); 
			Date date=null; 
			try { 
				date = simpleDateFormat.parse(workDefinitionInfo.getEstimateFinishDate().substring(0, 10));
			} catch (ParseException e) {
				 e.printStackTrace(); 
			}
			 c.setTime(date); 
			 int day=c.get(Calendar.DATE); 
			 c.set(Calendar.DATE,day-1); 
			 String dayBefore=new SimpleDateFormat("yyyy/MM/dd").format(c.getTime()); 
			 lastovertime = dayBefore+" "+workDefinitionInfo.getWdhour()+":"+workDefinitionInfo.getWdminute();
		}
		//�����ǰʱ��������һ�η�����ʱ�䣬������ʵ�����ʱ��
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	@SuppressWarnings("deprecation")
	private void isSetOverTimeByYear(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count) {
		//����Ԥ�����ʱ�䡢��ʼʱ���ж����һ��ִ�з�����ʱ��
		//��ȡ��ʼʱ��
		String beginDate = workDefinitionInfo.getBeginDate();
		//��ȡԤ�����ʱ��
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//�������һ��Ԥ��ִ��ʱ��
		String lastStartDate = estimateFinishDate.substring(0,5)+beginDate.substring(5,beginDate.length());
		//������һ��ִ��ʱ�����Ԥ�����ʱ�䣬��ǰʱ��Ϊʵ�����ʱ��
		String lastovertime ="";
		if(lastStartDate.compareTo(estimateFinishDate)<=0){
			lastovertime = lastStartDate;
		}else{
			int lastYear = strParseDate(estimateFinishDate).getYear();
			lastovertime = (lastYear-1)+beginDate.substring(5,beginDate.length());
		}
		//�����ǰʱ��������һ�η�����ʱ�䣬������ʵ�����ʱ��
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	private void isSetOverTimeByHalfyear(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count) {
		//��ȡ��ʼʱ��
		String beginDate = workDefinitionInfo.getBeginDate();
		//��ȡԤ�����ʱ��
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//�жϿ�ʼʱ�䵽Ԥ�����ʱ��֮���ж��ٸ���ִ������
		int monthcount = getMonthSpace(beginDate,estimateFinishDate)%6;
		//���������
		int cyclenumber =  getMonthSpace(beginDate,estimateFinishDate)/6;
		String lastovertime ="";
		//��ʼʱ���ʱ����
		String startTime = beginDate.substring(12,beginDate.length());
		//Ԥ�����ʱ��ʱ����
		String estimateStartTime = estimateFinishDate.substring(12,beginDate.length());
		DateFormat df = new SimpleDateFormat("HH:mm");
		if(monthcount==0){
			//�������������
			try {  
		    		//��ʼʱ���ʱ����
		            Date dt1 = df.parse(startTime);//���ַ���ת��Ϊdate����  
		            Date dt2 = df.parse(estimateStartTime);  
		            if(dt1.getTime()<dt2.getTime())//�Ƚ�ʱ���С,���dt1����dt2  
		            {  
		            	 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	 df.parse(beginDate).setMonth(6*cyclenumber);
				    	 lastovertime = df.toString();
		            }  
		            else  
		            {  
		            	df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	df.parse(beginDate).setMonth(6*(cyclenumber-1));
				    	lastovertime = df.toString();
		            }  
		        } catch (ParseException e) {  
		       e.printStackTrace();  
		     } 
		}else{
			 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
			 try {
				df.parse(beginDate).setMonth(6*cyclenumber);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 lastovertime = df.toString();
		}
		//�����ǰʱ��������һ�η�����ʱ�䣬������ʵ�����ʱ��
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}

	@SuppressWarnings("deprecation")
	private void isSetOverTimeByQuarter(WorkDefinitionTB workDefinitionTB,
			WorkDefinitionInfo workDefinitionInfo,String count){
		//����Ԥ�����ʱ�䡢��ʼʱ���ж����һ��ִ�з�����ʱ��
		//��ȡ��ʼʱ��
		String beginDate = workDefinitionInfo.getBeginDate();
		//��ȡԤ�����ʱ��
		String estimateFinishDate = workDefinitionInfo.getEstimateFinishDate();
		//�жϿ�ʼʱ�䵽Ԥ�����ʱ��֮���ж��ٸ���ִ������
		int monthcount = getMonthSpace(beginDate,estimateFinishDate)%3;
		//���������
		int cyclenumber =  getMonthSpace(beginDate,estimateFinishDate)/3;
		String lastovertime ="";
		//��ʼʱ���ʱ����
		String startTime = beginDate.substring(12,beginDate.length());
		//Ԥ�����ʱ��ʱ����
		String estimateStartTime = estimateFinishDate.substring(12,beginDate.length());
		DateFormat df = new SimpleDateFormat("HH:mm");
		if(monthcount==0){
			//�������������
			try {  
		    		//��ʼʱ���ʱ����
		            Date dt1 = df.parse(startTime);//���ַ���ת��Ϊdate����  
		            Date dt2 = df.parse(estimateStartTime);  
		            if(dt1.getTime()<dt2.getTime())//�Ƚ�ʱ���С,���dt1����dt2  
		            {  
		            	 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	 df.parse(beginDate).setMonth(3*cyclenumber);
				    	 lastovertime = df.toString();
		            }  
		            else  
		            {  
		            	df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
		            	df.parse(beginDate).setMonth(3*(cyclenumber-1));
				    	lastovertime = df.toString();
		            }  
		        } catch (ParseException e) {  
		       e.printStackTrace();  
		     } 
		}else{
			 df = new SimpleDateFormat("yyyy/mm/dd HH:mm");
			 try {
				df.parse(beginDate).setMonth(3*cyclenumber);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 lastovertime = df.toString();
		}
		//�����ǰʱ��������һ�η�����ʱ�䣬������ʵ�����ʱ��
		if(IGStringUtils.getCurrentDateTime().compareTo(lastovertime)>=0&&"0".equals(count)){
			workDefinitionTB.setActualFinishDate(IGStringUtils.getCurrentDateTime());
		}
	}
	/**
	 * @Description ���칤��ȷ�ϴ����ʼ��
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 * @modifier WangLiang
	 * @modifyContent ������������˳�ʱֹͣ����ʱ�䣨�죩��ȷ�ϳ�ʼ��ʱ��Ҫ��Ԥ���������+��ʱֹͣ����ʱ�� �� ϵͳ�������Ƚϣ����ѳ�ʱ������ִ����ȷ��/������ع���
	 */
	public IGWIM02DTO confirmTodayWorkInit(IGWIM02DTO dto) throws BLException {
		log.info("=================���칤��ȷ�ϳ�ʼ������ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//����ʵ������
		Integer wiid = form.getWiid();
		//����������
		String titleDate = form.getTitleDate();
		if(wiid!=null&&wiid>0){
			//����ʵ��
			WorkInstanceInfo wiInfo = getWorkInstanceInfo(wiid);
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//�Ǳ���״̬
			cond.setBtnAction("1");
			//ֻ���Լ��Ĵ����¼
			cond.setExcutorId(dto.getUser().getUserid());
			//����������
			cond.setTitleDate(form.getTitleDate());
			//��ѯ����������־
			List<WorkLogInfo> wlogList = workLogBL.searchWorkLog(cond);
			//����ʵ����ֵ
			dto.setWiInfo(wiInfo);
			WorkInstanceTB wiTB = (WorkInstanceTB) SerializationUtils.clone(wiInfo);
			//���������������ж��ܷ��ٴ���
			WorkLogSearchCondImpl cond1 = new WorkLogSearchCondImpl();
			cond1.setWiid(wiid);
			//ֻ���Լ��Ĵ����¼
			cond1.setExcutorId(dto.getUser().getUserid());
			cond1.setTitleDate(titleDate);
			List<WorkLogInfo> logList = workLogBL.searchWorkLog(cond1);
			if(CollectionUtils.isNotEmpty(logList)){//�������־�����
				WorkLogInfo workLogInfo = logList.get(0);
				if("0".equals(workLogInfo.getBtnAction())){//����״̬,���Լ�����,ͬʱ��ֵ����ҳ��
					wiTB.setDescription(workLogInfo.getWlDescription());
					wiTB.setExcuteTime(workLogInfo.getExcuteTime());
					//��־����״̬0���棬1ȷ��
					wiTB.setWistatus("0");
					dto.setWiInfo(wiTB);
				}else{
					wiTB.setDescription(workLogInfo.getWlDescription());
					wiTB.setExcuteTime(workLogInfo.getExcuteTime());
					//��־����״̬0���棬1ȷ��
					wiTB.setWistatus("1");
					dto.setWiInfo(wiTB);
				}
			}else{
				//û�������־���
				wiTB.setDescription("");
				wiTB.setExcuteTime("");
				//��־����״̬0���棬1ȷ��
				dto.setWiInfo(wiTB);
			}
			//����������־���ϴ�ֵ
			dto.setWlogList(wlogList);
			
			//==========��ʱֹͣ�����⿪ʼ  Wangliang==========
			//ȡ�ù��������
			WorkDefinitionInfo workDefinitionInfo = workDefinitionBL.searchWorkDefinitionByPK(wiInfo.getWdid());
			//����õ�������ȷ��/���淶Χ�ڵ�����
			Date dateAfter = getDateAfter(strParseDate(workDefinitionInfo.getEstimateFinishDate()), 
					Integer.parseInt(workDefinitionInfo.getOvertimeStopDealTime()));
			if(compairDate(dateAfter, new Date())==-1){
				//�ѳ�ʱ
				dto.setIsOverTime("1");
			}else{
				//δ��ʱ
				dto.setIsOverTime("0");
			}
			dto.setDesc(workDefinitionInfo.getDescription());
			//==========��ʱֹͣ���������  Wangliang==========
		}
		log.info("=================���칤��ȷ�ϳ�ʼ���������=================");
		return dto;
	}
	/**
	 * @Description ���칤��ȷ�ϴ���
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author zyl
	 */
	public IGWIM02DTO confirmTodayWork(IGWIM02DTO dto) throws BLException {
		log.info("=================���칤��ȷ�ϴ���ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//����ʵ������
		Integer wiid = form.getWiid();
		
		//==========ִ����ȷ��ʱ������userid����½�û�����btnaction =2 ��ѯ���Ľ����ɾ����־��������ݿ�ʼ���ף���̣����==========
		
		WorkLogSearchCondImpl workLogCond = new WorkLogSearchCondImpl();
		//����ִ����userid
		workLogCond.setExcutorId(dto.getUser().getUserid());
		//���ð�ť�������ͣ�1�����棻2���ύ��
		workLogCond.setBtnAction("2");
		//����BL���������
		List<WorkLogInfo> searchWorkLog = workLogBL.searchWorkLog(workLogCond);
		//��������ǿգ��������ִ������ɾ��
		if(searchWorkLog!=null && searchWorkLog.size()>0){
			for (int i = 0; i < searchWorkLog.size(); i++) {
				workLogBL.deleteWorkLogByPK(searchWorkLog.get(i).getWlid());
			}
		}
		//==========ִ����ȷ��ʱ������userid����½�û�����btnaction =2 ��ѯ���Ľ����ɾ����־��������ݽ������ף���̣����==========
		if(wiid!=null&&wiid>0){
			//�������������
			WorkLogSearchCondImpl cond = new WorkLogSearchCondImpl();
			cond.setWiid(wiid);
			//ֻ���Լ��Ĵ����¼
			cond.setExcutorId(dto.getUser().getUserid());
			cond.setTitleDate(form.getTitleDate());
			List<WorkLogInfo> logList = workLogBL.searchWorkLog(cond);
			if(CollectionUtils.isNotEmpty(logList)){
				for(WorkLogInfo info : logList){
					workLogBL.deleteWorkLog(info);
				}
			}
			//1.������־��Ϣ���
			WorkLogTB tb = new WorkLogTB();
			//����ʵ��
			tb.setWiid(wiid);
			//ʵ�ʴ�������
			tb.setActualDealwithDate(IGStringUtils.getCurrentDateTime());
			//����������
			tb.setTitleDate(form.getTitleDate());
			//ִ��ʱ�䣨Сʱ ��
			tb.setExcuteTime(form.getExcuteTime());
			//ִ���������
			tb.setWlDescription(form.getWlDescription());
			//ִ����
			tb.setExcutorName(dto.getUser().getUsername());
			//ִ����id
			tb.setExcutorId(dto.getUser().getUserid());
			//����
			if("1".equals(form.getBtnAction())){
				//�ύ
				tb.setBtnAction("1");
			}else{
				//����
				tb.setBtnAction("0");
			}
			workLogBL.registWorkLog(tb);
			//��һ�˴�����Ĺ�����״̬��Ϊִ����,����Ǳ����򲻸���
			if("1".equals(form.getBtnAction())){				
				WorkInstanceTB wiTb =  (WorkInstanceTB) SerializationUtils.clone(workInstanceBL.searchWorkInstanceByPK(wiid));
				wiTb.setWistatus("ִ����");
				workInstanceBL.updateWorkInstance(wiTb);
			}
		}
		log.info("=================���칤��ȷ�ϴ������=================");
		return dto;
	}
	/**
	 * @Description ��ȡ������Ϣʵ��
	 * @param id ��������
	 * @return WorkInstanceInfo
	 * @throws BLException
	 * @author zyl
	 */
	public WorkInstanceInfo getWorkInstanceInfo(Integer id) throws BLException {
		log.info("=================��ȡ������Ϣʵ��=================");
		return workInstanceBL.searchWorkInstanceByPK(id);
	}
	
	/**
	 * @Description ������Ϣͳ�Ʋ�ѯ
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO countSearch(IGWIM02DTO dto) throws BLException {
		IGWIM0201Form form = dto.getIgwim0201Form();
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//���ò�ѯ����
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		
		//��������
		int totalCount = workInstanceBL.findCountSearch(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========������Ϣ���ݲ�����========");
			// ������Ϣ���ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========������Ϣ���ݹ���========");
			// ������Ϣ���ݹ���
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//����BL��ѯ������Ϣ
		List<Map<String, String>> wiList = workInstanceBL.findCountSearch(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//�����ѯ�����
		dto.setWiList(wiList);
		//���÷�ҳ������
		pDto.setTotalCount(totalCount);
				
		return dto;
	}
	
	/**
	 * @Description ������Ϣͳ�Ʋ�ѯ����
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 * @author songzhihui
	 */
	public IGWIM02DTO searchExport(IGWIM02DTO dto) throws BLException {
		log.info("=================������Ϣͳ�Ʋ�ѯ����BL����ʼ=================");
		IGWIM0201Form form = dto.getIgwim0201Form();
		//���ò�ѯ����
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		//��ȡ�Ľ����
		List<Map<String, String>> wiList = workInstanceBL.findCountSearch(cond, 0, 0);
		
		//������Ӧ����
		HttpServletResponse response = dto.getResponse();
		response.reset();
		response.setContentType("binary/octet-stream");
		OutputStream output = null;
		try {
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String("������Ϣ.xlsx".getBytes("gb2312"), "iso-8859-1"));
			output = response.getOutputStream();
			// ����������
			XSSFWorkbook book = new XSSFWorkbook();
			XSSFSheet sheet = book.createSheet("������Ϣ");
			
			// �ϲ���Ԫ��
			// �ĸ������ֱ��ǣ���ʼ�У������У���ʼ�У�������
			sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(0, 1, 0, 12));
			//���ñ��ⵥԪ����ʽ
			XSSFCellStyle bigtitlestyle = bigtitlecellstyle(book);
			// ��Ӵ������
			XSSFRow bigtitleRow = sheet.createRow(0);
			bigtitleRow.setHeight((short) 980);
			// ������Ԫ��
			XSSFCell bigtitlecell = bigtitleRow.createCell(0);
			bigtitlecell.setCellValue("������Ϣ");
			bigtitlecell.setCellStyle(bigtitlestyle);
			
			// �ϲ���Ԫ��
			// �ĸ������ֱ��ǣ���ʼ�У������У���ʼ�У�������
			sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(2, 2, 0, 4));
			// ��Ӳ�ѯ��������
			XSSFRow searchformRow = sheet.createRow(2);
			searchformRow.setHeight((short) 480);
			// ������Ԫ��
			XSSFCell searchformcell = searchformRow.createCell(0);
			searchformcell.setCellValue("������ʼ���ڣ�"+form.getBegindate_from()+"--"+form.getBegindate_to());
			
			//���ñ��ⵥԪ����ʽ
			XSSFCellStyle titlestyle = titlecellstyle(book);
			// ��ӱ�����
			XSSFRow titleRow = sheet.createRow(3);
			titleRow.setHeight((short) 980);
			String[] titles = { "��������","����","������","������","ִ����","����״̬",
					"������ʼ����","������������","����������","ִ��ȷ������","����ִ�����","ִ��ʱ�䣨Сʱ��","ִ���������" };
			int[] titlewidths = { 50 * 70, 50 * 70, 50 * 70, 50 * 70, 50 * 100, 
					50 * 70, 50 * 100, 50 * 100, 50 * 90, 50 * 100, 50 * 70, 50 * 100, 50 * 70 };

			for (int i = 0; i < titles.length; i++) {
				// ������Ԫ��
				XSSFCell cell = titleRow.createCell(i);
				cell.setCellValue(titles[i]);
				cell.setCellStyle(titlestyle);
				sheet.setColumnWidth(i, titlewidths[i]);
			}
			
			//�������ݵ�Ԫ��Ͳ�ѯ��������ʽ
			XSSFCellStyle liststyle = listcellstyle(book);
			//����������
			for(int k = 0; k< wiList.size();k++) {
				//��ȡÿ������
				Map<String, String> listmap = wiList.get(k);	
				
				// ��ӱ�����
				XSSFRow listRow = sheet.createRow(4+k);
				listRow.setHeight((short) 580);
				
				//�ж����ڵ�ֵ
				String cycle = "";
				if("day".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ��";
				} 
				else if("week".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ��";
				} 
				else if("month".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ��";
				} 
				else if("quarter".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ����";
				} 
				else if("halfyear".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ����";
				} 
				else if("year".equals(listmap.get("CYCLE"))) {
					cycle = "ÿ��";
				} 
				
				String[] list = { listmap.get("WDNAME"),
						cycle,
						listmap.get("INITIATORID"),
						listmap.get("LEADERNAME"),
						listmap.get("EXCUTORNAME"),
						listmap.get("WISTATUS"),
						listmap.get("BEGINDATE"),
						listmap.get("CRTDATE"),
						listmap.get("TITLEDATE"),
						listmap.get("ACTUALDEALWITHDATE"),
						listmap.get("BTNACTION"),
						listmap.get("EXCUTETIME"),
						listmap.get("WLDESCRIPTION") };

				for (int i = 0; i < list.length; i++) {
					// ������Ԫ��
					XSSFCell cell = listRow.createCell(i);
					cell.setCellStyle(liststyle);
					cell.setCellValue(list[i]);
				}
			}
			
			
			
			book.write(output);
		} catch (Exception e) {
			log.error(">>�����ļ��쳣��" + e.getMessage());
		} finally {
			try {
				// �ر������
				if (output != null) {
					output.close();
				}
			} catch (Exception e) {
				log.error(">>�����ļ��쳣��" + e.getMessage());
			}
		}

		log.info("=================������Ϣͳ�Ʋ�ѯ����BL�������=================");
		return dto;
	}
	
	/**
	 * ���õ���excel������ʽ
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle titlecellstyle(XSSFWorkbook book){
		// ������Ԫ����ʽ
		XSSFCellStyle titlestyle = book.createCellStyle();
		// ���õ�Ԫ�񱳾�ɫ (��ɫ)
		XSSFColor color = new XSSFColor(Color.white);
		titlestyle.setFillForegroundColor(color);
		// ���ñ߿� ��һ��Ӧ���Ǳ߿���ʽ
		titlestyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		titlestyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		titlestyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		// ���ö���
		titlestyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// ˮƽ
		titlestyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// ��ֱ
		// �����Զ�����
		titlestyle.setWrapText(true);
		//��������
		XSSFFont font = book.createFont();    
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("����");    
		font.setFontHeightInPoints((short) 10);//���������С    
		titlestyle.setFont(font);
		
		return titlestyle;
		
	}
	
	/**
	 * ���õ���excel������ʽ
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle bigtitlecellstyle(XSSFWorkbook book){
		// ������Ԫ����ʽ
		XSSFCellStyle bigtitlestyle = book.createCellStyle();
		// ���õ�Ԫ�񱳾�ɫ (��ɫ)
		XSSFColor color = new XSSFColor(Color.white);
		bigtitlestyle.setFillForegroundColor(color);
		// ���ö���
		bigtitlestyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// ˮƽ
		bigtitlestyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// ��ֱ
		// �����Զ�����
		bigtitlestyle.setWrapText(true);
		//��������
		XSSFFont font = book.createFont();    
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		font.setFontName("����");    
		font.setFontHeightInPoints((short) 20);//���������С    
		bigtitlestyle.setFont(font);
		
		return bigtitlestyle;
		
	}
	
	/**
	 * ���õ���excel������ʽ
	 * 
	 * */
	@SuppressWarnings("deprecation")
	public XSSFCellStyle listcellstyle(XSSFWorkbook book){
		// ������Ԫ����ʽ
		XSSFCellStyle listtyle = book.createCellStyle();
		// ���õ�Ԫ�񱳾�ɫ (��ɫ)
		XSSFColor color = new XSSFColor(Color.white);
		listtyle.setFillForegroundColor(color);
		// ���ñ߿� ��һ��Ӧ���Ǳ߿���ʽ
		listtyle.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
		
		listtyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		listtyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		// ���ö���
		listtyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);// ˮƽ
		listtyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// ��ֱ
		// �����Զ�����
		listtyle.setWrapText(true);
		
		return listtyle;
		
	}
	/**
	 * @Description ��ҳ�ҵĵ��չ�����ѯ
	 * @param dto IGWIM02DTO
	 * @return IGWIM02DTO
	 * @throws BLException
	 */
	public IGWIM02DTO findTodayWorkByCondForFirstPage(IGWIM02DTO dto) throws BLException {
		log.info("=================��ҳ�ҵĵ��չ�����ѯ����ʼ=================");
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		pDto.getPageDispCount();
		//���ò�ѯ����
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		//��ǰ�û�
		cond.setUserid(dto.getUser().getUserid());
		//��������
		int totalCount = workInstanceBL.findTodayWorkByCondForFirstPage(cond, 0, 0).size();
		
		if (totalCount == 0) {
			log.info("========������������ݲ�����========");
			// ֪ʶ����������ݲ�����
			dto.addMessage(new ActionMessage("IGBCM0101.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.info("========���������ݼ�������========");
			// �û��������ݼ�������
			dto.addMessage(new ActionMessage("IGBCM0101.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		//����BL��ѯ������Ϣ
		List<Map<String, String>> wiList = workInstanceBL.findTodayWorkByCondForFirstPage(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		//�����ѯ�����
		dto.setWiList(wiList);
		//���÷�ҳ������
		pDto.setTotalCount(totalCount);
		
		log.info("=================��ҳ�ҵĵ��չ�����ѯ�������=================");
		return dto;
	}
	/**
	 * ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮��
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public IGWIM02DTO getTotalExcuteTime(IGWIM02DTO dto){
		IGWIM0201Form form = dto.getIgwim0201Form();
		// ��ҳ����Ϣȡ��
		WorkInstanceSearchCondImpl cond = new WorkInstanceSearchCondImpl();
		cond.setWiid(form.getWiid());
		String totalExcuteTime = workInstanceBL.getTotalExcuteTime(cond);
		dto.setTotalExcuteTime(totalExcuteTime);
		return dto;
	}
	
	/**
	 * �ַ�����ʽת������
	 * @param str �ַ���
	 * @return ����
	 */
	private Date strParseDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.error("�ַ���ǿת�����ڸ�ʽʧ�ܣ�Ҫת�����ַ���:"+str+"\n�ࣺWorkRemindBLImpl��������strParseDate() 942\n"+e.getMessage());
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * ��ȡ���ں��������
	 * @param d ���������
	 * @param day ���ӵ�����
	 * @return
	 */
	private Date getDateAfter(Date d, int day) {  
		
        Calendar now = Calendar.getInstance();  
        //���õ�ϵͳ����
        now.setTime(d);
        //ϵͳ����+��
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
	
	/**
	 * �Ƚ����ڴ�С
	 * @param dt1 ����1
	 * @param dt2 ����2
	 * @return ����1������1>����2������-1������1<����2������0������1=����2
	 */
	private int compairDate(Date dt1,Date dt2){
		
		if(dt1.getTime() > dt2.getTime()){
			return 1;
		}else if(dt1.getTime() < dt2.getTime()){
			return -1;
		}else{
			return 0;
		}
	}

	public IGWIM02DTO getPermissionByUser(IGWIM02DTO dto) {
		//����û�Ȩ�ޣ��Ƽ����쵼
		boolean hasMostPower = hasMostPower(dto.getUser().getUserid());
		if(hasMostPower){
			dto.setUserPermission("1");
		}else{
			String orgsyscoding = hasLeaderPower(dto.getUser().getUserid());
			if(StringUtils.isNotEmpty(orgsyscoding)){
				dto.setUserPermission("2");
			}else{
				dto.setUserPermission("3");
			}
		}
		
		return dto;
	}
}
