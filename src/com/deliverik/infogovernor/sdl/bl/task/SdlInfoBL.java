/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_登记信息实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlInfoBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 登记信息查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<SdlInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlInfo> searchSdlInfo(SdlInfoSearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * Description: 查询记录总数
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlInfoSearchCond cond);

	/**
	 * <p>
	 * Description: 登记信息查看
	 * </p>
	 * 
	 * @param siid 登记信息ID
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo searchSdlInfoByKey(Integer siid);
	
	/**
	 * <p>
	 * Description: 登记信息保存
	 * </p>
	 * 
	 * @param sdlInfo 登记信息
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo registSdlInfo(SdlInfo sdlInfo) throws BLException;
	
	/**
	 * <p>
	 * Description: 登记信息删除
	 * </p>
	 * 
	 * @param siid 登记信息ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlInfo(Integer siid) throws BLException;
	
	/**
	 * <p>
	 * Description: 登记信息修改
	 * </p>
	 * 
	 * @param sdlInfo 登记信息
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo updateSdlInfo(SdlInfo SdlInfo) throws BLException;
}
