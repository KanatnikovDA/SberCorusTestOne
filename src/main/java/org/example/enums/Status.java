package org.example.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Status {
    OPEN("Открыт"),
    BLOCKED("Заблокирован"),
    CLOSED("Закрыт");

    private String title;
}