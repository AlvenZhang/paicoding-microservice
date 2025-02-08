package com.github.paicoding.adaptor;

import com.github.paicoding.entity.vo.SiteCntVo;
import com.github.paicoding.entity.vo.UserHomeVo;
import com.github.paicoding.forum.api.model.vo.PageListVo;
import com.github.paicoding.forum.api.model.vo.PageParam;
import com.github.paicoding.forum.api.model.vo.article.dto.ArticleDTO;
import com.github.paicoding.forum.api.model.vo.article.dto.YearArticleDTO;
import com.github.paicoding.forum.api.model.vo.seo.Seo;
import com.github.paicoding.forum.api.model.vo.user.dto.UserStatisticInfoDTO;
import com.github.paicoding.forum.core.enums.HomeSelectEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@FeignClient("paicoding-origin")
public interface OriginClient {

    @RequestMapping("/article/api/tag/list")
    String testFeign();

    @RequestMapping("/rest/listYearArticleByUserId")
    List<YearArticleDTO> listYearArticleByUserId(@RequestParam("userId") Long userId);

    @RequestMapping(value = "/rest/queryArticlesByUserAndType", method = RequestMethod.POST)
    PageListVo<ArticleDTO> queryArticlesByUserAndType(@RequestParam("userId") Long userId, @RequestBody PageParam pageParam, @RequestParam("select") HomeSelectEnum select);


    @RequestMapping("/rest/queryUserNotifyMsgCount")
    Integer queryUserNotifyMsgCount(@RequestParam("userId") Long userId);

    @RequestMapping("/rest/defaultSeo")
    Seo defaultSeo();
    @RequestMapping("/rest/initSeo")
    Seo initUserSeo(@RequestBody UserHomeVo vo);

    @RequestMapping("/rest/querySiteVisitInfo")
    SiteCntVo querySiteVisitInfo(@RequestParam("date") LocalDate date, @RequestParam("path") String path);

    @RequestMapping("/rest/queryUserStatisticInfo")
    UserStatisticInfoDTO queryUserStatisticInfo(@RequestParam("userId") Long userId);

}
