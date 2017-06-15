package com.deliverik.infogovernor.rdp.bl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0123Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.ram.bl.IGRAM01BLImpl;
import com.deliverik.infogovernor.rdp.bl.task.AutoTaskBL;
import com.deliverik.infogovernor.rdp.bl.task.ExcuteResultBL;
import com.deliverik.infogovernor.rdp.bl.task.RealtimedetailBL;
import com.deliverik.infogovernor.rdp.dto.IGRDP01DTO;
import com.deliverik.infogovernor.rdp.form.IGRDP0101Form;
import com.deliverik.infogovernor.rdp.form.IGRDP0102Form;
import com.deliverik.infogovernor.rdp.model.AutoTaskInfo;
import com.deliverik.infogovernor.rdp.model.ExcuteResultInfo;
import com.deliverik.infogovernor.rdp.model.RealtimedetailInfo;
import com.deliverik.infogovernor.rdp.model.condition.AutoTaskSearchCondImpl;
import com.deliverik.infogovernor.rdp.model.condition.ExcuteResultSearchCondImpl;
import com.deliverik.infogovernor.rdp.model.condition.RealtimedetailSearchCondImpl;
import com.deliverik.infogovernor.rdp.model.entity.AutoTaskTB;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultPK;
import com.deliverik.infogovernor.rdp.model.entity.ExcuteResultTB;
import com.google.gson.Gson;

public class IGRDP01BLImpl extends BaseBLImpl implements IGRDP01BL {
	
	static Log log = LogFactory.getLog(IGRDP01BLImpl.class);

	//远程部署任务TaskBL
	protected AutoTaskBL autoTaskBL;
	
	//执行结果TaskBL
	protected ExcuteResultBL excuteResultBL;
	
	//资产实体TaskBL
	protected SOC0118BL soc0118BL;
	
	//资产模型TaskBL
	protected SOC0117BL soc0117BL;
	
	//资产关系TaskBL
	protected SOC0119BL soc0119BL;
	
	protected SOC0107BL soc0107BL;
	
	private RealtimedetailBL realtimedetailBL;
	
	

	public void setRealtimedetailBL(RealtimedetailBL realtimedetailBL) {
		this.realtimedetailBL = realtimedetailBL;
	}

	public void setAutoTaskBL(AutoTaskBL autoTaskBL) {
		this.autoTaskBL = autoTaskBL;
	}

	public void setExcuteResultBL(ExcuteResultBL excuteResultBL) {
		this.excuteResultBL = excuteResultBL;
	}
	
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}

	/**
	 * 获取业务系统列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getBusinessSystems(IGRDP01DTO dto) throws BLException{
		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		cond.setEsyscoding("999003001");
		cond.setEcategory("003");
		List<SOC0124Info> bsms = soc0118BL.searchEntityItemVW(cond);
		dto.setBsms(bsms);
		
		return dto;
	}
	
	/**
	 * 通过业务系统eiid获取所属主机列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getHostsBySystemID(IGRDP01DTO dto) throws BLException {
		
		Integer eiid = dto.getBsmid();
		if(eiid == null) return dto;
		
		SOC0118Info entityItemInfo=soc0118BL.searchEntityItemByKey(eiid);
		//SOC0117Info entity=soc0117BL.searchEntityByKey(entityItemInfo.getEid());
		
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		parcond.setPareiid(eiid);
		parcond.setParversion(entityItemInfo.getEiversion());
		parcond.setParsmallversion(entityItemInfo.getEismallversion());
		parcond.setDeleteflag("0");
		List<SOC0119Info> parEntityItemRelationList = 
				this.soc0119BL.searchMaxEntityItemRelation(parcond);
		
		List<SOC0123Info> hosts = new ArrayList<SOC0123Info>();
		for(SOC0119Info relation:parEntityItemRelationList){
			SOC0123Info child = relation.getCldEntityItemVW();
			SOC0123VW cbean = (SOC0123VW)child; 
			SOC0117Info entity=soc0117BL.searchEntityByKey(child.getEid());
			SOC0129SearchCondImpl cond1 = new SOC0129SearchCondImpl();
			cond1.setEsyscoding_q(child.getEsyscoding());
			cond1.setEkey2(entity.getEkey2());
			cond1.setEiid(String.valueOf(child.getEiid()));
			
			//配置项配置信息全件查询
			List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
					cond1, 0, 0);
			for(SOC0129Info ci:configItemVWInfoList){
				if(ci.getCname().indexOf("IP") != -1){
					cbean.setEilabel(ci.getCivalue());
					break;
				}
			}
			hosts.add(cbean);
		}
		dto.setHosts(hosts);
		
		return dto;
	}
	
	/**
	 * 添加部署任务和结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO insertTaskAndResults(IGRDP01DTO dto) throws BLException {
		
		IGRDP0101Form form = dto.getIgrdp0101Form();
		String[] ips = form.getHostips();
		if(ips == null || ips.length == 0) return dto;
		
		StringBuilder hosts = new StringBuilder();
		for(int i = 0; i<ips.length; i++){
			hosts.append(ips[i]);
			if(i < ips.length - 1) hosts.append("#");
		}
		
		AutoTaskTB bean = new AutoTaskTB();
		bean.setTaskName(form.getTaskName().trim());
		bean.setHosts(hosts.toString());
		bean.setBusinessSystemid(Integer.parseInt(form.getBsmid()));
		bean.setExcutetime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
//		bean.setScriptPath(form.getScriptPath().trim());
		bean.setScriptParam(form.getScriptParam());
//		bean.setRdpFilePath(form.getRdpFilePath() == null?"":form.getRdpFilePath().trim());
		bean.setResultLogPath(form.getResultLogPath() == null?"":form.getResultLogPath().trim());
		bean.setCurrentFilePath(form.getCurrentFilePath().trim());
		bean.setState(0);
		bean.setScriptname(form.getScriptName());
		AutoTaskInfo currentTask = autoTaskBL.registAutoTask(bean);
		
		dto.setTaskID(currentTask.getId());
		
//		List<ExcuteResultInfo> results = new ArrayList<ExcuteResultInfo>();
		for(int i = 0; i<ips.length; i++){
			//每一台主机（IP）添加一条结果记录
			ExcuteResultTB result = new ExcuteResultTB();
			result.setTaskid(currentTask.getId());
			result.setHostid(ips[i]);
			result.setState(0);//未执行,等待中...
			ExcuteResultInfo info = excuteResultBL.registExcuteResult(result);
//			results.add(info);
		}
		
		return dto;
	}
	
	/**
	 * 查询升级任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchTasks(IGRDP01DTO dto) throws BLException {
		
		IGRDP0101Form form = dto.getIgrdp0101Form();
		AutoTaskSearchCondImpl cond = new AutoTaskSearchCondImpl();
		cond.setTaskName_like(form.getTaskName_like());
		if(StringUtils.isNotEmpty(form.getBsmid())){
			cond.setSystemid_eq(Integer.parseInt(form.getBsmid()));
		}
		cond.setTime_from(form.getTime_from());
		cond.setTime_to(form.getTime_to());
		
		int totalcount = autoTaskBL.getSearchCount(cond);
		PagingDTO pDto = dto.getPagingDto();
		List<AutoTaskInfo> tasks = autoTaskBL.searchAutoTask(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalcount);
		
		List<SOC0124Info> businessSystems = dto.getBsms();
		List<AutoTaskInfo> tasks_final = new ArrayList<AutoTaskInfo>();
		for(AutoTaskInfo info:tasks){
			AutoTaskTB bean = (AutoTaskTB) info;
			int bsmid = info.getBusinessSystemid();
			for(SOC0124Info bsm:businessSystems){
				if(bsm.getEiid() == bsmid){
					bean.setBsmname(bsm.getEiname());
					break;
				}
			}
			tasks_final.add(bean);
		}
		
		dto.setTasks(tasks_final);
		return dto;
	}
	
	/**
	 * 获取所有任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchAllTasks(IGRDP01DTO dto) throws BLException {
		List<AutoTaskInfo> tasks = autoTaskBL.searchAutoTask();
		dto.setTasks(tasks);
		return dto;
	}
	
	
	/**
	 * 远程部署升级
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO remoteDeploy(final IGRDP01DTO dto) throws BLException {
		
		final Integer taskID = dto.getTaskID();
		
		if(taskID == null) return dto;
		final AutoTaskInfo task = autoTaskBL.searchAutoTaskByPK(taskID);
		ExcuteResultSearchCondImpl cond = new ExcuteResultSearchCondImpl();
		cond.setTaskID_eq(taskID);
		final List<ExcuteResultInfo> results = excuteResultBL.searchExcuteResult(cond);
		
		//远程部署线程
		Thread deployThread = new Thread(){
			@Override
			public void run(){
				
				boolean isConnect = false;
				
				HttpURLConnection hc = null;
				InputStream input = null;
				AutoTaskTB taskBean = null;
				
				try {
					Map<String,ExcuteResultInfo> resultsMap = new HashMap<String,ExcuteResultInfo>();
					for(ExcuteResultInfo result:results){
						resultsMap.put(result.getHostid(), result);
					}
					
					
					//带路径的执行脚本名
					//String scriptFile = task.getScriptPath();
					
					//执行脚本的附加参数
					String scriptParam = task.getScriptParam() == null?"":task.getScriptParam();
					
					//获取要执行脚本的主机ID
					String hosts = task.getHosts();
					
					//远程升级文件部署路径
					//String rdpFilePath = task.getRdpFilePath();
					
					//结果日志路径
					String resultLogPath = task.getResultLogPath();

					//脚本名
					String scriptName = task.getScriptname();
					
					//当前升级文件和脚本的路径
					String rootPath = ResourceUtility.getString("IGCAM_SERVER_ROOTFILEPATH");
					if(StringUtils.isEmpty(rootPath)){
						if(scriptName.endsWith("bat")){
							rootPath = "C:\\public";
						}else if(scriptName.endsWith("sh")){
							rootPath = "/opt/public";
						}
					}
		    		char c1 = rootPath.charAt(rootPath.length()-1);
		    		if(c1 == '\\' || c1 == '/') {
		    			rootPath = rootPath.substring(0,rootPath.length()-1);
		    		}
		    		
		    		SOC0118Info bsmBean = soc0118BL.searchEntityItemByKey(task.getBusinessSystemid());
		    		
		    		String currentFilePath;
		    		if(rootPath.indexOf("\\") != -1){
		    			currentFilePath = rootPath + "\\" + bsmBean.getEiname() + "\\"+ task.getCurrentFilePath();
		    		}else currentFilePath = rootPath + "/" + bsmBean.getEiname() + "/"+ task.getCurrentFilePath();
		    		
		    		taskBean = (AutoTaskTB)task;
					
					String serverIP = ResourceUtility.getString("IGCAM_SERVER_IP");
					String serverPort = ResourceUtility.getString("IGCAM_SERVER_PORT");
					if(StringUtils.isEmpty(serverIP)){
						serverIP = "localhost";
					}
					if(StringUtils.isEmpty(serverPort)){
						serverPort = "7080";
					}
					
					String urlStr = "http://"+serverIP+":"+serverPort+"/excuteScript";
				
					urlStr = urlStr + "?scriptParam="+ URLEncoder.encode(scriptParam,"UTF-8");
					urlStr = urlStr + "&hostips="+ URLEncoder.encode(hosts.toString(),"UTF-8");
					urlStr = urlStr + "&resultLogPath="+ URLEncoder.encode(resultLogPath,"UTF-8");
					urlStr = urlStr + "&currentFilePath="+ URLEncoder.encode(currentFilePath,"UTF-8");
					urlStr = urlStr + "&scriptName="+ URLEncoder.encode(scriptName,"UTF-8");
					urlStr = urlStr + "&serverIP="+ URLEncoder.encode(serverIP,"UTF-8");
					urlStr = urlStr + "&serverPort="+ URLEncoder.encode(serverPort,"UTF-8");
					urlStr = urlStr + "&taskid="+ taskID;
					
					URL url = new URL(urlStr);
					hc = (HttpURLConnection) url.openConnection();
					hc.setUseCaches(false);
					hc.connect();
					input = hc.getInputStream();
					
					isConnect = true;

					BufferedReader reader  = new BufferedReader(new InputStreamReader(input));
					
					String resultStr ;
					ExcuteResultTB bean = null;
					
					
					taskBean.setExcutetime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
					AutoTaskInfo taskInfo = autoTaskBL.updateAutoTask(taskBean);
					
					//读取返回结果
					while((resultStr = reader.readLine()) != null){
						
						if(resultStr.startsWith("@error")){
							for(ExcuteResultInfo result:results){
								ExcuteResultTB rbean = (ExcuteResultTB)result;
								rbean.setState(3);//传输失败
								rbean.setRealtimedetail(resultStr.substring("@error".length() + 1));
								excuteResultBL.updateExcuteResult(rbean);
							}
							taskBean = (AutoTaskTB) taskInfo;
							taskBean.setState(1);//已执行
							taskInfo = autoTaskBL.updateAutoTask(taskBean);
							return;
						}
						
						String ip = "";
						if(resultStr.startsWith("ip>>>>")){
							ip = resultStr.substring(resultStr.indexOf("ip>>>>") + 6, resultStr.indexOf("<<<<ip")).trim();
							ExcuteResultInfo info = resultsMap.get(ip);
							bean = (ExcuteResultTB)info;
							bean.setState(1);//传输中...
							StringBuilder realtime = new StringBuilder();
							realtime.append("传输服务器").append(currentFilePath).append("文件夹到该主机...<br/>");
							
							bean.setRealtimedetail(realtime.toString());
							ExcuteResultInfo temp = excuteResultBL.updateExcuteResult(bean);
							bean = (ExcuteResultTB)temp;
						}
						
						if(resultStr.startsWith("host transResult>>>")){
							String result = 
									resultStr.substring(resultStr.indexOf("result>>") + 8, resultStr.indexOf("<<result")).trim();
	
							if("ok".equals(result)) {
								StringBuilder realtime = new StringBuilder();
								realtime.append("脚本").append(taskInfo.getScriptname()).append("执行中...");
								
								bean.setRealtimedetail(realtime.toString());
								bean.setState(2);//传输成功
							}else if("fail".equals(result)) {
								String detail = resultStr.substring(resultStr.indexOf("detail>>") + 8, resultStr.indexOf("<<detail"));
								bean.setState(3);//传输失败
								bean.setRealtimedetail(detail);
							}
							ExcuteResultInfo temp = excuteResultBL.updateExcuteResult(bean);
							bean = (ExcuteResultTB)temp;
							
						}else if(resultStr.startsWith("host excuteResult>>>")){
							String result = 
									resultStr.substring(resultStr.indexOf("result>>") + 8, resultStr.indexOf("<<result")).trim();
							if("success".equals(result)) {
								bean.setState(4);//执行成功
								String realtime = "脚本" + taskInfo.getScriptname() + "已执行";
								bean.setRealtimedetail(realtime);
							}
							else if("error".equals(result) || "fail".equals(result)) {
								bean.setState(5);//执行失败
							}
							
							String detail = resultStr.substring(resultStr.indexOf("detail>>") + 8, resultStr.indexOf("<<detail")).trim().replace("&&&", "\n");
							String scriptResultLog = ResourceUtility.getString("ScriptResultLog");
							if(StringUtils.isEmpty(scriptResultLog)) {
								if(scriptName.endsWith("bat") || scriptName.endsWith("exe")) scriptResultLog = "C:/ScriptResultLog";
								else if(scriptName.endsWith("sh")) scriptResultLog = "/ScriptResultLog";
							}
							File sdir = new File(scriptResultLog.trim());
							if(!sdir.exists()) sdir.mkdir();
							File sfile = new File(sdir.getPath() + "/" + taskID + "_" + bean.getHostid() + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log");
							PrintWriter sp = new PrintWriter(new FileWriter(sfile));
							sp.print(detail);
							sp.flush();
							sp.close();
							bean.setResult(sfile.getPath());
							
							if("error".equals(result) || "fail".equals(result)) {
								bean.setState(5);//执行失败
								bean.setRealtimedetail(detail);
							}
							
							String log = resultStr.substring(resultStr.indexOf("log>>") + 5, resultStr.indexOf("<<log")).trim().replace("&&&", "\n");
							
							String excuteResultLog = ResourceUtility.getString("ExcuteResultLog");
							if(StringUtils.isEmpty(excuteResultLog)) {
								if(scriptName.endsWith("bat") || scriptName.endsWith("exe")) excuteResultLog = "C:/ExcuteResultLog";
								else if(scriptName.endsWith("sh")) excuteResultLog = "/ExcuteResultLog";
							}
							File dir = new File(excuteResultLog.trim());
							if(!dir.exists()) dir.mkdir();
							File file = new File(dir.getPath() + "/" + taskID + "_" + bean.getHostid() + "_" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + ".log");
							PrintWriter p = new PrintWriter(new FileWriter(file));
							p.print(log);
							p.flush();
							p.close();
							
							bean.setResultDetail(file.getPath());
							excuteResultBL.updateExcuteResult(bean);
						}
					}
					
					taskBean = (AutoTaskTB) taskInfo;
					taskBean.setState(1);//已执行
					autoTaskBL.updateAutoTask(taskBean);
					
				} catch (Exception e) {
					log.error(e.getMessage());
					if(!isConnect){//如果没有能连接上IGCam SERVER
						try {
							for(ExcuteResultInfo result:results){
								ExcuteResultTB rbean = (ExcuteResultTB)result;
								rbean.setState(3);//传输失败
								rbean.setRealtimedetail("IGCam Server连接失败");
								excuteResultBL.updateExcuteResult(rbean);
							}
						}catch (Exception e1){
							log.error(e1.getMessage());
							e1.printStackTrace();
						}
					}
					
					if(taskBean != null){
						taskBean.setState(2);//已执行，但有异常
						try {
							autoTaskBL.updateAutoTask(taskBean);
						} catch (BLException e1) {
							log.error(e1.getMessage());
						}
					}

				} finally {
					try{
						if(input != null){
							input.close();
						}
						if(hc != null){
							hc.disconnect();
						}
					} catch(Exception e){
						log.error(e.getMessage());
						e.printStackTrace();
					}
				}
			}
		};
		
		deployThread.start();
		
		return dto;
	}
	
	
	/**
	 * 通过任务id获取任务结果
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO getExcuteResultByTaskID(IGRDP01DTO dto) throws BLException {
		
		IGRDP0102Form form = dto.getIgrdp0102Form();
		String taskid_eq = form.getTaskid_eq();
		
		ExcuteResultSearchCondImpl cond = new ExcuteResultSearchCondImpl();
		if(StringUtils.isNotEmpty(taskid_eq)){
			cond.setTaskID_eq(Integer.parseInt(taskid_eq));
		}
		
		int totalCount = excuteResultBL.getSearchCount(cond);
		PagingDTO pdto = dto.getPagingDto();
		List<ExcuteResultInfo> results = excuteResultBL.searchExcuteResult(cond,pdto.getFromCount(),pdto.getPageDispCount());
		pdto.setTotalCount(totalCount);
		dto.setResults(results);
		
		return dto;
	}
	
	/**
	 * 通过日志路径获取本地日志
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getLogByLogPath(IGRDP01DTO dto) throws BLException {
		
		String path = dto.getLogPath();
		StringBuilder log = new StringBuilder();
		if(StringUtils.isNotEmpty(path)) {
			BufferedReader reader = null;
			try {
				String[] vals = path.split("#");
				ExcuteResultInfo info = excuteResultBL.searchExcuteResultByPK(new ExcuteResultPK(vals[0], Integer.parseInt(vals[1])));
				String detail = null;
				if("resultLog".equals(dto.getLogFlag())){
					detail = info.getResultDetail();
				}else if("scriptLog".equals(dto.getLogFlag())){
					detail = info.getResult();
				}
				if(StringUtils.isNotEmpty(detail)){
					reader = new BufferedReader(new FileReader(detail));
					String str;
					while((str = reader.readLine()) != null){
						log.append(str).append("<br/>");
					}
				}
			} catch (Exception e) {
				log.append("读取日志异常：");
				log.append(e.getMessage());
			} finally{
				try {
					if(reader != null){
						reader.close();
					}
				} catch (IOException e) {
				}
			}
		} 
		dto.setLog(log.toString());
		return dto;
	}

	public IGRDP01DTO getExcuteResultByTaskIDByAjax(IGRDP01DTO dto) throws BLException {
		IGRDP0102Form form = dto.getIgrdp0102Form();
		String taskid_eq = form.getTaskid_eq();
		
		ExcuteResultSearchCondImpl cond = new ExcuteResultSearchCondImpl();
		if(StringUtils.isNotEmpty(taskid_eq)){
			cond.setTaskID_eq(Integer.parseInt(taskid_eq));
		}
		
		List<ExcuteResultInfo> results = excuteResultBL.searchExcuteResult(cond);
		
		StringBuilder resultStr = new StringBuilder();
		for(int i=0;i<results.size();i++){
			ExcuteResultInfo result = results.get(i);
			resultStr.append(result.getHostid()).append("#_#");
			resultStr.append(result.getState()).append("#_#");
			resultStr.append(result.getResult() == null?"null":result.getResult()).append("#_#");
			resultStr.append(result.getResultDetail() == null?"null":result.getResultDetail()).append("#_#");
			resultStr.append(result.getRealtimedetail() == null?"":result.getRealtimedetail());
			if(i<results.size() -1) resultStr.append("@_@");
		}
		dto.setResultsStr(resultStr.toString());
		return dto;
	}

	public IGRDP01DTO getHostByAjax(IGRDP01DTO dto) throws BLException {
		dto = getHostsBySystemID(dto);
		List<SOC0123Info> hosts = dto.getHosts();
		StringBuilder b = new StringBuilder();
		for(int i=0;i<hosts.size();i++){
			SOC0123Info host = hosts.get(i);
			b.append(host.getEilabel()).append("&").append(host.getEiname())
			.append("（IP地址：").append(host.getEilabel())
			.append("，类型：").append(host.getEname()).append("）");
			if(i<hosts.size()-1) b.append("#");
		}
		dto.setResultsStr(b.toString());
		return dto;
	}
	
	/**
	 * Ajax 根据任务id 和 主机ip查询realtimedetail 最新数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchRealTimeDetail(IGRDP01DTO dto)throws BLException{
		
		RealtimedetailSearchCondImpl cond = new RealtimedetailSearchCondImpl();
		cond.setHostip(dto.getHostip());
		cond.setTaskid(dto.getTaskID());
		List<RealtimedetailInfo> list = realtimedetailBL.searchRealtimedetail(cond);
		Gson gson = new Gson();
		dto.setRealTimeDetailListJson(gson.toJson(list));
		return dto;
	}
	/**
	 * Ajax 根据任务id 和 已查出的最后的id 获取数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchLastRealTimeDetail(IGRDP01DTO dto)throws BLException{
		
		RealtimedetailSearchCondImpl cond = new RealtimedetailSearchCondImpl();
		cond.setTaskid(dto.getTaskID());
		cond.setRtdid_gt(dto.getRtdId());
		List<RealtimedetailInfo> list = realtimedetailBL.searchRealtimedetail(cond);
		Gson gson = new Gson();
		dto.setRealTimeDetailListJson(gson.toJson(list));
		return dto;
	}
	
}
