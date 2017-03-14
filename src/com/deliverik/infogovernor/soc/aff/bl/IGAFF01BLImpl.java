package com.deliverik.infogovernor.soc.aff.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0114BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.infogovernor.soc.aff.dto.IGAFF01DTO;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0101Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0102Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0103Form;
import com.deliverik.infogovernor.soc.aff.form.IGAFF0104Form;

/**
 * 设备影响分析业务逻辑实现
 *
 */
public class IGAFF01BLImpl extends BaseBLImpl implements IGAFF01BL {

	static Log log = LogFactory.getLog(IGAFF01BLImpl.class);
	
	private SOC0118BL soc0118BL;
	private SOC0114BL soc0114BL;
	private SOC0119BL soc0119BL;

	
	
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	public void setSoc0114BL(SOC0114BL soc0114bl) {
		soc0114BL = soc0114bl;
	}

	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	

	public IGAFF01DTO searchEntityItems(IGAFF01DTO dto) throws BLException{
		
		log.debug("========设备信息查询处理开始========");
		
		Integer eiid = null;
		SOC0119SearchCondImpl soc0119Cond = new SOC0119SearchCondImpl();
		List<Integer> eiids =null;
		//如果是主机影响分析,通过关联关系查询被影响的业务系统的eiid
		if(dto.getIgaff0101Form()!=null){
			IGAFF0101Form form = dto.getIgaff0101Form();
			soc0119Cond.setCldeiid(form.getEiid());
			soc0119Cond.setEirrelation("CR030100010001");
			eiids= soc0119BL.searchRelationByEiid(soc0119Cond);
		}else if(dto.getIgaff0102Form()!=null){
			//如果是中间件,通过链路查询被影响 的业务系统的eiid
			IGAFF0102Form form = dto.getIgaff0102Form();
			eiids = soc0114BL.searchLinkByEiid(form.getEiid());
		}else if(dto.getIgaff0103Form()!=null){
			//如果是数据库,通过链路查询被影响 的业务系统的eiid
			IGAFF0103Form form = dto.getIgaff0103Form();
			eiids = soc0114BL.searchLinkByEiid(form.getEiid());
			
		}else if(dto.getIgaff0104Form()!=null){
			//如果是虚拟化设备
			IGAFF0104Form form = dto.getIgaff0104Form();
			soc0119Cond.setCldeiid(form.getEiid());
			soc0119Cond.setEirrelation("CR030100010021");
			eiids= soc0119BL.searchRelationByEiid(soc0119Cond);
			
		}
		
		
		
		if(eiids==null||eiids.size()==0){
			log.debug("======== 设备查询数据不存在========");
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		}
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEiids(eiids);
		cond.setEsyscoding_like("999003001");
		
		int totalCount = soc0118BL.getEntityItemSearchCount(cond);
		if (totalCount == 0) {
			log.debug("======== 设备查询数据不存在========");
			//查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			
			pDto.setTotalCount(totalCount);
			
			List<SOC0118Info> soc0118List = soc0118BL.searchEntityItem(cond,pDto.getFromCount(), pDto.getPageDispCount());
			
			dto.setSoc0118List(soc0118List);
			
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========设备信息查询处理结束========");
		
		return dto;
		
	}
	
	
}
