package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode(exclude = "id")
public class ProjectBuilder {
    private int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private int projectType;
    private boolean isEnableTCApprovals;
    private String projectAdminName;
}
