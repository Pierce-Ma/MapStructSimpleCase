package cn.bugstack.mapstructsimplecase.controller;

import cn.bugstack.mapstructsimplecase.converter.DailyStepSummariesConverter;
import cn.bugstack.mapstructsimplecase.model.Entity.DailyStepSummaries;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepUpdateForm;
import cn.bugstack.mapstructsimplecase.model.vo.DailyStepVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/mapstruct")
@RequiredArgsConstructor
public class MapStructTestController {

    private final DailyStepSummariesConverter converter;

    /**
     * 验证：Entity → VO
     */
    @PostMapping("/toVO")
    public DailyStepVO toVO() {
        DailyStepSummaries entity = new DailyStepSummaries();
        entity.setTotalDuration(new BigDecimal("1.5"));
        entity.setTotalEnergy(350);
        entity.setOverallStatus(1);

        return converter.toVO(entity);
    }

    /**
     * 验证：Update（@MappingTarget）
     */
    @PostMapping("/update")
    public DailyStepSummaries update(@RequestBody DailyStepUpdateForm form) {
        DailyStepSummaries entity = new DailyStepSummaries();
        entity.setUserId(1001L);
        entity.setTotalDuration(new BigDecimal("2.0"));
        entity.setTotalEnergy(500);
        entity.setOverallStatus(3);

        // MapStruct 更新
        converter.updateEntity(form, entity);
        return entity;
    }
}
