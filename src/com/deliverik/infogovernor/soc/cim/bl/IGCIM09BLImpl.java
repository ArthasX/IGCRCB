package com.deliverik.infogovernor.soc.cim.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.EiDomainKeyWords;
import com.deliverik.framework.soc.asset.EiRelationKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0111BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0163BL;
import com.deliverik.framework.soc.asset.model.SOC0111Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM09DTO;

/**
 * 网络管理BL实现
 * @author Administrator
 *
 */
public class IGCIM09BLImpl  extends BaseBLImpl implements IGCIM09BL{
	
	static Log log = LogFactory.getLog(IGCIM09BLImpl.class);
	

	private SOC0111BL soc0111BL;
	private SOC0163BL soc0163BL;
	
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 
	
	
	
	public void setSoc0163BL(SOC0163BL soc0163bl) {
		soc0163BL = soc0163bl;
	}
	
	public void setSoc0111BL(SOC0111BL soc0111bl) {
		soc0111BL = soc0111bl;
	}

	/**
	 * 设备信息查询处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM09DTO searchEntityItemAction(IGCIM09DTO dto) throws BLException {

		log.debug("========设备信息查询处理开始========");
		
		//设备信息查询件数取得 
		int totalCount = this.soc0163BL.getSearchCountForNetAsset(dto.getIgcim0910Form());
		
		if (totalCount == 0) {
			log.debug("========设备信息查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页设备信息取得
		List<SOC0163Info> entityVWInfoList = this.soc0163BL.findByCondForNetAsset(dto.getIgcim0910Form(), pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setEntityVWInfoList(entityVWInfoList);
		//dto.setEntityItemVWInfoList(entityItemVWInfoList);
		Integer domainid = EiDomainKeyWords.DOOMAIN_ID_DEFAULT;
		SOC0111Info domain  = this.soc0111BL.searchDomainMaxVersion(domainid);
		Integer domainversion = domain.getVersion();
		String createtime = domain.getUpdatetime();
		String showRelation = "N";
		Map<String,String> showRelationMap = new HashMap<String,String>();
		if(entityVWInfoList!=null){
			//主机，交换机，存储可以查看关系
			for(SOC0163Info bean:entityVWInfoList){
				if(bean.getEsyscoding().startsWith(EiRelationKeyWords.HOST) 
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.SWITCH)
						|| bean.getEsyscoding().startsWith(EiRelationKeyWords.STORAGE_DMX)) {
					showRelation = "Y";
				}else{
					showRelation = "N";
				}
				showRelationMap.put(String.valueOf(bean.getEiid()), showRelation);
			}
		}
		dto.setDomainid(domainid);
		dto.setDomainversion(domainversion);
		dto.setCreatetime(createtime);
		dto.setShowRelationMap(showRelationMap);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========设备信息查询处理终了========");
		return dto;
	}
	
	
}
