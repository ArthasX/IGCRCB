/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.dto;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dut.form.IGDUT0401Form;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCond;

/**
 * ��ʱ����DTO
 */
public class IGDUT04DTO extends BaseDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ��¼�û�
	 */
	protected User user;
	
	/**
	 * ��ʱ������������
	 */
	protected DelaySearchCond delaySearchCond;
	
	/**
	 * �ӳٽ���Form
	 */
	protected IGDUT0401Form igdut0401Form;
	
	/**
	 * ��ʱ���������
	 */
	protected List<DelayInfo> delayList;
	
	/**
	 * ɾ������
	 */
	protected String[] deleteId;
	
	/**
	 * ��ҳBean
	 */
	protected PagingDTO pagingDto;
	
	protected List<LabelValueBean> titleList;
	
	protected int maxSearchCount;

	/**
	 * ��¼�û�ȡ��
	 * @return
	 */
	public User getUser() {
		return user;
	}

	/**
	 * ��¼�û��趨
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * �ӳٽ���Formȡ��
	 * @return
	 */
	public IGDUT0401Form getIgdut0401Form() {
		return igdut0401Form;
	}

	/**
	 * �ӳٽ���Form�趨
	 * @param igdut0401Form
	 */
	public void setIgdut0401Form(IGDUT0401Form igdut0401Form) {
		this.igdut0401Form = igdut0401Form;
	}

	/**
	 * ��ʱ������������ȡ��
	 * @return
	 */
	public DelaySearchCond getDelaySearchCond() {
		return delaySearchCond;
	}

	/**
	 * ��ʱ�������������趨
	 * @param delaySearchCond
	 */
	public void setDelaySearchCond(DelaySearchCond delaySearchCond) {
		this.delaySearchCond = delaySearchCond;
	}

	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ʱ���������ȡ��
	 * @return
	 */
	public List<DelayInfo> getDelayList() {
		return delayList;
	}

	/**
	 * ��ʱ����������趨
	 * @param delayList
	 */
	public void setDelayList(List<DelayInfo> delayList) {
		this.delayList = delayList;
	}

	/**
	 * ɾ������ȡ��
	 * @return
	 */
	public String[] getDeleteId() {
		return deleteId;
	}

	/**
	 * ɾ�������趨
	 * @param deleteRoleid
	 */
	public void setDeleteId(String[] deleteId) {
		this.deleteId = deleteId;
	}

	public List<LabelValueBean> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<LabelValueBean> titleList) {
		this.titleList = titleList;
	}

}
