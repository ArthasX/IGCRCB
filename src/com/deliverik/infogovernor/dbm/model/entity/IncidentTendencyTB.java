/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.dbm.model.entity;

 import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dbm.model.IncidentTendency;



/**
 * 
 * @Description:事件趋势统计表实体TB类
 * @Author
 * @History
 * @Version V1.0
 */

@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IncidentTendency")
@IdClass(IncidentTendencyTBPK.class)
public class IncidentTendencyTB extends BaseEntity implements Serializable, Cloneable, IncidentTendency{

	/**统计年**/
	@Id
	private String ityear;
	
	/**统计月**/
	@Id
	private String itmonth;
	
	/**统计日**/
	@Id
	private String itday;

	
	/**事件数量**/
	private int itamount;
	
	
	/**事件平均解决时间（分钟数）**/
	private int itaveragetime;;
	
	
	/**时间戳**/
	private String Fingerprint;


	public String getItyear() {
		return ityear;
	}

	public void setItyear(String ityear) {
		this.ityear = ityear;
	}


	public String getItmonth() {
		return itmonth;
	}

	public void setItmonth(String itmonth) {
		this.itmonth = itmonth;
	}


	public String getItday() {
		return itday;
	}

	public void setItday(String itday) {
		this.itday = itday;
	}


	public int getItamount() {
		return itamount;
	}

	public void setItamount(int itamount) {
		this.itamount = itamount;
	}

	public int getItaveragetime() {
		return itaveragetime;
	}

	public void setItaveragetime(int itaveragetime) {
		this.itaveragetime = itaveragetime;
	}


	public String getFingerprint() {
		return Fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		Fingerprint = fingerprint;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return new IncidentTendencyTBPK(ityear, itmonth, itday);
	}
}

