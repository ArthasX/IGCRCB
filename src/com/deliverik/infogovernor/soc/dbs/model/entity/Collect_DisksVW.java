/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.dbs.model.entity;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Id;

import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;

/**
 * 
 * @Description:存储实时信息视图实体TB类
 * @Author
 * @History
 * @Version V1.0
 */
@javax.persistence.Entity
public class Collect_DisksVW implements Serializable, Cloneable,Collect_DisksVWInfo{

	private static final long serialVersionUID = 1L;
	
	protected String symtime;
	/**
	*  获取CX的设备
	*/
	protected String Object_Name ;
	/**
	*  系统使用率
	*/
	protected BigDecimal sysBusy;

    public String getObject_Name() {
		return Object_Name;
	}
	public void setObject_Name(String object_Name) {
		Object_Name = object_Name;
	}
	/**
     * 设备
     * @return
     */
	@Id
	private String director_number;
	
	public String getSymtime() {
		return symtime;
	}
	public void setSymtime(String symtime) {
		this.symtime = symtime;
	}

	public String getDirector_number() {
		return director_number;
	}
	public void setDirector_number(String director_number) {
		this.director_number = director_number;
	}
	public BigDecimal getSysBusy() {
		return sysBusy;
	}
	public void setSysBusy(BigDecimal sysBusy) {
		this.sysBusy = sysBusy;
	}
}

