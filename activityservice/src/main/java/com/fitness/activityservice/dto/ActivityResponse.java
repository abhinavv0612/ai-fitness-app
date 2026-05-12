package com.fitness.activityservice.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fitness.activityservice.model.ActivityType;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@JsonPropertyOrder({
        "id",
        "userId",
        "type",
        "duration",
        "caloriesBurned",
        "startTime",
        "additionalMetrics",
        "createdAt",
        "updatedAt"
})
public class ActivityResponse {
    private String id;
    private String userId;
    private ActivityType type;
    private Integer duration;
    private Integer caloriesBurned;
    private LocalDateTime startTime;
    private Map<String,Object> additionalMetrics;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
