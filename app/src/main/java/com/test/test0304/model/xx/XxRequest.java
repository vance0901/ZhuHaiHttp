package com.test.test0304.model.xx;

import java.util.List;
import java.util.ArrayList;

/**
 * 删除请求模型类 - 用于DELETE请求的JSON提交
 * 包含需要删除的ID列表
 */
public class XxRequest {
    private List<String> ids;

    public XxRequest() {
        this.ids = new ArrayList<>();
    }

    public XxRequest(List<String> ids) {
        this.ids = ids;
    }

    /**
     * 添加单个ID到删除列表
     * @param id 要删除的ID
     */
    public void addId(String id) {
        if (this.ids == null) {
            this.ids = new ArrayList<>();
        }
        this.ids.add(id);
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "XxRequest{" +
                "ids=" + ids +
                '}';
    }
} 