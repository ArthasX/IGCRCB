package com.deliverik.infogovernor.soc.iop.bl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP02DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0201Form;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0202Form;

/**
 * 设备影响分析业务逻辑实现
 *
 */
public class IGIOP02BLImpl extends BaseBLImpl implements IGIOP02BL {

	static Log log = LogFactory.getLog(IGIOP02BLImpl.class);
	
	private SOC0118BL soc0118BL;



	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	
	
	/**
	 * 根据IP资产的eiid 查询
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIPByEiids(IGIOP02DTO dto)throws BLException{
		IGIOP0201Form form = dto.getIgiop0201Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		
		cond.setEiid(form.getEiid().toString());
		cond.setEid(form.getEid());
		List<SOC0118Info> ipList = soc0118BL.searchEntityItem(cond);
		
		dto.setSoc0118List(ipList);
		
		return dto;
	}
	/**
	 * IP资产查询
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO searchIP(IGIOP02DTO dto)throws BLException{
		
		IGIOP0201Form form = dto.getIgiop0201Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		
		cond.setEid(form.getEid());
		cond.setEiname(form.getEiName());
		cond.setEidesc_falg(form.getIpStatus());
		cond.setEilabel_like(form.getSubnet());
		
		// 设备信息查询件数取得
		int totalCount = this.soc0118BL.getEntityItemSearchCount(cond);

		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			// 设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGIOP0201.E001", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========设备信息查询数据件数过多========");
			// 设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGIOP0201.E002", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		// 当前页设备信息取得
		List<SOC0118Info> ipList = this.soc0118BL.searchEntityItem(cond,
				pDto.getFromCount(), pDto.getPageDispCount());

		pDto.setTotalCount(totalCount);
		
		dto.setSoc0118List(ipList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		return dto;
	}
	
	/**
	 * IP回收
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO recoveryIP(IGIOP02DTO dto)throws BLException{
		
		if(dto.getIgiop0201Form().getDelEiids()==null){
		
			getIPByEiid(dto);
			
			SOC0118TB ipTB = (SOC0118TB)dto.getIpInfo();
			
			ipTB.setEidesc(null);
			
			soc0118BL.updateEntityItem(ipTB);
			
		}else{
			SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
			cond.setEiids(Arrays.asList(dto.getIgiop0201Form().getDelEiids()));
			int result = soc0118BL.clearEidescByEiid(cond);
			dto.addMessage( new ActionMessage("IGIOP0102.I003",result));
		}
		
		return dto;
	}
	
	
	
	/**
	 * 根据eiid 查询IP
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGIOP02DTO getIPByEiid(IGIOP02DTO dto)throws BLException{
		
		IGIOP0201Form iop0201form = dto.getIgiop0201Form();
		IGIOP0202Form iop0202form = dto.getIgiop0202Form();
		Integer eiid ;
		if(iop0201form == null){
			eiid = iop0202form.getEiid();
		}else{
			eiid = iop0201form.getEiid();
		}
		
		
		SOC0118Info ipInfo = soc0118BL.searchEntityItemByKey(eiid);
		
		dto.setIpInfo(ipInfo);
		
		return dto;
	}
	
	/**
	 * IP分配
	 * @param dto
	 * @return
	 */
	public IGIOP02DTO allotIP(IGIOP02DTO dto)throws BLException{
		
		getIPByEiid(dto);
		
		SOC0118TB ipTB = (SOC0118TB)dto.getIpInfo();
		
		ipTB.setEidesc(dto.getIgiop0202Form().getDesc());
		
		soc0118BL.updateEntityItem(ipTB);
		
		dto.addMessage(new ActionMessage("IGIOP0102.I004", 1));
		return dto;
	}
}
