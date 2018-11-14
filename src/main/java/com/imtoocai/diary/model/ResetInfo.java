package com.imtoocai.diary.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetInfo {
    private String email;
    private String code;
    private String password;
}
