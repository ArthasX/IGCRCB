package com.deliverik.infogovernor.asset.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;

/**
 * ����ƽ��ͼ�����ã֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGASM11141VO extends BaseVO implements Serializable{
	
	/** ������Ϣ */
	protected SOC0603Info computerContainerVWInfo;
	
	protected List<SOC0602Info> computerDeviceVWInfoList;

	/** �豸��Ϣ */
	protected List<IGASM11142VO> rowList;
	

	public List<IGASM11142VO> getRowList() {
		return rowList;
	}

	public void setRowList(List<IGASM11142VO> rowList) {
		this.rowList = rowList;
	}

	/**
	 * ���캯��
	 * @param computerContainerVWInfo��������Ϣ
	 * @param computerDeviceVWInfoList�����������豸��Ϣ
	 */
	public IGASM11141VO(SOC0603Info computerContainerVWInfo,
			List<SOC0602Info> computerDeviceVWInfoList) {
		this.computerContainerVWInfo = computerContainerVWInfo;
		this.computerDeviceVWInfoList = computerDeviceVWInfoList;
		
		//��Ԫ�����б�����
		rowList = new ArrayList<IGASM11142VO>();
		
		//��Ԫ��������
		int rows = Integer.parseInt(computerContainerVWInfo.getU_total());
		
		//���ڻ�
		for (int row=0;row<rows;row++ ) {
			IGASM11142VO vo = new  IGASM11142VO();
			vo.setRowNum(rows-row);
			rowList.add(vo);
		}
		
		//�����趨
		for (SOC0602Info cinfo:computerDeviceVWInfoList) {
			//�п�
			int rowwidth = Integer.parseInt(cinfo.getU_width());
			
			//�к�
			int rownum = rows - Integer.parseInt(cinfo.getU_value()) - rowwidth + 1;

			//������ʼ��Ԫ�������ж���ȡ��
			IGASM11142VO rowVO = rowList.get(rownum);
			
			//�ո��ʶ���ó�FALSE
			rowVO.setSpace(false);
			//������Ϣ�趨
			rowVO.setEntityData(cinfo);
			
			//�������1�����ϵ����
			if (rowwidth>1) {
				for(int j= 0;j<rowwidth-1;j++){
					//��ʼ��һ�µ���ȡ��
					IGASM11142VO rVO = rowList.get(rownum+j+1);
					rVO.setOneUnit(false);
					rVO.setSpace(false);
					rVO.setEntityData(cinfo);
				}
			}
		}
	}
	
	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public SOC0603Info getComputerContainerVWInfo() {
		return computerContainerVWInfo;
	}

	public int getU_total() {
		return Integer.parseInt(computerContainerVWInfo.getU_total());
	}
}


