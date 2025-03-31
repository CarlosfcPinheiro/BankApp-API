package me.dio.api_rest_springboot.domain.controller;

import me.dio.api_rest_springboot.domain.dto.pix.PixDTO;
import me.dio.api_rest_springboot.domain.dto.pix.PixResponseDTO;
import me.dio.api_rest_springboot.domain.service.PixService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/pix")
public class PixController {

    private final PixService pixService;

    public PixController(PixService pixService){
        this.pixService = pixService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PixResponseDTO>> findById(@PathVariable UUID userId){
        List<PixResponseDTO> pixList = pixService.findPixByUserId(userId);
        return ResponseEntity.ok(pixList);
    }

    @PostMapping
    public ResponseEntity<PixDTO> save(@RequestBody PixDTO pixDTO){
        PixDTO newPix = pixService.create(pixDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPix.getId())
                .toUri();
        return ResponseEntity.created(location).body(newPix);
    }
}
