/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_��׼VO
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL03011VO extends BaseVO implements Serializable {
	
	/**��׼��ϢList*/
	protected List<SdlDefineInfo> sdlDefineInfoList;
	
	/**
	 * ��ȡ��׼��ϢList
	 * @return List<SdlDefineInfo>
	 */
	
	public List<SdlDefineInfo> getSdlDefineInfoList() {
		return sdlDefineInfoList;
	}
	/**
	 * ���캯��
	 * @param  
	 *
	 */
	public IGSDL03011VO() {
	}
	/**
	 * ���캯��
	 * @param sdlDefineInfoList List<SdlDefineInfo>
	 */
	public IGSDL03011VO(List<SdlDefineInfo> sdlDefineInfoList) {
		this.sdlDefineInfoList = sdlDefineInfoList;
	}
}
