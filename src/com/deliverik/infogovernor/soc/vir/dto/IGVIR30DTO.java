/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.dto;

import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3001Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3002Form;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3003Form;
import com.deliverik.infogovernor.soc.vir.model.VCD02Info;
import com.deliverik.infogovernor.soc.vir.model.VCD03Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���⻯Vcloud����DTO 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR30DTO extends BaseDTO{
	
	/** ��ĿID */
	protected Integer pid;

	/** �û���Ϣ */
	protected User user;
	
	/** json��� */
	protected String jsonResult;

	/** vCloud���⻯���뷢��Form */
	protected IGVIR3001Form igvir3001Form;
	
	/** vCloud���⻯���봦��Form */
	protected IGVIR3002Form igvir3002Form;
	
	/** �Զ����������ʾForm */
	protected IGVIR3003Form igvir3003Form;
	
	/** ��Ŀ��Ϣ */
	protected VCD02Info vcd02;
	
	/** vmids */
	protected String vmids;
	
	/** vm��Ϣ���� */
	protected List<VCD03Info> vcd03List;
	
	/**
	 * ��ĿIDȡ��
	 * @return pid ��ĿID
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * ��ĿID�趨
	 * @param pid ��ĿID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * �û���Ϣȡ��
	 * @return user �û���Ϣ
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û���Ϣ�趨
	 * @param user �û���Ϣ
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * json���ȡ��
	 * @return jsonResult json���
	 */
	public String getJsonResult() {
		return jsonResult;
	}

	/**
	 * json����趨
	 * @param jsonResult json���
	 */
	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	/**
	 * vCloud���⻯���뷢��Formȡ��
	 * @return igvir3001Form vCloud���⻯���뷢��Form
	 */
	public IGVIR3001Form getIgvir3001Form() {
		return igvir3001Form;
	}

	/**
	 * vCloud���⻯���뷢��Form�趨
	 * @param igvir3001Form vCloud���⻯���뷢��Form
	 */
	public void setIgvir3001Form(IGVIR3001Form igvir3001Form) {
		this.igvir3001Form = igvir3001Form;
	}

	/**
	 * vCloud���⻯���봦��Formȡ��
	 * @return igvir3002Form vCloud���⻯���봦��Form
	 */
	public IGVIR3002Form getIgvir3002Form() {
		return igvir3002Form;
	}

	/**
	 * vCloud���⻯���봦��Form�趨
	 * @param igvir3002Form vCloud���⻯���봦��Form
	 */
	public void setIgvir3002Form(IGVIR3002Form igvir3002Form) {
		this.igvir3002Form = igvir3002Form;
	}

	/**
	 * �Զ����������ʾFormȡ��
	 * @return igvir3003Form �Զ����������ʾForm
	 */
	public IGVIR3003Form getIgvir3003Form() {
		return igvir3003Form;
	}

	/**
	 * �Զ����������ʾForm�趨
	 * @param igvir3003Form �Զ����������ʾForm
	 */
	public void setIgvir3003Form(IGVIR3003Form igvir3003Form) {
		this.igvir3003Form = igvir3003Form;
	}

	/**
	 * ��Ŀ��Ϣȡ��
	 * @return vcd02 ��Ŀ��Ϣ
	 */
	public VCD02Info getVcd02() {
		return vcd02;
	}

	/**
	 * vmidsȡ��
	 * @return vmids vmids
	 */
	public String getVmids() {
		return vmids;
	}

	/**
	 * ��Ŀ��Ϣ�趨
	 * @param vcd02 ��Ŀ��Ϣ
	 */
	public void setVcd02(VCD02Info vcd02) {
		this.vcd02 = vcd02;
	}

	/**
	 * vmids�趨
	 * @param vmids vmids
	 */
	public void setVmids(String vmids) {
		this.vmids = vmids;
	}

	/**
	 * vm��Ϣ����ȡ��
	 * @return vcd03List vm��Ϣ����
	 */
	public List<VCD03Info> getVcd03List() {
		return vcd03List;
	}

	/**
	 * vm��Ϣ�����趨
	 * @param vcd03List vm��Ϣ����
	 */
	public void setVcd03List(List<VCD03Info> vcd03List) {
		this.vcd03List = vcd03List;
	}
}
