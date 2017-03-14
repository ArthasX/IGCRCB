/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.plugin.alarmSocket.bl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.crc.bl.task.IgalarmBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
import com.deliverik.infogovernor.crc.model.condition.IgalarmSearchCondImpl;
import com.deliverik.infogovernor.crc.model.entity.IgalarmTB;

/***
 * 集成告警相关业务接口实现
 * 
 * @time 2014/06/21
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 * 
 *       修改逻辑:(1)接收端格式调整---新增告警状态字段 (2)同一序列号的告警压缩为一条 by wangxing 2015/11/17
 * 
 *       增加逻辑: 接收告警时，通过告警IP判断告警来源设备所属的业务系统是否处于应急演练中和变更中状态，并更新该告警相应状态标识
 *       方式：向配置管理平台发送HTTP请求，具体判断逻辑由配置管理平台完成。 by wangxing 2016/09/05
 */
public class IGAlarmSocketBLImpl extends BaseBLImpl implements IGAlarmSocketBL{

	static Log log = LogFactory.getLog(IGAlarmSocketBLImpl.class);
	
	/** 集成告警表业务逻辑接口 */
	private IgalarmBL igalarmBL;
	
	/**
	 * 集成告警表业务逻辑接口设定
	 * 
	 * @param igalarmBL
	 *            集成告警表业务逻辑接口
	 */
	public void setIgalarmBL(IgalarmBL igalarmBL) {
		this.igalarmBL = igalarmBL;
	}

	/**
	 * 新增集成告警处理
	 * 
	 * @throws ParseException
	 */
	public int registIgalarm(IGCRC02DTO dto) throws Exception {
		
		log.debug("=======新增集成告警处理开始==========");
		// 返回结果
		int result = 0;

		// 获取告警信息各域的值
		String message = dto.getMsg().trim();
		String[] contents = message.split("[|]");
		log.debug(contents.length);
		// 如果不是7个值域，告警信息格式错误
		if(contents.length != 7 ){
			log.error("告警信息格式错误：" + message);
			result = 1;
		}else{
			String alarmip = contents[1].substring(1, contents[1].length()-1);
			String alarmSerial = contents[2].substring(1, contents[2].length()-1);
			// 判断该IP所在设备是否处于应急演练的屏蔽状态

			Map<Integer, String> resultMap = null;
			try {
				resultMap = getDeviceShieldStatusByIP(alarmip, contents[3]);
			} catch (Exception e) {
				log.error("=========链接到配置管理平台查询业务系统报错，设备IP" + alarmip + "=========");
				e.printStackTrace();
				return -2;

				// throw new Exception("根据IP查询业务系统报错");
			}
			boolean isShield = Boolean.parseBoolean(resultMap.get(1));
			// 获取与所新增记录序号相同的记录列表
			List<IgalarmInfo> sameSerialAlarms = searchSameSerial(alarmSerial);
			
			String status = null;
			if ("1".equals(contents[6])) {// 告警发生
				// 事件内容包含‘已恢复’的，将状态调整为告警修复
				if (contents[3].contains("已恢复")) {
					status = "1";
				}else{
					status = "0";
				}
			} else if ("2".equals(contents[6])) {// 告警修复
				status = "1";
			}else{
				log.error("未知的告警状态类型:" + contents[6]);
				return 1;
			}
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date lastTime = new Date();
			try {
				lastTime = df.parse(contents[4]);
			} catch (ParseException e1) {
				log.error("解析日期错误");
				e1.printStackTrace();
				throw new Exception("解析日期错误");
			}
			df.applyPattern("yyyy/MM/dd HH:mm:ss");
			String lastTimeStr = df.format(lastTime);
			
			// 如果相同序号的告警记录已经存在
			if(sameSerialAlarms != null && sameSerialAlarms.size() > 0){
				if(sameSerialAlarms.size() > 1) {
					log.warn("相同的告警序列号(" + alarmSerial + ")超过一条,当前条数" + sameSerialAlarms.size() + "条");
				}
				for(IgalarmInfo alarmInfo : sameSerialAlarms){
					IgalarmTB iaTB = (IgalarmTB)alarmInfo;
					if(isShield) {
						iaTB.setShieldflag("1");// 如果处于屏蔽状态，则置为1
						iaTB.setShielddesc(resultMap.get(2));
					}
					else
						iaTB.setShieldflag("0");// 正常告警则置为0
					
					if ("0".equals(status)) {// 如果不是修复告警
						iaTB.setPrealarmtime(lastTimeStr);// 把此次告警时间更新为最后一次告警时间
						iaTB.setAlarmcount(iaTB.getAlarmcount() + 1);// 告警总次数加1
						iaTB.setStatus(status);
						iaTB.setRecoveryTime(null);
						igalarmBL.updateIgalarm(iaTB);
						
					} else if ("1".equals(status) && !"2".equals(iaTB.getStatus())) {// 如果是修复告警,并且该告警尚未被流程关闭
						iaTB.setRecoveryTime(lastTimeStr);// 设置告警修复时间
						iaTB.setFaultContact(iaTB.getFaultContact());
						iaTB.setStatus(status);
						igalarmBL.updateIgalarm(iaTB);
					}
					
				}
				
				// 如果是新告警
			}else{

				//
				IgalarmTB iaTB = new IgalarmTB();
				
				if(isShield) {
					iaTB.setShieldflag("1");// 如果处于屏蔽状态，则置为1
					iaTB.setShielddesc(resultMap.get(2));
				}
				else
					iaTB.setShieldflag("0");// 正常告警则置为0
				iaTB.setAppname(contents[0]);// 主机名称赋值
				iaTB.setSerial(alarmSerial);// 序号赋值
				iaTB.setIpaddr(alarmip);// IP地址赋值
				iaTB.setSummary(contents[3]);// 事件内容赋值
				iaTB.setLasttime(lastTimeStr);// 触发时间赋值
				iaTB.setFingerPrint(contents[5]);// 处理人
				iaTB.setStatus(status);// 状态设置
				iaTB.setIsCreateOrder("0");// 设置是否生成工单取得
				iaTB.setIsShow("0");// 是否显示标识(0显示，1不显示)
				iaTB.setPrealarmtime(lastTimeStr);// 最后告警时间
				iaTB.setAlarmcount(1);
				
				IgalarmInfo iaInfo = igalarmBL.registIgalarm(iaTB);
				if(iaInfo == null){
					log.error("告警信息增加失败");
					result = 1;
				} else {
					try {
						// 根据告警触发应急流程
						// IGDRMAlarmTools.monitorAlarm(message, isShield);

					} catch (Exception e) {
						log.error("================触发应急流程报错===============");

						throw e;
					}
				}
			}
			
		}
		
		log.debug("=======新增集成告警处理结束==========");
		
		return result;
	}
	
	
	/**
	 * 获取相同序号的集成告警记录列表
	 * 
	 * @param serial
	 *            序号
	 * @return List<IgalarmInfo> 集成告警记录列表
	 */
	public List<IgalarmInfo> searchSameSerial(String serial){		
		
		List<IgalarmInfo> list = new ArrayList<IgalarmInfo>();
		// 集成告警表检索条件
		IgalarmSearchCondImpl cond = new IgalarmSearchCondImpl();
		
		cond.setSerial(serial);
		cond.setStatus("ALL");
		// 查询序号相同的集成告警记录
		list = igalarmBL.searchIgalarm(cond);
		
		return list;	
	}
	
	/**
	 * 通过Http Post请求向常熟配置管理平台获取IP所在的设备是否处于应急演练屏蔽状态
	 * 
	 * @param ip
	 * @return
	 */
	private Map<Integer,String> getDeviceShieldStatusByIP(String ip,String msg){
		Map<Integer,String> resultMap = new HashMap<Integer,String>();
		resultMap.put(1, "false");
		
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("ip", ip));
		list.add(new BasicNameValuePair("msg", msg));
		
		HttpParams params = new BasicHttpParams();
		params.setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 10 * 1000);
		params.setParameter(CoreConnectionPNames.SO_TIMEOUT, 10 * 1000);
		
		// 实现将请求 的参数封装封装到HttpEntity中。
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(list, "utf-8");
			// 使用HttpPost请求方式
			String posturl = ResourceUtility.getString("BSMAPP_URL");
			HttpPost httpPost = new HttpPost(posturl);
			// 设置请求参数到Form中。
			httpPost.setEntity(entity);
			// 实例化一个默认的Http客户端
			DefaultHttpClient client = new DefaultHttpClient(params);
			// 执行请求，并获得响应数据
			HttpResponse httpResponse = client.execute(httpPost);
			String result = EntityUtils.toString(httpResponse.getEntity());
			
			if(StringUtils.isNotEmpty(result)){
				if(result.startsWith("true")){
					String[] temp = result.split("@_@");
					resultMap.put(1, "true");
					if(temp.length > 1) resultMap.put(2, temp[1]);
				}else if(result.startsWith("false")){
					resultMap.put(1, "false");
				}else{
					log.error("错误的返回数据格式>" + result + "<");
				}
			}else{
				log.error("返回数据为空!");
			}
			log.info("设备状态请求处理结束:" + httpResponse.getStatusLine().getStatusCode());
		} catch (Exception e) {
			log.error("设备状态请求出现异常:");
			log.error(e,e);
		}
		return resultMap;
	}

}
