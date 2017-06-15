/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.ExcelBaseBLImpl;
import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM41ExcelDTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计导出
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGASM4001ExcelBLImpl extends ExcelBaseBLImpl  implements IGASM4001ExcelBL {
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGASM4001ExcelBLImpl.class);

	public ExcelDTO initHeader(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcelDTO initBody(ExcelDTO dto) throws BLException {
		log.debug("=================风险检查统计导出开始=================");
		IGASM41ExcelDTO exceldto = (IGASM41ExcelDTO) excelDTO;
		// 设置起始行数
		exceldto.setStartRow(2);
		try {
			// 获取导出内容
			int i = 0;  //行号
			int risklyRowNum = 0;  //行数计数(第一列专用)
			int riskareaRowNum = 0;  //行数计数(第二列专用)
			int riskitemRowNum = 0;  //行数计数(第三列专用)
			int totalRowNum = 0;  //key的总行数
			String tempRiskly=null;//风险子域(二级分类)临时变量
			String tempRiskarea=null;//风险子域(二级分类)临时变量
			Map<List<RiskVWInfo>, List<CheckVWInfo>> map = exceldto.getRiskCheckMap();
			//获得key的总行数
			for(List<RiskVWInfo> riskList:map.keySet()){
				for(@SuppressWarnings("unused") RiskVWInfo risk:riskList){
					totalRowNum++;
				}
			}
			//向excel中插入单元格
			for(Entry<List<RiskVWInfo>, List<CheckVWInfo>> entry: map.entrySet()){
				for(int j=0;j<entry.getKey().size();j++){
					RiskVWInfo risk=entry.getKey().get(j);
					// 风险领域(一级分类)
					addCell(0, i, risk.getRiskly());
					// 风险子域(二级分类)
					addCell(1, i, risk.getRiskarea());
					// 风险项
					addCell(2, i, risk.getRiskitem());
					// 风险点(检查点)
					addCell(3, i, risk.getEiname());
					// 严重等级
					addCell(4, i, risk.getGrad());
					// 发生可能性
					addCell(5, i, risk.getPoss());
					// 风险级别
					addCell(6, i, risk.getLevels());
					// 风险点标志
					addCell(7, i, risk.getRisksign());
					
					//第一列合并判断
					if(risklyRowNum == 0){
						tempRiskly = risk.getRiskly();
						risklyRowNum++;
					}else{
						//与上一个内容相同时合并
						if(tempRiskly.equals(risk.getRiskly())){
							risklyRowNum++;
							//最后一条合并
							if(totalRowNum==i+1){
								dto.getWritableSheet().mergeCells(0,dto.getStartRow()+i-risklyRowNum+1,0, dto.getStartRow() + i);
							}
						}else{
							dto.getWritableSheet().mergeCells(0,dto.getStartRow()+i-risklyRowNum,0, dto.getStartRow() + i-1);
							tempRiskly = risk.getRiskly();
							risklyRowNum = 1;
						}
					}
					
					//第二列合并判断
					if(riskareaRowNum == 0){
						tempRiskarea = risk.getRiskarea();
						riskareaRowNum++;
					}else{
						//与上一个内容相同时合并
						if(tempRiskarea.equals(risk.getRiskarea())){
							riskareaRowNum++;
							//最后一条合并
							if(totalRowNum==i+1){
								dto.getWritableSheet().mergeCells(1,dto.getStartRow()+i-riskareaRowNum+1,1, dto.getStartRow() + i);
							}
						}else{
							dto.getWritableSheet().mergeCells(1,dto.getStartRow()+i-riskareaRowNum,1, dto.getStartRow() + i-1);
							tempRiskarea = risk.getRiskarea();
							riskareaRowNum = 1;
						}
					}
					/**
					 * 向检查方法与检查频率列插入单元格,只在遍历到每个Key(list)的第一条数据时插入其值,
					 * 其余插空值,然后合并单元格
					 */
					if(j==0){
						//检查方法串
						StringBuffer checkMethod= new StringBuffer();
						//检查频率串
						StringBuffer checkFrequency= new StringBuffer();
						if(entry.getValue()!=null){
							for(CheckVWInfo check:entry.getValue()){
								checkMethod.append(check.getCheckMethod()+"\n");
								checkFrequency.append(check.getCheckfrequency()+"\n");
							}
						}
						// 检查方法
						if(StringUtils.isNotEmpty(checkMethod.toString())){
							addCell(8, i, checkMethod.toString());
						}else{
							addCell(8, i, "");
						}
						//检查频率
						if(StringUtils.isNotEmpty(checkFrequency.toString())){
							addCell(9, i, checkFrequency.toString());
						}else{
							addCell(9, i, "");
						}
					}else{
						addCell(8, i, "");
						addCell(9, i, "");
					}
					/**
					 * 如果key(list)所对应的value(list)的条数比key(list)的条数多,
					 * 将key(list)中每一条的行高加一定高度,以便value(list)能在excel中全部显示出来
					 */
					if(entry.getValue()!=null){
						if(entry.getValue().size()>entry.getKey().size()){
							double distance = (entry.getValue().size()-entry.getKey().size())*270/entry.getKey().size();
							dto.getWritableSheet().setRowView(i+2, 280+(int)Math.floor(distance));
						}
					}
					i++;
				}
				//合并第三列
				dto.getWritableSheet().mergeCells(2,dto.getStartRow() + riskitemRowNum,2, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				//合并第九列
				dto.getWritableSheet().mergeCells(8,dto.getStartRow() + riskitemRowNum,8, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				//合并第十列
				dto.getWritableSheet().mergeCells(9,dto.getStartRow() + riskitemRowNum,9, dto.getStartRow() + riskitemRowNum + entry.getKey().size() - 1);
				riskitemRowNum = riskitemRowNum + entry.getKey().size(); 
			}
			//合并第一列
			//dto.getWritableSheet().mergeCells(0,dto.getStartRow(),0, dto.getStartRow() + i-1);
		} catch (RowsExceededException e) {
			throw new BLException("IGRPT0000.E004");
		} catch (WriteException e) {
			throw new BLException("IGRPT0000.E005");
		} catch (Exception e) {
			e.printStackTrace();
			log.debug(e);
		}
		log.debug("=================风险检查统计导出结束=================");
		return dto;
	}

	public ExcelDTO initFooter(ExcelDTO dto) throws BLException {
		// TODO Auto-generated method stub
		return null;
	}

}
