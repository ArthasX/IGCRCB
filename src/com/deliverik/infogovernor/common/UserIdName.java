package com.deliverik.infogovernor.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;

public class UserIdName {
	/** 记录日志 */
	private static Log log = LogFactory.getLog(UserIdName.class);
	
	/** 系统参数信息 */
	private static Map<String, String> userIdNameMap = new HashMap<String, String>();
	
	private static boolean init = false;

	/**
	 * <p>
	 * Description:构造函数
	 * </p>
	 */
	private UserIdName() {

	}

	/**
	 * <p>
	 * Discription:初始化参数map
	 * </p>
	 * 
	 * @update sunkaiyu@deliverik.com
	 */
	public static void init() {
		log.debug("＝＝＝＝＝＝userIdNameMapping初始化开始＝＝＝＝＝＝");
		UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
		List<User> userList = userBL.searchUser(new UserSearchCondImpl());
		for (User user : userList) {
			userIdNameMap.put(user.getUserid(),user.getUsername());
		}
		init = true;
		log.debug("＝＝＝＝＝＝userIdNameMapping初始化结束＝＝＝＝＝＝");
	}

	/**
	 * <p>
	 * Description: 获取参数信息
	 * </p>
	 * 
	 * @param key
	 * @return String
	 * @update sunkaiyu@deliverik.com
	 */
	public static String getUserNameByUserId(String key) {
		String userName = "";
		if (key != null && !"".equals(key)) {
			if(!init){
				init();
			}
			userName = userIdNameMap.get(key);
			if(null == userName){
				init();
				userName = userIdNameMap.get(key);
			}
		}
		return userName;
	}

}
