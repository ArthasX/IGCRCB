/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.bl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2201BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2201DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2201Form;
import com.deliverik.infogovernor.crc.model.IGCRC2201VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2201CondImpl;
import com.deliverik.infogovernor.crc.vo.IGCRC2202VO;

/**	
 * 概述:变更总体统计逻辑接口实现
 * 创建记录：yukexin    2014-8-15 下午5:11:24	
 * 修改记录：null
 */	
public class IGCRC22BLImpl extends BaseBLImpl implements IGCRC22BL {

	static Log log = LogFactory.getLog(IGCRC22BLImpl.class);

	/** 变更总体统计BL接口 */
	protected IGCRC2201BL igcrc2201BL;

	public IGCRC2201BL getIgcrc2201BL() {
		return igcrc2201BL;
	}

	public void setIgcrc2201BL(IGCRC2201BL igcrc2201bl) {
		igcrc2201BL = igcrc2201bl;
	}



	/**
	 * 变更总体统计查询处理
	 * 
	 * @param igcrc22dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC2201DTO searchEntityItemAction(IGCRC2201DTO dto) throws BLException {

		log.debug("==============================变更总体统计查询开始==============================");
		IGCRC2201Form form = dto.getIgcrc2201Form();
		IGCRC2201CondImpl cond = new IGCRC2201CondImpl();
		//查询条件放入cond
		cond = copyProperties(form, cond);
		//查询数据
		List<IGCRC2201VWInfo> list = igcrc2201BL.searchIncidentTypeData(cond);
		IGCRC2202VO igcrc2202vo = null;
		@SuppressWarnings("serial")
		//分类类型初始化
		Map<String, String> typeMap = new HashMap<String, String>(){
			{
				put("110001","系统网络类");
				put("110002","应用程序类");
				put("110003","项目类");
				put("110004","数据类");
			}
		};
		//数字格式化方法
		NumberFormat nf = NumberFormat.getPercentInstance();
		//小数点1位
		nf.setMaximumFractionDigits(1);
		//通过率
		double pass = 0;
		//成功率
		double success = 0;
		//返回的List
		List<IGCRC2202VO> igcrc2202voList = new ArrayList<IGCRC2202VO>();
		//将查询的数据计算之后存入并返回
		for (IGCRC2201VWInfo igcrc2201vwInfo : list) {
			//如果带数据项小于4个执行
			if(list.size() < 4){
				//循环设定好的map
				for(Map.Entry<String, String> entry : typeMap.entrySet()){
					//如果查出的数据中与设定好的map typeId相同 则将其值 置空,作为标志
					if(igcrc2201vwInfo.getTypeId().equals(entry.getKey())){
						entry.setValue("");
					}
				}
			}
			//数据复制
			igcrc2202vo = new IGCRC2202VO();
			igcrc2202vo.setTypeId(igcrc2201vwInfo.getTypeId());
			igcrc2202vo.setTypeName(igcrc2201vwInfo.getTypeName());
			igcrc2202vo.setPassnum(igcrc2201vwInfo.getPassnum());
			igcrc2202vo.setSuccessnum(igcrc2201vwInfo.getSuccessnum());
			igcrc2202vo.setTotalnum(igcrc2201vwInfo.getTotalnum());
			//计算通过率
			pass = new Double(igcrc2201vwInfo.getPassnum())/igcrc2201vwInfo.getTotalnum();
			//不是0 则格式化
			igcrc2202vo.setPassrate(pass == 0 ? "0" : nf.format(pass));
			//计算成功率
			success = new Double(igcrc2201vwInfo.getSuccessnum())/igcrc2201vwInfo.getTotalnum();
			//不是0 则格式化
			igcrc2202vo.setSuccessrate(success == 0 ? "0" : nf.format(success));
			igcrc2202voList.add(igcrc2202vo);
		}
		//如果带数据项小于4个执行
		if(list.size() < 4){
			//添加空数据项
			for(Map.Entry<String, String> entry : typeMap.entrySet()){
				//如果值不为空添加此项
				if(!"".equals(entry.getValue())){
					igcrc2202voList.add(new IGCRC2202VO(entry.getKey(), entry.getValue(), 0, 0, "0", 0, "0"));
				}
			}
		}
		//数据按typeId排序
		Collections.sort(igcrc2202voList, new Comparator<IGCRC2202VO>() {
			public int compare(IGCRC2202VO o1, IGCRC2202VO o2) {
				return new Integer(Integer.parseInt(o1.getTypeId()))
						.compareTo(Integer.parseInt(o2.getTypeId()));
			}
		});
		dto.setIgcrc2202voList(igcrc2202voList);
		log.debug("==============================变更总体统计查询结束==============================");
		return dto;
	}

	/**	
	 * 功能：将form中的查询条件赋给cond
	 * @param form 页面查询条件
	 * @param cond 检索条件
	 * @return
	 * 修改记录：
	 */	
	private IGCRC2201CondImpl copyProperties(IGCRC2201Form form, IGCRC2201CondImpl cond){
		//年
		cond.setYear(form.getYear());
		//月
		cond.setMonth(form.getMonth());
		return cond;
	}
}
