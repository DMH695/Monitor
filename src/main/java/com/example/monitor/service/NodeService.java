package com.example.monitor.service;

import com.example.monitor.entity.Node;
import com.example.monitor.utils.page.PageRequest;
import com.example.monitor.utils.page.PageResult;

import java.sql.Date;

public interface NodeService {
    PageResult getPage(PageRequest pageRequest, Date startDate,Date endDate,String number);
    void insert(Node node);
    void update(Node node);
    void delete(int id);
    void change(int id,boolean control);
}
