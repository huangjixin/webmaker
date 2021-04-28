package com.hjx.webmaker.modules.sys.web.admin;

import com.hjx.webmaker.modules.base.dto.DataGridDto;
import com.hjx.webmaker.modules.base.dto.ResultVo;
import com.hjx.webmaker.modules.base.utils.ResultVoUtil;
import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.sys.domain.User;
import com.hjx.webmaker.modules.sys.domain.UserCriteria;
import com.hjx.webmaker.modules.sys.service.IUserService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "角色")
@AllArgsConstructor
@RestController
@RequestMapping("admin/sys/user")
public class UserRestController extends BaseRestController<User> {
    private static Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Qualifier(value = "userService")
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "获取角色分页数据", notes = "获取角色分页数据", httpMethod = "GET", tags = "角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页开始，默认为1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "每页记录数的大小，默认为50", dataType = "int", paramType = "query"),
    })
    @ApiResponses({//方法返回值的swagger注释
            @ApiResponse(code = 200, message = "成功", response = DataGridDto.class),
            @ApiResponse(code = 400, message = "角色输入错误", response = DataGridDto.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = DataGridDto.class)
    })
    @GetMapping("listPage")
    public DataGridDto listPage(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                @RequestParam(name = "rows", defaultValue = "50", required = false) Integer rows,
                                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws JSONException {
        UserCriteria example = this.getCriteria(httpServletRequest);
        if (example == null) {
            example = new UserCriteria();
        }
        int start = (page - 1) * rows;
        example.setLimitStart(start);
        example.setLimitSize(rows);
        List<User> list = userService.selectByExample(example);
        Long total = userService.countByExample(example);

        DataGridDto gridDto = new DataGridDto();
        gridDto.setRows(list);
        gridDto.setTotal(total);
        return gridDto;
    }

    private UserCriteria getCriteria(HttpServletRequest request) {
        UserCriteria example = null;
        if (request.getParameterNames().hasMoreElements()) {
            example = new UserCriteria();
            UserCriteria.Criteria criteria = example.createCriteria();
            String name = request.getParameter("name");
            if (!StringUtils.isEmpty(name)) {
                criteria.andLoginNameLike("%" + name + "%");
            }
            
            String sort = request.getParameter("sort");
            String sortOrder = request.getParameter("sortOrder");
            if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(sortOrder)) {
                /*if("loginName".equals(sort)){
                    sort = "login_name";
                }

                if("realName".equals(sort)){
                    sort = "real_name";
                }

                if("createTime".equals(sort)){
                    sort = "create_time";
                }

                if("updateTime".equals(sort)){
                    sort = "update_time";
                }*/

                example.setOrderByClause(sort + " " + sortOrder);
            } else {
                example.setOrderByClause("create_time desc");
            }
        }
        return example;
    }


    @ApiOperation(value = "删除对象", notes = "删除对象", httpMethod = "POST", tags = "角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "对象ID", dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功", response = ResultVo.class),
            @ApiResponse(code = 200, message = "删除成功", response = ResultVo.class),
    })
    @PostMapping("deleteByKey/{id}")
    public ResultVo deleteByKey(@PathVariable(name = "id") String id,
                                HttpServletRequest request, HttpServletResponse response) {
        int result = this.userService.deleteByPrimaryKey(id);

        return result > 0 ? ResultVoUtil.success() : ResultVoUtil.error(400, "删除失败");
    }

    @ApiOperation(value = "批量删除对象", notes = "批量删除对象", httpMethod = "POST", tags = "角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "对象ID", dataType = "String", paramType = "query")
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "删除成功", response = ResultVo.class),
            @ApiResponse(code = 200, message = "删除成功", response = ResultVo.class),
    })
    @PostMapping("deleteBatch")
    public ResultVo deleteBatch(@RequestParam List<String> list,
                                HttpServletRequest request, HttpServletResponse response) {
//        List<String> list = Arrays.asList(ids);
        UserCriteria userCriteria = new UserCriteria();
        userCriteria.createCriteria().andIdIn(list);
        int result = this.userService.deleteByExample(userCriteria);

        return result > 0 ? ResultVoUtil.success() : ResultVoUtil.error(400, "删除失败");
    }

}
