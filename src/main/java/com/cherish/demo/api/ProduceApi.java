package com.cherish.demo.api;

import com.cherish.demo.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/produce")
public class ProduceApi {

    @Autowired
    ProduceService produceService;

    private Map newResult(int code, String status, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", code);
        result.put("status", status);
        result.put("message", message);
        return result;
    }

    private Map successResult() {
        return newResult(0, "success", "已提交,请耐心等待审核。");
    }

    private Map failResult() {
        return newResult(-1, "fail", "提交失败，请联系服务支持(Cherish-Hui)。");
    }

    @PostMapping(value = "/plan")
    public Map<String, Object> plan(@RequestParam("data") String data, HttpSession session) {
        String result = produceService.plan(data,session);
        switch (result) {
            case ProduceService.RESULT_SUCCESS:
                return successResult();
            case ProduceService.RESULT_ERROR:
                return failResult();
            default:
                return failResult();
        }
    }


}