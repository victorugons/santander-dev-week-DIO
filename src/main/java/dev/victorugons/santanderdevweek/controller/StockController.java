package dev.victorugons.santanderdevweek.controller;

import dev.victorugons.santanderdevweek.model.dto.StockDTO;
import dev.victorugons.santanderdevweek.service.StockService;
import dev.victorugons.santanderdevweek.util.MessageUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @Operation(summary = "Creates a new stock.",
            description = "Creates a new stock.",
            tags = {"stocks"},
            operationId = "save")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Stock successfully created.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = StockDTO.class
                                    )
                            )),
                    @ApiResponse(
                            responseCode = "422",
                            description = "This stock already exists."
                    )
            })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.save(stockDTO));
    }

    @Operation(summary = "Updates an existing stock.",
            description = "Updates an existing stock.",
            tags = {"stocks"},
            operationId = "update")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Stock successfully updated.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = StockDTO.class
                                    )
                            )),
                    @ApiResponse(
                            responseCode = "422",
                            description = "This update violates a business rule."
                    )
            })
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO stockDTO) {
        return ResponseEntity.ok(stockService.update(stockDTO));
    }

    @Operation(summary = "Returns a list of current stocks.",
            description = "Returns a list of current stocks.",
            tags = {"stocks"},
            operationId = "findAll")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returned a list of current stocks.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = StockDTO.class
                                            )
                                    )
                            ))
            })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(stockService.findAll());
    }

    @Operation(summary = "Returns an existing room with the specified id.",
            description = "Returns an existing room with the specified id.",
            tags = {"stocks"},
            operationId = "findById")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned the stock with the specified id.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = StockDTO.class
                                    )
                            )),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Stock with specified id not found."
                    )
            })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.findById(id));
    }

    @Operation(summary = "Returns a list of stocks updated today.",
            description = "Returns a list of stocks updated today.",
            tags = {"stocks"},
            operationId = "findByToday")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Successfully returned a list of stocks updated today.",
                            content = @Content(
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = StockDTO.class
                                            )
                                    )
                            ))
            })
    @GetMapping(value = "/today", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findByToday() {
        return ResponseEntity.ok(stockService.findByToday());
    }

    @Operation(summary = "Deletes an existing stock.",
            description = "Deletes an existing stock.",
            tags = {"stocks"},
            operationId = "delete")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Stock successfully deleted.",
                            content = @Content(
                                    schema = @Schema(
                                            implementation = StockDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Stock with specified id not found."
                            )
            })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete (@PathVariable Long id) {
        return ResponseEntity.ok(stockService.delete(id));
    }
}
