/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度统计查询的DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC2001DTO extends BaseDTO implements Serializable{
	
	/**年度工作统计列合计的集合*/
	private List<Integer> sumList;
	
	/**年度工作统计内容和行合计的集合*/
	private List<IGCRC2002VO> igcrc2002voList;

	/**年度查询Form*/
	private IGCRC2001Form igcrc2001Form;
	
	/**年度查询条件*/
	private IGCRC2001Cond cond;
	
	
	public List<Integer> getSumList() {
		return sumList;
	}

	public void setSumList(List<Integer> sumList) {
		this.sumList = sumList;
	}

	public List<IGCRC2002VO> getIgcrc2002voList() {
		return igcrc2002voList;
	}

	public void setIgcrc2002voList(List<IGCRC2002VO> igcrc2002voList) {
		this.igcrc2002voList = igcrc2002voList;
	}

	public IGCRC2001Cond getCond() {
		return cond;
	}

	public void setCond(IGCRC2001Cond cond) {
		this.cond = cond;
	}

	
	public IGCRC2001Form getIgcrc2001Form() {
		return igcrc2001Form;
	}

	public void setIgcrc2001Form(IGCRC2001Form igcrc2001Form) {
		this.igcrc2001Form = igcrc2001Form;
	}

}
