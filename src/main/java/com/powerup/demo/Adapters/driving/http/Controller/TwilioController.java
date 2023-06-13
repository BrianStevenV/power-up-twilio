package com.powerup.demo.Adapters.driving.http.Controller;

import com.powerup.demo.Adapters.driving.http.handler.ITwilioHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/twilio/")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class TwilioController {
    private final ITwilioHandler twilioHandler;

    @Operation(summary = "Send a new Message ",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Notification created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "Error n@",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("notification/")
    public ResponseEntity<String> sendNotification(){
        return ResponseEntity.ok(twilioHandler.message());
    }
}
