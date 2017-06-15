/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.condition.NMS04SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCond;
import com.deliverik.infogovernor.nms.model.dao.NMS04DAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 设备信息实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS04BLImpl extends NMSBaseBLImpl implements NMS04BL {

    /** 设备信息实体DAO */
    protected NMS04DAO nms04DAO;

    /**
     * 设备信息实体DAO设定
     * @param nms04DAO 设备信息实体DAO
     */
    public void setNms04DAO(NMS04DAO nms04dao) {
        nms04DAO = nms04dao;
    }
    
    /**
     * 主键检索处理
     *
     * @param pk 主键
     * @return 检索结果
     */
    public NMS04Info searchByPK(String pk) throws BLException {
        return checkExistInstance(pk);
    }
    
    /**
     * 条件检索结果件数取得
     *
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(NMS04SearchCond cond) {
        return nms04DAO.getSearchCount(cond);
    }

    /**
     * 条件检索处理
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<NMS04Info> search(NMS04SearchCond cond) {
        return nms04DAO.findByCond(cond, 0, 0);
    }
    
    /**
     * 条件检索处理
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<NMS04Info> search(NMS04SearchCond cond, int start,int count) {
        return nms04DAO.findByCond(cond, start, count);
    }
    
    /**
     * 新增处理
     *
     * @param instance 新增实例
     * @return 新增实例
     */
    public NMS04Info regist(NMS04Info instance) throws BLException {
        return nms04DAO.save(instance);
    }
    
    /**
     * 新增处理
     *
     * @param instance 新增实例
     * @return 新增实例
     */
    public List<NMS04Info> regist(List<NMS04Info> instances) throws BLException {
        List<NMS04Info> list = new ArrayList<NMS04Info>(instances.size());
        for(NMS04Info instance:instances){
            list.add(nms04DAO.save(instance));
        }
        return list;
    }
    
    /**
     * 修改处理
     *
     * @param instance 修改实例
     * @return 修改实例
     */
    public NMS04Info update(NMS04Info instance) throws BLException {
        checkExistInstance(instance.getId());
        return nms04DAO.save(instance);
    }
    
    /**
     * 删除处理
     *
     * @param pk 主键
     */
    public void delete(String pk) throws BLException {
        nms04DAO.delete(checkExistInstance(pk));
    }
    
    /**
     * 删除处理
     *
     * @param instance 删除实例
     */
    public void delete(NMS04Info instance) throws BLException {
        nms04DAO.delete(instance);
    }
    
    /**
     * 实例存在检查处理
     *
     * @param pk 主键
     * @return 实例
     */
    public NMS04Info checkExistInstance(String pk) throws BLException {
        NMS04Info instance = nms04DAO.findByPK(pk);
        if (instance == null) {
            throw new BLException("IGCO10000.E004", "实例基本");
        }
        return instance;
    }
	
	/**
     * 根据组版本查询设备信息
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public List<NMS04VWInfo> searchDeviceByGroup(final NMS04VWSearchCond cond, final Integer version) throws BLException {
        return nms04DAO.searchDeviceByGroup(cond, version);
    }
}
