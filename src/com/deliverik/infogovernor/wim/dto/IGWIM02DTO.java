/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.dto;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
 * @Description ��������DTO
 * 
 * @date 2017��6��14��14:35:06
 * 
 * @author zyl
 *
 */
@SuppressWarnings("serial")
public class IGWIM02DTO extends BaseDTO{

	/** ��������Form */
	protected IGWIM0201Form igwim0201Form;
	
	/** ��ǰ��¼�û� */
	protected User user;
	
	/** �������� */
	protected Map<String,String> orgMap;
	
	/** �û��������� */
	List<Map<String,String>> userOrgList;
	
	/** ����ʵ����Ϣ */
	WorkInstanceInfo wiInfo;
	
	/** ����������־���� */
	List<WorkLogInfo> wlogList;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ������Ϣ */
	List<Map<String, String>> wiList;
	
	/** ��������Ϣ */
	List<String> dateList;
	
	/** ������(��)��Ϣ */
	List<String> dateToWeekYearList;

	/** ��Ӧ���� */
	protected HttpServletResponse response;
	
	/** ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮�� */
	protected String totalExcuteTime;
	
	/** �������������Ƿ�ʱδ����0��δ��ʱ��1���ѳ�ʱ�� */
	protected String isOverTime;
	
	/** ��ǰ�û�Ȩ�� 1���Ƽ����쵼��2�����ĸ����ˣ�3����ͨ�û� */
	protected String userPermission;
		
	/** �������� */
	protected String desc;
	
	/**
	 * ȡ�� ����ʱ��֮��
	 * 
	 * @return totalExcuteTime ����ʱ��֮��
	 */
	public String getTotalExcuteTime() {
		return totalExcuteTime;
	}

	/**
	 * �趨 ����ʱ��֮��
	 * 
	 * @param totalExcuteTime ����ʱ��֮��
	 */
	public void setTotalExcuteTime(String totalExcuteTime) {
		this.totalExcuteTime = totalExcuteTime;
	}

	/**
	 * ȡ�� ������(��)��Ϣ
	 * 
	 * @return dateToWeekYearList ������(��)��Ϣ
	 */
	public List<String> getDateToWeekYearList() {
		return dateToWeekYearList;
	}

	/**
	 * �趨 ������(��)��Ϣ
	 * 
	 * @param dateToWeekYearList ������(��)��Ϣ
	 */
	public void setDateToWeekYearList(List<String> dateToWeekYearList) {
		this.dateToWeekYearList = dateToWeekYearList;
	}

	/**
	 * ȡ�� ��������Ϣ
	 * 
	 * @return dateList ��������Ϣ
	 */
	public List<String> getDateList() {
		return dateList;
	}

	/**
	 * �趨 ��������Ϣ
	 * 
	 * @param dateList ��������Ϣ
	 */
	public void setDateList(List<String> dateList) {
		this.dateList = dateList;
	}

	/**
	 * ȡ�� ������Ϣ 
	 * 
	 * @return wiList ������Ϣ 
	 */
	public List<Map<String, String>> getWiList() {
		return wiList;
	}

	/**
	 * �趨 ������Ϣ 
	 * 
	 * @param wiList ������Ϣ 
	 */
	public void setWiList(List<Map<String, String>> wiList) {
		this.wiList = wiList;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 * @param ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
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
	 * @param ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}
	/**
	 * ȡ�� ����ʵ����Ϣ
	 * 
	 * @return wiInfo ����ʵ����Ϣ
	 */
	public WorkInstanceInfo getWiInfo() {
		return wiInfo;
	}
	/**
	 * �趨 ����ʵ����Ϣ
	 * 
	 * @param wiInfo ����ʵ����Ϣ
	 */
	public void setWiInfo(WorkInstanceInfo wiInfo) {
		this.wiInfo = wiInfo;
	}
	/**
	 * ȡ�� ����������־���� 
	 * 
	 * @return wlogList ����������־���� 
	 */
	public List<WorkLogInfo> getWlogList() {
		return wlogList;
	}
	/**
	 * �趨 ����������־���� 
	 * 
	 * @param wlogList ����������־���� 
	 */
	public void setWlogList(List<WorkLogInfo> wlogList) {
		this.wlogList = wlogList;
	}
	/**
	 * �û���������  ȡ��
	 * @return �û���������  
	 */
	public List<Map<String, String>> getUserOrgList() {
		return userOrgList;
	}
	/**
	 * �û��������� �趨
	 * @param �û��������� 
	 */
	public void setUserOrgList(List<Map<String, String>> userOrgList) {
		this.userOrgList = userOrgList;
	}

	/**
	 * ���������趨
	 * @param ��������
	 */
	public void setOrgMap(Map<String, String> orgMap) {
		this.orgMap = orgMap;
	}

	/**
	 * �������� ȡ��
	 * @return �������� 
	 */
	public Map<String, String> getOrgMap() {
		return orgMap;
	}

	/**
	 * ��������Formȡ��
	 * @return ��������Form
	 */
	public IGWIM0201Form getIgwim0201Form() {
		return igwim0201Form;
	}

	/**
	 * ��������Form�趨
	 * @param ��������Form
	 */
	public void setIgwim0201Form(IGWIM0201Form igwim0201Form) {
		this.igwim0201Form = igwim0201Form;
	}

	/**
	 * ��ǰ��¼�û�ȡ��
	 * @return ��ǰ��¼�û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ��ǰ��¼�û��趨
	 * @param ��ǰ��¼�û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��Ӧ����ȡ��
	 * @return ��Ӧ����
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * ��Ӧ�����趨
	 * @param ��Ӧ����
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	/**
	 * �������������Ƿ�ʱδ����0��δ��ʱ��1���ѳ�ʱ��ȡ��
	 * @return �������������Ƿ�ʱδ����0��δ��ʱ��1���ѳ�ʱ��
	 */
	public String getIsOverTime() {
		return isOverTime;
	}

	/**
	 * �������������Ƿ�ʱδ����0��δ��ʱ��1���ѳ�ʱ���趨
	 * @param �������������Ƿ�ʱδ����0��δ��ʱ��1���ѳ�ʱ��
	 */
	public void setIsOverTime(String isOverTime) {
		this.isOverTime = isOverTime;
	}

	public String getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(String userPermission) {
		this.userPermission = userPermission;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
