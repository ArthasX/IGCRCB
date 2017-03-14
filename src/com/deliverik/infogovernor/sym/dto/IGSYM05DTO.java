/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.form.IGSYM0501Form;
import com.deliverik.infogovernor.sym.form.IGSYM0502Form;
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
public class IGSYM05DTO extends BaseDTO implements Serializable {
	
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
	protected IGSYM0502Form igsym0502Form;
	/**
	 * ֪ͨ��ϸForm
	 */
	protected IGSYM0501Form igsym0501Form;
	/**
	 * ��ȡ֪ͨ����
	 * @return Notice
	 */
	/**
	 * ���ø�����
	 */
	protected IGSYM0502Form attachFile;
	
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
	 * @return IGSYM0502Form
	 */
	
	public IGSYM0502Form getIgsym0502Form() {
		return igsym0502Form;
	}

	/**
	 * ���ñ����֪ͨ������Ϣ
	 * @return igsym0502Form IGSYM0502Form
	 */
	
	public void setIgsym0502Form(IGSYM0502Form igsym0502Form) {
		this.igsym0502Form = igsym0502Form;
	}

	public IGSYM0501Form getIgsym0501Form() {
		return igsym0501Form;
	}

	public void setIgsym0501Form(IGSYM0501Form igsym0501Form) {
		this.igsym0501Form = igsym0501Form;
	}

	public IGSYM0502Form getAttachFile() {
		return attachFile;
	}

	public void setAttachFile(IGSYM0502Form attachFile) {
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
