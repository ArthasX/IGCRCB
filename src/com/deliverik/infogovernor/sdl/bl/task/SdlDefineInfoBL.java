/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准接口
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlDefineInfoBL extends BaseBL {
	
	/**
	 * <p>
	 * Description: 标准查询
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return List<SdlDefineInfo>
	 * @author liupeng@deliverik.com
	 */
	public List<SdlDefineInfo> searchSdlDefineInfo(SdlDefineInfoSearchCond cond, int start, int count);
	
	/**
	 * <p>
	 * Description: 查询记录总数
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlDefineInfoSearchCond cond);

	/**
	 * <p>
	 * Description: 标准查看
	 * </p>
	 * 
	 * @param sdiid 标准ID
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo searchSdlDefineInfoByKey(Integer sdiid);
	
	/**
	 * <p>
	 * Description: 标准保存
	 * </p>
	 * 
	 * @param sdlDefineInfo 标准信息
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo registSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException;
	
	/**
	 * <p>
	 * Description: 标准删除
	 * </p>
	 * 
	 * @param sdiid 标准ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlDefineInfo(Integer sdiid) throws BLException;
	
	/**
	 * <p>
	 * Description: 标准修改
	 * </p>
	 * 
	 * @param sdlDefineInfo 标准信息
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo updateSdlDefineInfo(SdlDefineInfo SdlDefineInfo) throws BLException;
}
