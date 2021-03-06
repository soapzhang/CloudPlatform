package com.oneplatform.user.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesuite.common.util.AssertUtil;
import com.jeesuite.common.util.BeanUtils;
import com.jeesuite.mybatis.plugin.pagination.Page;
import com.jeesuite.springweb.model.WrapperResponse;
import com.jeesuite.security.client.LoginContext;
import com.oneplatform.base.model.IdParam;

import com.oneplatform.user.dto.param.UserInfoQueryParam;
import com.oneplatform.user.dao.entity.UserInfoEntity;
import com.oneplatform.user.dto.param.UserInfoParam;
import com.oneplatform.user.service.UserInfoService;

import io.swagger.annotations.ApiOperation;

/**
 * generated by www.jeesuite.com
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    private @Autowired UserInfoService userInfoService;
	
	@ApiOperation(value = "分页查询")
	@RequestMapping(value = "list", method = RequestMethod.POST)
    public @ResponseBody Page<UserInfoEntity> pageQueryUserInfos(@RequestBody UserInfoQueryParam param) {
		Page<UserInfoEntity> page = userInfoService.pageQuery(param,param);
		return page;
	}
	
	@ApiOperation(value = "按id查询")
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public @ResponseBody WrapperResponse<UserInfoEntity> getById(@PathVariable("id") int id) {
		UserInfoEntity entity = userInfoService.findUserInfoById(id);
		return new WrapperResponse<>(entity);
	}
	
	@ApiOperation(value = "新增")
	@RequestMapping(value = "add", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> addUserInfo(@RequestBody UserInfoParam param) {
		UserInfoEntity entity = BeanUtils.copy(param, UserInfoEntity.class);
		//entity.setCreatedAt(new Date());
		//entity.setCreatedBy(LoginContext.getIntFormatUserId());
		userInfoService.addUserInfo(entity);
		
		return new WrapperResponse<>();
	}
	
	@ApiOperation(value = "更新")
	@RequestMapping(value = "update", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> updateUserInfo(@RequestBody UserInfoParam param) {
		UserInfoEntity entity = BeanUtils.copy(param, UserInfoEntity.class);
		//entity.setUpdatedAt(new Date());
		//entity.setUpdatedBy(LoginContext.getIntFormatUserId());
		userInfoService.updateUserInfo(entity);
		
		return new WrapperResponse<>();
	}
	
	@ApiOperation(value = "删除")
	@RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public @ResponseBody WrapperResponse<String> deleteUserInfo(@RequestBody IdParam param) {
		userInfoService.deleteUserInfo(param.getId());
		return new WrapperResponse<>();
	}
	
	
}
