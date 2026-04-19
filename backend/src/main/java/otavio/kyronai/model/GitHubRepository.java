package otavio.kyronai.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "github_repositories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitHubRepository {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    /** "owner/repo" — identificador único do repositório */
    @Column(name = "full_name", nullable = false, length = 300)
    private String fullName;

    @Column(nullable = false, length = 150)
    private String owner;

    @Column(name = "repo_name", nullable = false, length = 150)
    private String repoName;

    @Column(length = 500)
    private String description;

    @Column(length = 1000)
    private String url;

    @Column(length = 50)
    private String branch;

    /** Token de acesso para repositórios privados */
    @Column(name = "access_token", length = 500)
    private String accessToken;

    @Column(name = "is_private")
    private Boolean isPrivate;

    // Mantém compatibilidade com código que usa isPublic
    @Column(name = "is_public")
    private Boolean isPublic;

    @Enumerated(EnumType.STRING)
    @Column(name = "index_status")
    private IndexStatus indexStatus;

    @Column(name = "indexed_files_count")
    private Integer indexedFilesCount;

    @Column(name = "last_indexed_at")
    private LocalDateTime lastIndexedAt;

    /** Conteúdo indexado do repositório para injeção no prompt */
    @Column(name = "context_index", columnDefinition = "TEXT")
    private String contextIndex;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public enum IndexStatus {
        PENDING,
        INDEXING,
        READY,
        ERROR
    }
}