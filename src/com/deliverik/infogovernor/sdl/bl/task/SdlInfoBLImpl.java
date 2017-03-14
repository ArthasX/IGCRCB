/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.dao.SdlInfoTBDAO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_登记信息接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class SdlInfoBLImpl extends BaseBLImpl implements SdlInfoBL {

	/** SdlInfoTBDAO DAO */
	protected SdlInfoTBDAO sdlInfoTBDAO;

	public void setSdlInfoTBDAO(SdlInfoTBDAO sdlInfoTBDAO) {
		this.sdlInfoTBDAO = sdlInfoTBDAO;
	}

	/**
	 * <p>
	 * Description: 查询记录总数
	 * </p>
	 * 
	 * @param cond 检索条件
	 * @return int
	 * @author liupeng@deliverik.com
	 */
	public int getSearchCount(SdlInfoSearchCond cond){
		return sdlInfoTBDAO.getSearchCount(cond);
	}

	/**
	 * <p>
	 * Description: 登记信息查看
	 * </p>
	 * 
	 * @param sdiid 登记信息ID
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo searchSdlInfoByKey(Integer eid){

		SdlInfo ret = sdlInfoTBDAO.findByPK(eid);
		return ret;
	}

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
	public List<SdlInfo> searchSdlInfo(SdlInfoSearchCond cond, int start, int count){
		List<SdlInfo> ret = sdlInfoTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * <p>
	 * Description: 登记信息保存
	 * </p>
	 * 
	 * @param sdlInfo 登记信息
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo registSdlInfo(SdlInfo sdlInfo) throws BLException{
		SdlInfo ret = sdlInfoTBDAO.save(sdlInfo);
		return ret;
	}
	/**
	 * <p>
	 * Description: 登记信息删除
	 * </p>
	 * 
	 * @param sdiid 登记信息ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlInfo(Integer eid) throws BLException{
		SdlInfo SdlInfo = checkExistSdlInfo(eid);
		sdlInfoTBDAO.delete(SdlInfo);
	}
	/**
	 * <p>
	 * Description: 登记信息修改
	 * </p>
	 * 
	 * @param sdlInfo 登记信息
	 * @return 登记信息
	 * @author liupeng@deliverik.com
	 */
	public SdlInfo updateSdlInfo(SdlInfo sdlInfo) throws BLException{
		SdlInfo ret = sdlInfoTBDAO.save(sdlInfo);
		return ret;
	}
	
	/**
	 * 登记信息存在检查
	 * 
	 * @param sdiid 登记信息ID
	 * @return 登记信息
	 * @throws BLException 
	 */
	protected SdlInfo checkExistSdlInfo(Integer sdiid) throws BLException{
		SdlInfo info = sdlInfoTBDAO.findByPK(sdiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","登记基本");
		}
		return info;
	}

}
