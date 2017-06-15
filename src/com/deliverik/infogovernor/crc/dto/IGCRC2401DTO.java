/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401Cond;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决时间DTO
 * </p>
 * 
 * @author 
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCRC2401DTO extends BaseDTO implements Serializable{
	
	/**事件平均解决时间Form*/
	private IGCRC2401Form igcrc2401Form;

	/**事件平均解决时间查询条件*/
	private IGCRC2401Cond cond;
	
	/**事件平均解决时间集合*/
	private List<IGCRC2402VO> igcrc2402voList;
	

	/***/
//	private List<String> deptList;
//
//	public List<String> getDeptList() {
//		return deptList;
//	}
//
//	public void setDeptList(List<String> deptList) {
//		this.deptList = deptList;
//	}

	public IGCRC2401Form getIgcrc2401Form() {
		return igcrc2401Form;
	}

	public void setIgcrc2401Form(IGCRC2401Form igcrc2401Form) {
		this.igcrc2401Form = igcrc2401Form;
	}

	public IGCRC2401Cond getCond() {
		return cond;
	}

	public void setCond(IGCRC2401Cond cond) {
		this.cond = cond;
	}

	/**
	 * 事件平均解决时间集合取得
	 * @return igcrc2402voList  事件平均解决时间集合
	 */
	public List<IGCRC2402VO> getIgcrc2402voList() {
		return igcrc2402voList;
	}

	/**
	 * 事件平均解决时间集合设定
	 * @param igcrc2402voList  事件平均解决时间集合
	 */
	public void setIgcrc2402voList(List<IGCRC2402VO> igcrc2402voList) {
		this.igcrc2402voList = igcrc2402voList;
	}



}
