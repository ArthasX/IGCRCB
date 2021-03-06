/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.condition.NMS07SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS07DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS07BLImpl extends NMSBaseBLImpl implements NMS07BL {

	/** 链路信息实体DAO */
	protected NMS07DAO nms07DAO;

	/**
	 * 链路信息实体DAO设定
	 * @param nms07DAO 链路信息实体DAO
	 */
	public void setNms07DAO(NMS07DAO nms07dao) {
		nms07DAO = nms07dao;
	}
	
	/**
	 * 设置版本
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms07DAO.setVersion(version);
	}
	
	/**
	 * 升版处理
	 */
	public void upateVersion(){
		nms07DAO.upateVersionForCreateTable();
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS07Info searchByPK(String pk) throws BLException {
		return nms07DAO.findByPK(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS07SearchCond cond) {
		return nms07DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS07Info> search(NMS07SearchCond cond) {
		return nms07DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS07Info> search(NMS07SearchCond cond, int start,int count) {
		return nms07DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS07Info regist(NMS07Info instance) throws BLException {
		return nms07DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS07Info> regist(List<NMS07Info> instances) throws BLException {
		List<NMS07Info> list = null;
		if(instances != null && instances.size() > 0){
			list = new ArrayList<NMS07Info>();
			for(NMS07Info entity : instances){
				list.add(nms07DAO.save(entity));
			}
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS07Info update(NMS07Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms07DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms07DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS07Info instance) throws BLException {
		nms07DAO.delete(instance);
	}
	
	/**
	 * 删除表
	 */
	public void dropTable(){
		nms07DAO.dropTable();
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS07Info checkExistInstance(String pk) throws BLException {
		NMS07Info instance = nms07DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
