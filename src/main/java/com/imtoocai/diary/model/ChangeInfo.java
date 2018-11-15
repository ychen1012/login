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

    private Integer userId;
    private Integer oldPassword;
    private Integer newPassword;
}
