/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;

/**
 * 应急资产管理BL
 * 
 * @author 张剑
 *
 * 2015-2-12 上午11:02:20
 */

public interface IGDRM04BL extends BaseBL {


	/**
	 * 初始化应急资产新增页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO init0401Action(IGDRM04DTO dto) throws BLException;
	/**
	 * 应急资产保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO regEmergencyResource(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 应急资产快捷保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO regEmergencyResourceShortcut(IGDRM04DTO dto)throws BLException, FileNotFoundException, IOException;
	
	/**
	 * 获取应急资产编号
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getLabel(IGDRM04DTO dto)throws BLException;
	/**
	 * 应急资产查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO searchEmergencyResource(IGDRM04DTO dto)throws BLException;
	/**
	 * 应急资产配置信息编辑处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM04DTO editEntityItemAction(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException ;
	/**
	 * 应急资产配置信息编辑画面初期化处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM04DTO initIGDRM0404Action(IGDRM04DTO dto) throws BLException ;
	/**
	 * 应急资产删除处理
	 *
	 * @param dto IGASM05DTO
	 * @return IGASM05DTO
	 */
	public IGDRM04DTO deleteEntityItemAction(IGDRM04DTO dto) throws BLException;
	/**
	 * 获取应急资产中附件的ciid
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM04DTO getArrId(IGDRM04DTO dto)throws BLException;
	
	
	
	//资产分类

	/**
	 * 资产信息查询处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * 资产信息登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertEntityAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * 资产信息编辑画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0412Action(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产信息更新处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateEntityAction(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产配置信息登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationAction(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产配置信息编辑画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0414Action(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产配置信息更新处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO updateConfigurationAction(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产详细信息画面初期显示处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO initIGDRM0416Action(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产信息删除处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteEntityAction(IGDRM04DTO dto) throws BLException;

	/**
	 * 资产配置信息删除处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO deleteConfigurationAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产分类状态变化
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGDRM04DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 资产分类属性状态变化
	 * </p>
	 * 
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGDRM04DTO dto) throws BLException;
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchConfigurationCodeDetailBean(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO searchConfigurationCodeDetail(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO searchCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException;
	/**
	 * 资产下拉数据登记处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO insertConfigurationCodeDetailAction(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO getCfgCodeDetailByCategory(IGDRM04DTO dto) throws BLException;
	
	public IGDRM04DTO insertCfgCodeDetailAction(IGDRM04DTO dto) throws BLException;
	
	/**
	 * 查询不包括机房、机柜及服务记录的一级分类（生成EXCEL模板使用）
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 */
	public IGDRM04DTO searchEntityActionForExportExcelModel(IGDRM04DTO dto) throws BLException;
	/**
	 * 导出Excel模板
	 * @throws Exception
	 */
	public IGDRM04DTO searchInfoForExportExcel(String esyscode) throws BLException;
	
	/**
	 * 资产属性默认值编辑画面初期化处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws Exception
	 */
	public IGDRM04DTO initIGDRM0424Action(IGDRM04DTO dto) throws BLException;
	
	/**
	 * 资产属性默认值编辑处理
	 *
	 * @param dto IGDRM04DTO
	 * @return IGDRM04DTO
	 * @throws BLException 
	 */
	public IGDRM04DTO editIGDRM0424Action(IGDRM04DTO dto) throws BLException, FileNotFoundException, IOException;;

	/**
	 * 查询应急资源分类名称
	 * @param dto
	 * @return
	 * @throws BLException
	 */

		public IGDRM04DTO searchEntityNameActionSOC(IGDRM04DTO dto) throws BLException;
		
		/**
		 * 获取应急资源详细信息
		 * 
		 * @param dto    IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO getEntityFullInfo(IGDRM04DTO dto) throws BLException;
		/**
		 * 资产项信息查询
		 * 
		 * @param dto
		 *            IGDRM07DTO
		 * @return IGDRM07DTO
		 */
		public IGDRM04DTO searchEntityItem0406Action(IGDRM04DTO dto) throws BLException;
		
		/***
		 * 查询应急资源属性列表
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO searchConfigList(IGDRM04DTO dto) throws BLException;
		/**
		 * 应急资源资产关联查询处理
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO searchEntityItemAction(IGDRM04DTO dto) throws BLException ;
		/**
		 * 应急资源资产关联处理
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO setRelationAction(IGDRM04DTO dto) throws BLException ;
		/**
		 * 应急资源资产解除单个关联关系
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO deleteSigleRelationAction(IGDRM04DTO dto) throws BLException;
		/**
		 * 应急资源资产批量解除关联关系
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO deleteRelationAction(IGDRM04DTO dto) throws BLException;
		/**
		 * 初始化树
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO initNewNodeMap(IGDRM04DTO dto)throws BLException;
		/**
		 * 应急资源修改对应资产模型（已有关联不能修改）
		 *
		 * @param erid
		 * @return boolean
		 */
		public boolean searchRelationAjaxAction(Integer erid) throws BLException;
		/**
		 * 应急资源资产关联查询处理(初始化)
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO searchEntityDisp(IGDRM04DTO dto) throws BLException;
		/**
		 * 应急资源登记属性信息列表
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 * @throws IOException 
		 */
		public String getConfigList(IGDRM04DTO dto) throws BLException;
		/**
		 * 设备配置信息编辑画面初期化处理
		 *
		 * @param dto IGDRM04DTO
		 * @return IGDRM04DTO
		 */
		public IGDRM04DTO initIGDRM0430Action(IGDRM04DTO dto) throws BLException ;
		
		/**
		 * 获取应急资源分类树显示内容
		 * @param dto
		 * @return
		 * @throws BLException
		 */
		public IGDRM04DTO getTreeNodeNameCountAction(IGDRM04DTO dto) throws BLException;
}
