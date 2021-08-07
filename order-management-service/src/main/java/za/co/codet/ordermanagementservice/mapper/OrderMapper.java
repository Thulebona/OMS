package za.co.codet.ordermanagementservice.mapper;

import org.mapstruct.Mapper;
import za.co.codet.ordermanagementservice.dto.OrderDto;
import za.co.codet.ordermanagementservice.model.Order;

@Mapper
public interface OrderMapper {

    Order map(OrderDto dto);
    OrderDto map(Order dto);
}
