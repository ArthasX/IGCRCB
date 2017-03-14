/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准查询删除Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0301Form extends BaseForm implements SdlDefineInfoSearchCond{

	/**年度*/
	protected String sdiyear;

	/**相关资产ID*/
	protected Integer sdieiid;

	/**资产名称 */
	protected String sdieiname;
	
	/**标准删除主键*/
	protected String[] deleteSdlDefineInfoid;
	
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * 设置年度
	 * @param sdiyear 年度
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getSdieiid() {
		if(sdieiid != null && sdieiid != 0){
			return sdieiid;
		}else{
			return null;
		}
	}

	/**
	 * 设置相关资产ID
	 * @param sdieiid 相关资产ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * 获取相关资产名字
	 * @return 相关资产名字
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * 设置相关资产名字
	 * @param sdieiname 相关资产名字
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}
	
	/**
	 * 获取标准删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteSdlDefineInfoid() {
		return deleteSdlDefineInfoid;
	}

	/**
	 * 设置标准删除主键
	 * @param deleteSdlDefineInfoid String[]
	 */
	
	public void setDeleteSdlDefineInfoid(String[] deleteSdlDefineInfoid) {
		this.deleteSdlDefineInfoid = deleteSdlDefineInfoid;
	}
	
}
