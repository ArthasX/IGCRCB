/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.dto;


import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.form.IGDRM1101Form;
import com.deliverik.infogovernor.drm.form.IGDRM1102Form;

/**
 * �����ƻ�DTO
 *
 */
@SuppressWarnings("serial")
public class IGDRM11DTO extends BaseDTO {
	
	/**ǩ��form*/
	protected IGDRM1101Form igdrm1101Form;
	
	/**��ǩ��form*/
	protected IGDRM1102Form igdrm1102Form;
	
	/**��ǩ��Map*/
	protected List<Map<String,Object>> signinMap ;
	
	/** ����ѯ���� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** �û����� */
	protected User user;

	/**
	 * ǩ��formȡ��
	 * @return igdrm1101Form ǩ��form
	 */
	public IGDRM1101Form getIgdrm1101Form() {
		return igdrm1101Form;
	}

	/**
	 * ǩ��form�趨
	 * @param igdrm1101Form ǩ��form
	 */
	public void setIgdrm1101Form(IGDRM1101Form igdrm1101Form) {
		this.igdrm1101Form = igdrm1101Form;
	}

	/**
	 * ��ǩ��formȡ��
	 * @return igdrm1102Form ��ǩ��form
	 */
	public IGDRM1102Form getIgdrm1102Form() {
		return igdrm1102Form;
	}

	/**
	 * ��ǩ��form�趨
	 * @param igdrm1102Form ��ǩ��form
	 */
	public void setIgdrm1102Form(IGDRM1102Form igdrm1102Form) {
		this.igdrm1102Form = igdrm1102Form;
	}

	/**
	 * ��ǩ��Mapȡ��
	 * @return signinMap ��ǩ��Map
	 */
	public List<Map<String, Object>> getSigninMap() {
		return signinMap;
	}

	/**
	 * ��ǩ��Map�趨
	 * @param signinMap ��ǩ��Map
	 */
	public void setSigninMap(List<Map<String, Object>> signinMap) {
		this.signinMap = signinMap;
	}

	/**
	 * ����ѯ����ȡ��
	 * @return maxSearchCount ����ѯ����
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ����ѯ�����趨
	 * @param maxSearchCount ����ѯ����
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return pagingDto ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �û�����ȡ��
	 * @return user �û�����
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û������趨
	 * @param user �û�����
	 */
	public void setUser(User user) {
		this.user = user;
	}
}