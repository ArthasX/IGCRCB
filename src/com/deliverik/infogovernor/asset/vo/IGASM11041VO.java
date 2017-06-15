package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * 机房平面图画面用ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11041VO extends BaseVO implements Serializable{
	
	/** 机房信息 */
	protected SOC0601Info computerRoomVWInfo;
	
	protected List<SOC0603Info> computerContainerVWInfoList;

	/** 机房信息 */
	protected List<IGASM11042VO> rowList;
	
	/** 已上架机柜XML*/
	protected String jiguiXml;
	
	/** 未上架机柜XML*/
	protected String toolsXml;
	
	/**过道地板XML */
	protected String guodaoXML;
	
	/**无效地区XML */
	protected String wuxiaoXML;
	
	/**图例信息XML */
	protected String legendXML;
	
	/**关联机房XML */
	protected String relateRoomXML;

	public String getRelateRoomXML() {
		return relateRoomXML;
	}

	public void setRelateRoomXML(String relateRoomXML) {
		this.relateRoomXML = relateRoomXML;
	}

	public List<IGASM11042VO> getRowList() {
		return rowList;
	}

	public void setRowList(List<IGASM11042VO> rowList) {
		this.rowList = rowList;
	}

	public IGASM11041VO() {
	}
	/**
	 * 构造函数
	 * @param computerRoomVWInfo　机房信息
	 * @param computerContainerVWInfoList　机房所属机柜信息
	 */
	public IGASM11041VO(SOC0601Info computerRoomVWInfo,
			List<SOC0603Info> computerContainerVWInfoList) {
		this.computerRoomVWInfo = computerRoomVWInfo;
		this.computerContainerVWInfoList = computerContainerVWInfoList;
		
		//单元格行列表生成
		rowList = new ArrayList<IGASM11042VO>();
		
		//单元格总行数
		int rows = Integer.parseInt(computerRoomVWInfo.getY_total());
		//单元格总列数
		int cols = Integer.parseInt(computerRoomVWInfo.getX_total());
		
		//初期化
		for (int row=0;row<rows;row++ ) {
			IGASM11042VO vo = new  IGASM11042VO(cols);
			rowList.add(vo);
		}
		
		//机柜设定
		for (SOC0603Info cinfo:computerContainerVWInfoList) {
			//行号
			int rownum = Integer.parseInt(cinfo.getY_value());
			//列号
			int colnum = Integer.parseInt(cinfo.getX_value());
			//行宽
			int rowwidth = Integer.parseInt(cinfo.getX_width());
			//列宽
			int colwidth = Integer.parseInt(cinfo.getY_width());
			
			//机柜起始单元格所在行对象取得
			IGASM11042VO rowVO = rowList.get(rownum-1);
			
			//机柜起始单元格取得
			IGASM11043VO colVO = rowVO.getColumnList().get(colnum-1);
			
			//空格标识设置成FALSE
			colVO.setSpace(false);
			//机柜信息设定
			colVO.setEntityData(cinfo);
			
			//横向宽在1个单元格以上的情况
			if (rowwidth>1) {
				for(int i= 0; i< rowwidth-1;i++) {
					//横向宽内的其他单元格取得
					IGASM11043VO cVO = rowVO.getColumnList().get(colnum+i);
					//单一单元标识设置成FALSE
					cVO.setOneUnit(false);
					//空格标识设置成FALSE
					cVO.setSpace(false);
					cVO.setEntityData(cinfo);
				}
			}
			
			//纵向宽在1行以上的情况
			if (colwidth>1) {
				for(int j= 0;j<colwidth-1;j++){
					//起始行一下的行取得
					IGASM11042VO rVO = rowList.get(rownum+j);
					for(int i= 0; i< rowwidth;i++) {
						IGASM11043VO cVO = rVO.getColumnList().get(colnum+i-1);
						cVO.setOneUnit(false);
						cVO.setSpace(false);
						cVO.setEntityData(cinfo);
					}
				}
			}
		}
	}
	
	/**
	 * 机房信息取得
	 * @return 机房信息
	 */
	public SOC0601Info getComputerRoomVWInfo() {
		return computerRoomVWInfo;
	}

	public int getTableWidth() {
		int cols = Integer.parseInt(computerRoomVWInfo.getX_total());
		int width = 20 + cols*50; 
		
		return width;
	}

	public int getX_total() {
		return Integer.parseInt(computerRoomVWInfo.getX_total());
	}

	public int getY_total() {
		return Integer.parseInt(computerRoomVWInfo.getY_total());
	}

	public String getJiguiXml() {
		return jiguiXml;
	}

	public void setJiguiXml(String jiguiXml) {
		this.jiguiXml = jiguiXml;
	}

	public String getToolsXml() {
		return toolsXml;
	}

	public void setToolsXml(String toolsXml) {
		this.toolsXml = toolsXml;
	}

	public List<SOC0603Info> getComputerContainerVWInfoList() {
		return computerContainerVWInfoList;
	}

	public void setComputerContainerVWInfoList(
			List<SOC0603Info> computerContainerVWInfoList) {
		this.computerContainerVWInfoList = computerContainerVWInfoList;
	}

	public void setComputerRoomVWInfo(SOC0601Info computerRoomVWInfo) {
		this.computerRoomVWInfo = computerRoomVWInfo;
	}

	public String getGuodaoXML() {
		return guodaoXML;
	}

	public void setGuodaoXML(String guodaoXML) {
		this.guodaoXML = guodaoXML;
	}
	
	/**
	 * 无效地区取得
	 * @return 无效地区
	 */
	public String getWuxiaoXML() {
		return wuxiaoXML;
	}

	/**
	 * 无效地区取得
	 */
	public void setWuxiaoXML(String wuxiaoXML) {
		this.wuxiaoXML = wuxiaoXML;
	}
	
	/**
	 * 图例信息取得
	 * @return 图例信息
	 */
	public String getLegendXML() {
		return legendXML;
	}

	/**
	 * 图例信息取得
	 */
	public void setLegendXML(String legendXML) {
		this.legendXML = legendXML;
	}
}


