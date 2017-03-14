/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: NMSDAO基类接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMSBaseDAO<T> extends BaseHibernateDAO<T> {

	/**
	 * 版本取得
	 * @return version 版本
	 */
	public Integer getVersion();

	/**
	 * 版本设定
	 * @param version 版本
	 */
	public void setVersion(Integer version);
	
	/**
	 * 升版后如果当前版本表存在，则删除所有数据，否则创建表
	 */
	public void upateVersionForCreateTable();
	
	/**
	 * 校验当前表是否存在
	 * @return true 存在 false 不存在
	 */
	public boolean checkTableExits();
	
	
	/**
	 * 删除表
	 */
	public void dropTable();
}
