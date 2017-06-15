/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.mtp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.mtp.model.QuartzJobDetails;


/**
 * <p>
 * Title : SOC
 * </p>
 * <p>
 * Description: 日常运维计划信息实体
 * </p>
 * 
 * @author duchong@deliverik.com
 */
@SuppressWarnings("serial")
@Entity
@Table(name="QuartzJobDetails")
public class QuartzJobDetailsTB extends BaseEntity implements Serializable, Cloneable, QuartzJobDetails {

	@Id
	@TableGenerator(
		    name="QUARTZJOBDETAILS_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="QUARTZJOBDETAILS_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="QUARTZJOBDETAILS_TABLE_GENERATOR")
	/**主键*/
	protected Integer qjdid;
	
	/**QuartzJoss表主键*/
	protected Integer qjid;

	/**执行时间*/
	protected String qjdtime;

	/**星期几 */
	protected String qjdweek;

	/**执行状态（1已执行，0未执行） */
	protected String qjdtype;

	/**触发器名称*/
	protected String qjdtriname;
	
	/**触发器所属组的名称*/
	protected String qjdtrigrpname;

	/**
	 * 获取主键
	 * @return 
	 */
	public Serializable getPK() {
		return qjdid;
	}
	
	/**
	 * 获取主键
	 * @return 主键
	 */
	public Integer getQjdid() {
		return qjdid;
	}

	/**
	 * 设置主键
	 * @param qjdid 主键
	 */
	public void setQjdid(Integer qjdid) {
		this.qjdid = qjdid;
	}

	/**
	 * 获取运维任务主键
	 * @return 主键
	 */
	public Integer getQjid() {
		return qjid;
	}

	/**
	 * 设置运维任务主键
	 * @param qjid 主键
	 */
	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	/**
	 * 获取执行时间
	 * @return 执行时间
	 */
	public String getQjdtime() {
		return qjdtime;
	}

	/**
	 * 设置执行时间
	 * @param qjdtime 执行时间
	 */
	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}

	/**
	 * 获取星期几
	 * @return 星期几
	 */
	public String getQjdweek() {
		return qjdweek;
	}

	/**
	 * 设置星期几
	 * @param qjdweek 星期几
	 */
	public void setQjdweek(String qjdweek) {
		this.qjdweek = qjdweek;
	}

	/**
	 * 获取执行状态
	 * @return 执行状态
	 */
	public String getQjdtype() {
		return qjdtype;
	}

	/**
	 * 设置执行状态
	 * @param qjdtype 执行状态
	 */
	public void setQjdtype(String qjdtype) {
		this.qjdtype = qjdtype;
	}

	/**
	 * 获取触发器名称
	 * @return 触发器名称
	 */
	public String getQjdtriname() {
		return qjdtriname;
	}

	/**
	 * 设置触发器名称
	 * @param qjdtriname 触发器名称
	 */
	public void setQjdtriname(String qjdtriname) {
		this.qjdtriname = qjdtriname;
	}

	/**
	 * 获取触发器所属组的名称
	 * @return 触发器所属组的名称
	 */
	public String getQjdtrigrpname() {
		return qjdtrigrpname;
	}

	/**
	 * 设置触发器所属组的名称
	 * @param qjdtrigrpname 触发器所属组的名称
	 */
	public void setQjdtrigrpname(String qjdtrigrpname) {
		this.qjdtrigrpname = qjdtrigrpname;
	}

}
