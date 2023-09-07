package com.leonidfrolov.spring.pastebox.repository;

import com.leonidfrolov.spring.pastebox.entity.PasteBoxEntity;

import java.util.List;

public interface PasteBoxRepository {
    PasteBoxEntity getByHash(String hash);
    List<PasteBoxEntity> getListOfPublicAndAlive(int amount);
    void add(PasteBoxEntity pasteBoxEntity);

}
