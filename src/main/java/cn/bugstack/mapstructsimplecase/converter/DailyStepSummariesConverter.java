package cn.bugstack.mapstructsimplecase.converter;

import cn.bugstack.mapstructsimplecase.model.Entity.DailyStepSummaries;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepCreateForm;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepUpdateForm;
import cn.bugstack.mapstructsimplecase.model.vo.DailyStepVO;
import org.mapstruct.*;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel = "spring")
public interface DailyStepSummariesConverter {
    /* ========= 新增 ========= */

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "createdTime", ignore = true)
    @Mapping(target = "updatedTime", ignore = true)
    DailyStepSummaries toEntity(DailyStepCreateForm form);

    /* ========= 查询 ========= */

    @Mapping(
            target = "overallStatusText",
            expression = "java(statusText(entity.getOverallStatus()))"
    )
    DailyStepVO toVO(DailyStepSummaries entity);

    List<DailyStepVO> toVOList(List<DailyStepSummaries> list);

    /* ========= 更新（重点） ========= */

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "userId", ignore = true)
    @Mapping(target = "recordDate", ignore = true)
    @Mapping(target = "createdTime", ignore = true)
    @Mapping(target = "updatedTime", ignore = true)
    void updateEntity(DailyStepUpdateForm form,
                      @MappingTarget DailyStepSummaries entity);

    /* ========= 工具方法 ========= */

    default String statusText(Integer status) {
        if (status == null) return "未知";
        return switch (status) {
            case 1 -> "良好";
            case 2 -> "一般";
            case 3 -> "较差";
            default -> "未知";
        };
    }
}
