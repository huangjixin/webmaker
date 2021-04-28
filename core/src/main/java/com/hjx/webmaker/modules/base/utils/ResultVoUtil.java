package com.hjx.webmaker.modules.base.utils;

import com.hjx.webmaker.modules.base.dto.ResultVo;

public class ResultVoUtil {
    public static ResultVo success(Object object) {
        ResultVo resultVO = new ResultVo();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVO = new ResultVo();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
