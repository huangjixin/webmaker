package com.hjx.webmaker.modules.base.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("Datagrid数据表格调用通用返回对象")
public class DataGridDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("列表数据")
    private List rows;
    @ApiModelProperty("总数")
    private Long total;

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }


}
