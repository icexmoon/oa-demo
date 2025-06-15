package cn.icexmoon.oaservice.service;

import cn.icexmoon.oaservice.dto.KeyNameDTO;
import cn.icexmoon.oaservice.entity.ApplyProcess;
import cn.icexmoon.oaservice.entity.User;
import cn.icexmoon.oaservice.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * @author 70748
 * @description 针对表【apply_process(申请流)】的数据库操作Service
 * @createDate 2025-06-07 19:37:15
 */
public interface ApplyProcessService extends IService<ApplyProcess> {

    /**
     * 增加申请流
     *
     * @param applyProcess 申请流
     * @return 申请流id
     */
    Result<Long> add(ApplyProcess applyProcess);

    /**
     * 分页信息查询
     *
     * @param pageNum    页码
     * @param pageSize   页宽
     * @param name       申请名称
     * @param processKey 关联的流程key
     * @param startDate  开始日期
     * @param endDate    结束日期
     * @param enable     是否激活
     * @return 分页信息
     */
    Result<IPage<ApplyProcess>> queryPage(Long pageNum, Long pageSize, String name, String processKey, Date startDate, Date endDate, Boolean enable);

    /**
     * 启用/停用申请流
     *
     * @param processId 申请流id
     * @param enable    是否启用
     * @return 成功/失败
     */
    Result<Void> enable(Long processId, boolean enable);

    /**
     * 更新申请流
     *
     * @param applyProcess 申请流
     * @return 成功/失败
     */
    Result<Void> edit(ApplyProcess applyProcess);

    /**
     * 返回指定用户可以提交的申请流
     *
     * @param user 指定用户
     * @return 可以提交申请的申请流
     */
    Result<List<ApplyProcess>> listCanApply(User user);

    /**
     * 删除申请流
     *
     * @param id 申请流id
     * @return 成功/失败
     */
    Result<Void> del(Long id);

    /**
     * 获取申请流详情
     *
     * @param id 申请流id
     * @return 申请流详情
     */
    Result<ApplyProcess> getApplyProcess(Long id);

    /**
     * 获取审批状态列表
     *
     * @return 审批状态列表
     */
    List<KeyNameDTO> getApprovalStatus();
}
