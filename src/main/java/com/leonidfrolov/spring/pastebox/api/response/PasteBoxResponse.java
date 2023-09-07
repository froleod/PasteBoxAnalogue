package com.leonidfrolov.spring.pastebox.api.response;

import com.leonidfrolov.spring.pastebox.api.request.PublicStatus;
import com.leonidfrolov.spring.pastebox.service.PasteBox;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class PasteBoxResponse {
    private final String data;
    private final boolean isPublic;
}
