/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dbm.form.IGDBM1301Form;
import com.deliverik.infogovernor.dbm.form.IGDBM1302Form;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.vo.IGDBM13012VO;

@SuppressWarnings("serial")
public class IGDBM13DTO extends BaseDTO{
	protected Integer wmid;
	
	//���������ѯform
	protected IGDBM1301Form igdbm1301Form;
		
	//������������form
	protected IGDBM1302Form igdbm1302Form;
	
	//������������
	protected List<WorkmanagerInfo> wmList;
	
	//��ǰ�û�
	protected User user;
	
	protected int maxSearchCount;
	
	protected PagingDTO pagingDto;
	
	/**Ƶ�������ڼ���*/
	protected List<IGDBM13012VO> weekList;
	
	/**Ƶ������������*/
	protected List<IGDBM13012VO> monthList;
	
	/** �༭������Ϣ */
	protected WorkmanagerInfo info;
	
	/**
	 * @return the �༭������Ϣ
	 */
	public WorkmanagerInfo getInfo() {
		return info;
	}

	/**
	 * @param �༭������Ϣ the info to set
	 */
	public void setInfo(WorkmanagerInfo info) {
		this.info = info;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the Ƶ�������ڼ���
	 */
	public List<IGDBM13012VO> getWeekList() {
		return weekList;
	}

	/**
	 * @param Ƶ�������ڼ��� the weekList to set
	 */
	public void setWeekList(List<IGDBM13012VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * @return the Ƶ������������
	 */
	public List<IGDBM13012VO> getMonthList() {
		return monthList;
	}

	/**
	 * @param Ƶ������������ the monthList to set
	 */
	public void setMonthList(List<IGDBM13012VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * @param pagingDto the pagingDto to set
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the igdbm1301Form
	 */
	public IGDBM1301Form getIgdbm1301Form() {
		return igdbm1301Form;
	}

	/**
	 * @param igdbm1301Form the igdbm1301Form to set
	 */
	public void setIgdbm1301Form(IGDBM1301Form igdbm1301Form) {
		this.igdbm1301Form = igdbm1301Form;
	}

	/**
	 * @return the igdbm1302Form
	 */
	public IGDBM1302Form getIgdbm1302Form() {
		return igdbm1302Form;
	}

	/**
	 * @param igdbm1302Form the igdbm1302Form to set
	 */
	public void setIgdbm1302Form(IGDBM1302Form igdbm1302Form) {
		this.igdbm1302Form = igdbm1302Form;
	}

	/**
	 * @return the wmList
	 */
	public List<WorkmanagerInfo> getWmList() {
		return wmList;
	}

	/**
	 * @param wmList the wmList to set
	 */
	public void setWmList(List<WorkmanagerInfo> wmList) {
		this.wmList = wmList;
	}
	
}
