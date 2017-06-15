/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0112Info;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0112SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
/**
 * 概述: 资产域定义业务逻辑接口
 * 功能描述: 资产域定义业务逻辑接口
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public interface IGCIM02BL extends BaseBL{

	/**
	 * 资产域定义信息登记处理
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO insertEiDomainDefAction(IGCIM02DTO dto) throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0112Info> searchEiDomainDetailAction(SOC0112SearchCond cond) throws BLException;
	
		
	/**
	 * 给域添加应用
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<SOC0124Info>searchAppForDomainDetail()throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> searchImportVersionAction(SOC0120SearchCond cond) throws BLException;
	
	
	/**
	 * 导入对象检索
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO searchImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 采集控制台查询处理
	 * @param dto IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0214Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 删除用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGCIM02DTO revokeImportVesionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 添加用户角色
	 * </p>
	 * 
	 * @param dto IGSYM04DTO
	 * @return IGSYM04DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGCIM02DTO InsertImportVesionAction(IGCIM02DTO dto)throws BLException;
	
	/**
	 * 资产域定义信息查询处理
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefAction(IGCIM02DTO dto) throws BLException;
	/**
	 * 资产域定义变更初始化
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0202Action(IGCIM02DTO dto)throws BLException;

	/**
	 * 资产域定义变更处理
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO updateEiDomainDefAction(IGCIM02DTO dto) throws BLException;
	/**
	 * 资产域定义详细信息初始化
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0205Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 控制台显示处理
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0201Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 控制台显示处理[导入原数据]
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0803Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 把soc0115 状态ID 赋予CR03返回CR数据
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initCR03Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0803Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction0803(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 控制台任务查看处理
	 *
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO initIGCIM0210Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiWaitTaskAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 资产域定义删除处理
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO deleteEiDomainDefAction(IGCIM02DTO dto) throws BLException;

	/**
	 * 导入对象信息登记处理
	 * @param dto
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO insertImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 * @throws BLException
	 */
	public IGCIM02DTO importIGCIM0201Action(IGCIM02DTO dto) throws BLException;

	/**
	 * 导入对象删除处理
	 * @param dto
	 * @throws BLException
	 */
	public IGCIM02DTO deleteImportVersionAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 导入对象状态调整
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGCIM02DTO dto) throws BLException ;

	/**
	 * 导入对象类型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO getEiImportProgrammeAction(IGCIM02DTO dto) throws BLException;
	/**
	 * 导入对象版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchImportVersionIGCIM0210Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 资产域定义版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0212Action(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 域手动快照生成
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO handSnapshotAction(IGCIM02DTO dto) throws BLException;

	/**
	 * 最新版本域信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchIGCIM0213Action(IGCIM02DTO dto)throws BLException;

	/**
	 * 域CI查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM02DTO searchDoaminCiInfoAction(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 资产域定义信息查询处理
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchEiDomainDefActionNoPage(IGCIM02DTO dto) throws BLException;
	
	/**
	 * 采集查询
	 * 
	 * @param dtoIGCIM02DTO
	 * @return IGCIM02DTO
	 */
	public IGCIM02DTO searchCr03Action(IGCIM02DTO dto) throws BLException;
	
	
}
