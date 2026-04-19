package otavio.kyronai.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GitHubRepositoryDTO {

    private UUID id;
    private String fullName;
    private String owner;
    private String repoName;
    private String description;
    private String url;
    private String branch;
    private Boolean isPublic;
    private Boolean isPrivate;
    private GitHubRepository.IndexStatus indexStatus;
    private Integer indexedFilesCount;
    private LocalDateTime lastIndexedAt;
    private UUID projectId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static GitHubRepositoryDTO fromEntity(GitHubRepository entity) {
        if (entity == null) return null;
        return GitHubRepositoryDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .owner(entity.getOwner())
                .repoName(entity.getRepoName())
                .description(entity.getDescription())
                .url(entity.getUrl())
                .branch(entity.getBranch())
                .isPublic(entity.getIsPublic())
                .isPrivate(entity.getIsPrivate())
                .indexStatus(entity.getIndexStatus())
                .indexedFilesCount(entity.getIndexedFilesCount())
                .lastIndexedAt(entity.getLastIndexedAt())
                .projectId(entity.getProject() != null
                        ? entity.getProject().getId() : null)
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}