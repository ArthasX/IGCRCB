package com.deliverik.infogovernor.soc.vir.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR0702Form;
import com.deliverik.infogovernor.soc.vir.model.VIM01Info;

/**
 * 虚拟化管理业务用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGVIR07DTO extends BaseDTO implements Serializable{
	
	protected IGVIR0702Form igVIR0702Form;

	/** vCenter检索结果 */
	protected List<VIM01Info> vim01InfoList;
	
	/** url查重标识	1：重复	0：未重 */
	protected String urlcheckflag;

	/**
	 * igVIR0702Form取得
	 * @return igVIR0702Form igVIR0702Form
	 */
	public IGVIR0702Form getIgVIR0702Form() {
		return igVIR0702Form;
	}


	/**
	 * igVIR0702Form设定
	 * @param igVIR0702Form igVIR0702Form
	 */
	public void setIgVIR0702Form(IGVIR0702Form igVIR0702Form) {
		this.igVIR0702Form = igVIR0702Form;
	}


	/**
	 * vCenter检索结果取得
	 * @return vim01InfoList vCenter检索结果
	 */
	public List<VIM01Info> getVim01InfoList() {
		return vim01InfoList;
	}


	/**
	 * vCenter检索结果设定
	 * @param vim01InfoList vCenter检索结果
	 */
	public void setVim01InfoList(List<VIM01Info> vim01InfoList) {
		this.vim01InfoList = vim01InfoList;
	}


	/**
	 * url查重标识1：重复0：未重取得
	 * @return urlcheckflag url查重标识1：重复0：未重
	 */
	public String getUrlcheckflag() {
		return urlcheckflag;
	}


	/**
	 * url查重标识1：重复0：未重设定
	 * @param urlcheckflag url查重标识1：重复0：未重
	 */
	public void setUrlcheckflag(String urlcheckflag) {
		this.urlcheckflag = urlcheckflag;
	}


}


