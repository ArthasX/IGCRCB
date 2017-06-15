package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;

public interface Project  extends BaseModel {

	/** 获取主键ID*/
	public abstract Integer getPid();

	/** 获取项目类型*/
	public abstract String getPtype();

	/** 获取项目编号*/
	public abstract String getPcode();

	/** 获取项目名称*/
	public abstract String getPname();

	/** 获取项目简介*/
	public abstract String getPdesc();

	public abstract String getPinfo();

	/** 获取开始时间*/
	public abstract String getPopentime();

	/** 获取结束时间*/
	public abstract String getPclosetime();

	/** 获取状态*/
	public abstract String getPstatus();

	/** 获取登记人机构ID*/
	public abstract String getPorg();

	/** 获取登记人角色*/
	public abstract String getProle();

	/** 获取登记人*/
	public abstract String getPuser();

	/** 获取项目预算，对应预算表中的预算名称*/
	public abstract String getPamount();
	
	/** 获取项目预算用途*/
	public abstract String getPuse();
	
	/** 获取项目预算额度*/
	public abstract Double getPlimit();
	
	/** 获取需求部门*/
	public abstract String getPbranch();
	
	/** 获取预算主表ID*/
	public abstract Integer getPbid();
	
	/** 获取项目目的*/
	public abstract String getPaim();
	
	/**
	 * 获取项目用途
	 * @return fppurpose 项目用途
	 */
	public abstract String getPpurpose();
	
	/**
	 * 获取预算表实体
	 * @param ppurpose  预算表实体
	 */
	public abstract BudgetTB getBudgetTB();
	
	/**
	 * 获取使用预算
	 * @return
	 */
	public abstract String getIsUseBudget();
	
	/**
	 * 计划结束时间取得
	 * @return pplanclosetime 计划结束时间
	 */
	public String getPplanclosetime() ;
	
	/**
	 * 项目资本金开发取得
	 * @return bzdevelop 项目资本金开发
	 */
	public Double getPzdevelop() ;

	/**
	 * 项目资本金硬件取得
	 * @return bzhardware 项目资本金硬件
	 */
	public Double getPzhardware() ;

	/**
	 * 项目资本金软件取得
	 * @return bzsoftware 项目资本金软件
	 */
	public Double getPzsoftware();

	/**
	 * 项目资本金工程取得
	 * @return bzproject 项目资本金工程
	 */
	public Double getPzproject() ;

	/**
	 * 项目资本金其他取得
	 * @return bzelse 项目资本金其他
	 */
	public Double getPzelse() ;

	/**
	 * 项目成本金实施取得
	 * @return bcimplement 项目成本金实施
	 */
	public Double getPcimplement();

	/**
	 * 项目成本金其他取得
	 * @return bcelse 项目成本金其他
	 */
	public Double getPcelse() ;
	
	/**
	 * 合同编号取得
	 * @return plcid 合同编号
	 */
	public Integer getPlcid() ;
	/**
	 * 项目性质取得
	 * @return ppquality 项目性质
	 */
	public String getPpquality();
}