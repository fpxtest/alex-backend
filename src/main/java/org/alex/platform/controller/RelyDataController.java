package org.alex.platform.controller;

import org.alex.platform.common.Result;
import org.alex.platform.exception.BusinessException;
import org.alex.platform.pojo.RelyDataDO;
import org.alex.platform.pojo.RelyDataDTO;
import org.alex.platform.service.RelyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelyDataController {
    @Autowired
    RelyDataService relyDataService;

    /**
     * 新增依赖数据
     *
     * @param relyDataDO relyDataDO
     * @return Result
     * @throws BusinessException BusinessException
     */
    @PostMapping("/rely/save")
    public Result saveRelyData(@Validated RelyDataDO relyDataDO) throws BusinessException {
        relyDataService.saveRelyData(relyDataDO);
        return Result.success("新增成功");
    }

    /**
     * 修改依赖数据
     *
     * @param relyDataDO relyDataDO
     * @return Result
     * @throws BusinessException BusinessException
     */
    @PostMapping("/rely/modify")
    public Result modifyRelyData(@Validated RelyDataDO relyDataDO) throws BusinessException {
        relyDataService.modifyRelyData(relyDataDO);
        return Result.success("修改成功");
    }

    /**
     * 查看依赖详情
     *
     * @param id 依赖编号
     * @return Result
     */
    @GetMapping("/rely/{id}")
    public Result findRelyDataById(@PathVariable Integer id) {
        return Result.success(relyDataService.findRelyDataById(id));
    }

    /**
     * 查看依赖列表
     *
     * @param relyDataDTO relyDataDTO
     * @param pageNum     pageNum
     * @param pageSize    pageSize
     * @return Result
     */
    @GetMapping("/rely")
    public Result findRelyDataList(RelyDataDTO relyDataDTO, Integer pageNum, Integer pageSize) {
        int num = pageNum == null ? 1 : pageNum;
        int size = pageSize == null ? 10 : pageSize;
        return Result.success(relyDataService.findRelyDataList(relyDataDTO, num, size));
    }

    /**
     * 删除依赖
     *
     * @param id 依赖编号
     * @return Result
     * @throws BusinessException BusinessException
     */
    @GetMapping("/rely/remove/{id}")
    public Result removeRelyData(@PathVariable Integer id) throws BusinessException {
        relyDataService.removeRelyDataById(id);
        return Result.success("删除成功");
    }
}
