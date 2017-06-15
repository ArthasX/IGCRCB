/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sdl.bl.task.SdlDefineInfoBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL03DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0302Form;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_目标业务逻辑接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL03BLImpl extends BaseBLImpl implements IGSDL03BL {

	static Log log = LogFactory.getLog(IGSDL03BLImpl.class);

	/** 目标信息BL */
	protected SdlDefineInfoBL sdlDefineInfoBL;
	

	public void setSdlDefineInfoBL(SdlDefineInfoBL sdlDefineInfoBL) {
		this.sdlDefineInfoBL = sdlDefineInfoBL;
	}

	/**
	 * 目标信息查询处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO searchSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {

		log.debug("========目标信息查询处理开始========");
		
		//目标信息查询件数取得 
		int totalCount = this.sdlDefineInfoBL.getSearchCount(dto.getSdlDefineInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========目标信息查询数据不存在========");
			//目标信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========目标信息查询数据件数过多========");
			//目标信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页目标信息取得
		List<SdlDefineInfo> sdlDefineInfoList = this.sdlDefineInfoBL.searchSdlDefineInfo(dto.getSdlDefineInfoSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSdlDefineInfoList(sdlDefineInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========目标信息查询处理终了========");
		return dto;
	}

	/**
	 * 目标信息登记处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO insertSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========目标信息登记处理开始========");
		
		//目标信息登记处理
		this.sdlDefineInfoBL.registSdlDefineInfo(dto.getSdlDefineInfo());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "目标基本信息") );

		log.debug("========目标信息登记处理终了========");
		return dto;
	}

	/**
	 * 目标信息编辑画面初期显示处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO initSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {

		log.debug("========目标信息编辑画面初期显示处理开始========");
		
		IGSDL0302Form form = dto.getIgsdl0302Form();
		
		Integer sdiid = form.getSdiid();
		
		//显示用目标信息取得
		SdlDefineInfo sdlDefineInfo = this.sdlDefineInfoBL.searchSdlDefineInfoByKey(sdiid);
		
		if ( sdlDefineInfo == null ){
			throw new BLException("IGCO10000.E004","目标基本");
		}
		form.setSdiyear(sdlDefineInfo.getSdiyear());//年度
		form.setSdieiid(sdlDefineInfo.getSdieiid());// 相关资产ID
		form.setSdieiname(sdlDefineInfo.getSdieiname());//资产名称
		form.setSdibreakm(sdlDefineInfo.getSdibreakm());// 月中断时间
		form.setSdibreaky(sdlDefineInfo.getSdibreaky());//年中断时间
		form.setSdicontinuousm(sdlDefineInfo.getSdicontinuousm());//月连续时间百分比
		form.setSdicontinuousy(sdlDefineInfo.getSdicontinuousy());//年连续时间百分比
		form.setSdiimpactm(sdlDefineInfo.getSdiimpactm());//月影响时间
		form.setSdiimpacty(sdlDefineInfo.getSdiimpacty());//年影响时间
		form.setSdisteadym(sdlDefineInfo.getSdisteadym());//月稳定时间百分比
		form.setSdisteadyy(sdlDefineInfo.getSdisteadyy());//年稳定时间百分比
		form.setSdisafecasem(sdlDefineInfo.getSdisafecasem());//月安全事件个数
		form.setSdisafecasey(sdlDefineInfo.getSdisafecasey());//年安全事件个数
		form.setSdisafemarkm(sdlDefineInfo.getSdisafemarkm());//月安全事件评分
		form.setSdisafemarky(sdlDefineInfo.getSdisafemarky());//年安全事件评分
		form.setSdiriskmarkm(sdlDefineInfo.getSdiriskmarkm());//月风险检查评分
		form.setSdiriskmarky(sdlDefineInfo.getSdiriskmarky());//年风险检查评分
		form.setSdicapacitycasem(sdlDefineInfo.getSdicapacitycasem());//月容量事件个数
		form.setSdicapacitycasey(sdlDefineInfo.getSdicapacitycasey());//年容量事件个数
		form.setSdicapacitymarkm(sdlDefineInfo.getSdicapacitymarkm());//月容量事件评分
		form.setSdicapacitymarky(sdlDefineInfo.getSdicapacitymarky());//年容量事件评分
		
		//编辑模式设定
		form.setMode("1");
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","目标基本信息"));
		
		log.debug("========目标信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 目标信息更新处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO updateSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========目标信息更新处理开始========");
		
		//目标信息更新处理
		this.sdlDefineInfoBL.updateSdlDefineInfo(dto.getSdlDefineInfo());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "目标基本信息") );
		
		log.debug("========目标信息更新处理终了========");
		return dto;
	}

	/**
	 * 目标信息删除处理
	 *
	 * @param dto IGSDL03DTO
	 * @return IGSDL03DTO
	 */
	public IGSDL03DTO deleteSdlDefineInfoAction(IGSDL03DTO dto) throws BLException {
		log.debug("========目标信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteSdlDefineInfoid().length;i++ ){
			String sdiid = dto.getDeleteSdlDefineInfoid()[i];
			//目标信息删除处理
			this.sdlDefineInfoBL.deleteSdlDefineInfo(Integer.parseInt(sdiid));
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I006", "目标基本信息") );
		log.debug("========目标信息删除处理终了========");
		return dto;
	}

}
