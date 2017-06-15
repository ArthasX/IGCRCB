/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.sta.model;

/**
 * 
 * 合同额统计
 * 
 */
public interface Contract{ /**
     * ID取得
    *
    * @return eid ID
    */
   public String getEid() ;

   /**
    * 合同类型取得
    *
    * @return ename 合同类型
    */
   public String getEname();

   /**
    * 当前年合同额总计取得
    *
    * @return currentinvestment 当前年合同额总计
    */
   public String getCurrentinvestment();

   /**
    * 前一年合同额总计取得
    *
    * @return lastinvestment 前一年合同额总计
    */
   public String getLastinvestment();

   /**
    * 两年合同额差取得
    *
    * @return diff 两年合同额差
    */
   public String getDiff();

   /**
    * 合同类型码取得
    *
    * @return esyscoding 合同类型码
    */
   public String getEsyscoding();
   }
