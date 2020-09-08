package org.alex.platform.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.alex.platform.exception.BusinessException;
import org.alex.platform.exception.ParseException;
import org.alex.platform.exception.SqlException;
import org.alex.platform.mapper.InterfaceCaseMapper;
import org.alex.platform.mapper.InterfaceSuiteCaseRefMapper;
import org.alex.platform.pojo.InterfaceSuiteCaseRefDO;
import org.alex.platform.pojo.InterfaceSuiteCaseRefDTO;
import org.alex.platform.pojo.InterfaceSuiteCaseRefVO;
import org.alex.platform.service.InterfaceCaseService;
import org.alex.platform.service.InterfaceSuiteCaseRefService;
import org.alex.platform.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class InterfaceSuiteCaseRefServiceImpl implements InterfaceSuiteCaseRefService {
    @Autowired
    InterfaceSuiteCaseRefMapper  interfaceSuiteCaseRefMapper;
    @Autowired
    InterfaceCaseService interfaceCaseService;

    @Override
    public void saveSuiteCase(List<InterfaceSuiteCaseRefDO> interfaceSuiteCaseRefDOList) {
        interfaceSuiteCaseRefMapper.insertSuiteCase(interfaceSuiteCaseRefDOList);
    }

    @Override
    public void removeSuiteCase(Integer incrementKey) {
        interfaceSuiteCaseRefMapper.deleteSuiteCase(incrementKey);
    }

    @Override
    public PageInfo<InterfaceSuiteCaseRefVO> findSuiteCaseList(InterfaceSuiteCaseRefDTO interfaceSuiteCaseRefDTO, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(interfaceSuiteCaseRefMapper.selectSuiteCaseList(interfaceSuiteCaseRefDTO));
    }

    @Override
    public void executeSuiteCaseById(Integer suiteId) throws ParseException, BusinessException, SqlException {
        // 获取测试套件下所有测试用例 筛选已启用的
        InterfaceSuiteCaseRefDTO interfaceSuiteCaseRefDTO = new InterfaceSuiteCaseRefDTO();
        interfaceSuiteCaseRefDTO.setSuiteId(suiteId);
        interfaceSuiteCaseRefDTO.setCaseStatus((byte)0);
        List<InterfaceSuiteCaseRefVO> suiteCaseList = interfaceSuiteCaseRefMapper.selectSuiteCaseList(interfaceSuiteCaseRefDTO);
        // 并行case
        suiteCaseList.parallelStream().forEach(suiteCase -> {
            Integer caseId = suiteCase.getCaseId();
            try {
                interfaceCaseService.executeInterfaceCase(caseId);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        });
//        for (InterfaceSuiteCaseRefVO suiteCase : suiteCaseList) {
//            Integer caseId = suiteCase.getCaseId();
//            // 执行用例
//            interfaceCaseService.executeInterfaceCase(caseId);
//        }
    }
}