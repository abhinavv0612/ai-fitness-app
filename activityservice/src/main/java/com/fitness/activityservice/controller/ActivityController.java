package com.fitness.activityservice.controller;

import com.fitness.activityservice.dto.ActivityRequest;
import com.fitness.activityservice.dto.ActivityResponse;
import com.fitness.activityservice.service.ActivityService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@AllArgsConstructor
public class ActivityController {
    private ActivityService activityService;

@PostMapping
public ResponseEntity<@NonNull ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
    return ResponseEntity.ok(activityService.trackActivity(request));

}

@GetMapping
public ResponseEntity<@NonNull List<ActivityResponse>> getUserActivities(@RequestHeader("X-USER-ID") String userId) {
    return ResponseEntity.ok(activityService.getUserActivities(userId));
}

@GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable("activityId") String activityId) {
    return ResponseEntity.ok(activityService.getActivityById(activityId));
}


}
