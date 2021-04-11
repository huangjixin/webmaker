package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.art.domain.ArticleCriteria;
import com.hjx.webmaker.modules.base.dto.DataGridDto;
import com.hjx.webmaker.modules.base.web.BaseRestController;
import com.hjx.webmaker.modules.art.domain.Article;
import com.hjx.webmaker.modules.art.service.IArticleService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("admin/art/article")
public class ArticleRestController extends BaseRestController<Article> {
    private static Logger logger = LoggerFactory.getLogger(ArticleRestController.class);

    @Qualifier(value = "articleService")
    @Autowired
    private IArticleService articleService;

    @ApiOperation(value = "获取文章分页数据", notes = "获取文章分页数据", httpMethod = "GET", tags = "文章管理相关api")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "第几页开始，默认为1", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "rows", value = "每页记录数的大小，默认为50", dataType = "int", paramType = "query"),
    })
    @ApiResponses({//方法返回值的swagger注释
            @ApiResponse(code = 200, message = "成功", response = DataGridDto.class),
            @ApiResponse(code = 400, message = "文章输入错误", response = DataGridDto.class),
            @ApiResponse(code = 500, message = "系统内部错误", response = DataGridDto.class)
    })
    @GetMapping("listPage")
    public DataGridDto listPage(@RequestParam(name = "page", defaultValue = "1", required = false) Integer page,
                                @RequestParam(name = "rows", defaultValue = "50", required = false) Integer rows,
                                HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws JSONException {
        ArticleCriteria example = this.getCriteria(httpServletRequest);
        if (example == null) {
            example = new ArticleCriteria();
        }
        int start = (page - 1) * rows;
        example.setLimitStart(start);
        example.setLimitSize(rows);
        List<Article> list = articleService.selectByExample(example);
        Long total = articleService.countByExample(example);

        DataGridDto gridDto = new DataGridDto();
        gridDto.setRows(list);
        gridDto.setTotal(total);
        return gridDto;
    }

    private ArticleCriteria getCriteria(HttpServletRequest request) {
        ArticleCriteria example = null;
        if (request.getParameterNames().hasMoreElements()) {
            example = new ArticleCriteria();
            ArticleCriteria.Criteria criteria = example.createCriteria();
            String name = request.getParameter("name");
            if (!StringUtils.isEmpty(name)) {
                criteria.andNameLike("%" + name + "%");
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
            }
        }else{
            example.setOrderByClause( "created_time desc");
        }
        return example;
    }
}
