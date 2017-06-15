package com.deliverik.infogovernor.asset.bl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.IG189BL;
import com.deliverik.framework.asset.model.IG011Info;
import com.deliverik.framework.asset.model.IG445Info;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0601BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0602BL;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0604Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0601SearchCondImpl;
import com.deliverik.infogovernor.asset.dto.IGASM13DTO;

/**
 * 设备存量统计业务逻辑实现
 *
 */
public class IGASM13BLImpl extends BaseBLImpl implements IGASM13BL {

	static Log log = LogFactory.getLog(IGASM13BLImpl.class);

	protected IG189BL ig189BL;
	
	protected SOC0601BL soc601BL;
	
	protected SOC0602BL soc0602BL;

	public void setSoc0602BL(SOC0602BL soc0602BL) {
		this.soc0602BL = soc0602BL;
	}

	public void setSoc0601BL(SOC0601BL soc601BL) {
		this.soc601BL = soc601BL;
	}

	public void setIg189BL(IG189BL ig189BL) {
		this.ig189BL = ig189BL;
	}

	/**
	 * 计算每个一级分类名下的设备数量所占总数的比例
	 * @param count 每个一级分类下设备的数量
	 * @param total 总数
	 */
	private String getPercent(Integer count,Integer total) {   
	    String result="";//接受百分比的值   
	    double dcount = count.doubleValue();   
	    double dtotal = total.doubleValue();  
	    if(total==0){
	    	result="0%";
	    }else{
	    	double percount=dcount/dtotal;   
		    //NumberFormat nf   =   NumberFormat.getPercentInstance();
		    //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位   
		    //baifenbi=nf.format(fen);
	    	if(percount==0){
	    		result="0%";
	    	}else{
	    		DecimalFormat df1 = new DecimalFormat("##.##%");//##.00%   百分比格式，后面不足2位的用0补齐    
			    result = df1.format(percount);    
	    	}  
	    }
	    
	    return result;   
	}  

	/**
	 * 取得设备存量统计的结果
	 */
	public IGASM13DTO getEntityCount(IGASM13DTO dto) throws BLException {

		log.debug("========设备存量统计处理开始========");

		
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(ig189BL.getIG011InfoSearchCount(dto.getEntityCountSearchCond()));

		List<IG011Info> ecList = ig189BL.searchIG011Info(dto.getEntityCountSearchCond());
		
		Integer total = 0;
		for(IG011Info ec : ecList){
			total+=ec.getTotal();
		}
		for(IG011Info ec : ecList){
			ec.setProportion(getPercent(ec.getTotal(),total));
		}
		dto.setEcList(ecList);
		dto.setTotal(total);
		
		
		log.debug("========设备存量统计处理终了========");
		return dto;
	}
	
	/**
	 * 取得设备存量分布式统计的结果
	 */
	public IGASM13DTO getEquDistributingCount(IGASM13DTO dto) throws BLException {

		log.debug("========设备存量分布式统计处理开始========");

		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(ig189BL.getIG445InfoSearchCount(dto.getEquDistributingCountSearchCond()));
		

		List<IG445Info> edList = ig189BL.searchIG445Info(dto.getEquDistributingCountSearchCond());
		
		Integer total = 0;
		for(IG445Info ed : edList){
			total+=ed.getCount();
		}
		for(IG445Info ed : edList){
			ed.setProportion(getPercent(ed.getCount(),total));
		}
		dto.setEdList(edList);
		dto.setTotal(total);

		log.debug("========设备存量分布式统计处理终了========");
		return dto;
	}
	
	
	
	/**
	 * 取得机房机柜统计的结果
	 */
	public IGASM13DTO searchComputerRoomAndContainer(IGASM13DTO dto) throws BLException {
		PagingDTO pDto = dto.getPagingDto();

		// 查询记录总数
		int totalCount = soc0602BL.getSOC0604InfoSearchCount(dto.getComputerRoomAndContainerVWSearchCond());
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		pDto.setTotalCount(totalCount);
		List<SOC0604Info> ecList = soc0602BL.searchSOC0604Info(dto.getComputerRoomAndContainerVWSearchCond(), 
				pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setCrcList(ecList);
		
		return dto;
	}
	
	/**
	 * 取得机房下拉列表
	 */
	public List<LabelValueBean> getComputerRoomList(IGASM13DTO dto) throws BLException {
		SOC0601SearchCondImpl cond = new SOC0601SearchCondImpl();
		
		List<SOC0601Info> list  = soc601BL.searchSOC0601Info(cond, 0, 0);
		
		List<LabelValueBean> codeList = new ArrayList<LabelValueBean>();
		codeList.add(new LabelValueBean("", ""));
		for(Iterator<SOC0601Info> iter = list.iterator();iter.hasNext();){
			SOC0601Info itemsCodes = iter.next();	
			codeList.add(new LabelValueBean(itemsCodes.getEiname(), itemsCodes.getEiid().toString()));	
		}
		return codeList;
	}
	

}
