package cn.bugstack.mapstructsimplecase.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class DailyStepVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate recordDate;
    private BigDecimal totalDuration;
    private Integer totalEnergy;
    private Integer targetPercent;
    private Integer overallStatus;

    private String interpretation;

    // 派生字段（不来自数据库）
    private String overallStatusText;
}
