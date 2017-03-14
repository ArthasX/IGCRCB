package com.deliverik.infogovernor.common;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;

public class PrjTypeValueBean {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(PrjTypeValueBean.class);
	
	/** 系统参数信息 */
	private static Map<String, String> ptypeValueMap = new HashMap<String, String>();

	/** 加载属性文件标识 */
	//private static boolean init = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private PrjTypeValueBean() {

	}

	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 * @update duchong@deliverik.com
	 */
	public static void init(String key) {

		log.debug("＝＝＝＝＝＝项目类别初始化开始＝＝＝＝＝＝");
		// 取出单位系统配置参数
		
		IGPRJ01BL prjBL = (IGPRJ01BL) WebApplicationSupport.getBean("igprj01BL");
		IGPRJ01DTO dto = new IGPRJ01DTO();
		dto.setPtype(key);
		dto = prjBL.findProjectTypeAction(dto);
		
		ptypeValueMap.put(key,dto.getPtype_name());

		//init = true;
		log.debug("＝＝＝＝＝＝项目类别初始化结束＝＝＝＝＝＝");

	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update duchong@deliverik.com
	 */
	public static String getConfigInfo(String key) {
		if (ptypeValueMap != null && !ptypeValueMap.isEmpty()) {
			if(ptypeValueMap.get(key)==null || "".equals(ptypeValueMap.get(key))){
				init(key);
				return (String) ptypeValueMap.get(key);
			}else{
				return (String) ptypeValueMap.get(key);
			}
		}else{
			init(key);
			return (String) ptypeValueMap.get(key);
		}

	}

}
