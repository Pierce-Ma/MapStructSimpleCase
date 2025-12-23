package cn.bugstack.mapstructsimplecase.model.form;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class DailyStepCreateForm implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer recordDate;
    @NotNull
    private BigDecimal totalDuration;

    @NotNull
    private Integer totalEnergy;

    @NotNull
    private Integer targetPercent;

    @NotNull
    private Integer overallStatus;

    private String interpretation;

}
