/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.drm.dto.IGDRM14DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_通知管理_BL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface IGDRM14BL extends BaseBL {
	
	
	/**
	 * <p>
	 * Description: 取得需要滚动显示的通知信息
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public IGDRM14DTO getNoticeInfo(IGDRM14DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: 通知查询
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知查询
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchPageNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知删除
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO deleteNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知新增
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO insertNoticeAction(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知变更初始化
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO initIGDRM1402Action(IGDRM14DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知变更
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO updateNoticeAction(IGDRM14DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 通知单个查询
	 * </p>
	 * 
	 * @param dto IGDRM14DTO
	 * @return IGDRM14DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGDRM14DTO searchNoticeDetail(IGDRM14DTO dto) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid, List<UserRoleInfo> list) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String userid, List<UserRoleInfo> list, String temp) throws BLException;
	
	public IGDRM14DTO searchDateWorkAction(String date, String userid) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list) throws BLException;
	public IGDRM14DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list, String temp) throws BLException;
}
