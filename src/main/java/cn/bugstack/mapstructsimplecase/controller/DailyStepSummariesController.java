package cn.bugstack.mapstructsimplecase.controller;

import cn.bugstack.mapstructsimplecase.model.form.DailyStepCreateForm;
import cn.bugstack.mapstructsimplecase.model.form.DailyStepUpdateForm;
import cn.bugstack.mapstructsimplecase.model.vo.DailyStepVO;
import cn.bugstack.mapstructsimplecase.service.DailyStepSummariesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/daily-step")
@RequiredArgsConstructor
public class DailyStepSummariesController {
    private final DailyStepSummariesService dailyStepSummariesService;
    @PostMapping
    public Long create(@Valid @RequestBody DailyStepCreateForm dailyStepCreateForm) {
        return dailyStepSummariesService.create(dailyStepCreateForm);
    }
    @PutMapping
    public void update(@Valid @RequestBody DailyStepUpdateForm dailyStepUpdateForm) {
        dailyStepSummariesService.update(dailyStepUpdateForm);
    }
    @GetMapping("/{id}")
    public DailyStepVO get(@PathVariable Long id) {
        return dailyStepSummariesService.get(id);
    }
    @GetMapping
    public List<DailyStepVO> mine() {
        return dailyStepSummariesService.listMine();
    }
}
