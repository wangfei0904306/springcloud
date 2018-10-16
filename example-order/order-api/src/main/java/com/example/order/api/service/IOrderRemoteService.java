package com.example.order.api.service;


import com.example.microframe.common.RemoteResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * 订单中心服务接口
 *
 * @author ff
 * @date 2018年04月13日19:55:54
 */
@RequestMapping("/remote/dataService")
public interface IOrderRemoteService {

    @RequestMapping("/getAllDepts")
    RemoteResult<Map<Integer, String>> getDeptNameMap();

    /**
     * 根据用户id获取订单列表
     *寺
     * @author ff
     * @Date 2018年04月13日19:55:54
     */
    @RequestMapping("/getUserDeptInfo")
    RemoteResult<List> getUserDeptInfo(@RequestBody Long userIdQO);

    @RequestMapping("/getDeptsMap")
    RemoteResult<Map<String, String>> getDeptsMap();

}
