package cn.bugstack.mapstructsimplecase.model.form;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class DailyStepUpdateForm implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    private BigDecimal totalDuration;
    private Integer totalEnergy;
    private Integer targetPercent;
    private Integer overallStatus;
    private String interpretation;
}