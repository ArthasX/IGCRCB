/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利
 */
package com.deliverik.infogovernor.rpt.job;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.bl.task.SOC0202BL;
import com.deliverik.infogovernor.rpt.model.entity.SOC0202TB;

/**
 * 概述:自定义birtWORD导出
 * 功能描述:自定义birtWORD导出
 * 创建记录:杨龙全 2012/06/12 
 * 修改记录:
 */
public class CustomBirtReportImport {
	
	static Log log = LogFactory.getLog(CustomBirtReportImport.class);
	protected static SOC0202BL soc0202BL=(SOC0202BL) WebApplicationSupport.getBean("soc0202BL");
	/**
	 * 自定义报表导出文档
	 * @throws IOException
	 * @throws BLException
	 */
	public int runBirtReportImport(String ssn,String kpi,String checkboxs,String dateFrom,String dateTo,String timeFrom,String timeTo
			,String timetype,String compareData,String mode,String device,String userName,String raName) {
		java.net.HttpURLConnection connection=null;
		int state=0;
		try {
			java.io.InputStream in; 
			StringBuilder sb=new StringBuilder();
			//访问路径
			sb.append(ResourceUtility.getString("BIREVIEWER_URL"));
			//word存储路径
			sb.append("?docPath="+ResourceUtility.getString("CUSTOM_BIRT_GFILE_PATH"));
			//存储序列
			sb.append("&ssn="+ssn);
			//kpi类型名字
			sb.append("&kpi="+kpi);
			//传类型为1
			sb.append("&rType=1");
			//模板路径
			String temPath=ResourceUtility.getString("BIRT_REPORT_PATH")+kpi+"/1/"+kpi;
			sb.append("&reportTemPathName="+temPath);
			log.debug("准备访问路径:"+sb.toString());
			java.net.URL url = new java.net.URL(sb.toString());	//birtviewer访问路径
			connection = (java.net.HttpURLConnection)url.openConnection(); 
			//模拟成ie 多浏览器支持
//			connection.setRequestProperty("user-agent","mozilla/4.0 (compatible; msie 6.0; windows 2000)"); 
			connection.setRequestProperty("user-agent","mozilla/4.0 (compatible; msie 8.0; Windows NT 5.1)"); 
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
			//checkbox
			if(checkboxs!=null){
				String checkbox = "&checkboxs="+URLEncoder.encode(checkboxs, "utf-8");
		        out.writeBytes(checkbox);
			}
	        //dateFrom
			if(dateFrom!=null){
			String dateFroms = "&dateFrom="+URLEncoder.encode(dateFrom, "utf-8");
	        out.writeBytes(dateFroms);
			}
	        //dateTo
			if(dateTo!=null){
			String dateTos = "&dateTo="+URLEncoder.encode(dateTo, "utf-8");
	        out.writeBytes(dateTos);
			}
	        //timeFrom
			if(timeFrom!=null){
			String timeFroms = "&timeFrom="+URLEncoder.encode(timeFrom, "utf-8");
	        out.writeBytes(timeFroms);
			}
	        //timeTo
	        if(timeTo!=null){
			String timeTos = "&timeTo="+URLEncoder.encode(timeTo, "utf-8");
	        out.writeBytes(timeTos);
	        }
	        //timetype
	        if(timetype!=null){
			String timetypes = "&timetype="+URLEncoder.encode(timetype, "utf-8");
	        out.writeBytes(timetypes);
	        }
	        //compareData
	        if(compareData!=null){
			String compareData1s = "&compareData="+URLEncoder.encode(compareData, "utf-8");
	        out.writeBytes(compareData1s);
	        }
	        //Mode
	        if(mode!=null){
			String modes = "&mode="+URLEncoder.encode(mode, "utf-8");
	        out.writeBytes(modes);
	        }
	        //device
	        if(device!=null){
			String devices = "&device="+URLEncoder.encode(device, "utf-8");
	        out.writeBytes(devices);
	        }
	        out.flush();
	        out.close();
	        state = connection.getResponseCode();  
	        
	        
	        
			in = connection.getInputStream(); 
			java.io.BufferedReader breader = new BufferedReader(new InputStreamReader(in , "utf-8")); 
			String str=breader.readLine(); 
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			while (str != null) {
				str = breader.readLine();
				if(str!=null){
					if(str.startsWith("customreport")){	
						String[] strArr=str.split("=");
						SOC0202TB reportAnnexationTB=new SOC0202TB();
						reportAnnexationTB.setRaSsn(ssn);
						reportAnnexationTB.setRaKpi(kpi);
						reportAnnexationTB.setRaCreateDate(sdf.format(new Date()));
						reportAnnexationTB.setRaUserName(userName);
						reportAnnexationTB.setRaRealName(strArr[1]);
						reportAnnexationTB.setRaName(raName);
						soc0202BL.registSOC0202(reportAnnexationTB);					
						} else {
							log.debug(str);
					}
				}
			}
			//存储记录
		} catch (MalformedURLException e) {
			log.debug(e); 
			state=500;
			e.printStackTrace();
		} catch (IOException e) {
			log.debug(e); 
			state=500;
			e.printStackTrace();
		} catch (BLException e) {
			log.debug(e); 
			state=500;
			e.printStackTrace();
		} finally{
			try {
				log.debug("status："+connection.getResponseCode()); 
			} catch (IOException e) {
				log.debug(e);
				e.printStackTrace();
			}
		}
		
		return state;
	}
		
}
