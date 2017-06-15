/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2001BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2001DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2001Form;
import com.deliverik.infogovernor.crc.model.IGCRC2001VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2001CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2001VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2002VO;

/**
 * 概述:导出年度工作统计BL 
 */
public class IGCRC20BLImpl extends BaseBLImpl implements IGCRC20BL {
	
	/**年度统计BL*/
	protected IGCRC2001BL igcrc2001bl;

	public IGCRC2001BL getIgcrc2001bl() {
		return igcrc2001bl;
	}

	public void setIgcrc2001bl(IGCRC2001BL igcrc2001bl) {
		this.igcrc2001bl = igcrc2001bl;
	}
	
	/**按年份查询各类工作数量*/
	public IGCRC2001DTO getFindStatistics(IGCRC2001DTO dto) {
		// TODO Auto-generated method stub

		IGCRC2001Form form = dto.getIgcrc2001Form();

		IGCRC2001CondImpl cond = new IGCRC2001CondImpl();
		//添加查询条件 年
		cond.setYear(form.getYear());
		//查询条件放到DTO里
		dto.setCond(cond);
		//存储列合计List
		List<Integer> sumList = new ArrayList<Integer>();
		//查询结果存到List中
		List<IGCRC2001VWInfo> list = igcrc2001bl.list(cond);
		List<IGCRC2002VO> igcrc2002voList = new ArrayList<IGCRC2002VO>();
		IGCRC2001VW igcrc2001vw = null;
		//月份初始化
		Map<String, String> monthMap = new LinkedHashMap<String, String>(){
			{
				put("1","01");
				put("2","02");
				put("3","03");
				put("4","04");
				put("5","05");
				put("6","06");
				put("7","07");
				put("8","08");
				put("9","09");
				put("10","10");
				put("11","11");
				put("12","12");
			}
		};
		//事件合计
		Integer incidentNum = 0;
		//问题合计
		Integer problemNum = 0;
		//变更合计
		Integer changeNum = 0;
		//科技服务请求合计
		Integer serviceNum = 0;
		//程序开发合计
		Integer sfNum = 0;
		//合计
		Integer total = 0;
		//计算行的合计
		for (int i = 0; i < list.size(); i++) {
			igcrc2001vw = (IGCRC2001VW) list.get(i);
			//如果月份是0开头 去掉0
			if(igcrc2001vw.getPropentime().matches("0\\d")){
				igcrc2001vw.setPropentime(igcrc2001vw.getPropentime().replace("0", ""));
			}
			//如果月份小于12个月
			if(list.size() < 12){
				//循环设定好的map
				for(Map.Entry<String, String> entry : monthMap.entrySet()){
					//如果数据中有此月份 月相同 则将其值 置空,作为标志
					if(igcrc2001vw.getPropentime().equals(entry.getKey())){
						entry.setValue("");
					}
				}
			}
			//计算行合计
			Integer sum = (igcrc2001vw.getIncidentnum()
					+ igcrc2001vw.getProblemnum() + igcrc2001vw.getChangenum()
					+ igcrc2001vw.getServicenum() + igcrc2001vw.getSfnum());
			//计算列合计
			incidentNum += igcrc2001vw.getIncidentnum();
			problemNum += igcrc2001vw.getProblemnum();
			changeNum += igcrc2001vw.getChangenum();
			serviceNum += igcrc2001vw.getServicenum();
			sfNum += igcrc2001vw.getSfnum();
			total += sum;
			//行合计结果填充到集合中
			igcrc2002voList.add(new IGCRC2002VO(igcrc2001vw, sum));
		}
		//将列的合计填充到sumList中
		sumList.add(incidentNum);
		sumList.add(problemNum);
		sumList.add(changeNum);
		sumList.add(serviceNum);
		sumList.add(sfNum);
		sumList.add(total);
		
		//添加空数据项
		for(Map.Entry<String, String> entry : monthMap.entrySet()){
			//如果值不为空添加此项
			if(!"".equals(entry.getValue())){
				igcrc2002voList.add(new IGCRC2002VO(entry.getKey(), 0, 0, 0, 0, 0, 0));
			}
		}
		//数据按月份排序
		Collections.sort(igcrc2002voList, new Comparator<IGCRC2002VO>() {
			public int compare(IGCRC2002VO vo1, IGCRC2002VO vo2) {
				return new Integer(Integer.parseInt(vo1.getPropentime()))
						.compareTo(Integer.parseInt(vo2.getPropentime()));
			}
		});
		
		//保存到DTO
		dto.setIgcrc2002voList(igcrc2002voList);
		dto.setSumList(sumList);
		
		return dto;
	}

}
