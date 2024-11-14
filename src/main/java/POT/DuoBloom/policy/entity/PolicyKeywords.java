package POT.DuoBloom.policy.entity;

import POT.DuoBloom.hospital.entity.Keyword;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PolicyKeywords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long keywordId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Keyword keyword;

    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<PolicyKeywordsMapping> policyMappings;


}
