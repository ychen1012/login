package com.imtoocai.diary.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangeInfo {

    private String userId;
    private String oldPassword;
    private String newPassword;
}
