/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0302Form;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼DTO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSDL03DTO extends BaseDTO implements Serializable {
	
	/**��׼��Ϣ*/
	protected SdlDefineInfo sdlDefineInfo;
	
	/**��׼��ѯBean */
	protected SdlDefineInfoSearchCond sdlDefineInfoSearchCond;
	
	/**��׼��ϢList*/
	protected List<SdlDefineInfo> sdlDefineInfoList;

	/**�����ѯ������¼��*/
	protected int maxSearchCount;

	/**��ҳBean*/
	protected PagingDTO pagingDto;
	
	/**��׼ɾ������*/
	protected String[] deleteSdlDefineInfoid;
	
	/**��׼����Form*/
	protected IGSDL0302Form igsdl0302Form;
	
	/**
	 * ��ȡ��׼��Ϣ
	 * @return SdlDefineInfo
	 */
	
	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}

	/**
	 * ���ñ�׼��Ϣ
	 * @param sdlDefineInfo SdlDefineInfo
	 */
	
	public void setSdlDefineInfo(SdlDefineInfo sdlDefineInfo) {
		this.sdlDefineInfo = sdlDefineInfo;
	}

	/**
	 * ��ȡ��׼��ѯBean
	 * @return SdlDefineInfoSearchCond
	 */
	
	public SdlDefineInfoSearchCond getSdlDefineInfoSearchCond() {
		return sdlDefineInfoSearchCond;
	}

	/**
	 * ���ñ�׼��ѯBean
	 * @param sdlDefineInfoSearchCond SdlDefineInfoSearchCond
	 */
	
	public void setSdlDefineInfoSearchCond(
			SdlDefineInfoSearchCond sdlDefineInfoSearchCond) {
		this.sdlDefineInfoSearchCond = sdlDefineInfoSearchCond;
	}

	/**
	 * ��ȡ��׼��ϢList
	 * @return List<SdlDefineInfo>
	 */
	
	public List<SdlDefineInfo> getSdlDefineInfoList() {
		return sdlDefineInfoList;
	}

	/**
	 * ���ñ�׼��ϢList
	 * @param sdlDefineInfoList List<SdlDefineInfo>
	 */
	
	public void setSdlDefineInfoList(List<SdlDefineInfo> sdlDefineInfoList) {
		this.sdlDefineInfoList = sdlDefineInfoList;
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
	 * ��ȡ��׼ɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteSdlDefineInfoid() {
		return deleteSdlDefineInfoid;
	}

	/**
	 * ���ñ�׼ɾ������
	 * @param deleteSdlDefineInfoid String[]
	 */
	
	public void setDeleteSdlDefineInfoid(String[] deleteSdlDefineInfoid) {
		this.deleteSdlDefineInfoid = deleteSdlDefineInfoid;
	}

	/**
	 * ��ȡ��׼����Form
	 * @return IGSDL0302Form
	 */
	public IGSDL0302Form getIgsdl0302Form() {
		return igsdl0302Form;
	}

	/**
	 * ���ñ�׼����Form
	 * @param igsdl0302Form IGSDL0302Form
	 */
	public void setIgsdl0302Form(IGSDL0302Form igsdl0302Form) {
		this.igsdl0302Form = igsdl0302Form;
	}

}
