package com.latitude.genoapay.codingchallenge.controller;

import com.latitude.genoapay.codingchallenge.dto.InputStockPrices;
import com.latitude.genoapay.codingchallenge.dto.OutputMaxStockProfit;
import com.latitude.genoapay.codingchallenge.service.MaxProfitCalculator;
import com.latitude.genoapay.codingchallenge.swagger.api.MaxprofitApi;
import com.latitude.genoapay.codingchallenge.swagger.model.MaxProfit;
import com.latitude.genoapay.codingchallenge.swagger.model.StockPrices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController implements MaxprofitApi {

	private ModelMapper modelMapper;

	@Autowired
	public StockController(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public ResponseEntity<MaxProfit> getMaxProfit(final StockPrices stockPrices){
		InputStockPrices inputStockPrices = convertToDTO(stockPrices);
		System.out.println("inputStockPrices ::: "+ inputStockPrices);
		OutputMaxStockProfit maxStockProfit = MaxProfitCalculator.getMaxProfit(inputStockPrices);
		return new ResponseEntity(convertToModel(maxStockProfit), HttpStatus.OK);
	}

	private InputStockPrices convertToDTO(StockPrices stockPrices) {
		return modelMapper.map(stockPrices,InputStockPrices.class);
	}

	private MaxProfit convertToModel(final OutputMaxStockProfit outputMaxStockProfit) {
		return modelMapper.map(outputMaxStockProfit, MaxProfit.class);
	}

}