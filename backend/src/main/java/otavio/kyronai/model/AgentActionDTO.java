package otavio.kyronai.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentActionDTO {

    private UUID id;
    private UUID conversationId;
    private UUID sessionId;
    private String actionType;
    private String description;
    private String filePath;
    private String proposedContent;
    private String parameters;
    private String result;
    private String status;
    private Integer executionOrder;
    private LocalDateTime resolvedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static AgentActionDTO fromEntity(AgentAction entity) {
        if (entity == null) return null;
        return AgentActionDTO.builder()
                .id(entity.getId())
                .conversationId(entity.getConversationId())
                .sessionId(entity.getSessionId())
                .actionType(entity.getActionType() != null
                        ? entity.getActionType().name() : null)
                .description(entity.getDescription())
                .filePath(entity.getFilePath())
                .proposedContent(entity.getProposedContent())
                .parameters(entity.getParameters())
                .result(entity.getResult())
                .status(entity.getStatus() != null
                        ? entity.getStatus().name() : null)
                .executionOrder(entity.getExecutionOrder())
                .resolvedAt(entity.getResolvedAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}