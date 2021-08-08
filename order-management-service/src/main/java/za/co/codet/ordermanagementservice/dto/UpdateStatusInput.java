package za.co.codet.ordermanagementservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.codet.ordermanagementservice.enums.OrderStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStatusInput {

    @JsonProperty(required = true)
    private Long id;
    @JsonProperty(required = true)
    private OrderStatus status;
}
