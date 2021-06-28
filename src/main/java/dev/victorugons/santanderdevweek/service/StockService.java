package dev.victorugons.santanderdevweek.service;

import dev.victorugons.santanderdevweek.exception.BusinessException;
import dev.victorugons.santanderdevweek.exception.NotFoundException;
import dev.victorugons.santanderdevweek.mapper.StockMapper;
import dev.victorugons.santanderdevweek.model.Stock;
import dev.victorugons.santanderdevweek.model.dto.StockDTO;
import dev.victorugons.santanderdevweek.repository.StockRepository;
import dev.victorugons.santanderdevweek.util.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository repository;

    @Autowired
    private StockMapper mapper;

    @Transactional
    public StockDTO save(StockDTO stockDTO) {
        Optional<Stock> optionalStock = repository.findByNameAndDate(stockDTO.getName(), stockDTO.getDate());
        if(optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(stockDTO);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO update(StockDTO stockDTO) {
        Optional<Stock> optionalStock = repository.findByStockUpdate(stockDTO.getName(), stockDTO.getDate(), stockDTO.getId());
        if(optionalStock.isPresent()) {
            throw new BusinessException(MessageUtils.STOCK_ALREADY_EXISTS);
        }
        Stock stock = mapper.toEntity(stockDTO);
        repository.save(stock);
        return mapper.toDTO(stock);
    }

    @Transactional
    public StockDTO delete(Long id) {
        StockDTO stockDTO = this.findById(id);
        repository.deleteById(stockDTO.getId());
        return stockDTO;
    }

    @Transactional(readOnly = true)
    public List<StockDTO> findAll() {
        List<Stock> list = repository.findAll();
        return mapper.toDTO(list);
    }

    @Transactional(readOnly = true)
    public StockDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(NotFoundException::new);
    }
}
