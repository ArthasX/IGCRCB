/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2401BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2401DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2401Form;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2401CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2401VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2402VO;

/**
 * 概述:事件平均解决时间统计BL 
 */
public class IGCRC24BLImpl extends BaseBLImpl implements IGCRC24BL {
	
	/**事件平均解决时间BL*/
	protected IGCRC2401BL igcrc2401bl;

	public IGCRC2401BL getIgcrc2401bl() {
		return igcrc2401bl;
	}

	public void setIgcrc2401bl(IGCRC2401BL igcrc2401bl) {
		this.igcrc2401bl = igcrc2401bl;
	}

	public IGCRC2401DTO getFindStatistics(IGCRC2401DTO dto) {
		// TODO Auto-generated method stub
		
		IGCRC2401Form form = dto.getIgcrc2401Form();
		
		IGCRC2401CondImpl cond = new IGCRC2401CondImpl();
		//添加查询条件  年
		cond.setYear(form.getYear());
		//添加查询条件 月
		cond.setMonth(form.getMonth());
		//添加查询条件 部门
		cond.setDept(form.getDept());
		
		cond.setSign(form.getSign());
		//值放到DTO
		dto.setCond(cond);
		//查询结果集合
		List<IGCRC2401VW> igcrc2401vwList = igcrc2401bl.igcrc2401vwList(cond);

		//页面显示的数据
		List<IGCRC2402VO> igcrc2402voList = new ArrayList<IGCRC2402VO>();
		if(null != igcrc2401vwList && igcrc2401vwList.size() != 0){
			
			//第一条数据的userId 和 名字
			String initialUserId = igcrc2401vwList.get(0).getUserId();
			String initialName = igcrc2401vwList.get(0).getUserName();
			//时间和对象
			IGCRC2402VO timeSum = new IGCRC2402VO();
			Integer pridNUM = 0;
			//循环
			for (int i = 0 ; i < igcrc2401vwList.size(); i ++) {
				IGCRC2401VW igcrc2401vw = igcrc2401vwList.get(i);
				//判断userId是否相同 相同则相加
				if(initialUserId.equals(igcrc2401vw.getUserId())){
					pridNUM++;
					//计算时间和
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTime(igcrc2401vw) , pridNUM ,igcrc2401vw.getPrid());
				}else if(!initialUserId.equals(igcrc2401vw.getUserId())){//不同重新初始化userid
					//userid第一次不同时(即在计算下一个人员时) 将timeSum添加到List中
					pridNUM = 1;
					igcrc2402voList.add(new IGCRC2402VO(timeSum, initialUserId, initialName));
					initialUserId = igcrc2401vw.getUserId();
					initialName = igcrc2401vw.getUserName();
					//初始化时间和对象
					timeSum = new IGCRC2402VO();
					//计算第一个userid不同的时间和
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTime(igcrc2401vw),pridNUM,igcrc2401vw.getPrid());
					
				}
				if(i == (igcrc2401vwList.size() - 1)){
					//结束时(即将最后一个人员) 将timeSum添加到List中
					igcrc2402voList.add(new IGCRC2402VO(timeSum, igcrc2401vw.getUserId(),igcrc2401vw.getUserName()));
				}
			}
		}
		dto.setIgcrc2402voList(igcrc2402voList);
		return dto;
	}
	
	/**	
	 * 功能：计算时间和 保存到对象中
	 * @param 时间和对象
	 * @param 等级
	 * @param 时间差
	 * @return 时间和对象
	 * 修改记录：null 	
	 */	
	private IGCRC2402VO getTimeSum(IGCRC2402VO timeSum, String gradeStr, Long time , Integer pridNUM , Integer prid ){
		int grade = 0;
		timeSum.setPridNUM(pridNUM);
		
		if(StringUtils.isNotBlank(timeSum.getPrid_In())){
			timeSum.setPrid_In(timeSum.getPrid_In() + "," + prid);
		}else if(prid != null){
			timeSum.setPrid_In(prid.toString());
		}
		if("Ⅰ".equals(gradeStr)){
			grade = 1;
		}else if("Ⅱ".equals(gradeStr)){
			grade = 2;
		}else if("Ⅲ".equals(gradeStr)){
			grade = 3;
		}else if("Ⅳ".equals(gradeStr)){
			grade = 4;
		}else if("Ⅴ".equals(gradeStr)){
			grade = 5;
		}
		//判断每个类别所得的时间平均数
		switch (grade) {
		case 1:
			timeSum.setGrade1(timeSum.getGrade1() + time);
			timeSum.setGrade1Count(timeSum.getGrade1Count() + 1);
			break;
		case 2:
			timeSum.setGrade2(timeSum.getGrade2() + time);
			timeSum.setGrade2Count(timeSum.getGrade2Count() + 1);
			break;
		case 3:
			timeSum.setGrade3(timeSum.getGrade3() + time);
			timeSum.setGrade3Count(timeSum.getGrade3Count() + 1);
			break;
		case 4:
			timeSum.setGrade4(timeSum.getGrade4() + time);
			timeSum.setGrade4Count(timeSum.getGrade4Count() + 1);
			break;
		case 5:
			timeSum.setGrade5(timeSum.getGrade5() + time);
			timeSum.setGrade5Count(timeSum.getGrade5Count() + 1);
			break;
		case 6:
			timeSum.setGrade6(timeSum.getGrade6() + time);
			timeSum.setGrade6Count(timeSum.getGrade6Count() + 1);
			break;
		case 7:
			timeSum.setGrade7(timeSum.getGrade7() + time);
			timeSum.setGrade7Count(timeSum.getGrade7Count() + 1);
			break;
		case 8:
			timeSum.setGrade8(timeSum.getGrade8() + time);
			timeSum.setGrade8Count(timeSum.getGrade8Count() + 1);
			break;

		default:
			break;
		}
		return timeSum;
	}
	
	/**	
	 * 功能：计算时间差 单位:分钟
	 * @param igcrc2401vw
	 * @return 时间差
	 * 修改记录：null 	
	 */	
	private Long getTime(IGCRC2401VW igcrc2401vw){
		//开始时间
		Date startTime = null;
		//结束事件
		Date endTime=null;
		//格式化
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//获得起始和结束时间
		try {
			endTime = df.parse(igcrc2401vw.getEndTime() + ":00");
			startTime = df.parse(igcrc2401vw.getStartTime() + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//返回时间差 单位:分钟
		return (endTime.getTime() - startTime.getTime()) / 60000;
	}
	

	
	/***
	 *  计算平均值
	 *  zhangqiang
	 *  zhangq@deliverik.com
	 *  2014-12-24
	 * @param dto
	 * @return
	 */
	public IGCRC2401DTO getFindStatisticsConfirm(IGCRC2401DTO dto) {
		// TODO Auto-generated method stub
		
		IGCRC2401Form form = dto.getIgcrc2401Form();
		
		IGCRC2401CondImpl cond = new IGCRC2401CondImpl();
		//添加查询条件  年
		cond.setYear(form.getYear());
		//添加查询条件 月
		cond.setMonth(form.getMonth());
		//添加查询条件 部门
		cond.setDept(form.getDept());
		
		cond.setSign(form.getSign());
		//值放到DTO
		dto.setCond(cond);
		//查询结果集合
		List<IGCRC2401VW> igcrc2401vwList = igcrc2401bl.igcrc2401vwListConfirm(cond);

		//页面显示的数据
		List<IGCRC2402VO> igcrc2402voList = new ArrayList<IGCRC2402VO>();
		if(null != igcrc2401vwList && igcrc2401vwList.size() != 0){
			
			//第一条数据的userId 和 名字
			String initialUserId = igcrc2401vwList.get(0).getUserId();
			String initialName = igcrc2401vwList.get(0).getUserName();
			Integer pridNUM = 0;
			//时间和对象
			IGCRC2402VO timeSum = new IGCRC2402VO();
			//循环
			for (int i = 0 ; i < igcrc2401vwList.size(); i ++) {
				IGCRC2401VW igcrc2401vw = igcrc2401vwList.get(i);
				//判断userId是否相同 相同则相加
				if(initialUserId.equals(igcrc2401vw.getUserId())){
					pridNUM ++ ;
					//计算时间和
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTimeConfirm(igcrc2401vw),pridNUM , igcrc2401vw.getPrid());
				}else if(!initialUserId.equals(igcrc2401vw.getUserId())){//不同重新初始化userid
					pridNUM = 1;
					//userid第一次不同时(即在计算下一个人员时) 将timeSum添加到List中
					igcrc2402voList.add(new IGCRC2402VO(timeSum, initialUserId, initialName));
					initialUserId = igcrc2401vw.getUserId();
					initialName = igcrc2401vw.getUserName();
					//初始化时间和对象
					timeSum = new IGCRC2402VO();
					//计算第一个userid不同的时间和
					timeSum = getTimeSum(timeSum, igcrc2401vw.getGrade(), getTimeConfirm(igcrc2401vw),pridNUM ,igcrc2401vw.getPrid());
					
				}
				if(i == (igcrc2401vwList.size() - 1)){
					//结束时(即将最后一个人员) 将timeSum添加到List中
					igcrc2402voList.add(new IGCRC2402VO(timeSum, igcrc2401vw.getUserId(),igcrc2401vw.getUserName()));
				}
			}
		}
		dto.setIgcrc2402voList(igcrc2402voList);
		return dto;
	}
	
	
	
	
	/**	
	 * 功能：计算时间差 单位:分钟
	 * @param igcrc2401vw
	 * @return 时间差
	 * @time  2014-12-24 
	 * @auth  zhangq@deliverik.com
	 * 修改记录：null 	
	 */	
	private Long getTimeConfirm(IGCRC2401VW igcrc2401vw){
		//开始时间
		Date startTime = null;
		//结束事件
		Date endTime=null;
		//格式化
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//获得起始和结束时间
		try {
			endTime = df.parse(igcrc2401vw.getConfirmtime() + ":00");
			startTime = df.parse(igcrc2401vw.getStartTime() + ":00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//返回时间差 单位:分钟
		return (endTime.getTime() - startTime.getTime()) / 60000;
	}

	

}
