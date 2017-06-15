package com.deliverik.infogovernor.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.prj.vo.MilestoneInfo;

public class PRJHelper {

	public static String verifyMilestone(String pplInfo, String index, String confirmTime, String confirmDesc) {
		if (null == confirmDesc || "".equals(confirmDesc)) {
			confirmDesc = "N";
		}
		if (null == confirmTime || "".equals(confirmTime)) {
			confirmTime = String.valueOf(System.currentTimeMillis());
		}
		StringBuilder ppInfoBuilder = new StringBuilder();
		String[] milestoneInfos = pplInfo.split(";");
		for (int i = 0; i < milestoneInfos.length; i++) {
			String milestoneInfo = milestoneInfos[i];
			String[] milestones = milestoneInfo.split(":");
			if (index.equals(milestones[0])) {
				for (int j = 0; j < milestones.length; j++) {
					if (1 == j) {
						ppInfoBuilder.append("V:");
					} else if(5 == j){
						ppInfoBuilder.append(confirmTime).append(":");
					} else if (6 == j) {
						ppInfoBuilder.append(confirmDesc);
					} else {
						ppInfoBuilder.append(milestones[j]).append(":");
					}
				}
				ppInfoBuilder.append(";");
				continue;
			}
			ppInfoBuilder.append(milestoneInfo).append(";");
		}
		return ppInfoBuilder.toString();
	}

	public static List<MilestoneInfo> creatMilestoneInfoVOArray(String pplInfo) {
		String[] milestoneInfos = pplInfo.split(";");
		int milestoneInfoLength = milestoneInfos.length;
		List<MilestoneInfo> milestoneInfoVOList = new ArrayList<MilestoneInfo>();
		for (int i = 0; i < milestoneInfoLength; i++) {
			MilestoneInfo milestoneInfoVO = new MilestoneInfo();
			String milestoneInfo = milestoneInfos[i];
			String[] milestoneElements = milestoneInfo.split(":");
			milestoneInfoVO.setMsIndex(milestoneElements[0]);
			milestoneInfoVO.setMsStatus(milestoneElements[1]);
			milestoneInfoVO.setMsName(milestoneElements[2]);
			milestoneInfoVO.setMsPlanDate(milestoneElements[3]);
			milestoneInfoVO.setMsplanDesc(milestoneElements[4]);
			milestoneInfoVO.setMsConfirmDate(milestoneElements[5]);
			milestoneInfoVO.setMsConfirmDesc(milestoneElements[6]);
			milestoneInfoVOList.add(milestoneInfoVO);
		}
		MilestoneComparator milestoneComparator = new MilestoneComparator();
		Collections.sort(milestoneInfoVOList, milestoneComparator);
		return milestoneInfoVOList;
	}
	
    public static String creatDateStr(int month, int day){
    	String retMonthStr = null;
    	String retDayStr = null;
    	if(month < 10){
    		retMonthStr = "0" + month;
    	} else{
    		retMonthStr = String.valueOf(month);
    	}
    	if(day < 10){
    		retDayStr = "0" + day;
    	}else{
    		retDayStr = String.valueOf(day);
    	}
    	return retMonthStr + "/" + retDayStr;
    }
    
    public static boolean isLeapYear(int year){
		if (year % 400 == 0) {
			return true;
		} else if ((year % 100 != 0) && (year % 4 == 0)) {
			return true;
		} else {
			return false;
		}
    }
    
    public static String getPcode(int projectCount){
    	int projectIndex = projectCount + 1;
    	String strProjectIndex = StringUtils.leftPad(String.valueOf(projectIndex), 3, "0");
    	int year = Calendar.getInstance().get(Calendar.YEAR);
    	return year + strProjectIndex;
    }
    
    public static Map<String,List<Role>> getRoleMap(List<Role> roleList){
    	if(roleList.size() == 0){
    		return null;
    	}
    	Map<String,List<Role>> retMap = new HashMap<String, List<Role>>();
    	for (Role role : roleList) {
    		String roleType = role.getRoletype();
    		if(!retMap.containsKey(roleType)){
    			retMap.put(roleType, new ArrayList<Role>());
    		}
    		retMap.get(roleType).add(role);
		}
    	return retMap;
    }

}

class MilestoneComparator implements Comparator<MilestoneInfo> {

	public int compare(MilestoneInfo arg0, MilestoneInfo arg1) {
		int flag = arg0.getMsPlanDate().compareTo(arg1.getMsPlanDate());
		return flag;
	}

}
