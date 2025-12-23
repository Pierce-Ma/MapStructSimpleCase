package cn.bugstack.mapstructsimplecase.model.Entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@TableName("daily_step_summaries")
public class DailyStepSummaries implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private LocalDate recordDate;

    private BigDecimal totalDuration;

    private Integer totalEnergy;

    private Integer targetPercent;

    private Integer overallStatus;

    private String interpretation;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;
}
