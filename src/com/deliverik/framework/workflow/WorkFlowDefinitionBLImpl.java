/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.workflow.prd.bl.task.IG001BL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG008BL;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG108BL;
import com.deliverik.framework.workflow.prd.bl.task.IG110BL;
import com.deliverik.framework.workflow.prd.bl.task.IG111BL;
import com.deliverik.framework.workflow.prd.bl.task.IG123BL;
import com.deliverik.framework.workflow.prd.bl.task.IG126BL;
import com.deliverik.framework.workflow.prd.bl.task.IG132BL;
import com.deliverik.framework.workflow.prd.bl.task.IG156BL;
import com.deliverik.framework.workflow.prd.bl.task.IG202BL;
import com.deliverik.framework.workflow.prd.bl.task.IG212BL;
import com.deliverik.framework.workflow.prd.bl.task.IG213BL;
import com.deliverik.framework.workflow.prd.bl.task.IG221BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG233BL;
import com.deliverik.framework.workflow.prd.bl.task.IG237BL;
import com.deliverik.framework.workflow.prd.bl.task.IG243BL;
import com.deliverik.framework.workflow.prd.bl.task.IG258BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG273BL;
import com.deliverik.framework.workflow.prd.bl.task.IG286BL;
import com.deliverik.framework.workflow.prd.bl.task.IG298BL;
import com.deliverik.framework.workflow.prd.bl.task.IG299BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG334BL;
import com.deliverik.framework.workflow.prd.bl.task.IG335BL;
import com.deliverik.framework.workflow.prd.bl.task.IG373BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG413BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG699BL;
import com.deliverik.framework.workflow.prd.bl.task.IG700BL;
import com.deliverik.framework.workflow.prd.bl.task.IG701BL;
import com.deliverik.framework.workflow.prd.bl.task.IG725BL;
import com.deliverik.framework.workflow.prd.bl.task.IG881BL;
import com.deliverik.framework.workflow.prd.bl.task.IG911BL;
import com.deliverik.framework.workflow.prd.bl.task.IG931BL;
import com.deliverik.framework.workflow.prd.bl.task.IG992BL;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG008Info;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.IG123Info;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.IG132Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG202Info;
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.IG221Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG334Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG560VWInfo;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG700Info;
import com.deliverik.framework.workflow.prd.model.IG701Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.IG909Info;
import com.deliverik.framework.workflow.prd.model.IG911Info;
import com.deliverik.framework.workflow.prd.model.IG913Info;
import com.deliverik.framework.workflow.prd.model.IG931Info;
import com.deliverik.framework.workflow.prd.model.IG992Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG008SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG110SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG132SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG202SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG221SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG334SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG700SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG701SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG909SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG911SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG913SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG931SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG992SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG259TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG700PK;
import com.deliverik.framework.workflow.prd.model.entity.IG701PK;
import com.deliverik.framework.workflow.prr.bl.task.IG561BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;

/**
 * <p>����:���̶���ҵ���߼�ʵ��</p>
 * <p>����������1.��ȡʹ���е�����ģ����Ϣ</p>
 * <p>          2.������������ģ����Ϣ</p>
 * <p>          3.������������ģ����Ϣ����ҳ��ѯ�ã�</p>
 * <p>          4.��������ģ��ID��ȡ����ģ��</p>
 * <p>          5.��������ģ�崦��</p>
 * <p>          6.ɾ������ģ�崦��</p>
 * <p>          7.�������ģ����Ϣ����</p>
 * <p>          8.��������ģ��ID��ȡ���̶��弯��</p>
 * <p>          9.�������̶���ID��ȡ���̶���</p>
 * <p>          10.���ݼ�������ȡ�����̶�����Ϣ�������</p>
 * <p>          11.���ݼ�������ȡ�����̶�����Ϣ�б�</p>
 * <p>          12.���ݼ�������ȡ�����̶�����Ϣ�б���ҳ��ѯʹ�ã�</p>
 * <p>          13.���̶�����Ϣ</p>
 * <p>          14.ɾ�����̶�����Ϣ</p>
 * <p>          15.�������̶�����Ϣ</p>
 * <p>          16.�������̶���ID��ȡ���̱������弯��</p>
 * <p>          17.�������̶���ID��ȡ���̱������弯�ϣ�������ȱʡ������ƽ̨������</p>
 * <p>          18.���̱����������������������ȡ��</p>
 * <p>          19.���̱�������������������</p>
 * <p>          20.���̱�������������������</p>
 * <p>          21.�������̱�������ID��ȡ���̱���������Ϣ</p>
 * <p>          22.���̱���������Ϣ��¼����</p>
 * <p>          23.���̱���������Ϣ���´���</p>
 * <p>          24.���̱���������Ϣɾ������</p>
 * <p>          25.���̱���������Ϣɾ������</p>
 * <p>������¼��
 */
public class WorkFlowDefinitionBLImpl extends BaseBLImpl implements WorkFlowDefinitionBL {
	
	/** ����ģ����Ϣ���� */
	protected IG259BL ig259BL;
	
	/** ����������Ϣ���� */
	protected IG380BL ig380BL;
	
	/** ���̱���������Ϣ���� */
	protected IG007BL ig007BL;
	
	/** ���̲�����Ϣ���� */
	protected IG105BL ig105BL;
	
	/** ��ɫ����BL */
	protected IG001BL ig001BL;
	
	/** ���̲鿴��ɫ��Ȩ����BL */
	protected IG701BL ig701BL;

	/** ����ǰ������BL */
	protected IG413BL ig413BL;
	
	/** ����״̬��ϢBL */
	protected IG333BL ig333BL;
	
	/** ����״̬_��������ϢBL */
	protected IG222BL ig222BL;
	
	/** ���̱���ʼ���¼�������ϢBL */
	protected IG373BL ig373BL;
	
	/** ����������ʾBL */
	protected IG243BL ig243BL;
	
	/**����״̬�ɷ��ɽ�ɫ����BL*/
	protected IG298BL ig298BL;
	
	/** ���̽�ɫ������ȨBL */
	protected IG213BL ig213BL;
	
	/** ״̬�����߹����������Ͷ���BL*/
	protected IG911BL ig911BL;
	
	/** ����״̬�ɷ��ɻ�������BL */
	protected IG299BL ig299BL;
	
	/** ȱʡ״̬�����߹����������Ͷ���BL*/
	protected IG931BL ig931BL;
	
	/** ������ΧBL */
	protected IG123BL ig123BL;
	
	/** ����״̬��ť����BL */
	protected IG156BL ig156BL;
	
	/** ���̱�����BL */
	protected IG286BL ig286BL;
	
	/** ����״̬_�����߰�ťBL */
	protected IG132BL ig132BL;
	
	/** ����״̬_�����߰�ťvwBL */
	protected IG221BL ig221BL;
	
	/** ����״̬_������_Ȩ����ϢBL */
	protected IG881BL ig881BL;
	
	/** ��������ϢBL */
	protected IG273BL ig273BL;
	
	/** ȱʡ�����˰�ť����BL */
	protected IG725BL ig725BL;
	
	/** ����ҳ��BL */
	protected IG126BL ig126BL;
	
	/** ����ȱʡ�����߱���Ȩ��BL */
	protected IG699BL ig699BL;
	
	/** ��ͨ��������Ϣ��ϢBL */
	protected IG202BL ig202BL;
	
	/** ���̲鿴��ɫBL */
	protected IG700BL ig700BL;
	
	/** ����֪ͨ�����趨BL */
	protected IG212BL ig212BL;
	
	/** ����֪ͨ����֪ͨ��BL */
	protected IG237BL ig237BL;
	
	/**  �ⲿ����  */
	protected IG992BL ig992BL;
	
	/**  ���̿ɵ���������  */
	protected IG258BL ig258BL;
	
	/** ����״̬BL */
	protected IG233BL ig233BL;
    
    /** ����ѯ����BL */
    protected IG108BL ig108BL;
    
	/**  ֪ͨ���Ի�����ϢBL */
	protected IG334BL ig334BL;
	
	/**  ������BL */
	protected IG335BL ig335BL;
	
	/** ����ɫ�޶�BL */
	protected IG008BL ig008BL;
	
	/**״̬��˽�б�Ĭ��ֵBL*/
    protected IG560BL ig560BL;
    
    /**״̬��˽�б�ֵ��*/
    protected IG561BL ig561BL;
    
    /** ���̲�ѯ��ʾ�ж���BL */
    protected IG110BL ig110BL;
    
    /** ���̲�ѯ��������ʵ��BL */
    protected IG111BL ig111BL;
    
    /** �����鶨�����BL */
    protected IG480BL ig480BL;
    
	/**
	 * @param ig480bl the �����鶨�����BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * ����ģ����Ϣ�����趨
	 * @param ig259BL ����ģ����Ϣ����
	 */
	public void setIg259BL(IG259BL ig259bl) {
		ig259BL = ig259bl;
	}

	/**
	 * ����������Ϣ�����趨
	 * @param ig380BL ����������Ϣ����
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * ���̱���������Ϣ�����趨
	 * @param ig007BL ���̱���������Ϣ����
	 */
	public void setIg007BL(IG007BL ig007bl) {
		ig007BL = ig007bl;
	}

	/**
	 * ���̲�����Ϣ�����趨
	 * @param ig105BL ���̲�����Ϣ����
	 */
	public void setIg105BL(IG105BL ig105bl) {
		ig105BL = ig105bl;
	}

	/**
	 * ��ɫ����BL�趨
	 * @param ig001BL ��ɫ����BL
	 */
	public void setIg001BL(IG001BL ig001bl) {
		ig001BL = ig001bl;
	}

	/**
	 * ���̲鿴��ɫ��Ȩ����BL�趨
	 * @param ig701BL ���̲鿴��ɫ��Ȩ����BL
	 */
	public void setIg701BL(IG701BL ig701bl) {
		ig701BL = ig701bl;
	}

	/**
	 * ����ǰ������BL�趨
	 * @param ig413BL ����ǰ������BL
	 */
	public void setIg413BL(IG413BL ig413bl) {
		ig413BL = ig413bl;
	}

	/**
	 * ����״̬��ϢBL�趨
	 * @param ig333BL ����״̬��ϢBL
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}

	/**
	 * ����״̬_��������ϢBL�趨
	 * @param ig222BL ����״̬_��������ϢBL
	 */
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}

	/**
	 * ���̱���ʼ���¼�������ϢBL�趨
	 * @param ig373BL ���̱���ʼ���¼�������ϢBL
	 */
	public void setIg373BL(IG373BL ig373bl) {
		ig373BL = ig373bl;
	}

	/**
	 * ����������ʾBL�趨
	 * @param ig243BL ����������ʾBL
	 */
	public void setIg243BL(IG243BL ig243bl) {
		ig243BL = ig243bl;
	}

	/**
	 * ����״̬�ɷ��ɽ�ɫ����BL�趨
	 * @param ig298BL ����״̬�ɷ��ɽ�ɫ����BL
	 */
	public void setIg298BL(IG298BL ig298bl) {
		ig298BL = ig298bl;
	}

	/**
	 * ���̽�ɫ������ȨBL�趨
	 * @param ig213BL ���̽�ɫ������ȨBL
	 */
	public void setIg213BL(IG213BL ig213bl) {
		ig213BL = ig213bl;
	}

	/**
	 * ״̬�����߹����������Ͷ���BL�趨
	 * @param ig911BL ״̬�����߹����������Ͷ���BL
	 */
	public void setIg911BL(IG911BL ig911bl) {
		ig911BL = ig911bl;
	}

	/**
	 * ����״̬�ɷ��ɻ�������BL�趨
	 * @param ig299BL ����״̬�ɷ��ɻ�������BL
	 */
	public void setIg299BL(IG299BL ig299bl) {
		ig299BL = ig299bl;
	}

	/**
	 * ȱʡ״̬�����߹����������Ͷ���BL�趨
	 * @param ig931BL ȱʡ״̬�����߹����������Ͷ���BL
	 */
	public void setIg931BL(IG931BL ig931bl) {
		ig931BL = ig931bl;
	}

	/**
	 * ������ΧBL�趨
	 * @param ig123BL ������ΧBL
	 */
	public void setIg123BL(IG123BL ig123bl) {
		ig123BL = ig123bl;
	}

	/**
	 * ����״̬��ť����BL�趨
	 * @param ig156BL ����״̬��ť����BL
	 */
	public void setIg156BL(IG156BL ig156bl) {
		ig156BL = ig156bl;
	}

	/**
	 * ���̱�����BL�趨
	 * @param ig286BL ���̱�����BL
	 */
	public void setIg286BL(IG286BL ig286bl) {
		ig286BL = ig286bl;
	}

	/**
	 * ����״̬_�����߰�ťBL�趨
	 * @param ig132BL ����״̬_�����߰�ťBL
	 */
	public void setIg132BL(IG132BL ig132bl) {
		ig132BL = ig132bl;
	}

	/**
	 * ����״̬_�����߰�ťvwBL�趨
	 * @param ig221BL ����״̬_�����߰�ťvwBL
	 */
	public void setIg221BL(IG221BL ig221bl) {
		ig221BL = ig221bl;
	}

	/**
	 * ����״̬_������_Ȩ����ϢBL�趨
	 * @param ig881BL ����״̬_������_Ȩ����ϢBL
	 */
	public void setIg881BL(IG881BL ig881bl) {
		ig881BL = ig881bl;
	}

	/**
	 * ��������ϢBL�趨
	 * @param ig273BL ��������ϢBL
	 */
	public void setIg273BL(IG273BL ig273bl) {
		ig273BL = ig273bl;
	}

	/**
	 * ȱʡ�����˰�ť����BL�趨
	 * @param ig725BL ȱʡ�����˰�ť����BL
	 */
	public void setIg725BL(IG725BL ig725bl) {
		ig725BL = ig725bl;
	}

	/**
	 * ����ҳ��BL�趨
	 * @param ig126BL ����ҳ��BL
	 */
	public void setIg126BL(IG126BL ig126bl) {
		ig126BL = ig126bl;
	}

	/**
	 * ����ȱʡ�����߱���Ȩ��BL�趨
	 * @param ig699BL ����ȱʡ�����߱���Ȩ��BL
	 */
	public void setIg699BL(IG699BL ig699bl) {
		ig699BL = ig699bl;
	}

	/**
	 * ��ͨ��������Ϣ��ϢBL�趨
	 * @param ig202BL ��ͨ��������Ϣ��ϢBL
	 */
	public void setIg202BL(IG202BL ig202bl) {
		ig202BL = ig202bl;
	}

	/**
	 * ���̲鿴��ɫBL�趨
	 * @param ig700BL ���̲鿴��ɫBL
	 */
	public void setIg700BL(IG700BL ig700bl) {
		ig700BL = ig700bl;
	}

	/**
	 * ����֪ͨ�����趨BL�趨
	 * @param ig212BL ����֪ͨ�����趨BL
	 */
	public void setIg212BL(IG212BL ig212bl) {
		ig212BL = ig212bl;
	}

	/**
	 * ����֪ͨ����֪ͨ��BL�趨
	 * @param ig237BL ����֪ͨ����֪ͨ��BL
	 */
	public void setIg237BL(IG237BL ig237bl) {
		ig237BL = ig237bl;
	}

	/**
	 * �ⲿ�����趨
	 * @param ig992BL �ⲿ����
	 */
	public void setIg992BL(IG992BL ig992bl) {
		ig992BL = ig992bl;
	}
	
    public void setIg561BL(IG561BL ig561bl) {
        ig561BL = ig561bl;
    }

    public void setIg560BL(IG560BL ig560bl) {
        ig560BL = ig560bl;
    }

	/**
	 * ���̿ɵ����������趨
	 * @param ig258BL ���̿ɵ���������
	 */
	public void setIg258BL(IG258BL ig258bl) {
		ig258BL = ig258bl;
	}

	/**
	 * ����״̬BL�趨
	 * @param ig233BL ����״̬BL
	 */
	public void setIg233BL(IG233BL ig233bl) {
		ig233BL = ig233bl;
	}

	/**
	 * ����ѯ����BL�趨
	 * @param ig108BL ����ѯ����BL
	 */
	public void setIg108BL(IG108BL ig108bl) {
		ig108BL = ig108bl;
	}

	/**
	 * ֪ͨ���Ի�����ϢBL�趨
	 * @param ig334BL ֪ͨ���Ի�����ϢBL
	 */
	public void setIg334BL(IG334BL ig334bl) {
		ig334BL = ig334bl;
	}

	/**
	 * ������BL�趨
	 * @param ig335BL ������BL
	 */
	public void setIg335BL(IG335BL ig335bl) {
		ig335BL = ig335bl;
	}
	
	/**
	 * ����ɫ�޶�BL�趨
	 * @param ig008BL ����ɫ�޶�BL
	 */
	public void setIg008BL(IG008BL ig008bl) {
		ig008BL = ig008bl;
	}

	/**
	 * ���̲�ѯ��ʾ�ж���BL�趨
	 * @param ig110BL ���̲�ѯ��ʾ�ж���BL
	 */
	public void setIg110BL(IG110BL ig110bl) {
		ig110BL = ig110bl;
	}

	/**
	 * ���̲�ѯ��������ʵ��BL�趨
	 * @param ig111BL ���̲�ѯ��������ʵ��BL
	 */
	public void setIg111BL(IG111BL ig111bl) {
		ig111BL = ig111bl;
	}

	/**
	 * <p>
	 * �µ�����ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ�����ģ����Ϣ����ʵ��ȡ��
	 */
	
	public IG259TB getProcessTemplateTBInstance() {
		return ig259BL.getIG259TBInstance();
	}
	
	/**
	 * <p>
	 * �µ�����������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ�����������Ϣ����ʵ��ȡ��
	 */
	
	public IG380TB getProcessDefinitionTBInstance() {
		return ig380BL.getIG380TBInstance();
	}
	/**
	 * <p>
	 * �µ����̱���������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ����̱���������Ϣ����ʵ��ȡ��
	 */
	
	public IG007TB getIG007TBInstance() {
		return ig007BL.getIG007TBInstance();
	}
	
	/**
	 * ���ܣ���ȡʹ���е�����ģ����Ϣ
	 * @param prtype ����ģ������
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	
	public IG259Info searchProcessTemplateByPrType(String prtype){
		return ig259BL.searchIG259ByPrType(prtype);
	}
	
	/**
	 * ���ܣ�������������ģ����Ϣ
	 * @param cond ����ģ����Ϣ��������
	 * @return ����ģ����Ϣ����б�
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond) {
		return ig259BL.searchIG259Info(cond);
	}
	
	/**
	 * ���ܣ�������������ģ����Ϣ����ҳ��ѯ�ã�
	 * @param cond ����ģ����Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ����ģ����Ϣ����б�
	 */
	public List<IG259Info> searchProcessTemplate(IG259SearchCond cond, int start, int count){
		return ig259BL.searchIG259Info(cond, start, count);
	}
	
	/**
	 * ���ܣ���������ģ��ID��ȡ����ģ��
	 * @param ptid ����ģ��ID
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	public IG259Info searchProcessTemplateByKey(Integer ptid) throws BLException{
		return ig259BL.searchIG259InfoByKey(ptid);
	}
	
	/**
	 * ���ܣ���������ģ�崦��
	 * 
	 * @param processTemplate ��������
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	
	public IG259Info registProcessTemplate(IG259Info processTemplate)throws BLException{
		return ig259BL.registIG259Info(processTemplate);
	}
	
	
	/**
	 * ���ܣ�ɾ������ģ�崦��
	 * 
	 * @param ptid ����ģ��ID
	 * @return
	 * @throws BLException
	 */
	
	public void deleteProcessTemplateByKey(Integer ptid) throws BLException{
		ig259BL.deleteIG259InfoByKey(ptid);
	}
	
	/**
	 * ���ܣ��������ģ����Ϣ����
	 * 
	 * @param processTemplate �������
	 * @return ����ģ����Ϣ
	 * @throws BLException
	 */
	
	public IG259Info updateProcessTemplate(IG259Info processTemplate)throws BLException{
		return ig259BL.updateIG259Info(processTemplate);
	}
	
	
	/**
	 * ���ܣ���������ģ��ID��ȡ���̶��弯��
	 * @param processTemplateId ����ģ��ID
	 * @return  ���̶�����Ϣ����
	 */
	
	public List<IG380Info> searchProcessDefinitionsByPtid(Integer processTemplateId){
		return ig380BL.searchIG380InfoByPtid(processTemplateId);
	}
	
	/**
	 * ���ܣ��������̶���ID��ȡ���̶���
	 * @param pdid ���̶���ID
	 * @return ���̶�����Ϣ
	 * @throws BLException
	 */
	public IG380Info searchProcessDefinitionByKey(String pdid) throws BLException {
		return ig380BL.searchIG380InfoByKey(pdid);
	}
	/**
	 * ���ܣ����������鶨��ID��ȡ�����鶨��
	 * @param pgdid ���̶���ID
	 * @return �����鶨����Ϣ
	 * @throws BLException
	 */
	public IG480Info searchGroupProcessDefinitionByKey(String pgdid) throws BLException {
		return ig480BL.searchIG480ByPK(pgdid);
	}
	
	/**
	 * ���ܣ����ݼ�������ȡ�����̶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getProcessDefinitionSearchCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchCount(cond);
	}
	
	/**
	 * ���ܣ����ݼ�������ȡ�����̶�����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond){
		return ig380BL.searchIG380Info(cond);
	}
	/**
	 * ���ܣ����ݼ�������ȡ�������鶨����Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG480Info> searchIG480ProcessDefinition(IG480SearchCond cond){
		return ig480BL.searchIG480(cond);
	}
	
	/**
	 * ���ܣ����ݼ�������ȡ�����̶�����Ϣ�б���ҳ��ѯʹ�ã�
	 * 
	 * @param cond ���̶����������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchProcessDefinition(IG380SearchCond cond,int start,int count){
		return ig380BL.searchIG380Info(cond,start,count);
	}
	
	/**
	 * ���ܣ����̶�����Ϣ
	 * 
	 * @param processDefinition ���̶�����Ϣ
	 * @return ���̶���
	 * @throws BLException
	 */
	public IG380Info registProcessDefinition(IG380Info processDefinition) throws BLException{
		return ig380BL.registIG380Info(processDefinition);
	}
	/**
	 * ���ܣ�ɾ�����̶�����Ϣ
	 * 
	 * @param pdid ���̶�������
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessDefinitionByKey(String pdid) throws BLException{
		ig380BL.deleteIG380InfoByKey(pdid);
	}
	/**
	 * ���ܣ��������̶�����Ϣ
	 * 
	 * @param processDefinition ���̶�����Ϣ
	 * @return ���̶���
	 * @throws BLException
	 */
	public IG380Info updateProcessDefinition(IG380Info processDefinition) throws BLException{
		return ig380BL.updateIG380Info(processDefinition);
	}
	/**
	 * ���ܣ����������鶨����Ϣ
	 * 
	 * @param processDefinition �����鶨����Ϣ
	 * @return �����鶨��
	 * @throws BLException
	 */
	public IG480Info updateGroupProcessDefinition(IG480Info processDefinition) throws BLException{
		return ig480BL.updateIG480(processDefinition);
	}
	
	/**
	 * ���ܣ����ݼ�������ȡ����ʷ���̶�����Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ��ʷ���̶�����Ϣ�������
	 */
	public int getProcessDefinitionSearchHistoryCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchHistoryCount(cond);
	}
	
	/**
	 * ���ܣ����ݼ�������ȡ����ʷ���̶�����Ϣ�б���ҳ��ѯʹ�ã�
	 * 
	 * @param cond ���̶����������
	 * @param start ������ʼ����
	 * @param count ��������
	 * @return ��ʷ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchHistoryProcessDefinition(IG380SearchCond cond,int start,int count) throws BLException {
		return ig380BL.searchHistoryIG380Info(cond, start, count);
	}
	
	/**
	 * ���̶�������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getProcessDefinitionPK(String firstsite,String pdsequence) {
		String pdid = ig380BL.getPdidNextValue(firstsite,pdsequence);
		while(true) {
			IG380SearchCondImpl cond_IG380 = new IG380SearchCondImpl();
			cond_IG380.setPdid_like(pdid.substring(0, 5));
			List<IG380Info> lst_IG380 = searchProcessDefinition(cond_IG380);
			if(lst_IG380.isEmpty()) {
				break;
			}
			pdid = getProcessDefinitionPK(firstsite,pdsequence);
		}
		return pdid;
	}
	/**
	 * �����鶨������ֵȡ��
	 * @param firstsite ������λ��ʶ
	 * @param pdsequence ��������
	 * @return PDID����ֵ
	 */
	public String getIG480ProcessDefinitionPK(String firstsite,String pdsequence) {
		String pgdid = ig480BL.getPdidNextValue(firstsite,pdsequence);
		while(true) {
			IG480SearchCondImpl cond_IG480 = new IG480SearchCondImpl();
			cond_IG480.setPgdid_like(pgdid.substring(0, 5));
			List<IG480Info> lst_IG480 = searchIG480ProcessDefinition(cond_IG480);
			if(lst_IG480.isEmpty()) {
				break;
			}
			pgdid = getProcessDefinitionPK(firstsite,pdsequence);
		}
		return pgdid;
	}
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�������
	 * 
	 * @param cond ���̶�����Ϣ��������
	 * @return ���̶�����Ϣ�������
	 */
	public int getProcessDefinitionSearchLastCount(IG380SearchCond cond){
		return ig380BL.getIG380InfoSearchLastCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ�����̶���������Ϣ�б�
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG380Info> searchLastProcessDefinition(IG380SearchCond cond, int start, int count){
		return ig380BL.searchLastIG380Info(cond, start, count);
	}
	
	/**
	 * ���ݼ�������ȡ����ط�����Զ����������͵���Ϣ
	 * 
	 * @param cond ���̶����������
	 * @return ���̶�����Ϣ�б�
	 */
	public List<IG913Info> searchLastIG380AndIG911Info(IG913SearchCond cond){
		return ig380BL.searchLastIG380AndIG911Info(cond);
	}
	
	/**
     * ���ݼ�������ȡ��ȱʡȨ�޵���ط�����Զ����������͵���Ϣ
     * 
     * @param cond ���̶����������
     * @return ���̶�����Ϣ�б�
     */
    public List<IG913Info> searchLastIG380AndIG931Info(IG913SearchCond cond){
    	return ig380BL.searchLastIG380AndIG931Info(cond);
    }
    
	/**
	 * ���̶��岻���ڼ��
	 * 
	 * @param ptid ����ģ��ID
	 * @param pdname ���̶�������
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistProcessDefinition(Integer ptid, String pdname) throws BLException{
		ig380BL.checkNotExistIG380Info(ptid, pdname);
	}
	
	/**
	 * ���̶������洦��
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeProcessDefVersion(String pdid) throws BLException{
		String newPdid = ig380BL.upgradeProcessDefVersion(pdid);
		copyStatusFormDefinition(pdid,newPdid);
	}
	/**
	 * �����鶨�����洦��洢����
	 * 
	 * @param pdid ���̶���ID
	 */
	public void upgradeGroupProcessDefVersion(String pgdid) throws BLException{
		ig480BL.upgradeGroupProcessDefVersion(pgdid);
	}
	
	/**
	 * ���̶��帴�ƴ���
	 * 
	 * @param pdid ���̶���ID
	 */
	public String copyProcessDefVersion(String pdid) throws BLException{
		IG380Info pd = searchProcessDefinitionByKey(pdid);
		IG259Info pt = searchProcessTemplateByKey(pd.getPtid());
		String newPdid = ig380BL.copyProcessDefVersion(pdid,pt.getPdsequence());
		copyStatusFormDefinition(pdid,newPdid);
		return newPdid;
	}
	
	private void copyStatusFormDefinition(String pdid, String newPdid) throws BLException {
		//��ѯ״̬��������
		IG560SearchCondImpl cond = new IG560SearchCondImpl();
		cond.setPidid_l(pdid);
		List<IG560Info> list = ig560BL.searchIG560(cond);
		for(IG560Info info:list){
			IG560TB tb = new IG560TB();
			tb.setPidid(info.getPidid().replace(pdid, newPdid));
			tb.setPsdid(info.getPsdid().replace(pdid, newPdid));
			tb.setDfvalue(info.getDfvalue());
			tb.setUsedtoall(info.getUsedtoall());
			ig560BL.registIG560(tb);
		}
	}

	/**
	 * �����鶨�帴�ƴ���
	 * 
	 * @param pgdid �����鶨��ID
	 */
	public String copyGroupProcessDefVersion(String pgdid) throws BLException{
		IG480Info pd = searchGroupProcessDefinitionByKey(pgdid);
		IG259Info pt = searchProcessTemplateByKey(pd.getPtid());
		return ig480BL.copyGroupProcessDefVersion(pgdid,pt.getPdsequence());
	}
	
	/**
	 * ���ܣ��������̶���ID��ȡ���̱������弯��
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱������弯��
	 */
	
	public List<IG007Info> searchProcessInfoDefsByPdid(String processDefinitionId){
		return ig007BL.searchIG007InfoByPdid(processDefinitionId);
	}
	/**
	 * ���ܣ��������̶���ID��ȡ���̱������弯�ϣ�������ȱʡ������ƽ̨������
	 * @param processDefinitionId ���̶���ID
	 * @return  ���̱������弯��
	 */
	
	public List<IG007Info> searchProcessInfoDefsNoDefault(String processDefinitionId){
		return ig007BL.searchIG007InfoNoDefault(processDefinitionId);
	}
	
	/**
	 * ����״̬����������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG007Info> searchIG007InfoRun(IG007SearchCond cond){
		return ig007BL.searchIG007InfoRun(cond);
	}
	/**
	 * ���ܣ����̱����������������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getProcessInfoDefSearchCount(IG007SearchCond cond){
		return ig007BL.getIG007InfoSearchCount(cond);
	}
	/**
	 * ���ܣ����̱�������������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond){
		return ig007BL.searchIG007Info(cond);
	}
	
	/**
	 * ���ܣ����̱�������������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG007Info> searchProcessInfoDef(IG007SearchCond cond, int start, int count){
		return ig007BL.searchIG007Info(cond, start, count);
	}
	/**
	 * ���ܣ��������̱�������ID��ȡ���̱���������Ϣ
	 * 
	 * @param pidid ���̱�������ID
	 * @return ���̱���������Ϣ
	 * @throws BLException 
	 */
	public IG007Info searchProcessInfoDefByKey(String pidid) throws BLException {
		return ig007BL.searchIG007InfoByKey(pidid);
	}
	
	/**
	 * ���ܣ����̱���������Ϣ��¼����
	 * 
	 * @param processInfoDef ��¼����
	 * @return ���̱���������Ϣ
	 * @throws BLException
	 */
	public IG007Info registProcessInfoDef(IG007Info processInfoDef) throws BLException{
		return ig007BL.registIG007Info(processInfoDef);
	}
	
	/**
	 * ���ܣ����̱���������Ϣ���´���
	 * 
	 * @param processInfoDef ��������
	 * @return ���̱���������Ϣ
	 * @throws BLException
	 */
	public IG007Info updateProcessInfoDef(IG007Info processInfoDef) throws BLException{
		return ig007BL.updateIG007Info(processInfoDef);
	}
	
	/**
	 * ���ܣ����̱���������Ϣɾ������
	 * 
	 * @param pidid ɾ��ȫ�ֱ�������
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDefByKey(String pidid) throws BLException{
		ig007BL.deleteIG007InfoByKey(pidid);
	}
	
	/**
	 * ���ܣ����̱���������Ϣɾ������
	 * 
	 * @param processInfoDef ���̱�������
	 * @return
	 * @throws BLException
	 */
	public void deleteProcessInfoDef(IG007Info processInfoDef) throws BLException{
		ig007BL.deleteIG007Info(processInfoDef);
	}
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ������
	 * @param pdid ���̶���ID
	 * @return  Map<String,List<IG337Info>> ���̱���ȱʡ������
	 */
	
	public Map<String,List<IG337Info>> getDefaultApprovors(String pdid){
		return ig007BL.getDefaultApprovors(pdid);
	}
	
	/**
	 * ����������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PIDID����ֵ
	 */
	public String getProcessInfoDefPK(String pdid){
		return ig007BL.getPididSequenceNextValue(pdid);
	}
	
	/**
	 * ���ܣ���ȡ���̱���ȱʡ����������(ppcomment��ȡ֮����Ҫ���)
	 * @param pdid ���̶���ID
	 * @return  List<IG337Info> ���̱���ȱʡ����������
	 */
	public List<IG337Info> searchDefaultApprovorDispatcherByPdid(String pdid){
		return ig007BL.searchDefaultApprovorDispatcherByPdid(pdid);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<IG105Info> searchProcessStrategyDef(IG105SearchCond cond) {
		return ig105BL.searchIG105Info(cond);
	}
	
	/**
	 * ��ѯ��ɫ����
	 * @param cond ��ѯ����
	 * @return ��ɫ������Ϣ����
	 * @throws BLException
	 */
	public List<IG001Info> searchOARoleConfig(IG001SearchCond cond) throws BLException {
		return ig001BL.searchIG001(cond);
	}
	
	/**
	 * ɾ����ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @throws BLException
	 */
	public void deleteOARoleConfig(IG001Info entity) throws BLException {
		ig001BL.deleteIG001(entity);
	}
	
	/**
	 * ɾ����ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @throws BLException
	 */
	public void deleteOARoleConfig(List<IG001Info> entitys) throws BLException{
		ig001BL.deleteIG001(entitys);
	}
	
	/**
	 * ע���ɫ����
	 * @param entity ��ɫ������Ϣ
	 * @return ��ɫ������Ϣ
	 * @throws BLException
	 */
	public IG001Info registOARoleConfig(IG001Info entity) throws BLException {
		return ig001BL.registIG001(entity);
	}
	
	/**
	 * �������Ͳ�ѯ���ý�ɫ����
	 * @param type ����
	 * @return
	 * @throws BLException
	 */
	public List<Integer> searchOARoleidByType(String type) throws BLException {
		List<Integer> roles = null;
		IG001SearchCondImpl cond = new IG001SearchCondImpl();
		cond.setProtype_eq(type);
		List<IG001Info> list = ig001BL.searchIG001(cond);
		if(list!=null){
			for(IG001Info pro:list){
				if(roles == null){
					roles = new ArrayList<Integer>();
				}
				roles.add(pro.getProroleid());
			}
		}
		return roles;
	}
	
	/**
	 * ��ɫ��Ȩ������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG701Info> searchRoleForm(IG701SearchCond cond){
		return ig701BL.searchIg701(cond);
	}
	
	/**
	 * ע���ɫ��Ȩ��
	 * @param entity ��ɫ��Ȩ��ʵ��
	 * @return ��ɫ��Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG701Info registRoleForm(IG701Info entity) throws BLException {
		return ig701BL.registIg701(entity);
	}
	
	/**
	 * ��������ɾ����ɫ��Ȩ��
	 * @param pk
	 * @throws BLException
	 */
	public void deleteRoleForm(IG701PK pk) throws BLException {
		ig701BL.deleteIg701ByPK(pk);
	}
	
	/**
	 * �¼��������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG413Info> searchWorkFlowEventHandler(IG413SearchCond cond){
		return ig413BL.searchIG413Info(cond);
	}
	
	/**
	 * �¼���������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getWorkFlowEventHandlerPK(String psdid){
		return ig413BL.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * ע���¼�����
	 * @param entity �¼�����ʵ��
	 * @return �¼�����ʵ��
	 * @throws BLException
	 */
	public IG413Info registWorkFlowEventHandler(IG413Info entity) throws BLException{
		return ig413BL.registIG413Info(entity);
	}
	
	/**
	 * �����¼�����
	 * @param entity �¼�����ʵ��
	 * @return �¼�����ʵ��
	 * @throws BLException
	 */
	public IG413Info updateWorkFlowEventHandler(IG413Info entity) throws BLException{
		return ig413BL.updateIG413Info(entity);
	}
	
	/**
	 * ��������ɾ���¼�����
	 * @param key �¼���������
	 * @throws BLException
	 */
	public void deleteWorkFlowEventHandlerByKey(String key) throws BLException{
		ig413BL.deleteIG413Info(key);
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getProcessStatusDefSearchCount(IG333SearchCond cond) throws BLException{
		return ig333BL.getIG333InfoSearchCount(cond);
	}
	
	/**
	 * ״̬��Ϣ����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG333Info> searchProcessStatusDef(IG333SearchCond cond) {
		return ig333BL.searchIG333Info(cond);
	}
	
	/**
	 * �ɱ����ɽڵ����
	 * @param psdid ���ɽڵ㶨��id
	 * @param pbdid ������ť
	 * @return �������
	 * @throws BLException
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid,String pbdid) throws BLException{
		return ig333BL.searchAssignedStatusDef(psdid, pbdid);
	}
	
	/**
	 * ��������״̬����
	 * @param psdid ����
	 * @return ״̬������Ϣ
	 * @throws BLException
	 */
	public IG333Info searchProcessStatusDefByKey(String psdid) throws BLException{
		return ig333BL.searchIG333InfoByKey(psdid);
	}
	
	/**
	 * ָ��״̬�����Ŀɵ��������ߵ�״̬����ȡ��
	 * @param psdid ״̬ID
	 * @return ״̬����
	 */
	public List<IG333Info> searchAdjustStatus(String psdid){
		return ig333BL.searchAdjustStatus(psdid);
	}
	
	/**
	 * ���ܣ�����״̬code��ȡָ���������͵�״̬ID
	 * @param pdid ���̶���ID
	 * @param psdcode ����״̬��ʶ
	 * @return ����״̬ID
	 * @throws BLException 
	 */
	public String searchProcessStatusKey(String pdid,String psdcode) throws BLException{
		return ig333BL.getIG333InfoIdByStatus(pdid, psdcode);
	}
	
	/**
	 * ��������״̬����
	 * @param entity ����״̬����ʵ��
	 * @return ����״̬����ʵ��
	 * @throws BLException
	 */
	public IG333Info registProcessStatus(IG333Info entity) throws BLException {
		return ig333BL.registIG333Info(entity);
	}
	
	/**
	 * ����״̬��������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return ����״̬��������ֵ
	 */
	public String getProcessStatusDefPK(String pdid_one) {
		return ig333BL.getPsdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * ��������ɾ��״̬����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessStatusDefByPK(String pk) throws BLException {
		ig333BL.deleteIG333InfoByKey(pk);
	}
	
	/**
	 * ��������״̬����
	 * @param entity ����״̬����ʵ��
	 * @return ����״̬����ʵ��
	 * @throws BLException
	 */
	public IG333Info updateProcessStatus(IG333Info entity) throws BLException {
		return ig333BL.updateIG333Info(entity);
	}
	
	/**
	 * ���ܣ���ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid,String pdid){
		return ig222BL.searchInitProcessParticipantRole(userid, pdid);
	}
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid){
		return ig222BL.searchVisibleButton(psdid, roleid);
	}
	
	/**
	 * �����˶������
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG222Info> searchParticipantDef(IG222SearchCond cond){
		return ig222BL.searchIG222Info(cond);
	}
	
	/**
	 * ����������ѯ�����˶�����Ϣ
	 * @param pk ����
	 * @return �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info searchParticipantDefByKey(String pk) throws BLException{
		return ig222BL.searchIG222InfoByKey(pk);
	}
	
	/**
	 * �����˶�������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return �����˶�������ֵ
	 */
	public String getParticipantDefPK(String pdid_one) throws BLException {
		return ig222BL.getPpdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * ���������˶�����Ϣ
	 * @param entity �����˶���ʵ��
	 * @return �����˶���ʵ��
	 * @throws BLException
	 */
	public IG222Info registParticipantDef(IG222Info entity) throws BLException {
		return ig222BL.registIG222Info(entity);
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getParticipantSearchCount(IG222SearchCond cond) throws BLException {
		return ig222BL.getIG222InfoSearchCount(cond);
	}
	
	/**
	 * ɾ�������˶�����Ϣ
	 * @param entity �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info deleteParticipantDefByKey(String pk) throws BLException{
		return ig222BL.deleteIG222Info(pk);
	}
	
	/**
	 * ���²����˶�����Ϣ
	 * @param entity �����˶�����Ϣ
	 * @return �����˶�����Ϣ
	 * @throws BLException
	 */
	public IG222Info updateParticipantDef(IG222Info entity) throws BLException {
		return ig222BL.updateIG222Info(entity);
	}
	
	/**
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getParticipantDefSearchCount(IG222SearchCond cond) throws BLException {
		return ig222BL.getIG222InfoSearchCount(cond);
	}
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid){
		return ig222BL.searchRoleCommitNormalAuth(psdid);
	}
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid){
		return ig222BL.searchRoleCommitDefaultAuth(psdid);
	}
	
	/**
	 * ����ʼ���¼�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG373Info> searchInitFormEventHandler(IG373SearchCond cond){
		return ig373BL.searchIG373Info(cond);
	}
	
	/**
	 * ����ʼ���¼�����ֵȡ��
	 * @param ����״̬ID
	 * @return ����ʼ���¼�����ֵ
	 */
	public String getInitFormEventHandlerPK(String psdid) throws BLException {
		return ig373BL.getPiididSequenceNextValue(psdid);
	}
	
	/**
	 * ע�����ʼ���¼�
	 * @param entity ����ʼ���¼�ʵ��
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info registInitFormEventHandler(IG373Info entity) throws BLException {
		return ig373BL.registIG373Info(entity);
	}
	
	/**
	 * ���±���ʼ���¼�
	 * @param entity ����ʼ���¼�ʵ��
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info updateInitFormEventHandler(IG373Info entity) throws BLException {
		return ig373BL.updateIG373Info(entity);
	}
	
	/**
	 * ������������ʼ���¼�
	 * @param pk ����
	 * @return ����ʼ���¼�ʵ��
	 * @throws BLException
	 */
	public IG373Info searchInitFormEventHandlerByKey(String pk) throws BLException {
		return ig373BL.searchIG373InfoByPK(pk);
	}
	
	/**
	 * ��������ɾ������ʼ���¼�
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteInitFormEventHandlerByKey(String pk) throws BLException {
		ig373BL.deleteIG373InfoByPK(pk);
	}
	
	/**
	 * ���̱��ⶨ�����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG243Info> searchProcessTitleDef(IG243SearchCond cond){
		return ig243BL.searchIG243Info(cond);
	}
	
	/**
	 * ���̱��ⶨ������ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PTDID����ֵ
	 */
	public String getProcessTitleDefPK(String pdid_one){
		return ig243BL.getPtdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * �������̱��ⶨ��
	 * @param entity ���̱��ⶨ��ʵ��
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info registProcessTitleDef(IG243Info entity) throws BLException {
		return ig243BL.registIG243Info(entity);
	}
	
	/**
	 * ������ѯ���̱��ⶨ��
	 * @param pk ����
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info searchProcessTitleDefByPK(String pk) throws BLException {
		return ig243BL.searchIG243InfoByPK(pk);
	}
	
	/**
	 * �������̱��ⶨ��
	 * @param entity ���̱��ⶨ��ʵ��
	 * @return ���̱��ⶨ��ʵ��
	 * @throws BLException
	 */
	public IG243Info updateProcessTitleDef(IG243Info entity) throws BLException {
		return ig243BL.updateIG243Info(entity);
	}
	
	/**
	 * ����״̬������ѯ�ɱ����ɲ�����(��ɫ)
	 * @param psdid ״̬����
	 * @return �������
	 * @throws BLException
	 */
	public List<IG298Info> searchProcessStatusRoleDefInfoByPsdid(String psdid) throws BLException{
		return ig298BL.searchIG298Info(psdid);
	}
	
	/**
	 * �ɱ����ɲ�����(��ɫ)ʵ�����ڼ��
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ʵ��
	 * @throws BLException
	 */
	public IG298Info checkProcessStatusRoleDefInfo(String psdid, Integer roleid) throws BLException{
		return ig298BL.checkIG298Info(psdid, roleid);
	}
	
	/**
	 * �ɱ����ɲ�����(��ɫ)����ֵȡ��
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɲ�����(��ɫ)����ֵ
	 */
	public String getProcessStatusRoleDefInfoPK(String psdid) throws BLException {
		return ig298BL.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��ɱ����ɲ�����(��ɫ)
	 * @param entity �ɱ����ɲ�����(��ɫ)ʵ��
	 * @return �ɱ����ɲ�����(��ɫ)ʵ��
	 * @throws BLException
	 */
	public IG298Info registProcessStatusRoleDefInfo(IG298Info entity) throws BLException {
		return ig298BL.registIG298Info(entity);
	}
	
	/**
	 * ɾ���ɱ����ɲ�����(��ɫ)
	 * @param entity �ɱ����ɲ�����(��ɫ)ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusRoleDefInfoByKey(String pk) throws BLException {
		ig298BL.deleteIG298InfoByPK(pk);
	}
	
	/**
	 * �ɱ����ɵĽ�ɫ��������
	 * @param pdid ���̶���ID
	 * @param psdid ����״̬ID
	 * @return �ɱ����ɵĽ�ɫ�б�
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid) {
		return ig298BL.searchToBeAssignRole(pdid, psdid);
	}
	
	/**
	 * ����״̬������ѯ�ɱ����ɲ�����(����)
	 * @param psdid ״̬����
	 * @return �������
	 * @throws BLException
	 */
	public List<IG299Info> searchProcessStatusOrgDefInfoByPsdid(String psdid) throws BLException{
		return ig299BL.searchIG299Info(psdid);
	}
	
	/**
	 * �ɱ����ɵĻ�����������
	 * @param pdid ��������ID
	 * @param levellen �����ĵ�ǰ����
	 * @param psdid ����״̬�ڵ�ID
	 * @return �ɱ����ɵĻ����б�
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid) {
		return ig299BL.searchToBeAssignOrg(pdid, levellen, psdid);
	}
	
	/**
	 * �ɱ����ɵĻ�������ֵȡ��
	 * @param ����״̬ID
	 * @return �ɱ����ɵĻ�������ֵ
	 */
	public String getProcessStatusOrgDefInfoPK(String psdid) throws BLException {
		return ig299BL.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��ɱ����ɵĻ���
	 * @param entity �ɱ����ɵĻ���ʵ��
	 * @return �ɱ����ɵĻ���ʵ��
	 * @throws BLException
	 */
	public IG299Info registProcessStatusOrgDefInfo(IG299Info entity) throws BLException {
		return ig299BL.registIG299(entity);
	}
	
	/**
	 * ��������ɾ���ɱ����ɵĻ���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessStatusOrgDefInfoByKey(String pk) throws BLException {
		ig299BL.deleteIG299ByPK(pk);
	}
	
	/**
	 * ��ɫ��Χ����
	 * @param cond ��������
	 * @return �������
	 */
	public List<IG213Info> searchProcessRoleTypeDef(IG213SearchCond cond) {
		return ig213BL.searchIG213Info(cond);
	}
	
	/**
	 * ��ɫ��Χ����ֵȡ��
	 * @param ���̶���ID
	 * @return ��ɫ��Χ����ֵ
	 */
	public String getProcessRoleTypeDefPK(String pdid_one) throws BLException {
		return ig213BL.getPrtdidSequenceNextValue(pdid_one);
	}
	
	/**
	 * ע���ɫ��Χ��Ϣ
	 * @param entity ��ɫ��Χ��Ϣʵ��
	 * @return ��ɫ��Χ��Ϣʵ��
	 * @throws BLException
	 */
	public IG213Info registProcessRoleTypeDef(IG213Info entity) throws BLException {
		return ig213BL.registIG213Info(entity);
	}
	
	/**
	 * ��������ɾ����ɫ��Χ��Ϣ
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessRoleTypeDefByKey(String pk) throws BLException {
		ig213BL.deleteIG213InfoByKey(pk);
	}
	
	/**
     * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg911RelevantPdidCount(IG911SearchCond cond) {
    	return ig911BL.getIg911RelevantPdidCount(cond);
    }
    
	/**
	 * ��ط�������״̬Ϊ����״̬��״̬��������ط�����Ϣȡ��
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG911Info> searchIg911RelevantPdid(IG911SearchCond cond) {
	    return ig911BL.searchIg911RelevantPdid(cond);
	}
	
	/**
     * ״̬�����߹����������Ͷ�������ֵȡ��
     * @param ����״̬ID
     * @return ״̬�����߹����������Ͷ�������ֵ
     */
	public String getParticipantRelevantDefPK(String psdid) throws BLException {
		return ig911BL.getPsprpidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��״̬�����߹����������Ͷ���
	 * @param entity ״̬�����߹����������Ͷ���ʵ��
	 * @return ״̬�����߹����������Ͷ���ʵ��
	 * @throws BLException
	 */
	public IG911Info registParticipantRelevantDefInfo(IG911Info entity) throws BLException {
		return ig911BL.registIG911Info(entity);
	}
	
	/**
	 * ��������ɾ��״̬�����߹����������Ͷ���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteParticipantRelevantDefInfoByKey(String pk) throws BLException {
		ig911BL.deleteIG911InfoByPK(pk);
	}
	
	/**
	 * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG911����ȡ��IG380����Ϣ��
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG380Info> searchIg380ByIg911Cond(IG911SearchCond cond){
		return ig911BL.searchIg380ByIg911Cond(cond);
	}
	
    /**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣ����ȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public int getIg931RelevantPdidCount(IG931SearchCond cond) {
        return ig931BL.getIg931RelevantPdidCount(cond);
    }
    
	/**
     * ��ط�������״̬Ϊ����״̬��Ĭ��Ȩ�޵���ط�����Ϣȡ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG931Info> searchIg931RelevantPdid(IG931SearchCond cond) {
        return ig931BL.searchIg931RelevantPdid(cond);
    }
    
	/**
     * ȱʡ״̬�����߹����������Ͷ�������ֵȡ��
     * @param ����״̬ID
     * @return ȱʡ״̬�����߹����������Ͷ�������ֵ
     */
    public String getDefaultParticipantRelevantDefPK(String psdid) throws BLException {
    	return ig931BL.getDpsprpidSequenceNextValue(psdid);
    }
    
    /**
     * ע��ȱʡ״̬�����߹����������Ͷ���
     * @param entity ȱʡ״̬�����߹����������Ͷ���ʵ��
     * @return ȱʡ״̬�����߹����������Ͷ���ʵ��
     * @throws BLException
     */
    public IG931Info registDefaultParticipantRelevantDefInfo(IG931Info entity) throws BLException {
    	return ig931BL.registIG931Info(entity);
    }
    
    /**
     * ��������ɾ��ȱʡ״̬�����߹����������Ͷ���
     * @param pk ����
     * @throws BLException
     */
    public void deleteDefaultParticipantRelevantDefInfoByKey(String pk) throws BLException {
    	ig931BL.deleteIG931InfoByPK(pk);
    }
    
    /**
     * ��ط���ɷ������̵����̶�����Ϣȡ�ã�����IG931����ȡ��IG380����Ϣ��
     * @param cond ��������
     * @return ��������б�
     */
    public List<IG380Info> searchIg380ByIg931Cond(IG931SearchCond cond){
    	return ig931BL.searchIg380ByIg931Cond(cond);
    }
    
    /**
     * �������̶�����������������Χ
     * @param pdid ���̶�������
     * @return �������
     */
    public List<IG123Info> searchProcessOrgScopeByPdid(String pdid){
    	return ig123BL.findBypdid(pdid);
    }
    
	/**
	 * ������Χ����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return ������Χ����ֵ
	 */
    public String getProcessOrgScopePK(String pdid_one) throws BLException{
    	return ig123BL.getPotdidSequenceNextValue(pdid_one);
    }
    
    /**
     * ע�������Χ
     * @param entity ������Χʵ��
     * @return ������Χʵ��
     * @throws BLException
     */
    public IG123Info registProcessOrgScope(IG123Info entity) throws BLException {
    	return ig123BL.registIG123(entity);
    }
 
    /**
     * ɾ��������Χ
     * @param entity ������Χʵ��
     * @throws BLException
     */
    public void deleteProcessOrgScope(List<IG123Info> entitys) throws BLException {
    	ig123BL.deleteIG123List(entitys);
    }
    
    /**
     * ����״̬��ť�������
     * @param cond ��������
     * @return ����״̬��ť������Ϣ����
     * @throws BLException
     */
    public List<IG156Info> searchProcessStatusButtonDef(IG156SearchCond cond) throws BLException{
    	return ig156BL.searchIG156Info(cond);
    }
    
    /**
     * ������������״̬��ť����
     * @param pk ����
     * @return ����״̬��ť������Ϣ
     * @throws BLException
     */
    public IG156Info searchProcessStatusButtonDefByKey(String pk) throws BLException {
    	return ig156BL.searchIG156InfoByPK(pk);
    }
    
	/**
	 * ״̬��ť��������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PEDID����ֵ
	 */
	public String getProcessStatusButtonDefPK(String psdid) {
		return ig156BL.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @return ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public IG156Info registProcessStatusButtonDef(IG156Info entity) throws BLException {
		return ig156BL.registIG156Info(entity);
	}
	
	/**
	 * ����״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @return ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public IG156Info updateProcessStatusButtonDef(IG156Info entity) throws BLException {
		return ig156BL.updateIG156Info(entity);
	}
	
	/**
	 * ��������ɾ��״̬��ť����
	 * @param entity ״̬��ť����ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusButtonDefByPK(String pk) throws BLException {
		ig156BL.deleteIG156InfoByPK(pk);
	}
	
	/**
	 * ������������Ϣ����
	 * @param cond �������� 
	 * @return �������
	 * @throws BLException
	 */
	public List<IG286Info> searchProcessLinkageDef(IG286SearchCond cond) throws BLException {
		return ig286BL.searchIG286Info(cond);
	}
	
	/**
	 * ������������Ϣ����ֵȡ��
	 * @param ���̶���ID
	 * @return ������������Ϣ����ֵ
	 */
	public String getProcessLinkageDefPK(String pdid_one) throws BLException {
		return ig286BL.getPlidSequenceNextValue(pdid_one);
	}
	
	/**
	 * ע�������������Ϣ
	 * @param entity ������������Ϣʵ��
	 * @return ������������Ϣʵ��
	 * @throws BLException
	 */
	public IG286Info registProcessLinkageDef(IG286Info entity) throws BLException {
		return ig286BL.insertIG286Info(entity);
	}
	
	/**
	 * ɾ��������������Ϣ
	 * @param entity ������������Ϣʵ��
	 * @return ������������Ϣʵ��
	 * @throws BLException
	 */
	public void deleteProcessLinkageDef(IG286Info entity) throws BLException {
		ig286BL.deleteIG286Info(entity);
	}
	
	/**
	 * ��������������������Ϣ
	 * @param pk ����
	 * @return ������������Ϣ
	 * @throws BLException
	 */
	public IG286Info searchProcessLinkageDefByKey(String pk) throws BLException {
		return ig286BL.searchIG286InfoByPk(pk);
	}
	
	/**
	 * �����˰�ť�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG132Info> searchParticipantButtonDef(IG132SearchCond cond) throws BLException {
		return ig132BL.searchIG132Info(cond);
	}
	
	/**
	 * �������������˰�ť����
	 * @param pk ����
	 * @return �����˰�ť������Ϣ
	 * @throws BLException
	 */
	public IG132Info searchParticipantButtonDefByKey(String pk) throws BLException {
		return ig132BL.searchIG132InfoByPK(pk);
	}
	
	/**
	 * �����˰�ť��������ֵȡ��
	 * @param ���̶���ID
	 * @return �����˰�ť��������ֵ
	 */
	public String getParticipantButtonDefPK(String pbdid) throws BLException {
		return ig132BL.getPpbdidSequenceNextValue(pbdid);
	}
	
	/**
	 * ע������˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @return �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public IG132Info registParticipantButtonDef(IG132Info entity) throws BLException {
		return ig132BL.registIG132Info(entity);
	}
	
	/**
	 * ��������ɾ�������˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public void deleteParticipantButtonDefByKey(String pk) throws BLException {
		ig132BL.deleteIG132InfoByPK(pk);
	}
	
	/**
	 * ���²����˰�ť������Ϣ 
	 * @param entity �����˰�ť������Ϣʵ��
	 * @return �����˰�ť������Ϣʵ��
	 * @throws BLException
	 */
	public IG132Info updateParticipantButtonDef(IG132Info entity) throws BLException {
		return ig132BL.updateIG132Info(entity);
	}
	
	/**
	 * �����˰�ť������ͼ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG221Info> searchParticipantButtonVW(IG221SearchCond cond) throws BLException {
		return ig221BL.searchIG221Info(cond);
	}
	
	/**
	 * ȱʡ�����˰�ť������ͼ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG221Info> searchDefaultParticipantButtonVW(IG221SearchCond cond) throws BLException {
		return ig221BL.searchIG221InfoVW(cond);
	}
	
	/**
	 * ���̲����߱���Ȩ����ͼ��ѯ
	 * @param cond ��ѯ����
	 * @return ���̲����߱���Ȩ��
	 * @throws BLException 
	 */
	public List<IG100Info> searchProcessInfoParticipantDefVW(IG100SearchCond cond) throws BLException {
		return ig881BL.searchIG100Info(cond);
	}
	
	/**
	 * �������������˱���Ȩ����Ϣ
	 * @param pk ����
	 * @return �����˱���Ȩ����Ϣ
	 * @throws BLException
	 */
	public IG881Info searchProcessInfoParticipantDefByKey(String pk) throws BLException {
		return ig881BL.searchIG881InfoByKey(pk);
	}
	
	/**
	 * �����˱���Ȩ������ֵȡ��
	 * @param ����״̬�����߶���ID
	 * @return �����˱���Ȩ������ֵ
	 */
	public String getProcessInfoParticipantDefPK(String ppdid) throws BLException {
		return ig881BL.getPipdidSequenceNextValue(ppdid);
	}
	
	/**
	 * ע������˱���Ȩ��
	 * @param entity �����˱���Ȩ��ʵ��
	 * @return �����˱���Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG881Info registProcessInfoParticipantDef(IG881Info entity) throws BLException {
		return ig881BL.registIG881Info(entity);
	}
	
	/**
	 * ���²����˱���Ȩ��
	 * @param entity �����˱���Ȩ��ʵ��
	 * @return �����˱���Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG881Info updateProcessInfoParticipantDef(IG881Info entity) throws BLException {
		return ig881BL.updateIG881Info(entity);
	}
	
	/**
	 * ԾǨ�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG273Info> searchProcessTransitionDef(IG273SearchCond cond) throws BLException {
		return ig273BL.searchIG273Info(cond);
	}
	
	/**
	 * ԾǨ��������ֵȡ��
	 * @param ����״̬ID
	 * @return ԾǨ��������ֵ
	 */
	public String getProcessTransitionDefPK(String psdid) throws BLException {
		return ig273BL.getPtdidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��ԾǨ����
	 * @param entity ԾǨ����ʵ��
	 * @return ԾǨ����ʵ��
	 * @throws BLException
	 */
	public IG273Info registProcessTransitionDef(IG273Info entity) throws BLException {
		return ig273BL.registIG273Info(entity);
	}
	
	/**
	 * ����ԾǨ����
	 * @param entity ԾǨ����ʵ��
	 * @return ԾǨ����ʵ��
	 * @throws BLException
	 */
	public IG273Info updateProcessTransitionDef(IG273Info entity) throws BLException {
		return ig273BL.updateIG273Info(entity);
	}
	
	/**
	 * ��������ɾ��ԾǨ����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessTransitionDefByKey(String pk) throws BLException {
		ig273BL.deleteIG273InfoByKey(pk);
	}
	
	/**
	 * ȱʡ�����˰�ť�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG725Info> searchParticipantDefaultButtonDef(IG725SearchCond cond) throws BLException {
		return ig725BL.searchIG725Info(cond);
	}
	
	/**
	 * ����ȷ�ϰ�ť����
	 * @param psdid ����״̬ID
	 */
	public void registConfirmButton(String psdid) throws BLException {
		ig725BL.registConfirmButton(psdid);
	}
	
	/**
	 * ɾ��ȷ�ϰ�ť����
	 * @param psdid ����״̬ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException {
		ig725BL.deleteConfirmButton(psdid);
	}
	
	/**
	 * ȱʡ�����˰�ť��������ֵȡ��
	 * @param ���̶���ID
	 * @return ȱʡ�����˰�ť��������ֵ
	 */
	public String getParticipantDefaultButtonDefPK(String psdid) throws BLException {
		return ig725BL.getPdbdidSequenceNextValue(psdid);
	}
	
	/**
	 * ע��ȱʡ�����˰�ť����
	 * @param entity ȱʡ�����˰�ť����ʵ��
	 * @return ȱʡ�����˰�ť����ʵ��
	 * @throws BLException
	 */
	public IG725Info registParticipantDefaultButtonDef(IG725Info entity) throws BLException {
		return ig725BL.registIG725Info(entity);
	}
	
	/**
	 * ����ȱʡ�����˰�ť����
	 * @param entity ȱʡ�����˰�ť����ʵ��
	 * @return ȱʡ�����˰�ť����ʵ��
	 * @throws BLException
	 */
	public IG725Info updateParticipantDefaultButtonDef(IG725Info entity) throws BLException {
		return ig725BL.updateIG725Info(entity);
	}
	
	/**
	 * ��������ɾ��ȱʡ�����˰�ť����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteParticipantDefaultButtonDefByKey(String pk) throws BLException {
		ig725BL.deleteIG725InfoByPK(pk);
	}
	
	/**
	 * ��������ɾ��ȱʡ�����˰�ť����
	 * @param pk ����
	 * @throws BLException
	 */
	public IG725Info searchParticipantDefaultButtonDefByKey(String pk) throws BLException {
		return ig725BL.searchIG725InfoByPK(pk);
	}
	
	/**
	 * ����ҳ�����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG126Info> searchProcessJspDef(IG126SearchCond cond) throws BLException {
		return ig126BL.searchIG126Info(cond);
	}
	
	/**
	 * ����ҳ������ֵȡ��
	 * @param ���̶���ID
	 * @return ����ҳ������ֵ
	 */
	public String getProcessJspDefPK(String pdid) throws BLException {
		return ig126BL.getPjdidSequenceNextValue(pdid);
	}
	
	/**
	 * ע�ᶨ��ҳ��
	 * @param entity ����ҳ��ʵ��
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info registProcessJspDef(IG126Info entity) throws BLException {
		return ig126BL.registIG126Info(entity);
	}
	
	/**
	 * ���¶���ҳ��
	 * @param entity ����ҳ��ʵ��
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info updateProcessJspDef(IG126Info entity) throws BLException {
		return ig126BL.updateIG126Info(entity);
	}
	
	/**
	 * ������������ҳ��
	 * @param pk ����
	 * @return ����ҳ��ʵ��
	 * @throws BLException
	 */
	public IG126Info searchProcessJspDefByKey(String pk) throws BLException {
		return ig126BL.searchIG126InfoByKey(pk);
	}
	
	/**
	 * ��������ɾ������ҳ��
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessJspDefByKey(String pk) throws BLException {
		ig126BL.deleteIG126Info(pk);
	}
	
	/**
	 * ����ȱʡ����Ȩ����ͼ��ѯ
	 * @param cond ��ѯ����
	 * @return ����ȱʡ����Ȩ��
	 * @throws BLException 
	 */
	public List<IG909Info> searchParticipantDefaultVariableVW(IG909SearchCond cond) throws BLException {
		return ig699BL.searchIG909Info(cond);
	}
	
	/**
	 * ����ȱʡ����Ȩ������ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return ����ȱʡ����Ȩ������ֵ
	 */
	public String getParticipantDefaultVariablePK(String pdid) throws BLException {
		return ig699BL.getPdvidSequenceNextValue(pdid);
	}
	
	/**
	 * ע������ȱʡ����Ȩ��
	 * @param entity ����ȱʡ����Ȩ��ʵ��
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info registParticipantDefaultVariable(IG699Info entity) throws BLException {
		return ig699BL.registIG699Info(entity);
	}
	
	/**
	 * ��������ȱʡ����Ȩ��
	 * @param entity ����ȱʡ����Ȩ��ʵ��
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info updateParticipantDefaultVariable(IG699Info entity) throws BLException {
		return ig699BL.updateIG699Info(entity);
	}
	
	/**
	 * ������������ȱʡ����Ȩ��
	 * @param pk ����
	 * @return ����ȱʡ����Ȩ��ʵ��
	 * @throws BLException
	 */
	public IG699Info searchParticipantDefaultVariableByKey(String pk) throws BLException {
		return ig699BL.searchIG699InfoByKey(pk);
	}
	
	/**
	 * ȱʡ����Ȩ�޼���
	 * @param cond ��������
	 * @return ȱʡ����Ȩ�޼���
	 * @throws BLException
	 */
	public List<IG699Info> searchParticipantDefaultVariable(IG699SearchCond cond) throws BLException {
		return ig699BL.searchIG699Info(cond);
	}
	
	/**
	 * ���̲鿴��ɫ����
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG700Info> searchProcessSeeRoleInfo(IG700SearchCond cond) throws BLException {
		return ig700BL.searchIg700(cond);
	}
	
	/**
	 * ע�����̲鿴��ɫ
	 * @param entity ���̲鿴��ɫʵ��
	 * @return ���̲鿴��ɫʵ��
	 * @throws BLException
	 */
	public IG700Info registProcessSeeRoleInfo(IG700Info entity) throws BLException {
		return ig700BL.registIg700(entity);
	}
	
	/**
	 * ��������ɾ�����̲鿴��ɫ
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessSeeRoleInfoByKey(IG700PK pk) throws BLException {
		ig700BL.deleteIg700ByPK(pk);
	}
	
	/**
	 * ���̹�ͨ���������������
	 * @param cond ��������
	 * @return ��������
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralSearchCount(IG202SearchCond cond) throws BLException {
		return ig202BL.getIG202InfoSearchCount(cond);
	}
	
	/**
	 * ���̹�ͨ��������(��ҳ��)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneral(IG202SearchCond cond,int start,int count) throws BLException {
		return ig202BL.searchIG202Info(cond, start, count);
	}
	
	/**
	 * ���̹�ͨ���������������
	 * @param cond ��������
	 * @return ��������
	 * @throws BLException
	 */
	public int getProcessInfoDefGeneralVWSearchCount(IG202SearchCond cond) throws BLException {
		return ig202BL.searchIG202InfoCount(cond);
	}
	
	/**
	 * ���̹�ͨ��������(��ҳ��)
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 * @throws BLException
	 */
	public List<IG202Info> searchProcessInfoDefGeneralVW(IG202SearchCond cond,int start,int count) throws BLException {
		return ig202BL.searchIG202InfoFromVW(cond, start, count);
	}
	
	/**
	 * �����������̹�ͨ����
	 * @param pk ����
	 * @return ���̹�ͨ����
	 * @throws BLException
	 */
	public IG202Info searchProcessInfoDefGeneralByKey(Integer pk) throws BLException {
		return ig202BL.findIG202InfoByPK(pk);
	}
	
	/**
	 * ע�����̹�ͨ����
	 * @param entity ���̹�ͨ����ʵ��
	 * @return ����ͳͳ����ʵ��
	 * @throws BLException
	 */
	public IG202Info registProcessInfoDefGeneral(IG202Info entity) throws BLException {
		return ig202BL.registIG202Info(entity);
	}
	
	/**
	 * ���̹�ͨ��������
	 * @param entity ���̹�ͨ����ʵ��
	 * @return ���̹�ͨ����ʵ��
	 * @throws BLException
	 */
	public IG202Info updateProcessInfoDefGeneral(IG202Info entity) throws BLException {
		return ig202BL.updateIG202Info(entity);
	}
	
	/**
	 * ��������ɾ�����̹�ͨ����
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessInfoDefGeneralByKey(Integer pk) throws BLException {
		ig202BL.deleteIG202Info(pk);
	}
	
	/**
	 * ע������֪ͨ����
	 * @param entity ����֪ͨ����ʵ��
	 * @return ����֪ͨ����ʵ��
	 * @throws BLException
	 */
	public IG212Info registProcessNoticeStrategyDefInfo(IG212Info entity) throws BLException {
		return ig212BL.registIG212Info(entity);
	}
	
	/**
	 * ����֪ͨ���Բ�ѯ
	 * @param pdid ���̶���ID
	 * @return ����֪ͨ�����б�
	 */
	public List<IG238Info> searchProcessNoticeStrategyVWInfoByPdid(String pdid) throws BLException {
		return ig212BL.searchIG238Info(pdid);
	}
	
	/**
	 * ���̲���֪ͨ�˼���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG237Info> searchProcessNoticeStrategyUserInfo(IG237SearchCond cond) {
		return ig237BL.searchIG237Info(cond);
	}
	
	/**
	 * ɾ�����̲���֪ͨ��
	 * @param entity ���̲���֪ͨ��ʵ��
	 * @throws BLException
	 */
	public void deleteProcessNoticeStrategyUserInfo(IG237Info entity) throws BLException {
		ig237BL.deleteIG237Info(entity);
	}
	
	/**
	 * ע�����̲���֪ͨ��
	 * @param entitys ���̲���֪ͨ��ʵ�弯��
	 * @throws BLException
	 */
	public void registProcessNoticeStrategyUserInfo(List<IG237Info> entitys) throws BLException {
		ig237BL.registAllIG237Info(entitys);
	}
	
	/**
	 * �������������ⲿ���ö���
	 * @param pk ����
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info searchProcessExternalDefInfoByKey(Integer pk) throws BLException {
		return ig992BL.searchIG992InfoByPK(pk);
	}
	
	/**
	 * ע�������ⲿ���ö���
	 * @param entity �����ⲿ���ö���ʵ��
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info registProcessExternalDefInfo(IG992Info entity) throws BLException {
		return ig992BL.registIG992Info(entity);
	}
	
	/**
	 * ���������ⲿ���ö���
	 * @param entity �����ⲿ���ö���ʵ��
	 * @return �����ⲿ���ö���ʵ��
	 * @throws BLException
	 */
	public IG992Info updateProcessExternalDefInfo(IG992Info entity) throws BLException {
		return ig992BL.updateIG992Info(entity);
	}
	
	/**
	 * ��������ɾ�������ⲿ���ö���
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteProcessExternalDefInfoByKey(Integer pk) throws BLException {
		ig992BL.deleteIG992InfoByPK(pk);
	}
	
	/**
	 * �����ⲿ���ö������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG992Info> searchProcessExternalDefInfo(IG992SearchCond cond) throws BLException {
		return ig992BL.searchIG992Info(cond);
	}
	
	/**
	 * ����״̬�����ߵ�������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG258Info> searchProcessStatusPrtChangeDefInfo(IG258SearchCond cond) throws BLException {
		return ig258BL.searchIG258Info(cond);
	}
	
	/**
	 * ����״̬�����ߵ�������ֵȡ��
	 * @param ���̶���ID
	 * @return ����״̬�����ߵ�������ֵ
	 */
	public String getProcessStatusPrtChangeDefPK(String psdid) throws BLException {
		return ig258BL.getPspcdSequenceNextValue(psdid);
	}
	
	/**
	 * ע������״̬�����ߵ���
	 * @param entity ����״̬�����ߵ���ʵ��
	 * @return ����״̬�����ߵ���ʵ��
	 * @throws BLException
	 */
	public IG258Info registProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException {
		return ig258BL.registIG258Info(entity);
	}
	
	/**
	 * ɾ������״̬�����ߵ���
	 * @param entity ����״̬�����ߵ���ʵ��
	 * @throws BLException
	 */
	public void deleteProcessStatusPrtChangeDefInfo(IG258Info entity) throws BLException {
		ig258BL.deleteIG258Info(entity);
	}
	
	/**
	 * ע����ɶ���
	 * @param entity ���ɶ���ʵ��
	 * @return ���ɶ���ʵ��
	 * @throws BLException
	 */
	public IG233Info registAssignedDefInfo(IG233Info entity) throws BLException {
		return ig233BL.registIG233(entity);
	}
	
	/**
	 * ��ѯָ��״̬�ķ�����Ϣ
	 * @param psdid ״̬ID
	 * @return ������Ϣ���
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfoByPsdid(String psdid) throws BLException {
		return ig233BL.searchByPsdid(psdid);
	}
	
	/**
	 * ��������״̬�ķ�����Ϣ
	 * @param cond ��������
	 * @return ������Ϣ���
	 * @throws BLException
	 */
	public List<IG233Info> searchAssignedDefInfo(IG233SearchCond cond) throws BLException {
		return ig233BL.searchIG233(cond);
	}
	
	/**
	 * ɾ��������Ϣ
	 * @param entitys ������Ϣʵ�弯��
	 * @throws BLException
	 */
	public void deleteAssignedDefInf(List<IG233Info> entitys) throws BLException {
		ig233BL.deleteIG233(entitys);
	}
	
	/**
	 * �������̶���������ѯ����ѯ��������
	 * @param pdid ���̶�������
	 * @return ����ѯ��������ʵ��
	 * @throws BLException
	 */
	public List<IG108Info> searchFormQueryDefByPdid(String pdid) throws BLException {
		return ig108BL.findBypdid(pdid);
	}
	
	/**
	 * ע�����ѯ����
	 * @param entity ����ѯ����ʵ��
	 * @return ����ѯ����ʵ��
	 * @throws BLException
	 */
	public IG108Info registFormQueryDefInfo(IG108Info entity) throws BLException {
		return ig108BL.registIG108(entity);
	}
	
	/**
	 * ��������ɾ������ѯ��������
	 * @param pk ����
	 * @throws BLException
	 */
	public void deleteFormQueryDefByKey(Integer pk) throws BLException {
		ig108BL.deleteIG108ByPK(pk);
	}
	
	/**
	 * ֪ͨ���Լ���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG334Info> searchInformStrategy(IG334SearchCond cond) throws BLException {
		return ig334BL.searchIG334(cond);
	}
	
	/**
	 * ע��֪ͨ����
	 * @param entity ֪ͨ����ʵ��
	 * @return ֪ͨ����ʵ��
	 * @throws BLException
	 */
	public IG334Info registInformStrategy(IG334Info entity) throws BLException {
		return ig334BL.registIG334(entity);
	}
	
	/**
	 * ɾ��֪ͨ����
	 * @param entity ֪ͨ����ʵ��
	 * @throws BLException
	 */
	public void deleteInformStrategy(IG334Info entity) throws BLException {
		ig334BL.deleteIG334(entity);
	}
	
	/**
	 * �����Լ���
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategy(IG335SearchCond cond) throws BLException {
		return ig335BL.searchIG335(cond);
	}
	
	/**
	 * ��ʱ֪ͨ���Բ�ѯ
	 * @param pdid ���̶���ID
	 * @param psdid ״̬����ID
	 * @param pidid ������ID
	 * @return  ��ʱ֪ͨ�����б�
	 * @throws BLException
	 */
	public List<IG335Info> searchFormStrategyVW(String pdid,  String psdid, String pidid, String psdconfirm) throws BLException {
		return ig335BL.searchIG335Info(pdid, psdid, pidid, psdconfirm);
	}
	
	/**
	 * ע�������
	 * @param entity ������ʵ��
	 * @return ������ʵ��
	 * @throws BLException
	 */
	public IG335Info registFormStrategy(IG335Info entity) throws BLException {
		return ig335BL.registIG335(entity);
	}
	
	/**
	 * ������ɾ��
	 * @param entitys ������ʵ�弯��
	 * @throws BLException
	 */
	public void deleteFormStrategy(List<IG335Info> entitys) throws BLException {
		ig335BL.deleteIG335(entitys);
	}
	
	/**
	 * ����ɫ��Χע��
	 * @param entity ����ɫ��Χʵ��
	 * @return ����ɫ��Χʵ��
	 * @throws BLException
	 */
	public IG008Info registFormRoleScope(IG008Info entity) throws BLException {
		return ig008BL.registIG008(entity);
	}
	
	/**
	 * ���ݱ�����ID��������ɫ�޶���Χ
	 * @param pidid ����������
	 * @return
	 */
	public List<IG008Info> searchFormRoleScopeByPidid(String pidid){
		if(StringUtils.isNotEmpty(pidid)){
			IG008SearchCondImpl cond = new IG008SearchCondImpl();
			cond.setPidid(pidid);
			return ig008BL.searchIG008(cond);
		}else{
			return null;
		}
	}
	
	/**
	 * ����ɫ�޶���Χɾ��
	 * @param entitys ����ɫ�޶���Χʵ�弯��
	 */
	public void deleteFormRoleScope(List<IG008Info> entitys) throws BLException{
		ig008BL.deleteIG008(entitys);
	}
	
	/**
	 * XML�ű���������
	 * @param pdid ���̶���ID
	 * @return XML�ű�
	 */
	public String exportXML(String pdid) throws BLException{
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append(ig380BL.exportXML(pdid));
		sbf_xml.append(ig007BL.exportXML(pdid));
		sbf_xml.append(ig333BL.exportXML(pdid));
		sbf_xml.append(ig258BL.exportXML(pdid));
		sbf_xml.append(ig222BL.exportXML(pdid));
		sbf_xml.append(ig132BL.exportXML(pdid));
		sbf_xml.append(ig881BL.exportXML(pdid));
		sbf_xml.append(ig273BL.exportXML(pdid));
		sbf_xml.append(ig286BL.exportXML(pdid));
		sbf_xml.append(ig413BL.exportXML(pdid));
		sbf_xml.append(ig126BL.exportXML(pdid));
		sbf_xml.append(ig725BL.exportXML(pdid));
		sbf_xml.append(ig699BL.exportXML(pdid));
		sbf_xml.append(ig213BL.exportXML(pdid));
		sbf_xml.append(ig243BL.exportXML(pdid));
		sbf_xml.append(ig298BL.exportXML(pdid));
		sbf_xml.append(ig156BL.exportXML(pdid));
		sbf_xml.append(ig212BL.exportXML(pdid));
		sbf_xml.append(ig237BL.exportXML(pdid));
		sbf_xml.append(ig373BL.exportXML(pdid));
		sbf_xml.append(ig911BL.exportXML(pdid));
		sbf_xml.append(ig931BL.exportXML(pdid));
		sbf_xml.append(ig700BL.exportXML(pdid));
		sbf_xml.append(ig701BL.exportXML(pdid));
//		sbf_xml.append(ig108BL.exportXML(pdid));
		sbf_xml.append(ig233BL.exportXML(pdid));
		sbf_xml.append(ig334BL.exportXML(pdid));
		sbf_xml.append(ig335BL.exportXML(pdid));
		sbf_xml.append(ig008BL.exportXML(pdid));
		sbf_xml.append(ig110BL.exportXML(pdid));
		sbf_xml.append(ig111BL.exportXML(pdid));
		return sbf_xml.toString();
	}
	
	/**
	 * XML�ű����봦��
	 * @param element Element
	 * @throws BLException
	 */
	public void importXML(List<org.jdom.Element> elements) throws BLException {
		for(org.jdom.Element element : elements) {
			if("IG380".equals(element.getName())) {
				ig380BL.importXML(element);
			} else if("IG007".equals(element.getName())) {
				ig007BL.importXML(element);
			} else if("IG333".equals(element.getName())) {
				ig333BL.importXML(element);
			} else if("IG258".equals(element.getName())) {
				ig258BL.importXML(element);
			} else if("IG222".equals(element.getName())) {
				ig222BL.importXML(element);
			} else if("IG132".equals(element.getName())) {
				ig132BL.importXML(element);
			} else if("IG881".equals(element.getName())) {
				ig881BL.importXML(element);
			} else if("IG273".equals(element.getName())) {
				ig273BL.importXML(element);
			} else if("IG286".equals(element.getName())) {
				ig286BL.importXML(element);
			} else if("IG413".equals(element.getName())) {
				ig413BL.importXML(element);
			} else if("IG126".equals(element.getName())) {
				ig126BL.importXML(element);
			} else if("IG725".equals(element.getName())) {
				ig725BL.importXML(element);
			} else if("IG699".equals(element.getName())) {
				ig699BL.importXML(element);
			} else if("IG213".equals(element.getName())) {
				ig213BL.importXML(element);
			} else if("IG243".equals(element.getName())) {
				ig243BL.importXML(element);
			} else if("IG298".equals(element.getName())) {
				ig298BL.importXML(element);
			} else if("IG156".equals(element.getName())) {
				ig156BL.importXML(element);
			} else if("IG212".equals(element.getName())) {
				ig212BL.importXML(element);
			} else if("IG237".equals(element.getName())) {
				ig237BL.importXML(element);
			} else if("IG373".equals(element.getName())) {
				ig373BL.importXML(element);
			} else if("IG911".equals(element.getName())) {
                ig911BL.importXML(element);
			} else if("IG931".equals(element.getName())) {
                ig931BL.importXML(element);
            } else if("IG700".equals(element.getName())) {
                ig700BL.importXML(element);
			} else if("IG701".equals(element.getName())) {
                ig701BL.importXML(element);
            } else if("IG108".equals(element.getName())) {
            	ig108BL.importXML(element);
            } else if("IG233".equals(element.getName())) {
            	ig233BL.importXML(element);
            } else if("IG334".equals(element.getName())) {
            	ig334BL.importXML(element);
            } else if("IG335".equals(element.getName())) {
            	ig335BL.importXML(element);
            } else if("IG008".equals(element.getName())) {
				ig008BL.importXML(element);
			} else if ("IG110".equals(element.getName())) {
				ig110BL.importXML(element);
			} else if ("IG111".equals(element.getName())) {
				ig111BL.importXML(element);
            }else if(!"CHECKINFO".equals(element.getName())){
				//throw new BLException("IGPRD0101.E006");
			}
		}
	}

    /**
     * ״̬��˽�б�����������
     * @Description: ״̬��˽�б�����������
     * @param dfvalue Ĭ��ֵ
     * @param usedToAll �Ƿ�Ӧ�õ�����״̬
     * @param psdid ״̬id
     * @param pidid ��id
     * @throws BLException
     */
    public void saveOrUpdateStatusDefault(String dfvalue,boolean usedToAll,String psdid,String pidid)throws BLException{
        IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pidid);
        cond.setUsedToAll("T");
        List<IG560Info>  lst=ig560BL.searchIG560(cond);
        IG560TB ig560TB=new IG560TB();
        if(lst!=null&&lst.size()>0){
            ig560TB=(IG560TB) lst.get(0);
        }
        ig560TB.setDfvalue(dfvalue);
        ig560TB.setPidid(pidid);
        if(usedToAll){
            ig560TB.setUsedtoall("T");
        }else{
            ig560TB.setUsedtoall("F");
        }
        if(StringUtils.isNotEmpty(psdid)){
            ig560TB.setPsdid(psdid);
        }
        ig560BL.registIG560(ig560TB);
    }
    /**
     * ����״̬��˽�б�Ĭ��ֵ
     * @Description: ����״̬��˽�б�Ĭ��ֵ
     * @param list ig560list
     * @throws BLException
     */
    public void saveStatusDefaultList(List<IG560Info> list)throws BLException{
        ig560BL.saveOrUpdateAll(list);
    }
    /**
     * ��ѯĳһ״̬��ĳһ����Ĭ��ֵ�����ͬһ�����ж��Ĭ��ֵ����ȡ���Ȩ�ޡ�
     * @Description: ��ѯĳһ״̬��ĳһ����Ĭ��ֵ�����ͬһ�����ж��Ĭ��ֵ����ȡ���Ȩ�ޡ�
     * @param psdid �ڵ�id,like��ѯ
     * @param pidid ��id,like��ѯ
     * @return ״̬��˽�б�Ĭ��ֵ��ͼ
     * @throws BLException
     */
    public List<IG560VWInfo> searchIG560VWInfo(String psdid,String pidid)throws BLException{
        IG560SearchCondImpl cond= new IG560SearchCondImpl();
        cond.setPidid_l(pidid);
        cond.setPsdid_l(psdid);
        cond.setUsedToAll("T");
        List<IG560VWInfo> lst= ig560BL.searchIG560VW(cond);
        Map<String, IG560VWInfo> map= new HashMap<String, IG560VWInfo>();
        
        for(IG560VWInfo info:lst ){
            //empty
            if(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall())){
                map.put(info.getPidid(), info);
            }
        }
        for(IG560VWInfo info:lst ){
            if(!(StringUtils.isNotEmpty(info.getUsedtoall())&&"T".equals(info.getUsedtoall()))){
                map.put(info.getPidid(), info);
            }
        }
        List<IG560VWInfo> returnLst= new ArrayList<IG560VWInfo>();
        for(Entry<String, IG560VWInfo> entry:map.entrySet()){
            returnLst.add(entry.getValue());
        }
        return returnLst;
    }
    /**
     * ״̬��˽�б�Ĭ��ֵ cond����
     * @Description: ״̬��˽�б�Ĭ��ֵ cond����
     * @param cond 
     * @return
     * @throws BLException
     */
    public List<IG560Info> searchIG560TBInfo(IG560SearchCond cond)throws BLException{
        return this.ig560BL.searchIG560(cond);      
    }
    
    /**
     * ���̲�ѯ��ʾ�в�ѯ
     * @param pdid ���̶���ID
     * @return ���̲�ѯ��ʾ�м���
     * @throws BLException
     */
	public List<IG110Info> searchProcessQueryShowColumnByPdid(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			pdid = "N/A";
		}
		IG110SearchCondImpl cond = new IG110SearchCondImpl();
		cond.setPdid(pdid);
		return ig110BL.searchIG110(cond);
	}
	
	/**
	 * ���̲�ѯ������ѯ
	 * @param pdid ���̶���ID
	 * @return ���̲�ѯ��������
	 * @throws BLException
	 */
	public List<IG111Info> searchprocessQueryByPdid(String pdid) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			pdid = "N/A";
		}
		IG111SearchCondImpl cond = new IG111SearchCondImpl();
		cond.setPdid(pdid);
		
		return ig111BL.searchIG111(cond);
	}
	
	/**
	 * ɾ�����̲�ѯ��ʾ��
	 * @param instance ���̲�ѯ��ʾ��
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumn(IG110Info instance) throws BLException {
		ig110BL.deleteIG110(instance);
	}
	
	/**
	 * ����pdidɾ�����̲�ѯ��ʾ��
	 * 
	 * @param instance
	 *            ���̲�ѯ��ʾ��
	 * @throws BLException
	 */
	public void deleteProcessQueryShowColumnByPdid(String pdid) throws BLException {
		ig110BL.deleteByPdid(pdid);
	}

	/**
	 * ɾ�����̲�ѯ����
	 * 
	 * @param instance
	 *            ���̲�ѯ����
	 * @throws BLException
	 */
	public void deleteProcessQuery(IG111Info instance) throws BLException {
		ig111BL.deleteIG111(instance);
	}
	
	/**
	 * ����pdidɾ�����̲�ѯ����
	 * 
	 * @param instance
	 *            ���̲�ѯ����
	 * @throws BLException
	 */
	public void deleteProcessQueryByPdid(String pdid) throws BLException {
		ig111BL.deleteByPdid(pdid);
	}

	/**
	 * ���̲�ѯ��ʾ�ж���ǼǴ���
	 * 
	 * @param instance
	 *            ���̲�ѯ��ʾ��ʵ��
	 * @return ���̲�ѯ��ʾ��ʵ��
	 * @throws BLException
	 */
	public IG110Info registProcessQueryShowColumn(IG110Info instance) throws BLException {
		return ig110BL.registIG110(instance);
	}
	
	/**
	 * ���̲�ѯ��ʾ�ж�����´���
	 * @param instance ���̲�ѯ��ʾ��ʵ��
	 * @return ���̲�ѯ��ʾ��ʵ��
	 * @throws BLException
	 */
	public IG110Info updateProcessQueryShowColumn(IG110Info instance) throws BLException {
		return ig110BL.updateIG110(instance);
	}
	
	/**
	 * ȡ�ò�ѯ��ʾ��ʵ�����һ��ID
	 * @param pdid ���̶���ID
	 * @return ������ʾ��ʵ��ID
	 * @throws BLException
	 */
	public String getProcessQueryShowColumnNextId(String pdid) throws BLException {
		return ig110BL.getNextId(pdid);
	}
	
	/**
	 * ȡ�ò�ѯ����ʵ�����һ��ID
	 * @param pdid ���̶���ID
	 * @return ���̲�ѯ����ʵ��ID
	 * @throws BLException
	 */
	public String getProcessQueryNextId(String pdid) throws BLException {
		return ig111BL.getNextId(pdid);
	}
	
	/**
	 * ���̲�ѯ�����ǼǴ���
	 * @param instance ���̲�ѯ����ʵ��
	 * @return ���̲�ѯ����ʵ��
	 * @throws BLException
	 */
	public IG111Info registProcessQuery(IG111Info instance) throws BLException {
		return ig111BL.registIG111(instance);
	}
}
