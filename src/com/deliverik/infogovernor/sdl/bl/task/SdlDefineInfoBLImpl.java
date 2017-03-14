package com.deliverik.infogovernor.sdl.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCond;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCondImpl;
import com.deliverik.infogovernor.sdl.model.condition.SdlInfoSearchCondImpl;
import com.deliverik.infogovernor.sdl.model.dao.SdlDefineInfoTBDAO;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_标准接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class SdlDefineInfoBLImpl extends BaseBLImpl implements SdlDefineInfoBL {

	/** SdlDefineInfoTBDAO DAO */
	protected SdlDefineInfoTBDAO sdlDefineInfoTBDAO;
	
	protected SdlInfoBL sdlInfoBL;

	public void setSdlDefineInfoTBDAO(SdlDefineInfoTBDAO sdlDefineInfoTBDAO) {
		this.sdlDefineInfoTBDAO = sdlDefineInfoTBDAO;
	}

	public void setSdlInfoBL(SdlInfoBL sdlInfoBL) {
		this.sdlInfoBL = sdlInfoBL;
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
	public int getSearchCount(SdlDefineInfoSearchCond cond){
		return sdlDefineInfoTBDAO.getSearchCount(cond);
	}

	/**
	 * <p>
	 * Description: 标准查看
	 * </p>
	 * 
	 * @param sdiid 标准ID
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo searchSdlDefineInfoByKey(Integer eid){

		SdlDefineInfo ret = sdlDefineInfoTBDAO.findByPK(eid);
		return ret;
	}

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
	public List<SdlDefineInfo> searchSdlDefineInfo(SdlDefineInfoSearchCond cond, int start, int count){
		List<SdlDefineInfo> ret = sdlDefineInfoTBDAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * <p>
	 * Description: 标准保存
	 * </p>
	 * 
	 * @param sdlDefineInfo 标准信息
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo registSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException{
		checkNotExistSdlDefineInfo(sdlDefineInfo.getSdieiid(),sdlDefineInfo.getSdiyear(),sdlDefineInfo.getSdieiname());
		SdlDefineInfo ret = sdlDefineInfoTBDAO.save(sdlDefineInfo);
		return ret;
	}
	/**
	 * <p>
	 * Description: 标准删除
	 * </p>
	 * 
	 * @param sdiid 标准ID
	 * @author liupeng@deliverik.com
	 */
	public void deleteSdlDefineInfo(Integer eid) throws BLException{
		SdlDefineInfo SdlDefineInfo = checkExistSdlDefineInfo(eid);
		sdlDefineInfoTBDAO.delete(SdlDefineInfo);
	}
	/**
	 * <p>
	 * Description: 标准修改
	 * </p>
	 * 
	 * @param sdlDefineInfo 标准信息
	 * @return 标准信息
	 * @author liupeng@deliverik.com
	 */
	public SdlDefineInfo updateSdlDefineInfo(SdlDefineInfo sdlDefineInfo) throws BLException{
		SdlDefineInfo ret = sdlDefineInfoTBDAO.save(sdlDefineInfo);
		return ret;
	}

	/**
	 * 标准信息不存在检查
	 * 
	 * @param sdieiid 相关资产ID
	 * @param disyear 年度
	 * @param sdieiname 标准资产名称
	 * @throws BLException 
	 */
	protected void checkNotExistSdlDefineInfo(Integer sdieiid, String disyear, String sdieiname) throws BLException{
		SdlDefineInfoSearchCondImpl cond = new SdlDefineInfoSearchCondImpl();
		cond.setSdieiid(sdieiid);
		cond.setSdiyear(disyear);
		List<SdlDefineInfo> infoList = sdlDefineInfoTBDAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGSDL0301.E001",disyear,sdieiname);
		}
	}
	
	/**
	 * 标准信息存在检查
	 * 
	 * @param sdiid 标准ID
	 * @return 标准信息
	 * @throws BLException 
	 */
	protected SdlDefineInfo checkExistSdlDefineInfo(Integer sdiid) throws BLException{
		SdlDefineInfo info = sdlDefineInfoTBDAO.findByPK(sdiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","标准基本");
		}
		SdlInfoSearchCondImpl cond = new SdlInfoSearchCondImpl();
		cond.setSieiid(info.getSdieiid());
		List<SdlInfo> list = sdlInfoBL.searchSdlInfo(cond, 0, 0);
		if(list.size()>0){
			throw new BLException("IGSDL0301.E002",info.getSdieiname());
		}
		return info;
	}

}
