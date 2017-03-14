/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.task.EventssBL;
import com.deliverik.infogovernor.drm.bl.task.ScopesBL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1601Form;
import com.deliverik.infogovernor.drm.form.IGDRM1602Form;
import com.deliverik.infogovernor.drm.form.IGDRM1603Form;
import com.deliverik.infogovernor.drm.form.IGDRM1604Form;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.ScopesInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.ScopesSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;
import com.deliverik.infogovernor.drm.model.entity.ScopesTB;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM16BLImpl extends BaseBLImpl implements IGDRM16BL {

	static Log log = LogFactory.getLog(IGDRM16BLImpl.class);

	/** 事件BL */
	private EventssBL eventssBL;
	
	/** 事件影响范围BL */
	private ScopesBL scopesBL; 

	/**
	 * eventssBL设定
	 * 
	 * @param eventssBL
	 */
	public void setEventssBL(EventssBL eventssBL) {
		this.eventssBL = eventssBL;
	}
	/**
	 * eventssBL取得
	 * 
	 * @param eventssBL
	 */

	public EventssBL getEventssBL() {
		return eventssBL;
	}

	/**
	 * scopesBL取得
	 * 
	 * @param scopesBL
	 */

	public ScopesBL getScopesBL() {
		return scopesBL;
	}
	
	/**
	 * scopesBL设定
	 * 
	 * @param scopesBL
	 */
	public void setScopesBL(ScopesBL scopesBL) {
		this.scopesBL = scopesBL;
	}
	
	/**
     * @Description: 查询事件所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getEventssList(IGDRM16DTO dto) {
		
		log.debug("==============事件查询开始=====================");
		//取得form
		IGDRM1602Form form = dto.getIgdrm1602Form();
		//取得查询条件
		EventssSearchCondImpl cond = new EventssSearchCondImpl();
	    cond.setEventssname(form.getSeventName());
//	    cond.setLabels(form.getLabels());	
	    cond.setEventDes(form.getSeventDes());
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//取得总数
		int totalCount=eventssBL.getSearchCount(cond);
		//验证查询的数量是否满足条件s
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//验证查询的数量是否满足条件e
		pDto.setTotalCount(totalCount);
		cond.setOrder("asc");
		cond.setOrderBy("eventid");
		dto.setEventssInfoList( eventssBL.searchEventss(cond,pDto.getFromCount(),pDto.getPageDispCount()));
		log.debug("==============事件查询结束=====================");	
		return dto;
	}
	/**
     * @Description: 删除事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO deleteEventssAction(IGDRM16DTO dto) throws BLException {
        log.debug("============事件信息删除开始=============");
		EventssInfo info=eventssBL.searchEventssByPK(dto.getIgdrm1602Form().getEventId());
		if(info!=null){
			eventssBL.deleteEventssByPK(dto.getIgdrm1602Form().getEventId());
		}else{
			dto.addMessage(new ActionMessage("IGASM4202.E002"));
		}
		log.debug("============事件信息删除结束=============");
		return dto;
	}
	
	/**
     * @Description: 添加事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO insertEventssAction(IGDRM16DTO dto) throws BLException {
		log.debug("============事件新增新增信息开始=============");
		//取得form
		IGDRM1601Form form = dto.getIgdrm1601Form();
		//创建事件实体赋值
		EventssTB entity= new EventssTB();
		entity.setEventname(form.getEventName());
		entity.setLabels(form.getLabels());
		entity.setEventdes(form.getEventDes());
		EventssInfo eveInfo = eventssBL.registEventss(entity);
		// Integer[] scopeids = form.getScopeid();
		//保存从表信息
		for (int i = 0; i < form.getImpscope().length - 1; i++) {
			ScopesTB scope = new ScopesTB();
			scope.setEventid(eveInfo.getEventid());
//			scope.setImpbus(form.getImpbus()[i]);
			scope.setImpscope(form.getImpscope()[i]);
			scope.setImptime(form.getImptime()[i]);
//			scope.setScopeid(form.getScopeid()[i]);
			scopesBL.registScopes(scope);
		}
		
		
		log.debug("============事件新增新增信息结束=============");
		return dto;
	}
	
	/**
     * @Description:  通过主键查询事件一条数据初始化
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchEventssByPK(IGDRM16DTO dto) throws BLException {
		log.debug("============取得事件一条数据开始=============");
		IGDRM1604Form form=dto.getIgdrm1604Form();
		Integer eventId = (form==null?dto.getIgdrm1603Form().getUpEventid():form.getUpEventid());
		ScopesSearchCondImpl cond = new ScopesSearchCondImpl();
		EventssInfo info=eventssBL.searchEventssByPK(eventId);	
		cond.setEventid(eventId);
		dto.setScopesInfoList(scopesBL.searchScopes(cond));		
		dto.setEventssInfo(info);
		log.debug("============取得事件一条数据结束=============");
		return dto;
	}
	
	/**
     * @Description: 更新事件一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO updateEventssAction(IGDRM16DTO dto) throws BLException {
		log.debug("============更新事件信息开始=============");		
		IGDRM1603Form form =dto.getIgdrm1603Form();
		// 创建事件实体赋值
		EventssTB entity = new EventssTB();
		entity.setEventid(form.getUpEventid());
		entity.setEventname(form.getUpEventname());
		entity.setLabels(form.getUpLabels());
		entity.setEventdes(form.getUpEventdes());
		eventssBL.updateEventss(entity);
		log.debug("============更改事件信息结束=============");
		return dto;
	}
	
	 /**
     * @Description: 事件影响范围条目登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO editScopeAction(IGDRM16DTO dto)throws BLException{
    	   log.debug("===========事件影响范围条目修改/登记开始===============");
   	    IGDRM1604Form form = dto.getIgdrm1604Form();
   	    
   	    //更新主表
   	    EventssInfo eveInfo = eventssBL.searchEventssByPK(form.getUpEventid());
   	    EventssTB neve = (EventssTB)SerializationUtils.clone(eveInfo);
		neve.setEventdes(form.getEventDes());
   	    neve.setEventname(form.getEventName());
   	    neve.setLabels(form.getLabels());
   	    eventssBL.updateEventss(neve);
   	    //更新从表
   	    ScopesSearchCondImpl cond= new ScopesSearchCondImpl();
   	    cond.setEventid(form.getUpEventid());
	    List<ScopesInfo> list = scopesBL.searchScopes(cond);
	    Map<String,ScopesTB> map = new HashMap<String, ScopesTB>();
	    if(list!=null&&list.size()>0){
	        for(ScopesInfo info:list){
	        	ScopesTB tb = (ScopesTB)SerializationUtils.clone(info);
	            map.put(tb.getScopeid().toString(), tb);
	        }
	    }
   	    //取form集合
   	    String[] impscope=form.getImpscope();
   	    String[] impbus= form.getImpbus();
   	    String[] imptime = form.getImptime();
   	    for(int i=0;i<impscope.length-1;i++){
   	       ScopesTB tb=new ScopesTB();
   	      tb.setImpscope(impscope[i]);
//   	      tb.setImpbus(impbus[i]);
   	      tb.setImptime(imptime[i]);
   	      tb.setEventid(form.getUpEventid());
   	      scopesBL.registScopes(tb);    
   	    }
   	    //如果map里还有内容，则判断为删除的
   	    if(map.size()>0){
   	        for(Entry<String, ScopesTB> entry:map.entrySet()){
   	            scopesBL.deleteScopes(entry.getValue());
   	        }
   	    }
   	    log.debug("===========事件影响范围条目修改/登记结束===============");
    	return dto;
    }
    
    /**
     * @Description: 事件等级修改
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO updateEventssLabelsAction(IGDRM16DTO dto) throws BLException{
    	log.debug("============事件等级更新开始=============");
    	IGDRM1603Form form =dto.getIgdrm1603Form();
    	Integer olabels=form.getUpLabels();
    	Integer tolabel=0;
    	EventssInfo info=eventssBL.searchEventssByPK(form.getUpEventid());
    	String flag=form.getFlag();
    	//判断标签上升还是下降
    	if(flag.equals("true")){
    		tolabel=info.getLabels()-1;
    	}
    	else{
    		tolabel=info.getLabels()+1;
    	}   	
    	EventssSearchCondImpl cond=new EventssSearchCondImpl();
    	cond.setLabels(tolabel);
    	List<EventssInfo> InfoList=eventssBL.searchEventss(cond);
    	while(InfoList.size()>0){
    		EventssInfo einfo=InfoList.get(0);
    		EventssTB fromTb = (EventssTB) SerializationUtils.clone(info);
    		EventssTB toTb = (EventssTB) SerializationUtils.clone(einfo); 		
    		fromTb.setLabels(tolabel);
    		toTb.setLabels(olabels);
    		eventssBL.registEventss(fromTb);
        	eventssBL.registEventss(toTb);   
        	break;
    	}  	
    	log.debug("============事件等级更新结束=============");
    	return dto;
    }
    /**
     * @throws BLException 
     * @Description: 查询所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    
    public IGDRM16DTO getList(IGDRM16DTO dto) throws BLException{
    	log.debug("==============事件查询开始=====================");
    	//IGDRM1604Form form = dto.getIgdrm1604Form();   	    	
    	List<EventssInfo> eList=eventssBL.searchEventss();
    	Map<String,List<ScopesInfo>> eventssScopesMap = new LinkedHashMap<String, List<ScopesInfo>>();
    	 ScopesSearchCondImpl cond= new ScopesSearchCondImpl();
    	for(int i=0;i<eList.size();i++){  		
    		cond.setEventid(eList.get(i).getEventid());
    		List<ScopesInfo> scopesInfoList = scopesBL.searchScopes(cond);
    		eventssScopesMap.put(eList.get(i).getEventname()+"_"+eList.get(i).getEventid()+"_"+eList.get(i).getEventdes(), scopesInfoList);
    	}	
    	dto.setEventssScopesMap(eventssScopesMap);
		log.debug("==============事件查询结束=====================");	
		return dto;
 
    }
    /**
     * @throws BLException 
     * @Description: 获取事件等级最大值
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO searchMaxLabelsAction(IGDRM16DTO dto) throws BLException{
    	log.debug("==============取得事件当前最大级别开始=====================");	
    	EventssSearchCondImpl cond=new EventssSearchCondImpl();
    	Integer maxLabel=0;
    	List<EventssInfo> eList=eventssBL.searchEventss();
    	//判断表中是否有值
    	for(int i=0;i<eList.size()-1;i++){
           if(eList.get(i).getLabels()>maxLabel){
           maxLabel=eList.get(i).getLabels();
        		}
        	}   	
    	cond.setLabels(maxLabel);
    	List<EventssInfo> info= eventssBL.searchEventss(cond);
    	dto.setEventssInfoList(info);
    	log.debug("==============取得事件当前最大级别结束=====================");	
    	return dto;
    }

}
