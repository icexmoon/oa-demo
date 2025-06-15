package cn.icexmoon.oaservice.service;

import cn.icexmoon.oaservice.dto.ApplyAddDTO;
import cn.icexmoon.oaservice.dto.ApprovalResultDTO;
import cn.icexmoon.oaservice.entity.ApplyInstance;
import cn.icexmoon.oaservice.entity.User;
import cn.icexmoon.oaservice.util.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;

/**
 * @author 70748
 * @description 针对表【apply_instance(申请流实例)】的数据库操作Service
 * @createDate 2025-06-08 16:06:13
 */
public interface ApplyInstanceService extends IService<ApplyInstance> {

    /**
     * 添加流程实例
     *
     * @param dto  流程实例
     * @param user 提交申请的人
     * @return 流程实例id
     */
    Result<Long> add(ApplyAddDTO dto, User user);

    /**
     * 是否已经使用过指定表单
     *
     * @param formId
     * @return
     */
    boolean alreadyUseForm(Long formId);

    /**
     * 获取申请流实例的分页信息
     *
     * @param pageNum        页码
     * @param pageSize       页宽
     * @param applyProcessId 申请流id
     * @param beginDate      开始时间
     * @param endDate        结束时间
     * @param userId         申请用户id
     * @return 申请流实例的分页信息
     */
    IPage<ApplyInstance> queryPage(Long pageNum, Long pageSize, Long applyProcessId, Date beginDate, Date endDate, Long userId);

    /**
     * 获取申请实例的详细信息
     *
     * @param applyInstanceId 申请实例id
     * @return 申请实例详细信息
     */
    ApplyInstance getApplyInstance(Long applyInstanceId);

    /**
     * 查询指定用户待审批的分页信息
     *
     * @param pageNum        页码
     * @param pageSize       页宽
     * @param applyProcessId 申请流id
     * @param approvalUserId 审批人
     * @param status         审批状态
     * @return
     */
    IPage<ApplyInstance> queryPreapprovalPage(Long pageNum, Long pageSize,
                                              Long applyProcessId,
                                              Long approvalUserId,
                                              ApplyInstance.ApprovalStatus status);

    /**
     * 审批
     *
     * @param dto 审批信息
     * @return 审批结果
     */
    boolean approval(ApprovalResultDTO dto);

    /**
     * 申请流正常结束
     */
    void endProcess(String processInstanceId);


    /**
     * 分页查询指定用户审批过的流程实例
     *
     * @param userId         指定用户id
     * @param applyProcessId 申请类型
     * @param beginDate      审批时间查询开始时间
     * @param endDate        审批时间查询结束时间
     * @param pageNum        页码
     * @param pageSize       页宽
     * @return 分页信息
     */
    IPage<ApplyInstance> queryApprovedPage(Long userId, Long pageNum, Long pageSize, Date beginDate, Date endDate, Long applyProcessId);
}
