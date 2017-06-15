/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model;

/**
 * 概述: 投资使用情况导出实体接口
 * 功能描述：投资使用情况导出实体接口
 * 创建人：王廷志
 * 创建记录： 2012-5-22
 * 修改记录：
 */
public interface InvestUseInfoVW{


	/**
	 * pid取得
	 * @return pid pid
	 */
	public Integer getPid() ;
	/**
	 * 项目性质取得
	 * @return ppquality 项目性质
	 */
	public String getPpquality();
	/**
	 * 项目类别取得
	 * @return ptype 项目类别
	 */
	public String getPtype() ;
	/**
	 * 项目名称取得
	 * @return pname 项目名称
	 */
	public String getPname() ;
	/**
	 * 项目简介取得
	 * @return pdesc 项目简介
	 */
	public String getPdesc();
	/**
	 * 预算项目编号取得
	 * @return pstorecode 预算项目编号
	 */
	public String getPstorecode() ;
	/**
	 * 合同金额总计取得
	 * @return ltotal 合同金额总计
	 */
	public Double getLtotal() ;
	/**
	 * 合同金额资本金总计取得
	 * @return ltotalctsum 合同金额资本金总计
	 */
	public Double getLtotalctsum() ;
	/**
	 * 合同金额成本金总计取得
	 * @return ltotalcssum 合同金额成本金总计
	 */
	public Double getLtotalcssum() ;
	/**
	 * 合同金额资本金开发取得
	 * @return ltotal1 合同金额资本金开发
	 */
	public Double getLtotal1() ;
	/**
	 * 合同金额资本金软件取得
	 * @return ltotal2 合同金额资本金软件
	 */
	public Double getLtotal2();
	/**
	 * 合同金额资本金硬件取得
	 * @return ltotal3 合同金额资本金硬件
	 */
	public Double getLtotal3() ;
	/**
	 * 合同金额资本金工程取得
	 * @return ltotal4 合同金额资本金工程
	 */
	public Double getLtotal4() ;
	/**
	 * 合同金额资本金其他取得
	 * @return ltotal5 合同金额资本金其他
	 */
	public Double getLtotal5() ;
	/**
	 * 合同金额成本金实施取得
	 * @return ltotal6 合同金额成本金实施
	 */
	public Double getLtotal6();
	/**
	 * 合同金额成本金其他取得
	 * @return ltotal7 合同金额成本金其他
	 */
	public Double getLtotal7() ;
	/**
	 * 付款条件取得
	 * @return term 付款条件
	 */
	public String getTerm();
	/**
	 * 付款取得
	 * @return fktotal 付款
	 */
	public Double getFktotal();
	/**
	 * 预算总计取得
	 * @return bztotal 预算总计
	 */
	public Double getBztotal();
	/**
	 * 预算资本金总计取得
	 * @return bztotalctsum 预算资本金总计
	 */
	public Double getBztotalctsum();
	/**
	 * 预算成本金总计取得
	 * @return bztotalcssum 预算成本金总计
	 */
	public Double getBztotalcssum() ;
	/**
	 * 预算资本金开发取得
	 * @return bztotal1 预算资本金开发
	 */
	public Double getBztotal1() ;
	/**
	 * 预算资本金软件取得
	 * @return bztotal2 预算资本金软件
	 */
	public Double getBztotal2() ;
	/**
	 * 预算资本金硬件取得
	 * @return bztotal3 预算资本金硬件
	 */
	public Double getBztotal3() ;
	/**
	 * 预算资本金工程取得
	 * @return bztotal4 预算资本金工程
	 */
	public Double getBztotal4() ;
	/**
	 * 预算资本金其他取得
	 * @return bztotal5 预算资本金其他
	 */
	public Double getBztotal5();
	/**
	 * 预算成本金实施取得
	 * @return bztotal6 预算成本金实施
	 */
	public Double getBztotal6() ;
	/**
	 * 预算成本金其他取得
	 * @return bztotal7 预算成本金其他
	 */
	public Double getBztotal7();
	/**
	 * 项目总计取得
	 * @return ptotal 项目总计
	 */
	public Double getPtotal() ;
	/**
	 * 项目资本金总计取得
	 * @return ptotalctsum 项目资本金总计
	 */
	public Double getPtotalctsum() ;
	/**
	 * 项目成本金总计取得
	 * @return ptotalcssum 项目成本金总计
	 */
	public Double getPtotalcssum() ;
	/**
	 * 项目资本金开发取得
	 * @return ptotal1 项目资本金开发
	 */
	public Double getPtotal1();
	/**
	 * 项目资本金软件取得
	 * @return ptotal2 项目资本金软件
	 */
	public Double getPtotal2() ;
	/**
	 * 项目资本金硬件取得
	 * @return ptotal3 项目资本金硬件
	 */
	public Double getPtotal3() ;
	/**
	 * 项目资本金工程取得
	 * @return ptotal4 项目资本金工程
	 */
	public Double getPtotal4() ;
	/**
	 * 项目资本金其他取得
	 * @return ptotal5 项目资本金其他
	 */
	public Double getPtotal5() ;
	/**
	 * 项目成本金实施取得
	 * @return ptotal6 项目成本金实施
	 */
	public Double getPtotal6();
	/**
	 * 项目成本金其他取得
	 * @return ptotal7 项目成本金其他
	 */
	public Double getPtotal7() ;
	/**
	 * 项目用途取得
	 * @return ppurpose 项目用途
	 */
	public String getPpurpose() ;
}
