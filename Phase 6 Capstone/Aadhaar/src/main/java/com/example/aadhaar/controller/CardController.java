package com.example.aadhaar.controller;

import com.example.aadhaar.model.AadhaarCard;
import com.example.aadhaar.service.CardService;
import com.example.aadhaar.vo.AadhaarResponse;
import com.example.aadhaar.vo.AadhaarUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;


@RestController
@RequestMapping("/aadhaarCard")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/approve")
    public AadhaarResponse approve(@RequestParam
                                       @Valid
                                       @Min(value = 1, message = "Invalid aadhaar request id")
                                       int aadhaarRequestId,
                                   @RequestHeader String authorization){
        return cardService.approve(aadhaarRequestId, authorization);
    }

    @GetMapping("/pending")
    public List<AadhaarCard> getAllPendingCardsForApproval(){
        return cardService.pendingForApproval();
    }

    @GetMapping
    public AadhaarResponse status(@RequestHeader String authorization){
        return cardService.status(authorization);
    }

    @PutMapping("/update")
    public AadhaarResponse update(@Valid @RequestBody AadhaarUpdateRequest updateRequest, @RequestHeader String authorization){
        return cardService.update(updateRequest, authorization);
    }

    @GetMapping("/duplicate")
    public AadhaarResponse duplicate(@RequestHeader String authorization){
        return cardService.duplicate(authorization);
    }
}
