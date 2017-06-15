/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.dbm.bl;


import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.dto.IGDBM06DTO;

/**
 * @概述锦州银行事件综合分析首页BL
 * @功能描述 1. 取得事件题类型数量及占比值
 *           2. 取得事件平均解决时间趋势值
 *           3. 取得事件数量趋势值
 *           4. 取得事件及时解决率值
 * @创建记录 赵俊  2010/11/30
 * @version 1.0
 */

public class IGDBM06BLImpl extends BaseBLImpl implements IGDBM06BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * 功能: 取得事件题类型数量及占比值
	 * @param  IGDBM06DTO dto
	 * @return 事件各类型数据值
	 * @throws BLException
	 */
	public IGDBM06DTO getPieValue(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn1Value = dto.getPn1Value();    //查询月份
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * 功能: 取得事件平均解决时间趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForAvg(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn2Value = dto.getPn2Value();  //事件类型
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForAvg(content);
		return dto;
	}
	
	/**
	 * 功能: 取得事件数量趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForCount(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn3Value = dto.getPn2Value();  //事件类型
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForCount(content);
		return dto;
	}
	
	/**
	 * 功能: 取得事件数量趋势值
	 * @param  IGDBM06DTO dto
	 * @return 事件数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentLineForSolve(IGDBM06DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn4Value = dto.getPn2Value();  //事件类型
		
	    String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
	    content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "83" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "89" + "</value>";
	    content = content+"<value>" + "99" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"<TWOLINE>" ;
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80)+ "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"<value>" + (rand.nextInt(20)+80) + "</value>";
	    content = content+"</TWOLINE>" ;
	    content = content+"</ROOT>";
		dto.setIncidentLineForSolve(content);
		return dto;
	}
	/**
	 * 功能: 取得事件综合分析页面所有模块值
	 * @param  IGDBM06DTO dto
	 * @return 事件综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM06DTO getProcessIncidentAllMode(IGDBM06DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessIncidentLineForAvg(dto);
		dto = this.getProcessIncidentLineForCount(dto);
		dto = this.getProcessIncidentLineForSolve(dto);
		return dto;
	}
}

