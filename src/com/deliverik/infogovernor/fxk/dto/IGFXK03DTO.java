package com.deliverik.infogovernor.fxk.dto;



import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0302Form;
import com.deliverik.infogovernor.fxk.model.RiskprojectvwInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������DTO
 * </p>
 * 2014-7-24
 * 
 * @author fenghuan@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGFXK03DTO extends BaseDTO {
	
	   /** �����ѯ������¼�� */
	private int maxSearchCount;
	
    /**��õ���Ϣmap*/
    private Map<RiskprojectvwInfo,Map<String,Map<String,String>>> infomap;

    /** ��ҳBean */
    private PagingDTO pagingDto;
    
    /** �û���ҳ�б� */
    private List<LabelValueBean> lst_LabelValueBean;
    
    private IGFXK0302Form form0302;
    
    /** �û��������б�*/
    private List<LabelValueBean> Peo_LabelValueBean;

	/**
	 * �����ѯ������¼��ȡ��
	 * @return maxSearchCount �����ѯ������¼��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����ѯ������¼���趨
	 * @param maxSearchCount �����ѯ������¼��
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��õ���Ϣmapȡ��
	 * @return infomap ��õ���Ϣmap
	 */
	public Map<RiskprojectvwInfo, Map<String, Map<String, String>>> getInfomap() {
		return infomap;
	}

	/**
	 * ��õ���Ϣmap�趨
	 * @param infomap ��õ���Ϣmap
	 */
	public void setInfomap(
			Map<RiskprojectvwInfo, Map<String, Map<String, String>>> infomap) {
		this.infomap = infomap;
	}

	/**
	 * ��ҳBeanȡ��
	 * @return pagingDto ��ҳBean
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳBean�趨
	 * @param pagingDto ��ҳBean
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �û���ҳ�б�ȡ��
	 * @return lst_LabelValueBean �û���ҳ�б�
	 */
	public List<LabelValueBean> getLst_LabelValueBean() {
		return lst_LabelValueBean;
	}

	/**
	 * �û���ҳ�б��趨
	 * @param lst_LabelValueBean �û���ҳ�б�
	 */
	public void setLst_LabelValueBean(List<LabelValueBean> lst_LabelValueBean) {
		this.lst_LabelValueBean = lst_LabelValueBean;
	}

	/**
	 * form0302ȡ��
	 * @return form0302 form0302
	 */
	public IGFXK0302Form getForm0302() {
		return form0302;
	}

	/**
	 * form0302�趨
	 * @param form0302 form0302
	 */
	public void setForm0302(IGFXK0302Form form0302) {
		this.form0302 = form0302;
	}

	/**
	 * peo_LabelValueBeanȡ��
	 * @return peo_LabelValueBean peo_LabelValueBean
	 */
	public List<LabelValueBean> getPeo_LabelValueBean() {
		return Peo_LabelValueBean;
	}

	/**
	 * peo_LabelValueBean�趨
	 * @param peo_LabelValueBean peo_LabelValueBean
	 */
	public void setPeo_LabelValueBean(List<LabelValueBean> peo_LabelValueBean) {
		Peo_LabelValueBean = peo_LabelValueBean;
	}

}
