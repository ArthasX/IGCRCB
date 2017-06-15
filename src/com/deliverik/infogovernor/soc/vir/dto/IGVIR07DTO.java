package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0702Form;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;

/**
 * ���⻯����ҵ����DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR07DTO extends BaseDTO implements Serializable{
	
	protected IGVIR0702Form igVIR0702Form;

	/** vCenter������� */
	protected List<VIM01Info> vim01InfoList;
	
	/** url���ر�ʶ	1���ظ�	0��δ�� */
	protected String urlcheckflag;

	/**
	 * igVIR0702Formȡ��
	 * @return igVIR0702Form igVIR0702Form
	 */
	public IGVIR0702Form getIgVIR0702Form() {
		return igVIR0702Form;
	}


	/**
	 * igVIR0702Form�趨
	 * @param igVIR0702Form igVIR0702Form
	 */
	public void setIgVIR0702Form(IGVIR0702Form igVIR0702Form) {
		this.igVIR0702Form = igVIR0702Form;
	}


	/**
	 * vCenter�������ȡ��
	 * @return vim01InfoList vCenter�������
	 */
	public List<VIM01Info> getVim01InfoList() {
		return vim01InfoList;
	}


	/**
	 * vCenter��������趨
	 * @param vim01InfoList vCenter�������
	 */
	public void setVim01InfoList(List<VIM01Info> vim01InfoList) {
		this.vim01InfoList = vim01InfoList;
	}


	/**
	 * url���ر�ʶ1���ظ�0��δ��ȡ��
	 * @return urlcheckflag url���ر�ʶ1���ظ�0��δ��
	 */
	public String getUrlcheckflag() {
		return urlcheckflag;
	}


	/**
	 * url���ر�ʶ1���ظ�0��δ���趨
	 * @param urlcheckflag url���ر�ʶ1���ظ�0��δ��
	 */
	public void setUrlcheckflag(String urlcheckflag) {
		this.urlcheckflag = urlcheckflag;
	}


}


