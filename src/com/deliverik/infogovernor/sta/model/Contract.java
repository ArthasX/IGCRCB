/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;

/**
 * 
 * ��ͬ��ͳ��
 * 
 */
public interface Contract{ /**
     * IDȡ��
    *
    * @return eid ID
    */
   public String getEid() ;

   /**
    * ��ͬ����ȡ��
    *
    * @return ename ��ͬ����
    */
   public String getEname();

   /**
    * ��ǰ���ͬ���ܼ�ȡ��
    *
    * @return currentinvestment ��ǰ���ͬ���ܼ�
    */
   public String getCurrentinvestment();

   /**
    * ǰһ���ͬ���ܼ�ȡ��
    *
    * @return lastinvestment ǰһ���ͬ���ܼ�
    */
   public String getLastinvestment();

   /**
    * �����ͬ���ȡ��
    *
    * @return diff �����ͬ���
    */
   public String getDiff();

   /**
    * ��ͬ������ȡ��
    *
    * @return esyscoding ��ͬ������
    */
   public String getEsyscoding();
   }
