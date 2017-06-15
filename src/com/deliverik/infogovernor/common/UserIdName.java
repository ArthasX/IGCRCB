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
	/** ��¼��־ */
	private static Log log = LogFactory.getLog(UserIdName.class);
	
	/** ϵͳ������Ϣ */
	private static Map<String, String> userIdNameMap = new HashMap<String, String>();
	
	private static boolean init = false;

	/**
	 * <p>
	 * Description:���캯��
	 * </p>
	 */
	private UserIdName() {

	}

	/**
	 * <p>
	 * Discription:��ʼ������map
	 * </p>
	 * 
	 * @update sunkaiyu@deliverik.com
	 */
	public static void init() {
		log.debug("������������userIdNameMapping��ʼ����ʼ������������");
		UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
		List<User> userList = userBL.searchUser(new UserSearchCondImpl());
		for (User user : userList) {
			userIdNameMap.put(user.getUserid(),user.getUsername());
		}
		init = true;
		log.debug("������������userIdNameMapping��ʼ������������������");
	}

	/**
	 * <p>
	 * Description: ��ȡ������Ϣ
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
