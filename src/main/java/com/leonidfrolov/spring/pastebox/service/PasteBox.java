package com.leonidfrolov.spring.pastebox.service;

import com.leonidfrolov.spring.pastebox.api.request.PasteBoxRequest;
import com.leonidfrolov.spring.pastebox.api.response.PasteBoxResponse;
import com.leonidfrolov.spring.pastebox.api.response.PasteBoxUrlResponse;

import java.util.List;

public interface PasteBox {
    PasteBoxResponse getByHash(String hash);
    List<PasteBoxResponse> getFirstPublicPasteBox();

    PasteBoxUrlResponse create(PasteBoxRequest request);
}
