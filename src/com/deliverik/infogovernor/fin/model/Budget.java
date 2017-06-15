package com.deliverik.infogovernor.fin.model;

import com.deliverik.framework.base.BaseModel;

public interface Budget  extends BaseModel {

	/** 获取主键ID*/
	public abstract Integer getBid();

	/** 获取预算类型*/
	public abstract String getBtype();

	public abstract String getBinittime();

	/** 获取开始时间*/
	public abstract String getBopentime();

	/** 获取状态*/
	public abstract String getBstatus();

	public abstract String getBreqid();

	public abstract String getBapvid();

	/** 获取预算名称*/
	public abstract String getBtitle();

	/** 获取关闭时间*/
	public abstract String getBclosetime();

	/** 获取预算简介*/
	public abstract String getBdesc();

	public abstract String getBinfo();

	/** 获取预算年份*/
	public abstract String getByear();

	/** 获取机构ID*/
	public abstract String getBorgid();

	/** 获取机构名称*/
	public abstract String getBorgname();

	public abstract String getBreqname();

	public abstract String getBapvname();

	/** 获取预算总额*/
	public abstract Double getBamount();

	public abstract String getBattkey();
	
	public abstract Integer getPid();
	
	public abstract String getPcode();
	
	public abstract String getPname();
	
	/** 获取预算性质*/
	public abstract String getPquality();
	
	/** 获取储备项目编号*/
	public abstract String getPstorecode();
	
	/** 获取需求部门*/
	public abstract String getPneeddispart();
	
	/** 获取预算组成*/
	public abstract String getPbuggetform();
	
	/** 获取预算用途*/
	public abstract String getPuse();
	
	/** 获取备注*/
	public abstract String getRemark();

	/** 获取预算资本金开发*/
	public abstract Double getBzdevelop();
	
	/** 获取预算资本金硬件*/
	public abstract Double getBzhardware();
	
	/** 获取预算资本金软件*/
	public abstract Double getBzsoftware();
	
	/** 获取预算资本金工程*/
	public abstract Double getBzproject();
	
	/** 获取预算资本金其他*/
	public abstract Double getBzelse();
	
	/** 获取预算成本金实施*/
	public abstract Double getBcimplement();
	
	/** 获取预算成本金其他*/
	public abstract Double getBcelse();
}