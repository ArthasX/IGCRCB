/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.bl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.sdl.bl.task.SdlDefineInfoBL;
import com.deliverik.infogovernor.sdl.bl.task.SdlInfoBL;
import com.deliverik.infogovernor.sdl.bl.task.SdlSummaryBL;
import com.deliverik.infogovernor.sdl.bl.task.SdlYearSummaryBL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlInfo;
import com.deliverik.infogovernor.sdl.model.SdlSummary;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;
import com.deliverik.infogovernor.sdl.model.condition.SdlDefineInfoSearchCondImpl;
import com.deliverik.infogovernor.sdl.model.condition.SdlSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.condition.SdlYearSummarySearchCond;
import com.deliverik.infogovernor.sdl.model.entity.SdlSummaryVW;
import com.deliverik.infogovernor.sdl.model.entity.SdlYearSummaryVW;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计业务逻辑接口实现
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL05BLImpl extends BaseBLImpl implements IGSDL05BL {

	static Log log = LogFactory.getLog(IGSDL05BLImpl.class);

	/** 统计信息BL */
	protected SdlSummaryBL sdlSummaryBL;

	/** 标准信息BL */
	protected SdlDefineInfoBL sdlDefineInfoBL;
	
	/** 信息BL */
	protected SdlInfoBL sdlInfoBL;
	
	/** 附件BL */
	protected AttachmentBL attachmentBL;
	
	/** 统计信息BL */
	protected SdlYearSummaryBL sdlYearSummaryBL;
	
	public void setSdlYearSummaryBL(SdlYearSummaryBL sdlYearSummaryBL) {
		this.sdlYearSummaryBL = sdlYearSummaryBL;
	}

	public void setSdlInfoBL(SdlInfoBL sdlInfoBL) {
		this.sdlInfoBL = sdlInfoBL;
	}

	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	public void setSdlSummaryBL(SdlSummaryBL sdlSummaryBL) {
		this.sdlSummaryBL = sdlSummaryBL;
	}
	
	public void setSdlDefineInfoBL(SdlDefineInfoBL sdlDefineInfoBL) {
		this.sdlDefineInfoBL = sdlDefineInfoBL;
	}

	/**
	 * 统计信息查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlSummaryAction(IGSDL05DTO dto) throws BLException {

		log.debug("========统计信息查询处理开始========");
		
		SdlSummarySearchCond sscond = dto.getSdlSummarySearchCond();
		SdlDefineInfoSearchCondImpl cond = new SdlDefineInfoSearchCondImpl();
		cond.setSdieiid(sscond.getEiid());
		cond.setSdiyear(sscond.getYear());
		List<SdlDefineInfo> infoList = sdlDefineInfoBL.searchSdlDefineInfo(cond, 0, 0);
		if(infoList.size() == 1 ) {
			dto.setSdlDefineInfo(infoList.get(0));
		}

		//当前页统计信息取得
		List<SdlSummary> sdlSummaryList = this.sdlSummaryBL.searchSdlSummary(sscond, 0, 0);
		
		for(SdlSummary sdl : sdlSummaryList){
			SdlSummaryVW vw = (SdlSummaryVW)sdl;
			vw.setContinuousm(calculatePercent(vw.getMonth() , vw.getBreakm()));
			vw.setSteadym(calculatePercent(vw.getMonth() , vw.getImpactm()));
		}
		if(sdlSummaryList.size()<13){
			SdlSummaryVW vw = new SdlSummaryVW();
			vw.setContinuousm(calculatePercent("13" , vw.getBreakm()));
			vw.setSteadym(calculatePercent("13" , vw.getImpactm()));
			sdlSummaryList.add(vw);
		}
		dto.setSdlSummaryList(sdlSummaryList);
		
		log.debug("========统计信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 信息查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoAction(IGSDL05DTO dto) throws BLException {

		log.debug("========信息查询处理开始========");
		
		//信息查询件数取得 
		int totalCount = this.sdlInfoBL.getSearchCount(dto.getSdlInfoSearchCond());
		
		if (totalCount == 0) {
			log.debug("========信息查询数据不存在========");
			//信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========信息查询数据件数过多========");
			//信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页信息取得
		List<SdlInfo> sdlInfoList = this.sdlInfoBL.searchSdlInfo(dto.getSdlInfoSearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setSdlInfoList(sdlInfoList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 信息详细信息处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlInfoDetailAction(IGSDL05DTO dto) throws BLException{
		SdlInfo sdlinfo = this.sdlInfoBL.searchSdlInfoByKey(dto.getSiid());
		dto.setSdlInfo(sdlinfo);
		String attkey = sdlinfo.getSiattkey();
		if(StringUtils.isNotEmpty(attkey)){
			List<Attachment> attachmentList = this.attachmentBL.searchAttachmentsByAttkey(attkey);
			dto.setAttachmentList(attachmentList);
		}else{
			dto.setAttachmentList(new ArrayList<Attachment>());
		}
		return dto;
	}
	
	/**
	 * 统计信息查询处理
	 *
	 * @param dto IGSDL05DTO
	 * @return IGSDL05DTO
	 */
	public IGSDL05DTO searchSdlYearSummaryAction(IGSDL05DTO dto) throws BLException {

		log.debug("========统计信息查询处理开始========");
		
		SdlYearSummarySearchCond sscond = dto.getSdlYearSummarySearchCond();

		//当前页统计信息取得
		List<SdlYearSummary> sdlYearSummaryList = this.sdlYearSummaryBL.searchSdlYearSummary(sscond, 0, 0);
		SdlDefineInfoSearchCondImpl cond = new SdlDefineInfoSearchCondImpl();
		for(SdlYearSummary sdl : sdlYearSummaryList){
			SdlYearSummaryVW vw = (SdlYearSummaryVW)sdl;
			vw.setContinuousm(calculatePercent("13" , vw.getBreakm()));
			vw.setSteadym(calculatePercent("13" , vw.getImpactm()));
			cond.setSdieiid(sdl.getSieiid());
			cond.setSdiyear(sscond.getYear());
			List<SdlDefineInfo> infoList = sdlDefineInfoBL.searchSdlDefineInfo(cond, 0, 0);
			if(infoList.size() == 1 ) {
				vw.setSdlDefineInfo(infoList.get(0));
			}
		}
		dto.setSdlYearSummaryList(sdlYearSummaryList);
		
		log.debug("========统计信息查询处理终了========");
		return dto;
	}

	/**
	 * 计算百分比
	 *
	 * @param month String
	 * @param num Integer
	 * @return Double
	 */
	protected static Double calculatePercent(String month,Integer num) {
		
		if(num == null){
			num = 0;
		}
		//百分比
		double time = 0.0D;
		if("13".equals(month)){
			if(PRJHelper.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))){
				time = num/(366*24*60.0);
			}else{
				time = num/(365*24*60.0);
			}
			return roundDouble((1-time)*100);
		}
		
		int i = 0;
		if(month.startsWith("0")){
			i = Integer.parseInt(month.substring(1));
		}else{
			i = Integer.parseInt(month);
		}
		//月份
		switch(i){
		case 1:	
		case 3:	
		case 5:	
		case 7:	
		case 8:	
		case 10:	
		case 12:	
			time = num/(31*24*60.0);
			break;
		case 2:	
			if(PRJHelper.isLeapYear(Calendar.getInstance().get(Calendar.YEAR))){
				time = num/(29*24*60.0);
			}else{
				time = num/(28*24*60.0);
			}
			break;
		case 4:	
		case 6:	
		case 9:	
		case 11:	
			time = num/(30*24*60.0);
			break;
	}
		
		return roundDouble((1-time)*100);
	} 
	
	/**
	 * 四舍五入
	 *
	 * @param num Double
	 * @return Double
	 */
	protected static Double roundDouble(Double num) {
		BigDecimal bd = new BigDecimal(num);
		bd = bd.setScale(3,BigDecimal.ROUND_HALF_UP);  
		return bd.doubleValue();
	}

}

