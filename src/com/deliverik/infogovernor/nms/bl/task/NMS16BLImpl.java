/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS16DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备组关系信息实体BL实现
 * </p>
 * 
 * @version 1.0
 */
public class NMS16BLImpl extends NMSBaseBLImpl implements NMS16BL {

	/** 组设备坐标信息实体DAO */
	protected NMS16DAO nms16DAO;
	
	/**
     * 设置组设备坐标信息实体DAO
     * @param nms16DAO 组设备坐标信息实体DAO
     */
    public void setNms16DAO(NMS16DAO nms16dao) {
        nms16DAO = nms16dao;
    }

    /**
	 * 设置版本
	 * @param version 版本
	 */
	public void setVersion(Integer version) {
		super.setVersion(version);
		nms16DAO.setVersion(version);
	}
	
	/**
	 * 升版处理
	 */
	public void upateVersion(){
		nms16DAO.upateVersionForCreateTable();
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS16Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS16SearchCond cond) {
		return nms16DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS16Info> search(NMS16SearchCond cond) {
		return nms16DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS16Info> search(NMS16SearchCond cond, int start,int count) {
		return nms16DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS16Info regist(NMS16Info instance) throws BLException {
		return nms16DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS16Info> regist(List<NMS16Info> instances) throws BLException {
		List<NMS16Info> list = new ArrayList<NMS16Info>(instances.size());
		for(NMS16Info instance:instances){
			list.add(nms16DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS16Info update(NMS16Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms16DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms16DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS16Info instance) throws BLException {
		nms16DAO.delete(instance);
	}
	
	/**
	 * 删除表
	 */
	public void dropTable(){
		nms16DAO.dropTable();
	}
	
	/**
     * 校验当前表是否存在
     * @return true 存在 false 不存在
     */
    public boolean checkTableExits() {
        return nms16DAO.checkTableExits();
    }
    
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS16Info checkExistInstance(String pk) throws BLException {
		NMS16Info instance = nms16DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
}
