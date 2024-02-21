package com.mspprarosaje.arosaje.api;

import com.mspprarosaje.arosaje.api.dto.message.MessageCreateDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageDTO;
import com.mspprarosaje.arosaje.api.dto.message.MessageUpdateDTO;
import com.mspprarosaje.arosaje.api.mappers.message.MessageCreateMapper;
import com.mspprarosaje.arosaje.api.mappers.message.MessageMapper;
import com.mspprarosaje.arosaje.api.mappers.message.MessageUpdateMapper;
import com.mspprarosaje.arosaje.model.Message;
import com.mspprarosaje.arosaje.services.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
@Slf4j
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper messageMapper;
    private final MessageCreateMapper messageCreateMapper;
    private final MessageUpdateMapper messageUpdateMapper;

    @GetMapping
    public ResponseEntity<List<MessageDTO>> getMessages(){
        return ResponseEntity.ok(messageMapper.toDtos(messageService.getMessages()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageDTO> getMessageById(@PathVariable("id") int id){
        return ResponseEntity.of(this.messageService.getMessageById(id).map(this.messageMapper::toDto));
    }

    @PostMapping()
    public ResponseEntity<MessageCreateDTO> saveMessage(@RequestBody MessageCreateDTO messageCreateDTO){
        Message createdMessage = messageService.saveMessage(
                this.messageCreateMapper.fromDto(messageCreateDTO),
                messageCreateDTO.getSender().getId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(this.messageCreateMapper.toDto(createdMessage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageUpdateDTO> updateAddress(@PathVariable("id") Integer id,
                                                          @RequestBody MessageUpdateDTO messageUpdateDTO){
        if (!id.equals((messageUpdateDTO.getId()))){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(!this.messageService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        Message updateMessage = messageService.saveMessage(
                this.messageUpdateMapper.fromDto(messageUpdateDTO),
                messageUpdateDTO.getSender().getId()
        );
        return ResponseEntity.ok(this.messageUpdateMapper.toDto((updateMessage)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable() Integer id){
        if(!this.messageService.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        this.messageService.deleteById(id);
        if(this.messageService.existsById(id)){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}