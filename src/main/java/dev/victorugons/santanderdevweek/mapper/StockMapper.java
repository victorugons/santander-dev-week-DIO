package dev.victorugons.santanderdevweek.mapper;

import dev.victorugons.santanderdevweek.model.Stock;
import dev.victorugons.santanderdevweek.model.dto.StockDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock toEntity(StockDTO stockDTO) {
        Stock stock = new Stock();
        if(stockDTO.getId() != null) {
            stock.setId(stockDTO.getId());
        }
        stock.setName(stockDTO.getName());
        stock.setPrice(stockDTO.getPrice());
        stock.setVariation(stockDTO.getVariation());
        stock.setDate(stockDTO.getDate());
        return stock;
    }

    public StockDTO toDTO(Stock stock) {
        StockDTO stockDTO = new StockDTO();
        stockDTO.setId(stock.getId());
        stockDTO.setName(stock.getName());
        stockDTO.setPrice(stock.getPrice());
        stockDTO.setVariation(stock.getVariation());
        stockDTO.setDate(stock.getDate());
        return stockDTO;
    }

    public List<StockDTO> toDTO(List<Stock> list) {
        return list.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
