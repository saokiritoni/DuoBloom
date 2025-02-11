package POT.DuoBloom.domain.community.dto.response;

import POT.DuoBloom.domain.community.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommunityListResponseDto {
    private Long communityId;
    private String content;
    private Type type;
    private String nickname;
    private String profilePictureUrl;
    private boolean isOwner;
    private boolean likedByUser;
    private boolean scraped;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<String> imageUrls;
    private long likeCount;
    private long commentCount;
    private List<TagResponseDto> tags;
}
