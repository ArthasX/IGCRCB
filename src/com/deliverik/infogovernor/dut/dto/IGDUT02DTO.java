/*
 * ��������������������޹�˾��Ȩ����,��������Ȩ��.
 */

package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.dut.form.IGDUT0201Form;
import com.deliverik.infogovernor.dut.form.IGDUT0202Form;
import com.deliverik.infogovernor.dut.form.IGDUT0203Form;
import com.deliverik.infogovernor.dut.form.IGDUT0204Form;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.form.IGDUT0207Form;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.DutyResultVWInfo;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCond;
import com.deliverik.infogovernor.dut.model.entity.DutyPersonTB;

/**
 * ֵ�����DTO
 * 
 */
public class IGDUT02DTO extends BaseDTO implements Serializable{
	
	private static final long serialVersionUID = -6214724454446012825L;

	/** ֵ��ƻ���ѯ���� */
	protected DutyPlanSearchCond dutyPlanSearchCond;
	
	/** �û���Ϣ */
	protected User user;
	
	/** ֵ���������б� */
	protected List<DutyResult> dutyResultList;
	
	/** ֵ�����б� */
	protected List<DutyPersonTB> dutyPersonList;
	
	/** ֵ������Ϣ */
	protected String usersinfo;
	
	/** ֵ��ƻ� */
	protected DutyPlan dutyPlan;
	
	/** ֵ�ཻ��Form */
	protected IGDUT0204Form igDUT0204Form;
	
	/** ֵ����ֹForm */
	protected IGDUT0207Form igDUT0207Form;
	
	/** ��ѡ�װ���Ա */
	protected List<UserRoleInfo> dayShiftUsers;
	
	/** ��ѡҹ����Ա */
	protected List<UserRoleInfo> nightShiftUsers;
	
	/** �װ�ֵ����Ա */
	protected List<UserRoleInfo> dayShiftDutyUsers;
	
	/** ҹ��ֵ����Ա */
	protected List<UserRoleInfo> nightShiftDutyUsers;
	
	/** ֵ����Ա��Ϣ */
	protected Map<String,String> dutyUserMap;
	
	protected IGDUT0202Form igdut0202Form;
	
	/** ֵ��ƻ����� */
	protected IGDUT0201Form igdut0201Form;
	
	/** ֵ���ձ�Form */
	protected IGDUT0203Form igDUT0203Form;
	
	protected int calendarYear;
	
	protected int calendarMonth;
	
	protected boolean canChangeDuty = false;
	
	protected String todayYMD;
	
	/** ֵ��ƻ������б� */
	protected List<DutyPlan> dutyPlanList;
	
	/** ֵ������Form */
	protected IGDUT0206Form igDUT0206Form;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ֵ������Ϣ���������� */
	protected int maxSearchCount;
	
	/** ֵ���ձ�������� */
	protected Map<String,List<DutyResultVWInfo>> typeMap;
	
	/** ֵ��ʱ�� */
	protected String dptype;
	
	/** ֵ���ձ�ID���� */
	protected List<Integer> dridList;

	/** igdut0203���������ֶγ��� */
	protected Integer  num;
	/** �Ƿ���δ�����,1���� */
	protected String  hasNullDrcontent;
	
	/** ֵ���ձ������ѡ���ʶ 0����ѡ 1��ѡ */
	protected List<String> showList;
	
	/** ֵ��ƻ���ע */
	protected String dpremarks;
	
	/** ���˵���Ƿ�ɱ༭ */
	protected List<String> showResultList;
	
	/** ҹ�࿪ʼʱ�� */
	protected String nightStartTime;
	
	public String getNightStartTime() {
		return nightStartTime;
	}

	public void setNightStartTime(String nightStartTime) {
		this.nightStartTime = nightStartTime;
	}

	public List<String> getShowResultList() {
		return showResultList;
	}

	public void setShowResultList(List<String> showResultList) {
		this.showResultList = showResultList;
	}

	/**
	 * ֵ���ձ������ѡ���ʶȡ��
	 * @return the showList
	 */
	public List<String> getShowList() {
		return showList;
	}

	/**
	 *  ֵ���ձ������ѡ���ʶ�趨
	 */
	public void setShowList(List<String> showList) {
		this.showList = showList;
	}

	/**
	 * igdut0203���������ֶγ���ȡ��
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 *  igdut0203���������ֶγ����趨
	 */
	public void setNum(Integer num) {
		this.num = num;
	}


	/**
	 * ֵ���ձ�ID����ȡ��
	 * @return the dridList
	 */
	public List<Integer> getDridList() {
		return dridList;
	}

	

	/**
	 *  ֵ���ձ�ID�����趨
	 */
	public void setDridList(List<Integer> dridList) {
		this.dridList = dridList;
	}

	/**
	 *  ֵ��ʱ��ȡ��
	 * @return the dptype
	 */
	public String getDptype() {
		return dptype;
	}

	/**
	 *  ֵ��ʱ���趨
	 */
	public void setDptype(String dptype) {
		this.dptype = dptype;
	}

	/**
	 * ֵ���ձ��������ȡ��
	 * @return the typeMap
	 */
	public Map<String, List<DutyResultVWInfo>> getTypeMap() {
		return typeMap;
	}

	/**
	 * ֵ���ձ���������趨
	 */
	public void setTypeMap(Map<String, List<DutyResultVWInfo>> typeMap) {
		this.typeMap = typeMap;
	}

	/**
	 * ֵ���ձ�Formȡ��
	 * @return the igDUT0203Form
	 */
	public IGDUT0203Form getIgDUT0203Form() {
		return igDUT0203Form;
	}

	/**
	 * ֵ���ձ�Form�趨
	 */
	public void setIgDUT0203Form(IGDUT0203Form igDUT0203Form) {
		this.igDUT0203Form = igDUT0203Form;
	}

	
	
	
	
	public int getCalendarYear() {
		return calendarYear;
	}

	public void setCalendarYear(int calendarYear) {
		this.calendarYear = calendarYear;
	}

	public int getCalendarMonth() {
		return calendarMonth;
	}

	public void setCalendarMonth(int calendarMonth) {
		this.calendarMonth = calendarMonth;
	}

	/**
	 * ֵ��ƻ���ѯ����ȡ��
	 * @return ֵ��ƻ���ѯ����
	 */
	public DutyPlanSearchCond getDutyPlanSearchCond() {
		return dutyPlanSearchCond;
	}

	/**
	 * ֵ��ƻ��趨��ѯ����
	 *
	 * @param dutyPlanSearchCond ֵ��ƻ���ѯ����
	 */
	public void setDutyPlanSearchCond(DutyPlanSearchCond dutyPlanSearchCond) {
		this.dutyPlanSearchCond = dutyPlanSearchCond;
	}

	/**
	 * �û���Ϣȡ��
	 * @return �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ֵ��ƻ��趨��ѯ����
	 *
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

/**
	 * ֵ���������б�ȡ��
	 * @return ֵ���������б�
	 */
	public List<DutyResult> getDutyResultList() {
		return dutyResultList;
	}

	/**
	 * ֵ���������б�
	 *
	 * @param dutyResultList ֵ���������б�
	 */
	public void setDutyResultList(List<DutyResult> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}
	
	/**
	 * ֵ������Ϣȡ��
	 * @return ֵ������Ϣ
	 */
	public String getUsersinfo() {
		return usersinfo;
	}

	/**
	 * ֵ������Ϣ�趨
	 *
	 * @param usersinfo ֵ������Ϣ
	 */
	public void setUsersinfo(String usersinfo) {
		this.usersinfo = usersinfo;
	}

	/**
	 * ֵ��ƻ�ȡ��
	 * @return ֵ��ƻ�
	 */
	public DutyPlan getDutyPlan() {
		return dutyPlan;
	}

	/**
	 * ֵ��ƻ��趨
	 *
	 * @param dutyPlan ֵ��ƻ�
	 */
	public void setDutyPlan(DutyPlan dutyPlan) {
		this.dutyPlan = dutyPlan;
	}

	/**
	 * ֵ�ཻ��Formȡ��
	 * @return ֵ�ཻ��Form
	 */
	public IGDUT0204Form getIgDUT0204Form() {
		return igDUT0204Form;
	}
	
	/**
	 * ֵ�ཻ��Form�趨
	 *
	 * @param igDUT0204Form ֵ�ཻ��Form
	 */
	public void setIgDUT0204Form(IGDUT0204Form igDUT0204Form) {
		this.igDUT0204Form = igDUT0204Form;
	}
	
	/**
	 * ֵ����ֹFormȡ��
	 * @return ֵ����ֹForm
	 */
	public IGDUT0207Form getIgDUT0207Form() {
		return igDUT0207Form;
	}

	/**
	 * ֵ����ֹForm�趨
	 *
	 * @param igDUT0207Form ֵ����ֹForm
	 */
	public void setIgDUT0207Form(IGDUT0207Form igDUT0207Form) {
		this.igDUT0207Form = igDUT0207Form;
	}

	/**
	 * ֵ����ȡ��
	 * @return ֵ����
	 */
	public List<DutyPersonTB> getDutyPersonList() {
		return dutyPersonList;
	}

	/**
	 * ֵ�����趨
	 *
	 * @param dutyPersonList ֵ����
	 */
	public void setDutyPersonList(List<DutyPersonTB> dutyPersonList) {
		this.dutyPersonList = dutyPersonList;
	}

	public List<UserRoleInfo> getDayShiftUsers() {
		return dayShiftUsers;
	}

	public void setDayShiftUsers(List<UserRoleInfo> dayShiftUsers) {
		this.dayShiftUsers = dayShiftUsers;
	}

	public List<UserRoleInfo> getNightShiftUsers() {
		return nightShiftUsers;
	}

	public void setNightShiftUsers(List<UserRoleInfo> nightShiftUsers) {
		this.nightShiftUsers = nightShiftUsers;
	}

	public List<UserRoleInfo> getDayShiftDutyUsers() {
		return dayShiftDutyUsers;
	}

	public void setDayShiftDutyUsers(List<UserRoleInfo> dayShiftDutyUsers) {
		this.dayShiftDutyUsers = dayShiftDutyUsers;
	}

	public List<UserRoleInfo> getNightShiftDutyUsers() {
		return nightShiftDutyUsers;
	}

	public void setNightShiftDutyUsers(List<UserRoleInfo> nightShiftDutyUsers) {
		this.nightShiftDutyUsers = nightShiftDutyUsers;
	}

	public IGDUT0202Form getIgdut0202Form() {
		return igdut0202Form;
	}

	public void setIgdut0202Form(IGDUT0202Form igdut0202Form) {
		this.igdut0202Form = igdut0202Form;
	}

	public Map<String, String> getDutyUserMap() {
		return dutyUserMap;
	}

	public void setDutyUserMap(Map<String, String> dutyUserMap) {
		this.dutyUserMap = dutyUserMap;
	}

	public IGDUT0201Form getIgdut0201Form() {
		return igdut0201Form;
	}

	public void setIgdut0201Form(IGDUT0201Form igdut0201Form) {
		this.igdut0201Form = igdut0201Form;
	}

	public boolean isCanChangeDuty() {
		return canChangeDuty;
	}

	public void setCanChangeDuty(boolean canChangeDuty) {
		this.canChangeDuty = canChangeDuty;
	}

	public String getTodayYMD() {
		return todayYMD;
	}

	public void setTodayYMD(String todayYMD) {
		this.todayYMD = todayYMD;
	}

	/**
	 * ֵ������Formȡ��
	 * @return ֵ������Form
	 */
	public IGDUT0206Form getIgDUT0206Form() {
		return igDUT0206Form;
	}

	/**
	 * ֵ������Form�趨
	 * @param igDUT0206Form ֵ������Form
	 */
	public void setIgDUT0206Form(IGDUT0206Form igDUT0206Form) {
		this.igDUT0206Form = igDUT0206Form;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ֵ������Ϣ����������ȡ��
	 * @return ֵ������Ϣ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ֵ������Ϣ�����������趨
	 * @param maxSearchCount ֵ������Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ֵ��ƻ������б�ȡ��
	 * @return ֵ��ƻ�
	 */
	public List<DutyPlan> getDutyPlanList() {
		return dutyPlanList;
	}

	/**
	 * ֵ��ƻ��趨
	 * @param dutyPlanList ֵ��ƻ�
	 */
	public void setDutyPlanList(List<DutyPlan> dutyPlanList) {
		this.dutyPlanList = dutyPlanList;
	}

	/**
	 * �Ƿ���δ�����ȡ��
	 * @return �Ƿ���δ�����
	 */
	public String getHasNullDrcontent() {
		return hasNullDrcontent;
	}

	/**
	 * �Ƿ���δ�����
	 * @param hasNullDrcontent �Ƿ���δ�����
	 */
	public void setHasNullDrcontent(String hasNullDrcontent) {
		this.hasNullDrcontent = hasNullDrcontent;
	}

	/**
	 * ֵ��ƻ���עȡ��
	 *
	 * @return dpremarks ֵ��ƻ���ע
	 */
	public String getDpremarks() {
		return dpremarks;
	}

	/**
	 * ֵ��ƻ���ע�趨
	 *
	 * @param dpremarks ֵ��ƻ���ע
	 */
	public void setDpremarks(String dpremarks) {
		this.dpremarks = dpremarks;
	}
	
}
