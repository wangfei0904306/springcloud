package com.example.microframe.order.facade.api;


import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 数据中心服务接口
 *
 * @author ff
 * @date 2018年04月13日19:55:54
 */
@RequestMapping("/remote/dataService")
public interface OrderServiceApi {

    //@RequestMapping("/getAllDepts")
    //RemoteResult<Map<Integer, String>> getDeptNameMap();

    /**
     * 根据用户id获取订单列表
     *寺
     * @author ff
     * @Date 2018年04月13日19:55:54
     */
    //@RequestMapping("/getUserDeptInfo")
    //RemoteResult<UserDeptInfo> getUserDeptInfo(@RequestBody UserDeptInfoQo userDeptInfoQo);

    //@RequestMapping("/getDeptsMap")
    //RemoteResult<Map<String, String>> getDeptsMap();

}
