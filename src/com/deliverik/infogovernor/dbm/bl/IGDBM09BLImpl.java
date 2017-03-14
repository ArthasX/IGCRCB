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
import com.deliverik.infogovernor.dbm.dto.IGDBM09DTO;

/**
 * @概述锦州银行系统可用率分析首页BL
 * @功能描述 1.当前实际可用率         
 *			2.实际可用率全年累计        
 *			3.可用率年度趋势         
 *			4.工作及时解决率趋势
 * @创建记录：李旭峙    2010/12/01
 * @version 1.0
 */

public class IGDBM09BLImpl extends BaseBLImpl implements IGDBM09BL {
	
	static Log log = LogFactory.getLog(IGDBM01BLImpl.class);

	/**
	 * 功能: 取得当前实际可用率
	 * @param  IGDBM09DTO dto
	 * @return 当前实际可用率值
	 * @throws BLException
	 */
	public IGDBM09DTO getCurrentActualAvailability(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//取得所选的系统ID
		Random rand = new Random();
		//根据系统ID取得当前实际可用率
		dto.setCurrentActualAvailability((rand.nextInt(20)+80)+"");
		return dto;
	}
	
	/**
	 * 功能: 取得实际可用率全年累计
	 * @param  IGDBM09DTO dto
	 * @return 实际可用率全年累计值
	 * @throws BLException
	 */
	public IGDBM09DTO getYearActualAvailability(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//取得所选的系统ID
		Random rand = new Random();
		//根据系统ID取得实际可用率全年累计
		dto.setYearActualAvailability((rand.nextInt(20)+80)+"");
		return dto;
	}
	
	/**
	 * 功能: 取得可用率年度趋势
	 * @param  IGDBM09DTO dto
	 * @return 可用率年度趋势12个月值
	 * @throws BLException
	 */
	public IGDBM09DTO getAvailabilityYearTrends(IGDBM09DTO dto) throws BLException{
		String selectSystemId = dto.getSelectSystemId();//取得所选的系统ID
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
		content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
	    content = content+"<ONELINE>" ;
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "80" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "88" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "98" + "</value>";
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"</ONELINE>" ;
	    content = content+"</ROOT>";
	    dto.setAvailabilityYearTrends(content);
		return dto;
	}
	
	/**
	 * 功能: 取得工作及时解决率趋势
	 * @param  IGDBM09DTO dto
	 * @return 工作及时解决率趋势12个月值
	 * @throws BLException
	 */
	public IGDBM09DTO getWorkTimelySolutionlyTrends(IGDBM09DTO dto) throws BLException{
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
	    content = content+"<MAXVALUE>" + "100" + "</MAXVALUE>";
		content = content+"<MINVALUE>" + "80" + "</MINVALUE>";
		content = content+"<ALARMVALUE>" + "90" + "</ALARMVALUE>";
	    content = content+"<value>" + "100" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"<value>" + "80" + "</value>";
	    content = content+"<value>" + "95" + "</value>";
	    content = content+"<value>" + "90" + "</value>";
	    content = content+"<value>" + "88" + "</value>";
	    content = content+"<value>" + "81" + "</value>";
	    content = content+"<value>" + "85" + "</value>";
	    content = content+"</ROOT>";
	    dto.setWorkTimelySolutionlyTrends(content);
		return dto;
	}
	
}

