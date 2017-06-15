/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.condition.NMS05SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS05TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备组关系信息实体DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS05DAOImpl extends NMSBaseDAOImpl<NMS05Info> implements NMS05DAO {
	
	/**
	 * 构造方法
	 */
	public NMS05DAOImpl(){
		super(NMS05TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS05SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS05Info> findByCond(NMS05SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS05SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		return c;
	}
}
