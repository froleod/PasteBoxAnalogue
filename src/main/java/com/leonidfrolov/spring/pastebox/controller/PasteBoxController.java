package com.leonidfrolov.spring.pastebox.controller;

import com.leonidfrolov.spring.pastebox.api.request.PasteBoxRequest;
import com.leonidfrolov.spring.pastebox.api.response.PasteBoxResponse;
import com.leonidfrolov.spring.pastebox.api.response.PasteBoxUrlResponse;
import com.leonidfrolov.spring.pastebox.service.PasteBox;
import com.leonidfrolov.spring.pastebox.service.PasteBoxImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PasteBoxController {

    private final PasteBox pasteBoxService;

    @GetMapping("/{hash}")
    public PasteBoxResponse getByHash(@PathVariable String hash){
        return pasteBoxService.getByHash(hash);
    }

    @GetMapping("/")
    public Collection<PasteBoxResponse> getPublicPasteList(){
        return pasteBoxService.getFirstPublicPasteBox();
    }

    @PostMapping("/")
    public PasteBoxUrlResponse addNewPaste(@RequestBody PasteBoxRequest request){
        return pasteBoxService.create(request);
    }

}
