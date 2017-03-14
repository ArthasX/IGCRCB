/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sdl.model.SdlInfo;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="SdlInfo")
public class SdlInfoTB extends BaseEntity implements Serializable, Cloneable, SdlInfo {

	@Id
	@TableGenerator(
		    name="SDLINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SDLINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SDLINFO_TABLE_GENERATOR")
	/**主键*/
	protected Integer siid;
	/**类别*/
	protected String sitype;
	/**说明*/
	protected String sidesc;
	/**开始时间*/
	protected String sibegin;
	/**结束时间*/
	protected String siend;
	/**评分*/
	protected Integer simark;
	/**相关资产ID*/
	protected Integer sieiid;
	/**相关资产名称*/
	protected String sieiname;
	/**相关事件流程ID*/
	protected Integer siprid;
	/**相关事件流程名称*/
	protected String siprtitle;
	/**附件*/
	protected String siattkey;
	/**登记日期*/
	protected String sidate;
	/**实际时间*/
	protected Integer sifacttime;

	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return siid;
	}

	/**
	 * 比较
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SdlInfoTB))
			return false;
		SdlInfo target = (SdlInfo) obj;
		if (!(getSiid()==target.getSiid()))
			return false;

		return true;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getSiid() {
		return siid;
	}

	/**
	 * 设置主键
	 * @param siid 主键
	 */
	public void setSiid(Integer siid) {
		this.siid = siid;
	}

	/**
	 * 获取类别
	 * @return 类别
	 */
	public String getSitype() {
		return sitype;
	}

	/**
	 * 设置类别
	 * @param sitype 类别
	 */
	
	public void setSitype(String sitype) {
		this.sitype = sitype;
	}

	/**
	 * 获取说明
	 * @return 说明
	 */
	public String getSidesc() {
		return sidesc;
	}

	/**
	 * 设置说明
	 * @param sidesc 说明
	 */
	public void setSidesc(String sidesc) {
		this.sidesc = sidesc;
	}

	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public String getSibegin() {
		return sibegin;
	}

	/**
	 * 设置开始时间
	 * @param sibegin 开始时间
	 */
	public void setSibegin(String sibegin) {
		this.sibegin = sibegin;
	}

	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public String getSiend() {
		return siend;
	}

	/**
	 * 设置结束时间
	 * @param siend 结束时间
	 */
	public void setSiend(String siend) {
		this.siend = siend;
	}

	/**
	 * 获取评分
	 * @return 评分
	 */
	public Integer getSimark() {
		return simark;
	}

	/**
	 * 设置评分
	 * @param simark 评分
	 */
	public void setSimark(Integer simark) {
		this.simark = simark;
	}

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public Integer getSieiid() {
		return sieiid;
	}

	/**
	 * 设置相关资产ID
	 * @param sieiid 相关资产ID
	 */
	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	/**
	 * 获取相关资产名称
	 * @return 相关资产名称
	 */
	public String getSieiname() {
		return sieiname;
	}

	/**
	 * 设置相关资产名称
	 * @param sieiname 相关资产名称
	 */
	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}

	/**
	 * 获取相关流程ID
	 * @return 相关流程ID
	 */
	public Integer getSiprid() {
		return siprid;
	}

	/**
	 * 设置相关流程ID
	 * @param siprid 相关流程ID
	 */
	public void setSiprid(Integer siprid) {
		this.siprid = siprid;
	}

	/**
	 * 获取相关流程名称
	 * @return 相关流程名称
	 */
	public String getSiprtitle() {
		return siprtitle;
	}

	/**
	 * 设置相关流程名称
	 * @param siprtitle 相关流程名称
	 */
	public void setSiprtitle(String siprtitle) {
		this.siprtitle = siprtitle;
	}
	/**
	 * 获取附件
	 * @return 附件
	 */
	public String getSiattkey() {
		return siattkey;
	}

	/**
	 * 设置附件
	 * @param siattkey 附件
	 */
	public void setSiattkey(String siattkey) {
		this.siattkey = siattkey;
	}
	/**
	 * 获取登记日期
	 * @return 登记日期
	 */
	public String getSidate() {
		return sidate;
	}

	/**
	 * 设置登记日期
	 * @param sidate 登记日期
	 */
	public void setSidate(String sidate) {
		this.sidate = sidate;
	}
	/**
	 * 获取实际时间
	 * @return 实际时间
	 */
	public Integer getSifacttime() {
		return sifacttime;
	}

	/**
	 * 设置实际时间
	 * @param sidate 实际时间
	 */
	public void setSifacttime(Integer sifacttime) {
		this.sifacttime = sifacttime;
	}
	
}
