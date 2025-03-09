package br.com.pvt.valorant.tracker.core.model.agent;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore all unknown properties
public class AgentResponse {

    private String uuid;
    private String displayName;
    private String description;
    private String developerName;
    private String releaseDate;
    private List<String> characterTags;

    @JsonProperty("displayIcon")
    private String displayIconUrl;

    @JsonProperty("displayIconSmall")
    private String displayIconSmallUrl;

    private String bustPortrait;
    private String fullPortrait;
    private String fullPortraitV2;
    private String killfeedPortrait;
    private String background;
    private List<String> backgroundGradientColors;
    private String assetPath;

    @JsonProperty("isFullPortraitRightFacing")
    private boolean isFullPortraitRightFacing;

    @JsonProperty("isPlayableCharacter")
    private boolean isPlayableCharacter;

    @JsonProperty("isAvailableForTest")
    private boolean isAvailableForTest;

    @JsonProperty("isBaseContent")
    private boolean isBaseContent;

    private Role role;

    private List<Ability> abilities;
    private String voiceLine;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Role {
        private String uuid;
        private String displayName;
        private String description;
        private String displayIcon;
        private String assetPath;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Ability {
        private String slot;
        private String displayName;
        private String description;
        private String displayIcon;
    }
}
