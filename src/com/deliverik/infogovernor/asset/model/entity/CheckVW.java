/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.CheckVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
public class CheckVW implements Serializable,
Cloneable,CheckVWInfo {

	@Id
	/** 主键 */
	protected String eiid;
	
	/** syscoding */
	protected String syscoding;

	/** 检查方法 */
	protected String checkMethod;
	
	/**建议检查频度*/
	protected String checkfrequency;

	/**
	 * syscoding取得
	 * @return syscoding syscoding
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * eiid取得
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid设定
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}
	
	/**
	 * syscoding设定
	 * @param syscoding syscoding
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

	/**
	 * 检查方法取得
	 * @return checkMethod 检查方法
	 */
	public String getCheckMethod() {
		return checkMethod;
	}

	/**
	 * 检查方法设定
	 * @param checkMethod 检查方法
	 */
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	/**
	 * 建议检查频度取得
	 * @return checkfrequency 建议检查频度
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * 建议检查频度设定
	 * @param checkfrequency 建议检查频度
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}
	
	public String getFingerPrint() {
		return null;
	}

}
