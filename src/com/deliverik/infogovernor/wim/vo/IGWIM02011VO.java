/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.WorkLogInfo;

/**
 * @Description ���������VO
 * 
 * @date 2017��6��9��16:09:40
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM02011VO extends BaseVO{

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
	
	/** �����Ƿ�ʱδ�����ʶ��0��δ��ʱ��1���ѳ�ʱ�� */
	protected String isOverTime;
	
	/** �������� */
	protected String desc;
	
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
	 * �����Ƿ�ʱδ�����ʶ��0��δ��ʱ��1���ѳ�ʱ��ȡ��
	 * @return �����Ƿ�ʱδ�����ʶ��0��δ��ʱ��1���ѳ�ʱ��
	 */
	public String getIsOverTime() {
		return isOverTime;
	}

	/**
	 * �����Ƿ�ʱδ�����ʶ��0��δ��ʱ��1���ѳ�ʱ���趨
	 * @param �����Ƿ�ʱδ�����ʶ��0��δ��ʱ��1���ѳ�ʱ��
	 */
	public void setIsOverTime(String isOverTime) {
		this.isOverTime = isOverTime;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
}
