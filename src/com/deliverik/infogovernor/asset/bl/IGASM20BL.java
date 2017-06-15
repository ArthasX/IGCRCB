/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import com.deliverik.framework.asset.model.EiDomainDetailInfo;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
/**
 * 概述: 资产域定义业务逻辑接口
 * 功能描述: 资产域定义业务逻辑接口
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public interface IGASM20BL extends BaseBL{

	/**
	 * 资产域定义信息登记处理
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO insertEiDomainDefAction(IGASM20DTO dto) throws BLException;

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailInfo> searchEiDomainDetailAction(EiDomainDetailSearchCond cond) throws BLException;
	
		
	/**
	 * 给域添加应用
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public List<IG688Info>searchAppForDomainDetail()throws BLException;
	
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<ImportVersionInfo> searchImportVersionAction(ImportVersionSearchCond cond) throws BLException;
	
	
	/**
	 * 导入对象检索
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO searchImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * 采集控制台查询处理
	 * @param dto IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2014Action(IGASM20DTO dto) throws BLException;
	
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
	
	public IGASM20DTO revokeImportVesionAction(IGASM20DTO dto) throws BLException;
	
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
	
	public IGASM20DTO InsertImportVesionAction(IGASM20DTO dto)throws BLException;
	
	/**
	 * 资产域定义信息查询处理
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM20DTO searchEiDomainDefAction(IGASM20DTO dto) throws BLException;
	/**
	 * 资产域定义变更初始化
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2002Action(IGASM20DTO dto)throws BLException;

	/**
	 * 资产域定义变更处理
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO updateEiDomainDefAction(IGASM20DTO dto) throws BLException;
	/**
	 * 资产域定义详细信息初始化
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2005Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * 控制台显示处理
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2001Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * 控制台任务查看处理
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO initIGASM2010Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * 待处理任务删除处理
	 * 
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiWaitTaskAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * 资产域定义删除处理
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO deleteEiDomainDefAction(IGASM20DTO dto) throws BLException;

	/**
	 * 导入对象信息登记处理
	 * @param dto
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO insertImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * 控制台导入处理
	 * 
	 * @param dtoIGASM20DTO
	 * @return IGASM20DTO
	 * @throws BLException
	 */
	public IGASM20DTO importIGASM2001Action(IGASM20DTO dto) throws BLException;

	/**
	 * 导入对象删除处理
	 * @param dto
	 * @throws BLException
	 */
	public IGASM20DTO deleteImportVersionAction(IGASM20DTO dto) throws BLException;
	
	/**
	 * 导入对象状态调整
	 * @param dto
	 * @throws BLException
	 */
	public void changeDeleteFlagAction(IGASM20DTO dto) throws BLException ;

	/**
	 * 导入对象类型
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO getEiImportProgrammeAction(IGASM20DTO dto) throws BLException;
	/**
	 * 导入对象版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchImportVersionIGASM2010Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * 资产域定义版本检索
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2012Action(IGASM20DTO dto) throws BLException;
	
	/**
	 * 域手动快照生成
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO handSnapshotAction(IGASM20DTO dto) throws BLException;

	/**
	 * 最新版本域信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchIGASM2013Action(IGASM20DTO dto)throws BLException;

	/**
	 * 域CI查询处理
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGASM20DTO searchDoaminCiInfoAction(IGASM20DTO dto) throws BLException;
}
