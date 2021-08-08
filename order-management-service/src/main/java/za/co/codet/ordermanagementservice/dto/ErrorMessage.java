package za.co.codet.ordermanagementservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ErrorMessage {
    private String message;
}
