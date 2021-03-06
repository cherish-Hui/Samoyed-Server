package com.cherish.demo.dao;

import com.cherish.demo.entity.produce.ProduceOrder;
import com.cherish.demo.entity.produce.ProduceOrderActualDetail;
import com.cherish.demo.entity.produce.ProduceOrderPlanDetail;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduceDao {

    void insertProduceOrder(ProduceOrder produceOrder);

    void insertProduceOrderPlanDetail(ProduceOrderPlanDetail produceOrderPlanDetail);

    void insertProduceOrderActualDetail(ProduceOrderActualDetail produceOrderActualDetail);

    void updateProduceWaste(ProduceOrder produceOrder);

    void updateProduceOrderStatus(ProduceOrder produceOrder);

    void deleteProduceOrder(String orderNumber);

    void deleteProduceOrderPlanDetail(String orderNumber);

    ProduceOrder selectProduceOrderByOrderNumber(String orderNumber);

    List<ProduceOrder> selectAllProduceOrder(String statusId);

    List<ProduceOrder> selectAllToIssueProduceOrder();

    List<ProduceOrder> selectAllAlreadyIssueProduceOrder();

    List<ProduceOrderPlanDetail> selectAllProduceOrderPlanDetailProduceByOrderNumber(String orderNumber);

    List<ProduceOrderPlanDetail> selectAllProduceOrderPlanDetailMaterialByOrderNumber(String orderNumber);

    List<ProduceOrderActualDetail> selectAllProduceOrderActualDetailByOrderNumber(String orderNumber);

}
