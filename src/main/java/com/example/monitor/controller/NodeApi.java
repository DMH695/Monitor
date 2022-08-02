package com.example.monitor.controller;

import com.example.monitor.entity.Node;
import com.example.monitor.service.NodeService;
import com.example.monitor.utils.ResultBody;
import com.example.monitor.utils.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
@RequestMapping("/node")
public class NodeApi {
    @Autowired
    NodeService nodeService;

    /**
     * 分页查询、并且具有搜索功能，搜索条件为
     * 由于不存在数据转换的问题，直接将数据分页返回即可
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Object findAll(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                          @RequestParam(required = false) Date startDate,@RequestParam(required = false) Date endDate,
                          @RequestParam(required = false) String number){
        PageRequest pageRequest = new PageRequest(pageNum,pageSize);
        return new ResultBody<>(true,200,nodeService.getPage(pageRequest,startDate,endDate,number));
    }

    @RequestMapping(value = " /wx/all",method = RequestMethod.GET)
    public Object findAllForWX(@RequestParam Integer pageNum, @RequestParam Integer pageSize,
                          @RequestParam(required = false) Date startDate,@RequestParam(required = false) Date endDate,
                          @RequestParam(required = false) String number){
        PageRequest pageRequest = new PageRequest(pageNum,pageSize);
        return new ResultBody<>(true,200,nodeService.getPage(pageRequest,startDate,endDate,number));
    }


    /**
     * 新增节点
     * number、airWet、airTemperature、CO2、light、soilWet、soilTemperature
     * 时间由后端补
     */
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(@RequestBody Node node){
        //获取当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        node.setDate(date);
        nodeService.insert(node);
        return new ResultBody<>(true,200,null);
    }

    @RequestMapping(value = "/wx/insert",method = RequestMethod.POST)
    public Object insertForWX(@RequestBody Node node){
        //获取当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        node.setDate(date);
        nodeService.insert(node);
        return new ResultBody<>(true,200,null);
    }
    /**
     * 更新节点
     * id、number、airWet、airTemperature、CO2、light、soilWet、soilTemperature
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(@RequestBody Node node){
        if (node.getId() <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        //获取当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        node.setDate(date);
        nodeService.update(node);
        return new ResultBody<>(true,200,null);
    }
    @RequestMapping(value = "/wx/update",method = RequestMethod.POST)
    public Object updateForWX(@RequestBody Node node){
        if (node.getId() <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        //获取当前时间
        String date = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        node.setDate(date);
        nodeService.update(node);
        return new ResultBody<>(true,200,null);
    }
    /**
     * 删除节点
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object delete(@RequestParam int id){
        if (id <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        nodeService.delete(id);
        return new ResultBody<>(true,200,null);
    }

    @RequestMapping(value = "/wx/delete",method = RequestMethod.GET)
    public Object deleteForWX(@RequestParam int id){
        if (id <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        nodeService.delete(id);
        return new ResultBody<>(true,200,null);
    }
    /**
     * 控制开关
     */
    @RequestMapping(value = "/on-off",method = RequestMethod.GET)
    public Object updateControl(@RequestParam boolean control,@RequestParam int id){
        if (id <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        nodeService.change(id, control);
        return new ResultBody<>(true,200,null);
    }

    @RequestMapping(value = "/wx/on-off",method = RequestMethod.GET)
    public Object updateControlForWX(@RequestParam boolean control,@RequestParam int id){
        if (id <= 0) {
            return new ResultBody<>(false,501,"error id");
        }
        nodeService.change(id, control);
        return new ResultBody<>(true,200,null);
    }

}
