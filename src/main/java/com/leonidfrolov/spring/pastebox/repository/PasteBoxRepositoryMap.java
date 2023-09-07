package com.leonidfrolov.spring.pastebox.repository;

import com.leonidfrolov.spring.pastebox.entity.PasteBoxEntity;
import com.leonidfrolov.spring.pastebox.exception.NotFoundEntityException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PasteBoxRepositoryMap implements PasteBoxRepository{

    private final Map<String, PasteBoxEntity> vault = new ConcurrentHashMap<>();

    @Override
    public PasteBoxEntity getByHash(String hash) {
        PasteBoxEntity pasteBoxEntity = vault.get(hash);
        if(pasteBoxEntity == null){
            throw new NotFoundEntityException("PasteBox not found with hash = " + hash);
        }

        return pasteBoxEntity;
    }

    @Override
    public List<PasteBoxEntity> getListOfPublicAndAlive(int amount) {
//        long nowTimeStamp = LocalDateTime.now()
//                .atZone(ZoneId.systemDefault())
//                .toInstant().getEpochSecond();

        LocalDateTime now = LocalDateTime.now();

        return vault.values().stream().filter(PasteBoxEntity::isPublic)
                .filter(pasteBoxEntity -> pasteBoxEntity.getLifeTime().isAfter(now))
                .sorted(Comparator.comparing(PasteBoxEntity::getId).reversed())
                .limit(amount).toList();
    }

    @Override
    public void add(PasteBoxEntity pasteBoxEntity) {
        vault.put(pasteBoxEntity.getHash(), pasteBoxEntity);
    }
}
