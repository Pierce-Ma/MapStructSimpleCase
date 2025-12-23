package cn.bugstack.mapstructsimplecase.service;

import cn.bugstack.mapstructsimplecase.converter.DailyStepSummariesConverter;
import cn.bugstack.mapstructsimplecase.mapper.DailyStepSummariesMapper;
import cn.bugstack.mapstructsimplecase.model.Entity.DailyStepSummaries;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepCreateForm;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepUpdateForm;
import cn.bugstack.mapstructsimplecase.model.vo.DailyStepVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyStepSummariesService {
    private final DailyStepSummariesMapper dailyStepSummariesMapper;
    private final DailyStepSummariesConverter dailyStepSummariesConverter;
    private Long currentUserId(){
        return 1001L;
    }
    public long create(DailyStepCreateForm dailyStepCreateForm){
        DailyStepSummaries entity = dailyStepSummariesConverter.toEntity(dailyStepCreateForm);
        entity.setUserId(currentUserId());
        entity.setCreatedTime(LocalDateTime.now());
        entity.setUpdatedTime(LocalDateTime.now());
        dailyStepSummariesMapper.insert(entity);
        return entity.getId();
    }
    public void update(DailyStepUpdateForm dailyStepUpdateForm){
        DailyStepSummaries entity = dailyStepSummariesMapper.selectById(dailyStepUpdateForm.getId());
        if(entity == null){
            throw new RuntimeException("记录不存在");
        }
        dailyStepSummariesConverter.updateEntity(dailyStepUpdateForm, entity);
        entity.setUpdatedTime(LocalDateTime.now());
        dailyStepSummariesMapper.updateById(entity);
    }
    public DailyStepVO get(Long id) {
        return dailyStepSummariesConverter.toVO(dailyStepSummariesMapper.selectById(id));
    }
    public List<DailyStepVO> listMine() {
        return dailyStepSummariesConverter.toVOList(
                dailyStepSummariesMapper.selectList(
                        new com.baomidou.mybatisplus.core.conditions.query.QueryWrapper<DailyStepSummaries>()
                                .eq("user_id", currentUserId())
                                .orderByDesc("record_date")
                )
        );
    }
}
