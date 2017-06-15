/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.soc.dbs.bl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_CXVWInfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Dir_DaVWInfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Dir_FibreVWInfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Dir_RfbVWInfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_DisksVWInfoBL;
import com.deliverik.infogovernor.soc.dbs.bl.task.Collect_Symmetrix_InfoBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_BehindInterfaceCardVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_CXVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_DaVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_FibreVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Dir_RfbVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_DisksVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_FrontInterfaceCardVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_BusySearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_BehindInterfaceCardVW;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_CXVW;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_DisksVW;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_FrontInterfaceCardVW;

/**
 * @概述SOC EMC运维存储管理性能总图BL
 * @功能描述 包含前端CPU 前端端口 后端CPU 后端端口 磁盘DISK
 * 
 * @创建记录：杨亮 2011/01/06
 * @修改记录：崔龙 2011/08/08
 * @version 1.0
 */

public class IGDBS02BLImpl extends BaseBLImpl implements IGDBS02BL {

	static Log log = LogFactory.getLog(IGDBS02BLImpl.class);

	private Collect_Dir_FibreVWInfoBL collect_Dir_FibreVWInfoBL;
	private Collect_Dir_DaVWInfoBL collect_Dir_DaVWInfoBL;
	private Collect_DisksVWInfoBL collect_DisksVWInfoBL;
	private Collect_Dir_RfbVWInfoBL collect_Dir_RfbVWInfoBL;
	private Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL;

	private Collect_CXVWInfoBL collect_CXVWInfoBL;

	public void setCollect_Symmetrix_InfoBL(
			Collect_Symmetrix_InfoBL collect_Symmetrix_InfoBL) {
		this.collect_Symmetrix_InfoBL = collect_Symmetrix_InfoBL;
	}

	public List<Collect_Dir_FibreVWInfo> findFrontCPUBusy(
			final Collect_BusySearchCond cond, final int start, final int count) {

		List<Collect_Dir_FibreVWInfo> frontCPUBusy = collect_Dir_FibreVWInfoBL
				.findByCond(cond, start, count);

		return frontCPUBusy;
	}

	public List<Collect_Dir_DaVWInfo> findBehindCPUBusy(
			Collect_BusySearchCond cond, int start, int count) {
		List<Collect_Dir_DaVWInfo> behindCPUBusy = collect_Dir_DaVWInfoBL
				.findByCond(cond, start, count);
		return behindCPUBusy;
	}

	public List<Collect_DisksVWInfo> findDisksBusy(Collect_BusySearchCond cond,
			int start, int count) {
		List<Collect_DisksVWInfo> disksBusy = collect_DisksVWInfoBL.findByCond(
				cond, start, count);
		return disksBusy;
	}

	public List<Collect_Dir_RfbVWInfo> findFrontCPUBusy2(
			Collect_BusySearchCond cond, int start, int count) {
		List<Collect_Dir_RfbVWInfo> frontCPUBusy2 = collect_Dir_RfbVWInfoBL
				.findByCond(cond, start, count);
		return frontCPUBusy2;
	}

	/**
	 * 获取全部磁盘名称
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Collect_DisksVWInfo> findDisksDeviceName (
			Collect_BusySearchCond cond, int start, int count) throws BLException{
		List<Collect_DisksVWInfo> disksDeviceNames = collect_DisksVWInfoBL
				.findDisksDeviceName(cond, start, count);
		return disksDeviceNames;
	}

	public String createXml(Collect_BusySearchCond cond) throws BLException{

		List<Collect_Dir_RfbVWInfo> frontCPUBusy2 = findFrontCPUBusy2(cond, 0,
				0);
		List<Collect_DisksVWInfo> disksBusy = findDisksBusy(cond, 0, 0);
		List<Collect_Dir_FibreVWInfo> frontCPUBusy = findFrontCPUBusy(cond, 0,
				0);
		List<Collect_Dir_DaVWInfo> behindCPUBusy = findBehindCPUBusy(cond, 0, 0);
		List<Collect_BehindInterfaceCardVWInfo> behindCard = getBehindInterfaceCardVWInfo(behindCPUBusy);
		List<Collect_FrontInterfaceCardVWInfo> frontCard = getFrontInterfaceCardVWInfo(
				frontCPUBusy, frontCPUBusy2) ;
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";

		/**
		 * 前端CPU
		 */
		for (int i = 0; i < frontCPUBusy2.size(); i++) {
			BigDecimal busy = frontCPUBusy2.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			String show = frontCPUBusy2.get(i).getDirector_number();
			String director_number = show;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (show.contains("RF-")) {
					director_number = show.substring(3);
				}
			}else{
				if(!show.contains("RF-")){
					director_number="RF-"+show;
				}
			}
			
			content = content + "<UNIT useper ='" + busy + "' data_times = '"
					+ frontCPUBusy2.get(i).getSymtime() + "' show='" + director_number
					+ "'>" + director_number + "</UNIT>";
		}
		/**
		 * 前端CPU最后
		 */
		for (int i = 0; i < frontCPUBusy.size(); i++) {
			BigDecimal busy = frontCPUBusy.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			String show = frontCPUBusy.get(i).getDirector_number();
			String director_number = show;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (show.contains("FA-")) {
					director_number = show.substring(3);
				}
			}else{
				if (!show.contains("FA-")) {
					director_number = "FA-"+show;
				}
			}
			content = content + "<UNIT useper ='" + busy + "' data_times = '"
					+ frontCPUBusy.get(i).getSymtime() + "' show='" + director_number
					+ "'>" + director_number + "</UNIT>";
		}
		/**
		 * 前端端口
		 */
		for (int i = 0; i < frontCard.size(); i++) {
			BigDecimal busy = frontCard.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			String show = frontCard.get(i).getDirector_number();
			String director_number = show;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (show.contains("FA-")) {
					director_number = show.substring(3);
				}
			}else{
				if (!show.contains("FA-")) {
					director_number = "FA-"+show;
				}
			}
			content = content + "<UNIT useper ='" + busy
					+ "' data_times = '' show='" + director_number + "'>"
					+ director_number + "</UNIT>";
		}
		/**
		 * DISK
		 */
		for (int i = 0; i < disksBusy.size(); i++) {
			BigDecimal busy = disksBusy.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			// "16A 0xD6"前6位改为 16AD6 后七位改为 16进制数
			String director_number = disksBusy.get(i).getDirector_number();
			String[] nums = director_number.split("0x");
			// 以0x分割后组合
			String num1 = nums[0].trim();
			String num2 = nums[1].trim();
			// String num3 = num2.substring(0,1);
			// String num4 =
			// Integer.toHexString(Integer.parseInt(num2.substring(1))).toUpperCase();
			// director_number = num1+num3+num4;
			// if(num1.contains("DF-")){
			// director_number = num1.substring(3)+num3+num4;
			// }
			director_number = num1 + num2;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (num1.contains("DF-")) {
					director_number = num1.substring(3) + num2;
				}
			}else{
				if (!num1.contains("DF-")) {
					director_number ="DF-"+ num1 + num2;
				}
			}
			// 修改为直接用原来的名称。show == director_number;
			content = content + "<UNIT useper ='" + busy + "' data_times = '"
					+ disksBusy.get(i).getSymtime() + "' show='" + director_number + "'>"
					+ director_number + "</UNIT>";
		}
		/**
		 * 后端CPU
		 */
		for (int i = 0; i < behindCPUBusy.size(); i++) {
			BigDecimal busy = behindCPUBusy.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			String show = behindCPUBusy.get(i).getDirector_number();
			String director_number = show;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (show.contains("DF-")) {
					director_number = show.substring(3);
				}
			}else{
				if (!show.contains("DF-")) {
					director_number ="DF-"+ show;
				}
			}
			content = content + "<UNIT useper ='" + busy + "' data_times = '"
					+ behindCPUBusy.get(i).getSymtime() + "' show='" + director_number
					+ "'>" + director_number + "</UNIT>";
		}
		/**
		 * 后端端口
		 */
		for (int i = 0; i < behindCard.size(); i++) {
			BigDecimal busy = behindCard.get(i).getSysBusy();
			if (busy.compareTo(BigDecimal.ZERO) == -1) {
				busy = BigDecimal.ZERO;
			}
			String show = behindCard.get(i).getDirector_number();
			String director_number = show;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (show.contains("DF-")) {
					director_number = show.substring(3);
				}
			}else{
				if (!show.contains("DF-")) {
					director_number ="DF-"+ show;
				}
			}
			content = content + "<UNIT useper ='" + busy
					+ "' data_times = '' show='" + director_number + "'>"
					+ director_number + "</UNIT>";
		}
		content = content + "<DATAID>" + cond.getDataid() + "</DATAID>";
		String date_from = cond.getDate_from() == null ? "" : cond
				.getDate_from().substring(0, 10);
		String date_to = cond.getDate_to() == null ? "" : cond.getDate_to()
				.substring(0, 10);
		content = content + "<DATEFROM>" + date_from + "</DATEFROM>";
		content = content + "<DATETO>" + date_to + "</DATETO>";
		content = content + "</ROOT>";

		// System.out.println(frontCPUBusy2.size());
		// System.out.println(disksBusy.size());
		// System.out.println(frontCPUBusy.size());
		// System.out.println(behindCPUBusy.size());

		return content;
	}

	public Collect_CXVWInfoBL getCollect_CXVWInfoBL() {
		return collect_CXVWInfoBL;
	}

	public void setCollect_CXVWInfoBL(Collect_CXVWInfoBL collect_CXVWInfoBL) {
		this.collect_CXVWInfoBL = collect_CXVWInfoBL;
	}

	public Collect_Dir_FibreVWInfoBL getCollect_Dir_FibreVWInfoBL() {
		return collect_Dir_FibreVWInfoBL;
	}

	public void setCollect_Dir_FibreVWInfoBL(
			Collect_Dir_FibreVWInfoBL collect_Dir_FibreVWInfoBL) {
		this.collect_Dir_FibreVWInfoBL = collect_Dir_FibreVWInfoBL;
	}

	public Collect_Dir_DaVWInfoBL getCollect_Dir_DaVWInfoBL() {
		return collect_Dir_DaVWInfoBL;
	}

	public void setCollect_Dir_DaVWInfoBL(
			Collect_Dir_DaVWInfoBL collect_Dir_DaVWInfoBL) {
		this.collect_Dir_DaVWInfoBL = collect_Dir_DaVWInfoBL;
	}

	public Collect_DisksVWInfoBL getCollect_DisksVWInfoBL() {
		return collect_DisksVWInfoBL;
	}

	public void setCollect_DisksVWInfoBL(
			Collect_DisksVWInfoBL collect_DisksVWInfoBL) {
		this.collect_DisksVWInfoBL = collect_DisksVWInfoBL;
	}

	public Collect_Dir_RfbVWInfoBL getCollect_Dir_RfbVWInfoBL() {
		return collect_Dir_RfbVWInfoBL;
	}

	public void setCollect_Dir_RfbVWInfoBL(
			Collect_Dir_RfbVWInfoBL collect_Dir_RfbVWInfoBL) {
		this.collect_Dir_RfbVWInfoBL = collect_Dir_RfbVWInfoBL;
	}

	/**
	 * 取后端端口使用率
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<Collect_BehindInterfaceCardVWInfo> getBehindInterfaceCardVWInfo(
			List<Collect_Dir_DaVWInfo> behindCPUBusy) throws BLException{

		List<Collect_BehindInterfaceCardVWInfo> card = new ArrayList<Collect_BehindInterfaceCardVWInfo>();
		Map<String, List<BigDecimal>> map = new HashMap<String, List<BigDecimal>>();
		for (int i = 0; i < behindCPUBusy.size(); i++) {
			Collect_Dir_DaVWInfo info = behindCPUBusy.get(i);
			String director_number = info.getDirector_number().substring(0, 2);
			if (info.getDirector_number().contains("DF-")) {
				director_number = info.getDirector_number().substring(3, 5);
			}
			if (!map.containsKey(director_number)) {
				List<BigDecimal> busy = new ArrayList<BigDecimal>();
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			} else {
				List<BigDecimal> busy = map.get(director_number);
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			Collect_BehindInterfaceCardVW cardInfo = new Collect_BehindInterfaceCardVW();
			String director_number = iterator.next().toString();
			cardInfo.setDirector_number(director_number);
			List<BigDecimal> busy = map.get(director_number);
			BigDecimal cardBusy = BigDecimal.ZERO;
			for (int i = 0; i < busy.size(); i++) {
				cardBusy = cardBusy.add(busy.get(i));
			}
			if (busy.size() > 0) {
				cardBusy = cardBusy.divide(new BigDecimal(busy.size()),
						MathContext.DECIMAL32);
				cardInfo.setSysBusy(cardBusy);
			}
			card.add(cardInfo);
		}
		return card;
	}

	/**
	 * 取前端端口使用率
	 * 
	 * @param behindCPUBusy
	 * @return
	 */
	public List<Collect_FrontInterfaceCardVWInfo> getFrontInterfaceCardVWInfo (
			List<Collect_Dir_FibreVWInfo> frontCPUBusy,
			List<Collect_Dir_RfbVWInfo> frontCPUBusy2) throws BLException{

		List<Collect_FrontInterfaceCardVWInfo> card = new ArrayList<Collect_FrontInterfaceCardVWInfo>();
		Map<String, List<BigDecimal>> map = new HashMap<String, List<BigDecimal>>();
		for (int i = 0; i < frontCPUBusy.size(); i++) {
			Collect_Dir_FibreVWInfo info = frontCPUBusy.get(i);
			String director_number = info.getDirector_number().substring(0, 2);
			if (info.getDirector_number().contains("FA-")) {
				director_number = info.getDirector_number().substring(3, 5);
			}
			if (!map.containsKey(director_number)) {
				List<BigDecimal> busy = new ArrayList<BigDecimal>();
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			} else {
				List<BigDecimal> busy = map.get(director_number);
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			}
		}
		for (int i = 0; i < frontCPUBusy2.size(); i++) {
			Collect_Dir_RfbVWInfo info = frontCPUBusy2.get(i);
			String director_number = info.getDirector_number().substring(0, 2);
			if (info.getDirector_number().contains("RF-")) {
				director_number = info.getDirector_number().substring(3, 5);
			}
			if (!map.containsKey(director_number)) {
				List<BigDecimal> busy = new ArrayList<BigDecimal>();
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			} else {
				List<BigDecimal> busy = map.get(director_number);
				busy.add(info.getSysBusy());
				map.put(director_number, busy);
			}
		}
		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			Collect_FrontInterfaceCardVW cardInfo = new Collect_FrontInterfaceCardVW();
			String director_number = iterator.next().toString();
			cardInfo.setDirector_number(director_number);
			List<BigDecimal> busy = map.get(director_number);
			BigDecimal cardBusy = BigDecimal.ZERO;
			for (int i = 0; i < busy.size(); i++) {
				cardBusy = cardBusy.add(busy.get(i));
			}
			if (busy.size() > 0) {
				cardBusy = cardBusy.divide(new BigDecimal(busy.size()),
						MathContext.DECIMAL32);
				cardInfo.setSysBusy(cardBusy);
			}
			card.add(cardInfo);
		}
		return card;
	}

	/**
	 * 第一次进入不查询数据库
	 * 
	 * @return
	 */
	public String initXml(Collect_BusySearchCond cond) throws BLException{
		String content = "<?xml version=1.0 encoding=UTF-8?><ROOT>";
		content = content + "<DATAID>" + cond.getDataid() + "</DATAID>";
		String date_from = cond.getDate_from() == null ? "" : cond
				.getDate_from().substring(0, 10);
		String date_to = cond.getDate_to() == null ? "" : cond.getDate_to()
				.substring(0, 10);
		content = content + "<DATEFROM>" + date_from + "</DATEFROM>";
		content = content + "<DATETO>" + date_to + "</DATETO>";
		List<Collect_DisksVWInfo> disksName = collect_DisksVWInfoBL
				.findDisksDeviceName(cond, 0, 0);

		/**
		 * DISK
		 */
		for (int i = 0; i < disksName.size(); i++) {
			BigDecimal busy = disksName.get(i).getSysBusy();
			busy = BigDecimal.valueOf(-10);
			// "16A 0xD6"前6位改为 16AD6 后七位改为 16进制数
			String director_number = disksName.get(i).getDirector_number();
			String[] nums = director_number.split("0x");
			// 以0x分割后组合
			String num1 = nums[0].trim();
			String num2 = nums[1].trim();
			// String num3 = num2.substring(0,1);
			// String num4 =
			// Integer.toHexString(Integer.parseInt(num2.substring(1))).toUpperCase();
			// director_number = num1+num3+num4;
			// if(num1.contains("DF-")){
			// director_number = num1.substring(3)+num3+num4;
			// }
			director_number = num1 + num2;
			if(StringUtils.isNotEmpty(cond.getSymm_model())&&"DMX4-24".equals(cond.getSymm_model())){
				if (num1.contains("DF-")) {
					director_number = num1.substring(3) + num2;
				}
			}else{
				if (!num1.contains("DF-")) {
					director_number ="DF-"+ num1 + num2;
				}
			}
			// 修改为直接用原来的名称。show == director_number;
			content = content + "<UNIT useper ='" + busy + "' data_times = '"
					+ disksName.get(i).getSymtime() + "' show='" + director_number + "'>"
					+ director_number + "</UNIT>";
		}
		content = content + "</ROOT>";
		return content;
	}

	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(0);
		System.out.println(a.compareTo(BigDecimal.ZERO));

		String[] nums = "5A 0xD26".split("0x");
		// 以0x分割后组合
		String num1 = nums[0].trim();
		String num2 = nums[1].trim();
		String num3 = num2.substring(0, 1);
		String num4 = Integer.toHexString(Integer.parseInt(num2.substring(1)))
				.toUpperCase();
		String director_number = num1 + num3 + num4;

		System.out.println(director_number);
		System.out.println(Integer.toHexString(
				Integer.parseInt("16A 0xD29".substring(7))).toUpperCase());
		System.out.println(Integer.toHexString(
				Integer.parseInt("16A 0xD16".substring(7))).toUpperCase());
	}


	/**
	 * <p>[功能描述]</p>
	 * @comment 第一次 查询CX性能总图 查询数据库
	 * @author	Administrator, 2011-8-8
	 * @param cond
	 * @return
	 */
	public String initCXXml(Collect_BusySearchCond cond) throws BLException{
		int iNumber_CX = 0;
		int iLength = 0;

		StringBuffer sb_CX = new StringBuffer("");
		String busItemString = null;
		String EnclosureItem = null;
		
		List<String> lstBus = new ArrayList<String>();
		List<String> lstEnclosure = new ArrayList<String>();
		
		//开始拼写生成的xml文件
		sb_CX.append("<?xml version='1.0' encoding='UTF-8'?>");
		sb_CX.append("<ROOT>");
		sb_CX.append("<DATAID>");
		sb_CX.append(cond.getDataid());
		sb_CX.append("</DATAID>");
		String date_from = cond.getDate_from() == null ? "" : cond
				.getDate_from().substring(0, 10);
		String date_to = cond.getDate_to() == null ? "" : cond.getDate_to()
				.substring(0, 10);
		sb_CX.append("<DATEFROM>");
		sb_CX.append(date_from);
		sb_CX.append("</DATEFROM>");
		sb_CX.append("<DATETO>").append(date_to).append("</DATETO>");
		
		List<Collect_CXVWInfo> lstProtName = collect_CXVWInfoBL
				.CX_findProtDeviceName(cond, 0, 0);
		// 获取CX_Prot
		if (lstProtName != null) {
			for (iNumber_CX = 0, iLength = lstProtName.size(); iNumber_CX < iLength; iNumber_CX++) {
				Collect_CXVW collect_ProtVW = (Collect_CXVW) lstProtName
						.get(iNumber_CX);
				sb_CX.append("<faportItem ");
				sb_CX.append("show='");
				sb_CX.append(collect_ProtVW.getObject_Name());
				sb_CX.append("' />");
			}
		}

		//获取CX_SP
		sb_CX.append("<spItem ");
		sb_CX.append("show='SP A'");
		sb_CX.append("/>");
		sb_CX.append("<spItem ");
		sb_CX.append("show='SP B'");
		sb_CX.append("/>");

		//从数据库中查询Disk的集合
		List<Collect_DisksVWInfo> lstDisksName = collect_DisksVWInfoBL
		.CX_findDisksDeviceName(cond, 0, 0);
		if (lstDisksName != null) {
			for (iNumber_CX = 0, iLength = lstDisksName.size(); iNumber_CX < lstDisksName
					.size(); iNumber_CX++) {
				Collect_DisksVW collect_DisksVW = (Collect_DisksVW) lstDisksName
						.get(iNumber_CX);
				// 取得唯一的bus
				String objectName = collect_DisksVW.getObject_Name();
				String[] nums = objectName.split("_");
				busItemString = nums[0].trim();

				// 过滤相同的数据
				if (!lstBus.contains(busItemString)) {
					lstBus.add(busItemString);
				}
				// 获取CX_EnclosureItem
				String[] numElItem = collect_DisksVW.getObject_Name()
						.split("_");
				String num1 = numElItem[0].trim();
				String num2 = numElItem[1].trim();
				EnclosureItem = num1 + "_" + num2;

				if (!lstEnclosure.contains(EnclosureItem)) {
					lstEnclosure.add(EnclosureItem);
				}

				// 获取CX_Disks
				sb_CX.append("<diskItem ");
				sb_CX.append("show='");
				sb_CX.append(collect_DisksVW.getObject_Name());
				sb_CX.append("' />");
			}

			// 获取CX_BUS
			for (iNumber_CX = 0, iLength = lstBus.size(); iNumber_CX < lstBus
					.size(); iNumber_CX++) {
				sb_CX.append("<busItem  show='BUS_");
				sb_CX.append(lstBus.get(iNumber_CX));
				sb_CX.append("' />");
			}

			//获取CX_EnclosureItem
			for (iNumber_CX = 0, iLength = lstEnclosure.size(); iNumber_CX < lstEnclosure
					.size(); iNumber_CX++) {
				sb_CX.append("<EnclosureItem show='");
				sb_CX.append(lstEnclosure.get(iNumber_CX));
				sb_CX.append("' />");
			}
		}
		sb_CX.append("</ROOT>");
		return sb_CX.toString();
	}

	/**
	 * <p>[功能描述]</p>
	 * @comment 第二次 查询CX性能总图 查询数据库
	 * @author	Administrator, 2011-8-8
	 * @param cond
	 * @return
	 */
	@SuppressWarnings("unused")
	public String createXml_cx(Collect_BusySearchCond cond)  throws BLException{
		int iNumber_CX = 0;
		int iLength = 0;
		//从数据库中获取Prot的集合
		List<Collect_CXVWInfo> lstProtName = collect_CXVWInfoBL
				.findProtByCond_CX(cond, 0, 0);
        //从数据库中获取Disk的集合
		List<Collect_DisksVWInfo> lstDisksName = collect_DisksVWInfoBL
				.findDisksByCond_CX(cond, 0, 0);
		//从数据库中获取Sp的集合
		List<Collect_CXVWInfo> lstSP = collect_CXVWInfoBL.findSPByCond_CX(cond,
				0, 0);
		//开始拼写xml文件
		StringBuffer sb_CX = new StringBuffer("");
		sb_CX.append("<?xml version='1.0' encoding='UTF-8'?>");
		String date_from = cond.getDate_from() == null ? "" : cond
				.getDate_from().substring(0, 10);
		String date_to = cond.getDate_to() == null ? "" : cond.getDate_to()
				.substring(0, 10);
		sb_CX.append("<ROOT>");
		sb_CX.append("<DATAID>");
		sb_CX.append(cond.getDataid());
		sb_CX.append("</DATAID>");
		sb_CX.append("<DATEFROM>");
		sb_CX.append(date_from);
		sb_CX.append("</DATEFROM>");
		sb_CX.append("<DATETO>");
		sb_CX.append(date_to);
		sb_CX.append("</DATETO>");

		// CX_Prot使用率
		if (lstProtName != null) {
			for (iNumber_CX = 0, iLength = lstProtName.size(); iNumber_CX < lstProtName
					.size(); iNumber_CX++) {
				Collect_CXVW collect_ProtVW = (Collect_CXVW) lstProtName
						.get(iNumber_CX);
				BigDecimal busy = lstProtName.get(iNumber_CX).getSysBusy();
				if (busy.compareTo(BigDecimal.ZERO) == -1) {
					busy = BigDecimal.ZERO;
				}
				sb_CX.append("<UNIT show='");
				sb_CX.append(collect_ProtVW.getDirector_number() + "' useper='"
						+ busy + "' data_times = '"
						+ lstProtName.get(iNumber_CX).getSymtime());
				sb_CX.append("'/>");
			}
		}

		// CX_SP使用率
		if (lstSP != null) {
			for (iNumber_CX = 0, iLength = lstSP.size(); iNumber_CX < lstSP
					.size(); iNumber_CX++) {
				Collect_CXVW collect_ProtVW = (Collect_CXVW) lstSP
						.get(iNumber_CX);
				BigDecimal busy = lstSP.get(iNumber_CX).getSysBusy();
				if (busy.compareTo(BigDecimal.ZERO) == -1) {
					busy = BigDecimal.ZERO;
				}
				sb_CX.append("<UNIT show='");
				sb_CX.append(collect_ProtVW.getDirector_number() + "' useper="
						+ "'" + busy + "' data_times = '"
						+ lstSP.get(iNumber_CX).getSymtime());
				sb_CX.append("'/>");
			}
		}

		// CX_Disks使用率
		if (lstDisksName != null) {
			for (iNumber_CX = 0, iLength = lstDisksName.size(); iNumber_CX < lstDisksName
					.size(); iNumber_CX++) {
				Collect_DisksVW collect_DisksVW = (Collect_DisksVW) lstDisksName
						.get(iNumber_CX);
				BigDecimal busy = lstDisksName.get(iNumber_CX).getSysBusy();
				if (busy.compareTo(BigDecimal.ZERO) == -1) {
					busy = BigDecimal.ZERO;
				}
				String diskItem = collect_DisksVW.getDirector_number();
				sb_CX.append("<UNIT show='");
				sb_CX.append(diskItem + "' useper=" + "'" + busy
						+ "' data_times = '"
						+ lstDisksName.get(iNumber_CX).getSymtime());
				sb_CX.append("'/>");
			}
		}
		sb_CX.append("</ROOT>");
		return sb_CX.toString();
	}
	
	/**
	 * 取得DMX存储的微码版本
	 */
	public String getSymm_version(String symm_id) throws BLException{
		String symm_version = "";
		Collect_Symmetrix_InfoSearchCondImpl cond = new Collect_Symmetrix_InfoSearchCondImpl();
		cond.setSymm_id(symm_id);
		List<Collect_Symmetrix_Info> lstCollect_Symmetrix_Info = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(cond,0,0);
		if(lstCollect_Symmetrix_Info != null && lstCollect_Symmetrix_Info.size() >0){
			symm_version = lstCollect_Symmetrix_Info.get(0).getSymm_version();
		}
		return symm_version;
	}
	
	/**
	 * 取得DMX存储的型号
	 */
	public String getSymm_model(String symm_id) throws BLException{
		String symm_model = "";
		Collect_Symmetrix_InfoSearchCondImpl cond = new Collect_Symmetrix_InfoSearchCondImpl();
		cond.setSymm_id(symm_id);
		List<Collect_Symmetrix_Info> lstCollect_Symmetrix_Info = collect_Symmetrix_InfoBL.findCollect_Symmetrix_InfoByCond(cond,0,0);
		if(lstCollect_Symmetrix_Info != null && lstCollect_Symmetrix_Info.size() >0){
			symm_model = lstCollect_Symmetrix_Info.get(0).getSymm_model();
		}
		return symm_model;
	}
}
