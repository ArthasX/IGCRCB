package com.deliverik.framework.user.model.condition;

/**
 * �˵���Ϣ��������ʵ��
 * 
 */
public class ActionSearchCondImpl implements ActionSearchCond {

	/** �˵���ʾ���� */
	protected String actlabel;
	
	/** �˵��������ɫ���� */
	protected String actroletype;
	
	/** �˵����� */
	protected String actname_like;
	
	/**URL��ѯ */
	protected String acturl_like;
	
	/**�˵����� */
	protected String acttype;
	
	/**�Զ��������Զ����ɲ˵���״̬��ǣ�1������Ч�� */
    protected String actl1id;
	
	/**
     * �˵�����ȡ��
     * @return �˵�����
     */
    public String getActtype() {
        return acttype;
    }

    /**
     * �˵������趨
     *
     * @param acttype �˵�����
     */
    public void setActtype(String acttype) {
        this.acttype = acttype;
    }

    /**
	 * �˵���ʾ����ȡ��
	 * 
	 * @return �˵���ʾ����
	 */
	public String getActlabel() {
		return actlabel;
	}

	/**
	 * �˵���ʾ�����趨
	 *
	 * @param actlabel �˵���ʾ����
	 */
	public void setActlabel(String actlabel) {
		this.actlabel = actlabel;
	}

	/**
	 * �˵��������ɫ����(���ŷָ�)ȡ��
	 * @return �˵��������ɫ����(���ŷָ�)
	 */
	public String getActroletype() {
		return actroletype;
	}

	/**
	 * �˵��������ɫ�����趨
	 *
	 * @param actroletype �˵��������ɫ����
	 */
	public void setActroletype(String actroletype) {
		this.actroletype = actroletype;
	}

	/**
	 * �˵�����ȡ��
	 * @return �˵�����
	 */
	public String getActname_like() {
		return actname_like;
	}

	/**
	 * �˵������趨
	 * @param actname_like�˵�����
	 */
	public void setActname_like(String actname_like) {
		this.actname_like = actname_like;
	}

	public String getActurl_like() {
		return acturl_like;
	}

	public void setActurl_like(String acturl_like) {
		this.acturl_like = acturl_like;
	}

    /**
     * @return the �Զ��������Զ����ɲ˵���״̬��ǣ�1������Ч��
     */
    public String getActl1id() {
        return actl1id;
    }

    /**
     * @param �Զ��������Զ����ɲ˵���״̬��ǣ�1������Ч�� the actl1id to set
     */
    public void setActl1id(String actl1id) {
        this.actl1id = actl1id;
    }
	
}
