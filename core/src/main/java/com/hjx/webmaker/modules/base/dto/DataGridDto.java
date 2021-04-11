package com.hjx.webmaker.modules.base.dto;

import java.io.Serializable;
import java.util.List;

public class DataGridDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private List rows;
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
