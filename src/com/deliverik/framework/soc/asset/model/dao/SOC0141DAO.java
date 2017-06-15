package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;

/**
 * 资产项视图DAO接口
 * 
 * @author 
 * 修改记录：2011/7/13 增加IBM逻辑图显示 王龙宇
 */
public interface SOC0141DAO extends BaseHibernateDAO<SOC0141VW> {
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0141VW> findByCond(final SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0140VW> findDiskByCond(final SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findDaByCond(final SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<String> findFaByCond(final SOC0121SearchCond cond,final String strStorageEilabel);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SOC0133VW> findSwitchZoneByCond(final SOC0121SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
    public List<SOC0132VW> findSwitchPortByCond(final SOC0121SearchCond cond);	
    
    /**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0121TB> findSwitchRelationByCond(final SOC0121SearchCond cond1,final SOC0121SearchCond cond2);
	/**
	 * 
	 * @Description: [查询 IBM faport]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @param strStorageEilabel
	 * @return List<ShowEntityVW> faport属性的显示集合
	 */
	public List<SOC0140VW> findIBMFaportByCond(final SOC0121SearchCond cond,final String strStorageEilabel);
	/**
	 * 
	 * @Description: [查询IBM DA SERIAL]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> disk serial属性的显示集合
	 */
	public List<SOC0140VW> findIBMDiskSerialByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [查询IBM DISK PACK]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> disk pack属性的显示集合
	 */
	public List<SOC0140VW> findIBMDiskPackByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [查询IBM FA]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> fa属性的显示集合
	 */
	public List<SOC0140VW> findIBMFaByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [查询IBM DA LOC]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> daloc属性的显示集合
	 */
	public List<SOC0140VW> findIBMDaLocByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [查询IBM DA PAIR]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> dapair属性的显示集合
	 */
	public List<SOC0140VW> findIBMDaPairByCond(final SOC0121SearchCond cond);
	/**
	 * 
	 * @Description: [查询IBM DA interface]
	 * @author	wanglongyu@diliverik.com, 2011-7-13
	 * @param cond
	 * @return List<ShowEntityVW> interface属性的显示集合
	 */
	public List<SOC0140VW> findIBMDaInterfaceByCond(final SOC0121SearchCond cond);
	
}
