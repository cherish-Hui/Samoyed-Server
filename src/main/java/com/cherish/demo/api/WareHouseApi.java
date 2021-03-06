package com.cherish.demo.api;

import com.cherish.demo.entity.warehouse.WareHouseMaterial;
import com.cherish.demo.entity.warehouse.WareHouseProduce;
import com.cherish.demo.entity.warehouse.WareHouseWaste;
import com.cherish.demo.service.FinanceService;
import com.cherish.demo.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/warehouse")
public class WareHouseApi {

    private Map newResult(int code, String status, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("status", status);
        result.put("message", message);
        return result;
    }

    private Map successResult() {
        return newResult(0, "success", "操作成功,请耐心等待.");
    }

    private Map failResult() {
        return newResult(-1, "fail", "操作失败,请联系服务支持(Cherish-Hui).");
    }

    private Map notEnoughResult() {
        return newResult(1, "not_enough", "操作终止,库存不足.");
    }

    @Autowired
    WareHouseService wareHouseService;

    /*
     * 仓储入库-采购
     * */

    @PostMapping(value = "/purchaseDelivery")
    public Map<String, Object> purchaseDelivery(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.purchaseDelivery(orderNumber);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseBatchDelivery")
    public Map<String, Object> purchaseBatchDelivery(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.purchaseBatchDelivery(orderNumbers);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseCheck")
    public Map<String, Object> purchaseCheck(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.purchaseCheck(orderNumber);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseBatchCheck")
    public Map<String, Object> purchaseBatchCheck(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.purchaseBatchCheck(orderNumbers);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseReturn")
    public Map<String, Object> purchaseReturn(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.purchaseReturn(orderNumber);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseBatchReturn")
    public Map<String, Object> purchaseBatchReturn(@RequestParam("orderNumbers") String[] orderNumbers) {
        String result = wareHouseService.purchaseBatchReturn(orderNumbers);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseStorage")
    public Map<String, Object> purchaseStorage(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.purchaseStorage(orderNumber);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/purchaseBatchStorage")
    public Map<String, Object> purchaseBatchStorage(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.purchaseBatchStorage(orderNumbers);
        switch (result) {
            case FinanceService.RESULT_SUCCESS:
                return successResult();
            case FinanceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    /*
     *仓储入库-生产
     */

    @PostMapping(value = "/produceStorage")
    public Map<String, Object> produceStorage(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.produceStorage(orderNumber);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/produceBatchStorage")
    public Map<String, Object> produceBatchStorage(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.produceBatchStorage(orderNumbers);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    /*
     *仓储出库-生产
     */

    @PostMapping(value = "/produceIssue")
    public Map<String, Object> produceIssue(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.produceIssue(orderNumber);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_NOT_ENOUGH:
                return notEnoughResult();
            default:
                return notEnoughResult();
        }
    }

    @PostMapping(value = "/produceBatchIssue")
    public Map<String, Object> produceBatchIssue(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.produceBatchIssue(orderNumbers);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_NOT_ENOUGH:
                return notEnoughResult();
            default:
                return notEnoughResult();
        }
    }

    /*
     * 仓储出库-销售
     * */

    @PostMapping(value = "/saleDeliver")
    public Map<String, Object> saleDeliver(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.saleDeliver(orderNumber);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_NOT_ENOUGH:
                return notEnoughResult();
            default:
                return notEnoughResult();
        }
    }

    @PostMapping(value = "/saleBatchDeliver")
    public Map<String, Object> saleBatchDeliver(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.saleBatchDeliver(orderNumbers);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_NOT_ENOUGH:
                return notEnoughResult();
            default:
                return notEnoughResult();
        }
    }

    @PostMapping(value = "/saleBack")
    public Map<String, Object> saleBack(@RequestParam("orderNumber") String orderNumber) {
        String result = wareHouseService.saleBack(orderNumber);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/saleBatchBack")
    public Map<String, Object> saleBatchBack(@RequestParam("orderNumbers[]") String[] orderNumbers) {
        String result = wareHouseService.saleBatchBack(orderNumbers);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    /*
     * 仓储明细
     * */

    @PostMapping(value = "/material/update")
    public Map<String, Object> updateMaterial(@RequestParam("data") String data) {
        String result = wareHouseService.updateMaterial(data);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/produce/update")
    public Map<String, Object> updateProduce(@RequestParam("data") String data) {
        String result = wareHouseService.updateProduce(data);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @PostMapping(value = "/waste/update")
    public Map<String, Object> updateWaste(@RequestParam("data") String data) {
        String result = wareHouseService.updateWaste(data);
        switch (result) {
            case WareHouseService.RESULT_SUCCESS:
                return successResult();
            case WareHouseService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }

    @GetMapping("/getAllMaterial")
    public List<WareHouseMaterial> getAllMaterial() {
        return wareHouseService.getAllMaterial();
    }

    @GetMapping("/getAllProduce")
    public List<WareHouseProduce> getAllProduce() {
        return wareHouseService.getAllProduce();
    }

    @GetMapping("/getAllWaste")
    public WareHouseWaste getAllWaste() {
        return wareHouseService.getAllWaste();
    }


}
