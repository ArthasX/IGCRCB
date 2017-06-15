/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_֪ͨ����_DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM14DTO extends BaseDTO implements Serializable {
	
	/**
	 * ֪ͨ����
	 */
	
	protected Notice notice;
	/**
	 * ֪ͨ��ѯBean
	 */
	
	protected NoticeSearchCond noticeSearchCond;
	
	/**
	 * ֪ͨ����List
	 */
	
	protected List<Notice> noticeCondList;
	
	/**
	 * ֪ͨ����List�������б��ã�
	 */
	
	protected List<Notice> noticeList;
	protected List<DateWorkVWInfo> dateWorkList;
	/**
	 * �����ѯ������¼��
	 */
	
	protected int maxSearchCount;

	/**
	 * ��ҳBean
	 */
	
	protected PagingDTO pagingDto;
	
	/**
	 * ֪ͨɾ������
	 */
	
	protected String[] deleteNid;
	
	/**
	 * �����֪ͨ������Ϣ
	 */
	protected IGDRM1402Form igdrm1402Form;
	/**
	 * ֪ͨ��ϸForm
	 */
	protected IGDRM1401Form igdrm1401Form;
	/**
	 * ��ȡ֪ͨ����
	 * @return Notice
	 */
	/**
	 * ���ø�����
	 */
	protected IGDRM1402Form attachFile;
	
	protected User user;
	
	public Notice getNotice() {
		return notice;
	}

	/**
	 * ����֪ͨ����
	 * @param notice Notice
	 */
	
	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	/**
	 * ��ȡ֪ͨ��ѯBean
	 * @return NoticeSearchCond
	 */
	
	public NoticeSearchCond getNoticeSearchCond() {
		return noticeSearchCond;
	}

	/**
	 * ����֪ͨ��ѯBean
	 * @param noticeSearchCond NoticeSearchCond
	 */
	
	public void setNoticeSearchCond(
			NoticeSearchCond noticeSearchCond) {
		this.noticeSearchCond = noticeSearchCond;
	}

	/**
	 * ��ȡ֪ͨ����List
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticeCondList() {
		return noticeCondList;
	}
	
	/**
	 * ��ȡ֪ͨ����List�������б��ã�
	 * @return List<Notice>
	 */
	
	public List<Notice> getNoticeList() {
		return noticeList;
	}

	/**
	 * ����֪ͨ����List
	 * @param noticeCondList List<Notice>
	 */
	
	public void setNoticeCondList(List<Notice> noticeCondList) {
		this.noticeCondList = noticeCondList;
	}
	
	/**
	 * ����֪ͨ����List�������б��ã�
	 * @param noticeList List<Notice>
	 */
	
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}
	
	/**
	 * ��ȡ�����ѯ������¼��
	 * @return int
	 */
	
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ���������ѯ������¼��
	 * @param maxSearchCount int
	 */
	
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ȡ��ҳBean
	 * @return PagingDTO
	 */
	
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ���÷�ҳBean
	 * @param pagingDto PagingDTO
	 */
	
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��ȡ֪ͨɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteNid() {
		return deleteNid;
	}

	/**
	 * ����֪ͨɾ������
	 * @param deleteNid String[]
	 */
	
	public void setDeleteNid(String[] deleteNid) {
		this.deleteNid = deleteNid;
	}

	/**
	 * ��ȡ�����֪ͨ������Ϣ
	 * @return IGDRM1402Form
	 */
	
	public IGDRM1402Form getIgdrm1402Form() {
		return igdrm1402Form;
	}

	/**
	 * ���ñ����֪ͨ������Ϣ
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
