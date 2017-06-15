/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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

	/** �¼�BL */
	private EventssBL eventssBL;
	
	/** �¼�Ӱ�췶ΧBL */
	private ScopesBL scopesBL; 

	/**
	 * eventssBL�趨
	 * 
	 * @param eventssBL
	 */
	public void setEventssBL(EventssBL eventssBL) {
		this.eventssBL = eventssBL;
	}
	/**
	 * eventssBLȡ��
	 * 
	 * @param eventssBL
	 */

	public EventssBL getEventssBL() {
		return eventssBL;
	}

	/**
	 * scopesBLȡ��
	 * 
	 * @param scopesBL
	 */

	public ScopesBL getScopesBL() {
		return scopesBL;
	}
	
	/**
	 * scopesBL�趨
	 * 
	 * @param scopesBL
	 */
	public void setScopesBL(ScopesBL scopesBL) {
		this.scopesBL = scopesBL;
	}
	
	/**
     * @Description: ��ѯ�¼���������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO getEventssList(IGDRM16DTO dto) {
		
		log.debug("==============�¼���ѯ��ʼ=====================");
		//ȡ��form
		IGDRM1602Form form = dto.getIgdrm1602Form();
		//ȡ�ò�ѯ����
		EventssSearchCondImpl cond = new EventssSearchCondImpl();
	    cond.setEventssname(form.getSeventName());
//	    cond.setLabels(form.getLabels());	
	    cond.setEventDes(form.getSeventDes());
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//ȡ������
		int totalCount=eventssBL.getSearchCount(cond);
		//��֤��ѯ�������Ƿ���������s
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��֤��ѯ�������Ƿ���������e
		pDto.setTotalCount(totalCount);
		cond.setOrder("asc");
		cond.setOrderBy("eventid");
		dto.setEventssInfoList( eventssBL.searchEventss(cond,pDto.getFromCount(),pDto.getPageDispCount()));
		log.debug("==============�¼���ѯ����=====================");	
		return dto;
	}
	/**
     * @Description: ɾ���¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO deleteEventssAction(IGDRM16DTO dto) throws BLException {
        log.debug("============�¼���Ϣɾ����ʼ=============");
		EventssInfo info=eventssBL.searchEventssByPK(dto.getIgdrm1602Form().getEventId());
		if(info!=null){
			eventssBL.deleteEventssByPK(dto.getIgdrm1602Form().getEventId());
		}else{
			dto.addMessage(new ActionMessage("IGASM4202.E002"));
		}
		log.debug("============�¼���Ϣɾ������=============");
		return dto;
	}
	
	/**
     * @Description: ����¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO insertEventssAction(IGDRM16DTO dto) throws BLException {
		log.debug("============�¼�����������Ϣ��ʼ=============");
		//ȡ��form
		IGDRM1601Form form = dto.getIgdrm1601Form();
		//�����¼�ʵ�帳ֵ
		EventssTB entity= new EventssTB();
		entity.setEventname(form.getEventName());
		entity.setLabels(form.getLabels());
		entity.setEventdes(form.getEventDes());
		EventssInfo eveInfo = eventssBL.registEventss(entity);
		// Integer[] scopeids = form.getScopeid();
		//����ӱ���Ϣ
		for (int i = 0; i < form.getImpscope().length - 1; i++) {
			ScopesTB scope = new ScopesTB();
			scope.setEventid(eveInfo.getEventid());
//			scope.setImpbus(form.getImpbus()[i]);
			scope.setImpscope(form.getImpscope()[i]);
			scope.setImptime(form.getImptime()[i]);
//			scope.setScopeid(form.getScopeid()[i]);
			scopesBL.registScopes(scope);
		}
		
		
		log.debug("============�¼�����������Ϣ����=============");
		return dto;
	}
	
	/**
     * @Description:  ͨ��������ѯ�¼�һ�����ݳ�ʼ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */
	public IGDRM16DTO searchEventssByPK(IGDRM16DTO dto) throws BLException {
		log.debug("============ȡ���¼�һ�����ݿ�ʼ=============");
		IGDRM1604Form form=dto.getIgdrm1604Form();
		Integer eventId = (form==null?dto.getIgdrm1603Form().getUpEventid():form.getUpEventid());
		ScopesSearchCondImpl cond = new ScopesSearchCondImpl();
		EventssInfo info=eventssBL.searchEventssByPK(eventId);	
		cond.setEventid(eventId);
		dto.setScopesInfoList(scopesBL.searchScopes(cond));		
		dto.setEventssInfo(info);
		log.debug("============ȡ���¼�һ�����ݽ���=============");
		return dto;
	}
	
	/**
     * @Description: �����¼�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM16DTO    
     * @throws
     */

	public IGDRM16DTO updateEventssAction(IGDRM16DTO dto) throws BLException {
		log.debug("============�����¼���Ϣ��ʼ=============");		
		IGDRM1603Form form =dto.getIgdrm1603Form();
		// �����¼�ʵ�帳ֵ
		EventssTB entity = new EventssTB();
		entity.setEventid(form.getUpEventid());
		entity.setEventname(form.getUpEventname());
		entity.setLabels(form.getUpLabels());
		entity.setEventdes(form.getUpEventdes());
		eventssBL.updateEventss(entity);
		log.debug("============�����¼���Ϣ����=============");
		return dto;
	}
	
	 /**
     * @Description: �¼�Ӱ�췶Χ��Ŀ�Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO editScopeAction(IGDRM16DTO dto)throws BLException{
    	   log.debug("===========�¼�Ӱ�췶Χ��Ŀ�޸�/�Ǽǿ�ʼ===============");
   	    IGDRM1604Form form = dto.getIgdrm1604Form();
   	    
   	    //��������
   	    EventssInfo eveInfo = eventssBL.searchEventssByPK(form.getUpEventid());
   	    EventssTB neve = (EventssTB)SerializationUtils.clone(eveInfo);
		neve.setEventdes(form.getEventDes());
   	    neve.setEventname(form.getEventName());
   	    neve.setLabels(form.getLabels());
   	    eventssBL.updateEventss(neve);
   	    //���´ӱ�
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
   	    //ȡform����
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
   	    //���map�ﻹ�����ݣ����ж�Ϊɾ����
   	    if(map.size()>0){
   	        for(Entry<String, ScopesTB> entry:map.entrySet()){
   	            scopesBL.deleteScopes(entry.getValue());
   	        }
   	    }
   	    log.debug("===========�¼�Ӱ�췶Χ��Ŀ�޸�/�Ǽǽ���===============");
    	return dto;
    }
    
    /**
     * @Description: �¼��ȼ��޸�
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO updateEventssLabelsAction(IGDRM16DTO dto) throws BLException{
    	log.debug("============�¼��ȼ����¿�ʼ=============");
    	IGDRM1603Form form =dto.getIgdrm1603Form();
    	Integer olabels=form.getUpLabels();
    	Integer tolabel=0;
    	EventssInfo info=eventssBL.searchEventssByPK(form.getUpEventid());
    	String flag=form.getFlag();
    	//�жϱ�ǩ���������½�
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
    	log.debug("============�¼��ȼ����½���=============");
    	return dto;
    }
    /**
     * @throws BLException 
     * @Description: ��ѯ��������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    
    public IGDRM16DTO getList(IGDRM16DTO dto) throws BLException{
    	log.debug("==============�¼���ѯ��ʼ=====================");
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
		log.debug("==============�¼���ѯ����=====================");	
		return dto;
 
    }
    /**
     * @throws BLException 
     * @Description: ��ȡ�¼��ȼ����ֵ
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
    public IGDRM16DTO searchMaxLabelsAction(IGDRM16DTO dto) throws BLException{
    	log.debug("==============ȡ���¼���ǰ��󼶱�ʼ=====================");	
    	EventssSearchCondImpl cond=new EventssSearchCondImpl();
    	Integer maxLabel=0;
    	List<EventssInfo> eList=eventssBL.searchEventss();
    	//�жϱ����Ƿ���ֵ
    	for(int i=0;i<eList.size()-1;i++){
           if(eList.get(i).getLabels()>maxLabel){
           maxLabel=eList.get(i).getLabels();
        		}
        	}   	
    	cond.setLabels(maxLabel);
    	List<EventssInfo> info= eventssBL.searchEventss(cond);
    	dto.setEventssInfoList(info);
    	log.debug("==============ȡ���¼���ǰ��󼶱����=====================");	
    	return dto;
    }

}
