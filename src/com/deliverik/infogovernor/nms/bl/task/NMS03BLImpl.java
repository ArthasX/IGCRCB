/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS03Info;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCondImpl;
import com.deliverik.infogovernor.nms.model.dao.NMS03DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发现任务信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS03BLImpl extends NMSBaseBLImpl implements NMS03BL {

	/** 发现任务信息实体DAO */
	protected NMS03DAO nms03DAO;

	/**
	 * 发现任务信息实体DAO设定
	 * @param nms03DAO 发现任务信息实体DAO
	 */
	public void setNms03DAO(NMS03DAO nms03dao) {
		nms03DAO = nms03dao;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS03Info searchByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 最新版本检索
	 * @return 最新版本
	 */
	public List<NMS03Info> searchNewest(NMS03SearchCond cond){
		return nms03DAO.searchNewest(cond);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS03SearchCond cond) {
		return nms03DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS03Info> search(NMS03SearchCond cond) {
		return nms03DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS03Info> search(NMS03SearchCond cond, int start,int count) {
		return nms03DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS03Info regist(NMS03Info instance) throws BLException {
		checkExistInstance(instance.getGid(), instance.getType(),
				instance.getFromIP(), instance.getToIP(), instance.getSubNet());
		return nms03DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public List<NMS03Info> regist(List<NMS03Info> instances) throws BLException {
		List<NMS03Info> list = new ArrayList<NMS03Info>(instances.size());
		for(NMS03Info instance:instances){
			list.add(nms03DAO.save(instance));
		}
		return list;
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS03Info update(NMS03Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms03DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(Integer pk) throws BLException {
		nms03DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS03Info instance) throws BLException {
		nms03DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS03Info checkExistInstance(Integer pk) throws BLException {
		NMS03Info instance = nms03DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	

	
	/**
	 * 实例存在检查处理
	 *
	 * @param gid 组ID
	 * @param gversion 组版本
	 * @param type 任务类型
	 * @param fromIP 起始IP
	 * @param toIP 结束IP
	 * @param subNet 子网
	 * @return 实例
	 */
	public void checkExistInstance(Integer gid, String type,
			String fromIP, String toIP, String subNet) throws BLException {
		NMS03SearchCondImpl cond = new NMS03SearchCondImpl();
		cond.setDeleteflag("0");
		cond.setGid(gid);
		cond.setType(type);
		if(NMSBaseBLImpl.TaskType_IP.equals(type)) {
			cond.setFromIP(fromIP);
			cond.setToIP(toIP);
		} else if(NMSBaseBLImpl.TaskType_SubNet.equals(type)) {
			cond.setSubNet(subNet);
		} else if(NMSBaseBLImpl.TaskType_Route.equals(type)) {
			cond.setFromIP(fromIP);
		}
		//查询最新版本
		List<NMS03Info> lst_NMS03Info = this.searchNewest(cond);
		if (!lst_NMS03Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "配置基本信息已存在");
		}
		//查询0版本
		cond.setVersion(0);
		lst_NMS03Info = this.search(cond);
		if (!lst_NMS03Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "配置基本信息已存在");
		}
	}
	
}
