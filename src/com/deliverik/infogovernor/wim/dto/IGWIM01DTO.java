/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;
import com.deliverik.infogovernor.wim.form.IGWIM0102Form;
import com.deliverik.infogovernor.wim.model.WorkDefinitionInfo;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.vo.IGWIM01011VO;

/**
 * @Description ���������DTO
 * 
 * @date 2017��6��9��15:54:29
 * 
 * @author WangLiang
 *
 */
@SuppressWarnings("serial")
public class IGWIM01DTO extends BaseDTO{

	/** ���������Form */
	protected IGWIM0101Form igwim0101Form;
	
	/** �������ѯForm */
	protected IGWIM0102Form igwim0102Form;
	
	/** ��ǰ��¼�û� */
	protected User user;
	
	/** ������������ID */
	protected Integer wdid;
	
	/** �����ʱ�������/�Ƴ���ʶ��1����ӣ�2���Ƴ��� */
	protected String addOrRemoveFlag;
	
	/** ������ɾ������ */
	protected String[] deleteEntityItem;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ���������Ϣ */
	protected WorkDefinitionInfo workDefinitionInfo;
	
	/** ������ʵ����Ϣ */
	protected WorkInstanceInfo workInstanceInfo;
	
	/** Ƶ�������ڼ��� */
	protected List<IGWIM01011VO> weekList;
	
	/** Ƶ������������ */
	protected List<IGWIM01011VO> monthList;
	
	/** Ƶ��Сʱ���� */
	protected List<IGWIM01011VO> hourList;
	
	/** Ƶ�ʷּ��� */
	protected List<IGWIM01011VO> minutesList;
	
	/** ������弯��  */
	protected List<WorkDefinitionInfo> definitionInfos;
	
	/** �ֶ������ʶ:ֵ��Ϊ�մ����ֶ����� */
	protected String launchFlag;
	
	/** ��ʾ��Ϣ */
	protected String msg;
	
	/** �Ƿ������ĸ��������ϸ�λ��1���ǣ�0���� */
	protected String isLeader;
	
	/** ��Ч��ʶ 1����Ч��0����Ч */
	protected String isInvalid;
	
	/**
	 * ���������Formȡ��
	 * @return ���������Form
	 */
	public IGWIM0101Form getIgwim0101Form() {
		return igwim0101Form;
	}

	/**
	 * ���������Form�趨
	 * @param ���������Form
	 */
	public void setIgwim0101Form(IGWIM0101Form igwim0101Form) {
		this.igwim0101Form = igwim0101Form;
	}

	/**
	 * �������ѯFormȡ��
	 * @return �������ѯForm
	 */
	public IGWIM0102Form getIgwim0102Form() {
		return igwim0102Form;
	}

	/**
	 * �������ѯForm�趨
	 * @param �������ѯForm
	 */
	public void setIgwim0102Form(IGWIM0102Form igwim0102Form) {
		this.igwim0102Form = igwim0102Form;
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
	 * ������������IDȡ��
	 * @return ������������ID
	 */
	public Integer getWdid() {
		return wdid;
	}

	/**
	 * ������������ID�趨
	 * @param ������������ID
	 */
	public void setWdid(Integer wdid) {
		this.wdid = wdid;
	}

	/**
	 * �����ʱ�������/�Ƴ���ʶ��1����ӣ�2���Ƴ���ȡ��
	 * @return �����ʱ�������/�Ƴ���ʶ��1����ӣ�2���Ƴ���
	 */
	public String getAddOrRemoveFlag() {
		return addOrRemoveFlag;
	}

	/**
	 * �����ʱ�������/�Ƴ���ʶ��1����ӣ�2���Ƴ����趨
	 * @param �����ʱ�������/�Ƴ���ʶ��1����ӣ�2���Ƴ���
	 */
	public void setAddOrRemoveFlag(String addOrRemoveFlag) {
		this.addOrRemoveFlag = addOrRemoveFlag;
	}

	/**
	 * ������ɾ������ȡ��
	 * @return ������ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ������ɾ�������趨
	 * @param ������ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
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
	 * ���������Ϣȡ��
	 * @return ���������Ϣ
	 */
	public WorkDefinitionInfo getWorkDefinitionInfo() {
		return workDefinitionInfo;
	}

	/**
	 * ���������Ϣ�趨
	 * @param ���������Ϣ
	 */
	public void setWorkDefinitionInfo(WorkDefinitionInfo workDefinitionInfo) {
		this.workDefinitionInfo = workDefinitionInfo;
	}

	/**
	 * ������ʵ����Ϣȡ��
	 * @return ������ʵ����Ϣ
	 */
	public WorkInstanceInfo getWorkInstanceInfo() {
		return workInstanceInfo;
	}

	/**
	 * ������ʵ����Ϣ�趨
	 * @param ������ʵ����Ϣ
	 */
	public void setWorkInstanceInfo(WorkInstanceInfo workInstanceInfo) {
		this.workInstanceInfo = workInstanceInfo;
	}

	/**
	 * Ƶ�������ڼ���ȡ��
	 * @return Ƶ�������ڼ���
	 */
	public List<IGWIM01011VO> getWeekList() {
		return weekList;
	}

	/**
	 * Ƶ�������ڼ����趨
	 * @param Ƶ�������ڼ���
	 */
	public void setWeekList(List<IGWIM01011VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * Ƶ������������ȡ��
	 * @return Ƶ������������
	 */
	public List<IGWIM01011VO> getMonthList() {
		return monthList;
	}

	/**
	 * Ƶ�������������趨
	 * @param Ƶ������������
	 */
	public void setMonthList(List<IGWIM01011VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * Ƶ��Сʱ����ȡ��
	 * @return Ƶ��Сʱ����
	 */
	public List<IGWIM01011VO> getHourList() {
		return hourList;
	}

	/**
	 * Ƶ��Сʱ�����趨
	 * @param Ƶ��Сʱ����
	 */
	public void setHourList(List<IGWIM01011VO> hourList) {
		this.hourList = hourList;
	}

	/**
	 * Ƶ�ʷּ���ȡ��
	 * @return Ƶ�ʷּ���
	 */
	public List<IGWIM01011VO> getMinutesList() {
		return minutesList;
	}

	/**
	 * Ƶ�ʷּ����趨
	 * @param Ƶ�ʷּ���
	 */
	public void setMinutesList(List<IGWIM01011VO> minutesList) {
		this.minutesList = minutesList;
	}

	/**
	 * ������弯��ȡ��
	 * @return ������弯��
	 */
	public List<WorkDefinitionInfo> getDefinitionInfos() {
		return definitionInfos;
	}

	/**
	 * ������弯���趨
	 * @param ������弯��
	 */
	public void setDefinitionInfos(List<WorkDefinitionInfo> definitionInfos) {
		this.definitionInfos = definitionInfos;
	}

	/**
	 * �ֶ������ʶ:ֵ��Ϊ�մ����ֶ�����ȡ��
	 * @return �ֶ������ʶ:ֵ��Ϊ�մ����ֶ�����
	 */
	public String getLaunchFlag() {
		return launchFlag;
	}

	/**
	 * �ֶ������ʶ:ֵ��Ϊ�մ����ֶ������趨
	 * @param �ֶ������ʶ:ֵ��Ϊ�մ����ֶ�����
	 */
	public void setLaunchFlag(String launchFlag) {
		this.launchFlag = launchFlag;
	}

	/**
	 * ��ʾ��Ϣȡ��
	 * @return ��ʾ��Ϣ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ��ʾ��Ϣ�趨
	 * @param ��ʾ��Ϣ
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * �Ƿ������ĸ��������ϸ�λ��1���ǣ�0����ȡ��
	 * @return �Ƿ������ĸ��������ϸ�λ��1���ǣ�0����
	 */
	public String getIsLeader() {
		return isLeader;
	}

	/**
	 * �Ƿ������ĸ��������ϸ�λ��1���ǣ�0�����趨
	 * @param �Ƿ������ĸ��������ϸ�λ��1���ǣ�0����
	 */
	public void setIsLeader(String isLeader) {
		this.isLeader = isLeader;
	}

	/**
	 * ��Ч��ʶ 1����Ч��0����Ч ȡ��
	 * @return ��Ч��ʶ 1����Ч��0����Ч 
	 */
	public String getIsInvalid() {
		return isInvalid;
	}

	/**
	 * ��Ч��ʶ 1����Ч��0����Ч �趨
	 * @param ��Ч��ʶ 1����Ч��0����Ч 
	 */
	public void setIsInvalid(String isInvalid) {
		this.isInvalid = isInvalid;
	}

	
	
}
