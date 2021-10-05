package shop.cofin.api.cloud.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.cloud.board.repository.BoardRepository;

@RequiredArgsConstructor
@RestController
public class BoardController {
    private final BoardRepository boardRepository;



}
