package com.deliverik.infogovernor.scheduling.model.condition;


public class QuartzProcessInfoEntitySearchCondImpl implements QuartzProcessInfoEntitySearchCond{

	/** �������������� */
	protected Integer qpieid;

	/** ����ID(QuartzProcessRecord��) */
	protected Integer qprid;

	/** ��̬��ID��QuartzProcessInfoDef��*/
	protected Integer qpiid;

	/** �ʲ�ID(EntityItem��) */
	protected Integer qeiid;

	

	/**
	 *��������������ȡ��
	 * @return ��������������
	 */
	public Integer getQpieid(){
		return qpieid;
	}
	
	/**
	 *���������������趨
	 * @param pieid��������������
	 */
	public void setQpieid(Integer qpieid){
		this.qpieid=qpieid;
	}
	
	/**
	 *����ID(QuartzProcessRecord��)ȡ��
	 * @return ����ID(QuartzProcessRecord��)
	 */
	public Integer getQprid(){
		return qprid;
	}

	/**
	 *����ID(QuartzProcessRecord��)�趨
	 * @param prid����ID(QuartzProcessRecord��)
 	 */
	public void setQprid(Integer qprid){
		this.qprid=qprid;
	}
	
	/**
	 *��̬��ID��QuartzProcessInfoDef��ȡ��
	 * @return ��̬��ID��QuartzProcessInfoDef��
	 */
	public Integer getQpiid(){
		return qpiid;
	}
	
	/**
	 *��̬��ID��QprocessInfoDef���趨
	 * @param pidid��̬��ID��QprocessInfoDef��
	 */
	public void setQpiid(Integer qpiid){
		this.qpiid=qpiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)ȡ��
	 * @return �ʲ�ID(EntityItem��)
	 */
	public Integer getQeiid(){
		return qeiid;
	}
	
	/**
	 *�ʲ�ID(EntityItem��)�趨
	 * @param eiid�ʲ�ID(EntityItem��)
	 */
	public void setQeiid(Integer qeiid){
		this.qeiid=qeiid;
	}

}
