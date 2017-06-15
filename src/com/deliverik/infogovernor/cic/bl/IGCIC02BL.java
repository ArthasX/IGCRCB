/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.cic.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.cic.dto.IGCIC02DTO;
import com.deliverik.infogovernor.cic.model.CompareresultVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 对比任务业务逻辑实现
 * </p>
 * 
 * @author 
 * @version 1.0
 */
public interface IGCIC02BL extends BaseBL {

    /**
     * 查询比对执行情况
     * 
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO searchCompareProcessAction(IGCIC02DTO dto) throws BLException;
	
    /**
     * 比对任务查看页面 
     * 
     * @param dto
     * @return
     */
    public IGCIC02DTO compareResultViewAction(IGCIC02DTO dto) throws BLException;
    
    /**
     * 根据对象比对结果
     * 
     * @param cond 检索条件
     * @param version 版本
     * @return 检索结果列表
     */
    public IGCIC02DTO searchObjectCompareresult(IGCIC02DTO dto) throws BLException;
    
    /**
     * 取得比较对象文件路径
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getCompareObjectFilepath(IGCIC02DTO dto) throws BLException;
    
    /**
     * 执行比对任务
     * 
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO executeCompareTask(IGCIC02DTO dto) throws BLException;
    /**
     * 获取树视图
     * @param dto
     * @return
     * @throws BLException
     */
    public IGCIC02DTO getTreeView(IGCIC02DTO dto) throws BLException ;
    
    /**
     * 根据配置模型id 和对比过程id 获取对比结果
     * @param dto
     * @return
     * @throws BLException
     */
    public List<CompareresultVWInfo> getDetailByEentity(String eid,Integer cpid) throws BLException;
}
