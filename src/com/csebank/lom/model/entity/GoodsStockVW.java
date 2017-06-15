/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.csebank.lom.model.GoodsStock;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_统计汇总_库存统计信息
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class ChangeKpiVW extends BaseEntity implements Serializable, Cloneable, ChangeKpi {
public class GoodsStockVW implements Serializable, Cloneable, GoodsStock {

	@Id
	/**序号 */
	protected String gid;
	
	/**物品编号 */
	protected String giodcode;
	
	/**物品名称*/
	protected String giodname;
	
	/**出库数量*/
	protected Integer giodoutnum;

	/**入库数量*/
	protected Integer giodinnum;
	
	/**库存量*/
	protected Integer giodnum;
	
	/**出入库类型*/
	protected String type;
	
	public Serializable getPK() {
		return gid;
	}
	
	/**
	 * 序号
	 * @return 序号
	 */
	public String getGid() {
		return gid;
	}
	
	/**
	 * 序号
	 * @param gid 序号
	 */
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	/**
	 * 物品编号
	 * @return 物品编号
	 */
	public String getGiodcode() {
		return giodcode;
	}
	
	/**
	 * 物品编号
	 * @param giodcode 物品编号
	 */
	public void setGiodcode(String giodcode) {
		this.giodcode = giodcode;
	}
	
	/**
	 * 物品名称
	 * @return 物品名称
	 */
	public String getGiodname() {
		return giodname;
	}
	
	/**
	 * 物品名称
	 * @param giodname 物品名称
	 */
	public void setGiodname(String giodname) {
		this.giodname = giodname;
	}
	
	/**
	 * 出库数量
	 * @return 出库数量
	 */
	public Integer getGiodoutnum() {
		return giodoutnum;
	}
	
	/**
	 * 出库数量
	 * @param giodinoutnum 出库数量
	 */
	public void setGiodinoutnum(Integer giodoutnum) {
		this.giodoutnum = giodoutnum;
	}
	
	/**
	 * 入库数量
	 * @return 入库数量
	 */
	public Integer getGiodinnum() {
		return giodinnum;
	}
	
	/**
	 * 入库数量
	 * @param giodininnum 入库数量
	 */
	public void setGiodinnum(Integer giodinnum) {
		this.giodinnum = giodinnum;
	}
	
	/**
	 * 库存量
	 * @return 库存量
	 */
	public Integer getGiodnum() {
		return giodnum;
	}
	
	/**
	 * 库存量
	 * @param giodininnum 库存量
	 */
	public void setGiodnum(Integer giodnum) {
		this.giodnum = giodnum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
