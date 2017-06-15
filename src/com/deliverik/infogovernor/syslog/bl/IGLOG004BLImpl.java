/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.syslog.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.syslog.bl.task.Mss00001BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00002BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00003BL;
import com.deliverik.infogovernor.syslog.bl.task.Mss00004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;
import com.deliverik.infogovernor.syslog.form.IGLOG0042Form;
import com.deliverik.infogovernor.syslog.model.Mss00001Info;
import com.deliverik.infogovernor.syslog.model.Mss00002Info;
import com.deliverik.infogovernor.syslog.model.Mss00003Info;
import com.deliverik.infogovernor.syslog.model.Mss00004Info;
import com.deliverik.infogovernor.syslog.model.Mss00004VWInfo;
import com.deliverik.infogovernor.syslog.model.condition.Mss00001SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00002SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00003SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.condition.Mss00004SearchCondImpl;
import com.deliverik.infogovernor.syslog.model.entity.Mss00003TB;
import com.deliverik.infogovernor.syslog.model.entity.Mss00004TB;
import com.deliverik.infogovernor.util.CodeDefine;
/**
 * 
 * 规则模板管理CTROLBL
 *
 * @author wangxing
 *
 */
public class IGLOG004BLImpl extends BaseBLImpl implements IGLOG004BL{
	static Log log = LogFactory.getLog(IGLOG004BLImpl.class);
	
	/** 设备taskBL */
	protected Mss00001BL mss00001BL;
	
	/** 规则模板taskBL */
	protected Mss00004BL mss00004BL;
	
	/** 规则条件taskBL */
	protected Mss00003BL mss00003BL;
	
	/** 设备规则关系的taskBL */
	protected Mss00002BL mss00002BL;
	
	protected CodeDetailBL codeDetailBL;
	
	
	
	/**
	 * 设备taskBL注入
	 * @param mss00001BL
	 */
	public void setMss00001BL(Mss00001BL mss00001BL) {
		this.mss00001BL = mss00001BL;
	}

	/**
	 * 规则模板taskBL注入
	 */
	public void setMss00004BL(Mss00004BL mss00004BL) {
		this.mss00004BL = mss00004BL;
	}

	/**
	 * 规则条件taskBL设定
	 */
	public void setMss00003BL(Mss00003BL mss00003BL) {
		this.mss00003BL = mss00003BL;
	}


	/**
	 * 设备规则关系的taskBL设定
	 */
	public void setMss00002BL(Mss00002BL mss00002BL) {
		this.mss00002BL = mss00002BL;
	}
	
	
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 查询规则模板
	 */
	public IGLOG0041DTO searchMss00004(IGLOG0041DTO dto) {
		log.debug("========规则模板查询开始========");
		
		List<Integer> tempidList = null;
		//页面显示规则模板List
		List<Mss00004VWInfo> mss00004InfoList = new ArrayList<Mss00004VWInfo>();
		dto.setMss00004InfoList(mss00004InfoList);
		//表单form取得
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//如果查询条件中有设备ip
		if(StringUtils.isNotEmpty(form.getDeviceip())){
			
			tempidList = new ArrayList<Integer>();
			
			//通过ip取到设备
			Mss00001SearchCondImpl deviceCond = new Mss00001SearchCondImpl();
			deviceCond.setDeviceip_like(form.getDeviceip());
			List<Mss00001Info> devices = mss00001BL.searchMss00001(deviceCond);
			
			//如果根本没有这个设备，则返回空
			if(devices == null || devices.size() == 0) return dto;
			
			for(Mss00001Info device:devices){
				Mss00002SearchCondImpl relationCond = new Mss00002SearchCondImpl();
				relationCond.setDeviceid(String.valueOf(device.getDeviceid()));
				//通过设备找到关系
				List<Mss00002Info> relations = mss00002BL.searchMss00002(relationCond);
				
				for(Mss00002Info relation : relations){
					tempidList.add(relation.getRuletempid());
				}
			}
		}
		
		//搜索条件cond
		Mss00004SearchCondImpl cond = new Mss00004SearchCondImpl();
		
		cond.setTempidList(tempidList);
		cond.setRuletempname(form.getRuletempname());//模板名称
		
		if(StringUtils.isNotEmpty(form.getTempstates())){
			cond.setTempstates(Integer.valueOf(form.getTempstates()));//查询条件模板状态
		}
		
		if(StringUtils.isNotEmpty(form.getTypeid())){
			cond.setTypeid(form.getTypeid());
		}
		
		if(StringUtils.isNotEmpty(form.getSummary())){
			cond.setSummary(form.getSummary().trim());
		}
		
		//数据总数
		int totalCount = this.mss00004BL.getSearchCount(cond);
		//分页信息取得
		PagingDTO pDto = dto.getPagingDto();
		//查询规则模板（带分页）
		mss00004InfoList = mss00004BL.findByCondVW(cond,pDto.getFromCount(),pDto.getPageDispCount());
		//存入载体
		dto.setMss00004InfoList(mss00004InfoList);
		pDto.setTotalCount(totalCount);
		
		log.debug("========规则模板查询结束========");
		return dto;
	}


	/**
	 * 更改模板状态
	 */
	public IGLOG0041DTO changeTempstate(IGLOG0041DTO dto) throws  BLException {
		log.debug("========更改模板状态处理开始========");
		
		//取得form
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//根据主键获得模板实例
		Mss00004Info info = mss00004BL.searchMss00004ByPK(Integer.valueOf(form.getRuletempid()));
		
		Mss00004TB mss00004TB = (Mss00004TB) SerializationUtils.clone(info);
		
		//判断模板之前的状态
		if(0==mss00004TB.getTempstate()){
			mss00004TB.setTempstate(1);
		}else if(1==mss00004TB.getTempstate()){
			mss00004TB.setTempstate(0);
		}
		
		//修改模板状态
		mss00004BL.updateMss00004(mss00004TB);
		
		log.debug("========更改模板状态处理结束========");
		return dto;
	}


	/**
	 * 录入规则条件模板
	 * @throws BLException 
	 */
	public IGLOG0041DTO insertMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========录入规则模板处理开始========");
		
		//form取得
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//实例化模板类
		Mss00004TB mss00004TB = new Mss00004TB();
		
		mss00004TB.setRuletempname(form.getRuletempname());//模板名称
		mss00004TB.setRulecondition(form.getRulecondition());//规则条件 0是与 ,1是或
		mss00004TB.setTypeid(form.getTypeid());//设备类型
		mss00004TB.setTempdesc(form.getTempdesc());//描述
		mss00004TB.setTempstate(form.getTempstate());//模板状态
		mss00004TB.setCreatetime(IGStringUtils.getCurrentDate());//创建时间，精确到日期
		
		//调用taskBL执行录入规则模板
		Mss00004Info info= mss00004BL.registMss00004(mss00004TB);
		
		StringBuilder summary = new StringBuilder();
		String[] conditionStr = {"包含","等于"};

		//开始录入自定义规则条件
		if(form.getAlarmconditions()!=null && form.getAlarmconditions().length>0){
			
			CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		    condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
		    List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			
			for(int i=0;i<form.getAlarmconditions().length;i++){
				
				if(i > 0){//不是第一个条件
					if(form.getRulecondition() == 0) summary.append("并且");
					else if(form.getRulecondition() == 1) summary.append("或者");
				}
				
				//级别
				String priority = form.getPriority()[i];
				if(!priority.equals("100")){//如果有级别
					String level = "";
					for(CodeDetail cbean : cds){
						if(cbean.getCid().equals(priority)){
							level = cbean.getCvalue();
							break;
						}
					}
					summary.append("[级别").append(level);
				}else summary.append("[");
				
				//包含或等于某字符串
				Integer alarmCondition = Integer.valueOf(form.getAlarmconditions()[i]);
				if(alarmCondition != 0){//如果有条件
					if(!priority.equals("100")) summary.append("且");
					summary.append(conditionStr[alarmCondition-1])
					.append("\""+form.getAlarmmsgs()[i]+"\"]");
				}else summary.append("]");
					
					
				Mss00003TB mss00003TB = new Mss00003TB();
				mss00003TB.setRuletempid(info.getRuletempid());
				mss00003TB.setAlarmcondition(alarmCondition);
				mss00003TB.setAlarmmsg(form.getAlarmmsgs()[i]);
				mss00003TB.setAlarmlevel(Integer.parseInt(priority));
				mss00003TB.setCreatetime(IGStringUtils.getCurrentDate());
				 //调用taskBL录入条件
				mss00003BL.registMss00003(mss00003TB);
			}
		}
		
		Mss00004TB bean = (Mss00004TB) SerializationUtils.clone(info);
		bean.setSummary(summary.toString());
		mss00004BL.updateMss00004(bean);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "规则模板") );
		
		log.debug("========录入规则模板处理结束========");
		
		return dto;
	}


	/**
	 * 修改规则条件模板
	 */
	public IGLOG0041DTO updateMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========修改规则条件模板处理开始========");
		//form取得
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//根据主键查询出条件模板
		Mss00004TB mss00004TB = (Mss00004TB) mss00004BL.searchMss00004ByPK(form.getRuletempid());
		
		mss00004TB.setRuletempname(form.getRuletempname());//模板名称
		mss00004TB.setRulecondition(form.getRulecondition());//规则条件0与1或
		mss00004TB.setTempdesc(form.getTempdesc());//模板描述
		mss00004TB.setTempstate(form.getTempstate());//模板状态
		mss00004TB.setTypeid(form.getTypeid());//设备类型
		
		//更新条件Line206-229
		Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
		
		cond.setRuletempid(form.getRuletempid());
		
		//查询出该规则的条件列表
		List<Mss00003Info> mss00003InfoList = mss00003BL.searchMss00003(cond);
		
		for(Mss00003Info info :mss00003InfoList){
			//删除原有的条件
			this.mss00003BL.deleteMss00003ByPK(info.getRuleconditionid());
		}
		
		StringBuilder summary = new StringBuilder();
		String[] conditionStr = {"包含","等于"};
		
		//开始录入自定义规则条件
		if(form.getAlarmconditions()!=null && form.getAlarmconditions().length>0){
			
			CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
		    condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
		    List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
			
			
			for(int i=0;i<form.getAlarmconditions().length;i++){
				
				if(i > 0){//不是第一个条件
					if(form.getRulecondition() == 0) summary.append("并且");
					else if(form.getRulecondition() == 1) summary.append("或者");
				}
				
				//级别
				String priority = form.getPriority()[i];
				if(!priority.equals("100")){//如果有级别
					String level = "";
					for(CodeDetail cbean : cds){
						if(cbean.getCid().equals(priority)){
							level = cbean.getCvalue();
							break;
						}
					}
					summary.append("[级别").append(level);
				}else summary.append("[");
				
				//包含或等于某字符串
				Integer alarmCondition = Integer.valueOf(form.getAlarmconditions()[i]);
				if(alarmCondition != 0){//如果有条件
					if(!priority.equals("100")) summary.append("且");
					summary.append(conditionStr[alarmCondition-1])
					.append("\""+form.getAlarmmsgs()[i]+"\"]");
				}else summary.append("]");
				
				Mss00003TB mss00003TB = new Mss00003TB();
				mss00003TB.setRuletempid(form.getRuletempid());
				mss00003TB.setAlarmcondition(Integer.valueOf(form.getAlarmconditions()[i]));
				mss00003TB.setAlarmmsg(form.getAlarmmsgs()[i]);
				mss00003TB.setAlarmlevel(Integer.parseInt(form.getPriority()[i]));
				mss00003TB.setCreatetime(IGStringUtils.getCurrentDate());
				 //调用taskBL录入条件
				mss00003BL.registMss00003(mss00003TB);
			}
		}
		
		mss00004TB.setSummary(summary.toString());
		this.mss00004BL.updateMss00004(mss00004TB);
		
		//添加提示信息
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "规则条件模板") );
		
		log.debug("========修改规则条件模板处理结束========");
		
		return dto;
	}


	/**
	 * 获得当前规则条件
	 */
	public IGLOG0041DTO getMss0004(IGLOG0041DTO dto) throws BLException {
		log.debug("========规则条件模板初始化处理开始========");
		//form取得
		IGLOG0042Form form = dto.getIgLog0042Form();
		
		//根据主键查询出条件模板
		Mss00004TB mss00004TB = (Mss00004TB) mss00004BL.searchMss00004ByPK(form.getRuletempid());
		
		Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
		
		cond.setRuletempid(form.getRuletempid());
		
		//查询出该规则的条件列表
		List<Mss00003Info> mss00003InfoList = mss00003BL.searchMss00003(cond);
		
		dto.setMss00004TB(mss00004TB);
		
		dto.setMss00003InfoList(mss00003InfoList);
		
		log.debug("========规则条件模板初始化处理结束========");
		
		return dto;
	}
	/**
	 * 删除选中的规则模板
	 */
	public void deleteTemp(IGLOG0041DTO dto) throws BLException {
		log.debug("========规则模板删除处理开始========");
		
		//取得form
		IGLOG0041Form form = dto.getIgLog0041Form();
		
		//遍历form的deleteId，根据id进行删除规则模板
		for( String ruletempid:form.getDeleteId()){
			Mss00003SearchCondImpl cond = new Mss00003SearchCondImpl();
			cond.setRuletempid(Integer.valueOf(ruletempid));
			List<Mss00003Info> infoList = mss00003BL.searchMss00003(cond);
			for( Mss00003Info info :infoList){
				//删除该模板下的条件
				mss00003BL.deleteMss00003(info);
			}
			//删除规则模板
			mss00004BL.deleteMss00004ByPK(Integer.valueOf(ruletempid));
			//删除设备规则关系表中的规则模板记录
			Mss00002SearchCondImpl searchCond = new Mss00002SearchCondImpl();
			
			searchCond.setRuletempid(Integer.valueOf(ruletempid));
			List<Mss00002Info> minfoList = mss00002BL.searchMss00002(searchCond);
			for( Mss00002Info infos :minfoList){
				//删除设备下的该规则模板
				mss00002BL.deleteMss00002(infos);
			}
		}
		
		log.debug("========规则模板删除处理结束========");
	}
	
	
	public IGLOG0041DTO getAlarmPriority(IGLOG0041DTO dto) throws Exception {
		String alarmPrioritiesStr = "";
        CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
        condimpl.setCcid(CodeDefine.SYSLOGALARM_PRIORITY.getCcid());
        List<CodeDetail> cds = this.codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
        dto.setAlarmPrioritiesList(cds);
        for(CodeDetail cd:cds){
        	alarmPrioritiesStr = alarmPrioritiesStr + cd.getCid()+"&"+cd.getCvalue()+",";
        }
        dto.setAlarmPriorities(alarmPrioritiesStr);
        return dto;
	}

	
	/**
	 * 获取某个模板的设备列表（字符串形式）
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public IGLOG0041DTO getDeviceListString(IGLOG0041DTO dto) throws Exception {
		
		StringBuilder builder = new StringBuilder();
		
		IGLOG0042Form form = dto.getIgLog0042Form();
		Integer ruletempid = form.getRuletempid();
		
		Mss00002SearchCondImpl cond = new Mss00002SearchCondImpl();
		cond.setRuletempid(ruletempid);
		List<Mss00002Info> relations = mss00002BL.searchMss00002(cond);
		
		for(Mss00002Info relation : relations){
			Mss00001Info device = mss00001BL.searchMss00001ByPK(relation.getDeviceid());
			builder.append(device.getDevicename());
			if(StringUtils.isEmpty(device.getDeviceip2())){
				builder.append("（IP："+device.getDeviceip()+"）");
			}else{
				builder.append("（IP1：" + device.getDeviceip() + " IP2："+device.getDeviceip2()+"）");
			}
			builder.append("\n");
		}
		
		dto.setDeviceListString(builder.toString());
		return dto;
	}
}
