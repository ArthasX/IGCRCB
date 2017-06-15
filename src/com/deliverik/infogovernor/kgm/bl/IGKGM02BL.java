/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;

/**
 * 概述: 知识管理业务逻辑BL接口
 * 功能描述：知识管理业务逻辑BL接口
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public interface IGKGM02BL extends BaseBL {

	
	/**
	 * 知识库查询(带评分)
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowLedgeInfoAction(IGKGM03DTO dto) throws BLException; 
	
	/**
	 * 知识登记
	 */
	public IGKGM03DTO insertAction(IGKGM03DTO dto) throws BLException;
	
	
	/**
	 * 知识更新
	 */
	public IGKGM03DTO insertKnowledgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识管理(查询)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：更新知识状态
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeStatus(IGKGM03DTO dto) throws BLException ;
		
	/**
	 * 知识库明细查询
	 * @param knid
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeDetailAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 知识评分表查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeGradeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识管理(修改)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识管理(主键查询)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识更新管理(主键查询)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchUpdateKnowLedgeActionbyPK(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 知识评分登记
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO registKnowledgeGradeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识管理(删除)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO deleteKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识详细信息查询(主键查询)
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowLedgeDetailActionbyPK(IGKGM03DTO dto) throws BLException;
	/**
	 * 功能：查询自己提交的知识
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchMyKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：查询自己提交的知识
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeNotCheckAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：查找关键字
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO searchKnowledgeKeyAction(IGKGM03DTO dto,CodeDetailBL codeDetailBL) throws BLException;
	
	/**
	 * 功能：查询知识历史信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeHistory(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：查看知识关联的流程和服务工单
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeProcessByKnid(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：业务系统List取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getSystem_typeList(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识关联业务系统List取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识关联业务系统初始化取得
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO getKnowledgeAppImpact_Disp(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：根据流程id查找流程名称
	 * @param dto
	 * @return dto
	 * @throws BLException
	 */
	public IGKGM03DTO searchProcessRecordByKey(IGKGM03DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 查询知识审批人角色
	 * </p>
	 * @return IGKGM03DTO
	 * @author leexuzhi@deliverik.com
	 */
	public IGKGM03DTO getRoleKnApproveRole(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：更新知识状态
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO updateOneKnowLedgeStatus(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识批量导出
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO exportKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 功能：知识批量导出用业务系统查询
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public String searchKnowLedgeAppImpactAction(Integer knid, Integer knversion) throws BLException;
	
	/**
	 * 功能：知识下载
	 *
	 * @param dto 
	 * @return dto
	 * @throws BLException 
	 */
	public IGKGM03DTO downKnowLedgeAction(IGKGM03DTO dto) throws BLException;
	
	/**
	 * 知识详细页面查询
	 * @param dto
	 * @return 返回值0表示没有未审批的“知识更新”数据。1表示有。
	 * @throws BLException
	 */
	public IGKGM03DTO searchKnowledgeNotCheckActionForKGMDis(IGKGM03DTO dto)throws BLException;
	
	/**
	 * 获取知识提交次数
	 * @param dto
	 * @return 
	 */
	public IGKGM03DTO getKnowledgeCount(IGKGM03DTO dto) throws BLException;

	/**
	 * 
	 * 知识管理(查询)
	 */
	public IGKGM02DTO searchProcessRecordLogAction(IGKGM02DTO dto) throws BLException;
	
	/**
	 * 知识贡献数量统计(查询)
	 * @param dto
	 */
	public IGKGM02DTO searchStatisticalKnowledgeContribution(IGKGM02DTO dto) throws BLException;
	
	/**
	 * 查询业务系统分类
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGKGM02DTO searchBusinessSystem(IGKGM02DTO dto) throws BLException;
}
