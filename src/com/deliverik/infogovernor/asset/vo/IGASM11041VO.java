package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * ����ƽ��ͼ�����ã֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11041VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected SOC0601Info computerRoomVWInfo;
	
	protected List<SOC0603Info> computerContainerVWInfoList;

	/** ������Ϣ */
	protected List<IGASM11042VO> rowList;
	
	/** ���ϼܻ���XML*/
	protected String jiguiXml;
	
	/** δ�ϼܻ���XML*/
	protected String toolsXml;
	
	/**�����ذ�XML */
	protected String guodaoXML;
	
	/**��Ч����XML */
	protected String wuxiaoXML;
	
	/**ͼ����ϢXML */
	protected String legendXML;
	
	/**��������XML */
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
	 * ���캯��
	 * @param computerRoomVWInfo��������Ϣ
	 * @param computerContainerVWInfoList����������������Ϣ
	 */
	public IGASM11041VO(SOC0601Info computerRoomVWInfo,
			List<SOC0603Info> computerContainerVWInfoList) {
		this.computerRoomVWInfo = computerRoomVWInfo;
		this.computerContainerVWInfoList = computerContainerVWInfoList;
		
		//��Ԫ�����б�����
		rowList = new ArrayList<IGASM11042VO>();
		
		//��Ԫ��������
		int rows = Integer.parseInt(computerRoomVWInfo.getY_total());
		//��Ԫ��������
		int cols = Integer.parseInt(computerRoomVWInfo.getX_total());
		
		//���ڻ�
		for (int row=0;row<rows;row++ ) {
			IGASM11042VO vo = new  IGASM11042VO(cols);
			rowList.add(vo);
		}
		
		//�����趨
		for (SOC0603Info cinfo:computerContainerVWInfoList) {
			//�к�
			int rownum = Integer.parseInt(cinfo.getY_value());
			//�к�
			int colnum = Integer.parseInt(cinfo.getX_value());
			//�п�
			int rowwidth = Integer.parseInt(cinfo.getX_width());
			//�п�
			int colwidth = Integer.parseInt(cinfo.getY_width());
			
			//������ʼ��Ԫ�������ж���ȡ��
			IGASM11042VO rowVO = rowList.get(rownum-1);
			
			//������ʼ��Ԫ��ȡ��
			IGASM11043VO colVO = rowVO.getColumnList().get(colnum-1);
			
			//�ո��ʶ���ó�FALSE
			colVO.setSpace(false);
			//������Ϣ�趨
			colVO.setEntityData(cinfo);
			
			//�������1����Ԫ�����ϵ����
			if (rowwidth>1) {
				for(int i= 0; i< rowwidth-1;i++) {
					//������ڵ�������Ԫ��ȡ��
					IGASM11043VO cVO = rowVO.getColumnList().get(colnum+i);
					//��һ��Ԫ��ʶ���ó�FALSE
					cVO.setOneUnit(false);
					//�ո��ʶ���ó�FALSE
					cVO.setSpace(false);
					cVO.setEntityData(cinfo);
				}
			}
			
			//�������1�����ϵ����
			if (colwidth>1) {
				for(int j= 0;j<colwidth-1;j++){
					//��ʼ��һ�µ���ȡ��
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
	 * ������Ϣȡ��
	 * @return ������Ϣ
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
	 * ��Ч����ȡ��
	 * @return ��Ч����
	 */
	public String getWuxiaoXML() {
		return wuxiaoXML;
	}

	/**
	 * ��Ч����ȡ��
	 */
	public void setWuxiaoXML(String wuxiaoXML) {
		this.wuxiaoXML = wuxiaoXML;
	}
	
	/**
	 * ͼ����Ϣȡ��
	 * @return ͼ����Ϣ
	 */
	public String getLegendXML() {
		return legendXML;
	}

	/**
	 * ͼ����Ϣȡ��
	 */
	public void setLegendXML(String legendXML) {
		this.legendXML = legendXML;
	}
}


