/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.wim.dto;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.wim.form.IGWIM0101Form;

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
	
	/** ��ǰ��¼�û� */
	protected User user;

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
}
