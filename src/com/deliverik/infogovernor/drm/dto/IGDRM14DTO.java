/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM1401Form;
import com.deliverik.infogovernor.drm.form.IGDRM1402Form;
import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;
import com.deliverik.infogovernor.sym.model.Notice;
import com.deliverik.infogovernor.sym.model.condition.NoticeSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM14DTO extends BaseDTO implements Serializable {
	
	/**
	 * 通知对象
	 */
	
	protected Notice notice;
	/**
	 * 通知查询Bean
	 */
	
	protected NoticeSearchCond noticeSearchCond;
	
	/**
	 * 通知对象List
	 */
	
	protected List<Notice> noticeCondList;
	
	/**
	 * 通知对象List（下拉列表用）
	 */
	
	protected List<Notice> noticeList;
	protected List<DateWorkVWInfo> dateWorkList;
	/**
	 * 允许查询的最大记录数
	 */
	
	protected int maxSearchCount;

	/**
	 * 分页Bean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * 通知删除主键
	 */
	
	protected String[] deleteNid;
	
	/**
	 * 变更用通知基本信息
	 */
	protected IGDRM1402Form igdrm1402Form;
	/**
	 * 通知详细Form
	 */
	protected IGDRM1401Form igdrm1401Form;
	/**
	 * 获取通知对象
	 * @return Notice
	 */
	/**
	 * 设置附件用
	 */
	protected IGDRM1402Form attachFile;
	
	protected User user;
	
	public Notice getNotice() {
		return notice;
	}

	/**
	 * 设置通知对象
	 * @param notice Notice
	 */
	
	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	/**
	 * 获取通知查询Bean
	 * @return NoticeSearchCond
	 */
	
	public NoticeSearchCond getNoticeSearchCond() {
		return noticeSearchCond;
	}

	/**
	 * 设置通知查询Bean
	 * @param noticeSearchCond NoticeSearchCond
	 */
	
	public void setNoticeSearchCond(
			NoticeSearchCond noticeSearchCond) {
		this.noticeSearchCond = noticeSearchCond;
	}

	/**
	 * 获取通知对象List
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticeCondList() {
		return noticeCondList;
	}
	
	/**
	 * 获取通知对象List（下拉列表用）
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticeList() {
		return noticeList;
	}

	/**
	 * 设置通知对象List
	 * @param noticeCondList List<Notice>
	 */
	
	public void setNoticeCondList(List<Notice> noticeCondList) {
		this.noticeCondList = noticeCondList;
	}
	
	/**
	 * 设置通知对象List（下拉列表用）
	 * @param noticeList List<Notice>
	 */
	
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
	/**
	 * 获取允许查询的最大记录数
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 设置允许查询的最大记录数
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 获取分页Bean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 设置分页Bean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 获取通知删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteNid() {
		return deleteNid;
	}

	/**
	 * 设置通知删除主键
	 * @param deleteNid String[]
	 */
	
	public void setDeleteNid(String[] deleteNid) {
		this.deleteNid = deleteNid;
	}

	/**
	 * 获取变更用通知基本信息
	 * @return IGDRM1402Form
	 */
	
	public IGDRM1402Form getIgdrm1402Form() {
		return igdrm1402Form;
	}

	/**
	 * 设置变更用通知基本信息
	 * @return igdrm1402Form IGDRM1402Form
	 */
	
	public void setIgdrm1402Form(IGDRM1402Form igdrm1402Form) {
		this.igdrm1402Form = igdrm1402Form;
	}

	public IGDRM1401Form getIgdrm1401Form() {
		return igdrm1401Form;
	}

	public void setIgdrm1401Form(IGDRM1401Form igdrm1401Form) {
		this.igdrm1401Form = igdrm1401Form;
	}

	public IGDRM1402Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGDRM1402Form attachFile) {
		this.attachFile = attachFile;
	}
	public List<DateWorkVWInfo> getDateWorkList() {
		return dateWorkList;
	}

	public void setDateWorkList(List<DateWorkVWInfo> dateWorkList) {
		this.dateWorkList = dateWorkList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
