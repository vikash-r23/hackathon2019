package com.db.hackathon.service;

import com.db.hackathon.model.MonthBreakDownData;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NativeQueries {

    @Autowired
    private EntityManager entityManager;
    
    public Map<String, Double> getBreakDownByInvestor(Long pitcherId){
        String sql = "SELECT SUM(amount),first_name FROM Investments JOIN User_Info ON Investments.investor_Id=User_Info.user_id where idea_Id IN ( SELECT id FROM Idea WHERE pitcher_Id = ?1) GROUP BY investor_Id";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.setParameter(1,pitcherId);
        List<Object[]> resultList = nativeQuery.getResultList();
        Map<String, Double> map = new HashMap<>();
        for (Object[] obj : resultList) {
            if (map.get(obj[1].toString()) == null){
                map.put(obj[1].toString(),(Double) obj[0]);
            }else{
                map.put(obj[1].toString(),(Double) obj[0] + map.get(obj[1].toString()));
            }
        }
        return map;
    }

    public List<MonthBreakDownData> getBreakDownByMonth(Long pitcherId){
        String sql = "SELECT month,year,SUM(amount) as amount FROM Investments WHERE idea_Id IN ( SELECT id FROM Idea WHERE pitcher_Id = ?1) GROUP BY year,month";
        Query nativeQuery = entityManager.createNativeQuery(sql);
        nativeQuery.setParameter(1,pitcherId);
        List<Object[]> resultList = nativeQuery.getResultList();
        Map<String, Double> map = new HashMap<>();
        List<MonthBreakDownData> list = new ArrayList<MonthBreakDownData>();
        for (Object[] obj : resultList) {
            list.add(new MonthBreakDownData(obj[0].toString(),obj[1].toString(),(Double) obj[2]));
        }
        return list;
    }
}
