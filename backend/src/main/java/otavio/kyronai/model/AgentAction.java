package otavio.kyronai.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "agent_actions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgentAction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "conversation_id")
    private UUID conversationId;

    @Column(name = "session_id")
    private UUID sessionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false, length = 50)
    private ActionType actionType;

    @Column(length = 1000)
    private String description;

    @Column(name = "file_path", length = 500)
    private String filePath;

    @Column(name = "proposed_content", columnDefinition = "TEXT")
    private String proposedContent;

    @Column(columnDefinition = "TEXT")
    private String parameters;

    @Column(columnDefinition = "TEXT")
    private String result;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50)
    private ActionStatus status;

    @Column(name = "execution_order")
    private Integer executionOrder;

    @Column(name = "resolved_at")
    private LocalDateTime resolvedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum ActionType {
        CREATE_FILE,
        EDIT_FILE,
        DELETE_FILE,
        RUN_COMMAND,
        EXPLAIN
    }

    public enum ActionStatus {
        PENDING,
        APPROVED,
        REJECTED,
        EXECUTED,
        FAILED
    }
}