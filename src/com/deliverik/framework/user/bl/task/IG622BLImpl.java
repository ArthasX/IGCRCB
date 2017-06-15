/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.user.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.dao.IG622DAO;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * 概述: 首页跳转URL定义业务逻辑实现
  * 功能描述: 首页跳转URL定义业务逻辑实现
  * 创建记录: 2012/07/18
  * 修改记录: 
  */
public class IG622BLImpl extends BaseBLImpl implements
		IG622BL {

	/** 首页跳转URL定义DAO接口 */
	protected IG622DAO ig622DAO;
	
	//组装首页跳转URL定义集合
	private static List<LabelValueBean> lst_LabelValueBean = null;
	
	//组装用户首页下拉列表
	private static Map<String, IG622Info> map_IG622Info = null;
	
	/**
	 * 首页跳转URL定义DAO接口设定
	 *
	 * @param ig622DAO 首页跳转URL定义DAO接口
	 */
	public void setIg622DAO(IG622DAO ig622DAO) {
		this.ig622DAO = ig622DAO;
	}

	/**
	 * 首页跳转URL定义实例取得
	 *
	 * @return 首页跳转URL定义实例
	 */
	public IG622TB getIG622TBInstance() {
		return new IG622TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG622Info> searchIG622Info() {
		return ig622DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG622Info searchIG622InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG622SearchCond cond) {
		return ig622DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond) {
		return ig622DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond, int start,
			int count) {
		return ig622DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG622Info registIG622Info(IG622Info instance)
		throws BLException {
		return ig622DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG622Info updateIG622Info(IG622Info instance)
		throws BLException {
		checkExistInstance(instance.getHpid());
		return ig622DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG622InfoByPK(String pk)
		throws BLException {
		ig622DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG622Info(IG622Info instance)
		throws BLException {
		ig622DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG622Info checkExistInstance(String pk)
		throws BLException {
		IG622Info instance = ig622DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 初始化
	 */
	@SuppressWarnings("unused")
	private void init() throws BLException {
		List<IG622Info> lst_IG622Info = searchIG622Info();
		lst_LabelValueBean = new ArrayList<LabelValueBean>();
		map_IG622Info = new HashMap<String, IG622Info>();
		for(IG622Info info : lst_IG622Info) {
			//组装首页跳转URL定义集合
			map_IG622Info.put(info.getHpid(), info);
			//组装用户首页下拉列表，不包括系统管理员
			if(!"S".equals(info.getHpid())) {
				lst_LabelValueBean.add(new LabelValueBean(info.getHplabel(), info.getHpid().toString()));
			}
		}
	}
	
	/**
	 * 用户首页下拉列表取得
	 *
	 * @return 用户首页下拉列表
	 */
	public List<LabelValueBean> getComboBox() {
		return lst_LabelValueBean;
	}
	
	/**
	 * 首页跳转URL取得
	 *
	 * @param hpid 定义ID
	 * @return 首页跳转URL
	 * @throws BLException 
	 */
	public String getUrl(String hpid) throws BLException {
		IG622Info info = map_IG622Info.get(hpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "首页（" + hpid + "）跳转URL定义基本");
		}
		return info.getHpurl();
	}
	
	/**
	 * 首页显示名称取得
	 *
	 * @param hpid 定义ID
	 * @return 首页显示名称
	 * @throws BLException 
	 */
	public String getTitle(String hpid) throws BLException {
		IG622Info info = map_IG622Info.get(hpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "首页（" + hpid + "）跳转URL定义基本");
		}
		return info.getHptitle();
	}

}