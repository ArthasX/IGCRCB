/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS05Info;
import com.deliverik.infogovernor.nms.model.condition.NMS05SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS05DAO;
import com.deliverik.infogovernor.nms.model.entity.NMS05PK;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备组关系信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS05BLImpl extends NMSBaseBLImpl implements NMS05BL {

	/** 设备组关系信息实体DAO */
	protected NMS05DAO nms05DAO;

	/**
	 * 设备组关系信息实体DAO设定
	 * @param nms05DAO 设备组关系信息实体DAO
	 */
	public void setNms05DAO(NMS05DAO nms05dao) {
		nms05DAO = nms05dao;
	}
	
	/**
	 * 设置版本
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms05DAO.setVersion(version);
	}
	
	/**
	 * 升版处理
	 */
	public void upateVersion(){
		nms05DAO.upateVersionForCreateTable();
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS05Info searchByPK(NMS05PK pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS05SearchCond cond) {
		return nms05DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS05Info> search(NMS05SearchCond cond) {
		return nms05DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS05Info> search(NMS05SearchCond cond, int start,int count) {
		return nms05DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS05Info regist(NMS05Info instance) throws BLException {
		return nms05DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS05Info> regist(List<NMS05Info> instances) throws BLException {
		List<NMS05Info> list = new ArrayList<NMS05Info>(instances.size());
		for(NMS05Info instance:instances){
			list.add(nms05DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS05Info update(NMS05Info instance) throws BLException {
		checkExistInstance(new NMS05PK(instance.getGid(), instance.getDid(), instance.getGversion()));
		return nms05DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(NMS05PK pk) throws BLException {
		nms05DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS05Info instance) throws BLException {
		nms05DAO.delete(instance);
	}
	
	/**
	 * 删除表
	 */
	public void dropTable(){
		nms05DAO.dropTable();
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS05Info checkExistInstance(NMS05PK pk) throws BLException {
		NMS05Info instance = nms05DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
