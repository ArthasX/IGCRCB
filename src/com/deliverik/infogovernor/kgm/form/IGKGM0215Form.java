/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseForm;


/**
 * ����: ֪ʶ������ϸҳ��Form
 * ����������֪ʶ������ϸҳ��Form
 * ������¼������ 2010/12/10
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGKGM0215Form extends BaseForm{

	/** ֪ʶID */
	protected Integer knid;
	
	/** ֪ʶ��ϸҳ�淵�ر�ʶ */
	protected String knflag;
	
	protected String rlcomment;
	
	/** ��֪ʶ��ϸҳ�������ID */
	protected Integer prid;
	
	/** ��֪ʶ��ϸҳ��ķ��񹤵�ID */
	protected Integer sfid;
	
	/**֪ʶ�汾*/
	protected Integer knversion;
	
	/**
	 * ֪ʶ�汾ȡ��
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion() {
		return knversion;
	}

	/**
	 * ֪ʶ�汾�趨
	 * @param knversion ֪ʶ�汾
	 */
	public void setKnversion(Integer knversion) {
		this.knversion = knversion;
	}

	/**
	 * ֪ʶIDȡ��
	 * @return ֪ʶID
	 */
	public Integer getKnid() {
		return knid;
	}

	/**
	 * ֪ʶID�趨
	 * @param knid֪ʶID
	 */
	public void setKnid(Integer knid) {
		this.knid = knid;
	}

	/**
	 * ֪ʶ��ϸҳ�淵�ر�ʶȡ��
	 * @return ֪ʶ��ϸҳ�淵�ر�ʶ
	 */
	public String getKnflag() {
		return knflag;
	}

	/**
	 * ֪ʶ��ϸҳ�淵�ر�ʶ�趨
	 * @param knflag֪ʶ��ϸҳ�淵�ر�ʶ
	 */
	public void setKnflag(String knflag) {
		this.knflag = knflag;
	}

	/**
	 * ��֪ʶ��ϸҳ�������IDȡ��
	 * @return ��֪ʶ��ϸҳ�������ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ��֪ʶ��ϸҳ�������ID�趨
	 * @param prid��֪ʶ��ϸҳ�������ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ��֪ʶ��ϸҳ��ķ��񹤵�IDȡ��
	 * @return ��֪ʶ��ϸҳ��ķ��񹤵�ID
	 */
	public Integer getSfid() {
		return sfid;
	}

	/**
	 * ��֪ʶ��ϸҳ��ķ��񹤵�ID�趨
	 * @param sfid��֪ʶ��ϸҳ��ķ��񹤵�ID
	 */
	public void setSfid(Integer sfid) {
		this.sfid = sfid;
	}

	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.prid = null;
		this.knid = null;
		this.sfid = null;
	}

	public String getRlcomment() {
		return rlcomment;
	}

	public void setRlcomment(String rlcomment) {
		this.rlcomment = rlcomment;
	}

}
