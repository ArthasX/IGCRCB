/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sdl.form.IGSDL0402Form;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��ϢDTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL04DTO extends BaseDTO implements Serializable {
	
	/**��Ϣ*/
	protected SdlInfo sdlInfo;
	
	/**��Ϣ��ѯBean */
	protected SdlInfoSearchCond sdlInfoSearchCond;
	
	/**��ϢList*/
	protected List<SdlInfo> sdlInfoList;

	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**��Ϣɾ������*/
	protected String[] deleteSdlInfoid;
	
	/**��Ϣ����Form*/
	protected IGSDL0402Form igsdl0402Form;
	
	/**��ϢID*/
	protected Integer siid;
	
	/**����*/
	protected List<Attachment> attachmentList;
	
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Integer getSiid() {
		return siid;
	}

	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * ��ȡ��Ϣ
	 * @return SdlInfo
	 */
	
	public SdlInfo getSdlInfo() {
		return sdlInfo;
	}

	/**
	 * ������Ϣ
	 * @param sdlInfo SdlInfo
	 */
	
	public void setSdlInfo(SdlInfo sdlInfo) {
		this.sdlInfo = sdlInfo;
	}

	/**
	 * ��ȡ��Ϣ��ѯBean
	 * @return SdlInfoSearchCond
	 */
	
	public SdlInfoSearchCond getSdlInfoSearchCond() {
		return sdlInfoSearchCond;
	}

	/**
	 * ������Ϣ��ѯBean
	 * @param sdlInfoSearchCond SdlInfoSearchCond
	 */
	
	public void setSdlInfoSearchCond(
			SdlInfoSearchCond sdlInfoSearchCond) {
		this.sdlInfoSearchCond = sdlInfoSearchCond;
	}

	/**
	 * ��ȡ��ϢList
	 * @return List<SdlInfo>
	 */
	
	public List<SdlInfo> getSdlInfoList() {
		return sdlInfoList;
	}

	/**
	 * ������ϢList
	 * @param sdlInfoList List<SdlInfo>
	 */
	
	public void setSdlInfoList(List<SdlInfo> sdlInfoList) {
		this.sdlInfoList = sdlInfoList;
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
	 * ��ȡ��Ϣɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteSdlInfoid() {
		return deleteSdlInfoid;
	}

	/**
	 * ������Ϣɾ������
	 * @param deleteSdlInfoid String[]
	 */
	
	public void setDeleteSdlInfoid(String[] deleteSdlInfoid) {
		this.deleteSdlInfoid = deleteSdlInfoid;
	}

	/**
	 * ��ȡ��Ϣ����Form
	 * @return IGSDL0402Form
	 */
	public IGSDL0402Form getIgsdl0402Form() {
		return igsdl0402Form;
	}

	/**
	 * ������Ϣ����Form
	 * @param igsdl0402Form IGSDL0402Form
	 */
	public void setIgsdl0402Form(IGSDL0402Form igsdl0402Form) {
		this.igsdl0402Form = igsdl0402Form;
	}

}
