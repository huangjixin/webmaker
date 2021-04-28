package com.hjx.webmaker.modules.art.web.admin;

import com.hjx.webmaker.modules.art.domain.Channel;
import com.hjx.webmaker.modules.art.service.IChannelService;
import com.hjx.webmaker.modules.base.web.BaseRestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Api(tags = "频道")
@AllArgsConstructor
@RestController
@RequestMapping("admin/art/channel")
public class ChannelRestController extends BaseRestController<Channel> {
    private static Logger logger = LoggerFactory.getLogger(ChannelRestController.class);

    @Qualifier(value = "channelService")
    @Autowired
    private IChannelService channelService;

    /**
     * 获取频道树数据结构数据
     *
     * @param parentId
     * @param channelId
     * @param request
     * @param response
     * @return
     */
    @ApiOperation(value = "获取频道树数据结构数据", notes = "获取频道树数据结构数据", httpMethod = "GET", tags = "频道")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parentId", value = "父亲ID，默认为空字符串，如果不为空还要查询该字段所在条目，再在列表当中设置为选中状态", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "channelId", value = "频道ID，默认为空字符串，如果不为空还要查询该字段所在条目数，再在列表当中设置为选中状态", dataType = "String", paramType = "query"),
    })
    @GetMapping("tree")
    public List tree(@RequestParam(name = "parentId", required = false) Long parentId,
                     @RequestParam(name = "channelId", required = false) Long channelId,
                     HttpServletRequest request, HttpServletResponse response) {

        List list = this.channelService.getTree(parentId, channelId);
        return list;
    }
}
