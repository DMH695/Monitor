package com.example.monitor.service;

import com.alibaba.fastjson.JSONObject;
import com.example.monitor.dao.NodeDao;
import com.example.monitor.entity.Node;
import com.example.monitor.utils.page.PageRequest;
import com.example.monitor.utils.page.PageResult;
import com.example.monitor.utils.page.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class NodeServiceImpl implements NodeService{
    public static Page page;
    @Autowired
    NodeDao nodeDao;
    @Override
    public PageResult getPage(PageRequest pageRequest, Date startDate, Date endDate, String number) {
        return PageUtil.getPageResult(getPageInfoByCondition(pageRequest, startDate, endDate, number),page);
    }

    @Override
    public void insert(Node node) {
        nodeDao.insert(node);
    }

    @Override
    public void update(Node node) {
        nodeDao.update(node);
    }

    @Override
    public void delete(int id) {
        nodeDao.delete(id);
    }

    @Override
    public void change(int id, boolean control) {
        nodeDao.change(id, control);
    }

    private PageInfo<?> getPageInfoByCondition(PageRequest pageRequest,Date startDate, Date endDate, String number) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        //设置分页数据
        page = PageHelper.startPage(pageNum,pageSize);
        List<Node> res = new ArrayList<>();
        res = nodeDao.getPage(startDate,endDate,number);
        return new PageInfo<>(res);
    }
}
