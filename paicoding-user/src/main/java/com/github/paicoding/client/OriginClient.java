package com.github.paicoding.client;

import com.github.paicoding.entity.SiteCntVo;
import com.github.paicoding.forum.api.model.enums.HomeSelectEnum;
import com.github.paicoding.forum.api.model.vo.PageListVo;
import com.github.paicoding.forum.api.model.vo.PageParam;
import com.github.paicoding.forum.api.model.vo.article.dto.ArticleDTO;
import com.github.paicoding.forum.api.model.vo.article.dto.YearArticleDTO;
import com.github.paicoding.forum.api.model.vo.seo.Seo;
import com.github.paicoding.forum.api.model.vo.user.dto.UserStatisticInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@FeignClient("paicoding-origin")
public interface OriginClient {

    @RequestMapping("/article/api/tag/list")
    String testFeign();

    @RequestMapping("/rest/article/api/tag/list")
    List<YearArticleDTO> listYearArticleByUserId(@RequestParam("userId") Long userId);

    @RequestMapping(value = "/rest/queryArticlesByUserAndType", method = RequestMethod.POST)
    PageListVo<ArticleDTO> queryArticlesByUserAndType(@RequestParam("userId") Long userId, @RequestBody PageParam pageParam, @RequestParam("select") String select);


    @RequestMapping("/rest/queryUserNotifyMsgCount")
    Integer queryUserNotifyMsgCount(@RequestParam("userId") Long userId);

    @RequestMapping("/rest/defaultSeo")
    Seo defaultSeo();

    @RequestMapping("/rest/querySiteVisitInfo")
    SiteCntVo querySiteVisitInfo(@RequestParam("date") LocalDate date, @RequestParam("path") String path);

    @RequestMapping("/rest/queryUserStatisticInfo")
    UserStatisticInfoDTO queryUserStatisticInfo(@RequestParam("userId") Long userId);
}
