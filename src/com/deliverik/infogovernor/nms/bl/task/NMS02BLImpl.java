/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCondImpl;
import com.deliverik.infogovernor.nms.model.dao.NMS02DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS02BLImpl extends NMSBaseBLImpl implements NMS02BL {

	/** SNMP参数信息实体DAO */
	protected NMS02DAO nms02DAO;

	/**
	 * SNMP参数信息实体DAO设定
	 * @param nms02DAO SNMP参数信息实体DAO
	 */
	public void setNms02DAO(NMS02DAO nms02DAO) {
		this.nms02DAO = nms02DAO;
	}
	
	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public NMS02Info searchByPK(String pk) throws BLException {
		return checkExistInstance(pk);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS02SearchCond cond) {
		return nms02DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<NMS02Info> search(NMS02SearchCond cond) {
		return nms02DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<NMS02Info> search(NMS02SearchCond cond, int start,int count) {
		return nms02DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public NMS02Info regist(NMS02Info instance) throws BLException {
		checkExistInstance(instance.getSnmpVersion(), instance.getSnmpPort(),
				instance.getReadCommit(), instance.getSnmpUser(), instance.getSnmpPassword());
		return nms02DAO.save(instance);
	}
	
	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public NMS02Info update(NMS02Info instance) throws BLException {
		checkExistInstance(instance.getId());
		return nms02DAO.save(instance);
	}
	
	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void delete(String pk) throws BLException {
		nms02DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void delete(NMS02Info instance) throws BLException {
		nms02DAO.delete(instance);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public NMS02Info checkExistInstance(String pk) throws BLException {
		NMS02Info instance = nms02DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param snmpVersion SNMP版本
	 * @param snmpPort 端口
	 * @param readCommit 读取团体字
	 * @param snmpUser V3安全用户
	 * @param snmpPassword V3身份验证密码
	 * @return 实例
	 */
	public void checkExistInstance(Integer snmpVersion, Integer snmpPort, String readCommit,
			String snmpUser, String snmpPassword) throws BLException {
		NMS02SearchCondImpl cond = new NMS02SearchCondImpl();
		cond.setDeleteflag("0");
		cond.setSnmpVersion(snmpVersion);
		cond.setSnmpPort(snmpPort);
		cond.setReadCommit(readCommit);
		cond.setSnmpUser(snmpUser);
		cond.setSnmpPassword(snmpPassword);
		List<NMS02Info> lst_NMS02Info = this.search(cond);
		if (!lst_NMS02Info.isEmpty()) {
			throw new BLException("IGCO10000.E140", "配置基本信息已存在");
		}
	}
}
