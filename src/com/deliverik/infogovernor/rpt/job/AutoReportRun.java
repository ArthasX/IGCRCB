/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.job;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.bl.task.SOC0201BL;
import com.deliverik.infogovernor.rpt.bl.task.SOC0203BL;
import com.deliverik.infogovernor.rpt.model.SOC0201Info;
import com.deliverik.infogovernor.rpt.model.SOC0203Info;
import com.deliverik.infogovernor.rpt.model.condition.SOC0201SearchCondImpl;
import com.deliverik.infogovernor.rpt.model.entity.SOC0201TB;


/**
 * 概述:自动报表生成文件
 * 修改记录：
 * 			增加年季	2012/06/07 
 */
public class AutoReportRun implements Job{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** log对象 */
	static Log log = LogFactory.getLog(AutoReportRun.class);
	

	/** AutoReportRun临时表 */
	protected static SOC0203BL soc0203BL = (SOC0203BL) WebApplicationSupport
			.getBean("soc0203BL");
	
	/** 自动报表生成表 */
	protected static SOC0201BL soc0201BL = (SOC0201BL) WebApplicationSupport
			.getBean("soc0201BL");

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		try {
			log.debug("================================自动生成报表任务开始 "+new Date()+"=======================================");  
			List<SOC0203Info> soc0203List = soc0203BL.findAllSOC0203();
			if(soc0203List!=null&&soc0203List.size()>0){
				for(SOC0203Info rc : soc0203List){
					log.debug(rc.getR_title()+"  准备生成报表");  
					runJob(rc);
				}
			}
		} catch (BLException e) {
			log.debug(e);  
			e.printStackTrace();
		}
	}

	/** 自动报表执行 
	 * 	para参数中包含 
	 *  &&TYPE=00000 年报 、季报、月报、周报、日报  其中1为生成，0为不生成
	 * @throws BLException */
	public void runJob(SOC0203Info soc0203) throws BLException{
		//add by wangly 20111110 增加对para的判断，是否有出日报的标记最后一位  dataid:000290105486&&TYPE=001
		if(!isParaCorrect(soc0203.getPara())){
			return;
		}
		java.net.HttpURLConnection connection=null;
		try {
			java.io.InputStream in; 
			log.debug("准备访问路径:"+ResourceUtility.getString("BIREVIEWER_URL")+"?report="+soc0203.getR_path()+"&dataId="+soc0203.getDataid()+"&docpath="+ResourceUtility.getString("BIRT_GFILE_PATH")+"&reportpath="+ResourceUtility.getString("BIRT_AUTOREPORT_PATH"));
			java.net.URL url = new java.net.URL(ResourceUtility.getString("BIREVIEWER_URL")+"?report="+soc0203.getR_path()+"&docpath="+ResourceUtility.getString("BIRT_GFILE_PATH")+"&reportpath="+ResourceUtility.getString("BIRT_REPORT_PATH")+"&rType=0");	//birtviewer访问路径
			connection = (java.net.HttpURLConnection)url.openConnection(); 
			//模拟成ie 多浏览器支持
			connection.setRequestProperty("user-agent","mozilla/4.0 (compatible; msie 6.0; windows 2000)"); 
	        // 设置是否向connection输出，因为这个是post请求，参数要放在
	        // http正文内，因此需要设为true
	        connection.setDoOutput(true);
	        // Read from the connection. Default is true.
	        connection.setDoInput(true);
	        // Set the post method. Default is GET
	        connection.setRequestMethod("POST");
	        
			connection.connect(); 
			
	        DataOutputStream out = new DataOutputStream(connection
	                .getOutputStream());
	        // The URL-encoded contend
	        
	        //para参数
	        String para = "&para="+URLEncoder.encode(soc0203.getPara(), "utf-8");
	        out.writeBytes(para);
	        //取得自动报表生成规则 0000  季报、月报、周报、日报、年报
	        String strType = soc0203.getPara().split("&&")[1].split("=")[1];
	        //生成日报情况下的参数
			//if(needReport(strType, 4)){
			//	REPORT_GDATA_ITEMSearchCondImpl cond = new REPORT_GDATA_ITEMSearchCondImpl();
			//	//指定查询条件
			//	cond.setR_rcid(repcig.getId());
			//	cond.setR_category("day");
			//	List<REPORT_GDATA_ITEM> lstRGT = rEPORT_GDATA_ITEMBL.findREPORT_GDATA_ITEMByCond(cond, 0, 1);
			//	if(lstRGT != null && lstRGT.size() > 0){
			//		//取上一次执行的最后一条日报记录时间 2011/07/01 格式
			//		String time = lstRGT.get(0).getR_time();
			//		if(StringUtils.isNotEmpty(time) && time.length() == 10)
			//		{
						//para参数
			//	        String lastdate = "&lastDate="+URLEncoder.encode(time, "utf-8");
			//	        out.writeBytes(lastdate);
			//		}
			//	}
		//	}
			//生成月报情况下的参数
			if(needReport(strType, 2)){
				SOC0201SearchCondImpl cond = new SOC0201SearchCondImpl();
				//指定查询条件
				cond.setR_rcid(soc0203.getId());
				cond.setR_category("month");
				List<SOC0201Info> lstRGT = soc0201BL.findSOC0201ByCond(cond, 0, 1);
				if(lstRGT != null && lstRGT.size() > 0){
					//取上一次执行的最后一条日报记录时间 2011/07 格式
					String time = lstRGT.get(0).getR_time();
					if(StringUtils.isNotEmpty(time) && time.length() == 7)
					{
						//para参数
				        String lastdate = "&lastMonth="+URLEncoder.encode(time, "utf-8");
				        out.writeBytes(lastdate);
					}
				}
			}
			//生成季报情况下的参数
			if(needReport(strType, 1)){
				SOC0201SearchCondImpl cond = new SOC0201SearchCondImpl();
				//指定查询条件
				cond.setR_rcid(soc0203.getId());
				cond.setR_category("quarter");
				List<SOC0201Info> lstRGT = soc0201BL.findSOC0201ByCond(cond, 0, 1);
				if(lstRGT != null && lstRGT.size() > 0){
					//取上一次执行的最后一条季报记录时间 20121 格式
					String time = lstRGT.get(0).getR_time();
					if(StringUtils.isNotEmpty(time) && time.length() == 5)
					{
						//para参数
				        String lastdate = "&lastQuarter="+URLEncoder.encode(time, "utf-8");
				        out.writeBytes(lastdate);
					}
				}
			}
			//生成年报情况下的参数
			if(needReport(strType, 0)){
				SOC0201SearchCondImpl cond = new SOC0201SearchCondImpl();
				//指定查询条件
				cond.setR_rcid(soc0203.getId());
				cond.setR_category("year");
				List<SOC0201Info> lstRGT = soc0201BL.findSOC0201ByCond(cond, 0, 1);
				if(lstRGT != null && lstRGT.size() > 0){
					//取上一次执行的最后一条年报记录时间 2011 格式
					String time = lstRGT.get(0).getR_time();
					if(StringUtils.isNotEmpty(time) && time.length() == 4)
					{
						//para参数
				        String lastdate = "&lastYear="+URLEncoder.encode(time, "utf-8");
				        out.writeBytes(lastdate);
					}
				}
			}
	        // 正文，正文内容其实跟get的URL中'?'后的参数字符串一致
	        String reportname = "&reportname=" + URLEncoder.encode(soc0203.getDataid()+soc0203.getR_path(), "utf-8");
	        // DataOutputStream.writeBytes将字符串中的16位的unicode字符以8位的字符形式写道流里面
	        out.writeBytes(reportname); 
	        out.flush();
	        out.close(); // flush and close
	        
			in = connection.getInputStream(); 
			java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in , "utf-8")); 
			String str=breader.readLine(); 
			while (str != null) {
				str = breader.readLine();
				if(str!=null){
					String strs[] = str.split("&");
					if (strs != null && strs.length > 1) {
						// 记录生成的自动报表
						String rpath=strs[0].split("=")[1];
						String rtime=strs[1].split("=")[1];
						String rtime_Year = "";
						String rtime_Quarter="";
						String rtime_Mont = "";
						String rtime_Date = "";
						int flag=2;//年季月周日 43210
						if(StringUtils.isNotEmpty(rtime)){
							int timeLen=rtime.length();
							if(timeLen==4){//年2012
								rtime_Year=rtime;
								flag=0;
							}else if(timeLen==5){//季 20121
								rtime_Year=rtime.substring(0,4);
								rtime_Quarter=rtime.charAt(rtime.length()-1)+"";
								flag=1;
							}else{
								String[] paras = rtime.split("[/]");
								rtime_Year = rtime.split("[/]")[0];
								rtime_Mont = rtime.split("[/]")[1];
								if(paras.length == 3){
									rtime_Date = rtime.split("[/]")[2];
									flag=4;
								}else{
									flag=2;
								}
								if(StringUtils.isNotEmpty(rtime_Mont)){
									if(Integer.parseInt(rtime_Mont)<10){
										rtime_Mont = "0"+rtime_Mont;
									}
								}
								if(StringUtils.isNotEmpty(rtime_Date)){
									if(Integer.parseInt(rtime_Date)<10){
										rtime_Date = "0"+rtime_Date;
									}
								}
							}
						}
						SOC0201SearchCondImpl cond = new SOC0201SearchCondImpl();
						cond.setR_path(rpath);
						cond.setR_rcid(soc0203.getId());
						if(flag==0){
							cond.setR_time(rtime_Year);
						}else if(flag==1){
							cond.setR_time(rtime_Year+rtime_Quarter);
						}else if(flag==2){
							cond.setR_time(rtime_Year+"/"+rtime_Mont);
						}else if(flag==4){
							cond.setR_time(rtime_Year+"/"+rtime_Mont+"/"+rtime_Date);
						}
						List<SOC0201Info> rgiList = soc0201BL
								.findSOC0201ByCond(cond, 0, 0);
						if(rgiList!=null&&rgiList.size()>0){
							
						}else{
							SOC0201TB soc0201  = new SOC0201TB();
							//判断增加记录报型
							if(flag==0){
								soc0201.setR_category("year");
								soc0201.setR_time(rtime_Year);
							}else if(flag==1){
								soc0201.setR_category("quarter");
								soc0201.setR_time(rtime_Year+rtime_Quarter);
							}else if(flag==2){
								soc0201.setR_category("month");
								soc0201.setR_time(rtime_Year+"/"+rtime_Mont);
							}else if(flag==4){
								soc0201.setR_category("day");
								soc0201.setR_time(rtime_Year+"/"+rtime_Mont+"/"+rtime_Date);
							}
							soc0201.setR_path(rpath);
							soc0201.setR_rcid(soc0203.getId());
							soc0201.setDataid(soc0203.getDataid());
							soc0201BL.saveSOC0201(soc0201);
						}
					} else {
						log.debug(str);
					}
				}
			}
		} catch (MalformedURLException e) {
			log.debug(e); 
			e.printStackTrace();
		} catch (IOException e) {
			log.debug(e); 
			e.printStackTrace();
		} finally{
			try {
				log.debug("执行状态："+connection.getResponseCode()); 
			} catch (IOException e) {
				log.debug(e);
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据规则判断是否生成报表
	 * 	para参数中包含 
	 *  &&TYPE=00000 年报 、季报、月报、周报、日报
	 * @param type
	 * @param position
	 * @return
	 */
	public boolean needReport(String type, int position){
		if(StringUtils.isEmpty(type) || type.length() != 5){
			return false;
		}
		String str = String.valueOf(type.charAt(position));
		if("1".equalsIgnoreCase(str)){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断para参数的值是否合理，如果不合理则不进行自动报表生成
	 * dataid:000290105486&&TYPE=001
	 * @param para
	 * @return
	 */
	public boolean isParaCorrect(String para){
		//判断是否为空
		if(StringUtils.isEmpty(para)){
			log.debug("para参数为空!");
			return false;
		}
		//判断格式是否为dataid:000290105486&&TYPE=0001格式
		String[] arrPara = para.split("&&");
		if(arrPara.length!=2){
			log.debug("请设置para参数的自动报表生成规则!");
			return false;
		}
		String[] arrType = arrPara[1].split("=");
		if(arrType.length != 2){
			log.debug("请设置para参数的自动报表生成规则!");
			return false;
		}
		return true;
	}
}
