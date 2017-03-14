/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.prj.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.write.Label;
import jxl.Sheet;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.infogovernor.prj.model.InvestUseInfoVW;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0101ExcelDTO;

/**
 * 概述:投资使用情况报表导出实现 功能描述：投资使用情况报表导出实现 创建人：王廷志 创建记录： 2012-5-22 修改记录：
 */
public class IGPRJ0101ExcelBLImpl extends ExcelBaseBLImpl implements
		IGPRJ0101ExcelBL {

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// 获取数据
		IGPRJ0101ExcelDTO dataDTO = (IGPRJ0101ExcelDTO) dto;
		List<CodeDetail> ppqCodeList = dataDTO.getPpqCodeList();
		List<CodeDetail> ptypeCodeList = dataDTO.getPtypeCodeList();
		Map<String, String> ppqCodeMap = new HashMap<String, String>();
		Map<String, String> ptypeCodeMap = new HashMap<String, String>();
		if (ppqCodeList != null && ppqCodeList.size() > 0) {
			for (CodeDetail code : ppqCodeList) {
				ppqCodeMap.put(code.getCid(), code.getCvalue());
			}
		}
		if (ptypeCodeList != null && ptypeCodeList.size() > 0) {
			for (CodeDetail code : ptypeCodeList) {
				ptypeCodeMap.put(code.getCid(), code.getCvalue());
			}
		}
		List<InvestUseInfoVW> investList = dataDTO.getInvestUseInfoList();
		// 处理数据
		// ppqualityClassify key 项目性质 value 该项目性质下所有项目组成的map
		Map<String, Map<String, List<InvestUseInfoVW>>> ppqualityClassify = new HashMap<String, Map<String, List<InvestUseInfoVW>>>();
		// 如果数据部为空，对数据进行处理
		if (investList != null && investList.size() > 0) {
			// 遍历数据集合
			for (InvestUseInfoVW invest : investList) {
				// 如果当前项目性质分类map还没有该项目性质记录，则添加该分类
				if (ppqualityClassify.get(invest.getPpquality()) == null) {
					Map<String, List<InvestUseInfoVW>> ptypeClassify = new HashMap<String, List<InvestUseInfoVW>>();
					List<InvestUseInfoVW> dataList = new ArrayList<InvestUseInfoVW>();
					dataList.add(invest);
					ptypeClassify.put(invest.getPtype(), dataList);
					ppqualityClassify.put(invest.getPpquality(), ptypeClassify);
					// 如果已经存在该分类
				} else {
					// 如果该分类下不存在该项目类型匪类，则添加相应分类并放置当前数据
					if (ppqualityClassify.get(invest.getPpquality()).get(
							invest.getPtype()) == null) {
						List<InvestUseInfoVW> dataList = new ArrayList<InvestUseInfoVW>();
						dataList.add(invest);
						ppqualityClassify.get(invest.getPpquality()).put(
								invest.getPtype(), dataList);
						// 如果该分类下存在该项目分类，直接添加当前数据
					} else {
						ppqualityClassify.get(invest.getPpquality())
								.get(invest.getPtype()).add(invest);
					}
				}
			}
		}
		// 计算项目类型级别的总计金额
		Map<String, Map<String, Map<String, Double>>> ppqsum = new HashMap<String, Map<String, Map<String, Double>>>();
		if (ppqualityClassify != null && ppqualityClassify.keySet() != null
				&& ppqualityClassify.keySet().size() > 0) {
			for (String ppClas : ppqualityClassify.keySet()) {
				Map<String, List<InvestUseInfoVW>> temp = ppqualityClassify
						.get(ppClas);
				if (temp != null && temp.keySet() != null
						&& temp.keySet().size() > 0) {
					Map<String, Map<String, Double>> ptypesum = new HashMap<String, Map<String, Double>>();
					for (String ptypeClas : temp.keySet()) {
						List<InvestUseInfoVW> list = temp.get(ptypeClas);
						if (list != null && list.size() > 0) {
							double ltotal = 0;
							double ltotalctsum = 0;
							double ltotalcssum = 0;
							double ltotal1 = 0;
							double ltotal2 = 0;
							double ltotal3 = 0;
							double ltotal4 = 0;
							double ltotal5 = 0;
							double ltotal6 = 0;
							double ltotal7 = 0;

							double bztotal = 0;
							double bztotalctsum = 0;
							double bztotalcssum = 0;
							double bztotal1 = 0;
							double bztotal2 = 0;
							double bztotal3 = 0;
							double bztotal4 = 0;
							double bztotal5 = 0;
							double bztotal6 = 0;
							double bztotal7 = 0;

							double ptotal = 0;
							double ptotalctsum = 0;
							double ptotalcssum = 0;
							double ptotal1 = 0;
							double ptotal2 = 0;
							double ptotal3 = 0;
							double ptotal4 = 0;
							double ptotal5 = 0;
							double ptotal6 = 0;
							double ptotal7 = 0;
							
							double fktotal = 0;
							double fktotalctsum = 0;
							double fktotalcssum = 0;
							double fktotal1 = 0;
							double fktotal2 = 0;
							double fktotal3 = 0;
							double fktotal4 = 0;
							double fktotal5 = 0;
							double fktotal6 = 0;
							double fktotal7 = 0;
							for (InvestUseInfoVW invest : list) {
								ltotal += invest.getLtotal() == null ? 0: invest.getLtotal();
								ltotalctsum+=invest.getLtotalctsum()==null?0:invest.getLtotalctsum();
								ltotalcssum+=invest.getLtotalcssum()==null?0:invest.getLtotalcssum();
								ltotal1 += invest.getLtotal1() == null ? 0: invest.getLtotal1();
								ltotal2 += invest.getLtotal2() == null ? 0: invest.getLtotal2();
								ltotal3 += invest.getLtotal3() == null? 0: invest.getLtotal3();
								ltotal4 += invest.getLtotal4() == null? 0: invest.getLtotal4();
								ltotal5 += invest.getLtotal5() == null? 0: invest.getLtotal5();
								ltotal6 += invest.getLtotal6() == null? 0: invest.getLtotal6();
								ltotal7 += invest.getLtotal7() == null? 0: invest.getLtotal7();

								bztotal += invest.getBztotal() == null ? 0: invest.getBztotal();
								bztotalctsum += invest.getBztotalctsum() == null ? 0:invest.getBztotalctsum();
								bztotalcssum += invest.getBztotalctsum() == null ? 0:invest.getBztotalcssum();
								bztotal1 += invest.getBztotal1() == null ? 0: invest.getBztotal1();
								bztotal2 += invest.getBztotal2() == null ? 0: invest.getBztotal2();
								bztotal3 += invest.getBztotal3() == null ? 0: invest.getBztotal3();
								bztotal4 += invest.getBztotal4() == null ? 0: invest.getBztotal4();
								bztotal5 += invest.getBztotal5() == null ? 0: invest.getBztotal5();
								bztotal6 += invest.getBztotal6() == null ? 0: invest.getBztotal6();
								bztotal7 += invest.getBztotal7() == null ? 0: invest.getBztotal7();

								ptotal += invest.getPtotal() == null ? 0: invest.getPtotal();
								ptotalctsum += invest.getPtotalctsum() == null ? 0:invest.getPtotalctsum();
								ptotalcssum += invest.getPtotalcssum() == null ? 0:invest.getPtotalcssum();
								ptotal1 += invest.getPtotal1() == null ? 0: invest.getPtotal1();
								ptotal2 += invest.getPtotal2() == null ? 0: invest.getPtotal2();
								ptotal3 += invest.getPtotal3() == null ? 0: invest.getPtotal3();
								ptotal4 += invest.getPtotal4() == null ? 0: invest.getPtotal4();
								ptotal5 += invest.getPtotal5() == null ? 0: invest.getPtotal5();
								ptotal6 += invest.getPtotal6() == null ? 0: invest.getPtotal6();
								ptotal7 += invest.getPtotal7() == null ? 0: invest.getPtotal7();
								
								fktotal+= invest.getFktotal() == null ? 0: invest.getFktotal();
								if(invest.getFktotal().equals(invest.getLtotal())){
									fktotalctsum+=invest.getLtotalctsum()==null?0:invest.getLtotalctsum();
									fktotalcssum+=invest.getLtotalcssum()==null?0:invest.getLtotalcssum();
									fktotal1 += invest.getLtotal1() == null ? 0: invest.getLtotal1();
									fktotal2 += invest.getLtotal2() == null ? 0: invest.getLtotal2();
									fktotal3 += invest.getLtotal3() == null? 0: invest.getLtotal3();
									fktotal4 += invest.getLtotal4() == null? 0: invest.getLtotal4();
									fktotal5 += invest.getLtotal5() == null? 0: invest.getLtotal5();
									fktotal6 += invest.getLtotal6() == null? 0: invest.getLtotal6();
									fktotal7 += invest.getLtotal7() == null? 0: invest.getLtotal7();
								}
							}
							Map<String, Double> sumMap = new HashMap<String, Double>();
							sumMap.put("ltotal", ltotal);
							sumMap.put("ltotalctsum", ltotalctsum);
							sumMap.put("ltotalcssum", ltotalcssum);
							sumMap.put("ltotal1", ltotal1);
							sumMap.put("ltotal2", ltotal2);
							sumMap.put("ltotal3", ltotal3);
							sumMap.put("ltotal4", ltotal4);
							sumMap.put("ltotal5", ltotal5);
							sumMap.put("ltotal6", ltotal6);
							sumMap.put("ltotal7", ltotal7);

							sumMap.put("bztotal", bztotal);
							sumMap.put("bztotalctsum", bztotalctsum);
							sumMap.put("bztotalcssum", bztotalcssum);
							sumMap.put("bztotal1", bztotal1);
							sumMap.put("bztotal2", bztotal2);
							sumMap.put("bztotal3", bztotal3);
							sumMap.put("bztotal4", bztotal4);
							sumMap.put("bztotal5", bztotal5);
							sumMap.put("bztotal6", bztotal6);
							sumMap.put("bztotal7", bztotal7);

							sumMap.put("ptotal", ptotal);
							sumMap.put("ptotalctsum", ptotalctsum);
							sumMap.put("ptotalcssum", ptotalcssum);
							sumMap.put("ptotal1", ptotal1);
							sumMap.put("ptotal2", ptotal2);
							sumMap.put("ptotal3", ptotal3);
							sumMap.put("ptotal4", ptotal4);
							sumMap.put("ptotal5", ptotal5);
							sumMap.put("ptotal6", ptotal6);
							sumMap.put("ptotal7", ptotal7);
							
							sumMap.put("fktotal", fktotal);
							sumMap.put("fktotalctsum", fktotalctsum);
							sumMap.put("fktotalcssum", fktotalcssum);
							sumMap.put("fktotal1", fktotal1);
							sumMap.put("fktotal2", fktotal2);
							sumMap.put("fktotal3", fktotal3);
							sumMap.put("fktotal4", fktotal4);
							sumMap.put("fktotal5", fktotal5);
							sumMap.put("fktotal6", fktotal6);
							sumMap.put("fktotal7", fktotal7);
							ptypesum.put(ptypeClas, sumMap);
						}
					}
					ppqsum.put(ppClas, ptypesum);
				}
			}
		}
		// 计算项目性质级别的总计金额
		Map<String, Map<String, Double>> datasum = new HashMap<String, Map<String, Double>>();
		if (ppqsum != null && ppqsum.keySet() != null
				&& ppqsum.keySet().size() > 0) {
			for (String ppClas : ppqsum.keySet()) {
				Map<String, Map<String, Double>> temp = ppqsum.get(ppClas);
				if (temp != null && temp.keySet() != null
						&& temp.keySet().size() > 0) {
					Map<String, Double> tempMap = new HashMap<String, Double>();
					double ltotal = 0;
					double ltotalctsum = 0;
					double ltotalcssum = 0;
					double ltotal1 = 0;
					double ltotal2 = 0;
					double ltotal3 = 0;
					double ltotal4 = 0;
					double ltotal5 = 0;
					double ltotal6 = 0;
					double ltotal7 = 0;

					double bztotal = 0;
					double bztotalctsum = 0;
					double bztotalcssum = 0;
					double bztotal1 = 0;
					double bztotal2 = 0;
					double bztotal3 = 0;
					double bztotal4 = 0;
					double bztotal5 = 0;
					double bztotal6 = 0;
					double bztotal7 = 0;

					double ptotal = 0;
					double ptotalctsum = 0;
					double ptotalcssum = 0;
					double ptotal1 = 0;
					double ptotal2 = 0;
					double ptotal3 = 0;
					double ptotal4 = 0;
					double ptotal5 = 0;
					double ptotal6 = 0;
					double ptotal7 = 0;
					
					double fktotal = 0;
					double fktotalctsum = 0;
					double fktotalcssum = 0;
					double fktotal1 = 0;
					double fktotal2 = 0;
					double fktotal3 = 0;
					double fktotal4 = 0;
					double fktotal5 = 0;
					double fktotal6 = 0;
					double fktotal7 = 0;
					
					for (String ptypeClas : temp.keySet()) {
						ltotal += ppqsum.get(ppClas).get(ptypeClas).get("ltotal") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal");
						ltotalctsum += ppqsum.get(ppClas).get(ptypeClas).get("ltotalctsum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotalctsum");
						ltotalcssum += ppqsum.get(ppClas).get(ptypeClas).get("ltotalcssum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotalcssum");
						ltotal1 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal1") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal1");
						ltotal2 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal2") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal2");
						ltotal3 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal3") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal3");
						ltotal4 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal4") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal4");
						ltotal5 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal5") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal5");
						ltotal6 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal6") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal6");
						ltotal7 += ppqsum.get(ppClas).get(ptypeClas).get("ltotal7") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ltotal7");

						bztotal += ppqsum.get(ppClas).get(ptypeClas).get("bztotal") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal");
						bztotalctsum += ppqsum.get(ppClas).get(ptypeClas).get("bztotalctsum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotalctsum");
						bztotalcssum += ppqsum.get(ppClas).get(ptypeClas).get("bztotalcssum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotalcssum");
						bztotal1 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal1") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal1");
						bztotal2 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal2") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal2");
						bztotal3 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal3") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal3");
						bztotal4 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal4") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal4");
						bztotal5 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal5") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal5");
						bztotal6 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal6") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal6");
						bztotal7 += ppqsum.get(ppClas).get(ptypeClas).get("bztotal7") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("bztotal7");

						ptotal += ppqsum.get(ppClas).get(ptypeClas).get("ptotal") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal");
						ptotalctsum += ppqsum.get(ppClas).get(ptypeClas).get("ptotalctsum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotalctsum");
						ptotalcssum += ppqsum.get(ppClas).get(ptypeClas).get("ptotalcssum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotalcssum");
						ptotal1 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal1") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal1");
						ptotal2 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal2") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal2");
						ptotal3 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal3") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal3");
						ptotal4 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal4") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal4");
						ptotal5 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal5") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal5");
						ptotal6 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal6") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal6");
						ptotal7 += ppqsum.get(ppClas).get(ptypeClas).get("ptotal7") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("ptotal7");
						
						fktotal += ppqsum.get(ppClas).get(ptypeClas).get("fktotal") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal");
						fktotalctsum += ppqsum.get(ppClas).get(ptypeClas).get("fktotalctsum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotalctsum");
						fktotalcssum += ppqsum.get(ppClas).get(ptypeClas).get("fktotalcssum") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotalcssum");
						fktotal1 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal1") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal1");
						fktotal2 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal2") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal2");
						fktotal3 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal3") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal3");
						fktotal4 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal4") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal4");
						fktotal5 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal5") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal5");
						fktotal6 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal6") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal6");
						fktotal7 += ppqsum.get(ppClas).get(ptypeClas).get("fktotal7") == null ? 0 : ppqsum.get(ppClas).get(ptypeClas).get("fktotal7");
					}
					tempMap.put("ltotal", ltotal);
					tempMap.put("ltotalctsum", ltotalctsum);
					tempMap.put("ltotalcssum", ltotalcssum);
					tempMap.put("ltotal1", ltotal1);
					tempMap.put("ltotal2", ltotal2);
					tempMap.put("ltotal3", ltotal3);
					tempMap.put("ltotal4", ltotal4);
					tempMap.put("ltotal5", ltotal5);
					tempMap.put("ltotal6", ltotal6);
					tempMap.put("ltotal7", ltotal7);

					tempMap.put("bztotal", bztotal);
					tempMap.put("bztotalctsum", bztotalctsum);
					tempMap.put("bztotalcssum", bztotalcssum);
					tempMap.put("bztotal1", bztotal1);
					tempMap.put("bztotal2", bztotal2);
					tempMap.put("bztotal3", bztotal3);
					tempMap.put("bztotal4", bztotal4);
					tempMap.put("bztotal5", bztotal5);
					tempMap.put("bztotal6", bztotal6);
					tempMap.put("bztotal7", bztotal7);

					tempMap.put("ptotal", ptotal);
					tempMap.put("ptotalctsum", ptotalctsum);
					tempMap.put("ptotalcssum", ptotalcssum);
					tempMap.put("ptotal1", ptotal1);
					tempMap.put("ptotal2", ptotal2);
					tempMap.put("ptotal3", ptotal3);
					tempMap.put("ptotal4", ptotal4);
					tempMap.put("ptotal5", ptotal5);
					tempMap.put("ptotal6", ptotal6);
					tempMap.put("ptotal7", ptotal7);
					
					tempMap.put("fktotal", fktotal);
					tempMap.put("fktotalctsum", fktotalctsum);
					tempMap.put("fktotalcssum", fktotalcssum);
					tempMap.put("fktotal1", fktotal1);
					tempMap.put("fktotal2", fktotal2);
					tempMap.put("fktotal3", fktotal3);
					tempMap.put("fktotal4", fktotal4);
					tempMap.put("fktotal5", fktotal5);
					tempMap.put("fktotal6", fktotal6);
					tempMap.put("fktotal7", fktotal7);
					datasum.put(ppClas, tempMap);
				}
			}
		}
		// 写入excel
		dto.setStartRow(6);
		int index = 0;
		if (ppqualityClassify.keySet() != null
				&& ppqualityClassify.keySet().size() > 0) {
			for (String ppqClas : ppqualityClassify.keySet()) {
				Map<String, List<InvestUseInfoVW>> temp = ppqualityClassify
						.get(ppqClas);
				if (temp != null && temp.keySet() != null
						&& temp.keySet().size() > 0) {
					addCell(0, index, "", Colour.YELLOW);
					addCell(1, index, ppqCodeMap.get(ppqClas), Colour.YELLOW);
					addCell(2, index, "", Colour.YELLOW);
					addCell(3, index, "", Colour.YELLOW);
					addCell(4, index, "", Colour.YELLOW);
					addCell(5, index, "", Colour.YELLOW);
					addCell(6, index, datasum.get(ppqClas).get("bztotal"), Colour.YELLOW);
					addCell(7, index, datasum.get(ppqClas).get("bztotalctsum"), Colour.YELLOW);
					addCell(8, index, datasum.get(ppqClas).get("bztotal1"), Colour.YELLOW);
					addCell(9, index, datasum.get(ppqClas).get("bztotal2"), Colour.YELLOW);
					addCell(10, index, datasum.get(ppqClas).get("bztotal3"), Colour.YELLOW);
					addCell(11, index, datasum.get(ppqClas).get("bztotal4"), Colour.YELLOW);
					addCell(12, index, datasum.get(ppqClas).get("bztotal5"), Colour.YELLOW);
					addCell(13, index, datasum.get(ppqClas).get("bztotalcssum"), Colour.YELLOW);
					addCell(14, index, datasum.get(ppqClas).get("bztotal6"), Colour.YELLOW);
					addCell(15, index, datasum.get(ppqClas).get("bztotal7"), Colour.YELLOW);
					
					addCell(16, index, datasum.get(ppqClas).get("ptotal"), Colour.YELLOW);
					addCell(17, index, datasum.get(ppqClas).get("ptotalctsum"), Colour.YELLOW);
					addCell(18, index, datasum.get(ppqClas).get("ptotal1"), Colour.YELLOW);
					addCell(19, index, datasum.get(ppqClas).get("ptotal2"), Colour.YELLOW);
					addCell(20, index, datasum.get(ppqClas).get("ptotal3"), Colour.YELLOW);
					addCell(21, index, datasum.get(ppqClas).get("ptotal4"), Colour.YELLOW);
					addCell(22, index, datasum.get(ppqClas).get("ptotal5"), Colour.YELLOW);
					addCell(23, index, datasum.get(ppqClas).get("ptotalcssum"), Colour.YELLOW);
					addCell(24, index, datasum.get(ppqClas).get("ptotal6"), Colour.YELLOW);
					addCell(25, index, datasum.get(ppqClas).get("ptotal7"), Colour.YELLOW);
					addCell(26, index, "", Colour.YELLOW);
					addCell(27, index, datasum.get(ppqClas).get("ltotal"), Colour.YELLOW);
					addCell(28, index, datasum.get(ppqClas).get("ltotalctsum"), Colour.YELLOW);
					addCell(29, index, datasum.get(ppqClas).get("ltotal1"), Colour.YELLOW);
					addCell(30, index, datasum.get(ppqClas).get("ltotal2"), Colour.YELLOW);
					addCell(31, index, datasum.get(ppqClas).get("ltotal3"), Colour.YELLOW);
					addCell(32, index, datasum.get(ppqClas).get("ltotal4"), Colour.YELLOW);
					addCell(33, index, datasum.get(ppqClas).get("ltotal5"), Colour.YELLOW);
					addCell(34, index, datasum.get(ppqClas).get("ltotalcssum"), Colour.YELLOW);
					addCell(35, index, datasum.get(ppqClas).get("ltotal6"), Colour.YELLOW);
					addCell(36, index, datasum.get(ppqClas).get("ltotal7"), Colour.YELLOW);
					addCell(37, index, "", Colour.YELLOW);
					addCell(38, index, datasum.get(ppqClas).get("fktotal"), Colour.YELLOW);
					addCell(39, index, datasum.get(ppqClas).get("fktotalctsum"), Colour.YELLOW);
					addCell(40, index, datasum.get(ppqClas).get("fktotal1"), Colour.YELLOW);
					addCell(41, index, datasum.get(ppqClas).get("fktotal2"), Colour.YELLOW);
					addCell(42, index, datasum.get(ppqClas).get("fktotal3"), Colour.YELLOW);
					addCell(43, index, datasum.get(ppqClas).get("fktotal4"), Colour.YELLOW);
					addCell(44, index, datasum.get(ppqClas).get("fktotal5"), Colour.YELLOW);
					addCell(45, index, datasum.get(ppqClas).get("fktotalcssum"), Colour.YELLOW);
					addCell(46, index, datasum.get(ppqClas).get("fktotal6"), Colour.YELLOW);
					addCell(47, index, datasum.get(ppqClas).get("fktotal7"), Colour.YELLOW);
					addCell(48, index, "", Colour.YELLOW);
					index++;
					for (String ptypeClas : temp.keySet()) {
						List<InvestUseInfoVW> list = temp.get(ptypeClas);
						if (list != null && list.size() > 0) {
							int idx = 1;
							addCell(0, index, "",Colour.LIGHT_ORANGE);
							addCell(1, index, "",Colour.LIGHT_ORANGE);
							addCell(2, index, ptypeCodeMap.get(ptypeClas),Colour.LIGHT_ORANGE);
							addCell(3, index, "",Colour.LIGHT_ORANGE);
							addCell(4, index, "",Colour.LIGHT_ORANGE);
							addCell(5, index, "",Colour.LIGHT_ORANGE);
							
							addCell(6, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal"),Colour.LIGHT_ORANGE);
							addCell(7, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotalctsum"),Colour.LIGHT_ORANGE);
							addCell(8, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal1"),Colour.LIGHT_ORANGE);
							addCell(9, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal2"),Colour.LIGHT_ORANGE);
							addCell(10, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal3"),Colour.LIGHT_ORANGE);
							addCell(11, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal4"),Colour.LIGHT_ORANGE);
							addCell(12, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal5"),Colour.LIGHT_ORANGE);
							addCell(13, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotalcssum"),Colour.LIGHT_ORANGE);
							addCell(14, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal6"),Colour.LIGHT_ORANGE);
							addCell(15, index, ppqsum.get(ppqClas).get(ptypeClas).get("bztotal7"),Colour.LIGHT_ORANGE);
							
							addCell(16, index, ppqsum.get(ppqClas).get(ptypeClas).get("ptotal"),Colour.LIGHT_ORANGE);
							addCell(17, index, ppqsum.get(ppqClas).get(ptypeClas).get("ptotalctsum"),Colour.LIGHT_ORANGE);
							addCell(18,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal1"),Colour.LIGHT_ORANGE);
							addCell(19,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal2"),Colour.LIGHT_ORANGE);
							addCell(20,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal3"),Colour.LIGHT_ORANGE);
							addCell(21,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal4"),Colour.LIGHT_ORANGE);
							addCell(22,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal5"),Colour.LIGHT_ORANGE);
							addCell(23, index, ppqsum.get(ppqClas).get(ptypeClas).get("ptotalcssum"),Colour.LIGHT_ORANGE);
							addCell(24,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal6"),Colour.LIGHT_ORANGE);
							addCell(25,index,ppqsum.get(ppqClas).get(ptypeClas).get("ptotal7"),Colour.LIGHT_ORANGE);
							addCell(26, index, "",Colour.LIGHT_ORANGE);
							
							addCell(27,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal"),Colour.LIGHT_ORANGE);
							addCell(28,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotalctsum"),Colour.LIGHT_ORANGE);
							addCell(29,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal1"),Colour.LIGHT_ORANGE);
							addCell(30,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal2"),Colour.LIGHT_ORANGE);
							addCell(31,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal3"),Colour.LIGHT_ORANGE);
							addCell(32,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal4"),Colour.LIGHT_ORANGE);
							addCell(33,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal5"),Colour.LIGHT_ORANGE);
							addCell(34,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotalcssum"),Colour.LIGHT_ORANGE);
							addCell(35,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal6"),Colour.LIGHT_ORANGE);
							addCell(36,index,ppqsum.get(ppqClas).get(ptypeClas).get("ltotal7"),Colour.LIGHT_ORANGE);
							addCell(37, index, "",Colour.LIGHT_ORANGE);
							addCell(38, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal"),Colour.LIGHT_ORANGE);
							addCell(39, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotalctsum"),Colour.LIGHT_ORANGE);
							addCell(40, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal1"),Colour.LIGHT_ORANGE);
							addCell(41, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal2"),Colour.LIGHT_ORANGE);
							addCell(42, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal3"),Colour.LIGHT_ORANGE);
							addCell(43, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal4"),Colour.LIGHT_ORANGE);
							addCell(44, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal5"),Colour.LIGHT_ORANGE);
							addCell(45, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotalcssum"),Colour.LIGHT_ORANGE);
							addCell(46, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal6"),Colour.LIGHT_ORANGE);
							addCell(47, index, ppqsum.get(ppqClas).get(ptypeClas).get("fktotal7"),Colour.LIGHT_ORANGE);
							addCell(48, index, "",Colour.LIGHT_ORANGE);
							index++;
							for (InvestUseInfoVW invest : list) {
								addCell(0, index, idx);
								addCell(1, index, "");
								addCell(2, index, ptypeCodeMap.get(ptypeClas));
								addCell(3, index, invest.getPstorecode());
								addCell(4, index, invest.getPname());
								addCell(5, index, invest.getPpurpose());
								addCell(6, index,invest.getBztotal() == null ? 0:invest.getBztotal());
								addCell(7, index,invest.getBztotalctsum() == null ? 0:invest.getBztotalctsum());
								addCell(8, index,invest.getBztotal1() == null ? 0:invest.getBztotal1());
								addCell(9, index,invest.getBztotal2() == null ? 0:invest.getBztotal2());
								addCell(10, index,invest.getBztotal3() == null ? 0:invest.getBztotal3());
								addCell(11, index,invest.getBztotal4() == null ? 0:invest.getBztotal4());
								addCell(12, index,invest.getBztotal5() == null ? 0:invest.getBztotal5());
								addCell(13, index,invest.getBztotalcssum() == null ? 0:invest.getBztotalcssum());
								addCell(14, index,invest.getBztotal6() == null ? 0:invest.getBztotal6());
								addCell(15, index,invest.getBztotal7() == null ? 0:invest.getBztotal7());
								
								addCell(16,index,invest.getPtotal() == null ? 0 : invest.getPtotal());
								addCell(17,index,invest.getPtotalctsum() == null ? 0 : invest.getPtotalctsum());
								addCell(18, index,invest.getPtotal1() == null ? 0:invest.getPtotal1());
								addCell(19, index,invest.getPtotal2() == null ? 0:invest.getPtotal2());
								addCell(20, index,invest.getPtotal3() == null ? 0:invest.getPtotal3());
								addCell(21, index,invest.getPtotal4() == null ? 0:invest.getPtotal4());
								addCell(22, index,invest.getPtotal5() == null ? 0:invest.getPtotal5());
								addCell(23,index,invest.getPtotalcssum() == null ? 0 : invest.getPtotalcssum());
								addCell(24, index,invest.getPtotal6() == null ? 0:invest.getPtotal6());
								addCell(25, index,invest.getPtotal7() == null ? 0:invest.getPtotal7());
								addCell(26, index, invest.getPdesc());
								addCell(27,index,invest.getLtotal() == null ? 0 : invest.getLtotal());
								addCell(28,index,invest.getLtotalctsum() == null ? 0 : invest.getLtotalctsum());
								addCell(29, index,invest.getLtotal1() == null ? 0: invest.getLtotal1());
								addCell(30, index,invest.getLtotal2() == null ? 0: invest.getLtotal2());
								addCell(31, index,invest.getLtotal3() == null ? 0: invest.getLtotal3());
								addCell(32, index,invest.getLtotal4() == null ? 0: invest.getLtotal4());
								addCell(33, index,invest.getLtotal5() == null ? 0: invest.getLtotal5());
								addCell(34,index,invest.getLtotalcssum() == null ? 0 : invest.getLtotalcssum());
								addCell(35, index,invest.getLtotal6() == null ? 0: invest.getLtotal6());
								addCell(36, index,invest.getLtotal7() == null ? 0: invest.getLtotal7());
								String str = invest.getTerm();
								String[] strs = str.split(",");
								String data = "";
								for (int i = 0; i < strs.length; i++) {
									if (strs[i] != null && (!strs.equals(""))) {
										if (data.equals("")) {
											data = strs[i];
										} else {
											data += ("," + strs[i]);
										}
									}
								}
								addCell(37, index, data);
								addCell(38, index,invest.getFktotal() == null ? 0: invest.getFktotal());
								if(invest.getFktotal().equals(invest.getLtotal())){
									addCell(39,index,invest.getLtotalctsum() == null ? 0 : invest.getLtotalctsum());
									addCell(40, index,invest.getLtotal1() == null ? 0: invest.getLtotal1());
									addCell(41, index,invest.getLtotal2() == null ? 0: invest.getLtotal2());
									addCell(42, index,invest.getLtotal3() == null ? 0: invest.getLtotal3());
									addCell(43, index,invest.getLtotal4() == null ? 0: invest.getLtotal4());
									addCell(44, index,invest.getLtotal5() == null ? 0: invest.getLtotal5());
									addCell(45,index,invest.getLtotalcssum() == null ? 0 : invest.getLtotalcssum());
									addCell(46, index,invest.getLtotal6() == null ? 0: invest.getLtotal6());
									addCell(47, index,invest.getLtotal7() == null ? 0: invest.getLtotal7());
								}else{
									addCell(39, index, 0);
									addCell(40, index, 0);
									addCell(41, index, 0);
									addCell(42, index, 0);
									addCell(43, index, 0);
									addCell(44, index, 0);
									addCell(45, index, 0);
									addCell(46, index, 0);
									addCell(47, index, 0);
								}
								addCell(48, index, "");
								index++;
								idx++;
							}
						}
					}
				}
			}
		}
		return dto;
	}

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		return dto;
	}

	protected void addCell(int pColumn, int pRow, String pValue, Colour c)
			throws BLException {

		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// 设置单元格的背景颜色
			wcf.setBackground(c);
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);

		} catch (WriteException e) {
			throw new BLException(e.getMessage());
		}
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
		WritableSheet wsheet = excelDTO.getWritableSheet();
		wsheet.getSettings().setScaleFactor(
				wsheetTemplate.getSettings().getScaleFactor());

		Label label = new Label(pColumn, pRow + excelDTO.getStartRow(), pValue,
				wcf);
		try {
			wsheet.addCell(label);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}

	protected void addCell(int pColumn, int pRow, double pValue, Colour c)
			throws BLException {

		// 定义格式 字体 下划线 斜体 粗体 颜色
		WritableFont wf = new WritableFont(WritableFont.ARIAL, 10,
				WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				Colour.AUTOMATIC);
		// 单元格定义
		WritableCellFormat wcf = new WritableCellFormat(wf);
		try {
			// 设置单元格的背景颜色
			wcf.setBackground(c);
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN);

		} catch (WriteException e) {
			throw new BLException(e.getMessage());
		}
		Sheet wsheetTemplate = excelDTO.getTemplateSheet();
		WritableSheet wsheet = excelDTO.getWritableSheet();
		wsheet.getSettings().setScaleFactor(wsheetTemplate.getSettings().getScaleFactor());

		jxl.write.Number number = new jxl.write.Number(pColumn, pRow + excelDTO.getStartRow(), pValue, wcf);

		try {
			wsheet.addCell(number);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		}
	}

}
