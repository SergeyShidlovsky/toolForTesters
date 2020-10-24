package com.sshidlovsky.toolforrunners.runner.entity.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateIssueRequest {
    private String title;
    private String body;
    private List<String> assignees;
    private Integer milestone;
    private String state;
    private List<String> labels;
}
