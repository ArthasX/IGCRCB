package com.deliverik.infogovernor.soc.cim.bl;

import java.util.ArrayList;
import java.util.List;

import main.java.com.dlk.hq.Metric;
import main.java.com.dlk.hq.Server;
import main.java.com.dlk.hq.XmlTemplate;
import main.java.com.dlk.hq.XmlTemplateImpl;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.CicollecttaskBL;
import com.deliverik.framework.soc.asset.bl.task.Timer01BL;
import com.deliverik.framework.soc.asset.bl.task.Timer02BL;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.Timer01Info;
import com.deliverik.framework.soc.asset.model.Timer02Info;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.Timer01SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.Timer02SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.Timer01TB;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.broker.collect.CollectJobProxy;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM13DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0805Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0806Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0807Form;
import com.deliverik.infogovernor.util.HQUtil;

/**
 * CI定时采集配置BL
 * 
 * @author 王省
 * 
 */
public class IGCIM13BLImpl extends BaseBLImpl implements IGCIM13BL {

	protected Timer01BL timer01BL;

	protected Timer02BL timer02BL;

	private static Log log = LogFactory.getLog(IGCIM13BLImpl.class);

	protected CicollecttaskBL cicollecttaskBL;

	public void setCicollecttaskBL(CicollecttaskBL cicollecttaskBL) {
		this.cicollecttaskBL = cicollecttaskBL;
	}

	public void setTimer01BL(Timer01BL timer01BL) {
		this.timer01BL = timer01BL;
	}

	public void setTimer02BL(Timer02BL timer02BL) {
		this.timer02BL = timer02BL;
	}

	/**
	 * CI采集定时任务查询处理
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGCIM13DTO getCICollectTimerTaskList(IGCIM13DTO dto) {

		List<CicollecttaskInfo> cicollecttaskList = null;
		List<String> typeNames = new ArrayList<String>();

		IGCIM0805Form form = dto.getIgcim0805Form();
		CicollecttaskSearchCondImpl cond = new CicollecttaskSearchCondImpl();
		String typeName = form.getTypename();
		if (StringUtils.isEmpty(typeName)) {
			List<Server> serverTypeList = getServerList();
			for (Server server : serverTypeList) {
				typeNames.add(server.getType());
			}
		} else
			typeNames.add(typeName);
		List<Integer> ids = cicollecttaskBL.getTypeIdByName(typeNames);
		cond.setTypeIds(ids);
		cond.setExecutstatus(form.getExecutstatus());
		cond.setNewstarttime(form.getNewstarttime());

		PagingDTO pDto = dto.getPagingDto();

		cicollecttaskList = cicollecttaskBL.searchCicollecttask(cond, pDto
				.getFromCount(), pDto.getPageDispCount());

		dto.setTimerTaskList(cicollecttaskList);
		
		int totalCount = cicollecttaskBL.getSearchCount(cond);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		
		pDto.setTotalCount(totalCount);
		
		return dto;
	}

	public IGCIM13DTO getHistoryTaskListByType(IGCIM13DTO dto) {

		String uuid = dto.getUuid();
		IGCIM0807Form form = dto.getIgcim0807Form();

		Timer02SearchCondImpl cond = new Timer02SearchCondImpl();
		cond.setUuid(uuid);
		cond.setCollectdate(form.getCollectdate());
		cond.setExecutstatus(form.getExecutstatus());

		int totalCount = timer02BL.getSearchCount(cond);
		PagingDTO pDto = dto.getPagingDto();
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========导入对象信息查询数据件数过多========");
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		List<Timer02Info> list = timer02BL.searchTimer02(cond, pDto
				.getFromCount(), pDto.getPageDispCount());
		dto.setHistoryList(list);
		pDto.setTotalCount(totalCount);
		
		return dto;
	}

	public List<String> getRealtimeTypeNames() {
		List<Server> serverTypeList = getServerList();
		List<String> typeNames = new ArrayList<String>();
		for (Server server : serverTypeList) {
			typeNames.add(server.getType());
		}
		return typeNames;
	}
	

	/**
	 * 数据同步逻辑：
	 * 
	 * 1>Timer01采集任务表与xml配置文件进行同步：
	 * 		1.1> 对于xml新增的servertype，timer01表要同步添加该type的server;
	 * 		1.2> 对于xml已经删除的servertype，若timer01表该type下的server已设置采集规则，则置为停用状态，若没设置过则直接删除;
	 * 
	 * 2>Timer01采集任务表与eam_server表进行同步：
	 * 		2.1> 对于eam_server表中已不存在的server，若timer01表该server已设置采集规则，则置为停用状态，若没设置过则直接删除;
	 * 		2.2> 对于eam_server表中新增的server，若该server的servertype在xml中已设置，则Timer01表要添加相应的server（但并不启动采集）
	 */
	public String init() throws Exception {

		/**
		 * 级联查询，获取最新的数据
		 */
		List<CicollecttaskInfo> cicollecttaskList = null;
		List<Server> serverTypeList = getServerList();
		if(serverTypeList == null || serverTypeList.size() == 0){
			return "no";
		}
		List<String> xmlTypeNames = new ArrayList<String>();
		for (Server server : serverTypeList) {
			xmlTypeNames.add(server.getType());
		}
		List<Integer> xmlids = cicollecttaskBL.getTypeIdByName(xmlTypeNames);
		if(xmlids == null || xmlids.size() == 0){
			return "yes";
		}
		CicollecttaskSearchCondImpl cond = new CicollecttaskSearchCondImpl();
		cond.setTypeIds(xmlids);
		cicollecttaskList = cicollecttaskBL.searchCicollecttask(cond);
		
		
		/**
		 * step1.1 对于xml新增的servertype，timer01表要同步添加该type的server;
		 */
		Timer01SearchCondImpl timer01Cond = new Timer01SearchCondImpl();
		List<String> temp = null;
		index:
		for(Server server:serverTypeList){
			String typename = server.getType();
			if(StringUtils.isEmpty(typename))	continue index;
			temp = new ArrayList<String>();
			temp.add(typename);
			timer01Cond.setTypeNames_In(temp);
			List<Timer01Info> infos = timer01BL.searchTimer01(timer01Cond);
			if(infos == null || infos.size() == 0){
				List<Integer> typeids = cicollecttaskBL.getTypeIdByName(temp);
				if(typeids.size() == 0) continue index;
				List<Integer> resourceids = cicollecttaskBL.getResourceIdByType(typeids);
				for(Integer resouceid:resourceids){
					String servername = "";
					for(CicollecttaskInfo info:cicollecttaskList){
						if(resouceid.equals(info.getResourceid())){
							servername = info.getServername();
						}
					}
					Timer01TB bean = new Timer01TB();
					bean.setUuid(server.getUuid()+"_"+resouceid);
					bean.setName(servername);
					bean.setTypename(typename);
					bean.setResourceid(resouceid);
					bean.setCollecttype("0");
					bean.setExecutstatus("2");
					
					timer01BL.registTimer01(bean);
				}
			}
		}
		
		/**
		 * step1.2 对于xml已经删除的servertype，timer01表要相应的将该type下的server置为停用状态;
		 */
		timer01Cond = new Timer01SearchCondImpl();
		timer01Cond.setTypeNames_Notin(xmlTypeNames);
		List<Timer01Info> timer01List = timer01BL.searchTimer01(timer01Cond);
		for (Timer01Info info : timer01List) {
			Timer01TB bean = stopOrDeleteServer(info);
			CollectJobProxy proxy = CollectJobProxy.getInstance();
			proxy.removeCollectJob(bean);// 去掉相应的采集任务
		}

		
		/**
		 * step2.1 对于eam_server表中已不存在的server，Timer01表中若存在该数据则置为停用状态;
		 */
		List<Integer> realTimeDatas = new ArrayList<Integer>();
		for (CicollecttaskInfo info : cicollecttaskList) {
			realTimeDatas.add(info.getResourceid());
		}
		timer01Cond = new Timer01SearchCondImpl();
		timer01Cond.setResourceid_Notin(realTimeDatas);
		List<Timer01Info> list = timer01BL.searchTimer01(timer01Cond);
		for(Timer01Info info:list){
			stopOrDeleteServer(info);
		}
		
		/**
		 * step2.2 对于eam_server表中新增的server，若该server的servertype在xml中已设置，则Timer01表要添加相应的server（但并不启动采集）
		 */
		timer01Cond = new Timer01SearchCondImpl();
		List<Timer01Info> results = timer01BL.searchTimer01(timer01Cond);//timer01表里所有数据
		for (CicollecttaskInfo info : cicollecttaskList) {
			boolean flag = false;
			for (int i = 0; i < results.size(); i++) {
				if(info.getResourceid().equals(results.get(i).getResourceid())){
					flag = true;
					break;
				}
			}
			if(flag == false){
				Server server = null;
				for(Server buff:serverTypeList){
					if(buff.getType().equalsIgnoreCase(info.getTypename())){
						server = buff;
						break;
					}
				}
				Timer01TB bean = new Timer01TB();
				bean.setUuid(server.getUuid()+"_"+info.getResourceid());
				bean.setName(info.getServername());
				bean.setTypename(info.getTypename());
				bean.setResourceid(info.getResourceid());
				bean.setCollecttype("0");
				bean.setExecutstatus("2");
				timer01BL.registTimer01(bean);
			}
		}
		return "yes";
	}
	
	private Timer01TB stopOrDeleteServer(Timer01Info info) throws BLException{
		Timer01TB bean = (Timer01TB) SerializationUtils.clone(info);
		if(StringUtils.isNotEmpty(bean.getStartrule()) || StringUtils.isNotEmpty(bean.getStoprule())){
			bean.setExecutstatus("2");// 停用状态
			timer01BL.updateTimer01(bean);
		}else{
			timer01BL.deleteTimer01(bean);
		}
		return bean;
	}
	
	private String getMetricNameStr(Server server){
	if(server.getMetricList()==null){
			return null;
		}
		List<Metric>  mlist = server.getMetricList().get(0).getMetric();
		StringBuilder metricNamesStr = new StringBuilder();
		for(int i=0;i<mlist.size();i++){
			metricNamesStr.append(mlist.get(i).getName());
			if(i < mlist.size()-1) metricNamesStr.append(",");
		}
		return metricNamesStr.toString();
	}
	
	
	/**
	 * 修改定时任务
	 * @param igcim0805Form
	 * @return
	 */
	public String editCollect(IGCIM0806Form igcim0806Form) {
		
		String message = "SUCCESS";
		
		try {

			List<Server> serverTypeList = getServerList();

			if(serverTypeList == null){
				log.info("xml模版中没有配置需要采集的server");
				return "error";
			}

			Server server = null;
			
			for(Server sbuff:serverTypeList){
				if(sbuff.getType().equals(igcim0806Form.getTypename())){
					server = sbuff;
					break;
				}
			}

			if(server==null){
				log.info("xml模版中没有配置需要采集的server");
				return "error";
			}

			String metricNames = this.getMetricNameStr(server);

			if(metricNames ==null || "".equals(metricNames)){
				log.info("xml模版中server没有配置采集指标");
				return "error";
			}
			
			String stoprule = "";
			CollectJobProxy proxy = CollectJobProxy.getInstance();
			
			
			if(igcim0806Form.getStoptime()!=null && !"".equals(igcim0806Form.getStoptime())){
				
				stoprule = HQUtil.creatCronExp(igcim0806Form.getPeriodtype(),
						igcim0806Form.getStophour(), igcim0806Form.getStopminute(),
						igcim0806Form.getStoptime());
			}
			
			String startrule = HQUtil.creatCronExp(igcim0806Form.getPeriodtype(),
					igcim0806Form.getStarthour(), igcim0806Form.getStartminute(),
					igcim0806Form.getStarttime());

			Timer01TB timer01Info = new Timer01TB();
			timer01Info.setCollecttype("0");
			timer01Info.setUuid(igcim0806Form.getUuid());
			timer01Info.setTypename(igcim0806Form.getTypename());
			timer01Info.setExecutstatus(igcim0806Form.getExecutstatus());
			timer01Info.setName(igcim0806Form.getName());
			timer01Info.setPeriodtype(igcim0806Form.getPeriodtype());
			timer01Info.setStartrule(startrule);
			timer01Info.setStoprule(stoprule);
			timer01Info.setTypename(igcim0806Form.getTypename());
			timer01Info.setNewstarttime(igcim0806Form.getNewstarttime());
			timer01Info.setNewstoptime(igcim0806Form.getNewstoptime());
			timer01Info.setStarttime(igcim0806Form.getStarttime()+" "+igcim0806Form.getStarthour()+":"+igcim0806Form.getStartminute());
			
			if(igcim0806Form.getStophour() != null && !"".equals(igcim0806Form.getStophour())){
				timer01Info.setStoptime(igcim0806Form.getStoptime()+" "+igcim0806Form.getStophour()+":"+igcim0806Form.getStopminute());
				
			}
			
			timer01Info.setResourceid(igcim0806Form.getResourceId());
			timer01Info.setFingerPrint(metricNames);
			
			if("2".equals(igcim0806Form.getExecutstatus())){
				proxy.removeCollectJob(timer01Info);
			}else if("1".equals(igcim0806Form.getExecutstatus())){
				proxy.addCollectJob(timer01Info);
			}

			timer01BL.updateTimer01(timer01Info);
		} catch (Exception e) {
			message = "添加定时任务失败";
			e.printStackTrace();
		}
		return message;
	}
	
	/**
	 * 通过xml获取需要定时采集的server类型
	 * 
	 * @return
	 */
	protected List<Server> getServerList() {
		List<Server> servers = null;
		XmlTemplate template = new XmlTemplateImpl();
		try {
			servers = template.getServerListByTemplatePath(ResourceUtility
					.getString("CI_COLLECT_TYPE_PATH"));
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("获取XmlTemplate失败");
		}
		return servers;
	}

	public List<CicollecttaskInfo> findAllByCollectType(String collectType)
			throws Exception {
		CicollecttaskSearchCondImpl cond = new CicollecttaskSearchCondImpl();
		cond.setCollectType(collectType);
		return cicollecttaskBL.searchCicollecttask(cond);
	}

	public List<Integer> findResourceidByType(int type) throws Exception {
		return cicollecttaskBL.findResourceidByType(type);
	}

	public Timer01Info getTimer01ByUuid(String uuid) throws Exception {
		Timer01Info timer01Info = timer01BL.searchTimer01ByPK(uuid);
		return timer01Info;
	}
	
	public void updateTimer01(Timer01Info timer01) throws Exception {
		timer01BL.updateTimer01(timer01);
	}

	public void addTimer02(Timer02Info instance)throws Exception {
		timer02BL.registTimer02(instance);
	}
	
}
