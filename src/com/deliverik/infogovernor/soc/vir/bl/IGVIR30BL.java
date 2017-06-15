/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化Vcloud管理BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGVIR30BL extends BaseBL{

	/**
	 * 初始化基本信息
	 * @param dto
	 * @return
	 */
	public IGVIR30DTO initBasicInfoAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 查询模板操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchTemplateAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 保存模板信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO saveApplyVMInfoAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 取得vm信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMInfAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 查询部署中的VM信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMListAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 自动部署进度数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO getApplyVMDataListAction(IGVIR30DTO dto) throws BLException;

	/**
	 * 查询部署日志操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGVIR30DTO searchDeployLogAction(IGVIR30DTO dto) throws BLException;

}
