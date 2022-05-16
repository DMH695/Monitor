package com.example.monitor.dao;

import com.example.monitor.entity.Node;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

@Mapper
public interface NodeDao {
    List<Node> getPage(Date startDate,Date endDate,String number);
    void insert(@Param("node") Node node);
    void update(@Param("node") Node node);
    void delete(int id);
    void change(int id,boolean control);
}
