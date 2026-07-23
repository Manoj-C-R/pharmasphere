/**
 * Health check REST controller.
 *
 * @author Manoj C R
 * @version 1.0.0
 */
package com.pharmasphere.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmasphere.common.ApiResponse;


@RestController
public class HealthController {

    @GetMapping("/api/health")
    public ApiResponse health() {
    	return new ApiResponse(true, "Welcome Manu", "v1.0");
    }

}