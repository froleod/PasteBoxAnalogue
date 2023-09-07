package com.leonidfrolov.spring.pastebox;

import com.leonidfrolov.spring.pastebox.api.response.PasteBoxResponse;
import com.leonidfrolov.spring.pastebox.entity.PasteBoxEntity;
import com.leonidfrolov.spring.pastebox.exception.NotFoundEntityException;
import com.leonidfrolov.spring.pastebox.repository.PasteBoxRepository;
import com.leonidfrolov.spring.pastebox.service.PasteBox;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PasteBoxServiceTest {
    @Autowired
    private PasteBox pasteBox;

    @MockBean
    private PasteBoxRepository pasteBoxRepository;

    @Test
    public void notExistHash(){
        when(pasteBoxRepository.getByHash(anyString())).thenThrow(NotFoundEntityException.class);
        assertThrows(NotFoundEntityException.class, () -> pasteBox.getByHash("alkjsdf"));
    }

    @Test
    public void getExistHash(){
        PasteBoxEntity entity = new PasteBoxEntity();
        entity.setHash("1");
        entity.setData("11");
        entity.setPublic(true);

        when(pasteBoxRepository.getByHash("1")).thenReturn(entity);

        PasteBoxResponse expected = new PasteBoxResponse("11", true);
        PasteBoxResponse actual = pasteBox.getByHash("1");

        assertEquals(expected, actual);
    }

}
