package za.co.codet.ordermanagementservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import za.co.codet.ordermanagementservice.dto.OrderDto;
import za.co.codet.ordermanagementservice.dto.OrderItemDto;
import za.co.codet.ordermanagementservice.dto.UpdateStatusInput;
import za.co.codet.ordermanagementservice.model.Order;
import za.co.codet.ordermanagementservice.model.OrderItem;

import java.math.BigDecimal;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order map(OrderDto orderDto);
    @Mapping(target = "totalCost", ignore = true)
    OrderDto map(Order order);

}
