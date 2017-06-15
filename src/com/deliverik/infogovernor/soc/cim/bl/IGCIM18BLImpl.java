package com.deliverik.infogovernor.soc.cim.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hyperic.hq.hqapi1.HQApi;
import org.hyperic.hq.hqapi1.types.Resource;
import org.hyperic.hq.hqapi1.types.ResourceResponse;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.CicollecttaskBL;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.infogovernor.soc.alarm.model.entity.HQServerTB;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM18DTO;
import com.deliverik.infogovernor.util.HQUtil;

public class IGCIM18BLImpl extends BaseBLImpl implements IGCIM18BL{
	
	HQApi hqapi;
	protected CicollecttaskBL cicollecttaskBL;

	/**
	 * init
	 * 
	 */
	public void init() throws Exception {
		CodeListUtils codeListUtils = this.getCodeListUtils();
		hqapi = HQUtil.getHQApi(codeListUtils);
	}

	/**
	 * get CodeList Utils
	 * 
	 * @return
	 * @throws Exception
	 */
	private CodeListUtils getCodeListUtils() throws Exception {
		CodeListUtils codeListUtils = (CodeListUtils) WebApplicationSupport
				.getBean("codeListUtils");
		return codeListUtils;
	}
	
	public void setCicollecttaskBL(CicollecttaskBL cicollecttaskBL) {
		this.cicollecttaskBL = cicollecttaskBL;
	}


	public IGCIM18DTO getCIHQServerList(IGCIM18DTO dto)throws Exception {

		synchronized(this){
			init();
			List<HQServerTB> hqServerTBList = null;
			List<String> plateformNameList = cicollecttaskBL.getHQPlateformNameList();
			Map<String, ResourceResponse> plateformMap = HQUtil.getHQPlateformsMap(plateformNameList, hqapi);
			String serverStatus = dto.getIgcim0808Form().getServerstatus();
			String pluginName = dto.getIgcim0808Form().getPluginNmae();
			if (plateformMap == null || plateformMap.size() == 0) {
				return dto;
			}
			hqServerTBList = new ArrayList<HQServerTB>();
			for(Entry<String, ResourceResponse> entry : plateformMap.entrySet()){
				ResourceResponse plateform = entry.getValue();
				List<Resource> hqServerList = HQUtil.getHQServerListByPlateform(plateform);
				
				for (Resource server : hqServerList) {
					HQServerTB servertb = HQUtil.getMetricStatusByName(server, hqapi, null);
					if(servertb != null){
						servertb.setServerName(server.getName());
						servertb.setPluginName(server.getResourcePrototype().getName());
						servertb.setPlantformName(entry.getKey());
						servertb.setDesc(server.getDescription());
						if(serverStatus!=null && "1".equals(serverStatus) 
								&& servertb.isEnable() 
								&& (pluginName.equals(servertb.getPluginName()) || pluginName.equals("All"))){
							hqServerTBList.add(servertb);
						}else if(serverStatus!=null && "2".equals(serverStatus) 
								&& !servertb.isEnable() 
								&& (pluginName.equals(servertb.getPluginName()) || pluginName.equals("All"))){
							hqServerTBList.add(servertb);
						}else if(serverStatus == null || "0".equals(serverStatus) 
								&& (pluginName.equals(servertb.getPluginName()) || pluginName.equals("All"))){
							hqServerTBList.add(servertb);
						}
					}
				}
			}
			dto.setHqServerTBList(hqServerTBList);
		}
		return dto;
	}
	public IGCIM18DTO startServer(IGCIM18DTO dto) throws Exception {
		
		synchronized(this){
			init();
			String[] eitids = dto.getIgcim0808Form().getEitids();
			Map<String,String> serverNameMap = this.getServerNameMap(eitids);

			List<HQServerTB> hqServerTBList = null;
			List<String> plateformNameList = cicollecttaskBL.getHQPlateformNameList();
			Map<String, ResourceResponse> plateformMap = HQUtil.getHQPlateformsMap(plateformNameList, hqapi);
			
			if (plateformMap == null || plateformMap.size() == 0) {
				return dto;
			}
			
			hqServerTBList = new ArrayList<HQServerTB>();
			for(Entry<String, ResourceResponse> entry : plateformMap.entrySet()){
				ResourceResponse plateform = entry.getValue();
				List<Resource> hqServerList = HQUtil.getHQServerListByPlateform(plateform);

				for (Resource server : hqServerList) {

					if(serverNameMap.containsKey(server.getName())){
						HQUtil.closeMetric(server, hqapi);
						HQUtil.openMetric(server, hqapi);
					}

					HQServerTB servertb = HQUtil.getMetricStatusByName(server, hqapi, null);
					if(servertb != null){
						servertb.setServerName(server.getName());
						servertb.setPluginName(server.getResourcePrototype().getName());
						servertb.setPlantformName(entry.getKey());
						servertb.setDesc(server.getDescription());
						hqServerTBList.add(servertb);
					}
				}
			}
			dto.setHqServerTBList(hqServerTBList);
		}
		return dto;
	}

	public IGCIM18DTO stopServer(IGCIM18DTO dto) throws Exception {

		synchronized(this){
			init();
			String[] eitids = dto.getIgcim0808Form().getEitids();
			Map<String,String> serverNameMap = this.getServerNameMap(eitids);

			List<HQServerTB> hqServerTBList = null;
			List<String> plateformNameList = cicollecttaskBL.getHQPlateformNameList();
			Map<String, ResourceResponse> plateformMap = HQUtil.getHQPlateformsMap(plateformNameList, hqapi);

			if (plateformMap == null || plateformMap.size() == 0) {
				return dto;
			}
			
			hqServerTBList = new ArrayList<HQServerTB>();
			for(Entry<String, ResourceResponse> entry : plateformMap.entrySet()){
				ResourceResponse plateform = entry.getValue();
				List<Resource> hqServerList = HQUtil.getHQServerListByPlateform(plateform);

				for (Resource server : hqServerList) {
					
					if(serverNameMap.containsKey(server.getName())){
						HQUtil.closeMetric(server, hqapi);
					}
					HQServerTB servertb = HQUtil.getMetricStatusByName(server, hqapi, null);
					if(servertb != null){
						servertb.setServerName(server.getName());
						servertb.setPluginName(server.getResourcePrototype().getName());
						servertb.setPlantformName(entry.getKey());
						servertb.setDesc(server.getDescription());
						hqServerTBList.add(servertb);
					}
				}
			}
			dto.setHqServerTBList(hqServerTBList);
		}
		return dto;
		
	}
	
	public IGCIM18DTO searchServer(IGCIM18DTO dto) throws Exception {
		synchronized(this){

			List<HQServerTB> sl = null;
			String einame = dto.getIgcim0808Form().getEiname();
			dto = this.getCIHQServerList(dto);

			if(einame != null && !"".equals(einame)){
				sl = new ArrayList<HQServerTB>();
				List<HQServerTB> serverList = dto.getHqServerTBList();
				for(HQServerTB server : serverList){
					server.getStatusNum();
					if(server.getServerName().contains(einame)){
//						if(serverStatus!=null && "1".equals(serverStatus) && server.isEnable()){
//							sl.add(server);
//						}else if(serverStatus!=null && "2".equals(serverStatus) && !server.isEnable()){
//							sl.add(server);
//						}else if(serverStatus == null && "0".equals(serverStatus) && !server.isEnable()){
//							sl.add(server);
//						}
						sl.add(server);
					}
				}
				dto.setHqServerTBList(sl);
			}
		}
		return dto;
	}
	
	private Map<String, String> getServerNameMap(String[] eitids){
		Map<String,String> serverNameMap = new HashMap<String,String>();
		for(String name : eitids){
			serverNameMap.put(name, name);
		}
		return serverNameMap;
	}

}
