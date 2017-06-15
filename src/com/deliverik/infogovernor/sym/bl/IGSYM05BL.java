/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.dto.IGSYM05DTO;

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

public interface IGSYM05BL extends BaseBL {
	
	
	/**
	 * <p>
	 * Description: 取得需要滚动显示的通知信息
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public IGSYM05DTO getNoticeInfo(IGSYM05DTO dto) throws BLException ;
	/**
	 * <p>
	 * Description: 通知查询
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知删除
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO deleteNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知新增
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO insertNoticeAction(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知变更初始化
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO initIGSYM0502Action(IGSYM05DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 通知变更
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author liupeng@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO updateNoticeAction(IGSYM05DTO dto) throws BLException;
	/**
	 * <p>
	 * Description: 通知单个查询
	 * </p>
	 * 
	 * @param dto IGSYM05DTO
	 * @return IGSYM05DTO
	 * @throws BLException
	 * @author tangxiaona@deliverik.com
	 * @update
	 */
	
	public IGSYM05DTO searchNoticeDetail(IGSYM05DTO dto) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String userid, List<UserRoleInfo> list, String temp) throws BLException;
	
	public IGSYM05DTO searchDateWorkAction(String date, String userid) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list) throws BLException;
	public IGSYM05DTO searchDateWorkAction(String date, String userid, List<UserRoleInfo> list, String temp) throws BLException;
}
