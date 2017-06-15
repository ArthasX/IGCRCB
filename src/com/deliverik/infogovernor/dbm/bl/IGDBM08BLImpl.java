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
import com.deliverik.infogovernor.dbm.dto.IGDBM08DTO;

/**
 * @概述锦州银行工作综合分析首页BL
 * @功能描述 1. 取得月工作类型数量及占比值
 *           2. 取得工作平均解决时间趋势值
 *           3. 取得工作数量趋势值
 *           4. 取得工作及时解决率值
 * @创建记录 赵俊  2010/11/30
 * @version 1.0
 */

public class IGDBM08BLImpl extends BaseBLImpl implements IGDBM08BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);
	

	/**
	 * 功能: 取得月工作类型数量及占比值
	 * @param  IGDBM08DTO dto
	 * @return 工作各类型数据值
	 * @throws BLException
	 */
	public IGDBM08DTO getPieValue(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn1Value = dto.getPn1Value();    //查询月份
		dto.setPieValue(rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5)+"|"+rand.nextInt(5));
		return dto;
	}
	
	/**
	 * 功能: 取得工作平均解决时间趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作平均解决时间趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForAvg(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn2Value = dto.getPn2Value();  //工作类型
		
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
		dto.setWorkLineForAvg(content);
		return dto;
	}
	
	/**
	 * 功能: 取得工作数量趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForCount(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn3Value = dto.getPn2Value();  //工作类型
		
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
		dto.setWorkLineForCount(content);
		return dto;
	}
	
	/**
	 * 功能: 取得工作数量趋势值
	 * @param  IGDBM08DTO dto
	 * @return 工作数量趋势12个月值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkLineForSolve(IGDBM08DTO dto) throws BLException{
		Random rand = new Random();
		String typeValue = dto.getTypeValue();  //查询条件 类型 or 来源
		String yearValue = dto.getYearValue();  //查询年度
		String pn4Value = dto.getPn2Value();  //工作类型
		
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
		dto.setWorkLineForSolve(content);
		return dto;
	}
	/**
	 * 功能: 取得工作综合分析页面所有模块值
	 * @param  IGDBM08DTO dto
	 * @return 工作综合分析页面所有模块值
	 * @throws BLException
	 */
	public IGDBM08DTO getProcessWorkAllMode(IGDBM08DTO dto) throws BLException{
		dto = this.getPieValue(dto);
		dto = this.getProcessWorkLineForAvg(dto);
		dto = this.getProcessWorkLineForCount(dto);
		dto = this.getProcessWorkLineForSolve(dto);
		return dto;
	}
}

