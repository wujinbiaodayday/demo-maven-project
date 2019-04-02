package com.ddc.common.demo.service.jms.constants;

public class MQConstant {

    //门店交换机
    public static final String STORE_WMS_EXCHANGES = "store.wms.exchanges";


    //门店退货发货消息
    public static final String TAG_RTV_DELIVERY_CALL_BACK = "pms-rtv.delivery.callback.to.shop";
    public static final String TAG_RTV_DELIVERY_CALL_BACK_KEY = "route-key-invoice";

    //门店退货需求回写消息
    public static final String TAG_RTV_HEAD_CALL_BACK = "pms-rtv.head.callback.to.shop";
    public static final String TAG_RTV_HEAD_CALL_BACK_KEY = "route-key-return";

    //门店订货KEY
    public static final String KEY_STORE_PUR_REQ = "route-key-purchase";
    public static final String TAG_STORE_PUR_REQ = "store.purchase.req.sync";

    //门店收货回写PMS
    public static final String TAG_ASN_RECEIVE_CALL_BACK = "store.asn.receive.callback";
    public static final String KEY_ASN_RECEIVE_CALL_BACK = "routing_key_receipt";


}
