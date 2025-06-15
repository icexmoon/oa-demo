package cn.icexmoon.oaservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 申请流
 *
 * @TableName apply_process
 */
@TableName(value = "apply_process", autoResultMap = true)
@Data
public class ApplyProcess {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 申请名称
     */
    private String name;

    /**
     * 可以使用申请的职位
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<Integer> positionIds;

    /**
     * 申请使用的activiti流程的key
     */
    private String processKey;

    /**
     * 关联的表单key
     */
    private String formKey;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 是否启用
     */
    private Boolean enable;
    /**
     * 申请流使用的申请表
     */
    @TableField(exist = false)
    private ApplyForm applyForm;

    /**
     * 判断指定职位是否能申请当前申请流
     *
     * @param positionId 职位
     * @return
     */
    public boolean canApply(Integer positionId) {
        // 无论如何，任何人都可以申请的申请流都可以申请
        if (this.positionIds == null || this.positionIds.isEmpty()) {
            return true;
        }
        // 只有指定职位不为 null，且申请流包含该职位的情况下才能提交申请
        return positionId != null && this.positionIds.contains(positionId);
    }
}